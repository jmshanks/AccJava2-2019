package interfacefun;

public class Point {
    public int x;
    public int y;
    
    public Point() {
        this.x = 0;
        this.y = 0;
    }
    
    public Point(int x, int y) {
        this();
        this.x = x;
        this.y = y;
    }
    
    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
//        String parentString = super.toString();
        return "(" + x + ", " + y + ")";// + "..." + parentString;
    }
}
