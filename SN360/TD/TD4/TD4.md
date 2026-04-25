# Exercice 1
## 1.
EXCAL
## 2.

```VHDL
library IEEE;
use IEEE.std_logic_1164.all;

entity COUNTER is
begin
port(
	clk    : in STD_LOGIC;
	enable : in STD_LOGIC;
	rst    : in STD_LOGIC;
	up     : in STD_LOGIC;
	douwn  : in STD_LOGIC;
	count  : out STD_LOGIC_VECTOR(2 downto 0)
)
end COUNT;

architecture BHV of COUNT is

type stateType is (s0, s1, s2, s3, s4, s5);
signal state, nextState : stateType;


begin
	process(clk)
	begin
		if clk'event and clk='1' then
			if rst='1' then
				state <= s0;
			else
				state <= nextState;
			end if;
		end if;
		
	end process;
	
	process(state, up, down, enable)
	begin
		nextState <= state;
		count <= (others => '0');
		
		case state is
			when s0 =>
				if enable='1' and
				up='1' and down='0' then
					
					nextState <= s1;
					
				elsif enable='1' and
				down='1' and up='0' then
					
					nextState <= s5;
				
				end if;
				
				count <= (others => '0');
			
			when s1 =>
				if enable='1' and
				up='1' and down='0' then
					
					nextState <= s2;
					
				elsif enable='1' and
				down='1' and up='0' then
					
					nextState <= s0;
				
				end if;
				
				count <= '001';
			
			-- etc...
	
	
	
	end process;
	count <= count_intern;
end BHV;
```

# Exercice 2
## 1.
```VHDL
library IEEE;
use IEEE.std_logic_1164.all;

entity TOGGLE is
begin
	port(
		clk : in STD_LOGIC;
		rst : in STD_LOGIC;
		t   : in STD_LOGIC;
		q   : out STD_LOGIC
	)
end TOGGLE;

architecture BHV of TOGGLE is
type stateType is (s0, s1);
signal state, nextState : stateType;

begin
	process(rst)
	begin
		if rst='1' then
			state <= s0;
		end if;
	end process;
	
	process(state, t)
	begin
		case state is
		when s0 =>
			if t = '0' then
				nextState <= s0;
			if t = '1' then
				nextState <= s1;
				q <= not(q);
		
	end process;


end BHV;
```

# Exercice 3
## 1.
![[Pasted image 20260424114806.png]]

#### 2.
$$2 \text{ car }(4 \text{ états})$$
#### 3.
```VHDL
library IEEE;
use IEEE.std_logic_1164.all;

entity DETECTOR is 
begin
	port(
		a   : in STD_LOGIC;
		b   : in STD_LOGIC;
		c   : in STD_LOGIC;
		clk : in STD_LOGIC;
		rst : in STD_LOGIC;
		x   : out STD_LOGIC;
	)
	
end DETECTOR;

architecture BEHAV of DETECTOR is

type stateType is (s0, s1, s2, s3, s4);
signal state, nextState : stateType;

begin
	process(clk)
	begin
		if clk'event and clk='1' then
			if rst='1' then
				state <= s0;
			else
				state <= nextState;
			end if;
		end if;
	end process;
	
	process(state, a, b, c)
	begin
		nextState <= state;
		x <= '0';
		
		case state is
			when s0 =>
				if a='1' then
					nextState <= s1;
				end if;
				
			when s1 =>
				if a='0' then
					nextState <= s0;
				else if b='1' then
					nextState <= s2;
				end if;
			
			when s2 =>
				if a='0' then
					nextState <= s0;
				else if b='0' then
					nextState <= s1;
				else if c='1' then
					nextState <= s3;
				end if;
				
			when s3 =>
				x <= '1';
				if a='0' then
					nextState <= s0;
				else if b='0' then
					nextState <= s1;
				else if c='0' then
					nextState <= s2;
				end if;
	end process;
	
	
end BEHAV;
```
