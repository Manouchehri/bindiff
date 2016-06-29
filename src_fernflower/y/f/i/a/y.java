package y.f.i.a;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import y.f.i.a.A;
import y.f.i.a.B;
import y.f.i.a.C;
import y.f.i.a.D;
import y.f.i.a.E;
import y.f.i.a.F;
import y.f.i.a.G;
import y.f.i.a.I;
import y.f.i.a.J;
import y.f.i.a.L;
import y.f.i.a.O;
import y.f.i.a.R;
import y.f.i.a.U;
import y.f.i.a.V;
import y.f.i.a.Z;
import y.f.i.a.aC;
import y.f.i.a.aD;
import y.f.i.a.aG;
import y.f.i.a.aH;
import y.f.i.a.aM;
import y.f.i.a.aN;
import y.f.i.a.aV;
import y.f.i.a.aX;
import y.f.i.a.aY;
import y.f.i.a.aZ;
import y.f.i.a.aa;
import y.f.i.a.ab;
import y.f.i.a.ac;
import y.f.i.a.ae;
import y.f.i.a.ar;
import y.f.i.a.av;
import y.f.i.a.aw;
import y.f.i.a.ax;
import y.f.i.a.ay;
import y.f.i.a.az;
import y.f.i.a.bF;
import y.f.i.a.bS;
import y.f.i.a.bW;
import y.f.i.a.bX;
import y.f.i.a.bb;
import y.f.i.a.be;
import y.f.i.a.bf;
import y.f.i.a.bi;
import y.f.i.a.bj;
import y.f.i.a.bk;
import y.f.i.a.bm;
import y.f.i.a.bp;
import y.f.i.a.ca;
import y.f.i.a.i;
import y.f.i.a.m;
import y.f.i.a.n;
import y.f.i.a.w;
import y.f.i.a.x;
import y.f.i.a.z;

public class y extends y.f.a {
   static final Object a = "EdgeRouter.EDGE_BUNDLE_ID";
   static final Object b = "EdgeRouter.REGISTERED_EDGE_INFO_KEY";
   private I c;
   private O d;
   private V e;
   private i f;
   private x g;
   private byte h;
   private Object i;
   private Object n;
   private boolean o;
   private boolean p;
   private L q;
   private boolean r;
   private long s;
   private boolean t;
   private double u;
   private double v;
   private double w;
   private List x;
   private List y;

   public y(y.f.ah var1) {
      super(var1);
      this.i = y.f.ah.h_;
      this.n = y.f.ah.g_;
      this.r = false;
      this.s = Long.MAX_VALUE;
      this.t = false;
      this.u = 30.0D;
      this.v = 0.3D;
      this.w = 10.0D;
      this.g = new x();
   }

   public y() {
      this((y.f.ah)null);
   }

   public long b() {
      return this.s;
   }

   public x c() {
      return this.g;
   }

   protected x a(y.c.d var1) {
      y.c.c var2 = var1.a().c((Object)"y.layout.router.polyline.EdgeRouter.EDGE_LAYOUT_DESCRIPTOR_DPKEY");
      if(var2 != null) {
         x var3 = (x)var2.b(var1);
         if(var3 != null) {
            return var3;
         }
      }

      return this.g;
   }

   public boolean d() {
      return this.t;
   }

   public void a(boolean var1) {
      this.t = var1;
   }

   public boolean e() {
      return this.r;
   }

   public void a(byte var1) {
      switch(var1) {
      case 0:
      case 2:
      case 4:
         this.h = var1;
         return;
      case 1:
      case 3:
      default:
         throw new IllegalArgumentException("Argument \'" + var1 + "\' not allowed.");
      }
   }

   public byte f() {
      return this.h;
   }

   public Object g() {
      return this.n;
   }

   public Object h() {
      return this.i;
   }

