package y.h;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.RenderingHints.Key;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.awt.geom.Rectangle2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import y.h.cV;
import y.h.fj;
import y.h.go;
import y.h.gp;
import y.h.hC;
import y.h.hk;

public class gn extends fj {
   public static final Key KEY_SLOPPY_RECT_PAINTING = new go();
   public static final Object VALUE_SLOPPY_RECT_PAINTING_OFF = new gp();
   public static final byte RECT = 0;
   public static final byte ROUND_RECT = 1;
   public static final byte ELLIPSE = 2;
   public static final byte PARALLELOGRAM = 3;
   public static final byte HEXAGON = 4;
   public static final byte TRIANGLE = 5;
   public static final byte RECT_3D = 6;
   public static final byte OCTAGON = 7;
   public static final byte DIAMOND = 8;
   public static final byte TRAPEZOID = 9;
   public static final byte TRAPEZOID_2 = 10;
   protected Shape shape;
   private byte t;
   private static final double cb = 5.0D;
   private static final double bb = 1.2217304763960306D;
   private static Color ab = new Color(179, 166, 145);
   private byte s;
   private byte r;
   private Color v;
   private static final double u = 0.7D;

   public gn() {
      this((byte)0, 0.0D, 0.0D, "");
   }

   public gn(byte var1) {
      this(var1, 0.0D, 0.0D, "");
   }

   public gn(byte var1, double var2, double var4, String var6) {
      super(var2, var4, var6);
      this.s = 0;
      this.r = 0;
      this.v = ab;
      this.setShapeType(var1);
   }

   public gn(fj var1) {
      super(var1);
      this.s = 0;
      this.r = 0;
      this.v = ab;
      if(var1 instanceof gn) {
         gn var2 = (gn)var1;
         this.setShapeType(var2.getShapeType());
         this.v = var2.v;
         this.r = var2.r;
         this.s = var2.s;
         if(!fj.z) {
            return;
         }
      }

      this.setShapeType((byte)0);
   }

   public fj createCopy(fj var1) {
      return new gn(var1);
   }

   public void setCenter(double var1, double var3) {
      this.b(var1 - this.getWidth() / 2.0D, var3 - this.getHeight() / 2.0D);
   }

   public void setLocation(double var1, double var3) {
      this.b(var1, var3);
   }

   private void b(double var1, double var3) {
      if(this.shape instanceof RectangularShape) {
         super.setLocation(var1, var3);
         ((RectangularShape)this.shape).setFrame(this.x, this.y, this.width, this.height);
         if(!fj.z) {
            return;
         }
      }

      if(this.shape instanceof GeneralPath) {
         ((GeneralPath)this.shape).transform(AffineTransform.getTranslateInstance(var1 - this.x, var3 - this.y));
         super.setLocation(var1, var3);
      }

   }

   public void moveBy(double var1, double var3) {
      this.b(this.getX() + var1, this.getY() + var3);
   }

   public void setSize(double var1, double var3) {
      boolean var10 = fj.z;
      if(var1 != this.width || var3 != this.height) {
         if(this.shape instanceof RectangularShape) {
            super.setSize(var1, var3);
            ((RectangularShape)this.shape).setFrame(this.x, this.y, var1, var3);
            if(!var10) {
               return;
            }
         }

         if(this.shape instanceof GeneralPath) {
            if(this.width == 0.0D || this.height == 0.0D) {
               super.setSize(var1, var3);
               this.setShapeType(this.getShapeType());
               if(!var10) {
                  return;
               }
            }

            double var5 = this.x + this.width / 2.0D;
            double var7 = this.y + this.height / 2.0D;
            AffineTransform var9 = AffineTransform.getTranslateInstance(var5, var7);
            var9.scale(var1 / this.width, var3 / this.height);
            var9.translate(-var5, -var7);
            ((GeneralPath)this.shape).transform(var9);
            super.setSize(var1, var3);
            if(!var10) {
               return;
            }
         }

         super.setSize(var1, var3);
      }
   }

   private double e() {
      return this.width / 2.0D;
   }

