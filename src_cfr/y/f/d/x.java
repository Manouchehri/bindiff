/*
 * Decompiled with CFR 0_115.
 */
package y.f.d;

import y.d.n;
import y.d.t;
import y.f.d.B;
import y.f.d.a;

final class x {
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    private B g;
    private int h;
    private int i;
    private int j;

    x(int n2, int n3, int n4, int n5) {
        this.a = n4;
        this.b = n5;
        this.c = n2;
        this.e = 0;
        this.d = n3;
        this.f = 0;
        this.g = new B(n4 * n5);
    }

    int a() {
        return this.e;
    }

    int b() {
        return this.f;
    }

    void a(int n2, int n3, int n4, int n5) {
        int n6 = a.f;
        int n7 = n3;
        do {
            if (n7 >= n5) return;
            this.a(n2, n4, n7, true);
            ++n7;
        } while (n6 == 0);
    }

    void c() {
        int n2;
        int[] arrn;
        int n3;
        int n4;
        int[] arrn2;
        int[] arrn3;
        int[] arrn4;
        int n5;
        block13 : {
            block12 : {
                block11 : {
                    n3 = a.f;
                    arrn2 = new int[this.b];
                    arrn3 = new int[this.b];
                    arrn4 = new int[this.a];
                    arrn = new int[this.a];
                    for (n4 = 0; n4 < arrn2.length; ++n4) {
                        arrn2[n4] = this.a;
                        arrn3[n4] = -1;
                        if (n3 == 0) {
                            if (n3 == 0) continue;
                        }
                        break block11;
                    }
                    n4 = 0;
                }
                while (n4 < arrn4.length) {
                    arrn4[n4] = this.b;
                    arrn[n4] = -1;
                    ++n4;
                    if (n3 == 0) {
                        if (n3 == 0) continue;
                    }
                    break block12;
                }
                n4 = this.g.nextSetBit(0);
            }
            while (n4 >= 0) {
                n5 = n4 % this.a;
                n2 = n4 / this.a;
                arrn2[n2] = Math.min(arrn2[n2], n5);
                arrn4[n5] = Math.min(arrn4[n5], n2);
                arrn3[n2] = Math.max(arrn3[n2], n5);
                arrn[n5] = Math.max(arrn[n5], n2);
                n4 = this.g.nextSetBit(n4 + 1);
                if (n3 == 0) {
                    if (n3 == 0) continue;
                }
                break block13;
            }
            n4 = 0;
        }
        n5 = 0;
        do {
            int n6;
            int n7;
            block14 : {
                if (n5 >= this.b) return;
                n2 = arrn2[n5];
                block4 : do {
                    int n8 = n2;
                    int n9 = arrn3[n5];
                    block5 : while (n8 < n9) {
                        n7 = arrn4[n2];
                        n6 = n5;
                        if (n3 != 0) break block14;
                        if (n7 <= n6 && arrn[n2] >= n5) {
                            int n10 = n2 + 1;
                            while (arrn4[n10] <= n5) {
                                n8 = arrn[n10];
                                n9 = n5;
                                if (n3 != 0) continue block5;
                                if (n8 < n9) break;
                                ++n10;
                                if (n3 == 0) continue;
                            }
                            this.g.set(n4 + n2, n4 + n10);
                        }
                        ++n2;
                        if (n3 == 0) continue block4;
                    }
                    break block4;
                    break;
                } while (true);
                n7 = n4;
                n6 = this.a;
            }
            n4 = n7 + n6;
            ++n5;
        } while (n3 == 0);
    }

