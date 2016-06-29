package org.jfree.chart;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.UIManager;
import javax.swing.event.EventListenerList;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChartInfo;
import org.jfree.chart.block.BlockParams;
import org.jfree.chart.block.EntityBlockResult;
import org.jfree.chart.block.LengthConstraintType;
import org.jfree.chart.block.LineBorder;
import org.jfree.chart.block.RectangleConstraint;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.ChartChangeEvent;
import org.jfree.chart.event.ChartChangeListener;
import org.jfree.chart.event.ChartProgressEvent;
import org.jfree.chart.event.ChartProgressListener;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.event.PlotChangeListener;
import org.jfree.chart.event.TitleChangeEvent;
import org.jfree.chart.event.TitleChangeListener;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.Range;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.Align;
import org.jfree.ui.Drawable;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.Size2D;
import org.jfree.ui.VerticalAlignment;
import org.jfree.ui.about.ProjectInfo;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;

public class JFreeChart implements Serializable, Cloneable, PlotChangeListener, TitleChangeListener, Drawable {
   private static final long serialVersionUID = -3470703747817429120L;
   public static final ProjectInfo INFO = new JFreeChartInfo();
   public static final Font DEFAULT_TITLE_FONT = new Font("SansSerif", 1, 18);
   public static final Paint DEFAULT_BACKGROUND_PAINT = UIManager.getColor("Panel.background");
   public static final Image DEFAULT_BACKGROUND_IMAGE = null;
   public static final int DEFAULT_BACKGROUND_IMAGE_ALIGNMENT = 15;
   public static final float DEFAULT_BACKGROUND_IMAGE_ALPHA = 0.5F;
   private transient RenderingHints renderingHints;
   private boolean borderVisible;
   private transient Stroke borderStroke;
   private transient Paint borderPaint;
   private RectangleInsets padding;
   private TextTitle title;
   private List subtitles;
   private Plot plot;
   private transient Paint backgroundPaint;
   private transient Image backgroundImage;
   private int backgroundImageAlignment;
   private float backgroundImageAlpha;
   private transient EventListenerList changeListeners;
   private transient EventListenerList progressListeners;
   private boolean notify;
   static Class class$org$jfree$chart$event$ChartChangeListener;
   static Class class$org$jfree$chart$event$ChartProgressListener;

   public JFreeChart(Plot var1) {
      this((String)null, (Font)null, var1, true);
   }

   public JFreeChart(String var1, Plot var2) {
      this(var1, DEFAULT_TITLE_FONT, var2, true);
   }

   public JFreeChart(String var1, Font var2, Plot var3, boolean var4) {
      this.backgroundImageAlignment = 15;
      this.backgroundImageAlpha = 0.5F;
      if(var3 == null) {
         throw new NullPointerException("Null \'plot\' argument.");
      } else {
         this.progressListeners = new EventListenerList();
         this.changeListeners = new EventListenerList();
         this.notify = true;
         this.renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
         this.borderVisible = false;
         this.borderStroke = new BasicStroke(1.0F);
         this.borderPaint = Color.black;
         this.padding = RectangleInsets.ZERO_INSETS;
         this.plot = var3;
         var3.addChangeListener(this);
         this.subtitles = new ArrayList();
         if(var4) {
            LegendTitle var5 = new LegendTitle(this.plot);
            var5.setMargin(new RectangleInsets(1.0D, 1.0D, 1.0D, 1.0D));
            var5.setFrame(new LineBorder());
            var5.setBackgroundPaint(Color.white);
            var5.setPosition(RectangleEdge.BOTTOM);
            this.subtitles.add(var5);
         }

         if(var1 != null) {
            if(var2 == null) {
               var2 = DEFAULT_TITLE_FONT;
            }

            this.title = new TextTitle(var1, var2);
            this.title.addChangeListener(this);
         }

         this.backgroundPaint = DEFAULT_BACKGROUND_PAINT;
         this.backgroundImage = DEFAULT_BACKGROUND_IMAGE;
         this.backgroundImageAlignment = 15;
         this.backgroundImageAlpha = 0.5F;
      }
   }

   public RenderingHints getRenderingHints() {
      return this.renderingHints;
   }

