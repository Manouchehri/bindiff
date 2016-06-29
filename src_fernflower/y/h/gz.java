package y.h;

import java.awt.geom.Point2D.Double;
import y.h.az;
import y.h.e;
import y.h.gA;
import y.h.gB;
import y.h.gC;

public abstract class gz implements Comparable {
   private double a;
   private az c;
   private Object d;
   public static final gz b = new gB(0.0D, new gA());

   protected gz(double var1) {
      this(var1, (az)null);
   }

   protected gz(double var1, az var3) {
      this(var1, var3, (Object)null);
   }

   protected gz(double var1, az var3, Object var4) {
      this.a = var1;
      this.c = var3 != null?var3:b.a((e)null, (y.d.t)null);
      this.d = var4;
   }

   public Object a() {
      return this.d;
   }

   public double b() {
      return this.a;
   }

   public abstract byte a(y.d.t var1, Double var2, byte var3);

   public abstract boolean a(y.d.t var1, y.d.t var2, byte var3);

   public int compareTo(Object var1) {
      gz var2 = (gz)var1;
      return y.g.e.a(this.b(), var2.b());
   }

   public az a(e var1, y.d.t var2) {
      return this.c;
   }

   public static gz a(double var0, az var2, boolean var3, double var4) {
      return new gC(var0, var2, var3, var4, (Object)null);
   }

   public static gz a(double var0, az var2, boolean var3, double var4, Object var6) {
      return new gC(var0, var2, var3, var4, var6);
   }
}
