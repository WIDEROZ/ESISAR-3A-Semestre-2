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

void Hbo(double omega, double r0, double r1, double s0, double *real, double *immaginary){
    double z_R = cos(omega*Te);
    double z_I = sin(-omega*Te);

    double z2_R;
    double z2_I;

    multiplier(z_R, z_I,z_R, z_I,&z2_R, &z2_I);

    double num_R;
    double num_I;
    double den_R;
    double den_I;

    multiplier(0.046, 0, z2_R, z2_I, &num_R, &num_I);
    multiplier(0.98, 0, z_R, z_I, &den_R, &den_I);
    den_R=1-den_R;
    den_I=-den_I;
    diviser(num_R, num_I, den_R, den_I, real, immaginary);


    multiplier(r1, 0, z_R, z_I, &num_R, &num_I);
    num_R=r0-num_R;
    num_I=-num_I;

    multiplier(1-z_R, -z_I, 1-s0*z_R, -s0*z2_I, &den_R, &den_I);
    diviser(num_R, num_I, den_R, den_I, &num_R, &num_I);
    multiplier(*real, *immaginary, num_R, num_I, real, immaginary);




}

double marge_module(double omega_max, double step, double r0, double r1, double s0){
    double min = INFINITY;
    double marge;
    double real, immaginary;

    for (double omega = 0; omega <= omega_max; omega+=step){
        Hbo(omega, r0, r1, s0, &real, &immaginary);
        marge = module(1+real, immaginary);
        if (marge < min){
            min = marge;
        }
    }
    
    return marge;
}

double calcul_omega_c(double r0, double r1, double s0, double omega_min, double omega_max, double tolerance){
    double real;
    double immaginary;
    double module_mid;
    double omega_mid;

    
    Hbo(omega_min, r0, r1, s0, &real, &immaginary);
    double module_min = module(real, immaginary);

    Hbo(omega_max, r0, r1, s0, &real, &immaginary);
    double module_max = module(real, immaginary);

    if ((module_min - 1) * (module_max - 1) > 0) {
        printf("La fréquence de coupure n'est pas dans l'intervalle donné.\n");
        return -1;
    }


    while(omega_max - omega_min > tolerance){
        omega_mid = (omega_min + omega_max) / 2;
        Hbo(omega_mid, r0, r1, s0, &real, &immaginary);
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

double marge_phase(double omega_c, double r0, double r1, double s0){
    double real;
    double immaginary;
    Hbo(omega_c, r0, r1, s0, &real, &immaginary);
    return M_PI+arg(1+real, immaginary);
}



void calcul_coefs(){
    double t_rep=0.437;
    double zBF = exp(-6.3*Te/t_rep);
    double s0 = 3*zBF - 1.98;
    double r0 = (3*zBF*zBF-1.98*(3*zBF - 1.98)-0.98)/(0.046);
    double r1 = -(zBF*zBF*zBF-0.98*(3*zBF - 1.98))/(0.046);

    printf("zBF = %lf \n", zBF);
    printf("s0 = %lf \n", s0);
    printf("r0 = %lf \n", r0);
    printf("r1 = %lf \n", r1);

    double omega_c=calcul_omega_c(r0, r1, s0, 1, M_PI/Te, 0.01);
    double M_module = marge_module(M_PI/Te, M_PI/Te/1000,r0, r1, s0);
    double M_phase=marge_phase(omega_c, r0, r1, s0);
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
