/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import y.c.C;
import y.c.d;
import y.c.e;
import y.c.i;
import y.c.q;
import y.c.x;
import y.e.a;
import y.h.a.v;
import y.h.aB;
import y.h.bu;
import y.h.eR;
import y.h.fj;
import y.h.gn;
import y.h.hk;

public class bV
extends gn {
    private bu a;
    private boolean b;
    private boolean c;
    private boolean d;

    public bV() {
        this.h();
    }

    public bV(fj fj2) {
        super(fj2);
        if (fj2 instanceof bV) {
            bV bV2 = (bV)fj2;
            this.a = bV2.a;
            this.b = bV2.b;
            this.c = bV2.c;
            this.d = bV2.d;
            if (!fj.z) return;
        }
        this.h();
    }

    private void h() {
        this.b = true;
        this.c = false;
        this.d = true;
    }

    public boolean a() {
        return this.d;
    }

    public boolean e() {
        return this.c;
    }

    public boolean f() {
        return this.b;
    }

    public bu g() {
        if (this.a != null) {
            return this.a;
        }
        try {
            i i2 = this.getNode().e();
            v v2 = v.a(i2);
            return (bu)v2.m(this.getNode());
        }
        catch (Exception var1_2) {
            return null;
        }
    }

    @Override
    protected void paintNode(Graphics2D graphics2D) {
        super.paintNode(graphics2D);
        if (!this.f()) return;
        this.a(graphics2D);
    }

    @Override
    public void paintSloppy(Graphics2D graphics2D) {
        if (this.b()) {
            return;
        }
        super.paintSloppy(graphics2D);
        if (!this.f()) return;
        Double d2 = (Double)graphics2D.getRenderingHint(hk.y);
        if (d2 == null) return;
        if (d2 >= Double.MAX_VALUE) return;
        this.a(graphics2D);
    }

    /*
     * Unable to fully structure code
     */
    protected void a(Graphics2D var1_1) {
        block19 : {
            var27_2 = fj.z;
            var2_3 = this.g();
            if (var2_3 == null) {
                return;
            }
            var3_4 = 10.0;
            var5_5 = this.getHeight() - var3_4 * 2.0;
            var7_6 = this.getWidth() - var3_4 * 2.0;
            var9_7 = this.getCenterX();
            var11_8 = this.getCenterY();
            var13_9 = this.getLabel();
            block0 : switch (var13_9.getModel()) {
                case 1: {
                    switch (var13_9.getPosition()) {
                        case 102: {
                            var5_5 -= var13_9.getHeight();
                            var11_8 += var13_9.getHeight() / 2.0;
                            if (!var27_2) break block0;
                        }
                        case 101: {
                            var5_5 -= var13_9.getHeight();
                            var11_8 -= var13_9.getHeight() / 2.0;
                            if (!var27_2) break block0;
                        }
                        case 115: {
                            var7_6 -= var13_9.getWidth();
                            var9_7 += var13_9.getWidth() / 2.0;
                            if (!var27_2) break block0;
                        }
                        case 116: {
                            var7_6 -= var13_9.getWidth();
                            var9_7 -= var13_9.getWidth() / 2.0;
                        }
                    }
                }
            }
            if (var7_6 <= 5.0) return;
            if (var5_5 <= 5.0) {
                return;
            }
            var14_10 = null;
            var15_11 = 1.0;
            var17_12 = 1.0;
            var19_13 = 1.0;
            var21_14 = var1_1.getTransform();
            if (this.e()) {
                var14_10 = var1_1.getClip();
                var1_1.clip(new Rectangle2D.Double(this.getX(), this.getY(), var7_6, var5_5));
            }
            var1_1.translate(var9_7, var11_8);
            if (this.a()) {
                var22_15 = var2_3.a();
                var15_11 = var7_6 / var22_15.getWidth();
                var17_12 = var5_5 / var22_15.getHeight();
                var19_13 = Math.min(var15_11, var17_12);
                var1_1.scale(var19_13, var19_13);
                var1_1.translate(- var22_15.getCenterX(), - var22_15.getCenterY());
            }
            var22_16 = var19_13 * var21_14.getScaleX();
            var24_17 = (Double)var1_1.getRenderingHint(hk.y);
            if (var24_17 != null && var22_16 <= var24_17) ** GOTO lbl66
            var25_18 = var2_3.o();
            while (var25_18.f()) {
                var26_19 = var2_3.t(var25_18.e());
                var26_19.paint(var1_1);
                var25_18.g();
                if (!var27_2) {
                    if (!var27_2) continue;
                }
                break block19;
            }
            var25_18 = var2_3.p();
            block10 : while (var25_18.f()) {
                var26_19 = var2_3.i(var25_18.a());
                var26_19.paint(var1_1);
                var25_18.g();
                if (var27_2 != false) return;
                if (!var27_2) continue;
lbl66: // 2 sources:
                if (var24_17 != null && 4.0 * var22_16 <= var24_17) break;
                var25_18 = var2_3.o();
                while (var25_18.f()) {
                    var26_19 = var2_3.t(var25_18.e());
                    var26_19.paintSloppy(var1_1);
                    var25_18.g();
                    if (var27_2) break block10;
                    if (!var27_2) continue;
                }
                var25_18 = var2_3.p();
                while (var25_18.f()) {
                    var26_19 = var2_3.i(var25_18.a());
                    var26_19.paintSloppy(var1_1);
                    var25_18.g();
                    if (var27_2 != false) return;
                    if (!var27_2) continue;
                }
                break block10;
            }
        }
        if (this.e()) {
            var1_1.setClip(var14_10);
        }
        var1_1.setTransform(var21_14);
    }

    @Override
    public fj createCopy(fj fj2) {
        return new bV(fj2);
    }

    @Override
    public void write(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeByte(0);
        super.write(objectOutputStream);
        objectOutputStream.writeBoolean(this.b);
        objectOutputStream.writeBoolean(this.c);
        objectOutputStream.writeBoolean(this.d);
    }

    @Override
    public void read(ObjectInputStream objectInputStream) {
        switch (objectInputStream.readByte()) {
            case 0: {
                super.read(objectInputStream);
                this.b = objectInputStream.readBoolean();
                this.c = objectInputStream.readBoolean();
                this.d = objectInputStream.readBoolean();
                if (!fj.z) return;
            }
        }
        throw new a();
    }
}

