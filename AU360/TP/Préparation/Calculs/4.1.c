#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define _USE_MATH_DEFINES

#define K 2.83

double C = K*0.046;

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

double HboP1_module(double omega, double Te){
    double z_REAL = cos(omega*Te);
    double z_IMAG = sin(-omega*Te);

    double z2_REAL = z_REAL*z_REAL-z_IMAG*z_IMAG;
    double z2_IMAG = 2*z_IMAG*z_REAL;

    double num_REAL = 1-z_REAL+C*z2_REAL;
    double num_IMAG = -z_IMAG+C*z2_IMAG;
    
    double den_REAL = 1-z_REAL;
    double den_IMAG = -z_IMAG;


    return module(num_REAL, num_IMAG)/module(den_REAL, den_IMAG);
}

double marge_module(double omega_max, double step, double Te){
    double min = INFINITY;
    double module;

    for (double omega = 0; omega <= omega_max; omega += step){
        module = HboP1_module(omega, Te);
        if(module < min){
            min = module;
        }
        
    }
    

    return min;
}

double marge_phase(double omega_C, double Te){
    return M_PI-(omega_C*Te+atan(sin(omega_C*Te)/(1-cos(omega_C*Te))));
}



int main(int argc, char const *argv[])
{
    double Te=0.01;

    double omega_C = acos((2-C*C)/2)/Te;
    double M_module = marge_module(M_PI/Te, M_PI/Te/1000000, Te);
    double M_phase = marge_phase(omega_C, Te);
    double M_retard = M_phase/omega_C;
    printf("omega_C = %lf\n", omega_C);
    printf("Marge de module = %lf\n", M_module);
    printf("Marge de phase = %lf°\n", M_phase*180/M_PI);
    printf("Marge de retard = %lf ms\n", M_retard*1000);
    return 0;
}
