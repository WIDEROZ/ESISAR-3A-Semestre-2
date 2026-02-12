# I - Définition
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





```VHDL

```

```Verilog

```