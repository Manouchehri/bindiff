/*
 * Decompiled with CFR 0_115.
 */
package y.f.g;

import java.util.Comparator;
import y.c.C;
import y.c.D;
import y.d.p;
import y.d.t;
import y.f.g.d;
import y.f.g.n;
import y.f.g.q;
import y.f.g.u;
import y.f.g.v;
import y.f.g.x;
import y.f.g.y;

final class r {
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    private x g;
    private int h;
    private int i;
    private int j;
    private final n k;

    r(n n2, int n3, int n4, int n5, int n6) {
        this.k = n2;
        this.a = n5;
        this.b = n6;
        this.c = n3;
        this.e = 0;
        this.d = n4;
        this.f = 0;
        this.g = new x(n5 * n6);
    }

    int a() {
        return this.e;
    }

    int b() {
        return this.f;
    }

    void a(int n2, int n3, int n4, int n5) {
        boolean bl2 = d.d;
        int n6 = n3;
        do {
            if (n6 >= n5) return;
            this.a(n2, n4, n6, true);
            ++n6;
        } while (!bl2);
    }

    void c() {
        int n2;
        int[] arrn;
        int n3;
        int[] arrn2;
        int[] arrn3;
        boolean bl2;
        int[] arrn4;
        int n4;
        block13 : {
            block12 : {
                block11 : {
                    bl2 = d.d;
                    arrn2 = new int[this.b];
                    arrn3 = new int[this.b];
                    arrn4 = new int[this.a];
                    arrn = new int[this.a];
                    for (n3 = 0; n3 < arrn2.length; ++n3) {
                        arrn2[n3] = this.a;
                        arrn3[n3] = -1;
                        if (!bl2) {
                            if (!bl2) continue;
                        }
                        break block11;
                    }
                    n3 = 0;
                }
                while (n3 < arrn4.length) {
                    arrn4[n3] = this.b;
                    arrn[n3] = -1;
                    ++n3;
                    if (!bl2) {
                        if (!bl2) continue;
                    }
                    break block12;
                }
                n3 = this.g.nextSetBit(0);
            }
            while (n3 >= 0) {
                n4 = n3 % this.a;
                n2 = n3 / this.a;
                arrn2[n2] = Math.min(arrn2[n2], n4);
                arrn4[n4] = Math.min(arrn4[n4], n2);
                arrn3[n2] = Math.max(arrn3[n2], n4);
                arrn[n4] = Math.max(arrn[n4], n2);
                n3 = this.g.nextSetBit(n3 + 1);
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block13;
            }
            n3 = 0;
        }
        n4 = 0;
        do {
            int n5;
            int n6;
            block14 : {
                if (n4 >= this.b) return;
                n2 = arrn2[n4];
                block4 : do {
                    int n7 = n2;
                    int n8 = arrn3[n4];
                    block5 : while (n7 < n8) {
                        n6 = arrn4[n2];
                        n5 = n4;
                        if (bl2) break block14;
                        if (n6 <= n5 && arrn[n2] >= n4) {
                            int n9 = n2 + 1;
                            while (arrn4[n9] <= n4) {
                                n7 = arrn[n9];
                                n8 = n4;
                                if (bl2) continue block5;
                                if (n7 < n8) break;
                                ++n9;
                                if (!bl2) continue;
                            }
                            this.g.set(n3 + n2, n3 + n9);
                        }
                        ++n2;
                        if (!bl2) continue block4;
                    }
                    break block4;
                    break;
                } while (true);
                n6 = n3;
                n5 = this.a;
            }
            n3 = n6 + n5;
            ++n4;
        } while (!bl2);
    }

