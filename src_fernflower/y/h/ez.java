package y.h;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import y.h.dV;
import y.h.eA;
import y.h.eB;
import y.h.fj;

abstract class ez {
   public void a(y.f.X var1, Collection var2, Rectangle2D var3, boolean var4) {
      boolean var17 = fj.z;
      ArrayList var5 = new ArrayList(var2.size() * 2);
      Iterator var6 = var2.iterator();

      double var13;
      double var15;
      while(true) {
         if(var6.hasNext()) {
            y.c.q var7 = (y.c.q)var6.next();
            y.f.am var8 = var1.a((Object)var7);
            if(var17) {
               break;
            }

            if(var3 != null && !var3.intersects(var8.getX(), var8.getY(), var8.getWidth(), var8.getHeight())) {
               continue;
            }

            double var9;
            double var11;
            label66: {
               if(var4) {
                  var9 = var8.getX();
                  var11 = var9 + var8.getWidth();
                  var13 = var8.getY();
                  var15 = var13 + var8.getHeight();
                  if(!var17) {
                     break label66;
                  }
               }

               var9 = var8.getY();
               var11 = var9 + var8.getHeight();
               var13 = var8.getX();
               var15 = var13 + var8.getWidth();
            }

            var5.add(new eA(var9, var7, true, var13, var15));
            var5.add(new eA(var11, var7, false, var13, var15));
            if(!var17) {
               continue;
            }
         }

         y.g.e.a((List)var5, (Comparator)null);
         break;
      }

      y.g.ai var18 = new y.g.ai();
      var18.a((Object)(new eB(-1.7976931348623157E308D, (y.c.q)null, (dV)null)));
      var18.a((Object)(new eB(Double.MAX_VALUE, (y.c.q)null, (dV)null)));
      Iterator var19 = var5.iterator();

      label54:
      while(true) {
         int var10000 = var19.hasNext();

         y.g.aj var10;
         eA var20;
         eB var21;
         y.g.aj var22;
         label51:
         while(true) {
            if(var10000 == 0) {
               return;
            }

            var20 = (eA)var19.next();
            var21 = new eB(var20.d, var20.b, (dV)null);
            var10 = var18.b((Object)var21);
            var22 = var10;
            if(!var20.c) {
               break;
            }

            while(true) {
               if(var22 == null) {
                  continue label54;
               }

               double var25;
               var10000 = (var25 = ((eB)var22.c()).a - var20.e) == 0.0D?0:(var25 < 0.0D?-1:1);
               if(var17) {
                  break;
               }

               if(var10000 >= 0) {
                  continue label54;
               }

               eB var12 = (eB)var22.c();
               if(var12.b != null) {
                  var13 = Math.max(var20.d, var12.a);
                  var15 = Math.min(var20.e, ((eB)var22.a().c()).a);
                  this.a(var20.b, var12.b, var4, var13, var15);
               }

               var22 = var22.a();
               if(var17) {
                  break label51;
               }
            }
         }

         var22 = var18.b((Object)(new eB(var20.e, var20.b, (dV)null)));
         y.c.q var23 = ((eB)var22.c()).b;
         y.g.aj var24 = var18.a((y.g.aj)var10, (Object)var21);
         if(var10 == var22) {
            var22 = var24;
         }

         y.g.aj var14 = var18.a((y.g.aj)var22, (Object)(new eB(var20.e, var23, (dV)null)));
         if(var24.a() != var14) {
            var18.a(var24.a(), var14.b());
            if(var17) {
               return;
            }
         }
      }
   }

   protected abstract void a(y.c.q var1, y.c.q var2, boolean var3, double var4, double var6);
}
