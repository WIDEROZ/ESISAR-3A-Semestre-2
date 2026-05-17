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

# Etat d'équilibre
phi_eq <- sqrt(2 * m * g * L0)
q_eq   <- 0.10
V_eq   <- R * phi_eq / L(q_eq)

# Condition initiale (perturbation autour de l'équilibre)
X0 <- c(q_eq * 1.20, 0.0, phi_eq * 0.90)

# Tension de commande (boucle ouverte constante)
V <- V_eq

# Champ de vecteurs f(V, X) avec X = (q, p, phi)
# Forme hamiltonienne à port : ẋ = (J-R)·∇H + g·V
f <- function(V, X) {
  q   <- X[1]
  p   <- X[2]
  phi <- X[3]

  dH_dq   <- m*g - phi^2 * dL(q) / (2*L(q)^2)
  dH_dp   <- p / m
  dH_dphi <- phi / L(q)

  dq   <-  dH_dp           # ligne 1 de J  : (0, 1, 0)·∇H
  dp   <- -dH_dq           # ligne 2 de J  : (-1, 0, 0)·∇H
  dphi <- -R * dH_dphi + V # ligne 3 de (J-R) + g·V

  return(c(dq, dp, dphi))
}

# Euler explicite
h <- 1e-4
N <- round(0.4 / h)
X <- matrix(0, nrow = N, ncol = 3)
X[1, ] <- X0
for (i in 2:N) {
  X[i, ] <- X[i-1, ] + h * f(V, X[i-1, ])
  if (X[i, 1] <= 0) {
    cat(sprintf("Bille tombée à t = %.4f s\n", i * h))
    N <- i
    X <- X[1:N, ]
    break
  }
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
plot(time, E_grav, type = "l", col = "red", lwd = 2,
     xlab = "Temps (s)", ylab = "Énergie (J)",
     main = "Énergie potentielle gravitationnelle (mgq)")
plot(time, E_tot, type = "l", col = "purple", lwd = 2,
     xlab = "Temps (s)", ylab = "Énergie (J)",
     main = "Hamiltonien total H(q, p, phi)")
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
     main = "Variation du Hamiltonien")
par(mfrow = c(1, 1))

# Bilan de puissance
plot(time, bilan, type = "l", col = "black", lwd = 2,
     xlab = "Temps (s)", ylab = "Bilan de puissance (W)",
     main = "Bilan de puissance : dH/dt - (P_elec - P_diss)")
abline(h = 0, col = "red", lty = 2)