package org.jfree.chart.renderer.xy;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.Serializable;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.LookupPaintScale;
import org.jfree.chart.renderer.PaintScale;
import org.jfree.chart.renderer.xy.AbstractXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.data.Range;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.RectangleAnchor;
import org.jfree.util.PublicCloneable;

public class XYBlockRenderer extends AbstractXYItemRenderer implements Serializable, Cloneable, XYItemRenderer {
   private double blockWidth = 1.0D;
   private double blockHeight = 1.0D;
   private RectangleAnchor blockAnchor;
   private double xOffset;
   private double yOffset;
   private PaintScale paintScale;

   public XYBlockRenderer() {
      this.blockAnchor = RectangleAnchor.CENTER;
      this.updateOffsets();
      this.paintScale = new LookupPaintScale();
   }

   public double getBlockWidth() {
      return this.blockWidth;
   }

   public void setBlockWidth(double var1) {
      if(var1 <= 0.0D) {
         throw new IllegalArgumentException("The \'width\' argument must be > 0.0");
      } else {
         this.blockWidth = var1;
         this.updateOffsets();
         this.notifyListeners(new RendererChangeEvent(this));
      }
   }

   public double getBlockHeight() {
      return this.blockHeight;
   }

   public void setBlockHeight(double var1) {
      if(var1 <= 0.0D) {
         throw new IllegalArgumentException("The \'height\' argument must be > 0.0");
      } else {
         this.blockHeight = var1;
         this.updateOffsets();
         this.notifyListeners(new RendererChangeEvent(this));
      }
   }

   public RectangleAnchor getBlockAnchor() {
      return this.blockAnchor;
   }

   public void setBlockAnchor(RectangleAnchor var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'anchor\' argument.");
      } else if(!this.blockAnchor.equals(var1)) {
         this.blockAnchor = var1;
         this.updateOffsets();
         this.notifyListeners(new RendererChangeEvent(this));
      }
   }

   public PaintScale getPaintScale() {
      return this.paintScale;
   }

   public void setPaintScale(PaintScale var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'scale\' argument.");
      } else {
         this.paintScale = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }
   }

   private void updateOffsets() {
      if(this.blockAnchor.equals(RectangleAnchor.BOTTOM_LEFT)) {
         this.xOffset = 0.0D;
         this.yOffset = 0.0D;
      } else if(this.blockAnchor.equals(RectangleAnchor.BOTTOM)) {
         this.xOffset = -this.blockWidth / 2.0D;
         this.yOffset = 0.0D;
      } else if(this.blockAnchor.equals(RectangleAnchor.BOTTOM_RIGHT)) {
         this.xOffset = -this.blockWidth;
         this.yOffset = 0.0D;
      } else if(this.blockAnchor.equals(RectangleAnchor.LEFT)) {
         this.xOffset = 0.0D;
         this.yOffset = -this.blockHeight / 2.0D;
      } else if(this.blockAnchor.equals(RectangleAnchor.CENTER)) {
         this.xOffset = -this.blockWidth / 2.0D;
         this.yOffset = -this.blockHeight / 2.0D;
      } else if(this.blockAnchor.equals(RectangleAnchor.RIGHT)) {
         this.xOffset = -this.blockWidth;
         this.yOffset = -this.blockHeight / 2.0D;
      } else if(this.blockAnchor.equals(RectangleAnchor.TOP_LEFT)) {
         this.xOffset = 0.0D;
         this.yOffset = -this.blockHeight;
      } else if(this.blockAnchor.equals(RectangleAnchor.TOP)) {
         this.xOffset = -this.blockWidth / 2.0D;
         this.yOffset = -this.blockHeight;
      } else if(this.blockAnchor.equals(RectangleAnchor.TOP_RIGHT)) {
         this.xOffset = -this.blockWidth;
         this.yOffset = -this.blockHeight;
      }

   }

   public Range findDomainBounds(XYDataset var1) {
      if(var1 != null) {
         Range var2 = DatasetUtilities.findDomainBounds(var1, false);
         return new Range(var2.getLowerBound() + this.xOffset, var2.getUpperBound() + this.blockWidth + this.xOffset);
      } else {
         return null;
      }
   }

   public Range findRangeBounds(XYDataset var1) {
      if(var1 != null) {
         Range var2 = DatasetUtilities.findRangeBounds(var1, false);
         return new Range(var2.getLowerBound() + this.yOffset, var2.getUpperBound() + this.blockHeight + this.yOffset);
      } else {
         return null;
      }
   }

   public void drawItem(Graphics2D var1, XYItemRendererState var2, Rectangle2D var3, PlotRenderingInfo var4, XYPlot var5, ValueAxis var6, ValueAxis var7, XYDataset var8, int var9, int var10, CrosshairState var11, int var12) {
      double var13 = var8.getXValue(var9, var10);
      double var15 = var8.getYValue(var9, var10);
      double var17 = 0.0D;
      if(var8 instanceof XYZDataset) {
         var17 = ((XYZDataset)var8).getZValue(var9, var10);
      }

      Paint var19 = this.paintScale.getPaint(var17);
      double var20 = var6.valueToJava2D(var13 + this.xOffset, var3, var5.getDomainAxisEdge());
      double var22 = var7.valueToJava2D(var15 + this.yOffset, var3, var5.getRangeAxisEdge());
      double var24 = var6.valueToJava2D(var13 + this.blockWidth + this.xOffset, var3, var5.getDomainAxisEdge());
      double var26 = var7.valueToJava2D(var15 + this.blockHeight + this.yOffset, var3, var5.getRangeAxisEdge());
      PlotOrientation var29 = var5.getOrientation();
      Double var28;
      if(var29.equals(PlotOrientation.HORIZONTAL)) {
         var28 = new Double(Math.min(var22, var26), Math.min(var20, var24), Math.abs(var26 - var22), Math.abs(var20 - var24));
      } else {
         var28 = new Double(Math.min(var20, var24), Math.min(var22, var26), Math.abs(var24 - var20), Math.abs(var26 - var22));
      }

      var1.setPaint(var19);
      var1.fill(var28);
      var1.setStroke(new BasicStroke(1.0F));
      var1.draw(var28);
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof XYBlockRenderer)) {
         return false;
      } else {
         XYBlockRenderer var2 = (XYBlockRenderer)var1;
         return this.blockHeight != var2.blockHeight?false:(this.blockWidth != var2.blockWidth?false:(!this.blockAnchor.equals(var2.blockAnchor)?false:(!this.paintScale.equals(var2.paintScale)?false:super.equals(var1))));
      }
   }

   public Object clone() {
      XYBlockRenderer var1 = (XYBlockRenderer)super.clone();
      if(this.paintScale instanceof PublicCloneable) {
         PublicCloneable var2 = (PublicCloneable)this.paintScale;
         var1.paintScale = (PaintScale)var2.clone();
      }

      return var1;
   }
}
