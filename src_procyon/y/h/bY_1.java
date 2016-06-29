package y.h;

import java.awt.*;
import java.awt.geom.*;

public abstract class bY extends bX
{
    Color g;
    
    public bY() {
        this.g = Color.lightGray;
    }
    
    public void a(final Graphics2D graphics2D) {
        this.a();
        if (this.g != null) {
            graphics2D.setColor(this.g);
            graphics2D.fill(this.f);
        }
        if (this.c != null && this.e != null) {
            graphics2D.setColor(this.c);
            final Rectangle2D bounds = this.e.getBounds();
            this.e.draw(graphics2D, (float)(this.f.x + (this.f.width - bounds.getWidth()) / 2.0), (float)(this.f.y - bounds.getY() + (this.f.height - bounds.getHeight()) / 2.0));
        }
    }
    
    public void b(final Color g) {
        this.g = g;
    }
}
