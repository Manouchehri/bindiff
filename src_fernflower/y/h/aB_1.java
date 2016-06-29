package y.h;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.geom.Rectangle2D.Float;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import y.h.C;
import y.h.O;
import y.h.aA;
import y.h.bu;
import y.h.dr;
import y.h.dy;
import y.h.fJ;
import y.h.fL;
import y.h.fj;
import y.h.h;
import y.h.hC;
import y.h.hk;
import y.h.ij;
import y.h.x;
import y.h.y;
import y.h.z;

public abstract class aB implements y.f.I {
   static final int xb = 1;
   static final int ob = 2;
   public static final byte PATH_UNCLIPPED = 0;
   public static final byte PATH_CLIPPED_AT_SOURCE = 4;
   public static final byte PATH_CLIPPED_AT_TARGET = 8;
   public static final byte PATH_CLIPPED_AT_SOURCE_AND_TARGET = 12;
   public static final byte PATH_INVISBLE = 28;
   Object vb;
   Object zb;
   private boolean rb;
   int pb;
   private y.c.d qb;
   private Color kb;
   private dr dc;
   private h ib;
   private h yb;
   private ArrayList cc;
   private byte gc;
   private boolean tb;
   private fL sb;
   private fL ec;
   private float mb;
   private float jb;
   private float bc;
   private float ac;
   private boolean fc;
   private static Color wb;
   private static dr lb;
   private static Color ub;
   protected z bends;
   protected GeneralPath path;
   Float nb;

   protected aB() {
      this.g();
      this.kb = Color.black;
      this.dc = dr.a;
      this.yb = this.ib = h.a;
      this.setSourcePort(new fL());
      this.setTargetPort(new fL());
   }

   protected aB(aB var1) {
      this.g();
      this.b(var1);
   }

   void b(aB var1) {
      aB var10000;
      boolean var5;
      label39: {
         var5 = fj.z;
         this.kb = var1.getLineColor();
         this.dc = var1.getLineType();
         this.yb = var1.getArrow();
         this.ib = var1.getSourceArrow();
         this.vb = var1.vb;
         this.zb = var1.zb;
         int var2 = var1.labelCount();
         if(var2 > 0) {
            this.cc = new ArrayList(var2);
            int var3 = 0;

            while(var3 < var2) {
               var10000 = this;
               if(var5) {
                  break label39;
               }

               this.addLabel((aA)var1.getLabel(var3).clone());
               ++var3;
               if(var5) {
                  break;
               }
            }
         }

         var10000 = var1;
      }

      y var6 = var10000.bends();

      while(true) {
         if(var6.f()) {
            x var4 = this.appendBend(var6.a().b(), var6.a().c());
            if(var5) {
               break;
            }

            if(var4 != null) {
               var4.a(var6.a().d());
            }

            var6.g();
            if(!var5) {
               continue;
            }
         }

         this.setSourcePort(var1.getSourcePort().a());
         this.setTargetPort(var1.getTargetPort().a());
         this.tb = var1.isSelected();
         this.setVisible(var1.isVisible());
         this.fc = var1.fc;
         this.rb = true;
         break;
      }

   }

   public aB createCopy() {
      return this.createCopy(this);
   }

   public abstract aB createCopy(aB var1);

   private void g() {
      this.pb = 1;
      this.path = new GeneralPath(1, 2);
      this.bends = new z();
      this.rb = true;
   }

   protected void bindEdge(y.c.d var1) {
      this.qb = var1;
      this.setDirty();
   }

   public fj getTargetRealizer() {
      return ((bu)this.qb.a()).t(this.qb.d());
   }

   public fj getSourceRealizer() {
      return ((bu)this.qb.a()).t(this.qb.c());
   }

   public y.c.d getEdge() {
      return this.qb;
   }

   bu i() {
      return this.qb != null?(bu)this.qb.a():null;
   }

   public void setPorts(fL var1, fL var2) {
      this.setSourcePort(var1);
      this.setTargetPort(var2);
   }

   public void setSourcePort(fL var1) {
      var1.a(this);
      this.sb = var1;
      this.setDirty();
   }

   public void setTargetPort(fL var1) {
      var1.a(this);
      this.ec = var1;
      this.setDirty();
   }

   public fL getSourcePort() {
      return this.sb;
   }

   public fL getTargetPort() {
      return this.ec;
   }

   public abstract x createBend(double var1, double var3, x var5, int var6);

   public abstract void reInsertBend(x var1, x var2, int var3);

   public abstract x insertBend(double var1, double var3);

   public abstract x removeBend(x var1);

   public void bendChanged(x var1, double var2, double var4) {
   }

   protected void labelBoundsChanged() {
   }

   public x appendBend(double var1, double var3) {
      return this.createBend(var1, var3, this.lastBend(), 0);
   }

   public int bendPos(x var1) {
      return this.bends.indexOf(var1);
   }

   public int bendCount() {
      return this.bends.size();
   }

   public x getBend(int var1) {
      return (x)this.bends.a(var1);
   }

   public y bends() {
      return this.bends.b();
   }

   public x firstBend() {
      return this.bends.size() == 0?null:(x)this.bends.f();
   }

   public x lastBend() {
      return this.bends.size() == 0?null:(x)this.bends.i();
   }

   public int getMinBendCount() {
      return 0;
   }

