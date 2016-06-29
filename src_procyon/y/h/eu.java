package y.h;

import java.awt.geom.*;

final class eu extends Rectangle2D
{
    private final fj a;
    
    protected eu(final fj a) {
        this.a = a;
    }
    
    public Rectangle2D createIntersection(final Rectangle2D rectangle2D) {
        return null;
    }
    
    public Rectangle2D createUnion(final Rectangle2D rectangle2D) {
        return null;
    }
    
    public int outcode(final double n, final double n2) {
        return 0;
    }
    
    public void setRect(final double n, final double n2, final double n3, final double n4) {
    }
    
    public double getHeight() {
        return this.a.getHeight();
    }
    
    public double getWidth() {
        return this.a.getWidth();
    }
    
    public double getX() {
        return this.a.getX();
    }
    
    public double getY() {
        return this.a.getY();
    }
    
    public boolean isEmpty() {
        return false;
    }
}
