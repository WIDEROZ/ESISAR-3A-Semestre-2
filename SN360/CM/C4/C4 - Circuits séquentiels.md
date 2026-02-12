# I - Définition
### Circuit comb
Un circuit combinatoire est un circuit ou la sortie peut changer si on a la même entrée.  

### 1. D-latch (Bascule Verrou)
![[Pasted image 20260212083806.png]]

```VHDL
process(d,c)
begin
if c='1' then
	q<=d;
end if;
end process;

```

```Verilog
always @(*)
begin
	if (c) begin
		q=d;
	end
end
```

##### Transparence des D-latch
Le résultat de : 
![[Pasted image 20260212085947.png]]
Dépend du temps de propagation. 

### 2. D-Flip-Flop
![[Pasted image 20260212090151.png]]
![[Pasted image 20260212090159.png]]
- Si D change quand H présente un front montant, Q est indéterminé
- Intervalle de commutation interdit de $D$ : $T_{\text{Setup}}$ avant et $T_{\text{Hold}}$ après le front d’horloge actif. 
![[Pasted image 20260212090658.png]]


#### Set / reset - enable
![[Pasted image 20260212091612.png]]
![[Pasted image 20260212092015.png]]
- Set : $Q=1$
- Reset : $Q = 0$
- Enable : Désactive le flip flop (Même si $H = 1$ et $D$ est une valeur différente de $Q$, $Q$ ne change pas)

#### Reset - Synchrone / Asynchrone
On appuie sur le reset : 
- Synchrone : On attend le front actif pour reset (montant ou descendant suivant le flip flop)
- Asynchrone : On reset directement. 

Reset synchrone : 
```VHDL
process(clk)
begin
if clk'event and clk='1' then
-- if rising_egde(clk) then
-- importer std_logic_1164 pour l'utiliser
	if reset = '1' then
		q <= '0';
	elsif enable = '1' then
		q <= d;
	end if;
end if;
end process;
```

Reset asynchrone : 
```Verilog
process(resset, clk)
begin
if reset='1' then
	q<=0;
elsif clk'event and clk='1' then
	if enable = '1' then
		q <= d;
	end if;
end if;
end process;
```

clk'event : bool toujours égal à $1$ 
Mais l'outil de synthèse ne va pas reconnaître que c'est un flip flop si il n'y a que : clk='1'
il faut donc mettre : clk'event and clk='1'

### 3. Signal d'horloge
Il provient toujours d'un oscillateur externe. 

```VHDL
signal clk : bit; -- par défaut initialisé à ‘0’
clk <= not clk after 10 ns;
-- période de 20 ns
-- ou avec un process
process
begin
	wait for 10 ns;
	clk <= not clk;
end process;
```

```Verilog
initial begin clk = 0;
// Initialisation de l'horloge à 0
end
always begin
#10 clk = ~clk;
// clk change toutes les 10ns
end
```

### 4. Test bench
Le test bench est un fichier HDL
- DUT : Device Under Test

Fichier a tester et nom de l'entité : dflipflop<font color="red">_TB</font>.VHDL
```VHDL
entity dflipflop_TB is
end dflipflop_TB;

architecture bhv of dflipflop_TB is
signal Reset_TB, Clock_TB, D_TB, Q_TB, Qn_TB : bit;

component dflipflop
	port(Clock, Reset, D : in bit;
		 Q, Qn           : out bit);
end component;

begin
Reset_TB <= '0', '1' after 15 ns;
Clock_TB <= not Clock_TB after 10 ns;
D_TB <= '0', '1' after 55 ns, '0' after 105 ns;
-- Tous les temps sont a partir de 0 ils ne s'additionnent pas

DUT: dflipflop
Port map(Clock_TB, Reset_TB, D_TB, Q_TB, Qn_TB);

End bhv;
```

### 5. Registre 
![[Pasted image 20260212095913.png]]



```VHDL
-- registre de taille à définir
signal d, q : bit_vector(…);
process(clk)
begin
if clk'event and clk='1' then
	-- ou if rising_edge(clk) then
	if reset = '1' then
	 q <= (others=>'0'); -- tous les bits de q so
```






```VHDL

```

```Verilog

```