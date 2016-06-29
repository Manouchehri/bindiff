package y.h.b;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import y.h.aZ;
import y.h.bo;
import y.h.fj;
import y.h.hk;
import y.h.b.K;
import y.h.b.L;
import y.h.b.P;
import y.h.b.Q;
import y.h.b.R;
import y.h.b.Y;
import y.h.b.a;
import y.h.b.c;
import y.h.b.f;
import y.h.b.i;

public class J implements bo {
   public static final L a = new L(0, (K)null);
   public static final L b = new L(1, (K)null);
   public static final L c = new L(2, (K)null);
   public static final L d = new L(3, (K)null);
   public static final L e = new L(4, (K)null);
   public static final L f = new L(5, (K)null);
   private static final fj g = b();
   private final Map h = new HashMap();
   private int i;

   public static J a() {
      J var0 = new J();
      var0.h.put(b, new Q(false));
      var0.h.put(a, new Q(true));
      var0.h.put(d, new R(false, false));
      var0.h.put(c, new R(true, false));
      var0.h.put(f, new P(false, false));
      var0.h.put(e, new P(true, false));
      return var0;
   }

   public bo a(L var1) {
      return (bo)this.h.get(var1);
   }

   public void a(fj var1, Graphics2D var2) {
      this.b(var1, var2, false);
   }

   protected void b(fj var1, Graphics2D var2) {
      if(c(var1, var2)) {
         var1.paintHotSpots(var2);
      }

   }

   static boolean c(fj var0, Graphics2D var1) {
      return var0.isSelected() && hk.b(var1);
   }

   static boolean a(Graphics2D var0, boolean var1) {
      Object var2 = var0.getRenderingHint(hk.g);
      return var1?hk.i.equals(var2):!hk.j.equals(var2);
   }

   static boolean b(Graphics2D var0, boolean var1) {
      Object var2 = var0.getRenderingHint(hk.k);
      return var1?hk.m.equals(var2):!hk.n.equals(var2);
   }

   protected void d(fj var1, Graphics2D var2) {
      var1.paintPorts(var2);
   }

   protected void f(fj var1, Graphics2D var2) {
      if(var1.labelCount() > 0) {
         var1.paintText(var2);
      }

   }

   public void e(fj var1, Graphics2D var2) {
      this.b(var1, var2, true);
   }

   protected void a(fj var1, Graphics2D var2, boolean var3) {
      if(var1 instanceof a) {
         Graphics2D var4 = (Graphics2D)var2.create();
         K var5 = new K(this, g);
         a var6 = (a)var1;
         this.a((aZ)var6, (aZ)var5);
         var5.setSelected(c(var1, var2));
         var5.a("y.view.tabular.TableNodePainter.BOUNDS", new Double());
         var5.a("y.view.tabular.TableNodePainter.CONTEXT", var6);
         var5.a("y.view.tabular.TableNodePainter.TABLE", var6.l());
         this.a(var5, var4, var3, false);
         this.a(var5, var4, var3, true);
         var4.dispose();
      }

   }

   private void b(fj var1, Graphics2D var2, boolean var3) {
      if(!var3) {
         this.b(var1, var2);
      }

      this.a(var1, var2, var3);
      if(b(var2, var3)) {
         this.d(var1, var2);
      }

      if(a(var2, var3)) {
         this.f(var1, var2);
      }

   }

