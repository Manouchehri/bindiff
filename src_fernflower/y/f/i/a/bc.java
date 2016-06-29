package y.f.i.a;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import y.f.i.a.L;
import y.f.i.a.M;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.ab;
import y.f.i.a.bd;
import y.f.i.a.be;
import y.f.i.a.v;
import y.f.i.a.y;

class bc {
   private final R a;
   private final L b;
   private final y.c.D c;
   private final y.c.D d;
   private final y.c.D e;
   private final HashMap f;
   private double g;
   private y.c.D h;
   private y.c.D i;
   private double[] j;
   private double[] k;
   private boolean[] l;
   private List[] m;

   bc(R var1, double var2, L var4) {
      this.a = var1;
      this.b = var4;
      this.g = var4 != null?var4.c() * Math.ceil(var2 / var4.c()):var2;
      this.c = new y.c.D();
      this.d = new y.c.D();
      this.e = new y.c.D();
      this.f = new HashMap();
      this.j = new double[]{-1.7976931348623157E308D, -1.7976931348623157E308D, Double.MAX_VALUE, Double.MAX_VALUE};
      this.k = new double[]{var1.h(), var1.i(), var1.j(), var1.k()};
      this.l = new boolean[4];
   }

   private int a(int var1) {
      return (var1 + 2) % 4;
   }

   private boolean b(int var1) {
      return var1 <= 1;
   }

   private boolean c(int var1) {
      return var1 == 0 || var1 == 2;
   }

   private List[] b() {
      int var4 = ab.a;
      bc var10000;
      if(this.m == null) {
         this.m = new List[4];
         y.d.y var1 = new y.d.y(this.a.h() - this.g, this.a.i() - this.g, this.a.l() + 2.0D * this.g, this.a.m() + 2.0D * this.g);
         Iterator var2 = this.a.d().a(var1).iterator();

         while(var2.hasNext()) {
            R var3 = (R)var2.next();
            if(this.a != var3) {
               var10000 = this;
               if(var4 != 0) {
                  return var10000.m;
               }

               if(this.a.h() >= var3.j()) {
                  this.a((R)var3, 0);
               }

               if(this.a.j() <= var3.h()) {
                  this.a((R)var3, 2);
               }

               if(this.a.i() >= var3.k()) {
                  this.a((R)var3, 1);
               }

               if(this.a.k() <= var3.i()) {
                  this.a((R)var3, 3);
                  if(var4 != 0) {
                     break;
                  }
               }
            }
         }
      }

      var10000 = this;
      return var10000.m;
   }

   private void a(R var1, int var2) {
      Object var3 = this.m[var2];
      if(var3 == null) {
         this.m[var2] = (List)(var3 = new y.c.D());
      }

      ((List)var3).add(var1);
   }

   private double b(R var1, int var2) {
      switch(var2) {
      case 0:
         return var1.h();
      case 1:
         return var1.i();
      case 2:
         return var1.j();
      default:
         return var1.k();
      }
   }

   public y.c.D a() {
      return this.c;
   }

   public boolean[] a(P[] var1, boolean[] var2) {
      int var7 = ab.a;
      boolean[] var3 = new boolean[var1.length];
      int var4 = 0;

      while(var4 < var1.length) {
         P var5;
         boolean var6;
         label33: {
            var5 = var1[var4];
            var6 = !var5.a();
            this.a(var6);
            if(var6 && this.h == null) {
               this.a(new M(this.k[0], this.k[2]), true);
               if(var7 == 0) {
                  break label33;
               }
            }

            if(!var6 && this.i == null) {
               this.a(new M(this.k[1], this.k[3]), false);
            }
         }

         var3[var4] = this.a(var5, var6?this.h:this.i, var2[var4]);
         ++var4;
         if(var7 != 0) {
            break;
         }
      }

      return var3;
   }

