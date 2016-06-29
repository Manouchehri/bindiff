package y.f.c;

import y.f.c.V;
import y.f.c.a;
import y.f.c.ah;
import y.f.c.ai;
import y.f.c.v;

public class ag extends a {
   private v o = new V();

   public void a(double var1) {
      super.a(var1);
      this.o.a(var1);
   }

   public void b(double var1) {
      super.b(var1);
      this.o.b(var1);
   }

   public void c(double var1) {
      this.a = var1;
      this.o.c(var1);
   }

   public void d(double var1) {
      this.b = var1;
      this.o.d(var1);
   }

   protected void a(y.c.y[] var1, y.c.c var2) {
      boolean var8 = a.i;
      y.f.X var3 = this.g;
      if(this.o != null && this.e != null) {
         this.o.a(this.e);
      }

      if(var1[0].size() != 1) {
         y.g.o.a(this, "Treedrawer: Not a tree !");
         this.o.a(var3, var1, var2);
      } else {
         y.c.x var4 = var3.o();

         int var10000;
         while(true) {
            if(var4.f()) {
               var10000 = var4.e().b();
               if(var8) {
                  break;
               }

               if(var10000 > 1) {
                  y.g.o.a(this, "Treedrawer: Not a tree !");
                  this.o.a(var3, var1, var2);
                  return;
               }

               var4.g();
               if(!var8) {
                  continue;
               }
            }

            var10000 = this.g.i();
            break;
         }

         boolean var9 = var10000 == 0 && y.a.A.b(var3);
         if(!var9) {
            y.g.o.a(this, "Treedrawer: Not a valid tree !");
            this.o.a(var3, var1, var2);
         } else {
            y.g.o.a(this, "Treedrawer: It\'s a tree !");
            y.c.x[] var5 = new y.c.x[var1.length];
            int var6 = 0;

            while(true) {
               if(var6 < var1.length) {
                  var5[var6] = var1[var6].a();
                  ++var6;
                  if(var8) {
                     break;
                  }

                  if(!var8) {
                     continue;
                  }
               }

               this.a(var3, var5);
               break;
            }

            y.f.k.x var10 = new y.f.k.x();
            var10.a((y.f.k.I)(new ai(this.c())));
            ah var7 = new ah(this);
            var10.a((y.f.k.J)var7);
            var10.m();
            var10.c(var3);
         }
      }
   }
}
