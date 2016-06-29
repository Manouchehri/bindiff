package y.h;

import javax.swing.*;
import java.awt.geom.*;

class hC
{
    static final ThreadLocal a;
    public final AffineTransform b;
    public final float[] c;
    public final JEditorPane d;
    public final JLabel e;
    public final JPanel f;
    public final Point2D.Double g;
    public final Point2D.Double h;
    public final Point2D.Double i;
    public final Rectangle2D.Double j;
    public final Rectangle2D.Double k;
    public final Line2D.Double l;
    public final Ellipse2D.Double m;
    public final double[] n;
    public final ib o;
    public final ib p;
    
    public static hC a() {
        return hC.a.get();
    }
    
    hC() {
        this.b = new AffineTransform();
        this.c = new float[6];
        this.d = new JEditorPane("text/html", "");
        this.e = new hE();
        this.f = new JPanel();
        this.g = new Point2D.Double();
        this.h = new Point2D.Double();
        this.i = new Point2D.Double();
        this.j = new Rectangle2D.Double();
        this.k = new Rectangle2D.Double();
        this.l = new Line2D.Double();
        this.m = new Ellipse2D.Double();
        this.n = new double[2];
        this.o = new ib();
        this.p = new ib();
    }
    
    static {
        a = new hD();
    }
}