   public boolean[] a(P[] var1, List var2) {
      int var10 = ab.a;
      y.c.D var3 = new y.c.D(this.d);
      y.c.D var4 = new y.c.D(this.e);
      Iterator var5 = var2.iterator();

      bc var10000;
      while(true) {
         if(var5.hasNext()) {
            P var6 = (P)var5.next();
            var10000 = this;
            if(var10 != 0) {
               break;
            }

            this.a(new bd(this, var6), var6.a()?var3:var4);
            if(var10 == 0) {
               continue;
            }
         }

         this.a(true);
         var10000 = this;
         break;
      }

      y.c.D var11 = var10000.a(new M(this.k[0], this.k[2]), var4, true);
      this.a(false);
      y.c.D var12 = this.a(new M(this.k[1], this.k[3]), var3, false);
      boolean[] var7 = new boolean[var1.length];
      int var8 = 0;

      boolean[] var13;
      while(true) {
         if(var8 < var1.length) {
            P var9 = var1[var8];
            var13 = var7;
            if(var10 != 0) {
               break;
            }

            var7[var8] = this.a(var9, var9.a()?var12:var11, false);
            ++var8;
            if(var10 == 0) {
               continue;
            }
         }

         var13 = var7;
         break;
      }

      return var13;
   }

   private boolean a(P var1, y.c.D var2, boolean var3) {
      int var13 = ab.a;
      boolean var4 = !var1.a();
      M var5 = this.b != null && !var3?this.b.b(var1.e(), var4):var1.e();
      if(var5 == null) {
         return false;
      } else {
         double var6 = Math.max(var5.a(), var4?this.k[0]:this.k[1]);
         double var8 = Math.min(var5.b(), var4?this.k[2]:this.k[3]);
         if(var6 > var8) {
            return false;
         } else {
            Iterator var10 = var2.iterator();

            int var10000;
            while(true) {
               if(var10.hasNext()) {
                  M var11 = (M)var10.next();
                  if(var11.b() <= var6) {
                     continue;
                  }

                  double var14;
                  var10000 = (var14 = var11.a() - var6) == 0.0D?0:(var14 < 0.0D?-1:1);
                  if(var13 == 0) {
                     boolean var12 = var10000 < 0 && var11.b() > var8;
                     return !var12;
                  }
                  break;
               }

               var10000 = 1;
               break;
            }

            return (boolean)var10000;
         }
      }
   }

   private void a(boolean var1) {
      if(var1) {
         if(!this.d(0) && !this.d(2)) {
            return;
         }

         this.h = null;
         if(ab.a == 0) {
            return;
         }
      }

      if(this.d(1) || this.d(3)) {
         this.i = null;
      }

   }

   private boolean d(int var1) {
      int var9 = ab.a;
      if(this.l[var1]) {
         int var10000;
         double var2;
         label33: {
            var2 = this.b(this.a, var1);
            List var4 = this.b()[var1];
            if(var4 != null) {
               Iterator var5 = var4.iterator();

               label30:
               do {
                  double var7;
                  do {
                     if(!var5.hasNext()) {
                        break label30;
                     }

                     bc var6 = ((R)var5.next()).b();
                     var7 = var6.j[var1];
                     var10000 = this.b(var1);
                     if(var9 != 0) {
                        break label33;
                     }

                     if(var10000 == 0) {
                        break;
                     }

                     var2 = Math.max(var2, var7);
                  } while(var9 == 0);

                  var2 = Math.min(var2, var7);
               } while(var9 == 0);
            }

            double var10;
            var10000 = (var10 = this.k[var1] - var2) == 0.0D?0:(var10 < 0.0D?-1:1);
         }

         if(var10000 != 0) {
            this.k[var1] = var2;
            this.l[var1] = false;
            return true;
         }
      }

      return false;
   }

   public void a(v var1) {
      be var2 = new be(this, var1);
      var2.a();
      a(var2, var1.g());
   }

   private static void a(be var0, y.c.d var1) {
      y.c.i var2 = var1.a();
      y.c.h var3 = (y.c.h)var2.c(y.b);
      y.c.D var4 = (y.c.D)var3.b(var1);
      if(var4 == null) {
         var4 = new y.c.D();
         var3.a(var1, var4);
      }

      var4.add(var0);
   }

