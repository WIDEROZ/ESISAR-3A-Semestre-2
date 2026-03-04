# Exercice 1
#### 1.
L’approximation fonctionne pour $20$ itérations mais pour $100$ itérations on obtiens finalement $0$. 

L'erreur provient principalement de la soustraction de $1$ et $\sqrt{1-(2^{-k}y_{k})^{2}}$ car les deux nombres sont très proches $(\sqrt{1-(2^{-k}y_{k})^{2}} \approx 1)$
Car l'erreur de la soustraction est : 
$$\boxed{\rho(a-b) = \frac{a}{a-b}\rho (a) - \frac{b}{a-b}\rho(b)}$$

#### 2.
$$2^{k}\sqrt{2} \frac{(2^{-k}y_{k})^{2}}{1+\sqrt{1-(2^{-k}y_{k})^{2}}}$$