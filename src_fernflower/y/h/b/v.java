package y.h.b;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import y.f.c.a.bh;
import y.f.c.a.bk;
import y.f.c.a.bt;
import y.h.bu;
import y.h.fj;
import y.h.b.A;
import y.h.b.B;
import y.h.b.C;
import y.h.b.D;
import y.h.b.E;
import y.h.b.F;
import y.h.b.G;
import y.h.b.H;
import y.h.b.I;
import y.h.b.a;
import y.h.b.aa;
import y.h.b.c;
import y.h.b.f;
import y.h.b.i;
import y.h.b.w;
import y.h.b.x;
import y.h.b.y;
import y.h.b.z;

public class v {
   private I a;
   private y.c.A b;
   private y.c.c c;
   private y.c.c d;
   private Map e;
   private boolean f = true;
   private bk g;
   private Map h;
   private Map i;
   private boolean j;
   private boolean k = false;
   private double l = 30.0D;
   private HashSet m;

   public double a() {
      return this.l;
   }

   public boolean b() {
      return this.j;
   }

   public void a(boolean var1) {
      this.j = var1;
   }

   public boolean c() {
      return this.f;
   }

   public void a(bu var1) {
      this.b(var1);
      this.c(var1);
   }

   public void b(bu var1) {
      int var7 = a.H;
      this.m = new HashSet();
      y.h.a.v var2 = var1.C();
      y.c.x var3 = var2.p((y.c.q)null);

      while(var3.f()) {
         y.c.q var4 = var3.e();
         if(var2.k(var4)) {
            fj var5 = c(var1, var4);
            if(var5 instanceof a) {
               a var6 = (a)var5;
               if(var6.k()) {
                  var6.c(false);
                  this.m.add(var6);
               }
            }
         }

         var3.g();
         if(var7 != 0) {
            break;
         }
      }

   }

   public void c(bu var1) {
      this.a = I.a(var1);
      if(this.a != null) {
         this.g(var1);
      }

   }

