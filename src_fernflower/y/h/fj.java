package y.h;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import y.h.aB;
import y.h.bu;
import y.h.dr;
import y.h.dy;
import y.h.eR;
import y.h.eU;
import y.h.gt;
import y.h.hC;
import y.h.hH;
import y.h.hk;

public abstract class fj implements y.f.am {
   private static final Color l = new Color(204, 204, 255);
   public static final byte HOTSPOT_NW = 0;
   public static final byte HOTSPOT_N = 1;
   public static final byte HOTSPOT_NE = 2;
   public static final byte HOTSPOT_SW = 3;
   public static final byte HOTSPOT_S = 4;
   public static final byte HOTSPOT_SE = 5;
   public static final byte HOTSPOT_W = 6;
   public static final byte HOTSPOT_E = 7;
   public static final byte HOTSPOT_NONE = 8;
   private Color g;
   private Color e;
   private Color c;
   private dr n;
   private boolean o;
   private boolean i;
   private boolean d;
   private ArrayList m;
   private List k;
   private Map f;
   private byte q;
   private static Color b;
   private static Color p;
   protected double x;
   protected double y;
   protected double width;
   protected double height;
   y.c.q j;
   public static boolean z;

   public fj() {
      this(0.0D, 0.0D, "");
   }

   public fj(double var1, double var3) {
      this(var1, var3, "");
   }

   public fj(double var1, double var3, String var5) {
      this.e = l;
      this.o = false;
      this.d = true;
      this.c = Color.black;
      this.n = dr.a;
      this.width = 30.0D;
      this.height = 30.0D;
      this.x = var1 - this.width / 2.0D;
      this.y = var3 - this.height / 2.0D;
      this.m = new ArrayList(1);
      this.b(var5);
      this.q = 0;
   }

   void b(String var1) {
      eR var2 = this.createNodeLabel();
      var2.setText(var1);
      this.setLabel(var2);
   }

   public fj(fj var1) {
      fj var10000;
      boolean var6;
      label35: {
         var6 = z;
         super();
         this.e = var1.e;
         this.g = var1.g;
         this.o = var1.o;
         this.c = var1.c;
         this.width = var1.width;
         this.height = var1.height;
         this.x = var1.x;
         this.y = var1.y;
         this.n = var1.n;
         this.d = var1.d;
         int var2 = var1.portCount();
         if(var2 > 0) {
            this.k = new ArrayList(var2);
            this.f = new HashMap();
            Iterator var3 = var1.ports();

            while(var3.hasNext()) {
               eU var4 = (eU)var3.next();
               eU var5 = var4.a();
               this.b(var5);
               var10000 = this;
               if(var6) {
                  break label35;
               }

               this.f.put(var5, var1.c(var4));
               if(var6) {
                  break;
               }
            }
         }

         var10000 = var1;
      }

      int var7 = var10000.labelCount();
      this.m = new ArrayList(var7);
      int var8 = 0;

      while(true) {
         if(var8 < var7) {
            this.addLabel((eR)var1.getLabel(var8).clone());
            ++var8;
            if(var6) {
               break;
            }

            if(!var6) {
               continue;
            }
         }

         this.i = var1.isSelected();
         this.q = 0;
         break;
      }

   }

   public fj createCopy() {
      return this.createCopy(this);
   }

   public abstract fj createCopy(fj var1);

   public y.c.q getNode() {
      return this.j;
   }

   public void setFillColor(Color var1) {
      this.e = var1;
   }

   public Color getFillColor() {
      return this.e;
   }

   public void setFillColor2(Color var1) {
      this.g = var1;
   }

   public Color getFillColor2() {
      return this.g;
   }

   public void setLineColor(Color var1) {
      this.c = var1;
   }

   public Color getLineColor() {
      return this.c;
   }

   public void setLineType(dr var1) {
      this.n = var1;
   }

   public dr getLineType() {
      return this.n;
   }

   public void setTransparent(boolean var1) {
      this.o = var1;
   }

   public boolean isTransparent() {
      return this.o;
   }

   public void setLabelText(String var1) {
      this.getLabel().setText(var1);
   }

