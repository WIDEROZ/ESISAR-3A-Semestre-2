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
$$z_{1, 2} = \frac{V_{2}}{i_{2}} = \frac{Z_{2}-Z_{2}}{2} $$


#### 2. Fonction de transfert du quadripôle à vide
$$$$
