# Exercice 1
## 1.
![[Pasted image 20260422085223.png]]
![[Pasted image 20260422090502.png]]

## 2.
On a une causalité dérivée pour $\omega$ :  
![[Pasted image 20260422091250.png]]

## 3.
![[Pasted image 20260422091446.png]]
La causalité ne change pas ça ne pose pas de problèmes car on exprime toujours la force en fonction de la vitesse.

# Exercice 2
![[Pasted image 20260422092157.png]]
## 1.
![[Pasted image 20260422093124.png]]

## 2.
Classe 3 car on a forcément une causalité dérivée. (Feur)

## 3.
$$\begin{pmatrix}
\dot{p}_{5} \\
\dot{p}_{10} \\
\dot{q}_{12}
\end{pmatrix} = \begin{pmatrix}
\cdot & \cdot & \cdot \\
\cdot & \cdot & \cdot \\
\cdot & \cdot & \cdot
\end{pmatrix}\begin{pmatrix}
p_{5} \\
p_{10} \\
q_{12}
\end{pmatrix} + \begin{pmatrix}
\cdot&\cdot \\
\cdot&\cdot \\
\cdot&\cdot
\end{pmatrix}\begin{pmatrix}
e(t) \\
v_{i}(t)
\end{pmatrix}$$

# Exercice 6
![[Pasted image 20260422095227.png]]
## 1.
Le Bond est un classe $1$ alors le nombre de variables d'énergies est égal au nombre de sorties (sans dissipations) : $\boxed{4}$ 

## 2.
On cherche à determiner les efforts/flows suivants :
$$\begin{pmatrix}
e_{5} \\
f_{7} \\
e_{10} \\
f_{12}
\end{pmatrix} = \begin{pmatrix}
\dot{p}_{5} \\
\dot{q}_{7} \\
\dot{p}_{10} \\
\dot{q}_{12}
\end{pmatrix} = f\left(\begin{pmatrix}
{p}_{5} \\
{q}_{7} \\
{p}_{10} \\
{q}_{12}
\end{pmatrix}, e(t)\right)$$
Alors, comme : 
$$f_{5} = \frac{\partial H}{\partial p_{5}}(p_{5}) = \frac{p_{5}(t)}{J_{m}} $$
$$e_{7} = \frac{\partial H}{\partial q_{7}}(q_{7})= k_{T}q_{7}(t) $$
$$e_{10}=\frac{\partial H}{\partial p_{10}} (p_{10}(t)) = \frac{p_{10}(t)}{m}$$
$$f_{12} = \frac{\partial H}{\partial q_{12}}(q_{12}(t)) = kq_{12}(t) $$
Donc, 
$$\dot{p}_{5} = e_{5} = e_{4}-e_{6} = \dots = \frac{T}{R_{\omega}}\left(e(t) -\frac{T}{J_{m}}p_{5}(t) \right)-k_{T}q_{7}$$
Ainsi, 
$$\begin{pmatrix}
e_{5} \\
f_{7} \\
e_{10} \\
f_{12}
\end{pmatrix} = \begin{pmatrix}
\dot{p}_{5} \\
\dot{q}_{7} \\
\dot{p}_{10} \\
\dot{q}_{12}
\end{pmatrix} = \begin{pmatrix}
-\frac{T^{2}}{J_{m}R_{\omega}}&-k_{T}&0&0 \\
\cdot&\cdot&\cdot&\cdot \\
\cdot&\cdot&\cdot&\cdot \\
\cdot&\cdot&\cdot&\cdot
\end{pmatrix}\begin{pmatrix}
{p}_{5} \\
{q}_{7} \\
{p}_{10} \\
{q}_{12}
\end{pmatrix}+ \begin{pmatrix}
\frac{T}{R_{\omega}} \\
\cdot \\
\cdot \\
\cdot
\end{pmatrix} e(t)$$
