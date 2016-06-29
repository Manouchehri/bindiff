package y.f.c.a;

import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import y.f.c.a.A;
import y.f.c.a.B;
import y.f.c.a.C;
import y.f.c.a.E;
import y.f.c.a.N;
import y.f.c.a.Z;
import y.f.c.a.aA;
import y.f.c.a.aC;
import y.f.c.a.aE;
import y.f.c.a.aG;
import y.f.c.a.aI;
import y.f.c.a.aK;
import y.f.c.a.aL;
import y.f.c.a.aN;
import y.f.c.a.aP;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.aY;
import y.f.c.a.aa;
import y.f.c.a.ab;
import y.f.c.a.ae;
import y.f.c.a.af;
import y.f.c.a.ag;
import y.f.c.a.ai;
import y.f.c.a.aj;
import y.f.c.a.ak;
import y.f.c.a.am;
import y.f.c.a.an;
import y.f.c.a.ao;
import y.f.c.a.ap;
import y.f.c.a.aq;
import y.f.c.a.ar;
import y.f.c.a.as;
import y.f.c.a.at;
import y.f.c.a.av;
import y.f.c.a.aw;
import y.f.c.a.bK;
import y.f.c.a.bP;
import y.f.c.a.cG;
import y.f.c.a.cR;
import y.f.c.a.cd;
import y.f.c.a.cq;
import y.f.c.a.dC;
import y.f.c.a.dp;

final class au implements aP {
   private final y.f.X c;
   private final aV d;
   private C e;
   private final aU f;
   private final y.c.A g;
   private final y.c.h h;
   private cq i;
   private dC j;
   private dp k;
   private bP l;
   private cd m;
   private E n;
   private final y.c.c o;
   private final y.c.c p;
   private final y.c.c q;
   private final y.c.c r;
   private final y.c.c s;
   private final y.c.c t;
   private final y.c.c u;
   private final y.c.c v;
   private final y.c.c w;
   private final y.c.c x;
   private final y.c.h y;
   private final y.g.ap z;
   private final Map A = new HashMap();
   private final Map B = new HashMap();
   Comparator a;
   Comparator b;

   public au(y.f.X var1, aU var2, aV var3, C var4, y.c.A var5, y.c.h var6, y.c.c var7, y.c.c var8, y.c.c var9, y.c.c var10, y.c.h var11, y.g.ap var12) {
      this.c = var1;
      this.f = var2;
      this.d = var3;
      this.e = var4;
      this.h = var6;
      this.g = var5;
      this.o = var1.c(y.f.aF.a);
      this.p = var1.c(y.f.aF.b);
      this.q = var1.c(y.f.ax.a);
      this.r = var1.c(y.f.ax.b);
      this.s = var1.c(y.f.aF.c);
      this.t = var1.c(y.f.aF.d);
      this.x = var10;
      this.v = var7;
      this.u = var8;
      this.w = var9;
      this.y = var11;
      this.z = var12;
   }

   void a(cq var1) {
      this.i = var1;
   }

   void a(dC var1) {
      this.j = var1;
   }

   void a(E var1) {
      this.n = var1;
   }

   void a(bP var1) {
      this.l = var1;
   }

   void a(cd var1) {
      this.m = var1;
   }

   void a(dp var1) {
      this.k = var1;
   }

   public y.c.q a(aQ var1, y.c.q var2, y.c.d var3) {
      return this.a((aQ)var1, (y.c.q)var2, (y.c.d)var3, (bK)null);
   }

   public y.c.q a(aQ var1, y.c.q var2, y.c.d var3, bK var4) {
      y.c.q var5 = this.c.d();
      this.c.b(var5, 0.0D, 0.0D);
      boolean var6 = var2 == var3.c();
      y.d.t var7 = var6?this.c.p(var3):this.c.q(var3);
      this.c.c(var5, var7.a, var7.b);
      this.b(var5, var6?var3.c():var3.d(), var3, var4);
      var1.a(var5);
      return var5;
   }

