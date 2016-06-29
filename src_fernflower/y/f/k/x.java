package y.f.k;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import y.f.aE;
import y.f.aF;
import y.f.aI;
import y.f.ae;
import y.f.am;
import y.f.an;
import y.f.k.A;
import y.f.k.B;
import y.f.k.F;
import y.f.k.H;
import y.f.k.I;
import y.f.k.J;
import y.f.k.K;
import y.f.k.O;
import y.f.k.Q;
import y.f.k.d;
import y.f.k.t;
import y.f.k.v;
import y.f.k.y;
import y.f.k.z;
import y.g.ap;

public class x extends y.f.c {
   public static final Object n = "y.layout.tree.GenericTreeLayouter.NODE_PLACER_DPKEY";
   public static final Object o = "y.layout.tree.GenericTreeLayouter.PORT_ASSIGNMENT_DPKEY";
   public static final Object p = "y.layout.tree.GenericTreeLayouter.CHILD_COMPARATOR_DPKEY";
   static final Object q = "y.layout.tree.GenericTreeLayouter.EDGE_REVERSED_DPKEY";
   private y.c.A s;
   private y.c.A t;
   private double u = 2.0D;
   private y.c.c v = new y(this);
   private y.c.c w = new z(this);
   private ap x;
   private ap y;
   private ap z;
   private ap A;
   private ap B;
   protected y.f.X r;
   private I C = new t();
   private I D = new H();
   private J E = new v();
   private Comparator F = null;
   private boolean G;
   private boolean H;
   private boolean I = true;
   private y.c.A J;
   private y.c.A K;
   private y.f.b.c L;
   private y.c.h M;
   private final y.f.F N;

   public x() {
      this.d(!this.n());
      an var1 = new an();
      var1.a(false);
      this.e(var1);
      this.N = new y.f.F();
   }

   y.f.F a() {
      return this.N;
   }

   public boolean n() {
      return this.I;
   }

   protected boolean b(y.f.X var1) {
      return a(var1, this.n());
   }

   static boolean a(y.f.X var0, boolean var1) {
      int var9 = d.g;
      if(var0 == null) {
         return false;
      } else {
         y.g.I var2;
         boolean var10000;
         label50: {
            var2 = null;
            if(var1 && y.f.b.c.b((y.c.i)var0)) {
               label54: {
                  var2 = new y.g.I(var0);
                  y.c.c var3 = var0.c(y.f.b.f.c);
                  HashSet var4 = new HashSet();
                  y.c.x var5 = var0.o();

                  while(var5.f()) {
                     var4.add(var3.b(var5.e()));
                     var5.g();
                     if(var9 != 0) {
                        break label54;
                     }

                     if(var9 != 0) {
                        break;
                     }
                  }

                  y.c.c var11 = var0.c(y.f.b.f.b);
                  y.c.c var6 = var0.c(y.f.b.f.d);
                  y.c.x var7 = var0.o();

                  while(var7.f()) {
                     y.c.q var8 = var7.e();
                     var10000 = var6.d(var8);
                     if(var9 != 0) {
                        break label50;
                     }

                     if(var10000 && var4.contains(var11.b(var8))) {
                        var2.a(var8);
                     }

                     var7.g();
                     if(var9 != 0) {
                        break;
                     }
                  }
               }
            }

            var10000 = y.a.A.b(var0);
         }

         boolean var10 = var10000;
         if(var2 != null) {
            var2.f();
         }

         return var10;
      }
   }

   private y.c.y a(y.f.b.c var1) {
      int var5 = d.g;
      y.c.y var2 = new y.c.y();
      y.c.y var3 = var1.b(var1.b());

      while(true) {
         if(!var3.isEmpty()) {
            y.c.q var4 = var3.d();
            if(!var1.e(var4)) {
               continue;
            }

            var2.add(var4);
            var3.addAll(var1.b(var4));
            if(var5 != 0) {
               break;
            }

            if(var5 == 0) {
               continue;
            }
         }

         var2.n();
         break;
      }

      return var2;
   }

