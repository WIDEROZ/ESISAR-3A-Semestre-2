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
$$\boxed{\begin{cases}
\exists ! s \in I, f(s) = s \\
\forall x_{0} \in I, x_{n} \underset{n \to +\infty}{\longrightarrow} s \\
\left| x_{k} -s\right| \leq \frac{L^{k}}{1-L}\left| x_{1}-x_0\right| \\
\left| x_{k} -s\right| \leq \frac{L}{1-L}\left| x_{k+1}-x_k\right|
\end{cases}}$$

De même pour les vecteurs. 

#### Théorème semi-local du théorème de Banach
Soit $I = \mathcal{\overline{B}}(x_{0}, r)$
Soit $f : \mathbb{R}^{N} \to \mathbb{R}^{N}$, $L$-lipschitzienne contractante
On définit : 
$$S = \left\{  x \in \mathbb{R}^{N} \left| \left|\left| x -x_{1} \right|\right|\leq \frac{L}{1-L} \left|\left| x_{1}-x_{0} \right|\right|  \right.  \right\}$$
Si pour $x_{1} = f(x_{0})$ : 
$$\left| x_{1}-x_{0}\right| \leq r(1-L)$$
Alors, 
$$\boxed{\begin{cases}
S \subset I \\
f(S) \subset S
\end{cases}}$$


# III - Vitesse ordre et acceleration de convergence
#### Définitions
Soient 
$$\begin{cases}
x_{n} \underset{n \to +\infty}{\longrightarrow}s \\
e_{k} = x_{k} - s \\
\rho_{k} = \frac{e_{k}}{s}&\text{avec } \rho_{k} = \beta^{1-c_{k}} \\
c_{k} = 1-\log_{\beta}(\rho_{k})
\end{cases}$$


#### Vitesse de convergence
$$\boxed{v_{k} = \frac{\Delta c_{k}}{\Delta k} = c_{k+1}-c_{k}}$$
Par le théorème de Banach (dans le cas général) on a : 
$$\boxed{v_{k} \underset{k \to + \infty}{\sim} v = -\log \left| f'(s)\right|}$$

#### Ordre de convergence (Schoeder)
Soit $(x_{n})_{n \in \mathbb{N}} \underset{n \to +\infty}{\longrightarrow} s$ avec $\forall n \in \mathbb{N}, x_{n+1} = f(x_{n})$, 
et :
$${\forall n \in \mathbb{N}, e_{n+1} = \sum_{k \in \mathbb{N}^{*}} \frac{f^{(k)}(s)}{k!} e_{n}^{k}}$$

$(x_{n})_{n \in \mathbb{N}}$ est convergente d'ordre $p$ ssi : 
$$\boxed{\forall k \in [\![1, p]\!], f^{(k)}(s) = 0 \text{ et }f^{(p)}\neq 0}$$

On pose alors, 
$$\boxed{\frac{\left| e_{n+1}\right|}{\left| e_{n}\right|} \underset{n \to + \infty}{\sim} \lambda = \frac{f^{(p)}(s)}{p!}}$$

#### Traub
Soit $(x_{n})_{n \in \mathbb{N}} \underset{n \to +\infty}{\longrightarrow}s$, 
$$\boxed{(x_{n})_{n \in \mathbb{N}}\text{ est convergente d'ordre } p \Leftrightarrow \exists \lambda > 0 , \frac{\left| e_{n+1}\right|}{\left| e_{n} \right|} \underset{n \to + \infty}{\sim} \lambda}$$


#### Acceleration d'Aitken / $\Delta^{2}$-process
Soit $(x_{n})_{n \in \mathbb{N}}$ tel que : $x_{n} \underset{n \to +\infty}{\longrightarrow} s$ converge à l'ordre $1$ ie : 
$$e_{n+1} \underset{n \to + \infty}{\sim} \lambda e_{n}$$
Alors, 
$$\begin{cases}
x_{n+1}-s = \lambda(x_n-s) + \varepsilon_{n} \\
x_{n+2} -s = \lambda(x_n-s) + \lambda(x_{n+1}-s) \varepsilon_{n+1}
\end{cases}$$
Donc, 
$$\begin{cases}
x_{n+1}-x_{n}' = \lambda_{n}(x_n-x'_{n}) \\
x_{n+2} -x_{n}' = \lambda_{n}(x_{n+1}-x'_{n+1})
\end{cases}$$
ie : 
$$\lambda_{n} = \frac{x_{n+2} - x_{n+1}}{x_{n+1}-x_{n}}$$
Ainsi, 
$$\boxed{x_{n}' = x_{n} - \frac{(x{_{n+1}-x_{n}})^{2}}{x_{n+2} - 2x_{n+1} + x_{n}}}$$

#### Méthode d'Aitken-Steffensen
Soit $x_{n} \underset{n \to +\infty}{\longrightarrow} s$ avec $x_{n+1} =f(x_{n})$,
soit $x_{0}$, son acceleration est : 
$$x_{0}' = x_{0} - \frac{(f(x_{0}) - x_{0})^{2}}{f(f(x_{0})) - 2f(x_{0}) +x_{0}}$$
On prend l'acceleration de $x_{0}'$ : 
$$x_{0}'' = x_{0}' - \frac{(f(x_{0}') - x_{0}')^{2}}{f(f(x_{0}')) - 2f(x_{0}') +x_{0}'}$$
On pose : 
$$y_{0} = x_{0} \text{ et } y_{n+1} = g(y_{n}) $$
Avec, 
$$g(\xi) = \begin{cases}
\xi - \frac{(f(\xi) - \xi)^{2}}{f(f(\xi)) - 2f(\xi) + \xi} & \text{ si }\xi \neq s \\
s&\text{si }\xi  = s
\end{cases}$$
On a alors, 
$$\begin{cases}
g(s) = s \\
f'(s) \neq 0 \Rightarrow g'(s) = 0 & x_{n} \text{ CV à un ordre} \geq 2\\
f'(s) = 0 \Rightarrow g'(s) = g''(s) = 0 & x_{n} \text{ CV à un ordre} \geq 3
\end{cases}$$

## 4. Méthodes itératives pour trouver $F(x) = 0$
On pose : 
$$f(x) = x-F(x)$$
Et on cherche le ou les points fixes de $f$.
On pose : 
$$x_{n+1} = f(x_{n})$$
Pour trouver l'existence de points fixes il suffit d'appliquer le théorème de Banach ie il faudrait trouver que $f$ est contractante ie : 
$$\left| f'(x) \right| = \left| 1-F'(x)\right| < 1$$
Seulement $F'(x)$ n'est souvent jamais entre $]0, 2[$ il faut donc trouver un $\mu$ tel que : 
$$f(x) = x-\frac{F(x)}{\mu}$$

De manière optimale il faudrait que : 
$$\mu = F'(s) \text{ car : } $$