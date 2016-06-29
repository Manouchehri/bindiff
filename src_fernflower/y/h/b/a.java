package y.h.b;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import y.f.al;
import y.h.aZ;
import y.h.be;
import y.h.bu;
import y.h.dr;
import y.h.eD;
import y.h.eF;
import y.h.eR;
import y.h.fj;
import y.h.b.J;
import y.h.b.S;
import y.h.b.T;
import y.h.b.X;
import y.h.b.Z;
import y.h.b.b;
import y.h.b.c;
import y.h.b.d;
import y.h.b.e;
import y.h.b.f;
import y.h.b.g;
import y.h.b.h;
import y.h.b.i;
import y.h.b.j;
import y.h.b.k;
import y.h.b.l;
import y.h.b.m;
import y.h.b.n;
import y.h.b.o;
import y.h.b.p;
import y.h.b.q;
import y.h.b.r;
import y.h.b.s;
import y.h.b.t;
import y.h.b.u;

public class a extends y.h.a.e {
   private static final y.d.r I = new y.d.r(0.0D, 0.0D, 0.0D, 0.0D);
   private j J;
   private double K;
   private double L;
   private double M;
   private double N;
   private y.d.r O;
   private y.d.r P;
   private boolean Q;
   static Class w;
   static Class A;
   static Class B;
   static Class C;
   static Class D;
   static Class E;
   static Class F;
   static Class G;
   public static int H;

   public a() {
      this.A();
   }

   public a(fj var1) {
      int var9 = H;
      super(var1);
      if(var1 instanceof a) {
         a var2 = (a)var1;
         int var3 = 0;
         int var4 = this.labelCount();

         do {
            if(var3 >= var4) {
               return;
            }

            eR var5 = var2.getLabel(var3);
            eR var6 = this.getLabel(var3);
            al var7 = var6.a();
            if(var7 instanceof e || var7 instanceof h) {
               Object var8 = var5.getModelParameter();
               if(var8 instanceof n) {
                  var6.setModelParameter(var8);
               }
            }

            ++var3;
         } while(var9 == 0);
      }

      this.A();
   }

   public boolean k() {
      return this.Q;
   }

   public void c(boolean var1) {
      this.Q = var1;
   }

   private double b(c var1) {
      int var7 = H;
      List var2 = var1.l();
      if(var2.isEmpty()) {
         return var1.g();
      } else {
         y.d.r var3 = var1.i();
         double var4 = var3.b + var3.d;
         Iterator var6 = var2.iterator();

         double var10000;
         while(true) {
            if(var6.hasNext()) {
               var10000 = var4 + this.b((c)var6.next());
               if(var7 != 0) {
                  break;
               }

               var4 = var10000;
               if(var7 == 0) {
                  continue;
               }
            }

            var10000 = Math.max(var4, var1.g());
            break;
         }

         return var10000;
      }
   }