   public void clearBends() {
      this.bends.clear();
      this.setDirty();
   }

   public y.d.t getPoint(int var1) {
      x var2 = this.getBend(var1);
      return var2 != null?new y.d.t(var2.b(), var2.c()):null;
   }

   public int pointCount() {
      return this.bendCount();
   }

   public y.d.t getSourcePoint() {
      fL var1 = this.getSourcePort();
      return new y.d.t(var1.g(), var1.h());
   }

   public y.d.t getTargetPoint() {
      fL var1 = this.getTargetPort();
      return new y.d.t(var1.g(), var1.h());
   }

   public void setSourcePoint(y.d.t var1) {
      this.getSourcePort().b(var1.a(), var1.b());
   }

   public void setTargetPoint(y.d.t var1) {
      this.getTargetPort().b(var1.a(), var1.b());
   }

   public void setPoint(int var1, double var2, double var4) {
      x var6 = this.getBend(var1);
      if(var6 != null) {
         var6.a(var2, var4);
      }

   }

   public void addPoint(double var1, double var3) {
      this.appendBend(var1, var3);
   }

   public void clearPoints() {
      this.clearBends();
   }

   public void registerObstacles(C var1) {
   }

   public void paintSloppy(Graphics2D var1) {
      if(this.isVisible()) {
         this.d(var1, hk.e(var1));
         if(e(var1, true)) {
            this.paintLabels(var1);
         }

      }
   }

   void c(Graphics2D var1) {
      this.d(var1, true);
   }

   private void d(Graphics2D var1, boolean var2) {
      boolean var18 = fj.z;
      GeneralPath var3 = this.path;
      if(var2 || !var3.getPathIterator((AffineTransform)null).isDone()) {
         Stroke var4;
         Color var5;
         label80: {
            var4 = var1.getStroke();
            var5 = var1.getColor();
            boolean var6 = b(this, var1);
            if(var6 && wb != null) {
               var1.setColor(wb);
               if(!var18) {
                  break label80;
               }
            }

            Color var7 = this.getLineColor();
            if(var7 != null) {
               var1.setColor(var7);
               if(!var18) {
                  break label80;
               }
            }

            return;
         }

         label91: {
            var1.setStroke(dr.a);
            if(var2) {
               fj var19 = this.getSourceRealizer();
               double var12 = this.sb.a(var19);
               double var14 = this.sb.b(var19);
               y.c.p var16 = this.bends.k();

               label62: {
                  double var8;
                  double var10;
                  while(var16 != null) {
                     x var17 = (x)var16.c();
                     var8 = var17.b();
                     var10 = var17.c();
                     var1.drawLine((int)var12, (int)var14, (int)var8, (int)var10);
                     var12 = var8;
                     var14 = var10;
                     var16 = var16.a();
                     if(var18) {
                        break label62;
                     }

                     if(var18) {
                        break;
                     }
                  }

                  var19 = this.getTargetRealizer();
                  var8 = this.ec.a(var19);
                  var10 = this.ec.b(var19);
                  var1.drawLine((int)var12, (int)var14, (int)var8, (int)var10);
               }

               if(!var18) {
                  break label91;
               }
            }

            boolean var20 = this.getSourceArrow() != h.a;
            boolean var21 = this.getTargetArrow() != h.a;
            if(var20 || var21) {
               GeneralPath var9 = new GeneralPath(var3.getWindingRule());
               Point2D var22;
               if(var20) {
                  var22 = this.getSourceIntersection();
                  var9.moveTo((float)var22.getX(), (float)var22.getY());
               }

               var9.append(var3, var20);
               if(var21) {
                  var22 = this.getTargetIntersection();
                  var9.lineTo((float)var22.getX(), (float)var22.getY());
               }

               var1.draw(var9);
               if(!var18) {
                  break label91;
               }
            }

            var1.draw(var3);
         }

         var1.setStroke(var4);
         var1.setColor(var5);
      }
   }

   public void repaint() {
      y.c.d var1 = this.getEdge();
      if(var1 != null) {
         y.c.i var2 = var1.a();
         if(var2 instanceof bu) {
            Double var3 = new Double(0.0D, 0.0D, -1.0D, -1.0D);
            this.calcUnionRect(var3);
            ((bu)var2).a(var3.x, var3.y, var3.width, var3.height);
         }
      }

   }

   public void paint(Graphics2D var1) {
      if((this.pb & 1) != 0) {
         if(this.isDirty()) {
            this.recalculateFeatures();
         }

         if((this.pb & 2) != 0) {
            Color var2 = var1.getColor();
            Stroke var3 = var1.getStroke();
            GeneralPath var4 = this.path;
            if(this instanceof fJ && (!this.qb.e() || this.bendCount() >= 2)) {
               C var5 = O.getBridgeCalculator(this, var1);
               if(var5 != null) {
                  GeneralPath var6 = new GeneralPath();
                  PathIterator var7 = var5.a(var4.getPathIterator((AffineTransform)null, 1.0D));
                  var6.append(var7, true);
                  var4 = var6;
               }
            }

            if(this.fc) {
               var4 = ij.a(var4);
            }

            boolean var8 = b(this, var1);
            if(var8 && wb != null) {
               var1.setColor(wb);
               if(lb != null) {
                  label66: {
                     int var9 = (int)(this.dc.getLineWidth() - lb.getLineWidth());
                     if(var9 >= 0) {
                        var1.setStroke(new BasicStroke(this.dc.getLineWidth() + 4.0F, 2, 2));
                        if(!fj.z) {
                           break label66;
                        }
                     }

                     var1.setStroke(lb);
                  }
               }

               var1.draw(var4);
            }

            if(this.kb != null) {
               var1.setColor(this.kb);
               var1.setStroke(this.dc);
               var1.draw(var4);
               this.paintArrows(var1);
            }

            if(e(var1, false)) {
               this.paintLabels(var1);
            }

            this.paintPorts(var1);
            if(var8) {
               this.paintHighlightedBends(var1);
            }

            this.paintBends(var1);
            var1.setStroke(var3);
            var1.setColor(var2);
         }
      }
   }

