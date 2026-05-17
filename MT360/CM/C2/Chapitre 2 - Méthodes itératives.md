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
De même pour des vecteurs.

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
Soient 
$$\begin{cases}
x_{n} \underset{n \to +\infty}{\longrightarrow}s \\
e_{k} = x_{k} - s \\
\rho_{k} = \frac{e_{k}}{s}\\
c_{k} = 1-\log_{\beta}(\rho_{k})
\end{cases}$$

#### a. Ordre de convergence (Schoeder)
Soit $(x_{n})_{n \in \mathbb{N}} \underset{n \to +\infty}{\longrightarrow} s$ avec $\forall n \in \mathbb{N}, x_{n+1} = f(x_{n})$, 
$(x_{n})_{n \in \mathbb{N}}$ est convergente d'ordre $p$ ssi : 
$$\boxed{\forall k \in [\![1, p-1]\!], f^{(k)}(s) = 0 \text{ et }f^{(p)}(s)\neq 0}$$


#### b. Vitesse de convergence
$$\boxed{\frac{\left| e_{n+1}\right|}{\left| e_{n}\right|^{p}} \underset{n \to + \infty}{\sim} \lambda = \frac{f^{(p)}(s)}{p!}}$$

Démonstration : 
On a : 
$$e_{n+1} = f(e_{n}+s)-s=f(e_{n}+s) -f(s) \underset{{e_{n} \to 0}}{=} \sum_{k = 1}^{+ \infty} \frac{f^{(k)}(s)}{k!} e_{n}^{k}$$
Alors, si l'ordre de convergence de $(x_{n})_{n \in \mathbb{N}}$ est $p$ : 
$$ e_{n+1}= \frac{f^{(p)}(s)}{p!} e_{n}^{p} + o(e_{n}^{p}) \Leftrightarrow \boxed{\frac{\left| e_{n+1}\right|}{\left| e_{n}\right|} = \frac{f^{(p)}(s)}{p!}e_{n}^{p}}$$


