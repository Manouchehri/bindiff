package y.f.i.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import y.f.i.a.L;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.S;
import y.f.i.a.Z;
import y.f.i.a.aU;
import y.f.i.a.aa;
import y.f.i.a.ab;
import y.f.i.a.ba;
import y.f.i.a.f;
import y.f.i.a.v;

class aZ extends ab {
   private ArrayList b;
   private R c;
   private L d;
   private int e;

   protected void c() {
      super.c();
      this.b = null;
      this.c = null;
      this.d = null;
   }

   protected void a(Z var1) {
      super.a(var1);
      this.d = var1.c().k();
   }

   protected void b(aa var1) {
      aU var3;
      List var4;
      int var8;
      label46: {
         var8 = ab.a;
         super.b(var1);
         this.e = var1.d().f().a();
         this.c = var1.g();
         y.c.d var2 = var1.c();
         var3 = this.a().a(var2);
         if(var3 != null) {
            var4 = var3.a(false);
            if(var8 == 0) {
               break label46;
            }
         }

         var4 = null;
      }

      this.b = null;
      if(var4 != null) {
         byte var5 = 0;
         Iterator var6 = var4.iterator();

         int var10000;
         y.f.ax var7;
         label38: {
            while(var6.hasNext()) {
               var7 = (y.f.ax)var6.next();
               if(!var7.b()) {
                  var10000 = var7.a();
                  if(var8 != 0) {
                     break label38;
                  }

                  if(var10000 == 255) {
                     var5 = 1;
                     break;
                  }
               }
            }

            var10000 = var5;
         }

         if(var10000 == 0) {
            this.b = new ArrayList(var4.size());
            var6 = var4.iterator();

            while(var6.hasNext()) {
               var7 = (y.f.ax)var6.next();
               this.b.add(new ba(this, var7, var3));
               if(var8 != 0) {
                  break;
               }
            }
         }
      }

   }

   double[] a(f var1, R var2, P[] var3, v[] var4, double[] var5) {
      if(this.e == 0) {
         this.b("bend penalty", 0.0D, false);
         return new double[var3.length];
      } else {
         y.f.y var6 = var1.d();
         if(var6 == null) {
            this.b("bend penalty", 0.0D, false);
            return new double[var3.length];
         } else {
            y.f.y var7 = var4[0].l();
            if(var6 == var7) {
               return super.a(var1, var2, var3, var4, var5);
            } else {
               double var8;
               label23: {
                  if(var6.c() == var7) {
                     var8 = 2.0D;
                     if(ab.a == 0) {
                        break label23;
                     }
                  }

                  var8 = 1.0D;
               }

               double var10 = var8 * (double)this.e;
               this.b("bend penalty", var10, false);
               double[] var12 = new double[var3.length];
               if(var10 > 0.0D) {
                  Arrays.fill(var12, var10);
               }

               return var12;
            }
         }
      }
   }

   protected double a(f var1, R var2, P var3, v var4, double var5) {
      double var7;
      label11: {
         if(var4.c() == 1) {
            var7 = 2.0D;
            if(ab.a == 0) {
               break label11;
            }
         }

         var7 = 0.0D;
      }

      double var9 = var7 * (double)this.e;
      this.a("bend penalty", var9, false);
      return var9;
   }

   protected double b(f var1) {
      int var5 = ab.a;
      if(this.e != 0 && !this.b().d(var1.a())) {
         int var2;
         label54: {
            boolean var3 = a(var1, this.c);
            boolean var4 = b(var1, this.c);
            if(this.b != null) {
               var2 = var3?2:(var4?0:1);
               var2 = this.a(var1, var2);
               if(var5 == 0) {
                  break label54;
               }
            }

            if(var3) {
               var2 = this.d == null?2:this.c(var1, this.c);
               if(var5 == 0) {
                  break label54;
               }
            }

            if(var4) {
               var2 = this.d == null?0:this.d(var1, this.c);
               if(var5 == 0) {
                  break label54;
               }
            }

            var2 = this.d == null?1:this.e(var1, this.c);
         }

         this.a("HEUR bend penalty", (double)(var2 * this.e), true);
         return (double)(var2 * this.e);
      } else {
         this.a("HEUR bend penalty", 0.0D, true);
         return 0.0D;
      }
   }

