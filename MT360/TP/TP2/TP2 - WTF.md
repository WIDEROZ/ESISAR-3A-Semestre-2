# Exercice 1
## 1.
On pose :
$$\forall n \in \mathbb{N}, \begin{cases}
t_{n+1} = t_{n} + h \\
f(x, y) = 2xy(x) - x y(x)^{2}  \\
 y_{n+1} = y(t_{n} + h)
\end{cases}$$
On cherche alors à résoudre : 
$$y'(x) = f(x, y)$$
Alors par Euler explicite on a : 
$$y_{n+1} = y_{n} + h f(x, y) $$

#### Point milieu
On pose : 
$$y_{M+1} = y_{M} + h f\left(x_{M} +\frac{h}{2}, y_{M} + \frac{h}{2}f(x_{M},y_{M})\right) $$

#### Runge-Kutta d'ordre $4$
On pose : 
$$c_{i} = \sum_{j = 1}^{n} a_{i,j}$$
$$\begin{cases}
k_{1} = f(x, y(x))  \\
k_{2} = f(t + c_{2} h, y +  a_{2,1}k_{1}h) \\
k_{3} = f(t + c_{3} h, y + (a_{3,1}k_{1} + a_{3,2}k_{2})h) \\
k_{4} = f(t + c_{4} h, y + (a_{4,1}k_{1} + a_{4,2}k_{2} + a_{4,3}k_{3})h)
\end{cases}$$
On prend un approximation de Runge-Kutta d'ordre $4$ : 
$$\phi^{RT_{4}} = R_{1}k_{1} + R_{2}k_{2} + R_{3}k_{3} + R_{4}k_{4}$$
$$ \text{ avec } R_{1}, R_{2} , R_{3}, R_{4}\in [0, 1] $$
$$\text{ et } R_{1}+R_{2}+R_{3}+R_{4} = 1$$
Alors, 
$$\begin{array}{c|cc}
0 \\
c_{2} & a_{2, 1} \\
c_{3} & a_{3, 1}&a_{3, 2} \\
c_{4} & a_{4, 1}& a_{4, 2}&a_{4, 3} \\ \hline
 & R_{1} & R_{2} & R_{3} & R_{4}
\end{array}$$
On prend les coefficients du cours :
$$\begin{array}{c|cc}
0 \\
c_{2} & \frac{1}{3} \\
c_{3} & -\frac{1}{3}&1\\
c_{4} & 1&-1&1 \\ \hline
 & R_{1} & R_{2} & R_{3} & R_{4}
\end{array}$$


Comme par Taylor : 
$$y(x_{0} + h) \underset{h \to 0}{=} \sum_{k = 0}^{p} \frac{f^{(k)}(x_{0})}{k!} h^{k} + o(h^{p})$$
On a que , 
$${err \approx C h^{p}}$$
Donc, 
$$\log(err) = \log(C) + p\log(h)$$
Ainsi, la pente de $\log(err)$, nous donnera l'ordre de la méthode. 

# Exercice 2
#### ii
$$y_{n+1} = y_{n} + hf(x_{n}, y_{n})$$
Avec : 
$$y'(x) = f(x, y) = \lambda y(x)$$
alors :
$$y_{n+1} = (1+\lambda h)y_{n} = \dots = (1+\lambda h)^{n} y_{0}$$
Ainsi pour qu'il y ait stabilité numérique :
$$\boxed{\left| 1+\lambda h\right| < 1}$$

#### iii.

$$y_{n+1} = y_{n} + hf(x_{n+1}, y_{n+1})$$
Avec : 
$$y'(x) = f(x, y) = \lambda y(x)$$
alors :
$$y_{n+1} = y_{n} + h\lambda y_{n+1}\Leftrightarrow y_{n+1} = \frac{1}{1-\lambda h}y_{n} \Leftrightarrow y_{n+1} = \frac{1}{(1-\lambda h)^{n}}y_{0}$$
Ainsi pour qu'il y ait stabilité numérique :
$$\boxed{\left| 1-\lambda h\right| > 1 \Leftrightarrow 1+0.5h >1 \Leftrightarrow h > 0 }$$
Il y a bien stabilité inconditionnelle. 

#### iv
$$y_{n+1} = y_{n} + \frac{h}{2} (f(x_{n}, y_{n})+f(x_{n+1}, y_{n+1}))$$
$$\left(1 - \frac{\lambda h}{2} \right)y_{n+1} = \left( 1+\frac{\lambda h}{2} \right)y_{n} \Leftrightarrow y_{n+1} = \frac{2+\lambda h}{2-\lambda h}y_{n}$$
Alors, 
$$y_{n+1} = \left( \frac{2+\lambda h}{2-\lambda h}  \right)^{n}y_{0}$$
Comme $\lambda<0$ on a directement : 
$$\boxed{\left| \frac{2+\lambda h}{2-\lambda h}\right| < 1}$$
Il y a bien stabilité inconditionnelle. 