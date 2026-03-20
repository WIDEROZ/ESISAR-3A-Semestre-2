## 1.1 - Modélisation
#### 1.1.1 - Schéma
![[Pasted image 20260301160819.png]]

Entrées / sorties : 
- $U(t)$ : Signal de commande
- $y_{c}(t)$ : Consigne
- $y(t)$ : Réponse en temps continu
- $y(k)$ : Réponse en temps discret

Perturbations : 
- $P_{b}(p)$ : Bruit de mesure (Bruit électrique par exemple)
- $P_{u}(p)$ : Perturbation de la commande (Bruit électrique par exemple)
- $P_{y}(p)$ : Variations lentes $H(p)$ suivant l'environnement (usure par exemple)

#### 1.1.2 - Fonction de transfert
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
$$H_{t_{R}}(p)=H(p)e^{ -t_{R}p }$$
$t_{R}$ : le retard pur entre l'actionneur et le capteur. 
On prend arbitrairement $1 \%$ du temps de réponse : 
$$\boxed{t_{R} \leq t_{R, \max} = 0.01 \tau = 5 \, ms}$$


#### 1.1.3 - Diagramme de Bode
##### a. Gain
$$\boxed{G_{db}(\omega) = 20 \log(\left| H(p)\right|) = 20\log\left( \frac{G}{\sqrt{1+(\omega \tau)^{2}}} \right)}$$
![[Pasted image 20260301132540.png]]
##### b. Phase
###### Sans retard pur
$$\arg(H(p)) = \arg(G) - \arg(1+j\omega \tau) = \arg(G) - \arctan(\omega \tau)$$
Donc, 
$$\boxed{\varphi = -\arctan(\omega \tau)}$$
![[Pasted image 20260301130654.png]]

###### Avec un retard pur
$$\arg(H(p)) = \arg(G)+\arg(e^{ -t_{R}j\omega}) - \arg(1+j\omega \tau) $$
$$= -\omega t_{R} - \arctan(\omega \tau)$$
Donc, 
$$\boxed{\varphi = -\omega t_{R} - \arctan(\omega \tau)}$$
![[Pasted image 20260301140118.png]]
- Rouge : sans retard pur
- Bleu : avec retard pur

#### 1.1.4 - Bruit
Dans le pire des cas le bruit est de : $\boxed{0.3 \, V}$

#### 1.1.5 - Modèles statiques
##### a. Actionneur
$$T_{act}(t) = G_{act}V_{a}(t) + T_{act, 0}$$
Alors, comme $-50 = G_{act} \times 0 + T_{act, 0}$ : 
$$T_{act}(t)=  G_{act}V_{act}(t) -50$$
Alors, comme $100 = G_{act}\times 5 - 50$ 
Ainsi, 
$$\boxed{\begin{array}{c}
G_{act} = 30 \\
T_{act,0} = -50 ° C
\end{array}}$$

##### b. Capteur
$$V_{c}(t) = G_{capt} (T_{enc}(t)  + T_{capt,0})$$
Alors, 
$$0 \, V = G_{capt}(T_{enc, 5V} + T_{capt,0}) = G_{capt}(-5 + T_{capt, 0})$$
donc,
$$\boxed{T_{capt} = 5 ° C}$$
De plus, 
$$5V = G_{capt}(60 + 5)$$
Ainsi, 
$$\boxed{G_{capt} = \frac{1}{13}}$$



#### 1.1.6 - Température externe
C'est la température associée au voltage du début du schéma :
$$T_{enc}(t) =  \frac{1}{G_{capt}}V_{c}(t)-T_{capt, 0} = 13V_{c}(t) - 5$$
$$\boxed{T_{ext} = T_{enc}(0) = 9.95°C}$$

#### 1.1.7 - Fonction de transfert de la micro-enceinte climatique
Comme le gain du système est de $G_{enc} \times G_{act} \times G_{capt} = 2.3$ (mesuré sur le schéma)
Alors, 
$$G_{enc} = \frac{2.3}{G_{act}G_{capt}}$$
Donc
$$\boxed{G_{enc} = 1}$$
Ainsi, 
$$\boxed{H_{enc}(p) = \frac{1}{1+\tau p}}$$