   public void a(y.c.q var1) {
      aQ var3;
      label27: {
         boolean var9 = N.x;
         aX var2 = this.d.a(var1);
         var3 = this.f.a(var2.j());
         y.c.q var4 = var2.f();
         y.c.d var5 = var2.g();
         y.f.I var6 = this.c.b(var5);
         if(var5.c() == var4) {
            var6.addPoint(0.0D, 0.0D);
            int var7 = var6.pointCount() - 1;

            label23: {
               while(var7 >= 1) {
                  y.d.t var8 = var6.getPoint(var7 - 1);
                  var6.setPoint(var7, var8.a, var8.b);
                  --var7;
                  if(var9) {
                     break label23;
                  }

                  if(var9) {
                     break;
                  }
               }

               var6.setPoint(0, this.c.j(var1), this.c.p(var5).b());
            }

            if(!var9) {
               break label27;
            }
         }

         var6.addPoint(this.c.j(var1), this.c.q(var5).b());
      }

      var3.b(var1);
      this.c.a((y.c.q)var1);
   }

   public y.c.q a(y.c.d var1, boolean var2) {
      return this.a((y.c.d)var1, var2, (bK)null);
   }

   public y.c.q a(y.c.d var1, boolean var2, bK var3) {
      int var4 = this.d.a(var2?var1.c():var1.d()).j();
      y.c.q var5 = this.c.d();
      this.c.b(var5, 0.0D, 0.0D);
      y.d.t var6 = var2?this.c.p(var1):this.c.q(var1);
      this.c.c(var5, var6.a, var6.b);
      this.a(var5, var2?var1.c():var1.d(), var1, var3);
      this.f.a(var4).a(var5);
      if(var2) {
         this.A.put(var1, this.c.n(var1));
         this.c.a(var1, y.d.t.c);
         this.c.a(var1, var5, var1.d());
         if(!N.x) {
            return var5;
         }
      }

      this.B.put(var1, this.c.o(var1));
      this.c.b(var1, y.d.t.c);
      this.c.a(var1, var1.c(), var5);
      return var5;
   }

   public y.c.d b(y.c.q var1) {
      aQ var3;
      y.c.d var4;
      label67: {
         boolean var11 = N.x;
         aX var2 = this.d.a(var1);
         var3 = this.f.a(var2.j());
         y.f.I var5;
         B var6;
         double var7;
         if(var1.c() > 0) {
            this.c.a(var4 = var1.f(), var2.f(), var1.f().d());
            this.c.a(var4, (y.d.t)this.A.get(var4));
            var5 = this.c.b(var4);
            var6 = this.d.a(var4).k();
            var7 = var6.i() / (double)Math.abs(2);
            int var9;
            y.d.t var10;
            if(var6.h().c() != 1) {
               var5.addPoint(0.0D, 0.0D);
               var9 = var5.pointCount() - 1;

               while(true) {
                  if(var9 >= 1) {
                     var10 = var5.getPoint(var9 - 1);
                     var5.setPoint(var9, var10.a, var10.b);
                     --var9;
                     if(var11) {
                        break;
                     }

                     if(!var11) {
                        continue;
                     }
                  }

                  var5.setPoint(0, this.c.j(var1), this.c.p(var4).b());
                  break;
               }

               if(!var11) {
                  break label67;
               }
            }

            var5.addPoint(0.0D, 0.0D);
            var5.addPoint(0.0D, 0.0D);
            var9 = var5.pointCount() - 1;

            label70: {
               while(var9 >= 2) {
                  var10 = var5.getPoint(var9 - 2);
                  var5.setPoint(var9, var10.a, var10.b);
                  --var9;
                  if(var11) {
                     break label70;
                  }

                  if(var11) {
                     break;
                  }
               }

               if(this.c.j(var1) < this.c.p(var4).a()) {
                  var5.setPoint(0, this.c.j(var1) + var7, this.c.p(var4).b());
                  var5.setPoint(1, this.c.j(var1), this.c.p(var4).b() + var7);
                  if(!var11) {
                     break label67;
                  }
               }

               var5.setPoint(0, this.c.j(var1) - var7, this.c.p(var4).b());
               var5.setPoint(1, this.c.j(var1), this.c.p(var4).b() + var7);
            }

            if(!var11) {
               break label67;
            }
         }

         this.c.a(var4 = var1.g(), var1.g().c(), var2.f());
         this.c.b(var4, (y.d.t)this.B.get(var4));
         var5 = this.c.b(var4);
         var6 = this.d.a(var4).k();
         var7 = var6.i() / (double)Math.abs(2);
         if(var6.h().c() != 1) {
            var5.addPoint(this.c.j(var1), this.c.q(var4).b());
            if(!var11) {
               break label67;
            }
         }

         if(this.c.j(var1) < this.c.q(var4).a()) {
            var5.addPoint(this.c.j(var1), this.c.q(var4).b() - var7);
            var5.addPoint(this.c.j(var1) + var7, this.c.q(var4).b());
            if(!var11) {
               break label67;
            }
         }

         var5.addPoint(this.c.j(var1), this.c.q(var4).b() - var7);
         var5.addPoint(this.c.j(var1) - var7, this.c.q(var4).b());
      }

      var3.b(var1);
      this.c.a((y.c.q)var1);
      return var4;
   }

