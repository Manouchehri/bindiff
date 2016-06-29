package y.f;

import java.util.Map;
import y.f.C;
import y.f.D;
import y.f.I;
import y.f.X;
import y.f.aj;
import y.f.ak;
import y.f.am;
import y.f.w;

public class Y implements y.g.C {
   private static final y.g.C a = new y.c.k();

   public y.c.q a(y.c.i var1, y.c.q var2) {
      y.c.i var3 = var2.e();
      if(var3 instanceof X) {
         X var4 = (X)var3;
         am var5 = var4.h(var2);
         y.c.q var6 = var1.d();
         X var7 = (X)var1;
         am var8 = var7.h(var6);
         var8.setSize(var5.getWidth(), var5.getHeight());
         var8.setLocation(var5.getX(), var5.getY());
         this.a(var4, var2, var7, var6);
         return var6;
      } else {
         return a.a(var1, var2);
      }
   }

   protected void a(X var1, y.c.q var2, X var3, y.c.q var4) {
      boolean var10 = X.j;
      if(var3 instanceof w) {
         aj[] var5 = var1.i(var2);
         w var6 = (w)var3;
         aj[] var7 = new aj[var5.length];
         int var8 = 0;

         while(var8 < var5.length) {
            aj var9 = var5[var8];
            var7[var8] = this.a(var9);
            ++var8;
            if(var10) {
               return;
            }

            if(var10) {
               break;
            }
         }

         var6.a(var4, var7);
      }

   }

   protected aj a(aj var1) {
      ak var2 = new ak();
      var2.a(var1.a());
      var2.setModelParameter(var1.getModelParameter());
      var2.a(var1.getOrientedBox());
      return var2;
   }

   public y.c.d a(y.c.i var1, y.c.q var2, y.c.q var3, y.c.d var4) {
      boolean var13 = X.j;
      y.c.i var5 = var4.a();
      if(!(var5 instanceof X)) {
         return a.a(var1, var2, var3, var4);
      } else {
         X var6 = (X)var1;
         y.c.d var7 = var6.a((y.c.q)var2, (y.c.q)var3);
         I var8 = var6.g(var7);
         X var9 = (X)var5;
         I var10 = var9.g(var4);
         var8.setSourcePoint(var10.getSourcePoint());
         var8.setTargetPoint(var10.getTargetPoint());
         int var11 = 0;

         while(true) {
            if(var11 < var10.pointCount()) {
               y.d.t var12 = var10.getPoint(var11);
               var8.addPoint(var12.a(), var12.b());
               ++var11;
               if(var13) {
                  break;
               }

               if(!var13) {
                  continue;
               }
            }

            this.a(var9, var4, var6, var7);
            break;
         }

         return var7;
      }
   }

   protected void a(X var1, y.c.d var2, X var3, y.c.d var4) {
      boolean var10 = X.j;
      if(var3 instanceof w) {
         C[] var5 = var1.h(var2);
         w var6 = (w)var3;
         C[] var7 = new C[var5.length];
         int var8 = 0;

         while(var8 < var5.length) {
            C var9 = var5[var8];
            var7[var8] = this.a(var9);
            ++var8;
            if(var10) {
               return;
            }

            if(var10) {
               break;
            }
         }

         var6.a(var4, var7);
      }

   }

   protected C a(C var1) {
      D var2 = new D();
      var2.a(var1.getLabelModel());
      var2.setModelParameter(var1.getModelParameter());
      var2.a(var1.getPreferredPlacementDescriptor());
      var2.a((y.d.n)var1.getOrientedBox());
      return var2;
   }

   public void a(y.c.i var1, y.c.i var2) {
   }

   public void a(y.c.i var1, y.c.i var2, Map var3, Map var4) {
   }
}
