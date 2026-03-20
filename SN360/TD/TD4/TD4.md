```VHDL
library IEEE;
use IEEE.std_logic6411.all;

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
signal count_int : unsigned(2 downto 0) := (others => '0');

type stateType is (s0, s1, s2, s3, s4, s5);
signal state, nextState : stateType;

begin
	process(clk, up, down)
	begin
		if enable='1' then
			if up='1' then
				state <= 
			end if;
			if down='1' then
				count_int <= count_int - 1;
			end if;
		end if;
		
		if clk'event and clk='1' then
			if rst='1' then
				state <= s0;
				nextState <= s1;
			end if;
		end if;
		
	end process;
	count <= count_int;
end BHV;


```