   private void g(bu var1) {
      int var29 = a.H;
      this.b = var1.t();
      this.e = new HashMap();
      this.h = new HashMap();
      this.i = new HashMap();
      HashMap var2 = new HashMap();
      boolean var3 = !this.b();
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      double var8 = 0.0D;
      double var10 = 0.0D;
      ArrayList var12 = new ArrayList(this.a.b());
      if(this.k) {
         Collections.sort(var12, new A(var3, this.a, var1));
      }

      Iterator var13 = var12.iterator();

      label142: {
         while(true) {
            if(var13.hasNext()) {
               i var14;
               B var19;
               Object var20;
               label148: {
                  var14 = (i)var13.next();
                  B var15 = new B();
                  G var16 = new G((Rectangle2D)null, var15);
                  this.a((Collection)var14.o(), (C)var16, (B)var15);
                  this.h.put(var14, var15);
                  B var17 = new B();
                  H var18 = new H((Rectangle2D)null, var17);
                  this.a((Collection)var14.l(), (C)var18, (B)var17);
                  this.i.put(var14, var17);
                  ++var4;
                  if(var3) {
                     if(var6 < var15.e.size()) {
                        var6 = var15.e.size();
                     }

                     var5 += var17.e.size();
                     var19 = var17;
                     var20 = var16;
                     if(var29 == 0) {
                        break label148;
                     }
                  }

                  if(var5 < var17.e.size()) {
                     var5 = var17.e.size();
                  }

                  var6 += var15.e.size();
                  var19 = var15;
                  var20 = var18;
               }

               var2.put(var14, new Integer(var7));
               var7 += var19.e.size() + 3;
               y.d.r var21 = var14.d();
               if(var8 < var19.b + ((C)var20).c(var21)) {
                  var8 = var19.b + ((C)var20).c(var21);
               }

               if(var10 >= var19.d + ((C)var20).d(var21)) {
                  continue;
               }

               var10 = var19.d + ((C)var20).d(var21);
               if(var29 != 0) {
                  break;
               }

               if(var29 == 0) {
                  continue;
               }
            }

            if(var3) {
               this.g = new bk(var6 + 2, var5 + 3 * var4 - 1);
               bt var30 = this.g.a(0);
               var30.a(var8);
               var30.a(true);
               bt var33 = this.g.a(var6 + 1);
               var33.a(var10);
               var33.a(true);
               break label142;
            }

            this.g = new bk(var6 + 3 * var4 - 1, var5 + 2);
            break;
         }

         y.f.c.a.l var31 = this.g.b(0);
         var31.a(var8);
         var31.a(true);
         y.f.c.a.l var34 = this.g.b(var5 + 1);
         var34.a(var10);
         var34.a(true);
      }

      ArrayList var32 = new ArrayList(this.a.b());
      y.g.e.a((List)var32, new w(this, var3));
      Iterator var35 = var32.iterator();

      label120:
      while(true) {
         if(var35.hasNext()) {
            i var36 = (i)var35.next();
            int var39 = ((Integer)var2.get(var36)).intValue();
            if(var39 > 0) {
               label156: {
                  if(var3) {
                     this.g.b(var39 - 1).a(this.a());
                     if(var29 == 0) {
                        break label156;
                     }
                  }

                  this.g.a(var39 - 1).a(this.a());
               }
            }

            B var22;
            HashMap var23;
            y.c.q var40;
            ArrayList var41;
            Double var43;
            B var44;
            label109: {
               var40 = this.a.a(var36);
               var41 = new ArrayList();
               a((y.h.a.v)y.h.a.v.a((y.c.i)var1), (y.c.q)var40, (Collection)var41);
               fj var42 = var1.t(var40);
               var43 = new Double(var42.getX(), var42.getY(), var42.getWidth(), var42.getHeight());
               var44 = (B)this.h.get(var36);
               var22 = (B)this.i.get(var36);
               y.g.e.a((List)var41, new x(this, var1));
               var23 = new HashMap();
               G var24 = new G(var43, var44);
               if(var3) {
                  this.a(var24, new D(this.g), var36.d().a + var22.b, var41, var23, var1);
                  if(var29 == 0) {
                     break label109;
                  }
               }

               this.a(var24, new D(this.g), var36, var39, var41, var22, var23, var1);
            }

            HashMap var25;
            label104: {
               y.g.e.a((List)var41, new y(this, var1));
               var25 = new HashMap();
               H var26 = new H(var43, var22);
               if(var3) {
                  this.a(var26, new z(this.g), var36, var39, var41, var44, var25, var1);
                  if(var29 == 0) {
                     break label104;
                  }
               }

               this.a(var26, new z(this.g), var36.d().b + var44.b, var41, var25, var1);
            }

            label99: {
               if(var3) {
                  this.b.a(var40, this.g.a(0, var39, var6 + 1, var39 + var22.e.size() + 1));
                  if(var29 == 0) {
                     break label99;
                  }
               }

               this.b.a(var40, this.g.a(var39, 0, var39 + var44.e.size() + 1, var5 + 1));
            }

            Iterator var27 = var41.iterator();

            do {
               if(!var27.hasNext()) {
                  continue label120;
               }

               y.c.q var28 = (y.c.q)var27.next();
               this.b.a(var28, this.g.a((bt)var23.get(var28), (y.f.c.a.l)var25.get(var28)));
               if(var29 != 0) {
                  break;
               }

               if(var29 != 0) {
                  return;
               }
            } while(var29 == 0);
         }

         if(!this.a.a().isEmpty()) {
            bh var37;
            Iterator var38;
            if(var3) {
               this.g.c().a(this.a());
               var37 = this.g.a(this.g.c(), this.g.b(1));
               var38 = this.a.a().iterator();

               while(var38.hasNext()) {
                  this.b.a(var38.next(), var37);
                  if(var29 != 0) {
                     return;
                  }
               }
            } else {
               this.g.d().a(this.a());
               var37 = this.g.a(this.g.a(1), this.g.d());
               var38 = this.a.a().iterator();

               while(var38.hasNext()) {
                  this.b.a(var38.next(), var37);
                  if(var29 != 0) {
                     return;
                  }

                  if(var29 != 0) {
                     break;
                  }
               }
            }
         }

         this.c = var1.c(bk.a);
         var1.a((Object)bk.a, (y.c.c)y.g.q.a((Object)this.g));
         this.d = var1.c(bk.b);
         var1.a((Object)bk.b, (y.c.c)this.b);
         return;
      }
   }