   public void setShapeType(byte var1) {
      GeneralPath var2;
      switch(var1) {
      case 0:
      case 6:
         this.shape = new Double(this.x, this.y, this.width, this.height);
         break;
      case 1:
         this.shape = new java.awt.geom.RoundRectangle2D.Double(this.x, this.y, this.width, this.height, 8.0D, 8.0D);
         break;
      case 2:
         this.shape = new java.awt.geom.Ellipse2D.Double(this.x, this.y, this.width, this.height);
         break;
      case 3:
         var2 = new GeneralPath(0, 5);
         var2.moveTo((float)(this.x + this.width * 0.1D), (float)this.y);
         var2.lineTo((float)(this.x + this.width), (float)this.y);
         var2.lineTo((float)(this.x + this.width * 0.9D), (float)(this.y + this.height));
         var2.lineTo((float)this.x, (float)(this.y + this.height));
         var2.closePath();
         this.shape = var2;
         break;
      case 4:
         var2 = new GeneralPath(0, 6);
         var2.moveTo((float)this.x, (float)(this.y + this.height / 2.0D));
         var2.lineTo((float)(this.x + this.width * 0.1D), (float)this.y);
         var2.lineTo((float)(this.x + this.width * 0.9D), (float)this.y);
         var2.lineTo((float)(this.x + this.width), (float)(this.y + this.height / 2.0D));
         var2.lineTo((float)(this.x + this.width * 0.9D), (float)(this.y + this.height));
         var2.lineTo((float)(this.x + this.width * 0.1D), (float)(this.y + this.height));
         var2.closePath();
         this.shape = var2;
         break;
      case 5:
         var2 = new GeneralPath(0, 3);
         var2.moveTo((float)(this.x + this.width / 2.0D), (float)this.y);
         var2.lineTo((float)(this.x + this.width), (float)(this.y + this.height));
         var2.lineTo((float)this.x, (float)(this.y + this.height));
         var2.closePath();
         this.shape = var2;
         break;
      case 7:
         double var3 = Math.sqrt(2.0D);
         double var5 = this.width / (2.0D + var3);
         double var7 = this.height / (2.0D + var3);
         var2 = new GeneralPath(0, 8);
         var2.moveTo((float)this.x, (float)(this.y + var7));
         var2.lineTo((float)(this.x + var5), (float)this.y);
         var2.lineTo((float)(this.x + this.width - var5), (float)this.y);
         var2.lineTo((float)(this.x + this.width), (float)(this.y + var7));
         var2.lineTo((float)(this.x + this.width), (float)(this.y + this.height - var7));
         var2.lineTo((float)(this.x + this.width - var5), (float)(this.y + this.height));
         var2.lineTo((float)(this.x + var5), (float)(this.y + this.height));
         var2.lineTo((float)this.x, (float)(this.y + this.height - var7));
         var2.closePath();
         this.shape = var2;
         break;
      case 8:
         var2 = new GeneralPath(0, 4);
         var2.moveTo((float)this.x, (float)(this.y + this.height * 0.5D));
         var2.lineTo((float)(this.x + this.width * 0.5D), (float)this.y);
         var2.lineTo((float)(this.x + this.width), (float)(this.y + this.height * 0.5D));
         var2.lineTo((float)(this.x + this.width * 0.5D), (float)(this.y + this.height));
         var2.closePath();
         this.shape = var2;
         break;
      case 9:
         var2 = new GeneralPath(0, 4);
         var2.moveTo((float)this.x, (float)(this.y + this.height));
         var2.lineTo((float)(this.x + this.width * 0.25D), (float)this.y);
         var2.lineTo((float)(this.x + this.width * 0.75D), (float)this.y);
         var2.lineTo((float)(this.x + this.width), (float)(this.y + this.height));
         var2.closePath();
         this.shape = var2;
         break;
      case 10:
         var2 = new GeneralPath(0, 4);
         var2.moveTo((float)this.x, (float)this.y);
         var2.lineTo((float)(this.x + this.width), (float)this.y);
         var2.lineTo((float)(this.x + this.width * 0.75D), (float)(this.y + this.height));
         var2.lineTo((float)(this.x + this.width * 0.25D), (float)(this.y + this.height));
         var2.closePath();
         this.shape = var2;
      }

      this.t = var1;
      this.setEdgesDirty();
   }

