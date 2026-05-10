	# Exercice 1
#### 1.
L’approximation fonctionne pour $20$ itérations mais pour $100$ itérations on obtiens finalement $0$. 

L'erreur provient principalement de la soustraction de $1$ et $\sqrt{1-(2^{-k}y_{k})^{2}}$ car les deux nombres sont très proches $(\sqrt{1-(2^{-k}y_{k})^{2}} \approx 1)$
Car l'erreur de la soustraction est : 
$$\boxed{\rho(a-b) = \frac{a}{a-b}\rho (a) - \frac{b}{a-b}\rho(b)}$$
$$\pi \approx 3,141592653589793$$
#### 2.
$$\boxed{y_{k+1} = 2^{k}\sqrt{2 \frac{(2^{-k}y_{k})^{2}}{1+\sqrt{1-(2^{-k}y_{k})^{2}}}}}$$

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

#### 2.
On modélise l'approximation de la fonction $\ln$ par $\varepsilon$ :
$$I_{0, \text{approx}} = I_{0} + \varepsilon$$
Alors, par la formule de récurrence, on a : 
$$I_{1} = 1-a(I_{0}+\varepsilon)$$
et : 
$$I_{2} = \frac{1}{2}- a(1-a(I_{0}+\varepsilon)) = \frac{1}{2} - a(1-aI_{0})+a^{2}\varepsilon$$
Ainsi, dès la deuxième itération l'erreur est amplifiée de $a^{2}=100$.
$$\boxed{I_{n} = \frac{1}{n}-aI_{n-1} + (-a)^{n}\varepsilon}$$

$$\boxed{\rho(a-b) = \frac{a}{a-b}\rho (a) - \frac{b}{a-b}\rho(b)}$$