   private static boolean a(f var0, R var1) {
      y.f.y var2 = var0.d();
      R var3 = var0.a();
      return var2 == y.f.y.b?var1.j() <= var3.h():(var2 == y.f.y.d?var3.j() <= var1.h():(var2 == y.f.y.a?var3.k() <= var1.i():var1.k() <= var3.i()));
   }

   private static boolean b(f var0, R var1) {
      y.f.y var2 = var0.d();
      P var3;
      if(var2.d()) {
         var3 = var1.a(S.d);
         if(ab.a == 0) {
            return var0.c().a(var3, 0.1D);
         }
      }

      var3 = var1.a(S.a);
      return var0.c().a(var3, 0.1D);
   }

   private int c(f var1, R var2) {
      y.f.y var3 = var1.d();
      P var4 = this.b(var2, var3);
      P var5 = this.c(var2, var3);
      return !this.d.a(var4) && this.d.a(var5)?3:2;
   }

   private int d(f var1, R var2) {
      y.f.y var3 = var1.d();
      P var4 = this.a(var2, var3);
      P var5 = this.c(var2, var3);
      P var6 = var1.c();
      P var7 = P.a(var6, var4);
      P var8 = new P(var6.f(), var4.f(), 0.0D, !var6.a());
      if(this.d.a(var7)) {
         return 0;
      } else {
         boolean var9 = this.d.a(var4);
         boolean var10 = this.d.a(var5);
         boolean var11 = this.d.a(var6);
         boolean var12 = this.d.a(var8);
         return var11?(!var10 && var9?2:1):(!var6.c(var4)?(var10?1:(var9 && var12?2:0)):((var9 || var10) && var12?(!var10?2:3):0));
      }
   }

   private int e(f var1, R var2) {
      y.f.y var3 = var1.d();
      P var4 = this.b(var2, var3);
      P var5 = this.c(var2, var3);
      P var6 = var1.c();
      P var7 = new P(var6.f(), var3 != y.f.y.b && var3 != y.f.y.c?var5.b():var5.c(), var5.f(), var5.a());
      return !this.d.a(var7) && this.d.a(var4)?2:1;
   }

   private P a(R var1, y.f.y var2) {
      if(var2 == y.f.y.b) {
         return var1.a(S.d);
      } else if(var2 == y.f.y.d) {
         return var1.a(S.c);
      } else if(var2 == y.f.y.c) {
         return var1.a(S.a);
      } else if(var2 == y.f.y.a) {
         return var1.a(S.b);
      } else {
         throw new IllegalArgumentException("Unknown direction: " + var2);
      }
   }

   private P b(R var1, y.f.y var2) {
      if(var2 == y.f.y.b) {
         return var1.a(S.c);
      } else if(var2 == y.f.y.d) {
         return var1.a(S.d);
      } else if(var2 == y.f.y.c) {
         return var1.a(S.b);
      } else if(var2 == y.f.y.a) {
         return var1.a(S.a);
      } else {
         throw new IllegalArgumentException("Unknown direction: " + var2);
      }
   }

   private P c(R var1, y.f.y var2) {
      if(var2 != y.f.y.b && var2 != y.f.y.d) {
         if(var2 != y.f.y.c && var2 != y.f.y.a) {
            throw new IllegalArgumentException("Unknown direction: " + var2);
         } else {
            return var1.a(S.d);
         }
      } else {
         return var1.a(S.a);
      }
   }

