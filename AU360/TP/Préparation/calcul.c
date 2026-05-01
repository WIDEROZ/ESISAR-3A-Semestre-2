#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define _USE_MATH_DEFINES

void marge_retard(){
    double p0 = 12.5;

    double omega_C;
    double M_phase;
    double M_retard;
    double r0, r1;
    double G = 2.3;
    double Te = 0.01;

    while (1){
        omega_C = sqrt(p0*(2*p0-4+sqrt(5*(p0*p0)-16*p0+16)));
        M_phase = atan((2*(p0-1)*omega_C)/(p0*p0))-atan(2/omega_C);
        M_retard = M_phase/omega_C;

        r0 = p0*p0/(2*G);
        r1 = (p0-1)/G;

        
        printf("p0 = %lf \n", p0);
        printf("omega_c = %lf \n", omega_C);
        printf("Marge de phase = %lf \n", M_phase*180/M_PI);
        printf("Marge de retard = %lf \n", M_retard);
        printf("r0 = %lf et r1 = %lf \n", r0, r1);

        printf("\n%lf + %lf p\n----------------------\n          p\n", r0, r1);

        printf("\n       %lf - %lf z^-1\n3.26 x ------------------------\n               1-z^-1\n", (r1+r0*Te)/3.26, r1/3.26);
        printf("\n%lf - %lf z^-1\n------------------------\n        1-z^-1\n", (r1+r0*Te), r1);


        printf("\n");
        printf("Entrez p0 = ");
        scanf("%lf", &p0);
        printf("\n");

    }
}


void calcul_coefs(){
    double Te = 0.01;
    double zBF = exp(-6.3*Te/0.387);
    double s0 = 3*zBF - 1.98;
    double r0 = (3*zBF*zBF-1.98*s0-0.98)/(0.046);
    double r1 = -(zBF*zBF*zBF-0.98*s0)/(0.046);

    printf("zBF = %lf \n", zBF);
    printf("s0 = %lf \n", s0);
    printf("r0 = %lf \n", r0);
    printf("r1 = %lf \n", r1);
}


int main(int argc, char const *argv[])
{
    
    
    marge_retard();

    return 0;
}
