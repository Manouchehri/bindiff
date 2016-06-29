/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import y.h.az;
import y.h.cV;
import y.h.ch;
import y.h.fj;
import y.h.hk;

public class gW
implements az {
    protected ch a;
    protected az b;

    public gW(ch ch2, az az2) {
        this.a = ch2;
        this.b = az2;
    }

    @Override
    public Rectangle getBounds() {
        Rectangle rectangle = this.a();
        Point2D point2D = this.a.getViewPoint2D();
        double d2 = 1.0 / this.a.getZoom();
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(point2D.getX(), point2D.getY());
        affineTransform.scale(d2, d2);
        return affineTransform.createTransformedShape(rectangle).getBounds();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void a(Graphics2D var1_1) {
        var2_2 = var1_1.getTransform();
        var3_3 = hk.a(var1_1);
        if (var3_3 == null || var3_3.a() == null) ** GOTO lbl-1000
        var1_1.setTransform(var3_3.a());
        if (fj.z) lbl-1000: // 2 sources:
        {
            var4_4 = this.a.getViewPoint2D();
            var5_5 = 1.0 / this.a.getZoom();
            var1_1.translate(var4_4.getX(), var4_4.getY());
            var1_1.scale(var5_5, var5_5);
        }
        this.b(var1_1);
        var1_1.setTransform(var2_2);
    }

    protected void b(Graphics2D graphics2D) {
        this.b.a(graphics2D);
    }

    protected Rectangle a() {
        return this.b.getBounds();
    }
}

