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
$$V(3\tau) = 1.47 + 1.15 = 2.62$$
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
$$1.15 \, V = G_{capt}(T_{enc}(0) + T_{capt,0})$$

$$T_{enc,V}(V) = AV + T_{0} \text{ alors }T_{0} = 268.15 $$
Donc, 
$$A = 13$$
Ainsi, 
$$1.15 \, V = G_{capt}(T_{enc}(0) + T_{capt,0}) = G_{capt}(13 \times 1.15 + 2 T_{capt, 0})$$
Ainsi, 
$$G_{capt} = $$


#### Température externe
C'est la température associée au voltage du début du schéma : 
$$T_{ext} = T_{enc}(0) = T_{enc,V}(1.54) = 15.02 °C$$

#### Fonction de transfert de la mico-enceinte climatique
$$TL[T_{enc}(t)] = \frac{1}{G_{capt}} TL[V_{c}(t)] - \frac{T_{capt,0}}{p}$$
$$TL[T_{act}(t)] = G_{act} TL[V_{a}(t)] +\frac{T_{act,0}}{p}$$
$$H_{enc}(p) = \frac{TL[T_{enc}(t)]}{TL[T_{act}(t)]} $$
$$= \frac{p}{\frac{G_{capt}G_{act}}{H(p)}p + T_{act,0}} - \frac{T_{capt,0}}{pG_{act} TL[V_{a}(t)] + T_{act,0}}$$
$$\boxed{H_{enc}(p) = \frac{\frac{p}{T_{act,0}}}{1+p\frac{G_{capt}G_{act}}{H(p)T_{act,0}}}  - \frac{\frac{ T_{capt,0}}{T_{act,0}}}{1+ p \frac{G_{act}}{T_{act,0}} TL[V_{a}(t)]}}$$

#### Modèle du CAN et du CNA
##### Simulation numérique du système
Gain : 
On prend un Gain unitaire : $\boxed{G_{CAN/CNA} = 1}$

Quantification : 
Comme le CAN et le CNA possèdent $1$ octets il y a $256$ possibilités pour une tension entre $0$ et $5 \, V$ : 
$$\boxed{Q = \frac{5}{265} = 19.5 \, mV}$$

Saturation : 
D'après le schéma la fréquence de saturation est de $\boxed{2.7 \, V}$

###### Synthèse de la commande
Gain :
D'après le schéma : 
$$G_{bruit} = \frac{\Delta s}{\Delta e} = \frac{2.8-1.35}{2.7-1.15} = 0.94$$
$$\boxed{G_{bruit} = 0.94}$$
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
