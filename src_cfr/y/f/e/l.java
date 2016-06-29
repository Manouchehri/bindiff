/*
 * Decompiled with CFR 0_115.
 */
package y.f.e;

import java.awt.Rectangle;
import java.util.Comparator;
import y.c.D;
import y.c.c;
import y.c.q;
import y.d.f;
import y.f.X;
import y.f.ad;
import y.f.ah;
import y.f.am;
import y.f.e.i;
import y.f.e.m;
import y.f.e.n;
import y.f.e.o;
import y.f.e.p;
import y.g.e;

public class l
implements ad {
    public static final Object a = "y.layout.organic.ShuffleLayouter.MINIMAL_DISTANCE_DPKEY";
    public static final Object b = "y.layout.organic.ShuffleLayouter.FIXED_NODE_DPKEY";
    private ah c;
    private double d = 5.0;
    private boolean e = false;
    private byte f = 2;
    private Rectangle[] g;
    private int[] h;
    private int[] i;
    private q[] n;
    private Comparator o;
    private boolean p;
    private c q;
    private boolean r = true;

    @Override
    public void c(X x2) {
        if (this.c != null) {
            this.c.c(x2);
        }
        if (x2.e() <= 0) return;
        this.a(x2);
    }

    @Override
    public void a(ah ah2) {
        this.c = ah2;
    }

    @Override
    public ah a() {
        return this.c;
    }

    public void a(byte by2) {
        this.f = by2;
    }

    public void a(double d2) {
        if (d2 < 0.0) {
            throw new IllegalArgumentException("Minimal distance must be non-negative");
        }
        this.d = d2;
    }

    public double b() {
        return this.d;
    }

    public void a(boolean bl2) {
        this.e = bl2;
    }

    public boolean c() {
        return this.e;
    }

    /*
     * Unable to fully structure code
     */
    private void a(X var1_1) {
        block10 : {
            block11 : {
                var15_2 = i.b;
                this.n = var1_1.m();
                this.g = new Rectangle[var1_1.e()];
                var2_3 = new double[var1_1.e() * 2];
                var3_4 = new double[var1_1.e() * 2];
                this.q = var1_1.c(l.b);
                var4_5 = var1_1.c(l.a);
                var5_6 = this.b();
                if (var5_6 == 0.0 && var4_5 == null) ** GOTO lbl31
                var7_7 = var5_6 * 0.5;
                for (var9_12 = this.n.length - 1; var9_12 >= 0; --var9_12) {
                    v0 = var4_5;
                    if (var15_2) break block10;
                    if (v0 == null) ** GOTO lbl20
                    var10_17 = var4_5.c(this.n[var9_12]);
                    if (var10_17 <= 0.0) ** GOTO lbl-1000
                    var7_7 = var10_17 * 0.5;
                    if (var15_2) lbl-1000: // 2 sources:
                    {
                        var7_7 = var5_6 * 0.5;
                    }
lbl20: // 4 sources:
                    var10_16 = var1_1.a(this.n[var9_12]);
                    var2_3[var9_12 << 1] = var10_16.getWidth();
                    var2_3[(var9_12 << 1) + 1] = var10_16.getHeight();
                    var3_4[var9_12 << 1] = var10_16.getX();
                    var3_4[(var9_12 << 1) + 1] = var10_16.getY();
                    var11_21 = (int)Math.floor(var10_16.getX() - var7_7);
                    var12_22 = (int)Math.floor(var10_16.getY() - var7_7);
                    var13_23 = (int)Math.ceil(var10_16.getX() + var10_16.getWidth() + var7_7);
                    var14_24 = (int)Math.ceil(var10_16.getY() + var10_16.getHeight() + var7_7);
                    this.g[var9_12] = new Rectangle(var11_21, var12_22, var13_23 - var11_21, var14_24 - var12_22);
                    if (!var15_2) continue;
lbl31: // 3 sources:
                    for (var7_8 = this.n.length - 1; var7_8 >= 0; --var7_8) {
                        var8_25 = var1_1.a(this.n[var7_8]);
                        var2_3[var7_8 << 1] = var8_25.getWidth();
                        var2_3[(var7_8 << 1) + 1] = var8_25.getHeight();
                        var9_12 = (int)Math.floor(var8_25.getX());
                        var10_18 = (int)Math.floor(var8_25.getY());
                        var11_21 = (int)Math.ceil(var8_25.getX() + var8_25.getWidth());
                        var12_22 = (int)Math.ceil(var8_25.getY() + var8_25.getHeight());
                        this.g[var7_8] = new Rectangle(var9_12, var10_18, var11_21 - var9_12, var12_22 - var10_18);
                        if (!var15_2) {
                            if (!var15_2) continue;
                        }
                        break block11;
                    }
                }
                this.o = new n(this);
            }
            if (!this.c()) ** GOTO lbl65
            if (!this.p) ** GOTO lbl62
            var7_9 = new int[this.g.length];
            var8_25 = new int[this.g.length];
            var9_13 = new int[this.g.length];
            var10_19 = new int[this.g.length];
            this.a(this.g, var7_9, (int[])var8_25);
            e.a(this.n, this.o);
            this.h();
            this.a(this.g, var9_13, var10_19);
            this.b(var7_9, (int[])var8_25, this.g);
            this.g();
            this.a(this.n);
            this.h();
            this.g();
            this.a(var9_13, var10_19, this.g);
            if (!var15_2) ** GOTO lbl132
lbl62: // 2 sources:
            e.a(this.n, this.o);
            this.h();
            if (!var15_2) ** GOTO lbl132
lbl65: // 2 sources:
            if (!this.p) ** GOTO lbl99
            var7_10 = new int[this.g.length];
            var8_25 = new int[this.g.length];
            var9_14 = new int[this.g.length];
            var10_20 = new int[this.g.length];
            this.a(this.g);
            this.e();
            this.a(this.g, var7_10, (int[])var8_25);
            e.a(this.n, this.o);
            this.h();
            this.a(this.g, var9_14, var10_20);
            this.b(var7_10, (int[])var8_25, this.g);
            this.g();
            this.a(this.n);
            this.h();
            this.g();
            this.a(var9_14, var10_20, this.g);
            this.d();
            this.a(this.g);
            this.f();
            this.a(this.g, var7_10, (int[])var8_25);
            e.a(this.n, this.o);
            this.h();
            this.a(this.g, var9_14, var10_20);
            this.b(var7_10, (int[])var8_25, this.g);
            this.g();
            this.a(this.n);
            this.h();
            this.g();
            this.a(var9_14, var10_20, this.g);
            this.f();
            this.b(this.g);
            this.b(this.g);
            if (!var15_2) ** GOTO lbl132
lbl99: // 2 sources:
            this.e();
            e.a(this.n, this.o);
            this.h();
            if (!this.r) ** GOTO lbl-1000
            v0 = this.q;
        }
        if (v0 != null) {
            v1 = true;
        } else lbl-1000: // 2 sources:
        {
            v1 = false;
        }
        var7_7 = (double)v1 ? 1 : 0;
        if (var7_7 != false) {
            this.g();
            e.a(this.n, this.o);
            this.h();
            this.g();
        }
        this.d();
        this.f();
        e.a(this.n, this.o);
        this.h();
        if (var7_7 != false) {
            this.g();
            e.a(this.n, this.o);
            this.h();
            this.g();
        }
        this.f();
        if (var7_7 != false) {
            e.a(this.n, this.o);
            this.h();
            this.g();
            e.a(this.n, this.o);
            this.h();
            this.g();
        }
lbl132: // 7 sources:
        for (var7_11 = this.n.length - 1; var7_11 >= 0; --var7_11) {
            var8_25 = this.n[var7_11];
            var9_15 = var8_25.d();
            var1_1.b((q)var8_25, var2_3[var9_15 << 1], var2_3[(var9_15 << 1) + 1]);
            var1_1.a((q)var8_25, (double)this.g[var9_15].x + (double)this.g[var9_15].width * 0.5, (double)this.g[var9_15].y + (double)this.g[var9_15].height * 0.5);
            if (var15_2 != false) return;
            if (!var15_2) continue;
        }
        this.n = null;
        this.g = null;
        this.q = null;
    }

    private void a(Object[] arrobject) {
        boolean bl2 = i.b;
        int n2 = (arrobject.length - 1) / 2;
        do {
            if (n2 < 0) return;
            Object object = arrobject[n2];
            arrobject[n2] = arrobject[arrobject.length - 1 - n2];
            arrobject[arrobject.length - 1 - n2] = object;
            --n2;
        } while (!bl2);
    }

    private void d() {
        boolean bl2 = i.b;
        for (int i2 = this.n.length - 1; i2 >= 0; --i2) {
            this.g[i2].width = this.h[i2];
            this.g[i2].x = this.i[i2];
            if (bl2) return;
            if (!bl2) continue;
        }
        this.h = null;
        this.i = null;
    }

    private void a(Rectangle[] arrrectangle) {
        boolean bl2 = i.b;
        int n2 = arrrectangle.length - 1;
        do {
            if (n2 < 0) return;
            arrrectangle[n2].x <<= 1;
            arrrectangle[n2].y <<= 1;
            arrrectangle[n2].width <<= 1;
            arrrectangle[n2].height <<= 1;
            --n2;
        } while (!bl2);
    }

    private void b(Rectangle[] arrrectangle) {
        boolean bl2 = i.b;
        int n2 = arrrectangle.length - 1;
        do {
            if (n2 < 0) return;
            arrrectangle[n2].x >>= 1;
            arrrectangle[n2].y >>= 1;
            arrrectangle[n2].width >>= 1;
            arrrectangle[n2].height >>= 1;
            --n2;
        } while (!bl2);
    }

    private void e() {
        boolean bl2 = i.b;
        this.h = new int[this.g.length];
        this.i = new int[this.g.length];
        e.a(this.n, this.o);
        D d2 = new D();
        for (int i2 = this.n.length - 1; i2 >= 0; --i2) {
            this.h[i2] = this.g[i2].width;
            this.i[i2] = this.g[i2].x;
            d2.add(new o(this.g[i2]));
            if (bl2) return;
            if (!bl2) continue;
        }
        f.a(d2, new m(this));
    }

    private void f() {
        boolean bl2 = i.b;
        int n2 = this.g.length - 1;
        do {
            if (n2 < 0) return;
            Rectangle rectangle = this.g[n2];
            int n3 = rectangle.x;
            int n4 = rectangle.y;
            int n5 = rectangle.width;
            int n6 = rectangle.height;
            rectangle.x = n4;
            rectangle.y = n3;
            rectangle.width = n6;
            rectangle.height = n5;
            --n2;
        } while (!bl2);
    }

    private void a(int[] arrn, int[] arrn2, Rectangle[] arrrectangle) {
        boolean bl2 = i.b;
        int n2 = arrrectangle.length - 1;
        do {
            if (n2 < 0) return;
            arrrectangle[n2].x = arrrectangle[n2].x + arrn[n2] >> 1;
            arrrectangle[n2].y = arrrectangle[n2].y + arrn2[n2] >> 1;
            --n2;
        } while (!bl2);
    }

    private void a(Rectangle[] arrrectangle, int[] arrn, int[] arrn2) {
        boolean bl2 = i.b;
        int n2 = arrrectangle.length - 1;
        do {
            if (n2 < 0) return;
            arrn[n2] = arrrectangle[n2].x;
            arrn2[n2] = arrrectangle[n2].y;
            --n2;
        } while (!bl2);
    }

    private void b(int[] arrn, int[] arrn2, Rectangle[] arrrectangle) {
        boolean bl2 = i.b;
        int n2 = arrrectangle.length - 1;
        do {
            if (n2 < 0) return;
            arrrectangle[n2].x = arrn[n2];
            arrrectangle[n2].y = arrn2[n2];
            --n2;
        } while (!bl2);
    }

    private void g() {
        boolean bl2 = i.b;
        int n2 = this.g.length - 1;
        do {
            if (n2 < 0) return;
            Rectangle rectangle = this.g[n2];
            rectangle.y = - rectangle.y + rectangle.height;
            --n2;
        } while (!bl2);
    }

    /*
     * Unable to fully structure code
     */
    private void h() {
        block26 : {
            var24_1 = i.b;
            var2_2 = Integer.MAX_VALUE;
            var1_3 = Integer.MAX_VALUE;
            var4_4 = Integer.MIN_VALUE;
            var3_5 = Integer.MIN_VALUE;
            for (var5_6 = this.g.length - 1; var5_6 >= 0; --var5_6) {
                v0 = var6_8 = this.g[var5_6];
                if (!var24_1) {
                    if (v0.x < var1_3) {
                        var1_3 = var6_8.x;
                    }
                    if (var6_8.y < var2_2) {
                        var2_2 = var6_8.y;
                    }
                    if (var6_8.x + var6_8.width > var3_5) {
                        var3_5 = var6_8.x + var6_8.width;
                    }
                    if (var6_8.y + var6_8.height <= var4_4) continue;
                    var4_4 = var6_8.y + var6_8.height;
                    if (!var24_1) continue;
                }
                break block26;
            }
            v0 = new Rectangle(var1_3, var2_2, var3_5 - var1_3, var4_4 - var2_2);
        }
        var5_7 = v0;
        var6_8 = new D();
        var7_9 = new p(var5_7.y, var5_7.x - 10, var5_7.x + var5_7.width + 10);
        var6_8.add(var7_9);
        var8_10 = 0;
        do {
            block27 : {
                v1 = var8_10;
                v2 = this.n.length;
                block2 : do lbl-1000: // 3 sources:
                {
                    if (v1 >= v2) return;
                    var9_11 = this.g[this.n[var8_10].d()];
                    var10_12 = var9_11.y;
                    var11_13 = var9_11.x;
                    var12_14 = var9_11.x + var9_11.width;
                    var13_15 = null;
                    var14_16 = null;
                    var15_17 = var5_7.y;
                    for (var16_18 = var6_8.k(); var16_18 != null; var16_18 = var16_18.a()) {
                        var7_9 = (p)var16_18.c();
                        v1 = var11_13;
                        v2 = var7_9.c;
                        if (var24_1) ** GOTO lbl-1000
                        if (v1 >= v2) continue;
                        var13_15 = var16_18;
                        var15_17 = Math.max(var15_17, var7_9.a);
                        break;
                    }
                    while (var16_18 != null) {
                        var7_9 = (p)var16_18.c();
                        var15_17 = Math.max(var15_17, var7_9.a);
                        v1 = var12_14;
                        v2 = var7_9.c;
                        if (var24_1) continue block2;
                        if (v1 <= v2) {
                            var14_16 = var16_18;
                            break block2;
                        }
                        var16_18 = var16_18.a();
                    }
                    break block2;
                    break;
                } while (true);
                if (!this.a(this.n[var8_10]) || var15_17 <= var10_12) ** GOTO lbl110
                var17_19 = var10_12 + var9_11.height;
                var18_20 = new p(var17_19, var11_13, var12_14);
                var19_21 = (p)var13_15.c();
                var20_22 = (p)var14_16.c();
                if (var13_15 != var14_16) ** GOTO lbl77
                if (var19_21.a >= var18_20.a) ** GOTO lbl144
                if (var19_21.b != var11_13 || var19_21.c != var12_14) ** GOTO lbl68
                var13_15.a(var18_20);
                if (!var24_1) ** GOTO lbl144
lbl68: // 2 sources:
                var20_22 = new p(var19_21.a, var12_14, var19_21.c);
                var19_21.c = var11_13;
                var14_16 = var6_8.b(var20_22, var13_15);
                var6_8.b(var18_20, var13_15);
                if (var19_21.c == var19_21.b) {
                    var6_8.h(var13_15);
                }
                if (var20_22.c != var20_22.b) ** GOTO lbl144
                var6_8.h(var14_16);
                if (!var24_1) ** GOTO lbl144
lbl77: // 2 sources:
                var21_23 = var19_21;
                var22_24 = var13_15.a();
                if (var19_21.a < var18_20.a) {
                    var21_23 = new p(var17_19, var11_13, var19_21.c);
                    var6_8.b(var21_23, var13_15);
                    var19_21.c = var11_13;
                }
                if (var20_22.a < var18_20.a) {
                    var6_8.a(new p(var17_19, var20_22.b, var12_14), var14_16);
                    var20_22.b = var12_14;
                }
                for (var16_18 = var22_24; var16_18 != var14_16; var16_18 = var16_18.a()) {
                    var23_25 = (p)var16_18.c();
                    v3 = var23_25.a;
                    v4 = var17_19;
                    if (!var24_1) {
                        if (v3 > v4) {
                            var21_23 = var23_25;
                            if (!var24_1) continue;
                        }
                        var23_25.a = var17_19;
                        if (var21_23.a == var17_19) {
                            var6_8.h(var16_18);
                            var21_23.c = var23_25.c;
                            if (!var24_1) continue;
                        }
                        var21_23 = var23_25;
                        if (!var24_1) continue;
                    }
                    break block27;
                }
                v3 = var19_21.c;
                v4 = var19_21.b;
            }
            if (v3 == v4) {
                var6_8.h(var13_15);
            }
            if (var20_22.c != var20_22.b) ** GOTO lbl144
            var6_8.h(var14_16);
            if (!var24_1) ** GOTO lbl144
lbl110: // 2 sources:
            var4_4 = Math.max(var10_12, var15_17);
            var17_19 = var4_4 + var9_11.height;
            var9_11.y = var4_4;
            var18_20 = new p(var17_19, var11_13, var12_14);
            var19_21 = (p)var13_15.c();
            var20_22 = (p)var14_16.c();
            if (var13_15 != var14_16) ** GOTO lbl-1000
            if (var19_21.b != var11_13 || var19_21.c != var12_14) ** GOTO lbl-1000
            var13_15.a(var18_20);
            if (var24_1) lbl-1000: // 2 sources:
            {
                var20_22 = new p(var19_21.a, var12_14, var19_21.c);
                var19_21.c = var11_13;
                var14_16 = var6_8.b(var20_22, var13_15);
                var6_8.b(var18_20, var13_15);
                if (var19_21.c == var19_21.b) {
                    var6_8.h(var13_15);
                }
                if (var20_22.c == var20_22.b) {
                    var6_8.h(var14_16);
                    ** if (!var24_1) goto lbl144
                }
            }
            ** GOTO lbl144
lbl-1000: // 2 sources:
            {
                block28 : {
                    var19_21.c = var11_13;
                    var20_22.b = var12_14;
                    for (var16_18 = var13_15.a(); var16_18 != var14_16; var16_18 = var16_18.a()) {
                        var6_8.h(var16_18);
                        if (!var24_1) {
                            if (!var24_1) continue;
                        }
                        break block28;
                    }
                    var6_8.b(var18_20, var13_15);
                }
                if (var19_21.c == var19_21.b) {
                    var6_8.h(var13_15);
                }
                if (var20_22.c == var20_22.b) {
                    var6_8.h(var14_16);
                }
            }
lbl144: // 11 sources:
            ++var8_10;
        } while (!var24_1);
    }

    private boolean a(q q2) {
        if (this.q == null) return false;
        return this.q.d(q2);
    }

    public void b(boolean bl2) {
        this.p = bl2;
    }

    static final boolean a(Rectangle rectangle, Rectangle rectangle2) {
        if (rectangle.width <= 0) return false;
        if (rectangle.height <= 0) return false;
        if (rectangle2.width <= 0) return false;
        if (rectangle2.height <= 0) return false;
        if (rectangle2.x < rectangle.x) return false;
        if (rectangle2.x + rectangle2.width > rectangle.x + rectangle.width) return false;
        if (rectangle2.y < rectangle.y) return false;
        if (rectangle2.y + rectangle2.height > rectangle.y + rectangle.height) return false;
        return true;
    }

    static Rectangle[] a(l l2) {
        return l2.g;
    }

    static boolean a(l l2, q q2) {
        return l2.a(q2);
    }

    static byte b(l l2) {
        return l2.f;
    }
}

