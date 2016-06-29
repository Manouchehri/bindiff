package y.f.e;

import y.f.b.*;
import y.c.*;
import java.awt.geom.*;
import y.f.*;

final class z implements a
{
    private final a a;
    private c b;
    private Object c;
    
    public z(final a a, final c b) {
        this.b = null;
        this.c = null;
        this.b = b;
        this.a = a;
    }
    
    public Rectangle2D a(final X x, final q q, final y y) {
        if (this.c != null) {
            this.b = x.c(this.c);
        }
        if (this.b == null || !this.b.d(q)) {
            return this.a.a(x, q, y);
        }
        if (y.isEmpty()) {
            final am a = x.a((Object)q);
            if (a.getWidth() == 0.0 || a.getHeight() == 0.0) {
                final Rectangle2D a2 = this.a.a(x, q, y);
                a.setSize(a2.getWidth(), a2.getHeight());
            }
            return new Rectangle2D.Double(a.getX(), a.getY(), a.getWidth(), a.getHeight());
        }
        final Rectangle2D a3 = this.a.a(x, q, y);
        final am a4 = x.a((Object)q);
        final double min = Math.min(a3.getX(), a4.getX());
        final double min2 = Math.min(a3.getY(), a4.getY());
        a3.setFrame(min, min2, Math.max(a3.getMaxX(), a4.getX() + a4.getWidth()) - min, Math.max(a3.getMaxY(), a4.getY() + a4.getHeight()) - min2);
        return a3;
    }
}
