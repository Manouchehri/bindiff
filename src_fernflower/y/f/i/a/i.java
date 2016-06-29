package y.f.i.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import y.f.i.a.M;
import y.f.i.a.Z;
import y.f.i.a.ab;
import y.f.i.a.ac;
import y.f.i.a.ah;
import y.f.i.a.ai;
import y.f.i.a.aj;
import y.f.i.a.bs;
import y.f.i.a.h;
import y.f.i.a.j;
import y.f.i.a.k;
import y.f.i.a.w;
import y.f.i.a.x;
import y.f.i.a.y;

public class i {
   private static final k a = new k((j)null);
   private Z b;
   private HashMap c = new HashMap();

   public void a(Z var1) {
      this.b = var1;
   }

   public void a() {
      this.c.clear();
      this.b = null;
   }

   private y.f.X b() {
      return this.b.a();
   }

   public void a(y.c.f var1, ac var2) {
      int var9 = ab.a;
      y.f.X var3 = this.b();
      if(var3.h() != 0) {
         y.c.D var4 = null;
         boolean var5 = false;
         int var6 = 0;

         while(true) {
            if(var6 < 2) {
               label45: {
                  this.c.clear();
                  var4 = this.a(var2);
                  this.a(var4);
                  Comparator var7 = this.a(var4, var2, this.b);
                  this.a(var4, var7);
                  if(var9 != 0) {
                     break;
                  }

                  if(!var5) {
                     var5 = this.a(var4, var2);
                     if(!var5) {
                        break label45;
                     }
                  }

                  ++var6;
                  if(var9 == 0) {
                     continue;
                  }
               }
            }

            this.b(var4);
            break;
         }

         y.c.e var10 = var1.a();

         while(true) {
            if(var10.f()) {
               y.c.d var11 = var10.a();
               w var8 = var2.a(var11);
               var3.a(var11, var8.g());
               var10.g();
               if(var9 != 0) {
                  break;
               }

               if(var9 == 0) {
                  continue;
               }
            }

            var2.a(var5);
            break;
         }

      }
   }

   private boolean a(y.c.D var1, ac var2) {
      int var6 = ab.a;
      boolean var3 = false;
      Iterator var4 = var1.iterator();

      boolean var10000;
      while(true) {
         if(var4.hasNext()) {
            h var5 = (h)var4.next();
            var10000 = var3 | this.a(var5, var2);
            if(var6 != 0) {
               break;
            }

            var3 = var10000;
            if(var6 == 0) {
               continue;
            }
         }

         var10000 = var3;
         break;
      }

      return var10000;
   }

   private boolean a(h var1, ac var2) {
      int var36 = ab.a;
      boolean var3 = false;
      List var4 = var1.d();
      ai var5 = null;
      Iterator var6 = var4.iterator();

      while(var6.hasNext()) {
         ai var7 = (ai)var6.next();
         boolean var8 = var5 != null && a(var5, var7) && a(var5, var7, var1);
         if(var8) {
            w var9 = this.a(var5, var2);
            w var10 = this.a(var7, var2);
            M var11 = this.a(var5, var9);
            M var12 = this.a(var7, var10);
            boolean var13 = var11 != null && var12 != null && var11.b(var12) == 0.0D;
            if(var13) {
               M var14 = M.a(var11, var12);
               boolean var15 = var14.d() < var11.d() && var14.d() < var12.d();
               if(var15) {
                  boolean var16 = var11.a() < var12.a();
                  ai var17 = var16?var5:var7;
                  ai var18 = var16?var7:var5;
                  M var19 = b(var14, var17);
                  M var20 = a(var14, var18);
                  boolean var21 = !this.a(var17);
                  boolean var22 = this.a(var17, var19, var21, var2);
                  boolean var23 = this.a(var18);
                  boolean var24 = this.a(var18, var20, var23, var2);
                  if(var22 || var24) {
                     boolean var25 = var22;
                     if(var22 && var24) {
                        var25 = var19.d() >= var20.d();
                     }

                     ai var26 = var25?var17:var18;
                     boolean var27 = this.a(var26);
                     w var28 = var25 ^ var16?var10:var9;
                     boolean var29 = var25?var21:var23;
                     int var30 = var29?var26.j() - 1:var26.j() + 1;
                     M var31 = var25?var19:var20;
                     ai var32 = var28.a(var30);
                     boolean var33 = this.a(var32);
                     boolean var34 = var25 ^ var27;
                     boolean var35 = var34 ^ var33;
                     this.a(var26, var32, var35, var34, var31, var14, var2);
                     var3 = true;
                  }
               }
            }
         }

         var5 = var7;
         if(var36 != 0) {
            break;
         }
      }

      return var3;
   }

