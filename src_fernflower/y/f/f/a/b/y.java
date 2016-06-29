package y.f.f.a.b;

import y.f.f.a.b.A;
import y.f.f.a.b.a;

public class y {
   private a a;
   private y.c.i b;
   private y.f.f.a.a.p c;
   private A d;
   private y.c.d e;
   private y.c.d f;
   private y.c.d g;
   private boolean h = true;
   private y.c.f i;

   public y(a var1) {
      this.a = var1;
      this.b = this.a.d();
      this.c = this.a.b();
   }

   public void a() {
      if(this.d != null) {
         this.d.a();
      }

   }

   public void a(boolean var1) {
      this.h = var1;
   }

   public static void a(a var0, y.c.d var1) {
      y var2 = new y(var0);
      var2.h = false;
      var2.a(new y.c.f(var1));
      var2.a();
   }

   public static boolean b(a var0, y.c.d var1) {
      y.c.f var2 = new y.c.f();
      y.c.f var3 = var0.d(var1);
      y var4 = new y(var0);
      var4.d = new A(var0);
      var4.h = false;
      double var5 = var4.d.a(var1, var2);
      var4.a();
      return var5 <= (double)var3.size();
   }

   public void a(y.c.f var1) {
      boolean var4 = a.c;
      y.c.e var2 = var1.a();

      while(var2.f()) {
         if(this.d == null) {
            this.d = new A(this.a);
         }

         label25: {
            this.g = var2.a();
            if(this.g.e()) {
               this.a(this.g);
               if(!var4) {
                  break label25;
               }
            }

            y.c.f var3 = this.d.a(this.g.c(), this.g.d());
            this.b(var3);
         }

         if(!this.h) {
            this.d.a();
            this.d = null;
         }

         var2.g();
         if(var4) {
            break;
         }
      }

   }

   private void a(y.c.d var1) {
      y.c.q var2 = var1.c();
      y.c.d var3 = this.a.k(var1);
      y.c.f var4 = this.a.a(var2);
      var4.a(var1);
      var4.a(var3);
      if(this.h) {
         y.c.d var5 = var4.c();
         y.f.h.p var6 = this.a.b(var5);
         this.a(var6, var1);
      }

   }

   private void b(y.c.f var1) {
      boolean var7 = a.c;
      y.c.d var2 = null;
      y.c.e var3 = var1.a();

      while(var3.f()) {
         y.c.d var4 = var3.a();
         int var5 = this.d.a(var4);
         switch(var5) {
         case 0:
            var2 = this.b(var4);
            if(!var7) {
               break;
            }
         case 1:
            var2 = this.c(var4);
            if(!var7) {
               break;
            }
         case 2:
            var2 = this.f(var4);
            if(!var7) {
               break;
            }
         case 3:
            var2 = this.d(var4);
            if(!var7) {
               break;
            }
         case 4:
            var2 = this.e(var4);
            if(var7) {
               throw new RuntimeException("Bad routing edge type!");
            }
            break;
         default:
            throw new RuntimeException("Bad routing edge type!");
         }

         if(this.h && var5 != 0) {
            y.f.h.p var6 = this.d.a(var4.c());
            this.a(var6, var2);
         }

         var3.g();
         if(var7) {
            break;
         }
      }

   }

   private y.c.d b(y.c.d var1) {
      this.e = this.b.a(this.g.c(), this.g.d());
      y.c.d var2 = this.a(this.g.c(), var1.d());
      this.a.b(this.g.c(), var2, this.e);
      this.i = new y.c.f();
      y.c.p var3 = this.i.b(this.e);
      this.a.a(this.e, var3);
      this.a.b(this.e, this.g);
      return null;
   }

   private y.c.d c(y.c.d var1) {
      this.f = this.a.k(this.e);
      y.c.d var2 = this.a(this.g.d(), var1.c());
      this.a.b(this.g.d(), var2, this.f);
      this.a.a(this.g, this.i);
      return this.e;
   }

   private y.c.d d(y.c.d var1) {
      y.c.q var2 = this.d.b(var1);
      this.b.a(this.e, this.e.c(), var2);
      this.f = this.a.k(this.e);
      y.c.d var3 = null;
      var3 = this.a(var2, this.f);
      this.a.d(var2, var3, this.f);
      y.c.d var4 = this.e;
      this.e = this.b.a(var2, this.g.d());
      y.c.d var5 = this.a.i(var3);
      if(var5.c() != var2) {
         var5 = this.a.c(var5);
      }

      this.a.a(var2, var5, this.e);
      this.a.c(var4, this.e);
      y.c.p var6 = this.i.b(this.e);
      this.a.a(this.e, var6);
      this.a.b(this.e, this.g);
      return var4;
   }