   private void a(aZ var1, Graphics2D var2, boolean var3, boolean var4) {
      int var29 = a.H;
      a var5 = a((fj)var1);
      i var6 = var5.l();
      double var7 = var5.getX();
      double var9 = var5.getY();
      double var11 = var5.getWidth();
      double var13 = var5.getHeight();
      bo var15 = this.a(var4?a:b);
      if(var15 != null) {
         label62: {
            var1.setFrame(var7, var9, var11, var13);
            if(var3) {
               var15.e(var1, var2);
               if(var29 == 0) {
                  break label62;
               }
            }

            var15.a(var1, var2);
         }
      }

      bo var16 = this.a(var4?c:d);
      if(var16 != null) {
         label67: {
            double var17 = var7 + var5.v();
            y.d.r var23 = var6.d();
            double var19 = var9 + var23.a;
            double var21 = var13 - (var23.a + var23.c);
            Iterator var24 = var6.l().iterator();

            while(var24.hasNext()) {
               c var25 = (c)var24.next();
               var1.a("y.view.tabular.TableNodePainter.COLUMN", var25);
               double var26 = var25.g();
               var1.setFrame(var17, var19, var26, var21);
               this.a(var1, var2, var3, var16);
               var17 += var26;
               if(var29 != 0) {
                  break label67;
               }

               if(var29 != 0) {
                  break;
               }
            }

            var1.c("y.view.tabular.TableNodePainter.COLUMN");
         }
      }

      bo var33 = this.a(var4?e:f);
      if(var33 != null) {
         double var20 = var9 + var5.t();
         y.d.r var30 = var6.d();
         double var18 = var7 + var30.b;
         double var22 = var11 - (var30.b + var30.d);
         Iterator var31 = var6.o().iterator();

         while(var31.hasNext()) {
            f var32 = (f)var31.next();
            var1.a("y.view.tabular.TableNodePainter.ROW", var32);
            double var27 = var32.g();
            var1.setFrame(var18, var20, var22, var27);
            this.b(var1, var2, var3, var33);
            var20 += var27;
            if(var29 != 0) {
               return;
            }

            if(var29 != 0) {
               break;
            }
         }

         var1.c("y.view.tabular.TableNodePainter.ROW");
      }

   }

   private void a(aZ var1, Graphics2D var2, boolean var3, bo var4) {
      int var22 = a.H;
      c var5 = c(var1);
      double var6 = var1.getX();
      double var8 = var1.getY();
      double var10 = var1.getHeight();
      y.d.r var12 = this.a(var1, var5.i());
      if(this.b(1)) {
         var8 += var12.a;
         var10 -= var12.a;
      }

      if(this.b(4)) {
         var10 -= var12.c;
      }

      label42: {
         if(var3) {
            var4.e(var1, var2);
            if(var22 == 0) {
               break label42;
            }
         }

         var4.a(var1, var2);
      }

      List var13 = var5.l();
      Iterator var14 = var13.iterator();

      while(var14.hasNext()) {
         c var15 = (c)var14.next();
         var1.a("y.view.tabular.TableNodePainter.COLUMN", var15);
         double var16 = var15.g();
         double var18 = 0.0D;
         double var20 = 0.0D;
         if(var15.b() == 0) {
            label32: {
               if(this.a(2)) {
                  var16 += var12.b;
                  var18 = var12.b;
                  if(var22 == 0) {
                     break label32;
                  }
               }

               var6 += var12.b;
            }
         }

         if(var15.b() + 1 == var5.k() && this.a(8)) {
            var16 += var12.d;
            var20 = var12.d;
         }

         var1.setFrame(var6, var8, var16, var10);
         var1.a("y.view.tabular.TableNodePainter.ACCUMULATED_INSETS_ID", new y.d.r(var12.a, var18, var12.c, var20));
         this.a(var1, var2, var3, var4);
         var1.c("y.view.tabular.TableNodePainter.ACCUMULATED_INSETS_ID");
         var6 += var16;
         if(var22 != 0) {
            break;
         }
      }

   }

   private void b(aZ var1, Graphics2D var2, boolean var3, bo var4) {
      int var22 = a.H;
      f var5 = d(var1);
      double var6 = var1.getX();
      double var8 = var1.getY();
      double var10 = var1.getWidth();
      y.d.r var12 = this.b(var1, var5.i());
      if(this.b(32)) {
         var6 += var12.b;
         var10 -= var12.b;
      }

      if(this.b(128)) {
         var10 -= var12.d;
      }

      label42: {
         if(var3) {
            var4.e(var1, var2);
            if(var22 == 0) {
               break label42;
            }
         }

         var4.a(var1, var2);
      }

      List var13 = var5.o();
      Iterator var14 = var13.iterator();

      while(var14.hasNext()) {
         f var15 = (f)var14.next();
         var1.a("y.view.tabular.TableNodePainter.ROW", var15);
         double var16 = var15.g();
         double var18 = 0.0D;
         double var20 = 0.0D;
         if(var15.b() == 0) {
            label32: {
               if(this.a(16)) {
                  var16 += var12.a;
                  var18 = var12.a;
                  if(var22 == 0) {
                     break label32;
                  }
               }

               var8 += var12.a;
            }
         }

         if(var15.b() + 1 == var5.n() && this.a(64)) {
            var16 += var12.c;
            var20 = var12.c;
         }

         var1.setFrame(var6, var8, var10, var16);
         var1.a("y.view.tabular.TableNodePainter.ACCUMULATED_INSETS_ID", new y.d.r(var18, var12.b, var20, var12.d));
         this.b(var1, var2, var3, var4);
         var1.c("y.view.tabular.TableNodePainter.ACCUMULATED_INSETS_ID");
         var8 += var16;
         if(var22 != 0) {
            break;
         }
      }

   }

