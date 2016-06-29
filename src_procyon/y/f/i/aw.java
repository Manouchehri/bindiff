package y.f.i;

import y.d.*;
import java.awt.geom.*;
import y.c.*;

class aw implements g
{
    private final Rectangle2D.Double a;
    private final Rectangle2D.Double b;
    private final Rectangle2D.Double c;
    private final av d;
    
    aw(final av d, final Rectangle2D.Double a, final Rectangle2D.Double b, final Rectangle2D.Double c) {
        this.d = d;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public void a(final Object o, final Object o2) {
        final aA aa = (aA)o;
        final aA aa2 = (aA)o2;
        if (aa.e.x() != aa2.e.x()) {
            this.a.setFrame(aa.c, aa.d, aa.a, aa.b);
            this.b.setFrame(aa2.c, aa2.d, aa2.a, aa2.b);
            Rectangle2D.intersect(this.a, this.b, this.c);
            if (this.c.width > 0.01 && this.c.height > 0.01) {
                ((D)av.a(this.d).b(aa.e)).add(aa2.e);
                ((D)av.a(this.d).b(aa2.e)).add(aa.e);
                av.b(this.d);
            }
        }
    }
}
