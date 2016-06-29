package y.h;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import y.h.bu;
import y.h.dr;
import y.h.dy;
import y.h.eR;
import y.h.eU;
import y.h.fj;
import y.h.gn;

public class gd extends gn {
   private List a;
   private fj b;

   public gd() {
      this.a = new ArrayList();
      this.a = new ArrayList();
      this.b = null;
   }

   public gd(fj var1) {
      boolean var6 = fj.z;
      super(var1);
      this.a = new ArrayList();
      this.a = new ArrayList();
      if(var1 instanceof gd) {
         gd var2 = (gd)var1;
         int var3 = 0;

         while(var3 < var2.a()) {
            fj var4 = var2.a(var3);
            fj var5 = var4.createCopy();
            this.a.add(var5);
            if(var4 == var2.e()) {
               this.b(var5);
            }

            ++var3;
            if(var6) {
               break;
            }
         }
      }

   }

   public fj createCopy(fj var1) {
      gd var2 = new gd(var1);
      return var2;
   }

   public void a(fj var1) {
      this.a.add(var1);
   }

   public int a() {
      return this.a.size();
   }

   public fj a(int var1) {
      return (fj)this.a.get(var1);
   }

   public fj e() {
      return this.b;
   }

   public void b(fj var1) {
      fj var2;
      label26: {
         var2 = this.b;
         if(var1 == this || var1 == null) {
            this.b = null;
            if(!fj.z) {
               break label26;
            }
         }

         this.b = var1;
      }

      y.c.q var3 = this.getNode();
      this.b(var3);
      if(var3 != null && this.b != var2) {
         bu var4 = this.d();
         if(var4 != null) {
            var4.a(var3, "realizer", this, this);
         }
      }

   }

   void b(y.c.q var1) {
      super.b(var1);
      if(this.b != null) {
         this.b.b(var1);
      }

   }

