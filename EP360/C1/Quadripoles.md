# II. Les filtres
#### Passifs
$$\mathcal{P}_{sortie} \leq \mathcal{P}_{entrée}$$
(R, L, C)

#### Actifs
$$\mathcal{P}_{sortie} > \mathcal{P}_{entrée}$$
(R, L, C)
(Bip, Fet, AOP, Mofset)

## 1. Filtre idéal
#### Fonction de transfert
$$\underline{H}(j\omega) = \frac{\underline{V_{s}}}{\underline{{V_{e}}}} = H e^{ j\varphi }$$

#### Temps de propagation de groupe
$$\boxed{\tau = -\frac{d \varphi(\omega)}{d \omega} }$$

#### Retard de phase
$$\boxed{t_{0} = - \frac{\varphi(\omega)}{\omega}}$$

#### Filtre parfait
- $H(\omega)$ : constant par morceaux
- $\varphi(\omega)$ : Linéaire en $f(\omega) = -t_{0}\omega$

## 2. Bode réel
Ondulation dans la bande passante : 
$$20\log_{10}\left( \frac{H_{0}}{H_{1}} \right)$$
Fréquence de coupure à $-3dB$ ($-6dB$)
Fréquence atténuée : $f_{a}$
fréquence passante : $f_{p}$
Bande de transition : $f_{a} - f_{p}$

Schema

#### Calcul de pente
Soit la fonction de transfert suivante : 
$$H(j\omega) = \frac{H_{0}}{1+j \frac{\omega}{\omega_{0}}}$$
On veut le nombre de décibels par décade : 
On pose alors, $\omega_{2}=10\omega_{1}$
$$G_{dB}(\omega_{2}) = 20 \log_{10}(\left| H(j\omega_{2})\right|) = 20 \log_{10}(H_{0}) - 20\log\left(  \right) $$