   protected void a(y.f.X var1) {
      int var17 = d.g;
      if(!this.b(var1)) {
         throw new y.c.B("Graph is not a tree");
      } else {
         boolean var2 = y.f.b.c.b((y.c.i)var1) && this.I;
         this.L = null;
         y.c.y var3 = null;
         y.g.I var4 = null;
         if(var2) {
            this.L = new y.f.b.c(var1);
            var3 = this.a(this.L);
            var4 = new y.g.I(var1);
            var4.a(var3);
         }

         if(var2 && var1.i() && !var3.isEmpty()) {
            var4.f();
            this.L.c();
            this.L = null;
         } else {
            this.r = var1;
            this.s = var1.t();
            this.t = var1.t();

            try {
               this.x = ap.b(var1, n);
               this.y = ap.b(var1, o);
               this.z = ap.b(var1, p);
               this.A = ap.a(var1, aF.a);
               this.B = ap.a(var1, aF.b);
               y.c.f var5 = this.o();
               this.a(var5);
               this.M = var1.u();
               var1.a((Object)q, (y.c.c)this.M);
               y.c.e var6 = var5.a();

               while(var6.f()) {
                  y.c.d var7 = var6.a();
                  this.M.a(var7, Boolean.TRUE);
                  var6.g();
                  if(var17 != 0) {
                     break;
                  }
               }

               try {
                  Object var10000;
                  y.c.q var24;
                  label304: {
                     var24 = y.a.A.d(var1);
                     if(var2) {
                        y.c.A var25 = this.a((y.c.i)var1, (y.c.q)var24);
                        this.J = var1.t();
                        this.K = var1.t();
                        y.c.x var8 = var3.a();

                        while(var8.f()) {
                           y.c.q var9 = var8.e();
                           y.c.y var10 = this.a(var9, this.L);
                           var10000 = var10;
                           if(var17 != 0) {
                              break label304;
                           }

                           if(!var10.isEmpty()) {
                              label327: {
                                 y.c.q var11 = a(var24, var10, var25);
                                 this.K.a(var9, var11);
                                 y.c.y var12;
                                 if(this.J.b(var11) == null) {
                                    var12 = new y.c.y(var9);
                                    this.J.a(var11, var12);
                                    if(var17 == 0) {
                                       break label327;
                                    }
                                 }

                                 var12 = (y.c.y)this.J.b(var11);
                                 var12.add(var9);
                              }
                           }

                           var8.g();
                           if(var17 != 0) {
                              break;
                           }
                        }
                     }

                     var10000 = this.a(var24, var1);
                  }

                  Object var26 = var10000;
                  if(var2 && !var3.isEmpty() && var1.c(B.h) != null) {
                     this.a(var3);
                  }

                  this.h(var24);
                  this.a((y.f.X)var1, (List)var26);
               } finally {
                  this.a(var5);
                  (new aI()).c(var1);
               }
            } finally {
               if(var2) {
                  var4.f();
                  y.f.b.j var16 = new y.f.b.j();
                  var16.a(false);
                  var16.c(var1);
                  var1.a((y.c.A)this.J);
                  var1.a((y.c.A)this.K);
                  this.L.c();
                  this.L = null;
               }

               this.y.e();
               this.y = null;
               this.x.e();
               this.x = null;
               this.A.e();
               this.A = null;
               this.B.e();
               this.B = null;
               this.z.e();
               this.z = null;
               if(this.M != null) {
                  var1.d_(q);
                  var1.a((y.c.h)this.M);
                  this.M = null;
               }

               this.r.a((y.c.A)this.t);
               this.r.a((y.c.A)this.s);
               this.t = null;
               this.s = null;
               this.r = null;
            }

         }
      }
   }