   protected void paintHighlightedBends(Graphics2D var1) {
      boolean var5 = fj.z;
      var1.setStroke(dr.a);
      if(this.bendCount() > 0) {
         java.awt.geom.Ellipse2D.Double var2 = hC.a().m;
         var2.width = var2.height = 6.0D;
         y var3 = this.bends.b();

         while(var3.f()) {
            x var4 = var3.a();
            var1.setColor(ub);
            var2.x = var4.b() - 3.0D;
            var2.y = var4.c() - 3.0D;
            var1.fill(var2);
            var1.setColor(Color.darkGray);
            var1.draw(var2);
            var3.g();
            if(var5) {
               break;
            }
         }
      }

   }

   protected void paintBends(Graphics2D var1) {
      boolean var5 = fj.z;
      if(!this.bends.isEmpty()) {
         boolean var2 = hk.b(var1);
         y.c.p var3 = this.bends.k();

         while(var3 != null) {
            x var4 = (x)var3.c();
            if(var4.d() && var2) {
               var4.a(var1);
            }

            var3 = var3.a();
            if(var5) {
               break;
            }
         }
      }

   }

   protected void paintPorts(Graphics2D var1) {
      this.sb.a(var1, this.getSourceRealizer());
      this.ec.a(var1, this.getTargetRealizer());
   }

   protected void paintArrows(Graphics2D var1) {
      boolean var17 = fj.z;
      if(this.ib != h.a || this.yb != h.a) {
         PathIterator var2 = this.path.getPathIterator((AffineTransform)null);
         hC var11 = hC.a();
         AffineTransform var12 = var11.b;
         float[] var13 = var11.c;
         var2.currentSegment(var13);
         var2.next();
         float var3 = var13[0];
         float var4 = var13[1];
         var2.currentSegment(var13);
         var2.next();
         double var14 = this.getArrowScaleFactor();
         double var5;
         double var7;
         double var9;
         boolean var16;
         if(this.ib != h.a) {
            label63: {
               var16 = this.isPathClippedAtSource();
               if(var16) {
                  var5 = (double)(this.mb - var3);
                  var7 = (double)(this.jb - var4);
                  if(!var17) {
                     break label63;
                  }
               }

               var5 = (double)(var3 - var13[0]);
               var7 = (double)(var4 - var13[1]);
            }

            var9 = Math.sqrt(var5 * var5 + var7 * var7);
            if(var9 > 0.0D) {
               var5 /= var9;
               var7 /= var9;
               if(var16) {
                  var3 = (float)((double)var3 + this.ib.c() * var5 * var14);
                  var4 = (float)((double)var4 + this.ib.c() * var7 * var14);
               }

               var12.setTransform(var5, var7, -var7, var5, (double)var3, (double)var4);
               if(var14 != 1.0D) {
                  var12.scale(var14, var14);
               }

               this.ib.a(var1, var12);
            }
         }

         if(this.yb != h.a) {
            while(!var2.isDone()) {
               var3 = var13[0];
               var4 = var13[1];
               var2.currentSegment(var13);
               var2.next();
               if(var17) {
                  return;
               }

               if(var17) {
                  break;
               }
            }

            label46: {
               var16 = this.isPathClippedAtTarget();
               if(var16) {
                  var5 = (double)(this.bc - var13[0]);
                  var7 = (double)(this.ac - var13[1]);
                  if(!var17) {
                     break label46;
                  }
               }

               var5 = (double)(var13[0] - var3);
               var7 = (double)(var13[1] - var4);
            }

            var9 = Math.sqrt(var5 * var5 + var7 * var7);
            if(var9 > 0.0D) {
               var5 /= var9;
               var7 /= var9;
               if(var16) {
                  var13[0] = (float)((double)var13[0] + this.yb.c() * var5 * var14);
                  var13[1] = (float)((double)var13[1] + this.yb.c() * var7 * var14);
               }

               var12.setTransform(var5, var7, -var7, var5, (double)var13[0], (double)var13[1]);
               if(var14 != 1.0D) {
                  var12.scale(var14, var14);
               }

               this.yb.a(var1, var12);
            }
         }

      }
   }

   public double getArrowScaleFactor() {
      double var1 = (double)this.getLineType().getLineWidth();
      if(var1 != 1.0D) {
         var1 = 1.0D + (var1 - 1.0D) / 8.0D;
      }

      return var1;
   }

