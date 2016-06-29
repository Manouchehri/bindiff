package y.f.i;

import y.f.i.v;
import y.f.i.w;

class B {
   private y.f.X a;
   private y.c.y b;

   private B(y.f.X var1) {
      this.a = var1;
      this.b = new y.c.y();
   }

   public y.c.y a() {
      int var9 = v.f;
      this.b();
      y.c.x var1 = this.a.o();

      label42:
      while(true) {
         boolean var10000 = var1.f();

         B var10;
         label39:
         while(var10000) {
            y.c.q var2 = var1.e();
            y.d.y var3 = this.a.s(var2);
            var10 = this;
            if(var9 != 0) {
               return var10.b;
            }

            y.f.aj[] var4 = this.a.a_(var1.e());
            if(var4 != null && var4.length > 0) {
               int var5 = 0;

               while(var5 < var4.length) {
                  y.f.aj var6 = var4[var5];
                  y.d.y var7 = var6.getBox();
                  var10000 = this.a(var3, var7, 3.0D);
                  if(var9 != 0) {
                     continue label39;
                  }

                  if(!var10000) {
                     y.c.q var8 = this.a.d();
                     this.a.a((y.c.q)var8, (y.d.q)var7);
                     this.a.b(var8, var7.e());
                     this.b.add(var8);
                  }

                  ++var5;
                  if(var9 != 0) {
                     break;
                  }
               }
            }

            var1.g();
            if(var9 == 0) {
               continue label42;
            }
            break;
         }

         var10 = this;
         return var10.b;
      }
   }

   private boolean a(y.d.y var1, y.d.y var2, double var3) {
      return var1.d() < var2.d() + var3 && var1.c() < var2.c() + var3 && var1.d() + var1.b() > var2.d() + var2.b() - var3 && var1.c() + var1.a() > var2.c() + var2.a() - var3;
   }

   public void b() {
      int var2 = v.f;
      if(!this.b.isEmpty()) {
         y.c.x var1 = this.b.a();

         while(var1.f()) {
            this.a.a((y.c.q)var1.e());
            var1.g();
            if(var2 != 0) {
               return;
            }

            if(var2 != 0) {
               break;
            }
         }

         this.b.clear();
      }

   }

   B(y.f.X var1, w var2) {
      this(var1);
   }
}
