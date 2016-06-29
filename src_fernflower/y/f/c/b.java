package y.f.c;

import y.f.c.a;
import y.f.c.v;

public class b implements v {
   public static final Object a = "y.layout.hierarchic.AlignmentDrawer.NODE_ALIGNMENT_POINT_DPKEY";
   private v b;

   public b(v var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b = var1;
      }
   }

   protected void a(y.f.X var1, y.c.y[] var2) {
      boolean var22 = a.i;
      double var3 = 0.0D;
      int var5 = 0;

      label39:
      while(var5 < var2.length) {
         y.c.x var6 = var2[var5].a();
         double var7 = 0.0D;
         double var9 = 0.0D;
         double var11 = Double.MAX_VALUE;
         double var13 = -1.7976931348623157E308D;
         var6.i();

         double var17;
         while(var6.f()) {
            y.c.q var15 = var6.e();
            y.f.am var16 = var1.a((Object)var15);
            var11 = Math.min(var11, var16.getY());
            var13 = Math.max(var13, var16.getY() + var16.getHeight());
            var17 = a(var15);
            var7 = Math.max(var7, var16.getHeight() * 0.5D + var17);
            var9 = Math.max(var9, var16.getHeight() * 0.5D - var17);
            var6.g();
            if(var22) {
               continue label39;
            }

            if(var22) {
               break;
            }
         }

         double var23 = var7 + var9;
         var17 = var11 + var3 + var7;
         var6.i();

         while(true) {
            if(var6.f()) {
               y.c.q var19 = var6.e();
               double var20 = a(var19);
               var1.a(var19, var1.j(var19), var17 - var20);
               var6.g();
               if(var22) {
                  break;
               }

               if(!var22) {
                  continue;
               }
            }

            var3 += var23 - (var13 - var11);
            ++var5;
            break;
         }

         if(var22) {
            break;
         }
      }

   }

   private static final double a(y.c.q var0) {
      y.c.c var1 = var0.e().c(a);
      return var1 == null?0.0D:var1.c(var0);
   }

   public void a(y.f.X var1, y.c.y[] var2, y.c.c var3) {
      this.b.a(var1, var2, var3);
      this.a(var1, var2);
   }

   public void a(y.c.A var1) {
      this.b.a(var1);
   }

   public void a(double var1) {
      this.b.a(var1);
   }

   public void d(double var1) {
      this.b.d(var1);
   }

   public void b(double var1) {
      this.b.b(var1);
   }

   public void c(double var1) {
      this.b.c(var1);
   }
}
