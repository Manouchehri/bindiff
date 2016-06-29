package y.h;

import java.awt.geom.*;
import java.awt.*;

abstract class r implements az
{
    private final Ellipse2D a;
    
    r() {
        this.a = new Ellipse2D.Double(-20.0, -5.0, 10.0, 10.0);
    }
    
    public Rectangle getBounds() {
        return null;
    }
    
    public void a(final Graphics2D graphics2D) {
        final Stroke stroke = graphics2D.getStroke();
        graphics2D.setStroke(dr.a);
        this.b(graphics2D);
        graphics2D.setStroke(stroke);
    }
    
    void b(final Graphics2D graphics2D) {
    }
    
    void c(final Graphics2D graphics2D) {
        graphics2D.drawLine(-15, -8, -15, 8);
    }
    
    void d(final Graphics2D graphics2D) {
        graphics2D.drawLine(-10, 0, 2, 8);
        graphics2D.drawLine(-10, 0, 2, 0);
        graphics2D.drawLine(-10, 0, 2, -8);
    }
    
    void e(final Graphics2D graphics2D) {
        graphics2D.drawLine(-6, -8, -6, 8);
    }
    
    void f(final Graphics2D graphics2D) {
        graphics2D.drawLine(-10, -8, -10, 8);
    }
    
    void g(final Graphics2D graphics2D) {
        final Shape clip = graphics2D.getClip();
        graphics2D.clipRect(-12, -10, 12, 20);
        this.d(graphics2D);
        graphics2D.setClip(clip);
    }
    
    void h(final Graphics2D graphics2D) {
        final Color color = graphics2D.getColor();
        graphics2D.setColor(Color.WHITE);
        graphics2D.fill(this.a);
        graphics2D.setColor(color);
        graphics2D.draw(this.a);
    }
}
