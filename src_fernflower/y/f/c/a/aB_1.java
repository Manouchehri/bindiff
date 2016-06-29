package y.f.c.a;

import java.util.HashMap;
import y.f.c.a.N;
import y.f.c.a.O;
import y.f.c.a.bK;

final class aB {
   private final y.c.c a;
   private final y.c.A b;
   private final y.c.c c;
   private final y.c.y d;
   private final y.c.A e;

   private aB(y.f.X var1, y.c.c var2, y.c.c var3) {
      this.a = var2;
      this.b = y.g.M.a();
      this.c = var3;
      this.d = new y.c.y();
      this.e = var1.t();
   }

   bK a(y.c.q var1) {
      return (bK)this.a.b(var1);
   }

   void a(y.c.q var1, bK var2) {
      this.b.a(var1, var2);
   }

   y.c.x a() {
      return this.d.a();
   }

   y.c.x b(y.c.q var1) {
      return ((y.c.y)this.e.b(var1)).a();
   }

   boolean c(y.c.q var1) {
      return this.c.d(var1);
   }

   void a(y.f.X var1, y.c.c var2, y.c.c var3) {
      boolean var9 = N.x;
      HashMap var4 = new HashMap();
      y.c.x var5 = var1.o();

      while(true) {
         if(var5.f()) {
            var4.put(var2.b(var5.e()), var5.e());
            var5.g();
            if(var9) {
               break;
            }

            if(!var9) {
               continue;
            }
         }

         var5 = var1.o();
         break;
      }

      while(var5.f()) {
         label37: {
            Object var6 = var3.b(var5.e());
            y.c.q var7 = (y.c.q)var4.get(var6);
            if(var7 != null) {
               y.c.y var8 = (y.c.y)this.e.b(var7);
               if(var8 == null) {
                  var8 = new y.c.y();
                  this.e.a(var7, var8);
               }

               var8.add(var5.e());
               if(!var9) {
                  break label37;
               }
            }

            if(this.c(var5.e())) {
               this.d.add(var5.e());
            }
         }

         label31: {
            if(!this.c(var5.e())) {
               this.b.a(var5.e(), this.a.b(var5.e()));
               if(!var9) {
                  break label31;
               }
            }

            if(this.e.b(var5.e()) == null) {
               this.e.a(var5.e(), new y.c.y());
            }
         }

         var5.g();
         if(var9) {
            break;
         }
      }

   }

   void a(y.f.X var1) {
      var1.a((y.c.A)this.e);
   }

   void b(y.c.q var1, bK var2) {
      boolean var6 = N.x;
      y.c.x var3 = this.b(var1);
      if(var3.k() == 0) {
         this.a(var1, var2);
         if(!var6) {
            return;
         }
      }

      while(var3.f()) {
         y.c.q var4 = var3.e();
         bK var5 = this.a(var4);
         if(var5 == null) {
            var5 = var2;
         }

         label25: {
            if(this.c(var4)) {
               this.b(var4, var5);
               if(!var6) {
                  break label25;
               }
            }

            this.a(var4, var5);
         }

         var3.g();
         if(var6) {
            break;
         }
      }

   }

   aB(y.f.X var1, y.c.c var2, y.c.c var3, O var4) {
      this(var1, var2, var3);
   }

   static y.c.A a(aB var0) {
      return var0.b;
   }
}
