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

# Exercice 3
### 1.
On montre que : 
$$\frac{\partial H}{\partial t} (x, y) = 0$$
Alors, 
$$\begin{array}{ll}
\frac{\partial H}{\partial t} (x, y) &= \delta \frac{\partial x}{\partial t}  + \beta \frac{\partial y}{\partial t}  - \frac{\partial x}{\partial t}\frac{\gamma  x^{\gamma-1}y^{\alpha} }{x^{\gamma}y^{\alpha}}- \frac{\partial y}{\partial t}\frac{\alpha x^{\gamma} y^{\alpha-1}}{x^{\gamma}y^{\alpha}} \\
&= \frac{\partial x}{\partial t} \left( \delta - \gamma \frac{1}{x} \right) +  \frac{\partial y}{\partial t} \left( \beta-\alpha  \frac{1}{y} \right) \\
&= x(\alpha-\beta y)\left( \delta - \gamma  \frac{1}{x} \right) + y(\delta x-\gamma)(\beta-\alpha \frac{1}{y}) \\
&=(\alpha-\beta y)(\delta x-\gamma)-(\delta x - \gamma)(\alpha-\beta y) 
\end{array}$$
Ainsi, 
$$\boxed{\frac{\partial H}{\partial t} (x(t), y(t)) = 0}$$


### 2.
Méthode d'Euler implicite : 
$$\frac{\partial x}{\partial t} = \alpha x(t) - \beta x(t)y(t)$$
$$\frac{\partial y}{\partial t} = \delta x(t)y(t)- \gamma y(t)$$

$$x_{n+1} = x_{n}+hf(x_{n+1}, y_{n+1}) = x_{n}+h(\alpha x_{n+1}-\beta x_{n+1}y_{n+1})$$
Alors, 
$$x_{n+1}(1-h(\alpha-\beta y_{n+1}))=x_{n}$$
Ainsi, 
$$\boxed{x_{n+1}=\frac{x_{n}}{1-h(\alpha-\beta y_{n+1})}}$$
Par analogie pour $y_{n}$ : 
$$\boxed{y_{n+1} = \frac{y_{n}}{1-h(\delta x_{n+1}-\gamma)}}$$


Méthode du point milieu : 
$$\boxed{y_{n+1} = y_{n} + hf_{y}(x_{n} + \frac{h}{2}f_{x}(x_{n}, y_{n}), y_{n} + \frac{h}{2}f_{y}(x_{n}, y_{n}))}$$


#### 3.
La méthode d'Euler symplectique est donnée par :
$$y_{n+1} = y_{n} + hf_{y}(x_{n}, y_{n+1})$$
Alors, 
$$y_{n+1} = y_{n} + hy_{n+1}(\delta x_{n} - \gamma)$$
Ainsi, 
$$\boxed{y_{n+1} = \frac{y_{n}}{1-h(\delta x_{n}-\gamma)}}$$
Ainsi : 
$$\boxed{x_{n+1} = x_{n} + hf_{x}(x_{n}, y_{n+1})}$$
___
La méthode implicite du point milieu est donné par : 
$$x_{k+1} = x_{k}  + h \frac{x_{k}+x_{k+1}}{2}(\alpha-\beta y_{k})$$
Alors, 
$$x_{k+1}\left( 1-\frac{\alpha-\beta y_{k}}{2} \right) = x_{k} + h \frac{x_{k}}{2} = \left( 1+\frac{h}{2} \right)x_{k}$$
Ainsi, 
$$\boxed{x_{k+1} = \frac{2+h}{2- (\alpha-\beta y_{k})}x_{k}}$$
De même on a : 
$$\boxed{y_{k+1} = \frac{2+h}{2-(\delta x_{k}-\gamma)}y_{k}}$$




#### 4.
Si $(x(t), y(t)) = \left( \frac{\gamma}{\delta}, \frac{\alpha}{\beta} \right)$ :
$$\boxed{\frac{\partial x}{\partial t} = \alpha x(t) - \beta x(t)y(t) = \alpha \frac{\gamma}{\delta} - \beta  \frac{\gamma}{\delta}\frac{\alpha}{\beta} = 0}$$
$$\boxed{\frac{\partial y}{\partial t} = \delta x(t)y(t)- \gamma y(t) = \delta \frac{\gamma}{\delta} \frac{\alpha}{\beta} - \gamma \frac{\alpha}{\beta} = 0}$$
Pour $(x(t), y(t)) = \left( 0, 0 \right)$ c'est trivial.
___

