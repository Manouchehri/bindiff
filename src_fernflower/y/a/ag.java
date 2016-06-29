package y.a;

import y.a.D;
import y.a.S;
import y.a.ah;
import y.a.ai;
import y.a.aj;
import y.a.ak;
import y.a.h;

class ag {
   private final D a;
   private int b;
   private S c;
   private int d;
   private int e;
   private int f;
   private boolean g;
   private double h;
   private boolean i;

   static void a(y.c.C var0, y.c.b var1, y.c.c var2) {
      boolean var3 = h.a;
      var0.i();

      while(var0.f()) {
         var1.a(var0.d(), var1.c(var0.d()) + var2.c(var0.d()));
         var0.g();
         if(var3) {
            break;
         }
      }

   }

   static void b(y.c.C var0, y.c.b var1, y.c.c var2) {
      boolean var3 = h.a;
      var0.i();

      while(var0.f()) {
         var1.a(var0.d(), var1.c(var0.d()) - var2.c(var0.d()));
         var0.g();
         if(var3) {
            break;
         }
      }

   }

   static void a(y.c.C var0, y.c.c var1, y.c.a var2) {
      boolean var3 = h.a;
      var0.i();

      while(var0.f()) {
         var2.a(var0.d(), var1.a(var0.d()));
         var0.g();
         if(var3) {
            break;
         }
      }

   }

   static int a(y.c.d var0, y.c.A var1, int var2) {
      boolean var9 = h.a;
      y.c.y var3 = new y.c.y();
      var3.add(var0.c());
      var1.a(var0.c(), var2);
      var3.add(var0.d());
      var1.a(var0.d(), -var2);

      label39:
      while(true) {
         int var10000 = var3.isEmpty();

         label36:
         while(var10000 == 0) {
            y.c.q var4 = var3.d();
            int var5 = var1.a(var4);
            y.c.e var6 = var4.j();

            while(true) {
               if(!var6.f()) {
                  continue label39;
               }

               y.c.q var7 = var6.a().a(var4);
               int var8 = var1.a(var7);
               var10000 = var8;
               if(var9) {
                  break;
               }

               if(var9) {
                  return var10000;
               }

               if(var8 != var5) {
                  if(var8 == -var5) {
                     return 1;
                  }

                  var1.a(var7, var5);
                  var3.add(var7);
               }

               var6.g();
               if(var9) {
                  break label36;
               }
            }
         }

         var10000 = 2;
         return var10000;
      }
   }

   static void a(y.c.d var0, int var1, y.c.y var2, y.c.f var3, y.c.A var4) {
      boolean var12 = h.a;
      if(var0 != null) {
         y.c.h var5 = y.g.M.b();
         y.c.y var6 = new y.c.y();
         var6.add(var0.c());
         var4.a(var0.c(), 1);
         var6.add(var0.d());
         var4.a(var0.d(), 1);

         label41:
         while(true) {
            int var10000 = var6.isEmpty();

            label39:
            while(var10000 == 0) {
               y.c.q var7 = var6.d();
               int var8 = var4.a(var7);
               var2.add(var7);
               y.c.e var9 = var7.j();

               do {
                  if(!var9.f()) {
                     continue label41;
                  }

                  y.c.d var10 = var9.a();
                  y.c.q var11 = var10.a(var7);
                  var10000 = var8 + 1;
                  if(var12) {
                     continue label39;
                  }

                  if(var10000 <= var1 && var4.a(var11) <= 0) {
                     var4.a(var11, var8 + 1);
                     var6.add(var11);
                  }

                  if(var4.a(var11) > 0 && !var5.d(var10)) {
                     var3.add(var10);
                     var5.a(var10, true);
                  }

                  var9.g();
               } while(!var12);

               return;
            }

            return;
         }
      }
   }

   ag() {
      this.c(2);
      this.b(Integer.MAX_VALUE);
      this.a(1);
      this.a = new D();
      this.c = S.a();
      this.b = 0;
      this.g = true;
      this.i = false;
      this.h = 1.0D;
   }