   private static M a(M var0, ai var1) {
      M var2 = null;
      if(var1.a() == null) {
         var2 = new M(var0.b(), var1.b().b());
      } else if(var0.b() < var1.a().a()) {
         var2 = M.c(var1.a(), var0);
      }

      return var2;
   }

   private static M b(M var0, ai var1) {
      M var2 = null;
      if(var1.a() == null) {
         var2 = new M(var1.b().a(), var0.a());
      } else if(var1.a().b() < var0.a()) {
         var2 = M.c(var1.a(), var0);
      }

      return var2;
   }

   private static boolean a(ai var0, ai var1, h var2) {
      return Math.abs(var2.b(var0) - var2.b(var1)) < 1.0D;
   }

   private static boolean a(ai var0, ai var1) {
      return var0.k() == null || var0.k() != var1.k();
   }

   private void a(ai var1, ai var2, boolean var3, boolean var4, M var5, M var6, ac var7) {
      int var30 = ab.a;
      int var8 = var1.j();
      int var9 = var2.j();
      ah var10 = var8 < var9?var1.k():var2.k();
      double var35;
      if(var10 == null) {
         w var11 = var7.a(var1.i());
         ai var12 = this.a(var1, var2, var3, var5);
         ai var13 = this.a(var1, var2, var4, var5, var6);
         M var14 = var1.a();
         if(var14 != null) {
            boolean var15 = var4 ^ this.a(var1);
            double var16 = var15?var14.a():var14.b();
            var1.a(new M(var16, var16));
         }

         var14 = var2.a();
         if(var14 != null) {
            var35 = var3?var14.b():var14.a();
            var2.a(new M(var35, var35));
         }

         var11.a(var12, var13);
         if(var30 == 0) {
            return;
         }
      }

      y.c.D var31 = new y.c.D();
      ah var32 = new ah(var5, var31);
      y.c.D var33 = new y.c.D();
      ah var34 = new ah((M)null, var33);
      var35 = Double.MAX_VALUE;
      double var17 = -1.7976931348623157E308D;
      Iterator var19 = var10.b().iterator();

      label77: {
         Object var10000;
         while(true) {
            if(var19.hasNext()) {
               y.c.d var20 = ((ai)var19.next()).i();
               w var21 = var7.a(var20);
               ai var22 = var21.a(var8);
               ai var23 = var21.a(var9);
               ai var24 = this.a(var22, var23, var3, var5);
               var24.a(var32);
               var31.add(var24);
               ai var25 = this.a(var22, var23, var4, var5, var6);
               var33.add(var25);
               var35 = Math.min(var35, var25.c().a());
               var17 = Math.max(var17, var25.c().b());
               M var26 = var22.a();
               var10000 = var26;
               if(var30 != 0) {
                  break;
               }

               if(var26 != null) {
                  boolean var27 = var4 ^ this.a(var22);
                  double var28 = var27?var26.a():var26.b();
                  var22.a(new M(var28, var28));
               }

               var26 = var23.a();
               if(var26 != null) {
                  double var37 = var3?var26.b():var26.a();
                  var23.a(new M(var37, var37));
               }

               var21.a(var24, var25);
               if(var30 == 0) {
                  continue;
               }
            }

            var32.d();
            var34.a(new M(var35, var17));
            var19 = var33.iterator();
            if(!var19.hasNext()) {
               break label77;
            }

            var10000 = var19.next();
            break;
         }

         while(true) {
            ai var36 = (ai)var10000;
            var36.a(var34);
            if(var30 != 0) {
               return;
            }

            if(var30 != 0 || !var19.hasNext()) {
               break;
            }

            var10000 = var19.next();
         }
      }

      var34.d();
   }

   private ai a(ai var1, ai var2, boolean var3, M var4, M var5) {
      M var6 = new M(var2.b().a() + 1.0D, var2.b().b() - 1.0D);
      int var7 = var3?var1.j():var1.j() + 2;
      return new ai(var1.i(), var7, var1.h(), var6, var5, M.b(var4, var5), (List)null);
   }

   private ai a(ai var1, ai var2, boolean var3, M var4) {
      M var5 = var3?new M(var2.b().a(), var2.b().a()):new M(var2.b().b(), var2.b().b());
      return new ai(var1.i(), var1.j() + 1, var2.h(), var4, var5, var2.b(), (List)null);
   }