   private void a(y.c.y var1) {
      int var18 = d.g;
      y.c.c var2 = this.r.c(B.h);
      y.c.c var3 = this.r.c(y.f.b.f.e);
      if(var2 != null && var3 != null) {
         y.c.A var4 = y.g.M.a(new double[this.r.f()]);
         y.c.A var5 = y.g.M.a(new double[this.r.f()]);
         y.c.x var6 = var1.a();

         y.c.q var7;
         F var10000;
         label142:
         while(true) {
            if(var6.f()) {
               var7 = var6.e();
               y.d.r var8 = y.d.r.a(var3.b(var7));
               if(var18 != 0) {
                  var10000 = (F)var8;
                  break;
               }

               if(var8 != null) {
                  int var9 = Integer.MAX_VALUE;
                  int var10 = Integer.MIN_VALUE;
                  y.c.y var11 = new y.c.y();
                  y.c.y var12 = new y.c.y();
                  y.c.y var13 = this.a(var7, this.L);
                  y.c.x var14 = var13.a();

                  y.c.q var15;
                  label120: {
                     while(var14.f()) {
                        var15 = var14.e();
                        F var16 = (F)var2.b(var15);
                        var10000 = var16;
                        if(var18 != 0) {
                           break label142;
                        }

                        if(var16 != null) {
                           if(var16.c() >= var10) {
                              if(var16.c() > var10) {
                                 var10 = var16.c();
                                 var12.clear();
                              }

                              var12.add(var15);
                           }

                           if(var16.c() <= var9) {
                              if(var16.c() < var9) {
                                 var9 = var16.c();
                                 var11.clear();
                              }

                              var11.add(var15);
                           }
                        }

                        var14.g();
                        if(var18 != 0) {
                           var14 = var11.a();
                           break label120;
                        }
                     }

                     var14 = var11.a();
                  }

                  double var21;
                  while(true) {
                     if(!var14.f()) {
                        var14 = var12.a();
                        break;
                     }

                     var15 = var14.e();
                     var21 = var4.c(var15);
                     var4.a(var15, var21 + var8.a);
                     var14.g();
                     if(var18 != 0) {
                        break;
                     }

                     if(var18 != 0) {
                        var14 = var12.a();
                        break;
                     }
                  }

                  while(true) {
                     if(!var14.f()) {
                        var6.g();
                        if(var18 == 0) {
                           continue label142;
                        }

                        var6 = this.r.o();
                        break;
                     }

                     var15 = var14.e();
                     var21 = var5.c(var15);
                     var5.a(var15, var21 + var8.c);
                     var14.g();
                     if(var18 != 0) {
                        if(var18 == 0) {
                           continue label142;
                        }

                        var6 = this.r.o();
                        break;
                     }

                     if(var18 != 0) {
                        var6.g();
                        if(var18 == 0) {
                           continue label142;
                        }

                        var6 = this.r.o();
                        break;
                     }
                  }
               } else {
                  var6.g();
                  if(var18 == 0) {
                     continue;
                  }

                  var6 = this.r.o();
               }
            } else {
               var6 = this.r.o();
            }

            if(!var6.f()) {
               return;
            }

            var7 = var6.e();
            var10000 = (F)var2.b(var7);
            break;
         }

         while(true) {
            F var19 = var10000;
            if(var19 != null) {
               I var20 = this.e(var7);
               if(var20 instanceof O) {
                  var20 = ((O)var20).a();
               }

               if(var20 instanceof B) {
                  var19.a(var7, this, ((B)var20).a(), var4.c(var7), var5.c(var7));
               }
            }

            var6.g();
            if(var18 != 0 || !var6.f()) {
               break;
            }

            var7 = var6.e();
            var10000 = (F)var2.b(var7);
         }
      }

   }

   private y.c.A a(y.c.i var1, y.c.q var2) {
      int var7 = d.g;
      y.c.A var3 = y.g.M.a(new int[var1.f()]);
      y.c.y[] var4 = y.a.b.a(var1, new y.c.y(var2));
      int var5 = 0;

      while(var5 < var4.length) {
         y.c.x var6 = var4[var5].a();

         while(true) {
            if(var6.f()) {
               var3.a(var6.e(), var5);
               var6.g();
               if(var7 != 0) {
                  break;
               }

               if(var7 == 0) {
                  continue;
               }
            }

            ++var5;
            break;
         }

         if(var7 != 0) {
            break;
         }
      }

      return var3;
   }

