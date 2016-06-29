/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.util.Map;
import y.b.b;
import y.b.c;
import y.b.d;
import y.b.e;
import y.f.O;
import y.f.ah;
import y.f.l;
import y.h.b.v;
import y.h.bI;
import y.h.bN;
import y.h.bQ;
import y.h.bS;
import y.h.bu;
import y.h.ch;
import y.h.dj;
import y.h.fj;

class bJ
extends bS {
    private volatile e i;
    private volatile d j;
    private final bQ k;
    private final Runnable l;
    private final bI m;

    bJ(bI bI2, ch ch2, bu bu2, ah ah2, boolean bl2, bQ bQ2, Runnable runnable) {
        super(bI2, ch2, bu2, ah2, bl2);
        this.m = bI2;
        this.k = bQ2;
        this.l = runnable;
    }

    @Override
    protected void a(l l2) {
        Class class_ = bI.b == null ? (bI.b = bI.a("y.h.b.v")) : bI.b;
        v v2 = (v)this.h.get(class_);
        if (v2 != null) {
            v2.f(this.e);
        }
        this.i = this.m.k();
        this.i.b(true);
        this.j = this.m.a(this.d, this.e, l2.C());
        if (this.j != null) {
            if (this.m.e().isEasedExecution()) {
                this.j = b.a(this.j);
            }
            this.i.a(this.d);
            this.i.a(new bN(this));
            if (!fj.z) return;
        }
        this.m.a(this.e, l2.C());
    }

    @Override
    protected void b(l l2) {
        if (this.i == null) return;
        if (this.j == null) return;
        this.i.a(this.j);
    }

    @Override
    protected void a() {
        super.a();
        if (this.b != null && this.k != null) {
            this.k.a(this.b);
        }
        if (this.l == null) return;
        this.l.run();
    }
}

