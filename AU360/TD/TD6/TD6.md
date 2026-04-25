## 1.
On souhaite : 
$$\begin{cases}
\dot{X} = AX + BU \\
Y = CX + DU
\end{cases}$$
Avec : 
$$X = \begin{pmatrix}
v  \\
a
\end{pmatrix}$$
On applique le PFD : 
$$\begin{cases}
F_{r}(t) =k(a(t)-0) = ka(t)  \\
F_{f}(t) = -fv(t) \\
F(t)
\end{cases}$$
Alors, 
$$\frac{dv(t)}{dt}  = -\frac{k}{M}a-\frac{f}{M}v + \frac{1}{M}F(t)$$
$$\dot{X} = \begin{pmatrix}
\frac{dv(t)}{dt}  \\
v(t)
\end{pmatrix} = \begin{pmatrix}
-\frac{k}{M}a-\frac{f}{M}v + \frac{1}{M}F(t) \\
v(t)
\end{pmatrix} $$
$$\boxed{\dot{X}(t)= \begin{pmatrix}
-\frac{f}{M}&-\frac{k}{M} \\
1&0
\end{pmatrix}\begin{pmatrix}
v \\
a
\end{pmatrix} + \begin{pmatrix}
\frac{1}{M} \\
0
\end{pmatrix}F(t)}$$
on veut mesurer : 
$$\boxed{Y = \begin{pmatrix}
0&1
\end{pmatrix}\begin{pmatrix}
v \\
a
\end{pmatrix}}$$



## 2.
Comme : 
$$pX(p) = AX(p) + BU$$
$$Y(p) = CX + DU$$
Alors, 
$$X(p) = (pI-A)^{-1} BU$$
Ainsi : 
$$\boxed{H(p) = Y(p)U^{-1}(p) = C(pI-A)B + D}$$

$$H(p) = C(pI-A)^{-1} B$$
$$(pI-A)^{-1} = \frac{1}{p^{2}+\frac{f}{M}+\frac{k}{M}} \begin{pmatrix}
p&-\frac{k}{M} \\
1&p+\frac{f}{M}
\end{pmatrix}$$

$$\boxed{H(p) = \frac{\frac{1}{M}}{p^{2}+\frac{f}{M}p+\frac{k}{M}}}$$

## 3. Commande modale par retour d'état
### a.

