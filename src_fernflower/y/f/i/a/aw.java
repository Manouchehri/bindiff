package y.f.i.a;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.aU;
import y.f.i.a.aa;
import y.f.i.a.ab;
import y.f.i.a.f;
import y.f.i.a.v;

class aw extends ab {
   private int b;
   private y.c.d c;
   private byte d;
   private boolean e;
   private R f;

   protected void b(aa var1) {
      super.b(var1);
      this.c = this.b().c();
      this.d = this.a().c().a(this.c).e();
      this.b = this.b().d().f().m();
      this.e = this.b > 0 && this.d != 0 && !this.c.e();
      this.f = var1.g();
   }

   protected double a(f var1, R var2, P var3, v var4, double var5) {
      double var10;
      label71: {
         int var14 = ab.a;
         boolean var7 = var1.j() == null;
         byte var8 = var4.c();
         boolean var9 = var8 == 4 || var8 == 2;
         var10 = 0.0D;
         y.f.y[] var12;
         if(var7 || var9) {
            var12 = var4.b();
            int var13 = var7?0:1;
            if(!this.a(var12, var13) || d(var1) && !this.a(true)) {
               break label71;
            }

            var10 = (double)this.b;
            if(var14 == 0) {
               break label71;
            }
         }

         if(var4.c() == 3 && var3.b(var1.c())) {
            var10 += (double)this.b;
            if(var14 == 0) {
               break label71;
            }
         }

         var12 = var4.b();
         if(this.a(var12, 1) && (!d(var1) || this.a(true))) {
            var10 = (double)this.b;
         }
      }

      this.a("monotonic edge route penalty", var10, false);
      return var10;
   }

   double[] a(f var1, R var2, P[] var3, v[] var4, double[] var5) {
      if(!this.e) {
         this.b("monotonic edge route penalty", 0.0D, false);
         return new double[var3.length];
      } else {
         return super.a(var1, var2, var3, var4, var5);
      }
   }

   protected double b(f var1) {
      if(!this.e) {
         return 0.0D;
      } else {
         double var2 = 0.0D;
         if(a(var1, this.f)) {
            y.f.y var4 = var1.d().c();
            if(this.a(var4) && this.a(false)) {
               var2 = (double)this.b;
            }
         }

         this.a("HEUR monotonic penalty", var2, true);
         return var2;
      }
   }

   private boolean a(y.f.y var1) {
      y.f.X var2 = this.a().a();
      y.f.y var3;
      if(this.d == 2 || this.d == 3) {
         var3 = a(this.c, var2, (byte)2);
         if(var1 == var3) {
            return true;
         }
      }

      if(this.d == 1 || this.d == 3) {
         var3 = a(this.c, var2, (byte)1);
         if(var1 == var3) {
            return true;
         }
      }

      return false;
   }

   private static boolean a(f var0, R var1) {
      y.f.y var2 = var0.d();
      R var3 = var0.a();
      return var2 == y.f.y.b?var1.j() <= var3.h():(var2 == y.f.y.d?var3.j() <= var1.h():(var2 == y.f.y.a?var3.k() <= var1.i():var1.k() <= var3.i()));
   }

   private boolean a(boolean var1) {
      int var8 = ab.a;
      aU var2 = this.a().a(this.c);
      List var3 = var2.a(var1);
      if(var3 != null && !var3.isEmpty()) {
         HashSet var4 = new HashSet();
         Iterator var5 = var3.iterator();

         while(var5.hasNext()) {
            y.f.ax var6 = (y.f.ax)var5.next();
            byte var7 = var6.e().b();
            if(var7 == 0) {
               return true;
            }

            var4.add(a(var7));
            if(var8 != 0) {
               break;
            }
         }

         Set var9 = this.d();
         var9.retainAll(var4);
         return !var9.isEmpty();
      } else {
         return true;
      }
   }

   private static y.f.y a(byte var0) {
      switch(var0) {
      case 1:
         return y.f.y.a;
      case 2:
         return y.f.y.c;
      case 3:
      case 5:
      case 6:
      case 7:
      default:
         throw new IllegalArgumentException(var0 + "not allowed");
      case 4:
         return y.f.y.d;
      case 8:
         return y.f.y.b;
      }
   }

   private static boolean d(f var0) {
      return !var0.i();
   }

   private Set d() {
      y.f.X var1 = this.a().a();
      HashSet var2 = new HashSet(Arrays.asList(new y.f.y[]{y.f.y.a, y.f.y.c, y.f.y.d, y.f.y.b}));
      y.f.y var3;
      if(this.d == 2 || this.d == 3) {
         var3 = a(this.c, var1, (byte)2);
         var2.remove(var3);
      }

      if(this.d == 1 || this.d == 3) {
         var3 = a(this.c, var1, (byte)1);
         var2.remove(var3);
      }

      return var2;
   }

   private boolean a(y.f.y[] var1, int var2) {
      byte var10000;
      y.f.X var3;
      y.f.y var4;
      int var5;
      int var6;
      label64: {
         var6 = ab.a;
         var3 = this.a().a();
         if(this.d == 2 || this.d == 3) {
            var4 = a(this.c, var3, (byte)2);
            var5 = var2;

            while(var5 < var1.length) {
               var10000 = var4.equals(var1[var5]);
               if(var6 != 0) {
                  break label64;
               }

               if(var10000 != 0) {
                  return true;
               }

               ++var5;
               if(var6 != 0) {
                  break;
               }
            }
         }

         var10000 = this.d;
      }

      boolean var7;
      if(var10000 == 1 || this.d == 3) {
         var4 = a(this.c, var3, (byte)1);
         var5 = var2;

         while(var5 < var1.length) {
            var7 = var4.equals(var1[var5]);
            if(var6 != 0) {
               return var7;
            }

            if(var7) {
               return true;
            }

            ++var5;
            if(var6 != 0) {
               break;
            }
         }
      }

      var7 = false;
      return var7;
   }

   private static y.f.y a(y.c.d var0, y.f.X var1, byte var2) {
      return var2 == 2?(var1.j(var0.c()) < var1.j(var0.d())?y.f.y.d:y.f.y.b):(var2 == 1?(var1.k(var0.c()) < var1.k(var0.d())?y.f.y.a:y.f.y.c):null);
   }
}
