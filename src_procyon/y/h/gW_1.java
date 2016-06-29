package y.h;

import java.awt.geom.*;
import java.awt.*;

public class gW implements az
{
    protected ch a;
    protected az b;
    
    public gW(final ch a, final az b) {
        this.a = a;
        this.b = b;
    }
    
    public Rectangle getBounds() {
        final Rectangle a = this.a();
        final Point2D viewPoint2D = this.a.getViewPoint2D();
        final double n = 1.0 / this.a.getZoom();
        final AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(viewPoint2D.getX(), viewPoint2D.getY());
        affineTransform.scale(n, n);
        return affineTransform.createTransformedShape(a).getBounds();
    }
    
    public void a(final Graphics2D graphics2D) {
        final AffineTransform transform = graphics2D.getTransform();
        final cV a = hk.a(graphics2D);
        Label_0077: {
            if (a != null && a.a() != null) {
                graphics2D.setTransform(a.a());
                if (!fj.z) {
                    break Label_0077;
                }
            }
            final Point2D viewPoint2D = this.a.getViewPoint2D();
            final double n = 1.0 / this.a.getZoom();
            graphics2D.translate(viewPoint2D.getX(), viewPoint2D.getY());
            graphics2D.scale(n, n);
        }
        this.b(graphics2D);
        graphics2D.setTransform(transform);
    }
    
    protected void b(final Graphics2D graphics2D) {
        this.b.a(graphics2D);
    }
    
    protected Rectangle a() {
        return this.b.getBounds();
    }
}
