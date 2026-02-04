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
#### Stabilité
Soit $f : \mathbb{R}^{N} \to \mathbb{R}^{M}$ un jeu de donnés
On dit que l'algorithme $f^{*}$ est numériquement stable en $x$ ssi : 
$$\forall x \in \mathcal{D}(f),\exists x^{*} \in V(x), $$