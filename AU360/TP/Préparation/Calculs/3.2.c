#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define _USE_MATH_DEFINES

double Te=0.01;


void multiplier(double R1, double I1, double R2, double I2, double* real, double* imaginary){
    *real = R1*R2-I1*I2;
    *imaginary = R1*I2+R2*I1;
}

void diviser(double R1, double I1, double R2, double I2, double* real, double* imaginary){
    multiplier(R1, I1, R2, -I2, real, imaginary);
    *real = *real/(R2*R2+I2*I2);
    *imaginary = *imaginary/(R2*R2+I2*I2);
}

double module(double real, double imaginary){
    return sqrt(real*real + imaginary*imaginary);
}

double arg(double real, double imaginary){
    if (real == 0)
    {
        if(imaginary==0){
            printf("COMPLEXE NUL\n");
            return 0;
        }
        else if(imaginary >0){
            return M_PI/2;
        }
        else{
            return -M_PI/2;
        }
    }
    else if(real >0){
        return atan(imaginary/real);
    }
    else
    {
        if (imaginary >= 0)
        {
            return atan(imaginary/real)+M_PI;
        }
        else
        {
            return atan(imaginary/real)-M_PI;
        }
    }
}

void Hbo(double omega, double r0, double r1, double G, double *real, double *immaginary){
    double num_R;
    double num_I;
    double den_R;
    double den_I;

    multiplier(2*G, 0, r0, r1*omega, &num_R, &num_I);
    multiplier(0, omega, 2, omega, &den_R, &den_I);
    diviser(num_R, num_I, den_R, den_I, real, immaginary);

}

double marge_module(double omega_max, double step, double r0, double r1, double G){
    double min = INFINITY;
    double marge;
    double real, immaginary;

    for (double omega = 0; omega <= omega_max; omega+=step){
        Hbo(omega, r0, r1, G, &real, &immaginary);
        marge = module(1+real, immaginary);
        if (marge < min){
            min = marge;
        }
    }
    
    return marge;
}

double marge_phase(double omega_c, double r0, double r1, double G){
    double real;
    double immaginary;
    Hbo(omega_c, r0, r1, G, &real, &immaginary);
    return M_PI+arg(real, immaginary);
}



void calcul_coefs(){
    double G = 2.3;
    double p0;
    double r0, r1;


    printf("Entrez p0 : ");
    scanf("%lf", &p0);
    printf("\n");

    r0 = p0*p0/(2*G);
    r1 = (p0-1)/G;

    printf("p0 = %lf \n", p0);
    printf("r0 = %lf \n", r0);
    printf("r1 = %lf \n", r1);

    double omega_c=sqrt(p0*(2*p0-4+sqrt(5*(p0*p0)-16*p0+16)));
    double M_module = marge_module(M_PI/Te, M_PI/Te/1000,r0, r1, p0);
    double M_phase=marge_phase(omega_c, r0, r1, G);
    double M_retard = M_phase/omega_c;


    printf("omega_C = %lf\n", omega_c);
    printf("Marge de module = %lf\n", M_module);
    printf("Marge de phase = %lf°\n", M_phase*180/M_PI);
    printf("Marge de retard = %lf ms\n", M_retard*1000);

}

int main(int argc, char const *argv[])
{
    

    while(1){
        calcul_coefs();
    }
    return 0;
}