   public byte getShapeType() {
      return this.t;
   }

   public Color getDropShadowColor() {
      return this.v;
   }

   public void setDropShadowColor(Color var1) {
      this.v = var1;
   }

   public byte getDropShadowOffsetY() {
      return this.r;
   }

   public void setDropShadowOffsetY(byte var1) {
      this.r = var1;
   }

   public byte getDropShadowOffsetX() {
      return this.s;
   }

   public void setDropShadowOffsetX(byte var1) {
      this.s = var1;
   }

   public boolean isDropShadowVisible() {
      return this.v != null && (this.s != 0 || this.r != 0);
   }

   void b(Graphics2D var1) {
      boolean var4 = fj.z;
      if(VALUE_SLOPPY_RECT_PAINTING_OFF.equals(var1.getRenderingHint(KEY_SLOPPY_RECT_PAINTING))) {
         label21: {
            Color var2 = this.getFillColor();
            if(b(this, var1)) {
               var1.setColor(getSloppySelectionColor());
               var1.fill(this.shape);
               if(!var4) {
                  break label21;
               }
            }

            if(var2 != null) {
               var1.setColor(var2);
               var1.fill(this.shape);
            }
         }

         Color var3 = this.getLineColor();
         if(var3 == null) {
            return;
         }

         var1.setColor(var3);
         var1.draw(this.shape);
         if(!var4) {
            return;
         }
      }

      super.b(var1);
   }

   protected void paintNode(Graphics2D var1) {
      if(b(this, var1)) {
         this.paintHotSpots(var1);
      }

      if(hk.d(var1)) {
         this.paintShadow(var1);
      }

      this.paintFilledShape(var1);
      if(b(var1, false)) {
         this.paintPorts(var1);
      }

      if(c(var1, false)) {
         this.paintText(var1);
      }

      this.paintShapeBorder(var1);
   }

