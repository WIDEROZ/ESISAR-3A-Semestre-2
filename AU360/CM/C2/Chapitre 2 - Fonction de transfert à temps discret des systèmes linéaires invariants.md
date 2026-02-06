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
$$H_{d}(p) = \frac{1}{1+\tau p}$$
