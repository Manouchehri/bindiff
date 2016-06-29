/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.geom.Rectangle2D;
import y.d.t;
import y.h.az;
import y.h.e;
import y.h.en;
import y.h.gC;
import y.h.gy;
import y.h.id;

class dZ
extends gC {
    private final gy a;
    private final en c;

    dZ(en en2, double d2, az az2, boolean bl2, double d3, Object object, gy gy2) {
        super(d2, az2, bl2, d3, object);
        this.c = en2;
        this.a = gy2;
    }

    @Override
    public az a(e e2, t t2) {
        double d2 = t2.a - e2.k().a;
        double d3 = t2.b - e2.k().b;
        double d4 = Math.min(en.a(this.c).b(d3), en.b(this.c).b(d3));
        double d5 = Math.max(en.a(this.c).b(d3), en.b(this.c).b(d3));
        double d6 = en.a(this.c).a(d2);
        return ((id)((Object)this.a)).a(new Rectangle2D.Double(d6, d4, 0.0, d5 - d4));
    }
}

