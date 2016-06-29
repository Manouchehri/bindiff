/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.util.Iterator;
import y.h.V;
import y.h.W;
import y.h.X;
import y.h.Y;
import y.h.a.v;
import y.h.ag;
import y.h.an;
import y.h.as;
import y.h.bu;
import y.h.cg;
import y.h.hN;

public class U
implements cg {
    private static final Iterator a = new V();
    private boolean b = false;
    private boolean c = true;
    private boolean d = false;

    public void a(boolean bl2) {
        this.b = bl2;
    }

    public void b(boolean bl2) {
        this.c = bl2;
    }

    public void c(boolean bl2) {
        this.d = bl2;
    }

    @Override
    public Iterator a(bu bu2, int n2) {
        return this.a(bu2, n2, true);
    }

    @Override
    public Iterator b(bu bu2, int n2) {
        return this.a(bu2, n2, false);
    }

    private Iterator a(bu bu2, int n2, boolean bl2) {
        v v2 = v.a(bu2);
        if ((n2 & 81) != 0 && (n2 & 46) != 0) {
            if (v2 != null && this.d) {
                if (this.b) {
                    if (!bl2) return new Y(bu2, v2, n2);
                    return new ag(bu2, v2, n2);
                }
                if (!bl2) return new an(bu2, v2, n2);
                return new as(bu2, v2, n2);
            }
            if (v2 == null) return new hN(new W(bu2, n2, bl2), new X(bu2, n2, bl2), this.b ^ bl2);
            if (!this.c) return new hN(new W(bu2, n2, bl2), new X(bu2, n2, bl2), this.b ^ bl2);
            return new hN(new W(bu2, v2, n2, bl2), new X(bu2, n2, bl2), this.b ^ bl2);
        }
        if ((n2 & 81) != 0) {
            if (v2 == null) return new W(bu2, n2, bl2);
            if (!this.c) return new W(bu2, n2, bl2);
            return new W(bu2, v2, n2, bl2);
        }
        if ((n2 & 46) == 0) return a;
        return new X(bu2, n2, bl2);
    }
}