#### 1.1.8 - Modèle du CAN et du CNA
##### a. Simulation numérique du système
Gain : 
Le gain idéal pour un CNA doît être unitaire : $\boxed{G_{CAN/CNA} = 1}$

Quantification : 
Comme le CAN et le CNA possèdent $1$ octets il y a $256$ possibilités pour une tension entre $0$ et $5 \, V$ : 
$$\boxed{Q = \frac{5}{256} = 19.5 \,m V}$$

Saturation : 
D'après le schéma la fréquence de saturation du CAN et du CNA est de $\boxed{5 \, V}$

###### b. Synthèse de la commande
Gain :
$\Delta s$ : On prend l'amplitude du bruit la plus grande 
$\Delta e$ : On prend la distance entre la valeur moyenne du maximum de l'amplitude et du minimum de l'amplitude
D'après le schéma : 
$$G_{bruit} = \frac{\Delta s}{\Delta e} = \frac{2.8 -2.45}{2.7-1.15} = 0.23$$
$$\boxed{G_{bruit} = 0.23}$$

#### 1.1.9 - Schéma fonctionnel
![[Pasted image 20260301151748.png]]
- $P_{b}(p)$ : Bruit de mesure
- $P_{u}(p)$ : Perturbation de la commande
- $R(p)$ : Consigne que doit suivre la sortie
- Modélisation compliquée des variations très lentes du système
- $U(p)$ : Entrée(s) du système (Commande actionneur)

## 1.2 Spécifications pour la synthèse de la commande
### 1.2.1 - Modèle à temps continu du système
![[Pasted image 20260316105448.png]]
Avec $H_{sys}(z)$ représentant la transformée en $Z$ de la fonction de transfert de l'enceinte et de la chaîne d’acquisition. 

#### a. Fonction de transfert
$$H_{sys}(p) = H_{BOZ}(p) H_{enc}(p)$$
Or la fonction de transfert d'un bloqueur d'ordre $0$ est : 
$$H_{BOZ}(p) = \frac{1-e^{ -pT_{e} }}{p}$$
Avec $T_{e}$ la période d’échantillonnage du CAN/CNA. 
Ainsi, 
$$\boxed{H_{sys}(p) = \frac{1-e^{ -pT_{e} }}{p + \tau p^{2}}}$$




#### b. Diagramme de Bode
Pour $T_{e} = \frac{1}{100}$
##### Gain
$$G_{dB}(\omega) = 20 \log(\left| H_{sys}(\omega)\right|)$$
En échelle logarithmique on a : 
![[Pasted image 20260316160459.png]]

##### Phase
$$\boxed{\varphi(\omega) = \arg(H_{sys}(\omega))}$$
En échelle logarithmique on a :
![[Pasted image 20260316160550.png]]

#### c. Majorant d'un retard pur
Le retard du CAN/CNA est de l'ordre de la $\mu s$ on peut donc le négliger alors on prend le retard pur de l'enceinte : 
$$\boxed{L_{\max} = 5 \, ms}$$

#### d. Amplitude du bruit de mesure
L'amplitude du bruit du capteur à été mesuré dans la partie précédente : 
$$\boxed{A_{bruit, capt} = 230 \, mV}$$

Le bruit de quantification du CAN/CNA est compris entre : 
$$-9.75 \, mV=-\frac{Q}{2} \leq G_{bruit, \mathrm{can}}(p) \leq \frac{Q}{2} = 9.75 \, mV$$
Donc, 
$$\boxed{A_{bruit, \mathrm{can}} = 19.5 \, mV}$$
Ainsi, 
$$\boxed{A_{bruit, \,total, \,\max} = 249.5 \, mV}$$

#### 1.2.2 Schéma du système commandé par un calculateur et précédé par un pré-filtre
![[Pasted image 20260316164226.png]]

#### 1.2.3 Spécification du cahier des charges
##### a. On traite la commande
On applique un échelon de température $Y_{C}(t)$ en commande puis on regarde la sortie $Y(t)$

##### b. On traite $P_{u}$ et $P_{y}$
$C$ doit contenir un intégrateur
Le gain statique de $F$ doit être égal à $1$
Si on applique un échelon de température $Y_{C}(t)$ en commande avant $F$ et que l'on regarde la sortie $Y(t)$, la différence : $Y_{c}(t)- Y(t)\underset{}{\longrightarrow} 0$.