   public void setFillColor(Color var1) {
      if(this.b == null) {
         super.setFillColor(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b.setFillColor(var1);
   }

   public Color getFillColor() {
      return this.b == null?super.getFillColor():this.b.getFillColor();
   }

   public void setFillColor2(Color var1) {
      if(this.b == null) {
         super.setFillColor2(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b.setFillColor2(var1);
   }

   public Color getFillColor2() {
      return this.b == null?super.getFillColor2():this.b.getFillColor2();
   }

   public void setLineColor(Color var1) {
      if(this.b == null) {
         super.setLineColor(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b.setLineColor(var1);
   }

   public Color getLineColor() {
      return this.b == null?super.getLineColor():this.b.getLineColor();
   }

   public void setLineType(dr var1) {
      if(this.b == null) {
         super.setLineType(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b.setLineType(var1);
   }

   public dr getLineType() {
      return this.b == null?super.getLineType():this.b.getLineType();
   }

   public void setTransparent(boolean var1) {
      if(this.b == null) {
         super.setTransparent(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b.setTransparent(var1);
   }

   public boolean isTransparent() {
      return this.b == null?super.isTransparent():this.b.isTransparent();
   }

   public void setShapeType(byte var1) {
      if(this.b instanceof gn) {
         ((gn)this.b).setShapeType(var1);
         if(!fj.z) {
            return;
         }
      }

      super.setShapeType(var1);
   }

   public byte getShapeType() {
      return this.b instanceof gn?((gn)this.b).getShapeType():super.getShapeType();
   }

   public void setLabelText(String var1) {
      if(this.b == null) {
         super.setLabelText(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b.setLabelText(var1);
   }

   public String getLabelText() {
      return this.b == null?super.getLabelText():this.b.getLabelText();
   }

   public eR createNodeLabel() {
      return this.b == null?super.createNodeLabel():this.b.createNodeLabel();
   }

   public void setLabel(eR var1) {
      if(this.b == null) {
         super.setLabel(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b.setLabel(var1);
   }

   public void addLabel(eR var1) {
      if(this.b == null) {
         super.addLabel(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b.addLabel(var1);
   }

   public void removeLabel(eR var1) {
      if(this.b == null) {
         super.removeLabel(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b.removeLabel(var1);
   }

   public void removeLabel(int var1) {
      if(this.b == null) {
         super.removeLabel(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b.removeLabel(var1);
   }

   public eR getLabel() {
      return this.b == null?super.getLabel():this.b.getLabel();
   }

   public eR getLabel(int var1) {
      return this.b == null?super.getLabel(var1):this.b.getLabel(var1);
   }

   public int labelCount() {
      return this.b == null?super.labelCount():this.b.labelCount();
   }

   public void addPort(eU var1) {
      if(this.b == null) {
         super.addPort(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b.addPort(var1);
   }

   public void removePort(int var1) {
      if(this.b == null) {
         super.removePort(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b.removePort(var1);
   }

   public void removePort(eU var1) {
      if(this.b == null) {
         super.removePort(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b.removePort(var1);
   }

   public eU getPort(int var1) {
      return this.b == null?super.getPort(var1):this.b.getPort(var1);
   }

   public int portCount() {
      return this.b == null?super.portCount():this.b.portCount();
   }

   public Iterator ports() {
      return this.b == null?super.ports():this.b.ports();
   }

   protected void invalidatePortPositions() {
      if(this.b == null) {
         super.invalidatePortPositions();
         if(!fj.z) {
            return;
         }
      }

      this.b.invalidatePortPositions();
   }

   eU b(Object var1) {
      return this.b == null?super.b(var1):this.b.b(var1);
   }

   Object c(eU var1) {
      return this.b == null?super.c(var1):this.b.c(var1);
   }

   public double getCenterX() {
      return this.b == null?super.getCenterX():this.b.getCenterX();
   }

   public double getCenterY() {
      return this.b == null?super.getCenterY():this.b.getCenterY();
   }

   public void setCenter(double var1, double var3) {
      if(this.b == null) {
         super.setCenter(var1, var3);
         if(!fj.z) {
            return;
         }
      }

      this.b.setCenter(var1, var3);
   }

   public void setCenterX(double var1) {
      if(this.b == null) {
         super.setCenterX(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b.setCenterX(var1);
   }

   public void setCenterY(double var1) {
      if(this.b == null) {
         super.setCenterY(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b.setCenterY(var1);
   }

   public double getX() {
      return this.b == null?super.getX():this.b.getX();
   }

   public double getY() {
      return this.b == null?super.getY():this.b.getY();
   }

   public void setLocation(double var1, double var3) {
      if(this.b == null) {
         super.setLocation(var1, var3);
         if(!fj.z) {
            return;
         }
      }

      this.b.setLocation(var1, var3);
   }

   public void setX(double var1) {
      if(this.b == null) {
         super.setX(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b.setX(var1);
   }

   public void setY(double var1) {
      if(this.b == null) {
         super.setY(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b.setY(var1);
   }

   public void moveBy(double var1, double var3) {
      if(this.b == null) {
         super.moveBy(var1, var3);
         if(!fj.z) {
            return;
         }
      }

      this.b.moveBy(var1, var3);
   }

   public double getWidth() {
      return this.b == null?super.getWidth():this.b.getWidth();
   }

   public double getHeight() {
      return this.b == null?super.getHeight():this.b.getHeight();
   }

   public void setFrame(double var1, double var3, double var5, double var7) {
      if(this.b == null) {
         super.setFrame(var1, var3, var5, var7);
         if(!fj.z) {
            return;
         }
      }

      this.b.setFrame(var1, var3, var5, var7);
   }

   public void setFrame(Rectangle2D var1) {
      if(this.b == null) {
         super.setFrame(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b.setFrame(var1);
   }

   public void setSize(double var1, double var3) {
      if(this.b == null) {
         super.setSize(var1, var3);
         if(!fj.z) {
            return;
         }
      }

      this.b.setSize(var1, var3);
   }

   public void setWidth(double var1) {
      if(this.b == null) {
         super.setWidth(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b.setWidth(var1);
   }

   public void setHeight(double var1) {
      if(this.b == null) {
         super.setHeight(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b.setHeight(var1);
   }

   public void setVisible(boolean var1) {
      if(this.b == null) {
         super.setVisible(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b.setVisible(var1);
   }

   public boolean isVisible() {
      return this.b == null?super.isVisible():this.b.isVisible();
   }

   public void setLayer(byte var1) {
      if(this.b == null) {
         super.setLayer(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b.setLayer(var1);
   }

   public byte getLayer() {
      return this.b == null?super.getLayer():this.b.getLayer();
   }

   public void setLayer(byte var1, boolean var2) {
      if(this.b == null) {
         super.setLayer(var1, var2);
         if(!fj.z) {
            return;
         }
      }

      this.b.setLayer(var1, var2);
   }

   public void setSelected(boolean var1) {
      if(this.b == null) {
         super.setSelected(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b.setSelected(var1);
   }

   public boolean isSelected() {
      return this.b == null?super.isSelected():this.b.isSelected();
   }

   public Double getBoundingBox() {
      return this.b == null?super.getBoundingBox():this.b.getBoundingBox();
   }

   public byte hotSpotHit(double var1, double var3) {
      return this.b == null?super.hotSpotHit(var1, var3):this.b.hotSpotHit(var1, var3);
   }

   public boolean findBBIntersection(double var1, double var3, double var5, double var7, Point2D var9) {
      return this.b == null?super.findBBIntersection(var1, var3, var5, var7, var9):this.b.findBBIntersection(var1, var3, var5, var7, var9);
   }

   public boolean findIntersection(double var1, double var3, double var5, double var7, Point2D var9) {
      return this.b == null?super.findIntersection(var1, var3, var5, var7, var9):this.b.findIntersection(var1, var3, var5, var7, var9);
   }

   public void calcUnionRect(Rectangle2D var1, byte var2) {
      if(this.b == null) {
         super.calcUnionRect(var1, var2);
         if(!fj.z) {
            return;
         }
      }

      this.b.calcUnionRect(var1, var2);
   }

   public void calcUnionRect(Rectangle2D var1) {
      if(this.b == null) {
         super.calcUnionRect(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b.calcUnionRect(var1);
   }

   public boolean intersects(double var1, double var3, double var5, double var7) {
      return this.b == null?super.intersects(var1, var3, var5, var7):this.b.intersects(var1, var3, var5, var7);
   }

   public boolean contains(double var1, double var3) {
      return this.b == null?super.contains(var1, var3):this.b.contains(var1, var3);
   }

   public boolean isInBox(double var1, double var3, double var5, double var7) {
      return this.b == null?super.isInBox(var1, var3, var5, var7):this.b.isInBox(var1, var3, var5, var7);
   }

   public y.c.D getPortCandidates(double var1) {
      return this.b == null?super.getPortCandidates(var1):this.b.getPortCandidates(var1);
   }

   public dy getMouseInputEditorProvider() {
      fj var1 = this.e();
      return var1 != null?var1.getMouseInputEditorProvider():null;
   }

   protected void paintNode(Graphics2D var1) {
      if(this.b == null) {
         super.paintNode(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b.paintNode(var1);
   }

   public void paintHotSpots(Graphics2D var1) {
      if(this.b == null) {
         super.paintHotSpots(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b.paintHotSpots(var1);
   }

   public void paintLayer(Graphics2D var1, byte var2) {
      if(this.b == null) {
         super.paintLayer(var1, var2);
         if(!fj.z) {
            return;
         }
      }

      this.b.paintLayer(var1, var2);
   }

   public void paintLayerSloppy(Graphics2D var1, byte var2) {
      if(this.b == null) {
         super.paintLayerSloppy(var1, var2);
         if(!fj.z) {
            return;
         }
      }

      this.b.paintLayerSloppy(var1, var2);
   }

   public void paintSloppy(Graphics2D var1) {
      if(this.b == null) {
         super.paintSloppy(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b.paintSloppy(var1);
   }

   public void paint(Graphics2D var1) {
      if(this.b == null) {
         super.paint(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b.paint(var1);
   }

   public void paintText(Graphics2D var1) {
      if(this.b == null) {
         super.paintText(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b.paintText(var1);
   }

   public void setEdgesDirty() {
      if(this.b == null) {
         super.setEdgesDirty();
         if(!fj.z) {
            return;
         }
      }

      this.b.setEdgesDirty();
   }

   public void write(ObjectOutputStream var1) {
      boolean var5 = fj.z;
      var1.writeByte(0);
      super.write(var1);
      var1.writeInt(this.a.size());
      int var2 = 0;
      int var3 = 0;

      while(true) {
         if(var3 < this.a.size()) {
            fj var4 = (fj)this.a.get(var3);
            var1.writeObject(y.e.h.a(var4.getClass().getName()));
            var4.write(var1);
            if(var5) {
               break;
            }

            if(var4 == this.b) {
               var2 = var3;
            }

            ++var3;
            if(!var5) {
               continue;
            }
         }

         var1.writeInt(var2);
         break;
      }

   }

   public void read(ObjectInputStream var1) {
      boolean var7 = fj.z;
      byte var2 = var1.readByte();
      if(var2 != 0) {
         throw new y.e.a((byte)0, var2);
      } else {
         super.read(var1);
         int var3 = var1.readInt();
         int var4 = 0;

         while(true) {
            if(var4 < var3) {
               try {
                  Class var5 = Class.forName(y.e.h.b((String)var1.readObject()));
                  fj var6 = (fj)var5.newInstance();
                  var6.b(this.getNode());
                  var6.read(var1);
                  var6.b((y.c.q)null);
                  this.a(var6);
               } catch (InstantiationException var8) {
                  throw new IOException(var8.getMessage());
               } catch (IllegalAccessException var9) {
                  throw new IOException(var9.getMessage());
               }

               if(var7) {
                  break;
               }

               ++var4;
               if(!var7) {
                  continue;
               }
            }

            this.b(this.a(var1.readInt()));
            break;
         }

      }
   }
}