#### 3.
Soit $m \in \mathbb{N}^{*}$ et $n \in [\![ 0, m [\![$,
$$\begin{array}{l}
d_{n}^{(m)} &= I_{n}^{(m)}-I_{n} \\
&= \frac{1}{a}\left( \frac{1}{n+1}-I_{n+1}^{(m)} \right) - \frac{1}{a}\left( \frac{1}{n+1}-I_{n+1} \right) \\
&=\frac{1}{a}(I_{n+1}-I_{n+1}^{(m)}) \\
&= -\frac{1}{a}d_{n+1}^{(m)}=\frac{1}{a^{2}}d_{n+2}^{(m)} = \dots = \left( -\frac{1}{a} \right)^{m-n} d_{m}^{(m)}
\end{array}$$
Ainsi par une recurrence rapide :
$$\boxed{d_{n}^{(m)} = -\left( -\frac{1}{a} \right)^{m-n} I_{m}}$$

___
$$0 \leq I_{n} \leq \int_{0}^{1} \frac{x^{n}}{a}\, dx  \text{ on a alors : } \left| I_{n}\right| = I_{n}$$
Alors, comme : 
$$I_{n+1} = \frac{1}{n}-aI_{n}\geq 0 \Rightarrow \frac{1}{n} \geq aI_{n} \geq0$$


Ainsi : 
$$\left| d_{n}^{(m)} \right|=  \frac{1}{a^{m-n}} I_{m} \leq \frac{1}{a^{m-n}} \int_{0}^{1} \frac{x^{m}}{a} \, dx = \frac{1}{a^{m-(n-1)} (m+1)}$$


Ainsi, 
$$\boxed{\left| d_{n}^{(m)}\right| \leq \frac{1}{a^{m-(n-1)}(m+1)}}$$
___
Pour $a > 1$ :
$$\left| d_{n}^{(m)}\right| = \frac{1}{a}\left| d_{n+1}^{(m)}\right| \Rightarrow \left| d_{n+1}^{(m)} \right| \leq \left| d_{n}^{(m)}\right|$$

$$I_{20}=0.00434703581802810875429$$





## 2. Méthodes itératives, ordre et accélération de convergence
# Exercice 3
### 1.
#### i.
$\cos$ est lipschitzienne contractante continue : 
$$\forall x \in \mathbb{R}, \cos'(x) = \sin(x) \leq 1$$
De plus, 
$$\cos([-1,1]) \subset [-1, 1] \text{ qui est un fermé borné}$$
Ainsi, d'après le théorème de Banach : 
$$\exists !s \in [-1, 1], \, \begin{cases}
\cos(s) = s \\
\boxed{x_{n} \underset{n \to +\infty}{\longrightarrow} s}
\end{cases}$$


#### ii.
Calcul numérique de : $\cos(s) = s$, 
L'ordre de convergence est de $1$ car $\sin(s) \neq 0$ ($\cos(0) = 1 \neq 0$ comme $s \in [-1, 1], \sin(s) \neq 0$).
La vitesse de convergence est égale à : 
$$\boxed{v = f'(s) = \sin(s)}$$

#### iii.
$$F(x) = x-\cos(x)$$
$$x_{n+1} = x_{n} - \frac{F(x_{n})}{F'(x_{n})}$$
$$f'(x) = \frac{F(x)F''(x)}{F'(x)^{2}} =  \frac{(x-\cos(x))\cos(x)}{1+\sin(x)} \Rightarrow f'(s) = 0$$
Alors on a : 
$$f''(x) = \frac{(F'(x)F''(x)+F(x)F^{(3)}(x))F'(x)-2F(x)^{2}F''(x)}{F'(x)^3}$$
Alors comme $F(s)=0$ :
$$f''(s) = \frac{F''(s)}{F'(s)} =\frac{\cos(s)}{1+\sin(s)}$$
Donc l'ordre de la méthode de Newton est de $\boxed{2}$.
Ainsi sa vitesse de convergence est de : 
$$\boxed{v = \frac{f''(s)}{2} = \frac{F''(s)}{2F'(s)} = \frac{\cos(s)}{2(1+\sin(s))}}$$

#### vi.
Comme la pente de cette fonction est grande vers le point fixe, l'erreur est amplifiée à chaque itération et de plus elle oscille à cause du $-$ : 
$$\boxed{\frac{e_{n+1}}{e_{n}} \underset{n \to +\infty}{\sim} f'(s) = -10\sin(s)}$$
de plus, $f'(s)$ doit surement être supérieur à $1$ car l'algorithme diverge et donc le théorème de Banach n'est pas respecté. 

#### v.
$$x_{n}' = x_{n} - \frac{(x{_{n+1}-x_{n}})^{2}}{x_{n+2} - 2x_{n+1} + x_{n}}$$
Ordre de convergence : 
$$(\Delta x_{n+1})^{2} =  C^{2}\lambda^{2n}(\lambda-1)^{2} + o(\lambda^{2n+2}) $$
$$x_{n+2} -2x_{n+1}+x_{n} = C\lambda^{n}(\lambda-1)^{2} + o(\lambda^{n+2})$$
Alors, 
$$x'_{n} =  x_{n} - C\lambda^{n} + o(\lambda^{n}) = s +o(\lambda^{n})=  s + O(\lambda^{n+1})$$
Donc, l'ordre de convergence est de $2$



#### vi.
$$x_{n+1} = x_{n} - \frac{(f(x_{n})-x_{n})^{2}}{f(f(x_{n})) - 2f(x_{n}) + x_{n}}$$
On pose :
$$g(\xi) = \xi - \frac{(f(\xi)-\xi)^{2}}{f(f(\xi)) - 2 f(\xi) + \xi}$$
Alors :



# Exercice 4
#### i

#### ii.
On pose : 
$$X_{n} = 
\begin{pmatrix}
x_{1} \\
x_{2}
\end{pmatrix} \text{ et }X_{n+1} = f(X_{n}) = \begin{pmatrix}
\frac{x_{2}^{2}-x_{1}^{2}}{2} \\
1-x_{1}^{2}x_{2}
\end{pmatrix}$$
$$X_{n+1} = X_{n} - J_{F}^{-1}(X_{n})F(X_{n}) \text{ avec }x_{0} \in \mathbb{R}^{2}$$
Avec : 
$$F(x_{1}, x_{2}) = \begin{pmatrix}
x_{1} \\
x_{2}
\end{pmatrix} - \begin{pmatrix}
\frac{x_{2}^{2}-x_{1}^{2}}{2} \\
1-x_{1}^{2}x_{2}
\end{pmatrix} = \begin{pmatrix}
x_{1}-\frac{1}{2}(x_{2}^{2}-x_{1}^{2}) \\
x_{2}-1+x_{1}^{2}x_{2}
\end{pmatrix} = \begin{pmatrix}
f_{1} \\
f_{2}
\end{pmatrix}
$$
$$J_{F}(x_{1}, x_{2}) = \begin{pmatrix}
\frac{\partial f_{1}}{\partial x_{1}}&\frac{\partial f_{1} }{\partial x_{2}}   \\
\frac{\partial f_{2} }{\partial x_{1}}&\frac{\partial f_{2}}{\partial x_{2}} 
\end{pmatrix} = \begin{pmatrix}
1+x_{1} & -x_{2} \\
2x_{1}x_{2} & 1+x_{1}^{2}
\end{pmatrix}$$
Alors, 
$$J^{-1}(x_{1}, x_{2}) = \frac{1}{(1+x_{1})(1+x_{1}^{2})+2x_{1}x_{2}^{2}}\begin{pmatrix}
1+x_{1}^{2} & x_{2} \\
-2x_{1}x_{2} & 1+x_{1}
\end{pmatrix}$$
Donc, 
$$\boxed{X_{n+1} = X_{n} - J_{F}^{-1}(X_{n})F(X_{n})}$$
La méthode ne semble pas converger

On choisit de calculer $p$ tel que : 
$$\left|\left| e_{n+1} \right|\right| \approx \lambda \left|\left| e_{n} \right|\right|^{p} \text{ et } \left|\left| e_{n} \right|\right| \approx \lambda \left|\left| e_{n-1} \right|\right|^{p} $$
Alors, 
$$\frac{\left|\left| e_{n+1} \right|\right| }{\left|\left| e_{n} \right|\right| } \approx \left( \frac{\left|\left| e_{n} \right|\right| }{\left|\left| e_{n-1} \right|\right| } \right)^{p}$$
Ainsi, 
$$\boxed{p \approx \frac{\ln\left( \frac{\left|\left| e_{n+1} \right|\right| }{\left|\left| e_{n} \right|\right| } \right)}{\ln\left( \frac{\left|\left| e_{n} \right|\right| }{\left|\left| e_{n-1} \right|\right| } \right)}}$$

# Exercice 5
#### i.
$$x_{n+1} = x_{n} - \frac{F(x_{n})}{F'(x_{n})} = x_{n} - \frac{x_{n}^{k}-\alpha}{kx_{n}^{k-1}}$$
Donc, 
$$\boxed{f(x) = x - \frac{x^{k}-\alpha}{kx^{k-1}}}$$
Alors, 
$$f'(x) = 1- \frac{k^{2}x^{2(k-1)} - k(k-1)x^{k-2}(x^{k}-\alpha)}{k^{2}x^{2(k-1)}} $$
Donc, 
$$f'(x) = \frac{k-1}{k}(1-x^{-k}\alpha)$$
Ainsi, 
$$f'(\sqrt[k]{\alpha}) = 0$$
De plus, 
$$\boxed{f''(x) = (1-k)\alpha x^{-k-1} = \frac{1-k}{\sqrt[k]{\alpha}} \neq 0}$$
Ainsi, la méthode est d'ordre $2$. 

#### ii.
L'ordre de convergence de la méthode de Newton est de $2$ : 
$$\left| e_{n+1}\right| \sim \lambda \left| e_{n}\right|^{2}$$
Alors, la vitesse de l'évolution des nombre significatif est de : 
$$\begin{array}{ll}
v_{n+1} &= -\log\left| \frac{e_{n+1}}{e_{n}} \right|  \\
&\approx -\log\left| \lambda e_{n}\right|  \\
&\approx -\log\left| (\lambda e_{n-1})^{2}\right|  \\
&=-2\log\left| \lambda e_{n-1}\right| \\
&=-2\log\left| \frac{e_{n}}{e_{n-1}}\right|
\end{array}$$
Ainsi, 
$$\boxed{v_{n+1} \approx 2 v_{n}}$$
C'est pourquoi on a un facteur $2$ a chaque itération.

#### iii.
$$x_{n+1} = x_{n}-\frac{F(x_{k})}{\frac{F(x_{n}) - F(x_{n-1})}{x_{n} - x_{n-1}}} \text{ avec } F(x) = x^{k}-\alpha$$
Donc, 
$${x_{n+1} = x_{n} - \frac{x_{n}^{k}-\alpha}{\frac{x_{n}^{k}-x_{n-1}^{k}}{x_{n}-x_{n-1}}}=x_{n}-\frac{x_{n}^{k}-\alpha}{x_{n}^{k-1} + x_{n-1}^{k-1}}}$$
Ainsi,
$$\boxed{x_{n+1} = x_{n}-\frac{x_{n}^{k}-\alpha}{x_{n}^{k-1} + x_{n-1}^{k-1}}}$$
