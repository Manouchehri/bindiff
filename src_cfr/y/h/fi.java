/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.ImageObserver;
import java.awt.image.Kernel;
import y.h.bw;
import y.h.ch;
import y.h.fD;
import y.h.fF;
import y.h.fj;

final class fI
extends bw {
    private BufferedImage f;
    private BufferedImage g;
    private ConvolveOp h;
    private final fD i;

    private boolean F() {
        if (this.h == null) {
            int n2 = 5;
            double d2 = 0.9;
            Object object = this.i.getClientProperty("Overview.funkyTheta");
            if (object instanceof Number) {
                d2 = ((Number)object).doubleValue();
            }
            float[] arrf = fD.access$100(d2, n2);
            this.h = new ConvolveOp(new Kernel(n2, n2, arrf));
        }
        if (this.f != null && this.getWidth() == this.f.getWidth()) {
            if (this.getHeight() == this.f.getHeight()) return false;
        }
        if (!fD.access$200()) {
            this.f = new BufferedImage(this.getWidth(), this.getHeight(), 1);
            this.g = new BufferedImage(this.getWidth(), this.getHeight(), 1);
            if (!fj.z) return true;
        }
        this.f = new BufferedImage(this.getWidth(), this.getHeight(), 2);
        this.g = new BufferedImage(this.getWidth(), this.getHeight(), 2);
        return true;
    }

    public fI(fD fD2, ch ch2) {
        super(ch2);
        this.i = fD2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    @Override
    public void paintComponent(Graphics var1_1) {
        if (this.F() || this.i.xc) {
            var2_2 = this.g;
            var3_3 = this.f;
            var4_4 = (Color)this.i.getClientProperty("Overview.FogColor");
            if (var4_4 == null) {
                var4_4 = new Color(0.85f, 0.85f, 0.85f, 0.6f);
            }
            if (this.i.xc) {
                this.i();
                this.i.xc = false;
            }
            var5_6 = var3_3.createGraphics();
            try {
                var5_6.setColor(this.getBackground());
                var5_6.clearRect(0, 0, this.getWidth(), this.getHeight());
                var5_6.setClip(0, 0, this.getWidth(), this.getHeight());
                super.paintComponent(var5_6);
            }
            finally {
                var5_6.dispose();
            }
            if ("Funky".equals(this.i.getClientProperty("Overview.PaintStyle")) && !fD.access$200()) {
                this.h.filter(this.f, this.g);
                var5_6 = var2_2.createGraphics();
                try {
                    var5_6.setColor(var4_4);
                    var5_6.fillRect(0, 0, this.getWidth(), this.getHeight());
                }
                finally {
                    var5_6.dispose();
                }
            }
            var5_6 = var2_2.createGraphics();
            try {
                var5_6.drawImage(this.f, 0, 0, null);
                var5_6.setColor(var4_4);
                var5_6.fillRect(0, 0, this.getWidth(), this.getHeight());
            }
            finally {
                var5_6.dispose();
            }
        }
        if (this.i.xc) {
            this.i();
            this.i.xc = false;
        }
        if (!Boolean.TRUE.equals(this.i.getClientProperty("Overview.Inverse"))) ** GOTO lbl-1000
        var2_2 = this.f;
        var3_3 = this.g;
        if (fj.z) lbl-1000: // 2 sources:
        {
            var2_2 = this.g;
            var3_3 = this.f;
        }
        var1_1.drawImage(var3_3, 0, 0, null);
        var4_5 = this.e(fF.a((fF)this.i.wc).x);
        var5_7 = this.f(fF.a((fF)this.i.wc).y);
        var6_9 = Math.max(0, var4_5);
        var7_11 = Math.max(0, var5_7);
        var8_13 = this.e(fF.a(this.i.wc).getMaxX());
        var9_14 = this.f(fF.a(this.i.wc).getMaxY());
        var10_15 = Math.min(this.getWidth(), var8_13);
        var11_16 = Math.min(this.getHeight(), var9_14);
        if (var10_15 < var6_9) return;
        if (var11_16 < var7_11) return;
        var1_1.drawImage(var2_2, var6_9, var7_11, var10_15, var11_16, var6_9, var7_11, var10_15, var11_16, null);
        var12_17 = (Color)this.i.getClientProperty("Overview.BorderColor");
        if (var12_17 == null) {
            var12_17 = Color.lightGray;
        }
        var1_1.setColor(var12_17);
        var1_1.drawRect(var4_5, var5_7, var8_13 - var4_5, var9_14 - var5_7);
        if (Boolean.TRUE.equals(this.i.getClientProperty("Overview.AllowZooming")) == false) return;
        var1_1.setColor(Color.darkGray);
        var1_1.fillRect(var8_13 - 1, var9_14 - 1, 3, 3);
    }
}

