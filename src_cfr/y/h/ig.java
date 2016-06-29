/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Point;
import javax.swing.JComponent;
import y.h.fj;

class ig
implements LayoutManager {
    static final Object a = "LayoutManager.CENTER_KEY";
    static final Object b = "LayoutManager.LOCATION_KEY";
    static final Object c = "LayoutManager.DIMENSION_KEY";

    ig() {
    }

    @Override
    public void addLayoutComponent(String string, Component component) {
    }

    @Override
    public void removeLayoutComponent(Component component) {
    }

    @Override
    public Dimension preferredLayoutSize(Container container) {
        return new Dimension(1, 1);
    }

    @Override
    public Dimension minimumLayoutSize(Container container) {
        return new Dimension(1, 1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    @Override
    public void layoutContainer(Container var1_1) {
        block5 : {
            var13_2 = fj.z;
            var2_3 = var1_1.getTreeLock();
            // MONITORENTER : var2_3
            for (var3_4 = 0; var3_4 < var1_1.getComponentCount(); ++var3_4) {
                v0 = var4_5 = var1_1.getComponent(var3_4);
                if (var13_2) break block5;
                if (!(v0 instanceof JComponent) || !((var6_7 = (var5_6 = (JComponent)var4_5).getClientProperty(ig.b)) instanceof Point)) continue;
                var7_8 = (Point)var6_7;
                var8_9 = (Dimension)var5_6.getClientProperty(ig.c);
                var9_10 = var4_5.getPreferredSize();
                if (var8_9 == null) ** GOTO lbl-1000
                var9_10.width = var8_9.width = Math.max(var9_10.width, var8_9.width);
                var9_10.height = var8_9.height = Math.max(var9_10.height, var8_9.height);
                if (var13_2) lbl-1000: // 2 sources:
                {
                    var8_9 = var9_10;
                    var5_6.putClientProperty(ig.c, var8_9);
                }
                if (!var4_5.isVisible()) continue;
                if (Boolean.TRUE.equals(var5_6.getClientProperty(ig.a))) {
                    var10_11 = var7_8.x - var9_10.width / 2;
                    var11_12 = var7_8.y - var9_10.height / 2;
                    var4_5.setBounds(var10_11, var11_12, var9_10.width, var9_10.height);
                    if (!var13_2) continue;
                }
                var4_5.setBounds(var7_8.x, var7_8.y, var9_10.width, var9_10.height);
                if (!var13_2) continue;
            }
            v0 = var2_3;
        }
        // MONITOREXIT : v0
    }
}

