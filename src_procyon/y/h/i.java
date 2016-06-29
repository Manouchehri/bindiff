package y.h;

import java.awt.geom.*;
import java.awt.*;

class i implements az
{
    GeneralPath a;
    GeneralPath b;
    
    i() {
        this.a = new GeneralPath(1, 3);
        this.b = new GeneralPath(1, 3);
        this.a.moveTo(0.0f, 0.0f);
        this.a.quadTo(-6.0f, 0.0f, -10.0f, -6.0f);
        this.b.moveTo(0.0f, 0.0f);
        this.b.quadTo(-6.0f, 0.0f, -10.0f, 6.0f);
    }
    
    public Rectangle getBounds() {
        return null;
    }
    
    public void a(final Graphics2D graphics2D) {
        final Stroke stroke = graphics2D.getStroke();
        graphics2D.setStroke(dr.a);
        graphics2D.draw(this.a);
        graphics2D.draw(this.b);
        graphics2D.setStroke(stroke);
    }
}
