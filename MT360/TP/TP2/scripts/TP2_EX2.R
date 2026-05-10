lambda <- -0.5
y0<-1

h<-5
N<- 100/h

f <- function(x, y){
  lambda*y
}
x <- numeric(N+1)
y <- numeric(N+1)

x[1]<-0
y[1]<-y0

for (i in 1:N) {
  x[i+1] <- x[i] + h
  y[i+1]<- y[i] + h*f(x[i], y[i])
}

y_exacte <- function(x){
  exp(x*lambda)
}

plot(x, y,
     type = "l",
     col = "blue",
     lwd = 2,
     xlab = "x",
     ylab = "y",
     main = "Euler vs solution exacte")

lines(x, y_exacte(x),
      col = "red",
      lwd = 2)

legend("topright",
       legend = c("Euler", "Solution exacte"),
       col = c("blue", "red"),
       lwd = 2,
       lty = c(1, 1))

# iii

lambda <- -0.5
h <- 5
N <- 100/h
y0 <- 1

x <- numeric(N + 1)
y <- numeric(N + 1)

x[1] <- 0
y[1] <- y0

for(i in 1:N){
  x[i + 1] <- x[i] + h
  y[i + 1] <- (2+lambda*h)/(2-lambda*h)* y[i]
}

y_exacte <- function(x){
  exp(x*lambda)
}

plot(x, y,
     type = "l",
     col = "blue",
     lwd = 2,
     xlab = "x",
     ylab = "y",
     main = "Trapèzes vs solution exacte")

lines(x, y_exacte(x),
      col = "red",
      lwd = 2)

legend("topright",
       legend = c("Trapèze", "Solution exacte"),
       col = c("blue", "red"),
       lwd = 2,
       lty = c(1, 1))
