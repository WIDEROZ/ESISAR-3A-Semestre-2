# I - Introduction
# II - Convergence
Soit : 
$$f : \begin{cases}
I \subset \mathbb{R} \to \mathbb{R} \\
x \mapsto f(x)
\end{cases} \text{ continue telle que : } f(I) \subset I \text{ et fermé bronée}$$
et
$$(x_{k})_{k \in \mathbb{N}} \text{ défini par : }\begin{cases}
x_{k+1} = f(x_{k}) \\
x_{0} \in I
\end{cases}$$
Alors, 
$$x_{k} \underset{k \to +\infty}{\longrightarrow} l \Rightarrow f(l) = l$$

Démonstration :
Supposons que : $x_{k} \underset{k \to +\infty}{\longrightarrow} l$ alors, comme $I$ est un fermé $l \in I$ 
Ainsi comme $f$ est continue en $l$ :
$$x_{k} = f(x_{k+1}) \underset{k \to +\infty}{\longrightarrow} f(l) = l$$


#### Fonction contractante
$f$ est contractante si elle est $k$-lipschitzienne avec $k <1$

#### Théorème du point fixe de Banach
Soit $f : I \subset \mathbb{R} \to \mathbb{R}$ continue avec $f(I) \subset I$ et $I$ fermé borné
Si $f$ est lipschitzienne et contractante
Alors, 
$$\begin{cases}
\exists ! s \in I, f(s) = s \\
\forall x_{0} \in I, x_{n} \underset{n \to +\infty}{\longrightarrow} s \\
\left| x_{k} -s\right| \leq \frac{L^{k}}{1-L}\left| x_{1}-x_0\right| \\
\left| x_{k} -s\right| \leq \frac{L}{1-L}\left| x_{k+1}-x_k\right|
\end{cases}$$

De même pour les vecteurs. 

#### Théorème semi-local du théorème de Banach
Soit $I = \mathcal{\overline{B}}(x_{0}, r)$
Si pour $x_{1} = f(x_{0})$ : 
$$\left| x_{1}-x_{0}\right| \leq r(1-L)$$
Soit : 
$$S = \left\{  x \in \mathbb{R}^{N} | \left|\left| x -x_{1} \right|\right|\leq \frac{L}{1-L} \left|\left| x_{1}-x_{0} \right|\right|    \right\}$$

# 