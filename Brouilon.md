## 1.2 Spécifications pour la synthèse de la commande
#### Modélisation du système
On prend une fonction de transfert d'ordre $2$ : 
$$\boxed{T(u) = \frac{G}{1+2\xi u + u^{2}} e^{  -t_{R} \omega_{0} u }}$$
avec : 
- $\xi$ le coefficient d'amortissement
- $u = \frac{p}{\omega_{0}}$
- $\omega_{0} = \frac{1}{\tau}$ la pulsation propre du système
- $G$ le gain

##### Validité fréquentielle
$$T(p) = \frac{G}{1+\frac{2\xi}{\omega_{0}}  p + \left( \frac{\omega}{\omega_{0}} \right)^{2}} e^{ -t_{R}p }$$
$$\boxed{G_{dB} =  20 \log(G) - 10 \log\left( \left( 1-\left( \frac{\omega}{\omega_{0}} \right)^{2} \right)^{2} + 4 \left( \frac{\xi \omega}{\omega_{0}} \right)^{2} \right)}$$
$$\varphi = \mathrm{arg}(T(p)) = -t_{R}\omega- \mathrm{arg}\left( 1- \left( \frac{\omega}{\omega_{0}} \right)^{2}+j\frac{2\xi}{\omega_{0}} \omega \right)  $$
Si $\omega \leq \omega_{0}$ : 
$$\boxed{\varphi = -t_{R}\omega -\arctan\left( \frac{\frac{\omega_{0}}{\omega}- \frac{\omega}{\omega_{0}} }{2\xi} \right)}$$
Si $\omega \geq \omega_{0}$ : 
$$\boxed{\varphi =\pi -t_{R}\omega -\arctan\left( \frac{\frac{\omega_{0}}{\omega}- \frac{\omega}{\omega_{0}} }{2\xi} \right) }$$

##### Retard pur
De même que précédemment : 
$$\boxed{t_{R} \leq t_{R, \max} = 5 \, ms}$$



#### Schéma fonctionnel
EXCAL 4
- $P_{b}(p)$ : Bruit de mesure
- $P_{u}(p)$ : Perturbation de la commande
- $P_{y}(p)$ : Variations lentes $\Delta H(p)$ de $H(p)$
- $R(p)$ : Consigne que doit suivre la sortie
- $U(p)$ : Entrée(s) du système (Commande actionneur)


$$\int_{\mathbb{R}} e^{ itx } \frac{1-\cos(x)}{\pi x^{2}} \, dx $$
$$\int_{\mathbb{R}} \frac{\cos(tx) - \cos(tx)\cos(x)}{\pi x^{2}} \, dx+ i\int_{\mathbb{R}} \frac{\sin(tx) - \sin(tx)\cos(x)}{\pi x^{2}} \, dx$$
$$= 2\int_{0}^{+ \infty} \frac{\cos(tx) - \cos(tx)\cos(x)}{\pi x^{2}} \, dx$$
$$= 2 \int_{0}^{+ \infty} \cos(tx)\frac{1-\cos(x)}{\pi x^{2}} \, dx$$
$$= 2\left(\left[\frac{1}{t}\cos(tx) \frac{1-\cos(x)}{\pi x^{2}} \right]_{0}^{+ \infty} - \frac{1}{t} \int_{0}^{+ \infty} \cos(tx)\frac{\sin(x)+}{}  \, dx  \right) $$

$$\int_{-\infty}^{+ \infty} \frac{e^{ itx }+e^{ -itx }-(e^{ itx }+e^{ -itx })(e^{ ix }+e^{ -ix })}{2\pi x^{2}} \, dx $$
$$= \int_{\mathbb{R}} \frac{e^{ itx }+e^{ -itx } - e^{ i(t+1)x }-e^{ -i(t+1)x }-e^{ i(t-1)x  } - e^{- i(t-1)x  }}{2\pi x^{2}} \, dx $$

$$2 \int_{-} \, dx $$