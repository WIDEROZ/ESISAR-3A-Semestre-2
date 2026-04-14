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
