/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import y.c.A;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.h;
import y.c.x;
import y.d.n;
import y.d.q;
import y.d.t;
import y.f.C;
import y.f.E;
import y.f.I;
import y.f.S;
import y.f.U;
import y.f.X;
import y.f.aG;
import y.f.ad;
import y.f.ae;
import y.f.ah;
import y.f.aj;
import y.f.al;
import y.f.am;

public class V
implements ad {
    private ah a;
    private h b;
    private A c;
    private boolean d = false;
    private boolean e = true;
    private boolean f = false;
    private boolean g = true;
    private boolean h = false;
    private boolean i = true;
    private boolean n = true;

    @Override
    public void a(ah ah2) {
        this.a = ah2;
    }

    @Override
    public ah a() {
        return this.a;
    }

    @Override
    public void c(X x2) {
        if (this.a == null) return;
        if (this.e() || this.d()) {
            this.a(x2);
        }
        this.a.c(x2);
        this.d(x2);
        this.b(x2);
    }

    public boolean b() {
        return this.n;
    }

    private void a(X x2) {
        boolean bl2;
        S[] arrs;
        Object object;
        Object object2;
        Object object3;
        Object object4;
        am am2;
        aj[] arraj;
        X x3;
        Object object5;
        block9 : {
            bl2 = X.j;
            c c2 = x2.c(U.a);
            if (c2 == null && this.e()) {
                this.b = x2.u();
                x2.a(U.a, this.b);
                object = x2.p();
                block0 : do {
                    boolean bl3 = object.f();
                    block1 : while (bl3) {
                        object4 = object.a();
                        object5 = x2.a(object4.c());
                        am2 = x2.a(object4.d());
                        arraj = x2.b(object4);
                        x3 = x2;
                        object2 = object4;
                        if (bl2) break block9;
                        arrs = x3.d(object2);
                        S[] arrs2 = new S[arrs.length];
                        for (int i2 = 0; i2 < arrs.length; ++i2) {
                            object3 = arrs[i2].getLabelModel().a(arrs[i2].getOrientedBox().d(), (I)arraj, (am)object5, am2, arrs[i2].getModelParameter());
                            bl3 = this.i;
                            if (bl2) continue block1;
                            if (bl3) {
                                t t2 = object3.k();
                                object3.c(0.0, -1.0);
                                object3.b(t2);
                            }
                            arrs2[i2] = new S(object3.f(- object5.getX() + object5.getWidth() * 0.5, - object5.getY() + object5.getHeight() * 0.5), arrs[i2].getPreferredPlacementDescriptor());
                            if (!bl2) continue;
                        }
                        this.b.a(object4, arrs2);
                        object.g();
                        if (!bl2) continue block0;
                    }
                    break block0;
                    break;
                } while (true);
            }
            x3 = x2;
            object2 = U.b;
        }
        if ((object = x3.c(object2)) != null) return;
        if (!this.d()) return;
        this.c = x2.t();
        x2.a(U.b, this.c);
        object4 = x2.o();
        do {
            boolean bl4 = object4.f();
            block4 : do {
                if (!bl4) return;
                object5 = object4.e();
                am2 = x2.a(object5);
                arraj = x2.a_(object5);
                arrs = new S[arraj.length];
                for (int i3 = 0; i3 < arraj.length; ++i3) {
                    n n2 = arraj[i3].a().a(arraj[i3].getOrientedBox().d(), am2, arraj[i3].getModelParameter());
                    bl4 = this.h;
                    if (bl2) continue block4;
                    if (bl4) {
                        object3 = n2.k();
                        n2.c(0.0, -1.0);
                        n2.b((t)object3);
                    }
                    arrs[i3] = new S(n2.f(- am2.getX() + am2.getWidth() * 0.5, - am2.getY() + am2.getHeight() * 0.5));
                    if (!bl2) continue;
                }
                break;
            } while (true);
            this.c.a(object5, arrs);
            object4.g();
        } while (!bl2);
    }

    private void b(X x2) {
        if (this.b != null) {
            x2.d_(U.a);
            x2.a(this.b);
            this.b = null;
        }
        if (this.c == null) return;
        x2.d_(U.b);
        x2.a(this.c);
        this.c = null;
    }

    /*
     * Unable to fully structure code
     */
    private void d(X var1_1) {
        var10_2 = X.j;
        var2_3 = var1_1.c(U.a);
        var3_4 = var1_1.c(U.b);
        if (var2_3 == null && var3_4 == null) {
            return;
        }
        if (!this.g && !this.f) {
            return;
        }
        var4_5 = var1_1.o();
        block0 : do {
            if (var4_5.f() == false) return;
            var5_6 = var4_5.e();
            if (var3_4 == null || !this.f) ** GOTO lbl22
            v0 = (S[])var3_4.b(var5_6);
            block1 : do {
                var6_7 = v0;
                var7_8 = var1_1.a_(var5_6);
                if (var6_7 != null && var7_8 != null && var6_7.length == var7_8.length) {
                    for (var8_9 = 0; var8_9 < var7_8.length; ++var8_9) {
                        this.a(var1_1, var5_6, var7_8[var8_9], (S)var6_7[var8_9]);
                        if (var10_2) continue block0;
                        if (!var10_2) continue;
                    }
                }
lbl22: // 5 sources:
                if (var2_3 == null || !this.g) break;
                var6_7 = var5_6.f();
                while (var6_7 != null) {
                    var7_8 = (S[])var2_3.b(var6_7);
                    var8_10 = var1_1.d(var6_7);
                    v0 = var7_8;
                    if (var10_2) continue block1;
                    if (v0 != null && var8_10 != null && var7_8.length == var8_10.length) {
                        for (var9_11 = 0; var9_11 < var8_10.length; ++var9_11) {
                            this.a(var1_1, (d)var6_7, var8_10[var9_11], (S)var7_8[var9_11]);
                            if (!var10_2) {
                                if (!var10_2) continue;
                            }
                            break;
                        }
                    } else {
                        var6_7 = var6_7.g();
                    }
                    if (!var10_2) continue;
                }
                break block1;
                break;
            } while (true);
            var4_5.g();
        } while (!var10_2);
    }

    private void a(X x2, d d2, C c2, S s2) {
        E e2 = c2.getLabelModel();
        n n2 = s2.a();
        if (this.b()) {
            ae.b(n2);
        }
        c2.setModelParameter(e2.a(n2, x2.b(d2), x2.a(d2.c()), x2.a(d2.d())));
    }

    private void a(X x2, y.c.q q2, aj aj2, S s2) {
        al al2 = aj2.a();
        aj2.setModelParameter(al2.a(s2.a(), x2.a(q2)));
    }

    public boolean c() {
        return this.g;
    }

    public void a(boolean bl2) {
        this.g = bl2;
    }

    public void b(boolean bl2) {
        this.f = bl2;
    }

    public boolean d() {
        return this.d;
    }

    public void c(boolean bl2) {
        this.d = bl2;
    }

    public boolean e() {
        return this.e;
    }

    public void d(boolean bl2) {
        this.e = bl2;
    }
}