   private y.d.r a(aZ var1, y.d.r var2) {
      int[] var3 = new int[]{1, 2, 4, 8};
      return this.a(var1, var2, var3);
   }

   private y.d.r b(aZ var1, y.d.r var2) {
      int[] var3 = new int[]{16, 32, 64, 128};
      return this.a(var1, var2, var3);
   }

   private y.d.r a(aZ var1, y.d.r var2, int[] var3) {
      Object var4 = var1.a("y.view.tabular.TableNodePainter.ACCUMULATED_INSETS_ID");
      if(var4 instanceof y.d.r) {
         double var5 = var2.a;
         if(this.a(var3[0])) {
            var5 += ((y.d.r)var4).a;
         }

         double var7 = var2.b;
         if(this.a(var3[1])) {
            var7 += ((y.d.r)var4).b;
         }

         double var9 = var2.c;
         if(this.a(var3[2])) {
            var9 += ((y.d.r)var4).c;
         }

         double var11 = var2.d;
         if(this.a(var3[3])) {
            var11 += ((y.d.r)var4).d;
         }

         return new y.d.r(var5, var7, var9, var11);
      } else {
         return var2;
      }
   }

   private boolean a(int var1) {
      return (this.i & var1) == var1;
   }

   private boolean b(int var1) {
      return !this.a(var1);
   }

   private static fj b() {
      aZ var0 = new aZ();
      var0.setLocation(0.0D, 0.0D);
      var0.setFillColor((Color)null);
      var0.setFillColor2((Color)null);
      var0.setLineColor((Color)null);

      while(var0.labelCount() > 0) {
         var0.removeLabel(var0.getLabel(0));
      }

      return var0;
   }

   private void a(aZ var1, aZ var2) {
      int var5 = a.H;
      var2.setFrame(var1.getX(), var1.getY(), var1.getWidth(), var1.getHeight());
      var2.setFillColor(var1.getFillColor());
      var2.setFillColor2(var1.getFillColor2());
      var2.setLineColor(var1.getLineColor());
      var2.setLineType(var1.getLineType());
      Iterator var3 = var1.e().iterator();

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         var2.a((String)var4.getKey(), var4.getValue());
         if(var5 != 0) {
            break;
         }
      }

   }

   public static a a(fj var0) {
      return (a)((aZ)var0).a("y.view.tabular.TableNodePainter.CONTEXT");
   }

   public static i b(fj var0) {
      return (i)((aZ)var0).a("y.view.tabular.TableNodePainter.TABLE");
   }

   public static c c(fj var0) {
      return (c)((aZ)var0).a("y.view.tabular.TableNodePainter.COLUMN");
   }

   public static f d(fj var0) {
      return (f)((aZ)var0).a("y.view.tabular.TableNodePainter.ROW");
   }

   private static Rectangle2D f(fj var0) {
      Rectangle2D var1 = (Rectangle2D)((aZ)var0).a("y.view.tabular.TableNodePainter.BOUNDS");
      var1.setFrame(var0.getX(), var0.getY(), var0.getWidth(), var0.getHeight());
      return var1;
   }

   private static Y b(fj var0, String var1) {
      return (Y)((aZ)var0).a(var1);
   }

   static Rectangle2D e(fj var0) {
      return f(var0);
   }

   static Y a(fj var0, String var1) {
      return b(var0, var1);
   }
}
