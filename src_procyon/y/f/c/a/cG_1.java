package y.f.c.a;

import java.util.*;
import y.c.*;
import y.f.*;
import y.d.*;
import y.g.*;

final class cG implements Comparator
{
    private final aV a;
    private final X b;
    private final aU c;
    
    public cG(final X b, final aU c, final aV a) {
        this.b = b;
        this.a = a;
        this.c = c;
    }
    
    final float a(final d d) {
        final boolean x = N.x;
        final aE e = this.a.a(d).e();
        final t o = this.b.o(d);
        if (e == null || e.g()) {
            final float n = (float)(o.a / 10000.0);
            if (!x) {
                return this.a.a(d.d()).k() + n;
            }
        }
        Label_0127: {
            switch (e.b()) {
                case 4: {
                    final float n = 0.3f + (float)(o.b / 10000.0);
                    if (x) {
                        break Label_0127;
                    }
                    return this.a.a(d.d()).k() + n;
                }
                case 8: {
                    final float n = -0.3f - (float)(o.b / 10000.0);
                    if (x) {
                        break;
                    }
                    return this.a.a(d.d()).k() + n;
                }
            }
        }
        final float n = (float)(o.a / 10000.0);
        return this.a.a(d.d()).k() + n;
    }
    
    public int compare(final Object o, final Object o2) {
        final d d = (d)o;
        final d d2 = (d)o2;
        final byte b = this.a.a(d.c()).b();
        if (b == 12 || b == 13) {
            final boolean b2 = b == 12;
            final aX a = this.a.a(d.d());
            final aX a2 = this.a.a(d2.d());
            if (b == a.b() && b != a2.b()) {
                return b2 ? 1 : -1;
            }
            if (b != a.b() && b == a2.b()) {
                return b2 ? -1 : 1;
            }
        }
        return e.a(this.a(d), this.a(d2));
    }
}