   private void a(C var1, F var2, double var3, List var5, Map var6, bu var7) {
      double var8;
      int var36;
      label165: {
         var36 = a.H;
         var8 = var1.a();
         Object var10 = var2.a(0);
         if(var10 instanceof y.f.c.a.l) {
            y.f.c.a.l var11 = (y.f.c.a.l)var10;
            var11.e(var11.b());
            var11.f(var8);
            if(var36 == 0) {
               break label165;
            }
         }

         bt var37 = (bt)var10;
         var37.f(var37.b());
         var37.e(var8);
      }

      int var38 = 0;
      int var12 = 1;
      double var13 = var3;
      Object var15 = var1.c().iterator();

      boolean var10000;
      while(true) {
         if(((Iterator)var15).hasNext()) {
            Object var16 = ((Iterator)var15).next();
            Object var17 = var2.a(var12);
            var2.a(var17, true);
            y.d.r var18 = var1.c(var16);
            double var19 = Math.max(var1.c(var18), 0.0D);
            double var21 = Math.max(var1.d(var18), 0.0D);
            var10000 = this.c();
            if(var36 != 0) {
               break;
            }

            double var23;
            Object var42;
            label153: {
               var23 = Math.max(var10000?var1.b(var16):var1.a(var16), var19 + var21);
               byte var10001;
               int var40;
               if(!((Iterator)var15).hasNext()) {
                  int var25 = var12 + 1;
                  int var26 = var2.a() - 1;

                  while(var25 < var26) {
                     Object var27 = var2.a(var25);
                     var23 -= var2.a(var27);
                     ++var25;
                     if(var36 != 0) {
                        break label153;
                     }

                     if(var36 != 0) {
                        if(var12 == 1) {
                           var42 = var2.a(0);
                           var23 -= var2.a(var42) - var3;
                        }
                        break label153;
                     }
                  }

                  var40 = var12;
                  var10001 = 1;
               } else {
                  var40 = var12;
                  var10001 = 1;
               }

               if(var40 == var10001) {
                  var42 = var2.a(0);
                  var23 -= var2.a(var42) - var3;
               }
            }

            label141:
            while(true) {
               double var43 = var19;
               double var44 = var21;
               y.d.r var29 = var1.f(var16);
               double var30;
               if(var29 != null) {
                  var30 = var1.c(var29);
                  double var32 = var1.d(var29);
                  var43 = var19 + var30;
                  var44 = var21 + var32;
                  var23 += var30 + var32;
                  this.e.put(var16, new E(var17, var30, var32));
                  if(var36 != 0) {
                     this.e.put(var16, new E(var17, 0.0D, 0.0D));
                     if(var2.b(var17) < var43) {
                        var2.b(var17, var43);
                     }
                  } else if(var2.b(var17) < var43) {
                     var2.b(var17, var43);
                  }
               } else {
                  this.e.put(var16, new E(var17, 0.0D, 0.0D));
                  if(var2.b(var17) < var19) {
                     var2.b(var17, var19);
                  }
               }

               if(var2.c(var17) < var44) {
                  var2.c(var17, var44);
               }

               if(var2.a(var17) < var23) {
                  var2.a(var17, var23);
               }

               var30 = var8;
               if(((Iterator)var15).hasNext()) {
                  var8 += var13 + var43 - var19 + var1.a(var16) + var44 - var21;
                  var13 = 0.0D;
                  if(var36 != 0) {
                     var8 = var1.b();
                  }
               } else {
                  var8 = var1.b();
               }

               double var33;
               bt var46;
               int var47;
               if(var17 instanceof y.f.c.a.l) {
                  y.f.c.a.l var45 = (y.f.c.a.l)var17;
                  var33 = var1.a(var16);
                  var45.e(var33);
                  var45.f(var8 - var33 - var44 + var21);
                  if(var36 != 0) {
                     var46 = (bt)var17;
                     var33 = var1.a(var16);
                     var46.f(var33);
                     var46.e(var8 - var33 - var44 + var21);
                     var47 = var5.size();
                     if(var38 >= var47) {
                        break;
                     }
                  } else {
                     var47 = var5.size();
                     if(var38 >= var47) {
                        break;
                     }
                  }
               } else {
                  var46 = (bt)var17;
                  var33 = var1.a(var16);
                  var46.f(var33);
                  var46.e(var8 - var33 - var44 + var21);
                  var47 = var5.size();
                  if(var38 >= var47) {
                     break;
                  }
               }

               while(true) {
                  y.c.q var48 = (y.c.q)var5.get(var38);
                  double var34 = var1.a(var7, var48);
                  if(var36 != 0) {
                     if(var12 == 1) {
                        var42 = var2.a(0);
                        var23 -= var2.a(var42) - var3;
                     }
                     break;
                  }

                  if(var12 != 1 && var30 > var34 || ((Iterator)var15).hasNext() && var34 >= var8) {
                     break label141;
                  }

                  var6.put(var48, var17);
                  ++var38;
                  if(var36 != 0 || var38 >= var47) {
                     break label141;
                  }
               }
            }

            ++var12;
            if(var36 == 0) {
               continue;
            }
         }

         var15 = var2.a(var12);
         var10000 = var15 instanceof y.f.c.a.l;
         break;
      }

      if(var10000) {
         y.f.c.a.l var39 = (y.f.c.a.l)var15;
         var39.e(var39.b());
         var39.f(var8);
         if(var36 == 0) {
            return;
         }
      }

      bt var41 = (bt)var15;
      var41.f(var41.b());
      var41.e(var8);
   }

