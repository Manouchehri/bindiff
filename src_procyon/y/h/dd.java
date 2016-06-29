package y.h;

import y.c.*;
import java.util.*;
import java.awt.*;
import java.awt.geom.*;
import y.d.*;

class dd implements az
{
    private final de a;
    private final boolean b;
    private final q c;
    private final dc d;
    
    dd(final dc d, final de a, final boolean b, final q c) {
        this.d = d;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public void a(final Graphics2D graphics2D) {
        final boolean z = fj.z;
        final bu graph2D = this.d.c().getGraph2D();
        graphics2D.setColor(this.d.a());
        final Iterator<q> iterator = this.a.b.iterator();
        while (iterator.hasNext()) {
            dc.a(this.d, graphics2D, graph2D, iterator.next(), this.b);
            if (z) {
                return;
            }
            if (z) {
                break;
            }
        }
        dc.a(this.d, graphics2D, graph2D, this.c, this.b);
    }
    
    public Rectangle getBounds() {
        final boolean z = fj.z;
        final bu graph2D = this.d.c().getGraph2D();
        final Rectangle2D.Double double1 = new Rectangle2D.Double(0.0, 0.0, -1.0, -1.0);
        final Iterator<q> iterator = this.a.b.iterator();
        while (iterator.hasNext()) {
            e.a(double1, dc.a(this.d, graph2D, iterator.next(), this.b), double1);
            if (z) {
                return double1.getBounds();
            }
            if (z) {
                break;
            }
        }
        e.a(double1, dc.a(this.d, graph2D, this.c, this.b), double1);
        return double1.getBounds();
    }
}