   protected void paintLabels(Graphics2D var1) {
      boolean var4 = fj.z;
      if(this.cc != null) {
         int var2 = this.cc.size() - 1;

         while(var2 >= 0) {
            aA var3 = this.getLabel(var2);
            if(var3.isVisible() && (var3.getText().length() != 0 || var3.getIcon() != null)) {
               var3.paint(var1);
            }

            --var2;
            if(var4) {
               break;
            }
         }
      }

   }

   static boolean b(aB var0, Graphics2D var1) {
      return var0.isSelected() && hk.b(var1);
   }

   static boolean e(Graphics2D var0, boolean var1) {
      Object var2 = var0.getRenderingHint(hk.c);
      return var1?hk.e.equals(var2):!hk.f.equals(var2);
   }

   protected abstract byte calculatePath(Point2D var1, Point2D var2);

   public static final byte calculateClippingAndIntersection(aB var0, GeneralPath var1, GeneralPath var2, Point2D var3, Point2D var4) {
      return ij.a(var0, var1, var2, var3, var4);
   }

   protected final void recalculateFeatures() {
      boolean var6;
      boolean var9;
      label19: {
         var9 = fj.z;
         hC var1 = hC.a();
         java.awt.geom.Point2D.Double var2 = var1.h;
         java.awt.geom.Point2D.Double var3 = var1.g;
         this.h();
         this.pb &= -13;
         byte var4 = this.calculatePath(var2, var3);
         this.pb |= 12 & var4;
         PathIterator var5 = this.path.getPathIterator((AffineTransform)null);
         var6 = true;
         if(var5.isDone()) {
            var6 = false;
            if(!var9) {
               break label19;
            }
         }

         this.mb = (float)var2.x;
         this.jb = (float)var2.y;
         this.bc = (float)var3.x;
         this.ac = (float)var3.y;
      }

      label14: {
         if(var6) {
            this.pb |= 2;
            if(!var9) {
               break label14;
            }
         }

         this.pb &= -3;
         fL var7 = this.getTargetPort();
         this.bc = (float)var7.a(this.getTargetRealizer());
         this.ac = (float)var7.b(this.getTargetRealizer());
         fL var8 = this.getSourcePort();
         this.mb = (float)var8.a(this.getSourceRealizer());
         this.jb = (float)var8.b(this.getSourceRealizer());
      }

      this.rb = false;
   }

   public boolean hasVisiblePath() {
      return (this.pb & 3) == 3;
   }

   public Point2D getSourceIntersection() {
      if(this.isDirty()) {
         this.recalculateFeatures();
      }

      return new java.awt.geom.Point2D.Float(this.mb, this.jb);
   }

   public Point2D getTargetIntersection() {
      if(this.isDirty()) {
         this.recalculateFeatures();
      }

      return new java.awt.geom.Point2D.Float(this.bc, this.ac);
   }

   public boolean isReversedPathRenderingEnabled() {
      return this.fc;
   }

   public void setReversedPathRenderingEnabled(boolean var1) {
      if(var1 != this.fc) {
         this.fc = var1;
      }

   }

   public Color getLineColor() {
      return this.kb;
   }

   public void setLineColor(Color var1) {
      this.kb = var1;
   }

   public static Color getSelectionColor() {
      return wb;
   }

   public static void setSelectionColor(Color var0) {
      wb = var0;
   }

   public static void setHighlightedBendColor(Color var0) {
      ub = var0;
   }

   public static Color getHighlightedBendColor() {
      return ub;
   }

   public dr getLineType() {
      return this.dc;
   }

   public void setLineType(dr var1) {
      if(this.dc != var1) {
         if(this.dc.getLineWidth() != var1.getLineWidth() && (this.ib.c() != 0.0D || this.yb.c() != 0.0D)) {
            this.setDirty();
         }

         this.dc = var1;
      }

   }

   public static void setSelectionStroke(dr var0) {
      lb = var0;
   }

   public static Stroke getSelectionStroke() {
      return lb;
   }

   public h getArrow() {
      return this.yb;
   }

   public void setArrow(h var1) {
      this.setTargetArrow(var1);
   }

   public h getTargetArrow() {
      return this.yb;
   }

   public void setTargetArrow(h var1) {
      if(var1 != this.yb) {
         if(this.yb.d() != var1.d() || this.yb.c() != var1.c()) {
            this.setDirty();
         }

         this.yb = var1;
      }

   }

   public h getSourceArrow() {
      return this.ib;
   }

   public void setSourceArrow(h var1) {
      if(var1 != this.ib) {
         if(this.ib.d() != var1.d() || this.ib.c() != var1.c()) {
            this.setDirty();
         }

         this.ib = var1;
      }

   }

   public void setLayer(byte var1) {
      this.gc = var1;
   }

   public byte getLayer() {
      return this.gc;
   }

   public void setVisible(boolean var1) {
      if(var1) {
         this.pb |= 1;
         if(!fj.z) {
            return;
         }
      }

      this.pb &= -2;
   }

   public boolean isVisible() {
      return (this.pb & 1) == 1;
   }

   public boolean isPathClippedAtSource() {
      return (this.pb & 4) == 4;
   }

   public boolean isPathClippedAtTarget() {
      return (this.pb & 8) == 8;
   }

   public void setSelected(boolean var1) {
      if(var1 != this.tb) {
         this.tb = var1;
         bu var2 = this.i();
         if(var2 != null) {
            var2.e(this.getEdge());
         }

         this.f();
      }

   }

