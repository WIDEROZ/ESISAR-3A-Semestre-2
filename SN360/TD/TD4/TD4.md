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
signal count_intern : unsigned(2 downto 0) := (others => '0');

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
	
		case state is
			when s0 =>
				if enable='1' and up='1' then
					state <= s1;
					nextState <= s2;
				else if enable='1' and down='1' then
					
				end if;
	
	
	
	end process;
	count <= count_int;
end BHV;


```