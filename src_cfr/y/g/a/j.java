/*
 * Decompiled with CFR 0_115.
 */
package y.g.a;

import java.util.Comparator;
import y.c.A;
import y.c.i;
import y.c.q;
import y.g.a.g;
import y.g.a.k;
import y.g.a.m;

public class j
implements g {
    private A a = null;
    private boolean b = false;
    private i c;
    private m d = null;

    public j(i i2) {
        this.c = i2;
        this.a = this.c.t();
        this.a(this.a);
        this.b = true;
    }

    private void a(A a2) {
        this.a = a2;
        this.d = new m(new k(this, a2));
    }

    @Override
    public boolean a() {
        return this.d.b();
    }

    @Override
    public boolean a(q q2) {
        return this.d.c(q2);
    }

    @Override
    public void a(q q2, int n2) {
        this.a.a((Object)q2, n2);
        this.d.a(q2);
    }

    public void c(q q2) {
        this.d.b(q2);
    }

    public q b() {
        return (q)this.d.c();
    }

    @Override
    public q c() {
        q q2 = this.b();
        this.c(q2);
        return q2;
    }

    @Override
    public void b(q q2, int n2) {
        this.d.b(q2);
        this.a.a((Object)q2, n2);
        this.d.a(q2);
    }

    @Override
    public void d() {
        this.d.a();
    }

    @Override
    public int b(q q2) {
        return this.a.a(q2);
    }
}