    q a(r r2, int n2, int n3, int n4, int n5, boolean bl2, y y2, D d2, D d3, boolean bl3) {
        q q2;
        int n6;
        block7 : {
            int n7;
            block5 : {
                boolean bl4;
                C c2;
                v v2;
                int n8;
                double d4;
                int n9;
                int n10;
                int n11;
                block6 : {
                    boolean bl5;
                    block4 : {
                        bl4 = d.d;
                        this.h = Integer.MAX_VALUE;
                        this.i = 0;
                        this.j = 0;
                        n10 = this.c + this.a / 2;
                        n9 = this.d + this.b / 2;
                        this.b(n2 - n10, n3 - n9);
                        n10 = this.c + this.a / 2;
                        n9 = this.d + this.b / 2;
                        q2 = null;
                        for (n7 = 0; n7 < n5; n7 += n4) {
                            bl5 = n.c(this.k);
                            if (bl4) break block4;
                            if (!bl5 || (q2 = this.a(r2, n7, y2, d2, bl2, bl3)) == null) continue;
                            d4 = Math.sqrt((n10 - q2.a) * (n10 - q2.a) + (n9 - q2.b) * (n9 - q2.b));
                            if (d3 == null || d3.isEmpty()) break block5;
                            n8 = n10 - q2.a;
                            n11 = n9 - q2.b;
                            this.c += n8;
                            this.d += n11;
                            this.e += n8;
                            this.f += n11;
                            v2 = new v(this.k, n10, n9);
                            d3.sort(v2);
                            c2 = d3.m();
                            break block6;
                        }
                        bl5 = bl2;
                    }
                    if (!bl5) return null;
                    this.c += this.i;
                    this.d += this.j;
                    this.e += this.i;
                    this.f += this.j;
                    return q2;
                }
                while (c2.f()) {
                    q q3 = (q)c2.d();
                    n6 = v2.compare(q3, q2);
                    if (!bl4) {
                        if (n6 < 0 && (t.a(n10, n9, q3.a, q3.b) < Math.max((double)n.d(this.k) / n.a(this.k), d4) || t.a(q2.a, q2.b, q3.a, q3.b) < 15.0 / n.a(this.k)) && this.a(r2, q3.a - n10, q3.b - n9, y2, bl2)) {
                            return q3;
                        }
                        c2.g();
                        if (!bl4) continue;
                    }
                    break block7;
                }
                this.c -= n8;
                this.d -= n11;
                this.e -= n8;
                this.f -= n11;
            }
            n6 = n7;
        }
        if (n6 == 0) return null;
        return q2;
    }

    boolean a(r r2, int n2, int n3, int n4, int n5, y y2, boolean bl2) {
        boolean bl3;
        block2 : {
            boolean bl4 = d.d;
            this.h = Integer.MAX_VALUE;
            this.i = 0;
            this.j = 0;
            int n6 = this.c + this.a / 2;
            int n7 = this.d + this.b / 2;
            this.b(n2 - n6, n3 - n7);
            for (int i2 = 0; i2 < n5; i2 += n4) {
                bl3 = n.c(this.k);
                if (!bl4) {
                    if (!bl3 || !this.a(r2, 0, 0, i2, y2, bl2)) continue;
                    if (i2 == 0) return false;
                    return true;
                }
                break block2;
            }
            bl3 = bl2;
        }
        if (!bl3) return false;
        this.c += this.i;
        this.d += this.j;
        this.e += this.i;
        this.f += this.j;
        return true;
    }

