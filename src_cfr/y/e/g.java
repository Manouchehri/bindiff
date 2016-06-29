/*
 * Decompiled with CFR 0_115.
 */
package y.e;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import y.e.c;
import y.h.bu;
import y.h.ch;

public class g {
    public static byte a = 0;
    public static byte b = 1;
    public static byte c = 0;
    public static byte d = 1;
    public static byte e = 2;
    private byte f = a;
    private byte g = c;
    private int h = 500;
    private int i = 500;
    private int j = 15;
    private bu k;
    private ch l;
    private double m = 1.0;

    /*
     * Unable to fully structure code
     */
    public void a(ch var1_1) {
        var13_2 = c.a;
        var2_3 = this.d();
        var4_4 = this.e();
        var6_5 = var1_1.getViewPoint();
        var7_6 = 1.0;
        if (this.b() != g.a) ** GOTO lbl22
        var9_7 = this.f();
        var10_8 = var9_7.a().getBounds2D();
        var11_9 = (double)this.a() / this.m;
        var10_8.setFrame(var10_8.getX() - var11_9, var10_8.getY() - var11_9, var10_8.getWidth() + 2.0 * var11_9, var10_8.getHeight() + 2.0 * var11_9);
        if (this.c() != g.e) ** GOTO lbl14
        var2_3 = var4_4 * var10_8.getWidth() / var10_8.getHeight();
        if (var13_2 == 0) ** GOTO lbl19
lbl14: // 2 sources:
        if (this.c() != g.d) ** GOTO lbl-1000
        var4_4 = var2_3 * var10_8.getHeight() / var10_8.getWidth();
        if (var13_2 != 0) lbl-1000: // 2 sources:
        {
            var2_3 = var10_8.getWidth();
            var4_4 = var10_8.getHeight();
        }
lbl19: // 4 sources:
        var7_6 = var2_3 / var10_8.getWidth();
        var6_5 = new Point((int)var10_8.getX(), (int)var10_8.getY());
        if (var13_2 == 0) ** GOTO lbl35
lbl22: // 2 sources:
        if (this.b() != g.b) ** GOTO lbl35
        var9_7 = this.g();
        var10_8 = var9_7.getCanvasSize();
        if (this.c() != g.e) ** GOTO lbl28
        var2_3 = var4_4 * var10_8.getWidth() / var10_8.getHeight();
        if (var13_2 == 0) ** GOTO lbl33
lbl28: // 2 sources:
        if (this.c() != g.d) ** GOTO lbl-1000
        var4_4 = var2_3 * var10_8.getHeight() / var10_8.getWidth();
        if (var13_2 != 0) lbl-1000: // 2 sources:
        {
            var2_3 = var10_8.getWidth();
            var4_4 = var10_8.getHeight();
        }
lbl33: // 4 sources:
        var6_5 = var9_7.getViewPoint();
        var7_6 = var9_7.getZoom() * var2_3 / var10_8.getWidth();
lbl35: // 3 sources:
        var1_1.setZoom(var7_6 *= this.m);
        var1_1.setSize((int)(var2_3 *= this.m), (int)(var4_4 *= this.m));
        var1_1.setViewPoint(var6_5.x, var6_5.y);
    }

    public int a() {
        return this.j;
    }

    public void a(byte by2) {
        this.f = by2;
    }

    public byte b() {
        return this.f;
    }

    public void b(byte by2) {
        this.g = by2;
    }

    public byte c() {
        return this.g;
    }

    public int d() {
        return this.h;
    }

    public int e() {
        return this.i;
    }

    public void a(bu bu2) {
        this.k = bu2;
    }

    public bu f() {
        return this.k;
    }

    public ch g() {
        return this.l;
    }
}

