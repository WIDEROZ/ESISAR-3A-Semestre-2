# Échantillonage
#### Filtre anti repliment de spectre
Sert à éliminer les composants fréquentielles supérieures à $\frac{f_{e}}{2}$.

#### Phase linéaire
$$\varphi(\omega) = - L\omega \text{ avec } L >0$$

#### Temps de groupe
$$\boxed{t_{g} = - \frac{d\varphi(\omega)}{d\omega}}$$

#### Bloqueur d'ordre $0$ (BOZ)
![[Pasted image 20260206085921.png]]

#### CAN
En premier on sature le signal avec des valeurs $x_{\min}$ et $x_{\max}$ 
Nombre de points de quantification : $2^{N}$

![[Pasted image 20260206090314.png]]

#### Lien entre la période d’échantillonnage et la période d'implémentation
Combien de Chiffres Significatifs doit on prendre en compte sur $z_{0}$ pour représenter le signal échantillonné en discret, 
On pose $p_{0} = \frac{1}{\tau}$ et $T_{0}$ : 
$$H_{c}(p) = \frac{1}{1+\tau p} \underset{T_{e}+\text{BOZ}}{\longrightarrow} H_{d}(z) = \frac{G(1-z_{0})z^{-1}}{1-z_{0}z^{-1}} \text{ avec }z_{0} = e^{ -\frac{T_e}{\tau} }$$
Ainsi, 
$$\boxed{\Delta _{\mathrm{imp}} = \frac{\partial z}{\partial p_{0}}  = \left| \frac{\delta p_{0}}{p_{0}}\right|p_{0}T_{0}}$$
#### A voir
![[Pasted image 20260206092803.png]]

#### Choix de  $T_{e}$ à partir du temps continu
Dépend du contexte mais on peut utiliser la Fréquence de Nyquist, car le spectre peut être réduit par le FAR

##### Gain pour un passe bas
Au delà d'un certain $\omega_{1}$, le gain de la fonction de transfert est inférieur à un $G_{\min}$ choisi. Souvent $G_{\min} = \frac{1}{10\,000}$ tous les signaux au dessus de ce $\omega_{0}$ ne sont plus considérés.

