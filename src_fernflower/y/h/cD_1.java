package y.h;

import java.awt.event.ActionEvent;
import java.util.HashSet;
import y.h.bu;
import y.h.cA;
import y.h.ch;
import y.h.cm;
import y.h.fj;
import y.h.gd;

public class cD extends cA {
   private boolean b;
   private boolean c;

   public cD() {
      this((ch)null);
   }

   public cD(ch var1) {
      super(cm.A.toString(), var1);
      this.c = false;
   }

   public void actionPerformed(ActionEvent var1) {
      ch var2 = this.a((ActionEvent)var1);
      if(var2 != null) {
         this.a(var2);
      }

   }

   public void a(ch var1) {
      boolean var12 = fj.z;
      bu var2 = var1.getGraph2D();
      y.h.a.v var3 = this.a((bu)var2);
      if(var3 != null) {
         y.c.y var4 = new y.c.y();
         y.c.q var5 = var3.e((y.c.i)var2);
         this.a(var3, var5, var4, var2);
         y.c.y var6 = new y.c.y(var2.J());
         var2.r();
         boolean var14 = false;

         boolean var18;
         label161: {
            try {
               label167: {
                  var14 = true;
                  HashSet var7 = new HashSet(var4);
                  y.c.y var8 = new y.c.y(var4);
                  y.c.x var9 = var4.a();

                  y.c.q var10;
                  y.c.q var10000;
                  while(true) {
                     if(var9.f()) {
                        var10 = var3.n(var9.e());
                        var10000 = var10;
                        if(var12) {
                           break;
                        }

                        if(var10 != null && var7.add(var10)) {
                           var8.add(var10);
                        }

                        var9.g();
                        if(!var12) {
                           continue;
                        }

                        var2.a(var8.a());
                        var9 = var4.a();
                     } else {
                        var2.a(var8.a());
                        var9 = var4.a();
                     }

                     if(!var9.f()) {
                        var14 = false;
                        break label167;
                     }

                     var10000 = var9.e();
                     break;
                  }

                  while(true) {
                     var10 = var10000;
                     var18 = var2.f(var10);
                     if(var12) {
                        var14 = false;
                        break label161;
                     }

                     if(var18) {
                        this.c(var10, var2);
                     }

                     var9.g();
                     if(var12) {
                        var14 = false;
                        break;
                     }

                     if(!var9.f()) {
                        var14 = false;
                        break;
                     }

                     var10000 = var9.e();
                  }
               }
            } finally {
               if(var14) {
                  var2.s();
               }
            }

            var2.s();
            var18 = this.b();
         }

         if(var18) {
            y.c.x var16 = var6.a();

            while(var16.f()) {
               y.c.q var17 = var16.e();
               if(var2.f(var17)) {
                  var2.a(var17, true);
               }

               var16.g();
               if(var12) {
                  break;
               }
            }
         }
      }

   }

   private void a(y.h.a.v var1, y.c.q var2, y.c.y var3, bu var4) {
      boolean var7 = fj.z;
      y.c.x var5 = var1.p(var2);

      while(var5.f()) {
         label25: {
            y.c.q var6 = var5.e();
            if(this.a(var4, var6)) {
               if(this.c && var1.k(var6)) {
                  this.a(var1, var6, var3, var4);
               }

               var3.add(var6);
               if(!var7) {
                  break label25;
               }
            }

            if(var1.k(var6)) {
               this.a(var1, var6, var3, var4);
            }
         }

         var5.g();
         if(var7) {
            break;
         }
      }

   }

   protected boolean a(bu var1, y.c.q var2) {
      y.h.a.v var3 = this.a((bu)var1);
      return var1.v(var2) && var3.k(var2);
   }

   public void c(y.c.q var1, bu var2) {
      var2.r();

      try {
         y.h.a.v var3 = this.a((bu)var2);
         y.c.q var4 = var3.n(var1);
         y.h.a.a var5 = null;
         boolean var6 = false;
         if(var4 != null) {
            var5 = var2.t(var4).getAutoBoundsFeature();
            var6 = var5 != null && var5.isAutoBoundsEnabled();
            if(var6) {
               var5.setAutoBoundsEnabled(false);
            }
         }

         try {
            this.a(var1, var2);
            this.b(var2, var1);
            this.b(var1, var2);
         } finally {
            if(var6) {
               var5.setAutoBoundsEnabled(true);
            }

         }
      } finally {
         var2.s();
      }

      var2.T();
   }

   private void b(bu var1, y.c.q var2) {
      this.a((bu)var1).e(var2);
      this.a(var1.t(var2));
   }

   protected void a(fj var1) {
      if(var1 instanceof gd) {
         gd var2 = (gd)var1;
         boolean var3 = var2.isSelected();
         var1 = var2.a(1);
         var2.b(var1);
         if(this.c()) {
            var2.setSelected(var3);
         }

         var1.setLocation(var2.a(0).getX(), var2.a(0).getY());
         if(!(var1 instanceof y.h.a.h) || ((y.h.a.h)var1).isGroupClosed()) {
            return;
         }

         ((y.h.a.h)var1).setGroupClosed(true);
         if(!fj.z) {
            return;
         }
      }

      if(var1 instanceof y.h.a.h && !((y.h.a.h)var1).isGroupClosed()) {
         ((y.h.a.h)var1).setGroupClosed(true);
      }

   }

   public boolean c() {
      return this.b;
   }
}