   private void a(C var1, F var2, i var3, int var4, List var5, B var6, Map var7, bu var8) {
      double var9;
      double var11;
      int var36;
      label89: {
         var36 = a.H;
         var9 = var1.c(var3.d()) + var6.b;
         var11 = var1.a();
         Object var13 = var2.a(var4);
         var2.a(var13, var9);
         var2.a(var13, true);
         if(var13 instanceof y.f.c.a.l) {
            y.f.c.a.l var14 = (y.f.c.a.l)var13;
            var14.e(var9);
            var14.f(var11);
            if(var36 == 0) {
               break label89;
            }
         }

         bt var38 = (bt)var13;
         var38.f(var9);
         var38.e(var11);
      }

      int var37 = 0;
      int var39 = var4 + 1;
      Iterator var15 = var1.c().iterator();

      Object var10000;
      while(true) {
         if(var15.hasNext()) {
            Object var16 = var15.next();
            Object var17 = var2.a(var39);
            var2.a(var17, true);
            y.d.r var18 = var1.c(var16);
            double var19 = Math.max(var1.c(var18), 0.0D);
            double var21 = Math.max(var1.d(var18), 0.0D);
            var10000 = this;
            if(var36 != 0) {
               break;
            }

            double var23;
            double var25;
            double var27;
            double var30;
            label78: {
               var23 = Math.max(this.c()?var1.b(var16):var1.a(var16), var19 + var21);
               var25 = var19;
               var27 = var21;
               y.d.r var29 = var1.f(var16);
               if(var29 != null) {
                  var30 = var1.c(var29);
                  double var32 = var1.d(var29);
                  var25 = var19 + var30;
                  var27 = var21 + var32;
                  var23 += var30 + var32;
                  this.e.put(var16, new E(var17, var30, var32));
                  if(var36 == 0) {
                     break label78;
                  }
               }

               this.e.put(var16, new E(var17, 0.0D, 0.0D));
            }

            label73: {
               var2.b(var17, var25);
               var2.c(var17, var27);
               var2.a(var17, var23);
               var30 = var11;
               if(var15.hasNext()) {
                  var11 += var9 + var25 - var19 + var1.a(var16) + var27 - var21;
                  var9 = 0.0D;
                  if(var36 == 0) {
                     break label73;
                  }
               }

               var11 = var1.b();
            }

            label68: {
               double var33;
               if(var17 instanceof y.f.c.a.l) {
                  y.f.c.a.l var45 = (y.f.c.a.l)var17;
                  var33 = var1.a(var16);
                  var45.e(var33);
                  var45.f(var11 - var33 - var27 + var21);
                  if(var36 == 0) {
                     break label68;
                  }
               }

               bt var46 = (bt)var17;
               var33 = var1.a(var16);
               var46.f(var33);
               var46.e(var11 - var33 - var27 + var21);
            }

            int var47 = var5.size();

            label62:
            do {
               int var42 = var37;
               int var10001 = var47;

               double var34;
               y.c.q var48;
               do {
                  if(var42 >= var10001) {
                     break label62;
                  }

                  var48 = (y.c.q)var5.get(var37);
                  var34 = var1.a(var8, var48);
                  var42 = var39;
                  var10001 = var4 + 1;
               } while(var36 != 0);

               if(var39 != var10001 && var30 > var34 || var15.hasNext() && var34 >= var11) {
                  break;
               }

               var7.put(var48, var17);
               ++var37;
            } while(var36 == 0);

            ++var39;
            if(var36 == 0) {
               continue;
            }
         }

         var10000 = var2.a(var39);
         break;
      }

      Object var40 = var10000;
      double var41 = var1.d(var3.d()) + var6.d;
      var2.a(var40, var41);
      var2.a(var40, true);
      if(var40 instanceof y.f.c.a.l) {
         y.f.c.a.l var43 = (y.f.c.a.l)var40;
         var43.e(var41);
         var43.f(var11);
         if(var36 == 0) {
            return;
         }
      }

      bt var44 = (bt)var40;
      var44.f(var41);
      var44.e(var11);
   }

