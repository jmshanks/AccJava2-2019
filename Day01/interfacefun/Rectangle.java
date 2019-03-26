package interfacefun;

public class Rectangle extends Shape {
    
    protected int length;
    protected int width;
    
    public Rectangle() {
        this.length = 3;
        this.width = 5;
    }

    public Rectangle(int length, int width) {
        this();
        this.length = length;
        this.width = width;
    }
    
    public Rectangle getMe() {
        return this;
    }
    
    public boolean isSquare() {
        return this.length == this.width;
    }
    
    @Override
    public double getArea() {
        return this.getWidth() * this.getLength();
    }
    
    @Override
    public double getPerimeter() {
        return (this.getWidth() * 2) + (this.getLength() * 2);
    }
    
    public static int calcArea(Rectangle r) {
        return r.getWidth() * r.getLength();
    }
    
    public static int calcPerimeter(Rectangle r) {
        return (r.getWidth() * 2) + (r.getLength() * 2);
    }

    @Override
    public void draw() {
        System.out.println("------");
        System.out.println("|    |");
        System.out.println("------");
    }
    
    // ** STANDARD GETTERS AND SETTERS FROM HERE **

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
