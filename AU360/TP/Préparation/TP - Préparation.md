# Sommaire
- 1.1 - Modélisation
- 1.2 - Spécifications pour la synthèse des commandes
- 1.3 - Synthèse à temps continu et discrétisation
- 1.4 - Synthèse des commandes à temps discret


# 1. Préparation
## 1.1 - Modélisation ^a1

#### 1.1.1 - Schéma ^a11
![[Pasted image 20260301160819.png]]

Entrées / sorties  su système : 
- $y_{c}(k)$ : Consigne
- $y(t)$ : Réponse en temps continu
- $y(k)$ : Réponse en temps discret

Variables notables du système : 
- $V_{a}(t)$ : Tension de commande de l'actionneur
- $T_{act}(t)$ : Température délivrée de l'actionneur
- $H_{enc}(p)$ : Fonction de transfert de l'enceinte
- $T_{capt}(t)$ : Température à l'entrée du capteur
- $V_{c}(t)$ : Tension délivrée par le capteur
- $H(p)$ : Fonction de transfert du système


Perturbations : 
- $P_{b}(t)$ : Bruit de mesure (Bruit électrique par exemple)
- $P_{u}(t)$ : Perturbation de la commande (Bruit électrique par exemple)
- $P_{y}(t)$ : Variations lentes $H(p)$ suivant l'environnement (usure par exemple)

#### 1.1.2 - Fonction de transfert ^a12
D'après le schéma on suppose que le système est linéaire de premier ordre : 
$$H(p) = \frac{G}{1+\tau p}$$

##### a. Calcul de $\tau$
$$\tau = \frac{t_{\max} - t_{0}}{3} \text{ avec } t_{0} = 0.5 \text{ s} $$
Calcul de $t_{\max}$ : 
$$\Delta V = V_{\max} - V_{0} = 2.7 - 1.15 = 1.55 V$$
$$\Delta V \times 0.95 = 1.47 \text{ }V $$
$$V(3\tau) = 1.47 + 1.15 = 2.62 \, V$$
$$t_{\max} = 2 \text{s}$$
Donc, 
$$\boxed{\tau = 0.5}$$

##### b. Calcul de $G$
On prend le gain à l'entrée : 
$$G = \frac{\Delta s}{\Delta e} = \frac{2.7 - 1.15}{2.33-1.66} \approx 2.3$$
$$\boxed{G = 2.3}$$

##### c. Retard pur
$t_{R}$ : le retard pur entre l'actionneur et le capteur. 
On prend arbitrairement $1 \%$ du temps de réponse : 
$$\boxed{t_{R} \leq t_{R, \max} = 0.01 \tau = 5 \, ms}$$


#### 1.1.3 - Diagramme de Bode ^a13
##### a. Gain
$$\boxed{G_{db}(\omega) = 20 \log(\left| H(p)\right|) = 20\log\left( \frac{G}{\sqrt{1+(\omega \tau)^{2}}} \right)}$$
![[Pasted image 20260301132540.png]]
##### b. Phase
###### Sans retard pur
$$\arg(H(p)) = \arg(G) - \arg(1+j\omega \tau) = \arg(G) - \arctan(\omega \tau)$$
Donc, 
$$\boxed{\varphi = -\arctan(\omega \tau)}$$
![[Pasted image 20260301130654.png]]

#### 1.1.4 - Bruit ^a14
Dans le pire des cas le bruit est de : ${0.3 \, V}$ pour une moyenne de $2.66 \, V$ pour l'actionneur alors, le gain du bruit est de : 
$$\boxed{G_{bruit} = \frac{0.3}{2.66} \approx 0.1}$$


#### 1.1.5 - Modèles statiques ^a15
##### a. Actionneur
$$T_{act}(t) = G_{act}V_{a}(t) + T_{act, 0}$$
Alors, comme l'actionneur délivre une température de $-50° C$ pour une tension de $0 \, V$ : $-50 = G_{act} \times 0 + T_{act, 0}$
On à donc : 
$$T_{act}(t)=  G_{act}V_{act}(t) -50$$
Alors, comme l'actionneur délivre une température de $100° C$ pour une tension de $5 \, V$ : $100 = G_{act}\times 5 - 50$ 
Ainsi, 
$$\boxed{\begin{array}{c}
G_{act} = 30 \\
T_{act,0} = -50 ° C
\end{array}}$$

##### b. Capteur
$$V_{c}(t) = G_{capt} (T_{enc}(t)  + T_{capt,0})$$
Alors, comme le capteur délivre une tension de $0\,V$ pour une température de $-5 \, °C$ : $0 \, V = G_{capt}(-5 + T_{capt, 0})$
donc,
$$V_{c}(t) = G_{capt} (T_{enc}(t)  + 5)$$
De plus, comme le capteur délivre une tension de $5\,V$ pour une température de $60 \, °C$ : $5V = G_{capt}(60 + 5)$
Ainsi, 
$$\boxed{\begin{cases}
G_{capt} = \frac{1}{13} \\
T_{capt,0} = 5 ° C
\end{cases}}$$


#### 1.1.6 - Température externe ^a16
C'est la température associée a la tension au temps $0$ du schéma :
$$T_{enc}(t) =  \frac{1}{G_{capt}}V_{c}(t)-T_{capt, 0} = 13V_{c}(t) - 5$$
$$\boxed{T_{ext} = T_{enc}(0) = 9.95°C}$$

#### 1.1.7 - Fonction de transfert de la micro-enceinte climatique ^a17
Comme le gain du système est de $G_{enc} \times G_{act} \times G_{capt} = 2.3$ (mesuré sur le schéma)
Donc, 
$$G_{enc} = \frac{2.3}{G_{act}G_{capt}} = 1$$
Ainsi, 
$$\boxed{H_{enc}(p) = \frac{1}{1+\tau p}}$$

#### 1.1.8 - Modèle du CAN et du CNA ^a18
Gain : 
Le gain idéal pour un CNA doit être unitaire : $\boxed{G_{CAN/CNA} = 1}$

Quantification : 
Comme le CAN et le CNA possèdent $1$ octets il y a $256$ possibilités pour une tension entre $0$ et $5 \, V$ : 
$$\boxed{Q = \frac{5}{256} = 19.5 \,m V}$$

Saturation : 
D'après le schéma la fréquence de saturation du CAN et du CNA est de $\boxed{5 \, V}$

#### 1.1.9 - Schéma fonctionnel ^a19
![[Pasted image 20260301151748.png]]
- $P_{b}(p)$ : Bruit de mesure
- $P_{u}(p)$ : Perturbation de la commande
- $R(p)$ : Consigne que doit suivre la sortie
- Modélisation compliquée des variations très lentes du système
- $U(p)$ : Entrée(s) du système (Commande actionneur)

![[Pasted image 20260316105448.png]]

## 1.2 Spécifications pour la synthèse des commande ^a2
### 1.2.1 - Modèle à temps continu du système ^a21
![[Pasted image 20260407155334.png]]
Avec : 
- $H_{sys}(p)$ : Fonction de transfert de l'enceinte. 
- $C(p)$ : Fonction de transfert du calculateur
- $F(p)$ : Fonction de transfert du filtre
- $R(p)$ : Consigne
- $R_{f}(p)$ : Consigne filtrée (pour éviter le dépassement)
- $U(p)$ : Commande du calculateur

#### a. Fonction de transfert
On prend la fonction de transfert du système : 
$$\boxed{H_{sys}(p) = \frac{G}{1+\tau p}}$$


