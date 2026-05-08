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

void Hbo(double omega, double K, double *real, double *immaginary){
    double z_R = cos(omega*Te);
    double z_I = sin(-omega*Te);

    double z2_R;
    double z2_I;

    multiplier(z_R, z_I,z_R, z_I,&z2_R, &z2_I);

    double num_R;
    double num_I;
    double den_R;
    double den_I;

    multiplier(K*0.046, 0, z2_R, z2_I, &num_R, &num_I);

    multiplier(1, 0, 1-z_R, -z_I, &den_R, &den_I);


    diviser(num_R, num_I, den_R, den_I, real, immaginary);
}

double marge_module(double omega_max, double step, double K){
    double min = INFINITY;
    double marge;
    double real, immaginary;

    for (double omega = 0; omega <= omega_max; omega+=step){
        Hbo(omega, K, &real, &immaginary);
        marge = module(1+real, immaginary);
        if (marge < min){
            min = marge;
        }
    }
    
    return marge;
}

double calcul_omega_c(double K, double omega_min, double omega_max, double tolerance){
    double real;
    double immaginary;
    double module_mid;
    double omega_mid;

    
    Hbo(omega_min, K, &real, &immaginary);
    double module_min = module(real, immaginary);

    Hbo(omega_max, K, &real, &immaginary);
    double module_max = module(real, immaginary);

    if ((module_min - 1) * (module_max - 1) > 0) {
        printf("La fréquence de coupure n'est pas dans l'intervalle donné.\n");
        return -1;
    }


    while(omega_max - omega_min > tolerance){
        omega_mid = (omega_min + omega_max) / 2;
        Hbo(omega_mid, K, &real, &immaginary);
        module_mid = module(real, immaginary);

        if (fabs(module_mid - 1) < tolerance){
            printf("PERFEEEEEEEEECT\n");
            return omega_mid;
        }
        else if((module_min - 1) * (module_mid - 1) < 0){
            omega_max = omega_mid;
            module_max = module_mid;
        }
        else{
            omega_min = omega_mid;
            module_min = module_mid;
        }
    }
    

    
    return (omega_min + omega_max) / 2;
}

double marge_phase(double omega_c, double K){
    double real;
    double immaginary;
    Hbo(omega_c, K, &real, &immaginary);
    return M_PI+arg(real, immaginary);
}



void calcul_coefs(){
    double K=2.84;

    printf("K = %lf \n", K);
    

    double omega_c=calcul_omega_c(K, 1, M_PI/Te, 0.01);
    double M_module = marge_module(M_PI/Te, M_PI/Te/1000, K);
    double M_phase=marge_phase(omega_c, K);
    double M_retard = M_phase/omega_c;


    printf("omega_C = %lf\n", omega_c);
    printf("Marge de module = %lf\n", M_module);
    printf("Marge de phase = %lf°\n", M_phase*180/M_PI);
    printf("Marge de retard = %lf ms\n", M_retard*1000);

}

int main(int argc, char const *argv[])
{
    

    calcul_coefs();
    return 0;
}
