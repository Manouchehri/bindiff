/*
 * Decompiled with CFR 0_115.
 */
package y.f.d;

import java.util.Map;
import y.c.A;
import y.c.C;
import y.c.D;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.q;
import y.c.x;
import y.c.y;
import y.f.Q;
import y.f.d.a;
import y.f.d.i;
import y.f.d.r;

class k {
    private y a;
    private f b;
    private D c;
    private final i d;

    public k(i i2) {
        this.d = i2;
        this.a = new y();
        this.b = new f();
        this.c = new D();
    }

    public void a(q q2) {
        this.a.add(q2);
    }

    public void a(d d2) {
        this.b.add(d2);
    }

    public void a(r r2) {
        this.c.add(r2);
    }

    public String toString() {
        StringBuffer stringBuffer;
        int n2 = a.f;
        r[] arrr = this.a();
        StringBuffer stringBuffer2 = new StringBuffer();
        for (int i2 = 0; i2 < arrr.length; ++i2) {
            stringBuffer = stringBuffer2.append(new StringBuffer().append(arrr[i2].toString()).append("\n").toString());
            if (n2 != 0) return stringBuffer.toString();
            if (n2 == 0) continue;
        }
        stringBuffer = stringBuffer2;
        return stringBuffer.toString();
    }

    public r[] a() {
        r[] arrr;
        int n2 = a.f;
        r[] arrr2 = new r[this.c.size()];
        int n3 = 0;
        C c2 = this.c.m();
        while (c2.f()) {
            arrr = arrr2;
            if (n2 != 0) return arrr;
            arrr[n3++] = (r)c2.d();
            c2.g();
            if (n2 == 0) continue;
        }
        arrr = arrr2;
        return arrr;
    }

    public void b() {
        int n2 = a.f;
        int n3 = 0;
        C c2 = this.c.m();
        block0 : do {
            if (!c2.f()) return;
            r r2 = (r)c2.d();
            C c3 = r2.b().m();
            while (c3.f()) {
                Q q2 = (Q)c3.d();
                q q3 = (q)this.d.o.get(q2);
                this.d.p.a((Object)q3, n3);
                c3.g();
                if (n2 != 0) continue block0;
                if (n2 == 0) continue;
            }
            ++n3;
            c2.g();
        } while (n2 == 0);
    }

    public void c() {
        int n2;
        C c2;
        block6 : {
            k k2;
            block5 : {
                n2 = a.f;
                c2 = this.d.i.o();
                while (c2.f()) {
                    this.d.i.c(c2.e());
                    c2.g();
                    if (n2 == 0) {
                        if (n2 == 0) continue;
                    }
                    break block5;
                }
                c2 = this.a.a();
            }
            while (c2.f()) {
                k2 = this;
                if (n2 == 0) {
                    k2.d.i.d(c2.e());
                    c2.g();
                    if (n2 == 0) continue;
                }
                break block6;
            }
            k2 = this;
        }
        c2 = k2.b.a();
        do {
            if (!c2.f()) return;
            this.d.i.e(c2.a());
            c2.g();
        } while (n2 == 0);
    }
}