   private static y.c.q a(y.c.q var0, y.c.q var1, y.c.A var2) {
      int var5 = d.g;
      if(var0 == var1) {
         return var0;
      } else {
         y.c.q var3 = var0;
         y.c.q var4 = var1;

         y.c.q var10000;
         label41: {
            label40:
            while(true) {
               if(var2.a(var3) < var2.a(var4)) {
                  var4 = var4.g().c();
                  if(var5 != 0) {
                     break;
                  }

                  if(var5 == 0) {
                     continue;
                  }
               }

               while(true) {
                  if(var2.a(var3) <= var2.a(var4)) {
                     break label40;
                  }

                  var3 = var3.g().c();
                  if(var5 != 0) {
                     break label41;
                  }

                  if(var5 != 0) {
                     break label40;
                  }
               }
            }

            while(var3 != var4) {
               var3 = var3.g().c();
               var10000 = var4.g().c();
               if(var5 != 0) {
                  return var10000;
               }

               var4 = var10000;
               if(var5 != 0) {
                  break;
               }
            }
         }

         var10000 = var3;
         return var10000;
      }
   }

   private static y.c.q a(y.c.q var0, y.c.y var1, y.c.A var2) {
      int var6 = d.g;
      y.c.q var3 = var1.b();
      y.c.x var4 = var1.a();

      y.c.q var10000;
      while(true) {
         if(var4.f()) {
            y.c.q var5 = var4.e();
            var3 = a(var3, var5, var2);
            var10000 = var3;
            if(var6 != 0) {
               break;
            }

            if(var3 == var0) {
               return var0;
            }

            var4.g();
            if(var6 == 0) {
               continue;
            }
         }

         var10000 = var3;
         break;
      }

      return var10000;
   }

   private y.c.y a(y.c.q var1, y.f.b.c var2) {
      int var7 = d.g;
      y.c.y var3 = var2.c(var1);
      y.c.y var4 = new y.c.y();
      y.c.x var5 = var3.a();

      while(var5.f()) {
         y.c.q var6 = var5.e();
         if(!var2.d(var6)) {
            var4.add(var6);
         }

         var5.g();
         if(var7 != 0) {
            break;
         }
      }

      return var4;
   }

   private void h(y.c.q var1) {
      int var11 = d.g;
      y.c.q[] var2 = this.g(var1);
      int var3 = var2.length - 1;

      y.c.q var4;
      int var10000;
      while(true) {
         if(var3 >= 0) {
            var4 = var2[var3];
            var10000 = var4.c();
            if(var11 != 0) {
               break;
            }

            if(var10000 > 0) {
               Comparator var5 = this.d(var4);
               if(var5 != null) {
                  var4.b(var5);
               }

               this.e(var4).a(var4, this.t);
            }

            --var3;
            if(var11 == 0) {
               continue;
            }
         }

         var10000 = 0;
         break;
      }

      var3 = var10000;

      while(true) {
         if(var3 < var2.length) {
            var4 = var2[var3];
            this.i(var4);
            A var13 = this.b(var4);
            this.s.a(var4, var13);
            this.j(var4);
            ++var3;
            if(var11 != 0) {
               break;
            }

            if(var11 == 0) {
               continue;
            }
         }

         var3 = var2.length - 1;
         break;
      }

      while(var3 >= 0) {
         double var12 = 0.0D;
         double var6 = 0.0D;
         y.c.q var8 = var2[var3];
         if(var8 != var1) {
            y.c.q var9 = var8.g().c();
            A var10 = this.a(var9);
            var12 = var10.a;
            var6 = var10.b;
         }

         A var14 = this.a(var8);
         var14.a += var12;
         var14.b += var6;
         this.a(var8, var12, var6);
         --var3;
         if(var11 != 0) {
            break;
         }
      }

   }

