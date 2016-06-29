package y.h;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.lang.ref.WeakReference;
import java.util.EventObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;
import y.h.D;
import y.h.aC;
import y.h.bu;
import y.h.bw;
import y.h.cB;
import y.h.cC;
import y.h.cD;
import y.h.cE;
import y.h.cF;
import y.h.cH;
import y.h.cI;
import y.h.cJ;
import y.h.cK;
import y.h.cL;
import y.h.cM;
import y.h.ch;
import y.h.cn;
import y.h.co;
import y.h.cq;
import y.h.cr;
import y.h.cs;
import y.h.ct;
import y.h.cu;
import y.h.cv;
import y.h.cw;
import y.h.cx;
import y.h.cy;
import y.h.cz;
import y.h.fj;
import y.h.gX;
import y.h.gd;
import y.h.ij;

public class cm {
   ch a;
   ActionMap b;
   public static final Object c = "FOCUS_RIGHT_NODE";
   public static final Object d = "EDIT_NODE";
   public static final Object e = "FOCUS_LEFT_NODE";
   public static final Object f = "FOCUS_TOP_NODE";
   public static final Object g = "FOCUS_BOTTOM_NODE";
   public static final Object h = "SELECT_ALL";
   public static final Object i = "TOP_ALIGN";
   public static final Object j = "ALIGN_VERTICALLY";
   public static final Object k = "BOTTOM_ALIGN";
   public static final Object l = "DISTRIBUTE_VERTICALLY";
   public static final Object m = "LEFT_ALIGN";
   public static final Object n = "ALIGN_HORIZONTALLY";
   public static final Object o = "RIGHT_ALIGN";
   public static final Object p = "DISTRIBUTE_HORIZONTALLY";
   public static final Object q = "SELECT_LEFT_EDGE";
   public static final Object r = "SELECT_RIGHT_EDGE";
   public static final Object s = "SELECT_TOP_EDGE";
   public static final Object t = "SELECT_BOTTOM_EDGE";
   public static final Object u = "DELETE_SELECTION";
   public static final Object v = "GROUP_SELECTION";
   public static final Object w = "FOLD_SELECTION";
   public static final Object x = "UNGROUP_SELECTION";
   public static final Object y = "UNFOLD_SELECTION";
   public static final Object z = "OPEN_FOLDERS";
   public static final Object A = "CLOSE_GROUPS";
   public static final Object B = "EDIT_LABEL";
   public static final Object C = "DUPLICATE_GRAPH";
   public static final Object D = "ADD_SUCCESSORS";
   public static final Object E = "ADD_PREDECESSORS";
   Map F;

   public cm() {
      this((ch)null);
   }

   public cm(ch var1) {
      this.F = new WeakHashMap();
      this.a = var1;
      this.b = new ActionMap();
      this.b.put(g, this.e());
      this.b.put(f, this.d());
      this.b.put(e, this.b());
      this.b.put(c, this.c());
      this.b.put(t, this.j());
      this.b.put(s, this.i());
      this.b.put(q, this.f());
      this.b.put(r, this.g());
      this.b.put(u, this.k());
      this.b.put(B, this.u());
      this.b.put(d, this.a());
      this.b.put(h, this.h());
      this.b.put(m, this.a(m, false, (byte)-1));
      this.b.put(n, this.a((Object)n, false, (byte)0));
      this.b.put(o, this.a((Object)o, false, (byte)1));
      this.b.put(p, this.a((Object)p, false, (byte)2));
      this.b.put(i, this.a(i, true, (byte)-1));
      this.b.put(j, this.a((Object)j, true, (byte)0));
      this.b.put(k, this.a((Object)k, true, (byte)1));
      this.b.put(l, this.a((Object)l, true, (byte)2));
      this.b.put(A, this.l());
      this.b.put(z, this.m());
      this.b.put(v, this.n());
      this.b.put(w, this.o());
      this.b.put(x, this.p());
      this.b.put(y, this.q());
      this.b.put(C, this.r());
      this.b.put(D, this.s());
      this.b.put(E, this.t());
   }

   Action a() {
      return new cn(this, d.toString());
   }

   protected ch a(ActionEvent var1) {
      return b(var1, this.a);
   }

   private static ch b(ActionEvent var0, ch var1) {
      return var0.getSource() instanceof bw?(ch)((bw)var0.getSource()).getParent():(var0.getSource() instanceof ch?(ch)var0.getSource():var1);
   }

   Action b() {
      return new cs(this, e.toString());
   }

   Action c() {
      return new ct(this, c.toString());
   }

   Action d() {
      return new cu(this, f.toString());
   }

   Action e() {
      return new cv(this, g.toString());
   }

   Action f() {
      return new cw(this, q.toString());
   }

   Action g() {
      return new cx(this, r.toString());
   }

