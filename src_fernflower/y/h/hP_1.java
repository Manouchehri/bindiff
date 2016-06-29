package y.h;

import java.util.Iterator;
import y.h.aA;
import y.h.aB;
import y.h.bu;
import y.h.cg;
import y.h.eR;
import y.h.eU;
import y.h.fj;
import y.h.hJ;
import y.h.hK;
import y.h.hN;
import y.h.hQ;

class hP implements cg {
   private cg a;
   private boolean b;

   public hP(cg var1, boolean var2) {
      this.a = var1;
      this.b = var2;
   }

   public Iterator a(bu var1, int var2) {
      return this.a(var1, var2, true);
   }

   public Iterator b(bu var1, int var2) {
      return this.a(var1, var2, false);
   }

   private Iterator a(bu var1, int var2, boolean var3) {
      y.g.A var4 = new y.g.A(this.a(var1, var3), new hJ(this, var1));
      y.g.A var5 = new y.g.A(this.a(var1, var3), new hK(this, var1));
      return new hQ(var1, new hN(var5, var4, var3), var2, var3);
   }

   private Iterator a(bu var1, boolean var2) {
      return var2?this.a.a(var1, 3):this.a.b(var1, 3);
   }

   private boolean a(Object var1, bu var2) {
      return var1 instanceof y.c.q && this.a(var2, (y.c.q)var1) || var1 instanceof y.c.d && this.a(var2, (y.c.d)var1);
   }

   private boolean a(bu var1, y.c.q var2) {
      boolean var3 = var1.v(var2);
      if(!var3 && !this.c(var1, var2) && !this.b(var1, var2)) {
         if(this.b) {
            y.h.a.v var4 = var1.C();
            if(var4 != null) {
               y.c.q var5 = var4.n(var2);
               return var5 != null && this.a(var1, var5);
            }
         }

         return false;
      } else {
         return true;
      }
   }

   private boolean a(bu var1, y.c.d var2) {
      return var1.r(var2) || this.b(var1, var2) || this.a(var1, var2.c()) || this.a(var1, var2.d());
   }

   private boolean b(bu var1, y.c.q var2) {
      boolean var5 = fj.z;
      fj var3 = var1.t(var2);
      boolean var10000;
      if(var3.portCount() > 0) {
         Iterator var4 = var3.ports();

         while(var4.hasNext()) {
            if(((eU)var4.next()).f()) {
               var10000 = true;
               if(!var5) {
                  return true;
               }

               return var10000;
            }
         }
      }

      var10000 = false;
      return var10000;
   }

   private boolean c(bu var1, y.c.q var2) {
      boolean var6 = fj.z;
      fj var3 = var1.t(var2);
      int var4 = 0;

      boolean var10000;
      while(true) {
         if(var4 < var3.labelCount()) {
            eR var5 = var3.getLabel(var4);
            var10000 = var5.isSelected();
            if(var6) {
               break;
            }

            if(var10000) {
               return true;
            }

            ++var4;
            if(!var6) {
               continue;
            }
         }

         var10000 = false;
         break;
      }

      return var10000;
   }

   private boolean b(bu var1, y.c.d var2) {
      boolean var6 = fj.z;
      aB var3 = var1.i(var2);
      int var4 = 0;

      boolean var10000;
      while(true) {
         if(var4 < var3.labelCount()) {
            aA var5 = var3.getLabel(var4);
            var10000 = var5.isSelected();
            if(var6) {
               break;
            }

            if(var10000) {
               return true;
            }

            ++var4;
            if(!var6) {
               continue;
            }
         }

         var10000 = false;
         break;
      }

      return var10000;
   }

   static boolean a(hP var0, Object var1, bu var2) {
      return var0.a(var1, var2);
   }
}
