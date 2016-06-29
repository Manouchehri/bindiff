package y.f.f.c;

import y.c.D;
import y.f.f.c.f;
import y.f.f.c.g;
import y.f.f.c.p;

public class m implements f {
   private y.f.f.b.h a;
   private p b;
   private p c;

   public void a(y.f.f.b.h var1, p var2, p var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.a();
   }

   public void a() {
      int var2 = g.a;
      y.f.h.q var1 = this.a.c();

      while(var1.f()) {
         this.b(this.a(var1.a()));
         var1.g();
         if(var2 != 0) {
            break;
         }
      }

   }

   private void b(D var1) {
      int var4 = g.a;
      int var2 = var1.size();
      int var3 = 0;

      while(var3 < var2) {
         if(this.a(var1)) {
            var3 = 0;
            var2 = var1.size();
            if(var4 == 0) {
               continue;
            }
         }

         var1.add(var1.g());
         ++var3;
         if(var4 != 0) {
            break;
         }
      }

   }

   private D a(y.f.h.p var1) {
      int var14 = g.a;
      D var2 = new D();
      y.c.e var3 = var1.a();

      while(var3.f()) {
         y.c.d var4 = var3.a();
         if(this.a.d(var4) != 2) {
            p var5;
            p var6;
            label43: {
               if(this.a.h(var4) == y.f.f.b.o.a || this.a.h(var4) == y.f.f.b.o.c) {
                  var5 = this.c;
                  var6 = this.b;
                  if(var14 == 0) {
                     break label43;
                  }
               }

               var5 = this.b;
               var6 = this.c;
            }

            g var7 = var6.a(var4);
            y.c.q var8 = var4.c();
            y.f.f.d.p var9 = new y.f.f.d.p(var7);
            g var10 = var5.a(var8);
            y.f.f.d.p var11 = new y.f.f.d.p(var10);
            y.f.f.d.b var12;
            switch(this.a.d(var4)) {
            case 1:
               var12 = new y.f.f.d.b(var11, var9, 0, this.a.h(var4), 2);
               var2.add(var12);
               if(var14 == 0) {
                  break;
               }
            case 3:
               var12 = new y.f.f.d.b(var11, var9, 1, this.a.h(var4), 2);
               var2.add(var12);
               if(var14 == 0) {
                  break;
               }
            case 4:
               y.f.f.b.o var13 = this.a.h(var4).b();
               var12 = new y.f.f.d.b(var9, var11, 1, var13, 2);
               var2.add(var12);
               var12 = new y.f.f.d.b(var11, var9, 1, this.a.h(var4), 2);
               var2.add(var12);
               if(var14 == 0) {
                  break;
               }
            case 2:
            default:
               System.err.println("Impossible Angle !");
            }
         }

         var3.g();
         if(var14 != 0) {
            break;
         }
      }

      return var2;
   }

   public boolean a(D var1) {
      int var10 = g.a;
      if(var1.size() < 4) {
         return false;
      } else {
         y.c.p var2 = var1.l();
         y.f.f.d.b var3 = (y.f.f.d.b)var2.c();
         var2 = var2.b();
         y.f.f.d.b var4 = (y.f.f.d.b)var2.c();
         var2 = var2.b();
         y.f.f.d.b var5 = (y.f.f.d.b)var2.c();
         var2 = var2.b();
         y.f.f.d.b var6 = (y.f.f.d.b)var2.c();
         if(var6.b() == 1 && var5.b() == 0 && var4.b() == 0) {
            var1.j();
            var1.j();
            var1.j();
            var1.j();
            y.f.f.d.b var7 = new y.f.f.d.b(var6.d(), var4.e(), 0, var4.c(), 2);
            var1.add(var7);
            var1.add(var3);
            y.f.f.d.p var8 = var6.d();
            y.f.f.d.p var9 = var3.e();
            if(var6.c().a(y.f.f.b.o.d)) {
               y.f.f.d.p.a(this.b, var8, var9, 1);
               if(var10 == 0) {
                  return true;
               }
            }

            if(var6.c().a(y.f.f.b.o.b)) {
               y.f.f.d.p.a(this.b, var9, var8, 1);
               if(var10 == 0) {
                  return true;
               }
            }

            if(var6.c().a(y.f.f.b.o.c)) {
               y.f.f.d.p.a(this.c, var9, var8, 1);
               if(var10 == 0) {
                  return true;
               }
            }

            if(var6.c().a(y.f.f.b.o.a)) {
               y.f.f.d.p.a(this.c, var8, var9, 1);
               if(var10 == 0) {
                  return true;
               }
            }

            y.g.o.a((Object)"Consistency Error in rect decomp.");
            return true;
         } else {
            return false;
         }
      }
   }
}