   public void setRenderingHints(RenderingHints var1) {
      if(var1 == null) {
         throw new NullPointerException("RenderingHints given are null");
      } else {
         this.renderingHints = var1;
         this.fireChartChanged();
      }
   }

   public boolean isBorderVisible() {
      return this.borderVisible;
   }

   public void setBorderVisible(boolean var1) {
      this.borderVisible = var1;
      this.fireChartChanged();
   }

   public Stroke getBorderStroke() {
      return this.borderStroke;
   }

   public void setBorderStroke(Stroke var1) {
      this.borderStroke = var1;
      this.fireChartChanged();
   }

   public Paint getBorderPaint() {
      return this.borderPaint;
   }

   public void setBorderPaint(Paint var1) {
      this.borderPaint = var1;
      this.fireChartChanged();
   }

   public RectangleInsets getPadding() {
      return this.padding;
   }

   public void setPadding(RectangleInsets var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'padding\' argument.");
      } else {
         this.padding = var1;
         this.notifyListeners(new ChartChangeEvent(this));
      }
   }

   public TextTitle getTitle() {
      return this.title;
   }

   public void setTitle(TextTitle var1) {
      this.title = var1;
      this.fireChartChanged();
   }

   public void setTitle(String var1) {
      if(var1 != null) {
         if(this.title == null) {
            this.setTitle(new TextTitle(var1, DEFAULT_TITLE_FONT));
         } else {
            this.title.setText(var1);
         }
      } else {
         this.setTitle((TextTitle)null);
      }

   }

   public void addLegend(LegendTitle var1) {
      this.addSubtitle(var1);
   }

   public LegendTitle getLegend() {
      return this.getLegend(0);
   }

   public LegendTitle getLegend(int var1) {
      int var2 = 0;
      Iterator var3 = this.subtitles.iterator();

      while(var3.hasNext()) {
         Title var4 = (Title)var3.next();
         if(var4 instanceof LegendTitle) {
            if(var2 == var1) {
               return (LegendTitle)var4;
            }

            ++var2;
         }
      }

      return null;
   }

   public void removeLegend() {
      this.removeSubtitle(this.getLegend());
   }

   public List getSubtitles() {
      return this.subtitles;
   }

   public void setSubtitles(List var1) {
      if(var1 == null) {
         throw new NullPointerException("Null \'subtitles\' argument.");
      } else {
         this.subtitles = var1;
         this.fireChartChanged();
      }
   }

   public int getSubtitleCount() {
      return this.subtitles.size();
   }

   public Title getSubtitle(int var1) {
      if(var1 >= 0 && var1 != this.getSubtitleCount()) {
         return (Title)this.subtitles.get(var1);
      } else {
         throw new IllegalArgumentException("Index out of range.");
      }
   }

   public void addSubtitle(Title var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'subtitle\' argument.");
      } else {
         this.subtitles.add(var1);
         var1.addChangeListener(this);
         this.fireChartChanged();
      }
   }

   public void clearSubtitles() {
      Iterator var1 = this.subtitles.iterator();

      while(var1.hasNext()) {
         Title var2 = (Title)var1.next();
         var2.removeChangeListener(this);
      }

      this.subtitles.clear();
      this.fireChartChanged();
   }

   public void removeSubtitle(Title var1) {
      this.subtitles.remove(var1);
      this.fireChartChanged();
   }

   public Plot getPlot() {
      return this.plot;
   }

   public CategoryPlot getCategoryPlot() {
      return (CategoryPlot)this.plot;
   }

   public XYPlot getXYPlot() {
      return (XYPlot)this.plot;
   }

   public boolean getAntiAlias() {
      Object var1 = this.renderingHints.get(RenderingHints.KEY_ANTIALIASING);
      return RenderingHints.VALUE_ANTIALIAS_ON.equals(var1);
   }

   public void setAntiAlias(boolean var1) {
      Object var2 = this.renderingHints.get(RenderingHints.KEY_ANTIALIASING);
      if(var2 == null) {
         var2 = RenderingHints.VALUE_ANTIALIAS_DEFAULT;
      }

      if((var1 || !RenderingHints.VALUE_ANTIALIAS_OFF.equals(var2)) && (!var1 || !RenderingHints.VALUE_ANTIALIAS_ON.equals(var2))) {
         if(var1) {
            this.renderingHints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
         } else {
            this.renderingHints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
         }

         this.fireChartChanged();
      }
   }

   public Object getTextAntiAlias() {
      return this.renderingHints.get(RenderingHints.KEY_TEXT_ANTIALIASING);
   }

   public void setTextAntiAlias(boolean var1) {
      if(var1) {
         this.setTextAntiAlias(RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
      } else {
         this.setTextAntiAlias(RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
      }

   }

   public void setTextAntiAlias(Object var1) {
      this.renderingHints.put(RenderingHints.KEY_TEXT_ANTIALIASING, var1);
      this.notifyListeners(new ChartChangeEvent(this));
   }

   public Paint getBackgroundPaint() {
      return this.backgroundPaint;
   }

   public void setBackgroundPaint(Paint var1) {
      if(this.backgroundPaint != null) {
         if(!this.backgroundPaint.equals(var1)) {
            this.backgroundPaint = var1;
            this.fireChartChanged();
         }
      } else if(var1 != null) {
         this.backgroundPaint = var1;
         this.fireChartChanged();
      }

   }

   public Image getBackgroundImage() {
      return this.backgroundImage;
   }

   public void setBackgroundImage(Image var1) {
      if(this.backgroundImage != null) {
         if(!this.backgroundImage.equals(var1)) {
            this.backgroundImage = var1;
            this.fireChartChanged();
         }
      } else if(var1 != null) {
         this.backgroundImage = var1;
         this.fireChartChanged();
      }

   }

   public int getBackgroundImageAlignment() {
      return this.backgroundImageAlignment;
   }

   public void setBackgroundImageAlignment(int var1) {
      if(this.backgroundImageAlignment != var1) {
         this.backgroundImageAlignment = var1;
         this.fireChartChanged();
      }

   }

   public float getBackgroundImageAlpha() {
      return this.backgroundImageAlpha;
   }

   public void setBackgroundImageAlpha(float var1) {
      if(this.backgroundImageAlpha != var1) {
         this.backgroundImageAlpha = var1;
         this.fireChartChanged();
      }

   }

   public boolean isNotify() {
      return this.notify;
   }

   public void setNotify(boolean var1) {
      this.notify = var1;
      if(var1) {
         this.notifyListeners(new ChartChangeEvent(this));
      }

   }

   public void draw(Graphics2D var1, Rectangle2D var2) {
      this.draw(var1, var2, (Point2D)null, (ChartRenderingInfo)null);
   }

   public void draw(Graphics2D var1, Rectangle2D var2, ChartRenderingInfo var3) {
      this.draw(var1, var2, (Point2D)null, var3);
   }

   public void draw(Graphics2D var1, Rectangle2D var2, Point2D var3, ChartRenderingInfo var4) {
      this.notifyListeners(new ChartProgressEvent(this, this, 1, 0));
      if(var4 != null) {
         var4.clear();
         var4.setChartArea(var2);
      }

      Shape var5 = var1.getClip();
      var1.clip(var2);
      var1.addRenderingHints(this.renderingHints);
      if(this.backgroundPaint != null) {
         var1.setPaint(this.backgroundPaint);
         var1.fill(var2);
      }

      if(this.backgroundImage != null) {
         Composite var6 = var1.getComposite();
         var1.setComposite(AlphaComposite.getInstance(3, this.backgroundImageAlpha));
         Double var7 = new Double(0.0D, 0.0D, (double)this.backgroundImage.getWidth((ImageObserver)null), (double)this.backgroundImage.getHeight((ImageObserver)null));
         Align.align(var7, var2, this.backgroundImageAlignment);
         var1.drawImage(this.backgroundImage, (int)var7.getX(), (int)var7.getY(), (int)var7.getWidth(), (int)var7.getHeight(), (ImageObserver)null);
         var1.setComposite(var6);
      }

      if(this.isBorderVisible()) {
         Paint var11 = this.getBorderPaint();
         Stroke var13 = this.getBorderStroke();
         if(var11 != null && var13 != null) {
            Double var8 = new Double(var2.getX(), var2.getY(), var2.getWidth() - 1.0D, var2.getHeight() - 1.0D);
            var1.setPaint(var11);
            var1.setStroke(var13);
            var1.draw(var8);
         }
      }

      Double var12 = new Double();
      var12.setRect(var2);
      this.padding.trim(var12);
      EntityCollection var14 = null;
      if(var4 != null) {
         var14 = var4.getEntityCollection();
      }

      if(this.title != null) {
         EntityCollection var15 = this.drawTitle(this.title, var1, var12, var14 != null);
         if(var15 != null) {
            var14.addAll(var15);
         }
      }

      Iterator var16 = this.subtitles.iterator();

      while(var16.hasNext()) {
         Title var9 = (Title)var16.next();
         EntityCollection var10 = this.drawTitle(var9, var1, var12, var14 != null);
         if(var10 != null) {
            var14.addAll(var10);
         }
      }

      PlotRenderingInfo var17 = null;
      if(var4 != null) {
         var17 = var4.getPlotInfo();
      }

      this.plot.draw(var1, var12, var3, (PlotState)null, var17);
      var1.setClip(var5);
      this.notifyListeners(new ChartProgressEvent(this, this, 2, 100));
   }

   private Rectangle2D createAlignedRectangle2D(Size2D var1, Rectangle2D var2, HorizontalAlignment var3, VerticalAlignment var4) {
      double var5 = java.lang.Double.NaN;
      double var7 = java.lang.Double.NaN;
      if(var3 == HorizontalAlignment.LEFT) {
         var5 = var2.getX();
      } else if(var3 == HorizontalAlignment.CENTER) {
         var5 = var2.getCenterX() - var1.width / 2.0D;
      } else if(var3 == HorizontalAlignment.RIGHT) {
         var5 = var2.getMaxX() - var1.width;
      }

      if(var4 == VerticalAlignment.TOP) {
         var7 = var2.getY();
      } else if(var4 == VerticalAlignment.CENTER) {
         var7 = var2.getCenterY() - var1.height / 2.0D;
      } else if(var4 == VerticalAlignment.BOTTOM) {
         var7 = var2.getMaxY() - var1.height;
      }

      return new Double(var5, var7, var1.width, var1.height);
   }

   protected EntityCollection drawTitle(Title var1, Graphics2D var2, Rectangle2D var3, boolean var4) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'t\' argument.");
      } else if(var3 == null) {
         throw new IllegalArgumentException("Null \'area\' argument.");
      } else {
         new Double();
         RectangleEdge var6 = var1.getPosition();
         double var7 = var3.getWidth();
         if(var7 <= 0.0D) {
            return null;
         } else {
            double var9 = var3.getHeight();
            if(var9 <= 0.0D) {
               return null;
            } else {
               RectangleConstraint var11 = new RectangleConstraint(var7, new Range(0.0D, var7), LengthConstraintType.RANGE, var9, new Range(0.0D, var9), LengthConstraintType.RANGE);
               Object var12 = null;
               BlockParams var13 = new BlockParams();
               var13.setGenerateEntities(var4);
               Rectangle2D var5;
               Size2D var14;
               if(var6 == RectangleEdge.TOP) {
                  var14 = var1.arrange(var2, var11);
                  var5 = this.createAlignedRectangle2D(var14, var3, var1.getHorizontalAlignment(), VerticalAlignment.TOP);
                  var12 = var1.draw(var2, var5, var13);
                  var3.setRect(var3.getX(), Math.min(var3.getY() + var14.height, var3.getMaxY()), var3.getWidth(), Math.max(var3.getHeight() - var14.height, 0.0D));
               } else if(var6 == RectangleEdge.BOTTOM) {
                  var14 = var1.arrange(var2, var11);
                  var5 = this.createAlignedRectangle2D(var14, var3, var1.getHorizontalAlignment(), VerticalAlignment.BOTTOM);
                  var12 = var1.draw(var2, var5, var13);
                  var3.setRect(var3.getX(), var3.getY(), var3.getWidth(), var3.getHeight() - var14.height);
               } else if(var6 == RectangleEdge.RIGHT) {
                  var14 = var1.arrange(var2, var11);
                  var5 = this.createAlignedRectangle2D(var14, var3, HorizontalAlignment.RIGHT, var1.getVerticalAlignment());
                  var12 = var1.draw(var2, var5, var13);
                  var3.setRect(var3.getX(), var3.getY(), var3.getWidth() - var14.width, var3.getHeight());
               } else {
                  if(var6 != RectangleEdge.LEFT) {
                     throw new RuntimeException("Unrecognised title position.");
                  }

                  var14 = var1.arrange(var2, var11);
                  var5 = this.createAlignedRectangle2D(var14, var3, HorizontalAlignment.LEFT, var1.getVerticalAlignment());
                  var12 = var1.draw(var2, var5, var13);
                  var3.setRect(var3.getX() + var14.width, var3.getY(), var3.getWidth() - var14.width, var3.getHeight());
               }

               EntityCollection var16 = null;
               if(var12 instanceof EntityBlockResult) {
                  EntityBlockResult var15 = (EntityBlockResult)var12;
                  var16 = var15.getEntityCollection();
               }

               return var16;
            }
         }
      }
   }

   public BufferedImage createBufferedImage(int var1, int var2) {
      return this.createBufferedImage(var1, var2, (ChartRenderingInfo)null);
   }

   public BufferedImage createBufferedImage(int var1, int var2, ChartRenderingInfo var3) {
      return this.createBufferedImage(var1, var2, 1, var3);
   }

   public BufferedImage createBufferedImage(int var1, int var2, int var3, ChartRenderingInfo var4) {
      BufferedImage var5 = new BufferedImage(var1, var2, var3);
      Graphics2D var6 = var5.createGraphics();
      this.draw(var6, new Double(0.0D, 0.0D, (double)var1, (double)var2), (Point2D)null, var4);
      var6.dispose();
      return var5;
   }

   public BufferedImage createBufferedImage(int var1, int var2, double var3, double var5, ChartRenderingInfo var7) {
      BufferedImage var8 = new BufferedImage(var1, var2, 1);
      Graphics2D var9 = var8.createGraphics();
      double var10 = (double)var1 / var3;
      double var12 = (double)var2 / var5;
      AffineTransform var14 = AffineTransform.getScaleInstance(var10, var12);
      var9.transform(var14);
      this.draw(var9, new Double(0.0D, 0.0D, var3, var5), (Point2D)null, var7);
      var9.dispose();
      return var8;
   }

   public void handleClick(int var1, int var2, ChartRenderingInfo var3) {
      this.plot.handleClick(var1, var2, var3.getPlotInfo());
   }

   public void addChangeListener(ChartChangeListener var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'listener\' argument.");
      } else {
         this.changeListeners.add(class$org$jfree$chart$event$ChartChangeListener == null?(class$org$jfree$chart$event$ChartChangeListener = class$("org.jfree.chart.event.ChartChangeListener")):class$org$jfree$chart$event$ChartChangeListener, var1);
      }
   }

   public void removeChangeListener(ChartChangeListener var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'listener\' argument.");
      } else {
         this.changeListeners.remove(class$org$jfree$chart$event$ChartChangeListener == null?(class$org$jfree$chart$event$ChartChangeListener = class$("org.jfree.chart.event.ChartChangeListener")):class$org$jfree$chart$event$ChartChangeListener, var1);
      }
   }

   public void fireChartChanged() {
      ChartChangeEvent var1 = new ChartChangeEvent(this);
      this.notifyListeners(var1);
   }

   protected void notifyListeners(ChartChangeEvent var1) {
      if(this.notify) {
         Object[] var2 = this.changeListeners.getListenerList();

         for(int var3 = var2.length - 2; var3 >= 0; var3 -= 2) {
            if(var2[var3] == (class$org$jfree$chart$event$ChartChangeListener == null?(class$org$jfree$chart$event$ChartChangeListener = class$("org.jfree.chart.event.ChartChangeListener")):class$org$jfree$chart$event$ChartChangeListener)) {
               ((ChartChangeListener)var2[var3 + 1]).chartChanged(var1);
            }
         }
      }

   }

   public void addProgressListener(ChartProgressListener var1) {
      this.progressListeners.add(class$org$jfree$chart$event$ChartProgressListener == null?(class$org$jfree$chart$event$ChartProgressListener = class$("org.jfree.chart.event.ChartProgressListener")):class$org$jfree$chart$event$ChartProgressListener, var1);
   }

   public void removeProgressListener(ChartProgressListener var1) {
      this.progressListeners.remove(class$org$jfree$chart$event$ChartProgressListener == null?(class$org$jfree$chart$event$ChartProgressListener = class$("org.jfree.chart.event.ChartProgressListener")):class$org$jfree$chart$event$ChartProgressListener, var1);
   }

   protected void notifyListeners(ChartProgressEvent var1) {
      Object[] var2 = this.progressListeners.getListenerList();

      for(int var3 = var2.length - 2; var3 >= 0; var3 -= 2) {
         if(var2[var3] == (class$org$jfree$chart$event$ChartProgressListener == null?(class$org$jfree$chart$event$ChartProgressListener = class$("org.jfree.chart.event.ChartProgressListener")):class$org$jfree$chart$event$ChartProgressListener)) {
            ((ChartProgressListener)var2[var3 + 1]).chartProgress(var1);
         }
      }

   }

   public void titleChanged(TitleChangeEvent var1) {
      var1.setChart(this);
      this.notifyListeners((ChartChangeEvent)var1);
   }

   public void plotChanged(PlotChangeEvent var1) {
      var1.setChart(this);
      this.notifyListeners((ChartChangeEvent)var1);
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof JFreeChart)) {
         return false;
      } else {
         JFreeChart var2 = (JFreeChart)var1;
         return !this.renderingHints.equals(var2.renderingHints)?false:(this.borderVisible != var2.borderVisible?false:(!ObjectUtilities.equal(this.borderStroke, var2.borderStroke)?false:(!PaintUtilities.equal(this.borderPaint, var2.borderPaint)?false:(!this.padding.equals(var2.padding)?false:(!ObjectUtilities.equal(this.title, var2.title)?false:(!ObjectUtilities.equal(this.subtitles, var2.subtitles)?false:(!ObjectUtilities.equal(this.plot, var2.plot)?false:(!PaintUtilities.equal(this.backgroundPaint, var2.backgroundPaint)?false:(!ObjectUtilities.equal(this.backgroundImage, var2.backgroundImage)?false:(this.backgroundImageAlignment != var2.backgroundImageAlignment?false:(this.backgroundImageAlpha != var2.backgroundImageAlpha?false:this.notify == var2.notify)))))))))));
      }
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writeStroke(this.borderStroke, var1);
      SerialUtilities.writePaint(this.borderPaint, var1);
      SerialUtilities.writePaint(this.backgroundPaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.borderStroke = SerialUtilities.readStroke(var1);
      this.borderPaint = SerialUtilities.readPaint(var1);
      this.backgroundPaint = SerialUtilities.readPaint(var1);
      this.progressListeners = new EventListenerList();
      this.changeListeners = new EventListenerList();
      this.renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      if(this.title != null) {
         this.title.addChangeListener(this);
      }

      for(int var2 = 0; var2 < this.getSubtitleCount(); ++var2) {
         this.getSubtitle(var2).addChangeListener(this);
      }

      this.plot.addChangeListener(this);
   }

   public static void main(String[] var0) {
      System.out.println(INFO.toString());
   }

   public Object clone() {
      JFreeChart var1 = (JFreeChart)super.clone();
      var1.renderingHints = (RenderingHints)this.renderingHints.clone();
      if(this.title != null) {
         var1.title = (TextTitle)this.title.clone();
         var1.title.addChangeListener(var1);
      }

      var1.subtitles = new ArrayList();

      for(int var2 = 0; var2 < this.getSubtitleCount(); ++var2) {
         Title var3 = (Title)this.getSubtitle(var2).clone();
         var1.subtitles.add(var3);
         var3.addChangeListener(var1);
      }

      if(this.plot != null) {
         var1.plot = (Plot)this.plot.clone();
         var1.plot.addChangeListener(var1);
      }

      var1.progressListeners = new EventListenerList();
      var1.changeListeners = new EventListenerList();
      return var1;
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }
}
