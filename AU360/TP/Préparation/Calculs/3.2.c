#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define _USE_MATH_DEFINES

double module(double real, double imaginary){
    return sqrt(real*real + imaginary*imaginary);
}

double HboP1_module(double omega, double p0){
    double G = 2.3;
    double r0 = p0*p0/(2*G);
    double r1 = (p0-1)/G;

    double gain = 2*G;
    double REAL_num = r0;
    double IMAG_num = r1*omega;
    double REAL_den = -omega*omega;
    double IMAG_den = 2*omega;
    



    return gain*module(REAL_num, IMAG_num)/module(REAL_den, IMAG_den);
}



double marge_module(double omega_max, double step, double p0){
    double min = INFINITY;
    double module;

    for (double omega = 0; omega <= omega_max; omega += step){
        module = HboP1_module(omega, p0);
        if(module < min){
            min = module;
        }
        
    }
    

    return min;
}

double marge_phase(double omega_C, double p0){
    return atan((2*(p0-1)*omega_C)/(p0*p0))-atan(2/omega_C);
}



void marge_retard(){
    double p0 = 12.5;

    double omega_C;
    double M_module;
    double M_phase;
    double M_retard;
    double r0, r1;
    double G = 2.3;
    double Te = 0.01;

    while (1){
        omega_C = sqrt(p0*(2*p0-4+sqrt(5*(p0*p0)-16*p0+16)));
        M_module = marge_module(M_PI/Te, M_PI/Te/1000000, p0);
        M_phase = marge_phase(omega_C, p0);
        M_retard = M_phase/omega_C;

        r0 = p0*p0/(2*G);
        r1 = (p0-1)/G;

        
        printf("p0 = %lf\n", p0);
        printf("omega_c = %lf\n", omega_C);
        printf("Marge de module = %lf\n", M_module);
        printf("Marge de phase = %lf°\n", M_phase*180/M_PI);
        printf("Marge de retard = %lf ms\n", M_retard*1000);
        printf("r0 = %lf et r1 = %lf\n", r0, r1);

        printf("\n%lf + %lf p\n----------------------\n          p\n", r0, r1);

        printf("\n       %lf - %lf z^-1\n3.26 x ------------------------\n               1-z^-1\n", (r1+r0*Te)/3.26, r1/3.26);
        printf("\n%lf - %lf z^-1\n------------------------\n        1-z^-1\n", (r1+r0*Te), r1);


        printf("\n");
        printf("Entrez p0 = ");
        scanf("%lf", &p0);
        printf("\n");

    }
}


int main(int argc, char const *argv[])
{
    
    
    marge_retard();

    return 0;
}
