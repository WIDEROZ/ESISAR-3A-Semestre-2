N<-10
X <- c(1, 1)
#X <- c(-3, 0)


for(n in 1:N){
  F <- c(X[1]-1/2*(X[2]^2-X[1]^2), X[2]-1+X[1]^2 * X[2])
  
  JF <- matrix(c(1+X[1], -X[2], 2*X[1]*X[2], 1+X[1]^2), 2, 2, byrow=TRUE)
  JF_inv <- solve(JF)
  X <- X - JF_inv %*% F
  
  
  
  cat("n =", n, "\n Newton = \n", X[1], "\n", X[2], "\n")
}

S <- X
X <- c(1, 1)
#X <- c(-3, 0)

err <- vector("list", N)

norme <- function(err) sqrt(err[1]^2 + err[2]^2);


for(n in 1:N){
  err[[n]] <- X-S

  F <- c(X[1]-1/2*(X[2]^2-X[1]^2), X[2]-1+X[1]^2 * X[2])
  
  JF <- matrix(c(1+X[1], -X[2], 2*X[1]*X[2], 1+X[1]^2), 2, 2, byrow=TRUE)
  JF_inv <- solve(JF)
  X <- X - JF_inv %*% F
  
  err[[n+1]] <- X-S
  
  
  if(n>=2){
    p <- log(norme(err[[n+1]])/norme(err[[n]]))/log(norme(err[[n]])/norme(err[[n-1]]))
    cat("n =", n, "\n Ordre = \n", p, "\n")
  }
}