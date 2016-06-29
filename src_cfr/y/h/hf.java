/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Container;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Point2D;
import javax.swing.JComponent;
import y.h.bw;
import y.h.ch;
import y.h.fD;
import y.h.fj;

class hF
implements MouseWheelListener {
    fD a;

    public hF(fD fD2) {
        this.a = fD2;
        fD2.getCanvasComponent().addMouseWheelListener(this);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void mouseWheelMoved(MouseWheelEvent var1_1) {
        block4 : {
            var18_2 = fj.z;
            var2_3 = this.a.tc;
            var3_4 = var1_1.getSource();
            if (var3_4 instanceof bw == false) return;
            var4_5 = (bw)var3_4;
            var5_6 = (ch)var4_5.getParent();
            if (Boolean.TRUE.equals(var5_6.getClientProperty("Overview.AllowZooming")) == false) return;
            var6_7 = var4_5.c(var1_1.getX());
            var8_8 = var4_5.d(var1_1.getY());
            var10_9 = var2_3.getZoom();
            var12_10 = 0;
            if (var1_1.getScrollType() != 1) ** GOTO lbl-1000
            var12_10 = var1_1.getWheelRotation();
            if (var18_2) lbl-1000: // 2 sources:
            {
                if (var1_1.getScrollType() == 0) {
                    var12_10 = var1_1.getUnitsToScroll();
                }
            }
            if (var12_10 == 0) return;
            var13_11 = var2_3.getCenter();
            if (var12_10 > 0) {
                var2_3.setZoom(var10_9 / 1.25);
                if (!var18_2) break block4;
            }
            var2_3.setZoom(var10_9 * 1.25);
        }
        var14_12 = var4_5.c(var1_1.getX());
        var16_13 = var4_5.d(var1_1.getY());
        var6_7 = var13_11.getX() + var6_7 - var14_12;
        var8_8 = var13_11.getY() + var8_8 - var16_13;
        var2_3.setCenter(var6_7, var8_8);
        this.a.adjustWorldRect(var2_3);
        var2_3.updateView();
    }
}

