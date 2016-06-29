package y.f.k;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.Iterator;
import java.util.List;
import y.f.k.P;
import y.f.k.d;
import y.f.k.e;
import y.f.k.f;
import y.f.k.g;
import y.f.k.h;
import y.f.k.i;
import y.f.k.j;
import y.f.k.k;

public abstract class m {
   public static final m a = new e();
   public static final m b = new f();
   public static final m c = new g();
   public static final m d = new h();
   public static final m e = new i();
   public static final m f = new j();
   public static final m g = new k();
   public static final m[] h;

   final void a(P var1, List var2, double var3) {
      this.a(var1, var2, a(var2), var3);
   }

   protected abstract void a(P var1, List var2, Rectangle2D var3, double var4);

   protected static Rectangle2D a(List var0) {
      int var12 = d.g;
      Double var1 = new Double(java.lang.Double.MAX_VALUE, java.lang.Double.MAX_VALUE, 0.0D, 0.0D);
      Iterator var2 = var0.iterator();

      Double var10000;
      while(true) {
         if(var2.hasNext()) {
            P var3 = (P)var2.next();
            double var4 = var3.f();
            if(var4 < var1.x) {
               var1.x = var4;
            }

            double var6 = var3.g();
            if(var6 < var1.y) {
               var1.y = var6;
            }

            double var8 = var3.e();
            if(var8 > var1.x + var1.width) {
               var1.width = var8 - var1.x;
            }

            double var10 = var3.d();
            if(var10 <= var1.y + var1.height) {
               continue;
            }

            var10000 = var1;
            if(var12 != 0) {
               break;
            }

            var1.height = var10 - var1.y;
            if(var12 == 0) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000;
   }

   static {
      h = new m[]{a, g, c, e, f, d};
   }
}