   private y.c.p a(bd var1, y.c.D var2) {
      int var11 = ab.a;
      M var3 = var1.b;
      double var4 = var3.a();
      double var6 = var3.b();
      y.c.p var8 = var2.k();
      M var9 = var8 != null?((bd)var8.c()).b:null;

      while(var9 != null && (var9.b() < var6 || var9.b() == var6 && var9.a() <= var4)) {
         var8 = var8.a();
         var9 = var8 != null?((bd)var8.c()).b:null;
         if(var11 != 0) {
            break;
         }
      }

      y.c.p var10;
      if(var8 != null) {
         var10 = var2.a((Object)var1, (y.c.p)var8);
         if(var11 == 0) {
            return var10;
         }
      }

      var10 = var2.b((Object)var1);
      return var10;
   }

   private double e(int var1) {
      int var9 = ab.a;
      boolean var2 = this.c(var1);
      boolean var3 = this.b(var1);
      double var4 = var3?Double.MAX_VALUE:-1.7976931348623157E308D;
      y.c.D var6 = var2?this.d:this.e;
      Iterator var7 = var6.iterator();

      while(var7.hasNext()) {
         bd var8 = (bd)var7.next();
         if(var3) {
            var4 = Math.min(var4, var8.b.a());
            if(var9 == 0) {
               continue;
            }
         }

         var4 = Math.max(var4, var8.b.b());
         if(var9 != 0) {
            break;
         }
      }

      return var4;
   }

   private void a(int var1, double var2, boolean var4) {
      boolean var10000;
      double var5;
      label47: {
         var5 = this.j[var1];
         if(!var4 || var2 == var5) {
            label46: {
               if(!var4) {
                  if(this.b(var1)) {
                     if(var2 > var5) {
                        break label46;
                     }
                  } else if(var2 < var5) {
                     break label46;
                  }
               }

               var10000 = false;
               break label47;
            }
         }

         var10000 = true;
      }

      boolean var7 = var10000;
      if(var7) {
         this.j[var1] = var2;
         double var8 = this.b(this.a, this.a(var1));
         int var10 = this.b(var1)?1:-1;
         if((double)var10 * var8 < (double)var10 * var5 || (double)var10 * var8 < (double)var10 * var2) {
            this.f(var1);
         }
      }

   }

   private void f(int var1) {
      int var6 = ab.a;
      List var2 = this.b()[this.a(var1)];
      if(var2 != null) {
         Iterator var3 = var2.iterator();

         while(var3.hasNext()) {
            R var4 = (R)var3.next();
            bc var5 = var4.b();
            var5.l[var1] = true;
            if(var6 != 0) {
               break;
            }
         }
      }

   }

   private void a(M var1, boolean var2) {
      y.c.D var3 = var2?this.e:this.d;
      y.c.D var4 = this.a(var1, var3, var2);
      if(var2) {
         this.h = var4;
         if(ab.a == 0) {
            return;
         }
      }

      this.i = var4;
   }

   private y.c.D a(M var1, y.c.D var2, boolean var3) {
      int var15 = ab.a;
      y.c.D var4 = new y.c.D();
      if(var2.size() == 0) {
         return var4;
      } else if(!this.a(var2, var1, var3)) {
         var4.add(new M(var1.a() - this.g, var1.b() + this.g));
         return var4;
      } else {
         Iterator var5 = var2.iterator();

         label58:
         while(true) {
            int var10000 = var5.hasNext();

            y.c.D var17;
            label55:
            while(var10000 != 0) {
               bd var6 = (bd)var5.next();
               if(var6.d - var6.c >= 2.0D * this.g) {
                  continue label58;
               }

               double var7 = var6.d - this.g;
               double var9 = var6.c + this.g;
               y.c.p var11 = null;
               var17 = var4;
               if(var15 != 0) {
                  return var17;
               }

               y.c.p var12 = var4.k();

               while(var12 != null) {
                  M var13 = (M)var12.c();
                  double var18;
                  var10000 = (var18 = var13.a() - var9) == 0.0D?0:(var18 < 0.0D?-1:1);
                  if(var15 != 0) {
                     continue label55;
                  }

                  if(var10000 >= 0) {
                     var11 = var12;
                     break;
                  }

                  if(var13.b() <= var7) {
                     var12 = var12.a();
                     if(var15 == 0) {
                        continue;
                     }
                  }

                  var7 = Math.min(var7, var13.a());
                  var9 = Math.max(var9, var13.b());
                  y.c.p var14 = var12;
                  var12 = var12.a();
                  var4.h(var14);
               }

               M var16 = new M(var7, var9);
               if(var11 != null) {
                  var4.a((Object)var16, (y.c.p)var11);
                  if(var15 == 0) {
                     continue label58;
                  }
               }

               var4.b((Object)var16);
               if(var15 == 0) {
                  continue label58;
               }
               break;
            }

            var17 = var4;
            return var17;
         }
      }
   }

