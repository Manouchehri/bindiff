/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import java.util.Collection;
import java.util.Iterator;
import y.c.d;
import y.c.e;
import y.c.h;
import y.d.t;
import y.f.X;
import y.f.a;
import y.f.aE;
import y.f.aF;
import y.f.ah;
import y.f.ax;
import y.f.c;

class ay
extends a {
    private byte a = 0;

    ay() {
    }

    @Override
    public void c(X x2) {
        h h2;
        block10 : {
            boolean bl2;
            h h3;
            y.c.c c2;
            block9 : {
                y.c.c c3;
                block8 : {
                    bl2 = y.f.c.a.i;
                    if (this.a() instanceof c) {
                        this.a = ((c)this.a()).h();
                    }
                    y.c.c c4 = x2.c(ax.a);
                    y.c.c c5 = x2.c(ax.b);
                    if (c4 == null && c5 == null) {
                        this.a().c(x2);
                        if (!bl2) return;
                    }
                    c3 = x2.c(aF.a);
                    c2 = x2.c(aF.b);
                    h3 = x2.u();
                    x2.a(aF.a, h3);
                    h2 = x2.u();
                    x2.a(aF.b, h2);
                    e e2 = x2.p();
                    while (e2.f()) {
                        d d2 = e2.a();
                        h3.a((Object)d2, this.a(d2, true, c3, h2, c4, c5, x2));
                        h2.a((Object)d2, this.a(d2, false, c3, h2, c4, c5, x2));
                        e2.g();
                        if (!bl2) {
                            if (!bl2) continue;
                        }
                        break block8;
                    }
                    this.a().c(x2);
                }
                if (c3 != null) {
                    x2.a(aF.a, c3);
                    if (!bl2) break block9;
                }
                x2.d_(aF.a);
            }
            x2.a(h3);
            if (c2 != null) {
                x2.a(aF.b, c2);
                if (!bl2) break block10;
            }
            x2.d_(aF.b);
        }
        x2.a(h2);
    }

    private aE a(d d2, boolean bl2, y.c.c c2, y.c.c c3, y.c.c c4, y.c.c c5, X x2) {
        Collection collection;
        double d3;
        double d4;
        ax ax2;
        aE aE2 = null;
        if (bl2 && c2 != null) {
            aE2 = (aE)c2.b(d2);
        } else if (!bl2 && c3 != null) {
            aE2 = (aE)c3.b(d2);
        }
        if (aE2 != null) return aE2;
        if (bl2 && c4 != null) {
            collection = (Collection)c4.b(d2);
            if (collection == null) return aE2;
            if (collection.size() != 1) return aE2;
            ax2 = (ax)collection.iterator().next();
            if (ax2.b()) {
                d3 = ax2.c(this.a);
                d4 = ax2.d(this.a);
                x2.a(d2, new t(d3, d4));
            }
            aE2 = ax2.a(this.a);
            if (!y.f.c.a.i) return aE2;
        }
        if (bl2) return aE2;
        if (c5 == null) return aE2;
        collection = (Collection)c5.b(d2);
        if (collection == null) return aE2;
        if (collection.size() != 1) return aE2;
        ax2 = (ax)collection.iterator().next();
        if (!ax2.b()) return ax2.a(this.a);
        d3 = ax2.c(this.a);
        d4 = ax2.d(this.a);
        x2.b(d2, new t(d3, d4));
        return ax2.a(this.a);
    }
}

