# Exercice ?
#### 1. Calcul de la matrice d'impédance
EXCAL 1, 2

$$\begin{pmatrix}
V_{1} \\
V_{2}
\end{pmatrix} = Z\begin{pmatrix}
i_{1}  \\
i_{2}
\end{pmatrix}$$
Calcul de $z_{1, 1}$ : $i_{2} = 0$
$$z_{1, 1} = \frac{V_{1}}{i_{1}} = \frac{Z_{1}+Z_{2}}{2}$$

Calcul de $z_{2, 1}$ : $i_{2} = 0$
Par la loi des mailles : 
$$Z_{1}  \frac{i_{1}}{2} + V_{2}= Z_{2} \frac{i_{1}}{2}$$
$$z_{2, 1} = \frac{V_{2}}{i_{1}} = \frac{Z_{2}-Z_{1}}{2}$$
Calcul de $z_{1, 2}$ : $i_{1} = 0$, 
$$z_{1, 2} = \frac{V_{1}}{i_{2}} = \frac{Z_{2}-Z_{1}}{2} $$

Calcul de $z_{2, 2}$ : $i_{1} = 0$, 
$$z_{2, 2} = \frac{V_{2}}{i_{2}} = \frac{Z_{2}+Z_{1}}{2} $$

$$\boxed{Z = \begin{pmatrix}
\frac{Z_{1}+Z_{2}}{2} & \frac{Z_{2}-Z_{1}}{2}\\
\frac{Z_{2}-Z_{1}}{2}&\frac{Z_{1}+Z_{2}}{2}
\end{pmatrix}}$$


#### 2. Fonction de transfert du quadripôle à vide
A vide : $i_{2}  = 0$ 
$$\begin{pmatrix}
V_{1} \\
V_{2}
\end{pmatrix} = \begin{pmatrix}
z_{1, 1}i_{1} \\
z_{2, 1}i_{1}
\end{pmatrix}$$
$$\boxed{H = \frac{V_{2}}{V_{1}} = \frac{z_{2, 1}}{z_{1, 1}}}$$

#### 3. Forme canonique
$$Z_{1} = R+Lp \text{ et } \frac{1}{Y_{2}} = Z_{2} = \frac{1}{Cp}$$
$$H(p) = \frac{Z_{2}-Z_{1}}{Z_{1}+Z_{2}} = \frac{\frac{1}{Cp}-R-Lp}{\frac{1}{Cp} + R+Lp}$$
$$\boxed{H(\omega)= \frac{1-RCp-LCp^{2}}{1+RCp+LCp^{2}} = \frac{1-\frac{2m}{\omega_{0}}j\omega + \left( \frac{\omega}{\omega_{0}} \right)^{2}}{1+\frac{2m}{\omega_{0}}j\omega - \left( \frac{\omega}{\omega_{0}} \right)^{2}}}$$
Avec : 
$$\omega_{0} = \frac{1}{\sqrt{LC}} \text{ et } m = \frac{1}{2}  R \sqrt{\frac{C}{L}}$$


#### 4. Diagramme de Bode
EXCAL 3

$$H(p) = \frac{1}{ 1+\frac{2m}{\omega_{0}} p + \frac{p^{2}}{\omega_{0}^{2}}}\left( 1-\frac{2m}{\omega_{0}} p - \frac{p^{2}}{\omega_{0}^{2}} \right)$$
Numérateur : Vert
Dénominateur : Bleu
Fonction : Rouge

# Exercice 8
#### 1.
EXCAL 4
AOP en mode linéaire (rétroaction négative)
$$\begin{cases}
i_{3} = C_{1} \frac{dV_{2}}{dt} \\
i_{2} = C_{2} \frac{d(V_{a} - V_{2})}{dt} \\
i_{1} = \frac{V_{1}-V_{a}}{R_{1}} \\
i_{1} = i_{2} + i_{3} \\
i_{3} = \frac{V_{a}-V_{2}}{R_{2}}
\end{cases}$$
Alors, on applique la transformée de laplace : 
$$\begin{cases}
i_{3} = C_{1}pV_{2} \\
i_{2} = C_{2} p(V_{a}-V_{2}) \\
i_{1} = \frac{V_{1}-V_{a}}{R_{1}} \\
i_{1} = i_{2} + i_{3} \\
i_{3} = \frac{V_{a}-V_{2}}{R_{2}}
\end{cases}$$
$$\frac{V_{a}-V_{2}}{R_{2}} = C_{1}pV_{2} \Leftrightarrow V_{a} = R_{2}C_{1}pV_{2} + V_{2}$$
Alors, 
$$\frac{V_{1}-(R_{2}C_{1}p+1)V_{2}}{R_{1}} = C_{2}p(R_{2}C_{1}p )V_{2}+ C_{1}pV_{2}$$
Donc, 
$$V_{1}  = (R_{1}R_{2}C_{1}C_{2}p^{2} + R_{1}C_{1}p + C_{1}R_{2}p +1)V_{2}$$
Ainsi, 
$$T(p) = \frac{V_{2}}{V_{1}} = \frac{1}{R_{1}R_{2}C_{1}C_{2}p^{2} + R_{1}C_{1}p + C_{1}R_{2}p +1}$$
$$\boxed{T(p)= \frac{1}{1+ (R_{1}+R_{2})C_{1}p + R_{1}R_{2}C_{1}C_{2}p^{2}}}$$
On pose alors, 
$$\omega_{0} = \frac{1}{\sqrt{R_{1}R_{2}C_{1}C_{2}}}$$

et 
$$ m =  \frac{(R_{1}+R_{2})C_{1}}{2}\omega_{0} = (R_{1}+R_{2}) \sqrt{\frac{C_{1}}{R_{1}R_{2}C_{2}}}$$
et
$$u = \frac{\omega}{\omega_{0}} = \omega\sqrt{R_{1}R_{2}C_{1}C_{2}}$$
Ainsi, 
$$\boxed{T(ju) = \frac{1}{1+ 2mju - u^{2}}}$$

