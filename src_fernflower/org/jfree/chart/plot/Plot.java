package org.jfree.chart.plot;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.image.ImageObserver;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.event.EventListenerList;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.LegendItemSource;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.event.AxisChangeEvent;
import org.jfree.chart.event.AxisChangeListener;
import org.jfree.chart.event.ChartChangeEventType;
import org.jfree.chart.event.MarkerChangeEvent;
import org.jfree.chart.event.MarkerChangeListener;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.event.PlotChangeListener;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.DrawingSupplier;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;
import org.jfree.io.SerialUtilities;
import org.jfree.text.G2TextMeasurer;
import org.jfree.text.TextBlock;
import org.jfree.text.TextBlockAnchor;
import org.jfree.text.TextUtilities;
import org.jfree.ui.Align;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;

public abstract class Plot implements Serializable, Cloneable, LegendItemSource, AxisChangeListener, MarkerChangeListener, DatasetChangeListener, PublicCloneable {
   private static final long serialVersionUID = -8831571430103671324L;
   public static final Number ZERO = new Integer(0);
   public static final RectangleInsets DEFAULT_INSETS = new RectangleInsets(4.0D, 8.0D, 4.0D, 8.0D);
   public static final Stroke DEFAULT_OUTLINE_STROKE = new BasicStroke(0.5F);
   public static final Paint DEFAULT_OUTLINE_PAINT;
   public static final float DEFAULT_FOREGROUND_ALPHA = 1.0F;
   public static final float DEFAULT_BACKGROUND_ALPHA = 1.0F;
   public static final Paint DEFAULT_BACKGROUND_PAINT;
   public static final int MINIMUM_WIDTH_TO_DRAW = 10;
   public static final int MINIMUM_HEIGHT_TO_DRAW = 10;
   public static final Shape DEFAULT_LEGEND_ITEM_BOX;
   public static final Shape DEFAULT_LEGEND_ITEM_CIRCLE;
   private Plot parent = null;
   private DatasetGroup datasetGroup;
   private String noDataMessage;
   private Font noDataMessageFont;
   private transient Paint noDataMessagePaint;
   private RectangleInsets insets;
   private transient Stroke outlineStroke;
   private transient Paint outlinePaint;
   private transient Paint backgroundPaint;
   private transient Image backgroundImage;
   private int backgroundImageAlignment = 15;
   private float backgroundImageAlpha = 0.5F;
   private float foregroundAlpha;
   private float backgroundAlpha;
   private DrawingSupplier drawingSupplier;
   private transient EventListenerList listenerList;
   static Class class$org$jfree$chart$event$PlotChangeListener;

   protected Plot() {
      this.insets = DEFAULT_INSETS;
      this.backgroundPaint = DEFAULT_BACKGROUND_PAINT;
      this.backgroundAlpha = 1.0F;
      this.backgroundImage = null;
      this.outlineStroke = DEFAULT_OUTLINE_STROKE;
      this.outlinePaint = DEFAULT_OUTLINE_PAINT;
      this.foregroundAlpha = 1.0F;
      this.noDataMessage = null;
      this.noDataMessageFont = new Font("SansSerif", 0, 12);
      this.noDataMessagePaint = Color.black;
      this.drawingSupplier = new DefaultDrawingSupplier();
      this.listenerList = new EventListenerList();
   }

   public DatasetGroup getDatasetGroup() {
      return this.datasetGroup;
   }

   protected void setDatasetGroup(DatasetGroup var1) {
      this.datasetGroup = var1;
   }

   public String getNoDataMessage() {
      return this.noDataMessage;
   }