   private boolean a(ai var1, M var2, boolean var3, ac var4) {
      int var11 = ab.a;
      if(var2 == null) {
         return false;
      } else if(var1.k() == null) {
         return true;
      } else {
         y.f.y var5 = null;
         int var6 = var3?var1.j() - 1:var1.j() + 1;
         if(var6 < 0) {
            return false;
         } else {
            Iterator var7 = var1.k().b().iterator();

            boolean var10000;
            while(true) {
               if(var7.hasNext()) {
                  ai var8 = (ai)var7.next();
                  w var9 = var4.a(var8.i());
                  if(var9.e() <= var6) {
                     return false;
                  }

                  y.f.y var10 = var9.a(var6).h();
                  if(var5 == null) {
                     var5 = var10;
                     if(var11 == 0) {
                        continue;
                     }
                  }

                  if(var5.equals(var10)) {
                     continue;
                  }

                  var10000 = false;
                  if(var11 == 0) {
                     return false;
                  }
                  break;
               }

               var10000 = true;
               break;
            }

            return var10000;
         }
      }
   }

   private w a(ai var1, ac var2) {
      w var3;
      if(var1.i() == null) {
         ai var4 = (ai)var1.k().b().get(0);
         var3 = var2.a(var4.i());
         if(ab.a == 0) {
            return var3;
         }
      }

      var3 = var2.a(var1.i());
      return var3;
   }

   private boolean a(ai var1) {
      return var1.h() == y.f.y.b || var1.h() == y.f.y.c;
   }

   private M a(ai var1, w var2) {
      int var3;
      double var4;
      ai var8;
      h var9;
      int var10;
      label48: {
         var10 = ab.a;
         var3 = var1.j();
         if(var3 == 0) {
            if(this.a(var1)) {
               var4 = var1.b().a();
               if(var10 == 0) {
                  break label48;
               }
            }

            var4 = var1.b().b();
            if(var10 == 0) {
               break label48;
            }
         }

         var8 = var2.a(var3 - 1);
         if(var8.k() != null) {
            var8 = var8.k().c();
         }

         var9 = (h)this.c.get(var8);
         if(var9 == null) {
            return null;
         }

         var4 = var9.b(var8);
      }

      double var6;
      if(var3 == var2.e() - 1) {
         if(this.a(var1)) {
            var6 = var1.b().b();
            if(var10 == 0) {
               return new M(var4, var6);
            }
         }

         var6 = var1.b().a();
         if(var10 == 0) {
            return new M(var4, var6);
         }
      }

      var8 = var2.a(var3 + 1);
      if(var8.k() != null) {
         var8 = var8.k().c();
      }

      var9 = (h)this.c.get(var8);
      if(var9 == null) {
         return null;
      } else {
         var6 = var9.b(var8);
         return new M(var4, var6);
      }
   }

