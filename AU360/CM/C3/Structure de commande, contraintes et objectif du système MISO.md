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
LDASE

