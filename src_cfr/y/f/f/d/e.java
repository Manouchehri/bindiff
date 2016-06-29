/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.d;

import y.c.i;
import y.c.q;
import y.c.x;
import y.f.X;
import y.f.f.b.h;
import y.f.f.d.M;
import y.f.f.d.o;

class E
implements M {
    private h a;
    private int b = 0;
    private int c;
    private int d;

    public E(int n2) {
        this.c = n2;
    }

    @Override
    public boolean a() {
        return false;
    }

    @Override
    public void a(h h2) {
        boolean bl2 = o.p;
        y.g.o.a(this, (Object)"Kandinsky Node Model !");
        this.a = h2;
        this.d = 1;
        X x2 = (X)h2.a();
        x x3 = h2.a().o();
        while (x3.f()) {
            q q2 = x3.e();
            if (bl2) return;
            if (h2.d(q2)) {
                x2.b(x3.e(), (double)this.c * 1.5, (double)this.c * 1.5);
                int[][] arrn = h2.i(q2);
                this.d = Math.max(this.d, arrn[0][0]);
                this.d = Math.max(this.d, arrn[1][0]);
                this.d = Math.max(this.d, arrn[2][0]);
                this.d = Math.max(this.d, arrn[3][0]);
                this.d = Math.max(this.d, arrn[0][2]);
                this.d = Math.max(this.d, arrn[1][2]);
                this.d = Math.max(this.d, arrn[2][2]);
                this.d = Math.max(this.d, arrn[3][2]);
            }
            x3.g();
            if (!bl2) continue;
        }
        this.b = 2;
    }

    @Override
    public boolean a(q q2) {
        return this.a.d(q2);
    }

    @Override
    public int b(q q2) {
        return this.b;
    }

    @Override
    public int c(q q2) {
        return this.b;
    }

    @Override
    public boolean d(q q2) {
        return this.a(q2);
    }

    @Override
    public double b() {
        return 2 * this.d;
    }

    @Override
    public boolean c() {
        return true;
    }

    @Override
    public int e(q q2) {
        return this.d;
    }

    @Override
    public int f(q q2) {
        return this.d;
    }

    @Override
    public void d() {
    }
}