   private static void a(y.h.a.v var0, y.c.q var1, Collection var2) {
      int var5 = a.H;
      y.c.x var3 = var0.p(var1);

      while(var3.f()) {
         label19: {
            y.c.q var4 = var3.e();
            if(var0.k(var4) && var0.p(var4).f()) {
               a(var0, var4, var2);
               if(var5 == 0) {
                  break label19;
               }
            }

            var2.add(var4);
         }

         var3.g();
         if(var5 != 0) {
            break;
         }
      }

   }

   private void a(Collection var1, C var2, B var3) {
      int var10 = a.H;
      double var4 = 0.0D;
      double var6 = 0.0D;
      Iterator var8 = var1.iterator();

      while(true) {
         if(var8.hasNext()) {
            Object var9 = var8.next();
            this.a(var9, var2, var3);
            if(var4 < var3.b) {
               var4 = var3.b;
            }

            if(var6 >= var3.d) {
               continue;
            }

            var6 = var3.d;
            if(var10 != 0) {
               break;
            }

            if(var10 == 0) {
               continue;
            }
         }

         var3.b = var4;
         var3.d = var6;
         break;
      }

   }

   private void a(Object var1, C var2, B var3) {
      int var16 = a.H;
      y.d.r var4 = var2.c(var1);
      if(var2.d(var1) == 0) {
         var3.e.add(var1);
         var3.f.put(var1, var2.a(var3.a, var3.c));
         var3.b = var2.a(var4);
         var3.d = var2.b(var4);
         if(var16 == 0) {
            return;
         }
      }

      double var5 = 0.0D;
      double var7 = 0.0D;
      double var9 = var3.a;
      double var11 = var3.c;
      boolean var13 = true;
      Iterator var14 = var2.e(var1).iterator();

      label44: {
         while(var14.hasNext()) {
            Object var15;
            label40: {
               var15 = var14.next();
               if(var13) {
                  var3.a = var2.c(var4) + var9;
                  var13 = false;
                  if(var16 == 0) {
                     break label40;
                  }
               }

               var3.a = 0.0D;
            }

            label35: {
               if(var14.hasNext()) {
                  var3.c = 0.0D;
                  if(var16 == 0) {
                     break label35;
                  }
               }

               var3.c = var2.d(var4) + var11;
            }

            this.a(var15, var2, var3);
            if(var5 < var3.b) {
               var5 = var3.b;
            }

            if(var7 < var3.d) {
               var7 = var3.d;
               if(var16 != 0) {
                  break label44;
               }

               if(var16 != 0) {
                  break;
               }
            }
         }

         var3.a = var9;
         var3.c = var11;
         var3.b = var2.a(var4) + var5;
      }

      var3.d = var2.b(var4) + var7;
   }

