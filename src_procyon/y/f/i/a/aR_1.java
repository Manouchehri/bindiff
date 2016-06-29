package y.f.i.a;

import java.util.*;
import y.d.*;
import y.c.*;

class aR
{
    private final aS[] a;
    private final aN b;
    
    aR(final aN b, final w w) {
        final int a = ab.a;
        this.b = b;
        final m[] f = w.f();
        final ArrayList list = new ArrayList<aS>();
        int i = 0;
        while (true) {
            while (i < f.length - 1) {
                final m m = f[i];
                final m j = f[i + 1];
                final int b2 = m.b() ? 1 : 0;
                final int b3 = j.b() ? 1 : 0;
                if (a != 0) {
                    while (true) {
                        if (b2 < b3) {
                            this.a[i] = list.get(i);
                            ++i;
                            if (a == 0) {
                                final int length = this.a.length;
                                continue;
                            }
                        }
                        break;
                    }
                    return;
                }
                if (b2 != b3) {
                    list.add(new aS(b, m, j, w, w.a(i + 1).k(), i));
                }
                ++i;
                if (a != 0) {
                    break;
                }
            }
            this.a = new aS[list.size()];
            i = 0;
            continue;
        }
    }
    
    public aS[] a() {
        return this.a;
    }
    
    public D b() {
        final int a = ab.a;
        final D d = new D();
        if (this.a == null || this.a.length < 1) {
            return d;
        }
        int i = 0;
        D d2 = null;
        while (i < this.a.length) {
            d2 = d;
            if (a != 0) {
                return d2;
            }
            d2.a(this.a[i].g());
            ++i;
            if (a != 0) {
                break;
            }
        }
        return d2;
    }
}