   public void repaint() {
      y.c.q var1 = this.getNode();
      if(var1 != null) {
         y.c.i var2 = var1.e();
         if(var2 instanceof bu) {
            Double var3 = new Double(0.0D, 0.0D, -1.0D, -1.0D);
            this.calcUnionRect(var3);
            ((bu)var2).a(var3.x, var3.y, var3.width, var3.height);
         }
      }

   }

   public String getLabelText() {
      return this.getLabel().getText();
   }

   public eR createNodeLabel() {
      return new eR();
   }

   public void setLabel(eR var1) {
      if(this.m.size() == 0) {
         this.m.add(var1);
      } else {
         this.m.set(0, var1);
      }

      var1.a(this);
   }

   public void addLabel(eR var1) {
      this.m.add(var1);
      var1.a(this);
   }

   public void removeLabel(eR var1) {
      this.m.remove(var1);
   }

   public void removeLabel(int var1) {
      try {
         this.m.remove(var1);
      } catch (IndexOutOfBoundsException var3) {
         throw new IndexOutOfBoundsException("Index: " + var1 + ", Size: " + this.m.size());
      }
   }

   public eR getLabel() {
      if(this.labelCount() == 0) {
         this.addLabel(this.createNodeLabel());
      }

      return (eR)this.m.get(0);
   }

   public eR getLabel(int var1) {
      return (eR)this.m.get(var1);
   }

   public int labelCount() {
      return this.m.size();
   }

   public eU getPort(int var1) {
      if(this.k == null) {
         throw new IndexOutOfBoundsException("Index: " + var1 + ", Size: 0");
      } else {
         return (eU)this.k.get(var1);
      }
   }

