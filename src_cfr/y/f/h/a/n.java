/*
 * Decompiled with CFR 0_115.
 */
package y.f.h.a;

import java.io.PrintStream;
import java.util.Iterator;
import y.c.D;
import y.c.d;
import y.c.q;
import y.f.h.a.b;
import y.f.h.a.f;
import y.f.h.a.h;
import y.f.h.a.i;
import y.f.h.a.m;
import y.f.h.a.o;
import y.f.h.a.p;
import y.f.h.a.r;

class n
extends r {
    private q b = null;
    private int c = -1;
    private int d = Integer.MAX_VALUE;
    private int e = Integer.MAX_VALUE;
    private p f = new p();
    private D g;
    private m h;
    private D i = new D();
    private D j = new D();
    private D k = null;

    n(q q2, int n2, m m2) {
        this.b = q2;
        this.c = n2;
        this.e = n2;
        this.d = n2;
        this.h = m2;
    }

    public String toString() {
        if (this.a == null) return Integer.toString(this.f());
        return new StringBuffer().append(Integer.toString(this.f())).append(": ").append(this.a.toString()).toString();
    }

    @Override
    String a() {
        return Integer.toString(this.f());
    }

    @Override
    n b() {
        return this;
    }

    h a(i i2) {
        return this.f.a(i2);
    }

    p c() {
        return this.f;
    }

    D d() {
        return this.i;
    }

    /*
     * Unable to fully structure code
     */
    m a(i var1_1, int var2_2, int var3_3) {
        var12_4 = b.g;
        var4_5 = var1_1.f(var2_2);
        if (var4_5 == null) {
            System.out.println("Error!");
        }
        var5_6 = var4_5.a(var1_1);
        var6_7 = var5_6.a(var4_5, var2_2 ^ 1);
        var7_8 = this.f(var3_3);
        var8_9 = var7_8.a(this);
        var9_10 = var8_9.t();
        var10_11 = var8_9.a(var7_8, var3_3 ^ 1);
        var11_12 = b.b(var5_6, var8_9, var6_7, var10_11, var4_5.a() + var7_8.a());
        if (var9_10 == null) ** GOTO lbl19
        if (var10_11 != 0) ** GOTO lbl17
        var8_9.e(var9_10);
        if (var12_4) {
            v0 = y.c.i.g = y.c.i.g == false;
lbl17: // 2 sources:
            if (var10_11 == 1) {
                var8_9.d(var9_10);
            }
        }
lbl19: // 6 sources:
        var1_1.e();
        if (var2_2 == var3_3) {
            var1_1.d();
        }
        if (var3_3 == 0) {
            this.a.b(var1_1.r());
            if (var12_4 == false) return var11_12;
        }
        this.a.a(var1_1.r());
        return var11_12;
    }

    void b(i i2) {
        if (this.g == null) {
            this.g = new D();
        }
        this.g.add(i2);
    }

    void e() {
        boolean bl2 = b.g;
        if (this.g == null) return;
        Iterator iterator = this.g.iterator();
        do {
            if (!iterator.hasNext()) return;
            i i2 = (i)iterator.next();
            this.a.a(i2.r());
            i2.e();
        } while (!bl2);
    }

    D h() {
        return this.g;
    }

    @Override
    int f() {
        return this.c;
    }

    void a(int n2, m m2) {
        this.c = n2;
        this.d = n2;
        this.e = n2;
        this.h = m2;
    }

    q i() {
        return this.b;
    }

    m j() {
        return this.h;
    }

    int k() {
        if (this.h != null) return this.h.a(this).f();
        return -1;
    }

    void a(int n2) {
        this.d = Math.min(this.d, n2);
        this.e = Math.min(this.d, this.e);
    }

    void b(int n2) {
        this.e = Math.min(this.e, n2);
    }

    int l() {
        return this.e;
    }

    void a(m m2) {
        this.i.b(m2);
    }

    D m() {
        return this.j;
    }

    void b(m m2) {
        this.j.b(m2);
    }

    int n() {
        if (!this.j.isEmpty()) return ((m)this.j.i()).e().f();
        return -1;
    }

    m o() {
        if (!this.j.isEmpty()) return (m)this.j.j();
        return null;
    }

    m p() {
        if (!this.j.isEmpty()) return (m)this.j.i();
        return null;
    }

    boolean c(int n2) {
        if (this.d < n2) return true;
        if (this.f.b() == null) return false;
        if (!this.f.b().a(n2)) return false;
        return true;
    }

    boolean d(int n2) {
        if (this.f.c() == null) return false;
        if (!this.f.c().b(n2)) return false;
        return true;
    }

    boolean e(int n2) {
        if (this.d(n2)) return true;
        if (this.n() == n2) return true;
        return false;
    }

    void a(d d2) {
        if (this.k == null) {
            this.k = new D();
        }
        this.k.add(d2);
    }

    D q() {
        return this.k;
    }

    void a(D d2) {
        this.k = d2;
    }
}