   public void a(Object var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("null");
      } else {
         this.i = var1;
      }
   }

   boolean a(y.c.d var1, y.c.i var2) {
      if(this.f() == 0) {
         return true;
      } else {
         y.c.c var3 = var2.c(this.h());
         return var3 != null && var3.d(var1);
      }
   }

   static boolean a(y.c.d var0, y.f.X var1) {
      int var6 = ab.a;
      y.d.v var2 = var1.l(var0);
      y.d.t var3 = null;
      y.d.u var4 = var2.b();

      while(var4.f()) {
         y.d.t var5 = var4.a();
         if(var3 != null && Math.abs(var3.a - var5.a) > 1.0E-6D && Math.abs(var3.b - var5.b) > 1.0E-6D) {
            return false;
         }

         var3 = var5;
         var4.g();
         if(var6 != 0) {
            break;
         }
      }

      return true;
   }

   static boolean b(y.c.d var0, y.f.X var1) {
      int var24 = ab.a;
      y.d.v var2 = var1.l(var0);
      int var3 = 0;

      int var10000;
      while(true) {
         if(var3 < var2.h() - 1) {
            y.d.m var4 = var2.a(var3);
            double var5 = var4.f();
            var10000 = var3;
            if(var24 != 0) {
               break;
            }

            if(var3 != 0 && var3 != var2.h() - 1) {
               if((0.999999D >= var5 || var5 >= 1.000001D) && (-1.000001D >= var5 || var5 >= -0.999999D) && !var4.b() && !var4.a()) {
                  return false;
               }

               if(0.999999D < var5 && var5 < 1.000001D || -1.000001D < var5 && var5 < -0.999999D) {
                  y.d.m var7 = var2.a(var3 - 1);
                  double var8 = var7.c().a();
                  double var10 = var7.d().a();
                  double var12 = var4.c().a();
                  double var14 = var4.d().a();
                  if(var7.b() && var8 < var10 && var12 > var14 || var8 > var10 && var12 < var14) {
                     return false;
                  }

                  double var16 = var7.c().b();
                  double var18 = var7.d().b();
                  double var20 = var4.c().b();
                  double var22 = var4.d().b();
                  if(var7.a() && var16 < var18 && var20 > var22 || var16 > var18 && var20 < var22) {
                     return false;
                  }
               }
            } else if(!var4.b() && !var4.a()) {
               return false;
            }

            ++var3;
            if(var24 == 0) {
               continue;
            }
         }

         var10000 = 1;
         break;
      }

      return (boolean)var10000;
   }

   private static y.d.m[] a(List var0) {
      int var4 = ab.a;
      if(var0 != null && var0.size() != 0) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = var0.iterator();

         ArrayList var10000;
         while(true) {
            if(var2.hasNext()) {
               y.d.m var3 = (y.d.m)var2.next();
               if(var3.g() <= 1.0E-6D) {
                  continue;
               }

               var10000 = var1;
               if(var4 != 0) {
                  break;
               }

               var1.add(var3);
               if(var4 == 0) {
                  continue;
               }
            }

            var10000 = var1;
            break;
         }

         return (y.d.m[])var10000.toArray(new y.d.m[var1.size()]);
      } else {
         return new y.d.m[0];
      }
   }

   private static y.d.v a(y.d.v var0) {
      int var5 = ab.a;
      if(var0 != null && var0.h() > 1) {
         ArrayList var1 = new ArrayList(var0.h());
         y.d.t var2 = null;
         y.d.u var3 = var0.b();

         while(var3.f()) {
            y.d.t var4 = var3.a();
            if(var2 == null || !var2.equals(var4)) {
               var1.add(var4);
            }

            var2 = var4;
            var3.g();
            if(var5 != 0) {
               break;
            }
         }

         return new y.d.v(var1);
      } else {
         return var0;
      }
   }

   static y.d.m[] c(y.c.d var0, y.f.X var1) {
      int var10 = ab.a;
      ArrayList var2 = new ArrayList();
      boolean var3 = false;
      y.d.t var4 = null;
      y.d.m var5 = null;
      y.d.v var6 = a(var1.l(var0));
      if(var6.h() <= 1) {
         return new y.d.m[0];
      } else {
         y.d.s var7 = var6.j();

         while(true) {
            if(var7.f()) {
               var5 = (y.d.m)var7.d();
               if(var10 != 0) {
                  break;
               }

               label81: {
                  if(var4 == null) {
                     var4 = var5.c();
                     var3 = var5.a();
                     if(var10 == 0) {
                        break label81;
                     }
                  }

                  if(var5.a() && !var3 || var5.b() && var3) {
                     var2.add(new y.d.m(var4, var5.c()));
                     var4 = var5.c();
                     var3 = !var3;
                     if(var10 == 0) {
                        break label81;
                     }
                  }

                  if(!var5.b() && !var5.a()) {
                     y.d.t var8 = var5.d();
                     y.d.t var9 = var3?new y.d.t(var4.a(), var8.b()):new y.d.t(var8.a(), var4.b());
                     var2.add(new y.d.m(var4, var9));
                     var4 = var9;
                     var3 = !var3;
                  }
               }

               var7.g();
               if(var10 == 0) {
                  continue;
               }
            }

            var2.add(new y.d.m(var4, var5.d()));
            break;
         }

         return a((List)var2);
      }
   }

   public boolean i() {
      return this.o;
   }

   public boolean j() {
      return this.p;
   }

   public L k() {
      return this.q;
   }

   public void a(double var1) {
      this.w = var1;
   }

   public double l() {
      return this.w;
   }

   protected I a(O var1) {
      return new I(var1);
   }

   protected void a(I var1) {
      int var5 = ab.a;
      List var2 = this.m();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         J var4 = (J)var3.next();
         var1.a((m)var4);
         if(var5 != 0) {
            break;
         }
      }

   }

   protected void b(I var1) {
      int var5 = ab.a;
      List var2 = this.m();
      Iterator var3 = var2.iterator();

      while(true) {
         if(var3.hasNext()) {
            J var4 = (J)var3.next();
            var4.a();
            var1.b((m)var4);
            if(var5 != 0) {
               break;
            }

            if(var5 == 0) {
               continue;
            }
         }

         this.c.a();
         this.c = null;
         break;
      }

   }

   public List m() {
      if(this.x == null) {
         this.x = new ArrayList();
         this.x.add(new az());
         this.x.add(new aC());
         this.x.add(new ar());
         this.x.add(new bX());
         this.x.add(new bp());
         this.x.add(new bS());
         this.x.add(new aD());
      }

      return this.x;
   }

   protected V n() {
      return new V();
   }

   protected void a(V var1) {
      int var5 = ab.a;
      List var2 = this.o();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         ab var4 = (ab)var3.next();
         var1.a(var4);
         if(var5 != 0) {
            break;
         }
      }

   }

   public List o() {
      if(this.y == null) {
         this.y = new ArrayList();
         this.y.add(new ax());
         this.y.add(new ay());
         this.y.add(new aY());
         this.y.add(new aX());
         this.y.add(new bb());
         this.y.add(new av());
         this.y.add(new aV());
         this.y.add(new aZ());
         this.y.add(new aw());
         this.y.add(new bW());
         this.y.add(new aG());
         this.y.add(new bi());
         this.y.add(new bF());
         this.y.add(new aM());
         this.y.add(new bf());
         this.y.add(new ca());
         this.y.add(new bj());
         this.y.add(new bk());
      }

      return this.y;
   }

   protected i p() {
      return new i();
   }

   protected n q() {
      return new n();
   }

   protected aa a(V var1, Z var2) {
      return new aa(var1, var2);
   }

   protected Z a(y.f.X var1, y.f.b.c var2) {
      return new Z(var1, var2, this);
   }

   public void c(y.f.X var1) {
      int var23 = ab.a;
      if(this.a() != null) {
         this.a().c(var1);
      }

      if(var1.h() != 0) {
         bm var2 = new bm(var1, this);
         var2.a();
         var2.b();
         long var3 = System.currentTimeMillis();
         R.f();
         y.f.b.c var5 = new y.f.b.c(var1);
         this.c = this.a(this.t());
         this.a(this.c);
         Z var6 = this.a(var1, var5);
         var6.a(var3);
         this.c.a(var6);
         this.e = this.s();
         this.a(this.e);
         this.e.a(var6);
         this.f = this.u();
         var1.a((Object)b, (y.c.c)y.g.M.b());
         var1.a((Comparator)(new z(this, var1)));

         try {
            boolean var7 = this.b() == Long.MAX_VALUE;
            int var8 = 0;
            if(!var7) {
               y.c.e var9 = var1.p();

               while(var9.f()) {
                  if(this.a((y.c.d)((y.c.d)var9.d()), (y.c.i)var1)) {
                     ++var8;
                  }

                  var9.g();
                  if(var23 != 0) {
                     break;
                  }
               }
            }

            aa var10;
            y.c.f var30;
            label430: {
               var30 = new y.c.f();
               var10 = this.a(this.e, var6);
               if(var7) {
                  var10.b(Long.MAX_VALUE);
                  if(var23 == 0) {
                     break label430;
                  }
               }

               long var11 = this.b() / (long)Math.max(1, var8);
               long var13 = Math.max(100L, var11);
               var10.b(var13);
            }

            y.c.h var31 = y.g.M.b();
            y.c.f var12 = new y.c.f();
            F var32 = new F(var1);

            y.c.f var15;
            label470:
            while(var32.hasNext()) {
               Object var10000 = var32.next();

               label468:
               while(true) {
                  y.c.f var14 = (y.c.f)var10000;
                  var15 = new y.c.f();
                  y.c.e var16 = var14.a();

                  boolean var36;
                  label448: {
                     while(var16.f()) {
                        y.c.d var17 = var16.a();
                        var36 = this.a((y.c.d)var17, (y.c.i)var1);
                        if(var23 != 0) {
                           break label448;
                        }

                        if(var36) {
                           var15.add(var17);
                        }

                        var16.g();
                        if(var23 != 0) {
                           break;
                        }
                     }

                     var10.a(var15);
                     var36 = var7;
                  }

                  label502: {
                     if(var36) {
                        var10.a(Long.MAX_VALUE);
                        if(var23 == 0) {
                           break label502;
                        }
                     }

                     int var37 = var8 - var12.size();
                     double var40 = var37 > 0?(double)var15.size() / (double)var37:1.0D;
                     var10.a((long)(var40 * (double)var6.d()));
                  }

                  this.e.b(var10);
                  ac var38 = var10.i();
                  Iterator var41 = var15.iterator();

                  while(true) {
                     y.c.d var18;
                     do {
                        if(!var41.hasNext()) {
                           continue label470;
                        }

                        var18 = (y.c.d)var41.next();
                        U var19 = var38.b(var18);
                        var10000 = var19;
                        if(var23 != 0) {
                           continue label468;
                        }

                        if(var19 != null) {
                           break;
                        }

                        var31.a(var18, false);
                        var30.add(var18);
                     } while(var23 == 0);

                     var31.a(var18, true);
                     var12.add(var18);
                     if(var23 != 0) {
                        break label470;
                     }
                  }
               }
            }

            boolean var33 = false;
            i var34 = this.u();
            var34.a(var6);
            if(!var12.isEmpty()) {
               var34.a(var12, var10.i());
               var33 = var10.i().a();
            }

            this.a(var1, var30);
            if(this.e() && var6.d() > 0L) {
               var15 = this.a(var1, var12, var31, 0.1D);
               this.a(var15, var10, var6);
               var33 |= var10.i().a();
               if(var6.d() > 0L) {
                  var15 = this.a(var1, var12, var31, 0.1D);
                  this.a(var15, var10, var6);
                  var33 |= var10.i().a();
               }
            }

            if(this.d()) {
               label514: {
                  aN var35 = new aN();
                  if(var33 || !var30.isEmpty()) {
                     ae var39 = new ae((y.f.ah)null);
                     var39.c(this.u);
                     var39.b(this.v);
                     var39.a(var6.c().l());
                     var39.b(this.h());
                     var39.a(this.g());
                     int var42 = this.f() == 0?0:(this.f() == 2?2:4);
                     var39.a((byte)var42);
                     var39.c(var1);
                     if(var23 == 0) {
                        break label514;
                     }
                  }

                  var35.b(this.u);
                  var35.a(this.v);
                  var35.a(var12, var10.i(), var6);
               }
            }

            this.b(var1);
         } finally {
            this.b(this.c);
            this.e.d();
            this.f.a();
            var1.d_(b);
            var5.c();
         }

         try {
            var1.a((Object)aH.a, (y.c.c)(new A(this)));
            (new aH(this.d())).c(var1);
         } finally {
            var1.d_(aH.a);
         }

         var2.c();
      }
   }

   private void b(y.f.X var1) {
      y.g.I var2 = new y.g.I(var1);
      var2.c();
      y.f.aI var3 = new y.f.aI();
      var3.c(var1);
      var2.f();
   }

   private boolean b(y.c.d var1) {
      y.c.c var2 = var1.a().c(y.f.aF.c);
      return var2 != null && var2.b(var1) != null;
   }

   private y.c.f a(y.f.X var1, y.c.f var2, y.c.h var3, double var4) {
      int var15 = ab.a;
      if(var4 >= 1.0D) {
         return var2;
      } else {
         y.c.f var6 = new y.c.f();
         y.c.h var7 = y.g.M.b();
         y.c.h var8 = y.g.M.b();
         y.c.h var9 = y.g.M.b();
         y.c.D var10 = new y.c.D();
         y.c.e var11 = var1.p();

         int var10000;
         while(true) {
            if(var11.f()) {
               y.c.d var12 = var11.a();
               var8.a(var12, var1.k(var12).size());
               var10000 = b(var12, var1);
               if(var15 != 0) {
                  break;
               }

               label55: {
                  if(var10000 != 0) {
                     y.d.s var13 = var1.l(var12).j();

                     while(var13.f()) {
                        y.d.m var14 = var13.a();
                        var10.add(new E(var12, var14, (z)null));
                        var13.g();
                        if(var15 != 0) {
                           break label55;
                        }

                        if(var15 != 0) {
                           break;
                        }
                     }
                  }

                  var11.g();
               }

               if(var15 == 0) {
                  continue;
               }
            }

            y.d.f.a(var10, new B(this, var9, var3, var7, var6));
            var2.sort(new D(var8, var9, (z)null));
            var10000 = Math.min(3, (int)Math.ceil((double)var2.size() * var4));
            break;
         }

         int var16 = var10000;
         y.c.e var17 = var2.a();

         y.c.f var19;
         while(true) {
            if(var17.f()) {
               var19 = var6;
               if(var15 != 0) {
                  break;
               }

               if(var6.size() < var16) {
                  y.c.d var18 = var17.a();
                  if(!this.b(var18) && !var7.d(var18)) {
                     var7.a(var18, true);
                     var6.add(var18);
                  }

                  var17.g();
                  if(var15 == 0) {
                     continue;
                  }
               }
            }

            a((y.c.D)var6);
            var19 = var6;
            break;
         }

         return var19;
      }
   }

   private static void a(y.c.D var0) {
      int var4 = ab.a;
      y.g.ar var1 = new y.g.ar(42L);
      Object[] var2 = var0.toArray();
      var1.a(var2);
      var0.clear();
      int var3 = 0;

      while(var3 < var2.length) {
         var0.add(var2[var3]);
         ++var3;
         if(var4 != 0) {
            break;
         }
      }

   }

   private void a(y.c.f var1, aa var2, Z var3) {
      int var16 = ab.a;
      y.f.X var4 = var3.a();
      ac var5 = var2.i();
      y.c.h var6 = (y.c.h)var4.c(b);
      y.c.e var7 = var4.p();

      while(var7.f()) {
         y.c.d var8 = var7.a();
         if(var5.b(var8) != null) {
            w var9 = var5.a(var8);
            var9.a();
         }

         var7.g();
         if(var16 != 0) {
            break;
         }
      }

      y.c.f var17 = new y.c.f();
      G var18 = new G(var1, var4);

      y.c.f var23;
      label111:
      while(true) {
         if(var18.hasNext()) {
            Object var10000 = var18.next();

            y.c.f var19;
            label106:
            while(true) {
               y.c.h var10;
               y.c.D var13;
               Object var14;
               be var15;
               boolean var20;
               y.c.e var21;
               label87:
               while(true) {
                  label74:
                  while(true) {
                     var19 = (y.c.f)var10000;
                     var10 = y.g.M.b();
                     var23 = var19;
                     if(var16 != 0) {
                        break label111;
                     }

                     y.c.e var11 = var19.a();

                     while(true) {
                        if(!var11.f()) {
                           break label74;
                        }

                        y.c.d var12 = var11.a();
                        var2.a().a((y.c.d)var12, (U)null);
                        var13 = (y.c.D)var6.b(var12);
                        var10.a(var12, var13);
                        var6.a(var12, (Object)null);
                        var10000 = var13.m();
                        if(var16 != 0) {
                           break;
                        }

                        var14 = var10000;

                        label69: {
                           while(((y.c.C)var14).f()) {
                              var15 = (be)((y.c.C)var14).d();
                              var15.b();
                              ((y.c.C)var14).g();
                              if(var16 != 0) {
                                 break label69;
                              }

                              if(var16 != 0) {
                                 break;
                              }
                           }

                           var11.g();
                        }

                        if(var16 != 0) {
                           break label74;
                        }
                     }
                  }

                  var2.a(var19);
                  this.s().b(var2);
                  var20 = false;
                  var21 = var19.a();

                  while(true) {
                     if(!var21.f()) {
                        break label87;
                     }

                     y.c.d var22 = var21.a();
                     var10000 = var5.b(var22);
                     if(var16 != 0) {
                        break;
                     }

                     if(var10000 == null) {
                        var20 = true;
                        if(var16 == 0) {
                           break label87;
                        }
                     }

                     var21.g();
                     if(var16 != 0) {
                        break label87;
                     }
                  }
               }

               if(!var20) {
                  break;
               }

               var21 = var19.a();

               while(true) {
                  if(!var21.f()) {
                     continue label111;
                  }

                  var13 = (y.c.D)var10.b(var21.a());
                  var10000 = var13.m();
                  if(var16 != 0) {
                     break;
                  }

                  var14 = var10000;

                  label101: {
                     while(((y.c.C)var14).f()) {
                        var15 = (be)((y.c.C)var14).d();
                        var15.a();
                        ((y.c.C)var14).g();
                        if(var16 != 0) {
                           break label101;
                        }

                        if(var16 != 0) {
                           break;
                        }
                     }

                     var21.g();
                  }

                  if(var16 != 0) {
                     break label106;
                  }
               }
            }

            var17.addAll(var19);
            if(var16 == 0) {
               continue;
            }
         }

         var23 = var17;
         break;
      }

      if(!var23.isEmpty()) {
         this.u().a(var17, var5);
      }

   }

   private void a(y.f.X var1, y.c.f var2) {
      int var7 = ab.a;
      if(!var2.isEmpty()) {
         y.c.h var4 = var1.u();
         y.c.e var5 = var2.a();

         while(true) {
            if(var5.f()) {
               var4.a(var5.a(), true);
               var5.g();
               if(var7 != 0) {
                  break;
               }

               if(var7 == 0) {
                  continue;
               }
            }

            var1.a((Object)"EDGES_WITHOUT_ROUTE_DPKEY", (y.c.c)var4);
            break;
         }

         y.f.i.a var8 = new y.f.i.a();
         HashSet var6 = new HashSet(var2);
         var1.a((Object)y.f.i.a.a, (y.c.c)(new C(this, var6)));
         var8.c(var1);
         var1.d_(y.f.i.a.a);
      }
   }

   public I r() {
      return this.c;
   }

   private O t() {
      if(this.d == null) {
         this.d = this.q();
      }

      return this.d;
   }

   V s() {
      if(this.e == null) {
         this.e = this.n();
      }

      return this.e;
   }

   private i u() {
      if(this.f == null) {
         this.f = this.p();
      }

      return this.f;
   }

   static boolean a(y var0, y.c.d var1) {
      return var0.b(var1);
   }
}
