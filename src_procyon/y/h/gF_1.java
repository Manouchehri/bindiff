package y.h;

import java.awt.geom.*;
import java.awt.*;

public final class gF
{
    public static float[] a;
    public static float[] b;
    public static double[] c;
    public static Point2D d;
    public static AffineTransform e;
    private static final RenderingHints.Key f;
    private static final gH[] g;
    
    public static void a(final Graphics2D graphics2D) {
        final boolean z = fj.z;
        gH gh = (gH)graphics2D.getRenderingHint(gF.f);
        Label_0085: {
            if (gh == null) {
                gh = gF.g[9];
                graphics2D.setRenderingHint(gF.f, gh);
                if (!z) {
                    break Label_0085;
                }
            }
            Label_0077: {
                if (gh.a < 7) {
                    gh = gF.g[gh.a + 9];
                    if (!z) {
                        break Label_0077;
                    }
                }
                gh = new gH(gh.a + 1);
            }
            graphics2D.setRenderingHint(gF.f, gh);
        }
        if (gh.a > 0) {
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        }
    }
    
    public static void b(final Graphics2D graphics2D) {
        final boolean z = fj.z;
        gH gh = (gH)graphics2D.getRenderingHint(gF.f);
        Label_0085: {
            if (gh == null) {
                gh = gF.g[7];
                graphics2D.setRenderingHint(gF.f, gh);
                if (!z) {
                    break Label_0085;
                }
            }
            Label_0077: {
                if (gh.a > -7) {
                    gh = gF.g[gh.a + 7];
                    if (!z) {
                        break Label_0077;
                    }
                }
                gh = new gH(gh.a - 1);
            }
            graphics2D.setRenderingHint(gF.f, gh);
        }
        if (gh.a <= 0) {
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        }
    }
    
    static {
        gF.a = new float[2];
        gF.b = new float[6];
        gF.c = new double[2];
        gF.d = new Point2D.Double();
        gF.e = new AffineTransform();
        f = new gG();
        g = new gH[16];
        for (int i = 0; i < gF.g.length; ++i) {
            gF.g[i] = new gH(i - 8);
        }
    }
}
