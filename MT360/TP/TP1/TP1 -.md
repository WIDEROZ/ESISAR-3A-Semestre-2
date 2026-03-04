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
$$I_{n}= \sum_{k = 1}^{n} (-1)^{k-1}\frac{a^{n-k}}{k} = ln(1-a^{n-k})$$

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
$$= \frac{1}{an} - \frac{1}{a}I_{n}^{(m)} - I_{n-1} = \frac{1}{an} - \frac{1}{a}d_{n}^{(m)} + \frac{1}{a} I_{n}- I_{n-1}$$
$$= \frac{1}{an}+ \frac{1}{a}\left( -\frac{1}{a} \right)^{m-n} I_{m}- I_{n-1}+ \frac{1}{a} I_{n}$$
$$= - \left( -\frac{1}{a} \right)^{m-(n-1)}I_{m} +\frac{1}{an} -I_{n-1}+ \frac{1}{a} I_{n}$$
$$= - \left( -\frac{1}{a} \right)^{m-(n-1)}I_{m} + \frac{1}{a}\left( \frac{1}{n}- \right)$$








Soit E un evn de dim finie Soit J ⊂ E et I un intervalle, $$f : \begin{cases} J \times I \to \mathbb{C} \ (x, t) \mapsto f(x, t) \end{cases}$$ Soit x 0 ∈ J ― ,

#### Théorème (TCVD)

On pose : F : x ↦ ∫ I f ( x , t ) , d t Si : $$\begin{cases} \forall x \in J,  
t \mapsto f(x, t) \in \mathcal{C}_{m}^{0} (I, \mathbb{C})  \\
 \forall t \in I, x \mapsto f(x, t) \text{ admet en } x_{0}\text{ une lim }g(t) \,
  g \in \mathcal{C}^{0}(I, \mathbb{C})  \\
  \exists \varphi : I \to \mathbb{R} \text{ intégrable telle que :} \ \forall (x, t)\in J \times I, \left| f(x, t)\right|\leq \varphi(t) \end{cases}$$ Alors, $$\begin{cases} F \text{ est bien définie sur }J  \\
   \underset{ x \to x_{0} }{\lim} F(x) = \int _{I} g(t) , dt  
\end{cases}$$