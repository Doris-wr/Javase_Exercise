package Static;

public class CircleTest {
    public static void main(String[] args) {
        Circle c1=new Circle();
        c1.setRadius(2.4);
        Circle c2=new Circle(2.0);
        Circle c3=new Circle(3.5);
        System.out.println(c1.getRadius());
        System.out.println(c1.getId()+" "+c2.getId()+" "+c3.getId());
        System.out.println(Circle.getInit());
        System.out.println(Circle.getTotal());
    }
}
class Circle{
    private int id;
    private double radius;
    private static int init=1000;
    private static  int total=0;
    public Circle(){
        id=init++;
        total++;
    }
    public Circle(double radius){
        this();
        this.radius=radius;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public static int getInit() {
        return init;
    }

    public static void setInit(int init) {
        Circle.init = init;
    }

    public static int getTotal() {
        return total;
    }

    public static void setTotal(int total) {
        Circle.total = total;
    }
}
