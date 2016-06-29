package y.h.a;

import java.awt.Dimension;
import java.awt.geom.Dimension2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import y.h.aZ;
import y.h.bg;
import y.h.bl;
import y.h.bo;
import y.h.bu;
import y.h.eR;
import y.h.fj;
import y.h.gt;
import y.h.a.a;
import y.h.a.e;
import y.h.a.f;
import y.h.a.l;
import y.h.a.v;

public class b implements f, bg, bl {
   private boolean b;
   static Class a;

   public b() {
      this(false);
   }

   public b(boolean var1) {
      this.b = var1;
   }

   public boolean a() {
      return this.b;
   }

   private boolean j(fj var1) {
      v var2 = this.i(var1);
      return var2 == null || !var2.p(var1.getNode()).f();
   }

   public void c(fj var1) {
      int var9 = v.a;
      if(var1 instanceof e) {
         e var2 = (e)var1;
         if(!var2.g()) {
            return;
         }

         var2.b(false);
         if(var2.isGroupClosed() || this.j(var2)) {
            y.d.q var3 = this.m(var1);
            if(var3 == null) {
               label48: {
                  if(this.a()) {
                     Dimension2D var4 = this.e(var2);
                     var3 = new y.d.q(var4.getWidth(), var4.getHeight());
                     if(var9 == 0) {
                        break label48;
                     }
                  }

                  var3 = new y.d.q(1.0D, 1.0D);
               }
            }

            double var11 = var2.getWidth();
            double var6 = var2.getHeight();
            boolean var8 = false;
            if(var11 < var3.a()) {
               var11 = var3.a();
               var8 = true;
            }

            if(var6 < var3.b()) {
               var6 = var3.b();
               var8 = true;
            }

            if(!var8) {
               return;
            }

            var2.setFrame(var2.getX(), var2.getY(), var11, var6);
            if(var9 == 0) {
               return;
            }
         }

         Rectangle2D var10 = this.d(var1);
         var1.setFrame(var10.getX(), var10.getY(), var10.getWidth(), var10.getHeight());
      }

   }

   protected Rectangle2D d(fj var1) {
      double var2 = var1.getX();
      double var4 = var1.getY();
      double var6 = var1.getWidth();
      double var8 = var1.getHeight();
      Double var10 = new Double(var2, var4, var6, var8);
      if(!(var1 instanceof e)) {
         return var10;
      } else {
         Rectangle2D var14;
         label14: {
            e var11 = (e)var1;
            y.d.r var12 = var11.getBorderInsets();
            var14 = this.k(var1);
            var2 = var14.getX() - var12.b;
            var4 = var14.getY() - var12.a;
            if(this.a()) {
               Dimension2D var13 = this.e(var11);
               var6 = Math.max(var14.getWidth() + var12.b + var12.d, var13.getWidth());
               var8 = Math.max(var14.getHeight() + var12.a + var12.c, var13.getHeight());
               if(v.a == 0) {
                  break label14;
               }
            }

            var6 = var14.getWidth() + var12.b + var12.d;
            var8 = var14.getHeight() + var12.a + var12.c;
         }

         var14.setFrame(var2, var4, var6, var8);
         return var14;
      }
   }

   protected Dimension2D e(fj var1) {
      int var18 = v.a;
      Dimension var2 = new Dimension();
      if(var1.labelCount() > 0) {
         double var5;
         double var7;
         double var11;
         label36: {
            eR var3 = var1.getLabel();
            byte var4 = var3.getAutoSizePolicy();
            if(var4 == 4) {
               var5 = var3.getContentWidth();
               var7 = var3.getContentHeight();
               if(var18 == 0) {
                  break label36;
               }
            }

            if(var4 != 0) {
               boolean var9 = var3.isOffsetDirty();
               boolean var10 = var3.isSizeDirty();
               var11 = var3.getContentWidth();
               double var13 = var3.getContentHeight();
               var3.internalSetAutoSizePolicy((byte)0);
               var3.calculateSize();
               var5 = var3.getContentWidth();
               var7 = var3.getContentHeight();
               var3.internalSetAutoSizePolicy(var4);
               var3.setContentSize(var11, var13);
               var3.internalSetSizeDirty(var10);
               var3.internalSetOffsetDirty(var9);
               if(var18 == 0) {
                  break label36;
               }
            }

            var5 = var3.getContentWidth();
            var7 = var3.getContentHeight();
         }

         double var19 = 0.0D;
         var11 = 0.0D;
         if(var1 instanceof e) {
            e var20 = (e)var1;
            String var14 = var20.f();
            bo var15 = (bo)aZ.a().a(var14, a == null?(a = a("y.h.bo")):a);
            if(var15 instanceof l) {
               l var16 = (l)var15;
               eR var17 = var16.d(var1);
               if(var17 != null) {
                  var19 = var17.getWidth();
                  var11 = var17.getHeight();
               }
            }
         }

         var2.setSize(var5 + var19, Math.max(var7, var11));
      }

      return var2;
   }

   public Rectangle2D f(fj var1) {
      Rectangle2D var2 = this.g(var1);
      y.d.r var3 = this.l(var1);
      if(var2 != null) {
         var2.setFrame(var2.getX() - var3.b, var2.getY() - var3.a, var2.getWidth() + var3.b + var3.d, var2.getHeight() + var3.a + var3.c);
      }

      return var2;
   }

