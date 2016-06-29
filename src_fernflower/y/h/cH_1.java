package y.h;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.geom.Rectangle2D.Double;
import y.h.bu;
import y.h.cA;
import y.h.ch;
import y.h.cm;
import y.h.fj;
import y.h.gd;

public class cH extends cA {
   private boolean b;

   public cH() {
      this((ch)null);
   }

   public cH(ch var1) {
      super(cm.w.toString(), var1);
      this.b = false;
   }

   public void actionPerformed(ActionEvent var1) {
      ch var2 = this.a((ActionEvent)var1);
      if(var2 != null) {
         this.a(var2);
         var2.getGraph2D().T();
      }

   }

   public void a(ch var1) {
      boolean var7 = fj.z;
      bu var2 = var1.getGraph2D();
      y.h.a.v var3 = this.a((bu)var2);
      if(var3 != null) {
         y.c.y var4 = new y.c.y();
         y.c.x var5 = var2.o();

         cH var10000;
         label28: {
            while(var5.f()) {
               y.c.q var6 = var5.e();
               var10000 = this;
               if(var7) {
                  break label28;
               }

               if(this.a(var2, var6)) {
                  var4.add(var6);
               }

               var5.g();
               if(var7) {
                  break;
               }
            }

            var10000 = this;
         }

         y.c.q var8 = var10000.a(var4, var1);
         if(this.b() && var8 != null) {
            var2.a(var8, true);
         }
      }

   }

   protected y.c.q a(y.c.y var1, ch var2) {
      bu var3 = var2.getGraph2D();
      var3.r();

      y.c.q var5;
      try {
         y.c.q var4 = null;
         if(var1.isEmpty()) {
            if(this.c()) {
               var4 = this.b(var2);
            }
         } else {
            var4 = this.b(var1, var2);
         }

         var5 = var4;
      } finally {
         var3.s();
      }

      return var5;
   }

   protected y.c.q b(ch var1) {
      bu var2 = var1.getGraph2D();
      y.h.a.v var3 = this.a((bu)var2);
      y.c.q var4 = var3.b((y.c.i)var2);
      double var5 = var1.getCenter().getX();
      double var7 = var1.getCenter().getY();
      var2.a(var4, var5, var7);
      this.a(var4, var1);
      return var4;
   }

   protected y.c.q b(y.c.y var1, ch var2) {
      bu var3 = var2.getGraph2D();
      y.h.a.v var4 = this.a((bu)var3);
      y.c.q var5 = var4.a(var1);
      y.c.q var6 = var4.b(var5);
      var4.c(var1, var6);
      this.a(var6, var2);
      fj var7 = var3.t(var6);
      var7.calcUnionRect(new Double());
      this.a((y.c.q)var6, (bu)var3);
      var4.e(var6);
      this.a(var3.t(var6));
      this.b((y.c.q)var6, (bu)var3);
      return var6;
   }

   protected void a(fj var1) {
      label21: {
         if(var1 instanceof gd) {
            gd var2 = (gd)var1;
            var1 = var2.a(1);
            var2.b(var1);
            if(!(var1 instanceof y.h.a.h) || ((y.h.a.h)var1).isGroupClosed()) {
               break label21;
            }

            ((y.h.a.h)var1).setGroupClosed(true);
            if(!fj.z) {
               break label21;
            }
         }

         if(var1 instanceof y.h.a.h && !((y.h.a.h)var1).isGroupClosed()) {
            ((y.h.a.h)var1).setGroupClosed(true);
         }
      }

      bu var6 = var1.d();
      y.c.q var3 = var1.getNode();
      bu var4 = (bu)var6.C().m(var3);
      Rectangle var5 = var4.a();
      var6.b(var3, (double)(var5.width + 10), (double)(var5.height + 10));
      var6.c(var3, (double)(var5.x - 5), (double)(var5.y - 5));
   }

   protected void a(y.c.q var1, ch var2) {
      fj var3 = var2.getGraph2D().t(var1);
      if(var3 instanceof gd) {
         gd var4 = (gd)var3;
         var4.a(0).setLabelText(this.c(var1, var2));
         var4.a(1).setLabelText(this.b(var1, var2));
         if(!fj.z) {
            return;
         }
      }

      var3.setLabelText(this.c(var1, var2));
   }

   protected String b(y.c.q var1, ch var2) {
      return "Folder";
   }

   protected String c(y.c.q var1, ch var2) {
      return "Group";
   }

   protected boolean a(bu var1, y.c.q var2) {
      return var1.v(var2);
   }

   public boolean c() {
      return this.b;
   }
}