On a : $(x(t), y(t)) = \left( \frac{\gamma}{\delta} + \tilde{x}(t), \frac{\alpha}{\beta}  + \tilde{y}(t)\right)$ : 
$$\begin{pmatrix}
\dot{\tilde{x}}(t) \\
\dot{\tilde{y}}(t)
\end{pmatrix} = \begin{pmatrix}
0 & -\frac{\beta \gamma}{\delta} \\
\frac{\delta \alpha}{\beta}&0
\end{pmatrix}\begin{pmatrix}
{\tilde{x}}(t) \\
{\tilde{y}}(t)
\end{pmatrix} = \begin{pmatrix}
-\frac{\beta \gamma}{\delta}\tilde{y}(t) \\
\frac{\delta \alpha}{\beta}\tilde{x}(t)
\end{pmatrix}$$

Alors, on a bien :
$$\dot{\tilde{x}}(t) = \left( \frac{\gamma}{\delta} + \tilde{x}(t) \right)\left( \alpha-\beta\left( \frac{\alpha}{\beta}+\tilde{y}(t) \right) \right) = -\beta\left( \frac{\gamma}{\delta} + \tilde{x}(t) \right) \tilde{y}(t)$$
Ainsi, 
$$\dot{\tilde{x}}(t) = -\frac{\beta \gamma}{\delta} \tilde{y}(t)-\beta \tilde{x}(t)\tilde{y}(t) \approx-\frac{\beta \gamma}{\delta} \tilde{y}(t)$$

Même raisonnement pour $y$ : 
$$\dot{\tilde{y}}(t) = \frac{\delta \alpha}{\beta}\tilde{x}(t)$$
___
On a :
$$\tilde{H}(\tilde{x}, \tilde{y}) = \begin{pmatrix}
\frac{\delta \alpha}{\beta}\tilde{x}(t)  & \frac{\beta \gamma}{\delta}\tilde{y}(t)
\end{pmatrix}\begin{pmatrix}
\tilde{x}(t) \\
\tilde{y}(t)
\end{pmatrix} = \frac{\delta \alpha}{\beta}\tilde{x}^{2}(t) + \frac{\beta \gamma}{\delta}\tilde{y}^{2}(t)$$
Alors,
$$\frac{\partial \tilde{H}}{\partial t} = 2\frac{\delta \alpha}{\beta} \frac{\partial \tilde{x}}{\partial t} \tilde{x}(t) + 2\frac{\beta \gamma}{\delta} \frac{\partial \tilde{y}}{\partial t} \tilde{y}(t)$$
Ainsi d'après les valeurs trouvés ($\dot{\tilde{x}} \text{ et } \dot{\tilde{y}}$) précédemment : 
$$\boxed{\frac{\partial \tilde{H}}{\partial t}  = 0}$$
La forme quadratique est conservée le long des trajectoires de ce système.

#### 5.
Par la méthode d'Euler explicite et l'exercice précédent on discrétise : $\begin{pmatrix}\dot{\tilde{x}}(t) \\\dot{\tilde{y}}(t)\end{pmatrix}$.
$$\begin{pmatrix}
x_{n+1} \\
y_{n+1}
\end{pmatrix} = \begin{pmatrix}
x_{n} \\
y_{n}
\end{pmatrix} + h\begin{pmatrix}
0 & -1 \\
1 & 0
\end{pmatrix}\begin{pmatrix}
\frac{\delta \alpha}{\beta} & 0 \\
0 & \frac{\beta \gamma}{\delta}
\end{pmatrix}\begin{pmatrix}
x_{n} \\
y_{n}
\end{pmatrix} $$
$$\begin{pmatrix}
x_{n+1} \\
y_{n+1}
\end{pmatrix}= \left( I_{2} + h\begin{pmatrix}
0&-\frac{\beta \gamma}{\delta} \\
\frac{\delta \alpha}{\beta}&0
\end{pmatrix} \right)\begin{pmatrix}
x_{n} \\
y_{n}
\end{pmatrix}$$
Alors, 
$$\begin{pmatrix}
x_{n+1} \\
y_{n+1}
\end{pmatrix} = \left( I_{2}+h\begin{pmatrix}
0&-\frac{\beta \gamma}{\delta} \\
\frac{\delta \alpha}{\beta} & 0
\end{pmatrix} \right)^{n}\begin{pmatrix}
x_{0} \\
y_{0}
\end{pmatrix} = A^{n}\begin{pmatrix}
x_{0} \\
y_{0}
\end{pmatrix}$$
Dans le but de la diagonaliser, on cherche donc les valeurs propres de la matrice : 
$$-A = -h\begin{pmatrix}
0&-\frac{\beta \gamma}{\delta} \\
\frac{\delta \alpha}{\beta} & 0
\end{pmatrix}$$
Alors, on obtiens :
$$\chi_{A} = \det(A+I_{n}) =(h+X)^{2}+\gamma  \alpha = X^{2}+2hX+(h^{2}+\gamma \alpha)$$
$$\Delta = 4h^{2}-4(h^{2}+\gamma \alpha) = -4\gamma \alpha <0$$
Donc, 
$$\chi_{A} = (X-(-h-i\sqrt{\gamma \alpha}))(X-(-h+i\sqrt{\gamma \alpha}))$$
Ainsi, 
$$\chi_{A} = (X+h +i\sqrt{\gamma \alpha})(X+h-i\sqrt{\gamma \alpha})$$
Donc si on écrit :
$$A = PDP^{-1} = P\begin{pmatrix}
h +i\sqrt{\gamma \alpha}&0 \\
0&h -i\sqrt{\gamma \alpha}
\end{pmatrix}P^{-1}$$
et qu'on l'implémente dans l'équation :
$$\begin{pmatrix}
x_{n+1} \\
y_{n+1}
\end{pmatrix}= P(I_{2}+D)^{n}P^{-1}\begin{pmatrix}
x_{0} \\
y_{0}
\end{pmatrix}$$
$$\boxed{\begin{pmatrix}
x_{n+1} \\
y_{n+1}
\end{pmatrix} = P\begin{pmatrix}
1+h+i\sqrt{\gamma \alpha} & 0 \\
0 & 1+h-i\sqrt{\gamma \alpha}
\end{pmatrix}^{n}P^{-1} \begin{pmatrix}
x_{0} \\
y_{0}
\end{pmatrix}}$$
Ainsi, Euler explicite est stable ssi le module des valeurs propres est inférieur à $1$, seulement : 
$$\sqrt{(1+h)^{2} + \gamma \alpha} > 1 (\text{car }h >0)$$
Euler explicite n'est donc jamais stable.

