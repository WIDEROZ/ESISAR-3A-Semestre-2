$$(\Delta_{imp})_{rel} = \left| \frac{\partial p_{0}}{\partial p_{0}} \right|p_{0} T_{e}$$

Au delà de $\omega_{1}$ une certaine pulsation, les signaux ne sont plus considérés : $G_{\min} = -80 \leq G_{dB}(\omega)$ 

Critère de phase : 
$$\omega_{\max} =\frac{\pi}{T_{e}} \geq 10^{N}\omega_{x} \text{ avec }\omega_{x} \text{(le pôle ou 0 le plus rapide)}$$

choix de la fréquence de coupure : $(\omega_{c})_{\max} = \omega_\mathrm{lent}$

Stable au sens EB-SB : $\left| \text{pôle}(z)\right| < 1 \text{ et }\mathrm{Re}(\text{pôle}(p)) <0$


Théorème de la valeur finale : $\underset{{ t \to \infty }}{\lim}\,y(t) = \lim_{ p \to 0 }pY(p) \text{ et }\underset{{ n \to \infty }}{\lim} \,x(n) = \lim_{ z \to 1 }(z-1)X(z)$


Fonction de sensibilité liant p et z : $\left| \frac{\partial p_{i}}{p_{i}}\right| = \frac{1}{\ln\left| z_{i}\right|} \left| \frac{\partial z_{i}}{z_{i}}\right|$

BOZ : $H_{BOZ}(p) = \frac{1-e^{ -T_{e}p }}{p}$

