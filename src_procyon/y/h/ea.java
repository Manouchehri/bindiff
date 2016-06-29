package y.h;

import y.d.*;
import java.awt.geom.*;

class ea extends gC
{
    private final gy a;
    private final en c;
    
    ea(final en c, final double n, final az az, final boolean b, final double n2, final Object o, final gy a) {
        super(n, az, b, n2, o);
        this.c = c;
        this.a = a;
    }
    
    public az a(final e e, final t t) {
        final double n = t.a - e.k().a;
        final double n2 = t.b - e.k().b;
        final double min = Math.min(en.a(this.c).a(n), en.b(this.c).a(n));
        return ((id)this.a).a(new Rectangle2D.Double(min, en.a(this.c).b(n2), Math.max(en.a(this.c).a(n), en.b(this.c).a(n)) - min, 0.0));
    }
}
