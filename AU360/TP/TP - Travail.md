#### Equation de la chaleur
D'après la fonction de transfert en préparation : 
$$H_{enc}(p) = \frac{TL[V_{capt}(t)]}{TL[V_{act}(t)]} = \frac{1}{1+p \tau}$$
Alors, 
$$TL\left[ V_{capt}(t) + \tau \frac{d V_{cap t}(t)}{dt}  \right] = TL[V_{act}(t)]$$
Donc, 
$$\tau\frac{dV_{capt}(t)}{dt} + V_{capt}(t) = V_{act}(t) \Leftrightarrow \frac{dV_{capt}(t)}{dt} =\tau(V_{act}(t) -V_{capt}(t)) $$
Ainsi, 
$$\boxed{\begin{cases}
A = -2\\
B = 2 \\
C = 1 \\
D = 0
\end{cases}}$$