   private int a(f var1, int var2) {
      int var7 = ab.a;
      int var3 = Integer.MAX_VALUE;
      if(this.b != null && !this.b.isEmpty()) {
         Iterator var4 = this.b.iterator();

         label37:
         while(true) {
            int var10000;
            if(var4.hasNext()) {
               ba var5 = (ba)var4.next();
               int var6 = 0;

               do {
                  var10000 = var6;
                  int var10001 = var5.a.length;

                  do {
                     if(var10000 >= var10001) {
                        continue label37;
                     }

                     var3 = Math.min(var3, this.a(var1, var5.a[var6], var5.b[var6]));
                     var10000 = var3;
                     if(var7 != 0) {
                        return var10000;
                     }

                     var10001 = var2;
                  } while(var7 != 0);

                  if(var3 <= var2) {
                     return var3;
                  }

                  ++var6;
               } while(var7 == 0);
            }

            var10000 = var3;
            return var10000;
         }
      } else {
         return var2;
      }
   }

   private int a(f var1, P var2, y.f.y var3) {
      P var4 = var1.c();
      y.f.y var5 = var1.d();
      boolean var6;
      if(var5 == var3) {
         var6 = a(var4.f(), var2.f(), var5);
         return !var6?4:(!var4.a(var2, var2.d() > 0.0D?0.1D:0.0D)?2:(var2.d() <= 0.0D || this.d == null || this.d.a(P.a(var4, var2)) || !this.d.a(var4) && !this.d.a(var2)?0:2));
      } else if(var5.c() == var3) {
         P var8 = this.c.a(S.a(var3));
         return a(var4.f(), var8.f(), var5) && var4.c(var8)?4:2;
      } else {
         var6 = a(var2.f(), var4.b(), var3) && a(var2.f(), var4.c(), var3) || this.d != null && this.a(var4, var2, var3);
         boolean var7 = !a(var4.f(), var2.b(), var5) && !a(var4.f(), var2.c(), var5) || this.d != null && this.b(var4, var2, var5);
         return !var6 && !var7?1:3;
      }
   }

   private boolean a(P var1, P var2, y.f.y var3) {
      if(!var1.e().a(var2.f())) {
         return false;
      } else {
         P var4;
         P var5;
         if(var3 == y.f.y.b || var3 == y.f.y.c) {
            var4 = new P(var1.b(), var2.f(), 0.0D, var1.a());
            var5 = new P(var1.c(), var2.f(), 0.0D, var1.a());
            if(ab.a == 0) {
               return !this.d.a(var4) && this.d.a(var5);
            }
         }

         var4 = new P(var1.c(), var2.f(), 0.0D, var1.a());
         var5 = new P(var1.b(), var2.f(), 0.0D, var1.a());
         return !this.d.a(var4) && this.d.a(var5);
      }
   }

   private boolean b(P var1, P var2, y.f.y var3) {
      if(!var2.e().a(var1.f())) {
         return false;
      } else {
         P var4;
         P var5;
         if(var3 == y.f.y.b || var3 == y.f.y.c) {
            var4 = new P(var2.c(), var1.f(), 0.0D, var2.a());
            var5 = new P(var2.b(), var1.f(), 0.0D, var2.a());
            if(ab.a == 0) {
               return !this.d.a(var4) && this.d.a(var5);
            }
         }

         var4 = new P(var2.b(), var1.f(), 0.0D, var2.a());
         var5 = new P(var2.c(), var1.f(), 0.0D, var2.a());
         return !this.d.a(var4) && this.d.a(var5);
      }
   }

   private static boolean a(double var0, double var2, y.f.y var4) {
      return y.f.y.b != var4 && y.f.y.c != var4?var2 < var0:var2 > var0;
   }

   private static y.f.y b(int var0) {
      switch(var0) {
      case 1:
         return y.f.y.c;
      case 2:
         return y.f.y.a;
      case 3:
      case 5:
      case 6:
      case 7:
      default:
         return y.f.y.c;
      case 4:
         return y.f.y.d;
      case 8:
         return y.f.y.b;
      }
   }

   static y.f.y a(int var0) {
      return b(var0);
   }

   static R a(aZ var0) {
      return var0.c;
   }
}
