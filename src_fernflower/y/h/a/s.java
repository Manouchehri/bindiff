package y.h.a;

import y.h.bu;
import y.h.fj;
import y.h.gd;
import y.h.a.h;
import y.h.a.t;
import y.h.a.u;
import y.h.a.v;

public class s implements u {
   boolean a = true;
   boolean b;

   public boolean a() {
      return this.b;
   }

   public void a(t var1) {
      v var2 = (v)var1.getSource();
      if(var1.a() == 6) {
         this.a = var2.l((y.c.q)var1.b());
         if(v.a == 0) {
            return;
         }
      }

      if(var1.a() == 4) {
         y.c.q var3 = (y.c.q)var1.b();
         bu var4 = (bu)var3.e();
         fj var5 = var4.t(var3);
         if(!var2.l(var3)) {
            h var6 = null;
            if(var5 instanceof h) {
               var6 = (h)var5;
               var6.setGroupClosed(var2.j(var3));
            } else if(var5 instanceof gd) {
               gd var7 = (gd)var5;
               boolean var8 = var7.isSelected();
               if(var2.k(var3)) {
                  var5 = var7.a(0);
                  var7.b(var5);
                  if(this.a()) {
                     var7.setSelected(var8);
                  }

                  if(var5 instanceof h) {
                     var6 = (h)var5;
                     var6.setGroupClosed(false);
                  }
               } else {
                  var5 = var7.a(1);
                  var7.b(var5);
                  if(this.a()) {
                     var7.setSelected(var8);
                  }

                  if(!this.a) {
                     var5.setLocation(var7.a(0).getX(), var7.a(0).getY());
                  }

                  if(var5 instanceof h) {
                     var6 = (h)var5;
                     var6.setGroupClosed(true);
                  }
               }
            }
         }
      }

   }
}
