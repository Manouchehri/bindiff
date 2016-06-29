package y.f.i.a;

import y.f.*;
import y.d.*;
import java.awt.geom.*;
import java.awt.*;
import java.util.*;

class ag extends I
{
    private ag(final O o) {
        super(o);
    }
    
    y a(final X x, final List list) {
        final int a = ab.a;
        final Rectangle a2 = x.a();
        final Iterator<N> iterator = list.iterator();
        y a3 = null;
        while (iterator.hasNext()) {
            a3 = iterator.next().a();
            if (a != 0) {
                return a3;
            }
            final y y = a3;
            Rectangle2D.union(a2, new Rectangle2D.Double(y.c(), y.d(), y.a(), y.b()), a2);
            if (a != 0) {
                break;
            }
        }
        final y y2 = new y(a2.getX() - 100.0, a2.getY() - 100.0, a2.getWidth() + 200.0, a2.getHeight() + 200.0);
        return a3;
    }
    
    ag(final O o, final af af) {
        this(o);
    }
}
