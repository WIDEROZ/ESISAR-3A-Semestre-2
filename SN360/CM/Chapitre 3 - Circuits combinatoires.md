Interdiction de boucler des circuits combinatoires
# I. Opérateurs logiques
#### Opérateurs logiques
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

#### Portes logiques

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
