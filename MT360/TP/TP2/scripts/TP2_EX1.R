y0 = 1
h = 0.01
N=5/h

f <- function (x, y) {
  2*x*y-x*y^2
}

x <- numeric(N + 1)
y <- numeric(N + 1)

x[1] <- 0
y[1] <- y0

for(i in 1:N){
  x[i + 1] <- x[i] + h
  y[i + 1] <- y[i] + h * f(x[i], y[i])
}


y_exacte <- 2*y[1] / (y[1] + (2 - y[1]) * exp(-x^2))

plot(x, y,
     type = "l",
     col = "blue",
     lwd = 2,
     xlab = "x",
     ylab = "y",
     main = "Euler vs solution exacte")

lines(x, y_exacte,
      col = "red",
      lwd = 2)

legend("bottomright",
       legend = c("Euler", "Solution exacte"),
       col = c("blue", "red"),
       lwd = 2,
       lty = c(1, 1))

# ii
N<-100
y0<-1

H <- 10^seq(-6, -1, length.out = N)

x <- numeric(N)
y <- numeric(N) # y[i] contient l'approximation pour le pas H[i]
err <- numeric(N)

f <- function (x, y) {
  2*x*y-x*y^2
}

y_exacte <- function(x){
  2*y0 / (y0 + (2 - y0) * exp(-x^2))
}


for(i in 1:N){
    x[i] = 0
    y[i] = y0
    err[i] <- abs(y_exacte(x[i])-y[i])
    for(j in 1:N){
      # Réalisation de Euler explicite
      tmp <- x[i]
      x[i] <- x[i] + H[i]
      y[i] <- y[i] + H[i] * f(tmp, y[i])
      
      # Recherche de l'erreur maximale pour h fixé : 
      if(err[i] <= abs(y_exacte(x[i])-y[i])){
        err[i] <- abs(y_exacte(x[i])-y[i])
      }
    }
}



plot(log10(H), log10(err),
     type = "l",
     col = "red",
     lwd = 2,
     xlab = "log10(h)",
     ylab = "log10(err)",
     main = "Erreur Globale")


#iii
# Point milieu:


y0<-2
h<-0.01
N<-4/h

f <- function (x, y) {
  2*x*y-x*y^2
}

x <- numeric(N)
y <- numeric(N)

x[1] <- 0
y[1] <- y0

for(i in 1:N){
  x[i + 1] <- x[i] + h
  y[i + 1] <- y[i] + h * f(x[i]+h/2, y[i] + h/2*f(x[i], y[i]))
}

y_exacte <- function(x){
  2*y0 / (y0 + (2 - y0) * exp(-x^2))
}

plot(x, y,
     type = "l",
     col = "blue",
     lwd = 2,
     xlab = "x",
     ylab = "y",
     main = "Point milieu vs solution exacte")

lines(x, y_exacte(x),
      col = "red",
      lwd = 2)

legend("bottomright",
       legend = c("Point milieu", "Solution exacte"),
       col = c("blue", "red"),
       lwd = 2,
       lty = c(1, 1))

# Erreur point milieu
N<-1000
y0<-1

H <- 10^seq(-6, -1, length.out = N)

x <- numeric(N)
y <- numeric(N) # y[i] contient l'approximation pour le pas H[i]
err <- numeric(N)

f <- function (x, y) {
  2*x*y-x*y^2
}

y_exacte <- function(x){
  2*y0 / (y0 + (2 - y0) * exp(-x^2))
}


for(i in 1:N){
  x[i] = 0
  y[i] = y0
  err[i] <- abs(y_exacte(x[i])-y[i])
  for(j in 1:N){
    # Réalisation de Point milieu
    tmp <- x[i]
    x[i] <- x[i] + H[i]
    y[i] <- y[i] + H[i] * f(tmp+H[i]/2, y[i] + H[i]/2*f(tmp, y[i]))
    
    # Recherche de l'erreur maximale pour h fixé : 
    if(err[i] <= abs(y_exacte(x[i])-y[i])){
      err[i] <- abs(y_exacte(x[i])-y[i])
    }
  }
}


