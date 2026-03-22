# I - Filtre actif de Tchebychev
## 1. Etude de la cellule Sallen-Key
![[Pasted image 20260321144951.png]]

### Rapport entre $V_{1}$ et $V_{2}$
![[Pasted image 20260321145023.png]]
Par la loi des mailles : 
$$V_{2} = \frac{Y_{eq}}{Y_{eq}+Y_{5}} V_{C_{2}} = \frac{Y_{3}+Y_{4}}{Y_{3}+Y_{4}+Y_{5}} V_{C_{2}}$$

![[Pasted image 20260321145202.png]]
Par la loi des mailles :
$$V_{2}= \frac{Y_{3}+Y_{4}}{Y_{3}+Y_{4}+Y_{5}} \frac{Y_{1}}{Y_{1}+Y_{2}} V_{1}$$

Ainsi, 
$$\boxed{\frac{\underline{V_{2}}}{\underline{V_{1}}} = \frac{Y_{1}(Y_{3}+Y_{4})}{(Y_{1}+Y_{2})(Y_{3}+Y_{4}+Y_{5})}}$$
Autre manière : 
$$\underline{V_{c_{2}}} = \frac{Y_{1}}{Y_{1}+Y_{2}} \underline{V_{1}}$$
et 
$$\underline{V_{2}} = \frac{Y_{3}}{Y_{3}+Y_{5}} \underline{V_{c_{2}}}$$
Ainsi : 
$$\boxed{\frac{\underline{V_{2}}}{\underline{V_{1}}} = \frac{Y_{1}Y_{3}}{(Y_{1}+Y_{2})(Y_{3}+Y_{5})}}$$
#### Fonction de transfert
$$H(p) = \frac{pC_{1}R_{5}(pC_{3}R_{4}+1)}{p(C_{1}+C_{2})(pC_{3}R_{4}R_{5} + R_{4} + R_{5})}$$
$$= \frac{p^{2}C_{1}C_{3}R_{4}R_{5}+pC_{1}R_{5}}{p(C_{1}+C_{2})(R_{4}+R_{5}) + p^{2}(C_{1}+C_{2})C_{3}R_{4}R_{5}}$$
$$= \frac{\frac{C_{1}R_{5}}{(C_{1}+C_{2})(R_{4}+R_{5})}+p\frac{C_{1}C_{3}R_{4}R_{5}}{(C_{1}+C_{2})(R_{4}+R_{5})}}{1+p \frac{C_{3}R_{4}R_{5}}{R_{4}+R_{5}}}$$
On pose alors : 
$$G = \frac{C_{1}R_{5}}{(C_{1}+C_{2})(R_{4}+R_{5})} \text{ le gain statique}$$
$$\omega_{0} = \frac{R_{4}+R_{5}}{C_{3}R_{4}R_{5}} \text{ et } \omega_{1} = \frac{(C_{1}+C_{2})(R_{4}+R_{5})}{C_{1}C_{3}R_{4}R_{5}}$$


$$H(p) = \frac{p^{2}C_{1}C_{3}R_{5}}{p(C_{1}+C_{2})(pC_{3}R_{5}+1)} $$
$$= \frac{p^{2}C_{1}C_{3}R_{5}}{p(C_{1}+C_{2})+p^{2}(C_{1}+C_{2})C_{3}R_{5}}$$
$$= \frac{p\frac{C_{1}C_{3}R_{5}}{C_{1}+C_{2}}}{1+pC_{3}R_{5}}$$
Ainsi
On pose alors : 
$$\omega_{0} = \frac{1}{C_{3}R_{5}} \text{ et }\omega_{1} = \frac{C_{1}+C_{2}}{C_{1}C_{3}R_{5}}$$

## 2. Application
#### Constantes de la fonction de transfert : 
On pose : 
$$\omega_{0} = $$

# II - Amplificateur classe A
## III - Etude préliminaire
#### Type de transistor
Le transistor $2n2222$ est un $\boxed{\text{Bipolaire }NPN}$

#### Polarisation en pont de base
On utilise un pont diviseur de tension pour contrôler la tension qui rentre dans le transistor ce qui donne au système une bonne stabilité thermique et ne dépend pas de l'amplification du transistor. 

#### 