   public y.c.q a(aQ var1, y.c.d var2) {
      return this.a((aQ)var1, (y.c.d)var2, (bK)null);
   }

   public y.c.q a(aQ var1, y.c.d var2, bK var3) {
      y.c.q var4;
      label11: {
         var4 = this.c.d();
         this.c.b(var4, 0.0D, 0.0D);
         if(var3 == null) {
            this.a(var4, var2);
            if(!N.x) {
               break label11;
            }
         }

         this.a(var4, var2, var3);
      }

      var1.a(var4);
      return var4;
   }

   public aQ a(boolean var1, int var2) {
      aQ var3;
      if(var1) {
         var3 = this.f.a((byte)1, var2);
         this.a(this.f.a(var2 - 1), true, var3);
         return var3;
      } else {
         var3 = this.f.a((byte)1, var2);
         this.a(this.f.a(var2 + 2), false, var3);
         return var3;
      }
   }

   private void a(aQ var1, boolean var2, aQ var3) {
      boolean var8 = N.x;
      y.c.p var4;
      y.c.q var5;
      y.c.d[] var6;
      int var7;
      if(var2) {
         if(this.a == null) {
            this.a = new cG(this.c, this.f, this.d);
         }

         var4 = var1.d().k();

         label63:
         do {
            if(var4 == null) {
               return;
            }

            var5 = (y.c.q)var4.c();
            var5.b(this.a);
            var6 = (new y.c.f(var5.l())).e();
            var7 = 0;

            while(var7 < var6.length) {
               this.a(var6[var7], var3, var2);
               ++var7;
               if(var8) {
                  continue label63;
               }

               if(var8) {
                  break;
               }
            }

            var4 = var4.a();
         } while(!var8);
      }

      if(this.b == null) {
         this.b = new cR(this.c, this.f, this.d);
      }

      var4 = var1.d().k();

      while(var4 != null) {
         var5 = (y.c.q)var4.c();
         var5.a(this.b);
         var6 = (new y.c.f(var5.k())).e();
         var7 = 0;

         label42: {
            while(var7 < var6.length) {
               this.a(var6[var7], var3, var2);
               ++var7;
               if(var8) {
                  break label42;
               }

               if(var8) {
                  break;
               }
            }

            var4 = var4.a();
         }

         if(var8) {
            break;
         }
      }

   }

   private y.c.q c(aQ var1, y.c.d var2) {
      aX var3 = (aX)this.g.b(var2.c());
      if(var3.b() != 12 && var3.b() != 13) {
         return this.a(var1, var2);
      } else {
         y.c.q var4 = var3.l();
         bK var5 = var3.b() == 12?this.n.a(var4):this.n.b(var4);
         return this.a(var1, var2, var5);
      }
   }