plot(log10(H), log10(err),
     type = "l",
     col = "red",
     lwd = 2,
     xlab = "log10(h)",
     ylab = "log10(err)",
     main = "Erreur Globale")


# RK d'ordre 4
y0<-1
h<-0.01
N<-4/h

f <- function (x, y) {
  2*x*y-x*y^2
}


x <- numeric(N)
y <- numeric(N)

x[1] <- 0
y[1] <- y0


RK4<-matrix(c(0, 1/3, -1/3, 1, 0, 0, 1, -1, 0, 0, 0, 1, 0, 0, 0, 0), 4, 4)

c2<-sum(RK4[2,])
c3<-sum(RK4[3,])
c4<-sum(RK4[4,])

R1<-1/8
R2<-3/8
R3<-3/8
R4<-1/8



for(i in 1:N){
  k1 <- f(x[i], y[i])
  k2 <- f(x[i]+c2*h, y[i] + RK4[2, 1]*k1*h)
  k3 <- f(x[i]+c3*h, y[i] + (RK4[3, 1]*k1 + RK4[3, 2]*k2)*h)
  k4 <- f(x[i]+c4*h, y[i] + (RK4[4, 1]*k1 + RK4[4, 2]*k2 + RK4[4, 3]*k3)*h)
  
  x[i + 1] <- x[i] + h
  y[i + 1] <- y[i] + h *(R1*k1+R2*k2+R3*k3+R4*k4)
}



y_exacte <- function(x){
  2*y0 / (y0 + (2 - y0) * exp(-x^2))
}

plot(x, y,
     type = "l",
     col = "blue",
     lwd = 2,
     xlab = "x",
     ylab = "y",
     main = "RK4 vs solution exacte")

lines(x, y_exacte(x),
      col = "red",
      lwd = 2)

legend("bottomright",
       legend = c("RK4", "Solution exacte"),
       col = c("blue", "red"),
       lwd = 2,
       lty = c(1, 1))


#Erreur RK4
N<-1000
y0<-1

H <- 10^seq(-6, -1, length.out = N)

x <- numeric(N)
y <- numeric(N) # y[i] contient l'approximation pour le pas H[i]
err <- numeric(N)

f <- function (x, y) {
  2*x*y-x*y^2
}

y_exacte <- function(x){
  2*y0 / (y0 + (2 - y0) * exp(-x^2))
}

RK4<-matrix(c(0, 1/3, -1/3, 1, 0, 0, 1, -1, 0, 0, 0, 1, 0, 0, 0, 0), 4, 4)

c2<-sum(RK4[2,])
c3<-sum(RK4[3,])
c4<-sum(RK4[4,])

R1<-1/8
R2<-3/8
R3<-3/8
R4<-1/8

for(i in 1:N){
  x[i] = 0
  y[i] = y0
  err[i] <- abs(y_exacte(x[i])-y[i])
  for(j in 1:N){
    # Réalisation de RK4
    k1 <- f(x[i], y[i])
    k2 <- f(x[i]+c2*H[i], y[i] + RK4[2, 1]*k1*H[i])
    k3 <- f(x[i]+c3*H[i], y[i] + (RK4[3, 1]*k1 + RK4[3, 2]*k2)*H[i])
    k4 <- f(x[i]+c4*H[i], y[i] + (RK4[4, 1]*k1 + RK4[4, 2]*k2 + RK4[4, 3]*k3)*H[i])
    
    x[i] <- x[i] + H[i]
    y[i] <- y[i] + H[i] *(R1*k1+R2*k2+R3*k3+R4*k4)
    
    # Recherche de l'erreur maximale pour h fixé : 
    if(err[i] <= abs(y_exacte(x[i])-y[i])){
      err[i] <- abs(y_exacte(x[i])-y[i])
    }
  }
}


plot(log10(H), log10(err),
     type = "l",
     col = "red",
     lwd = 2,
     xlab = "log10(h)",
     ylab = "log10(err)",
     main = "Erreur Globale")