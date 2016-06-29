package y.f.i.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import y.f.i.a.N;
import y.f.i.a.O;
import y.f.i.a.R;
import y.f.i.a.ab;
import y.f.i.a.l;
import y.f.i.a.m;
import y.f.i.a.o;
import y.f.i.a.p;
import y.f.i.a.q;
import y.f.i.a.r;
import y.f.i.a.s;
import y.f.i.a.t;
import y.f.i.a.u;

public class n implements O, l {
   private static final t a = new t();
   private static final u b = new u();
   private R c;
   private y.c.i d;
   private y.c.A e;
   private Map f;
   private Map g;
   private Map h;
   private Map i;
   private double j = 8.0D;
   private double k = 2.0D;
   private double l = 2.0D;
   private List m = new ArrayList();

   public void a(m var1) {
      this.m.add(var1);
   }

   public void b(m var1) {
      this.m.remove(var1);
   }

   protected void a(R var1, List var2) {
      int var5 = ab.a;
      if(!this.m.isEmpty()) {
         Iterator var3 = this.m.iterator();

         while(var3.hasNext()) {
            m var4 = (m)var3.next();
            var4.a(var1, var2);
            if(var5 != 0) {
               break;
            }
         }
      }

   }

   protected void a(R var1) {
      int var4 = ab.a;
      if(!this.m.isEmpty()) {
         Iterator var2 = this.m.iterator();

         while(var2.hasNext()) {
            m var3 = (m)var2.next();
            var3.b(var1);
            if(var4 != 0) {
               break;
            }
         }
      }

   }

   protected void b(R var1) {
      int var4 = ab.a;
      if(!this.m.isEmpty()) {
         Iterator var2 = this.m.iterator();

         while(var2.hasNext()) {
            m var3 = (m)var2.next();
            var3.a(var1);
            if(var4 != 0) {
               break;
            }
         }
      }

   }

   public void a(List var1, y.d.y var2) {
      int var8 = ab.a;
      if(this.d == null) {
         this.d = new y.c.i();
         this.f = new HashMap();
         this.i = new HashMap();
         this.g = new HashMap();
         this.h = new HashMap();
      }

      this.e = y.g.M.a();
      y.c.q var3 = this.d.d();
      this.c = new R(var2, this);
      this.e.a(var3, this.c);
      this.f.put(this.c, var3);
      y.c.D var4 = new y.c.D(var1);
      var4.sort(new o(this));
      y.c.D var5 = new y.c.D(var1);
      var5.sort(new p(this));
      this.i.put(this.c, new q(this.c, false, var4, var5));
      Iterator var6 = var1.iterator();

      while(true) {
         if(var6.hasNext()) {
            ArrayList var7 = new ArrayList();
            var7.add(this.c);
            this.h.put(var6.next(), var7);
            if(var8 != 0) {
               break;
            }

            if(var8 == 0) {
               continue;
            }
         }

         this.b(this.c);
         break;
      }

   }

   private boolean a(R var1, y.c.D var2) {
      int var5 = ab.a;
      y.c.C var3 = var2.m();

      boolean var10000;
      while(true) {
         if(var3.f()) {
            N var4 = (N)var3.d();
            var10000 = this.a(var4, var1);
            if(var5 != 0) {
               break;
            }

            if(!var10000) {
               return true;
            }

            var3.g();
            if(var5 == 0) {
               continue;
            }
         }

         var10000 = false;
         break;
      }

      return var10000;
   }

   private boolean a(N var1, R var2) {
      y.d.y var3 = var1.a();
      y.d.y var4 = var2.g();
      return var4.c() > var3.c() - 1.0E-6D && var4.c() + var4.a() < var3.c() + var3.a() + 1.0E-6D && var4.d() > var3.d() - 1.0E-6D && var4.d() + var4.b() < var3.d() + var3.b() + 1.0E-6D;
   }

   public void a() {
      int var3 = ab.a;
      if(this.c != null) {
         Iterator var1 = this.a(false).iterator();

         label20: {
            while(var1.hasNext()) {
               R var2 = (R)var1.next();
               var2.a();
               if(var3 != 0) {
                  break label20;
               }

               if(var3 != 0) {
                  break;
               }
            }

            this.c = null;
            this.d.j();
            this.f.clear();
            this.i.clear();
            this.g.clear();
            this.h.clear();
         }

         this.e = null;
      }

   }

