#### Equation de la chaleur
On a un système d'ordre $1$ :
$$H_{enc}(p) = \frac{1}{1+\tau p}$$
$$H_{enc}(p) = \frac{TL[T_{enc}(t)]}{TL[T_{act}(t)]+TL[T_{capt}(t)]} = \frac{1}{1+\tau p}$$
$$TL[T_{capt}(t)] = \frac{G_{enc}TL[T_{act }(t)]}{1+\tau p}$$
$$(1+\tau p)TL[T_{capt}(t)] = TL[G_{enc}T_{act}(t)]$$


L'équation de la chaleur dans ce système d'ordre $1$ est : 
$$\tau \frac{\partial T_{enc}}{\partial t} + T_{enc} = G_{enc}(T_{capt} + T_{act}) =T_{capt}+T_{act}$$
L'entrée est : 
$$\dot{x} = Ax + Bu \text{ et } y = Cx + Du$$
$$\begin{cases}
u(t) = T_{act}(t)+T_{capt}(t) \\
x(t) = T_{enc}(t) \\
y(t) = T_{enc}(t)
\end{cases}$$
Ainsi, 
$$\boxed{\begin{cases}
A = -2\\
B = 2 \\
C = 1 \\
D = 0
\end{cases}}$$