##### c. On traite le bruit
$$\left| C(p)\right| \leq_{\omega \to \infty} N_{\max} = \frac{\left| U_{b}\right|}{\left| P_{b}\right|} = \frac{0.5}{0.1} = 5$$
$$Y_{C} = cte \underset{}{\longrightarrow} \text{mesure de } \left| U_{b}\right| $$

##### d. On traite $P_{y}$
Diagramme de Bode, Nyquist, Black-Nichols sur le calculateur

##### e. On traite $P_{u}$
On fais un échelon sur $P_{u}$ et on regarde la sortie $Y_{C}(t)= cte$ 
$$\min \left|\left| \frac{Y}{P_{u}} \right|\right|_{H_{2}} $$









# 1.2 Prof
#### Donnés
On a un retard max de $15$ ms et et un retard min (min????) de $20$ ms alors le retard total est de $L = 35$ms
$$M_{\varphi} \geq 45° \text{ et } M_{M}  \geq 0.5 \text{ et } M_{r} = 3 \times L$$
Avec $L$ le retard total. 
___
$$\left| C(p)\right| \leq N_{\max} = 5$$
#### Tests a faire selon le cahier des charges
###### a. On traite ma commande
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

# 1.3.1 Prof
#### Compensation du pôle dominant à temps continu
$$R(p) = KA = K(p+2) \text{ et } S(p) = p$$
$2$ car $\tau = 0.5$ et donc $\omega_{0} = \frac{1}{\tau} = 2$

Alors, 
$$C(p) = K \frac{p+2}{p} = 5 \frac{p+2}{p}$$
Car $N_{\max} = 5$. 
Alors, 
$$H_{BO}(p) = H(p) C(p) = \frac{G}{1+\tau p} \times 5\frac{p+z}{p} = \frac{5\times\frac{G}{\tau}}{p} = \frac{23}{p}$$



###### Calcul de la marge de module
(?)
$$M_{M} = \max_{\omega} \left| S_{y}(p)\right| = \left| \frac{Y}{P_{b}}\right| = \left| \frac{1}{1+H_{BO}}\right|$$
Alors, 
$$S_{y}(p) = \frac{p}{p+23} \Rightarrow \left| S_{y}\right| \leq 1$$

###### Calcul de la marge de retard
(Plus grand retard que l'on peut avoir dans la boucle)
$$M_{\text{retard}} = \frac{M_{\varphi}[rad]}{\omega_{c}} = \frac{\frac{\pi}{2}}{23} = 68 \, \text{ms}$$
on veut que : $(M_{\text{retard}})_{\text{désirée}} \leq M_{\text{retard}}$ 

Alors :
###### Il faut que l'on diminue $K$
$$(M_{\text{retard}})_{\text{désirée}} = 105 \, \text{ms} = \frac{M_{\varphi}}{\omega_{c}}$$
Alors, on veut que : $(M_{\text{retard}})_{\text{désirée}} \leq M_{\text{retard}}$ donc, 
$$\omega_{c} \leq \frac{M_{\varphi}}{(M_{\text{retard}})_{\text{désirée}}} = \frac{\frac{\pi}{2}}{0.105} = 15 \, \text{rad.s}^{-1}$$
Ainsi, 
$$\boxed{C(p) = 3.26 \times \frac{p+2}{p}}$$

$$C(z)$$

#### Avec pré-filtre
EXCAL5
$$H_{BF} = \frac{HC}{1+HC} = \frac{15}{p+15} = \frac{1}{1+\frac{p}{15}}$$

#### Sans pré-filtre
$F = 1$ : 
EXCAL6

EXCAL7

$$\frac{Y}{P_{u}} = \frac{H}{1+HC} = \frac{1}{C} H_{BF} = \dots$$



#### Schéma fonctionnel
EXCAL 4
- $P_{b}(p)$ : Bruit de mesure
- $P_{u}(p)$ : Perturbation de la commande
- $P_{y}(p)$ : Variations lentes $\Delta H(p)$ de $H(p)$
- $R(p)$ : Consigne que doit suivre la sortie
- $U(p)$ : Entrée(s) du système (Commande actionneur)



