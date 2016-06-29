package y.a;

import y.a.h;
import y.a.n;

class o {
   private int a;

   private o() {
   }

   private void a(y.c.i var1, int[] var2) {
      boolean var6 = h.a;
      int var3 = var1.e() - 1;

      while(var3 >= 0) {
         var2[var3] = -1;
         --var3;
         if(var6) {
            break;
         }
      }

      y.c.d[] var7 = new y.c.d[var1.e()];
      this.a = 0;
      y.c.x var4 = var1.o();

      int var10000;
      y.c.q var5;
      while(true) {
         if(var4.f()) {
            label54: {
               var5 = var4.e();
               var10000 = var5.b();
               if(var6) {
                  break;
               }

               if(var10000 == 0) {
                  this.a(var5, var7, var2);
                  if(!var6) {
                     break label54;
                  }
               }

               var4.g();
               if(!var6) {
                  continue;
               }
            }
         }

         var4 = var1.o();
         var10000 = var4.f();
         break;
      }

      while(var10000 != 0) {
         var5 = var4.e();
         if(var2[var5.d()] == -1) {
            this.a(var5, var7, var2);
         }

         var4.g();
         if(var6) {
            break;
         }

         var10000 = var4.f();
      }

   }

   private y.c.y a(y.c.i var1) {
      boolean var8 = h.a;
      y.c.y var2 = new y.c.y();
      byte[] var3 = new byte[var1.e()];
      y.c.d[] var4 = new y.c.d[var1.e()];
      boolean var5 = false;
      y.c.x var6 = var1.o();

      int var10000;
      y.c.q var7;
      while(true) {
         if(var6.f()) {
            label44: {
               var7 = var6.e();
               var10000 = var7.b();
               if(var8) {
                  break;
               }

               if(var10000 == 0) {
                  this.a(var7, var4, var3, var2);
                  if(!var8) {
                     break label44;
                  }
               }

               var6.g();
               if(!var8) {
                  continue;
               }
            }
         }

         var6 = var1.o();
         var10000 = var6.f();
         break;
      }

      while(var10000 != 0) {
         var7 = var6.e();
         if(var3[var7.d()] == 0) {
            this.a(var7, var4, var3, var2);
         }

         var6.g();
         if(var8) {
            break;
         }

         var10000 = var6.f();
      }

      return var2;
   }

   private void a(y.c.q var1, y.c.d[] var2, int[] var3) {
      boolean var9 = h.a;
      if(var1.c() == 0) {
         var3[var1.d()] = this.a++;
         if(!var9) {
            return;
         }
      }

      int var4 = 0;
      var3[var1.d()] = -2;
      var2[var4] = var1.f();

      do {
         y.c.d var8;
         do {
            y.c.d var5;
            while(true) {
               if(var4 < 0) {
                  return;
               }

               var5 = var2[var4];
               y.c.q var6 = var5.d();
               int var7 = var6.d();
               if(var3[var7] != -1) {
                  break;
               }

               if(var6.c() == 0) {
                  var3[var7] = this.a++;
                  if(!var9) {
                     continue;
                  }
               }

               var3[var7] = -2;
               ++var4;
               var2[var4] = var6.f();
               if(var9) {
                  break;
               }
            }

            var8 = var5.g();
            if(var8 != null) {
               break;
            }

            var3[var5.c().d()] = this.a++;
            --var4;
         } while(!var9);

         var2[var4] = var8;
      } while(!var9);

   }

   private void a(y.c.q var1, y.c.d[] var2, byte[] var3, y.c.y var4) {
      boolean var10 = h.a;
      if(var1.c() == 0) {
         var3[var1.d()] = -2;
         var4.add(var1);
         if(!var10) {
            return;
         }
      }

      int var5 = 0;
      var3[var1.d()] = -1;
      var2[var5] = var1.f();

      do {
         y.c.d var9;
         do {
            y.c.d var6;
            while(true) {
               if(var5 < 0) {
                  return;
               }

               var6 = var2[var5];
               y.c.q var7 = var6.d();
               int var8 = var7.d();
               if(var3[var8] != 0) {
                  break;
               }

               if(var7.c() == 0) {
                  var3[var8] = -2;
                  var4.add(var7);
                  if(!var10) {
                     continue;
                  }
               }

               var3[var8] = -1;
               ++var5;
               var2[var5] = var7.f();
               if(var10) {
                  break;
               }
            }

            var9 = var6.g();
            if(var9 != null) {
               break;
            }

            var3[var6.c().d()] = -2;
            var4.add(var6.c());
            --var5;
         } while(!var10);

         var2[var5] = var9;
      } while(!var10);

   }

   o(n var1) {
      this();
   }

   static void a(o var0, y.c.i var1, int[] var2) {
      var0.a(var1, var2);
   }

   static y.c.y a(o var0, y.c.i var1) {
      return var0.a(var1);
   }
}
