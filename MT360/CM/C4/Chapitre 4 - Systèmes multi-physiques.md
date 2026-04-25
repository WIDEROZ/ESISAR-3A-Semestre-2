# The electro-mechanical analogy
![[Pasted image 20260414144250.png]]

### Stored energy and state variables
#### Electrical circuit (RLC)
Energy stored in the system :
$$H(p, q) = \frac{q^{2}(t)}{2C} + \frac{p^{2}(t)}{2L}$$
$q:= Q$ : electrical charge
$p:=\phi$ : electrical flow

#### Mass spring system
$$H(p, q) = \frac{q^{2}(t)}{2 \frac{1}{k_{s}}} + \frac{p^{2}(t)}{2m}$$
$q:= q$ : spring position
$p:=m\dot{x}$ : movement quantity

### Co-ennergy variables
$$\boxed{\frac{dH}{dt} := \frac{\partial H}{\partial q} \dot{q} + \frac{\partial H}{\partial p} \dot{p} = e_{q}(t)f_{q}(t)+e_{p}(t) f_{p}(t)}$$
#### Electrical circuit (RLC)
$$\begin{cases}
e_{q} = V_{C} &f_{q} = I_{C}\\
e_{p} = I_{L} & f_{p} = V_{L}
\end{cases}$$

#### Mass spring system
$$\begin{cases}
e_{q} = F_{S} &f_{q} = \dot{q}\\
e_{p} = \dot{x} & f_{p} = m\ddot{x}
\end{cases}$$

#### System Topology
- Kirchoff's laws
- Power Balance
- Kinematic Constraints

#### Storage elements
#### Capacitor
$$\dot{Q} = I_{c} $$
$$V_{c} = \frac{\partial }{\partial Q} H_{c}(Q) = \frac{\partial }{\partial Q} \left( \frac{Q^{2}}{2C} \right) = \frac{Q}{C}$$

#### Spring-mass system
$$\dot{q} = v_{s}$$

# II - Bond Graph
### Co-energy variables vs scattering variables
$$\begin{pmatrix}
w_{f} \\
w_{b}
\end{pmatrix} = \begin{pmatrix}
\frac{\sqrt{2}}{2} & -\frac{\sqrt{2}}{2} \\
\frac{\sqrt{2}}{2} & \frac{\sqrt{2}}{2}
\end{pmatrix}\begin{pmatrix}
e \\
f
\end{pmatrix}$$
$$P(t) = e(t)f(t) = \frac{w_{f}^{2}}{2}-\frac{w_{b}^{2}}{2}$$

### Junction structure
#### General case
![[Pasted image 20260421144958.png]]
Let a system, with $N$ inputs/outputs : 
$$\begin{array}{l}
\forall i \in N, u_{i}, y_{i} \in \{ e_{i}, f_{i} \}  \\
\Rightarrow \begin{cases}
u_{i} = e_{i} \Rightarrow y_{i} = f_{i} \\
\text{OR} \\
u_{i} = f_{i} \Rightarrow y_{i} = e_{i}
\end{cases}  \\
\Rightarrow \mathcal{P}(t) = \sum_{k=1}^{N} e_{k}f_{k} = 0
\end{array}$$
Then : 
$$\exists J \in \mathcal{M}_{N}(\mathbb{R}), \begin{cases}
y = J(t)u \\
\mathrm{rg}(J(t)) = N \\
J(t) = -J(t)^{\top}
\end{cases}$$
$$P(t) = u^{\top}y = u^{\top}J(t)u = 0$$


#### $0$-junction
$$\begin{cases}
e_{1} = \dots = e_{n} \\
f_{1}+ \dots +f_{n}=  0
\end{cases} \Leftrightarrow \begin{pmatrix}
f_{1} \\
e_{2} \\
e_{3} \\
\vdots \\
e_{n}
\end{pmatrix} = \begin{pmatrix}
0&-1&\dots&-1 \\
1&0&\dots&0 \\
\vdots&\vdots&&\vdots \\
1&0&\dots&0
\end{pmatrix}\begin{pmatrix}
e_{1} \\
f_{2} \\
f_{3} \\
\vdots \\
f_{n}
\end{pmatrix}$$
Power-balance equation : 
$$\mathcal{P}(t) = \sum_{k=1}^{n} e_{k}f_{k} = 0$$
![[Pasted image 20260421143842.png]]


#### $1$- junction
$$\begin{cases}
f_{1}=\dots=f_{n} \\
e_{1}+\dots+e_{n} = 0
\end{cases}\Leftrightarrow \begin{pmatrix}
e_{1} \\
f_{2} \\
f_{3} \\
\vdots \\
f_{n}
\end{pmatrix}= \begin{pmatrix}
0&-1&\dots&-1 \\
1&0&\dots&0 \\
\vdots&\vdots&&\vdots \\
1&0&\dots&0
\end{pmatrix}\begin{pmatrix}
f_{1} \\
e_{2} \\
e_{3} \\
\vdots \\
e_{n}
\end{pmatrix}$$
$$\mathcal{P}(t) = \sum_{k=1}^{n} e_{k}f_{k} = 0$$
![[Pasted image 20260421143848.png]]




# III - The Bond Graph causality and state space equation algorithms
![[Pasted image 20260421141634.png]]
When the power is negligible, signal connections are used.  



### Causal forms of some components
![[Pasted image 20260421142335.png]]
(ERREUR POUR LA DEUXIÈME CASUAL FORM DE LA RESISTANCE)

![[Pasted image 20260421145111.png]]

