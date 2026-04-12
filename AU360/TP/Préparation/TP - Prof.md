
#### Donnés
On a un retard max de $15$ ms et et un retard min (min????) de $20$ ms alors le retard total est de $L = 35$ms
$$M_{\varphi} \geq 45° \text{ et } M_{M}  \geq 0.5 \text{ et } M_{r} = 3 \times L$$
Avec $L$ le retard total. 
___
$$\left| C(p)\right| \leq N_{\max} = 5$$
#### Tests a faire selon le cahier des charges
###### a. On traite la commande
On applique un échelon de température $Y_{C}(t)$ en commande avant $F$ puis on regarde la sortie $Y(t)$

###### b. On traite $P_{u}$ et $P_{y}$
$C$ doit contenir un intégrateur
Le gain statique de $F$ doit être égal à $1$
Si on applique un échelon de température $Y_{C}(t)$ en commande avant $F$ et que l'on regarde la sortie $Y(t)$, la différence : $Y_{c}(t)- Y(t)\underset{}{\longrightarrow} 0$.

###### c. On traite le bruit
$$\left| C(p)\right| \leq_{\omega \to \infty} N_{\max} = \frac{\left| U_{b}\right|}{\left| P_{b}\right|} = \frac{0.5}{0.1} = 5$$
$$Y_{C} = cte \underset{}{\longrightarrow} \text{mesure de } \left| U_{b}\right| $$

###### d. On traite $P_{y}$
Diagramme de Bode, Nyquist, Black-Nichols sur le calculateur

###### e. On traite $P_{u}$
On fais un échelon sur $P_{u}$ et on regarde la sortie $Y_{C}(t)= cte$ 
$$\min \left|\left| \frac{Y}{P_{u}} \right|\right|_{H_{2}} $$


# 20/03
$$H(p) = \frac{B(p)}{A(p)} = \frac{4.6}{p+2}$$
$$C(p) = \frac{R(p)}{S(p)} = \frac{r_{0}+r_{1}p}{p}$$
De plus dans le cours : 
$$D(p) -A(p)S(p) + B(p) R(p) = 0$$
$$D(p) = (p+2)p + 4.6(r_{0}+r_{1}p)$$
$$D(p) = p^{2} + (2+4.6r_{0})p + 4.6r_{1}$$
Or : 
$$D_{désiré} (p) = (p+\omega_{0})^{2} = p^{2} + 2\omega_{0}p + \omega_{0}^{2}$$
Alors, 
$$r_{0} = \frac{2\omega_{0} -2}{4-6} \text{ et } r_{1} = \frac{\omega_{0}^{2}}{4.6}$$

Si $r_{0}=5$ alors, $\omega_{0} =12.5 \text{ rad.s}^{-1}$
Ainsi, 
$$r_{1} = 3.4$$

3.95