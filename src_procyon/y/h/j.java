package y.h;

import java.awt.geom.*;
import java.awt.*;

class j implements az
{
    GeneralPath a;
    GeneralPath b;
    
    j() {
        this.a = new GeneralPath(1, 3);
        this.b = new GeneralPath(1, 3);
        this.a.moveTo(-11.0f, -5.0f);
        this.a.quadTo(-4.0f, -5.0f, -1.0f, 0.25f);
        this.b.moveTo(-11.0f, 5.0f);
        this.b.quadTo(-4.0f, 5.0f, -1.0f, -0.25f);
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
