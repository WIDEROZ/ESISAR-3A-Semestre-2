# Introduction
On étudie ici les caractéristiques de retard d'un filtre passif RLC parallèle série, plus précisément un filtre passe bande. 
En premier lieu l'étude nous aura mené à calculer les caractéristiques fréquentielles de ce filtre, notamment sa fonction de transfert puis son diagramme de Bode avec ses pulsations caractéristiques associés.


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
###### En Basse fréquence
![[Pasted image 20260226172105.png]]
On a alors $V_{s} = 0 \, V$

###### En haute fréquence
![[Pasted image 20260226172151.png]]
On a alors $V_{s} = 0 \, V$

Comme on a deux composants actifs, le filtre est donc : 
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
$$R_{1}LC p^{2} u_{C} = R_{1}u_{L} + Lp(V_{s}+ u_{L})= (R_{1}+Lp)u_{L} + LpV_{s}$$
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
$$\boxed{\omega_{0} = \sqrt{\frac{R_{1}+R_{2}}{R_{1}LC}} = 447 \, kHz}$$
De plus, 
$$\frac{2m}{\omega_{0}} = \frac{R_{1}R_{2}C+L}{R_{1}+R_{2}} \Leftrightarrow \boxed{m =\frac{R_{1}R_{2}C+L}{2\sqrt{(R_{1}+R_{2})(R_{1}LC)}}=0.763}$$
$$\frac{H_{10}}{\omega_{0}} = \frac{R_{1}R_{2}}{R_{1}+R_{2}}C\Leftrightarrow \boxed{H_{10} = R_{2}C\sqrt{\frac{\frac{R_{1}}{LC}}{R_{1}+R_{2}}} = 1.05}$$


#### Ecriture de la fonction de transfert sous une autre forme
$$H_{1}(j\omega) = \frac{H_{10}j \frac{\omega}{\omega_{0}}}{1+2mj \frac{\omega}{\omega_{0}} - \frac{\omega^{2}}{\omega_{0}^{2}}} = \frac{H_{10}}{j\left( \frac{\omega}{\omega_{0}}-\frac{\omega_{0}}{\omega} \right) +2m} $$
Ainsi, 
$$\boxed{H_{1}(j\omega)= \frac{\frac{H_{10}}{2m}}{1+j \frac{1}{2m}\left(\frac{\omega}{\omega_{0}}- \frac{\omega_{0}}{\omega} \right)}}$$
$$\boxed{H_{m} = \frac{H_{10}}{2m}=0.688}$$
$$\boxed{Q = \frac{1}{2m}=0.655}$$
$$arg(H_{1}) = -\arg\left( 1+j Q\left( \frac{\omega}{\omega_{0}} - \frac{\omega_{0}}{\omega} \right) \right)$$




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
(car si ce terme croit (respectivement décroit) comme log est monotone alors $G_{dB}$ décroit (resp. croit)) i.e. la dérivée s'annulera pour cette fonction en $\omega$ : 
$$2Q^{2}\left( \frac{1}{\omega_{0}} + \frac{\omega_{0}}{\omega^{2}} \right)\left( \frac{\omega}{\omega_{0}}-\frac{\omega_{0}}{\omega} \right)$$
Donc, lorsque $\omega=\omega_{0}$, la dérivée s'annule il y a donc un extremum mais si $\omega < \omega_{0}$ (resp. $\omega > \omega_{0}$) le signe de cette expression est négatif (resp. positif) donc $G_{dB}$ croît (resp. décroît)
$$\boxed{\text{Ainsi }\omega_{0} \text{ est un maximum de }G_{dB}}$$
$$\boxed{G_{dB}(\omega_{0}) = 20\log(H_{m})}$$

#### Fréquences de coupures à $-3dB$
Le gain est à $-\, 3dB$ lorsque : 
$$\left| H_{1}(j\omega_{c})\right| = \frac{H_{m}}{\sqrt{2}}$$
Alors, 
$$ \frac{H_{m}}{\sqrt{2}} =  \frac{H_{m}}{\sqrt{1+Q^{2}\left( \frac{\omega_{c}}{\omega_{0}}-\frac{\omega_{0}}{\omega_{c}} \right)^{2}}}$$
Alors, 
$$\pm\left( \frac{\omega_{c}}{\omega_{0}} - \frac{\omega_{0}}{\omega_{c}} \right) Q = 1 $$
Donc on a : 
$$\pm \omega_{c}^{2} -\frac{\omega_{0}}{Q}\omega_{c}\mp \omega_{0}^{2} = 0$$

On cherche a trouver les solutions de cette équation : 
$$\Delta = \frac{\omega_{0}^{2}}{Q^{2}} - 4(\pm 1)(\mp \omega_{0}^{2}) = \omega_{0}^{2}\left( \frac{1}{Q^{2}}+4 \right)> 0$$
De plus
$$\omega_{c_{1/2}} = \mp\frac{\omega_{0}}{2 }\left( \frac{1}{Q} \pm   \sqrt{\frac{1}{Q^{2}}+4}\right)$$
Alors, comme $\frac{1}{Q} < \sqrt{\frac{1}{Q^{2}}+4}$ : 
$$\boxed{\omega_{c_{1}} = \frac{\omega_{0}}{2}\left( \sqrt{\frac{1}{Q^{2}}+4}-\frac{1}{Q} \right) = 221131 \, Hz \approx 221  kHz}$$
De plus comme $\omega_{c} > 0$ : 
$$\boxed{\omega_{c_{2}} = \frac{\omega_{0}}{2}\left( \sqrt{\frac{1}{Q^{2}}+4} +\frac{1}{Q} \right) = 903574 \approx 904 \, kHz}$$