   void f() {
   }

   public boolean isSelected() {
      return this.tb;
   }

   public void setDirty() {
      if(this.cc != null) {
         for(int var1 = this.cc.size() - 1; var1 >= 0; --var1) {
            aA var2 = this.getLabel(var1);
            var2.setOffsetDirty();
         }
      }

      this.rb = true;
      this.h();
   }

   protected boolean isDirty() {
      return this.rb;
   }

   public GeneralPath getPath() {
      if(this.isDirty()) {
         this.recalculateFeatures();
      }

      return this.path;
   }

   public dy getMouseInputEditorProvider() {
      return this instanceof dy?(dy)this:null;
   }

   public void addLabel(aA var1) {
      var1.bindRealizer(this);
      if(this.cc == null) {
         this.cc = new ArrayList(1);
      }

      this.cc.add(var1);
   }

   public void removeLabel(aA var1) {
      if(this.cc != null) {
         this.cc.remove(var1);
         this.rb = true;
      }

   }

   public void removeLabel(int var1) {
      if(this.cc == null) {
         throw new IndexOutOfBoundsException("Index: " + var1 + ", Size: 0");
      } else {
         try {
            this.cc.remove(var1);
            this.rb = true;
         } catch (IndexOutOfBoundsException var3) {
            throw new IndexOutOfBoundsException("Index: " + var1 + ", Size: " + this.cc.size());
         }
      }
   }

   public aA getLabel() {
      if(this.labelCount() == 0) {
         this.addLabel(this.createEdgeLabel());
      }

      return this.getLabel(0);
   }

   public int labelCount() {
      return this.cc != null?this.cc.size():0;
   }

   public aA getLabel(int var1) {
      if(this.cc == null) {
         throw new ArrayIndexOutOfBoundsException(0);
      } else {
         return (aA)this.cc.get(var1);
      }
   }

   public void setLabelText(String var1) {
      this.getLabel().setText(var1);
   }

   public String getLabelText() {
      return this.getLabel().getText();
   }

   public aA createEdgeLabel() {
      return new aA();
   }

   public boolean contains(double var1, double var3) {
      if((this.pb & 2) == 0) {
         return false;
      } else {
         if(this.isDirty() || this.nb == null) {
            this.nb = this.b(this.nb);
         }

         double var5 = (double)(this.nb.x - 5.0F);
         double var7 = (double)(this.nb.y - 5.0F);
         double var9 = var5 + (double)this.nb.width + 10.0D;
         double var11 = var7 + (double)this.nb.height + 10.0D;
         if(var1 > var5 && var1 < var9 && var3 > var7 && var3 < var11) {
            boolean var13 = this.containsSeg(var1, var3) > 0;
            if(var13) {
               Point2D var14 = this.getSourceIntersection();
               if(var14.distanceSq(var1, var3) < 25.0D) {
                  return false;
               }

               Point2D var15 = this.getTargetIntersection();
               if(var15.distanceSq(var1, var3) < 25.0D) {
                  return false;
               }
            }

            return var13;
         } else {
            return false;
         }
      }
   }

   public int containsSeg(double var1, double var3) {
      boolean var10 = fj.z;
      int var7 = 1;
      if(this.isDirty()) {
         this.recalculateFeatures();
      }

      PathIterator var8 = this.path.getPathIterator((AffineTransform)null);
      if(var8.isDone()) {
         return 0;
      } else {
         float[] var9 = hC.a().c;
         var8.currentSegment(var9);
         var8.next();
         float var5 = var9[0];
         float var6 = var9[1];

         int var10000;
         while(true) {
            if(!var8.isDone()) {
               var8.currentSegment(var9);
               double var11;
               var10000 = (var11 = Line2D.ptSegDistSq((double)var5, (double)var6, (double)var9[0], (double)var9[1], var1, var3) - 25.0D) == 0.0D?0:(var11 < 0.0D?-1:1);
               if(var10) {
                  break;
               }

               if(var10000 < 0) {
                  return var7;
               }

               ++var7;
               var8.next();
               var5 = var9[0];
               var6 = var9[1];
               if(!var10) {
                  continue;
               }
            }

            var10000 = 0;
            break;
         }

         return var10000;
      }
   }

   public void calcUnionRect(Rectangle2D var1) {
      if(this.isDirty() || this.nb == null) {
         this.nb = this.b(this.nb);
      }

      y.d.e.a((Rectangle2D)var1, (Rectangle2D)this.nb, (Rectangle2D)var1);
   }

