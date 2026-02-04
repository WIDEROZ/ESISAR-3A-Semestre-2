# I - Introduction
# II - Convergence
Soit : 
$$f : \begin{cases}
I \subset \mathbb{R} \to \mathbb{R} \\
x \mapsto f(x)
\end{cases} \text{ continue telle que : } f(I) \subset I$$
et
$$(x_{k})_{k \in \mathbb{N}} \text{ défini par : }\begin{cases}
x_{k+1} = f(x_{k}) \\
x_{0} \in I
\end{cases}$$
Alors, 
$$x_{k} \underset{k \to +\infty}{\longrightarrow} l \in \mathbb{R} \Rightarrow f(l) = l$$

Démonstration :
Supposons que : $x_{k} \underset{k \to +\infty}{\longrightarrow} l$ alors, comme : 
$$\forall \varepsilon \in \mathbb{R}_{+}^{*},\exists \alpha \in \mathbb{R}_{+}^{*}, \forall x, y \in I, \left| y-x\right| \leq \alpha \Rightarrow \left| f(y) - f(x) \right| \leq \varepsilon $$


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