## 1.1 - Modélisation
#### Schema
EXCAL 1

#### Fonction de transfert
D'après le schéma on suppose que le système est linéaire de premier ordre : 
$$H(p) = \frac{G}{1+\tau p}e^{ -t_{R}p }$$

##### Calcul de $\tau$
$$\tau = \frac{t_{\max} - t_{0}}{3} \text{ avec } t_{0} = 0.5 \text{ s} $$
Calcul de $t_{\max}$ : 
$$\Delta V = V_{\max} - V_{0} = 2.7 - 1.15 = 1.55 V$$
$$\Delta V \times 0.95 = 1.47 \text{ }V $$
$$V(3\tau) = 1.47 + 1.15 = 2.62 \, V$$
$$t_{\max} = 2 \text{s}$$
Donc, 
$$\boxed{\tau = 0.5}$$

##### Calcul de $G$
On prend le gain à l'entrée : 
$$G = \frac{\Delta s}{\Delta e} = \frac{2.7 - 1.15}{2.33-1.66} \approx 2.3$$
$$\boxed{G = 2.3}$$

##### Retard pur
On prend arbitrairement $1 \%$ du temps de réponse : 
$$\boxed{t_{R} \leq t_{R, \max} = 0.01 \tau = 5 \, ms}$$


#### Bode
EXCAL 2
Gain : 
$$\boxed{G_{db}(\omega) = 20 \log(\left| H(p)\right|) = 20\log\left( \frac{G}{\sqrt{1+(\omega \tau)^{2}}} \right)}$$
Phase : 
$$\arg(H(p)) = \arg(G) - \arg(1+j\omega \tau) = \arg(G) - \arctan(\omega \tau)=-\arctan(\omega \tau)$$
Donc, 
$$\boxed{\varphi = -\arctan(\omega \tau)}$$


#### Validité fréquentielle et retard
###### Validité fréquentielle
Plus on s'approche de la fréquence de coupure plus le signal a du retard d'après le diagramme de bode, alors on choisit de travailler en dessous de la fréquence de coupure. 

##### Retard pur
$$\left| \varphi\right| \leq \frac{\pi}{4}$$
si on prend les pulsations en dessous de $\omega = \frac{1}{\tau}$. 

#### Bruit
Dans le pire des cas le bruit est de : $0.3 \, V$

#### Modèles statiques
##### Actionneur
$$\begin{cases}
\forall t \in [0, 0.5], &T_{act}(t) = 1.66G_{act} + T_{act,0} \\
\forall t \in [0.5, 4],&T_{act}(t) = 2.33G_{act} + T_{act,0} \\
\forall t \in [4, 8],&T_{act}(t) = 1.83G_{act} + T_{act,0}
\end{cases}$$
Si on prend un modèle affine de la température ; 
$-50°C = 223.15° K$
$$T_{act}(V)=  AV +223.15 \Rightarrow A = \frac{(100+273.15)-223.15}{5} = 30$$
$$T_{act}(V) = 30V +223.15$$
Alors, 
$$\begin{cases}
\forall t \in [0, 0.5], &T_{act}(t) = 223.95 °K = -0.2 °C \\
\forall t \in [0.5, 4],&T_{act}(t) = 293.05 °K = 19.9°C \\
\forall t \in [4, 8],&T_{act}(t) = 278.05 °K = 4.9°C
\end{cases}$$
Donc, 
$$\begin{cases}
\forall t \in [0, 0.5], &272.95 = 1.66G_{act} + T_{act,0} \\
\forall t \in [0.5, 4],&293.05 = 2.33G_{act} + T_{act,0}
\end{cases}$$
$$293.05 = 2.33G_{act} + 272.95 - 1.66G_{act} \Rightarrow G_{act} = 30$$
$$T_{act,0} = 223.15$$
Ainsi, 
$$\boxed{\begin{array}{c}
G_{act} = 30 \\
T_{act,0} = 223.15 °K
\end{array}}$$

##### Capteur -5 a 60
$$V_{c}(t) = G_{capt} (T_{enc}(t)  + T_{capt,0})$$
Alors, 
$$0 \, V = G_{capt}(T_{enc, 5V} + T_{capt,0}) = G_{capt}(-5 + T_{capt, 0})$$
donc, $T_{capt} = 5 ° C$
De plus, 
$$5V = G_{capt}(60 + 5)$$
Ainsi, 
$$\boxed{G_{capt} = \frac{1}{13}}$$



