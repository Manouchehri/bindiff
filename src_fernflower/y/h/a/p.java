package y.h.a;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import y.h.O;
import y.h.bu;
import y.h.eR;
import y.h.fj;
import y.h.gn;
import y.h.gt;
import y.h.hk;
import y.h.a.a;
import y.h.a.h;
import y.h.a.q;
import y.h.a.r;
import y.h.a.v;

public class p extends gn implements a, h, gt {
   public static final Icon defaultClosedGroupIcon;
   public static final Icon defaultOpenGroupIcon;
   private boolean ue;
   private Icon bf;
   private Icon we;
   private boolean ze = false;
   private double af = 100.0D;
   private double pe = 80.0D;
   private boolean re = true;
   private boolean df;
   private double gf = 15.0D;
   private double cf = 15.0D;
   private double ef = 15.0D;
   private double te = 15.0D;
   private double ff = 0.0D;
   private double hf = 0.0D;
   private double xe = 0.0D;
   private double qe = 0.0D;
   private eR ve;
   private boolean se = false;
   private boolean ye = true;
   static Class class$y$view$hierarchy$AutoBoundsFeature;

   public p() {
      this.lb();
   }

   public p(fj var1) {
      super(var1);
      if(var1 instanceof h) {
         this.b((h)var1);
         if(v.a == 0) {
            return;
         }
      }

      this.bf = defaultClosedGroupIcon;
      this.we = defaultOpenGroupIcon;
   }

   private void b(h var1) {
      label15: {
         if(var1 instanceof p) {
            p var2 = (p)var1;
            this.af = var2.af;
            this.pe = var2.pe;
            this.bf = var2.bf;
            this.we = var2.we;
            this.ze = var2.ze;
            this.ve = var2.ve;
            this.gf = var2.gf;
            this.cf = var2.cf;
            this.ef = var2.ef;
            this.te = var2.te;
            this.ff = var2.ff;
            this.hf = var2.hf;
            this.xe = var2.xe;
            this.qe = var2.qe;
            this.se = var2.se;
            this.ye = var2.ye;
            this.df = var2.df;
            if(v.a == 0) {
               break label15;
            }
         }

         this.ze = var1.isGroupClosed();
         y.d.r var4 = var1.getMinimalInsets();
         this.gf = var4.a;
         this.cf = var4.c;
         this.ef = var4.b;
         this.te = var4.d;
         y.d.r var3 = var1.getBorderInsets();
         this.ff = var3.a;
         this.hf = var3.c;
         this.xe = var3.b;
         this.qe = var3.d;
      }

      if(this.ve != null) {
         this.ve = (eR)this.ve.clone();
         this.ve.a((fj)this);
      }

   }

   private void lb() {
      eR var1 = this.getLabel();
      var1.setPosition((byte)102);
      var1.setFontSize(16);
      var1.setBackgroundColor(Color.darkGray);
      var1.setTextColor(Color.white);
      var1.setAlignment((byte)2);
      var1.setAutoSizePolicy((byte)1);
      var1.a(0.0D);
      this.bf = defaultClosedGroupIcon;
      this.we = defaultOpenGroupIcon;
   }

   public fj createCopy(fj var1) {
      p var2 = new p(var1);
      if(!(var1 instanceof h)) {
         var2.b(this);
      }

      return var2;
   }