   private double y() {
      int var6 = H;
      i var1 = this.l();
      s var2 = new s();
      this.b(var2);
      double var3 = var2.b + var2.d;
      Iterator var5 = var1.l().iterator();

      double var10000;
      while(true) {
         if(var5.hasNext()) {
            var10000 = var3 + this.b((c)var5.next());
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

   private double b(f var1) {
      int var7 = H;
      List var2 = var1.o();
      if(var2.isEmpty()) {
         return var1.g();
      } else {
         y.d.r var3 = var1.i();
         double var4 = var3.a + var3.c;
         Iterator var6 = var2.iterator();

         double var10000;
         while(true) {
            if(var6.hasNext()) {
               var10000 = var4 + this.b((f)var6.next());
               if(var7 != 0) {
                  break;
               }

               var4 = var10000;
               if(var7 == 0) {
                  continue;
               }
            }

            var10000 = Math.max(var4, var1.g());
            break;
         }

         return var10000;
      }
   }

   private double z() {
      int var6 = H;
      i var1 = this.l();
      s var2 = new s();
      this.a(var2);
      double var3 = var2.a + var2.c;
      Iterator var5 = var1.o().iterator();

      double var10000;
      while(true) {
         if(var5.hasNext()) {
            var10000 = var3 + this.b((f)var5.next());
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

   protected void a(aZ var1) {
      super.a(var1);
      if(var1 instanceof a) {
         a var2;
         label13: {
            var2 = (a)var1;
            if(var2.J == null) {
               this.J = null;
               if(H == 0) {
                  break label13;
               }
            }

            this.J = new j(this, var2.J);
         }

         this.K = var2.K;
         this.L = var2.L;
         this.M = var2.M;
         this.N = var2.N;
         this.O = var2.O;
         this.P = var2.P;
         this.Q = var2.Q;
      }

   }

   public fj createCopy(fj var1) {
      return new a(var1);
   }

   public i l() {
      if(this.J == null) {
         this.J = new j(this, this.K, this.L, this.M, this.N, this.O, this.P);
      }

      return this.J;
   }

   public double m() {
      return this.K;
   }

   public void c(double var1) {
      this.K = var1;
   }

   public double n() {
      return this.M;
   }

   public void d(double var1) {
      this.M = var1;
   }

   public y.d.r o() {
      return this.O;
   }

   public void c(y.d.r var1) {
      this.O = var1;
   }

   public double p() {
      return this.L;
   }

   public void e(double var1) {
      this.L = var1;
   }

   public double q() {
      return this.N;
   }

   public void f(double var1) {
      this.N = var1;
   }

   public y.d.r r() {
      return this.P;
   }

   public void d(y.d.r var1) {
      this.P = var1;
   }

   public static Map s() {
      int var3 = H;
      Map var0 = a().a();
      var0.put(w == null?(w = f("y.h.bo")):w, J.a());
      var0.put(A == null?(A = f("y.h.bd")):A, (Object)null);
      var0.put(B == null?(B = f("y.h.bj")):B, (Object)null);
      eD var1 = new eD();
      var1.a((eF)(new u()));
      var1.a((eF)(new T()));
      var1.a((eF)(new X()));
      var1.a((eF)(new S()));
      var0.put(C == null?(C = f("y.h.bf")):C, var1);
      o var2 = new o((b)null);
      var0.put(D == null?(D = f("y.h.a.f")):D, var2);
      var0.put(E == null?(E = f("y.h.bl")):E, var2);
      var0.put(F == null?(F = f("y.h.bg")):F, new k((b)null));
      var0.put(G == null?(G = f("y.h.br")):G, new b());
      if(var3 != 0) {
         y.c.i.g = !y.c.i.g;
      }

      return var0;
   }

   private void A() {
      this.setFillColor(new Color(248, 236, 201));
      this.setFillColor2(new Color(0, 66, 244, 64));
      this.a(false);
      this.a((y.d.r)o.b());
      this.K = 30.0D;
      this.L = 30.0D;
      this.M = 30.0D;
      this.N = 30.0D;
      this.O = I;
      this.P = I;
      this.J = null;
      this.Q = true;
      this.B();
      be var1 = a();
      if(!var1.c().contains("y.view.TableGroupNodeRealizer.DEFAULT_CONFIGURATION")) {
         var1.a("y.view.TableGroupNodeRealizer.DEFAULT_CONFIGURATION", s());
      }

      this.d((String)"y.view.TableGroupNodeRealizer.DEFAULT_CONFIGURATION");
   }

   private void B() {
      dr var1 = dr.a(1, (byte)0);
      dr var2 = dr.a(3, (byte)0);
      Z var3 = new Z(var1, Color.BLACK, new Color(71, 74, 67, 64));
      Z var4 = new Z(var2, Color.BLACK, new Color(71, 74, 67, 128));
      this.a((String)"y.view.tabular.TableNodePainter.ALTERNATE_COLUMN_STYLE", (Object)var3);
      this.a((String)"y.view.tabular.TableNodePainter.ALTERNATE_ROW_STYLE", (Object)var3);
      this.a((String)"y.view.tabular.TableNodePainter.ALTERNATE_COLUMN_SELECTION_STYLE", (Object)var4);
      this.a((String)"y.view.tabular.TableNodePainter.ALTERNATE_ROW_SELECTION_STYLE", (Object)var4);
   }

   private void a(y.c.q var1) {
      if(this.getNode() != var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("null");
         }

         if(this.getNode() == null) {
            throw new IllegalStateException("realizer not bound to node");
         }

         if(var1.e() != this.getNode().e()) {
            throw new IllegalArgumentException("node does not belong to graph");
         }
      }

   }

   private fj c(y.c.q var1) {
      this.a(var1);
      return ((bu)var1.e()).t(var1);
   }

   private y.h.a.v C() {
      y.c.q var1 = this.getNode();
      if(var1 != null) {
         y.c.i var2 = var1.e();
         if(var2 != null) {
            return y.h.a.v.a(var2);
         }
      }

      return null;
   }

   private void D() {
      int var3 = H;
      int var1 = this.labelCount();
      if(var1 > 0) {
         int var2 = 0;

         while(var2 < var1) {
            this.getLabel(var2).setOffsetDirty();
            ++var2;
            if(var3 != 0) {
               break;
            }
         }
      }

   }

   private boolean E() {
      y.h.a.a var1 = this.getAutoBoundsFeature();
      return var1 != null && this.g() && !this.isGroupClosed();
   }

   private void d(boolean var1) {
      y.h.a.a var2 = this.getAutoBoundsFeature();
      if(var2 != null) {
         var2.setAutoBoundsEnabled(var1);
      }

   }

   private Rectangle2D c(c var1) {
      int var12 = H;
      double var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      c var8 = var1;

      while(var8 != null) {
         d var9 = var8.a();
         Iterator var10 = var9.l().iterator();

         Object var10000;
         label38: {
            while(var10.hasNext()) {
               c var11 = (c)var10.next();
               var10000 = var11;
               if(var12 != 0) {
                  break label38;
               }

               if(var11 == var8) {
                  break;
               }

               var2 += var11.g();
               if(var12 != 0) {
                  break;
               }
            }

            var10000 = var9;
         }

         if(var10000 instanceof c) {
            c var13 = (c)var9;
            y.d.r var15 = var13.i();
            if(var15 != null) {
               var2 += var15.b;
               var4 += var15.a;
               var6 += var15.c;
            }

            var8 = var13;
         } else {
            if(var9 != this.l()) {
               throw new IllegalStateException("Invalid or no parent.");
            }

            var2 += this.v();
            y.d.r var14 = this.l().d();
            var4 += var14.a;
            var6 += var14.c;
            var8 = null;
         }
      }

      return new Double(this.getX() + var2, this.getY() + var4, var1.g(), this.getHeight() - var4 - var6);
   }

   private Rectangle2D c(f var1) {
      int var12 = H;
      double var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      f var8 = var1;

      while(var8 != null) {
         g var9 = var8.a();
         Iterator var10 = var9.o().iterator();

         Object var10000;
         label38: {
            while(var10.hasNext()) {
               f var11 = (f)var10.next();
               var10000 = var11;
               if(var12 != 0) {
                  break label38;
               }

               if(var11 == var8) {
                  break;
               }

               var6 += var11.g();
               if(var12 != 0) {
                  break;
               }
            }

            var10000 = var9;
         }

         if(var10000 instanceof f) {
            f var13 = (f)var9;
            y.d.r var15 = var13.i();
            if(var15 != null) {
               var2 += var15.b;
               var4 += var15.d;
               var6 += var15.a;
            }

            var8 = var13;
         } else {
            if(var9 != this.l()) {
               throw new IllegalStateException("Invalid or no parent.");
            }

            var6 += this.t();
            y.d.r var14 = this.l().d();
            var2 += var14.b;
            var4 += var14.d;
            var8 = null;
         }
      }

      return new Double(this.getX() + var2, this.getY() + var6, this.getWidth() - var2 - var4, var1.g());
   }

   double t() {
      s var1 = new s();
      this.a(var1);
      return var1.a;
   }

   double u() {
      s var1 = new s();
      this.a(var1);
      return var1.c;
   }

   private void a(s var1) {
      c(this.l(), var1);
   }

   private static void c(i var0, s var1) {
      int var8 = H;
      double var2 = 0.0D;
      double var4 = 0.0D;
      Iterator var6 = var0.l().iterator();

      while(true) {
         if(var6.hasNext()) {
            c var7 = (c)var6.next();
            a(var7, var1);
            if(var2 < var1.a) {
               var2 = var1.a;
            }

            if(var4 >= var1.c) {
               continue;
            }

            var4 = var1.c;
            if(var8 != 0) {
               break;
            }

            if(var8 == 0) {
               continue;
            }
         }

         var1.a = var2;
         var1.c = var4;
         break;
      }

      y.d.r var9 = var0.d();
      var1.a += var9.a;
      var1.c += var9.c;
   }

   private static void a(c var0, s var1) {
      int var14 = H;
      y.d.r var2 = var0.i();
      double var3 = var2 != null?var2.a:0.0D;
      double var5 = var2 != null?var2.c:0.0D;
      List var7 = var0.l();
      if(var7.isEmpty()) {
         var1.a = var3;
         var1.c = var5;
         if(var14 == 0) {
            return;
         }
      }

      double var8 = 0.0D;
      double var10 = 0.0D;
      Iterator var12 = var7.iterator();

      label37: {
         while(var12.hasNext()) {
            c var13 = (c)var12.next();
            a(var13, var1);
            if(var8 < var1.a) {
               var8 = var1.a;
            }

            if(var10 < var1.c) {
               var10 = var1.c;
               if(var14 != 0) {
                  break label37;
               }

               if(var14 != 0) {
                  break;
               }
            }
         }

         var1.a = var3 + var8;
      }

      var1.c = var5 + var10;
   }

   double v() {
      s var1 = new s();
      this.b(var1);
      return var1.b;
   }

   double w() {
      s var1 = new s();
      this.b(var1);
      return var1.d;
   }

   private void b(s var1) {
      d(this.l(), var1);
   }

   private static void d(i var0, s var1) {
      int var8 = H;
      double var2 = 0.0D;
      double var4 = 0.0D;
      Iterator var6 = var0.o().iterator();

      while(true) {
         if(var6.hasNext()) {
            f var7 = (f)var6.next();
            a(var7, var1);
            if(var2 < var1.b) {
               var2 = var1.b;
            }

            if(var4 >= var1.d) {
               continue;
            }

            var4 = var1.d;
            if(var8 != 0) {
               break;
            }

            if(var8 == 0) {
               continue;
            }
         }

         var1.b = var2;
         var1.d = var4;
         break;
      }

      y.d.r var9 = var0.d();
      var1.b += var9.b;
      var1.d += var9.d;
   }

   private static void a(f var0, s var1) {
      int var14 = H;
      y.d.r var2 = var0.i();
      double var3 = var2 != null?var2.b:0.0D;
      double var5 = var2 != null?var2.d:0.0D;
      List var7 = var0.o();
      if(var7.isEmpty()) {
         var1.b = var3;
         var1.d = var5;
         if(var14 == 0) {
            return;
         }
      }

      double var8 = 0.0D;
      double var10 = 0.0D;
      Iterator var12 = var7.iterator();

      label37: {
         while(var12.hasNext()) {
            f var13 = (f)var12.next();
            a(var13, var1);
            if(var8 < var1.b) {
               var8 = var1.b;
            }

            if(var10 < var1.d) {
               var10 = var1.d;
               if(var14 != 0) {
                  break label37;
               }

               if(var14 != 0) {
                  break;
               }
            }
         }

         var1.b = var3 + var8;
      }

      var1.d = var5 + var10;
   }

   private f a(double var1, double var3) {
      int var15 = H;
      if(this.contains(var1, var3)) {
         y.d.r var5 = this.l().d();
         s var6 = new s();
         this.a(var6);
         double var7 = var1 - this.getX();
         double var9 = var3 - this.getY() - var6.a;
         double var11 = this.getWidth();
         var7 -= var5.b;
         var11 -= var5.b + var5.d;
         if(var7 >= 0.0D && var9 >= 0.0D && var7 <= var11) {
            Iterator var13 = this.l().o().iterator();

            while(var13.hasNext()) {
               f var14 = (f)var13.next();
               if(var9 <= var14.g()) {
                  return this.a(var14, var7, var9, var11);
               }

               var9 -= var14.g();
               if(var15 != 0) {
                  break;
               }
            }
         }
      }

      return null;
   }

   private f a(f var1, double var2, double var4, double var6) {
      int var17 = H;
      f var10000;
      if(!var1.o().isEmpty()) {
         y.d.r var8 = var1.i();
         double var9 = var2;
         double var11 = var4;
         double var13 = var6;
         if(var8 != null) {
            if(var2 < var8.b || var2 > var6 - var8.d || var4 < var8.a || var4 > var1.g() - var8.c) {
               return var1;
            }

            var9 = var2 - var8.b;
            var11 = var4 - var8.a;
            var13 = var6 - (var8.b + var8.d);
         }

         Iterator var15 = var1.o().iterator();

         while(var15.hasNext()) {
            var10000 = (f)var15.next();
            if(var17 != 0) {
               return var10000;
            }

            f var16 = var10000;
            if(var11 <= var16.g()) {
               return this.a(var16, var9, var11, var13);
            }

            var11 -= var16.g();
            if(var17 != 0) {
               break;
            }
         }
      }

      var10000 = var1;
      return var10000;
   }

   private c b(double var1, double var3) {
      int var15 = H;
      if(this.contains(var1, var3)) {
         y.d.r var5 = this.l().d();
         s var6 = new s();
         this.b(var6);
         double var7 = var1 - this.getX() - var6.b;
         double var9 = var3 - this.getY();
         double var11 = this.getHeight();
         var9 -= var5.a;
         var11 -= var5.a + var5.c;
         if(var7 >= 0.0D && var9 >= 0.0D && var9 <= var11) {
            Iterator var13 = this.l().l().iterator();

            while(var13.hasNext()) {
               c var14 = (c)var13.next();
               if(var7 <= var14.g()) {
                  return this.a(var14, var7, var9, var11);
               }

               var7 -= var14.g();
               if(var15 != 0) {
                  break;
               }
            }
         }
      }

      return null;
   }

   private c a(c var1, double var2, double var4, double var6) {
      int var17 = H;
      c var10000;
      if(!var1.l().isEmpty()) {
         y.d.r var8 = var1.i();
         double var9 = var2;
         double var11 = var4;
         double var13 = var6;
         if(var8 != null) {
            if(var2 < var8.b || var2 > var1.g() - var8.d || var4 < var8.a || var4 > var6 - var8.c) {
               return var1;
            }

            var9 = var2 - var8.b;
            var11 = var4 - var8.a;
            var13 = var6 - (var8.a + var8.c);
         }

         Iterator var15 = var1.l().iterator();

         while(var15.hasNext()) {
            var10000 = (c)var15.next();
            if(var17 != 0) {
               return var10000;
            }

            c var16 = var10000;
            if(var9 <= var16.g()) {
               return this.a(var16, var9, var11, var13);
            }

            var9 -= var16.g();
            if(var17 != 0) {
               break;
            }
         }
      }

      var10000 = var1;
      return var10000;
   }

   public void a(eR var1, c var2, boolean var3, double var4) {
      n var6 = new n(((q)var2).a, var3, var4);
      if(!(var1.a() instanceof e)) {
         var1.a(new e(), var6);
         if(H == 0) {
            return;
         }
      }

      var1.setModelParameter(var6);
   }

   public void a(eR var1, f var2, boolean var3, double var4) {
      int var7;
      label19: {
         var7 = H;
         n var6 = new n(((q)var2).a, var3, var4);
         if(!(var1.a() instanceof h)) {
            var1.a(new h(), var6);
            if(var7 == 0) {
               break label19;
            }
         }

         var1.setModelParameter(var6);
      }

      if(var4 < 0.5D) {
         var1.setRotationAngle(270.0D);
         if(var7 == 0) {
            return;
         }
      }

      var1.setRotationAngle(90.0D);
   }

   public void read(ObjectInputStream var1) {
      byte var2 = var1.readByte();
      switch(var2) {
      case 0:
      case 1:
         super.read(var1);
         this.c(var1.readBoolean());
         m var3 = new m();
         this.a(var3, var1, var2);
         this.a(var3, var1);
         if(H == 0) {
            return;
         }
      default:
         throw new y.e.a();
      }
   }

   private void a(m var1, ObjectInputStream var2) {
      int var8 = H;
      int var3 = this.labelCount();
      eR[] var4 = new eR[var3];
      int var5 = 0;

      while(true) {
         if(var5 < var3) {
            var4[var5] = this.getLabel(var5);
            ++var5;
            if(var8 != 0) {
               break;
            }

            if(var8 == 0) {
               continue;
            }
         }

         var5 = 0;
         break;
      }

      int var6 = var2.readInt();

      eR var7;
      while(true) {
         if(var5 < var6) {
            var7 = var4[var2.readInt()];
            var7.a(new e(var2.readDouble()), new n(var1.a(var2.readInt()), var2.readBoolean(), var2.readDouble()));
            ++var5;
            if(var8 != 0) {
               break;
            }

            if(var8 == 0) {
               continue;
            }
         }

         var5 = 0;
         break;
      }

      var6 = var2.readInt();

      while(var5 < var6) {
         var7 = var4[var2.readInt()];
         var7.a(new h(var2.readDouble()), new n(var1.b(var2.readInt()), var2.readBoolean(), var2.readDouble()));
         ++var5;
         if(var8 != 0) {
            break;
         }
      }

   }

   private void a(m var1, ObjectInputStream var2, byte var3) {
      this.M = 0.0D;
      double var4 = var2.readDouble();
      this.K = 0.0D;
      double var6 = var2.readDouble();
      this.O = null;
      y.d.r var8 = a(var2, var3);
      this.N = 0.0D;
      double var9 = var2.readDouble();
      this.L = 0.0D;
      double var11 = var2.readDouble();
      this.P = null;
      y.d.r var13 = a(var2, var3);
      if(var2.readBoolean()) {
         i var14 = this.l();
         var14.a(a(var2, var3));
         this.a((d)var14, var1, var2, var3);
         this.a((g)var14, var1, var2, var3);
      }

      this.d(var4);
      this.c(var6);
      this.c(var8);
      this.f(var9);
      this.e(var11);
      this.d(var13);
   }

   private void a(d var1, m var2, ObjectInputStream var3, byte var4) {
      int var7 = H;
      int var5 = var3.readInt();
      if(var5 > 0) {
         label21: {
            if(var1 == this.l()) {
               this.a(var1.b(0), var2, var3, var4);
               if(var7 == 0) {
                  break label21;
               }
            }

            this.a(var1.j(), var2, var3, var4);
         }

         int var6 = 1;

         while(var6 < var5) {
            this.a(var1.j(), var2, var3, var4);
            ++var6;
            if(var7 != 0) {
               break;
            }
         }
      }

   }

   private void a(c var1, m var2, ObjectInputStream var3, byte var4) {
      var2.a(var3.readInt(), var1);
      var1.a(var3.readDouble());
      var1.b(var3.readDouble());
      var1.a(a(var3, var4));
      this.a((d)var1, (m)null, var3, var4);
   }

   private void a(g var1, m var2, ObjectInputStream var3, byte var4) {
      int var7 = H;
      int var5 = var3.readInt();
      if(var5 > 0) {
         label21: {
            if(var1 == this.l()) {
               this.a(var1.c(0), var2, var3, var4);
               if(var7 == 0) {
                  break label21;
               }
            }

            this.a(var1.m(), var2, var3, var4);
         }

         int var6 = 1;

         while(var6 < var5) {
            this.a(var1.m(), var2, var3, var4);
            ++var6;
            if(var7 != 0) {
               break;
            }
         }
      }

   }

   private void a(f var1, m var2, ObjectInputStream var3, byte var4) {
      var2.a(var3.readInt(), var1);
      var1.a(var3.readDouble());
      var1.b(var3.readDouble());
      var1.a(a(var3, var4));
      this.a((g)var1, var2, var3, var4);
   }

   private static y.d.r a(ObjectInputStream var0, byte var1) {
      switch(var1) {
      case 0:
         return (y.d.r)var0.readObject();
      default:
         if(var0.readBoolean()) {
            double var2 = var0.readDouble();
            double var4 = var0.readDouble();
            double var6 = var0.readDouble();
            double var8 = var0.readDouble();
            return new y.d.r(var2, var4, var6, var8);
         } else {
            return null;
         }
      }
   }

   public void write(ObjectOutputStream var1) {
      var1.writeByte(1);
      super.write(var1);
      var1.writeBoolean(this.k());
      p var2 = new p();
      this.b(var2, var1);
      this.a(var2, var1);
   }

   private void a(p var1, ObjectOutputStream var2) {
      int var10 = H;
      int var3 = this.labelCount();
      HashMap var4 = new HashMap();
      ArrayList var5 = new ArrayList(var3);
      ArrayList var6 = new ArrayList(var3);
      int var7 = 0;

      eR var8;
      boolean var10000;
      while(true) {
         if(var7 < var3) {
            var8 = this.getLabel(var7);
            var4.put(var8, new Integer(var7));
            al var9 = var8.a();
            var10000 = var9 instanceof e;
            if(var10 != 0) {
               break;
            }

            label51: {
               if(var10000) {
                  var5.add(var8);
                  if(var10 == 0) {
                     break label51;
                  }
               }

               if(var9 instanceof h) {
                  var6.add(var8);
               }
            }

            ++var7;
            if(var10 == 0) {
               continue;
            }
         }

         var2.writeInt(var5.size());
         var10000 = var5.isEmpty();
         break;
      }

      Iterator var11;
      n var12;
      label43: {
         if(!var10000) {
            var11 = var5.iterator();

            while(var11.hasNext()) {
               var8 = (eR)var11.next();
               var2.writeInt(((Integer)var4.get(var8)).intValue());
               var2.writeDouble(((l)var8.a()).a());
               var12 = l.a(var8.getModelParameter());
               var2.writeInt(var1.a(var12.a));
               var2.writeBoolean(var12.b);
               var2.writeDouble(var12.c);
               if(var10 != 0) {
                  break label43;
               }

               if(var10 != 0) {
                  break;
               }
            }
         }

         var2.writeInt(var6.size());
      }

      if(!var6.isEmpty()) {
         var11 = var6.iterator();

         while(var11.hasNext()) {
            var8 = (eR)var11.next();
            var2.writeInt(((Integer)var4.get(var8)).intValue());
            var2.writeDouble(((l)var8.a()).a());
            var12 = l.a(var8.getModelParameter());
            var2.writeInt(var1.b(var12.a));
            var2.writeBoolean(var12.b);
            var2.writeDouble(var12.c);
            if(var10 != 0) {
               break;
            }
         }
      }

   }

   private void b(p var1, ObjectOutputStream var2) {
      var2.writeDouble(this.n());
      var2.writeDouble(this.m());
      a(this.o(), var2);
      var2.writeDouble(this.q());
      var2.writeDouble(this.p());
      a(this.r(), var2);
      if(this.J == null) {
         var2.writeBoolean(false);
         if(H == 0) {
            return;
         }
      }

      var2.writeBoolean(true);
      a(this.J.d(), var2);
      this.a(this.J.l(), var1, var2);
      this.b(this.J.o(), var1, var2);
   }

   private void a(List var1, p var2, ObjectOutputStream var3) {
      int var6 = H;
      var3.writeInt(var1.size());
      if(!var1.isEmpty()) {
         Iterator var4 = var1.iterator();

         while(var4.hasNext()) {
            c var5 = (c)var4.next();
            var3.writeInt(var2.a(var5));
            var3.writeDouble(var5.f());
            var3.writeDouble(var5.g());
            a(var5.i(), var3);
            this.a(var5.l(), var2, var3);
            if(var6 != 0) {
               break;
            }
         }
      }

   }

   private void b(List var1, p var2, ObjectOutputStream var3) {
      int var6 = H;
      var3.writeInt(var1.size());
      if(!var1.isEmpty()) {
         Iterator var4 = var1.iterator();

         while(var4.hasNext()) {
            f var5 = (f)var4.next();
            var3.writeInt(var2.a(var5));
            var3.writeDouble(var5.f());
            var3.writeDouble(var5.g());
            a(var5.i(), var3);
            this.b(var5.o(), var2, var3);
            if(var6 != 0) {
               break;
            }
         }
      }

   }

   private static void a(y.d.r var0, ObjectOutputStream var1) {
      if(var0 == null) {
         var1.writeBoolean(false);
         if(H == 0) {
            return;
         }
      }

      var1.writeBoolean(true);
      var1.writeDouble(var0.a);
      var1.writeDouble(var0.b);
      var1.writeDouble(var0.c);
      var1.writeDouble(var0.d);
   }

   static a a(c var0) {
      return ((t)var0).r();
   }

   static a a(f var0) {
      return ((r)var0).r();
   }

   private void c(double var1, double var3) {
      double var5 = this.getWidth();
      double var7 = this.getHeight();
      if(var1 > var5 || var3 > var7) {
         this.a(this.getX(), this.getY(), Math.max(var1, var5), Math.max(var3, var7));
         if(H == 0) {
            return;
         }
      }

      this.D();
   }

   private void a(j var1, List var2, c var3) {
      boolean var4 = this.E();
      if(var4) {
         this.d(false);
      }

      try {
         this.b(var1, var2, var3);
      } finally {
         if(var4) {
            this.d(var4);
         }

      }

   }

   private void b(j var1, List var2, c var3) {
      int var16 = H;
      List var4 = var3.l();
      d var5 = var3.a();
      s var6 = new s();
      this.a(var6);
      int var7 = var2.indexOf(var3);
      int var8 = 0;

      while(true) {
         if(var8 < var4.size()) {
            t var9 = (t)var4.get(var8);
            t.a(var9, var5);
            ++var8;
            if(var16 != 0) {
               break;
            }

            if(var16 == 0) {
               continue;
            }
         }

         var2.remove(var7);
         var2.addAll(var7, var4);
         break;
      }

      s var17 = new s();
      this.a(var17);
      double var18 = var6.a - var17.a;
      if(var18 > 0.0D) {
         f var11 = (f)j.a(var1).get(0);

         while(var11 != null) {
            var11.b(var11.g() + var18);
            List var12 = var11.o();
            if(var12.isEmpty()) {
               var11 = null;
            } else {
               var11 = (f)var12.get(0);
               if(var16 != 0) {
                  break;
               }
            }
         }
      }

      boolean var10000;
      label116: {
         double var19 = var6.c - var17.c;
         if(var19 > 0.0D) {
            f var13 = (f)j.a(var1).get(j.a(var1).size() - 1);

            while(var13 != null) {
               var13.b(var13.g() + var19);
               List var14 = var13.o();
               var10000 = var14.isEmpty();
               if(var16 != 0) {
                  break label116;
               }

               if(var10000) {
                  var13 = null;
               } else {
                  var13 = (f)var14.get(var14.size() - 1);
                  if(var16 != 0) {
                     break;
                  }
               }
            }
         }

         var10000 = var4.isEmpty();
      }

      label102: {
         List var15;
         c var22;
         if(var10000) {
            if(var2.size() <= 0) {
               break label102;
            }

            boolean var20 = var7 == var2.size();
            var22 = (c)var2.get(var20?var7 - 1:var7);

            while(true) {
               if(var22 == null) {
                  break label102;
               }

               var22.b(var22.g() + var3.g());
               var15 = var22.l();
               if(var16 != 0) {
                  return;
               }

               if(var15.isEmpty()) {
                  var22 = null;
               } else {
                  var22 = (c)var15.get(var20?var15.size() - 1:0);
                  if(var16 != 0) {
                     break;
                  }
               }
            }
         }

         y.d.r var21 = var3.i();
         if(var21 != null) {
            int var23;
            label86: {
               if(var21.b > 0.0D) {
                  var22 = (c)var4.get(0);

                  while(var22 != null) {
                     var22.b(var22.g() + var21.b);
                     var15 = var22.l();
                     var23 = var15.isEmpty();
                     if(var16 != 0) {
                        break label86;
                     }

                     if(var23 != 0) {
                        var22 = null;
                     } else {
                        var22 = (c)var15.get(0);
                        if(var16 != 0) {
                           break;
                        }
                     }
                  }
               }

               double var24;
               var23 = (var24 = var21.d - 0.0D) == 0.0D?0:(var24 < 0.0D?-1:1);
            }

            if(var23 > 0) {
               var22 = (c)var4.get(var4.size() - 1);

               while(var22 != null) {
                  var22.b(var22.g() + var21.d);
                  var15 = var22.l();
                  if(var16 != 0) {
                     return;
                  }

                  if(var15.isEmpty()) {
                     var22 = null;
                  } else {
                     var22 = (c)var15.get(var15.size() - 1);
                     if(var16 != 0) {
                        break;
                     }
                  }
               }
            }
         }
      }

      this.D();
   }

   private void a(j var1, List var2, f var3) {
      boolean var4 = this.E();
      if(var4) {
         this.d(false);
      }

      try {
         this.b(var1, var2, var3);
      } finally {
         if(var4) {
            this.d(var4);
         }

      }

   }

   private void b(j var1, List var2, f var3) {
      int var16 = H;
      List var4 = var3.o();
      g var5 = var3.a();
      s var6 = new s();
      this.b(var6);
      int var7 = var2.indexOf(var3);
      int var8 = 0;

      while(true) {
         if(var8 < var4.size()) {
            r var9 = (r)var4.get(var8);
            r.a(var9, var5);
            ++var8;
            if(var16 != 0) {
               break;
            }

            if(var16 == 0) {
               continue;
            }
         }

         var2.remove(var7);
         var2.addAll(var7, var4);
         break;
      }

      s var17 = new s();
      this.b(var17);
      double var18 = var6.b - var17.b;
      if(var18 > 0.0D) {
         c var11 = (c)j.b(var1).get(0);

         while(var11 != null) {
            var11.b(var11.g() + var18);
            List var12 = var11.l();
            if(var12.isEmpty()) {
               var11 = null;
            } else {
               var11 = (c)var12.get(0);
               if(var16 != 0) {
                  break;
               }
            }
         }
      }

      boolean var10000;
      label116: {
         double var19 = var6.d - var17.d;
         if(var19 > 0.0D) {
            c var13 = (c)j.b(var1).get(j.b(var1).size() - 1);

            while(var13 != null) {
               var13.b(var13.g() + var19);
               List var14 = var13.l();
               var10000 = var14.isEmpty();
               if(var16 != 0) {
                  break label116;
               }

               if(var10000) {
                  var13 = null;
               } else {
                  var13 = (c)var14.get(var14.size() - 1);
                  if(var16 != 0) {
                     break;
                  }
               }
            }
         }

         var10000 = var4.isEmpty();
      }

      label102: {
         List var15;
         f var22;
         if(var10000) {
            if(var2.size() <= 0) {
               break label102;
            }

            boolean var20 = var7 == var2.size();
            var22 = (f)var2.get(var20?var7 - 1:var7);

            while(true) {
               if(var22 == null) {
                  break label102;
               }

               var22.b(var22.g() + var3.g());
               var15 = var22.o();
               if(var16 != 0) {
                  return;
               }

               if(var15.isEmpty()) {
                  var22 = null;
               } else {
                  var22 = (f)var15.get(var20?var15.size() - 1:0);
                  if(var16 != 0) {
                     break;
                  }
               }
            }
         }

         y.d.r var21 = var3.i();
         if(var21 != null) {
            int var23;
            label86: {
               if(var21.a > 0.0D) {
                  var22 = (f)var4.get(0);

                  while(var22 != null) {
                     var22.b(var22.g() + var21.a);
                     var15 = var22.o();
                     var23 = var15.isEmpty();
                     if(var16 != 0) {
                        break label86;
                     }

                     if(var23 != 0) {
                        var22 = null;
                     } else {
                        var22 = (f)var15.get(0);
                        if(var16 != 0) {
                           break;
                        }
                     }
                  }
               }

               double var24;
               var23 = (var24 = var21.c - 0.0D) == 0.0D?0:(var24 < 0.0D?-1:1);
            }

            if(var23 > 0) {
               var22 = (f)var4.get(var4.size() - 1);

               while(var22 != null) {
                  var22.b(var22.g() + var21.c);
                  var15 = var22.o();
                  if(var16 != 0) {
                     return;
                  }

                  if(var15.isEmpty()) {
                     var22 = null;
                  } else {
                     var22 = (f)var15.get(var15.size() - 1);
                     if(var16 != 0) {
                        break;
                     }
                  }
               }
            }
         }
      }

      this.D();
   }

   private void a(Rectangle2D var1, Collection var2) {
      y.h.a.v var3 = this.C();
      if(var3 != null) {
         this.a(var3, this.getNode(), var1, var2);
      }

   }

   private void a(y.h.a.v var1, y.c.q var2, Rectangle2D var3, Collection var4) {
      int var10 = H;
      y.c.x var5 = var1.p(var2);

      while(var5.f()) {
         label53: {
            y.c.q var6 = var5.e();
            if(var1.k(var6)) {
               y.c.x var7 = var1.p(var6);
               if(var7.f()) {
                  LinkedHashSet var8 = new LinkedHashSet();
                  this.a((y.h.a.v)var1, (y.c.q)var6, (Rectangle2D)var3, (Collection)var8);
                  boolean var9 = true;

                  boolean var10000;
                  while(true) {
                     if(var7.f()) {
                        label63: {
                           var10000 = var8.contains(var5.e());
                           if(var10 != 0) {
                              break;
                           }

                           if(!var10000) {
                              var9 = false;
                              if(var10 == 0) {
                                 break label63;
                              }
                           }

                           var7.g();
                           if(var10 == 0) {
                              continue;
                           }
                        }
                     }

                     var10000 = var9;
                     break;
                  }

                  if(var10000) {
                     var4.add(var6);
                  }

                  var4.addAll(var8);
                  if(var10 == 0) {
                     break label53;
                  }
               }

               fj var12 = this.c(var6);
               if(!var3.contains(var12.getCenterX(), var12.getCenterY())) {
                  break label53;
               }

               var4.add(var6);
               if(var10 == 0) {
                  break label53;
               }
            }

            fj var11 = this.c(var6);
            if(var3.contains(var11.getCenterX(), var11.getCenterY())) {
               var4.add(var6);
            }
         }

         var5.g();
         if(var10 != 0) {
            break;
         }
      }

   }

   public void setSize(double var1, double var3) {
      Double var5 = new Double(this.getX(), this.getY(), this.getWidth(), this.getHeight());
      super.setSize(var1, var3);
      if(var5.getWidth() != this.getWidth() || var5.getHeight() != this.getHeight()) {
         this.a((Rectangle2D)var5);
      }

   }

   public void setFrame(double var1, double var3, double var5, double var7) {
      Double var9 = new Double(this.getX(), this.getY(), this.getWidth(), this.getHeight());
      this.a(var1, var3, var5, var7);
      if(var9.getWidth() != this.getWidth() || var9.getHeight() != this.getHeight()) {
         this.a((Rectangle2D)var9);
      }

   }

   public void setFrame(Rectangle2D var1) {
      this.setFrame(var1.getX(), var1.getY(), var1.getWidth(), var1.getHeight());
   }

   protected void a(Rectangle2D var1) {
      if(this.k()) {
         k.a(this, var1);
      }

   }

   private void a(double var1, double var3, double var5, double var7) {
      super.setSize(var5, var7);
      super.setLocation(var1, var3);
   }

   static Class f(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }

   static double a(a var0) {
      return var0.y();
   }

   static double b(a var0) {
      return var0.z();
   }

   static y.d.r x() {
      return I;
   }

   static f a(a var0, double var1, double var3) {
      return var0.a(var1, var3);
   }

   static boolean c(a var0) {
      return var0.E();
   }

   static void a(a var0, boolean var1) {
      var0.d(var1);
   }

   static Rectangle2D a(a var0, f var1) {
      return var0.c(var1);
   }

   static c b(a var0, double var1, double var3) {
      return var0.b(var1, var3);
   }

   static Rectangle2D a(a var0, c var1) {
      return var0.c(var1);
   }

   static void a(a var0, s var1) {
      var0.b(var1);
   }

   static void b(a var0, s var1) {
      var0.a(var1);
   }

   static void c(a var0, double var1, double var3) {
      var0.c(var1, var3);
   }

   static void d(a var0) {
      var0.D();
   }

   static void a(a var0, j var1, List var2, c var3) {
      var0.a(var1, var2, var3);
   }

   static j e(a var0) {
      return var0.J;
   }

   static void a(a var0, double var1, double var3, double var5, double var7) {
      var0.a(var1, var3, var5, var7);
   }

   static void a(a var0, Rectangle2D var1, Collection var2) {
      var0.a(var1, var2);
   }

   static void a(a var0, j var1, List var2, f var3) {
      var0.a(var1, var2, var3);
   }

   static void a(i var0, s var1) {
      d(var0, var1);
   }

   static void b(i var0, s var1) {
      c(var0, var1);
   }
}
