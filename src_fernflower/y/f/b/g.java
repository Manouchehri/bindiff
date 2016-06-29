package y.f.b;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import y.c.q;
import y.c.y;
import y.d.r;
import y.f.X;
import y.f.ae;
import y.f.b.a;
import y.f.b.f;

public class g implements a {
   private Object a;
   private int b;
   private int c;
   private int d;
   private int e;
   private boolean f;

   public g() {
      this(f.e);
   }

   public g(Object var1) {
      this.a = var1;
      this.b = this.c = this.d = this.e = 15;
   }

   public boolean a() {
      return this.f;
   }

   public Rectangle2D a(X var1, q var2, y var3) {
      Rectangle2D var4 = ae.a(var1, var1.o(), var1.p(), this.a());
      return this.a(var1, var2, var3, var4);
   }

   protected Rectangle2D a(X var1, q var2, y var3, Rectangle2D var4) {
      double var5 = (double)this.b;
      double var7 = (double)this.c;
      double var9 = (double)this.e;
      double var11 = (double)this.d;
      if(this.a != null) {
         y.c.c var13 = var1.c(this.a);
         if(var13 != null) {
            r var14 = r.a(var13.b(var2));
            if(var14 != null) {
               var5 = var14.a;
               var7 = var14.c;
               var11 = var14.b;
               var9 = var14.d;
            }
         }
      }

      Double var15 = new Double();
      var15.setFrame(var4.getX() - var11, var4.getY() - var5, var4.getWidth() + var11 + var9, var4.getHeight() + var5 + var7);
      return var15;
   }
}
