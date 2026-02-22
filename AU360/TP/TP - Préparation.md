## 1.1 - Modélisation
#### Schema
EXCAL 1

#### Fonction de transfert
D'après le schéma on suppose que le système est linéaire de premier ordre : 
$$H(p) = \frac{G}{1+\tau p}$$
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
$$G = \frac{\Delta s}{\Delta e} = \frac{2.7 - 1.15}{2.33-1.66} \approx 2.3 \text{ V}$$

$$\boxed{G = 2.3 V}$$
#### Domaine de validité fréquentiel
Sur le schéma, $t \in [0, 8]$ (en secondes) Alors, $f \in \left[ \frac{1}{8}, + \infty \right[$ (en $Hz$)

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
T_{act,0} = 223.15
\end{array}}$$

##### Capteur -5 a 60
$$V_{c}(t) = G_{capt} (T_{enc}(t)  + T_{capt,0})$$
$$1.15 \, V = G_{capt}(T_{enc}(0) + T_{capt,0})$$

$$T_{enc,V}(V) = AV + T_{0} \text{ alors }T_{0} = 268.15 $$
Donc, 
$$A = 13$$
Ainsi, 
$$1.15 \, V = 2G_{capt}T_{capt,0} \Rightarrow G_{capt} = 2.1443 \times 10^{-3}$$

#### Température externe
C'est la température associée au voltage du début du schéma : 
$$T_{ext} = T_{enc}(0) = T_{enc,V}(1.54) = 15.02 °C$$

#### Fonction de transfert de la mico-enceinte climatique
$$TL[T_{enc}(t)] = \frac{1}{G_{capt}} TL[V_{c}(t)] - \frac{T_{capt,0}}{p}$$
$$TL[T_{act}(t)] = G_{act} TL[V_{a}(t)] +\frac{T_{act,0}}{p}$$
$$H_{enc}(p) = \frac{TL[T_{enc}(t)]}{TL[T_{act}(t)]} $$
$$= \frac{p}{\frac{G_{capt}G_{act}}{H(p)}p + T_{act,0}} - \frac{T_{capt,0}}{pG_{act} TL[V_{a}(t)] + T_{act,0}}$$
$$\boxed{H_{enc}(p) = \frac{\frac{p}{T_{act,0}}}{1+p\frac{G_{capt}G_{act}}{H(p)T_{act,0}}}  - \frac{\frac{ T_{capt,0}}{T_{act,0}}}{1+ p \frac{G_{act}}{T_{act,0}} TL[V_{a}(t)]}}$$