    q a(r r2, int n2, y y2, D d2, boolean bl2, boolean bl3) {
        t[] arrt;
        Object object;
        D d3;
        Object object2;
        boolean bl4 = d.d;
        int n3 = this.c + this.a / 2;
        int n4 = this.d + this.b / 2;
        if (n2 != 0) {
            p p2 = new p(new t(n3, n4), n2);
            d3 = new D();
            object = d2.m();
            block0 : do {
                boolean bl5 = object.f();
                block1 : while (bl5) {
                    object2 = (u)object.d();
                    if (!bl3 || object2.b()) {
                        block13 : {
                            if (object2.c().a() == object2.d().a()) {
                                arrt = p2.b(object2.c().a());
                                if (!bl4) break block13;
                            }
                            arrt = p2.a(object2.c().b());
                        }
                        if (arrt != null) {
                            for (int i2 = 0; i2 < arrt.length; ++i2) {
                                bl5 = object2.a(arrt[i2]);
                                if (bl4) continue block1;
                                if (!bl5) continue;
                                int n5 = object2.l();
                                d3.add(new q(arrt[i2], n5, (u)object2));
                                if (!bl4) continue;
                            }
                        }
                    }
                    object.g();
                    if (!bl4) continue block0;
                }
                break block0;
                break;
            } while (true);
        } else {
            C c2 = d2.m();
            do {
                t t2;
                if (!c2.f()) return null;
                u u2 = (u)c2.d();
                if ((!bl3 || u2.b()) && u2.a(t2 = new t(n3, n4)) && this.a(r2, 0, 0, y2, bl2)) {
                    return new q(t2, u2.l(), u2);
                }
                c2.g();
            } while (!bl4);
            return null;
        }
        object = new v(this.k);
        d3.sort((Comparator)object);
        object2 = d3.m();
        do {
            if (!object2.f()) return null;
            arrt = (t[])object2.d();
            if (this.a(r2, arrt.a - n3, arrt.b - n4, y2, bl2)) {
                return arrt;
            }
            object2.g();
        } while (!bl4);
        return null;
    }

    /*
     * Unable to fully structure code
     */
    boolean a(r var1_1, int var2_2, int var3_3, int var4_4, y var5_5, boolean var6_6) {
        var11_7 = d.d;
        if (var4_4 == 0) {
            return this.a(var1_1, var2_2, var3_3, var5_5, var6_6);
        }
        var7_8 = var4_4;
        var8_9 = 0;
        var10_11 = var9_10 = var4_4 * var4_4;
        do lbl-1000: // 3 sources:
        {
            if (var7_8 < var8_9) return false;
            v0 = this.a(var1_1, var2_2 + var7_8, var3_3 + var8_9, var5_5, var6_6);
            if (var11_7 != false) return v0;
            if (v0) {
                return true;
            }
            if (this.a(var1_1, var2_2 + var7_8, var3_3 - var8_9, var5_5, var6_6)) {
                return true;
            }
            if (this.a(var1_1, var2_2 - var7_8, var3_3 + var8_9, var5_5, var6_6)) {
                return true;
            }
            if (this.a(var1_1, var2_2 - var7_8, var3_3 - var8_9, var5_5, var6_6)) {
                return true;
            }
            if (this.a(var1_1, var2_2 + var8_9, var3_3 + var7_8, var5_5, var6_6)) {
                return true;
            }
            if (this.a(var1_1, var2_2 + var8_9, var3_3 - var7_8, var5_5, var6_6)) {
                return true;
            }
            if (this.a(var1_1, var2_2 - var8_9, var3_3 + var7_8, var5_5, var6_6)) {
                return true;
            }
            if (this.a(var1_1, var2_2 - var8_9, var3_3 - var7_8, var5_5, var6_6)) {
                return true;
            }
            if (var10_11 >= var9_10) ** GOTO lbl31
            var10_11 += 1 + 2 * var8_9;
            ++var8_9;
            if (!var11_7) ** GOTO lbl-1000
lbl31: // 2 sources:
            var10_11 += 2 - 2 * var7_8 + 2 * var8_9;
            --var7_8;
            ++var8_9;
        } while (!var11_7);
        return false;
    }

    private final boolean a(r r2, int n2, int n3, y y2, boolean bl2) {
        t t2 = new t((double)(n2 + this.c) + (double)this.a * 0.5, (double)(n3 + this.d) + (double)this.b * 0.5);
        if (y2 != null && !y2.a(t2)) {
            return false;
        }
        if (!bl2) {
            return this.a(r2, n2, n3);
        }
        this.c += n2;
        this.d += n3;
        int n4 = this.b(r2);
        if (n4 < this.h) {
            this.h = n4;
            this.i = n2;
            this.j = n3;
        }
        if (n4 == 0) {
            this.e += n2;
            this.f += n3;
            return true;
        }
        this.c -= n2;
        this.d -= n3;
        return false;
    }

