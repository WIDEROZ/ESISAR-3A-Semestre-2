# Exercice 1
$4$ bits pour l'exposant et $5$ digits pour $t$
$$x=[ e | t] = [0000 | 00000]$$
$e = 1111$ est réservé pour $x=\pm \infty$ ou NAN
$e = 0000$ est réservé pour $x=0$ et pour les dénormalisés
L'exposant est toujours représenté en base $2$


## 1.
$$e \in [\![(0001)_{2}; (1110)_{2}]\!] = [\![-6, 7]\!]$$
$$(1000)_{2} = 0 = e$$

## 2.

On prend l'exposant le plus petit en normalisé : $e = 0001$ ie $7^{1-7} = 7^{-6}$ avec le biais (on ne prend pas $0$ car le nombre serait dénormalisé)
On prend ensuite la mantisse normalisée la plus petite on a ainsi le nombre normalisé le plus petit qui est : 
$$\boxed{x_{m} = 1.00000 \times 7^{-6}}$$

Pour prendre le plus grand on prend l'exposant le plus grand : $e=1110$ : $7^{14-7} = 7^{7}$ (car $e=1111$ est réservé pour $\infty, NAN, \dots$)
On prend ainsi la mantisse la plus grande possible et on obtiens ainsi le nombre le plus grand que l'on puisse représenter : 
$$\boxed{x_{M} = 1.66666 \times 7^{7} }$$


## 3.
$$0 \, 0000 \, 00000$$
Normalisés :
$$\#(\mathbb M) = 2((2^{4}-2)7^{5}+1)$$
- $2^{4}-2$ : Nombres d'exposants possibles (sans $e=0000$ et $e=1111$)
- $7^{5}$ : Nombres de dispositions de mantisse différentes. 
- $+1$ : Ajout de $0$
- $2(\dots)$ : Ajout des négatifs

## 4.
$$\left| \rho\right|\leq h  = \beta^{1-t} = 7^{-4}$$

## 5.
$$\beta^{e-t} = 7^{e-5}$$

## 6.
$$\frac{1}{3} = 0.\overline{3}_{10} $$
$$0.\overline{3} \times 7 = 2.\overline{3}$$
$$2.\overline{3} \times 7 = 16.\overline{3}$$
Donc, 
$$(1.6\overline{3} \times 7^{-3})_{7} = \left( \frac{1}{3} \right)_{10}$$
Ainsi, 
$$0 \, 0100 \, 63333 = \frac{1}{3}$$


$$\frac{4}{7} = 0.571428$$
$$ \frac{4}{7}\times 7 = 4_{7}$$
$$4 \times 7 \times 7^{-1} = 28_{10} \times 7^{-1} = 31_{7} \times 7^{-1}$$
$$28 \times 7 = 196_{10} = 226_{7} $$
$$196 \times 7$$



$$-(.40000) \times 7^{0} = -\frac{4}{7} $$

# Exercice 2
$$x^{2} + 2px-q = 0$$
On souhaite alors évaluer : 
$$f : \begin{cases}
\mathbb{R}\times \mathbb{R}_{+} \to \mathbb{R} \\
(p, q) \mapsto f(p, q) = -p+\sqrt{p^{2}+q}
\end{cases}$$

## 1.
$$\rho(f(p, q)) = \frac{p \frac{\partial f}{\partial p}(p, q)}{f(p, q)} \rho(p) + \frac{q \frac{\partial f}{\partial q}(p, q)}{f(p, q)} \rho(q) $$
$$= \frac{-p}{\sqrt{p^{2}+q}} \rho (p) + \frac{p+\sqrt{p^{2}+q}}{2\sqrt{p^{2}+q}}\rho(q)$$

## 2.


## 3.
$$\rho' = \frac{-p + \sqrt{p^{2} + q}-x'}{x'}$$

# Exercice 1
#### 1.
