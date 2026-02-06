## Capteur
Le capteur à un temps de retard $T_{capt}$ et ainsi, on modélise la réponse du capteur en tension comme ceci : 
$$\boxed{\frac{T_{capt}}{3} \frac{dV_{capt}}{dt} + V_{capt}(t) =  G_{capt}(D_{1} -2R - y)}$$

## Micro-turbine
La micro-turbine est pilotée par la tension $U$ la poussée débute à $U_{\min}$ : 
$$\begin{cases}
\frac{T_{turb}}{3} \frac{d F_{turb}}{dt} + F_{turb}=0&\text{si } 0 \leq U \leq U_{\min} \\
\boxed{\frac{T_{turb}}{3} \frac{d F_{turb}}{dt} + F_{turb}=G_{turb}(U-U_{\min})}&\text{si } U_{\min} \leq U 
\end{cases}$$

## Modélisation de la balle
On applique le PFD à la balle : 
$$M \ddot{y} = F_{turb} - Mg - \lambda_{v} \dot{y} - \lambda_{a} \mathrm{sgn}(\dot{y}) \dot{y}^{2} + F_{pert}$$

EXCAL

## 2.
On regarde le nombre d'entrée du système alors on pose : 
$$U = \begin{pmatrix}
U_{turb} \\
F_{pert} - Mg
\end{pmatrix}$$
On regarde maintenant les états variables du système : 
$$X = \begin{pmatrix}
F_{turb} \\
v_{balle} \\
y_{balle} \\
V_{capteur}
\end{pmatrix}$$
Ainsi,  la sortie du système est : 
$$Y = CX + DU = V_{capteur} \text{ Donc } C = \begin{pmatrix}
0&0&0&1
\end{pmatrix}$$

Alors,on souhaite résoudre les équations : 
$$\begin{cases}
X' = AX + BU \\
Y = CX
\end{cases}$$
$$ X' = \begin{pmatrix}
-\frac{3}{T_{turb}}&0&0&0 \\
\frac{1}{M}& - \frac{\lambda_{v}}{M}& 0 & 0 \\
0 & 1 & 0 & 0 \\
0 & 0 & \frac{3G_{capt}}{T_{capt}}  & -\frac{3}{T_{capt}}
\end{pmatrix} X + \begin{pmatrix}
\frac{3G_{turb}}{T_{turb}} & 0 \\
0 & \frac{1}{M} \\
0 & 0 \\
0 & 0
\end{pmatrix} U$$

Donc pour résoudre ce système, on applique la transformée de Laplace :
$$\begin{cases}
pX(p) = AX(p) + BU(p) \\
Y(p) = CX(p) + DU(p)
\end{cases}$$
$$ \Leftrightarrow  \begin{cases}
(pI_{n}-A)X(p) = BU(p) \\
\dots
\end{cases} $$
$$\Leftrightarrow \begin{cases}
X(p) = (pI_{n} - A)^{-1} B\,U(p) \\
\dots 
\end{cases}$$


$$\frac{V_{capt}}{U_{turb}} = H(p) = \frac{G_{turb}}{\frac{T_{turb}}{3}p + 1} \times \frac{1}{Mp + \lambda_{v}}\times \frac{1}{p}\times \frac{G_{capt}}{\frac{T_{capt}}{3} p+ 1}$$

$$\begin{array}{rl}
20\log(\left| H(p)\right|) &= 20&\log&\left( \frac{G_{turb}G_{capt}}{\lambda_{v}p} \right)  \\
&- 10&\log&\left( \left( 1+\left( \frac{T_{turb}}{3}p \right)^{2} \right.\right)&\text{ffff} \\
&&&\left( 1 + \left( \frac{M}{\lambda_{v}}p \right)^{2} \right) \\
&&&\left.\left( \frac{T_{capt}}{3}p +1\right)\right)
\end{array}$$

