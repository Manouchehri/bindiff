/*
 * Decompiled with CFR 0_115.
 */
package y.f.h.a;

import java.util.Iterator;
import y.c.e;
import y.c.i;
import y.f.h.D;
import y.f.h.a.b;
import y.f.h.a.d;
import y.f.h.a.j;
import y.f.h.p;
import y.f.h.q;

public class c
extends j {
    y.c.q[] a;

    public c() {
        this.a = null;
    }

    public c(D d2) {
        y.c.D[] arrd;
        int n2;
        int n3;
        int[] arrn;
        boolean bl2;
        block10 : {
            bl2 = b.g;
            super(d2.g());
            this.a = null;
            arrn = new int[this.b.f()];
            arrd = d2.h();
            while (arrd.f()) {
                block11 : {
                    p p2 = arrd.a();
                    n3 = p2.a().k();
                    if (bl2) break block10;
                    e e2 = p2.a();
                    while (e2.f()) {
                        y.c.d d3 = e2.a();
                        arrn[d3.c().d()] = Math.max(arrn[d3.c().d()], n3);
                        e2.g();
                        if (!bl2) {
                            if (!bl2) continue;
                        }
                        break block11;
                    }
                    arrd.g();
                }
                if (!bl2) continue;
            }
            this.a = this.b.m();
        }
        arrd = new y.c.D[this.b.h() * 2];
        for (n2 = 0; n2 < arrn.length; ++n2) {
            if (arrd[arrn[n2]] == null) {
                arrd[arrn[n2]] = new y.c.D();
            }
            arrd[arrn[n2]].add(this.a[n2]);
            if (!bl2) continue;
        }
        n2 = this.a.length - 1;
        n3 = 0;
        while (n3 < arrd.length) {
            if (arrd[n3] != null) {
                for (y.c.q this.a[n2] : arrd[n3]) {
                    --n2;
                    if (!bl2) {
                        if (!bl2) continue;
                    }
                    break;
                }
            } else {
                ++n3;
            }
            if (!bl2) continue;
        }
        if (!i.g) return;
        b.g = !bl2;
    }

    @Override
    protected void a() {
    }

    @Override
    Iterator b() {
        if (this.a != null) return new d(this);
        return super.b();
    }
}