   private List a(y.c.q var1, y.f.X var2) {
      int var8 = d.g;
      y.c.D var3 = new y.c.D();
      y.c.D var4 = new y.c.D();
      var4.add(var1);

      label30:
      while(true) {
         y.c.D var10000;
         if(!var4.isEmpty()) {
            y.c.q var5 = (y.c.q)var4.j();
            K var6 = this.e(var5).a(this, var2, var5);
            if(var6 != null) {
               var6.a(this.x.a(), this.y.a(), this.z.a());
               var3.a((Object)var6);
            }

            y.c.d var7 = var5.f();

            do {
               if(var7 == null) {
                  continue label30;
               }

               var10000 = var4;
               if(var8 != 0) {
                  return var10000;
               }

               var4.add(var7.d());
               var7 = var7.g();
            } while(var8 == 0 && var8 == 0);
         }

         var10000 = var3;
         return var10000;
      }
   }

   private void a(y.f.X var1, List var2) {
      int var5 = d.g;
      this.d(var1);
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         K var4 = (K)var3.next();
         if(var4 != null) {
            var4.a();
            if(var5 != 0) {
               break;
            }
         }
      }

   }

   private void d(y.f.X var1) {
      int var13 = d.g;
      if(this.H) {
         y.c.c var2 = var1.c(y.f.U.a);
         if(var2 != null) {
            y.c.e var3 = var1.p();

            while(var3.f()) {
               label36: {
                  y.c.d var4 = var3.a();
                  am var5 = var1.a((Object)var4.d());
                  y.f.S[] var6 = (y.f.S[])var2.b(var4);
                  if(var6 != null) {
                     int var7 = 0;

                     while(var7 < var6.length) {
                        y.f.S var8 = var6[var7];
                        double var9 = var8.d();
                        double var11 = var8.e();
                        var8.a(var9 + var5.getX(), var11 + var5.getY());
                        this.N.a((y.c.i)var1, (y.f.S)var8);
                        ++var7;
                        if(var13 != 0) {
                           break label36;
                        }

                        if(var13 != 0) {
                           break;
                        }
                     }
                  }

                  var3.g();
               }

               if(var13 != 0) {
                  break;
               }
            }

         }
      }
   }

   private void i(y.c.q var1) {
      int var5 = d.g;
      y.c.d var2 = var1.f();

      while(var2 != null) {
         y.c.q var3 = var2.d();
         A var4 = this.a(var3);
         var4.a = var4.i();
         var4.b = var4.j();
         var2 = var2.g();
         if(var5 != 0) {
            break;
         }
      }

   }

   private void j(y.c.q var1) {
      int var5 = d.g;
      y.c.d var2 = var1.f();

      while(var2 != null) {
         y.c.q var3 = var2.d();
         A var4 = this.a(var3);
         var4.a = var4.i() - var4.a;
         var4.b = var4.j() - var4.b;
         var2 = var2.g();
         if(var5 != 0) {
            break;
         }
      }

   }

   protected A a(y.c.q var1) {
      return (A)this.s.b(var1);
   }

   private void a(y.c.q var1, double var2, double var4) {
      int var11 = d.g;
      A var6 = this.a(var1);
      var6.b(var2, var4);
      y.c.d var7 = var1.f();

      while(var7 != null) {
         y.f.I var8 = this.r.b(var7);
         int var9 = 0;

         while(true) {
            if(var9 < var8.pointCount()) {
               y.d.t var10 = var8.getPoint(var9);
               var8.setPoint(var9, var10.a + var6.a, var10.b + var6.b);
               ++var9;
               if(var11 != 0) {
                  break;
               }

               if(var11 == 0) {
                  continue;
               }
            }

            var7 = var7.g();
            break;
         }

         if(var11 != 0) {
            break;
         }
      }

   }

   protected A b(y.c.q var1) {
      J var2 = this.c(var1);
      I var3 = this.e(var1);
      var2.a(this.r, var1);
      A var4 = var3.a(this.v, this.w, this.r, var1, (byte)this.t.a(var1));
      if(this.r()) {
         Q var5 = new Q(var1, this.r);
         var5.a(var4, (byte)this.t.a(var1), this.u, this.a());
      }

      return var4;
   }

   protected J c(y.c.q var1) {
      if(this.y != null) {
         J var2 = (J)this.y.b((Object)var1);
         if(var2 != null) {
            return var2;
         }
      }

      return this.E;
   }

   protected Comparator d(y.c.q var1) {
      if(this.z != null) {
         Comparator var2 = (Comparator)this.z.b((Object)var1);
         if(var2 != null) {
            return var2;
         }
      }

      return this.F;
   }

   protected I e(y.c.q var1) {
      I var2 = null;
      if(this.x != null) {
         var2 = (I)this.x.b((Object)var1);
      }

      return var2 != null?this.a(var1, var2):(var1.c() > 0?this.a(var1, this.C):this.a(var1, this.D));
   }

   private I a(y.c.q var1, I var2) {
      int var11 = d.g;
      if(this.L != null && this.J != null && this.J.b(var1) != null) {
         y.c.c var3 = this.r.c(y.f.b.f.e);
         y.c.y var4 = (y.c.y)this.J.b(var1);
         O var5 = null;
         y.c.x var6 = var4.a();

         while(var6.f()) {
            label26: {
               y.c.q var7 = var6.e();
               Object var8 = var3 == null?null:var3.b(var7);
               y.d.r var9 = y.d.r.a(var8);
               y.c.y var10 = this.L.c(var7);
               if(var5 == null) {
                  var5 = new O(var2, var7, var10, this.s, this.K, var9);
                  if(var11 == 0) {
                     break label26;
                  }
               }

               var5 = new O(var5, var7, var10, this.s, this.K, var9);
            }

            var6.g();
            if(var11 != 0) {
               break;
            }
         }

         return var5;
      } else {
         return var2;
      }
   }

   protected A f(y.c.q var1) {
      am var2 = this.r.a((Object)var1);
      A var3 = new A(var1, var2);
      if(this.G) {
         Q var4 = new Q(var1, this.r);
         var4.a(var3);
      }

      return var3;
   }

   protected y.c.q[] g(y.c.q var1) {
      int var8 = d.g;
      ArrayList var2 = new ArrayList(this.r.e());
      int[] var3 = new int[this.r.e()];
      y.c.q[] var4 = this.r.m();
      int var5 = 0;

      int var10000;
      while(true) {
         if(var5 < var4.length) {
            int var6 = var4[var5].c();
            var3[var5] = var6;
            var10000 = var6;
            if(var8 != 0) {
               break;
            }

            if(var6 == 0) {
               var2.add(var4[var5]);
            }

            ++var5;
            if(var8 == 0) {
               continue;
            }
         }

         var10000 = 0;
         break;
      }

      var5 = var10000;

      while(true) {
         if(!var2.isEmpty()) {
            y.c.q var9 = (y.c.q)var2.remove(var2.size() - 1);
            if(var8 != 0) {
               break;
            }

            if(var9 != var1) {
               y.c.q var7 = var9.g().c();
               if(--var3[var7.d()] == 0) {
                  var2.add(var7);
               }
            }

            var4[var5++] = var9;
            if(var8 == 0) {
               continue;
            }
         }

         if(var5 != this.r.e()) {
            throw new RuntimeException("Not all nodes found!");
         }
         break;
      }

      return var4;
   }

   protected y.c.f o() {
      int var3 = d.g;
      y.c.f var1 = y.a.A.e(this.r);
      y.c.e var2 = var1.a();

      while(var2.f()) {
         this.r.c(var2.a());
         var2.g();
         if(var3 != 0) {
            break;
         }
      }

      return var1;
   }

   protected y.c.a p() {
      return (y.c.b)this.A.d();
   }

   protected y.c.a q() {
      return (y.c.b)this.B.d();
   }

   protected void a(y.c.f var1) {
      int var6 = d.g;
      y.c.p var2 = var1.k();

      while(var2 != null) {
         y.c.d var3 = (y.c.d)var2.c();
         ae.a(this.r.g(var3));
         aE var4 = aE.d(this.r, var3);
         aE var5 = aE.e(this.r, var3);
         this.r.c(var3);
         this.p().a(var3, var5);
         this.q().a(var3, var4);
         var2 = var2.a();
         if(var6 != 0) {
            break;
         }
      }

   }

   public void a(I var1) {
      this.C = var1;
   }

   public void a(J var1) {
      this.E = var1;
   }

   public boolean r() {
      return this.H;
   }
}
