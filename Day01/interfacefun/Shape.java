package interfacefun;

public abstract class Shape implements Drawable {
    
    protected Point origin;
    
    abstract public double getArea();
    abstract public double getPerimeter();
    
    public Shape() {
        this.origin = new Point();
    }
    
    public Shape(Point origin) {
        this();
        this.origin = origin;
    }

    public Point getOrigin() {
        return origin;
    }

    public void setOrigin(Point origin) {
        this.origin = origin;
    }
    
    public void sayHello() {
        System.out.println("Hello!");
    }
}
