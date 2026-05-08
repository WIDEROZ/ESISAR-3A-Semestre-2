% Script MATLAB pour tracer le diagramme de Nyquist avec marge de module min|1+H| et marge de phase
clc;
clear;
close all;

Te=0.01;

r0=1.28;
r1=-1.21;
s0=0.569;

%% Définition du système (exemple : fonction de transfert)
num = [0, 0, 0.046*r0, 0.046*r1];          % Numérateur
den = [1, -(s0 + 1.980), (1.980 * s0 + 0.980), -0.980 * s0];
G = tf(num, den, Te);   % Fonction de transfert du système

%% Calcul de la réponse en fréquence
w = logspace(-2, 2, 1000); % Plage de fréquences (rad/s)
[mag, phase] = bode(G, w);
mag = squeeze(mag); % Convertir en vecteur
phase = squeeze(phase); % Convertir en vecteur

%% Calcul de H(jω) = G(jω)
H = mag .* exp(1i * phase * pi/180); % Convertir la phase en radians

%% Calcul de 1 + H(jω)
one_plus_H = 1 + H;

%% Calcul de |1 + H(jω)| (module)
module_one_plus_H = abs(one_plus_H);

%% Trouver la marge de module : min|1 + H(jω)|
min_module = min(module_one_plus_H);
fprintf('Marge de module (min|1 + H|) : %.4f\n', min_module);

%% Calcul de la marge de phase
% Trouver la fréquence de coupure (où |H| = 1)
[~, idx_crossover] = min(abs(mag - 1));
w_crossover = w(idx_crossover);
phase_crossover = phase(idx_crossover);

% Interpolation pour une meilleure précision
if idx_crossover > 1 && idx_crossover < length(w)
    w1 = w(idx_crossover-1); w2 = w(idx_crossover+1);
    m1 = mag(idx_crossover-1); m2 = mag(idx_crossover+1);
    p1 = phase(idx_crossover-1); p2 = phase(idx_crossover+1);

    % Interpolation linéaire pour w_crossover
    w_crossover = w1 + (1 - m1) * (w2 - w1) / (m2 - m1);
    phase_crossover = p1 + (w_crossover - w1) * (p2 - p1) / (w2 - w1);
end

% marge de phase
phase_margin = 180 + phase_crossover;
fprintf('Marge de phase : %.2f° à la fréquence %.2f rad/s\n', phase_margin, w_crossover);

fprintf('Marge de retard : %.2f ms, à la fréquence %.2f rad/s\n',phase_margin*pi/180/w_crossover*1000, w_crossover);
%% Tracer le diagramme de Nyquist
figure;
plot(real(H), imag(H), 'r-', 'LineWidth', 1.5); % Courbe de Nyquist en rouge
hold on;
grid on;
xlabel('Axe réel');
ylabel('Axe imaginaire');
title('Diagramme de Nyquist avec marges de module et de phase');

%% Tracer le point critique (-1, 0)
plot(-1, 0, 'ro', 'MarkerSize', 10, 'MarkerFaceColor', 'r');
text(-1, 0.1, 'Point critique (-1, 0)', 'Color', 'r', 'HorizontalAlignment', 'center');

%% Tracer un cercle centré sur (-1, 0) avec rayon = min_module
theta = linspace(0, 2*pi, 100);
x_circle = -1 + min_module * cos(theta);
y_circle = 0 + min_module * sin(theta);
plot(x_circle, y_circle, 'b--', 'LineWidth', 1);
text(-1, -min_module - 0.1, sprintf('Marge de module = %.4f', min_module), 'Color', 'b', 'HorizontalAlignment', 'center');

%% Tracer des lignes pour les axes réel et imaginaire
plot([-2 1], [0 0], 'k-', 'LineWidth', 0.5); % Axe réel
plot([0 0], [-1.5 1.5], 'k-', 'LineWidth', 0.5); % Axe imaginaire

%% Tracer la marge de phase
% Point à la fréquence de coupure
H_crossover = H(idx_crossover);
plot(real(H_crossover), imag(H_crossover), 'go', 'MarkerSize', 8, 'MarkerFaceColor', 'g');
text(real(H_crossover), imag(H_crossover) + 0.1, sprintf('Fréquence de coupure (%.2f rad/s)', w_crossover), 'Color', 'g', 'HorizontalAlignment', 'center');

% Tracer une ligne entre l'origine et H_crossover
plot([0, real(H_crossover)], [0, imag(H_crossover)], 'g--', 'LineWidth', 1);

% Tracer l'arc pour la marge de phase
angle_arc = linspace(180 * pi/180, (180 + phase_margin) * pi/180, 50);
x_arc = 0.5 * cos(angle_arc);
y_arc = 0.5 * sin(angle_arc);
plot(x_arc, y_arc, 'g-', 'LineWidth', 1.5);
text(0.3, 0.3, sprintf('Marge de phase = %.2f°', phase_margin), 'Color', 'g', 'HorizontalAlignment', 'center');

%% Ajuster les limites des axes
xlim([-2 1]);
ylim([-1.5 1.5]);
axis equal; % Pour que les axes aient la même échelle