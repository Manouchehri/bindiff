package y.f.h;

import y.f.h.N;
import y.f.h.S;
import y.f.h.m;

public class p {
   private y.c.f a = new y.c.f();

   public boolean a(y.c.q var1) {
      boolean var3 = N.d;
      y.c.e var2 = this.a();

      while(var2.f()) {
         if(var2.a().c() == var1) {
            return true;
         }

         var2.g();
         if(var3) {
            break;
         }
      }

      return false;
   }

   public y.c.e a() {
      return this.a.a();
   }

   public m b() {
      return new S(this.a.a());
   }

   void a(y.c.d var1) {
      this.a.b(var1);
   }

   public void a(y.c.d var1, y.c.d var2) {
      boolean var6 = N.d;
      y.c.q var3 = var1.c();
      y.c.p var4 = null;
      var4 = this.a.k();

      while(true) {
         if(var4 != null) {
            y.c.d var5 = (y.c.d)var4.c();
            if(var6) {
               break;
            }

            if(!var5.c().equals(var3)) {
               var4 = this.a.c(var4);
               if(!var6) {
                  continue;
               }
            }
         }

         this.a.a(var1, var4);
         this.a.a(var2, var4);
         break;
      }

   }

   public void a(y.c.d var1, y.c.d var2, y.c.d var3) {
      boolean var5 = N.d;
      y.c.p var4 = null;
      var4 = this.a.k();

      while(true) {
         if(var4 != null) {
            Object var10000 = var4.c();
            if(var5) {
               break;
            }

            if(!var10000.equals(var1)) {
               var4 = this.a.c(var4);
               if(!var5) {
                  continue;
               }
            }
         }

         if(var4 == null) {
            System.err.println("Face: replace Edge: Edge not found !");
            return;
         }

         this.a.a(var2, var4);
         this.a.a(var3, var4);
         this.a.h(var4);
         break;
      }

   }

   void a(y.c.d var1, y.c.f var2) {
      boolean var5 = N.d;
      y.c.p var3 = null;
      var3 = this.a.k();

      y.c.p var10000;
      while(true) {
         if(var3 != null) {
            var10000 = var3;
            if(var5) {
               break;
            }

            if(!var3.c().equals(var1)) {
               var3 = this.a.c(var3);
               if(!var5) {
                  continue;
               }
            }
         }

         var10000 = var3;
         break;
      }

      if(var10000 == null) {
         System.err.println("Face: replace Edge: Edge not found !");
      } else {
         y.c.e var4 = var2.a();

         while(true) {
            if(var4.f()) {
               this.a.a(var4.a(), var3);
               var4.g();
               if(var5) {
                  break;
               }

               if(!var5) {
                  continue;
               }
            }

            this.a.h(var3);
            break;
         }

      }
   }

   void b(y.c.d var1, y.c.d var2, y.c.d var3) {
      boolean var6 = N.d;
      y.c.p var4 = null;
      var4 = this.a.k();

      y.c.p var10000;
      while(true) {
         if(var4 != null) {
            var10000 = var4;
            if(var6) {
               break;
            }

            if(!var4.c().equals(var1)) {
               var4 = this.a.c(var4);
               if(!var6) {
                  continue;
               }
            }
         }

         var10000 = var4;
         break;
      }

      if(var10000 == null) {
         System.err.println("Face: unreplace Edge: first edge not found !");
      } else {
         y.c.p var5 = this.a.c(var4);
         if(var5 == null) {
            var5 = this.a.k();
         }

         if(this.a.g(var5) != var2) {
            System.err.println("Face: unreplace Edge: second edge not found !");
         } else {
            this.a.h(var5);
            this.a.a(var4, var3);
         }
      }
   }

   public String toString() {
      boolean var3 = N.d;
      StringBuffer var1 = new StringBuffer();
      var1.append("Edges: ");
      y.c.e var2 = this.a();

      StringBuffer var10000;
      while(true) {
         if(var2.f()) {
            var10000 = var1.append(var2.a().toString()).append(" ");
            if(var3) {
               break;
            }

            var2.g();
            if(!var3) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000.toString();
   }
}
