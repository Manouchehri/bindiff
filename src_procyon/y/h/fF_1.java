package y.h;

import java.awt.geom.*;
import java.awt.*;

class fF implements az
{
    private Rectangle2D.Double a;
    private Color b;
    
    private fF() {
        this.a = new Rectangle2D.Double();
        this.b = new Color(100, 100, 100, 100);
    }
    
    public void a(final double n, final double n2, final double n3, final double n4) {
        this.a.setRect(n, n2, n3, n4);
    }
    
    public void a(final Graphics2D graphics2D) {
        final Color color = graphics2D.getColor();
        graphics2D.setColor(this.b);
        graphics2D.fill(this.a);
        graphics2D.setColor(color);
    }
    
    public boolean a(final double n, final double n2) {
        return this.a.contains(n, n2);
    }
    
    public Rectangle getBounds() {
        return this.a.getBounds();
    }
    
    fF(final fE fe) {
        this();
    }
    
    static Rectangle2D.Double a(final fF ff) {
        return ff.a;
    }
}