   private void a(y.c.d var1, aQ var2, boolean var3) {
      boolean var11 = N.x;
      aX var4 = (aX)this.g.b(var1.c());
      aX var5 = (aX)this.g.b(var1.d());
      boolean var6 = var4.b() == 1;
      boolean var7 = var5.b() == 1;
      y.c.q var8;
      y.c.q var9;
      y.c.d var10;
      if(var6 && var7) {
         label63: {
            var8 = this.c(var2, var4.g());
            var9 = var1.d();
            var10 = var1.i();
            if(var10 == null) {
               this.c.a(var1, var1.c(), var1.g(), 1, var8, (y.c.d)null, 0);
               if(!var11) {
                  break label63;
               }
            }

            this.c.a(var1, var1.c(), var10, 0, var8, (y.c.d)null, 0);
         }

         this.a(var8, var9, var1, false, false);
         if(!var11) {
            return;
         }
      }

      if(var6 && !var7) {
         label53: {
            var8 = this.c(var2, var4.g());
            var9 = var1.c();
            var10 = var1.j();
            if(var10 == null) {
               this.c.a(var1, var8, (y.c.d)null, 0, var1.d(), var1.h(), 1);
               if(!var11) {
                  break label53;
               }
            }

            this.c.a(var1, var8, (y.c.d)null, 0, var1.d(), var1.j(), 0);
         }

         this.a(var9, var8, var1, false, false);
         if(!var11) {
            return;
         }
      }

      if(var7 && !var6) {
         label43: {
            var8 = this.c(var2, var5.g());
            var9 = var1.d();
            var10 = var1.i();
            if(var10 == null) {
               this.c.a(var1, var1.c(), var1.g(), 1, var8, (y.c.d)null, 0);
               if(!var11) {
                  break label43;
               }
            }

            this.c.a(var1, var1.c(), var10, 0, var8, (y.c.d)null, 0);
         }

         this.a(var8, var9, var1, false, false);
         if(!var11) {
            return;
         }
      }

      var8 = null;
      var9 = null;
      A var13 = (A)this.h.b(var1);
      if(var13.a() == 6) {
         var8 = this.a(var4.l(), var2, var4.b());
         var2.a(var8);
         this.a(var1.c(), var8);
         this.a(var8, var1.d());
      } else {
         var8 = this.c(var2, var1);
         y.c.d var12 = this.a(var1.c(), var8, var1, true, false);
         this.c.a(var12, var12.c(), var1, 0, var12.d(), (y.c.d)null, 1);
         this.a(var8, var1.d(), var1, false, true);
      }

      this.c.a((y.c.d)var1);
   }

   public aX a(y.c.q var1, y.c.d var2) {
      A var3 = this.d.a(var2);
      return this.a(var1, var2, this.d.a(var3.i()?var2.c():var2.d()).h());
   }

   public aX a(y.c.q var1, y.c.d var2, bK var3) {
      aA var4 = new aA(var1, var2, var3);
      this.g.a(var1, var4);
      return var4;
   }

   public A a(y.c.d var1) {
      y.f.aE var2 = null;
      y.f.aE var3 = null;
      Object var4 = null;
      Object var5 = null;
      Object var6 = null;
      Object var7 = null;
      Object var8 = null;
      B var9 = null;
      if(this.o != null) {
         var2 = (y.f.aE)this.o.b(var1);
      }

      if(this.p != null) {
         var3 = (y.f.aE)this.p.b(var1);
      }

      if(this.q != null) {
         var4 = (Collection)this.q.b(var1);
         if(var4 != null) {
            var4 = new ArrayList((Collection)var4);
         }
      }

      if(this.r != null) {
         var5 = (Collection)this.r.b(var1);
         if(var5 != null) {
            var5 = new ArrayList((Collection)var5);
         }
      }

      if(this.s != null) {
         var6 = this.s.b(var1);
      }

      if(this.t != null) {
         var7 = this.t.b(var1);
      }

      y.c.c var10 = this.c.c(y.f.b.f.d);
      if(var10 != null) {
         if(var10.d(var1.c())) {
            var4 = null;
            var6 = null;
         }

         if(var10.d(var1.d())) {
            var5 = null;
            var7 = null;
         }
      }

      if(this.u != null) {
         Object var11 = this.u.b(var1);
         if(var11 instanceof B) {
            var9 = (B)var11;
         }
      }

      if(var2 == null && var3 == null && var4 == null && var5 == null) {
         if(var6 == null && var7 == null) {
            var8 = new ao(var9);
         } else {
            var8 = new aj(var9, var6, var7);
         }
      } else if(var6 == null && var7 == null) {
         var8 = new ak(var1, var9, var2, (Collection)var4, var3, (Collection)var5, var6, var7);
      } else {
         var8 = new aK(var1, var9, var6, var7, var2, (Collection)var4, var3, (Collection)var5);
      }

      this.h.a(var1, var8);
      return (A)var8;
   }

