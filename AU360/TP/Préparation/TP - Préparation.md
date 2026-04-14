# Sommaire

>[!Sommaire]
>
> [[#^a1|1.1 - Modélisation]]
> > [[#^a11|1.1.1 - Schéma]]
> > [[#^a12|1.1.2 - Fonction de Transfert]] 
> > [[#^a13|1.1.3 - Diagramme de Bode]]
> > [[#^a14|1.1.4 - Bruit]]
> > [[#^a15 |1.1.5 - Modèles statiques]]
> > [[#^a16 |1.1.6 - Température externe]]
> > [[#^a17 |1.1.7 - Fonction de transfert de la micro-enceinte climatique]]
> > [[#^a18|1.1.8 - Modèle du CAN/CNA]]
> > [[#^a19|1.1.9 - Schéma Fonctionnel]]
>
> [[#^a2|1.2 - Spécifications de la synthèse de la commande]]
> > [[#^a21|1.2.1 - Modèle à temps continu du système]]
> > [[#^a22|1.2.2 - Schéma du système commandé par un calculateur et précédé par un pré-filtre]]
> > [[#^a23|1.2.3 - Spécifications du cahier des charges]]
>


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
$$H_{t_{R}}(p)=H(p)e^{ -t_{R}p }$$
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
###### Avec un retard pur
$$\arg(H(p)) = \arg(G)+\arg(e^{ -t_{R}j\omega}) - \arg(1+j\omega \tau) $$
$$= -\omega t_{R} - \arctan(\omega \tau)$$
Donc, 
$$\boxed{\varphi = -\omega t_{R} - \arctan(\omega \tau)}$$
![[Pasted image 20260301140118.png]]
- Rouge : sans retard pur
- Bleu : avec retard pur
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
- $H_{sys}(p)$ : Fonction de transfert de l'enceinte et de la chaîne d’acquisition. 
- $C(p)$ : Fonction de transfert du calculateur
- $F(p)$ : Fonction de transfert du filtre
- $R(p)$ : Consigne
- $R_{f}(p)$ : Consigne filtrée (pour éviter le dépassement)
- $U(p)$ : Commande du calculateur

#### a. Fonction de transfert
$$H_{sys}(p) = H_{BOZ}(p) H_{enc}(p)$$
Or la fonction de transfert d'un bloqueur d'ordre $0$ est : 
$$H_{BOZ}(p) = \frac{1-e^{ -pT_{e} }}{p}$$
Avec $T_{e}$ la période d’échantillonnage du CAN/CNA. 
De plus comme d'après le 1.1.7 (Fonction de transfert de l'enceinte) : 
$$H_{enc}(p) = \frac{1}{1+\tau p}$$
Ainsi, 
$$\boxed{H_{sys}(p) = \frac{1-e^{ -pT_{e} }}{p + \tau p^{2}}}$$


#### b. Diagramme de Bode
Pour $T_{e} = \frac{1}{100}$ la période d'échantillonnage minimale du CAN/CNA
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
$$\boxed{A_{bruit, \,total, \,\max} = 19.5 + 230 = 249.5 \, mV}$$

#### 1.2.2 - Schéma du système commandé par un calculateur et précédé par un pré-filtre ^a22
![[Pasted image 20260316164226.png]]

#### 1.2.3 - Spécification du cahier des charges ^a23
##### a. On traite la commande
On applique un échelon de température $Y_{C}(t)$ en commande puis on regarde la sortie $Y(t)$ 
![[Pasted image 20260408175715.png]]
Ainsi $T_{d}$ doit être inférieur à : $5\%$ de $T$ : $\boxed{T_{d} \leq 5 \% T}$
Il faudra alors faire en sorte que le <u>calculateur et le filtre</u> respectent cette spécification.

##### b. On traite $P_{u}$ et $P_{y}$
$C$ doit contenir un intégrateur
Le gain statique de $F$ doit être égal à $1$ ($F(0)=1$)
Si on applique un échelon de température $Y_{C}(t)$ en commande avant $F$ et que l'on regarde la sortie $Y(t)$, la différence : $e(t) = Y_{c}(t)- Y(t)\underset{t \to + \infty}{\longrightarrow} 0 = e_{stat}$.

##### c. On traite le bruit $P_{b}$ en hautes fréquences
$$\left| C(p)\right| \leq_{\omega \to \infty} N_{\max} = \frac{\left| U_{b}\right|}{\left| P_{b}\right|} = \frac{5}{0.1} = 50$$
On applique une consigne telle que la tension de commande soit maximale ($5 \, V$) puis on mesure $\left| P_{b}\right|$ et on vérifie que $\left| P_{b}\right|$ ne dépasse pas $10 \%$ de $\left| U_{b}\right|$ : $\left| P_{b}\right| = 0.1$ et $\left| U_{b}\right| = 5 \, V$ alors comme : $10\%\left| U_{b}\right| = 5$ et que $0.1\leq 5$ : $\boxed{\left| P_{b}\right| \leq 10\% \left| U_{b}\right|}$.
Le <u>calculateur</u> devra respecter ce critère. 


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
$$H_{enc}(p) = \frac{G}{1 + \tau p}$$
On prend le pôle le plus rapide : $-\frac{1}{\tau}$, 
$$R(p) = K\left( p+\frac{1}{\tau} \right)= K(p+2) \text{ donc } S(p) = p$$
Donc, 
$$C(p) = K \frac{p+2}{p} = 5 \frac{p+2}{p}$$
Car $\left| C(p)\right| \underset{\omega \to + \infty}{=}N_{\max} = 5$. 
Alors, 
$$H_{BO}(p) = H_{enc}(p) C(p) = \frac{G}{1+\tau p} \times 5\frac{p+2}{p} = \frac{5\times\frac{G}{\tau}}{p} = \frac{23}{p}$$


###### Calcul de la marge de module
$$M_{M} = \max_{\omega} \left| S_{y}(p)\right| = \left| \frac{1}{1+H_{BO}(p)}\right|$$
Alors, 
$$S_{y}(p) = \frac{p}{p+23} \Rightarrow \left| S_{y}\right| \leq 1$$
Ainsi, $\boxed{M_{M} = 1 \geq 0.5}$ Le cahier des charges est bien suivi.
	
###### Calcul de la marge de phase
$$\boxed{M_{\varphi} = \pi + \arg(H_{BO}(p)_{\left| H_{BO}(\omega_{c})\right| = 1}) = \pi + \arg(-j) = \frac{\pi}{2} }$$
$\boxed{M_{\varphi} = \frac{\pi}{2}\geq \frac{\pi}{4}}$ Le cahier des charges est bien suivi.

###### Calcul de la marge de retard
(Plus grand retard que l'on peut avoir dans la boucle)
Ainsi, 
$$\boxed{M_{retard}  = \frac{M_{\varphi}}{\omega_{c}} = \frac{\frac{\pi}{2}}{23} = 68 \, \text{ms}}$$
on veut que : $(M_{\text{retard}})_{\text{désirée}} = 105 \, \text{ms}\leq M_{\text{retard}}$ or $105 \, \text{ms}\nleq 68 \, \text{ms}$, alors Il faut que l'on diminue $K$ : 
$$(M_{\text{retard}})_{\text{désirée}} = 105 \, \text{ms} = \frac{M_{\varphi}}{\omega_{c}}$$
Alors, on veut que : $(M_{\text{retard}})_{\text{désirée}} \leq M_{\text{retard}}$ donc, 
$$\omega_{c} \leq \frac{M_{\varphi}}{(M_{\text{retard}})_{\text{désirée}}} = \frac{\frac{\pi}{2}}{0.105} = 15 \, \text{rad.s}^{-1}$$
Donc comme : $H_{BO}(p) =\frac{K \times \frac{G}{\tau}}{p}$ on a : $\left| H_{BO}(\omega_{c})\right| = 1 = \frac{K \times \frac{G}{\tau}}{\omega_{c}}$, alors $K = \frac{\omega_{c}}{\frac{G}{\tau}} = 3.26$
Ainsi, 
$$\boxed{C(p) = 3.26 \times \frac{p+2}{p}}$$



#### 1.3.1.2 - Nécessité d'utiliser un préfiltre ^a312
Comme : $H_{BO}(p)= \frac{K \times \frac{G}{\tau}}{p} = \frac{15}{p}$ alors, 
$$H_{BF}(p) = \frac{H(p)C(p)}{1+H(p)C(p)} = \frac{15}{p+15} = \frac{1}{1+\frac{p}{15}}$$
Dans le cas ou il n'y a pas de filtre on applique un échelon de consigne : $Y_{C}(t) = T °C$ alors en appliquant la transformée de Laplace : $Y_{C}(p) = \frac{T}{p}$ donc : 
$$Y(p) = H_{BF}(p)Y_{C}(p) = \frac{15}{p(p+15)}T = \left( \frac{1}{p}-\frac{1}{p+15} \right)T$$
Ainsi, 
$$\boxed{Y(t) = \mathcal{L}^{-1}(Y(p)) = T(1-e^{ -15t }) }$$
![[Pasted image 20260409221409.png]]
Il n'y a pas de dépassement ainsi l'<u>utilisation d'un préfiltre dans ce cas n'est pas utile</u>. 

##### a. Echelon de consigne
Comme on a une réponse exponentielle : $Y(t) = T\left( 1-e^{ -\frac{t}{\tau_{_{y}}} } \right)$ (en posant $\tau_{y}=\frac{1}{15}$) on peut facilement calculer le temps de réponse à $95\%$ qui est de $\boxed{t_{r} =3 \tau_{y} = 0.2 \, s}$

##### b. Perturbation de commande
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

##### c. Retard additionnel admissible



#### 1.3.1.2 - Implantation du calculateur à temps discret ^a312
$$\boxed{T_{e} = 10 \, \text{ms}}$$

#### 1.3.1.4 - Filtre anti-repliement de spectre ^a314
On veut supprimer les composantes spectrales supérieures à $\frac{f_{e}}{2}$ ($f_{e}=\frac{1}{T_{e}}$ la fréquence d'échantillonnage) pour respecter le critère de Shannon : $f_{\max}\leq \frac{f_{e}}{2}$ (et donc éviter le repliement de spectre)
![[Pasted image 20260410142719.png]]
On choisit donc un filtre passe bas idéal de gain unitaire et fréquence de coupure : $\frac{f_{e}}{}$ (i.e. $\omega_{c} = \omega_{0} = \pi f_{e}$)
![[Pasted image 20260410150319.png]]
$$H_{FAR}(f) = \mathrm{Rect}_{f_{e}}(f) \overset{TF^{-1}}{\Rightarrow} h_{FAR}(t) = f_{e}\mathrm{sinc}\left( \pi f_{e} t \right)$$
Donc, on rend le filtre causal pour assurer la stabilité du filtre : 
$$y(n) = f_{e} \sum_{k = 0}^{+ \infty} \mathrm{sinc}\left( \pi f_{e}k \right)x(n-k)$$
$\forall n \in \mathbb{N}, x(n) \text{ l'entrée} \text{ et } y(n) \text{ la sortie à temps discret du filtre}$
Ainsi on applique la transformée en $z$ : 
$$\boxed{ H_{FAR}(z)= \frac{y(n)}{x(n)} =f_{e} \sum_{k = 0}^{+ \infty} \mathrm{sinc}\left( \pi f_{e}k \right)z^{-k}}$$
On peut donc facilement choisir l'ordre de ce filtre en arrêtant la somme à l'ordre voulu. 

#### 1.3.1.5 - Fonction de transfert du calculateur à temps discret ^a315
$$C(p) = 3.26 \frac{p+2}{p} \Leftrightarrow C(z) =  3.26 \frac{1+2T_{e}-z^{-1}}{1-z^{-1}} $$
$$C(p) =  3.26 \frac{0.98p+2}{p} \Leftrightarrow C(z) =  3.26 \frac{1-(1-2T_{e})z^{-1}}{1-z^{-1}} $$
($1+2T_{e}=1.02$ et $1-2T_{e}=0.98$)

#### 1.3.1.6 - Fonctions de transfert à temps discret implémentés ^a316
$$H_{enc}(z) = \frac{G}{1+\frac{\tau}{T_{e}} (1-z^{-1})}=\frac{\frac{G}{1+\frac{\tau}{T_{e}}}}{1- \frac{1}{1+\frac{T_{e}}{\tau}}z^{-1}}=\frac{0.045}{1-2.255z^{-1}}$$
$$C(z) = 3.26 \frac{1-0.98z^{-1}}{1-z^{-1}}$$



#### 1.3.1.7 - Algorithme de commande ^a317
On convertit l'expressions de la fonction de transfert en $z$ de $C$ en $n$ avec les entrées-sorties associés : 
$$U(z) = C(z)\varepsilon(z) = U(z)(1-z^{-1}) = 3.26(1-0.98z^{-1})\varepsilon(z)$$
Alors, 
$$\boxed{U(n)=U(n-1) + 3.26(\varepsilon(n)-0.98\varepsilon(n-1))}$$
```
Entrées : U(n-1), ε(n), ε(n-1)
	max=5;
	min=0;
	
	U(n) = U(n-1) + 3.26*(ε(n)-0.98ε(n-1));
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
On convertit toutes les expressions des fonctions de transfert en $z$ en $n$ avec les entrées sorties associés.

###### Enceinte :
$$Y(z)=H(z)U(z) \Leftrightarrow Y(z)\left( 1-\frac{1}{1+\frac{T_{e}}{\tau}}z^{-1} \right) = \frac{G}{1+\frac{\tau}{T_{e}}}U(z)$$
Alors, 
$$ \boxed{Y(n) = \frac{1}{1+\frac{T_{e}}{\tau}}Y(n-1) + \frac{G}{1+\frac{\tau}{T_{e}}}U(n)}$$



```C
int N=500;

float G=2.3;
float tau=0.5;
float fe=100;
float Te=1/fe;


uint8_t H_discret(uint8_t U, uint8_t Y){
	return 1/(1+Te/tau)*Y + G/(1+tau/Te)*U;
}

uint8_t[N] C_discret_tableau(uint8_t Yc){
	uint8_t Y = Yc[0];
	int erreur=Yc[0]-Y;
	
	uint8_t U[N];
	
	int tmp;
	
	for(int n=1; n < N; n++){
		tmp = 0.98*erreur; // err = Yc(n-1)-Y(n-1)
		Y = H_discret(U[n], Y); // Y(n)
		erreur = Yc[n]-Y; // Yc(n)-Y(n)
		U[n] = U[n-1] + 3.26*(erreur-tmp); // U(n)
	}
	
	
	return U;
}


uint8_t C_discret(uint8_t Yc, uint8_t Yc_avant, uint8_t Y_avant, uint8_t U){
	int erreur=Yc_avant-Y_avant;
	int Y;
	int tmp;
	
	
	tmp = 0.98*erreur; // err = Yc(n-1)-Y(n-1)
	Y = H_discret(U, Y_avant); // Y(n)
	erreur = Yc-Y; // Yc(n)-Y(n)
	U = U + 3.26*(erreur-tmp); // U(n)
	
	return U;
}
```


### 1.3.2 - Synthèse par placement des pôles de la boucle fermée à temps continu ^a32
#### 1.3.2.1 - Méthode de placement des pôles de la boucle fermée ^a321
On définit : 
$$C(p) = \frac{R(p)}{S(p)} \text{ et }H(p) = \frac{B(p)}{A(p)} \text{ et } F(p) = \frac{T(p)}{R(p)}$$
##### a. Choix des degrés 
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
Donc, 
$$\begin{cases}
d_{1} = 2(1+Gr_{1}) \\
d_{0} = 2Gr_{0}
\end{cases}$$
Or les pôles de la boucle fermée sont : 
$$D(p) = (p+p_{0})^{2} = p^{2}+2p_{0}p + p_{0}^{2}$$
Ainsi, 
$$\boxed{\begin{cases}
1+Gr_{1} = p_{0} \\
2Gr_{0}=p_{0}^{2}
\end{cases} \Leftrightarrow \begin{cases}
r_{1} = \frac{p_{0}-1}{G} \\
r_{0} = \frac{p_{0}^{2}}{2G}
\end{cases}}$$
De plus, 
$$(1+Gr_{1})^{2} = p_{0}^{2}=2Gr_{0} \Leftrightarrow r_{0} = \frac{(1+Gr_{1})^{2}}{2G}$$
Alors, 
$$C(p) = \frac{r_{1}p+r_{0}}{p}$$

##### b. Gain en haute fréquence du correcteur
$$C(p) \underset{p\to + \infty}{=} r_{1} = \frac{p_{0}-1}{G} \leq N_{\max} = 5$$
Alors, 
$$p_{0} \leq \frac{5+1}{G} = 2.6$$

##### c. Calcul des marges
###### Marge de module
$$\min(1+\left| H_{BO}(p)\right|) = M_{M} > 0.5$$
$$\left| C(p)H(p)\right| = 2G\left| \frac{r_{1}p+r_{0}}{p(p+2)}\right|=\frac{2G}{\omega_{c}\sqrt{\omega_{c}^{2}+2}} \sqrt{r_{1}^{2}+r_{0}^{2}}= 3.34$$
(pour $p_{0}=2.6$)

$$\max(\left| S_{y}(p)\right|) = \max \left| \frac{1}{1+C(p)H(p)}\right|$$

$$S_{y}(p) = \frac{p(p+2)}{p(p+2)+2G(r_{1}p+r_{0})} = \frac{p^{2}+2p}{p^{2} + 2p_{0}p + p_{0}}$$

Alors, 
$$S_{y}(j\omega) = \frac{\omega^{2}-2j\omega}{(\omega-jp_{0})^{2}}$$
$$f(\omega) = \frac{\omega \sqrt{\omega^{2}+4}}{\omega^{2}+p_{0}^{2}}=\left| S_{y}(p)\right|$$
$$f'(\omega) = \frac{\left( \sqrt{\omega^{2}+4} + \frac{\omega^{2}}{\sqrt{\omega^{2}+4}} \right)(\omega^{2}+p_{0}^{2})-2\omega^{2} \sqrt{\omega^{2}+4}}{(\omega^{2}+p_{0}^{2})^{2}} $$
$$f'(\omega) = 0 \Leftrightarrow (p_{0}^{2}-\omega^{2})\sqrt{\omega^{2}+4} + (\omega^{2}+p_{0}^{2})\frac{\omega^{2}}{\sqrt{\omega^{2}+4}}=0$$
$$\Leftrightarrow (\omega^{2}-p_{0}^{2})(\omega^{2}+4) = (\omega^{2}+p_{0}^{2})\omega^{2}$$
$$\Leftrightarrow \omega^{2} (4- p_{0}^{2})-4p_{0}^{2} = p_{0}^{2}\omega^{2} \Leftrightarrow (4-2p_{0}^{2})\omega^{2}=4p_{0}^{2} $$
$$\Leftrightarrow \omega = p_{0}\sqrt{\frac{2}{2-p_{0}^{2}}}$$

$$f'(\omega)> 0 \Leftrightarrow \omega < p_{0}\sqrt{\frac{2}{2-p_{0}^{2}}} \text{ et } f'(\omega)< 0 \Leftrightarrow \omega > p_{0}\sqrt{\frac{2}{2-p_{0}^{2}}}$$
donc $0< p_{0} < \sqrt{2}$


###### Marge de phase
$$\pi + \arg(H_{BO}(p)_{H_{BO}(j\omega_{c}) = 1})=M_{\varphi} > 45°$$
$$\left| H_{BO}(j\omega_{c})\right| = 1 = 2G\left| \frac{r_{1}j\omega_{c}+r_{0}}{2j\omega_{c}-\omega_{c}^{2}}\right| = \frac{2G}{\omega_{c}} \frac{\sqrt{r_{1}^{2}\omega_{c} + r_{0}^{2}}}{\sqrt{4+\omega_{c}^{2}}} $$
$$\Leftrightarrow \omega_{c}\sqrt{\omega_{c}^{2}+4} = 2G\sqrt{r_{1}^{2}\omega_{c}^{2}+r_{0}^{2}} \Leftrightarrow \omega_{c}^{4}+4\omega_{c}^{2} = 4G^{2}(r_{1}^{2}\omega_{c}^{2} +r_{0}^{2})$$
$$\Leftrightarrow \omega_{c}^{4}+ 4(1-(Gr_{1})^{2})\omega_{c}^{2} = 4G^{2}r_{0}^{2}$$
On pose $X=\omega_{c}^{2}$,
$$\Leftrightarrow X^{2}+4(1-(Gr_{1})^{2})X - (2Gr_{0})^{2} = 0$$
___
$$1+Gr_{1}=p_{0} \Leftrightarrow (Gr_{1})^{2} = (p_{0}-1)^{2} $$
$$\Leftrightarrow 4(1-(Gr_{1})^{2}) = 4(1-(p_{0}-1)^{2})$$
___
$$\Leftrightarrow X^{2} + 4(1-(p_{0}-1)^{2})X - p_{0}^{4} = 0$$
$$\Delta = 16(1-(p_{0}-1)^{2})^{2}+4p_{0}^{4}\geq0$$
Alors, 
$$\Delta = 20p_{0}^{4}-64p_{0}^{3}+64p_{0}^{2} = p_{0}^{2}(20p_{0}^{2}-64p_{0}+64)$$
Alors, 
$$X = p_{0}(2p_{0}-4) \pm p_{0}\sqrt{5p_{0}^{2}-16p_{0}+16}$$
$$= p_{0}(2p_{0}-4 + \sqrt{5p_{0}^{2}-16p_{0}+16})$$
$$\omega_{c} = \sqrt{X}$$

$$H_{BO}(j\omega_{c}) = 2G\frac{r_{1}j\omega_{c}+r_{0}}{2j\omega_{c}-\omega_{c}^{2}} = 4.6 \frac{r_{1}j\omega_{c}+r_{0}}{2j\omega_{c}-\omega_{c}^{2}}$$
Alors, 
$$M_{\varphi} = \pi + \arg(r_{1}j\omega_{c}+r_{0}) - \arg(2j\omega_{c}-\omega_{c}^{2}) $$
Donc, 
$$M_{\varphi}= \pi + \left( \arctan\left( \frac{r_{1}}{r_{0}} \right) -\left( \pi+\arctan\left( \frac{2}{\omega_{c}} \right) \right) \right)$$
Donc, 
$$M_{\varphi} = \arctan\left( \frac{r_{1}}{r_{0}}\right)-\arctan\left( \frac{2}{\omega_{c}} \right) > \frac{\pi}{4} $$
Or, 
$$\frac{r_{1}}{r_{0}} = 2 \frac{p_{0}-1}{p_{0}^{2}}$$
Donc, 
$$\arctan\left( 2 \frac{p_{0}-1}{p_{0}^{2}} \right) > \frac{\pi}{4} + \arctan\left( \frac{2}{\omega_{c}} \right) = \arctan\left( \frac{1+\frac{2}{\omega_{c}}}{1-\frac{2}{\omega_{c}}} \right)$$
Ainsi, 
$$2\frac{p_{0}-1}{p_{0}^{2}} > \frac{\omega_{c}+2}{\omega_{c}-2}$$
