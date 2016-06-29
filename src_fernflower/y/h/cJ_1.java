package y.h;

import java.awt.event.ActionEvent;
import java.awt.geom.Rectangle2D.Double;
import y.h.bu;
import y.h.cA;
import y.h.ch;
import y.h.cm;
import y.h.fj;
import y.h.gd;

public class cJ extends cA {
   private boolean b;

   public cJ() {
      this((ch)null);
   }

   public cJ(ch var1) {
      super(cm.z.toString(), var1);
   }

   public void actionPerformed(ActionEvent var1) {
      ch var2 = this.a((ActionEvent)var1);
      if(var2 != null) {
         this.a(var2);
      }

   }

   public void a(ch var1) {
      boolean var13 = fj.z;
      bu var2 = var1.getGraph2D();
      y.h.a.v var3 = this.a((bu)var2);
      if(var3 != null) {
         y.c.y var4 = new y.c.y();
         y.c.x var5 = var2.o();

         while(var5.f()) {
            y.c.q var6 = var5.e();
            if(var13) {
               return;
            }

            if(this.a(var2, var6)) {
               var4.add(var6);
            }

            var5.g();
            if(var13) {
               break;
            }
         }

         y.c.y var21 = new y.c.y(var2.J());
         var2.r();
         boolean var16 = false;

         y.c.x var22;
         label262: {
            try {
               var16 = true;
               var2.a(var4.a());
               var22 = var4.a();

               while(true) {
                  if(var22.f()) {
                     y.c.q var7 = var22.e();
                     y.c.q var8 = var3.n(var7);
                     if(var13) {
                        var16 = false;
                        break label262;
                     }

                     if(var8 != null) {
                        y.h.a.a var9 = var2.t(var8).getAutoBoundsFeature();
                        boolean var10 = var9 != null && var9.isAutoBoundsEnabled();
                        if(var10) {
                           var9.setAutoBoundsEnabled(false);
                        }

                        try {
                           this.c(var7, var2);
                        } finally {
                           if(var10) {
                              var9.setAutoBoundsEnabled(true);
                           }

                        }
                     } else {
                        this.c(var7, var2);
                     }

                     var22.g();
                     if(!var13) {
                        continue;
                     }

                     var16 = false;
                     break;
                  }

                  var16 = false;
                  break;
               }
            } finally {
               if(var16) {
                  var2.s();
               }
            }

            var2.s();
         }

         if(this.b()) {
            var22 = var21.a();

            while(var22.f()) {
               var2.a(var22.e(), true);
               var22.g();
               if(var13) {
                  break;
               }
            }
         }
      }

   }

   protected boolean a(bu var1, y.c.q var2) {
      y.h.a.v var3 = this.a((bu)var1);
      return var1.v(var2) && var3.j(var2);
   }

   public void c(y.c.q var1, bu var2) {
      var2.r();

      try {
         this.a(var1, var2);
         this.b(var2, var1);
         this.b(var1, var2);
      } finally {
         var2.s();
      }

      var2.T();
   }

   private void b(bu var1, y.c.q var2) {
      y.h.a.v var3 = this.a((bu)var1);
      bu var4 = (bu)var3.m(var2);
      y.d.t var5 = var1.o(var2);
      y.c.y var6 = new y.c.y(var4.o());
      var3.f(var2);
      fj var7 = var1.t(var2);
      this.a(var7);
      var7.calcUnionRect(new Double());
      Double var8 = var7.getBoundingBox();
      if(var6.size() > 0) {
         var6.add(var2);
         y.f.ae.a(var1, (y.c.x)var6.a(), var5.a - var8.x, var5.b - var8.y);
         if(!fj.z) {
            return;
         }
      }

      y.f.ae.a(var1, (y.c.q)var2, var5.a - var8.x, var5.b - var8.y);
   }

   protected void a(fj var1) {
      if(var1 instanceof gd) {
         gd var2 = (gd)var1;
         boolean var3 = var2.isSelected();
         var1 = var2.a(0);
         var2.b(var1);
         if(this.c()) {
            var2.setSelected(var3);
         }

         if(!(var1 instanceof y.h.a.h) || !((y.h.a.h)var1).isGroupClosed()) {
            return;
         }

         ((y.h.a.h)var1).setGroupClosed(false);
         if(!fj.z) {
            return;
         }
      }

      if(var1 instanceof y.h.a.h && ((y.h.a.h)var1).isGroupClosed()) {
         ((y.h.a.h)var1).setGroupClosed(false);
      }

   }

   public boolean c() {
      return this.b;
   }
}