   private void e(R var1) {
      int var18 = ab.a;
      q var2 = (q)this.i.get(var1);
      if(!var2.c) {
         y.c.D var3;
         R var8;
         R var9;
         label62: {
            var3 = var2.d;
            y.c.D var4 = var2.e;
            y.d.y var5 = var1.g();
            r var6 = this.a(var3, var5, a);
            r var7 = this.a(var4, var5, b);
            double var10;
            y.c.D var12;
            y.c.D var13;
            y.c.D var14;
            y.c.D var15;
            y.d.y var16;
            y.d.y var17;
            if(var7.b <= var6.b) {
               var10 = var7.a;
               var12 = new y.c.D();
               var13 = new y.c.D();
               this.a(var3, b, var10, var12, var13);
               var14 = new y.c.D();
               var15 = new y.c.D();
               this.a(var4, b, var10, var14, var15);
               var16 = new y.d.y(var1.h(), var1.i(), var1.l(), var10 - var1.i());
               var8 = this.a(var1, var12, var14, var16);
               var17 = new y.d.y(var1.h(), var10, var1.l(), var1.k() - var10);
               var9 = this.a(var1, var13, var15, var17);
               if(var18 == 0) {
                  break label62;
               }
            }

            var10 = var6.a;
            var12 = new y.c.D();
            var13 = new y.c.D();
            this.a(var3, a, var10, var12, var13);
            var14 = new y.c.D();
            var15 = new y.c.D();
            this.a(var4, a, var10, var14, var15);
            var16 = new y.d.y(var1.h(), var1.i(), var10 - var1.h(), var1.m());
            var8 = this.a(var1, var12, var14, var16);
            var17 = new y.d.y(var10, var1.i(), var1.j() - var10, var1.m());
            var9 = this.a(var1, var13, var15, var17);
         }

         q var11;
         q var19;
         label57: {
            var19 = (q)this.i.get(var8);
            var11 = (q)this.i.get(var9);
            if(var19.b) {
               var11.f.add(var8);
               if(var18 == 0) {
                  break label57;
               }
            }

            var11.g.add(var8);
         }

         label52: {
            if(var11.b) {
               var19.f.add(var9);
               if(var18 == 0) {
                  break label52;
               }
            }

            var19.g.add(var9);
         }

         ArrayList var20 = new ArrayList(var2.f.size() + var2.g.size());
         var20.addAll(var2.f);
         var20.addAll(var2.g);
         Iterator var21 = var20.iterator();

         while(var21.hasNext()) {
            R var24 = (R)var21.next();
            q var26 = (q)this.i.get(var24);
            var26.g.remove(var1);
            if(var18 != 0) {
               break;
            }
         }

         y.c.C var22 = var3.m();

         while(true) {
            if(var22.f()) {
               N var25 = (N)var22.d();
               List var27 = (List)this.h.get(var25);
               var27.remove(var1);
               var22.g();
               if(var18 != 0) {
                  break;
               }

               if(var18 == 0) {
                  continue;
               }
            }

            var2.a();
            var2.c = true;
            break;
         }

         List var23 = Arrays.asList(new R[]{var8, var9});
         this.a(var1, var23);
         if(var19.b) {
            this.a(var8);
         }

         if(var11.b) {
            this.a(var9);
         }

      }
   }

   private void a(y.c.D var1, s var2, double var3, y.c.D var5, y.c.D var6) {
      int var10 = ab.a;
      y.c.C var7 = var1.m();

      while(var7.f()) {
         N var8 = (N)var7.d();
         y.d.y var9 = var8.a();
         if(var2.a(var9) < var3 - 1.0E-6D) {
            var5.add(var8);
         }

         if(var2.b(var9) > var3 + 1.0E-6D) {
            var6.add(var8);
         }

         var7.g();
         if(var10 != 0) {
            break;
         }
      }

   }

