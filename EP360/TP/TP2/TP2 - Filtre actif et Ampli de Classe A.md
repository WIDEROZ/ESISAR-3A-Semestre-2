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


$$\underline{V_{2}}= \frac{Y_{1}Y_{3}}{\left( Y_{1}+Y_{2}+ \frac{Y_{3}Y_{5}}{Y_{3}+Y_{5}} \right)(Y_{3}+Y_{5})}\underline{V_{1}}$$
$$$$