    boolean a(x x2, int n2, int n3, int n4, int n5, n n6, boolean bl2) {
        boolean bl3;
        block3 : {
            int n7 = a.f;
            this.h = Integer.MAX_VALUE;
            this.i = 0;
            this.j = 0;
            int n8 = this.c + this.a / 2;
            int n9 = this.d + this.b / 2;
            this.b(n2 - n8, n3 - n9);
            for (int i2 = 0; i2 < n5; i2 += n4) {
                bl3 = this.a(x2, 0, 0, i2, n6, bl2);
                if (n7 == 0) {
                    if (!bl3) continue;
                    if (i2 == 0) return false;
                    return true;
                }
                break block3;
            }
            bl3 = bl2;
        }
        if (!bl3) return false;
        if (this.i <= 0) {
            if (this.j <= 0) return false;
        }
        this.c += this.i;
        this.d += this.j;
        this.e += this.i;
        this.f += this.j;
        return true;
    }

    /*
     * Unable to fully structure code
     */
    boolean a(x var1_1, int var2_2, int var3_3, int var4_4, n var5_5, boolean var6_6) {
        var11_7 = a.f;
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
            if (var11_7 != 0) return v0;
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
            if (var11_7 == 0) ** GOTO lbl-1000
lbl31: // 2 sources:
            var10_11 += 2 - 2 * var7_8 + 2 * var8_9;
            --var7_8;
            ++var8_9;
        } while (var11_7 == 0);
        return false;
    }

    private final boolean a(x x2, int n2, int n3, n n4, boolean bl2) {
        t t2 = new t((double)(n2 + this.c) + (double)this.a * 0.5, (double)(n3 + this.d) + (double)this.b * 0.5);
        if (n4 != null && !n.a(n4, t2, 1.0)) {
            return false;
        }
        if (!bl2) {
            return this.a(x2, n2, n3);
        }
        this.c += n2;
        this.d += n3;
        int n5 = this.c(x2);
        if (n5 < this.h) {
            this.h = n5;
            this.i = n2;
            this.j = n3;
        }
        if (n5 == 0) {
            this.e += n2;
            this.f += n3;
            return true;
        }
        this.c -= n2;
        this.d -= n3;
        return false;
    }

    private final boolean a(x x2, int n2, int n3) {
        this.c += n2;
        this.d += n3;
        if (!this.b(x2)) {
            this.e += n2;
            this.f += n3;
            return true;
        }
        this.c -= n2;
        this.d -= n3;
        return false;
    }

    private int c(x x2) {
        int n2;
        int n3 = a.f;
        int n4 = Math.max(this.c, x2.c);
        int n5 = Math.min(this.c + this.a, x2.c + x2.a);
        int n6 = Math.max(this.d, x2.d);
        int n7 = Math.min(this.d + this.b, x2.d + x2.b);
        int n8 = 0;
        int n9 = n4;
        block0 : do {
            int n10 = n9;
            block1 : while (n10 < n5) {
                n2 = n6;
                if (n3 != 0) return n2;
                for (int i2 = v1421388; i2 < n7; ++i2) {
                    n10 = (int)this.a(n9, i2) ? 1 : 0;
                    if (n3 != 0) continue block1;
                    if (n10 == 0 || !x2.a(n9, i2)) continue;
                    ++n8;
                    if (n3 == 0) continue;
                }
                ++n9;
                if (n3 == 0) continue block0;
            }
            break block0;
            break;
        } while (true);
        n2 = n8;
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
            if (a.f == 0) return;
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
            if (a.f == 0) return;
        }
        this.g.clear(n5, n6);
    }

    public void b(int n2, int n3) {
        this.c += n2;
        this.d += n3;
        this.e += n2;
        this.f += n3;
    }

    public void a(x x2) {
        int n2 = a.f;
        if (x2.c < this.c || x2.c >= this.c + this.a || x2.d < this.d || x2.d >= this.d + this.b || x2.c + x2.a > this.c + this.a || x2.d + x2.b > this.d + this.b) {
            this.b(Math.min(x2.c, this.c), Math.min(x2.d, this.d), Math.max(x2.c + x2.a, this.c + this.a), Math.max(x2.d + x2.b, this.d + this.b));
        }
        int n3 = x2.g.nextSetBit(0);
        do {
            if (n3 < 0) return;
            int n4 = n3 % x2.a + x2.c;
            int n5 = n3 / x2.a + x2.d;
            int n6 = n4 - this.c + (n5 - this.d) * this.a;
            this.g.set(n6);
            n3 = x2.g.nextSetBit(n3 + 1);
        } while (n2 == 0);
    }

    void b(int n2, int n3, int n4, int n5) {
        int n6 = a.f;
        int n7 = n4 - n2;
        B b2 = new B(n7 * (n5 - n3));
        int n8 = this.g.nextSetBit(0);
        while (n8 >= 0) {
            int n9 = n8 % this.a + this.c;
            int n10 = n8 / this.a + this.d;
            b2.set(n9 - n2 + (n10 - n3) * n7);
            n8 = this.g.nextSetBit(n8 + 1);
            if (n6 != 0) return;
            if (n6 == 0) continue;
        }
        this.g = b2;
        this.c = n2;
        this.d = n3;
        this.a = n7;
        this.b = n5 - n3;
    }

    /*
     * Unable to fully structure code
     */
    public boolean b(x var1_1) {
        var14_2 = a.f;
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
            if (var14_2 != 0) return (boolean)v0;
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
            if (var14_2 == 0) ** GOTO lbl-1000
lbl32: // 2 sources:
            var9_10 = var3_4.a(var10_11, var12_13, var4_5, var6_7, var5_6, var7_8);
            if (var14_2 == 0) ** GOTO lbl-1000
lbl34: // 2 sources:
            if (var12_13 >= var13_14) ** GOTO lbl37
            var8_9 = var2_3.a(var11_12, var13_14, var4_5, var6_7, var5_6, var7_8);
            if (var14_2 == 0) ** GOTO lbl-1000
lbl37: // 2 sources:
            var9_10 = var3_4.a(var10_11, var12_13, var4_5, var6_7, var5_6, var7_8);
        } while (var14_2 == 0);
        return (boolean)0;
    }

    /*
     * Unable to fully structure code
     */
    public final int a(int var1_1, int var2_2, int var3_3, int var4_4, int var5_5, int var6_6) {
        var9_7 = a.f;
        var7_8 = var1_1 - this.c + (var2_2 - this.d) * this.a;
        v0 = var8_9 = var7_8 >= 0 && var7_8 % this.a >= (var3_3 -= this.c) && var7_8 % this.a < (var5_5 -= this.c) && var7_8 / this.a >= (var4_4 -= this.d) && var7_8 / this.a < (var6_6 -= this.d);
        block0 : do {
            if (var8_9) ** GOTO lbl10
            if (var7_8 % this.a >= var3_3) ** GOTO lbl-1000
            var7_8 += var3_3 - var7_8 % this.a;
            if (var9_7 != 0) lbl-1000: // 2 sources:
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
            } while (var9_7 != 0);
            break;
        } while (true);
        return v1;
    }

    public String toString() {
        int n2 = a.f;
        StringBuffer stringBuffer = new StringBuffer(this.a * this.b + this.b + 1);
        int n3 = 0;
        int n4 = 0;
        do {
            int n5 = n4;
            block1 : do {
                if (n5 >= this.b) return new StringBuffer().append("x: ").append(this.c).append(" y: ").append(this.d).append("\n").append(stringBuffer.toString()).toString();
                for (int i2 = 0; i2 < this.a; ++n3, ++i2) {
                    n5 = (int)this.g.get(n3) ? 1 : 0;
                    if (n2 != 0) continue block1;
                    if (n5 != 0) {
                        stringBuffer.append('#');
                        if (n2 == 0) continue;
                    }
                    stringBuffer.append('.');
                    if (n2 == 0) continue;
                }
                break;
            } while (true);
            stringBuffer.append('\n');
            ++n4;
        } while (n2 == 0);
        return new StringBuffer().append("x: ").append(this.c).append(" y: ").append(this.d).append("\n").append(stringBuffer.toString()).toString();
    }
}

