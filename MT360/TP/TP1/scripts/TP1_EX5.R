options(digits = 17)

a=5
k=3
N=30

f <- function(x) x-(x^k-a)/(k*x^(k-1))

s<-5^(1/k)
x<-1

for(n in 1:N){
  x <- f(x)
  err=x-s
  rho=err/s
  c=1-log10(abs(rho))
  cat("\nn = ", n, "\nChiffres sign : ", c, "\nx=", x, " s=", s)
}


x<-1
x_nm1<-1

for(n in 1:N){
  tmp <- x
  x <- x-(x^k-a)/(x^(k-1)+x_nm1^(k-1))
  x_nm1 <- tmp
  
  err=x-s
  rho=err/s
  c=1-log10(abs(rho))
  cat("\nn = ", n, "\nChiffres sign : ", c, "\nx =", x, " s =", s)
}



