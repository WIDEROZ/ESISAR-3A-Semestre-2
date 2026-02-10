package EX3;

import java.util.ArrayList;

public class Rectangles {

    private Point P1 = new Point();
    private Point P2 = new Point();
    public static nbr = 0;

    public Rectangles(double l1, double l2, double l3, double l4){
        P1.setX(0);
        P1.setY(0);
        nbr++;

    }

    public Rectangles(Point a, Point b){
        P1.setPoint(a);
        P2.setPoint(b);
        nbr++;

    }

    

    public Rectangles(Point a, double x, double y){
        P1.setPoint(a);
        P2.setX(P1.getX() + x);
        P2.setY(P1.getY() + y);
        nbr++;
    }


    public double surface(){
        return abs(P2.getX() - P1.getX())*abs(P2.getY() - P1.getY());
    }

    public boolean contains(Point P){
        return (P1.getX()<= P.getX() <= P2.getX() || P2.getX()<= P.getX() <= P1.getX()
             && P1.getY()<= P.getY() <= P2.getY() || P2.getY()<= P.getY() <= P1.getY());
    }

    public boolean contains(Rectangles R){
        return (contains(R.P1) && contains(R.P2));
    }

    public boolean sameAs(Rectangles R){
        return (P1.sameAs(R.P1) && P2.sameAs(R.P2)) || (P2.sameAs(R.P1) && P1.sameAs(R.P2));
    }

    public Rectangles hull(ArrayList<Rectangles> R_list){
        double x_min = ;
        double y_min;
        double x_max;
        double y_max;

        for (Rectangles R : R_list) {
            if 
        }

    return ;
    }

}