T<-10
h<-0.1
N<-T/h

a<-1
b<-1
d<-1
g<-2
xi0<-2

x0<-xi0
y0<-xi0


fx <- function(x, y) {
  a*x - b*x*y
}

fy <- function(x, y) {
  d*x*y - g*y
}


# Euler explicite
euler_explicite <- function(x0, y0, N, h) {
  x <- numeric(N + 1)
  y <- numeric(N + 1)
  x[1] <- x0
  y[1] <- y0
  
  for (n in 1:N) {
    x[n + 1] <- x[n] + h * fx(x[n], y[n])
    y[n + 1] <- y[n] + h * fy(x[n], y[n])
  }
  
  return(data.frame(x = x, y = y))
}

# Euler Implicite
euler_implicite <- function(x0, y0, N, h) {
  x <- numeric(N + 1)
  y <- numeric(N + 1)
  x[1] <- x0
  y[1] <- y0
  
  for (n in 1:N) {
    x[n + 1] <- x[n] / (1 - h * (a - b * y[n]))
    y[n + 1] <- y[n] / (1 - h * (d * x[n + 1] - g))
  }
  
  return(data.frame(x = x, y = y))
}

# Méthode du point milieu explicite

point_milieu_explicite <- function(x0, y0, N, h) {
  x <- numeric(N + 1)
  y <- numeric(N + 1)
  x[1] <- x0
  y[1] <- y0
  
  for (n in 1:N) {
    x_mid <- x[n] + (h / 2) * fx(x[n], y[n])
    y_mid <- y[n] + (h / 2) * fy(x[n], y[n])
    
    x[n + 1] <- x[n] + h * fx(x_mid, y_mid)
    y[n + 1] <- y[n] + h * fy(x_mid, y_mid)
  }
  
  return(data.frame(x = x, y = y))
}


# Méthode du point milieu implicite
point_milieu_implicite <- function(x0, y0, N, h) {
  x <- numeric(N + 1)
  y <- numeric(N + 1)
  x[1] <- x0
  y[1] <- y0
  
  for (n in 1:N) {
    x[n + 1] <- ((2 + h) / (2 - h * (a - b * y[n]))) * x[n]
    y[n + 1] <- ((2 + h) / (2 - h * (d *  x[n] - g))) * y[n]
  }
  
  return(data.frame(x = x, y = y))
}

# Méthode d'Euler symplectique
euler_symplectique <- function(x0, y0, N, h) {
  x <- numeric(N + 1)
  y <- numeric(N + 1)
  x[1] <- x0
  y[1] <- y0
  
  for (n in 1:N) {
    y[n + 1] <- y[n] / (1 - h * (d * x[n] - g))
    x[n + 1] <- x[n] + h * fx(x[n], y[n+1])
  }
  
  return(data.frame(x = x, y = y))
}


resultat <- euler_symplectique(x0, y0, N, h)


plot(resultat$x, resultat$y,
     type = "l",
     col = "blue",
     xlab = "x(t)",
     ylab = "y(t)",
     main = "Trajectoire",
     lwd = 2)


points(x0, y0, col = "red", pch = 19, cex = 1.5)
legend("topright",
       legend = c("Trajectoire", "Point initial (x0, y0)"),
       col = c("blue", "red"),
       lty = c(1, NA),
       pch = c(NA, 19),
       lwd = 2)
