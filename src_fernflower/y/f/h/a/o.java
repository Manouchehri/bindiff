package y.f.h.a;

import y.f.h.a.b;
import y.f.h.a.f;
import y.f.h.a.m;

class o {
   o a;
   o b;
   m c;

   o(m var1, o var2, o var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   m a() {
      return this.c;
   }

   o a(o var1) {
      if(var1 == this.a) {
         return this.b;
      } else if(var1 == this.b) {
         return this.a;
      } else {
         throw new RuntimeException("Link not known!");
      }
   }

   void a(int var1, o var2) {
      if(var1 == 0) {
         this.a = var2;
         if(!b.g) {
            return;
         }
      }

      this.b = var2;
   }

   void a(o var1, o var2) {
      boolean var3 = b.g;
      if(var1 == this.a) {
         this.a = var2;
         if(!var3) {
            return;
         }
      }

      if(var1 != this.b) {
         throw new RuntimeException("Link not known!");
      } else {
         this.b = var2;
         if(var3) {
            throw new RuntimeException("Link not known!");
         }
      }
   }

   o b() {
      if(this.a != null) {
         this.a.a(this, this.b);
      }

      if(this.b != null) {
         this.b.a(this, this.a);
      }

      this.a = null;
      this.b = null;
      return this;
   }

   void b(o var1, o var2) {
      boolean var3 = b.g;
      if(var1 == this.a) {
         this.b.a(this, var2);
         var2.a(1, this.b);
         this.b = var2;
         var2.a(0, this);
         if(!var3) {
            return;
         }
      }

      if(var1 != this.b) {
         throw new RuntimeException("Link not known!");
      } else {
         this.a.a(this, var2);
         var2.a(0, this.a);
         this.a = var2;
         var2.a(1, this);
         if(var3) {
            throw new RuntimeException("Link not known!");
         }
      }
   }

   void a(o var1, f var2) {
      boolean var3 = b.g;
      if(!var2.a()) {
         label28: {
            if(var1 == this.a) {
               this.b.a(this, var2.f());
               var2.c(this.b);
               this.b = var2.e();
               var2.d(this);
               if(!var3) {
                  break label28;
               }
            }

            if(var1 != this.b) {
               throw new RuntimeException("Link not known!");
            }

            this.a.a(this, var2.f());
            var2.c(this.a);
            this.a = var2.e();
            var2.d(this);
            if(var3) {
               throw new RuntimeException("Link not known!");
            }
         }

         var2.b();
      }

   }
}