   public void setNoDataMessage(String var1) {
      this.noDataMessage = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Font getNoDataMessageFont() {
      return this.noDataMessageFont;
   }

   public void setNoDataMessageFont(Font var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'font\' argument.");
      } else {
         this.noDataMessageFont = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Paint getNoDataMessagePaint() {
      return this.noDataMessagePaint;
   }

   public void setNoDataMessagePaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.noDataMessagePaint = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public abstract String getPlotType();

   public Plot getParent() {
      return this.parent;
   }

   public void setParent(Plot var1) {
      this.parent = var1;
   }

   public Plot getRootPlot() {
      Plot var1 = this.getParent();
      return var1 == null?this:var1.getRootPlot();
   }

   public boolean isSubplot() {
      return this.getParent() != null;
   }

   public RectangleInsets getInsets() {
      return this.insets;
   }

   public void setInsets(RectangleInsets var1) {
      this.setInsets(var1, true);
   }

   public void setInsets(RectangleInsets var1, boolean var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'insets\' argument.");
      } else {
         if(!this.insets.equals(var1)) {
            this.insets = var1;
            if(var2) {
               this.notifyListeners(new PlotChangeEvent(this));
            }
         }

      }
   }

   public Paint getBackgroundPaint() {
      return this.backgroundPaint;
   }

   public void setBackgroundPaint(Paint var1) {
      if(var1 == null) {
         if(this.backgroundPaint != null) {
            this.backgroundPaint = null;
            this.notifyListeners(new PlotChangeEvent(this));
         }
      } else {
         if(this.backgroundPaint != null && this.backgroundPaint.equals(var1)) {
            return;
         }

         this.backgroundPaint = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public float getBackgroundAlpha() {
      return this.backgroundAlpha;
   }

   public void setBackgroundAlpha(float var1) {
      if(this.backgroundAlpha != var1) {
         this.backgroundAlpha = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public DrawingSupplier getDrawingSupplier() {
      DrawingSupplier var1 = null;
      Plot var2 = this.getParent();
      if(var2 != null) {
         var1 = var2.getDrawingSupplier();
      } else {
         var1 = this.drawingSupplier;
      }

      return var1;
   }

   public void setDrawingSupplier(DrawingSupplier var1) {
      this.drawingSupplier = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Image getBackgroundImage() {
      return this.backgroundImage;
   }

   public void setBackgroundImage(Image var1) {
      this.backgroundImage = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public int getBackgroundImageAlignment() {
      return this.backgroundImageAlignment;
   }

   public void setBackgroundImageAlignment(int var1) {
      if(this.backgroundImageAlignment != var1) {
         this.backgroundImageAlignment = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public float getBackgroundImageAlpha() {
      return this.backgroundImageAlpha;
   }

   public void setBackgroundImageAlpha(float var1) {
      if(var1 >= 0.0F && var1 <= 1.0F) {
         if(this.backgroundImageAlpha != var1) {
            this.backgroundImageAlpha = var1;
            this.notifyListeners(new PlotChangeEvent(this));
         }

      } else {
         throw new IllegalArgumentException("The \'alpha\' value must be in the range 0.0f to 1.0f.");
      }
   }

   public Stroke getOutlineStroke() {
      return this.outlineStroke;
   }

   public void setOutlineStroke(Stroke var1) {
      if(var1 == null) {
         if(this.outlineStroke != null) {
            this.outlineStroke = null;
            this.notifyListeners(new PlotChangeEvent(this));
         }
      } else {
         if(this.outlineStroke != null && this.outlineStroke.equals(var1)) {
            return;
         }

         this.outlineStroke = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public Paint getOutlinePaint() {
      return this.outlinePaint;
   }

   public void setOutlinePaint(Paint var1) {
      if(var1 == null) {
         if(this.outlinePaint != null) {
            this.outlinePaint = null;
            this.notifyListeners(new PlotChangeEvent(this));
         }
      } else {
         if(this.outlinePaint != null && this.outlinePaint.equals(var1)) {
            return;
         }

         this.outlinePaint = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public float getForegroundAlpha() {
      return this.foregroundAlpha;
   }

   public void setForegroundAlpha(float var1) {
      if(this.foregroundAlpha != var1) {
         this.foregroundAlpha = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public LegendItemCollection getLegendItems() {
      return null;
   }

   public void addChangeListener(PlotChangeListener var1) {
      this.listenerList.add(class$org$jfree$chart$event$PlotChangeListener == null?(class$org$jfree$chart$event$PlotChangeListener = class$("org.jfree.chart.event.PlotChangeListener")):class$org$jfree$chart$event$PlotChangeListener, var1);
   }

   public void removeChangeListener(PlotChangeListener var1) {
      this.listenerList.remove(class$org$jfree$chart$event$PlotChangeListener == null?(class$org$jfree$chart$event$PlotChangeListener = class$("org.jfree.chart.event.PlotChangeListener")):class$org$jfree$chart$event$PlotChangeListener, var1);
   }

   public void notifyListeners(PlotChangeEvent var1) {
      Object[] var2 = this.listenerList.getListenerList();

      for(int var3 = var2.length - 2; var3 >= 0; var3 -= 2) {
         if(var2[var3] == (class$org$jfree$chart$event$PlotChangeListener == null?(class$org$jfree$chart$event$PlotChangeListener = class$("org.jfree.chart.event.PlotChangeListener")):class$org$jfree$chart$event$PlotChangeListener)) {
            ((PlotChangeListener)var2[var3 + 1]).plotChanged(var1);
         }
      }

   }

   public abstract void draw(Graphics2D var1, Rectangle2D var2, Point2D var3, PlotState var4, PlotRenderingInfo var5);

   public void drawBackground(Graphics2D var1, Rectangle2D var2) {
      this.fillBackground(var1, var2);
      this.drawBackgroundImage(var1, var2);
   }

   protected void fillBackground(Graphics2D var1, Rectangle2D var2) {
      if(this.backgroundPaint != null) {
         Composite var3 = var1.getComposite();
         var1.setComposite(AlphaComposite.getInstance(3, this.backgroundAlpha));
         var1.setPaint(this.backgroundPaint);
         var1.fill(var2);
         var1.setComposite(var3);
      }

   }

   protected void drawBackgroundImage(Graphics2D var1, Rectangle2D var2) {
      if(this.backgroundImage != null) {
         Composite var3 = var1.getComposite();
         var1.setComposite(AlphaComposite.getInstance(3, this.backgroundImageAlpha));
         Double var4 = new Double(0.0D, 0.0D, (double)this.backgroundImage.getWidth((ImageObserver)null), (double)this.backgroundImage.getHeight((ImageObserver)null));
         Align.align(var4, var2, this.backgroundImageAlignment);
         var1.drawImage(this.backgroundImage, (int)var4.getX(), (int)var4.getY(), (int)var4.getWidth() + 1, (int)var4.getHeight() + 1, (ImageObserver)null);
         var1.setComposite(var3);
      }

   }

   public void drawOutline(Graphics2D var1, Rectangle2D var2) {
      if(this.outlineStroke != null && this.outlinePaint != null) {
         var1.setStroke(this.outlineStroke);
         var1.setPaint(this.outlinePaint);
         var1.draw(var2);
      }

   }

   protected void drawNoDataMessage(Graphics2D var1, Rectangle2D var2) {
      Shape var3 = var1.getClip();
      var1.clip(var2);
      String var4 = this.noDataMessage;
      if(var4 != null) {
         var1.setFont(this.noDataMessageFont);
         var1.setPaint(this.noDataMessagePaint);
         TextBlock var5 = TextUtilities.createTextBlock(this.noDataMessage, this.noDataMessageFont, this.noDataMessagePaint, 0.9F * (float)var2.getWidth(), new G2TextMeasurer(var1));
         var5.draw(var1, (float)var2.getCenterX(), (float)var2.getCenterY(), TextBlockAnchor.CENTER);
      }

      var1.setClip(var3);
   }

   public void handleClick(int var1, int var2, PlotRenderingInfo var3) {
   }

   public void zoom(double var1) {
   }

   public void axisChanged(AxisChangeEvent var1) {
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public void datasetChanged(DatasetChangeEvent var1) {
      PlotChangeEvent var2 = new PlotChangeEvent(this);
      var2.setType(ChartChangeEventType.DATASET_UPDATED);
      this.notifyListeners(var2);
   }

   public void markerChanged(MarkerChangeEvent var1) {
      this.notifyListeners(new PlotChangeEvent(this));
   }

   protected double getRectX(double var1, double var3, double var5, RectangleEdge var7) {
      double var8 = var1;
      if(var7 == RectangleEdge.LEFT) {
         var8 = var1 + var3;
      } else if(var7 == RectangleEdge.RIGHT) {
         var8 = var1 + var5;
      }

      return var8;
   }

   protected double getRectY(double var1, double var3, double var5, RectangleEdge var7) {
      double var8 = var1;
      if(var7 == RectangleEdge.TOP) {
         var8 = var1 + var3;
      } else if(var7 == RectangleEdge.BOTTOM) {
         var8 = var1 + var5;
      }

      return var8;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof Plot)) {
         return false;
      } else {
         Plot var2 = (Plot)var1;
         return !ObjectUtilities.equal(this.noDataMessage, var2.noDataMessage)?false:(!ObjectUtilities.equal(this.noDataMessageFont, var2.noDataMessageFont)?false:(!PaintUtilities.equal(this.noDataMessagePaint, var2.noDataMessagePaint)?false:(!ObjectUtilities.equal(this.insets, var2.insets)?false:(!ObjectUtilities.equal(this.outlineStroke, var2.outlineStroke)?false:(!PaintUtilities.equal(this.outlinePaint, var2.outlinePaint)?false:(!PaintUtilities.equal(this.backgroundPaint, var2.backgroundPaint)?false:(!ObjectUtilities.equal(this.backgroundImage, var2.backgroundImage)?false:(this.backgroundImageAlignment != var2.backgroundImageAlignment?false:(this.backgroundImageAlpha != var2.backgroundImageAlpha?false:(this.foregroundAlpha != var2.foregroundAlpha?false:(this.backgroundAlpha != var2.backgroundAlpha?false:this.drawingSupplier.equals(var2.drawingSupplier))))))))))));
      }
   }

   public Object clone() {
      Plot var1 = (Plot)super.clone();
      if(this.datasetGroup != null) {
         var1.datasetGroup = (DatasetGroup)ObjectUtilities.clone(this.datasetGroup);
      }

      var1.drawingSupplier = (DrawingSupplier)ObjectUtilities.clone(this.drawingSupplier);
      var1.listenerList = new EventListenerList();
      return var1;
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.noDataMessagePaint, var1);
      SerialUtilities.writeStroke(this.outlineStroke, var1);
      SerialUtilities.writePaint(this.outlinePaint, var1);
      SerialUtilities.writePaint(this.backgroundPaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.noDataMessagePaint = SerialUtilities.readPaint(var1);
      this.outlineStroke = SerialUtilities.readStroke(var1);
      this.outlinePaint = SerialUtilities.readPaint(var1);
      this.backgroundPaint = SerialUtilities.readPaint(var1);
      this.listenerList = new EventListenerList();
   }

   public static RectangleEdge resolveDomainAxisLocation(AxisLocation var0, PlotOrientation var1) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'location\' argument.");
      } else if(var1 == null) {
         throw new IllegalArgumentException("Null \'orientation\' argument.");
      } else {
         RectangleEdge var2 = null;
         if(var0 == AxisLocation.TOP_OR_RIGHT) {
            if(var1 == PlotOrientation.HORIZONTAL) {
               var2 = RectangleEdge.RIGHT;
            } else if(var1 == PlotOrientation.VERTICAL) {
               var2 = RectangleEdge.TOP;
            }
         } else if(var0 == AxisLocation.TOP_OR_LEFT) {
            if(var1 == PlotOrientation.HORIZONTAL) {
               var2 = RectangleEdge.LEFT;
            } else if(var1 == PlotOrientation.VERTICAL) {
               var2 = RectangleEdge.TOP;
            }
         } else if(var0 == AxisLocation.BOTTOM_OR_RIGHT) {
            if(var1 == PlotOrientation.HORIZONTAL) {
               var2 = RectangleEdge.RIGHT;
            } else if(var1 == PlotOrientation.VERTICAL) {
               var2 = RectangleEdge.BOTTOM;
            }
         } else if(var0 == AxisLocation.BOTTOM_OR_LEFT) {
            if(var1 == PlotOrientation.HORIZONTAL) {
               var2 = RectangleEdge.LEFT;
            } else if(var1 == PlotOrientation.VERTICAL) {
               var2 = RectangleEdge.BOTTOM;
            }
         }

         if(var2 == null) {
            throw new IllegalStateException("resolveDomainAxisLocation()");
         } else {
            return var2;
         }
      }
   }

   public static RectangleEdge resolveRangeAxisLocation(AxisLocation var0, PlotOrientation var1) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'location\' argument.");
      } else if(var1 == null) {
         throw new IllegalArgumentException("Null \'orientation\' argument.");
      } else {
         RectangleEdge var2 = null;
         if(var0 == AxisLocation.TOP_OR_RIGHT) {
            if(var1 == PlotOrientation.HORIZONTAL) {
               var2 = RectangleEdge.TOP;
            } else if(var1 == PlotOrientation.VERTICAL) {
               var2 = RectangleEdge.RIGHT;
            }
         } else if(var0 == AxisLocation.TOP_OR_LEFT) {
            if(var1 == PlotOrientation.HORIZONTAL) {
               var2 = RectangleEdge.TOP;
            } else if(var1 == PlotOrientation.VERTICAL) {
               var2 = RectangleEdge.LEFT;
            }
         } else if(var0 == AxisLocation.BOTTOM_OR_RIGHT) {
            if(var1 == PlotOrientation.HORIZONTAL) {
               var2 = RectangleEdge.BOTTOM;
            } else if(var1 == PlotOrientation.VERTICAL) {
               var2 = RectangleEdge.RIGHT;
            }
         } else if(var0 == AxisLocation.BOTTOM_OR_LEFT) {
            if(var1 == PlotOrientation.HORIZONTAL) {
               var2 = RectangleEdge.BOTTOM;
            } else if(var1 == PlotOrientation.VERTICAL) {
               var2 = RectangleEdge.LEFT;
            }
         }

         if(var2 == null) {
            throw new IllegalStateException("resolveRangeAxisLocation()");
         } else {
            return var2;
         }
      }
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }

   static {
      DEFAULT_OUTLINE_PAINT = Color.gray;
      DEFAULT_BACKGROUND_PAINT = Color.white;
      DEFAULT_LEGEND_ITEM_BOX = new Double(-4.0D, -4.0D, 8.0D, 8.0D);
      DEFAULT_LEGEND_ITEM_CIRCLE = new java.awt.geom.Ellipse2D.Double(-4.0D, -4.0D, 8.0D, 8.0D);
   }
}
