package y.d;

import y.c.D;
import y.d.g;
import y.d.h;
import y.d.j;
import y.d.t;

class l implements j {
   D[] a;
   y.c.p b;
   final double c;
   final double d;
   final double e;
   final int f;

   l(double var1, double var3, int var5) {
      boolean var7 = t.d;
      super();
      this.a = new D[var5];
      int var6 = 0;

      while(true) {
         if(var6 < this.a.length) {
            this.a[var6] = new D();
            ++var6;
            if(var7) {
               break;
            }

            if(!var7) {
               continue;
            }
         }

         this.c = var1;
         this.d = var3;
         this.e = var3 - var1 + 1.0D;
         this.f = this.a.length / 2;
         break;
      }

   }

   public void a(h var1) {
      boolean var10 = t.d;
      int var2 = 0;
      double var3 = this.c;
      double var5 = this.d;

      h var10000;
      while(true) {
         if(var2 < this.f) {
            double var7 = 0.5D * (var5 - var3);
            var10000 = var1;
            if(var10) {
               break;
            }

            if(var1.b < var7) {
               var2 = (var2 << 1) + 1;
               var5 = var7;
               if(!var10) {
                  continue;
               }
            }

            if(var1.a > var7) {
               var2 = (var2 << 1) + 2;
               var3 = var7;
               if(!var10) {
                  continue;
               }
            }
         }

         if(this.b != null) {
            y.c.p var9 = (y.c.p)this.b.c();
            this.b.a(var1);
            this.a[var2].a(this.b);
            var1.e = this.b;
            this.b = var9;
            if(!var10) {
               return;
            }
         }

         var10000 = var1;
         break;
      }

      var10000.e = this.a[var2].b((Object)var1);
   }

   public void b(h var1) {
      boolean var9 = t.d;
      int var2 = 0;
      double var3 = this.c;
      double var5 = this.d;

      h var10000;
      while(true) {
         if(var2 < this.f) {
            double var7 = 0.5D * (var5 - var3);
            var10000 = var1;
            if(var9) {
               break;
            }

            if(var1.b < var7) {
               var2 = (var2 << 1) + 1;
               var5 = var7;
               if(!var9) {
                  continue;
               }
            }

            if(var1.a > var7) {
               var2 = (var2 << 1) + 2;
               var3 = var7;
               if(!var9) {
                  continue;
               }
            }
         }

         this.a[var2].h(var1.e);
         var10000 = var1;
         break;
      }

      var10000.e.a(this.b);
      this.b = var1.e;
   }

   void a(h var1, g var2, int var3, double var4, double var6) {
      boolean var13 = t.d;
      double var8 = 0.5D * (var6 - var4);
      Object var10 = var1.d;
      y.c.p var11;
      h var12;
      if(var3 < this.f) {
         if(var1.b < var8) {
            var11 = this.a[var3].k();

            while(true) {
               if(var11 != null) {
                  var12 = (h)var11.c();
                  if(var13) {
                     break;
                  }

                  if(var12.b >= var1.a && var12.a <= var1.b) {
                     var2.a(var10, var12.d);
                  }

                  var11 = var11.a();
                  if(!var13) {
                     continue;
                  }
               }

               this.a(var1, var2, (var3 << 1) + 1, var4, var8);
               break;
            }

            if(!var13) {
               return;
            }
         }

         if(var1.a > var8) {
            var11 = this.a[var3].k();

            while(true) {
               if(var11 != null) {
                  var12 = (h)var11.c();
                  if(var13) {
                     break;
                  }

                  if(var12.b >= var1.a && var12.a <= var1.b) {
                     var2.a(var10, var12.d);
                  }

                  var11 = var11.a();
                  if(!var13) {
                     continue;
                  }
               }

               this.a(var1, var2, (var3 << 1) + 2, var8, var6);
               break;
            }

            if(!var13) {
               return;
            }
         }

         var11 = this.a[var3].k();

         label63: {
            while(var11 != null) {
               var12 = (h)var11.c();
               var2.a(var10, var12.d);
               var11 = var11.a();
               if(var13) {
                  break label63;
               }

               if(var13) {
                  break;
               }
            }

            this.a(var1, var2, (var3 << 1) + 1, var4, var8);
            this.a(var1, var2, (var3 << 1) + 2, var8, var6);
         }

         if(!var13) {
            return;
         }
      }

      var11 = this.a[var3].k();

      while(var11 != null) {
         var12 = (h)var11.c();
         if(var12.b >= var1.a && var12.a <= var1.b) {
            var2.a(var10, var12.d);
         }

         var11 = var11.a();
         if(var13) {
            break;
         }
      }

   }

   public void a(h var1, g var2) {
      this.a(var1, var2, 0, this.c, this.d);
   }
}
