
$$\begin{cases}
\frac{\partial x}{\partial t} = Ax(t) + Bu(t) \\
y(t) = Cx(t) + Du(t)
\end{cases}$$

#### Théorème de la valeur initiale / finale
Soit $x$ une fonction définie en $0$, ($x(t)\underset{n \to +\infty}{\longrightarrow} l \in \mathbb{R}$)
Si $X$ (Transformée de Laplace de $x$) a une abscisse de convergence finie alors, 
$$\lim_{ t \to 0^{+} } x(t) = \lim_{ p \to +\infty } pX(p)$$
$$\lim_{ t \to +\infty } x(t) = \lim_{ p \to 0^{+} } pX(p)  $$

#### Théorème
Un système linéaire entrée bornée sortie bornée est stable ssi : 
$$\int_{0}^{+ \infty} \left| h(t)\right| \, dt \in \mathbb{R} \Leftrightarrow \mathrm{Re}(\mathrm{pôles}(H(p))) < 0$$


#### Régime statique
On appelle Régime Statique d’un système linéaire invariant causal et stable, l’état, de durée indéfinie, du système dans lequel toutes ses dérivées nulles.


# ATTENTION
Ne pas 