   private y.c.d e(y.c.d var1) {
      y.c.q var2 = this.d.b(var1);
      this.b.a(this.e, this.e.c(), var2);
      this.f = this.a.k(this.e);
      y.c.d var3 = this.a(var2, var1.d());
      y.c.d var4 = this.a.i(var3);
      if(var4.c() != var2) {
         var4 = this.a.c(var4);
      }

      this.a.a(var2, var4, this.f);
      y.c.d var5 = this.e;
      this.e = this.b.a(var2, this.g.d());
      this.a.d(var2, var3, this.e);
      y.c.p var6 = this.i.b(this.e);
      this.a.a(this.e, var6);
      this.a.b(this.e, this.g);
      this.a.c(this.e, var5);
      return var5;
   }

   private y.c.d f(y.c.d var1) {
      boolean var21 = a.c;
      y.c.d var2 = this.d.c(var1);
      y.c.d var3 = this.a.c(var2);
      y.c.d var4 = null;
      y.c.d var5 = null;
      y.c.d var6 = null;
      y.c.d var7 = null;
      y.c.q var8 = var2.d();
      y.c.q var9 = var2.c();
      y.c.q var10 = null;
      y.f.f.a.a.b var11 = this.c.a(var8);
      y.f.f.a.a.b var12 = this.c.a(var9);
      boolean var13 = false;
      y.f.f.a.a.b var15;
      y.c.d var16;
      if(var12 == var11.c()) {
         var13 = true;
         y.c.q var14 = var8;
         var8 = var9;
         var9 = var14;
         var15 = var11;
         var11 = var12;
         var12 = var15;
         var16 = var3;
         var3 = var2;
         var2 = var16;
      }

      y.f.f.a.a.b var22;
      y.c.d var24;
      if(var11 == var12.c()) {
         var10 = this.b.d();
         this.a.c(var10);
         var22 = this.c.a(var11, var10);
         var11.a(var22);
         y.c.d var17;
         y.c.f var18;
         y.c.p var19;
         if(!this.a.a(var3)) {
            var24 = this.a.h(var3);
            var16 = this.a.i(var3);
            var17 = this.a.e(var3);
            var18 = this.a.d(var17);
            this.a.y(var17);
            var6 = this.b.a(var8, var10);
            var4 = this.a.k(var6);
            var5 = this.b.a(var10, var9);
            var7 = this.a.k(var5);
            this.a.b(var6, var17);
            this.a.b(var5, var17);
            var19 = var18.a(var6, this.a.j(var3));
            this.a.a(var6, var19);
            var19 = var18.a(var5, this.a.j(var3));
            this.a.a(var5, var19);
            var18.remove(var3);
            this.a.c(var6, var16);
            if(var24 != null && this.a.i(var24) != null) {
               this.a.c(var24, var5);
            }
         } else {
            var24 = this.a.g(var2);
            var16 = this.a.i(var2);
            var17 = this.a.e(var2);
            var18 = this.a.d(var17);
            this.a.y(var17);
            var4 = this.b.a(var10, var8);
            var6 = this.a.k(var4);
            var7 = this.b.a(var9, var10);
            var5 = this.a.k(var7);
            this.a.b(var4, var17);
            this.a.b(var7, var17);
            var19 = var18.a(var7, this.a.j(var2));
            this.a.a(var7, var19);
            var19 = var18.a(var4, this.a.j(var2));
            this.a.a(var4, var19);
            var18.remove(var2);
            this.a.c(var4, var16);
            if(var24 != null && this.a.i(var24) != null) {
               this.a.c(var24, var7);
            }
         }

         this.a.e(var8, var3, var6);
         this.a.a(var10).add(var4);
         this.a.c(var9, var2, var7);
         this.a.a(var10).add(var5);
         this.g(var3);
         this.g(var2);
      } else {
         var10 = this.b.d();
         this.a.c(var10);
         var22 = (y.f.f.a.a.b)var11.c();
         var15 = this.c.a(var22, var10);
         var22.a(var15);
         y.c.p var20;
         y.c.f var25;
         y.c.p var27;
         y.c.d var28;
         y.c.d var29;
         if(!this.a.a(var3)) {
            label82: {
               var6 = this.b.a(var8, var10);
               var4 = this.a.k(var6);
               var5 = this.b.a(var10, var9);
               var7 = this.a.k(var5);
               var16 = this.a.e(var3);
               if(var16 == null) {
                  var25 = new y.c.f();
                  this.a.a(var3, var25);
                  var27 = var25.b(var6);
                  this.a.a(var6, var27);
                  var27 = var25.b(var5);
                  this.a.a(var5, var27);
                  this.a.b(var6, var3);
                  this.a.b(var5, var3);
                  this.a.y(var3);
                  if(!var21) {
                     break label82;
                  }
               }

               this.a.y(var16);
               var25 = this.a.d(var16);
               var28 = this.a.h(var3);
               var29 = this.a.g(var3);
               var20 = var25.a(var6, this.a.j(var3));
               this.a.a(var6, var20);
               var20 = var25.a(var5, this.a.j(var3));
               this.a.a(var5, var20);
               var25.remove(var3);
               this.a.b(var6, var16);
               this.a.b(var5, var16);
               if(var28 != null && this.a.i(var28) == var3) {
                  this.a.c(var28, var5);
               }

               if(var29 != null && this.a.i(var29) == var3) {
                  this.a.c(var29, var6);
               }
            }
         } else {
            label83: {
               var7 = this.b.a(var9, var10);
               var5 = this.a.k(var7);
               var4 = this.b.a(var10, var8);
               var6 = this.a.k(var4);
               var16 = this.a.e(var2);
               if(var16 == null) {
                  var25 = new y.c.f();
                  this.a.a(var2, var25);
                  var27 = var25.b(var7);
                  this.a.a(var7, var27);
                  var27 = var25.b(var4);
                  this.a.a(var4, var27);
                  this.a.b(var7, var2);
                  this.a.b(var4, var2);
                  this.a.y(var2);
                  if(!var21) {
                     break label83;
                  }
               }

               this.a.y(var16);
               var25 = this.a.d(var16);
               var28 = this.a.h(var2);
               var29 = this.a.g(var2);
               var20 = var25.a(var7, this.a.j(var2));
               this.a.a(var7, var20);
               var20 = var25.a(var4, this.a.j(var2));
               this.a.a(var4, var20);
               var25.remove(var2);
               this.a.b(var7, var16);
               this.a.b(var4, var16);
               if(var28 != null && this.a.i(var28) == var2) {
                  this.a.c(var28, var4);
               }

               if(var29 != null && this.a.i(var29) == var2) {
                  this.a.c(var29, var7);
               }
            }
         }

         this.a.c(var8, var3, var6);
         this.a.a(var10).add(var4);
         this.a.c(var9, var2, var7);
         this.a.a(var10).add(var5);
         this.g(var3);
         this.g(var2);
      }

      y.c.d var23;
      label65: {
         this.a.y(this.g);
         this.b.a(this.e, this.e.c(), var10);
         var23 = this.e;
         var24 = this.a.k(var23);
         if(var13) {
            this.a.a(var10, var4, var24);
            if(!var21) {
               break label65;
            }
         }

         this.a.a(var10, var5, var24);
      }

      label60: {
         this.e = this.b.a(var10, this.g.d());
         if(var13) {
            this.a.a(var10, var5, this.e);
            if(!var21) {
               break label60;
            }
         }

         this.a.a(var10, var4, this.e);
      }

      this.a.b(this.e, this.g);
      y.c.p var26 = this.i.b(this.e);
      this.a.a(this.e, var26);
      return var23;
   }

