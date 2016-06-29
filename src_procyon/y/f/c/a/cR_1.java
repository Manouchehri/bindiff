package y.f.c.a;

import java.util.*;
import y.c.*;
import y.f.*;
import y.d.*;
import y.g.*;

final class cR implements Comparator
{
    private final aV a;
    private final X b;
    private final aU c;
    
    public cR(final X b, final aU c, final aV a) {
        this.b = b;
        this.a = a;
        this.c = c;
    }
    
    final float a(final d d) {
        final boolean x = N.x;
        final aE c = this.a.a(d).c();
        final t n = this.b.n(d);
        if (c == null || c.g()) {
            final float n2 = (float)(n.a / 10000.0);
            if (!x) {
                return this.a.a(d.c()).k() + n2;
            }
        }
        Label_0127: {
            switch (c.b()) {
                case 4: {
                    final float n2 = 0.3f - (float)(n.b / 10000.0);
                    if (x) {
                        break Label_0127;
                    }
                    return this.a.a(d.c()).k() + n2;
                }
                case 8: {
                    final float n2 = -0.3f + (float)(n.b / 10000.0);
                    if (x) {
                        break;
                    }
                    return this.a.a(d.c()).k() + n2;
                }
            }
        }
        final float n2 = (float)(n.a / 10000.0);
        return this.a.a(d.c()).k() + n2;
    }
    
    public int compare(final Object o, final Object o2) {
        final d d = (d)o;
        final d d2 = (d)o2;
        final byte b = this.a.a(d.d()).b();
        if (b == 12 || b == 13) {
            final boolean b2 = b == 12;
            final aX a = this.a.a(d.c());
            final aX a2 = this.a.a(d2.c());
            if (b == a.b() && b != a2.b()) {
                return b2 ? -1 : 1;
            }
            if (b != a.b() && b == a2.b()) {
                return b2 ? 1 : -1;
            }
        }
        return e.a(this.a(d), this.a(d2));
    }
}