Ainsi, 
La pulsation centrale est : 
$$\boxed{\omega_{c} = \frac{\omega_{c_{1}}+\omega_{c_{2}}}{2} = \frac{\omega_{0}}{2}\sqrt{\frac{1}{Q^{2}}+4} = 562353 \, Hz \approx 562 \, kHz}$$


#### Bande passante
La bande passante À $-3dB$ est : 
$$\boxed{\Delta \omega = \omega_{c_{2}}-\omega_{c_{1}} = \frac{\omega_{0}}{Q}}$$

#### Pulsations à l'intersection des asymptotes avec l'axe $0dB$

$$ 0 = G_{db}(\omega_{a})  = 20\log\left( \frac{H_{m}}{\sqrt{1+Q^{2}\left( \frac{\omega_{a}}{\omega_{0}}-\frac{\omega_{0}}{\omega_{a}} \right)^{2}}} \right)$$
$$\frac{H_{m}}{\sqrt{1+Q^{2}\left( \frac{\omega_{a}}{\omega_{0}}-\frac{\omega_{0}}{\omega_{a}} \right)^{2}}} = 1$$
Alors, 
$$\frac{1}{Q}\sqrt{H_{m}^{2}-1} =\pm \left( \frac{\omega_{a}}{\omega_{0}}-\frac{\omega_{0}}{\omega_{a}} \right)$$
Par analogie avec les fréquences de coupure : 
En posant : 
$$\boxed{b = \frac{1}{Q}\sqrt{H_{m}^{2}-1}}$$
$$\boxed{\omega_{a_{1}} = \frac{\omega_{0}}{2}(b+\sqrt{b^{2}+4})}$$
$$\boxed{\omega_{a_{2}} = \frac{\omega_{0}}{2}(\sqrt{b^{2}+4}-b)}$$

### c. Diagramme de Bode
#### Diagramme asymptotique de Bode

![[Pasted image 20260227155352.png]]

Comme $1>0$ : 
$$\boxed{\arg(H_{1}) = -\arctan\left( Q\left( \frac{\omega}{\omega_{0}}-\frac{\omega_{0}}{\omega} \right) \right)}$$
On a ainsi : 
![[Pasted image 20260227160043.png]]
En échelle logarithmique $(1\sim10, 2 \sim 10^{2})$

# II - Filtre Chargé
## 1. Préambule
#### Impédance de sortie d'un GBF
A l'idéal : 
$${Z_{GBF} = 0 \Omega}$$
Mais dans la réalité 
$$\boxed{Z_{GBF} \approx 50 \Omega}$$

#### Effet de cette impédance sur la fonction de transfert du filtre
![[Pasted image 20260226201835.png]]
L'impédance de sortie modifie la fonction de transfert elle ajoute une tension parasite de $Z_{GBF}i_{e}$.

## 2. Filtre Chargé
### a. Etude du nouveau filtre
#### Fonction de transfert
On créé une résistance équivalente : 
$$R = \frac{R_{2}R_{u}}{R_{2}+R_{u}}$$
On remplace alors $R_{2}$ par cette résistance $R$
$$\boxed{H_{2}(j\omega)=\frac{H_{m_{u}}}{1+j Q_{u}\left(\frac{\omega}{\omega_{0_{u}}}- \frac{\omega_{0_{u}}}{\omega} \right)}}$$
Avec : 
$$\boxed{H_{m_{u}} = \frac{RC\sqrt{\frac{\frac{R_{1}}{LC}}{R_{1}+R}}}{2\frac{R_{1}RC+L}{2\sqrt{(R_{1}+R)(R_{1}LC)}}}= \frac{RR_{1}C}{R_{1}RC+L}}$$
$$\boxed{Q_{u} = \frac{\sqrt{(R_{1}+R)(R_{1}LC)}}{R_{1}RC+L}}$$
$$\boxed{\omega_{0_{u}} = \sqrt{\frac{R_{1}+R}{R_{1}LC}}}$$
### b. Diagramme de Bode
De même que l'ancien diagramme de Bode avec un décalage par rapport à l'axe des abscisses. 

# III - Plus de finesse
#### Fréquence de résonance d'une bobine spécifique
Bobine choisie : 77F102J-RC
$$\boxed{\text{SRF}=1.2 \, MHz}$$
#### Proximité de $V_{e}$ en fréquence par rapport à la fréquence de résonnance
##### Proche de la fréquence de résonnance
Lorsque le signal d'entré est proche de la fréquence de résonnance le signal de sortie est en régime critique. C'est à dire que si l'on augmente un peu la fréquence du signal d'entré la sortie va se mettre à osciller. 

##### Bien au delà de la fréquence de résonnance
Lorsque le signal d'entré est bien au dessus de la fréquence de résonnance le signal de sortie est en régime pseudo-périodique. C'est à dire que le signal de sortie va osciller en ayant une amplitude qui décroit avec le temps. 