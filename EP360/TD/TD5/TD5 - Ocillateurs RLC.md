# II - Montage 1
## 1. Etude en boucle ouverte
#### Ampli non-inverseur
$$A = \frac{V_{2}}{V_{e}} =  \frac{V_{2}-V_{e} + V_{e}}{-i_{e}R_{2}} = \frac{-R_{1}i_{e} -R_{2}i_{e}}{-R_{2}i_{e}} = \frac{R_{1}+R_{2}}{R_{2}}$$
Ainsi, 
$$\boxed{A = \frac{R_{1}+R_{2}}{R_{2}}}$$

#### Filtre passe bande
$$B = \frac{V_{1}}{V_{2}} $$
On calcule $Y_{eq} = \frac{1}{Z_{eq}}$ : 
$$\frac{1}{Z_{eq}} = pC + \frac{1}{R} + \frac{1}{pL}$$

On applique un pont diviseur de tension : 
$$V_{1} = \frac{Z_{eq}}{Z_{eq}+P}V_{2} = \frac{1}{1+\frac{ \rho }{Z_{eq}}} = \frac{1}{1+ \rho \left( pC + \frac{1}{R}+ \frac{1}{pL} \right)}V_{2}$$
Ainsi : 
$$\boxed{B = \frac{1}{1+ \rho \left( pC + \frac{1}{R}+ \frac{1}{pL} \right)}}$$

#### Fonction de transfert
$$\boxed{H(p) = \frac{V_{1}}{V_{e}} = AB = \frac{1+\frac{R_{1}}{R_{2}}}{1+\frac{\rho}{R} +j\rho\left( \omega C - \frac{1}{\omega L} \right)}}$$


## 2. Etude en boucle fermée
$$\boxed{H(j\omega_{osc}) = \frac{V_{1}}{V_{e}} = 1}$$
car $V_{1}  = V_{e}$ 

#### Critère de Barkhausen
###### Choix de la fréquence d’oscillation
$$\mathrm{Im}(H(j\omega_{osc})) = \mathrm{Im}(1) = 0$$
Alors, 
$$\omega_{osc} = \frac{1}{\sqrt{LC}} = \omega_{0}$$
##### Démarrage
$$\left| H(j\omega_{osc}) \right| > 1$$
$$\Leftrightarrow \left| H(j\omega_{osc})\right| = \frac{1+ \frac{R_{1}}{R_{2}}}{1+\frac{\rho}{R}} >1$$
$$\Leftrightarrow \boxed{\rho < R\frac{R_{1}}{R_{2}}}$$


# II - Montage 2
## Filtre
$$B = \frac{V_{e}}{V_{s}}$$
On utilise la théorie des quadripôles : 
On à $3$ cellules identiques $Q$ (cell. $RC$)
On prend la matrice chaîne : 
$$\begin{pmatrix}
V_{1} \\
i_{1}
\end{pmatrix} = \begin{pmatrix}
k_{1, 1}&k_{1, 2} \\
k_{2, 1}&k_{2, 2}
\end{pmatrix}\begin{pmatrix}
V_{2} \\
-i_{2}
\end{pmatrix} = Q \begin{pmatrix}
V_{2} \\
-i_{2}
\end{pmatrix}$$
$$k_{1, 1} = \left. \frac{V_{1}}{V_{2}} \right)_{i_{2}=0} = \frac{pRC+1}{pRC}$$
$$k_{2, 1} = \left. \frac{i_{1}}{V_{2}} \right)_{i_{2}=0} = \frac{1}{R}$$
$$k_{1, 2} = \left. \frac{V_{1}}{-i_{2}} \right)_{V_{2}=0} = \frac{V_{1}}{i_{1}} = \frac{1}{pC}$$
$$k_{2,2} = \left. -\frac{i_{1}}{i_{2}} \right)_{V_{2}=0} = 1$$

Ainsi : 
$$\boxed{Q = \begin{pmatrix}
 \frac{pRC+1}{pRC}& \frac{1}{pC} \\
 \frac{1}{R}&1
\end{pmatrix}}$$

Ainsi, 
$$\begin{pmatrix}
V_{s} \\
i_{s}
\end{pmatrix} = Q^{3}\begin{pmatrix}
V_{e} \\
-i_{e}
\end{pmatrix}$$
$$Q^{2} = \begin{pmatrix}
\left( \frac{pRC+1}{pRC} \right)^{2} + \frac{1}{pRC}& \frac{pRC+1}{p^{2}RC^{2}} +\frac{1}{pC} \\
\frac{pRC+1}{pR^{2}C}+\frac{1}{R}& \frac{1}{pRC} +1
\end{pmatrix}$$
On ne désire que le premier coefficient $K$ de la matrice $Q^{3}$ : 
$$V_{s} = K V_{e}$$
Alors, 
$$\frac{V_{e}}{V_{s}} = \frac{1}{K}$$
Donc comme : 
$$K =  \left( \frac{pRC+1}{pRC} \right)^{3} + \frac{1}{pRC}\frac{pRC+1}{pRC}+\frac{pRC+1}{p^{2}R^{2}C^{2}} +\frac{1}{pRC}$$
$$= \frac{1}{(pRC)^{3}}((1+pRC)^{3} + 3(pRC)^{2}+2pRC)$$
$$= \frac{1}{(pRC)^{3}}(1 + 3pRC + 3(pRC)^{2}+(pRC)^{3} + 3(pRC)^{2} + 2pRC)$$
$$= \frac{1}{(pRC)^{3}}(1+5pRC + 6(pRC)^{2} + (pRC)^{3})$$

Ainsi : 
$$\boxed{B(p) = \frac{(pRC)^{3}}{1+5pRC + 6(pRC)^{2} + (pRC)^{3}}}$$

#### Oscillation en boucle fermée
##### Fréquence d'oscillation
$$\boxed{B(p) = \frac{-j(\omega RC)^{3}}{1+j5\omega RC - 6(\omega RC)^{2} -j (\omega RC)^{3}}} \times \frac{j}{j}$$
Comme $\mathrm{Im}(B(j\omega_{c})) = 0$

