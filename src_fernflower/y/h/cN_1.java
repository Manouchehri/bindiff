package y.h;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.AbstractAction;
import y.h.bu;
import y.h.ch;
import y.h.cm;
import y.h.fj;
import y.h.hV;

class cN extends AbstractAction {
   ch a;
   boolean b;

   public cN(ch var1, boolean var2) {
      this.a = var1;
      this.b = var2;
   }

   public void actionPerformed(ActionEvent var1) {
      ch var2 = this.a(var1);
      if(var2 != null) {
         this.a(var2);
         var2.getGraph2D().T();
      }

   }

   public void a(ch var1) {
      bu var2 = var1.getGraph2D();
      y.c.y var3 = this.a(var2);
      if(!var3.isEmpty()) {
         var2.r();

         try {
            y.c.y var4 = this.a(var2, var3);
            this.a(var2, var4, var3);
            this.b(var2, var4, var3);
         } finally {
            var2.s();
         }

         var1.updateWorldRect();
         var1.updateView();
      }

   }

   protected y.c.y a(bu var1, y.c.y var2) {
      boolean var14 = fj.z;
      y.c.y var3 = new y.c.y();
      if(var2.size() > 0) {
         y.c.q var4 = var1.d();
         var3.add(var4);
         y.c.A var5 = var1.t();
         ArrayList var6 = new ArrayList();
         y.h.a.v var7 = var1.C();
         int var8 = 0;
         y.c.x var9 = var2.a();

         y.c.q var10;
         byte var10000;
         label64: {
            while(var9.f()) {
               var10 = var9.e();
               var10000 = this.b;
               if(var14) {
                  break label64;
               }

               label60: {
                  if(var10000 != 0) {
                     var1.a(var10, var4);
                     if(!var14) {
                        break label60;
                     }
                  }

                  var1.a(var4, var10);
               }

               label71: {
                  y.c.q var11 = var7 == null?null:var7.n(var10);
                  if(var11 == null) {
                     ++var8;
                     if(!var14) {
                        break label71;
                     }
                  }

                  int var12 = var5.a(var11);
                  if(var12 == 0) {
                     var6.add(var11);
                  }

                  ++var12;
                  var5.a(var11, var12);
               }

               var9.g();
               if(var14) {
                  break;
               }
            }

            var10000 = 0;
         }

         int var15 = var10000;
         var10 = null;
         Iterator var16 = var6.iterator();

         while(var16.hasNext()) {
            y.c.q var17 = (y.c.q)var16.next();
            int var13 = var5.a(var17);
            if(var15 < var13) {
               var15 = var13;
               var10 = var17;
               if(var14) {
                  return var3;
               }

               if(var14) {
                  break;
               }
            }
         }

         if(var15 > var8) {
            var7.b(var3, var10);
         }
      }

      return var3;
   }

   protected y.c.y a(bu var1) {
      boolean var5 = fj.z;
      y.c.y var2 = new y.c.y();
      y.c.x var3 = var1.o();

      while(var3.f()) {
         y.c.q var4 = var3.e();
         if(var1.v(var4)) {
            var2.add(var4);
         }

         var3.g();
         if(var5) {
            break;
         }
      }

      return var2;
   }

   protected void a(bu var1, y.c.y var2, y.c.y var3) {
      hV.a(var1, var2);
   }

   protected void b(bu var1, y.c.y var2, y.c.y var3) {
      boolean var6 = fj.z;
      var1.N();
      y.c.x var4 = var2.a();

      while(var4.f()) {
         y.c.q var5 = var4.e();
         var1.a(var5, true);
         var4.g();
         if(var6) {
            break;
         }
      }

   }

   protected ch a(ActionEvent var1) {
      return cm.a(var1, this.a);
   }
}
