/*
 * Decompiled with CFR 0_115.
 */
package y.a;

import java.util.Arrays;
import y.a.B;
import y.a.C;
import y.a.b;
import y.a.h;
import y.c.D;
import y.c.I;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.i;
import y.c.p;
import y.c.q;
import y.c.x;
import y.c.y;
import y.g.M;

public class A {
    public static f[] a(i i2, y[] arry) {
        boolean bl2 = h.a;
        f[] arrf = new f[arry.length];
        int[] arrn = new int[i2.f()];
        int n2 = 1;
        int n3 = 0;
        block0 : do {
            f f2;
            int n4 = n3;
            int n5 = arry.length;
            block1 : do {
                x x2;
                block7 : {
                    if (n4 >= n5) return arrf;
                    y y2 = arry[n3];
                    f2 = new f();
                    x2 = y2.a();
                    while (x2.f()) {
                        arrn[x2.e().d()] = n2;
                        x2.g();
                        if (!bl2) {
                            if (!bl2) continue;
                        }
                        break block7;
                    }
                    x2 = y2.a();
                }
                while (x2.f()) {
                    q q2 = x2.e();
                    if (bl2) continue block0;
                    e e2 = q2.l();
                    while (e2.f()) {
                        d d2 = e2.a();
                        n4 = arrn[d2.a(q2).d()];
                        n5 = n2;
                        if (bl2) continue block1;
                        if (n4 == n5 && !d2.e()) {
                            f2.c(d2);
                        }
                        e2.g();
                        if (!bl2) continue;
                    }
                    x2.g();
                    if (!bl2) continue;
                }
                break block1;
                break;
            } while (true);
            arrf[n3] = f2;
            ++n3;
            ++n2;
        } while (!bl2);
        return arrf;
    }

    /*
     * Unable to fully structure code
     */
    public static y[] a(i var0) {
        var11_1 = h.a;
        var1_2 = new int[var0.f()];
        var2_3 = new D();
        var3_4 = new y();
        var5_5 = false;
        var6_6 = var0.o();
        while (var6_6.f()) {
            var4_7 = var6_6.e();
            var1_2[var4_7.d()] = var4_7.c();
            v0 = var4_7.c();
            if (!var11_1) {
                if (v0 == 0 && var4_7.b() == 1) {
                    var3_4.b(var4_7);
                }
                var6_6.g();
                if (!var11_1) continue;
            }
            ** GOTO lbl19
        }
        do lbl-1000: // 4 sources:
        {
            v0 = var3_4.isEmpty();
lbl19: // 2 sources:
            if (v0 != 0) break;
            var4_7 = var3_4.d();
            if (var4_7.b() <= 0) ** GOTO lbl-1000
            var6_6 = var4_7.g().c();
            v1 = var1_2;
            v2 = var6_6.d();
            v1[v2] = v1[v2] - 1;
            if (var6_6.b() > 1 || var1_2[var6_6.d()] != 0) ** GOTO lbl-1000
            var3_4.b(var6_6);
        } while (!var11_1);
        var6_6 = var0.o();
        do {
            block9 : {
                v3 = var6_6.f();
                block3 : do {
                    if (v3 == 0) return (y[])var2_3.toArray(new y[var2_3.size()]);
                    var4_7 = var6_6.e();
                    var8_9 = var1_2[var4_7.d()];
                    if (var8_9 == 0 && var4_7.b() != 1 && var4_7.c() > 0) {
                        var7_8 = new y();
                        var7_8.b(var4_7);
                        A.a(var4_7, var7_8);
                        var2_3.b(var7_8);
                        if (!var11_1) break block9;
                    }
                    if (var8_9 <= 0 || var8_9 >= var4_7.c()) break block9;
                    var7_8 = new y();
                    var7_8.b(var4_7);
                    var9_10 = var4_7.o();
                    while (var9_10.f()) {
                        var10_11 = var9_10.e();
                        v3 = var1_2[var10_11.d()];
                        if (var11_1) continue block3;
                        if (v3 == 0 && var10_11.b() == 1) {
                            var7_8.b(var10_11);
                            A.a(var10_11, var7_8);
                        }
                        var9_10.g();
                        if (!var11_1) continue;
                    }
                    break block3;
                    break;
                } while (true);
                var2_3.b(var7_8);
            }
            var6_6.g();
        } while (!var11_1);
        return (y[])var2_3.toArray(new y[var2_3.size()]);
    }

