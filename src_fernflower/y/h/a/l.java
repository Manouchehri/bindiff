package y.h.a;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import javax.swing.Icon;
import y.h.O;
import y.h.aZ;
import y.h.bd;
import y.h.bf;
import y.h.bj;
import y.h.bo;
import y.h.bu;
import y.h.cW;
import y.h.ch;
import y.h.dx;
import y.h.eR;
import y.h.fj;
import y.h.gm;
import y.h.hk;
import y.h.a.e;
import y.h.a.h;
import y.h.a.m;
import y.h.a.o;
import y.h.a.p;
import y.h.a.v;

public class l implements bd, bf, bj, bo {
   private static final eR a = (new e()).getLabel();
   private boolean b;
   private eR c;
   private boolean d;
   private Icon e;
   private Icon f;
   private final bo g;

   public l() {
      this(new gm());
   }

   public l(bo var1) {
      this.d = true;
      this.e = p.defaultClosedGroupIcon;
      this.f = p.defaultOpenGroupIcon;
      this.g = var1;
   }

   public void a(fj var1, Graphics2D var2) {
      this.g.a(var1, var2);
      if(var1 instanceof h && ((h)var1).isGroupClosed() && this.b) {
         this.b(var1, var2);
      }

      this.a(var1, var2, false);
   }

   public void e(fj var1, Graphics2D var2) {
      this.g.e(var1, var2);
      this.a(var1, var2, true);
   }

   protected void a(fj var1, Graphics2D var2, boolean var3) {
      synchronized(this) {
         if(!hk.r.equals(var2.getRenderingHint(hk.o))) {
            float var5 = this.b(var1);
            if(var5 >= 1.0F) {
               this.d(var1).paint(var2);
               if(v.a == 0) {
                  return;
               }
            }

            if(var5 > 0.0F) {
               eR var6 = this.d(var1);
               y.d.y var7 = var6.getBox();
               int var8 = (int)Math.ceil(var7.c + var7.a) - (int)Math.floor(var7.c);
               int var9 = (int)Math.ceil(var7.d + var7.b) - (int)Math.floor(var7.d);
               BufferedImage var10 = new BufferedImage(var8, var9, 2);
               Graphics2D var11 = var10.createGraphics();
               var11.translate(-var7.c, -var7.d);
               var6.paint(var11);
               var11.dispose();
               Composite var12 = var2.getComposite();
               AffineTransform var13 = var2.getTransform();
               var2.translate(var7.c, var7.d);
               var2.setComposite(AlphaComposite.getInstance(3, var5));
               var2.drawImage(var10, 0, 0, (ImageObserver)null);
               var2.setTransform(var13);
               var2.setComposite(var12);
            }
         }

      }
   }

   protected float b(fj var1) {
      if(var1 instanceof aZ) {
         Object var2 = ((aZ)var1).a("y.view.hierarchy.GroupNodePainter.GROUP_STATE_STYLE");
         if(var2 instanceof o) {
            return ((o)var2).a();
         }
      }

      return 1.0F;
   }