   protected void paintShapeBorder(Graphics2D var1) {
      boolean var7 = fj.z;
      byte var2 = this.getShapeType();
      Color var3;
      if(var2 == 6) {
         var3 = this.getFillColor();
         if(var3 == null) {
            return;
         }

         var1.setColor(var3);
         this.paint3DBorder(var1, true);
         if(!var7) {
            return;
         }
      }

      var3 = this.getLineColor();
      if(var3 != null) {
         Stroke var4;
         label28: {
            var4 = var1.getStroke();
            var1.setStroke(this.getLineType());
            var1.setColor(var3);
            if(var2 == 2) {
               cV var5 = (cV)var1.getRenderingHint(hk.z);
               Object var6 = var1.getRenderingHint(RenderingHints.KEY_ANTIALIASING);
               if(!RenderingHints.VALUE_ANTIALIAS_ON.equals(var6) && (var5 == null || !var5.b())) {
                  var1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                  var1.draw(this.shape);
                  var1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, var6);
                  if(!var7) {
                     break label28;
                  }
               }

               var1.draw(this.shape);
               if(!var7) {
                  break label28;
               }
            }

            var1.draw(this.shape);
         }

         var1.setStroke(var4);
      }

   }

   protected void paintFilledShape(Graphics2D var1) {
      Color var2 = this.getFillColor();
      if(var2 != null && !this.isTransparent()) {
         label30: {
            boolean var3 = b(this, var1);
            Color var4 = this.getFillColor2();
            if(var4 != null && hk.c(var1)) {
               if(var3) {
                  var4 = this.createSelectionColor(var4);
                  var2 = this.createSelectionColor(var2);
               }

               var1.setPaint(new GradientPaint((float)(this.x + this.width / 3.0D), (float)this.y, var2, (float)(this.x + this.width), (float)this.y, var4, true));
               if(!fj.z) {
                  break label30;
               }
            }

            var1.setColor(var3?this.createSelectionColor(var2):var2);
         }

         var1.fill(this.shape);
      }

   }

   protected Color createSelectionColor(Color var1) {
      return new Color(Math.max((int)((double)var1.getRed() * 0.7D), 0), Math.max((int)((double)var1.getGreen() * 0.7D), 0), Math.max((int)((double)var1.getBlue() * 0.7D), 0), var1.getAlpha());
   }

   protected void paint3DBorder(Graphics2D var1, boolean var2) {
      Paint var3;
      Color var5;
      Color var6;
      label23: {
         var3 = var1.getPaint();
         Color var4 = var1.getColor();
         var5 = var4.brighter();
         var6 = var4.darker();
         if(!var2) {
            var1.setColor(var6);
            if(!fj.z) {
               break label23;
            }
         }

         if(var3 != var4) {
            var1.setColor(var4);
         }
      }

      var1.setColor(var2?var5:var6);
      Double var7 = hC.a().k;
      var7.setFrame(this.x, this.y, 1.0D, this.height);
      var1.fill(var7);
      var7.setFrame(this.x + 1.0D, this.y, this.width - 2.0D, 1.0D);
      var1.fill(var7);
      var1.setColor(var2?var6:var5);
      var7.setFrame(this.x + 1.0D, this.y + this.height - 1.0D, this.width - 1.0D, 1.0D);
      var1.fill(var7);
      var7.setFrame(this.x + this.width - 1.0D, this.y, 1.0D, this.height - 1.0D);
      var1.fill(var7);
      var1.setPaint(var3);
   }

   protected void paintShadow(Graphics2D var1) {
      if(this.v != null && (this.s != 0 || this.r != 0)) {
         Color var2 = var1.getColor();
         AffineTransform var3 = var1.getTransform();
         var1.setColor(this.v);
         var1.translate(this.s, this.r);
         var1.fill(this.shape);
         var1.setColor(var2);
         var1.setTransform(var3);
      }
   }

   public boolean contains(double var1, double var3) {
      if(!this.isTransparent()) {
         return this.shape.contains(var1, var3);
      } else {
         Double var5 = hC.a().k;
         var5.setRect(var1 - 5.0D, var3 - 5.0D, 10.0D, 10.0D);
         return this.shape.intersects(var5) && (!this.shape.contains(var1 - 5.0D, var3 - 5.0D) || !this.shape.contains(var1 + 5.0D, var3 - 5.0D) || !this.shape.contains(var1 - 5.0D, var3 + 5.0D) || !this.shape.contains(var1 + 5.0D, var3 + 5.0D));
      }
   }

   public boolean findIntersection(double var1, double var3, double var5, double var7, Point2D var9) {
      boolean var22 = fj.z;
      if(var1 == var5 && var3 == var7) {
         return false;
      } else if(this.contains(var1, var3) && !this.contains(var5, var7)) {
         if(this.t == 2 && var1 == this.getCenterX() && var3 == this.getCenterY()) {
            double var14;
            double var16;
            label55: {
               double var10 = var5 - this.getCenterX();
               double var12 = var7 - this.getCenterY();
               if(this.width < 1.0E-6D || this.height < 1.0E-6D) {
                  var14 = 0.0D;
                  var16 = 0.0D;
                  if(!var22) {
                     break label55;
                  }
               }

               double var18 = this.width / this.height;
               double var20 = 1.0D / Math.sqrt(var10 * var10 + var12 * var12 * var18 * var18);
               var14 = var10 * this.width * 0.5D * var20;
               var16 = var18 * var12 * this.height * 0.5D * var20;
            }

            var9.setLocation(this.getCenterX() + var14, this.getCenterY() + var16);
            if(!var22) {
               return true;
            }
         }

         if(this.t == 0 && var1 == this.getCenterX() && var3 == this.getCenterY()) {
            if(this.contains(var5, var7)) {
               return false;
            } else {
               return this.findBBIntersection(var1, var3, var5, var7, var9);
            }
         } else {
            super.findIntersection(var1, var3, var5, var7, var9);
            return true;
         }
      } else {
         return false;
      }
   }

   public void calcUnionRect(Rectangle2D var1) {
      boolean var2 = fj.z;
      super.calcUnionRect(var1);
      if((this.s != 0 || this.r != 0) && this.v != null) {
         if(this.s > 0) {
            if(this.r > 0) {
               var1.add(this.x + this.width + (double)this.s, this.y + this.height + (double)this.r);
               if(!var2) {
                  return;
               }
            }

            var1.add(this.x + this.width + (double)this.s, this.y + (double)this.r);
            if(!var2) {
               return;
            }
         }

         if(this.r > 0) {
            var1.add(this.x + (double)this.s, this.y + this.height + (double)this.r);
            if(!var2) {
               return;
            }
         }

         var1.add(this.x + (double)this.s, this.y + (double)this.r);
      }

   }

   public void paintHotSpots(Graphics2D var1) {
      boolean var10 = fj.z;
      if((this.s != 0 || this.r != 0) && this.v != null) {
         double var2;
         double var4;
         double var6;
         double var8;
         label26: {
            var2 = this.width;
            var4 = this.height;
            var6 = this.x;
            var8 = this.y;
            if(this.s >= 0) {
               this.width += (double)this.s;
               if(!var10) {
                  break label26;
               }
            }

            this.width -= (double)this.s;
            this.x += (double)this.s;
         }

         label21: {
            if(this.r >= 0) {
               this.height += (double)this.r;
               if(!var10) {
                  break label21;
               }
            }

            this.y += (double)this.r;
            this.height -= (double)this.r;
         }

         super.paintHotSpots(var1);
         this.width = var2;
         this.height = var4;
         this.x = var6;
         this.y = var8;
         if(!var10) {
            return;
         }
      }

      super.paintHotSpots(var1);
   }

   public byte hotSpotHit(double var1, double var3) {
      boolean var14 = fj.z;
      byte var5;
      if((this.s != 0 || this.r != 0) && this.v != null) {
         double var6;
         double var8;
         double var10;
         double var12;
         label23: {
            var6 = this.width;
            var8 = this.height;
            var10 = this.x;
            var12 = this.y;
            if(this.s >= 0) {
               this.width += (double)this.s;
               if(!var14) {
                  break label23;
               }
            }

            this.width -= (double)this.s;
            this.x += (double)this.s;
         }

         label18: {
            if(this.r >= 0) {
               this.height += (double)this.r;
               if(!var14) {
                  break label18;
               }
            }

            this.y += (double)this.r;
            this.height -= (double)this.r;
         }

         var5 = super.hotSpotHit(var1, var3);
         this.width = var6;
         this.height = var8;
         this.x = var10;
         this.y = var12;
         return var5;
      } else {
         var5 = super.hotSpotHit(var1, var3);
         return var5;
      }
   }

   public void write(ObjectOutputStream var1) {
      var1.writeByte(1);
      super.write(var1);
      var1.writeByte(this.t);
      var1.writeByte(this.s);
      var1.writeByte(this.r);
      var1.writeObject(this.v);
   }

   public void read(ObjectInputStream var1) {
      boolean var2 = fj.z;
      switch(var1.readByte()) {
      case 0:
         super.read(var1);
         this.setShapeType(var1.readByte());
         if(!var2) {
            break;
         }
      case 1:
         super.read(var1);
         this.setShapeType(var1.readByte());
         this.s = var1.readByte();
         this.r = var1.readByte();
         this.v = (Color)var1.readObject();
         if(var2) {
            throw new y.e.a();
         }
         break;
      default:
         throw new y.e.a();
      }

   }

   public static Map shapeTypeToStringMap() {
      HashMap var0 = new HashMap(23);
      var0.put(new Byte((byte)0), "Rectangle");
      var0.put(new Byte((byte)1), "Round Rect");
      var0.put(new Byte((byte)2), "Ellipse");
      var0.put(new Byte((byte)3), "Parallelogram");
      var0.put(new Byte((byte)4), "Hexagon");
      var0.put(new Byte((byte)5), "Triangle");
      var0.put(new Byte((byte)6), "Rectangle 3D");
      var0.put(new Byte((byte)7), "Octagon");
      var0.put(new Byte((byte)8), "Diamond");
      var0.put(new Byte((byte)9), "Trapezoid");
      var0.put(new Byte((byte)10), "Trapezoid 2");
      return var0;
   }
}