   private boolean a(y.c.D var1, M var2, boolean var3) {
      int var11 = ab.a;
      M var4 = this.b != null?this.b.b(var2, var3):var2;
      if(var4 == null) {
         return false;
      } else {
         y.c.D var5 = new y.c.D(var1);
         double var6 = var4.a();

         bd var8;
         double var9;
         while(true) {
            if(var5.size() > 0) {
               var8 = this.a(var5, var6);
               var9 = Math.max(var6, var8.b.a());
               var8.c = var9;
               var6 = this.a(var9 + this.g, var3);
               if(var11 != 0) {
                  break;
               }

               if(var11 == 0) {
                  continue;
               }
            }

            var5 = new y.c.D(var1);
            break;
         }

         var6 = var4.b();

         while(var5.size() > 0) {
            var8 = this.b(var5, var6);
            var9 = Math.min(var6, var8.b.b());
            var8.d = var9;
            var6 = this.b(var9 - this.g, var3);
            if(var11 != 0) {
               break;
            }
         }

         return true;
      }
   }

   private bd a(y.c.D var1, double var2) {
      int var9 = ab.a;
      double var4 = Double.MAX_VALUE;
      y.c.p var6 = null;
      y.c.p var7 = var1.k();

      Object var10000;
      while(true) {
         if(var7 != null) {
            bd var8 = (bd)var7.c();
            var10000 = var8.b;
            if(var9 != 0) {
               break;
            }

            if(((M)var10000).a() < var4) {
               var6 = var7;
               var4 = var8.b.a();
            }

            if(var4 > var2) {
               var7 = var7.a();
               if(var9 == 0) {
                  continue;
               }
            }
         }

         var10000 = var1.h(var6);
         break;
      }

      return (bd)var10000;
   }

   private bd b(y.c.D var1, double var2) {
      int var9 = ab.a;
      double var4 = -1.7976931348623157E308D;
      y.c.p var6 = null;
      y.c.p var7 = var1.l();

      Object var10000;
      while(true) {
         if(var7 != null) {
            bd var8 = (bd)var7.c();
            var10000 = var8.b;
            if(var9 != 0) {
               break;
            }

            if(((M)var10000).b() > var4) {
               var6 = var7;
               var4 = var8.b.b();
            }

            if(var4 < var2) {
               var7 = var7.b();
               if(var9 == 0) {
                  continue;
               }
            }
         }

         var10000 = var1.h(var6);
         break;
      }

      return (bd)var10000;
   }

   private double a(double var1, boolean var3) {
      if(this.b != null) {
         double var4 = var3?this.b.a():this.b.b();
         return Math.ceil((var1 - var4) / this.b.c() * this.b.c()) + var4;
      } else {
         return var1;
      }
   }

   private double b(double var1, boolean var3) {
      if(this.b != null) {
         double var4 = var3?this.b.a():this.b.b();
         return Math.floor((var1 - var4) / this.b.c() * this.b.c()) + var4;
      } else {
         return var1;
      }
   }

   static y.c.D a(bc var0) {
      return var0.c;
   }

   static y.c.D b(bc var0) {
      return var0.e;
   }

   static y.c.D c(bc var0) {
      return var0.d;
   }

   static double d(bc var0) {
      return var0.g;
   }

   static void a(bc var0, int var1, double var2, boolean var4) {
      var0.a(var1, var2, var4);
   }

   static y.c.D a(bc var0, y.c.D var1) {
      return var0.h = var1;
   }

   static y.c.D b(bc var0, y.c.D var1) {
      return var0.i = var1;
   }

   static HashMap e(bc var0) {
      return var0.f;
   }

   static y.c.p a(bc var0, bd var1, y.c.D var2) {
      return var0.a(var1, var2);
   }

   static double a(bc var0, int var1) {
      return var0.e(var1);
   }

   static L f(bc var0) {
      return var0.b;
   }
}