   public aX c(y.c.q var1) {
      aY var2 = null;
      if(this.v != null) {
         Object var3 = this.v.b(var1);
         if(var3 instanceof aY) {
            var2 = (aY)var3;
         }
      }

      bK var6 = null;
      if(this.w != null) {
         Object var4 = this.w.b(var1);
         if(var4 instanceof bK) {
            var6 = (bK)var4;
         }
      }

      Z var7 = null;
      if(this.x != null) {
         Object var5 = this.x.b(var1);
         if(var5 instanceof Z) {
            var7 = (Z)var5;
         }
      }

      ae var8 = new ae(var2, var6, var7);
      this.g.a(var1, var8);
      return var8;
   }

   public aX a(y.c.q var1, double var2, double var4, y.c.d[] var6) {
      an var7 = new an(var2, var4, var6, (bK)null);
      this.g.a(var1, var7);
      return var7;
   }

   public aX a(y.c.q var1, y.c.q var2, y.c.d var3, bK var4) {
      af var5 = new af(var2, var3, var4);
      this.g.a(var1, var5);
      return var5;
   }

   public aX b(y.c.q var1, y.c.q var2, y.c.d var3, bK var4) {
      aI var5 = new aI(var2, var3, var4);
      this.g.a(var1, var5);
      return var5;
   }

   public aX a(boolean var1, y.c.q var2, y.c.d var3, y.c.q var4, y.c.d var5) {
      Object var6;
      label11: {
         if(var1) {
            var6 = new aq(var3, var5, var4, this.d.a(var3.d()).h());
            if(!N.x) {
               break label11;
            }
         }

         var6 = new aE(var3, var5, var4, this.d.a(var3.c()).h());
      }

      this.g.a(var2, var6);
      return (aX)var6;
   }

   public y.c.q a(y.c.q var1, aQ var2, byte var3) {
      y.c.q var4 = this.c.d();
      this.c.b(var4, 1.0D, 1.0D);
      bK var5 = null;
      switch(var3) {
      case 12:
         var5 = this.n.a(var1);
         break;
      case 13:
         var5 = this.n.b(var1);
      }

      aC var6 = new aC(var5, var1, var2, var3);
      this.g.a(var4, var6);
      this.n.f(var1).b((Object)var4);
      return var4;
   }

   public y.c.q a(aQ var1, Object var2) {
      y.c.q var3 = this.c.d();
      this.c.b(var3, 0.0D, 0.0D);
      this.a(var3, var2, var1.e() == 2);
      var1.a(var3);
      return var3;
   }

   public aX a(y.c.q var1, Object var2, boolean var3) {
      Object var4;
      label11: {
         if(var3) {
            var4 = new aG(var1, var2, (bK)null);
            if(!N.x) {
               break label11;
            }
         }

         var4 = new ab(var1, var2, (bK)null);
      }

      this.g.a(var1, var4);
      return (aX)var4;
   }

   public aX b(y.c.q var1, y.c.d var2) {
      aN var3 = new aN(var2, this.d.a(var2.c()).h());
      this.g.a(var1, var3);
      return var3;
   }

   public y.c.d a(y.c.q var1, y.c.q var2) {
      y.c.d var3 = this.c.a((y.c.q)var1, (y.c.q)var2);
      at var4 = new at();
      this.h.a(var3, var4);
      return var3;
   }

   public y.c.q a(y.c.q var1, Object var2, aQ var3, y.c.d var4) {
      y.c.q var5 = var4.a(var1);
      bK var6 = null;
      if(this.g.b(var5) instanceof aX) {
         var6 = ((aX)this.g.b(var5)).h();
      } else if(this.w.b(var5) instanceof bK) {
         var6 = (bK)this.w.b(var5);
      }

      bK var7 = this.n.a(var1);
      bK var8 = this.n.b(var1);
      if(var7 != null && var8 != null) {
         label27: {
            if(var6 != null) {
               if(var7.compareTo(var6) > 0) {
                  var6 = var7;
               }

               if(var8.compareTo(var6) >= 0) {
                  break label27;
               }

               var6 = var8;
               if(!N.x) {
                  break label27;
               }
            }

            var6 = var7;
         }
      } else {
         var6 = null;
      }

      y.c.q var9 = this.c.d();
      this.c.b(var9, 0.0D, 0.0D);
      ar var10 = new ar(var6, var1, var3, var4);
      this.g.a(var9, var10);
      var3.a(var9);
      return var9;
   }

