package y.f.b;

import java.util.HashSet;
import y.c.q;
import y.c.x;
import y.f.X;
import y.f.ah;
import y.f.b.a;
import y.f.b.c;
import y.f.b.f;
import y.f.b.j;
import y.g.I;

public class b extends y.f.a {
   private I a;
   private y.c.c b;
   private y.c.c c;
   private y.c.c d;
   private j e;

   public b() {
      this.e = new j();
      this.e.a(true);
   }

   public b(ah var1) {
      this();
      this.a((ah)var1);
   }

   public boolean b() {
      return this.e.b();
   }

   public void a(boolean var1) {
      this.e.a(var1);
   }

   public void b(X var1) {
      this.a((y.c.i)var1);
      this.b((y.c.i)var1);
   }

   public void d(X var1) {
      this.c((y.c.i)var1);
      this.c();
   }

   void a(y.c.i var1) {
      int var8 = c.a;
      y.c.c var2 = var1.c(f.d);
      if(var2 != null) {
         boolean var3;
         HashSet var4;
         y.c.c var5;
         x var6;
         label42: {
            var3 = this.b();
            var4 = new HashSet();
            if(!var3) {
               var5 = var1.c(f.c);
               var6 = var1.o();

               while(var6.f()) {
                  var4.add(var5.b(var6.e()));
                  var6.g();
                  if(var8 != 0) {
                     break label42;
                  }

                  if(var8 != 0) {
                     break;
                  }
               }
            }

            this.a = new I(var1);
            var5 = var1.c(f.b);
         }

         var6 = var1.o();

         while(var6.f()) {
            q var7 = var6.e();
            if(var2.d(var7) && (var3 || var4.contains(var5.b(var7)))) {
               this.a.a(var7);
            }

            var6.g();
            if(var8 != 0) {
               break;
            }
         }
      }

   }

   void c() {
      if(this.a != null) {
         this.a.f();
         this.e.c((X)this.a.i());
         this.a = null;
      }

   }

   public void a(a var1) {
      this.e.a(var1);
   }

   void b(y.c.i var1) {
      this.b = var1.c(f.d);
      this.c = var1.c(f.b);
      this.d = var1.c(f.c);
      if(this.b != null) {
         var1.d_(f.d);
      }

      if(this.c != null) {
         var1.d_(f.b);
      }

      if(this.d != null) {
         var1.d_(f.c);
      }

   }

   void c(y.c.i var1) {
      if(this.b != null) {
         var1.a(f.d, this.b);
      }

      if(this.c != null) {
         var1.a(f.b, this.c);
      }

      if(this.d != null) {
         var1.a(f.c, this.d);
      }

      this.b = null;
      this.c = null;
      this.d = null;
   }

   public void c(X var1) {
      if(this.a() != null) {
         this.a((y.c.i)var1);
         this.b((y.c.i)var1);
         this.a().c(var1);
         this.c((y.c.i)var1);
         this.c();
      }
   }
}