#### Température externe
C'est la température associée au voltage du début du schéma : 
$$T_{enc}(V) =  13V-5$$
$$\boxed{T_{ext} = T_{enc}(0) = T_{enc,V}(1.15) =  9.95°C}$$

#### Fonction de transfert de la mico-enceinte climatique
Comme le gain du système est de $G_{enc} \times G_{act} \times G_{capt} = 2.3$ (mesuré sur le schéma)
Alors, 
$$\boxed{G_{enc} = 1}$$
Ainsi, 
$$\boxed{H_{enc}(p) = \frac{1}{1+\tau p}}$$



#### Modèle du CAN et du CNA
##### Simulation numérique du système
Gain : 
On prend un Gain unitaire : $\boxed{G_{CAN/CNA} = 1}$

Quantification : 
Comme le CAN et le CNA possèdent $1$ octets il y a $256$ possibilités pour une tension entre $0$ et $5 \, V$ : 
$$\boxed{Q = \frac{5}{256} = 19.5 \, mV}$$

Saturation : 
D'après le schéma la fréquence de saturation est de $\boxed{5 \, V}$

###### Synthèse de la commande
Gain :
$\Delta s$ : On a pris l'amplitude du bruit la plus grande 
$\Delta e$ : Valeur moyenne du capteur
D'après le schéma : 
$$G_{bruit} = \frac{\Delta s}{\Delta e} = \frac{2.8 -2.45}{2.7-1.15} = 0.23 $$
$$\boxed{G_{bruit} = 0.23}$$
Quantification :
Comme la quantification du CAN et du CNA donne des intervalles de $19.5 \, mV$, si le signal voulu est entre les bornes de cet intervalle on aura un bruit qui sera compris dans cet intervalle ie 
$$\boxed{\frac{Q}{2} = 9.75 \, mV}$$



#### Schéma fonctionnel
EXCAL 3
- $P_{b}(p)$ : Bruit de mesure
- $P_{u}(p)$ : Perturbation de la commande
- $P_{y}(p)$ : Variations lentes $\Delta H(p)$ de $H(p)$
- $R(p)$ : Consigne que doit suivre la sortie
- $U(p)$ : Entrée(s) du système (Commande actionneur)

## 1.2 Spécifications pour la synthèse de la commande
#### Modélisation du système
On prend une fonction de transfert d'ordre $2$ : 
$$\boxed{T(u) = \frac{G}{1+2\xi u + u^{2}} e^{  -t_{R} \omega_{0} u }}$$
avec : 
- $\xi$ le coefficient d'amortissement
- $u = \frac{p}{\omega_{0}}$
- $\omega_{0} = \frac{1}{\tau}$ la pulsation propre du système
- $G$ le gain

##### Validité fréquentielle
$$T(p) = \frac{G}{1+\frac{2\xi}{\omega_{0}}  p + \left( \frac{\omega}{\omega_{0}} \right)^{2}} e^{ -t_{R}p }$$
$$\boxed{G_{dB} =  20 \log(G) - 10 \log\left( \left( 1-\left( \frac{\omega}{\omega_{0}} \right)^{2} \right)^{2} + 4 \left( \frac{\xi \omega}{\omega_{0}} \right)^{2} \right)}$$
$$\varphi = \mathrm{arg}(T(p)) = -t_{R}\omega- \mathrm{arg}\left( 1- \left( \frac{\omega}{\omega_{0}} \right)^{2}+j\frac{2\xi}{\omega_{0}} \omega \right)  $$
Si $\omega \leq \omega_{0}$ : 
$$\boxed{\varphi = -t_{R}\omega -\arctan\left( \frac{\frac{\omega_{0}}{\omega}- \frac{\omega}{\omega_{0}} }{2\xi} \right)}$$
Si $\omega \geq \omega_{0}$ : 
$$\boxed{\varphi =\pi -t_{R}\omega -\arctan\left( \frac{\frac{\omega_{0}}{\omega}- \frac{\omega}{\omega_{0}} }{2\xi} \right) }$$

##### Retard pur
De même que précédemment : 
$$\boxed{t_{R} \leq t_{R, \max} = 5 \, ms}$$
$$$$





#### Schéma fonctionnel
EXCAL 4
- $P_{b}(p)$ : Bruit de mesure
- $P_{u}(p)$ : Perturbation de la commande
- $P_{y}(p)$ : Variations lentes $\Delta H(p)$ de $H(p)$
- $R(p)$ : Consigne que doit suivre la sortie
- $U(p)$ : Entrée(s) du système (Commande actionneur)