   Action h() {
      return new cK(this.a);
   }

   Action a(Object var1, boolean var2, byte var3) {
      return new cy(this, var1.toString(), var2, var3);
   }

   Action i() {
      return new cz(this, s.toString());
   }

   Action j() {
      return new co(this, t.toString());
   }

   Action k() {
      return new cE(this.a);
   }

   Action l() {
      return new cD(this.a);
   }

   Action m() {
      return new cJ(this.a);
   }

   Action n() {
      return new cI(this.a);
   }

   Action o() {
      return new cH(this.a);
   }

   Action p() {
      return new cM(this.a);
   }

   Action q() {
      return new cL(this.a);
   }

   Action r() {
      return new cF(this.a);
   }

   Action s() {
      return new cC(this.a);
   }

   Action t() {
      return new cB(this.a);
   }

   private static fj b(bu var0, y.c.q var1) {
      fj var2 = var0.t(var1);
      return var2 instanceof gd?((gd)var2).e():var2;
   }

   Action u() {
      return new cq(this);
   }

   public ActionMap v() {
      boolean var4 = fj.z;
      ActionMap var1 = new ActionMap();
      Object[] var2 = this.b.keys();
      int var3 = 0;

      ActionMap var10000;
      while(true) {
         if(var3 < var2.length) {
            var10000 = var1;
            if(var4) {
               break;
            }

            var1.put(var2[var3], this.b.get(var2[var3]));
            ++var3;
            if(!var4) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000;
   }

   public InputMap a(ActionMap var1) {
      HashSet var2;
      int var4;
      label125: {
         boolean var7 = fj.z;
         var2 = new HashSet();
         Object[] var3 = var1.keys();
         if(var3 != null) {
            var4 = 0;

            while(var4 < var3.length) {
               var2.add(var3[var4]);
               ++var4;
               if(var7) {
                  break label125;
               }

               if(var7) {
                  break;
               }
            }
         }

         var4 = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
      }

      InputMap var5 = new InputMap();
      if(var2.contains(e)) {
         var5.put(KeyStroke.getKeyStroke(37, 0), e);
      }

      if(var2.contains(c)) {
         var5.put(KeyStroke.getKeyStroke(39, 0), c);
      }

      if(var2.contains(g)) {
         var5.put(KeyStroke.getKeyStroke(40, 0), g);
      }

      if(var2.contains(f)) {
         var5.put(KeyStroke.getKeyStroke(38, 0), f);
      }

      byte var6 = 8;
      if(var2.contains(q)) {
         var5.put(KeyStroke.getKeyStroke(37, var6), q);
      }

      if(var2.contains(r)) {
         var5.put(KeyStroke.getKeyStroke(39, var6), r);
      }

      if(var2.contains(t)) {
         var5.put(KeyStroke.getKeyStroke(40, var6), t);
      }

      if(var2.contains(s)) {
         var5.put(KeyStroke.getKeyStroke(38, var6), s);
      }

      if(var2.contains(u)) {
         var5.put(KeyStroke.getKeyStroke(127, 0), u);
      }

      if(var2.contains(h)) {
         var5.put(KeyStroke.getKeyStroke(65, var4), h);
      }

      if(var2.contains(B)) {
         var5.put(KeyStroke.getKeyStroke(113, 0), B);
      }

      if(var2.contains(d)) {
         var5.put(KeyStroke.getKeyStroke(10, 0), d);
      }

      var6 = 10;
      if(var2.contains(o)) {
         var5.put(KeyStroke.getKeyStroke(39, var6), o);
      }

      if(var2.contains(m)) {
         var5.put(KeyStroke.getKeyStroke(37, var6), m);
      }

      if(var2.contains(n)) {
         var5.put(KeyStroke.getKeyStroke(72, var6), n);
      }

      if(var2.contains(j)) {
         var5.put(KeyStroke.getKeyStroke(86, var6), j);
      }

      if(var2.contains(i)) {
         var5.put(KeyStroke.getKeyStroke(38, var6), i);
      }

      if(var2.contains(k)) {
         var5.put(KeyStroke.getKeyStroke(40, var6), k);
      }

      if(var2.contains(A)) {
         var5.put(KeyStroke.getKeyStroke(67, var6), A);
      }

      if(var2.contains(z)) {
         var5.put(KeyStroke.getKeyStroke(79, var6), z);
      }

      if(var2.contains(v)) {
         var5.put(KeyStroke.getKeyStroke(71, var6), v);
      }

      if(var2.contains(w)) {
         var5.put(KeyStroke.getKeyStroke(70, var6), w);
      }

      if(var2.contains(x)) {
         var5.put(KeyStroke.getKeyStroke(85, var6), x);
      }

      if(var2.contains(y)) {
         var5.put(KeyStroke.getKeyStroke(77, var6), y);
      }

      var6 = 3;
      if(var2.contains(l)) {
         var5.put(KeyStroke.getKeyStroke(86, var6), l);
      }

      if(var2.contains(p)) {
         var5.put(KeyStroke.getKeyStroke(72, var6), p);
      }

      return var5;
   }

   protected void a(ch var1) {
      boolean var9 = fj.z;
      bu var2 = this.d(var1);
      if(var2.I()) {
         y.c.x var3 = var2.J();
         if(var3.f()) {
            y.c.q var4 = var3.e();
            aC var5 = null;
            D var6 = null;
            Iterator var7 = var1.getViewModes();

            while(true) {
               if(var7.hasNext()) {
                  gX var8 = (gX)var7.next();
                  if(var8 instanceof D) {
                     var6 = (D)var8;
                  }

                  if(!(var8 instanceof aC)) {
                     continue;
                  }

                  var5 = (aC)var8;
                  if(var9) {
                     break;
                  }

                  if(!var9) {
                     continue;
                  }
               }

               if(var6 != null && var6.isActive() && !var6.a()) {
                  if(!var6.a(var4)) {
                     return;
                  }

                  var6.a((y.c.q)var4, (EventObject)null);
                  if(!var9) {
                     return;
                  }
               }
               break;
            }

            if(var5 != null && var5.isActive() && !var5.isEditing()) {
               var5.editNode(var4, (EventObject)null);
            }
         }
      }

   }

   void a(byte var1, ch var2) {
      bu var3;
      double var4;
      double var6;
      y.c.q var8;
      y.c.x var9;
      boolean var21;
      label38: {
         var21 = fj.z;
         var3 = this.d(var2);
         var8 = this.b(var2);
         var9 = var3.o();
         if(var8 == null) {
            y.c.d var10 = this.c(var2);
            if(var10 != null) {
               var4 = 0.5D * (var3.j(var10.c()) + var3.j(var10.d()));
               var6 = 0.5D * (var3.k(var10.c()) + var3.k(var10.d()));
               y.c.y var11 = new y.c.y(var10.c());
               var11.add(var10.d());
               var9 = var11.a();
               if(!var21) {
                  break label38;
               }
            }

            Point2D var23 = var2.getCenter();
            var4 = var23.getX();
            var6 = var23.getY();
            if(!var21) {
               break label38;
            }
         }

         var4 = var3.j(var8);
         var6 = var3.k(var8);
      }

      double var22 = Double.MAX_VALUE;
      y.c.q var12 = null;
      y.c.x var13 = var9;

      while(true) {
         if(var13.f()) {
            y.c.q var14 = var13.e();
            double var15 = var3.j(var14);
            double var17 = var3.k(var14);
            double var19 = this.a(var4, var6, var15, var17, var1);
            if(var21) {
               break;
            }

            if(var19 < var22 && var14 != var8) {
               var22 = var19;
               var12 = var14;
            }

            var13.g();
            if(!var21) {
               continue;
            }
         }

         if(var12 != null) {
            var3.N();
            var3.a(var12, true);
            var2.focusView(var2.getZoom(), new java.awt.geom.Point2D.Double(var3.j(var12), var3.k(var12)), false);
            var3.T();
         }
         break;
      }

   }

   void a(ch var1, boolean var2, byte var3) {
      bu var4 = this.d(var1);
      y.c.y var5 = new y.c.y(var4.J());
      var4.r();
      var4.a(var5.a());
      y.f.ae.a(var4, var5, (y.c.q)null, var2, var3);
      var4.s();
      var4.T();
   }

   void b(byte var1, ch var2) {
      boolean var22 = fj.z;
      bu var3 = this.d(var2);
      double var4 = Double.MAX_VALUE;
      y.c.d var6 = null;
      y.d.t var7 = null;
      y.c.q var8 = this.b(var2);
      if(var8 != null) {
         this.F.put(var2, new WeakReference(var8));
         var7 = var3.l(var8);

         for(y.c.e var9 = var8.j(); var9.f(); var9.g()) {
            y.c.d var10 = var9.a();
            if(var22) {
               return;
            }

            Point2D var11;
            double var12;
            if(var8 == var10.c()) {
               var11 = var3.i(var10).getSourceIntersection();
               if(var11 != null) {
                  var12 = this.a(var7.a, var7.b, var11.getX(), var11.getY(), var1);
                  if(var12 < var4) {
                     var4 = var12;
                     var6 = var10;
                  }
               }
            }

            if(var8 == var10.d()) {
               var11 = var3.i(var10).getTargetIntersection();
               if(var11 != null) {
                  var12 = this.a(var7.a, var7.b, var11.getX(), var11.getY(), var1);
                  if(var12 < var4) {
                     var4 = var12;
                     var6 = var10;
                  }
               }
            }
         }
      } else {
         y.c.d var23 = this.c(var2);
         if(var23 != null) {
            y.c.q var24 = var23.c();
            WeakReference var25 = (WeakReference)this.F.get(var2);
            y.c.q var26 = (y.c.q)(var25 != null?var25.get():null);
            if(var26 != null) {
               label126: {
                  if(var26 == var23.c() || var26 == var23.d()) {
                     var24 = var26;
                     if(!var22) {
                        break label126;
                     }
                  }

                  this.F.put(var2, new WeakReference(var8));
               }
            }

            y.c.q var13 = var24;
            y.d.t var14 = var3.l(var24);
            HashMap var15 = new HashMap();
            y.c.D var16 = new y.c.D();
            y.c.e var17 = var24.j();

            while(var17.f()) {
               y.c.d var18 = var17.a();
               GeneralPath var19 = var3.i(var18).getPath();
               if(var18.c() == var13 && !var15.containsValue(var18)) {
                  var15.put(var19, var18);
                  var16.add(var19);
               }

               if(var18.d() == var13 && !var18.e()) {
                  var19 = ij.a(var19);
                  var15.put(var19, var18);
                  var16.add(var19);
               }

               var17.g();
               if(var22) {
                  break;
               }
            }

            AffineTransform var27 = new AffineTransform();
            double[] var28 = new double[6];
            double[] var29 = new double[6];
            var16.sort(new cr(this, var27, var28, var29, var14));
            y.c.C var20 = var16.m();

            while(var20.f()) {
               y.c.d var21 = (y.c.d)var15.get(var20.d());
               if(var21 == var23) {
                  label127: {
                     if(var1 == 1 || var1 == 3) {
                        var20.g();
                        if(var20.f()) {
                           break label127;
                        }

                        var20.i();
                        if(!var22) {
                           break label127;
                        }
                     }

                     var20.h();
                     if(!var20.f()) {
                        var20.j();
                     }
                  }

                  var21 = (y.c.d)var15.get(var20.d());
                  if(var23 != var21) {
                     var6 = var21;
                  }
                  break;
               }

               var20.g();
            }
         }
      }

      if(var6 != null) {
         var3.N();
         var3.a((y.c.d)var6, true);
         var2.updateView();
      }

   }

   private double a(double var1, double var3, double var5, double var7) {
      double var9 = var5 - var1;
      double var11 = var7 - var3;
      return Math.atan2(var11, var9);
   }

   double a(double var1, double var3, double var5, double var7, byte var9) {
      boolean var24 = fj.z;
      double var10 = var5 - var1;
      double var12 = var7 - var3;
      double var14 = 0.0D;
      double var16 = 0.0D;
      switch(var9) {
      case 0:
         var14 = -1.0D;
         var16 = 0.0D;
         if(!var24) {
            break;
         }
      case 1:
         var14 = 1.0D;
         var16 = 0.0D;
         if(!var24) {
            break;
         }
      case 2:
         var14 = 0.0D;
         var16 = -1.0D;
         if(!var24) {
            break;
         }
      case 3:
         var14 = 0.0D;
         var16 = 1.0D;
      }

      double var18 = y.d.t.a(var1, var3, var5, var7);
      if(var18 == 0.0D) {
         return var18;
      } else {
         double var20 = (var14 * var10 + var16 * var12) / var18;
         double var22 = Math.acos(var20);
         return var22 >= 1.5707963267948966D?Double.MAX_VALUE:y.d.t.a(var1, var3, var5, var7) * (1.0D + Math.pow(2.0D * var22 / 3.141592653589793D, 8.0D));
      }
   }

   y.c.q b(ch var1) {
      boolean var5 = fj.z;
      bu var2 = this.d(var1);
      y.c.x var3 = var2.o();

      while(var3.f()) {
         y.c.q var4 = var3.e();
         if(var2.v(var4)) {
            return var4;
         }

         var3.g();
         if(var5) {
            break;
         }
      }

      return null;
   }

   y.c.d c(ch var1) {
      boolean var5 = fj.z;
      bu var2 = this.d(var1);
      y.c.e var3 = var2.p();

      while(var3.f()) {
         y.c.d var4 = var3.a();
         if(var2.r(var4)) {
            return var4;
         }

         var3.g();
         if(var5) {
            break;
         }
      }

      return null;
   }

   bu d(ch var1) {
      return var1.getGraph2D();
   }

   static ch a(ActionEvent var0, ch var1) {
      return b(var0, var1);
   }

   static fj a(bu var0, y.c.q var1) {
      return b(var0, var1);
   }

   static double a(cm var0, double var1, double var3, double var5, double var7) {
      return var0.a(var1, var3, var5, var7);
   }
}
