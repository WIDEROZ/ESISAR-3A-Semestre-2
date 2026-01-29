# Download : AMD Vivado Design Suite: Standard Edition

# I. Introduction
## 1. Pourquoi utiliser des composants reconfigurables
#### Réduction du time to market (TTM)
#### Conception a l'aide de composants reconfigurables
- Hardware Description Language (HDL)
  + Very High speed Integrated Circuit HDL (VHDL)
  + Verilog


## Acronymes
- CPLD : Complex Programmable Logic Device
- FPGA : Field Programmable Gate Array
- ASIC : Application Specific Integrated Circuit
- MPSoC : Multi-Processor System-on-Chip
- SoPC : System-on-Programmable-Chip
- eFPGA : embedded FPGA

## 2. Architecture des FPGA SRAM
#### FPGA
![[Pasted image 20260129092624.png]]
Interconnection entre les cellules : Route bleue
IOB : Input Output Block
CLB : Configurable Logic Block
$1$ Bloc $=$ $1$ Bit


#### SRAM
![[Pasted image 20260129093305.png]]
Pour chaque : interconnection / IOB / CLB Il existe un bloc de SRAM qui contient le code de configuration binaire.

#### Look up table (LUT)
Faire toutes les fonction possibles avec $4$ bits d'entrée : 
![[Pasted image 20260129093813.png]]

#### Flot de conception
