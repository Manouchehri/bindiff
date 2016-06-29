package org.jfree.chart.renderer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.EventListener;
import java.util.List;
import javax.swing.event.EventListenerList;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.event.RendererChangeListener;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.DrawingSupplier;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.TextAnchor;
import org.jfree.util.BooleanList;
import org.jfree.util.BooleanUtilities;
import org.jfree.util.ObjectList;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintList;
import org.jfree.util.PaintUtilities;
import org.jfree.util.ShapeList;
import org.jfree.util.ShapeUtilities;
import org.jfree.util.StrokeList;

public abstract class AbstractRenderer implements Serializable, Cloneable {
   private static final long serialVersionUID = -828267569428206075L;
   public static final Double ZERO = new Double(0.0D);
   public static final Paint DEFAULT_PAINT;
   public static final Paint DEFAULT_OUTLINE_PAINT;
   public static final Stroke DEFAULT_STROKE;
   public static final Stroke DEFAULT_OUTLINE_STROKE;
   public static final Shape DEFAULT_SHAPE;
   public static final Font DEFAULT_VALUE_LABEL_FONT;
   public static final Paint DEFAULT_VALUE_LABEL_PAINT;
   private Boolean seriesVisible = null;
   private BooleanList seriesVisibleList = new BooleanList();
   private boolean baseSeriesVisible = true;
   private Boolean seriesVisibleInLegend = null;
   private BooleanList seriesVisibleInLegendList = new BooleanList();
   private boolean baseSeriesVisibleInLegend = true;
   private transient Paint paint = null;
   private PaintList paintList = new PaintList();
   private transient Paint basePaint;
   private transient Paint fillPaint;
   private PaintList fillPaintList;
   private transient Paint baseFillPaint;
   private transient Paint outlinePaint;
   private PaintList outlinePaintList;
   private transient Paint baseOutlinePaint;
   private transient Stroke stroke;
   private StrokeList strokeList;
   private transient Stroke baseStroke;
   private transient Stroke outlineStroke;
   private StrokeList outlineStrokeList;
   private transient Stroke baseOutlineStroke;
   private transient Shape shape;
   private ShapeList shapeList;
   private transient Shape baseShape;
   private Boolean itemLabelsVisible;
   private BooleanList itemLabelsVisibleList;
   private Boolean baseItemLabelsVisible;
   private Font itemLabelFont;
   private ObjectList itemLabelFontList;
   private Font baseItemLabelFont;
   private transient Paint itemLabelPaint;
   private PaintList itemLabelPaintList;
   private transient Paint baseItemLabelPaint;
   private ItemLabelPosition positiveItemLabelPosition;
   private ObjectList positiveItemLabelPositionList;
   private ItemLabelPosition basePositiveItemLabelPosition;
   private ItemLabelPosition negativeItemLabelPosition;
   private ObjectList negativeItemLabelPositionList;
   private ItemLabelPosition baseNegativeItemLabelPosition;
   private double itemLabelAnchorOffset = 2.0D;
   private Boolean createEntities;
   private BooleanList createEntitiesList;
   private boolean baseCreateEntities;
   private transient EventListenerList listenerList;
   private transient RendererChangeEvent event;
   private static final double ADJ;
   private static final double OPP;
   static Class class$org$jfree$chart$event$RendererChangeListener;