___
Euler implicite :
De la même manière on obtiens :
$$\begin{pmatrix}
x_{n+1} \\
y_{n+1}
\end{pmatrix}= \left( I_{2} - h\begin{pmatrix}
0&-\frac{\beta \gamma}{\delta} \\
\frac{\delta \alpha}{\beta}&0
\end{pmatrix} \right)^{-1}\begin{pmatrix}
x_{n} \\
y_{n}
\end{pmatrix}$$
Donc, 
$$\begin{pmatrix}
x_{n+1} \\
y_{n+1}
\end{pmatrix} = \begin{pmatrix}
1 & h  \frac{\beta \gamma}{\delta} \\
-h\frac{\delta \alpha}{\beta} & 1
\end{pmatrix}^{-1} \begin{pmatrix}
x_{n} \\
y_{n}
\end{pmatrix}$$
$$\begin{pmatrix}
x_{n+1} \\
y_{n+1}
\end{pmatrix} = \frac{1}{1+h^{2}\gamma \alpha}\begin{pmatrix}
1&-h\frac{\beta \gamma}{\delta} \\
h\frac{\delta \alpha}{\beta} & 1
\end{pmatrix}\begin{pmatrix}
x_{n} \\
y_{n}
\end{pmatrix} $$
$$\begin{pmatrix}
x_{n+1} \\
y_{n+1}
\end{pmatrix}= \frac{1}{(1+h^{2}\gamma \alpha)^{n}} \begin{pmatrix}
1&-h\frac{\beta \gamma}{\delta} \\
h\frac{\delta \alpha}{\beta} & 1
\end{pmatrix}^{n}\begin{pmatrix}
x_{0} \\
y_{0}
\end{pmatrix}$$
Alors, en posant : 
$$A = \begin{pmatrix}
1&-h\frac{\beta \gamma}{\delta} \\
h\frac{\delta \alpha}{\beta} & 1
\end{pmatrix}$$
$$\chi_{A} = \det(XI_{2}-A) = (X-1)^{2}+h^{2}\gamma \alpha $$
$$\chi_{A} = (X-(1+ih\sqrt{\gamma \alpha}))(X-(1-ih\sqrt{\gamma \alpha}))$$
Alors, 
$$A = PDP^{-1} = P\begin{pmatrix}
1+ih\sqrt{\gamma \alpha}&0 \\
0&1-ih\sqrt{\gamma \alpha}
\end{pmatrix}P^{-1}$$
Donc : 
$$\begin{pmatrix}
x_{n+1} \\
y_{n+1}
\end{pmatrix}= P\frac{1}{(1+h^{2}\gamma \alpha)^{n}} D^{n}P^{-1}\begin{pmatrix}
x_{0} \\
y_{0}
\end{pmatrix}$$
Ainsi, comme : 
$$\left| \frac{1\pm ih\sqrt{\gamma a}}{1+h^{2}\gamma \alpha}\right| = \frac{1}{1+h^{2}\gamma a}\sqrt{1+h^{2}\gamma \alpha} = \boxed{\frac{1}{\sqrt{1+h^{2}\gamma \alpha}}< 1}$$
Euler implicite est inconditionnellement stable. 

#### 6.
