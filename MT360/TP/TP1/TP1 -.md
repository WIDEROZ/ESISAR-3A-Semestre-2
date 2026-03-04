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
On souhaite utiliser le TCVD : 
$f_{n}:x \mapsto \frac{x^{n}}{a+x}$ est intégrable en $x$
$\forall [0, 1], f_{n}(x) = \frac{x^{n}}{x+a} \underset{n \to +\infty}{\longrightarrow} 0$
et 
$$\forall  x \in [0, 1], \left| \frac{x^{n}}{x+a} \right| \leq \frac{1}{x+a} \text{ qui est intégrable sur } [0, 1]$$
Ainsi, 
$$\boxed{\lim_{ n \to \infty }I_{n} = \int_{0}^{1} \lim_{ n \to \infty } \frac{x^{n}}{x+a} \, dx = 0  }$$


#### 3.


#### 4.
$$d_{n}^{(m)} = I_{n}^{(m)}-I_{n}$$
On procède par récurrence de $m$ à $0$ : 
Initialisation : 
$$d_{m}^{(m)} = -\left( -\frac{1}{a} \right)^{m-m} I_{m} = -I_{m} = I_{m}^{(m)}- I_{m}$$

Hérédité : 
Supposons que :
$$d_{n}^{(m)} = -\left( -\frac{1}{a} \right)^{m-n} I_{m}$$
Alors, 
$$d_{n-1}^{(m)} = I_{n-1}^{(m)} - I_{n-1} = \frac{1}{a}\left( \frac{1}{n} - I_{n}^{(m)} \right) -I_{n-1}$$
$$= \frac{1}{an} - \frac{1}{a}I_{n}^{(m)} - I_{n-1} = \frac{1}{an} - \frac{1}{a}d_{n}^{(m)} - \frac{1}{a} I_{n}- I_{n-1}$$
$$= \frac{1}{an}+ \frac{1}{a}\left( -\frac{1}{a} \right)^{m-n} I_{m}- I_{n-1}- \frac{1}{a} I_{n}$$
$$= - \left( -\frac{1}{a} \right)^{m-(n-1)}I_{m} +\frac{1}{an} -\frac{1}{an} + \frac{1}{a}I_{n}- \frac{1}{a} I_{n}$$
Ainsi, 
$$\boxed{d_{n-1}^{(m)}= - \left( -\frac{1}{a} \right)^{m-(n-1)}I_{m}}$$

$$0 \leq I_{n} \leq \int_{0}^{1} \frac{x^{n}}{a}\, dx $$
$$\forall n \in [\![0, m[\![, \left| d_{n}^{(m)} \right|=  \frac{1}{a^{m-n}} I_{m} \leq \frac{1}{a^{m-n}} \int_{0}^{1} \frac{x^{n}}{a} \, dx = \frac{1}{a^{m-(n-1)} (n+1)}$$
Ainsi, 
$$\boxed{\forall n \in [\![0, m[\![, \left| d_{n}^{(m)}\right| \leq \frac{1}{a^{m-(n-1)}(n+1)}}$$
