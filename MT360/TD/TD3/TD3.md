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

# Exercice 2
$$X'(t) = \begin{pmatrix}
x_{1}'(t) \\
x_{2}'(t)
\end{pmatrix} = \begin{pmatrix}
-x_{1}(t) + x_{1}(t)x_{2}(t) \\
x_{2}(t)-x_{1}(t)x_{2}(t)
\end{pmatrix}$$
On cherche a savoir si $X'(t)$ est lipschitzienne. 
$$\forall r \in \mathbb{R}^{2}, \forall x, y \in \mathcal{B}((0, 0), r), A = \begin{pmatrix}
-x+xy \\
y-xy
\end{pmatrix}$$
Alors, 
$$\left|\left| A \right|\right|  = \sup_{U = (u, v) \neq (0, 0)} \frac{\left|\left| AU \right|\right| }{\left|\left| U \right|\right| } = $$