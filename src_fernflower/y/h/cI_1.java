package y.h;

import java.awt.event.ActionEvent;
import y.h.bu;
import y.h.cA;
import y.h.ch;
import y.h.cm;
import y.h.fj;
import y.h.gd;

public class cI extends cA {
   private boolean b;

   public cI() {
      this((ch)null);
   }

   public cI(ch var1) {
      super(cm.v.toString(), var1);
      this.b = false;
   }

   public void actionPerformed(ActionEvent var1) {
      ch var2 = this.a(var1);
      if(var2 != null) {
         this.a(var2);
         var2.getGraph2D().T();
      }

   }

   public void a(ch var1) {
      boolean var8 = fj.z;
      bu var2 = var1.getGraph2D();
      y.h.a.v var3 = this.a(var2);
      if(var3 != null) {
         y.c.y var4 = new y.c.y();
         y.c.x var5 = var2.o();

         while(var5.f()) {
            y.c.q var6 = var5.e();
            if(var8) {
               return;
            }

            if(this.a(var2, var6)) {
               var4.add(var6);
            }

            var5.g();
            if(var8) {
               break;
            }
         }

         y.c.y var9 = new y.c.y(var2.J());
         this.a(var4, var1);
         y.c.x var10 = var9.a();

         while(var10.f()) {
            y.c.q var7 = var10.e();
            if(this.b()) {
               var2.a(var7, true);
            }

            var10.g();
            if(var8) {
               break;
            }
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

         if(var4 != null) {
            this.a(var4, var2);
         }

         var5 = var4;
      } finally {
         var3.s();
      }

      return var5;
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

   protected y.c.q b(ch var1) {
      bu var2 = var1.getGraph2D();
      y.c.q var3 = this.a(var2).c((y.c.i)var2);
      double var4 = var1.getCenter().getX();
      double var6 = var1.getCenter().getY();
      var2.a(var3, var4, var6);
      return var3;
   }

   protected y.c.q b(y.c.y var1, ch var2) {
      bu var3 = var2.getGraph2D();
      y.c.q var4 = this.a(var3).a(var1);
      y.c.q var5 = this.a(var3).b(var4);
      this.a(var5, var3);
      this.a(var3).c(var1, var5);
      this.b(var5, var3);
      return var5;
   }

   protected boolean a(bu var1, y.c.q var2) {
      return var1.v(var2);
   }

   protected void a(y.c.q var1, bu var2) {
   }

   protected void b(y.c.q var1, bu var2) {
   }

   public boolean c() {
      return this.b;
   }
}