   public void d(bu var1) {
      this.f(var1);
      this.e(var1);
   }

   public void e(bu var1) {
      int var4 = a.H;
      if(this.m != null) {
         Iterator var2 = this.m.iterator();

         while(var2.hasNext()) {
            a var3 = (a)var2.next();
            var3.c(true);
            if(var4 != 0) {
               return;
            }

            if(var4 != 0) {
               break;
            }
         }
      }

      this.m = null;
   }

   public void f(bu var1) {
      if(this.a != null) {
         this.h(var1);
         this.a = null;
      }

   }

   private void h(bu var1) {
      int var21 = a.H;
      boolean var2 = !this.b();
      double var3 = var2?this.g.a(0).e():this.g.b(0).e();
      y.c.D var5 = var2?this.g.e():this.g.f();
      if(!this.a.a().isEmpty()) {
         var5.remove(var5.size() - 1);
         var5.remove(var5.size() - 1);
      }

      Iterator var6 = this.a.b().iterator();

      label140:
      while(true) {
         if(var6.hasNext()) {
            i var7;
            label145: {
               var7 = (i)var6.next();
               y.c.q var8 = this.a.a(var7);
               List var9;
               int var10;
               a var11;
               double var12;
               E var15;
               int var16;
               E var20;
               y.c.p var23;
               int var24;
               double var26;
               double var27;
               if(var2) {
                  var9 = ((B)this.h.get(var7)).e;
                  var10 = var9.size();
                  var11 = b(var1, var8);
                  var12 = var11.t();
                  if(var12 < var3) {
                     f var14 = (f)var9.get(0);
                     var15 = (E)this.e.get(var14);
                     this.e.put(var14, new E(var15.a, var15.b - var3 + var12, var15.c));
                  }

                  var23 = var5.k();
                  var24 = 0;
                  var16 = var10 + 1;

                  while(var24 < var16) {
                     var23 = var23.a();
                     ++var24;
                     if(var21 != 0) {
                        continue label140;
                     }

                     if(var21 != 0) {
                        break;
                     }
                  }

                  var26 = 0.0D;

                  while(var23 != null) {
                     bt var17 = (bt)var23.c();
                     var26 += var17.e();
                     var23 = var23.a();
                     if(var21 != 0) {
                        continue label140;
                     }

                     if(var21 != 0) {
                        break;
                     }
                  }

                  var27 = var11.u();
                  if(var27 >= var26) {
                     break label145;
                  }

                  f var19 = (f)var9.get(var10 - 1);
                  var20 = (E)this.e.get(var19);
                  this.e.put(var19, new E(var20.a, var20.b, var20.c - var26 + var27));
                  if(var21 == 0) {
                     break label145;
                  }
               }

               var9 = ((B)this.i.get(var7)).e;
               var10 = var9.size();
               var11 = b(var1, var8);
               var12 = var11.v();
               if(var12 < var3) {
                  c var25 = (c)var9.get(0);
                  var15 = (E)this.e.get(var25);
                  this.e.put(var25, new E(var15.a, var15.b - var3 + var12, var15.c));
               }

               var23 = var5.k();
               var24 = 0;
               var16 = var10 + 1;

               while(var24 < var16) {
                  var23 = var23.a();
                  ++var24;
                  if(var21 != 0) {
                     continue label140;
                  }

                  if(var21 != 0) {
                     break;
                  }
               }

               var26 = 0.0D;

               while(var23 != null) {
                  y.f.c.a.l var28 = (y.f.c.a.l)var23.c();
                  var26 += var28.e();
                  var23 = var23.a();
                  if(var21 != 0) {
                     continue label140;
                  }

                  if(var21 != 0) {
                     break;
                  }
               }

               var27 = var11.w();
               if(var27 < var26) {
                  c var29 = (c)var9.get(var10 - 1);
                  var20 = (E)this.e.get(var29);
                  this.e.put(var29, new E(var20.a, var20.b, var20.c - var26 + var27));
               }
            }

            Iterator var22 = var7.o().iterator();

            label96: {
               while(var22.hasNext()) {
                  this.a((f)var22.next());
                  if(var21 != 0) {
                     break label96;
                  }

                  if(var21 != 0) {
                     break;
                  }
               }

               var22 = var7.l().iterator();
            }

            do {
               if(!var22.hasNext()) {
                  continue label140;
               }

               this.a((c)var22.next());
               if(var21 != 0 || var21 != 0) {
                  break label140;
               }
            } while(var21 == 0);
         }

         this.i = null;
         this.h = null;
         var1.d_(bk.a);
         break;
      }

      if(this.c != null) {
         var1.a((Object)bk.a, (y.c.c)this.c);
         this.c = null;
      }

      var1.d_(bk.b);
      var1.a((y.c.A)this.b);
      this.b = null;
      if(this.d != null) {
         var1.a((Object)bk.b, (y.c.c)this.d);
         this.d = null;
      }

   }

