/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import y.c.D;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.i;
import y.c.q;
import y.d.t;
import y.f.X;
import y.f.i.aK;
import y.f.i.v;

class aO {
    private f[] a;
    private int[] b;
    private int c;
    private q d;
    private X e;
    private final aK f;

    public aO(aK aK2, q q2, c c2) {
        block5 : {
            int n2;
            block4 : {
                n2 = v.f;
                this.f = aK2;
                this.a = new f[4];
                this.b = new int[4];
                this.c = 0;
                for (int i2 = 0; i2 < 4; ++i2) {
                    this.a[i2] = new f();
                    if (n2 == 0) {
                        if (n2 == 0) continue;
                    }
                    break block4;
                }
                this.d = q2;
                this.e = (X)this.d.e();
            }
            if (c2 != null) {
                this.a(c2);
                if (n2 == 0) break block5;
            }
            this.e();
        }
        this.f();
    }

    /*
     * Unable to fully structure code
     */
    private void a(c var1_1) {
        block6 : {
            var11_2 = v.f;
            var2_3 = new boolean[4];
            var3_4 = this.d.j();
            while (var3_4.f()) {
                var4_6 = var3_4.a();
                v0 = (int)aK.a(this.f).d(var4_6) ? 1 : 0;
                if (var11_2 != 0) break block6;
                if (v0 != 0) ** GOTO lbl22
                var5_7 = this.d == var4_6.c();
                var6_8 = this.e.m(var4_6);
                var9_11 = var6_8.size();
                if (!var5_7) ** GOTO lbl-1000
                var7_9 = (t)var6_8.a(0);
                var8_10 = (t)var6_8.a(1);
                if (var11_2 != 0) lbl-1000: // 2 sources:
                {
                    var7_9 = (t)var6_8.a(var9_11 - 1);
                    var8_10 = (t)var6_8.a(var9_11 - 2);
                }
                if ((var10_12 = this.a(var7_9, var8_10)) != -9) {
                    this.a[var10_12].add(var4_6);
                    if (var1_1.d(var4_6)) {
                        var2_3[var10_12] = true;
                    }
                }
lbl22: // 6 sources:
                var3_4.g();
                if (var11_2 == 0) continue;
            }
            v0 = 0;
        }
        var3_5 = v0;
        do {
            if (var3_5 >= 4) return;
            if (!var2_3[var3_5]) {
                this.a[var3_5].clear();
            }
            ++var3_5;
        } while (var11_2 == 0);
    }

    /*
     * Unable to fully structure code
     */
    private void e() {
        var9_1 = v.f;
        var1_2 = this.d.j();
        do {
            if (var1_2.f() == false) return;
            var2_3 = var1_2.a();
            var3_4 = this.d == var2_3.c();
            var4_5 = this.e.m(var2_3);
            var7_8 = var4_5.size();
            if (!var3_4) ** GOTO lbl-1000
            var5_6 = (t)var4_5.a(0);
            var6_7 = (t)var4_5.a(1);
            if (var9_1 != 0) lbl-1000: // 2 sources:
            {
                var5_6 = (t)var4_5.a(var7_8 - 1);
                var6_7 = (t)var4_5.a(var7_8 - 2);
            }
            if ((var8_9 = this.a(var5_6, var6_7)) != -9) {
                this.a[var8_9].add(var2_3);
            }
            var1_2.g();
        } while (var9_1 == 0);
    }

    private int a(t t2, t t3) {
        double d2;
        int n2;
        int n3 = v.f;
        if (Math.abs(t2.a - t3.a) < 0.01) {
            d2 = this.e.n(this.d) + this.e.q(this.d) / 2.0;
            n2 = t3.b <= d2 ? 0 : 1;
            if (n3 == 0) return n2;
        }
        if (Math.abs(t2.b - t3.b) >= 0.01) return -9;
        d2 = this.e.m(this.d) + this.e.p(this.d) / 2.0;
        n2 = t3.a <= d2 ? 2 : 3;
        if (n3 == 0) return n2;
        return -9;
    }

    private void f() {
        int n2;
        int n3;
        int[] arrn;
        int n4;
        block7 : {
            int n5;
            int n6;
            int n7;
            block6 : {
                n2 = v.f;
                int n8 = Integer.MIN_VALUE;
                n5 = -1;
                int n9 = Integer.MAX_VALUE;
                n6 = -1;
                for (int i2 = 0; i2 < 4; ++i2) {
                    n7 = this.a[i2].size();
                    if (n2 == 0) {
                        if (n7 > n8) {
                            n5 = i2;
                            n8 = this.a[i2].size();
                        }
                        if (this.a[i2].size() > n9) continue;
                        n6 = i2;
                        n9 = this.a[i2].size();
                        if (n2 == 0) continue;
                    }
                    break block6;
                }
                this.b[0] = n5;
                this.b[3] = n6;
                n7 = 2;
            }
            int[] arrn2 = new int[n7];
            arrn2[0] = 0;
            arrn2[1] = 0;
            arrn = arrn2;
            for (int i3 = 0; i3 < 4; ++i3) {
                n4 = i3;
                n3 = n6;
                if (n2 == 0) {
                    if (n4 == n3 || i3 == n5) continue;
                    arrn[1] = arrn[0];
                    arrn[0] = i3;
                    if (n2 == 0) continue;
                }
                break block7;
            }
            n4 = this.a[arrn[0]].size();
            n3 = this.a[arrn[1]].size();
        }
        if (n4 > n3) {
            this.b[1] = arrn[0];
            this.b[2] = arrn[1];
            if (n2 == 0) return;
        }
        this.b[1] = arrn[1];
        this.b[2] = arrn[0];
    }

    public void a() {
        this.c = 0;
    }

    public boolean b() {
        ++this.c;
        if (this.c < 0) return false;
        if (this.c >= 4) return false;
        return true;
    }

    public f c() {
        return this.a[this.b[this.c]];
    }

    public int d() {
        return this.b[this.c];
    }

    public String toString() {
        int n2 = v.f;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[n: ").append(this.d);
        stringBuffer.append("; sequence = (");
        for (int i2 = 0; i2 < 3; ++i2) {
            stringBuffer.append(this.b[i2]).append(", ");
            if (n2 != 0) return stringBuffer.toString();
            if (n2 == 0) continue;
        }
        stringBuffer.append(this.b[3]).append(")");
        stringBuffer.append("; currIndex = ").append(this.c).append("]");
        return stringBuffer.toString();
    }
}

