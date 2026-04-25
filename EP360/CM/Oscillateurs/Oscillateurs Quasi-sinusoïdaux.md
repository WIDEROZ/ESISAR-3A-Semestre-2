### Définitions
#### Bruit blanc
Bruit qui possède une amplitude pour chaque fréquence. 

#### Critère de Barkhausen
On prend une entrée nulle : 
![[Pasted image 20260414112606.png]]
On observe alors une sortie finie. 
$$H(p) = \frac{V_{s}}{V_{e}} = \frac{A}{1+AB}$$
$$\boxed{\begin{array}{cl}
A(p)B(p) = -1  &\Leftrightarrow& \begin{cases}
\mathrm{Re}(A(j\omega_{osc}) B(j\omega_{osc})) = -1 \\
\mathrm{Im}(A(j\omega_{osc}) B(j\omega_{osc})) = 0
\end{cases} \\
&\Leftrightarrow&\begin{cases}
\left| A(j\omega_{osc}) B(j\omega_{osc})\right| = 1 \\
\arg(A(j\omega_{osc})B(j\omega_{osc})) = \pm \pi
\end{cases}
\end{array}}$$
Ce critère est impossible a obtenir rigoureusement, c'est pourquoi on a deux cas : 
$$\begin{cases}
\left| A(j\omega_{osc})B(j\omega_{osc})\right| = 1+ \varepsilon > 1 \\
\left| A(j\omega_{osc})B(j\omega_{osc})\right| = 1- \varepsilon < 1
\end{cases}$$

#### $1^{\text{er}}$ cas : $\left| A(j\omega_{osc})B(j\omega_{osc})\right| = 1+ \varepsilon > 1$
Le système est instable il sera amplifié à chaque passage dans la boucle à cause de : $\frac{A}{1+AB}$

#### $1^{\text{eme}}$ cas : $\left| A(j\omega_{osc})B(j\omega_{osc})\right| = 1- \varepsilon < 1$
Le système est stable car il sera amplifié à chaque passage dans la boucle de

