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

begin
	process(clk, up, down)
	begin
		if up='1' then
			count_int = count_int + 1;
		end if;
		if down='1' then
			count_int = count_int - 1;
		end if;
		
		if clk'event and clk='1' then
			
		end if;
		
	end process;
end BHV;


```