#### b. Diagramme de Bode
Voir [[#^a13|1.1.3 - Diagramme de Bode]].

#### c. Majorant d'un retard pur
Le retard du calculateur est de $20 \, \text{ms}$ au maximum d'après le cahier des charges.
De plus, d'après la partie précédente ([[#^a12|1.1.2 - Fonction de transfert]] Partie c) le retard du système enceinte (actionneur $+$ enceinte $+$ capteur) est de $5\, \text{ms}$.
Ainsi : 
$$\boxed{L_{\max} = 25 \, ms}$$
Seulement comme on discrétise ensuite notre système continu, il faut prendre en compte le retard pur du filtre anti-repliement de spectre qui est de : $T_{e}$
Ainsi pour $T_{e} = 10 \, \text{ms}$ :
$$\boxed{L_{\max}=  25 + T_{e} = 35 \, ms}$$

On se fixe cette condition : $\boxed{M_{\text{retard}} \geq 3L_{\max} =105 \, \text{ms}}$


#### d. Amplitude du bruit de mesure
L'amplitude du bruit du capteur à été mesuré dans la partie précédente : 
$$\boxed{A_{bruit, capt} = 230 \, mV}$$

Le bruit de quantification du CAN/CNA est compris entre : 
$$-9.75 \, mV=-\frac{Q}{2} \leq G_{bruit, \mathrm{can}}(p) \leq \frac{Q}{2} = 9.75 \, mV$$
Donc, 
$$\boxed{A_{bruit, \mathrm{can}} = 19.5 \, mV}$$
Ainsi, 
$$\boxed{A_{bruit, \,total, \,\max} = 19.5 + 230 = 249.5 \, mV}$$

#### 1.2.2 - Schéma du système commandé par un calculateur et précédé par un pré-filtre ^a22
![[Pasted image 20260316164226.png]]

#### 1.2.3 - Spécification du cahier des charges ^a23
##### a. On traite la commande
On applique un échelon de température $Y_{C}(t)$ en commande puis on regarde la sortie $Y(t)$ 
![[Pasted image 20260408175715.png]]
Ainsi $T_{d}$ doit être inférieur à : $5\%$ de $T$ : $\boxed{T_{d} \leq 5 \% T}$
Il faudra alors faire en sorte que le <u>calculateur et le pré-filtre</u> respectent cette spécification.

##### b. On traite $P_{u}$ et $P_{y}$
$C$ doit contenir un intégrateur
Le gain statique de $F$ doit être égal à $1$ ($F(0)=1$) pour que le système suive au mieux les références constantes. 
Si on applique un échelon de température $Y_{C}(t)$ en commande avant $F$ et que l'on regarde la sortie $Y(t)$, la différence : $e(t) = Y_{c}(t)- Y(t)$ doit tendre vers une erreur statique nulle.
Ainsi la spécification concerne le <u>calculateur et le pré-filtre</u>.


##### c. On traite le bruit $P_{b}$ en hautes fréquences
On note : $U_{b}$ le bruit présent sur la tension de commande alors, d'après le cahier des charges on souhaite que $\left| U_{b}\right| \leq 10 \% \, 5V = 0.5 \, V=\left| U_{b}\right|_{\max}$ alors : 
$$\left| C(p)\right| \leq_{\omega \to \infty} N_{\max} = \frac{\left| U_{b}\right|_{\max}}{\left| P_{b}\right|} = \frac{0.5}{0.1} = 5$$
On applique une consigne telle que la tension de commande soit maximale ($5 \, V$) puis on mesure $\left| U_{b}\right|$ et on vérifie qu'il ne dépasse pas $10 \%$ de $5 \, V$.
Le <u>calculateur</u> devra ainsi respecter ce critère. 


##### d. On traite $P_{y}$
Le but de cette contrainte est d'assurer la stabilité du système en vérifiant en premier lieu le critère du revers. 
Ensuite on trace les diagrammes de Bode, Nyquist et Black-Nichols de la fonction de transfert du système en boucle ouverte puis on mesure la marge de module sur le diagramme de Nyquist puis la marge de phase sur l'un des $3$ diagrammes. 
Ici la fonction de transfert du <u>calculateur</u>, de l'enceinte et du bloqueur d'ordre zero seront prises en compte ($H_{BO}(p)= C(p)H_{sys}(p) = C(p)H_{BOZ}(p)H_{enc}(p)$)

![[Pasted image 20260409172615.png]]

##### e. On traite $P_{u}$
On recherche : $\min \left|\left| \frac{Y}{P_{u}} \right|\right|$,
Alors on fait un échelon de bruit sur $P_{u}(t)$ et on regarde la sortie $Y_{C}(t)= cte$ puis on s'assure que $Y(t)$ suive la consigne. 



## 1.3 - Synthèses à temps continu et discrétisation ^a3
### 1.3.1 - Synthèse par compensation du pôle dominant à temps continu ^a31
#### 1.3.1.1 - Compensation du pôle dominant à temps continu ^a311
##### a. Synthèse du correcteur ^a311a
$$H_{enc}(p) = \frac{G}{1 + \tau p}$$
On prend le pôle le plus rapide : $-\frac{1}{\tau}$, 
$$R(p) = K\left( p+\frac{1}{\tau} \right)= K(p+2) \text{ donc } S(p) = p$$
Donc, 
$$C(p) = K \frac{p+2}{p} = 5 \frac{p+2}{p}$$
Car $\left| C(p)\right| \underset{\omega \to + \infty}{=}N_{\max} = 5$. 
Alors, 
$$H_{BO}(p) = H_{enc}(p) C(p) = \frac{G}{1+\tau p} \times 5\frac{p+2}{p} = \frac{5\times\frac{G}{\tau}}{p} = \frac{23}{p}$$

##### b. Calcul des marges ^a311b
###### $\alpha.$ Calcul de la marge de module ^a311ba
$$\frac{1}{M_{M}} = \sup_{\omega} \left| S_{y}(p)\right| = \sup_{\omega}\left| \frac{1}{1+H_{BO}(p)}\right|$$
Alors, 
$$S_{y}(p) = \frac{p}{p+23} \Rightarrow \left| S_{y}\right| \leq 1 \Rightarrow \sup_{\omega}\left| S_{y}(p)\right| \leq 1$$
Ainsi, $\boxed{M_{M} \geq 1 \geq 0.5}$ Le cahier des charges est bien suivi.

###### $\beta.$ Calcul de la marge de phase  ^a311bb
$$\boxed{M_{\varphi} = \pi + \arg(H_{BO}(p)_{\left| H_{BO}(\omega_{c})\right| = 1}) = \pi - \arg(j) = \frac{\pi}{2} }$$
$\boxed{M_{\varphi} = \frac{\pi}{2}\geq \frac{\pi}{4}}$ Le cahier des charges est bien suivi.

###### $\gamma.$ Calcul de la marge de retard ^a311bc
(Plus grand retard que l'on peut avoir dans la boucle)
Ainsi, 
$$\boxed{M_{retard}  = \frac{M_{\varphi}}{\omega_{c}} = \frac{\frac{\pi}{2}}{23} = 68 \, \text{ms}}$$
On a en plus les retards évoqués lors de la partie retard pur ([[#^a21|1.2.1 - Modèle à temps continu du système]], partie c)
Alors, comme : $M_{\text{retard}} \geq 3L_{\max} =105 \, \text{ms}$ : 
$$105 \, \text{ms} = (M_{\text{retard}})_{\text{désiré}} \nleq M_{\text{retard}}= 68 \, \text{ms}$$
Alors Il faut que l'on diminue $K$ : 
$$(M_{\text{retard}})_{\text{désirée}} = 105 \, \text{ms} = \frac{M_{\varphi}}{\omega_{c}}$$
Alors, on veut que : $(M_{\text{retard}})_{\text{désirée}} \leq M_{\text{retard}}$ donc, 
$$\omega_{c} \leq \frac{M_{\varphi}}{(M_{\text{retard}})_{\text{désirée}}} = \frac{\frac{\pi}{2}}{0.105} = 15 \, \text{rad.s}^{-1}$$
Donc comme : $H_{BO}(p) =\frac{K \times \frac{G}{\tau}}{p}$ on a : $\left| H_{BO}(\omega_{c})\right| = 1 = \frac{K \times \frac{G}{\tau}}{\omega_{c}}$, alors $K = \frac{\omega_{c}}{\frac{G}{\tau}} = 3.26$.

##### c. Correcteur Final ^a311c
Ainsi, 
$$\boxed{C(p) = 3.26 \times \frac{p+2}{p} = 3.26\left( 1+\frac{2}{p} \right)}$$


#### 1.3.1.2 - Nécessité d'utiliser un pré-filtre ^a312
Comme : $H_{BO}(p)= \frac{K \times \frac{G}{\tau}}{p} = \frac{15}{p}$ alors, 
$$H_{BF}(p) = \frac{H(p)C(p)}{1+H(p)C(p)} = \frac{15}{p+15} = \frac{1}{1+\frac{p}{15}}$$
Dans le cas ou il n'y a pas de filtre on applique un échelon de consigne : $Y_{C}(t) = T °C$ alors en appliquant la transformée de Laplace : $Y_{C}(p) = \frac{T}{p}$ donc : 
$$Y(p) = H_{BF}(p)Y_{C}(p) = \frac{15}{p(p+15)}T = \left( \frac{1}{p}-\frac{1}{p+15} \right)T$$
Ainsi, 
$$\boxed{Y(t) = \mathcal{L}^{-1}(Y(p)) = T(1-e^{ -15t }) }$$
![[Pasted image 20260409221409.png]]
Il n'y a pas de dépassement ainsi l'<u>utilisation d'un préfiltre dans ce cas n'est pas utile</u>. 

##### a. Echelon de consigne ^a312a
Comme on a une réponse exponentielle : $Y(t) = T\left( 1-e^{ -\frac{t}{\tau_{_{y}}} } \right)$ (en posant $\tau_{y}=\frac{1}{15}$) on peut facilement calculer le temps de réponse à $95\%$ qui est de $\boxed{t_{r} =3 \tau_{y} = 0.2 \, s}$

##### b. Perturbation de commande ^a312b
Si on perturbe la commande avec un bruit $P_{u}(t)=\mathcal{P} = \text{cte}$ en utilisant la transformée de Laplace : $P_{u}(p) = \frac{\mathcal{P}}{p}$
$$Y(p) = \frac{H_{enc}(p)}{1+C(p)H_{enc}(p)}P_{u}(p) =\frac{G\mathcal{P}}{p(1+\tau p)\left( 1+\frac{15}{p} \right)} $$
$$= \frac{\frac{G\mathcal{P}}{\tau}}{\left( \frac{1}{\tau}+ p \right)\left( 15+p \right)} = \frac{G\mathcal{P}}{\tau}\left( \frac{A}{\frac{1}{\tau}+ p} + \frac{B}{15+p} \right)$$
Alors par une décomposition en éléments simples on a : 
$$A = \frac{1}{15-\frac{1}{\tau}} \text{ et }B = \frac{1}{\frac{1}{\tau}-15}$$
Donc, 
$$Y(p) = \frac{G\mathcal{P}}{1-15\tau}\left( \frac{1}{15+p} - \frac{1}{\frac{1}{\tau}+p} \right)$$
Ainsi, 
$$\boxed{Y(t) = \frac{G\mathcal{P}}{1-15\tau}\left( e^{ -15t } - e^{ -\frac{t}{\tau} } \right)}$$
![[Pasted image 20260409230817.png]]
On observe un dépassement qui dépend de l'amplitude du bruit de commande : $\mathcal{P}$. De plus à cause de ce dépassement, pour que la réponse atteigne son régime permanent il faut prendre en compte un retard additionnel.
Ainsi pour réduire le dépassement de la réponse voulue il faut minimiser le bruit de commande $P_{u}$. 

##### c. Retard additionnel admissible ^a312c
Le retard additionnel admissible dans la boucle de commande est de : $M_{\text{retard}} - R_{\text{existants}}$ avec $R_{\text{existants}}$ les retards déjà existants dans la boucle de commande :
- $5\, \text{ms}$ pour le BOZ
- $10 \text{ ms}$ pour le FAR
- $5 \, \text{ms}$ pour le système enceinte (capteur + actionneur + enceinte)
- $1 \, \text{ms}$ pour le calculateur

Donc, $R_{\text{existants}} = 21\, \text{ms}$
Ainsi, 
$$\boxed{M_{\text{retard}} - R_{\text{existants}}=105 \, \text{ms}-21 \,\text{ms} = 84 \, \text{ms}}$$
C'est le retard en plus que peut supporter le système en restant relativement stable. 

Remarque : 
Si le calculateur atteint son retard maximal de $20 \,\text{ms}$ le retard maximal admissible sera de $65 \, \text{ms}$


#### 1.3.1.3 - Période d’échantillonnage ^a313
On propose : 
$$\boxed{T_{e} = 10 \, \text{ms}}$$
Les calculs de la marge de retard faits précédemment ([[#^a311bc|Calcul de la marge de retard]]), confirme que l'on puisse utiliser cette période d’échantillonnage. (Cette période d'échantillonnage ne nuit pas au cahier des charges)

#### 1.3.1.4 - Filtre anti-repliement de spectre ^a314
On veut supprimer les composantes spectrales supérieures à $\frac{f_{e}}{2}$ ($f_{e}=\frac{1}{T_{e}}$ la fréquence d'échantillonnage) pour respecter le critère de Shannon : $f_{\max}\leq \frac{f_{e}}{2}$ (et donc éviter le repliement de spectre)
![[Pasted image 20260410142719.png]]
On choisit donc un filtre passe bas de Butterworth d'ordre $3$, de gain unitaire et fréquence de coupure : $\frac{f_{e}}{2}$ (i.e. $\omega_{c} = \omega_{0} = \pi f_{e}$) :
$$H_{FAR}(p) = \frac{1}{\left( 1+\frac{p}{\omega_{0}} \right)\left( 1+\frac{p}{\omega_{0}} + \frac{p^{2}}{\omega_{0}^{2}} \right)}$$
En posant : $\Omega = \frac{\omega}{\omega_{0}}$
On à donc un gain : 
$$\begin{array}{ll}
G_{dB}(\omega) &= -10\log\left( (1+\Omega^{2})((1-\Omega^{2})^{2} + \Omega^{2})\right) \\
&= -10\log(1-2\Omega^{2}+\Omega^{4}+\Omega^{2} + \Omega^{2}-2\Omega^{4}+\Omega^{6}+\Omega^{4}) \\
&= -10\log(1+\Omega^{6})
\end{array}$$
Donc, 
$$\boxed{G_{dB} = -10\log\left( 1+\left( \frac{\omega}{\omega_{0}} \right)^{6} \right)}$$
Et un argument de :
$$\begin{array}{ll}
\arg(H_{FAR}(j\omega)) &= -\arg\left( 1+j\Omega \right)-\arg(1-\Omega^{2} + j \Omega) \\
&=_{\omega\leq \omega_{c}}-\left(\arctan( \Omega) + \arctan\left( \frac{\Omega}{1-\Omega^{2}} \right) +\pi\right)
\end{array}$$
Donc, 
$$\boxed{\arg(H_{FAR}(\omega)) = -\arctan\left( \frac{\omega}{\omega_{0}} \right) - \arctan\left( \frac{\frac{\omega}{\omega_{0}}}{1-\left( \frac{\omega}{\omega_{0}} \right)^{2}} \right) -\pi}$$

On peut donc remarquer que pour la bande fréquentielle d’intérêt : $\omega \leq \omega_{c}$ on peut approximer la fonction de transfert $H_{FAR}(p)$ par : 
$$\boxed{H_{FAR}(p) \approx H_{approx}(p) = e^{ -pT_{e} }}$$
Cela se confirme par les tracés GeoGebra : 
![[Pasted image 20260429104447.png]]
- $\cdot$ : Calculé à partir de la fonction de transfert : $H_{FAR}(p)$
- $\cdot_{approx}$ : Calculé à partir de la fonction de transfert : $H_{approx}(p) = e^{ -pT_{e} }$
- $\omega_{0, x}$ : $\omega_{0}$ ramené à l’échelle logarithmique pour observer la bande fréquentielle d'intérêt qui se situe à gauche de cette droite. 

Ainsi, dans la bande fréquentielle d'intérêt, <u>le FAR introduit un retard pur</u> : 
$$\boxed{\arg(H_{FAR}(j\omega)) \approx \arg(e^{ -pT_{e} }) =- \omega T_{e}}$$



#### 1.3.1.5 - Fonction de transfert du calculateur à temps discret ^a315
On a calculé précédemment (Voir [[#^a311|1.3.1.1 - Compensation du pôle dominant à temps continu]]) ce calculateur : 
$$C(p) = 3.26 \frac{2+p}{p} = 3.26 \frac{\frac{1}{\tau}+p}{p}  $$
Alors en appliquant l'approximation d'Euler implicite : 
$\left( p=\frac{1}{T_{e}} (1-z^{-1}) \right)$
$$\boxed{C(z) =  3.26 \frac{1+\frac{T_{e}}{\tau}-z^{-1}}{1-z^{-1}} }$$
($1+\frac{T_{e}}{\tau}=1.02$)

Pour vérifier que cette approximation est valide, il suffit d'étudier la stabilité du calculateur après avoir appliqué l'approximation :
En effet, la méthode d'<u>Euler implicite conserve la stabilité de la fonction de transfert</u>. 


#### 1.3.1.6 - Fonctions de transfert à temps discret implémentés ^a316
$$\boxed{C(z) = 3.26 \frac{1.02-z^{-1}}{1-z^{-1}} = 3.26 \frac{1+\frac{T_{e}}{\tau}-z^{-1}}{1-z^{-1}}}$$

#### 1.3.1.7 - Algorithme de commande ^a317
On convertit l'expressions de la fonction de transfert en $z$ de $C$ en $n$ avec les entrées-sorties associés : 
$$U(z) = C(z)\varepsilon(z) \Leftrightarrow U(z)(1-z^{-1}) = K\left( 1+\frac{T_{e}}{\tau}-z^{-1} \right)\varepsilon(z)$$
avec $K=3.26$
Alors, 
$$\boxed{U(n)=U(n-1) + K\left(\left( 1+\frac{T_{e}}{\tau} \right)\varepsilon(n)-\varepsilon(n-1)\right)}$$
```
Entrées : U(n-1), ε(n), ε(n-1)
	max=5;
	min=0;
	Te=0.01;
	K=3.26;
	tau=0.5;
	
	U(n) = U(n-1) + K*((1+Te/tau)*ε(n)-ε(n-1));
	if(U(n) > max){
		return max;
	}
	else if(U(n)<min){
		return min;
	}
	else{
		return U(n);
	}
```


#### 1.3.1.8 - Algorithme du système ^a318
```C
float G=2.3;
float tau=0.5;
float fe=100;
float Te=1/fe;
float K=3.26;


uint8_t Correcteur(
		uint8_t Yc,     // Yc(n)
		uint8_t Yc_nm1, // Yc(n-1)
		uint8_t Y,      // Y(n)
		uint8_t Y_nm1,  // Y(n-1)
		uint8_t U       // U(n)
		){

	// ε(n-1) = Yc(n-1)-Y(n-1) : 
	float erreur_nm1=Yc_nm1-Y_nm1; 
	
	// ε(n) = Yc(n)-Y(n) :
	float erreur=Yc-Y;
	
// U(n+1) = U(n) + 3.26 x (1.02 x ε(n) - ε(n-1)) :
	return U+K*((1+Te/tau)*erreur-erreur_nm1);
}
```


### 1.3.2 - Synthèse par placement des pôles de la boucle fermée à temps continu ^a32
#### 1.3.2.1 - Méthode de placement des pôles de la boucle fermée ^a321
On définit : 
$$C(p) = \frac{R(p)}{S(p)} \text{ et }H(p) = \frac{B(p)}{A(p)} \text{ et } F(p) = \frac{T(p)}{R(p)}$$
##### a. Placement des pôles ^a321a
On choisit le degré de $R(p)$ : 
$\deg(R(p)) = \deg(A(p)) = 1$
$$R(p) = r_{1}p+r_{0}$$
Donc pour le cas d'un correcteur propre et intégral : 
$$S(p) = p$$
car $S(0)= 0$ pour assurer le rejet des perturbations constantes.

On choisit le degré du polynôme de régulation $D(p)$ : 
$$\deg(D(p)) = \deg(A) + \deg(S(p)) = 1+1 = 2$$
Alors, 
$$D(p) = p^{2} + d_{1}p + d_{0}$$
Donc comme par définition : 
$$D(p) = A(p)S(p) + B(p)R(p)$$
On a : 
$$D(p) = p(p+2) + 2G(r_{1}p+r_{0}) = p^{2} + (2+2Gr_{1})p + 2Gr_{0}$$
Donc par identification des coefficients on a :
$$\begin{cases}
d_{1} = 2(1+Gr_{1}) \\
d_{0} = 2Gr_{0}
\end{cases}$$
Or on souhaite le polynôme de régulation suivant :
$$D(p) = (p+p_{0})^{2} = p^{2}+2p_{0}p + p_{0}^{2}$$
Ainsi, 
$$\boxed{\begin{cases}
1+Gr_{1} = p_{0} \\
2Gr_{0}=p_{0}^{2}
\end{cases} \Leftrightarrow \begin{cases}
r_{1} = \frac{p_{0}-1}{G} \\
r_{0} = \frac{p_{0}^{2}}{2G}
\end{cases}}$$
Alors, 
$$\boxed{C(p) = \frac{r_{1}p+r_{0}}{p}}$$

##### b. Gain en haute fréquence du correcteur ^a321b
$$C(p) \underset{p\to + \infty}{=} r_{1} = \frac{p_{0}-1}{G} \leq N_{\max} = 5$$
Alors, 
$$p_{0} \leq 5\times 2.3+1 = 12.5$$
Donc on choisit $r_{1} = 5$. 
Ainsi, 
$$\boxed{r_{1} = 5 \text{ et } r_{0} = 34}$$
Donc, 
$$\boxed{C(p) = \frac{5p+34}{p}}$$

##### c. Calcul des marges ^a321c
$$\boxed{H_{BO}(p) = 2G\frac{r_{1}p+r_{0}}{p(p+2)}}$$
###### $\alpha.$ Calcul de la marge de module ^a321ca
$$M_{M}=\min(\left|1+ H_{BO}(p)\right|)$$
D'après un algorithme d'approximation réalisé en langage $C$ on obtiens une marge de module de : 
$$\boxed{M_{M} = 1.0 \geq 0.5}$$


###### $\beta.$ Calcul de $\omega_{c}$ ^a321cb
$$\left| H_{BO}(j\omega_{c})\right| = 1 = 2G\left| \frac{r_{1}j\omega_{c}+r_{0}}{2j\omega_{c}-\omega_{c}^{2}}\right| = \frac{2G}{\omega_{c}} \frac{\sqrt{r_{1}^{2}\omega_{c} + r_{0}^{2}}}{\sqrt{4+\omega_{c}^{2}}} $$
$$\begin{array}{ll}
&\Leftrightarrow \omega_{c}\sqrt{\omega_{c}^{2}+4} = 2G\sqrt{r_{1}^{2}\omega_{c}^{2}+r_{0}^{2}}  \\
&\Leftrightarrow \omega_{c}^{4}+4\omega_{c}^{2} = 4G^{2}(r_{1}^{2}\omega_{c}^{2} +r_{0}^{2}) \\
&\Leftrightarrow \omega_{c}^{4}+ 4(1-(Gr_{1})^{2})\omega_{c}^{2} = 4G^{2}r_{0}^{2}
\end{array}$$
En posant $X=\omega_{c}^{2}$ on a alors :
$$X^{2}+4(1-(Gr_{1})^{2})X - (2Gr_{0})^{2} = 0$$
On exprime alors les coefficients de cette équation polynomiale du second ordre en fonction de $p_{0}$ :
$$\begin{array}{ll}
&&1+Gr_{1}=p_{0}  \\
&\Leftrightarrow &(Gr_{1})^{2} = (p_{0}-1)^{2}  \\
&\Leftrightarrow &4(1-(Gr_{1})^{2}) = 4(1-(p_{0}-1)^{2})
\end{array}$$
On obtient donc :
$$X^{2} + 4(1-(p_{0}-1)^{2})X - p_{0}^{4} = 0$$
Le calcul du discriminant se révèle positif : 
$$\begin{array}{ll}
\Delta &= 16(1-(p_{0}-1)^{2})^{2}+4p_{0}^{4}&\geq0 \\
&= 20p_{0}^{4}-64p_{0}^{3}+64p_{0}^{2}  \\
&= p_{0}^{2}(20p_{0}^{2}-64p_{0}+64)
\end{array}$$
Alors, 
$$\begin{array}{ll}
X &= p_{0}(2p_{0}-4) \pm p_{0}\sqrt{5p_{0}^{2}-16p_{0}+16}  \\
&= p_{0}(2p_{0}-4 + \sqrt{5p_{0}^{2}-16p_{0}+16})
\end{array}$$
Ainsi après le calcul de $X$ pour $p_{0}=12.5$ :
$$\boxed{\omega_{c} = \sqrt{X} = 23.83 \, \text{rad.s}^{-1}}$$

###### $\gamma.$ Calcul de la marge de phase ^a321cc
Par définition :
$$M_{\varphi}=\pi + \arg(H_{BO}(p)_{H_{BO}(j\omega_{c}) = 1})$$
Alors comme : 
$$H_{BO}(j\omega_{c}) = 2G\frac{r_{1}j\omega_{c}+r_{0}}{2j\omega_{c}-\omega_{c}^{2}} = 4.6 \frac{r_{1}j\omega_{c}+r_{0}}{2j\omega_{c}-\omega_{c}^{2}}$$
On a : 
$$\begin{array}{ll}
M_{\varphi} &= \pi + \arg(r_{1}j\omega_{c}+r_{0}) - \arg(2j\omega_{c}-\omega_{c}^{2}) \\
&= \pi + \left( \arctan\left( \frac{r_{1}\omega_{c}}{r_{0}} \right) -\left( \pi+\arctan\left( \frac{2}{\omega_{c}} \right) \right) \right) \\
&= \arctan\left( \frac{r_{1}\omega_{c}}{r_{0}}\right)-\arctan\left( \frac{2}{\omega_{c}} \right)
\end{array}$$

Ainsi : 
$$\boxed{M_{\varphi} = \arctan\left( \frac{2(p_{0}-1)\omega_{c}}{p_{0}^{2}} \right) -\arctan\left( \frac{2}{\omega_{c}} \right) =69.29°>45°}$$

###### $\delta.$ Calcul de la marge de retard ^a321cd
$$M_{\text{retard}} = \frac{M_{\varphi}}{\omega_{c}} \approx 51\, \text{ms}\ngeq (M_{\text{retard}})_{\text{désiré}} = 105 \, \text{ms}$$
Ainsi on résout alors numériquement l'équation : 
$$M_{\text{retard}} = 105\, \text{ms}$$
(i.e. on souhaite trouver $p_{0}$ pour respecter la marge de retard)
À l'aide d'un script codé en $C$, on obtiens : 
$$\boxed{p_{0} = 7.46}$$
Après calcul on a ainsi : 
$$\boxed{\begin{cases}
r_{0}=12.1 \\
r_{1}=2.81\\
\omega_{c}=13.4 \,\text{rad.s}^{-1} \\
M_{M} = 1.01 \\
M_{\varphi}=80.7° \\
M_{\text{retard}} = 105 \, \text{ms}
\end{cases}}$$


##### d. Correcteur Final ^a321d
Ainsi : 
$$\boxed{C(p) = \frac{2.81p+12.1}{p}}$$

##### e. Filtre Final ^a321e
On a : $F(p) = \frac{T(p)}{R(p)}$ et on souhaite que $F(0) = 1$ donc $T(0) = R(0) = r_{0}=12.1$ de plus on considère aussi que $T(p)$ est constant on a ainsi : 
$$\boxed{F(p) = \frac{12.1}{2.81p+12.1}}$$


#### 1.3.2.2 - Commande obtenue ^a322
##### a. Temps de réponse d'un échelon de consigne en température
$$Y_{c}(t) = T \Leftrightarrow Y_{c}(p) = \frac{T}{p}$$
Alors, 
$$\begin{array}{llcl}
Y(p)& =& F(p) \frac{H(p)C(p)}{1+H(p)C(p)}&Y_{c}(p)  \\
&=& \frac{T(p)B(p)}{D(p)}&Y_{c}(p)  \\
&=& \frac{\frac{r_{0} G}{\tau}}{(p+p_{0})^{2}}&Y_{c}(p)
\end{array}$$
Donc, 
$$\begin{array}{ll}
Y(p)&= \frac{r_{0}GT}{\tau} \times \frac{1}{p(p+p_{0})^{2}}  \\
&= \frac{p_{0}^{2}T}{2\tau} \left( \frac{\frac{1}{p_{0}^{2}}}{p} - \frac{\frac{p}{p_{0}^{2}}+\frac{2}{p_{0}}}{(p+p_{0})^{2}} \right) \\
&=\frac{T}{2\tau}\left( \frac{1}{p}-\frac{p+2p_{0}}{(p+p_{0})^{2}} \right) \\
&=\frac{T}{2\tau}\left( \frac{1}{p}-\frac{1}{p+p_{0}}-\frac{p_{0}}{(p+p_{0})^{2}} \right)
\end{array}$$
Alors, comme : 
$$\mathcal{L}[Rect_{[0, + \infty[}(t)](p) =\int_{0}^{+ \infty} e^{ -pt } \, dt = \frac{1}{p} $$
et
$$\mathcal{L}[e^{ -p_{0}t }](p) = \int _{0}^{+ \infty}e^{ -(p+p_{0})t } \, dt  = \frac{1}{p+p_{0}}$$
et
$$\begin{array}{ll}
\mathcal{L}[te^{ -p_{0}t}(t)](p)&=-\left[ \frac{t}{p_{0}+p} e^{ -(p_{0}+p)t } \right]_{0}^{+\infty} +\frac{1}{p_{0}+p}\int_{0}^{+ \infty} e^{ -(p_{0}+p)t } \, dt \\
&= \frac{1}{(p+p_{0})^{2}}
\end{array}$$
Ainsi : 
$$\boxed{Y(t) = \frac{T}{2\tau} (1-e^{ -p_{0}t }-p_{0}te^{ -p_{0}t })}$$
![[Pasted image 20260502100124.png]]



##### b. Retard additionnel admissible dans la commande
On a choisit la marge telle qu'elle soit égale à : $105 \,\text{ms}$,
Il reste donc : 
$$\boxed{M_{\text{retard}} - R_{\text{existants}}=105 \, \text{ms}-21 \,\text{ms} = 84 \, \text{ms}}$$
de retard additionnel admissible

Remarque : 
Si le calculateur atteint son retard maximal de $20 \,\text{ms}$ le retard maximal admissible sera de $65 \, \text{ms}$.

#### 1.3.2.3 - Période d'échantillonnage ^a323
De même que précédemment ([[#^a313|1.3.1.3 - Période d’échantillonnage]]) la période d'échantillonnage à été prise en compte dans le calcul des marges de retard ainsi :
$$\boxed{T_{e} = 10 \, \text{ms}}$$


#### 1.3.2.4 - Filtre anti-repliement de spectre ^a324
Voir [[#^a314|1.3.1.4 - Filtre anti-repliement de spectre]].

#### 1.3.2.5 - Fonctions de transfert à temps discret ^a325
$$C(p) = \frac{2.81p+12.1}{p} \text{ et }F(p) = \frac{12.1}{2.81p+12.1}$$
Ainsi, en utilisant l'approximation d'Euler implicite
$$\boxed{C(z) = \frac{2.81(1-z^{-1}) + 12.1T_{e}}{1-z^{-1}} = \frac{2.931-2.81z^{-1}}{1-z^{-1}}}$$
$$\boxed{F(z) = \frac{12.1}{\frac{2.81}{T_{e}}(1-z^{-1})+12.1} = \frac{12.1}{293.1-281z^{-1}}}$$


#### 1.3.2.6 - Fonctions de transfert implémentées ^a326
$$\boxed{C(z) = \frac{(r_{1} + r_{0}T_{e})-r_{1}z^{-1}}{1-z^{-1}}= \frac{2.931-2.81z^{-1}}{1-z^{-1}}}$$
$$\boxed{F(z)= \frac{r_{0}T_{e}}{(r_{1}+r_{0}T_{e})-r_{1}z^{-1}}= \frac{0.121}{2.931-2.81z^{-1}}}$$

#### 1.3.2.7 - Fonctions de transfert implémentées ^a327
On convertit l'expressions de la fonction de transfert en $z$ de $C$ en $n$ avec les entrées-sorties associés : 
$$U(z) = C(z)\varepsilon(z) \Leftrightarrow U(z)(1-z^{-1}) = (r_{1}+r_{0}T_{e}-r_{1}z^{-1})\varepsilon(z)$$
Alors, 
$$\boxed{U(n)=U(n-1) + ((r_{1}+r_{0}T_{e})\varepsilon(n)-r_{1}\varepsilon(n-1))}$$

```
Entrées : U(n-1), ε(n), ε(n-1)
	max=5;
	min=0;
	
	r0=12.1;
	r1=2.81;
	Te=0.01;
	
	U(n) = U(n-1) + ((r1+r0*Te)*ε(n)-r1*ε(n-1));
	if(U(n) > max){
		return max;
	}
	else if(U(n)<min){
		return min;
	}
	else{
		return U(n);
	}
```

#### 1.3.2.8 - Algorithme de commande ^a328
On convertit l'expressions de la fonction de transfert en $z$ de $F$ en $n$ avec les entrées-sorties associés : 
$$Y_{C}(z)=F(z)Ref(z) = \frac{r_{0}T_{e}}{(r_{1}+r_{0}T_{e})-r_{1}z^{-1}}Ref(z)$$
Alors, 
$$\left( r_{1}+r_{0}T_{e} \right)Y_{C}(n)=r_{1}Y_{C}(n-1)+r_{0}T_{e}Ref(n)$$
Ainsi, 
$$\boxed{Y_{C}(n) = \frac{r_{1}}{r_{1}+r_{0}T_{e}}Y_{C}(n-1)+ \frac{r_{0}T_{e}}{r_{1}+r_{0}T_{e}} Ref(n)}$$

```C
float G=2.3;
float tau=0.5;
float fe=100;
float Te=1/fe;

float r0=12.1;
float r1=2.81;

uint8_t Correcteur(uint8_t Yc, uint8_t Yc_nm1, uint8_t Y, uint8_t Y_nm1, uint8_t U_nm1){
	// ε(n-1)=Yc(n-1)-Y(n-1) :
	int erreur_nm1=Yc_nm1-Y_nm1;
	// ε(n)=Yc(n)-Y(n) :
	int erreur=Yc-Y;
	
	// U(n) = U(n-1) + ((r1+r0*Te)*ε(n)-r1*ε(n-1))
	return U_nm1+((r1+r0*Te)*erreur-r1*erreur_nm1);
}

uint8_t Filtre(uint8_t Ref, uint8_t Yc_nm1){
	return (r1/(r1+r0*Te))*Yc_nm1+((r0*Te)/(r1+r0*Te))*Ref;
}
```

## 1.4 - Synthèses de commandes à temps discret ^a4
#### a. Période d'échantillonnage
On prend la période d’échantillonnage minimale (rendu possible par le CAN/CNA) : 
$$\boxed{T_{e} = 10ms}$$

#### b. Filtre anti-repliement de spectre
Voir [[#^a314|1.3.1.4 - Filtre anti-repliement de spectre]].
Dans cette partie on a approximé : 
$$\boxed{H_{FAR}(p) \approx e^{ -pT_{e} }}$$

#### c. Modèle linéaire à temps discret
$$H_{sys}(p) = \frac{Ny(p)}{Nu(p)} = H_{\mathrm{CNA}}(p)H_{BOZ}H(p)H_{FAR}(p)H_{\mathrm{CAN}}(p) $$
Comme $H_{CAN}H_{CNA}(p) = 1$ : 
$$H_{sys}(p) = \frac{Ny(p)}{Nu(p)} = H_{BOZ}(p) H(p)H_{FAR}(p)$$
On a donc :
$$H_{BOZ}(p)H(p) = G\frac{1-e^{ -pT_{e} }}{p(1+\tau p)}$$
Alors on passe du domaine de Laplace en z : 
$$\begin{array}{ll}
\mathcal{Z}(H_{BOZ}(p)H(p)) &= G\, \mathcal{Z}\left( \frac{1-e^{ -pT_{e} }}{p(1+\tau p)} \right)  \\
&= G (1-z^{-1}) \mathcal{Z}\left( \frac{1}{p(1+\tau p)} \right)
\end{array}$$
Mais comme : 
$$\frac{1}{p(1+\tau p)} = \frac1p - \frac{1}{\frac{1}{\tau}+p}$$
On a : 
$$\begin{array}{ll}
\mathcal{Z}\left( \frac{1}{p(1+\tau p)} \right) &= \frac{1}{1-z^{-1}}-\frac{1}{1-e^{ -\frac{T_{e}}{\tau} }z^{-1} }  \\
&= \frac{1-e^{ -\frac{T_{e}}{\tau} }z^{-1} - (1-z^{-1})}{(1-z^{-1})\left( 1-e^{ -\frac{T_{e}}{\tau} }z^{-1} \right)}  \\
&= \frac{\left( 1-e^{ -\frac{T_{e}}{\tau} } \right)z^{-1}}{(1-z^{-1})\left( 1-e^{ -\frac{T_{e}}{\tau} }z^{-1} \right)}
\end{array}$$
Donc : 
$$\mathcal{Z}(H_{BOZ}(p)H(p)) = \frac{G\left( 1-e^{ -\frac{T_{e}}{\tau} } \right)z^{-1}}{1-e^{ -\frac{T_{e}}{\tau} }z^{-1}}$$
Or d'après le point $b$, le FAR introduit un retard pur de $T_{e}$ :
$$H_{FAR}(p) = e^{ -pT_{e} } \Leftrightarrow H_{FAR}(z) = z^{-1}$$
On a donc : 
$$\begin{array}{ll}
H_{sys}(y)&=\mathcal{Z}(H(p)H_{BOZ}(p)H_{FAR}(p)) \\
& = \mathcal{Z}(H(p)H_{BOZ}(p)e^{ -pT_{e} })  \\
&= \mathcal{Z}(H(p)H_{BOZ}(p))z^{-1}
\end{array}$$
Ainsi : 
$$\boxed{H_{sys}(z) = G\frac{\left( 1-e^{ -\frac{T_{e}}{\tau} } \right)z^{-2}}{ 1-e^{ -\frac{T_{e}}{\tau} }z^{-1} }=\frac{0.046z^{-2}}{1-0.980z^{-1}}}$$


### 1.4.1 - Synthèse par compensation du pôle dominant à temps discret ^a41
#### 1.4.1.1 - Méthode de compensation du pôle dominant discret ^a411
##### a. Synthèse du correcteur ^a411a
On pose : 
$$H_{sys}(z) = \frac{B(p)}{A(p)} \text{ et } C(z) = \frac{R(z)}{S(z)} $$
On choisit : 
$$R(z) = KA(p) = K(1-0.980z^{-1})$$
De plus, pour assurer le rejet des perturbations lors d'un échelon de consigne constant $S(z=1)=0$, alors $S(z) = 1-z^{-1}$

Calculer le gain en hautes fréquence du correcteur revient à calculer $\lim_{ z \to -1 }C(z)$ car $\omega_{\max}=2\pi \frac{f_{e}}{2}=\frac{\pi}{T_{e}}$ et donc $z=e^{ j\omega_{\max}{T_{e}} }=e^{ \pi j }=-1$
$$C(z) \underset{z \to -1}{\longrightarrow} \frac{1.980}{2}K\leq N_{\max} = 5 \Leftrightarrow \boxed{K=5.05}$$
Ainsi, 
$$\boxed{C(z) = 5.05 \frac{1-0.980z^{-1}}{1-z^{-1}}}$$

##### b. Calcul des marges ^a411b
La fonction de transfert en boucle ouverte est : 
$$\boxed{H_{BO}(z) = H(z)C(z) = 5.05 \frac{0.046z^{-2}}{1-z^{-1}}= \frac{0.23z^{-2}}{1-z^{-1}}}$$

###### $\alpha.$ Calcul de la marge de module ^a411ba
Par définition :
$$M_{M} = \min_{\omega}\left| 1+H_{BO}(e^{ j\omega T_{e} })\right|$$
Alors d'après un algorithme d'approximation réalisé en langage $C$ on obtient une marge de module de : 
$$\boxed{M_{M} = 1.12 \geq 0.5}$$

###### $\beta.$ Calcul de $\omega_{c}$ ^a411bb

$$\left| H_{BO}(e^{ j\omega_{c}T_{e} })\right| = 1 = \left| K\frac{0.046z^{-2}}{1-z^{-1}}\right| = K\frac{0.046}{\sqrt{2-2\cos(\omega_{c}T_{e})}}$$
Alors, 
$$(0.046K)^{2} = 2-2\cos(\omega_{c}T_{e}) \Leftrightarrow \cos(\omega_{c}T_{e}) = \frac{2-(0.046K)^{2}}{2}$$
$$\boxed{\omega_{c} =\frac{1}{T_{e}}\cos ^{-1}\left( \frac{2-(0.046K)^{2}}{2} \right)=23.05 \text{ rad.s}^{-1}}$$


###### $\gamma.$ Calcul de la marge de phase ^a411bc
Par définition :
$$M_{\varphi}=  \pi + \arg(H_{BO}(z))$$
Calculé pour $\omega = \omega_{c}$ : $z=e^{ j\omega_{c}T_{e} }$
$$\begin{array}{ll}
M_{\varphi} &= \pi +\arg\left( \frac{0.23z^{-2}}{1-z^{-1}} \right)  \\
&= \pi+ (-\omega_{c}T_{e}-\arg(1-z^{-1})) \\
&= \pi - (\omega_{c}T_{e}+\arg(1-\cos(\omega_{c}T_{e})+j\sin(\omega_{c}T_{e})))
\end{array}$$
Ainsi : 
$$\boxed{M_{\varphi}= \pi-\left( \omega_{c}T_{e} + \arctan\left( \frac{\sin(\omega_{c}T_{e})}{1-\cos(\omega_{c}T_{e})} \right)\right) = 70.0°}$$



###### $\delta.$ Calcul de la marge de retard ^a411bd
Par définition et après calcul on a :
$$M_{\text{retard}} = \frac{M_{\varphi}}{\omega_{c}} = 52 \, \text{ms}$$
Seulement on souhaite que $M_{\text{retard}} \geq 105 \, \text{ms}$, alors, 
Alors d'après un algorithme d'approximation réalisé en langage $C$ on obtient : $\boxed{K = 2.84}$ on a alors pour avoir un retard de $105 \, ms$ :
Ainsi après calcul on a les donnés suivantes :
$$\boxed{\begin{cases}
\omega_{c} = 13.1 \text{ rad.s}^{-1}\\
M_{M} = 1.07\\
M_{\varphi}=78.8° \\
M_{\text{retard}} =105 \, \text{ms}
\end{cases}}$$
Le cahier des charges est bien respecté.


##### c. Correcteur Final ^a411c
Ainsi, le correcteur final est : 
$$\boxed{ C(z) = 2.84 \frac{1-0.980z^{-1}}{1-z^{-1}}}$$


#### 1.4.1.2 - Fonctions de transferts implémentés ^a412
$$\boxed{C(z) = 2.84 \frac{1-0.980z^{-1}}{1-z^{-1}}}$$

#### 1.4.1.3 - Equations de récurrence ^a413
##### Calculateur
$$C(z) = \frac{U(z)}{\varepsilon(z)}$$
Alors, 
$$\varepsilon(z)(1-z^{-1}) = KU(z)(1-0.98z^{-1})$$
(avec $K=3.1$)
Ainsi, 
$$\boxed{U(n) = \frac{1}{K}(\varepsilon(n)-\varepsilon(n-1)) + 0.980U(n-1)}$$

```
Entrées : U(n-1), ε(n), ε(n-1)
	max=5;
	min=0;
	
	K=2.84;
	
	U(n) = 0.98*U(n-1) + (ε(n)-ε(n-1))/K;
	if(U(n) > max){
		return max;
	}
	else if(U(n)<min){
		return min;
	}
	else{
		return U(n);
	}
```


#### 1.4.1.4 - Algorithme de Commande ^a414
```C
float fe=100;
float Te=1/fe;

K=2.84;

uint8_t Correcteur(uint8_t Yc, uint8_t Yc_nm1, uint8_t Y, uint8_t Y_nm1, uint8_t U_nm1){
	// ε(n-1)=Yc(n-1)-Y(n-1) :
	int erreur_nm1=Yc_nm1-Y_nm1;
	// ε(n)=Yc(n)-Y(n) :
	int erreur=Yc-Y;
	
	// U(n) = 0.98*U(n-1) + (ε(n)-ε(n-1))/K : 
	return 0.98*U_nm1+(erreur-erreur_nm1)/K;
}
```

### 1.4.2 - Synthèse par placement des pôles de la boucle fermée à temps discret ^a42
#### 1.4.2.1 - Méthode de placement des pôles de la boucle fermée à temps discret ^a421
##### a. Calcul de $z_{BF}$ ^a421a
L'expression du polynôme de régulation désiré est : 
$$D(z) = (1-z_{BF}z^{-1})^{n}$$
Avec : 
$$z_{BF} = e^{ -\frac{6.3T_{e}}{t_{rep_{95\%}}}} $$
Alors, on choisit  le temps de réponse ($t_{rep_{95\%}}$) du système :
$$t_{rep_{95\%}} = 0.387$$
Ainsi, 
$$\boxed{z_{BF}= e^{ - \frac{6.3 T_{e}}{0.387} } = 0.850}$$

##### b. Détermination de $C(p)$ ^a421b
$$H_{sys}(z) = \frac{0.046z^{-2}}{1-0.980z^{-1}} $$
On pose : 
$$C(z) = \frac{R(z)}{S(z)} \text{ et } H_{sys}(z)  = \frac{B(z)}{A(z)}$$

Alors, comme $\deg(R(z))= \deg(B(z))=1$, puis que 
$\deg(S(z)) > \deg(R(z))=1$ et $S(z=1)=0$ on choisit alors : 
$$R(z) = r_{0}+r_{1}z^{-1} \text{ et } S(z) =(1-z^{-1})(1-s_{0}z^{-1})$$

Donc par définition du polynôme de régulation : 
$$D(z) = A(z)S(z) + B(z)R(z) $$
$$= (1-0.98z^{-1})(1-z^{-1})(1-s_{0}z^{-1}) + 0.046z^{-2}(r_{0}+r_{1}z^{-1})$$
$$ \begin{array}{llcl}
=&-&(-0.046r_{1}+0.98s_{0})&z^{-3} \\
&+&(0.046r_{0}+s_{0}+0.98+0.98s_{0})&z^{-2} \\
&-& (s_{0}+1+0.98)&z^{-1}  \\
&+&1&
\end{array}$$
Or on désire : 
$$D_{desiré}(z) = (1-z_{BF}z^{-1})^{3}$$
$$\begin{array}{llcl}
=&-&z_{BF}^{3}&z^{-3} \\
&+&3z_{BF}^{2}&z^{-2} \\
&-&3z_{BF}&z^{-1} \\
&+&1
\end{array}$$
Ainsi par identification (et quelques calculs) : 
$$\begin{cases}
s_{0}=0.569 \\
r_{0}=1.28 \\
r_{1}=-1.21
\end{cases}$$
$$\boxed{C(z) = \frac{1.28-1.21z^{-1}}{(1-z^{-1})(1-0.569z^{-1})}}$$


##### c. Calcul des marges ^a421c
$$\boxed{H_{BO}(z) = \frac{0.046z^{-2}}{(1-0.980z^{-1})} \frac{r_{0}+r_{1}z^{-1}}{(1-z^{-1})(1-s_{0}z^{-1})}}$$

Dans cette partie toutes les marges et valeurs calculées l'ont été avec des algorithmes d'approximation (voir Annexe $1$)

###### $\alpha.$ Calcul de la marge de module ^a421ca
$$\boxed{M_{M} = \min_{\omega}\left| 1+H_{BO}(e^{ j\omega T_{e} })\right| = 1}$$

###### $\alpha.$ Calcul de $\omega_{c}$
$$\boxed{\omega_{c} = 42.3 \text{ rad.s}^{-1}}$$

###### $\alpha.$ Calcul de la marge de phase
$$\boxed{M_{\varphi} = \pi + \arg(H_{BO}(e^{ j\omega_{c}T_{e} }))=232.6° \geq 45 °}$$


###### $\alpha.$ Calcul de la marge de retard
$$\boxed{M_{\text{retard}} = \frac{M_{\varphi}}{\omega_{c}}= 118 \, \text{ms}}$$

Ainsi $M_{\text{retard}} \geq 105 \, \text{ms}$, le cahier des charges est respecté
On obtiens ainsi : 
$$\boxed{\begin{cases}
t_{rep, 95\% } &= 0.387& \,\text{s} \\
z_{BF} &=0.850 \\
s_{0}&= 0.569 \\
r_{0}&=1.28 \\
r_{1}&=-1.21 \\
\omega_{c}&=42.29& \text{rad.s}^{-1} \\
M_{M}&=1.00 \\
M_{\varphi}&=285° \\
M_{\text{retard}} &=118 &\, \text{ms}
\end{cases}}$$



##### d. Détermination du Pré-Filtre
On pose : 
$$F(z) = \frac{T(z)}{R(z)} = \frac{T(z)}{r_{0}+r_{1}z^{-1}}$$
Pour avoir une erreur statique nulle il faut que : 
$$1=\frac{Y(z=1)}{Ref(z=1)} = H_{BF}(z=1)  = \frac{T(z=1)B(z=1)}{D(z=1)}$$
Car d'après la structure RST : 
$$H_{BF}(z) = T(z) \times \frac{B(z)}{S(z)A(z)+B(z)R(z)} = \frac{T(z)B(z)}{D(z)}$$
Alors, comme : $S(z=1) = 0$.
$$T(z=1) = \frac{D(z=1)}{B(z=1)} = R(z=1) = r_{0}+r_{1}$$
Ainsi, 
$$\boxed{F(z) = \frac{r_{0}+r_{1}}{r_{0}+r_{1}z^{-1}} = \frac{0.07}{1.28-1.21z^{-1}}}$$



#### 1.4.2.2 - Fonctions de transferts implémentés ^a422
$$\boxed{C(z) = \frac{1.28-1.21z^{-1}}{1-1.569+z^{-1}+0.569z^{-2}}}\text{ et }\boxed{F(z) = \frac{0.07}{1.28-1.21z^{-1}}}$$

#### 1.4.2.3 - Equations de récurrence ^a423
##### Correcteur discret
Par définition : 
$$\frac{U(z)}{\varepsilon(z)} = C(z)$$
Alors : 
$$(1-1.569z^{-1}+0.569z^{-2})U(z) = (1.28-1.21z^{-1})\varepsilon(z)$$
Donc en appliquant la transformée en $z$ inverse on a : 
$$\boxed{U(n) = r_{0}\varepsilon(n)-r_{1}\varepsilon(n-1)+(1+s_{0})U(n-1) - s_{0}U(n-2)}$$


##### Filtre
$$F(z)= \frac{Y_{C}(z)}{Ref(z)}$$
$$r_{0}Y_{c}(n)=(r_{0}+r_{1})Ref(n)+r_{1}Y_{C}(n-1)$$
Alors, 
$$\boxed{Y_{C}(n) = \frac{r_{0}+r_{1}}{r_{0}}Ref(n) + \frac{r_{1}}{r_{0}} Y_{C}(n-1)}$$


```
Entrées : U(n-1), U(n-2), ε(n), ε(n-1)
	max=5;
	min=0;
	
	r0=1.28;
	r1=-1.21;
	s0=0.569;
	
	U(n) = r0*ε(n)-r1*ε(n-1) + (1+s0)*U(n-1)-s0*U(n-2);
	
	if(U(n) > max){
		return max;
	}
	else if(U(n)<min){
		return min;
	}
	else{
		return U(n);
	}
```

#### 1.4.2.4 - Algorithme de Commande ^a424
```C
float r0=1.28;
float r1=-1.21;
float s0=0.569;

uint8_t Correcteur(uint8_t Yc, uint8_t Yc_nm1, uint8_t Y, uint8_t Y_nm1, uint8_t U_nm1, uint8_t U_nm2){
	// ε(n-1)=Yc(n-1)-Y(n-1) :
	int erreur_nm1=Yc_nm1-Y_nm1;
	// ε(n)=Yc(n)-Y(n) :
	int erreur=Yc-Y;
	
	
	// U(n) = r0*ε(n)-r1*ε(n-1) + (1+s0)*U(n-1)-s0*U(n-2)
	return r0*erreur(n)-r1*erreur_nm1 + (1+s0)*U_nm1-s0*U_nm2;
}

uint8_t Filtre(uint8_t Ref, uint8_t Yc_nm1){
	return (r0+r1)/r0 *Ref + r1/r0 *Yc_nm1;
}
```