   public y.c.d a(y.c.q var1, y.c.q var2, y.c.d var3, boolean var4, boolean var5) {
      y.c.d var6;
      Object var7;
      label19: {
         boolean var9 = N.x;
         var6 = this.c.a((y.c.q)var1, (y.c.q)var2);
         A var8 = this.d.a(var3);
         if(var4) {
            var7 = new av(var3, var8);
            this.c.a(var6, this.c.n(var3));
            if(!var9) {
               break label19;
            }
         }

         if(var5) {
            var7 = new am(var3, var8);
            this.c.b(var6, this.c.o(var3));
            if(!var9) {
               break label19;
            }
         }

         var7 = new aL(var3, var8);
      }

      this.h.a(var6, var7);
      return var6;
   }

   public y.c.d b(y.c.q var1, y.c.q var2, y.c.d var3, boolean var4, boolean var5) {
      y.c.d var6;
      Object var7;
      label19: {
         boolean var10 = N.x;
         var6 = this.c.a((y.c.q)var1, (y.c.q)var2);
         A var8 = this.d.a(var3);
         if(var4) {
            var7 = new aw(var3, var8);
            this.c.a(var6, this.c.o(var3));
            if(!var10) {
               break label19;
            }
         }

         if(var5) {
            var7 = new aa(var3, var8);
            this.c.b(var6, this.c.n(var3));
            if(!var10) {
               break label19;
            }
         }

         aL var9 = new aL(var3, var8);
         var9.b(true);
         var7 = var9;
      }

      this.h.a(var6, var7);
      return var6;
   }

   public y.c.d a(y.c.q var1, y.c.q var2, y.c.d var3) {
      y.c.d var4 = this.c.a((y.c.q)var1, (y.c.q)var2);
      aX var5 = (aX)this.g.b(var1);
      aX var6 = (aX)this.g.b(var2);
      ap var7 = new ap(var5.a(), var6.a(), var3, var3 != null?this.d.a(var3).k():null);
      this.h.a(var4, var7);
      return var4;
   }

   public void b(y.c.d var1) {
      as var2 = (as)this.g.b(var1.c());
      var2.a(var1);
      var2 = (as)this.g.b(var1.d());
      var2.a(var1);
      this.f.a(var2.j()).a(var1);
   }

   public y.c.d a(aQ var1, y.c.d var2, y.c.q var3) {
      boolean var4;
      y.c.q var5;
      y.c.d var6;
      Object var7;
      label15: {
         var4 = var2.c() == var3;
         var5 = this.c.d();
         this.c.b(var5, 0.0D, 0.0D);
         if(var4) {
            var6 = this.c.a((y.c.q)var3, (y.c.q)var5);
            this.c.a(var6, this.c.n(var2));
            this.c.a(var2, y.d.t.c);
            this.c.a(var2, var5, var2.d());
            var7 = new av(var2, this.d.a(var2));
            if(!N.x) {
               break label15;
            }
         }

         var6 = this.c.a((y.c.q)var5, (y.c.q)var3);
         this.c.b(var6, this.c.o(var2));
         this.c.b(var2, y.d.t.c);
         this.c.a(var2, var2.c(), var5);
         var7 = new am(var2, this.d.a(var2));
      }

      this.h.a(var6, var7);
      this.a(var4, var5, var2, var3, var6);
      var1.a(var5);
      return var6;
   }