   public Rectangle2D g(fj var1) {
      int var9 = v.a;
      if(!(var1 instanceof e)) {
         return new Double(var1.getX(), var1.getY(), var1.getWidth(), var1.getHeight());
      } else {
         e var2 = (e)var1;
         y.d.r var3 = this.l(var2);
         if(!var2.isGroupClosed() && !this.j(var2)) {
            Double var4 = new Double(-1.0D, -1.0D, -1.0D, -1.0D);
            v var5 = this.i(var1);
            if(var5 != null) {
               y.c.q var6 = var2.getNode();
               bu var7 = (bu)var6.e();
               if(var5.k(var6) && var5.p(var6).k() > 0) {
                  y.c.x var8 = var5.p(var6);

                  while(var8.f()) {
                     this.a(var7, var8.e(), var4);
                     var8.g();
                     if(var9 != 0) {
                        break;
                     }
                  }

                  return var4;
               }
            }

            y.d.r var10 = this.l(var2);
            return new Double(var1.getX() + var10.b, var1.getY() + var10.a, var1.getWidth() - var10.b - var10.d, var1.getHeight() - var10.a - var10.c);
         } else {
            return new Double(var1.getX(), var1.getY(), var3.b + var3.d, var3.a + var3.c);
         }
      }
   }

   protected void a(bu var1, y.c.q var2, Rectangle2D var3) {
      var1.t(var2).calcUnionRect(var3);
   }

   public y.d.r h(fj var1) {
      int var12 = v.a;
      if(!(var1 instanceof e)) {
         return new y.d.r(0.0D, 0.0D, 0.0D, 0.0D);
      } else {
         e var2 = (e)var1;
         double var3 = 0.0D;
         double var5 = 0.0D;
         double var7 = 0.0D;
         double var9 = 0.0D;
         if(var2.labelCount() > 0) {
            eR var11 = var2.getLabel();
            if(var11.isVisible()) {
               switch(var11.getPosition()) {
               case 102:
               case 117:
               case 118:
                  if(var11.getAutoSizePolicy() == 2 || var11.getAutoSizePolicy() == 3) {
                     break;
                  }

                  var3 = var11.getHeight();
                  if(var12 == 0) {
                     break;
                  }
               case 101:
               case 119:
               case 120:
                  if(var11.getAutoSizePolicy() == 2 || var11.getAutoSizePolicy() == 3) {
                     break;
                  }

                  var5 = var11.getHeight();
                  if(var12 == 0) {
                     break;
                  }
               case 115:
                  if(var11.getAutoSizePolicy() == 1 || var11.getAutoSizePolicy() == 3) {
                     break;
                  }

                  var7 = var11.getWidth();
                  if(var12 == 0) {
                     break;
                  }
               case 116:
                  if(var11.getAutoSizePolicy() != 1 && var11.getAutoSizePolicy() != 3) {
                     var9 = var11.getWidth();
                  }
               case 103:
               case 104:
               case 105:
               case 106:
               case 107:
               case 108:
               case 109:
               case 110:
               case 111:
               case 112:
               case 113:
               case 114:
               }
            }
         }

         y.d.r var13 = var2.getMinimalInsets();
         return new y.d.r(var13.a + var3, var13.b + var7, var13.c + var5, var13.d + var9);
      }
   }

   protected v i(fj var1) {
      y.c.q var2 = var1.getNode();
      return var2 == null?null:v.a(var2.e());
   }

   public void a(fj var1, eR var2) {
      if(this.a()) {
         if(var1 instanceof e) {
            e var3 = (e)var1;
            String var4 = var3.f();
            bo var5 = (bo)aZ.a().a(var4, a == null?(a = a("y.h.bo")):a);
            eR var6 = null;
            if(var5 instanceof l) {
               l var7 = (l)var5;
               var6 = var7.d(var1);
            }

            if(var2 != var1.getLabel() && (var6 == null || var2 != var6)) {
               return;
            }

            var1.calcUnionRect(new Double());
            if(v.a == 0) {
               return;
            }
         }

         var1.calcUnionRect(new Double());
      }

   }

   public y.d.q a(fj var1) {
      y.d.r var2 = this.l(var1);
      double var3 = var2.b + var2.d;
      double var5 = var2.a + var2.c;
      y.d.q var7;
      if(this.a()) {
         Dimension2D var8 = this.e(var1);
         var7 = new y.d.q(Math.max(var3, var8.getWidth()), Math.max(var5, var8.getHeight()));
         if(v.a == 0) {
            return var7;
         }
      }

      if(var1 instanceof e) {
         e var9 = (e)var1;
         if(var9.isGroupClosed()) {
            return new y.d.q(1.0D, 1.0D);
         }
      }

      var7 = new y.d.q(var3, var5);
      return var7;
   }

   public y.d.q b(fj var1) {
      return new y.d.q(2.147483647E9D, 2.147483647E9D);
   }

   private Rectangle2D k(fj var1) {
      a var2 = var1.getAutoBoundsFeature();
      if(var2 == null) {
         Double var3 = new Double(0.0D, 0.0D, -1.0D, -1.0D);
         var1.calcUnionRect(var3);
         return var3;
      } else {
         return var2.getMinimalAutoBounds();
      }
   }

   private y.d.r l(fj var1) {
      a var2 = var1.getAutoBoundsFeature();
      return var2 == null?new y.d.r(0.0D, 0.0D, 0.0D, 0.0D):var2.getAutoBoundsInsets();
   }

   private y.d.q m(fj var1) {
      gt var2 = var1.getSizeConstraintProvider();
      return var2 == null?null:var2.getMinimumSize();
   }

   static Class a(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }
}
