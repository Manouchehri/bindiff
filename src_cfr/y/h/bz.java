/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import y.h.bY;
import y.h.cb;
import y.h.fj;

public class bZ
extends bY {
    /*
     * Unable to fully structure code
     */
    @Override
    void a() {
        var8_1 = fj.z;
        this.f.setFrame(0.0, 0.0, 0.0, 0.0);
        if (this.a == null) return;
        if ("".equals(this.a) != false) return;
        this.e = new TextLayout(this.a, this.b, this.d.b.getFontRenderContext());
        var1_2 = this.e.getBounds().getHeight() + 20.0;
        var3_3 = this.d.a.getPaper();
        if (this.d.a.getOrientation() != 1) ** GOTO lbl11
        this.f = new Rectangle2D.Double(var3_3.getImageableX(), var3_3.getImageableY(), var3_3.getImageableWidth(), var1_2);
        if (!var8_1) ** GOTO lbl20
lbl11: // 2 sources:
        if (this.d.a.getOrientation() != 0) ** GOTO lbl-1000
        var4_4 = var3_3.getHeight() - var3_3.getImageableY() - var3_3.getImageableHeight();
        var6_5 = var3_3.getImageableX();
        this.f = new Rectangle2D.Double(var4_4, var6_5, var3_3.getImageableHeight(), var1_2);
        if (var8_1) lbl-1000: // 2 sources:
        {
            if (this.d.a.getOrientation() == 2) {
                var4_4 = var3_3.getImageableY();
                var6_5 = var3_3.getWidth() - var3_3.getImageableX() - var3_3.getImageableWidth();
                this.f = new Rectangle2D.Double(var4_4, var6_5, var3_3.getImageableHeight(), var1_2);
            }
        }
lbl20: // 6 sources:
        this.f.x -= (double)this.d.d * this.f.width;
        this.f.y -= (double)this.d.e * var3_3.getImageableHeight();
        this.f.width *= (double)this.d.g;
    }
}