   void a(double var1) {
      boolean var3 = h.a;
      if(var1 >= 0.0D && var1 <= 1.0D) {
         this.b(true);
         this.c(2);
         this.b(Integer.MAX_VALUE);
         this.a(4);
         this.d(0);
         this.a(false);
         this.b(1.0D);
         this.e(2);
         if(var1 > 0.84D) {
            this.d(0);
            if(!var3) {
               return;
            }
         }

         if(var1 > 0.69D) {
            this.d(1);
            if(!var3) {
               return;
            }
         }

         if(var1 > 0.29D) {
            this.d(1);
            this.b(4.0D);
            if(!var3) {
               return;
            }
         }

         this.d(2);
         this.e(2);
      } else {
         throw new IllegalArgumentException("Ratio must be within [0,1]");
      }
   }

   void a(int var1) {
      if(var1 > 1) {
         this.d = var1;
         if(!h.a) {
            return;
         }
      }

      this.d = 2;
   }

   void b(int var1) {
      if(var1 > 1) {
         this.f = var1;
         if(!h.a) {
            return;
         }
      }

      this.f = Integer.MAX_VALUE;
   }

   void c(int var1) {
      if(var1 > 0) {
         this.e = var1;
         if(!h.a) {
            return;
         }
      }

      this.e = 1;
   }

   void d(int var1) {
      this.b = var1;
      this.a.a(var1);
   }

   void b(double var1) {
      this.h = var1;
   }

   void a(boolean var1) {
      this.i = var1;
   }

   void e(int var1) {
      this.a.b(var1);
   }

   void b(boolean var1) {
      this.g = var1;
   }

   int a(y.c.i var1, y.c.A var2) {
      y.g.I var3;
      y.c.d[] var4;
      Object var5;
      boolean var14;
      label61: {
         var14 = h.a;
         var3 = new y.g.I(var1);
         var4 = var1.n();
         if(this.b == 2) {
            var5 = new ah(this, var1);
            if(!var14) {
               break label61;
            }
         }

         if(this.i) {
            var5 = new ak(this, var1);
            if(!var14) {
               break label61;
            }
         }

         var5 = new ai(this, var1);
      }

      y.c.y[] var6 = h.a(var1);
      int var7 = 0;

      while(var7 < var6.length) {
         ((ai)var5).b(var6[var7]);
         ++var7;
         if(var14) {
            break;
         }
      }

      aj var15 = aj.a(var1, ((ai)var5).e(), ((ai)var5).d(), this.c.a((y.c.d[])var4, ((ai)var5).e(), ((ai)var5).d()));
      y.c.A var8 = y.g.M.a(new int[var1.e()]);
      int var9 = 1;

      int var10000;
      while(true) {
         if(((ai)var5).d() < this.f) {
            var10000 = ((ai)var5).c();
            if(var14) {
               break;
            }

            if(var10000 != 0) {
               y.c.d var10 = ((ai)var5).b();
               var3.a(var10);
               y.c.y var11 = ((ai)var5).a(var10.c());
               ++var9;
               int var12 = a(var10, var8, var9);
               if(var12 == 1) {
                  ((ai)var5).c(var11);
                  if(!var14) {
                     continue;
                  }
               }

               if(var12 == 2) {
                  ((ai)var5).a(var11, var8);
                  aj var13 = aj.a(var1, ((ai)var5).e(), ((ai)var5).d(), this.c.a((y.c.d[])var4, ((ai)var5).e(), ((ai)var5).d()));
                  if(var13.b() != this.e && var13.c() <= var15.c()) {
                     continue;
                  }

                  var15 = var13;
                  if(!var14) {
                     continue;
                  }
               }

               throw new IllegalStateException("There shouldn\'t be more than 2 components after an edge removal.");
            }
         }

         a(var1.o(), (y.c.c)var15.a(), (y.c.a)var2);
         ((ai)var5).a();
         var3.h();
         var10000 = var15.b();
         break;
      }

      return var10000;
   }

   static D a(ag var0) {
      return var0.a;
   }

   static double b(ag var0) {
      return var0.h;
   }

   static int c(ag var0) {
      return var0.d;
   }

   static boolean d(ag var0) {
      return var0.g;
   }
}
