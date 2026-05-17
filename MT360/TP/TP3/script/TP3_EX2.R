# Paramètres
m    <- 0.05
g    <- 9.81
R    <- 1.0
L0   <- 0.10
Linf <- 0.0

# Inductance et sa dérivée
L    <- function(q)  (L0 + q * Linf) / (1 + q)
dL   <- function(q)  (Linf - L0) / (1 + q)^2

# Hamiltonien
H <- function(q, p, phi)  m*g*q + p^2/(2*m) + phi^2/(2*L(q))


f <- function(V, X) {
  q   <- X[1]
  p   <- X[2]
  phi <- X[3]
  
  J<-matrix(c(
    0, 1, 0,
    -1, 0, 0,
    0, 0, 0
  ), nrow=3, ncol=3, byrow=TRUE)
  
  R_mat<-matrix(c(
    0, 0, 0,
    0, 0, 0,
    0, 0, R
  ), nrow=3, ncol=3, byrow=TRUE)
  
  grad <- c(
    m*g-phi^2*(Linf-L0)/(2*(L0+q*Linf)^2), 
    p/m,
    phi*(1+q)/(L0+q*Linf)
  )
  
  g_mat <- c(
    0,
    0,
    1
  )
  
  
  return((J-R_mat)%*%grad + g_mat * V)
}

# Etat d'équilibre
phi_eq <- sqrt(2 * m * g * L0)
q_eq   <- 10
V_eq   <- R * phi_eq / L(q_eq)

# Condition initiale (perturbation autour de l'équilibre)
X0 <- c(q_eq, 0, phi_eq)


# Euler explicite
h <- 0.001
T<-1
N <- round(T/h)
X <- matrix(0, nrow = N, ncol = 3)
X[1, ] <- X0
V<-V_eq

for (i in 2:N) {
  X[i, ] <- X[i-1, ] + h * f(V, X[i-1, ])
}


time <- seq(0, (N-1) * h, by = h)

# Affichage 2D
matplot(time, X, type = "l", lty = 1, col = c("red", "blue", "green"),
        xlab = "Temps (s)", ylab = "Valeur",
        main = "Évolution des variables d'état (q, p, phi)")
legend("topright", legend = c("q(t)", "p(t)", "phi(t)"),
       col = c("red", "blue", "green"), lty = 1)

if (!require("scatterplot3d")) install.packages("scatterplot3d")
library(scatterplot3d)

# Trajectoire 3D dans l'espace d'état
scatterplot3d(
  X[, 1], X[, 2], X[, 3],
  type  = "l",
  color = "blue",
  lwd   = 2,
  xlab  = "q(t)",
  ylab  = "p(t)",
  zlab  = "phi(t)",
  main  = "Trajectoire dans l'espace d'état (q, p, phi)"
)

# Energies
I_vec  <- X[, 3] / L(X[, 1])          # courant I = phi / L(q)
E_mec  <- (X[, 2]^2) / (2 * m)        # énergie cinétique
E_grav <- m * g * X[, 1]              # énergie potentielle gravitationnelle
E_mag  <- X[, 3]^2 / (2 * L(X[, 1])) # énergie magnétique stockée
E_pot <- E_grav+E_mag
E_tot  <- mapply(H, X[, 1], X[, 2], X[, 3])  # Hamiltonien total

P_elec <- V * I_vec                    # puissance fournie par la source
P_diss <- R * I_vec^2                  # puissance dissipée dans R

# Variation de l'énergie totale
dE_tot_dt <- c(NA, diff(E_tot) / h)

# Bilan de puissance : dH/dt = P_elec - P_diss
bilan <- dE_tot_dt - (P_elec - P_diss)

# Tracé des énergies
par(mfrow = c(3, 1))
plot(time, E_mec, type = "l", col = "blue", lwd = 2,
     xlab = "Temps (s)", ylab = "Énergie (J)",
     main = "Énergie cinétique (p²/2m)")
plot(time, E_pot, type = "l", col = "red", lwd = 2,
     xlab = "Temps (s)", ylab = "Énergie (J)",
     main = "Énergie potentielle")
plot(time, E_tot, type = "l", col = "purple", lwd = 2,
     xlab = "Temps (s)", ylab = "Énergie (J)",
     main = "Energie mécanique (H(q, p, phi))")
par(mfrow = c(1, 1))

# Tracé des puissances
par(mfrow = c(3, 1))
plot(time, P_elec, type = "l", col = "green", lwd = 2,
     xlab = "Temps (s)", ylab = "Puissance (W)",
     main = "Puissance fournie par V(t)")
plot(time, P_diss, type = "l", col = "orange", lwd = 2,
     xlab = "Temps (s)", ylab = "Puissance dissipée (W)",
     main = "Puissance dissipée dans R")
plot(time, dE_tot_dt, type = "l", col = "brown", lwd = 2,
     xlab = "Temps (s)", ylab = "dH/dt (W)",
     main = "Variation de l'énergie mécanique (Hamiltonien)")
par(mfrow = c(1, 1))

# Bilan de puissance
plot(time, bilan, type = "l", col = "black", lwd = 2,
     xlab = "Temps (s)", ylab = "Bilan de puissance (W)",
     main = "Bilan de puissance : dH/dt - (P_elec - P_diss)")
abline(h = 0, col = "red", lty = 2)