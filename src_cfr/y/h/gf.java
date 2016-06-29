/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import y.h.fj;
import y.h.gG;
import y.h.gH;

public final class gF {
    public static float[] a = new float[2];
    public static float[] b = new float[6];
    public static double[] c = new double[2];
    public static Point2D d = new Point2D.Double();
    public static AffineTransform e = new AffineTransform();
    private static final RenderingHints.Key f = new gG();
    private static final gH[] g = new gH[16];

    /*
     * Unable to fully structure code
     */
    public static void a(Graphics2D var0) {
        var2_1 = fj.z;
        var1_2 = (gH)var0.getRenderingHint(gF.f);
        if (var1_2 != null) ** GOTO lbl-1000
        var1_2 = gF.g[9];
        var0.setRenderingHint(gF.f, var1_2);
        if (var2_1) lbl-1000: // 2 sources:
        {
            block3 : {
                if (var1_2.a < 7) {
                    var1_2 = gF.g[var1_2.a + 9];
                    if (!var2_1) break block3;
                }
                var1_2 = new gH(var1_2.a + 1);
            }
            var0.setRenderingHint(gF.f, var1_2);
        }
        if (var1_2.a <= 0) return;
        var0.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        var0.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    }

    /*
     * Unable to fully structure code
     */
    public static void b(Graphics2D var0) {
        var2_1 = fj.z;
        var1_2 = (gH)var0.getRenderingHint(gF.f);
        if (var1_2 != null) ** GOTO lbl-1000
        var1_2 = gF.g[7];
        var0.setRenderingHint(gF.f, var1_2);
        if (var2_1) lbl-1000: // 2 sources:
        {
            block3 : {
                if (var1_2.a > -7) {
                    var1_2 = gF.g[var1_2.a + 7];
                    if (!var2_1) break block3;
                }
                var1_2 = new gH(var1_2.a - 1);
            }
            var0.setRenderingHint(gF.f, var1_2);
        }
        if (var1_2.a > 0) return;
        var0.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        var0.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
    }

    static {
        int n2 = 0;
        while (n2 < g.length) {
            gF.g[n2] = new gH(n2 - 8);
            ++n2;
        }
    }
}

