/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import y.h.hD;
import y.h.hE;
import y.h.ib;

class hC {
    static final ThreadLocal a = new hD();
    public final AffineTransform b = new AffineTransform();
    public final float[] c = new float[6];
    public final JEditorPane d = new JEditorPane("text/html", "");
    public final JLabel e = new hE();
    public final JPanel f = new JPanel();
    public final Point2D.Double g = new Point2D.Double();
    public final Point2D.Double h = new Point2D.Double();
    public final Point2D.Double i = new Point2D.Double();
    public final Rectangle2D.Double j = new Rectangle2D.Double();
    public final Rectangle2D.Double k = new Rectangle2D.Double();
    public final Line2D.Double l = new Line2D.Double();
    public final Ellipse2D.Double m = new Ellipse2D.Double();
    public final double[] n = new double[2];
    public final ib o = new ib();
    public final ib p = new ib();

    public static hC a() {
        return (hC)a.get();
    }

    hC() {
    }
}

