options(digits=20)

a <- 10
m <- 100
I <- numeric(m) 

I[m] <- 0;

for (n in m:2) {
  I[n-1] <- 1/a*(1/n-I[n]);
  
}

I0 <- 1/a*(1-I[1])

I0
I