   public void addPort(eU var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("null");
      } else {
         if(this.k == null) {
            this.k = new ArrayList(1);
            this.f = new HashMap();
         }

         if(!this.f.containsKey(var1)) {
            this.b(var1);
            this.f.put(var1, new Object());
         }

      }
   }

   private void b(eU var1) {
      this.k.add(var1);
      var1.a(this);
   }

   public void removePort(eU var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("null");
      } else {
         if(this.k != null) {
            int var2 = this.k.indexOf(var1);
            if(var2 > -1) {
               this.b(var2);
            }
         }

      }
   }

   public void removePort(int var1) {
      if(this.k == null) {
         throw new IndexOutOfBoundsException("Index: " + var1 + ", Size: 0");
      } else {
         if(var1 < this.k.size()) {
            this.b(var1);
         }

      }
   }

   private void b(int var1) {
      boolean var8 = z;
      eU var2 = (eU)this.k.remove(var1);
      Object var3 = this.f.remove(var2);
      y.c.q var4 = this.getNode();
      if(var4 == null) {
         var2.a((fj)null);
      } else {
         label61: {
            bu var5;
            y.c.e var6;
            aB var7;
            label73: {
               if(var4.b() > 0) {
                  var5 = this.d();
                  var6 = var4.k();

                  while(var6.f()) {
                     var7 = var5.i(var6.a());
                     Object var10001 = var7.zb;
                     if(var8) {
                        if(var3 == var10001) {
                           var7.setDirty();
                        }

                        var6.g();
                        if(var8) {
                           break label61;
                        }
                        break label73;
                     }

                     if(var3 == var10001) {
                        var7.setDirty();
                     }

                     var6.g();
                     if(var8) {
                        break;
                     }
                  }
               }

               if(var4.c() <= 0) {
                  break label61;
               }

               var5 = this.d();
               var6 = var4.l();
            }

            while(var6.f()) {
               var7 = var5.i(var6.a());
               if(var8) {
                  return;
               }

               if(var3 == var7.vb) {
                  var7.setDirty();
               }

               var6.g();
               if(var8) {
                  break;
               }
            }
         }

         var2.a((fj)null);
      }

   }

   public int portCount() {
      return this.k == null?0:this.k.size();
   }

   Iterator ports() {
      return this.k == null?Collections.EMPTY_LIST.iterator():this.k.iterator();
   }

   Object c(eU var1) {
      return this.f == null?null:this.f.get(var1);
   }

   eU b(Object var1) {
      if(var1 != null && this.f != null && !this.f.isEmpty()) {
         Iterator var2 = this.f.entrySet().iterator();

         while(var2.hasNext()) {
            Entry var3 = (Entry)var2.next();
            if(var1 == var3.getValue()) {
               return (eU)var3.getKey();
            }
         }
      }

      return null;
   }

   public double getCenterX() {
      return this.x + this.width / 2.0D;
   }

   public double getCenterY() {
      return this.y + this.height / 2.0D;
   }

   public void setCenter(double var1, double var3) {
      this.x = var1 - this.width / 2.0D;
      this.y = var3 - this.height / 2.0D;
      this.setEdgesDirty();
      this.boundsChanged();
   }

   public void setCenterX(double var1) {
      this.setCenter(var1, this.getCenterY());
   }

   public void setCenterY(double var1) {
      this.setCenter(this.getCenterX(), var1);
   }

   public double getX() {
      return this.x;
   }

   public double getY() {
      return this.y;
   }

   public void setLocation(double var1, double var3) {
      if(this.x != var1 || this.y != var3) {
         this.x = var1;
         this.y = var3;
         this.setEdgesDirty();
         this.boundsChanged();
      }
   }

   public void setX(double var1) {
      this.setLocation(var1, this.y);
   }

   public void setY(double var1) {
      this.setLocation(this.x, var1);
   }

   public void moveBy(double var1, double var3) {
      this.x += var1;
      this.y += var3;
      this.setEdgesDirty();
      this.boundsChanged();
   }

   public double getWidth() {
      return this.width;
   }

   public double getHeight() {
      return this.height;
   }

   public void setFrame(double var1, double var3, double var5, double var7) {
      this.setSize(var5, var7);
      this.setLocation(var1, var3);
   }

   public void setFrame(Rectangle2D var1) {
      this.setSize(var1.getWidth(), var1.getHeight());
      this.setLocation(var1.getX(), var1.getY());
   }

   public void setSize(double var1, double var3) {
      boolean var10 = z;
      double var5 = (this.width - var1) / 2.0D;
      double var7 = (this.height - var3) / 2.0D;
      this.x += var5;
      this.y += var7;
      this.width = var1;
      this.height = var3;
      int var9 = 0;

      while(true) {
         if(var9 < this.m.size()) {
            this.getLabel(var9).setOffsetDirty();
            ++var9;
            if(var10) {
               break;
            }

            if(!var10) {
               continue;
            }
         }

         this.setEdgesDirty();
         this.invalidatePortPositions();
         this.boundsChanged();
         break;
      }

   }

   protected void boundsChanged() {
   }

   protected void labelBoundsChanged(eR var1) {
   }

   public void setWidth(double var1) {
      this.setSize(var1, this.height);
   }

   public void setHeight(double var1) {
      this.setSize(this.width, var1);
   }

   public void setVisible(boolean var1) {
      this.d = var1;
   }

   public boolean isVisible() {
      return this.d;
   }

   public void setLayer(byte var1) {
      this.q = var1;
   }

   public byte getLayer() {
      return this.q;
   }

   public void setLayer(byte var1, boolean var2) {
      boolean var5 = z;
      if(var2 && this.getNode() != null) {
         bu var3 = (bu)this.getNode().e();
         y.c.e var4 = this.getNode().j();

         while(var4.f()) {
            var3.i(var4.a()).setLayer(var1);
            var4.g();
            if(var5) {
               return;
            }

            if(var5) {
               break;
            }
         }
      }

      this.setLayer(var1);
   }

   public void setSelected(boolean var1) {
      if(var1 != this.i) {
         this.i = var1;
         bu var2 = this.d();
         if(var2 != null) {
            var2.e(this.getNode());
         }

         this.c();
      }

   }

   void c() {
   }

   public boolean isSelected() {
      return this.i;
   }

   public static void setHotSpotColor(Color var0) {
      b = var0;
   }

   public static Color getHotSpotColor() {
      return b;
   }

   public static void setSloppySelectionColor(Color var0) {
      p = var0;
   }

   public static Color getSloppySelectionColor() {
      return p;
   }

   public y.h.a.a getAutoBoundsFeature() {
      return this instanceof y.h.a.a?(y.h.a.a)this:null;
   }

   public gt getSizeConstraintProvider() {
      return this instanceof gt?(gt)this:null;
   }

   public dy getMouseInputEditorProvider() {
      return this instanceof dy?(dy)this:null;
   }

   public Double getBoundingBox() {
      return new Double(this.x, this.y, this.width, this.height);
   }

   public byte hotSpotHit(double var1, double var3) {
      if(!this.isSelected()) {
         return (byte)8;
      } else if(var1 >= this.x - 6.0D && var1 <= this.x + this.width + 7.0D && var3 >= this.y - 6.0D && var3 <= this.y + this.height + 7.0D) {
         if(var1 >= this.x && var1 <= this.x + this.width && var3 >= this.y && var3 <= this.y + this.height) {
            return (byte)8;
         } else {
            if(var1 > this.x + this.width) {
               if(var3 < this.y) {
                  return (byte)2;
               }

               if(var3 > this.y + this.height) {
                  return (byte)5;
               }

               if(var3 >= this.y + this.height / 2.0D - 3.0D && var3 < this.y + this.height / 2.0D + 3.0D) {
                  return (byte)7;
               }
            } else if(var1 < this.x) {
               if(var3 < this.y) {
                  return (byte)0;
               }

               if(var3 > this.y + this.height) {
                  return (byte)3;
               }

               if(var3 >= this.y + this.height / 2.0D - 3.0D && var3 < this.y + this.height / 2.0D + 3.0D) {
                  return (byte)6;
               }
            } else if(var1 > this.x + this.width / 2.0D - 3.0D && var1 < this.x + this.width / 2.0D + 3.0D) {
               if(var3 > this.y + this.height) {
                  return (byte)4;
               }

               if(var3 < this.y) {
                  return (byte)1;
               }
            }

            return (byte)8;
         }
      } else {
         return (byte)8;
      }
   }

   public boolean findBBIntersection(double var1, double var3, double var5, double var7, Point2D var9) {
      boolean var20 = z;
      if(this.getCenterX() == var1 && this.getCenterY() == var3) {
         double var10 = var5 - this.getCenterX();
         double var12 = var7 - this.getCenterY();
         if(this.height < 1.0E-6D || this.width < 1.0E-6D) {
            var9.setLocation(this.getCenterX(), this.getCenterY());
            if(!var20) {
               return true;
            }
         }

         double var18;
         label32: {
            if(var12 > 0.0D) {
               var18 = 1.0D;
               if(!var20) {
                  break label32;
               }
            }

            var18 = -1.0D;
         }

         var12 = var18 * var12;
         double var14 = this.height / 2.0D * var10 / var12;
         if(Math.abs(var14) < this.width / 2.0D) {
            var9.setLocation(this.getCenterX() + var14, this.getCenterY() + var18 * this.height / 2.0D);
            if(!var20) {
               return true;
            }
         }

         label23: {
            var12 = var18 * var12;
            if(var10 > 0.0D) {
               var18 = 1.0D;
               if(!var20) {
                  break label23;
               }
            }

            var18 = -1.0D;
         }

         var10 = var18 * var10;
         double var16 = this.width / 2.0D * var12 / var10;
         var9.setLocation(this.getCenterX() + var18 * this.width / 2.0D, this.getCenterY() + var16);
         return true;
      } else {
         return false;
      }
   }

   public boolean findIntersection(double var1, double var3, double var5, double var7, Point2D var9) {
      boolean var20 = z;
      if(this.contains(var1, var3)) {
         if(this.contains(var5, var7)) {
            var9.setLocation(var5, var7);
            return false;
         }
      } else if(!this.contains(var5, var7)) {
         var9.setLocation(var1, var3);
         return false;
      }

      double var10 = Math.sqrt((var5 - var1) * (var5 - var1) + (var7 - var3) * (var7 - var3));
      if(!java.lang.Double.isNaN(var10) && !java.lang.Double.isInfinite(var10)) {
         double var12 = (var5 - var1) / 2.0D;
         double var14 = (var7 - var3) / 2.0D;
         double var16 = var1 + var12;
         double var18 = var3 + var14;

         boolean var10000;
         while(true) {
            if(var10 > 0.1D) {
               var10 /= 2.0D;
               var12 /= 2.0D;
               var14 /= 2.0D;
               var10000 = this.contains(var16, var18);
               if(var20) {
                  break;
               }

               if(var10000) {
                  var16 += var12;
                  var18 += var14;
                  if(!var20) {
                     continue;
                  }
               }

               var16 -= var12;
               var18 -= var14;
               if(!var20) {
                  continue;
               }
            }

            var9.setLocation(var16, var18);
            var10000 = true;
            break;
         }

         return var10000;
      } else {
         var9.setLocation(var1, var3);
         return true;
      }
   }

   public void calcUnionRect(Rectangle2D var1, byte var2) {
      if(var2 == this.getLayer()) {
         this.calcUnionRect(var1);
      }

   }

   public void calcUnionRect(Rectangle2D var1) {
      this.calcUnionRectImpl(var1);
      this.calcUnionRectLabels(var1);
      this.calcUnionRectPorts(var1);
   }

   protected void calcUnionRectImpl(Rectangle2D var1) {
      if(var1.getWidth() <= 0.0D) {
         var1.setFrame(this.x, this.y, this.width, this.height);
         if(!z) {
            return;
         }
      }

      double var2 = Math.min(this.x, var1.getX());
      double var4 = Math.max(this.x + this.width, var1.getX() + var1.getWidth());
      double var6 = Math.min(this.y, var1.getY());
      double var8 = Math.max(this.y + this.height, var1.getY() + var1.getHeight());
      var1.setFrame(var2, var6, var4 - var2, var8 - var6);
   }

   protected void calcUnionRectLabels(Rectangle2D var1) {
      boolean var3 = z;
      int var2 = this.m.size() - 1;

      while(var2 >= 0) {
         ((eR)this.m.get(var2)).calcUnionRect(var1);
         --var2;
         if(var3) {
            break;
         }
      }

   }

   protected void calcUnionRectPorts(Rectangle2D var1) {
      boolean var3 = z;
      if(this.portCount() > 0) {
         Iterator var2 = this.ports();

         while(var2.hasNext()) {
            ((eU)var2.next()).a(var1);
            if(var3) {
               break;
            }
         }
      }

   }

   public boolean intersects(double var1, double var3, double var5, double var7) {
      return var1 + var5 >= this.x && var1 <= this.x + this.width && var3 + var7 >= this.y && var3 <= this.y + this.height;
   }

   public boolean contains(double var1, double var3) {
      return var1 >= this.x && var1 <= this.x + this.width && var3 >= this.y && var3 <= this.y + this.height;
   }

   public boolean isInBox(double var1, double var3, double var5, double var7) {
      double var9 = this.getCenterX();
      double var11 = this.getCenterY();
      return var9 <= var1 + var5 && var9 >= var1 && var11 <= var3 + var7 && var11 >= var3;
   }

   public y.c.D getPortCandidates(double var1) {
      boolean var13 = z;
      double var3 = this.getCenterX() - (double)((int)(this.getWidth() / 2.0D / var1)) * var1;
      double var5 = this.getCenterY() - (double)((int)(this.getHeight() / 2.0D / var1)) * var1;
      y.c.D var7 = new y.c.D();
      java.awt.geom.Point2D.Double var8 = new java.awt.geom.Point2D.Double();
      double var9 = this.getHeight() / 10.0D;

      double var11;
      double var14;
      int var10000;
      label125:
      while(true) {
         double var15;
         var10000 = (var15 = var3 - (this.x + this.width)) == 0.0D?0:(var15 < 0.0D?-1:1);

         label122:
         while(var10000 < 0) {
            var14 = this.getY() + 1.0D;
            if(var13) {
               break label125;
            }

            var11 = var14;

            while(true) {
               if(var11 < this.getY() + this.getHeight()) {
                  label132: {
                     var10000 = this.contains(var3, var11);
                     if(var13) {
                        break;
                     }

                     if(var10000 != 0 && this.findIntersection(var3, var11, var3, var11 - var9, var8)) {
                        var7.add(new y.d.t(var8.getX(), var8.getY()));
                        if(!var13) {
                           break label132;
                        }
                     }

                     var11 += var9;
                     if(!var13) {
                        continue;
                     }
                  }
               }

               var11 = this.getY() + this.getHeight() - 1.0D;
               double var16;
               var10000 = (var16 = var11 - this.getY()) == 0.0D?0:(var16 < 0.0D?-1:1);
               break;
            }

            while(var10000 > 0) {
               var10000 = this.contains(var3, var11);
               if(var13) {
                  continue label122;
               }

               if(var10000 != 0 && this.findIntersection(var3, var11, var3, var11 + var9, var8)) {
                  var7.add(new y.d.t(var8.getX(), var8.getY()));
                  if(!var13) {
                     break;
                  }
               }

               var11 -= var9;
               if(var13) {
                  break;
               }

               double var17;
               var10000 = (var17 = var11 - this.getY()) == 0.0D?0:(var17 < 0.0D?-1:1);
            }

            var3 += var1;
            if(!var13) {
               continue label125;
            }
            break;
         }

         var14 = this.getWidth() / 10.0D;
         break;
      }

      var9 = var14;

      label82:
      do {
         double var18;
         var10000 = (var18 = var5 - (this.y + this.height)) == 0.0D?0:(var18 < 0.0D?-1:1);

         label79:
         while(true) {
            if(var10000 >= 0) {
               break label82;
            }

            var11 = this.getX() + 1.0D;

            while(true) {
               if(var11 < this.getX() + this.getWidth()) {
                  label137: {
                     var10000 = this.contains(var11, var5);
                     if(var13) {
                        break;
                     }

                     if(var10000 != 0 && this.findIntersection(var11, var5, var11 - var9, var5, var8)) {
                        var7.add(new y.d.t(var8.getX(), var8.getY()));
                        if(!var13) {
                           break label137;
                        }
                     }

                     var11 += var9;
                     if(!var13) {
                        continue;
                     }
                  }
               }

               var11 = this.getX() + this.getWidth() - 1.0D;
               double var19;
               var10000 = (var19 = var11 - this.getX()) == 0.0D?0:(var19 < 0.0D?-1:1);
               break;
            }

            while(true) {
               if(var10000 <= 0) {
                  break label79;
               }

               var10000 = this.contains(var11, var5);
               if(var13) {
                  break;
               }

               if(var10000 != 0 && this.findIntersection(var11, var5, var11 + var9, var5, var8)) {
                  var7.add(new y.d.t(var8.getX(), var8.getY()));
                  if(!var13) {
                     break label79;
                  }
               }

               var11 -= var9;
               if(var13) {
                  break label79;
               }

               double var20;
               var10000 = (var20 = var11 - this.getX()) == 0.0D?0:(var20 < 0.0D?-1:1);
            }
         }

         var5 += var1;
      } while(!var13);

      var7.add(new y.d.t(this.getCenterX(), this.getCenterY()));
      return var7;
   }

   protected abstract void paintNode(Graphics2D var1);

   public void paintHotSpots(Graphics2D var1) {
      var1.setColor(b);
      double var2 = this.width / 2.0D;
      double var4 = this.height / 2.0D;
      Double var6 = hC.a().k;
      var6.width = var6.height = 5.0D;
      var6.x = this.x - 6.0D;
      var6.y = this.y - 6.0D;
      var1.fill(var6);
      var6.y = this.y + var4 - 2.0D;
      var1.fill(var6);
      var6.y = this.y + this.height + 2.0D;
      var1.fill(var6);
      var6.x = this.x + var2 - 2.0D;
      var1.fill(var6);
      var6.y = this.y - 6.0D;
      var1.fill(var6);
      var6.x = this.x + this.width + 2.0D;
      var1.fill(var6);
      var6.y = this.y + var4 - 2.0D;
      var1.fill(var6);
      var6.y = this.y + this.height + 2.0D;
      var1.fill(var6);
   }

   public void paintLayer(Graphics2D var1, byte var2) {
      if(var2 == this.getLayer()) {
         this.paint(var1);
      }

   }

   public void paintLayerSloppy(Graphics2D var1, byte var2) {
      if(var2 == this.getLayer()) {
         this.paintSloppy(var1);
      }

   }

   public void paintSloppy(Graphics2D var1) {
      if(!this.b()) {
         this.b(var1);
         if(b(var1, true)) {
            this.paintPorts(var1);
         }

         if(c(var1, true)) {
            this.paintText(var1);
         }

      }
   }

   void b(Graphics2D var1) {
      label17: {
         if(b(this, var1)) {
            var1.setColor(p);
            var1.fillRect((int)this.x, (int)this.y, (int)this.width, (int)this.height);
            if(!z) {
               break label17;
            }
         }

         if(this.e != null) {
            var1.setColor(this.e);
            var1.fillRect((int)this.x, (int)this.y, (int)this.width, (int)this.height);
         }
      }

      if(this.c != null) {
         var1.setColor(this.c);
         var1.drawRect((int)this.x, (int)this.y, (int)this.width, (int)this.height);
      }

   }

   public void paint(Graphics2D var1) {
      if(!this.b()) {
         Color var2 = var1.getColor();
         Stroke var3 = var1.getStroke();
         this.paintNode(var1);
         var1.setColor(var2);
         var1.setStroke(var3);
      }
   }

   boolean b() {
      return this.width <= 0.0D || this.height <= 0.0D || !this.isVisible();
   }

   public void paintText(Graphics2D var1) {
      boolean var3 = z;
      int var2 = 0;

      while(var2 < this.m.size()) {
         this.getLabel(var2).paint(var1);
         ++var2;
         if(var3) {
            break;
         }
      }

   }

   public void paintPorts(Graphics2D var1) {
      boolean var3 = z;
      if(this.portCount() > 0) {
         Iterator var2 = this.ports();

         while(var2.hasNext()) {
            ((eU)var2.next()).a(var1);
            if(var3) {
               break;
            }
         }
      }

   }

   static boolean b(fj var0, Graphics2D var1) {
      return var0.isSelected() && hk.b(var1);
   }

   static boolean c(Graphics2D var0, boolean var1) {
      Object var2 = var0.getRenderingHint(hk.g);
      return var1?hk.i.equals(var2):!hk.j.equals(var2);
   }

   static boolean b(Graphics2D var0, boolean var1) {
      Object var2 = var0.getRenderingHint(hk.k);
      return var1?hk.m.equals(var2):!hk.n.equals(var2);
   }

   protected void invalidatePortPositions() {
      if(this.portCount() > 0) {
         Iterator var1 = this.ports();

         while(var1.hasNext()) {
            ((eU)var1.next()).i();
         }
      }

   }

   public void setEdgesDirty() {
      if(this.j != null) {
         y.c.d var1;
         aB var2;
         for(var1 = this.j.g(); var1 != null; var1 = var1.h()) {
            var2 = ((hH)var1).l;
            if(var2 != null) {
               var2.setDirty();
            }
         }

         for(var1 = this.j.f(); var1 != null; var1 = var1.g()) {
            var2 = ((hH)var1).l;
            if(var2 != null) {
               var2.setDirty();
            }
         }

      }
   }

   public void write(ObjectOutputStream var1) {
      boolean var3 = z;
      var1.writeByte(4);
      var1.writeInt(this.labelCount());
      int var2 = 0;

      while(true) {
         if(var2 < this.labelCount()) {
            this.getLabel(var2).write(var1);
            ++var2;
            if(var3) {
               break;
            }

            if(!var3) {
               continue;
            }
         }

         var1.writeObject(this.e);
         var1.writeObject(this.c);
         var1.writeObject(this.g);
         var1.writeFloat((float)this.width);
         var1.writeFloat((float)this.height);
         var1.writeFloat((float)this.x);
         var1.writeFloat((float)this.y);
         var1.writeBoolean(this.o);
         dr.a(var1, this.n);
         var1.writeBoolean(this.isVisible());
         break;
      }

   }

   public void read(ObjectInputStream var1) {
      label81: {
         boolean var5;
         eR var6;
         label80: {
            label84: {
               var5 = z;
               int var2;
               int var3;
               eR var4;
               switch(var1.readByte()) {
               case 0:
                  break label80;
               case 1:
                  break label84;
               case 2:
                  break;
               case 4:
                  var2 = var1.readInt();
                  this.m = new ArrayList(var2);
                  var3 = 0;

                  label67: {
                     while(var3 < var2) {
                        var4 = this.createNodeLabel();
                        this.addLabel(var4);
                        var4.read(var1);
                        ++var3;
                        if(var5) {
                           break label67;
                        }

                        if(var5) {
                           break;
                        }
                     }

                     this.e = (Color)var1.readObject();
                     this.c = (Color)var1.readObject();
                     this.g = (Color)var1.readObject();
                     this.setSize((double)var1.readFloat(), (double)var1.readFloat());
                     this.setLocation((double)var1.readFloat(), (double)var1.readFloat());
                     this.o = var1.readBoolean();
                     this.n = dr.a(var1);
                     this.d = var1.readBoolean();
                  }

                  if(!var5) {
                     break label81;
                  }
               case 3:
                  var2 = var1.readInt();
                  this.m = new ArrayList(var2);
                  var3 = 0;

                  label55: {
                     while(var3 < var2) {
                        var4 = this.createNodeLabel();
                        this.addLabel(var4);
                        var4.read(var1);
                        ++var3;
                        if(var5) {
                           break label55;
                        }

                        if(var5) {
                           break;
                        }
                     }

                     this.e = (Color)var1.readObject();
                     this.c = (Color)var1.readObject();
                     this.g = (Color)var1.readObject();
                     this.setSize((double)var1.readFloat(), (double)var1.readFloat());
                     this.setLocation((double)var1.readFloat(), (double)var1.readFloat());
                     this.o = var1.readBoolean();
                     this.n = dr.a(var1);
                  }

                  if(!var5) {
                     break label81;
                  }
                  break;
               default:
                  throw new y.e.a();
               }

               var2 = var1.readInt();
               this.m = new ArrayList(var2);
               var3 = 0;

               label43: {
                  while(var3 < var2) {
                     var4 = this.createNodeLabel();
                     this.addLabel(var4);
                     var4.read(var1);
                     ++var3;
                     if(var5) {
                        break label43;
                     }

                     if(var5) {
                        break;
                     }
                  }

                  this.e = (Color)var1.readObject();
                  this.c = (Color)var1.readObject();
                  this.g = (Color)var1.readObject();
                  this.setSize((double)var1.readFloat(), (double)var1.readFloat());
                  this.setLocation((double)var1.readFloat(), (double)var1.readFloat());
                  this.o = var1.readBoolean();
                  this.n = dr.a(var1.readByte(), var1.readByte());
               }

               if(!var5) {
                  break label81;
               }
            }

            this.m = new ArrayList(1);
            var6 = this.createNodeLabel();
            var6.read(var1);
            this.setLabel(var6);
            this.e = (Color)var1.readObject();
            this.c = (Color)var1.readObject();
            this.g = (Color)var1.readObject();
            this.setSize((double)var1.readFloat(), (double)var1.readFloat());
            this.setLocation((double)var1.readFloat(), (double)var1.readFloat());
            this.o = var1.readBoolean();
            this.n = dr.a(var1.readByte(), var1.readByte());
            if(!var5) {
               break label81;
            }
         }

         this.m = new ArrayList(1);
         var6 = this.createNodeLabel();
         var6.read(var1);
         this.setLabel(var6);
         this.e = (Color)var1.readObject();
         this.c = (Color)var1.readObject();
         this.setSize((double)var1.readFloat(), (double)var1.readFloat());
         this.setLocation((double)var1.readFloat(), (double)var1.readFloat());
         this.o = var1.readBoolean();
         this.n = dr.a(var1.readByte(), var1.readByte());
         if(var5) {
            throw new y.e.a();
         }
      }

      this.q = 0;
   }

   void b(y.c.q var1) {
      this.j = var1;
      this.invalidatePortPositions();
      this.setEdgesDirty();
   }

   bu d() {
      return this.j != null?(bu)this.j.e():null;
   }

   static {
      b = Color.lightGray;
      p = Color.gray;
   }
}