#### c. Nombres significatifs corrects entre deux itérations
$$\boxed{v_{k} = \frac{\Delta c_{k}}{\Delta k} = c_{k+1}-c_{k}}$$
Par le théorème de Banach (dans le cas général) on a : 
$$\boxed{v_{k} \underset{k \to + \infty}{\sim} -\log_{\beta} \left| f'(s)\right|}$$

Demonstration : 
On a : 
$$\begin{array}{ll}
v_{k} &= -\log_{\beta}\left| \frac{x_{k+1}-s}{x_{k}-s}\right| \\
& = - \log_{\beta}\left| \frac{f(x_{k})-f(s)}{x_{k}-s}\right|
\end{array}$$
Et comme par le théorème de Banach : $x_{k} \underset{k \to +\infty}{\longrightarrow} s$ on a : $x_{k}-s \underset{k \to +\infty}{\longrightarrow}0$ ainsi :
$$\boxed{ v_{k}\underset{k \to +\infty}{\sim} -\log_{\beta} \left| f'(s)\right|}$$





#### d. Traub
Soit $(x_{n})_{n \in \mathbb{N}} \underset{n \to +\infty}{\longrightarrow}s$, 
$$\boxed{(x_{n})_{n \in \mathbb{N}}\text{ est convergente d'ordre } p \Leftrightarrow \exists \lambda > 0 , \frac{\left| e_{n+1}\right|}{\left| e_{n} \right|^{p}} \underset{n \to + \infty}{\sim} \lambda}$$


#### Acceleration d'Aitken / $\Delta^{2}$-process
Soit $(x_{n})_{n \in \mathbb{N}}$ tel que : $x_{n} \underset{n \to +\infty}{\longrightarrow} s$ converge à l'ordre $1$ ie : 
$$e_{n+1} \underset{n \to + \infty}{\sim} \lambda e_{n}$$
$$e_{n+2} \underset{n \to + \infty}{\sim} \lambda e_{n+1}  $$
Alors, 
$$\begin{cases}
x_{n+1}-s = \lambda(x_n-s) + \varepsilon_{n} \\
x_{n+2}-s = \lambda(x_{n+1}-s) + \varepsilon_{n+1} 
\end{cases}$$
Comme on souhaite approximer $s$ : 
$$\begin{cases}
x_{n+1}-x'_{n} = \lambda(x_n-x'_{n}) + \varepsilon_{n} \\
x_{n+2}-x'_{n+1} = \lambda(x_{n+1}-x'_{n+1}) + \varepsilon_{n+1} 
\end{cases}$$
Donc, en soustrayant ces deux équations : 
$$x_{n+2}-x_{n+1} = \lambda(x_{n+1} - x_{n}) + (\varepsilon_{n+1} - \varepsilon_{n})$$
Donc, 
$$\lambda \approx \frac{x_{n+2} - x_{n+1}}{x_{n+1}-x_{n}}$$
Puis, 
$$\Delta x_{n+2} = \lambda \Delta x_{n+1} = \lambda^{n+2}C \Rightarrow \Delta x_{n} = \lambda^{n}C$$
Alors, 
$$x_{n} = s + \lambda^{n}C$$
Donc, 
$$\Delta x_{n+1} = C\lambda^{n}(\lambda-1) \text{ et } x_{n+2} - 2x_{n+1}+x_{n} = C\lambda^{n}(\lambda-1)^{2}$$

Donc, 
$$\frac{(x{_{n+1}-x_{n}})^{2}}{x_{n+2} - 2x_{n+1} + x_{n}} = C\lambda^{n} = x_{n}-x_{n}'$$

Ainsi, 
$$\boxed{x_{n}^{*} = x_{n} - \frac{(x{_{n+1}-x_{n}})^{2}}{x_{n+2} - 2x_{n+1} + x_{n}}}$$


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
\xi - \frac{(f(\xi) - \xi)^{2}}{f(f(\xi)) - 2f(\xi) + \xi} & \text{si }\xi \neq s \\
s&\text{si }\xi  = s
\end{cases}$$
On a alors, 
$$\begin{cases}
g(s) = s \\
f'(s) \neq 0 \Rightarrow g'(s) = 0 & x_{n} \text{ CV à un ordre} \geq 2\\
f'(s) = 0 \Rightarrow g'(s) = g''(s) = 0 & x_{n} \text{ CV à un ordre} \geq 3
\end{cases}$$

# IV. Méthodes itératives pour trouver $F(x) = 0$
On pose : 
$$F(x) = x-f(x)$$
Et on cherche le ou les points fixes de $f$.
On pose : 
$$x_{n+1} = f(x_{n})$$
Pour trouver l'existence de points fixes il suffit d'appliquer le théorème de Banach ie il faudrait trouver que $f$ est contractante ie : 
$$\left| f'(x) \right| = \left| 1-F'(x)\right| < 1$$
Seulement $F'(x)$ n'est souvent jamais entre $]0, 2[$ il faut donc trouver un $\mu$ tel que : 
$$f(x) = x-\frac{F(x)}{\mu}$$

De manière optimale il faudrait que : 
$$\mu = F'(s) \text{ car : } f'(s)=  0 \text{ et } x_{n}\underset{n \to +\infty}{\longrightarrow} s \text{ à l'ordre 2}$$

## 1. Méthode des cordes parallèles
$$\boxed{\forall k \in \mathbb{N}, x_{k+1} = x_{k} - \frac{F(x_{k})}{\tan(\phi)} = f(x_{k}) \text{ (ici } \mu = \tan(\phi) \text{)}}$$


## 2. Méthode de la sécante
$$\forall k \in \mathbb{N}, x_{k+1} = x_{k} - \frac{F(x_{k})}{\frac{F(x_{n}) - F(x_{n-1})}{x_{n} - x_{n-1}}} = f(x_{n})$$
$$\mu_{n} = \frac{F(x_{n}) - F(x_{n-1})}{x_{n}-x_{n-1}}$$
Alors, 
$$e_{n+1} = e_{n}- \frac{F(x_{n})(e_{n}-e_{n-1})}{F(x_{n})-F(x_{n-1})} $$
Donc, 
$$\frac{\left| e_{n+1}\right|}{\left| e_{n}\right|^{\frac{1+\sqrt{5}}{2}}} \underset{n \to + \infty}{\sim} 1$$
ie $(x_{n})$ CV d'ordre $\frac{1+\sqrt{5}}{2}$ 

## 3. Méthode de Newton Raphson
$$x_{n+1} = x_{n} - \frac{F(x_{n})}{F'(x_{n})} = f(x_{n}) \text{ avec }\mu=F'(x_{n})$$
$$f'(x) = \frac{F(x)F''(x)}{F'(x)^{2}}$$
alors, 
$$f'(s) = 0 \text{(car )F(s) = s-f(s) = 0}$$
$$f''(x) = \frac{(F'(x)F''(x)+F(x)F^{(3)}(x))F'(x)-2F(x)^{2}F''(x)}{F'(x)^3}$$
Alors comme $F(s)=0$ :
$$f''(s) = \frac{F''(s)}{F'(s)}$$
De plus si $s$ est racine de multiplicité $p$ de $F$ i.e. : 
$$F(s) = (x-s)^{p}G(s) \text{ avec } G'(s) \neq 0$$
Donc dans ce cas on considère : 
$$x_{k+1} = x_{k} - p \frac{F(x_{k})}{F'(x_{k})}$$
