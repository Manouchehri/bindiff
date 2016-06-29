package y.f;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import y.f.C;
import y.f.D;
import y.f.I;
import y.f.O;
import y.f.X;
import y.f.ah;
import y.f.aj;
import y.f.ak;
import y.f.am;
import y.f.m;
import y.f.n;
import y.f.o;
import y.f.p;
import y.f.q;
import y.f.r;
import y.f.s;
import y.f.t;
import y.f.u;
import y.f.x;

public class l extends X {
   private y.c.A a;
   private y.c.h b;
   private y.c.A h;
   private y.c.h i;
   private Map k;
   private Map l;
   private y.c.A m;
   private Map n;
   private y.c.h o;
   private Map p;
   private Map q;
   private y.c.n r;
   private O s;
   private static final Object t;
   private static final Object u;

   public l(X var1) {
      this(var1, var1);
   }

   public l(y.c.n var1, O var2) {
      this.k = new HashMap();
      this.l = new HashMap();
      this.r = var1;
      this.s = var2;
      this.a = this.t();
      this.h = this.t();
      this.b = this.u();
      this.i = this.u();
      this.m = this.t();
      this.o = this.u();
      this.p = new HashMap();
      this.n = new HashMap();
      this.q = new HashMap();
      this.c(var1);
      this.b(var1);
      this.a(var1);
      y.c.c var3 = var1.c(ah.f_);
      this.a(ah.f_, new m(this, var3));
      y.c.c var4 = var1.c(ah.k);
      this.a(ah.k, new n(this, var4));
   }

   private void a(y.c.n var1) {
      boolean var5 = X.j;
      Object[] var2 = var1.z();
      int var3 = 0;

      while(var3 < var2.length) {
         label37: {
            y.c.c var4 = var1.c(var2[var3]);
            if(var4.getClass() == t) {
               this.a(var2[var3], new t(this, (y.c.A)var4));
               if(!var5) {
                  break label37;
               }
            }

            if(var4.getClass() == u) {
               this.a(var2[var3], new r(this, (y.c.h)var4));
               if(!var5) {
                  break label37;
               }
            }

            if(var4 instanceof y.c.a) {
               this.a(var2[var3], new s(this, var4));
               if(!var5) {
                  break label37;
               }
            }

            this.a(var2[var3], new q(this, var4));
         }

         ++var3;
         if(var5) {
            break;
         }
      }

   }

   private void b(y.c.n var1) {
      boolean var3 = X.j;
      Iterator var2 = var1.y();

      while(var2.hasNext()) {
         this.e(var2.next());
         if(var3) {
            break;
         }
      }

   }

   public y.c.d e(Object var1) {
      boolean var9 = X.j;
      y.c.q var2 = (y.c.q)this.q.get(this.r.b_(var1));
      y.c.q var3 = (y.c.q)this.q.get(this.r.c_(var1));
      y.c.d var4 = this.a(var2, var3);
      this.o.a(var4, var1);
      this.q.put(var1, var4);
      this.b.a(var4, new u(this.s.b(var1)));
      C[] var5 = this.s.d(var1);
      C[] var6 = new C[var5.length];
      int var7 = 0;

      while(true) {
         if(var7 < var6.length) {
            D var8 = new D();
            var8.a((y.d.n)var5[var7].getOrientedBox());
            var8.setModelParameter(var5[var7].getModelParameter());
            var8.a(var5[var7].getLabelModel());
            var8.a(var5[var7].getPreferredPlacementDescriptor());
            var6[var7] = var8;
            this.l.put(var6[var7], var4);
            this.p.put(var6[var7], var5[var7]);
            ++var7;
            if(var9) {
               break;
            }

            if(!var9) {
               continue;
            }
         }

         this.i.a(var4, var6);
         break;
      }

      return var4;
   }

   protected y.g.C b() {
      return new o(this);
   }

   private void c(y.c.n var1) {
      boolean var3 = X.j;
      Iterator var2 = var1.x();

      while(var2.hasNext()) {
         this.f(var2.next());
         if(var3) {
            break;
         }
      }

   }

   public y.c.q f(Object var1) {
      boolean var7 = X.j;
      y.c.q var2 = this.d();
      this.q.put(var1, var2);
      this.m.a(var2, var1);
      this.a.a(var2, new x(this.s.a(var1)));
      aj[] var3 = this.s.a_(var1);
      aj[] var4 = new aj[var3.length];
      int var5 = 0;

      while(true) {
         if(var5 < var4.length) {
            ak var6 = new ak();
            var6.a(var3[var5].getOrientedBox());
            var6.setModelParameter(var3[var5].getModelParameter());
            var6.a(var3[var5].a());
            var4[var5] = var6;
            this.k.put(var4[var5], var2);
            this.n.put(var4[var5], var3[var5]);
            ++var5;
            if(var7) {
               break;
            }

            if(!var7) {
               continue;
            }
         }

         this.h.a(var2, var4);
         break;
      }

      return var2;
   }