    private final boolean a(r r2, int n2, int n3) {
        this.c += n2;
        this.d += n3;
        if (!this.a(r2)) {
            this.e += n2;
            this.f += n3;
            return true;
        }
        this.c -= n2;
        this.d -= n3;
        return false;
    }

    private int b(r r2) {
        int n2;
        boolean bl2 = d.d;
        int n3 = Math.max(this.c, r2.c);
        int n4 = Math.min(this.c + this.a, r2.c + r2.a);
        int n5 = Math.max(this.d, r2.d);
        int n6 = Math.min(this.d + this.b, r2.d + r2.b);
        int n7 = 0;
        int n8 = n3;
        block0 : do {
            int n9 = n8;
            block1 : while (n9 < n4) {
                n2 = n5;
                if (bl2) return n2;
                for (int i2 = v1664307; i2 < n6; ++i2) {
                    n9 = (int)this.a(n8, i2) ? 1 : 0;
                    if (bl2) continue block1;
                    if (n9 == 0 || !r2.a(n8, i2)) continue;
                    ++n7;
                    if (!bl2) continue;
                }
                ++n8;
                if (!bl2) continue block0;
            }
            break block0;
            break;
        } while (true);
        n2 = n7;
        return n2;
    }

    public boolean a(int n2, int n3) {
        if (n2 < this.c) return false;
        if (n2 >= this.c + this.a) return false;
        if (n3 < this.d) return false;
        if (n3 >= this.d + this.b) {
            return false;
        }
        int n4 = (n3 - this.d) * this.a + n2 - this.c;
        return this.g.get(n4);
    }

    public void a(int n2, int n3, boolean bl2) {
        if (n2 < this.c) throw new IndexOutOfBoundsException();
        if (n2 >= this.c + this.a) throw new IndexOutOfBoundsException();
        if (n3 < this.d) throw new IndexOutOfBoundsException();
        if (n3 >= this.d + this.b) {
            throw new IndexOutOfBoundsException();
        }
        int n4 = (n3 - this.d) * this.a + n2 - this.c;
        if (bl2) {
            this.g.set(n4);
            if (!d.d) return;
        }
        this.g.clear(n4);
    }

    public void a(int n2, int n3, int n4, boolean bl2) {
        if (n2 < this.c) throw new IndexOutOfBoundsException();
        if (n3 >= this.c + this.a) throw new IndexOutOfBoundsException();
        if (n4 < this.d) throw new IndexOutOfBoundsException();
        if (n4 >= this.d + this.b) {
            throw new IndexOutOfBoundsException();
        }
        int n5 = (n4 - this.d) * this.a + n2 - this.c;
        int n6 = (n4 - this.d) * this.a + n3 - this.c;
        if (bl2) {
            this.g.set(n5, n6);
            if (!d.d) return;
        }
        this.g.clear(n5, n6);
    }

    public void b(int n2, int n3) {
        this.c += n2;
        this.d += n3;
        this.e += n2;
        this.f += n3;
    }

