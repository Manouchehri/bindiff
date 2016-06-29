package y.h;

import java.awt.geom.*;
import java.awt.*;

class io implements is
{
    private final Graphics2D a;
    private final ir b;
    
    io(final ir b, final Graphics2D a) {
        this.b = b;
        this.a = a;
    }
    
    public void a(final Line2D line2D) {
        this.a.draw(line2D);
    }
}
