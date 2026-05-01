function  [sSys,sCor,sRepFreq,sRepTemp] = DISC_PID_EXEMPLE
% Fichier d'exemple de paramétrage de l'utilitaire PIDdiscSynth V7

% Définition du Système
Te = 0.01;      % Période d'échantillonnage
B = 5 ;         % numérateur de H(p)
A = [1 2 1] ;   % dénominateur de H(p)
H = tf(B,A);    % fonction de transfert à temps continu du système à contrôler
sys = c2d(H,Te,'zoh'); % Calcul de la fonction de transfert à temps discret

%--------------------------------------------------------------------------
% Système
sSys = struct(...
        'sys',     	sys,...	% Fonction de transfert du système en 'z'
        'ARef',     10,...  % Amplitude de la consigne
        'APu',     	3,... 	% Amplitude de l'entrée de perturbation de commande
        'APutau',   Te,...  % Constante de temps du 1er ordre de la perturbation
        'Nmax',     10 );   % Amplification max autorisée du bruit de mesure

% Correcteur
sCor = struct(...
        'Te',       Te,...      % Période d'échantillonnage
        'Gain',     3.5,...     % Gain proportionnel
        'Ki',       0.008,...   % Gain de l'intégrateur 
        'Int_on',   1,...       % Intégrateur : on=1, off=0
        'Kd',       22,...      % Gain du dérivateur
        'a' ,       2,...       % Coeff. de filtrage du dérivateur
        'Der_Ref',  1,...       % Derivation de la consigne : oui=1, non=0
        'Der_on',   1,...       % Application des gains P et D à la consigne : oui=1, non=0
        'Whf',      1,...       % Pulsation de coupure du filtre haute fréquence
        'Whf_on',   0,...       % Filtre HF : on=1, off=0
        'AddNum',   [1],...     % Numérateur correcteur additionnel (temps continu 's')
        'AddDen',   [0.1 1],... % Dénominateur correcteur additionnel (temps continu 's')
        'AddCont',  0,...       % Corr. Additionnel : on=1, off=0
        'Wref',     1,...       % Pulsation du Préfiltre
        'FilOrder', 1,...       % Prefilter order : 1=1st order, 2=2nd order
        'Wref_on',  1,...       % Préfiltre : on=1, off=0
        'Rmin',     0.001,...   % Valeur min pour les gains du correcteur (doit ^etre >0)
        'Rmax',     1000);      % Valeur max pour les gains du correcteur (doit ^etre >Rmin)

% Paramètres des Réponse fréquentielles
sRepFreq = struct(...
        'Wmin',     1e-3,...    % pulsation min (rad/s)
        'Wmax',     1e3,...     % pulsation max (rad/s)
        'Gdbmax',   60,...      % Gain max en dB
        'Gdbmin',  -40,...      % Gain min en dB
        'Pmax',     90,...      % Phase max en degrés
        'Pmin',   -225 );       % Phase min en degrés

% Réponse temporelle
sRepTemp = struct(...
        'Tinit',    30,...      % Durée initiale de la simulation
        'Tmin',     0.1,...     % Durée minimale de la simulation
        'Tmax',     100,...     % Durée maximale de la simulation
        'Ymax',     1.2*sSys.ARef,...     % Valeur max affichée pour Y
        'Ymin',    -0.2*sSys.ARef,...     % Valeur min affichée pour Y
        'Yticks', [-0.2 -0.05 0 0.05 0.95 1 1.05 1.2]*sSys.ARef,... % lignes pointillés
        'Umax',    8,...     % Valeur max affichée pour U
        'Umin',    -4,...       % Valeur min affichée pour U
        'Uticks', [ -4 -2 0 2 4 6 8] ); % lignes pointillés
%--------------------------------------------------------------------------