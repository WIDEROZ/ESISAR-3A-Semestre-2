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
Comme $a>0$, $\forall x \in [0, 1], a+x \neq 0$, alors $x \mapsto \frac{x^{n}}{x+a}$ est continue sur $[0, 1]$. Donc intégrable
$$I_{n} = \int_{0}^{1} \frac{x^{n}}{a+x} \, dx $$
$$\boxed{I_{0}= \int_{0}^{1} \frac{1}{a+x} \, dx  = [ln(a+x)]_{0}^{1} = ln\left( \frac{1+a}{a} \right)}$$
___
On a : 
$$I_{n} + a I_{n-1} = \int_{0}^{1} \frac{x^{n}+ax^{n-1}}{x+a} \, dx = \int_{0}^{1} x^{n-1} \, dx = \frac{1}{n} [x^{n}]_{0}^{1} = \frac{1}{n} $$
Ainsi, 
$$\boxed{\forall n \in \mathbb{N}^{*},I_{n} = \frac{1}{n} - aI_{n-1}}$$
___
On a : 
$$I_{n}- I_{n-1} = \int_{0}^{1} \frac{x^{n}-x^{n-1}}{a+x} \, dx $$
Comme $x \mapsto \frac{x^{n}-x^{n-1}}{a+x} <0$ car $x \in [0, 1]$ alors, 
$$I_{n}-I_{n-1} <0$$
Ainsi, $I_{n}$ décroit et comme : 
$$I_{n}+ aI_{n-1} = \frac{1}{n} \underset{n \to +\infty}{\longrightarrow} 0$$
On a :
$$I_{n} = \frac{1}{n} - a\left( \frac{1}{n-1}-aI_{n-2} \right)$$
$$= i_{N}$$

#### 3.
