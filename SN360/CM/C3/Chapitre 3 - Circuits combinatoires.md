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
- $2$ vers $1$
- $4$ vers $1$











```VHDL

```