   public am h(y.c.q var1) {
      Object var2 = (am)this.a.b(var1);
      if(var2 == null) {
         var2 = new x();
         this.a.a(var1, var2);
      }

      return (am)var2;
   }

   public I g(y.c.d var1) {
      Object var2 = (I)this.b.b(var1);
      if(var2 == null) {
         var2 = new u();
         this.b.a(var1, var2);
      }

      return (I)var2;
   }

   public aj[] i(y.c.q var1) {
      aj[] var2 = (aj[])this.h.b(var1);
      if(var2 == null) {
         var2 = new aj[0];
         this.h.a(var1, var2);
      }

      return var2;
   }

   public C[] h(y.c.d var1) {
      C[] var2 = (C[])this.i.b(var1);
      if(var2 == null) {
         var2 = new C[0];
         this.i.a(var1, var2);
      }

      return var2;
   }

   public y.c.q a(aj var1) {
      return (y.c.q)this.k.get(var1);
   }

   public y.c.d a(C var1) {
      return (y.c.d)this.l.get(var1);
   }

   public O C() {
      return new p(this);
   }

   public void D() {
      boolean var8 = X.j;
      y.c.x var1 = this.o();

      Object var3;
      int var7;
      l var10000;
      while(true) {
         if(var1.f()) {
            y.c.q var2 = var1.e();
            var3 = this.m.b(var2);
            var10000 = this;
            if(var8) {
               break;
            }

            am var4 = this.h(var2);
            if(var4 != null) {
               am var5 = this.s.a(var3);
               var5.setSize(var4.getWidth(), var4.getHeight());
               var5.setLocation(var4.getX(), var4.getY());
            }

            label92: {
               aj[] var12 = this.i(var2);
               if(var12 != null) {
                  aj[] var6 = this.s.a_(var3);
                  var7 = 0;

                  while(var7 < var6.length) {
                     var6[var7].setModelParameter(var12[var7].getModelParameter());
                     ++var7;
                     if(var8) {
                        break label92;
                     }

                     if(var8) {
                        break;
                     }
                  }
               }

               var1.g();
            }

            if(!var8) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      y.c.e var9 = var10000.p();

      label75:
      while(var9.f()) {
         y.c.d var10 = var9.a();
         var3 = this.o.b(var10);
         I var11 = this.g(var10);
         if(var11 != null) {
            label104: {
               I var13 = this.s.b(var3);
               var13.setSourcePoint(var11.getSourcePoint());
               var13.setTargetPoint(var11.getTargetPoint());
               int var15;
               y.d.t var17;
               if(var13.pointCount() != var11.pointCount()) {
                  var13.clearPoints();
                  var15 = 0;

                  do {
                     if(var15 >= var11.pointCount()) {
                        break label104;
                     }

                     var17 = var11.getPoint(var15);
                     var13.addPoint(var17.a(), var17.b());
                     ++var15;
                     if(var8) {
                        continue label75;
                     }
                  } while(!var8);
               }

               var15 = 0;

               while(var15 < var11.pointCount()) {
                  var17 = var11.getPoint(var15);
                  var13.setPoint(var15, var17.a(), var17.b());
                  ++var15;
                  if(var8) {
                     continue label75;
                  }

                  if(var8) {
                     break;
                  }
               }
            }
         }

         label53: {
            C[] var14 = this.h(var10);
            if(var14 != null) {
               C[] var16 = this.s.d(var3);
               var7 = 0;

               while(var7 < var16.length) {
                  var16[var7].setModelParameter(var14[var7].getModelParameter());
                  ++var7;
                  if(var8) {
                     break label53;
                  }

                  if(var8) {
                     break;
                  }
               }
            }

            var9.g();
         }

         if(var8) {
            break;
         }
      }

   }

   public Object i(y.c.d var1) {
      return this.o.b(var1);
   }

   static y.c.A a(l var0) {
      return var0.m;
   }

   static y.c.h b(l var0) {
      return var0.o;
   }

   static Map c(l var0) {
      return var0.n;
   }

   static Map d(l var0) {
      return var0.p;
   }

   static Map e(l var0) {
      return var0.q;
   }

   static {
      y.c.i var0 = new y.c.i();
      y.c.A var1 = var0.t();
      t = var1.getClass();
      var0.a(var1);
      y.c.h var2 = var0.u();
      u = var2.getClass();
      var0.a(var2);
   }
}
