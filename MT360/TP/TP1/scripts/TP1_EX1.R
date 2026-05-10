options(digits=20);

N = 100;

y = 2;
for (k in 1:N){
  #para = 1-sqrt(1-(2^(-k)*y)^2);
  para = (2^(-k)*y)^2/(1+sqrt(1-(2^(-k)*y)^2));
  y = 2^k*sqrt(2*para);
}

y