   public boolean pathIntersects(Rectangle2D var1, boolean var2) {
      boolean var10 = fj.z;
      if(this.isDirty()) {
         this.recalculateFeatures();
      }

      if(this.nb != null && !this.nb.intersects(var1)) {
         return false;
      } else {
         PathIterator var3 = this.path.getPathIterator((AffineTransform)null);
         if(var3.isDone()) {
            return false;
         } else {
            float[] var6 = hC.a().c;
            var3.currentSegment(var6);
            var3.next();
            float var4 = var6[0];
            float var5 = var6[1];

            boolean var10000;
            while(true) {
               if(!var3.isDone()) {
                  var3.currentSegment(var6);
                  var10000 = var1.intersectsLine((double)var4, (double)var5, (double)var6[0], (double)var6[1]);
                  if(var10) {
                     break;
                  }

                  if(var10000) {
                     return true;
                  }

                  var3.next();
                  var4 = var6[0];
                  var5 = var6[1];
                  if(!var10) {
                     continue;
                  }
               }

               var10000 = var2;
               break;
            }

            if(var10000) {
               int var7 = this.labelCount() - 1;

               while(var7 >= 0) {
                  aA var8 = this.getLabel(var7);
                  var10000 = var8.isVisible();
                  if(var10) {
                     return var10000;
                  }

                  if(var10000 && (var8.getText().length() != 0 || var8.getIcon() != null)) {
                     y.d.y var9 = var8.getBox();
                     if(var1.intersects(var9.c, var9.d, var9.a, var9.b)) {
                        return true;
                     }
                  }

                  --var7;
                  if(var10) {
                     break;
                  }
               }
            }

            var10000 = false;
            return var10000;
         }
      }
   }

   void h() {
      this.nb = null;
   }

   public boolean intersects(Rectangle2D var1) {
      boolean var4 = fj.z;
      if(!this.isDirty() && this.nb != null) {
         return this.nb.intersects(var1);
      } else {
         if(this.bends.size() > 0) {
            y.c.p var2 = this.bends.k();

            while(var2 != null) {
               x var3 = (x)var2.c();
               if(var1.contains(var3.b(), var3.c())) {
                  return true;
               }

               var2 = var2.a();
               if(var4) {
                  break;
               }
            }
         }

         Point2D var5 = this.getTargetIntersection();
         if(var1.contains(var5)) {
            return true;
         } else {
            var5 = this.getSourceIntersection();
            if(var1.contains(var5)) {
               return true;
            } else {
               this.nb = this.b(this.nb);
               return this.nb.intersects(var1);
            }
         }
      }
   }

   Float b(Float var1) {
      boolean var15 = fj.z;
      Point2D var2 = this.getTargetIntersection();
      var1 = new Float((float)var2.getX(), (float)var2.getY(), 1.0F, 1.0F);
      if(this.isDirty()) {
         this.recalculateFeatures();
      }

      Rectangle2D var3 = this.path.getBounds2D();
      if(var3.getWidth() > 0.0D || var3.getHeight() > 0.0D) {
         var1.add(var3);
      }

      double var4 = var1.getX();
      double var6 = var4 + var1.getWidth();
      double var8 = var1.getY();
      double var10 = var8 + var1.getHeight();
      int var12 = this.labelCount() - 1;

      while(true) {
         if(var12 >= 0) {
            aA var13 = this.getLabel(var12);
            if(var15) {
               break;
            }

            if(var13.isVisible() && (var13.getText().length() != 0 || var13.getIcon() != null)) {
               y.d.y var14 = var13.getBox();
               var6 = Math.max(var14.c + var14.a, var6);
               var4 = Math.min(var14.c, var4);
               var10 = Math.max(var14.d + var14.b, var10);
               var8 = Math.min(var14.d, var8);
            }

            --var12;
            if(!var15) {
               continue;
            }
         }

         var1.setFrame(var4, var8, var6 - var4, var10 - var8);
         break;
      }

      return var1;
   }

   public void write(ObjectOutputStream var1) {
      boolean var3 = fj.z;
      var1.writeByte(6);
      var1.writeInt(this.bends.size());
      y var2 = this.bends();

      while(true) {
         if(var2.f()) {
            var1.writeFloat((float)var2.a().b());
            var1.writeFloat((float)var2.a().c());
            var2.g();
            if(var3) {
               break;
            }

            if(!var3) {
               continue;
            }
         }

         var1.writeObject(this.getLineColor());
         var1.writeByte(this.getArrow().a());
         break;
      }

      if(this.getArrow().a() == 0) {
         var1.writeObject(this.getArrow().b());
      }

      var1.writeByte(this.getSourceArrow().a());
      if(this.getSourceArrow().a() == 0) {
         var1.writeObject(this.getSourceArrow().b());
      }

      dr.a(var1, this.dc);
      var1.writeObject(y.e.h.a(this.sb.getClass().getName()));
      this.sb.a(var1);
      var1.writeObject(y.e.h.a(this.ec.getClass().getName()));
      this.ec.a(var1);
      var1.writeInt(this.labelCount());
      int var4 = 0;

      while(true) {
         if(var4 < this.labelCount()) {
            this.getLabel(var4).write(var1);
            ++var4;
            if(var3) {
               break;
            }

            if(!var3) {
               continue;
            }
         }

         var1.writeBoolean(this.isVisible());
         var1.writeBoolean(this.fc);
         break;
      }

   }

   public void read(ObjectInputStream var1) {
      boolean var3 = fj.z;
      byte var2 = var1.readByte();
      switch(var2) {
      case 0:
         this.b(var1);
         if(!var3) {
            break;
         }
      case 1:
         this.c(var1);
         if(!var3) {
            break;
         }
      case 2:
         this.d(var1);
         if(!var3) {
            break;
         }
      case 3:
         this.e(var1);
         if(!var3) {
            break;
         }
      case 4:
         this.f(var1);
         if(!var3) {
            break;
         }
      case 5:
         this.f(var1);
         this.setVisible(var1.readBoolean());
         if(!var3) {
            break;
         }
      case 6:
         this.f(var1);
         this.setVisible(var1.readBoolean());
         this.fc = var1.readBoolean();
         if(var3) {
            throw new y.e.a(var2);
         }
         break;
      default:
         throw new y.e.a(var2);
      }

   }

