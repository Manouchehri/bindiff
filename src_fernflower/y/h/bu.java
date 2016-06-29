package y.h;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import y.h.aA;
import y.h.aB;
import y.h.bE;
import y.h.bH;
import y.h.bU;
import y.h.bv;
import y.h.cW;
import y.h.ce;
import y.h.cf;
import y.h.ch;
import y.h.eR;
import y.h.eU;
import y.h.fJ;
import y.h.fj;
import y.h.gI;
import y.h.gZ;
import y.h.gn;
import y.h.hH;
import y.h.ie;
import y.h.ii;
import y.h.x;
import y.h.y;
import y.h.z;

public class bu extends y.f.X {
   private fj a;
   private aB b;
   private y.c.D h;
   private y.c.D i;
   private gI k;
   private y.h.a.v l;
   private bv m;
   private ArrayList n;
   private ArrayList o;

   protected y.g.C b() {
      return new bE();
   }

   public bu() {
      this.a((fj)(new gn()), (aB)(new fJ()));
   }

   public bu(bu var1) {
      this(var1, var1.o());
   }

   public bu(bu var1, y.c.C var2) {
      super(var1, var2);
      this.a(var1.a.createCopy(), var1.b.createCopy());
   }

   private void a(fj var1, aB var2) {
      this.a = var1;
      this.b = var2;
      this.h = new y.c.D();
      this.i = new y.c.D();
      this.n = new ArrayList();
      this.o = new ArrayList();
   }

   public void a(y.c.d var1, y.c.q var2, y.c.d var3, int var4, y.c.q var5, y.c.d var6, int var7) {
      super.a(var1, var2, var3, var4, var5, var6, var7);
      aB var8 = this.i(var1);
      if(var8 != null) {
         var8.setDirty();
      }

   }

   public void a(y.c.d var1, y.c.q var2, y.c.q var3) {
      super.a(var1, var2, var3);
      aB var4 = this.i(var1);
      if(var4 != null) {
         var4.setDirty();
      }

   }

   public void a(y.h.a.v var1) {
      this.l = var1;
   }

   public y.h.a.v C() {
      return this.l;
   }

   public y.c.d a(y.c.q var1, y.c.q var2) {
      return this.a(var1, var2, this.b.createCopy());
   }

   public y.c.d a(y.c.q var1, y.c.q var2, aB var3) {
      return this.a(var1, (y.c.d)null, var2, (y.c.d)null, 0, 0, var3);
   }

   public y.c.d a(y.c.q var1, y.c.d var2, y.c.q var3, y.c.d var4, int var5, int var6) {
      return this.a(var1, var2, var3, var4, var5, var6, this.b.createCopy());
   }

   public y.c.d a(y.c.q var1, y.c.d var2, y.c.q var3, y.c.d var4, int var5, int var6, aB var7) {
      hH var8 = new hH(this, var1, var2, var3, var4, var5, var6, var7);
      if(this.c()) {
         this.a((y.c.l)(new y.c.l(this, (byte)1, var8)));
      }

      return var8;
   }

   public y.c.q d() {
      return this.a(this.a.createCopy());
   }

   public y.c.q a(double var1, double var3) {
      fj var5 = this.a.createCopy();
      var5.setCenter(var1, var3);
      return this.a(var5);
   }

   public y.c.q a(fj var1) {
      ii var2 = new ii(this, var1);
      if(this.c()) {
         this.a((y.c.l)(new y.c.l(this, (byte)0, var2)));
      }

      return var2;
   }

