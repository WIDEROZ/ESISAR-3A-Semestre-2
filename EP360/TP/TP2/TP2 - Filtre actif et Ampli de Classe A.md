# I - Filtre actif de Tchebychev
## 1. Etude de la cellule Sallen-Key
![[Pasted image 20260321144951.png]]

### Rapport entre $V_{1}$ et $V_{2}$
On applique la loi des nœuds :
$$Y_{1}(\underline{V_{1}}-\underline{V_{c_{2}}}) + Y_{4}(\underline{V_{{2}}}-\underline{V_{c_{2}}}) = Y_{3}(\underline{V_{c_{2}}}-\underline{V_{2}}) + Y_{2}\underline{V_{c_{2}}}$$
Alors, 
$$\underline{V_{1}} = \frac{-Y_{4}-Y_{3}}{Y_{1}} \underline{V_{2}} + \left( \frac{Y_{1}+Y_{2}+Y_{3}+Y_{4}}{Y_{1}} \right)\underline{V_{c_{2}}}$$
Or, d'après un pont diviseur de tension appliqué à $R_{5}$ et $C_{3}$ : 
$$\underline{V_{c_{2}}} = \frac{Y_{3} + Y_{5}}{Y_{3}}\underline{V_{2}}$$
On a :
$$\underline{V_{1}} = \frac{Y_{3}(-Y_{4}-Y_{3})+(Y_{3}+Y_{5})(Y_{1}+Y_{2}+Y_{3}+Y_{4})}{Y_{1}Y_{3}}\underline{V_{2}}$$
Ainsi, 
$$\boxed{\frac{\underline{V_{2}}}{\underline{V_{1}}} = \frac{Y_{1}Y_{3}}{Y_{3}(Y_{1}+Y_{2}) + Y_{5}(Y_{1}+Y_{2}+Y_{3}+Y_{4})}}$$


#### Fonction de transfert
$$H(p) = \frac{p^{2}C_{1}C_{3}}{p^{2}(C_{1}+C_{2})C_{3} + \frac{1}{R_{5}}\left( pC_{1}+pC_{2} + pC_{3}+\frac{1}{R_{4}} \right)}$$
Ainsi : 
$$\boxed{H(p)=\frac{p^{2}C_{1}C_{3}R_{4}R_{5}}{1+pR_{4}(C_{1}+C_{2}+C_{3})+p^{2}(C_{1}+C_{2})C_{3}R_{4}R_{5}}}$$
De plus : 
$$\boxed{H(p) = \frac{H_{0}p^{2}}{1+\frac{2m}{\omega_{0}} p + \left( \frac{p}{\omega_{0}} \right)^{2}}}$$

On pose alors : 
$$\boxed{H_{0} = C_{1}C_{3}R_{4}R_{5} \text{ le gain dynamique}}$$
$$\boxed{\omega_{0} = \frac{1}{\sqrt{(C_{1}+C_{2})C_{3}R_{4}R_{5}}}  }$$
de plus : 
$$2\frac{m}{\omega_{0}} = R_{4}(C_{1}+C_{2}+C_{3})$$
Ainsi, 
$$\boxed{m = \frac{\omega_{0}}{2}R_{4}(C_{1}+C_{2}+C_{3}) = \frac{C_{1}+C_{2}+C_{3}}{2}\sqrt{\frac{R_{4}}{(C_{1}+C_{2})C_{3}R_{5}}}}$$

#### Constantes du système
$$\frac{2m}{\omega_{0}} = R_{4}(C_{1}+C_{2}+C_{3})$$
$$H_{0} = C_{1}C_{3}R_{4}R_{5}$$
$$R_{4}R_{5}=\frac{H_{0}}{C_{1}C_{3}}$$
$$\frac{2m}{\omega_{0}(C_{1}+C_{2}+C_{3})}$$
$$\frac{1}{\omega_{0}^{2}} = {(C_{1}+C_{2})C_{3}R_{4}R_{5}} =H_{0}+C_{2}C_{3}R_{4}R_{5} = H_{0} + \frac{C_{2}}{C_{1}}H_{0}$$

$$\frac{1}{\omega_{0}^{2}} = C_{1}+C_{2}$$


## 2. Application
#### Constantes de la fonction de transfert 



# II - Amplificateur classe A
## III - Etude préliminaire
#### Type de transistor
Le transistor $2n2222$ est un $\boxed{\text{Bipolaire }NPN}$

#### Polarisation en pont de base
On utilise un pont diviseur de tension pour contrôler la tension qui rentre dans le transistor ce qui donne au système une bonne stabilité thermique et ne dépend pas de l'amplification du transistor. 

#### Découplage partiel de la résistance d'émetteur
La résistance $R_{E_{2}}$ rend les signaux électriques et thermiques stables à la sortie de l’émetteur en cédant une partie du gain. 
Lorsque l’émetteur est soumis à un courant continu, le condensateur $C_{d}$ n'agit pas sur le système donc la résistance $R_{E_{1}}$ prend le relais pour rendre la tension en sortie de l'émetteur plus stable. Dans le cas contraire en courant alternatif, c'est le condensateur qui prend le relais ce qui permet de garder une grande amplification en tension.

#### Minorant de $V_{cc}$
On se place dans le cas ou on applique une tension continue à l'entrée.
Alors, 
$$$$