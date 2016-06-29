package y.f.f.c;

import y.c.A;
import y.c.x;
import y.d.t;
import y.f.f.c.b;
import y.f.f.c.f;
import y.f.f.c.g;
import y.f.f.c.l;
import y.f.f.c.p;
import y.g.al;

public class r {
   private y.f.f.b.h a;
   private f b;
   private l c;
   private int d = 3;
   private boolean e = false;
   private int f = 0;
   private int g = 0;
   private int h = 0;
   private int i = 0;

   public void a(y.f.f.b.h var1) {
      this.a = var1;
   }

   public void a(l var1) {
      this.c = var1;
   }

   public void a(f var1) {
      this.b = var1;
   }

   public void a(int var1) {
      this.d = var1;
   }

   public void a(boolean var1) {
      this.e = var1;
   }

   public void a(A var1) {
      int var9 = g.a;
      al var2 = new al();
      p var3 = new p(0, this.a);
      p var4 = new p(1, this.a);
      this.f = (int)var2.d();
      var2.e();
      if(this.b != null) {
         this.b.a(this.a, var3, var4);
         this.g = (int)var2.d();
         var2.e();
      }

      this.c.a(this.a, var3, var4);
      this.h = (int)var2.d();
      var2.e();
      if(this.d != 3) {
         b var5 = new b();
         var5.a(this.d);
         var5.a(this.a, var3, var4);
         this.i = (int)var2.d();
      }

      x var10 = this.a.a().o();

      while(true) {
         if(var10.f()) {
            y.c.q var6 = var10.e();
            int var7 = var4.a(var6).i();
            int var8 = var3.a(var6).i();
            var1.a(var6, new t((double)var8, (double)var7));
            var10.g();
            if(var9 != 0) {
               break;
            }

            if(var9 == 0) {
               continue;
            }
         }

         var4.c();
         var3.c();
         break;
      }

   }

   public int a() {
      return this.f;
   }

   public int b() {
      return this.g;
   }

   public int c() {
      return this.h;
   }

   public int d() {
      return this.i;
   }
}