    /*
     * Unable to fully structure code
     */
    public boolean a(r var1_1) {
        var14_2 = d.d;
        if (var1_1.c >= this.c + this.a) return false;
        if (var1_1.d >= this.d + this.b) return false;
        if (var1_1.c + var1_1.a <= this.c) return false;
        if (var1_1.d + var1_1.b <= this.d) {
            return false;
        }
        var2_3 = this;
        var3_4 = var1_1;
        var4_5 = Math.max(var2_3.c, var3_4.c);
        var5_6 = Math.min(var2_3.c + var2_3.a, var3_4.c + var3_4.a);
        var6_7 = Math.max(var2_3.d, var3_4.d);
        var7_8 = Math.max(var2_3.d + var2_3.b, var3_4.d + var3_4.b);
        if (var4_5 >= var5_6) return false;
        if (var6_7 >= var7_8) return false;
        var8_9 = var2_3.a(var4_5, var6_7, var4_5, var6_7, var5_6, var7_8);
        var9_10 = var3_4.a(var4_5, var6_7, var4_5, var6_7, var5_6, var7_8);
        do lbl-1000: // 5 sources:
        {
            if (var8_9 < 0) return (boolean)0;
            v0 = var9_10;
            if (var14_2 != false) return (boolean)v0;
            if (v0 < 0) return (boolean)0;
            var10_11 = var8_9 % var2_3.a + var2_3.c;
            var11_12 = var9_10 % var3_4.a + var3_4.c;
            var12_13 = var8_9 / var2_3.a + var2_3.d;
            var13_14 = var9_10 / var3_4.a + var3_4.d;
            if (var12_13 != var13_14) ** GOTO lbl34
            if (var10_11 == var11_12) {
                return true;
            }
            if (var10_11 >= var11_12) ** GOTO lbl32
            var8_9 = var2_3.a(var11_12, var13_14, var4_5, var6_7, var5_6, var7_8);
            if (!var14_2) ** GOTO lbl-1000
lbl32: // 2 sources:
            var9_10 = var3_4.a(var10_11, var12_13, var4_5, var6_7, var5_6, var7_8);
            if (!var14_2) ** GOTO lbl-1000
lbl34: // 2 sources:
            if (var12_13 >= var13_14) ** GOTO lbl37
            var8_9 = var2_3.a(var11_12, var13_14, var4_5, var6_7, var5_6, var7_8);
            if (!var14_2) ** GOTO lbl-1000
lbl37: // 2 sources:
            var9_10 = var3_4.a(var10_11, var12_13, var4_5, var6_7, var5_6, var7_8);
        } while (!var14_2);
        return (boolean)0;
    }

    /*
     * Unable to fully structure code
     */
    public final int a(int var1_1, int var2_2, int var3_3, int var4_4, int var5_5, int var6_6) {
        var9_7 = d.d;
        var7_8 = var1_1 - this.c + (var2_2 - this.d) * this.a;
        v0 = var8_9 = var7_8 >= 0 && var7_8 % this.a >= (var3_3 -= this.c) && var7_8 % this.a < (var5_5 -= this.c) && var7_8 / this.a >= (var4_4 -= this.d) && var7_8 / this.a < (var6_6 -= this.d);
        block0 : do {
            if (var8_9) ** GOTO lbl10
            if (var7_8 % this.a >= var3_3) ** GOTO lbl-1000
            var7_8 += var3_3 - var7_8 % this.a;
            if (var9_7) lbl-1000: // 2 sources:
            {
                var7_8 += this.a - var7_8 % this.a;
            }
lbl10: // 4 sources:
            v1 = var7_8 = this.g.nextSetBit(var7_8);
            do {
                if (v1 < 0) {
                    return -1;
                }
                var8_9 = var7_8 % this.a >= var3_3 && var7_8 % this.a < var5_5 && var7_8 / this.a >= var4_4 && var7_8 / this.a < var6_6;
                if (!var8_9) continue block0;
                v1 = var7_8;
            } while (var9_7);
            break;
        } while (true);
        return v1;
    }

    public String toString() {
        boolean bl2 = d.d;
        StringBuffer stringBuffer = new StringBuffer(this.a * this.b + this.b + 1);
        int n2 = 0;
        int n3 = 0;
        do {
            int n4 = n3;
            block1 : do {
                if (n4 >= this.b) return new StringBuffer().append("x: ").append(this.c).append(" y: ").append(this.d).append("\n").append(stringBuffer.toString()).toString();
                for (int i2 = 0; i2 < this.a; ++n2, ++i2) {
                    n4 = (int)this.g.get(n2) ? 1 : 0;
                    if (bl2) continue block1;
                    if (n4 != 0) {
                        stringBuffer.append('#');
                        if (!bl2) continue;
                    }
                    stringBuffer.append('.');
                    if (!bl2) continue;
                }
                break;
            } while (true);
            stringBuffer.append('\n');
            ++n3;
        } while (!bl2);
        return new StringBuffer().append("x: ").append(this.c).append(" y: ").append(this.d).append("\n").append(stringBuffer.toString()).toString();
    }
}