   protected void b(fj var1, Graphics2D var2) {
      int var27 = v.a;
      y.c.q var3 = var1.getNode();
      v var4 = this.a(var3.e());
      if(var4 != null) {
         if(var4.j(var3)) {
            bu var5 = (bu)var4.m(var3);
            y.d.r var6 = this.c(var1);
            double var7 = var1.getHeight() - var6.a - var6.c;
            double var9 = var1.getWidth() - var6.b - var6.d;
            double var11 = var1.getX() + var6.b + 0.5D * var9;
            double var13 = var1.getY() + var6.a + 0.5D * var7;
            if(var1.labelCount() > 0) {
               eR var15 = var1.getLabel();
               if(var15.isVisible()) {
                  switch(var15.getModel()) {
                  case 1:
                     switch(var15.getPosition()) {
                     case 102:
                     case 117:
                     case 118:
                        var7 -= var15.getHeight();
                        var13 += var15.getHeight() / 2.0D;
                        if(var27 == 0) {
                           break;
                        }
                     case 101:
                     case 119:
                     case 120:
                        var7 -= var15.getHeight();
                        var13 -= var15.getHeight() / 2.0D;
                        if(var27 == 0) {
                           break;
                        }
                     case 115:
                        var9 -= var15.getWidth();
                        var11 += var15.getWidth() / 2.0D;
                        if(var27 == 0) {
                           break;
                        }
                     case 116:
                        var9 -= var15.getWidth();
                        var11 -= var15.getWidth() / 2.0D;
                        if(var27 != 0) {
                           ;
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
            }

            if(var9 > 5.0D && var7 > 5.0D) {
               AffineTransform var28;
               label59: {
                  var28 = var2.getTransform();
                  var2.translate(var11, var13);
                  Rectangle var16 = var5.a();
                  double var17 = var9 / var16.getWidth();
                  double var19 = var7 / var16.getHeight();
                  double var21 = Math.min(var17, var19);
                  var2.scale(var21, var21);
                  var2.translate(-var16.getCenterX(), -var16.getCenterY());
                  double var23 = var21 * var28.getScaleX();
                  Double var25 = (Double)var2.getRenderingHint(hk.y);
                  O var26 = new O();
                  if(var25 == null || var23 > var25.doubleValue()) {
                     var26.paint(var2, var5);
                     if(var27 == 0) {
                        break label59;
                     }
                  }

                  if(4.0D * var23 > var25.doubleValue()) {
                     var26.paintSloppy(var2, var5);
                  }
               }

               var2.setTransform(var28);
            }
         }
      }
   }

   protected y.d.r c(fj var1) {
      return var1 instanceof h?((h)var1).getMinimalInsets():new y.d.r(15.0D, 15.0D, 15.0D, 15.0D);
   }

   protected eR d(fj var1) {
      int var2 = v.a;
      if(this.c == null) {
         this.c = new eR();
         this.c.setPosition((byte)117);
         this.c.a(1.0D);
      }

      label27: {
         this.c.a((fj)null);
         if(var1 instanceof h) {
            if(((h)var1).isGroupClosed()) {
               if(this.c.getIcon() == this.e) {
                  break label27;
               }

               this.c.setIcon(this.e);
               if(var2 == 0) {
                  break label27;
               }
            }

            if(this.c.getIcon() == this.f) {
               break label27;
            }

            this.c.setIcon(this.f);
            if(var2 == 0) {
               break label27;
            }
         }

         if(this.c.getIcon() != null) {
            this.c.setIcon((Icon)null);
         }
      }

      this.c.a(var1);
      return this.c;
   }

   protected v a(y.c.i var1) {
      return v.a(var1);
   }

   public dx a(fj var1, ch var2, double var3, double var5, cW var7) {
      return var1 instanceof e?(this.d(var1).contains(var3, var5)?new m(this, var1, var2):null):null;
   }

   public void a(fj var1) {
      if(var1 instanceof e) {
         e var2 = (e)var1;
         eR var3 = var2.getLabel();
         if(var3 != null && this.a(var3)) {
            var3.setPosition((byte)102);
            var3.setFontSize(16);
            var3.setBackgroundColor(Color.darkGray);
            var3.setTextColor(Color.white);
            var3.setAlignment((byte)2);
            var3.setAutoSizePolicy((byte)1);
            var3.a(0.0D);
         }
      }

   }

   private boolean a(eR var1) {
      boolean var2 = a.getAlignment() == var1.getAlignment();
      var2 &= a.getAutoSizePolicy() == var1.getAutoSizePolicy();
      var2 &= a((Object)a.getBackgroundColor(), (Object)var1.getBackgroundColor(), false);
      var2 &= a((Object)a.getBox(), (Object)var1.getBox(), false);
      var2 &= a((Object)a.getConfiguration(), (Object)var1.getConfiguration(), false);
      var2 &= a.getContentHeight() == var1.getContentHeight();
      var2 &= a.getContentWidth() == var1.getContentWidth();
      var2 &= a.e() == var1.e();
      var2 &= a((Object)a.getFont(), (Object)var1.getFont(), false);
      var2 &= a.getHeight() == var1.getHeight();
      var2 &= a.getHorizontalTextPosition() == var1.getHorizontalTextPosition();
      var2 &= a((Object)a.getIcon(), (Object)var1.getIcon(), false);
      var2 &= a((Object)a.getIconBox(), (Object)var1.getIconBox(), false);
      var2 &= a.getIconTextGap() == var1.getIconTextGap();
      var2 &= a((Object)a.getInsets(), (Object)var1.getInsets(), false);
      var2 &= a((Object)a.a(), (Object)var1.a(), true);
      var2 &= a((Object)a.getLineColor(), (Object)var1.getLineColor(), false);
      var2 &= a.getModel() == var1.getModel();
      var2 &= a(a.getModelParameter(), var1.getModelParameter(), true);
      var2 &= a((Object)a.getOffset(), (Object)var1.getOffset(), false);
      var2 &= a.getPosition() == var1.getPosition();
      var2 &= a.getRotationAngle() == var1.getRotationAngle();
      var2 &= a((Object)a.getText(), (Object)var1.getText(), false);
      var2 &= a((Object)a.getTextColor(), (Object)var1.getTextColor(), false);
      var2 &= a((Object)a.getTextBox(), (Object)var1.getTextBox(), false);
      var2 &= a(a.getUserData(), var1.getUserData(), true);
      var2 &= a.getVerticalTextPosition() == var1.getVerticalTextPosition();
      var2 &= a.getWidth() == var1.getWidth();
      return var2;
   }

   private static boolean a(Object var0, Object var1, boolean var2) {
      if(var2) {
         if(var0 != null) {
            var0 = var0.getClass();
         }

         if(var1 != null) {
            var1 = var1.getClass();
         }
      }

      return var0 == var1 || var0 != null && var0.equals(var1);
   }

   public boolean a(fj var1, double var2, double var4) {
      if(this.g instanceof bd) {
         if(((bd)this.g).a(var1, var2, var4)) {
            return true;
         }
      } else if(var2 >= var1.getX() && var2 <= var1.getX() + var1.getWidth() && var4 >= var1.getY() && var4 <= var1.getY() + var1.getHeight()) {
         return true;
      }

      return var1.labelCount() > 0 && var1.getLabel().contains(var2, var4);
   }
}
