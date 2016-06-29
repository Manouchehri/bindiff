/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.d;

import java.awt.Dimension;
import y.c.A;
import y.c.i;
import y.c.q;
import y.c.x;
import y.f.X;
import y.f.f.b.h;
import y.f.f.d.M;
import y.f.f.d.o;

class J
implements M {
    private h a;
    private A b;
    private int c;

    public J(int n2) {
        this.c = n2;
    }

    @Override
    public void a(h h2) {
        boolean bl2 = o.p;
        y.g.o.a(this, (Object)"Big Node Model !");
        this.a = h2;
        X x2 = (X)h2.a();
        this.b = h2.a().t();
        x x3 = h2.a().o();
        do {
            if (!x3.f()) return;
            q q2 = x3.e();
            if (h2.d(q2)) {
                Dimension dimension = null;
                int[] arrn = h2.h(q2);
                if (arrn[0] > 1 || arrn[1] > 1 || arrn[2] > 1 || arrn[3] > 1) {
                    int n2;
                    int n3 = arrn[1] > arrn[3] ? arrn[1] : arrn[3];
                    int n4 = n2 = arrn[0] > arrn[2] ? arrn[0] : arrn[2];
                    if (n3 > 0) {
                        --n3;
                    }
                    if (n2 > 0) {
                        --n2;
                    }
                    dimension = new Dimension(n2, n3);
                } else {
                    dimension = new Dimension(0, 0);
                }
                this.b.a((Object)q2, dimension);
                x2.b(q2, dimension.width * this.c + this.c / 2, dimension.height * this.c + this.c / 2);
            }
            x3.g();
        } while (!bl2);
    }

    @Override
    public boolean a() {
        return false;
    }

    @Override
    public boolean a(q q2) {
        return this.a.d(q2);
    }

    @Override
    public int b(q q2) {
        Dimension dimension = (Dimension)this.b.b(q2);
        return dimension.width;
    }

    @Override
    public int c(q q2) {
        Dimension dimension = (Dimension)this.b.b(q2);
        return dimension.height;
    }

    @Override
    public boolean d(q q2) {
        return this.a(q2);
    }

    @Override
    public double b() {
        return 1.0;
    }

    @Override
    public boolean c() {
        return false;
    }

    @Override
    public int e(q q2) {
        return 0;
    }

    @Override
    public int f(q q2) {
        return 0;
    }

    @Override
    public void d() {
        this.a.a().a(this.b);
    }
}

