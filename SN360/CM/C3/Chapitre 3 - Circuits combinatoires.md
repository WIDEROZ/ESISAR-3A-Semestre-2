Interdiction de boucler des circuits combinatoires
# I. Opérateurs logiques
## 1. Opérateurs logiques
```VHDL

s<=not(a);
s<=sll(a);
s<=srl(a);
s<=s1 or s2;
s<=s1 nor s2;
s<=s1 xor s2;
s<=s1 xnor s2;
s<=s1 and s2;
s<=s1 nand s2;

```

```Verilog
assign s = ~a; // not(a)
assign s1 = a | b; // a or b
assign s2 = ~(a | b); // a nor b
assign s3 = a & b; // a and b
assign s4 = ~(a & b); // a nand b
assign s5 = a ^ b; // a xor b
assign s6 = a ~^ b; // a xnor b
```

## 2. Portes logiques

```VHDL
entity INV is
port(e : in bit; s : out bit);
end INV;

architecture RTL of INV is
begin
s<=not(e);
end RTL;
```

```Verilog
module INV (
input wire e,
output wire s );
assign s = ~e;
endmodule
```

## 3. Puissance
![[Pasted image 20260129120829.png]]
Puissance de charge / décharge du condensateur (Puissance dynamique) : 
$$P_d = CV_{DD}^{2}F$$
Puissance du courant de fuite (Puissance statique): 
$$P_{s} = V_{DD}I_{leak}$$
## 4. Temps de propagation
Le temp de charge et de décharge des capacités parasites est :
$$T_{\text{propagation}} \alpha RC$$

#### Process
Warn du synthétiseur :
```VHDL
s <= not(a) after 10 ns;
```
Sythétisable :
```VHDL
process(a)
begin
wait for 10 ns;
s <= not(a);
end process;
```
Les process font les instructions de manière séquentiels (while infini tant que $a$ change)

## 5. Entité et architecture
L'entité décrit le nom du composant, ses entrés et ses sorties (vue externe)
L'architecture décrit le comportement que l'entité doit avoir (vue interne)
```VHDL
-- Entitée
entity Fonction is
port(a, b, c : in bit;
	 F       : out bit);
end Fonction;

-- Architecture
architecture comb of Fonction is
begin
F <= (a and b) or c;
end comb;
```

## 6. Description structurelle
```VHDL
component And_Gate
port(a, b : in bit; s : out bit);
end component;

component Or_Gate
port(a, b : in bit; s : out bit);
end component;

signal interne : bit;
begin

And1:And_Gate -- And1 : Nom de l'instance
port map(a=>a,b=>b,s=>interne); -- Instanciation par dénomination

Or1:Or_Gate -- Or1 : Nom de l'instance
port map(interne,c,F); -- Instanciation par position
```

## 7. Tableau de Karnaugh
...
## 8. Multiplexeur
- $2$ vers $1$ : $f(a, b, s) = as + bs'$
- $4$ vers $1$ : $f(a, b, c, d, s_{1}, s_{2}) = as_{1}s_{2} + bs_{1}s_{2}' + cs_{1}'s_{2}+ ds_{1}'s_{2}'$
(Voir comme la relation $=$)
![[Pasted image 20260205092444.png]]
![[Pasted image 20260205092452.png]]

```VHDL
-- avec un processus
process(a, b, s)
begin
case s is
	when '0' => f<=a;
	when '1' => f<=b;
	when others => f<=a;
end case;
end process;

-- sans processus
with s select
	f<=a when '0';
	f<=b when '1';
	f<=a when others;
end;
```


## 8. Démultiplexeur
![[Pasted image 20260205093233.png]]

```VHDL
process(e, s)
begin
f1<='0'; f2<='0'; f3<='0'; f4<='0';
case s is
	when "00" => f1<=e;
	when "01" => f2<=e;
	when "10" => f3<=e;
	when "11" => f4<=e;
	when others =>
end case;
end process;
```


## 9. Décodeur
![[Pasted image 20260205093612.png]]

```VHDL
process(i, d)
begin
d<="0000";
case i is
	when "00" => d(0)<='1';
	when "01" => d(1)<='1';
	when "10" => d(2)<='1';
	when "11" => d(3)<='1';
	when others =>
end case;
end process;
```


## 10. Comparateurs
![[Pasted image 20260205093856.png]]
```VHDL
process(a,b)
begin
if a=b then
	s<='1';
else
	s<='0';
end if;
end process;
```
(le if fonctionne seulement à l’intérieur des processus)


#### Conditions
```VHDL
-- égalité
a=b
-- différent de :
a\=b
```


## 11. Additionneur
```VHDL
library IEEE;
use IEEE.std_logic_1164.all;
use IEEE.numeric_std.all;

signal s1: signed(3 downto 0);
signal s2: signed(3 downto 0);
signal s3 : signed(4 downto 0);

s3 <= s1(3)&s1 + s2;
-- n bit + k bit crée max(n, k) (longeur finale de s3)
-- & = opérateur de concaténation
```
On ajoute le bit de poids fort car c'est un signé. 


## 12. Soustracteur
$A+(-B)$

## 13. Multiplicateur
Attention avec les signés.
`VHDL s1*s2`

## 14. Division
Division par autre chose que $2$ possible mais GOURMAND en ressources.











```VHDL

```