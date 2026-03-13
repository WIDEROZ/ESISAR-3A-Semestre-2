#### Perturbations
Il y aura deux formes de perturbations : 
- $P_{u}(t)$ : Perturbations qui viennent s'additionner à la commande
- $P_{b}(t)$ : Perturbations de bruit qui vient s'additionner à la mesure

#### Robustesse
- Perturbations
- Variations au cours du temps ou de $H(p)$

#### Fonction de sensibilité
$$S(p) = \frac{d(\log(H_{BF}))}{d(\log(H))} = \frac{\frac{dH_{BF}}{H_{BF}}}{\frac{dH}{H}} \text{ avec  }H_{BF} = \frac{HC}{1+HC}$$
Permet de calculer l'influence de la variation de $H{(j\omega)}$ sur le système bouclé $H_{BF}$


#### Intégrale de Bode
$$\int_{0}^{+ \infty } \log \left| S(j\omega)\right| \, d\omega = \pi \sum_{i} \left| p_{i}\right| $$

#### Système stable
![[Pasted image 20260213092036.png]]
Ces $3$ assertions sont équivalentes : 
- Le système est stable
- Tous les $H_{i}(p)$ de $M(p)$ sont stables (entrée bornée, sortie bornée)
- Toutes les racines de l'équation caractéristique : $T(p) = 1+CH_{1}H_{2} = 0$ sont a partie réelle strictement négatives et qu'il n'y a pas de compensation de pôle instable de $C(p)$, $H_{1}(p)$ ou $H_{2}(p)$ par un zero instable de $C(p)$, $H_{1}(p)$ ou $H_{2}(p)$.


#### Théorème tout a fait compréhensible
![[Pasted image 20260213092701.png]]


## Contraintes sur le correcteur
![[Pasted image 20260313084916.png]]
$(U_{b})_{\max}$ : amplitude max que l'on se donne pour le bruit


#### Définition $H_{BO}$ et $\omega_{c}$
$$H_{BO} = HC$$
$$\left| H_{BO}(\omega_{c})\right| = 1$$

#### Plus grande valeur de $\omega_{c}$
On prend : 
$$\left| C(p)\right| \leq N_{\max} = \frac{(U_{b})_{\max}}{P_{b}} = 10$$
$$(\omega_{c})_{\max} = \max_{\omega}(N_{\max}\left| H(p)\right| = 1)$$
$$\left| H_{BO}(\omega_{c})\right| = \left| H(p)\right| \left| C(p)\right|\leq \left| H(p)\right| N_{\max} = 1 = \frac{2}{\sqrt{1+\omega_{c}^{2}}^{2}} \times 10$$
Alors, $\omega_{c, \max} \approx \sqrt{20}$ (on néglige $1$)

#### Choix du pré-filtre $F(p)$
![[Pasted image 20260313090427.png]]

#### Critère de phase
$$\omega_{\max} = \frac{\pi}{T_{e}} \geq 10^{N} \left| \text{poles les} + \text{rapides} \right| $$
On choisit $N= 2$ et les poles sont : $\{ 0, -2, -15 \}$ : 
Alors avec le pole le plus rapide : 
$$T_{e} \leq \frac{\pi}{1500} = 2 \, \text{ms}$$
Or la fréquence d’échantillonnage du CAN/CNA est de $100 \, \text{Hz}$ donc $T_{e} \geq 10 \, \text{ms}$ alors, si on prend : $T_{e} = 10 \, \text{ms}$ on a : 
$$\omega_{\max} = \frac{\pi}{T_{e}} = 20 \times 15 \text{ rad.s}^{-1}$$