   public Rectangle a() {
      boolean var3 = fj.z;
      Rectangle var1 = new Rectangle(0, 0, -1, -1);
      y.c.x var2 = this.o();

      bu var10000;
      while(true) {
         if(var2.f()) {
            var10000 = this;
            if(var3) {
               break;
            }

            this.t(var2.e()).calcUnionRect(var1);
            var2.g();
            if(!var3) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      y.c.e var4 = var10000.p();

      while(var4.f()) {
         this.i(var4.a()).calcUnionRect(var1);
         var4.g();
         if(var3) {
            break;
         }
      }

      return var1;
   }

   public Rectangle a(byte var1) {
      boolean var5 = fj.z;
      Rectangle var2 = new Rectangle(0, 0, -1, -1);
      y.c.x var3 = this.o();

      bu var10000;
      while(true) {
         if(var3.f()) {
            var10000 = this;
            if(var5) {
               break;
            }

            this.t(var3.e()).calcUnionRect(var2, var1);
            var3.g();
            if(!var5) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      y.c.e var6 = var10000.p();

      while(var6.f()) {
         aB var4 = this.i(var6.a());
         if(var4.getLayer() == var1) {
            var4.calcUnionRect(var2);
         }

         var6.g();
         if(var5) {
            break;
         }
      }

      return var2;
   }

   public void b(byte var1) {
      boolean var3 = fj.z;
      y.c.x var2 = this.o();

      bu var10000;
      while(true) {
         if(var2.f()) {
            var10000 = this;
            if(var3) {
               break;
            }

            this.t(var2.e()).setLayer(var1);
            var2.g();
            if(!var3) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      y.c.e var4 = var10000.p();

      while(var4.f()) {
         this.i(var4.a()).setLayer(var1);
         var4.g();
         if(var3) {
            break;
         }
      }

   }

   public y D() {
      return new ie(this);
   }

   public void b(fj var1) {
      this.a = var1;
   }

   public void a(aB var1) {
      this.b = var1;
   }

   public fj F() {
      return this.a;
   }

   public aB G() {
      return this.b;
   }

   public fj t(y.c.q var1) {
      return ((ii)var1).l;
   }

   public aB i(y.c.d var1) {
      return ((hH)var1).l;
   }

   public void a(y.c.q var1, fj var2) {
      fj var3 = ((ii)var1).l;
      var2.b(var1);
      ((ii)var1).l = var2;
      this.a(var1, "realizer", var3, var2);
   }

   public void a(y.c.d var1, aB var2) {
      aB var3 = ((hH)var1).l;
      var2.bindEdge(var1);
      ((hH)var1).l = var2;
      this.a(var1, "realizer", var3, var2);
   }

   public y.f.am h(y.c.q var1) {
      return this.t(var1);
   }

   public y.f.I g(y.c.d var1) {
      return this.i(var1);
   }

   public y.f.aj[] i(y.c.q var1) {
      boolean var5 = fj.z;
      fj var2 = this.t(var1);
      y.f.aj[] var3 = new y.f.aj[var2.labelCount()];
      int var4 = 0;

      y.f.aj[] var10000;
      while(true) {
         if(var4 < var3.length) {
            var10000 = var3;
            if(var5) {
               break;
            }

            var3[var4] = var2.getLabel(var4);
            ++var4;
            if(!var5) {
               continue;
            }
         }

         var10000 = var3;
         break;
      }

      return var10000;
   }

   public y.f.C[] h(y.c.d var1) {
      boolean var5 = fj.z;
      aB var2 = this.i(var1);
      y.f.C[] var3 = new y.f.C[var2.labelCount()];
      int var4 = 0;

      y.f.C[] var10000;
      while(true) {
         if(var4 < var3.length) {
            var10000 = var3;
            if(var5) {
               break;
            }

            var3[var4] = var2.getLabel(var4);
            ++var4;
            if(!var5) {
               continue;
            }
         }

         var10000 = var3;
         break;
      }

      return var10000;
   }

   public y.c.q a(y.f.aj var1) {
      eR var2 = (eR)var1;
      return var2.f();
   }

   public y.c.d a(y.f.C var1) {
      aA var2 = (aA)var1;
      return var2.getEdge();
   }

   public boolean H() {
      boolean var6 = fj.z;
      y.c.x var1 = this.o();

      int var4;
      bu var13;
      int var14;
      boolean var10000;
      label126:
      while(true) {
         var10000 = var1.f();

         label123:
         while(var10000) {
            y.c.q var2 = var1.e();
            var13 = this;
            if(var6) {
               break label126;
            }

            if(this.v(var2)) {
               return false;
            }

            fj var3;
            label120: {
               var3 = this.t(var2);
               if(var3.labelCount() > 0) {
                  var4 = 0;

                  while(var4 < var3.labelCount()) {
                     eR var5 = var3.getLabel(var4);
                     var14 = this.a((gZ)var5);
                     if(var6) {
                        break label120;
                     }

                     if(var14 != 0) {
                        return false;
                     }

                     ++var4;
                     if(var6) {
                        break;
                     }
                  }
               }

               var14 = var3.portCount();
            }

            if(var14 > 0) {
               Iterator var10 = var3.ports();

               while(var10.hasNext()) {
                  if(this.a((eU)var10.next())) {
                     var10000 = false;
                     if(!var6) {
                        return false;
                     }
                     continue label123;
                  }
               }
            }

            var1.g();
            if(!var6) {
               continue label126;
            }
            break;
         }

         var13 = this;
         break;
      }

      y.c.e var7 = var13.p();

      label91:
      while(true) {
         var10000 = var7.f();

         label88:
         while(var10000) {
            y.c.d var8 = var7.a();
            var10000 = this.r(var8);
            if(var6) {
               return var10000;
            }

            if(var10000) {
               return false;
            }

            aB var9;
            label85: {
               var9 = this.i(var8);
               if(var9.bendCount() > 0) {
                  y var11 = var9.bends();

                  while(var11.f()) {
                     var14 = this.a(var11.a());
                     if(var6) {
                        break label85;
                     }

                     if(var14 != 0) {
                        return false;
                     }

                     var11.g();
                     if(var6) {
                        break;
                     }
                  }
               }

               var14 = var9.labelCount();
            }

            if(var14 > 0) {
               var4 = 0;

               while(var4 < var9.labelCount()) {
                  aA var12 = var9.getLabel(var4);
                  var10000 = this.a((gZ)var12);
                  if(var6) {
                     continue label88;
                  }

                  if(var10000) {
                     return false;
                  }

                  ++var4;
                  if(var6) {
                     break;
                  }
               }
            }

            var7.g();
            if(!var6) {
               continue label91;
            }
            break;
         }

         var10000 = true;
         return var10000;
      }
   }

   public boolean I() {
      return this.J().k() + this.M().k() == 1;
   }

   public y.c.x J() {
      boolean var4 = fj.z;
      y.c.y var1 = new y.c.y();
      y.c.x var2 = this.o();

      y.c.x var10000;
      while(true) {
         if(var2.f()) {
            var10000 = var2;
            if(var4) {
               break;
            }

            y.c.q var3 = var2.e();
            if(this.v(var3)) {
               var1.b(var3);
            }

            var2.g();
            if(!var4) {
               continue;
            }
         }

         var10000 = var1.a();
         break;
      }

      return var10000;
   }

   public y.c.e K() {
      boolean var4 = fj.z;
      y.c.f var1 = new y.c.f();
      y.c.e var2 = this.p();

      y.c.e var10000;
      while(true) {
         if(var2.f()) {
            var10000 = var2;
            if(var4) {
               break;
            }

            y.c.d var3 = var2.a();
            if(this.r(var3)) {
               var1.b(var3);
            }

            var2.g();
            if(!var4) {
               continue;
            }
         }

         var10000 = var1.a();
         break;
      }

      return var10000;
   }

   public y.c.C L() {
      boolean var6 = fj.z;
      y.c.D var1 = new y.c.D();
      y.c.e var2 = this.p();

      boolean var10000;
      int var4;
      bu var10;
      label73:
      while(true) {
         var10000 = var2.f();

         label70:
         while(var10000) {
            var10 = this;
            if(var6) {
               break label73;
            }

            aB var3 = this.i(var2.a());
            if(var3.labelCount() > 0) {
               var4 = 0;

               while(var4 < var3.labelCount()) {
                  aA var5 = var3.getLabel(var4);
                  var10000 = this.a((gZ)var5);
                  if(var6) {
                     continue label70;
                  }

                  if(var10000) {
                     var1.add(var5);
                  }

                  ++var4;
                  if(var6) {
                     break;
                  }
               }
            }

            var2.g();
            if(!var6) {
               continue label73;
            }
            break;
         }

         var10 = this;
         break;
      }

      y.c.x var7 = var10.o();

      do {
         var10000 = var7.f();

         label46:
         while(true) {
            if(!var10000) {
               return var1.m();
            }

            fj var8 = this.t(var7.e());
            if(var8.labelCount() <= 0) {
               break;
            }

            var4 = 0;

            while(true) {
               if(var4 >= var8.labelCount()) {
                  break label46;
               }

               eR var9 = var8.getLabel(var4);
               var10000 = this.a((gZ)var9);
               if(var6) {
                  break;
               }

               if(var10000) {
                  var1.add(var9);
               }

               ++var4;
               if(var6) {
                  break label46;
               }
            }
         }

         var7.g();
      } while(!var6);

      return var1.m();
   }

   public y M() {
      boolean var4 = fj.z;
      z var1 = new z();
      y var2 = this.D();

      y var10000;
      while(true) {
         if(var2.f()) {
            var10000 = var2;
            if(var4) {
               break;
            }

            x var3 = var2.a();
            if(this.a(var3)) {
               var1.b(var3);
            }

            var2.g();
            if(!var4) {
               continue;
            }
         }

         var10000 = var1.b();
         break;
      }

      return var10000;
   }

   public void N() {
      boolean var5 = fj.z;
      this.r();
      y.c.x var1 = this.o();

      bu var10000;
      int var4;
      while(true) {
         if(var1.f()) {
            y.c.q var2 = var1.e();
            this.a(var2, false);
            var10000 = this;
            if(var5) {
               break;
            }

            label100: {
               fj var3 = this.t(var2);
               if(var3.labelCount() > 0) {
                  var4 = 0;

                  while(var4 < var3.labelCount()) {
                     this.a((gZ)var3.getLabel(var4), false);
                     ++var4;
                     if(var5) {
                        break label100;
                     }

                     if(var5) {
                        break;
                     }
                  }
               }

               if(var3.portCount() > 0) {
                  Iterator var9 = var3.ports();

                  while(var9.hasNext()) {
                     this.a((eU)var9.next(), false);
                     if(var5) {
                        break label100;
                     }

                     if(var5) {
                        break;
                     }
                  }
               }

               var1.g();
            }

            if(!var5) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      y.c.e var6 = var10000.p();

      label64:
      while(true) {
         if(var6.f()) {
            y.c.d var7 = var6.a();
            this.a(var7, false);
            aB var8 = this.i(var7);
            if(var5) {
               break;
            }

            if(var8.labelCount() > 0) {
               var4 = 0;

               while(var4 < var8.labelCount()) {
                  this.a((gZ)var8.getLabel(var4), false);
                  ++var4;
                  if(var5) {
                     continue label64;
                  }

                  if(var5) {
                     break;
                  }
               }
            }

            y var10 = var8.bends();

            label48: {
               while(var10.f()) {
                  this.a(var10.a(), false);
                  var10.g();
                  if(var5) {
                     break label48;
                  }

                  if(var5) {
                     break;
                  }
               }

               var6.g();
            }

            if(!var5) {
               continue;
            }
         }

         this.s();
         break;
      }

   }

   public void O() {
      boolean var2 = fj.z;
      this.r();
      y.c.x var1 = this.o();

      while(true) {
         if(var1.f()) {
            this.a(var1.e(), false);
            var1.g();
            if(var2) {
               break;
            }

            if(!var2) {
               continue;
            }
         }

         this.s();
         break;
      }

   }

   public void P() {
      boolean var2 = fj.z;
      this.r();
      y.c.e var1 = this.p();

      while(true) {
         if(var1.f()) {
            this.a(var1.a(), false);
            var1.g();
            if(var2) {
               break;
            }

            if(!var2) {
               continue;
            }
         }

         this.s();
         break;
      }

   }

   public void Q() {
      boolean var2 = fj.z;
      this.r();
      y var1 = this.D();

      while(true) {
         if(var1.f()) {
            this.a(var1.a(), false);
            var1.g();
            if(var2) {
               break;
            }

            if(!var2) {
               continue;
            }
         }

         this.s();
         break;
      }

   }

   public cW a(double var1, double var3, boolean var5) {
      return new cW(this, var1, var3, var5, 0, 1, 2, 3, 4, 6, 5);
   }

   public cW b(double var1, double var3) {
      return this.a(var1, var3, true);
   }

   public void a(y.c.q var1, String var2) {
      this.t(var1).setLabelText(var2);
   }

   public String u(y.c.q var1) {
      return this.t(var1).getLabelText();
   }

   public void a(y.c.d var1, boolean var2) {
      this.i(var1).setSelected(var2);
   }

   public void a(gZ var1, boolean var2) {
      var1.setSelected(var2);
   }

   public void a(x var1, boolean var2) {
      var1.a(var2);
   }

   public void a(eU var1, boolean var2) {
      var1.a(var2);
   }

   public void a(y.c.e var1, boolean var2) {
      boolean var3 = fj.z;
      if(var1.f()) {
         this.r();

         while(true) {
            if(var1.f()) {
               this.a(var1.a(), var2);
               var1.g();
               if(var3) {
                  break;
               }

               if(!var3) {
                  continue;
               }
            }

            this.s();
            break;
         }

      }
   }

   public void a(y.c.q var1, boolean var2) {
      this.t(var1).setSelected(var2);
   }

   public void a(y.c.x var1, boolean var2) {
      boolean var3 = fj.z;
      if(var1.f()) {
         this.r();

         while(true) {
            if(var1.f()) {
               this.a(var1.e(), var2);
               var1.g();
               if(var3) {
                  break;
               }

               if(!var3) {
                  continue;
               }
            }

            this.s();
            break;
         }

      }
   }

   public boolean r(y.c.d var1) {
      return this.i(var1).isSelected();
   }

   public boolean a(gZ var1) {
      return var1.isSelected();
   }

   public boolean a(x var1) {
      return var1.d();
   }

   public boolean a(eU var1) {
      return var1.f();
   }

   public boolean v(y.c.q var1) {
      return this.t(var1).isSelected();
   }

   public double j(y.c.q var1) {
      return this.t(var1).getCenterX();
   }

   public double k(y.c.q var1) {
      return this.t(var1).getCenterY();
   }

   public double m(y.c.q var1) {
      return this.t(var1).getX();
   }

   public double n(y.c.q var1) {
      return this.t(var1).getY();
   }

   public double p(y.c.q var1) {
      return this.t(var1).getWidth();
   }

   public double q(y.c.q var1) {
      return this.t(var1).getHeight();
   }

   public void a(y.c.q var1, double var2, double var4) {
      this.t(var1).setCenter(var2, var4);
   }

   public void b(y.c.q var1, double var2, double var4) {
      this.t(var1).setSize(var2, var4);
   }

   public void c(y.c.q var1, double var2, double var4) {
      this.t(var1).setLocation(var2, var4);
   }

   public y.c.C R() {
      return this.i.m();
   }

   public gI S() {
      return this.k != null?this.k:(this.h.size() > 0?(gI)this.h.f():null);
   }

   public void a(gI var1) {
      this.k = var1;
   }

   public void b(gI var1) {
      this.h.b((Object)var1);
   }

   public void c(gI var1) {
      if(this.S() == var1) {
         this.a((gI)null);
      }

      this.h.remove(var1);
   }

   public void T() {
      boolean var2 = fj.z;
      y.c.C var1 = this.h.m();

      while(var1.f()) {
         ((gI)var1.d()).updateView();
         var1.g();
         if(var2) {
            break;
         }
      }

   }

   public void a(double var1, double var3, double var5, double var7) {
      boolean var10 = fj.z;
      y.c.C var9 = this.h.m();

      while(var9.f()) {
         ((gI)var9.d()).updateView(var1, var3, var5, var7);
         var9.g();
         if(var10) {
            break;
         }
      }

   }

   public void U() {
      if(this.S() instanceof ch) {
         ((ch)this.S()).fitContent();
      }
   }

   public void V() {
      this.r();
      this.a(this.o());
      this.a(this.p());
      this.s();
   }

   public void a(y.c.e var1) {
      if(this.m != null) {
         this.m.a(this, var1);
      }

   }

   public void a(y.c.x var1) {
      if(this.m != null) {
         this.m.a(this, var1);
      }

   }

   public void a(cf var1) {
      this.n.add(var1);
   }

   public Iterator W() {
      return this.n.iterator();
   }

   public void e(Object var1) {
      boolean var5 = fj.z;
      if(!this.n.isEmpty()) {
         ce var2 = new ce(this, var1);
         cf[] var3 = new cf[this.n.size()];
         this.n.toArray(var3);
         int var4 = 0;

         while(var4 < var3.length) {
            var3[var4].onGraph2DSelectionEvent(var2);
            ++var4;
            if(var5) {
               break;
            }
         }
      }

   }

   public void a(bU var1) {
      this.o.add(var1);
   }

   public Iterator X() {
      return this.o.iterator();
   }

   public void a(Object var1, String var2, Object var3, Object var4) {
      if(!this.o.isEmpty()) {
         bH var5 = new bH(this, var1, var2, var3, var4);
         bU[] var6 = new bU[this.o.size()];
         this.o.toArray(var6);

         for(int var7 = 0; var7 < var6.length; ++var7) {
            var6[var7].a(var5);
         }
      }

   }
}
