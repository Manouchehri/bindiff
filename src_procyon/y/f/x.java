package y.f;

public class x implements am
{
    protected double a;
    protected double b;
    protected double c;
    protected double d;
    
    public x() {
    }
    
    public x(final am am) {
        this(am.getX(), am.getY(), am.getWidth(), am.getHeight());
    }
    
    public x(final double a, final double b, final double c, final double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public void setLocation(final double a, final double b) {
        this.a = a;
        this.b = b;
    }
    
    public void a(final double n, final double n2) {
        this.a = n - this.c / 2.0;
        this.b = n2 - this.d / 2.0;
    }
    
    public void setSize(final double c, final double d) {
        this.c = c;
        this.d = d;
    }
    
    public double getHeight() {
        return this.d;
    }
    
    public double getWidth() {
        return this.c;
    }
    
    public double getX() {
        return this.a;
    }
    
    public double getY() {
        return this.b;
    }
}
