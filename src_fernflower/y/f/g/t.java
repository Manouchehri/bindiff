package y.f.g;

import y.f.aj;
import y.f.am;
import y.f.g.d;
import y.f.g.n;

class t implements y.d.o {
   Object a;
   Object b;
   byte c;
   private final n d;

   t(n var1, Object var2, Object var3, byte var4) {
      this.d = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
   }

   public boolean a() {
      return this.c == 2 || this.c == 3;
   }

   public void a(double var1, double var3) {
      boolean var9 = d.d;
      if(this.c == 1) {
         y.d.v var5 = n.b(this.d).j((y.c.d)this.a);
         y.c.D var6 = new y.c.D();
         y.d.u var7 = var5.b();

         label25: {
            while(var7.f()) {
               y.d.t var8 = var7.a();
               var6.add(new y.d.t(var8.a + var1, var8.b + var3));
               var7.g();
               if(var9) {
                  break label25;
               }

               if(var9) {
                  break;
               }
            }

            n.b(this.d).b((y.c.d)this.a, var6);
         }

         if(!var9) {
            return;
         }
      }

      if(this.c == 0) {
         y.d.t var10 = n.b(this.d).o((y.c.q)this.a);
         n.b(this.d).b((y.c.q)this.a, new y.d.t(var10.a + var1, var10.b + var3));
      }

   }

   public y.d.y h() {
      boolean var12 = d.d;
      if(this.c != 1) {
         y.d.n var17;
         if(this.c == 3) {
            y.c.d var16 = (y.c.d)this.b;
            y.f.C var14 = (y.f.C)this.a;
            var17 = var14.getLabelModel().a(var14.getOrientedBox().d(), n.b(this.d).b(var16), n.b(this.d).a((Object)var16.c()), n.b(this.d).a((Object)var16.d()), var14.getModelParameter());
            return var17.h();
         } else if(this.c == 2) {
            y.c.q var15 = (y.c.q)this.b;
            aj var2 = (aj)this.a;
            var17 = var2.a().a(var2.getOrientedBox().d(), n.b(this.d).a((Object)var15), var2.getModelParameter());
            return var17.h();
         } else {
            am var13 = n.b(this.d).a(this.a);
            return new y.d.y(var13.getX(), var13.getY(), var13.getWidth(), var13.getHeight());
         }
      } else {
         double var1 = Double.MAX_VALUE;
         double var3 = Double.MAX_VALUE;
         double var5 = -1.7976931348623157E308D;
         double var7 = -1.7976931348623157E308D;
         y.d.v var9 = n.b(this.d).l((y.c.d)this.a);
         y.d.u var10 = var9.b();

         while(var10.f()) {
            y.d.t var11 = var10.a();
            var1 = Math.min(var1, var11.a);
            var3 = Math.min(var3, var11.b);
            var5 = Math.max(var5, var11.a);
            var7 = Math.max(var7, var11.b);
            var10.g();
            if(var12) {
               break;
            }
         }

         return new y.d.y(var1, var3, var5 - var1, var7 - var3);
      }
   }

   public boolean a(y.d.y var1) {
      boolean var5 = d.d;
      if(this.c != 1) {
         return y.d.y.a(var1, this.h());
      } else {
         y.d.v var2 = n.b(this.d).l((y.c.d)this.a);
         y.d.s var3 = var2.j();

         boolean var10000;
         while(true) {
            if(var3.f()) {
               y.d.m var4 = var3.a();
               var10000 = var4.a(var1);
               if(var5) {
                  break;
               }

               if(var10000) {
                  return true;
               }

               var3.g();
               if(!var5) {
                  continue;
               }
            }

            var10000 = false;
            break;
         }

         return var10000;
      }
   }
}