   void f(ObjectInputStream var1) {
      boolean var7 = fj.z;
      int var2 = var1.readInt();
      int var3 = 0;

      while(true) {
         if(var3 < var2) {
            this.appendBend((double)var1.readFloat(), (double)var1.readFloat());
            ++var3;
            if(var7) {
               break;
            }

            if(!var7) {
               continue;
            }
         }

         this.setLineColor((Color)var1.readObject());
         var3 = var1.readByte();
         break;
      }

      h var4;
      label49: {
         if(var3 != 0) {
            this.setArrow(h.a((byte)var3));
            if(!var7) {
               break label49;
            }
         }

         var4 = h.a((String)var1.readObject());
         if(var4 != null) {
            this.setArrow(var4);
         }
      }

      label44: {
         byte var10 = var1.readByte();
         if(var10 != 0) {
            this.setSourceArrow(h.a(var10));
            if(!var7) {
               break label44;
            }
         }

         var4 = h.a((String)var1.readObject());
         if(var4 != null) {
            this.setSourceArrow(var4);
         }
      }

      this.dc = dr.a(var1);

      try {
         String var11 = y.e.h.b((String)var1.readObject());
         this.sb = (fL)Class.forName(var11).newInstance();
         this.sb.a(var1);
         this.setSourcePort(this.sb);
         var11 = y.e.h.b((String)var1.readObject());
         this.ec = (fL)Class.forName(var11).newInstance();
         this.ec.a(var1);
         this.setTargetPort(this.ec);
      } catch (IllegalAccessException var8) {
         throw new y.e.a("Could not construct Port!");
      } catch (InstantiationException var9) {
         throw new y.e.a("Could not instantiate Port!");
      }

      int var12 = var1.readInt();
      int var5 = 0;

      while(var5 < var12) {
         aA var6 = this.createEdgeLabel();
         this.addLabel(var6);
         var6.read(var1);
         ++var5;
         if(var7) {
            break;
         }
      }

   }

   void e(ObjectInputStream var1) {
      boolean var7 = fj.z;
      int var2 = var1.readInt();
      int var3 = 0;

      while(true) {
         if(var3 < var2) {
            this.appendBend((double)var1.readFloat(), (double)var1.readFloat());
            ++var3;
            if(var7) {
               break;
            }

            if(!var7) {
               continue;
            }
         }

         this.setLineColor((Color)var1.readObject());
         var3 = var1.readByte();
         break;
      }

      h var4;
      label49: {
         if(var3 != 0) {
            this.setArrow(h.a((byte)var3));
            if(!var7) {
               break label49;
            }
         }

         var4 = h.a((String)var1.readObject());
         if(var4 != null) {
            this.setArrow(var4);
         }
      }

      label44: {
         byte var10 = var1.readByte();
         if(var10 != 0) {
            this.setSourceArrow(h.a(var10));
            if(!var7) {
               break label44;
            }
         }

         var4 = h.a((String)var1.readObject());
         if(var4 != null) {
            this.setSourceArrow(var4);
         }
      }

      this.dc = dr.a(var1.readByte(), var1.readByte());

      try {
         String var11 = y.e.h.b((String)var1.readObject());
         this.sb = (fL)Class.forName(var11).newInstance();
         this.sb.a(var1);
         this.setSourcePort(this.sb);
         var11 = y.e.h.b((String)var1.readObject());
         this.ec = (fL)Class.forName(var11).newInstance();
         this.ec.a(var1);
         this.setTargetPort(this.ec);
      } catch (IllegalAccessException var8) {
         throw new y.e.a("Could not construct Port!");
      } catch (InstantiationException var9) {
         throw new y.e.a("Could not instantiate Port!");
      }

      int var12 = var1.readInt();
      int var5 = 0;

      while(var5 < var12) {
         aA var6 = this.createEdgeLabel();
         this.addLabel(var6);
         var6.read(var1);
         ++var5;
         if(var7) {
            break;
         }
      }

   }

   void d(ObjectInputStream var1) {
      boolean var7 = fj.z;
      int var2 = var1.readInt();
      int var3 = 0;

      while(true) {
         if(var3 < var2) {
            this.appendBend((double)var1.readFloat(), (double)var1.readFloat());
            ++var3;
            if(var7) {
               break;
            }

            if(!var7) {
               continue;
            }
         }

         var3 = var1.readInt();
         break;
      }

      int var4 = 0;

      while(true) {
         if(var4 < var3) {
            aA var5 = this.createEdgeLabel();
            this.addLabel(var5);
            var5.read(var1);
            ++var4;
            if(var7) {
               break;
            }

            if(!var7) {
               continue;
            }
         }

         this.setLineColor((Color)var1.readObject());
         var4 = var1.readByte();
         break;
      }

      h var10;
      label43: {
         if(var4 != 0) {
            this.setArrow(h.a((byte)var4));
            if(!var7) {
               break label43;
            }
         }

         var10 = h.a((String)var1.readObject());
         if(var10 != null) {
            this.setArrow(var10);
         }
      }

      label38: {
         byte var11 = var1.readByte();
         if(var11 != 0) {
            this.setSourceArrow(h.a(var11));
            if(!var7) {
               break label38;
            }
         }

         var10 = h.a((String)var1.readObject());
         if(var10 != null) {
            this.setSourceArrow(var10);
         }
      }

      this.dc = dr.a(var1.readByte(), var1.readByte());

      try {
         String var12 = y.e.h.b((String)var1.readObject());
         this.sb = (fL)Class.forName(var12).newInstance();
         this.sb.a(var1);
         this.setSourcePort(this.sb);
         var12 = y.e.h.b((String)var1.readObject());
         this.ec = (fL)Class.forName(var12).newInstance();
         this.ec.a(var1);
         this.setTargetPort(this.ec);
      } catch (IllegalAccessException var8) {
         throw new y.e.a("Could not construct Port!");
      } catch (InstantiationException var9) {
         throw new y.e.a("Could not instantiate Port!");
      }
   }

