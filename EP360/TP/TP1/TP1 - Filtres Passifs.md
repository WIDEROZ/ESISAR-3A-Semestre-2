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
$$i_{e} = i_{L} + i_{1} \Leftrightarrow C  \frac{du_{c}}{dt} = i_{L} + \frac{u_{R_{1}}}{R_{1}}\Leftrightarrow  CLR_{1} \frac{d^{2}u_{C}}{dt^{2}} = R_{1}u_{L} + Lu_{R_{1}}$$
On applique la loi des mailles sur celle de droite : 
$$V_{s} + u_{L} = u_{R_{1}}$$
On applique la loi des mailles sur celle de gauche : 
$$V_{e} = u_{R_{1}} + u_{C}$$
Par la loi d'ohm : 
$$V_{s} = R_{2}i_{L}$$
Alors, 
$$V_{s} =R_{2}L \frac{du_{L}}{dt} = R_{2}L\left( \frac{du_{R_{1}}}{dt} - \frac{dV_{s}}{dt} \right)$$
$$= R_{2}L\left( \frac{dV_{e}}{dt} - \frac{du_{C}}{dt} - \frac{dV_{s}}{dt} \right) = R_{2}L\left( \frac{dV_{e}}{dt} - C \frac{d^{2}i_{e}}{dt^{2}} - \frac{dV_{s}}{dt}  \right)$$
