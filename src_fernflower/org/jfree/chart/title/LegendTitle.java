package org.jfree.chart.title;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.LegendItemSource;
import org.jfree.chart.block.Arrangement;
import org.jfree.chart.block.Block;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.BlockFrame;
import org.jfree.chart.block.BorderArrangement;
import org.jfree.chart.block.CenterArrangement;
import org.jfree.chart.block.ColumnArrangement;
import org.jfree.chart.block.FlowArrangement;
import org.jfree.chart.block.LabelBlock;
import org.jfree.chart.block.RectangleConstraint;
import org.jfree.chart.event.TitleChangeEvent;
import org.jfree.chart.title.LegendGraphic;
import org.jfree.chart.title.LegendItemBlockContainer;
import org.jfree.chart.title.Title;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.Size2D;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;

public class LegendTitle extends Title implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = 2644010518533854633L;
   public static final Font DEFAULT_ITEM_FONT = new Font("SansSerif", 0, 12);
   public static final Paint DEFAULT_ITEM_PAINT;
   private LegendItemSource[] sources;
   private transient Paint backgroundPaint;
   private RectangleEdge legendItemGraphicEdge;
   private RectangleAnchor legendItemGraphicAnchor;
   private RectangleAnchor legendItemGraphicLocation;
   private RectangleInsets legendItemGraphicPadding;
   private Font itemFont;
   private transient Paint itemPaint;
   private RectangleInsets itemLabelPadding;
   private BlockContainer items;
   private Arrangement hLayout;
   private Arrangement vLayout;
   private BlockContainer wrapper;

   public LegendTitle(LegendItemSource var1) {
      this(var1, new FlowArrangement(), new ColumnArrangement());
   }

   public LegendTitle(LegendItemSource var1, Arrangement var2, Arrangement var3) {
      this.sources = new LegendItemSource[]{var1};
      this.items = new BlockContainer(var2);
      this.hLayout = var2;
      this.vLayout = var3;
      this.backgroundPaint = null;
      this.legendItemGraphicEdge = RectangleEdge.LEFT;
      this.legendItemGraphicAnchor = RectangleAnchor.CENTER;
      this.legendItemGraphicLocation = RectangleAnchor.CENTER;
      this.legendItemGraphicPadding = new RectangleInsets(2.0D, 2.0D, 2.0D, 2.0D);
      this.itemFont = DEFAULT_ITEM_FONT;
      this.itemPaint = DEFAULT_ITEM_PAINT;
      this.itemLabelPadding = new RectangleInsets(2.0D, 2.0D, 2.0D, 2.0D);
   }

   public LegendItemSource[] getSources() {
      return this.sources;
   }

   public void setSources(LegendItemSource[] var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'sources\' argument.");
      } else {
         this.sources = var1;
         this.notifyListeners(new TitleChangeEvent(this));
      }
   }

   public Paint getBackgroundPaint() {
      return this.backgroundPaint;
   }

   public void setBackgroundPaint(Paint var1) {
      this.backgroundPaint = var1;
      this.notifyListeners(new TitleChangeEvent(this));
   }

   public RectangleEdge getLegendItemGraphicEdge() {
      return this.legendItemGraphicEdge;
   }

   public void setLegendItemGraphicEdge(RectangleEdge var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'edge\' argument.");
      } else {
         this.legendItemGraphicEdge = var1;
         this.notifyListeners(new TitleChangeEvent(this));
      }
   }

   public RectangleAnchor getLegendItemGraphicAnchor() {
      return this.legendItemGraphicAnchor;
   }

   public void setLegendItemGraphicAnchor(RectangleAnchor var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'anchor\' point.");
      } else {
         this.legendItemGraphicAnchor = var1;
      }
   }

   public RectangleAnchor getLegendItemGraphicLocation() {
      return this.legendItemGraphicLocation;
   }

   public void setLegendItemGraphicLocation(RectangleAnchor var1) {
      this.legendItemGraphicLocation = var1;
   }

   public RectangleInsets getLegendItemGraphicPadding() {
      return this.legendItemGraphicPadding;
   }

   public void setLegendItemGraphicPadding(RectangleInsets var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'padding\' argument.");
      } else {
         this.legendItemGraphicPadding = var1;
         this.notifyListeners(new TitleChangeEvent(this));
      }
   }

   public Font getItemFont() {
      return this.itemFont;
   }

   public void setItemFont(Font var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'font\' argument.");
      } else {
         this.itemFont = var1;
         this.notifyListeners(new TitleChangeEvent(this));
      }
   }

   public Paint getItemPaint() {
      return this.itemPaint;
   }

   public void setItemPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.itemPaint = var1;
         this.notifyListeners(new TitleChangeEvent(this));
      }
   }

   public RectangleInsets getItemLabelPadding() {
      return this.itemLabelPadding;
   }

   public void setItemLabelPadding(RectangleInsets var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'padding\' argument.");
      } else {
         this.itemLabelPadding = var1;
         this.notifyListeners(new TitleChangeEvent(this));
      }
   }

   protected void fetchLegendItems() {
      this.items.clear();
      RectangleEdge var1 = this.getPosition();
      if(RectangleEdge.isTopOrBottom(var1)) {
         this.items.setArrangement(this.hLayout);
      } else {
         this.items.setArrangement(this.vLayout);
      }

      for(int var2 = 0; var2 < this.sources.length; ++var2) {
         LegendItemCollection var3 = this.sources[var2].getLegendItems();
         if(var3 != null) {
            for(int var4 = 0; var4 < var3.getItemCount(); ++var4) {
               LegendItem var5 = var3.get(var4);
               Block var6 = this.createLegendItemBlock(var5);
               this.items.add(var6);
            }
         }
      }

   }

   protected Block createLegendItemBlock(LegendItem var1) {
      BlockContainer var2 = null;
      LegendGraphic var3 = new LegendGraphic(var1.getShape(), var1.getFillPaint());
      var3.setFillPaintTransformer(var1.getFillPaintTransformer());
      var3.setShapeFilled(var1.isShapeFilled());
      var3.setLine(var1.getLine());
      var3.setLineStroke(var1.getLineStroke());
      var3.setLinePaint(var1.getLinePaint());
      var3.setLineVisible(var1.isLineVisible());
      var3.setShapeVisible(var1.isShapeVisible());
      var3.setShapeOutlineVisible(var1.isShapeOutlineVisible());
      var3.setOutlinePaint(var1.getOutlinePaint());
      var3.setOutlineStroke(var1.getOutlineStroke());
      var3.setPadding(this.legendItemGraphicPadding);
      LegendItemBlockContainer var4 = new LegendItemBlockContainer(new BorderArrangement(), var1.getDatasetIndex(), var1.getSeriesIndex());
      var3.setShapeAnchor(this.getLegendItemGraphicAnchor());
      var3.setShapeLocation(this.getLegendItemGraphicLocation());
      var4.add(var3, this.legendItemGraphicEdge);
      LabelBlock var5 = new LabelBlock(var1.getLabel(), this.itemFont, this.itemPaint);
      var5.setPadding(this.itemLabelPadding);
      var4.add(var5);
      var4.setToolTipText(var1.getToolTipText());
      var4.setURLText(var1.getURLText());
      var2 = new BlockContainer(new CenterArrangement());
      var2.add(var4);
      return var2;
   }

   public BlockContainer getItemContainer() {
      return this.items;
   }

   public Size2D arrange(Graphics2D var1, RectangleConstraint var2) {
      Size2D var3 = new Size2D();
      this.fetchLegendItems();
      if(this.items.isEmpty()) {
         return var3;
      } else {
         BlockContainer var4 = this.wrapper;
         if(var4 == null) {
            var4 = this.items;
         }

         RectangleConstraint var5 = this.toContentConstraint(var2);
         Size2D var6 = var4.arrange(var1, var5);
         var3.height = this.calculateTotalHeight(var6.height);
         var3.width = this.calculateTotalWidth(var6.width);
         return var3;
      }
   }

   public void draw(Graphics2D var1, Rectangle2D var2) {
      this.draw(var1, var2, (Object)null);
   }

   public Object draw(Graphics2D var1, Rectangle2D var2, Object var3) {
      Rectangle2D var4 = (Rectangle2D)var2.clone();
      var4 = this.trimMargin(var4);
      if(this.backgroundPaint != null) {
         var1.setPaint(this.backgroundPaint);
         var1.fill(var4);
      }

      BlockFrame var5 = this.getFrame();
      var5.draw(var1, var4);
      var5.getInsets().trim(var4);
      BlockContainer var6 = this.wrapper;
      if(var6 == null) {
         var6 = this.items;
      }

      var4 = this.trimPadding(var4);
      return var6.draw(var1, var4, var3);
   }

   public void setWrapper(BlockContainer var1) {
      this.wrapper = var1;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof LegendTitle)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         LegendTitle var2 = (LegendTitle)var1;
         return !PaintUtilities.equal(this.backgroundPaint, var2.backgroundPaint)?false:(this.legendItemGraphicEdge != var2.legendItemGraphicEdge?false:(this.legendItemGraphicAnchor != var2.legendItemGraphicAnchor?false:(this.legendItemGraphicLocation != var2.legendItemGraphicLocation?false:(!this.itemFont.equals(var2.itemFont)?false:(!this.itemPaint.equals(var2.itemPaint)?false:(!this.hLayout.equals(var2.hLayout)?false:this.vLayout.equals(var2.vLayout)))))));
      }
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.backgroundPaint, var1);
      SerialUtilities.writePaint(this.itemPaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.backgroundPaint = SerialUtilities.readPaint(var1);
      this.itemPaint = SerialUtilities.readPaint(var1);
   }

   static {
      DEFAULT_ITEM_PAINT = Color.black;
   }
}