   void c(ObjectInputStream var1) {
      boolean var7 = fj.z;
      int var2 = var1.readInt();
      int var3 = 0;

      while(true) {
         if(var3 < var2) {
            this.appendBend((double)var1.readFloat(), (double)var1.readFloat());
            ++var3;
            if(var7) {
               break;
            }

            if(!var7) {
               continue;
            }
         }

         var3 = var1.readInt();
         break;
      }

      int var4 = 0;

      while(true) {
         if(var4 < var3) {
            aA var5 = this.createEdgeLabel();
            var5.read(var1);
            this.addLabel(var5);
            ++var4;
            if(var7) {
               break;
            }

            if(!var7) {
               continue;
            }
         }

         this.setLineColor((Color)var1.readObject());
         var4 = var1.readByte();
         break;
      }

      h var10;
      label67: {
         if(var4 != 0) {
            this.setArrow(h.a((byte)var4));
            if(!var7) {
               break label67;
            }
         }

         var10 = h.a((String)var1.readObject());
         if(var10 != null) {
            this.setArrow(var10);
         }
      }

      label62: {
         byte var11 = var1.readByte();
         if(var11 != 0) {
            this.setSourceArrow(h.a(var11));
            if(!var7) {
               break label62;
            }
         }

         var10 = h.a((String)var1.readObject());
         if(var10 != null) {
            this.setSourceArrow(var10);
         }
      }

      this.dc = dr.a(var1.readByte(), var1.readByte());

      try {
         String var12;
         label89: {
            if(var1.readBoolean()) {
               this.sb = new fL();
               if(!var7) {
                  break label89;
               }
            }

            var12 = (String)var1.readObject();
            if(var12.startsWith("y.graph")) {
               var12 = "y.view.Port";
            }

            this.sb = (fL)Class.forName(var12).newInstance();
            this.sb.a(var1);
         }

         label90: {
            if(var1.readBoolean()) {
               this.ec = new fL();
               if(!var7) {
                  break label90;
               }
            }

            var12 = (String)var1.readObject();
            if(var12.startsWith("y.graph")) {
               var12 = "y.view.Port";
            }

            this.ec = (fL)Class.forName(var12).newInstance();
            this.ec.a(var1);
         }

         this.setPorts(this.sb, this.ec);
      } catch (IllegalAccessException var8) {
         throw new y.e.a("Could not construct Port!");
      } catch (InstantiationException var9) {
         throw new y.e.a("Could not instantiate Port!");
      }
   }

   void b(ObjectInputStream var1) {
      boolean var7 = fj.z;
      int var2 = var1.readInt();
      int var3 = 0;

      aB var10000;
      while(true) {
         if(var3 < var2) {
            var10000 = this;
            if(var7) {
               break;
            }

            this.appendBend((double)var1.readFloat(), (double)var1.readFloat());
            ++var3;
            if(!var7) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      label52: {
         aA var10 = var10000.createEdgeLabel();
         var10.read(var1);
         this.addLabel(var10);
         this.setLineColor((Color)var1.readObject());
         byte var4 = var1.readByte();
         if(var4 != 0) {
            this.setArrow(h.a(var4));
            if(!var7) {
               break label52;
            }
         }

         h var5 = h.a((String)var1.readObject());
         if(var5 != null) {
            this.setArrow(var5);
         }
      }

      this.dc = dr.a(var1.readByte(), var1.readByte());

      try {
         String var11;
         label65: {
            if(var1.readBoolean()) {
               this.sb = new fL();
               if(!var7) {
                  break label65;
               }
            }

            var11 = (String)var1.readObject();
            if(var11.startsWith("y.graph")) {
               var11 = "y.view.Port";
            }

            this.sb = (fL)Class.forName(var11).newInstance();
            this.sb.a(var1);
         }

         label66: {
            if(var1.readBoolean()) {
               this.ec = new fL();
               if(!var7) {
                  break label66;
               }
            }

            var11 = (String)var1.readObject();
            if(var11.startsWith("y.graph")) {
               var11 = "y.view.Port";
            }

            this.ec = (fL)Class.forName(var11).newInstance();
            this.ec.a(var1);
         }

         this.setPorts(this.sb, this.ec);
      } catch (IllegalAccessException var8) {
         throw new y.e.a("Could not construct Port!");
      } catch (InstantiationException var9) {
         throw new y.e.a("Could not instantiate Port!");
      }
   }

   static {
      wb = Color.orange;
      lb = dr.e;
      ub = Color.green;
   }
}
