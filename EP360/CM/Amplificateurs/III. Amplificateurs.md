### 1. Angle de conduction
$$\theta_{c} = \omega T_{c}$$ 
#### Distortion Harmonique
Soit $S_{k}$ n'amplitude de l'harmonique $k$
$$\boxed{\mathrm{THD} = \sqrt{\sum_{k = 2}^{+ \infty} H_{k}^{2}} \text{ avec } H_{k} = \frac{S_{k}}{S_{1}}}$$
exprimé en $\%$
Taux de distortion harmonique

Pour un ampli parfait : $\mathrm{THD} = 0$

### 2. Puissance
![[Pasted image 20260203105951.png]]
#### Rendement
$$\boxed{\eta = \frac{P_{u}}{P_{tot}}}$$



# I - Classe d'amplificateurs
#### Classe $A$
$$\begin{array}{l}
\theta_{c} = 2\pi \\
\eta : \text{à chier} \\
\mathrm{THD} : \text{ très bon} \\
\text{Grande linéarité} \\
\text{Faible puissance} \,(< 50 W) \\
\text{HI-FI}
\end{array}$$

#### Classe $B$ et $AB$
$$\begin{array}{l}
\theta_{c} = \pi - \varepsilon \\
\text{Compromis : }\eta \nearrow \text{ et } \mathrm{THD} \searrow \\
\text{Linéarité} \\
\text{Puissance} < 500W \\
\text{HI-FI} 
\end{array}$$

#### Classe $C$
$$\begin{array}{l}
\theta_{c} \ll \pi \\
n\nearrow \nearrow  \text{ et } \mathrm{THD}\searrow\searrow \\
\text{Haute fréquencce de forte pusisance} \sim KW \\
\text{TV / Radio}
\end{array}$$


#### Classe $D$
$$\begin{array}{l}
\theta_{c} \approx 0 \\
\eta : \text{INCROYABLE} \\
\mathrm{THD} : \text{à chier} \\
\text{Autoradio} / \text{Téléphone}
\end{array}$$


# II - Exemple d'amplificateurs
## 1. Quadripôle amplificateur 
![[Pasted image 20260203111523.png]]
Soit $A_{v} = \frac{V_{s}}{V_{e}}$ (pour $i_{s} = 0$)
#### Gain en charge
$$\boxed{A_{vc} = \left. \frac{V_{s}}{V_{e}} \right|_{Z_{u}} = \frac{Z_{u}}{Z_{s} + Z_{u}} A_{v}}$$

#### Gain Composite
$$\boxed{A_{vc} = \left. \frac{V_{s}}{e_{g}}\right|_{i_{s} = 0} = \frac{Z_{e}}{Z_{e} + R_{g}} A_{v}}$$

## 2. Transistor Bipolaire
![[Pasted image 20260203112213.png]]


## 3. Transistor à effet de champ canal $N$
![[Pasted image 20260203111957.png]]
#### Courant au Drain
$$\boxed{I_{D} = I_{Dss}(V_{p} + V_{GS})^{2}}$$
#### Caractéristique du transistor
![[Pasted image 20260203112351.png]]
$V_{p}$ : Tension de pincement

#### Schema équivalent
![[Pasted image 20260203112608.png]]

## 4. Transistor MOSFET
![[Pasted image 20260203112637.png]]

#### Caractéristique du transistor
![[Pasted image 20260203112717.png]]
$V_{th}$ : Tension de seuil

#### Schema équivalent
![[Pasted image 20260203112608.png]]

## 5. AOP
#### Schema équivalent
![[Pasted image 20260203112857.png]]

# III - Étude d'un amplificateur de Classe $A$
## 1. Montage
![[Pasted image 20260203113734.png]]

