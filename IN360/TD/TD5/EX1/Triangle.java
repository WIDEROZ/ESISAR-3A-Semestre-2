package EX1;

public class Triangle implements Figure{
    private int pointAx;
    private int pointAy;


    private int pointBx;
    private int pointBy;

    private int pointCx;
    private int pointCy;

    public Triangle(int pointAx, int pointAy, int pointBx, int pointBy, int pointCx, int pointCy) {
        this.pointAx = pointAx;
        this.pointAy = pointAy;
        this.pointBx = pointBx;
        this.pointBy = pointBy;
        this.pointCx = pointCx;
        this.pointCy = pointCy;
    }



        @Override
        public void afficher(){
            System.out.println("Je suis un Triangle :");
            System.out.println("Sommet A : x = " + pointAx + "; y = "+ pointAy);
            System.out.println("Sommet B : x = " + pointBx + "; y = "+ pointBy);
            System.out.println("Sommet C : x = " + pointCx + "; y = "+ pointCy);
        }

        @Override
        public void deplace(int dx, int dy){
            this.pointAx += dx;
            this.pointBx += dx;
            this.pointCx += dx;

            this.pointAy += dy;
            this.pointBy += dy;
            this.pointCy += dy;
        }

    
}