    public static boolean b(i i2) {
        if (i2.i()) {
            return true;
        }
        if (i2.e() != i2.g() + 1) {
            return false;
        }
        C c2 = new C();
        try {
            c2.a(i2);
            return true;
        }
        catch (y.c.B var2_2) {
            return false;
        }
    }

    public static y a(i i2, boolean bl2) {
        boolean bl3 = h.a;
        y y2 = new y();
        x x2 = i2.o();
        do {
            if (!x2.f()) return y2;
            q q2 = x2.e();
            if (bl2 && q2.c() == 0 || !bl2 && q2.a() == 1) {
                y2.add(q2);
            }
            x2.g();
        } while (!bl3);
        return y2;
    }

    public static q c(i i2) {
        if (i2.e() == 1) {
            return i2.k();
        }
        y[] arry = b.a(i2, A.a(i2, false));
        return arry[arry.length - 1].b();
    }

    public static q d(i i2) {
        q q2;
        int n2;
        block8 : {
            int n3;
            x x2;
            int n4;
            boolean bl2;
            block7 : {
                bl2 = h.a;
                x2 = i2.o();
                q2 = null;
                n3 = 0;
                x2.i();
                while (x2.f()) {
                    n4 = x2.e().b();
                    if (!bl2) {
                        if (n4 == 0) {
                            q2 = x2.e();
                            ++n3;
                        }
                        x2.g();
                        if (!bl2) continue;
                    }
                    break block7;
                }
                n4 = n3;
            }
            if (n4 == 1) {
                return q2;
            }
            n3 = 0;
            x2.i();
            while (x2.f()) {
                n2 = x2.e().c();
                if (!bl2) {
                    if (n2 == 0) {
                        q2 = x2.e();
                        ++n3;
                    }
                    x2.g();
                    if (!bl2) continue;
                }
                break block8;
            }
            n2 = n3;
        }
        if (n2 != 1) return A.f(i2);
        return q2;
    }

    public static f e(i i2) {
        return A.a(i2, A.d(i2));
    }

    public static q f(i i2) {
        int[] arrn = new int[i2.f()];
        y.c.A a2 = M.a(arrn);
        return A.a(i2, a2);
    }

    public static q a(i i2, y.c.A a2) {
        boolean bl2 = h.a;
        q q2 = i2.k();
        q[] arrq = new q[1];
        int[] arrn = new int[i2.f()];
        Arrays.fill(arrn, -1);
        f f2 = A.a(i2, q2);
        A.a(q2, a2, arrq, arrn, -1);
        e e2 = f2.a();
        do {
            if (!e2.f()) return arrq[0];
            i2.c(e2.a());
            e2.g();
        } while (!bl2);
        return arrq[0];
    }

    private static int a(q q2, y.c.A a2, q[] arrq, int[] arrn, int n2) {
        int n3;
        block6 : {
            boolean bl2;
            int n4;
            int n5;
            I i2;
            int n6;
            block5 : {
                bl2 = h.a;
                n4 = 0;
                for (d d2 = q2.f(); d2 != null; n4 += arrn[i2.d()], d2 = d2.g()) {
                    int n7;
                    i2 = d2.d();
                    n5 = n7 = A.a(i2, a2, arrq, arrn, n2);
                    n6 = n2;
                    if (!bl2) {
                        if (n5 <= n6) continue;
                        n2 = n7;
                        if (!bl2) continue;
                    }
                    break block5;
                }
                n5 = n4;
                n6 = q2.e().e() - 1 - n4;
            }
            n3 = n5 * n6;
            i2 = q2.f();
            while (i2 != null) {
                block7 : {
                    q q3;
                    q q4 = i2.d();
                    if (bl2) break block6;
                    for (d d3 = i2.g(); d3 != null; n3 += arrn[q4.d()] * arrn[q3.d()], d3 = d3.g()) {
                        q3 = d3.d();
                        if (!bl2) {
                            if (!bl2) continue;
                        }
                        break block7;
                    }
                    i2 = i2.g();
                }
                if (!bl2) continue;
            }
            a2.a((Object)q2, n3);
            arrn[q2.d()] = n4 + 1;
        }
        if (n3 <= n2) return n2;
        n2 = n3;
        arrq[0] = q2;
        return n2;
    }

