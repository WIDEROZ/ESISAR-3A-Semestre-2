# Exercice 1
#### 1.
On pose : 
$$f(t, x(t)) = x^{2}(t)$$

$$x'(t) = x^{2}(t) \text{ et } x(0) = 1$$
Soit, $t \in \mathbb{R}$, 
$$\left| \frac{x^{2}(t) - y^{2}(t)}{x(t)-y(t)}\right| = x(t)+y(t) $$
(elle ne semble pas lipschitzienne globalement)

Soit $r \in \mathbb{R}$, tel que $\forall x, y \in \mathcal{B}(1, r)$,
Alors, 
$$\frac{\left| x^{2}- y^{2}\right|}{\left| x-y\right|} \leq \left| x+y\right| \leq 2+2r$$
Ainsi, $L = 2+2r$
Donc, $f$ est lipschitzienne LOCALEMENT en $x$. 

De plus, 
$$\frac{dx}{dt} = x^{2} \Rightarrow \frac{dx}{x^{2}} = dt $$
Alors, 
$$\int_{x(0)}^{x(t)} \, \frac{d\xi}{\xi^{2}} = \int_{0}^{t} \, dt  \Leftrightarrow \frac{1}{x(0)}-\frac{1}{x} = t \Leftrightarrow \frac{1}{x} = \frac{1}{x(0)} -t  $$
Ainsi, 
$$\boxed{x(t) = \frac{x_{0}}{1-x_{0}t}}$$

#### 2.
$$X'(t) = \begin{pmatrix}
x_{1}'(t) \\
x_{2}'(t)
\end{pmatrix} = \begin{pmatrix}
-x_{1}(t) + x_{1}(t)x_{2}(t) \\
x_{2}(t)-x_{1}(t)x_{2}(t)
\end{pmatrix}$$
On cherche a savoir si $X'(t)$ est lipschitzienne. 
$$\forall r \in \mathbb{R}, \forall x, y \in \mathcal{B}((0, 0), r), A = \begin{pmatrix}
-x+xy \\
y-xy
\end{pmatrix}$$
Alors, 
$$\left|\left| A \right|\right|  = \sup_{U = (u, v) \neq (0, 0)} \frac{\left|\left| AU \right|\right| }{\left|\left| U \right|\right| } = \sup_{U \neq 0}\frac{\left| u(xy-x) + v(y-xy)\right|}{\left| u+v\right|} $$
$$\leq \sup_{U \neq 0 }  \frac{\left| u(r^{2}-r)\right|}{\left| u+v\right|} + \sup_{U \neq 0 } \frac{\left| v(r-r^{2})\right|}{\left| u+v\right|} = L_{1}$$

$$\frac{\left|\left| A \right|\right| - \left|\left| B \right|\right|}{\left|\left| X \right|\right| - \left|\left| Y \right|\right| } $$


# Exercice 4
$$J = \begin{pmatrix}
0 & 1 \\
-1 & 0
\end{pmatrix} \text{ et } R =\begin{pmatrix}
R_{2} & 0 \\
0 & \frac{1}{R_{1}}
\end{pmatrix} \text{ et } Q = \begin{pmatrix}
\frac{1}{L} & 0 \\
0 & \frac{1}{C}
\end{pmatrix}$$
$$\begin{cases}
\dot{x}(t) = (J-R)Qx(t) \\
x(0) = x_{0} \in \mathbb{R}
\end{cases}$$
On pose : 
$$\dot{x}(t) = f(t, x(t))$$
de plus,
$$x_{k} = x(t_{k})$$
### 1.
#### Euler explicite
$$f(t, x(t)) = \dot{x}(t) \approx \frac{x_{k+1}-x_{k}}{t_{k+1}-t_{k}} = \frac{x_{k+1}-x_{k}}{h}$$
Ainsi, 
$$\boxed{x_{k+1} = hf(t_{k}, x_{k}) + x_{k}}$$
$$\boxed{\begin{pmatrix}
\phi_{k+1} \\
Q_{k+1}
\end{pmatrix} = h\begin{pmatrix}
-\frac{R_{2}}{L}& \frac{1}{C} \\
-\frac{1}{L} &  -\frac{1}{R_{1}C}
\end{pmatrix}\begin{pmatrix}
\phi_{k} \\
Q_{k} 
\end{pmatrix} + \begin{pmatrix}
\phi_{k} \\
Q_{k} 
\end{pmatrix}}$$

#### Méthode des trapèzes
$$\frac{x_{k+1}-x_{k}}{h} \approx \frac{f(t_{k+1}, x_{k+1}) + f(t_{k}, x_{k})}{2}$$
Ainsi, 
$$\boxed{x_{k+1} = h \frac{f(t_{k+1} , x_{k+1}) + f(t_{k}, x_{k})}{2} + x_{k}}$$

#### Méthode du point milieu
$$x_{k+1} = x_{k} + hf\left(t_{M} , x_{M} \right)$$
Avec : 
$$t_{M} = t_{k} + \frac{h}{2} \text{ et } x_{M} = x_{k} + \frac{h}{2} f(t_{k}, x_{k})$$
Alors, 
$$x_{k+1} = x_{k} + h f\left( t_{k} + \frac{h}{2}, x_{k} + \frac{h}{2} f(t_{k}, x_{k}) \right)$$
$$= x_{k} + h\left( f\left( t_{k}+\frac{h}{2}, x_{k} \right) +\frac{h}{2} f\left( t_{k}+\frac{h}{2}, f(t_{k},x_{k}) \right) \right)$$
$$= x_{k} + h(J-R)Q \left( x_{k} + \frac{h}{2} f\left( t_{k} + \frac{h}{2}, x_{k} \right) \right)$$
$$\boxed{= x_{k} + h(J-R)Q \left( x_{k} + \frac{h}{2} (J-R)Q x_{k} \right)}$$
Ainsi, 
$$\boxed{x_{k+1} = x_{k} + h \begin{pmatrix}
-\frac{R_{2}}{L} & \frac{1}{C} \\
-\frac{1}{L} & -\frac{1}{R_{1}C}
\end{pmatrix} \left( x_{k} + \frac{h}{2} \begin{pmatrix}
 -\frac{R_{2}}{L} & \frac{1}{C} \\
 -\frac{1}{L} & -\frac{1}{R_{1}C}
\end{pmatrix} x_{k} \right) }$$

### 2.
$$\dot{x}(t) = Ax(t) = \begin{pmatrix}
0& \frac{1}{C} \\
-\frac{1}{L} & 0
\end{pmatrix}x(t)$$
Par recurrence rapide : 
$$x_{k} = x_{k} + h f(t_{k}, x_{k}) = (I+hA)^{k}x_{0}$$