   private void a(y.c.D var1) {
      int var7 = ab.a;
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         h var3 = (h)var2.next();
         Iterator var4 = var3.d().iterator();

         while(var4.hasNext()) {
            ai var5 = (ai)var4.next();
            x var6 = this.b.c().a(var5.i());
            var5.b(var6.c());
            if(var7 != 0 || var7 != 0) {
               return;
            }
         }
      }

   }

   protected Comparator a(y.c.D var1, ac var2, Z var3) {
      return new aj(var1, var2, var3);
   }

   private boolean b(ai var1, ai var2) {
      y var3 = this.b.c();
      double var4 = var3.a(var1.i()).c();
      double var6 = var3.a(var2.i()).c();
      double var8 = Math.max(var4, var6);
      return var1.b().a(var2.b()) && var1.c().b(var2.c()) < var8;
   }

   private y.c.D a(List var1) {
      int var13 = ab.a;
      Collections.sort(var1, a);
      y.c.D var2 = new y.c.D();
      y.c.D var3 = new y.c.D();
      Iterator var4 = var1.iterator();

      Object var10000;
      label109:
      while(true) {
         if(var4.hasNext()) {
            label115: {
               ai var5 = (ai)var4.next();
               double var6 = var5.c().a();
               y.c.D var8 = new y.c.D();
               var10000 = var3.m();
               if(var13 != 0) {
                  break;
               }

               Object var9 = var10000;

               h var10;
               int var20;
               while(true) {
                  if(!((y.c.C)var9).f()) {
                     var3.removeAll(var8);
                     break;
                  }

                  var10 = (h)((y.c.C)var9).d();
                  double var11 = this.d(var10);
                  double var21;
                  var20 = (var21 = var10.a().b() + var11 - var6) == 0.0D?0:(var21 < 0.0D?-1:1);
                  if(var13 != 0) {
                     break;
                  }

                  if(var20 < 0) {
                     var8.add(var10);
                  }

                  ((y.c.C)var9).g();
                  if(var13 != 0) {
                     var3.removeAll(var8);
                     break;
                  }
               }

               var2.a(var8);
               y.c.D var16 = new y.c.D();
               y.c.C var17 = var3.m();

               while(true) {
                  if(!var17.f()) {
                     var20 = var16.size();
                     break;
                  }

                  h var18 = (h)var17.d();
                  var20 = this.a(var18, var5);
                  if(var13 != 0) {
                     break;
                  }

                  if(var20 != 0) {
                     var16.add(var18);
                  }

                  var17.g();
                  if(var13 != 0) {
                     var20 = var16.size();
                     break;
                  }
               }

               if(var20 == 0) {
                  var10 = new h(var5);
                  var3.add(var10);
                  continue;
               }

               if(var16.size() == 1) {
                  var10 = (h)var16.get(0);
                  var10.a(var5);
                  continue;
               }

               var10 = new h(var5);
               y.c.C var19 = var16.m();

               while(var19.f()) {
                  h var12 = (h)var19.d();
                  var10.a(var12);
                  var19.g();
                  if(var13 != 0) {
                     if(var13 == 0) {
                        continue label109;
                     }
                     break label115;
                  }

                  if(var13 != 0) {
                     break;
                  }
               }

               var3.removeAll(var16);
               var3.add(var10);
               if(var13 == 0) {
                  continue;
               }
            }
         }

         var2.a(var3);
         var4 = var2.iterator();
         if(!var4.hasNext()) {
            return var2;
         }

         var10000 = var4.next();
         break;
      }

      while(true) {
         h var14 = (h)var10000;
         Iterator var15 = var14.d().iterator();

         while(var15.hasNext()) {
            ai var7 = (ai)var15.next();
            this.c.put(var7, var14);
            if(var13 != 0 || var13 != 0) {
               return var2;
            }
         }

         if(!var4.hasNext()) {
            return var2;
         }

         var10000 = var4.next();
      }
   }

   private double d(h var1) {
      int var8 = ab.a;
      double var2 = 0.0D;
      Iterator var4 = var1.d().iterator();

      double var10000;
      while(true) {
         if(var4.hasNext()) {
            ai var5 = (ai)var4.next();
            double var6 = this.b.c().a(var5.i()).c();
            var10000 = Math.max(var2, var6);
            if(var8 != 0) {
               break;
            }

            var2 = var10000;
            if(var8 == 0) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      return var10000;
   }

   private boolean a(h var1, ai var2) {
      int var5 = ab.a;
      Iterator var3 = var1.d().iterator();

      boolean var10000;
      while(true) {
         if(var3.hasNext()) {
            ai var4 = (ai)var3.next();
            if(!this.b(var2, var4)) {
               continue;
            }

            var10000 = true;
            if(var5 == 0) {
               return true;
            }
            break;
         }

         var10000 = false;
         break;
      }

      return var10000;
   }

   private y.c.D a(ac var1) {
      int var9 = ab.a;
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();
      y.c.e var4 = this.b().p();

      label39:
      do {
         boolean var10000 = var4.f();

         label36:
         while(true) {
            if(!var10000) {
               break label39;
            }

            y.c.d var5 = var4.a();
            w var6 = var1.a(var5);
            if(var6 == null) {
               break;
            }

            int var7 = 0;

            while(true) {
               if(var7 >= var6.e()) {
                  break label36;
               }

               ai var8 = var6.a(var7);
               var10000 = var8.g();
               if(var9 != 0) {
                  break;
               }

               label31: {
                  if(var10000) {
                     var3.add(var8);
                     if(var9 == 0) {
                        break label31;
                     }
                  }

                  var2.add(var8);
               }

               ++var7;
               if(var9 != 0) {
                  break label36;
               }
            }
         }

         var4.g();
      } while(var9 == 0);

      y.c.D var10 = this.a((List)var2);
      y.c.D var11 = this.a((List)var3);
      var10.a(var11);
      return var10;
   }

   private void a(y.c.D var1, Comparator var2) {
      int var5 = ab.a;
      y.c.C var3 = var1.m();

      while(var3.f()) {
         h var4 = (h)var3.d();
         this.a(var4, var2);
         var3.g();
         if(var5 != 0) {
            break;
         }
      }

   }

   private void a(h var1, Comparator var2) {
      List var3 = var1.d();
      this.a(var3, var2);
      this.e(var1);
      this.a(var1);
      this.b(var1);
      this.c(var1);
   }

   protected void a(List var1, Comparator var2) {
      int var9 = ab.a;
      y.c.D var3 = new y.c.D();
      Iterator var4 = var1.iterator();

      Object var10;
      label46:
      while(true) {
         int var10000 = var4.hasNext();

         label43:
         while(var10000 != 0) {
            ai var5 = (ai)var4.next();
            y.c.p var6 = null;
            var10 = var3;
            if(var9 != 0) {
               break label46;
            }

            y.c.p var7 = var3.l();

            while(var7 != null) {
               int var8;
               var10000 = var8 = var2.compare(var5, var7.c());
               if(var9 != 0) {
                  continue label43;
               }

               if(var10000 > 0) {
                  break;
               }

               if(var8 < 0) {
                  var6 = var7;
               }

               var7 = var7.b();
               if(var9 != 0) {
                  break;
               }
            }

            if(var6 != null) {
               var3.a((Object)var5, (y.c.p)var6);
               if(var9 == 0) {
                  continue label46;
               }
            }

            var3.b((Object)var5);
            if(var9 == 0) {
               continue label46;
            }
            break;
         }

         var1.clear();
         var10 = var1;
         break;
      }

      ((List)var10).addAll(var3);
   }

   private void b(y.c.D var1) {
      int var4 = ab.a;
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         h var3 = (h)var2.next();
         this.f(var3);
         this.g(var3);
         if(var4 != 0) {
            break;
         }
      }

   }

   private void e(h var1) {
      int var10 = ab.a;
      List var2 = var1.d();
      y.c.D var3 = new y.c.D();
      HashSet var4 = new HashSet();
      Iterator var5 = var2.iterator();

      boolean var10000;
      while(true) {
         if(var5.hasNext()) {
            ai var6 = (ai)var5.next();
            ah var7 = var6.k();
            if(var7 == null) {
               continue;
            }

            double var8 = Math.max(var6.m(), var7.c().m());
            var7.c().b(var8);
            var10000 = var4.add(var7);
            if(var10 != 0) {
               break;
            }

            if(!var10000) {
               continue;
            }

            var3.add(var7);
            if(var10 == 0) {
               continue;
            }
         }

         var5 = var3.iterator();
         var10000 = var5.hasNext();
         break;
      }

      while(var10000) {
         ah var11 = (ah)var5.next();
         int var12 = 0;
         Iterator var13 = var11.b().iterator();

         label40: {
            while(var13.hasNext()) {
               ai var9 = (ai)var13.next();
               var12 += var2.indexOf(var9);
               if(var10 != 0) {
                  break label40;
               }

               if(var10 != 0) {
                  break;
               }
            }

            var12 /= var11.b().size();
         }

         ai var14 = var11.c();
         this.c.put(var14, var1);
         var2.add(var12, var14);
         var2.removeAll(var11.b());
         var1.a(var11);
         if(var10 != 0) {
            break;
         }

         var10000 = var5.hasNext();
      }

   }

   protected void a(h var1) {
      (new bs(var1, this.b)).a();
   }

   protected void b(h var1) {
      (new bs(var1, this.b)).b();
   }

   protected void c(h var1) {
      bs.a(var1, this.b);
   }

   private void f(h var1) {
      int var6 = ab.a;
      Iterator var2 = var1.d().iterator();

      while(var2.hasNext()) {
         ai var3 = (ai)var2.next();
         if(!var3.f()) {
            double var4 = var1.b(var3);
            var3.a(var4);
            if(var6 != 0) {
               break;
            }
         }
      }

   }

   private void g(h var1) {
      int var10 = ab.a;
      List var2 = var1.d();
      int var3 = 0;
      int var4 = var1.e();

      do {
         int var10000 = var3;

         label29:
         while(true) {
            if(var10000 >= var4) {
               return;
            }

            ah var5 = var1.b(var3);
            ai var6 = var5.c();
            int var7 = var2.indexOf(var6);
            var2.remove(var6);
            Iterator var8 = var5.b().iterator();

            while(true) {
               if(!var8.hasNext()) {
                  break label29;
               }

               ai var9 = (ai)var8.next();
               var10000 = var9.f();
               if(var10 != 0) {
                  break;
               }

               if(var10000 == 0) {
                  var9.a(var6.e());
               }

               var2.add(var7, var9);
               if(var10 != 0) {
                  break label29;
               }
            }
         }

         ++var3;
      } while(var10 == 0);

   }
}