   public y.d.r getAutoBoundsInsets() {
      int var10 = v.a;
      double var1 = 0.0D;
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      if(this.labelCount() > 0) {
         eR var9 = this.getLabel();
         if(var9.isVisible()) {
            switch(var9.getPosition()) {
            case 102:
            case 117:
            case 118:
               if(var9.getAutoSizePolicy() == 2 || var9.getAutoSizePolicy() == 3) {
                  break;
               }

               var1 = var9.getHeight();
               if(var10 == 0) {
                  break;
               }
            case 101:
            case 119:
            case 120:
               if(var9.getAutoSizePolicy() == 2 || var9.getAutoSizePolicy() == 3) {
                  break;
               }

               var3 = var9.getHeight();
               if(var10 == 0) {
                  break;
               }
            case 115:
               if(var9.getAutoSizePolicy() == 1 || var9.getAutoSizePolicy() == 3) {
                  break;
               }

               var5 = var9.getWidth();
               if(var10 == 0) {
                  break;
               }
            case 116:
               if(var9.getAutoSizePolicy() != 1 && var9.getAutoSizePolicy() != 3) {
                  var7 = var9.getWidth();
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

      return new y.d.r(this.gf + var1, this.ef + var5, this.cf + var3, this.te + var7);
   }

   public void setAutoBoundsInsets(Insets var1) {
      this.setAutoBoundsInsets(new y.d.r(var1));
   }

   public void setAutoBoundsInsets(y.d.r var1) {
      this.setBorderInsets(var1);
   }

   public boolean isAutoBoundsEnabled() {
      return this.re && !this.ze;
   }

   public void setAutoBoundsEnabled(boolean var1) {
      if(!this.re && var1) {
         if(!this.ze && !this.kb()) {
            Rectangle2D var2 = this.calcMinimumInsetBounds();
            double var3 = var2.getX() + var2.getWidth();
            double var5 = var2.getY() + var2.getHeight();
            this.qe = this.x + this.width > var3?this.x + this.width - var3:0.0D;
            this.ff = this.y < var2.getY()?var2.getY() - this.y:0.0D;
            this.hf = this.y + this.height > var5?this.y + this.height - var5:0.0D;
            this.xe = this.x < var2.getX()?var2.getX() - this.x:0.0D;
         }

         this.re = var1;
         this.recalculateBounds();
         if(v.a == 0) {
            return;
         }
      }

      this.re = var1;
   }

   public Rectangle2D getMinimalAutoBounds() {
      return this.calcMinimumInsetBounds();
   }

   public void updateAutoSizeBounds() {
      this.recalculateBounds();
   }

   public void setMinimalInsets(Insets var1) {
      this.setMinimalInsets(new y.d.r(var1));
   }

   public void setMinimalInsets(y.d.r var1) {
      this.cf = var1.c;
      this.gf = var1.a;
      this.ef = var1.b;
      this.te = var1.d;
      this.recalculateBounds();
   }

   public y.d.r getMinimalInsets() {
      return new y.d.r(this.gf, this.ef, this.cf, this.te);
   }

   public void setBorderInsets(Insets var1) {
      this.setBorderInsets(new y.d.r(var1));
   }

   public void setBorderInsets(y.d.r var1) {
      this.ff = var1.a;
      this.hf = var1.c;
      this.qe = var1.d;
      this.xe = var1.b;
      this.recalculateBounds();
   }

   public y.d.r getBorderInsets() {
      return new y.d.r(this.ff, this.xe, this.hf, this.qe);
   }

   public Icon getClosedGroupIcon() {
      return this.bf;
   }

   public void setClosedGroupIcon(Icon var1) {
      this.bf = var1;
      if(this.ze) {
         this.getStateLabel().setIcon(this.bf);
      }

   }

   public Icon getOpenGroupIcon() {
      return this.we;
   }

   public void setOpenGroupIcon(Icon var1) {
      this.we = var1;
      if(!this.ze) {
         this.getStateLabel().setIcon(this.we);
      }

   }

   public double getClosedWidth() {
      return this.af;
   }

   public void setClosedWidth(double var1) {
      this.af = var1;
   }

   public double getClosedHeight() {
      return this.pe;
   }

   public void setClosedHeight(double var1) {
      this.pe = var1;
   }

   public void setGroupClosed(boolean var1) {
      this.getStateLabel().setIcon(var1?this.bf:this.we);
      if(this.ze != var1) {
         this.ze = var1;
         if(var1) {
            gt var2 = this.getSizeConstraintProvider();
            if(var2 != null) {
               double var3 = var2.getMinimumSize().a();
               double var5 = var2.getMinimumSize().b();
               if(this.af < var3) {
                  this.af = var3;
               }

               if(this.pe < var5) {
                  this.pe = var5;
               }
            }

            super.setFrame(this.x, this.y, this.af, this.pe);
            if(v.a == 0) {
               return;
            }
         }

         this.af = this.width;
         this.pe = this.height;
         this.setBoundsDirty();
         this.recalculateBounds();
      }

   }

   public boolean isGroupClosed() {
      return this.ze;
   }

   public void setInnerGraphDisplayEnabled(boolean var1) {
      this.se = var1;
   }

   public boolean isInnerGraphDisplayEnabled() {
      return this.se;
   }

   public void paintSloppy(Graphics2D var1) {
      if(this.ue) {
         this.recalculateBounds();
      }

      super.paintSloppy(var1);
      this.paintGroupState(var1, true);
   }

   protected void paintNode(Graphics2D var1) {
      int var6 = v.a;
      if(this.isBoundsDirty()) {
         this.recalculateBounds();
      }

      v var2 = this.getHierarchyManager();
      if(var2 != null) {
         label31: {
            Color var3 = this.getFillColor();
            if(var3 != null && this.ye) {
               Color var4 = var3;
               int var5 = var2.o(this.getNode());
               if(var5 > 0) {
                  var4 = new Color(Math.max(var3.getRed() - 20 * var5, 0), Math.max(var3.getGreen() - 20 * var5, 0), Math.max(var3.getBlue() - 20 * var5, 0), var3.getAlpha());
               }

               this.setFillColor(var4);
               this.paintShapeNode(var1);
               this.setFillColor(var3);
               if(var6 == 0) {
                  break label31;
               }
            }

            this.paintShapeNode(var1);
         }

         if(this.isGroupClosed() && this.isInnerGraphDisplayEnabled()) {
            this.paintInnerGraph(var1);
         }

         this.paintGroupState(var1, false);
         if(var6 == 0) {
            return;
         }
      }

      this.paintShapeNode(var1);
   }

   protected void paintGroupState(Graphics2D var1, boolean var2) {
      if(f(var1, var2)) {
         this.getStateLabel().paint(var1);
      }

   }

   private static boolean f(Graphics2D var0, boolean var1) {
      Object var2 = var0.getRenderingHint(hk.o);
      return var1?hk.q.equals(var2):!hk.r.equals(var2);
   }

   protected void paintShapeNode(Graphics2D var1) {
      super.paintNode(var1);
   }

   public void setGroupDepthFillColorEnabled(boolean var1) {
      this.ye = var1;
   }

   public boolean isGroupDepthFillColorEnabled() {
      return this.ye;
   }

   public void setStateLabel(eR var1) {
      this.ve = var1;
      var1.a((fj)this);
   }

   public eR getStateLabel() {
      if(this.ve == null) {
         this.ve = new eR();
         this.ve.setPosition((byte)117);
         this.ve.a(1.0D);
         this.ve.a((fj)this);
      }

      return this.ve;
   }

   public Double getBoundingBox() {
      if(this.ue) {
         this.recalculateBounds();
      }

      return super.getBoundingBox();
   }

   private boolean kb() {
      y.c.q var1 = this.getNode();
      if(var1 == null) {
         return true;
      } else {
         v var2 = this.getHierarchyManager();
         return var2 == null || !var2.p(var1).f();
      }
   }

   protected void recalculateBounds() {
      if(this.re) {
         if(this.df || !this.ze && !this.kb()) {
            Rectangle2D var1 = this.calcMinimumBounds();
            this.setSize(var1.getWidth(), var1.getHeight());
            this.setLocation(var1.getX(), var1.getY());
            this.ue = false;
            gt var2 = this.getSizeConstraintProvider();
            if(var2 != null) {
               var1.setFrame(var1.getX(), var1.getY(), Math.max(var1.getWidth(), var2.getMinimumSize().a()), Math.max(var1.getHeight(), var2.getMinimumSize().b()));
            }

            if(this.df) {
               Dimension2D var3 = this.calculateMinimalLabelSize();
               var1.setFrame(var1.getX(), var1.getY(), Math.max(var1.getWidth(), var3.getWidth()), Math.max(var1.getHeight(), var3.getHeight()));
            }

            this.setSize(var1.getWidth(), var1.getHeight());
            this.setLocation(var1.getX(), var1.getY());
            this.ue = false;
         }
      }
   }

   protected Rectangle2D calcMinimumInsetBounds() {
      y.d.r var1 = this.getAutoBoundsInsets();
      if(!this.ze && !this.kb()) {
         Rectangle2D var2 = this.calcMinimumGroupBounds();
         var2.setFrame(var2.getX() - var1.b, var2.getY() - var1.a, var2.getWidth() + var1.b + var1.d, var2.getHeight() + var1.a + var1.c);
         return var2;
      } else {
         return new Double(this.x, this.y, var1.b + var1.d, var1.a + var1.c);
      }
   }

   protected Rectangle2D calcMinimumBounds() {
      if(!this.ze && !this.kb()) {
         Rectangle2D var1 = this.calcMinimumInsetBounds();
         var1.setFrame(var1.getX() - this.xe, var1.getY() - this.ff, var1.getWidth() + this.xe + this.qe, var1.getHeight() + this.ff + this.hf);
         return var1;
      } else {
         return new Double(this.x, this.y, this.width, this.height);
      }
   }

   protected Rectangle2D calcMinimumGroupBounds() {
      int var6 = v.a;
      Double var1 = new Double(-1.0D, -1.0D, -1.0D, -1.0D);
      v var2 = this.getHierarchyManager();
      if(var2 != null) {
         y.c.q var3 = this.getNode();
         bu var4 = (bu)var3.e();
         if(var2.k(var3)) {
            y.c.x var5 = var2.p(var3);

            while(var5.f()) {
               var4.t(var5.e()).calcUnionRect(var1);
               var5.g();
               if(var6 != 0) {
                  break;
               }
            }
         }
      }

      return var1;
   }

   protected v getHierarchyManager() {
      y.c.q var1 = this.getNode();
      return var1 == null?null:v.a(var1.e());
   }

   protected boolean isBoundsDirty() {
      return this.ue;
   }

   protected void setBoundsDirty() {
      this.ue = true;
   }

   protected void paintInnerGraph(Graphics2D var1) {
      int var25 = v.a;
      v var2 = this.getHierarchyManager();
      if(var2 != null) {
         y.c.q var3 = this.getNode();
         if(var3 != null && var2.j(var3)) {
            bu var4 = (bu)var2.m(var3);
            double var5 = this.getHeight() - this.gf - this.cf;
            double var7 = this.getWidth() - this.ef - this.te;
            double var9 = this.getX() + this.ef + 0.5D * var7;
            double var11 = this.getY() + this.gf + 0.5D * var5;
            if(this.labelCount() > 0) {
               eR var13 = this.getLabel();
               if(var13.isVisible()) {
                  switch(var13.getModel()) {
                  case 1:
                     switch(var13.getPosition()) {
                     case 102:
                     case 117:
                     case 118:
                        var5 -= var13.getHeight();
                        var11 += var13.getHeight() / 2.0D;
                        if(var25 == 0) {
                           break;
                        }
                     case 101:
                     case 119:
                     case 120:
                        var5 -= var13.getHeight();
                        var11 -= var13.getHeight() / 2.0D;
                        if(var25 == 0) {
                           break;
                        }
                     case 115:
                        var7 -= var13.getWidth();
                        var9 += var13.getWidth() / 2.0D;
                        if(var25 == 0) {
                           break;
                        }
                     case 116:
                        var7 -= var13.getWidth();
                        var9 -= var13.getWidth() / 2.0D;
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

            if(var7 > 5.0D && var5 > 5.0D) {
               AffineTransform var19;
               label64: {
                  double var26 = 1.0D;
                  double var15 = 1.0D;
                  double var17 = 1.0D;
                  var19 = var1.getTransform();
                  var1.translate(var9, var11);
                  Rectangle var20 = var4.a();
                  var26 = var7 / var20.getWidth();
                  var15 = var5 / var20.getHeight();
                  var17 = Math.min(var26, var15);
                  var1.scale(var17, var17);
                  var1.translate(-var20.getCenterX(), -var20.getCenterY());
                  double var21 = var17 * var19.getScaleX();
                  java.lang.Double var23 = (java.lang.Double)var1.getRenderingHint(hk.y);
                  O var24 = new O();
                  if(var23 == null || var21 > var23.doubleValue()) {
                     var24.paint(var1, var4);
                     if(var25 == 0) {
                        break label64;
                     }
                  }

                  if(var23 == null || 4.0D * var21 > var23.doubleValue()) {
                     var24.paintSloppy(var1, var4);
                  }
               }

               var1.setTransform(var19);
            }
         }
      }
   }

   public double getY() {
      if(this.ue) {
         this.recalculateBounds();
      }

      return super.getY();
   }

   public double getCenterX() {
      if(this.ue) {
         this.recalculateBounds();
      }

      return super.getCenterX();
   }

   public boolean contains(double var1, double var3) {
      if(this.ue) {
         this.recalculateBounds();
      }

      return super.contains(var1, var3);
   }

   public double getHeight() {
      if(this.ue) {
         this.recalculateBounds();
      }

      return super.getHeight();
   }

   public double getX() {
      if(this.ue) {
         this.recalculateBounds();
      }

      return super.getX();
   }

   public boolean findIntersection(double var1, double var3, double var5, double var7, Point2D var9) {
      if(this.ue) {
         this.recalculateBounds();
      }

      return super.findIntersection(var1, var3, var5, var7, var9);
   }

   public double getWidth() {
      if(this.ue) {
         this.recalculateBounds();
      }

      return super.getWidth();
   }

   public double getCenterY() {
      if(this.ue) {
         this.recalculateBounds();
      }

      return super.getCenterY();
   }

   public y.d.q getMinimumSize() {
      int var8 = v.a;
      y.d.r var1 = this.getAutoBoundsInsets();
      double var2 = var1.b + var1.d;
      double var4 = var1.a + var1.c;
      y.d.q var6;
      if(this.isConsiderNodeLabelSize()) {
         Dimension2D var7 = this.calculateMinimalLabelSize();
         var6 = new y.d.q(Math.max(var2, var7.getWidth()), Math.max(var4, var7.getHeight()));
         if(var8 == 0) {
            return var6;
         }
      }

      if(this.ze) {
         var6 = new y.d.q(1.0D, 1.0D);
         if(var8 == 0) {
            return var6;
         }
      }

      var6 = new y.d.q(var2, var4);
      return var6;
   }

   public y.d.q getMaximumSize() {
      return new y.d.q(2.147483647E9D, 2.147483647E9D);
   }

   protected Dimension2D calculateMinimalLabelSize() {
      int var13 = v.a;
      Dimension var1 = new Dimension();
      if(this.labelCount() > 0) {
         double var4;
         double var6;
         double var8;
         double var10;
         label27: {
            eR var2 = this.getLabel();
            byte var3 = var2.getAutoSizePolicy();
            if(var3 == 4) {
               var4 = var2.getContentWidth();
               var6 = var2.getContentHeight();
               if(var13 == 0) {
                  break label27;
               }
            }

            if(var3 != 0) {
               var8 = var2.getContentWidth();
               var10 = var2.getContentHeight();
               var2.internalSetAutoSizePolicy((byte)0);
               var2.calculateSize();
               var4 = var2.getContentWidth();
               var6 = var2.getContentHeight();
               var2.internalSetAutoSizePolicy(var3);
               var2.setContentSize(var8, var10);
               if(var13 == 0) {
                  break label27;
               }
            }

            var4 = var2.getContentWidth();
            var6 = var2.getContentHeight();
         }

         var8 = 0.0D;
         var10 = 0.0D;
         eR var12 = this.getStateLabel();
         if(var12 != null) {
            var8 = var12.getWidth();
            var10 = var12.getHeight();
         }

         var1.setSize(var4 + var8, Math.max(var6, var10));
      }

      return var1;
   }

   protected void labelBoundsChanged(eR var1) {
      if(this.df && (this.labelCount() > 0 && var1 == this.getLabel() || var1 == this.getStateLabel())) {
         this.setBoundsDirty();
      }

   }

   public boolean intersects(double var1, double var3, double var5, double var7) {
      if(!this.isGroupClosed()) {
         this.ue = true;
      }

      if(this.ue) {
         this.recalculateBounds();
      }

      return super.intersects(var1, var3, var5, var7);
   }

   public void calcUnionRect(Rectangle2D var1) {
      if(!this.isGroupClosed()) {
         this.ue = true;
      }

      if(this.ue) {
         this.recalculateBounds();
      }

      super.calcUnionRect(var1);
   }

   public boolean findBBIntersection(double var1, double var3, double var5, double var7, Point2D var9) {
      if(this.ue) {
         this.recalculateBounds();
      }

      return super.findBBIntersection(var1, var3, var5, var7, var9);
   }

   public void write(ObjectOutputStream var1) {
      int var2;
      label27: {
         var2 = v.a;
         var1.writeByte(4);
         super.write(var1);
         if(this.isGroupClosed()) {
            var1.writeDouble(this.width);
            var1.writeDouble(this.height);
            if(var2 == 0) {
               break label27;
            }
         }

         var1.writeDouble(this.af);
         var1.writeDouble(this.pe);
      }

      label22: {
         if(this.we == defaultOpenGroupIcon) {
            var1.writeBoolean(true);
            if(var2 == 0) {
               break label22;
            }
         }

         var1.writeBoolean(false);
         var1.writeObject(this.we);
      }

      label17: {
         if(this.bf == defaultClosedGroupIcon) {
            var1.writeBoolean(true);
            if(var2 == 0) {
               break label17;
            }
         }

         var1.writeBoolean(false);
         var1.writeObject(this.bf);
      }

      var1.writeBoolean(this.ze);
      var1.writeBoolean(this.se);
      var1.writeDouble(this.gf);
      var1.writeDouble(this.cf);
      var1.writeDouble(this.ef);
      var1.writeDouble(this.te);
      var1.writeDouble(this.ff);
      var1.writeDouble(this.hf);
      var1.writeDouble(this.xe);
      var1.writeDouble(this.qe);
      var1.writeBoolean(this.ye);
      var1.writeBoolean(this.df);
   }

   public void read(ObjectInputStream var1) {
      int var4 = v.a;
      byte var2 = var1.readByte();
      super.read(var1);
      boolean var3;
      switch(var2) {
      case 0:
         this.af = var1.readDouble();
         this.pe = var1.readDouble();
         this.we = (Icon)var1.readObject();
         this.bf = (Icon)var1.readObject();
         this.ze = var1.readBoolean();
         this.se = var1.readBoolean();
         if(var4 == 0) {
            return;
         }
      case 1:
         this.af = var1.readDouble();
         this.pe = var1.readDouble();
         this.we = (Icon)var1.readObject();
         this.bf = (Icon)var1.readObject();
         this.ze = var1.readBoolean();
         this.se = var1.readBoolean();
         this.gf = var1.readDouble();
         this.cf = var1.readDouble();
         this.ef = var1.readDouble();
         this.te = var1.readDouble();
         this.ff = var1.readDouble();
         this.hf = var1.readDouble();
         this.xe = var1.readDouble();
         this.qe = var1.readDouble();
         if(var4 == 0) {
            return;
         }
      case 2:
         this.af = var1.readDouble();
         this.pe = var1.readDouble();
         this.we = (Icon)var1.readObject();
         this.bf = (Icon)var1.readObject();
         var3 = var1.readBoolean();
         this.se = var1.readBoolean();
         this.gf = var1.readDouble();
         this.cf = var1.readDouble();
         this.ef = var1.readDouble();
         this.te = var1.readDouble();
         this.ff = var1.readDouble();
         this.hf = var1.readDouble();
         this.xe = var1.readDouble();
         this.qe = var1.readDouble();
         this.ye = var1.readBoolean();
         this.setGroupClosed(var3);
         if(var4 == 0) {
            return;
         }
      case 3:
         this.af = var1.readDouble();
         this.pe = var1.readDouble();
         this.we = (Icon)var1.readObject();
         this.bf = (Icon)var1.readObject();
         var3 = var1.readBoolean();
         this.se = var1.readBoolean();
         this.gf = var1.readDouble();
         this.cf = var1.readDouble();
         this.ef = var1.readDouble();
         this.te = var1.readDouble();
         this.ff = var1.readDouble();
         this.hf = var1.readDouble();
         this.xe = var1.readDouble();
         this.qe = var1.readDouble();
         this.ye = var1.readBoolean();
         this.df = var1.readBoolean();
         this.setGroupClosed(var3);
         if(var4 == 0) {
            return;
         }
      case 4:
         break;
      default:
         throw new y.e.a((byte)4, var2);
      }

      label39: {
         this.af = var1.readDouble();
         this.pe = var1.readDouble();
         if(var1.readBoolean()) {
            this.we = defaultOpenGroupIcon;
            if(var4 == 0) {
               break label39;
            }
         }

         this.we = (Icon)var1.readObject();
      }

      label34: {
         if(var1.readBoolean()) {
            this.bf = defaultClosedGroupIcon;
            if(var4 == 0) {
               break label34;
            }
         }

         this.bf = (Icon)var1.readObject();
      }

      var3 = var1.readBoolean();
      this.se = var1.readBoolean();
      this.gf = var1.readDouble();
      this.cf = var1.readDouble();
      this.ef = var1.readDouble();
      this.te = var1.readDouble();
      this.ff = var1.readDouble();
      this.hf = var1.readDouble();
      this.xe = var1.readDouble();
      this.qe = var1.readDouble();
      this.ye = var1.readBoolean();
      this.df = var1.readBoolean();
      this.setGroupClosed(var3);
      if(var4 != 0) {
         throw new y.e.a((byte)4, var2);
      }
   }

   public void setSize(double var1, double var3) {
      super.setSize(var1, var3);
      if(this.ve != null) {
         this.ve.setOffsetDirty();
      }

   }

   public boolean isConsiderNodeLabelSize() {
      return this.df;
   }

   public void setConsiderNodeLabelSize(boolean var1) {
      this.df = var1;
      this.setBoundsDirty();
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }

   static {
      Class var0 = class$y$view$hierarchy$AutoBoundsFeature == null?(class$y$view$hierarchy$AutoBoundsFeature = class$("y.h.a.a")):class$y$view$hierarchy$AutoBoundsFeature;
      Object var1 = null;
      Object var2 = null;

      try {
         var1 = new ImageIcon(var0.getResource("resource/default_closed_group_icon.gif"));
         var2 = new ImageIcon(var0.getResource("resource/default_open_group_icon.gif"));
      } catch (Exception var4) {
         ;
      }

      if(var1 == null) {
         var1 = new q();
      }

      if(var2 == null) {
         var2 = new r();
      }

      defaultClosedGroupIcon = (Icon)var1;
      defaultOpenGroupIcon = (Icon)var2;
   }
}