   public AbstractRenderer() {
      this.basePaint = DEFAULT_PAINT;
      this.fillPaint = null;
      this.fillPaintList = new PaintList();
      this.baseFillPaint = Color.white;
      this.outlinePaint = null;
      this.outlinePaintList = new PaintList();
      this.baseOutlinePaint = DEFAULT_OUTLINE_PAINT;
      this.stroke = null;
      this.strokeList = new StrokeList();
      this.baseStroke = DEFAULT_STROKE;
      this.outlineStroke = null;
      this.outlineStrokeList = new StrokeList();
      this.baseOutlineStroke = DEFAULT_OUTLINE_STROKE;
      this.shape = null;
      this.shapeList = new ShapeList();
      this.baseShape = DEFAULT_SHAPE;
      this.itemLabelsVisible = null;
      this.itemLabelsVisibleList = new BooleanList();
      this.baseItemLabelsVisible = Boolean.FALSE;
      this.itemLabelFont = null;
      this.itemLabelFontList = new ObjectList();
      this.baseItemLabelFont = new Font("SansSerif", 0, 10);
      this.itemLabelPaint = null;
      this.itemLabelPaintList = new PaintList();
      this.baseItemLabelPaint = Color.black;
      this.positiveItemLabelPosition = null;
      this.positiveItemLabelPositionList = new ObjectList();
      this.basePositiveItemLabelPosition = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER);
      this.negativeItemLabelPosition = null;
      this.negativeItemLabelPositionList = new ObjectList();
      this.baseNegativeItemLabelPosition = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_CENTER);
      this.createEntities = null;
      this.createEntitiesList = new BooleanList();
      this.baseCreateEntities = true;
      this.listenerList = new EventListenerList();
   }

   public abstract DrawingSupplier getDrawingSupplier();

   public boolean getItemVisible(int var1, int var2) {
      return this.isSeriesVisible(var1);
   }

   public boolean isSeriesVisible(int var1) {
      boolean var2 = this.baseSeriesVisible;
      if(this.seriesVisible != null) {
         var2 = this.seriesVisible.booleanValue();
      } else {
         Boolean var3 = this.seriesVisibleList.getBoolean(var1);
         if(var3 != null) {
            var2 = var3.booleanValue();
         }
      }

      return var2;
   }

   public Boolean getSeriesVisible() {
      return this.seriesVisible;
   }

   public void setSeriesVisible(Boolean var1) {
      this.setSeriesVisible(var1, true);
   }

   public void setSeriesVisible(Boolean var1, boolean var2) {
      this.seriesVisible = var1;
      if(var2) {
         this.fireChangeEvent();
      }

   }

   public Boolean getSeriesVisible(int var1) {
      return this.seriesVisibleList.getBoolean(var1);
   }

   public void setSeriesVisible(int var1, Boolean var2) {
      this.setSeriesVisible(var1, var2, true);
   }

   public void setSeriesVisible(int var1, Boolean var2, boolean var3) {
      this.seriesVisibleList.setBoolean(var1, var2);
      if(var3) {
         this.fireChangeEvent();
      }

   }

   public boolean getBaseSeriesVisible() {
      return this.baseSeriesVisible;
   }

   public void setBaseSeriesVisible(boolean var1) {
      this.setBaseSeriesVisible(var1, true);
   }

   public void setBaseSeriesVisible(boolean var1, boolean var2) {
      this.baseSeriesVisible = var1;
      if(var2) {
         this.fireChangeEvent();
      }

   }

   public boolean isSeriesVisibleInLegend(int var1) {
      boolean var2 = this.baseSeriesVisibleInLegend;
      if(this.seriesVisibleInLegend != null) {
         var2 = this.seriesVisibleInLegend.booleanValue();
      } else {
         Boolean var3 = this.seriesVisibleInLegendList.getBoolean(var1);
         if(var3 != null) {
            var2 = var3.booleanValue();
         }
      }

      return var2;
   }

   public Boolean getSeriesVisibleInLegend() {
      return this.seriesVisibleInLegend;
   }

   public void setSeriesVisibleInLegend(Boolean var1) {
      this.setSeriesVisibleInLegend(var1, true);
   }

   public void setSeriesVisibleInLegend(Boolean var1, boolean var2) {
      this.seriesVisibleInLegend = var1;
      if(var2) {
         this.fireChangeEvent();
      }

   }

   public Boolean getSeriesVisibleInLegend(int var1) {
      return this.seriesVisibleInLegendList.getBoolean(var1);
   }

   public void setSeriesVisibleInLegend(int var1, Boolean var2) {
      this.setSeriesVisibleInLegend(var1, var2, true);
   }

   public void setSeriesVisibleInLegend(int var1, Boolean var2, boolean var3) {
      this.seriesVisibleInLegendList.setBoolean(var1, var2);
      if(var3) {
         this.fireChangeEvent();
      }

   }

   public boolean getBaseSeriesVisibleInLegend() {
      return this.baseSeriesVisibleInLegend;
   }

   public void setBaseSeriesVisibleInLegend(boolean var1) {
      this.setBaseSeriesVisibleInLegend(var1, true);
   }

   public void setBaseSeriesVisibleInLegend(boolean var1, boolean var2) {
      this.baseSeriesVisibleInLegend = var1;
      if(var2) {
         this.fireChangeEvent();
      }

   }

   public Paint getItemPaint(int var1, int var2) {
      return this.getSeriesPaint(var1);
   }

   public Paint getSeriesPaint(int var1) {
      if(this.paint != null) {
         return this.paint;
      } else {
         Paint var2 = this.paintList.getPaint(var1);
         if(var2 == null) {
            DrawingSupplier var3 = this.getDrawingSupplier();
            if(var3 != null) {
               var2 = var3.getNextPaint();
               this.paintList.setPaint(var1, var2);
            } else {
               var2 = this.basePaint;
            }
         }

         return var2;
      }
   }

   public void setPaint(Paint var1) {
      this.setPaint(var1, true);
   }

   public void setPaint(Paint var1, boolean var2) {
      this.paint = var1;
      if(var2) {
         this.fireChangeEvent();
      }

   }

   public void setSeriesPaint(int var1, Paint var2) {
      this.setSeriesPaint(var1, var2, true);
   }

   public void setSeriesPaint(int var1, Paint var2, boolean var3) {
      this.paintList.setPaint(var1, var2);
      if(var3) {
         this.fireChangeEvent();
      }

   }

   public Paint getBasePaint() {
      return this.basePaint;
   }

   public void setBasePaint(Paint var1) {
      this.setBasePaint(var1, true);
   }

   public void setBasePaint(Paint var1, boolean var2) {
      this.basePaint = var1;
      if(var2) {
         this.fireChangeEvent();
      }

   }

   public Paint getItemFillPaint(int var1, int var2) {
      return this.getSeriesFillPaint(var1);
   }

   public Paint getSeriesFillPaint(int var1) {
      if(this.fillPaint != null) {
         return this.fillPaint;
      } else {
         Paint var2 = this.fillPaintList.getPaint(var1);
         if(var2 == null) {
            var2 = this.baseFillPaint;
         }

         return var2;
      }
   }

   public void setSeriesFillPaint(int var1, Paint var2) {
      this.setSeriesFillPaint(var1, var2, true);
   }

   public void setSeriesFillPaint(int var1, Paint var2, boolean var3) {
      this.fillPaintList.setPaint(var1, var2);
      if(var3) {
         this.fireChangeEvent();
      }

   }

   public void setFillPaint(Paint var1) {
      this.setFillPaint(var1, true);
   }

   public void setFillPaint(Paint var1, boolean var2) {
      this.fillPaint = var1;
      if(var2) {
         this.fireChangeEvent();
      }

   }

   public Paint getBaseFillPaint() {
      return this.baseFillPaint;
   }

   public void setBaseFillPaint(Paint var1) {
      this.setBaseFillPaint(var1, true);
   }

   public void setBaseFillPaint(Paint var1, boolean var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.baseFillPaint = var1;
         if(var2) {
            this.fireChangeEvent();
         }

      }
   }

   public Paint getItemOutlinePaint(int var1, int var2) {
      return this.getSeriesOutlinePaint(var1);
   }

   public Paint getSeriesOutlinePaint(int var1) {
      if(this.outlinePaint != null) {
         return this.outlinePaint;
      } else {
         Paint var2 = this.outlinePaintList.getPaint(var1);
         if(var2 == null) {
            DrawingSupplier var3 = this.getDrawingSupplier();
            if(var3 != null) {
               var2 = var3.getNextOutlinePaint();
               this.outlinePaintList.setPaint(var1, var2);
            } else {
               var2 = this.baseOutlinePaint;
            }
         }

         return var2;
      }
   }

   public void setSeriesOutlinePaint(int var1, Paint var2) {
      this.setSeriesOutlinePaint(var1, var2, true);
   }

   public void setSeriesOutlinePaint(int var1, Paint var2, boolean var3) {
      this.outlinePaintList.setPaint(var1, var2);
      if(var3) {
         this.fireChangeEvent();
      }

   }

   public void setOutlinePaint(Paint var1) {
      this.setOutlinePaint(var1, true);
   }

   public void setOutlinePaint(Paint var1, boolean var2) {
      this.outlinePaint = var1;
      if(var2) {
         this.fireChangeEvent();
      }

   }

   public Paint getBaseOutlinePaint() {
      return this.baseOutlinePaint;
   }

   public void setBaseOutlinePaint(Paint var1) {
      this.setBaseOutlinePaint(var1, true);
   }

   public void setBaseOutlinePaint(Paint var1, boolean var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.baseOutlinePaint = var1;
         if(var2) {
            this.fireChangeEvent();
         }

      }
   }

   public Stroke getItemStroke(int var1, int var2) {
      return this.getSeriesStroke(var1);
   }

   public Stroke getSeriesStroke(int var1) {
      if(this.stroke != null) {
         return this.stroke;
      } else {
         Stroke var2 = this.strokeList.getStroke(var1);
         if(var2 == null) {
            DrawingSupplier var3 = this.getDrawingSupplier();
            if(var3 != null) {
               var2 = var3.getNextStroke();
               this.strokeList.setStroke(var1, var2);
            } else {
               var2 = this.baseStroke;
            }
         }

         return var2;
      }
   }

   public void setStroke(Stroke var1) {
      this.setStroke(var1, true);
   }

   public void setStroke(Stroke var1, boolean var2) {
      this.stroke = var1;
      if(var2) {
         this.fireChangeEvent();
      }

   }

   public void setSeriesStroke(int var1, Stroke var2) {
      this.setSeriesStroke(var1, var2, true);
   }

   public void setSeriesStroke(int var1, Stroke var2, boolean var3) {
      this.strokeList.setStroke(var1, var2);
      if(var3) {
         this.fireChangeEvent();
      }

   }

   public Stroke getBaseStroke() {
      return this.baseStroke;
   }

   public void setBaseStroke(Stroke var1) {
      this.setBaseStroke(var1, true);
   }

   public void setBaseStroke(Stroke var1, boolean var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'stroke\' argument.");
      } else {
         this.baseStroke = var1;
         if(var2) {
            this.fireChangeEvent();
         }

      }
   }

   public Stroke getItemOutlineStroke(int var1, int var2) {
      return this.getSeriesOutlineStroke(var1);
   }

   public Stroke getSeriesOutlineStroke(int var1) {
      if(this.outlineStroke != null) {
         return this.outlineStroke;
      } else {
         Stroke var2 = this.outlineStrokeList.getStroke(var1);
         if(var2 == null) {
            DrawingSupplier var3 = this.getDrawingSupplier();
            if(var3 != null) {
               var2 = var3.getNextOutlineStroke();
               this.outlineStrokeList.setStroke(var1, var2);
            } else {
               var2 = this.baseOutlineStroke;
            }
         }

         return var2;
      }
   }

   public void setOutlineStroke(Stroke var1) {
      this.setOutlineStroke(var1, true);
   }

   public void setOutlineStroke(Stroke var1, boolean var2) {
      this.outlineStroke = var1;
      if(var2) {
         this.fireChangeEvent();
      }

   }

   public void setSeriesOutlineStroke(int var1, Stroke var2) {
      this.setSeriesOutlineStroke(var1, var2, true);
   }

   public void setSeriesOutlineStroke(int var1, Stroke var2, boolean var3) {
      this.outlineStrokeList.setStroke(var1, var2);
      if(var3) {
         this.fireChangeEvent();
      }

   }

   public Stroke getBaseOutlineStroke() {
      return this.baseOutlineStroke;
   }

   public void setBaseOutlineStroke(Stroke var1) {
      this.setBaseOutlineStroke(var1, true);
   }

   public void setBaseOutlineStroke(Stroke var1, boolean var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'stroke\' argument.");
      } else {
         this.baseOutlineStroke = var1;
         if(var2) {
            this.fireChangeEvent();
         }

      }
   }

   public Shape getItemShape(int var1, int var2) {
      return this.getSeriesShape(var1);
   }

   public Shape getSeriesShape(int var1) {
      if(this.shape != null) {
         return this.shape;
      } else {
         Shape var2 = this.shapeList.getShape(var1);
         if(var2 == null) {
            DrawingSupplier var3 = this.getDrawingSupplier();
            if(var3 != null) {
               var2 = var3.getNextShape();
               this.shapeList.setShape(var1, var2);
            } else {
               var2 = this.baseShape;
            }
         }

         return var2;
      }
   }

   public void setShape(Shape var1) {
      this.setShape(var1, true);
   }

   public void setShape(Shape var1, boolean var2) {
      this.shape = var1;
      if(var2) {
         this.fireChangeEvent();
      }

   }

   public void setSeriesShape(int var1, Shape var2) {
      this.setSeriesShape(var1, var2, true);
   }

   public void setSeriesShape(int var1, Shape var2, boolean var3) {
      this.shapeList.setShape(var1, var2);
      if(var3) {
         this.fireChangeEvent();
      }

   }

   public Shape getBaseShape() {
      return this.baseShape;
   }

   public void setBaseShape(Shape var1) {
      this.setBaseShape(var1, true);
   }

   public void setBaseShape(Shape var1, boolean var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'shape\' argument.");
      } else {
         this.baseShape = var1;
         if(var2) {
            this.fireChangeEvent();
         }

      }
   }

   public boolean isItemLabelVisible(int var1, int var2) {
      return this.isSeriesItemLabelsVisible(var1);
   }

   public boolean isSeriesItemLabelsVisible(int var1) {
      if(this.itemLabelsVisible != null) {
         return this.itemLabelsVisible.booleanValue();
      } else {
         Boolean var2 = this.itemLabelsVisibleList.getBoolean(var1);
         if(var2 == null) {
            var2 = this.baseItemLabelsVisible;
         }

         if(var2 == null) {
            var2 = Boolean.FALSE;
         }

         return var2.booleanValue();
      }
   }

   public void setItemLabelsVisible(boolean var1) {
      this.setItemLabelsVisible(BooleanUtilities.valueOf(var1));
   }

   public void setItemLabelsVisible(Boolean var1) {
      this.setItemLabelsVisible(var1, true);
   }

   public void setItemLabelsVisible(Boolean var1, boolean var2) {
      this.itemLabelsVisible = var1;
      if(var2) {
         this.fireChangeEvent();
      }

   }

   public void setSeriesItemLabelsVisible(int var1, boolean var2) {
      this.setSeriesItemLabelsVisible(var1, BooleanUtilities.valueOf(var2));
   }

   public void setSeriesItemLabelsVisible(int var1, Boolean var2) {
      this.setSeriesItemLabelsVisible(var1, var2, true);
   }

   public void setSeriesItemLabelsVisible(int var1, Boolean var2, boolean var3) {
      this.itemLabelsVisibleList.setBoolean(var1, var2);
      if(var3) {
         this.fireChangeEvent();
      }

   }

   public Boolean getBaseItemLabelsVisible() {
      return this.baseItemLabelsVisible;
   }

   public void setBaseItemLabelsVisible(boolean var1) {
      this.setBaseItemLabelsVisible(BooleanUtilities.valueOf(var1));
   }

   public void setBaseItemLabelsVisible(Boolean var1) {
      this.setBaseItemLabelsVisible(var1, true);
   }

   public void setBaseItemLabelsVisible(Boolean var1, boolean var2) {
      this.baseItemLabelsVisible = var1;
      if(var2) {
         this.fireChangeEvent();
      }

   }

   public Font getItemLabelFont(int var1, int var2) {
      Font var3 = this.itemLabelFont;
      if(var3 == null) {
         var3 = this.getSeriesItemLabelFont(var1);
         if(var3 == null) {
            var3 = this.baseItemLabelFont;
         }
      }

      return var3;
   }

   public Font getItemLabelFont() {
      return this.itemLabelFont;
   }

   public void setItemLabelFont(Font var1) {
      this.setItemLabelFont(var1, true);
   }

   public void setItemLabelFont(Font var1, boolean var2) {
      this.itemLabelFont = var1;
      if(var2) {
         this.fireChangeEvent();
      }

   }

   public Font getSeriesItemLabelFont(int var1) {
      return (Font)this.itemLabelFontList.get(var1);
   }

   public void setSeriesItemLabelFont(int var1, Font var2) {
      this.setSeriesItemLabelFont(var1, var2, true);
   }

   public void setSeriesItemLabelFont(int var1, Font var2, boolean var3) {
      this.itemLabelFontList.set(var1, var2);
      if(var3) {
         this.fireChangeEvent();
      }

   }

   public Font getBaseItemLabelFont() {
      return this.baseItemLabelFont;
   }

   public void setBaseItemLabelFont(Font var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'font\' argument.");
      } else {
         this.setBaseItemLabelFont(var1, true);
      }
   }

   public void setBaseItemLabelFont(Font var1, boolean var2) {
      this.baseItemLabelFont = var1;
      if(var2) {
         this.fireChangeEvent();
      }

   }

   public Paint getItemLabelPaint(int var1, int var2) {
      Paint var3 = this.itemLabelPaint;
      if(var3 == null) {
         var3 = this.getSeriesItemLabelPaint(var1);
         if(var3 == null) {
            var3 = this.baseItemLabelPaint;
         }
      }

      return var3;
   }

   public Paint getItemLabelPaint() {
      return this.itemLabelPaint;
   }

   public void setItemLabelPaint(Paint var1) {
      this.setItemLabelPaint(var1, true);
   }

   public void setItemLabelPaint(Paint var1, boolean var2) {
      this.itemLabelPaint = var1;
      if(var2) {
         this.fireChangeEvent();
      }

   }

   public Paint getSeriesItemLabelPaint(int var1) {
      return this.itemLabelPaintList.getPaint(var1);
   }

   public void setSeriesItemLabelPaint(int var1, Paint var2) {
      this.setSeriesItemLabelPaint(var1, var2, true);
   }

   public void setSeriesItemLabelPaint(int var1, Paint var2, boolean var3) {
      this.itemLabelPaintList.setPaint(var1, var2);
      if(var3) {
         this.fireChangeEvent();
      }

   }

   public Paint getBaseItemLabelPaint() {
      return this.baseItemLabelPaint;
   }

   public void setBaseItemLabelPaint(Paint var1) {
      this.setBaseItemLabelPaint(var1, true);
   }

   public void setBaseItemLabelPaint(Paint var1, boolean var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.baseItemLabelPaint = var1;
         if(var2) {
            this.fireChangeEvent();
         }

      }
   }

   public ItemLabelPosition getPositiveItemLabelPosition(int var1, int var2) {
      return this.getSeriesPositiveItemLabelPosition(var1);
   }

   public ItemLabelPosition getPositiveItemLabelPosition() {
      return this.positiveItemLabelPosition;
   }

   public void setPositiveItemLabelPosition(ItemLabelPosition var1) {
      this.setPositiveItemLabelPosition(var1, true);
   }

   public void setPositiveItemLabelPosition(ItemLabelPosition var1, boolean var2) {
      this.positiveItemLabelPosition = var1;
      if(var2) {
         this.fireChangeEvent();
      }

   }

   public ItemLabelPosition getSeriesPositiveItemLabelPosition(int var1) {
      if(this.positiveItemLabelPosition != null) {
         return this.positiveItemLabelPosition;
      } else {
         ItemLabelPosition var2 = (ItemLabelPosition)this.positiveItemLabelPositionList.get(var1);
         if(var2 == null) {
            var2 = this.basePositiveItemLabelPosition;
         }

         return var2;
      }
   }

   public void setSeriesPositiveItemLabelPosition(int var1, ItemLabelPosition var2) {
      this.setSeriesPositiveItemLabelPosition(var1, var2, true);
   }

   public void setSeriesPositiveItemLabelPosition(int var1, ItemLabelPosition var2, boolean var3) {
      this.positiveItemLabelPositionList.set(var1, var2);
      if(var3) {
         this.fireChangeEvent();
      }

   }

   public ItemLabelPosition getBasePositiveItemLabelPosition() {
      return this.basePositiveItemLabelPosition;
   }

   public void setBasePositiveItemLabelPosition(ItemLabelPosition var1) {
      this.setBasePositiveItemLabelPosition(var1, true);
   }

   public void setBasePositiveItemLabelPosition(ItemLabelPosition var1, boolean var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'position\' argument.");
      } else {
         this.basePositiveItemLabelPosition = var1;
         if(var2) {
            this.fireChangeEvent();
         }

      }
   }

   public ItemLabelPosition getNegativeItemLabelPosition(int var1, int var2) {
      return this.getSeriesNegativeItemLabelPosition(var1);
   }

   public ItemLabelPosition getNegativeItemLabelPosition() {
      return this.negativeItemLabelPosition;
   }

   public void setNegativeItemLabelPosition(ItemLabelPosition var1) {
      this.setNegativeItemLabelPosition(var1, true);
   }

   public void setNegativeItemLabelPosition(ItemLabelPosition var1, boolean var2) {
      this.negativeItemLabelPosition = var1;
      if(var2) {
         this.fireChangeEvent();
      }

   }

   public ItemLabelPosition getSeriesNegativeItemLabelPosition(int var1) {
      if(this.negativeItemLabelPosition != null) {
         return this.negativeItemLabelPosition;
      } else {
         ItemLabelPosition var2 = (ItemLabelPosition)this.negativeItemLabelPositionList.get(var1);
         if(var2 == null) {
            var2 = this.baseNegativeItemLabelPosition;
         }

         return var2;
      }
   }

   public void setSeriesNegativeItemLabelPosition(int var1, ItemLabelPosition var2) {
      this.setSeriesNegativeItemLabelPosition(var1, var2, true);
   }

   public void setSeriesNegativeItemLabelPosition(int var1, ItemLabelPosition var2, boolean var3) {
      this.negativeItemLabelPositionList.set(var1, var2);
      if(var3) {
         this.fireChangeEvent();
      }

   }

   public ItemLabelPosition getBaseNegativeItemLabelPosition() {
      return this.baseNegativeItemLabelPosition;
   }

   public void setBaseNegativeItemLabelPosition(ItemLabelPosition var1) {
      this.setBaseNegativeItemLabelPosition(var1, true);
   }

   public void setBaseNegativeItemLabelPosition(ItemLabelPosition var1, boolean var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'position\' argument.");
      } else {
         this.baseNegativeItemLabelPosition = var1;
         if(var2) {
            this.fireChangeEvent();
         }

      }
   }

   public double getItemLabelAnchorOffset() {
      return this.itemLabelAnchorOffset;
   }

   public void setItemLabelAnchorOffset(double var1) {
      this.itemLabelAnchorOffset = var1;
      this.fireChangeEvent();
   }

   public boolean getItemCreateEntity(int var1, int var2) {
      if(this.createEntities != null) {
         return this.createEntities.booleanValue();
      } else {
         Boolean var3 = this.getSeriesCreateEntities(var1);
         return var3 != null?var3.booleanValue():this.baseCreateEntities;
      }
   }

   public Boolean getCreateEntities() {
      return this.createEntities;
   }

   public void setCreateEntities(Boolean var1) {
      this.setCreateEntities(var1, true);
   }

   public void setCreateEntities(Boolean var1, boolean var2) {
      this.createEntities = var1;
      if(var2) {
         this.fireChangeEvent();
      }

   }

   public Boolean getSeriesCreateEntities(int var1) {
      return this.createEntitiesList.getBoolean(var1);
   }

   public void setSeriesCreateEntities(int var1, Boolean var2) {
      this.setSeriesCreateEntities(var1, var2, true);
   }

   public void setSeriesCreateEntities(int var1, Boolean var2, boolean var3) {
      this.createEntitiesList.setBoolean(var1, var2);
      if(var3) {
         this.fireChangeEvent();
      }

   }

   public boolean getBaseCreateEntities() {
      return this.baseCreateEntities;
   }

   public void setBaseCreateEntities(boolean var1) {
      this.setBaseCreateEntities(var1, true);
   }

   public void setBaseCreateEntities(boolean var1, boolean var2) {
      this.baseCreateEntities = var1;
      if(var2) {
         this.fireChangeEvent();
      }

   }

   protected Point2D calculateLabelAnchorPoint(ItemLabelAnchor var1, double var2, double var4, PlotOrientation var6) {
      java.awt.geom.Point2D.Double var7 = null;
      if(var1 == ItemLabelAnchor.CENTER) {
         var7 = new java.awt.geom.Point2D.Double(var2, var4);
      } else if(var1 == ItemLabelAnchor.INSIDE1) {
         var7 = new java.awt.geom.Point2D.Double(var2 + OPP * this.itemLabelAnchorOffset, var4 - ADJ * this.itemLabelAnchorOffset);
      } else if(var1 == ItemLabelAnchor.INSIDE2) {
         var7 = new java.awt.geom.Point2D.Double(var2 + ADJ * this.itemLabelAnchorOffset, var4 - OPP * this.itemLabelAnchorOffset);
      } else if(var1 == ItemLabelAnchor.INSIDE3) {
         var7 = new java.awt.geom.Point2D.Double(var2 + this.itemLabelAnchorOffset, var4);
      } else if(var1 == ItemLabelAnchor.INSIDE4) {
         var7 = new java.awt.geom.Point2D.Double(var2 + ADJ * this.itemLabelAnchorOffset, var4 + OPP * this.itemLabelAnchorOffset);
      } else if(var1 == ItemLabelAnchor.INSIDE5) {
         var7 = new java.awt.geom.Point2D.Double(var2 + OPP * this.itemLabelAnchorOffset, var4 + ADJ * this.itemLabelAnchorOffset);
      } else if(var1 == ItemLabelAnchor.INSIDE6) {
         var7 = new java.awt.geom.Point2D.Double(var2, var4 + this.itemLabelAnchorOffset);
      } else if(var1 == ItemLabelAnchor.INSIDE7) {
         var7 = new java.awt.geom.Point2D.Double(var2 - OPP * this.itemLabelAnchorOffset, var4 + ADJ * this.itemLabelAnchorOffset);
      } else if(var1 == ItemLabelAnchor.INSIDE8) {
         var7 = new java.awt.geom.Point2D.Double(var2 - ADJ * this.itemLabelAnchorOffset, var4 + OPP * this.itemLabelAnchorOffset);
      } else if(var1 == ItemLabelAnchor.INSIDE9) {
         var7 = new java.awt.geom.Point2D.Double(var2 - this.itemLabelAnchorOffset, var4);
      } else if(var1 == ItemLabelAnchor.INSIDE10) {
         var7 = new java.awt.geom.Point2D.Double(var2 - ADJ * this.itemLabelAnchorOffset, var4 - OPP * this.itemLabelAnchorOffset);
      } else if(var1 == ItemLabelAnchor.INSIDE11) {
         var7 = new java.awt.geom.Point2D.Double(var2 - OPP * this.itemLabelAnchorOffset, var4 - ADJ * this.itemLabelAnchorOffset);
      } else if(var1 == ItemLabelAnchor.INSIDE12) {
         var7 = new java.awt.geom.Point2D.Double(var2, var4 - this.itemLabelAnchorOffset);
      } else if(var1 == ItemLabelAnchor.OUTSIDE1) {
         var7 = new java.awt.geom.Point2D.Double(var2 + 2.0D * OPP * this.itemLabelAnchorOffset, var4 - 2.0D * ADJ * this.itemLabelAnchorOffset);
      } else if(var1 == ItemLabelAnchor.OUTSIDE2) {
         var7 = new java.awt.geom.Point2D.Double(var2 + 2.0D * ADJ * this.itemLabelAnchorOffset, var4 - 2.0D * OPP * this.itemLabelAnchorOffset);
      } else if(var1 == ItemLabelAnchor.OUTSIDE3) {
         var7 = new java.awt.geom.Point2D.Double(var2 + 2.0D * this.itemLabelAnchorOffset, var4);
      } else if(var1 == ItemLabelAnchor.OUTSIDE4) {
         var7 = new java.awt.geom.Point2D.Double(var2 + 2.0D * ADJ * this.itemLabelAnchorOffset, var4 + 2.0D * OPP * this.itemLabelAnchorOffset);
      } else if(var1 == ItemLabelAnchor.OUTSIDE5) {
         var7 = new java.awt.geom.Point2D.Double(var2 + 2.0D * OPP * this.itemLabelAnchorOffset, var4 + 2.0D * ADJ * this.itemLabelAnchorOffset);
      } else if(var1 == ItemLabelAnchor.OUTSIDE6) {
         var7 = new java.awt.geom.Point2D.Double(var2, var4 + 2.0D * this.itemLabelAnchorOffset);
      } else if(var1 == ItemLabelAnchor.OUTSIDE7) {
         var7 = new java.awt.geom.Point2D.Double(var2 - 2.0D * OPP * this.itemLabelAnchorOffset, var4 + 2.0D * ADJ * this.itemLabelAnchorOffset);
      } else if(var1 == ItemLabelAnchor.OUTSIDE8) {
         var7 = new java.awt.geom.Point2D.Double(var2 - 2.0D * ADJ * this.itemLabelAnchorOffset, var4 + 2.0D * OPP * this.itemLabelAnchorOffset);
      } else if(var1 == ItemLabelAnchor.OUTSIDE9) {
         var7 = new java.awt.geom.Point2D.Double(var2 - 2.0D * this.itemLabelAnchorOffset, var4);
      } else if(var1 == ItemLabelAnchor.OUTSIDE10) {
         var7 = new java.awt.geom.Point2D.Double(var2 - 2.0D * ADJ * this.itemLabelAnchorOffset, var4 - 2.0D * OPP * this.itemLabelAnchorOffset);
      } else if(var1 == ItemLabelAnchor.OUTSIDE11) {
         var7 = new java.awt.geom.Point2D.Double(var2 - 2.0D * OPP * this.itemLabelAnchorOffset, var4 - 2.0D * ADJ * this.itemLabelAnchorOffset);
      } else if(var1 == ItemLabelAnchor.OUTSIDE12) {
         var7 = new java.awt.geom.Point2D.Double(var2, var4 - 2.0D * this.itemLabelAnchorOffset);
      }

      return var7;
   }

   public void addChangeListener(RendererChangeListener var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'listener\' argument.");
      } else {
         this.listenerList.add(class$org$jfree$chart$event$RendererChangeListener == null?(class$org$jfree$chart$event$RendererChangeListener = class$("org.jfree.chart.event.RendererChangeListener")):class$org$jfree$chart$event$RendererChangeListener, var1);
      }
   }

   public void removeChangeListener(RendererChangeListener var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'listener\' argument.");
      } else {
         this.listenerList.remove(class$org$jfree$chart$event$RendererChangeListener == null?(class$org$jfree$chart$event$RendererChangeListener = class$("org.jfree.chart.event.RendererChangeListener")):class$org$jfree$chart$event$RendererChangeListener, var1);
      }
   }

   public boolean hasListener(EventListener var1) {
      List var2 = Arrays.asList(this.listenerList.getListenerList());
      return var2.contains(var1);
   }

   protected void fireChangeEvent() {
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public void notifyListeners(RendererChangeEvent var1) {
      Object[] var2 = this.listenerList.getListenerList();

      for(int var3 = var2.length - 2; var3 >= 0; var3 -= 2) {
         if(var2[var3] == (class$org$jfree$chart$event$RendererChangeListener == null?(class$org$jfree$chart$event$RendererChangeListener = class$("org.jfree.chart.event.RendererChangeListener")):class$org$jfree$chart$event$RendererChangeListener)) {
            ((RendererChangeListener)var2[var3 + 1]).rendererChanged(var1);
         }
      }

   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof AbstractRenderer)) {
         return false;
      } else {
         AbstractRenderer var2 = (AbstractRenderer)var1;
         return !ObjectUtilities.equal(this.seriesVisible, var2.seriesVisible)?false:(!this.seriesVisibleList.equals(var2.seriesVisibleList)?false:(this.baseSeriesVisible != var2.baseSeriesVisible?false:(!ObjectUtilities.equal(this.seriesVisibleInLegend, var2.seriesVisibleInLegend)?false:(!this.seriesVisibleInLegendList.equals(var2.seriesVisibleInLegendList)?false:(this.baseSeriesVisibleInLegend != var2.baseSeriesVisibleInLegend?false:(!PaintUtilities.equal(this.paint, var2.paint)?false:(!ObjectUtilities.equal(this.paintList, var2.paintList)?false:(!PaintUtilities.equal(this.basePaint, var2.basePaint)?false:(!PaintUtilities.equal(this.fillPaint, var2.fillPaint)?false:(!ObjectUtilities.equal(this.fillPaintList, var2.fillPaintList)?false:(!PaintUtilities.equal(this.baseFillPaint, var2.baseFillPaint)?false:(!PaintUtilities.equal(this.outlinePaint, var2.outlinePaint)?false:(!ObjectUtilities.equal(this.outlinePaintList, var2.outlinePaintList)?false:(!PaintUtilities.equal(this.baseOutlinePaint, var2.baseOutlinePaint)?false:(!ObjectUtilities.equal(this.stroke, var2.stroke)?false:(!ObjectUtilities.equal(this.strokeList, var2.strokeList)?false:(!ObjectUtilities.equal(this.baseStroke, var2.baseStroke)?false:(!ObjectUtilities.equal(this.outlineStroke, var2.outlineStroke)?false:(!ObjectUtilities.equal(this.outlineStrokeList, var2.outlineStrokeList)?false:(!ObjectUtilities.equal(this.baseOutlineStroke, var2.baseOutlineStroke)?false:(!ObjectUtilities.equal(this.shape, var2.shape)?false:(!ObjectUtilities.equal(this.shapeList, var2.shapeList)?false:(!ObjectUtilities.equal(this.baseShape, var2.baseShape)?false:(!ObjectUtilities.equal(this.itemLabelsVisible, var2.itemLabelsVisible)?false:(!ObjectUtilities.equal(this.itemLabelsVisibleList, var2.itemLabelsVisibleList)?false:(!ObjectUtilities.equal(this.baseItemLabelsVisible, var2.baseItemLabelsVisible)?false:(!ObjectUtilities.equal(this.itemLabelFont, var2.itemLabelFont)?false:(!ObjectUtilities.equal(this.itemLabelFontList, var2.itemLabelFontList)?false:(!ObjectUtilities.equal(this.baseItemLabelFont, var2.baseItemLabelFont)?false:(!PaintUtilities.equal(this.itemLabelPaint, var2.itemLabelPaint)?false:(!ObjectUtilities.equal(this.itemLabelPaintList, var2.itemLabelPaintList)?false:(!PaintUtilities.equal(this.baseItemLabelPaint, var2.baseItemLabelPaint)?false:(!ObjectUtilities.equal(this.positiveItemLabelPosition, var2.positiveItemLabelPosition)?false:(!ObjectUtilities.equal(this.positiveItemLabelPositionList, var2.positiveItemLabelPositionList)?false:(!ObjectUtilities.equal(this.basePositiveItemLabelPosition, var2.basePositiveItemLabelPosition)?false:(!ObjectUtilities.equal(this.negativeItemLabelPosition, var2.negativeItemLabelPosition)?false:(!ObjectUtilities.equal(this.negativeItemLabelPositionList, var2.negativeItemLabelPositionList)?false:(!ObjectUtilities.equal(this.baseNegativeItemLabelPosition, var2.baseNegativeItemLabelPosition)?false:(this.itemLabelAnchorOffset != var2.itemLabelAnchorOffset?false:(!ObjectUtilities.equal(this.createEntities, var2.createEntities)?false:(!ObjectUtilities.equal(this.createEntitiesList, var2.createEntitiesList)?false:this.baseCreateEntities == var2.baseCreateEntities)))))))))))))))))))))))))))))))))))))))));
      }
   }

   public int hashCode() {
      short var1 = 193;
      int var2 = 37 * var1 + ObjectUtilities.hashCode(this.stroke);
      var2 = 37 * var2 + ObjectUtilities.hashCode(this.baseStroke);
      var2 = 37 * var2 + ObjectUtilities.hashCode(this.outlineStroke);
      var2 = 37 * var2 + ObjectUtilities.hashCode(this.baseOutlineStroke);
      return var2;
   }

   protected Object clone() {
      AbstractRenderer var1 = (AbstractRenderer)super.clone();
      if(this.seriesVisibleList != null) {
         var1.seriesVisibleList = (BooleanList)this.seriesVisibleList.clone();
      }

      if(this.seriesVisibleInLegendList != null) {
         var1.seriesVisibleInLegendList = (BooleanList)this.seriesVisibleInLegendList.clone();
      }

      if(this.paintList != null) {
         var1.paintList = (PaintList)this.paintList.clone();
      }

      if(this.fillPaintList != null) {
         var1.fillPaintList = (PaintList)this.fillPaintList.clone();
      }

      if(this.outlinePaintList != null) {
         var1.outlinePaintList = (PaintList)this.outlinePaintList.clone();
      }

      if(this.strokeList != null) {
         var1.strokeList = (StrokeList)this.strokeList.clone();
      }

      if(this.outlineStrokeList != null) {
         var1.outlineStrokeList = (StrokeList)this.outlineStrokeList.clone();
      }

      if(this.shape != null) {
         var1.shape = ShapeUtilities.clone(this.shape);
      }

      if(this.shapeList != null) {
         var1.shapeList = (ShapeList)this.shapeList.clone();
      }

      if(this.baseShape != null) {
         var1.baseShape = ShapeUtilities.clone(this.baseShape);
      }

      if(this.itemLabelsVisibleList != null) {
         var1.itemLabelsVisibleList = (BooleanList)this.itemLabelsVisibleList.clone();
      }

      if(this.itemLabelFontList != null) {
         var1.itemLabelFontList = (ObjectList)this.itemLabelFontList.clone();
      }

      if(this.itemLabelPaintList != null) {
         var1.itemLabelPaintList = (PaintList)this.itemLabelPaintList.clone();
      }

      if(this.positiveItemLabelPositionList != null) {
         var1.positiveItemLabelPositionList = (ObjectList)this.positiveItemLabelPositionList.clone();
      }

      if(this.negativeItemLabelPositionList != null) {
         var1.negativeItemLabelPositionList = (ObjectList)this.negativeItemLabelPositionList.clone();
      }

      if(this.createEntitiesList != null) {
         var1.createEntitiesList = (BooleanList)this.createEntitiesList.clone();
      }

      var1.listenerList = new EventListenerList();
      var1.event = null;
      return var1;
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.paint, var1);
      SerialUtilities.writePaint(this.basePaint, var1);
      SerialUtilities.writePaint(this.fillPaint, var1);
      SerialUtilities.writePaint(this.baseFillPaint, var1);
      SerialUtilities.writePaint(this.outlinePaint, var1);
      SerialUtilities.writePaint(this.baseOutlinePaint, var1);
      SerialUtilities.writeStroke(this.stroke, var1);
      SerialUtilities.writeStroke(this.baseStroke, var1);
      SerialUtilities.writeStroke(this.outlineStroke, var1);
      SerialUtilities.writeStroke(this.baseOutlineStroke, var1);
      SerialUtilities.writeShape(this.shape, var1);
      SerialUtilities.writeShape(this.baseShape, var1);
      SerialUtilities.writePaint(this.itemLabelPaint, var1);
      SerialUtilities.writePaint(this.baseItemLabelPaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.paint = SerialUtilities.readPaint(var1);
      this.basePaint = SerialUtilities.readPaint(var1);
      this.fillPaint = SerialUtilities.readPaint(var1);
      this.baseFillPaint = SerialUtilities.readPaint(var1);
      this.outlinePaint = SerialUtilities.readPaint(var1);
      this.baseOutlinePaint = SerialUtilities.readPaint(var1);
      this.stroke = SerialUtilities.readStroke(var1);
      this.baseStroke = SerialUtilities.readStroke(var1);
      this.outlineStroke = SerialUtilities.readStroke(var1);
      this.baseOutlineStroke = SerialUtilities.readStroke(var1);
      this.shape = SerialUtilities.readShape(var1);
      this.baseShape = SerialUtilities.readShape(var1);
      this.itemLabelPaint = SerialUtilities.readPaint(var1);
      this.baseItemLabelPaint = SerialUtilities.readPaint(var1);
      this.listenerList = new EventListenerList();
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }

   static {
      DEFAULT_PAINT = Color.blue;
      DEFAULT_OUTLINE_PAINT = Color.gray;
      DEFAULT_STROKE = new BasicStroke(1.0F);
      DEFAULT_OUTLINE_STROKE = new BasicStroke(1.0F);
      DEFAULT_SHAPE = new java.awt.geom.Rectangle2D.Double(-3.0D, -3.0D, 6.0D, 6.0D);
      DEFAULT_VALUE_LABEL_FONT = new Font("SansSerif", 0, 10);
      DEFAULT_VALUE_LABEL_PAINT = Color.black;
      ADJ = Math.cos(0.5235987755982988D);
      OPP = Math.sin(0.5235987755982988D);
   }
}
