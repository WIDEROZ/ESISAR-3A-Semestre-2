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
## 4. Temps
$$$$