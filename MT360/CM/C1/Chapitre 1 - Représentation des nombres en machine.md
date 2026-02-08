# I. Représentation flottante
#### Norme $IE754$

|          | $\beta$ | bits | Mantisse | exp. | plage            |
| -------- | ------- | ---- | -------- | ---- | ---------------- |
| Single   | 2       | 32   | 23       | 8    | $-126$-$127$     |
| Double   | 2       | 64   | 52       | 11   | $-1022$-$1023$   |
| Extended | 2       | 80   | 63       | 15   | $-16382$-$16383$ |

## Approximations
Soit $x$ un nombre en base $\beta$ avec $t$ digit et $e$ comme exposant, alors : 
![[Pasted image 20260208212609.png]]
#### Précision
La plus petite précision que l'on puisse obtenir est de : 
$$\beta^{e-t}$$

#### Chopping
$$x_{c} = sgn(x) trunc(\left| x\right| \beta^{t-e} ) \beta^{e-t}$$

#### Rounding
$$x_{r} = sgn(x) trunc\left( \left| x\right| \beta^{t-e} +\frac{1}{2} \right) \beta^{e-t}$$

## Erreurs
Soit $x'$ la valeur approchée de $x$
#### Erreur absolue
À priori :
$$\delta = x'-x$$

À posteriori : 
$$\delta' = x - x'$$

#### Erreur relative
À priori :
$$\rho = \frac{\delta}{x}
$$

À posteriori : 
$$\rho' = \frac{\delta'}{x'}$$


#### Conclusion
$$\begin{cases}
x' = x(1+\rho) \\
x = x'(1+\rho')
\end{cases}$$



#### Précision machine
$\beta$ la base et $t$ le nombre de digits
$$\boxed{h = \beta^{1-t}}$$

Démonstration : 
On cherche à évaluer la précision machine i.e. la valeur maximale que peut prendre l'erreur relative $\rho'$ : 
On sait que : $\left| \delta'\right| = \left| x-x_{0}\right| \leq \beta^{e-t}$ et que $\left| x_{0}\right| \geq \beta^{e-1}$ 
![[Pasted image 20260208212609.png]]
On vérifie bien que sur le dessin :  $\sup\left| x-x_{0}\right| = \beta^{e-t}$ et que : $\inf\left| x_{0}\right| = \beta^{e-1}$
Alors, comme 
$$\rho' = \frac{\left| x-x_{0}\right|}{\left| x_{0}\right|} \leq \beta^{1-t}$$
Ainsi, 
$$\sup\left| \rho'\right| = \beta^{1-t}$$

#### A




# Vu en TD
Soit $f : \mathbb{R}^{N} \to \mathbb{R}^{M}$ un jeu de donnés (un problème)
et $f^{*}$ son algorithme associé. 
#### Stabilité
On dit que l'algorithme $f^{*}$ est numériquement stable en $x$ ssi : 
$$\forall x \in \mathcal{D}(f),\exists x^{*} \in V(x), f(x^{*}) \in V(f^{*}(x)) $$
EXCAL 1

#### Bon conditionnement
On dit que le problème $f$ est bien conditionné ssi : 
$$\forall (x, x^{*}) \in \mathcal{D}(f) \times \mathcal{D}(f^{*}), x^{*} \in V(x) \Rightarrow f(x^{*}) \in V(f(x))$$



#### Erreur inévitable
$$\boxed{\rho(f(p, q)) = \frac{p \frac{\partial f}{\partial p}(p, q)}{f(p, q)} \rho(p) + \frac{q \frac{\partial f}{\partial q}(p, q)}{f(p, q)} \rho(q) }$$


