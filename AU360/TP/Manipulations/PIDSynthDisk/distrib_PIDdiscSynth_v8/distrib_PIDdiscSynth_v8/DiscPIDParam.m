% (Data in descending powers of z)

% System file : disc_v8_pid_exemple.m

% System transfer function H(z) = B(z)/A(z) :
B = [  0  0.00024834  0.00024669  ]
A = [  1  -1.9801  0.9802  ]

Te = 0.01    % Sampling time (s)

% H(z) in PZK form :
Zeros_H = [  -0.9933555  ]
Poles_H = [  0.99004984  0.99004982  ]
k_H =0.00024833957  

% Design parameters :
ARef   = 10   % Reference magnitude
APu    = 3   % Input disturbance magnitude
APutau = 0.01   % Input disturbance First order constant time
Nmax   = 10  % Noise maximum amplification

% PID parameters :
K  = 0.638    % Gain
Ki = 0.011189    % Integral gain
Kd = 45.555    % Derivative gain (s)
a  = 2    % Derivative filter
zd = 0.95705    %      filter pole
% Reference Derivation : yes
% High frequency filter : off

% PID controller in transfer function form C(z) = Cnum(z)/Cden(z) :
Cnum = 1.8938 * [  1  -1.9815957  0.98175765  ]
Cden = [  1  -1.9570469  0.95704686  ]

% PID controller transfer function with explicit integrator :
Cnum = 1.8938 * [  1  -1.9815957  0.98175765  ]
Cden = conv( [ 1 -1 ] , [ 1  -0.95704686  ] )


% PID controller in PZK form :
Zeros_C = [  0.99079786  0.99079786  ]
Poles_C = [  1  0.95704686  ]
k_C =1.8937839  
% Prefilter pulsation (rad/s), Wref = 1
% Prefilter transfer function F(z) = Fnum(z)/Fden(z) :
Fnum = [  0  0.0099501663  ]
Fden = [  1  -0.99004983  ]

% Gain Margin  : 40 dB at 30 rad/s
% Phase Margin : 61.1 deg at 1.76  rad/s
% Delay Margin : 0.61 sec at 1.76  rad/s
% Module Margin : 0.792
% |Hxd|_2_step : 0.101
% C-Loop Stable : Yes

% Step time 7.61 s