package y.f.e;

import y.f.b.*;
import y.c.*;
import java.awt.geom.*;
import y.f.*;

class e extends h
{
    private final d a;
    
    e(final d a) {
        this.a = a;
    }
    
    public Rectangle2D a(final X x, final q q, final y y) {
        if (!y.isEmpty()) {
            return super.a(x, q, y);
        }
        final am h = x.h(q);
        return new Rectangle2D.Double(h.getX(), h.getY(), h.getWidth(), h.getHeight());
    }
}
