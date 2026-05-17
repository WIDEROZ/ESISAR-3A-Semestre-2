library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity COUNTER_TB is
end COUNTER_TB;

architecture bhv of COUNTER_TB is
    signal clk_TB : STD_LOGIC := '0';
    signal rst_TB : STD_LOGIC;
    signal start_TB : STD_LOGIC;
    signal seconds_TB : std_logic_vector(7 downto 0);
    signal minutes_TB : STD_LOGIC_VECTOR(7 downto 0);

    component chrono
        Port ( 
            start : in std_logic;
            clk   : in std_logic;
            rst   : in std_logic;
            
            seconds : out std_logic_vector(7 downto 0);
            minutes : out std_logic_vector(7 downto 0)
        );
    end component;

begin
    clk_TB <= not clk_TB after 5 ns;

    stim_proc :	process
	begin
		rst_tb		<= '0';
		start_tb	<= '1';
		


		wait;
    end process;

    DUT: chrono
        port map (
            clk => clk_TB,
            rst => rst_TB,
            start => start_TB,
            seconds => seconds_TB,
            minutes => minutes_TB
        );
end bhv;


