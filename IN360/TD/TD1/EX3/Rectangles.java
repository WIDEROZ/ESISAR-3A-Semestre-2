package EX3;


public class Rectangles {

    private Point P1 = new Point();
    private Point P2 = new Point();

    public Rectangles(double l1, double l2, double l3, double l4){
        P1.setX(0);
        P1.setY(0);


    }

    public Rectangles(Point a, Point b){
        P1.setPoint(a);
        P2.setPoint(b);

    }

    

    public Rectangles(Point a, double x, double y){
        P1.setPoint(a);
        P2.setX(P1.getX() + x);
        P2.setY(P1.getY() + y);
    }


    public double surface(){
        return abs(P2.getX() - P1.getX())*abs(P2.getY() - P1.getY());
    }

    public boolean contains(Point P){
        return (P1.getX()<= P.getX() <= P2.getX() || P2.getX()<= P.getX() <= P1.getX()
             && P1.getY()<= P.getY() <= P2.getY() || P2.getY()<= P.getY() <= P1.getY());
    }

    public boolean contains(Rectangles R){
        return ();
    }

}