   private r a(y.c.D var1, y.d.y var2, s var3) {
      int var29 = ab.a;
      double var4 = var3.a(var2);
      double var6 = var3.b(var2);
      double var8 = var3.c(var2);
      double var10 = var3.d(var2);
      double var12 = 0.0D;
      double var14 = Double.MAX_VALUE;
      int var16 = var1.size();
      int var17 = 0;
      int var18 = 0;
      int var19 = var16;
      y.c.D var20 = new y.c.D();
      y.c.C var21 = var1.m();

      label88:
      while(true) {
         int var10000 = var21.f();

         double var30;
         label85:
         while(true) {
            double var23;
            if(var10000 != 0) {
               N var22 = (N)var21.d();
               var30 = var3.a(var22.a());
               if(var29 != 0) {
                  break;
               }

               var23 = var30;

               double var25;
               label95: {
                  while(var20.size() > 0 && ((Double)var20.get(0)).doubleValue() <= var23 + 1.0E-6D) {
                     var25 = ((Double)var20.remove(0)).doubleValue();
                     ++var17;
                     --var18;
                     double var27 = this.a(var17, var19, var18) + this.a(var25, var4, var6, var8, var10);
                     if(var27 < var14) {
                        var14 = var27;
                        var12 = var25;
                        if(var29 != 0) {
                           break label95;
                        }

                        if(var29 != 0) {
                           break;
                        }
                     }
                  }

                  if(var23 > var4 + 1.0E-6D) {
                     var25 = this.a(var17, var19, var18) + this.a(var23, var4, var6, var8, var10);
                     if(var25 < var14) {
                        var14 = var25;
                        var12 = var23;
                     }
                  }

                  ++var18;
                  --var19;
                  var25 = var3.b(var22.a());
               }

               if(var25 + 1.0E-6D < var6) {
                  y.c.p var32 = var20.k();

                  while(var32 != null) {
                     double var33;
                     var10000 = (var33 = ((Double)var32.c()).doubleValue() - var25) == 0.0D?0:(var33 < 0.0D?-1:1);
                     if(var29 != 0) {
                        continue label85;
                     }

                     if(var10000 >= 0) {
                        break;
                     }

                     var32 = var32.a();
                     if(var29 != 0) {
                        break;
                     }
                  }

                  var20.a((Object)(new Double(var25)), (y.c.p)var32);
               }

               var21.g();
               if(var29 == 0) {
                  continue label88;
               }
            }

            while(var20.size() > 0) {
               double var31 = ((Double)var20.remove(0)).doubleValue();
               ++var17;
               --var18;
               var23 = this.a(var17, var19, var18) + this.a(var31, var4, var6, var8, var10);
               if(var23 < var14) {
                  var14 = var23;
                  var12 = var31;
                  if(var29 != 0) {
                     return new r((var6 + var4) / 2.0D, Double.MAX_VALUE);
                  }

                  if(var29 != 0) {
                     break;
                  }
               }
            }

            var30 = var14;
            break;
         }

         if(var30 < Double.MAX_VALUE) {
            return new r(var12, var14);
         }

         return new r((var6 + var4) / 2.0D, Double.MAX_VALUE);
      }
   }

   protected double a(int var1, int var2, int var3) {
      int var4 = var1 + var2 + var3;
      return this.j * ((double)var3 / (double)var4) + this.k * (double)Math.abs(var1 - var2) / (double)var4;
   }

   protected double a(double var1, double var3, double var5, double var7, double var9) {
      double var11 = var1 - var3;
      double var13 = var5 - var1;
      double var15 = var9 - var7;
      double var17 = var11 > var15?var15 / var11:var11 / var15;
      double var19 = var13 > var15?var15 / var13:var13 / var15;
      double var21 = Math.min(var17, var19);
      return (1.0D - var21) * this.l;
   }

   private R a(R var1, y.c.D var2, y.c.D var3, y.d.y var4) {
      int var14 = ab.a;
      if(var2.size() != var3.size()) {
         throw new IllegalArgumentException("Number of obstacles in horizontal and vertical list have to be identical");
      } else {
         R var7;
         q var8;
         Object var10000;
         label75: {
            label74: {
               label79: {
                  y.c.q var5 = (y.c.q)this.f.get(var1);
                  y.c.q var6 = this.d.d();
                  this.d.a(var5, var6);
                  var7 = new R(var4, this);
                  this.e.a(var6, var7);
                  this.f.put(var7, var6);
                  y.c.C var9;
                  N var10;
                  if(this.a(var7, var2)) {
                     var8 = new q(var7, false, var2, var3);
                     var9 = var2.m();

                     do {
                        if(!var9.f()) {
                           break label79;
                        }

                        var10 = (N)var9.d();
                        List var11 = (List)this.h.get(var10);
                        var11.add(var7);
                        var9.g();
                        if(var14 != 0) {
                           break label74;
                        }
                     } while(var14 == 0);
                  }

                  var8 = new q(var7, true, var2, var3);
                  var9 = var2.m();

                  while(var9.f()) {
                     var10 = (N)var9.d();
                     Object var17 = (List)this.g.get(var10);
                     var10000 = var17;
                     if(var14 != 0) {
                        break label75;
                     }

                     if(var17 == null) {
                        var17 = new ArrayList();
                        this.g.put(var10, var17);
                     }

                     ((List)var17).add(var7);
                     var9.g();
                     if(var14 != 0) {
                        break;
                     }
                  }
               }

               this.i.put(var7, var8);
            }

            var10000 = this.i.get(var1);
         }

         q var15 = (q)var10000;
         ArrayList var16 = new ArrayList(var15.f.size() + var15.g.size());
         var16.addAll(var15.f);
         var16.addAll(var15.g);
         Iterator var18 = var16.iterator();

         while(true) {
            if(var18.hasNext()) {
               R var12 = (R)var18.next();
               if(!a(var12, var7)) {
                  continue;
               }

               q var13 = (q)this.i.get(var12);
               if(var14 != 0) {
                  break;
               }

               label44: {
                  if(var8.b) {
                     var13.f.add(var7);
                     if(var14 == 0) {
                        break label44;
                     }
                  }

                  var13.g.add(var7);
               }

               if(var13.b) {
                  var8.f.add(var12);
                  if(var14 == 0) {
                     continue;
                  }
               }

               var8.g.add(var12);
               if(var14 == 0) {
                  continue;
               }
            }

            this.b(var7);
            break;
         }

         return var7;
      }
   }

