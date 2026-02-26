# I - Filtre passif non chargé
## 1. Préliminaires
#### Méthode des $9$ carreaux
Si on découpe verticalement une période (ou une demi-période pour plus de précision) en $9$ divisions alors, on obtiens pour chaque section un angle de $\boxed{\frac{2\pi}{9} \text{ rad} = 40°}$ ($20°$ pour une demi période)
Puis on calcule le nombres de divisions entre le premier et le deuxième signal. 
On le multiplie ensuite par l'angle d'une division pour obtenir le déphasage entre les deux signaux. 
![[Pasted image 20260226160816.png]]



#### Méthode de Lissajous
Soit deux signaux sinusoïdaux : 
$$\begin{cases}
f(t) = A\sin(f_{0}t) \\
g(t) = B\sin(f_{1}t + \varphi)
\end{cases}$$
![[Pasted image 20260226163921.png]]

On définit alors $x = f(t)$ en abscisse et $y = g(t)$ en ordonnés
![[Pasted image 20260226163938.png]]
On mesure alors la hauteur totale de l'ellipse : $H$ 
et la hauteur à l'intérieur de l'ellipse au centre (Mesure des deux points issus de l'intersection entre l'ellipse et l'ordonnée) : $h$
On a ainsi :
$$\boxed{\sin(\varphi) = \frac{h}{H}}$$

## 2. Fonction de Transfert
![[Pasted image 20260226173038.png]]
### a. Fonction de transfert
#### Gabarit et ordre du filtre
En Basse fréquence : 
![[Pasted image 20260226172105.png]]
$V_{s} = 0 \, V$

En haute fréquence : 
![[Pasted image 20260226172151.png]]
$V_{s} = 0 \, V$

Comme on a un condensateur et une bobine, le filtre est donc : 
$$\boxed{\text{Un filtre passe bande d'ordre 2}}$$

#### Fonction de transfert
On applique la loi des nœuds :
$$i_{e} = i_{L} + i_{1} \Leftrightarrow C  \frac{du_{c}}{dt} = i_{L} + \frac{u_{R_{1}}}{R_{1}}$$
$$\Leftrightarrow  \boxed{CLR_{1} \frac{d^{2}u_{C}}{dt^{2}} = R_{1}u_{L} + L \frac{du_{R_{1}}}{dt} }$$
On applique la loi des mailles sur celle de droite : 
$$V_{s} + u_{L} = u_{R_{1}}$$
On applique la loi des mailles sur celle de gauche : 
$$V_{e} = u_{R_{1}} + u_{C}$$
Alors, 
$$\boxed{V_{e} = V_{s} + u_{L} + u_{C}}$$
Par la loi d'ohm : 
$$V_{s} = R_{2}i_{L} \Leftrightarrow \boxed{u_{L} = \frac{L}{R_{2}}\frac{dV_{s}}{dt}}$$

Donc par l'équation $2$ et $3$ puis en appliquant la transformée de Laplace : 
$$V_{e} = V_{s} + \frac{L}{R_{2}}p V_{s}+u_{C} \Leftrightarrow \boxed{u_{C} = V_{e} - \left( 1+\frac{L}{R_{2}}p \right)V_{s}}$$

De plus, en appliquant la transformée de Laplace puis les équations encadrées numéro $1$ et $2$ :
$$R_{1}LC p^{2} u_{C} = R_{1}u_{L} + Lp(V_{s}+ u_{L})$$
$$\Leftrightarrow R_{1}LCp^{2} u_{C} = (R_{1}+Lp)u_{L} + LpV_{s}$$
Donc en injectant la $3^{eme}$ et $4^{eme}$ équation encadrée on obtiens : 
$$R_{1}LCp^{2}\left( V_{e} - \left( 1+\frac{L}{R_{2}}p \right)V_{s} \right) = (R_{1}+Lp) \frac{L}{R_{2}}pV_{s} +LpV_{s}$$
Alors, 
$$R_{1}Cp V_{e} - R_{1}Cp\left( 1+\frac{L}{R_{2}}p \right)V_{s} = \left( \frac{R_{1}+R_{2}+Lp}{R_{2}}\right)V_{s}$$
Alors, 
$$V_{s}\left( \frac{R_{1}+R_{2}}{R_{2}} + \left( R_{1}C+ \frac{L}{R_{2}}  \right)p + \frac{R_{1}LC}{R_{2}}p^{2} \right) = R_{1}CpV_{e}$$
Donc, 
$$H_{1}(p) = \frac{V_{s}}{V_{e}} = \frac{R_{1}Cp}{\frac{R_{1}+R_{2}}{R_{2}} + \left( R_{1}C + \frac{L}{R_{2}} \right)p + \frac{R_{1}LC}{R_{2}} p^{2}}$$
Ainsi, 
$$\boxed{H_{1}(p) = \frac{\frac{R_{1}R_{2}}{R_{1}+R_{2}}Cp}{1+\frac{R_{1}R_{2}C + L}{R_{1}+R_{2}} p + \frac{R_{1}LC}{R_{1}+R_{2}}p^{2}}}$$
Donc, 
$$\boxed{\omega_{0} = \sqrt{\frac{R_{1}+R_{2}}{R_{1}LC}}}$$
De plus, 
$$\frac{2m}{\omega_{0}} = \frac{R_{1}R_{2}C+L}{R_{1}+R_{2}} \Leftrightarrow \boxed{m =\frac{R_{1}R_{2}C+L}{2\sqrt{(R_{1}+R_{2})(R_{1}LC)}}}$$
$$\frac{H_{10}}{\omega_{0}} = \frac{R_{1}R_{2}}{R_{1}+R_{2}}C\Leftrightarrow \boxed{H_{10} = R_{2}C\sqrt{\frac{\frac{R_{1}}{LC}}{R_{1}+R_{2}}}}$$

#### Ecriture de la fonction de transfert sous une autre forme
$$H_{1}(j\omega) = \frac{H_{10}j \frac{\omega}{\omega_{0}}}{1+2mj \frac{\omega}{\omega_{0}} - \frac{\omega^{2}}{\omega_{0}^{2}}} = \frac{H_{10}}{j\left( \frac{\omega}{\omega_{0}}-\frac{\omega_{0}}{\omega} \right) +2m} $$
Ainsi, 
$$\boxed{H_{1}(j\omega)= \frac{\frac{H_{10}}{2m}}{1+j \frac{1}{2m}\left(\frac{\omega}{\omega_{0}}- \frac{\omega_{0}}{\omega} \right)}}$$
$$\boxed{H_{m} = \frac{H_{10}}{2m}}$$
$$\boxed{Q = \frac{1}{2m}}$$

Pertinence de la forme de la fonction de transfert :
$$\boxed{\begin{cases}
\text{On peut voir directement la résonnance à }\omega = \omega_{0} \\
\text{Le module est plus simple à calculer que la précédente}
\end{cases}}$$

### b. Etude de la fonction de transfert
#### Gain maximum
$$G_{dB}(\omega) = 20\log(\left| H_{1}(j\omega)\right|)$$
$$ = 20\log(H_{m}) - 10\log\left( 1+Q^{2}\left( \frac{\omega}{\omega_{0}}-\frac{\omega_{0}}{\omega} \right)^{2} \right)$$
On calcule alors la dérivée du terme dans le logarithme : 
(car si ce terme croit comme log est monotone alors $G_{dB}$ décroit) : 
$$2Q^{2}\left( \frac{1}{\omega_{0}} \right)\left( \frac{\omega}{\omega_{0}}-\frac{\omega_{0}}{\omega} \right)$$