   public y.c.d c(y.c.d var1) {
      boolean var11 = N.x;
      y.f.I var2 = this.c.b(var1);
      A var3 = this.d.a(var1);
      boolean var4 = var3.b().c() == var1.d();
      y.c.q var5;
      y.c.q var6;
      y.f.I var7;
      y.d.t var8;
      int var9;
      y.d.t var10;
      if(var4) {
         var5 = var1.d();
         var6 = var1.c();
         var7 = this.c.b(var5.f());
         var8 = this.c.q(var1);
         var2.addPoint(var8.a, var8.b);
         this.c.a(var5.f(), this.c.n(var1));
         var9 = 0;

         label51: {
            while(var9 < var2.pointCount()) {
               var7.addPoint(0.0D, 0.0D);
               ++var9;
               if(var11) {
                  break label51;
               }

               if(var11) {
                  break;
               }
            }

            var9 = var7.pointCount() - 1;
         }

         label61: {
            while(var9 >= var2.pointCount()) {
               var10 = var7.getPoint(var9 - var2.pointCount());
               var7.setPoint(var9, var10.a, var10.b);
               --var9;
               if(var11) {
                  break label61;
               }

               if(var11) {
                  break;
               }
            }

            var9 = 0;
         }

         label71: {
            while(var9 < var2.pointCount()) {
               var10 = var2.getPoint(var9);
               var7.setPoint(var9, var10.a, var10.b);
               ++var9;
               if(var11) {
                  break label71;
               }

               if(var11) {
                  break;
               }
            }

            this.c.a(var1 = var5.f(), var6, var5.f().d());
            this.c.a((y.c.q)var5);
         }

         if(!var11) {
            return var1;
         }
      }

      var5 = var1.c();
      var6 = var1.d();
      var7 = this.c.b(var5.g());
      var8 = this.c.p(var1);
      var7.addPoint(var8.a, var8.b);
      this.c.b(var5.g(), this.c.o(var1));
      var9 = 0;

      label38: {
         while(var9 < var2.pointCount()) {
            var10 = var2.getPoint(var9);
            var7.addPoint(var10.a, var10.b);
            ++var9;
            if(var11) {
               break label38;
            }

            if(var11) {
               break;
            }
         }

         this.c.a(var1 = var5.g(), var5.g().c(), var6);
      }

      this.c.a((y.c.q)var5);
      return var1;
   }

   public y.c.q b(aQ var1, y.c.d var2) {
      boolean var10 = N.x;
      y.c.q var3 = this.c.d();
      this.c.b(var3, 0.0D, 0.0D);
      ArrayList var4 = new ArrayList();
      ArrayList var5 = new ArrayList();
      if(this.z != null) {
         y.f.S[] var6 = (y.f.S[])this.z.b((Object)var2);
         if(var6 != null) {
            int var7 = 0;

            while(var7 < var6.length) {
               label27: {
                  y.f.S var8 = var6[var7];
                  y.f.aG var9 = var8.f();
                  if(var9.k()) {
                     var5.add(var8);
                     if(!var10) {
                        break label27;
                     }
                  }

                  var4.add(var8);
               }

               ++var7;
               if(var10) {
                  break;
               }
            }
         }
      }

      y.c.d var13 = this.c.a((y.c.q)var2.c(), (y.c.q)var3);
      this.c.a(var13, this.c.n(var2));
      av var11 = new av(var2, this.d.a(var2));
      if(this.y != null) {
         this.y.a(var13, var4.toArray(new y.f.S[var4.size()]));
      }

      this.h.a(var13, var11);
      y.c.d var14 = this.c.a((y.c.q)var3, (y.c.q)var2.d());
      this.c.b(var14, this.c.o(var2));
      am var12 = new am(var2, this.d.a(var2));
      if(this.y != null) {
         this.y.a(var14, var5.toArray(new y.f.S[var5.size()]));
      }

      this.h.a(var14, var12);
      this.b(var3, var2);
      var1.a(var3);
      this.c.a((y.c.d)var2);
      return var3;
   }

