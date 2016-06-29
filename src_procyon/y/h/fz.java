package y.h;

import java.awt.geom.*;

class fz
{
    private double a;
    private double b;
    private double c;
    private double d;
    
    public fz() {
        this(-1.7976931348623157E308, Double.MAX_VALUE, -1.7976931348623157E308, Double.MAX_VALUE);
    }
    
    public fz(final double a, final double b, final double c, final double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public double a() {
        return this.a;
    }
    
    public void a(final double a) {
        this.a = a;
    }
    
    public double b() {
        return this.b;
    }
    
    public void b(final double b) {
        this.b = b;
    }
    
    public double c() {
        return this.c;
    }
    
    public void c(final double c) {
        this.c = c;
    }
    
    public double d() {
        return this.d;
    }
    
    public void d(final double d) {
        this.d = d;
    }
    
    public void a(final Point2D point2D) {
        if (point2D.getX() > this.b()) {
            point2D.setLocation(this.b(), point2D.getY());
        }
        if (point2D.getX() < this.a()) {
            point2D.setLocation(this.a(), point2D.getY());
        }
        if (point2D.getY() > this.d()) {
            point2D.setLocation(point2D.getX(), this.d());
        }
        if (point2D.getY() < this.c()) {
            point2D.setLocation(point2D.getX(), this.c());
        }
    }
    
    boolean a(final double n, final double n2) {
        return this.a() <= n && n <= this.b() && this.c() <= n2 && n2 <= this.d();
    }
}
