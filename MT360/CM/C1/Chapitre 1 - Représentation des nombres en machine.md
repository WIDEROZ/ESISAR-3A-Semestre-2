# I. Représentation flottante
#### Norme $IE754$

|          | $\beta$ | bits | Mantisse | exp. | plage            |
| -------- | ------- | ---- | -------- | ---- | ---------------- |
| Single   | 2       | 32   | 23       | 8    | $-126$-$127$     |
| Double   | 2       | 64   | 52       | 11   | $-1022$-$1023$   |
| Extended | 2       | 80   | 63       | 15   | $-16382$-$16383$ |

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



# Vu en TD
Soit $f : \mathbb{R}^{N} \to \mathbb{R}^{M}$ un jeu de donnés (un problème)
et $f^{*}$ son algorithme associé. 
#### Stabilité
On dit que l'algorithme $f^{*}$ est numériquement stable en $x$ ssi : 
$$\forall x \in \mathcal{D}(f),\exists x^{*} \in V(x), f(x^{*}) \in V(f^{*}(x)) $$


#### Bon conditionnement
On dit que le problème $f$ est bien conditionné ssi : 
$$\forall (x, x^{*}) \in \mathcal{D}(f) \times \mathcal{D}(f^{*}), x^{*} \in V(x) \Rightarrow f(x^{*}) \in V(f(x))$$

#### Précision machine
$\beta$ la base et $t$ le nombre de digits
$$h = \beta^{1-t}$$


#### Erreur inévitable
$$\boxed{\rho(f(p, q)) = \frac{p \frac{\partial f}{\partial p}(p, q)}{f(p, q)} \rho(p) + \frac{q \frac{\partial f}{\partial q}(p, q)}{f(p, q)} \rho(q) }$$
