# Exercice 1
#### 1.
L’approximation fonctionne pour $20$ itérations mais pour $100$ itérations on obtiens finalement $0$. 

L'erreur provient principalement de la soustraction de $1$ et $\sqrt{1-(2^{-k}y_{k})^{2}}$ car les deux nombres sont très proches $(\sqrt{1-(2^{-k}y_{k})^{2}} \approx 1)$
Car l'erreur de la soustraction est : 
$$\boxed{\rho(a-b) = \frac{a}{a-b}\rho (a) - \frac{b}{a-b}\rho(b)}$$

#### 2.
$$\boxed{y_{k+1} = 2^{k}\sqrt{2} \frac{(2^{-k}y_{k})^{2}}{1+\sqrt{1-(2^{-k}y_{k})^{2}}}}$$

# Exercice 2
#### 1.
Soit $a \in \mathbb{R}_{+}^{*}$, 
Comme $a>0$, $\forall x \in [0, 1], a+x \neq 0$, alors l'intégrande est continue. 
$$I_{n} = \int_{0}^{1} \frac{x^{n}}{a+x} \, dx $$
$$\boxed{I_{0}= \int_{0}^{1} \frac{1}{a+x} \, dx  = [ln(a+x)]_{0}^{1} = ln\left( \frac{1+a}{a} \right)}$$

On procède par intégration par parties : 
$$I_{n} = []_{0}^{1}$$

$$\forall n \in \mathbb{N}^{*},I_{n} = \frac{1}{n} - aI_{n-1}$$