    public static f a(i i2, q q2) {
        boolean bl2 = h.a;
        f f2 = new f();
        B b2 = new B(f2);
        b2.a(false);
        b2.a(i2, q2);
        e e2 = f2.a();
        do {
            if (!e2.f()) return f2;
            i2.c(e2.a());
            e2.g();
        } while (!bl2);
        return f2;
    }

    private static void a(q q2, y y2) {
        boolean bl2 = h.a;
        x x2 = q2.o();
        do {
            if (!x2.f()) return;
            q q3 = x2.e();
            y2.b(q3);
            A.a(q3, y2);
            x2.g();
        } while (!bl2);
    }

    /*
     * Unable to fully structure code
     */
    public static q a(i var0, q var1_1, boolean var2_2, y var3_3) {
        block10 : {
            var9_4 = h.a;
            if (var3_3.size() == 0) {
                return null;
            }
            var4_5 = new int[var0.e()];
            var5_6 = var3_3.a();
            var6_7 = var5_6.e();
            if (var6_7 == var1_1) {
                return var1_1;
            }
            var7_8 = 1;
            while (var6_7 != var1_1) {
                var4_5[var6_7.d()] = var7_8++;
                var6_7 = A.a(var6_7, var2_2);
                if (!var9_4) {
                    if (!var9_4) continue;
                }
                break block10;
            }
            var4_5[var6_7.d()] = var7_8;
        }
        var8_9 = A.a(var5_6.e(), var2_2);
        var5_6.g();
        do {
            if (var8_9 == var1_1) return var8_9;
            if (var5_6.f() == false) return var8_9;
            var6_7 = var5_6.e();
            if (var6_7 == var1_1) {
                return var1_1;
            }
            if (var4_5[var6_7.d()] < var4_5[var8_9.d()]) ** GOTO lbl29
            var8_9 = A.a(var6_7, var2_2);
            if (!var9_4) ** GOTO lbl38
lbl29: // 3 sources:
            while (var4_5[var6_7.d()] == 0) {
                var4_5[var6_7.d()] = 1;
                var6_7 = A.a(var6_7, var2_2);
                if (!var9_4) {
                    if (!var9_4) continue;
                }
                ** GOTO lbl-1000
            }
            if (var4_5[var6_7.d()] != 1) lbl-1000: // 2 sources:
            {
                if (var4_5[var6_7.d()] > var4_5[var8_9.d()]) {
                    var8_9 = var6_7;
                }
            }
lbl38: // 6 sources:
            var5_6.g();
        } while (!var9_4);
        return var8_9;
    }

    private static q a(q q2, boolean bl2) {
        q q3;
        if (bl2) {
            q3 = q2.g().c();
            return q3;
        }
        q3 = q2.f().d();
        return q3;
    }

    public static void b(i i2, y.c.A a2) {
        q q2 = A.d(i2);
        A.a(q2, a2);
    }

    private static int a(q q2, y.c.A a2) {
        boolean bl2 = h.a;
        int n2 = 0;
        for (d d2 = q2.f(); d2 != null; d2 = d2.g()) {
            q q3 = d2.d();
            n2 = Math.max(n2, A.a(q3, a2));
            if (bl2) return n2 + 1;
            if (!bl2) continue;
        }
        a2.a((Object)q2, n2 + 1);
        return n2 + 1;
    }
}

