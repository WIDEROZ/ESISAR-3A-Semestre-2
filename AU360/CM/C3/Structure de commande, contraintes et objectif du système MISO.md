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
