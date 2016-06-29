package y.g;

import java.awt.geom.Point2D;
import y.g.V;
import y.g.an;
import y.g.x;

public class w implements V {
   private double a;
   private double b;

   protected w(double var1, double var3) {
      this.a = var1;
      this.b = var3;
   }

   public double a() {
      return this.a;
   }

   public double b() {
      return this.b;
   }

   public static w a(double var0, double var2) {
      return new w(var0, var2);
   }

   public static an a(Point2D var0) {
      return new x(var0);
   }
}