   public y.c.d d(y.c.q var1) {
      boolean var10 = N.x;
      aX var2 = this.d.a(var1);
      y.c.d var3 = var2.g();
      if(var3.c().e() == null) {
         this.c.b(var3.c());
         this.c.a(var3.c(), this.c.l(var1.g().c()));
      }

      if(var3.d().e() == null) {
         this.c.b(var3.d());
         this.c.a(var3.d(), this.c.l(var1.f().d()));
      }

      this.c.b(var3);
      y.f.I var4 = this.c.b(var3);
      var4.clearPoints();
      y.c.d var5 = var1.g();
      this.c.a(var3, this.c.n(var5));
      y.f.I var6 = this.c.b(var5);
      int var7 = 0;

      y.d.t var10000;
      while(true) {
         if(var7 < var6.pointCount()) {
            var10000 = var6.getPoint(var7);
            if(var10) {
               break;
            }

            y.d.t var8 = var10000;
            var4.addPoint(var8.a, var8.b);
            ++var7;
            if(!var10) {
               continue;
            }
         }

         var10000 = this.c.l(var1);
         break;
      }

      y.d.t var11 = var10000;
      var4.addPoint(var11.a, var11.b);
      var5 = var1.f();
      var6 = this.c.b(var5);
      int var12 = 0;

      while(true) {
         if(var12 < var6.pointCount()) {
            y.d.t var9 = var6.getPoint(var12);
            var4.addPoint(var9.a, var9.b);
            ++var12;
            if(var10) {
               break;
            }

            if(!var10) {
               continue;
            }
         }

         this.c.b(var3, this.c.o(var5));
         this.c.a((y.c.q)var1);
         break;
      }

      return var5;
   }

   public A a(y.c.d var1, boolean var2, y.f.aE var3) {
      Object var4;
      label47: {
         boolean var5 = N.x;
         var4 = (A)this.h.b(var1);
         if(var4 instanceof ai) {
            var4 = ((ai)var4).a(var2, var3);
            if(!var5) {
               break label47;
            }
         }

         System.err.println("warning : unidentified edge type " + var4 + " for " + var1);
         if(var4 != null) {
            var4 = new aK(var1, ((A)var4).k(), ((A)var4).g(), ((A)var4).h(), ((A)var4).c(), ((A)var4).d(), ((A)var4).e(), ((A)var4).f());
            if(!var5) {
               break label47;
            }
         }

         if(this.u != null && this.u.b(var1) instanceof B) {
            var4 = new ak(var1, (B)this.u.b(var1), var2?var3:null, (Collection)null, var2?null:var3, (Collection)null);
            if(!var5) {
               break label47;
            }
         }

         var4 = new ak(var1, new B(), var2?var3:null, (Collection)null, var2?null:var3, (Collection)null);
      }

      this.h.a(var1, var4);
      return (A)var4;
   }

   public A a(y.c.d var1, Object var2, Object var3) {
      A var4 = (A)this.h.b(var1);
      aK var5 = new aK(var1, var4.k(), var2, var3, var4.c(), var4.d(), var4.e(), var4.f());
      this.h.a(var1, var5);
      return var5;
   }

   public y.c.q a(aQ var1, Double var2, y.c.d[] var3) {
      y.c.q var4 = this.c.d();
      this.c.b(var4, var2.width, var2.height);
      this.c.c(var4, var2.x, var2.y);
      this.a(var4, var2.x, var2.y, var3);
      var1.a(var4);
      return var4;
   }

   public void e(y.c.q var1) {
      boolean var14 = N.x;
      an var2 = (an)this.g.b(var1);
      aQ var3 = this.f.a(var2.j());
      y.f.am var4 = this.c.a((Object)var1);
      double var5 = var4.getX() - var2.c;
      double var7 = var4.getY() - var2.b;
      int var9 = 0;

      while(true) {
         if(var9 < var2.a.length) {
            y.c.d var10 = var2.a[var9];
            y.f.I var11 = this.c.b(var10);
            if(var14) {
               break;
            }

            int var12 = 0;

            label27: {
               while(var12 < var11.pointCount()) {
                  y.d.t var13 = var11.getPoint(var12);
                  var11.setPoint(var12, var13.a + var5, var13.b + var7);
                  ++var12;
                  if(var14) {
                     break label27;
                  }

                  if(var14) {
                     break;
                  }
               }

               ++var9;
            }

            if(!var14) {
               continue;
            }
         }

         var3.b(var1);
         this.c.a((y.c.q)var1);
         break;
      }

   }

   public void d(y.c.d var1) {
      ai var2 = (ai)this.h.b(var1);
      ag var3 = new ag(var2);
      this.h.a(var1, var3);
   }
}