   public List c(R var1) {
      int var6 = ab.a;
      q var2 = (q)this.i.get(var1);

      while(var2.g.size() > 0) {
         Object[] var3 = var2.g.toArray();
         int var4 = 0;

         while(var4 < var3.length) {
            R var5 = (R)var3[var4];
            this.e(var5);
            ++var4;
            if(var6 != 0 || var6 != 0) {
               return var2.f;
            }
         }
      }

      return var2.f;
   }

   public List d(R var1) {
      q var2 = (q)this.i.get(var1);
      return (List)(var2.d == null?Collections.EMPTY_LIST:var2.d);
   }

   public List a(N var1) {
      int var5 = ab.a;
      List var2 = (List)this.h.get(var1);

      Object var10000;
      label30:
      while(true) {
         if(!var2.isEmpty()) {
            Object[] var3 = var2.toArray();
            int var4 = 0;

            do {
               if(var4 >= var3.length) {
                  continue label30;
               }

               var10000 = this;
               if(var5 != 0) {
                  break label30;
               }

               this.e((R)var3[var4]);
               ++var4;
            } while(var5 == 0 && var5 == 0);
         }

         var10000 = this.g.get(var1);
         break;
      }

      List var6 = (List)var10000;
      return (List)(var6 == null?Collections.EMPTY_LIST:new ArrayList(var6));
   }

   public List a(y.d.y var1) {
      int var10 = ab.a;
      y.c.D var2 = new y.c.D();
      y.c.D var3 = new y.c.D();
      var3.add(this.c);

      while(!var3.isEmpty()) {
         R var4 = (R)var3.remove(0);
         q var5 = (q)this.i.get(var4);
         if(y.d.y.a(var4.g(), var1)) {
            if(var5.b) {
               var2.add(var4);
               if(var10 == 0) {
                  continue;
               }
            }

            if(!var5.c) {
               this.e(var4);
            }

            y.c.q var6 = (y.c.q)this.f.get(var4);
            y.c.x var7 = var6.o();

            while(var7.f()) {
               y.c.q var8 = var7.e();
               R var9 = (R)this.e.b(var8);
               var3.add(var9);
               var7.g();
               if(var10 != 0 || var10 != 0) {
                  return var2;
               }
            }
         }
      }

      return var2;
   }

   public y.d.y b() {
      return this.c != null?this.c.g():null;
   }

   List a(boolean var1) {
      ArrayList var2 = new ArrayList();
      this.a(this.c, var2, var1);
      return var2;
   }

   private void a(R var1, List var2, boolean var3) {
      int var9 = ab.a;
      q var4 = (q)this.i.get(var1);
      if(var4.b || !var3 && !var4.c) {
         var2.add(var1);
         if(var9 == 0) {
            return;
         }
      }

      if(!var4.c) {
         this.e(var1);
      }

      y.c.q var5 = (y.c.q)this.f.get(var1);
      y.c.x var6 = var5.o();

      while(var6.f()) {
         y.c.q var7 = var6.e();
         R var8 = (R)this.e.b(var7);
         this.a(var8, var2, var3);
         var6.g();
         if(var9 != 0) {
            break;
         }
      }

   }

   private static boolean a(R var0, R var1) {
      byte var13;
      int var23;
      label86: {
         var23 = ab.a;
         double var2 = var0.h();
         double var4 = var0.j();
         double var6 = var1.h();
         double var8 = var1.j();
         var13 = 2;
         if(Math.abs(var4 - var6) < 1.0E-6D || Math.abs(var2 - var8) < 1.0E-6D) {
            var13 = 0;
            if(var23 == 0) {
               break label86;
            }
         }

         if(var6 <= var4 && var2 <= var6 || var2 <= var8 && var6 <= var2) {
            var13 = 1;
         }
      }

      double var14 = var0.i();
      double var16 = var0.k();
      double var18 = var1.i();
      double var20 = var1.k();
      byte var22 = 2;
      if(Math.abs(var16 - var18) < 1.0E-6D || Math.abs(var14 - var20) < 1.0E-6D) {
         var22 = 0;
         if(var23 == 0) {
            return var13 == 1 && var22 == 0 || var13 == 0 && var22 == 1;
         }
      }

      if(var18 <= var16 && var14 <= var18 || var14 <= var20 && var18 <= var14) {
         var22 = 1;
      }

      return var13 == 1 && var22 == 0 || var13 == 0 && var22 == 1;
   }
}
