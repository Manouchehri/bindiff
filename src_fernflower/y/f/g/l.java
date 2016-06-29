package y.f.g;

import y.f.X;
import y.f.g.d;
import y.f.g.m;
import y.g.M;

class l implements y.g.a.g {
   private X a;
   private y.c.i b;
   private y.c.y c;
   private y.c.A d;
   private y.c.A e;
   private y.c.y f;
   private final d g;

   l(d var1, X var2, y.c.i var3, y.c.A var4, y.c.y var5) {
      this.g = var1;
      this.a = var2;
      this.b = var3;
      this.e = var4;
      this.c = new y.c.y();
      this.d = M.a();
      this.f = var5;
      var5.sort(new m(var3));
   }

   public boolean a() {
      return this.c.isEmpty();
   }

   public boolean a(y.c.q var1) {
      return this.c.contains(var1);
   }

   public void a(y.c.q var1, int var2) {
      this.c.add(var1);
      this.d.a(var1, var2);
   }

   public y.c.q b() {
      boolean var11 = d.d;
      if(this.a()) {
         return null;
      } else {
         y.c.x var1 = this.f.a();

         y.c.q var2;
         int var10000;
         while(true) {
            if(var1.f()) {
               var2 = var1.e();
               var10000 = var2.b();
               if(var11) {
                  break;
               }

               if(var10000 == 0) {
                  this.f.b(var1);
                  this.b.a(var2);
               }

               var1.g();
               if(!var11) {
                  continue;
               }
            }

            var10000 = Integer.MAX_VALUE;
            break;
         }

         int var12 = var10000;
         var2 = null;
         double var3 = 0.0D;
         y.c.x var5 = this.c.a();

         y.c.q var13;
         while(true) {
            if(var5.f()) {
               y.c.q var6 = var5.e();
               double var7 = this.a.p(var6) * this.a.q(var6);
               int var9 = this.b(var6);
               y.c.q var10 = (y.c.q)this.e.b(var6);
               var13 = var10;
               if(var11) {
                  break;
               }

               if((var10 == null || var10.b() == 0) && (var12 > var9 || var12 == var9 && var7 > var3)) {
                  var12 = var9;
                  var2 = var6;
                  var3 = var7;
               }

               var5.g();
               if(!var11) {
                  continue;
               }
            }

            var13 = var2;
            break;
         }

         if(var13 == null) {
            throw new RuntimeException("Found no valid element!");
         } else {
            return var2;
         }
      }
   }

   public y.c.q c() {
      y.c.q var1 = this.b();
      this.c.remove(var1);
      y.c.q var2 = (y.c.q)this.e.b(var1);
      this.b.a(var2);
      return var1;
   }

   public void b(y.c.q var1, int var2) {
      this.d.a(var1, var2);
   }

   public void d() {
      this.c.clear();
      this.d = M.a();
   }

   public int b(y.c.q var1) {
      return this.d.a(var1);
   }
}
