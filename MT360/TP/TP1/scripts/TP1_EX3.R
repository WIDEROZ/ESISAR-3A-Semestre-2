# ii
s = 1231
N = 1000

for(k in 1:N){
  s = cos(s)
}


v=sin(s)


v
s


# iii
  
for(k in 1:10){
  s = s - (s-cos(s))/(1+sin(s));
}


deriv2 = cos(s)/(1+sin(s));


v=deriv2/2;


v
s

# iv

N = 100
s = numeric(N);
s[1] = 1;
for(k in 2:N){
  s[k] = 10*cos(s[k-1])
  
}

s

# v
N<-20
x <- numeric(N)

#f <- function(x) cos(x)
f <- function(x) 10*cos(x)

x[1] <- 1
x[2] <- f(x[1])

for (n in 1:(N-2)) {
  x[n+2] <- f(x[n+1])
  

  aitken <- x[n] - (x[n+1] - x[n])^2 / (x[n+2] - 2*x[n+1] + x[n])
  cat("n =", n, "Delta2 Aitken =", aitken, "\n")

}

# vi
N <- 20
x <- 1

#f <- function(x) cos(x)
f <- function(x) 10*cos(x)

for (n in 1:N) {
    x <- x - (f(x) - x)^2 / (f(f(x)) - 2*f(x) + x)
    cat("n =", n, "Aitken-Steffensen =", x, "\n")
}