   private void a(f var1) {
      int var6 = a.H;
      if(var1.n() == 0) {
         E var2 = (E)this.e.get(var1);
         bt var3 = (bt)var2.a;
         var1.b(var3.e() - var2.b - var2.c);
         if(var6 == 0) {
            return;
         }
      }

      double var7 = 0.0D;
      Iterator var4 = var1.o().iterator();

      while(var4.hasNext()) {
         f var5 = (f)var4.next();
         this.a(var5);
         var7 += var5.g();
         if(var6 != 0) {
            return;
         }

         if(var6 != 0) {
            break;
         }
      }

      var1.b(var1.i().a + var7 + var1.i().c);
   }

   private void a(c var1) {
      int var6 = a.H;
      if(var1.k() == 0) {
         E var2 = (E)this.e.get(var1);
         y.f.c.a.l var3 = (y.f.c.a.l)var2.a;
         var1.b(var3.e() - var2.b - var2.c);
         if(var6 == 0) {
            return;
         }
      }

      double var7 = 0.0D;
      Iterator var4 = var1.l().iterator();

      while(var4.hasNext()) {
         c var5 = (c)var4.next();
         this.a(var5);
         var7 += var5.g();
         if(var6 != 0) {
            return;
         }

         if(var6 != 0) {
            break;
         }
      }

      var1.b(var1.i().b + var7 + var1.i().d);
   }

   private static a b(bu var0, y.c.q var1) {
      return (a)c(var0, var1);
   }

   private static fj c(bu var0, y.c.q var1) {
      return aa.a(var0, var1);
   }

   static Map a(v var0) {
      return var0.h;
   }

   static Map b(v var0) {
      return var0.i;
   }

   static fj a(bu var0, y.c.q var1) {
      return c(var0, var1);
   }
}
