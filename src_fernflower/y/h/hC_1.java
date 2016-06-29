package y.h;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D.Double;
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
   public final Double g = new Double();
   public final Double h = new Double();
   public final Double i = new Double();
   public final java.awt.geom.Rectangle2D.Double j = new java.awt.geom.Rectangle2D.Double();
   public final java.awt.geom.Rectangle2D.Double k = new java.awt.geom.Rectangle2D.Double();
   public final java.awt.geom.Line2D.Double l = new java.awt.geom.Line2D.Double();
   public final java.awt.geom.Ellipse2D.Double m = new java.awt.geom.Ellipse2D.Double();
   public final double[] n = new double[2];
   public final ib o = new ib();
   public final ib p = new ib();

   public static hC a() {
      return (hC)a.get();
   }
}