   private y.c.d a(y.c.q var1, y.c.d var2) {
      boolean var4 = a.c;
      y.c.d var3 = this.a.l(var2);

      y.c.d var10000;
      while(true) {
         if(var3.c() != var1) {
            var10000 = this.a.l(var3);
            if(var4) {
               break;
            }

            var3 = var10000;
            if(!var4) {
               continue;
            }
         }

         var10000 = var3;
         break;
      }

      return var10000;
   }

   private y.c.d a(y.c.q var1, y.c.q var2) {
      y.c.d var3 = null;
      y.f.h.p var4 = this.d.a(var2);
      y.c.e var5 = var4.a();

      while(var5.f()) {
         if(var5.a().c() == var1) {
            var3 = var5.a();
            break;
         }

         var5.g();
      }

      return var3;
   }

   private void a(y.f.h.p var1, y.c.d var2) {
      y.f.h.p[] var3;
      label11: {
         y.c.q var4 = var2.d();
         if(this.a.d(var4)) {
            var3 = this.a.a(var1, var2, var4);
            if(!a.c) {
               break label11;
            }
         }

         var3 = this.a.a(var1, var2);
      }

      this.d.a(var1, var3);
   }

   private void g(y.c.d var1) {
      if(this.a.n(var1)) {
         this.b.a(var1);
         if(!a.c) {
            return;
         }
      }

      this.b.d(var1);
   }
}
