package y.h;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.RenderingHints.Key;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import y.h.fj;
import y.h.gG;
import y.h.gH;

public final class gF {
   public static float[] a = new float[2];
   public static float[] b = new float[6];
   public static double[] c = new double[2];
   public static Point2D d = new Double();
   public static AffineTransform e = new AffineTransform();
   private static final Key f = new gG();
   private static final gH[] g = new gH[16];

   public static void a(Graphics2D var0) {
      gH var1;
      label26: {
         boolean var2 = fj.z;
         var1 = (gH)var0.getRenderingHint(f);
         if(var1 == null) {
            var1 = g[9];
            var0.setRenderingHint(f, var1);
            if(!var2) {
               break label26;
            }
         }

         label18: {
            if(var1.a < 7) {
               var1 = g[var1.a + 9];
               if(!var2) {
                  break label18;
               }
            }

            var1 = new gH(var1.a + 1);
         }

         var0.setRenderingHint(f, var1);
      }

      if(var1.a > 0) {
         var0.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
         var0.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
      }

   }

   public static void b(Graphics2D var0) {
      gH var1;
      label26: {
         boolean var2 = fj.z;
         var1 = (gH)var0.getRenderingHint(f);
         if(var1 == null) {
            var1 = g[7];
            var0.setRenderingHint(f, var1);
            if(!var2) {
               break label26;
            }
         }

         label18: {
            if(var1.a > -7) {
               var1 = g[var1.a + 7];
               if(!var2) {
                  break label18;
               }
            }

            var1 = new gH(var1.a - 1);
         }

         var0.setRenderingHint(f, var1);
      }

      if(var1.a <= 0) {
         var0.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
         var0.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
      }

   }

   static {
      for(int var0 = 0; var0 < g.length; ++var0) {
         g[var0] = new gH(var0 - 8);
      }

   }
}
