package org.jfree.chart;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D.Float;
import java.awt.geom.Point2D.Double;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.EventListener;
import java.util.ResourceBundle;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.ToolTipManager;
import javax.swing.event.EventListenerList;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.editor.ChartEditor;
import org.jfree.chart.editor.ChartEditorManager;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.ChartChangeEvent;
import org.jfree.chart.event.ChartChangeListener;
import org.jfree.chart.event.ChartProgressEvent;
import org.jfree.chart.event.ChartProgressListener;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.Zoomable;
import org.jfree.ui.ExtensionFileFilter;

public class ChartPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener, Printable, Serializable, ChartChangeListener, ChartProgressListener {
   private static final long serialVersionUID = 6046366297214274674L;
   public static final boolean DEFAULT_BUFFER_USED = false;
   public static final int DEFAULT_WIDTH = 680;
   public static final int DEFAULT_HEIGHT = 420;
   public static final int DEFAULT_MINIMUM_DRAW_WIDTH = 300;
   public static final int DEFAULT_MINIMUM_DRAW_HEIGHT = 200;
   public static final int DEFAULT_MAXIMUM_DRAW_WIDTH = 800;
   public static final int DEFAULT_MAXIMUM_DRAW_HEIGHT = 600;
   public static final int DEFAULT_ZOOM_TRIGGER_DISTANCE = 10;
   public static final String PROPERTIES_COMMAND = "PROPERTIES";
   public static final String SAVE_COMMAND = "SAVE";
   public static final String PRINT_COMMAND = "PRINT";
   public static final String ZOOM_IN_BOTH_COMMAND = "ZOOM_IN_BOTH";
   public static final String ZOOM_IN_DOMAIN_COMMAND = "ZOOM_IN_DOMAIN";
   public static final String ZOOM_IN_RANGE_COMMAND = "ZOOM_IN_RANGE";
   public static final String ZOOM_OUT_BOTH_COMMAND = "ZOOM_OUT_BOTH";
   public static final String ZOOM_OUT_DOMAIN_COMMAND = "ZOOM_DOMAIN_BOTH";
   public static final String ZOOM_OUT_RANGE_COMMAND = "ZOOM_RANGE_BOTH";
   public static final String ZOOM_RESET_BOTH_COMMAND = "ZOOM_RESET_BOTH";
   public static final String ZOOM_RESET_DOMAIN_COMMAND = "ZOOM_RESET_DOMAIN";
   public static final String ZOOM_RESET_RANGE_COMMAND = "ZOOM_RESET_RANGE";
   private JFreeChart chart;
   private EventListenerList chartMouseListeners;
   private boolean useBuffer;
   private boolean refreshBuffer;
   private Image chartBuffer;
   private int chartBufferHeight;
   private int chartBufferWidth;
   private int minimumDrawWidth;
   private int minimumDrawHeight;
   private int maximumDrawWidth;
   private int maximumDrawHeight;
   private JPopupMenu popup;
   private ChartRenderingInfo info;
   private Point2D anchor;
   private double scaleX;
   private double scaleY;
   private PlotOrientation orientation;
   private boolean domainZoomable;
   private boolean rangeZoomable;
   private Point zoomPoint;
   private transient Rectangle2D zoomRectangle;
   private boolean fillZoomRectangle;
   private int zoomTriggerDistance;
   private boolean horizontalAxisTrace;
   private boolean verticalAxisTrace;
   private transient Line2D verticalTraceLine;
   private transient Line2D horizontalTraceLine;
   private JMenuItem zoomInBothMenuItem;
   private JMenuItem zoomInDomainMenuItem;
   private JMenuItem zoomInRangeMenuItem;
   private JMenuItem zoomOutBothMenuItem;
   private JMenuItem zoomOutDomainMenuItem;
   private JMenuItem zoomOutRangeMenuItem;
   private JMenuItem zoomResetBothMenuItem;
   private JMenuItem zoomResetDomainMenuItem;
   private JMenuItem zoomResetRangeMenuItem;
   private boolean enforceFileExtensions;
   private boolean ownToolTipDelaysActive;
   private int originalToolTipInitialDelay;
   private int originalToolTipReshowDelay;
   private int originalToolTipDismissDelay;
   private int ownToolTipInitialDelay;
   private int ownToolTipReshowDelay;
   private int ownToolTipDismissDelay;
   private double zoomInFactor;
   private double zoomOutFactor;
   protected static ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.chart.LocalizationBundle");
   static Class class$org$jfree$chart$ChartMouseListener;

   public ChartPanel(JFreeChart var1) {
      this(var1, 680, 420, 300, 200, 800, 600, false, true, true, true, true, true);
   }

   public ChartPanel(JFreeChart var1, boolean var2) {
      this(var1, 680, 420, 300, 200, 800, 600, var2, true, true, true, true, true);
   }

   public ChartPanel(JFreeChart var1, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6) {
      this(var1, 680, 420, 300, 200, 800, 600, false, var2, var3, var4, var5, var6);
   }

   public ChartPanel(JFreeChart var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, boolean var9, boolean var10, boolean var11, boolean var12, boolean var13) {
      this.orientation = PlotOrientation.VERTICAL;
      this.domainZoomable = false;
      this.rangeZoomable = false;
      this.zoomPoint = null;
      this.zoomRectangle = null;
      this.fillZoomRectangle = false;
      this.horizontalAxisTrace = false;
      this.verticalAxisTrace = false;
      this.zoomInFactor = 0.5D;
      this.zoomOutFactor = 2.0D;
      this.setChart(var1);
      this.chartMouseListeners = new EventListenerList();
      this.info = new ChartRenderingInfo();
      this.setPreferredSize(new Dimension(var2, var3));
      this.useBuffer = var8;
      this.refreshBuffer = false;
      this.minimumDrawWidth = var4;
      this.minimumDrawHeight = var5;
      this.maximumDrawWidth = var6;
      this.maximumDrawHeight = var7;
      this.zoomTriggerDistance = 10;
      this.popup = null;
      if(var9 || var10 || var11 || var12) {
         this.popup = this.createPopupMenu(var9, var10, var11, var12);
      }

      this.enableEvents(16L);
      this.enableEvents(32L);
      this.setDisplayToolTips(var13);
      this.addMouseListener(this);
      this.addMouseMotionListener(this);
      this.enforceFileExtensions = true;
      ToolTipManager var14 = ToolTipManager.sharedInstance();
      this.ownToolTipInitialDelay = var14.getInitialDelay();
      this.ownToolTipDismissDelay = var14.getDismissDelay();
      this.ownToolTipReshowDelay = var14.getReshowDelay();
   }

   public JFreeChart getChart() {
      return this.chart;
   }

   public void setChart(JFreeChart var1) {
      if(this.chart != null) {
         this.chart.removeChangeListener(this);
         this.chart.removeProgressListener(this);
      }

      this.chart = var1;
      if(var1 != null) {
         this.chart.addChangeListener(this);
         this.chart.addProgressListener(this);
         Plot var2 = var1.getPlot();
         this.domainZoomable = false;
         this.rangeZoomable = false;
         if(var2 instanceof Zoomable) {
            Zoomable var3 = (Zoomable)var2;
            this.domainZoomable = var3.isDomainZoomable();
            this.rangeZoomable = var3.isRangeZoomable();
            this.orientation = var3.getOrientation();
         }
      } else {
         this.domainZoomable = false;
         this.rangeZoomable = false;
      }

      if(this.useBuffer) {
         this.refreshBuffer = true;
      }

      this.repaint();
   }

   public int getMinimumDrawWidth() {
      return this.minimumDrawWidth;
   }

   public void setMinimumDrawWidth(int var1) {
      this.minimumDrawWidth = var1;
   }

   public int getMaximumDrawWidth() {
      return this.maximumDrawWidth;
   }

   public void setMaximumDrawWidth(int var1) {
      this.maximumDrawWidth = var1;
   }

   public int getMinimumDrawHeight() {
      return this.minimumDrawHeight;
   }

   public void setMinimumDrawHeight(int var1) {
      this.minimumDrawHeight = var1;
   }

   public int getMaximumDrawHeight() {
      return this.maximumDrawHeight;
   }

   public void setMaximumDrawHeight(int var1) {
      this.maximumDrawHeight = var1;
   }

   public double getScaleX() {
      return this.scaleX;
   }

   public double getScaleY() {
      return this.scaleY;
   }

   public Point2D getAnchor() {
      return this.anchor;
   }

   protected void setAnchor(Point2D var1) {
      this.anchor = var1;
   }

   public JPopupMenu getPopupMenu() {
      return this.popup;
   }

   public void setPopupMenu(JPopupMenu var1) {
      this.popup = var1;
   }

   public ChartRenderingInfo getChartRenderingInfo() {
      return this.info;
   }

   public void setMouseZoomable(boolean var1) {
      this.setMouseZoomable(var1, true);
   }

   public void setMouseZoomable(boolean var1, boolean var2) {
      this.setDomainZoomable(var1);
      this.setRangeZoomable(var1);
      this.setFillZoomRectangle(var2);
   }

   public boolean isDomainZoomable() {
      return this.domainZoomable;
   }

   public void setDomainZoomable(boolean var1) {
      if(var1) {
         Plot var2 = this.chart.getPlot();
         if(var2 instanceof Zoomable) {
            Zoomable var3 = (Zoomable)var2;
            this.domainZoomable = var1 && var3.isDomainZoomable();
         }
      } else {
         this.domainZoomable = false;
      }

   }

   public boolean isRangeZoomable() {
      return this.rangeZoomable;
   }

   public void setRangeZoomable(boolean var1) {
      if(var1) {
         Plot var2 = this.chart.getPlot();
         if(var2 instanceof Zoomable) {
            Zoomable var3 = (Zoomable)var2;
            this.rangeZoomable = var1 && var3.isRangeZoomable();
         }
      } else {
         this.rangeZoomable = false;
      }

   }

   public boolean getFillZoomRectangle() {
      return this.fillZoomRectangle;
   }

   public void setFillZoomRectangle(boolean var1) {
      this.fillZoomRectangle = var1;
   }

   public int getZoomTriggerDistance() {
      return this.zoomTriggerDistance;
   }

   public void setZoomTriggerDistance(int var1) {
      this.zoomTriggerDistance = var1;
   }

   public boolean getHorizontalAxisTrace() {
      return this.horizontalAxisTrace;
   }

   public void setHorizontalAxisTrace(boolean var1) {
      this.horizontalAxisTrace = var1;
   }

   protected Line2D getHorizontalTraceLine() {
      return this.horizontalTraceLine;
   }

   protected void setHorizontalTraceLine(Line2D var1) {
      this.horizontalTraceLine = var1;
   }

   public boolean getVerticalAxisTrace() {
      return this.verticalAxisTrace;
   }

   public void setVerticalAxisTrace(boolean var1) {
      this.verticalAxisTrace = var1;
   }

   protected Line2D getVerticalTraceLine() {
      return this.verticalTraceLine;
   }

   protected void setVerticalTraceLine(Line2D var1) {
      this.verticalTraceLine = var1;
   }

   public boolean isEnforceFileExtensions() {
      return this.enforceFileExtensions;
   }

   public void setEnforceFileExtensions(boolean var1) {
      this.enforceFileExtensions = var1;
   }

   public void setDisplayToolTips(boolean var1) {
      if(var1) {
         ToolTipManager.sharedInstance().registerComponent(this);
      } else {
         ToolTipManager.sharedInstance().unregisterComponent(this);
      }

   }

   public String getToolTipText(MouseEvent var1) {
      String var2 = null;
      if(this.info != null) {
         EntityCollection var3 = this.info.getEntityCollection();
         if(var3 != null) {
            Insets var4 = this.getInsets();
            ChartEntity var5 = var3.getEntity((double)((int)((double)(var1.getX() - var4.left) / this.scaleX)), (double)((int)((double)(var1.getY() - var4.top) / this.scaleY)));
            if(var5 != null) {
               var2 = var5.getToolTipText();
            }
         }
      }

      return var2;
   }

   public Point translateJava2DToScreen(Point2D var1) {
      Insets var2 = this.getInsets();
      int var3 = (int)(var1.getX() * this.scaleX + (double)var2.left);
      int var4 = (int)(var1.getY() * this.scaleY + (double)var2.top);
      return new Point(var3, var4);
   }

   public Point2D translateScreenToJava2D(Point var1) {
      Insets var2 = this.getInsets();
      double var3 = (var1.getX() - (double)var2.left) / this.scaleX;
      double var5 = (var1.getY() - (double)var2.top) / this.scaleY;
      return new Double(var3, var5);
   }

   public Rectangle2D scale(Rectangle2D var1) {
      Insets var2 = this.getInsets();
      double var3 = var1.getX() * this.getScaleX() + (double)var2.left;
      double var5 = var1.getY() * this.getScaleY() + (double)var2.top;
      double var7 = var1.getWidth() * this.getScaleX();
      double var9 = var1.getHeight() * this.getScaleY();
      return new java.awt.geom.Rectangle2D.Double(var3, var5, var7, var9);
   }

   public ChartEntity getEntityForPoint(int var1, int var2) {
      ChartEntity var3 = null;
      if(this.info != null) {
         Insets var4 = this.getInsets();
         double var5 = (double)(var1 - var4.left) / this.scaleX;
         double var7 = (double)(var2 - var4.top) / this.scaleY;
         EntityCollection var9 = this.info.getEntityCollection();
         var3 = var9 != null?var9.getEntity(var5, var7):null;
      }

      return var3;
   }

   public boolean getRefreshBuffer() {
      return this.refreshBuffer;
   }

   public void setRefreshBuffer(boolean var1) {
      this.refreshBuffer = var1;
   }

   public void paintComponent(Graphics var1) {
      super.paintComponent(var1);
      if(this.chart != null) {
         Graphics2D var2 = (Graphics2D)var1.create();
         Dimension var3 = this.getSize();
         Insets var4 = this.getInsets();
         java.awt.geom.Rectangle2D.Double var5 = new java.awt.geom.Rectangle2D.Double((double)var4.left, (double)var4.top, var3.getWidth() - (double)var4.left - (double)var4.right, var3.getHeight() - (double)var4.top - (double)var4.bottom);
         boolean var6 = false;
         double var7 = var5.getWidth();
         double var9 = var5.getHeight();
         this.scaleX = 1.0D;
         this.scaleY = 1.0D;
         if(var7 < (double)this.minimumDrawWidth) {
            this.scaleX = var7 / (double)this.minimumDrawWidth;
            var7 = (double)this.minimumDrawWidth;
            var6 = true;
         } else if(var7 > (double)this.maximumDrawWidth) {
            this.scaleX = var7 / (double)this.maximumDrawWidth;
            var7 = (double)this.maximumDrawWidth;
            var6 = true;
         }

         if(var9 < (double)this.minimumDrawHeight) {
            this.scaleY = var9 / (double)this.minimumDrawHeight;
            var9 = (double)this.minimumDrawHeight;
            var6 = true;
         } else if(var9 > (double)this.maximumDrawHeight) {
            this.scaleY = var9 / (double)this.maximumDrawHeight;
            var9 = (double)this.maximumDrawHeight;
            var6 = true;
         }

         java.awt.geom.Rectangle2D.Double var11 = new java.awt.geom.Rectangle2D.Double(0.0D, 0.0D, var7, var9);
         if(this.useBuffer) {
            if(this.chartBuffer == null || (double)this.chartBufferWidth != var5.getWidth() || (double)this.chartBufferHeight != var5.getHeight()) {
               this.chartBufferWidth = (int)var5.getWidth();
               this.chartBufferHeight = (int)var5.getHeight();
               this.chartBuffer = this.createImage(this.chartBufferWidth, this.chartBufferHeight);
               this.refreshBuffer = true;
            }

            if(this.refreshBuffer) {
               java.awt.geom.Rectangle2D.Double var12 = new java.awt.geom.Rectangle2D.Double(0.0D, 0.0D, (double)this.chartBufferWidth, (double)this.chartBufferHeight);
               Graphics2D var13 = (Graphics2D)this.chartBuffer.getGraphics();
               if(var6) {
                  AffineTransform var14 = var13.getTransform();
                  AffineTransform var15 = AffineTransform.getScaleInstance(this.scaleX, this.scaleY);
                  var13.transform(var15);
                  this.chart.draw(var13, var11, this.anchor, this.info);
                  var13.setTransform(var14);
               } else {
                  this.chart.draw(var13, var12, this.anchor, this.info);
               }

               this.refreshBuffer = false;
            }

            var2.drawImage(this.chartBuffer, var4.left, var4.right, this);
         } else {
            AffineTransform var16 = var2.getTransform();
            var2.translate(var4.left, var4.top);
            if(var6) {
               AffineTransform var17 = AffineTransform.getScaleInstance(this.scaleX, this.scaleY);
               var2.transform(var17);
            }

            this.chart.draw(var2, var11, this.anchor, this.info);
            var2.setTransform(var16);
         }

         this.drawZoomRectangle(var2);
         var2.dispose();
         this.anchor = null;
         this.verticalTraceLine = null;
         this.horizontalTraceLine = null;
      }
   }

   public void chartChanged(ChartChangeEvent var1) {
      this.refreshBuffer = true;
      Plot var2 = this.chart.getPlot();
      if(var2 instanceof Zoomable) {
         Zoomable var3 = (Zoomable)var2;
         this.orientation = var3.getOrientation();
      }

      this.repaint();
   }

   public void chartProgress(ChartProgressEvent var1) {
   }

   public void actionPerformed(ActionEvent var1) {
      String var2 = var1.getActionCommand();
      if(var2.equals("PROPERTIES")) {
         this.doEditChartProperties();
      } else if(var2.equals("SAVE")) {
         try {
            this.doSaveAs();
         } catch (IOException var4) {
            var4.printStackTrace();
         }
      } else if(var2.equals("PRINT")) {
         this.createChartPrintJob();
      } else if(var2.equals("ZOOM_IN_BOTH")) {
         this.zoomInBoth(this.zoomPoint.getX(), this.zoomPoint.getY());
      } else if(var2.equals("ZOOM_IN_DOMAIN")) {
         this.zoomInDomain(this.zoomPoint.getX(), this.zoomPoint.getY());
      } else if(var2.equals("ZOOM_IN_RANGE")) {
         this.zoomInRange(this.zoomPoint.getX(), this.zoomPoint.getY());
      } else if(var2.equals("ZOOM_OUT_BOTH")) {
         this.zoomOutBoth(this.zoomPoint.getX(), this.zoomPoint.getY());
      } else if(var2.equals("ZOOM_DOMAIN_BOTH")) {
         this.zoomOutDomain(this.zoomPoint.getX(), this.zoomPoint.getY());
      } else if(var2.equals("ZOOM_RANGE_BOTH")) {
         this.zoomOutRange(this.zoomPoint.getX(), this.zoomPoint.getY());
      } else if(var2.equals("ZOOM_RESET_BOTH")) {
         this.restoreAutoBounds();
      } else if(var2.equals("ZOOM_RESET_DOMAIN")) {
         this.restoreAutoDomainBounds();
      } else if(var2.equals("ZOOM_RESET_RANGE")) {
         this.restoreAutoRangeBounds();
      }

   }

   public void mouseEntered(MouseEvent var1) {
      if(!this.ownToolTipDelaysActive) {
         ToolTipManager var2 = ToolTipManager.sharedInstance();
         this.originalToolTipInitialDelay = var2.getInitialDelay();
         var2.setInitialDelay(this.ownToolTipInitialDelay);
         this.originalToolTipReshowDelay = var2.getReshowDelay();
         var2.setReshowDelay(this.ownToolTipReshowDelay);
         this.originalToolTipDismissDelay = var2.getDismissDelay();
         var2.setDismissDelay(this.ownToolTipDismissDelay);
         this.ownToolTipDelaysActive = true;
      }

   }

   public void mouseExited(MouseEvent var1) {
      if(this.ownToolTipDelaysActive) {
         ToolTipManager var2 = ToolTipManager.sharedInstance();
         var2.setInitialDelay(this.originalToolTipInitialDelay);
         var2.setReshowDelay(this.originalToolTipReshowDelay);
         var2.setDismissDelay(this.originalToolTipDismissDelay);
         this.ownToolTipDelaysActive = false;
      }

   }

   public void mousePressed(MouseEvent var1) {
      if(this.zoomRectangle == null) {
         Rectangle2D var2 = this.getScreenDataArea(var1.getX(), var1.getY());
         if(var2 != null) {
            this.zoomPoint = this.getPointInRectangle(var1.getX(), var1.getY(), var2);
         } else {
            this.zoomPoint = null;
         }

         if(var1.isPopupTrigger() && this.popup != null) {
            this.displayPopupMenu(var1.getX(), var1.getY());
         }
      }

   }

   private Point getPointInRectangle(int var1, int var2, Rectangle2D var3) {
      var1 = (int)Math.max(Math.ceil(var3.getMinX()), Math.min((double)var1, Math.floor(var3.getMaxX())));
      var2 = (int)Math.max(Math.ceil(var3.getMinY()), Math.min((double)var2, Math.floor(var3.getMaxY())));
      return new Point(var1, var2);
   }

   public void mouseDragged(MouseEvent var1) {
      if(this.popup == null || !this.popup.isShowing()) {
         if(this.zoomPoint != null) {
            Graphics2D var2 = (Graphics2D)this.getGraphics();
            this.drawZoomRectangle(var2);
            boolean var3 = false;
            boolean var4 = false;
            if(this.orientation == PlotOrientation.HORIZONTAL) {
               var3 = this.rangeZoomable;
               var4 = this.domainZoomable;
            } else {
               var3 = this.domainZoomable;
               var4 = this.rangeZoomable;
            }

            Rectangle2D var5 = this.getScreenDataArea((int)this.zoomPoint.getX(), (int)this.zoomPoint.getY());
            double var6;
            if(var3 && var4) {
               var6 = Math.min((double)var1.getX(), var5.getMaxX());
               double var8 = Math.min((double)var1.getY(), var5.getMaxY());
               this.zoomRectangle = new java.awt.geom.Rectangle2D.Double(this.zoomPoint.getX(), this.zoomPoint.getY(), var6 - this.zoomPoint.getX(), var8 - this.zoomPoint.getY());
            } else if(var3) {
               var6 = Math.min((double)var1.getX(), var5.getMaxX());
               this.zoomRectangle = new java.awt.geom.Rectangle2D.Double(this.zoomPoint.getX(), var5.getMinY(), var6 - this.zoomPoint.getX(), var5.getHeight());
            } else if(var4) {
               var6 = Math.min((double)var1.getY(), var5.getMaxY());
               this.zoomRectangle = new java.awt.geom.Rectangle2D.Double(var5.getMinX(), this.zoomPoint.getY(), var5.getWidth(), var6 - this.zoomPoint.getY());
            }

            this.drawZoomRectangle(var2);
            var2.dispose();
         }
      }
   }

   public void mouseReleased(MouseEvent var1) {
      if(this.zoomRectangle != null) {
         boolean var2 = false;
         boolean var3 = false;
         if(this.orientation == PlotOrientation.HORIZONTAL) {
            var2 = this.rangeZoomable;
            var3 = this.domainZoomable;
         } else {
            var2 = this.domainZoomable;
            var3 = this.rangeZoomable;
         }

         boolean var4 = var2 && Math.abs((double)var1.getX() - this.zoomPoint.getX()) >= (double)this.zoomTriggerDistance;
         boolean var5 = var3 && Math.abs((double)var1.getY() - this.zoomPoint.getY()) >= (double)this.zoomTriggerDistance;
         if(!var4 && !var5) {
            Graphics2D var16 = (Graphics2D)this.getGraphics();
            this.drawZoomRectangle(var16);
            var16.dispose();
            this.zoomPoint = null;
            this.zoomRectangle = null;
         } else {
            if((!var2 || (double)var1.getX() >= this.zoomPoint.getX()) && (!var3 || (double)var1.getY() >= this.zoomPoint.getY())) {
               Rectangle2D var14 = this.getScreenDataArea((int)this.zoomPoint.getX(), (int)this.zoomPoint.getY());
               double var6;
               double var8;
               double var10;
               double var12;
               if(!var3) {
                  var6 = this.zoomPoint.getX();
                  var8 = var14.getMinY();
                  var10 = Math.min(this.zoomRectangle.getWidth(), var14.getMaxX() - this.zoomPoint.getX());
                  var12 = var14.getHeight();
               } else if(!var2) {
                  var6 = var14.getMinX();
                  var8 = this.zoomPoint.getY();
                  var10 = var14.getWidth();
                  var12 = Math.min(this.zoomRectangle.getHeight(), var14.getMaxY() - this.zoomPoint.getY());
               } else {
                  var6 = this.zoomPoint.getX();
                  var8 = this.zoomPoint.getY();
                  var10 = Math.min(this.zoomRectangle.getWidth(), var14.getMaxX() - this.zoomPoint.getX());
                  var12 = Math.min(this.zoomRectangle.getHeight(), var14.getMaxY() - this.zoomPoint.getY());
               }

               java.awt.geom.Rectangle2D.Double var15 = new java.awt.geom.Rectangle2D.Double(var6, var8, var10, var12);
               this.zoom(var15);
            } else {
               this.restoreAutoBounds();
            }

            this.zoomPoint = null;
            this.zoomRectangle = null;
         }
      } else if(var1.isPopupTrigger() && this.popup != null) {
         this.displayPopupMenu(var1.getX(), var1.getY());
      }

   }

   public void mouseClicked(MouseEvent var1) {
      Insets var2 = this.getInsets();
      int var3 = (int)((double)(var1.getX() - var2.left) / this.scaleX);
      int var4 = (int)((double)(var1.getY() - var2.top) / this.scaleY);
      this.anchor = new Double((double)var3, (double)var4);
      if(this.chart != null) {
         this.chart.setNotify(true);
         EventListener[] var5 = this.chartMouseListeners.getListeners(class$org$jfree$chart$ChartMouseListener == null?(class$org$jfree$chart$ChartMouseListener = class$("org.jfree.chart.ChartMouseListener")):class$org$jfree$chart$ChartMouseListener);
         if(var5.length != 0) {
            ChartEntity var6 = null;
            if(this.info != null) {
               EntityCollection var7 = this.info.getEntityCollection();
               if(var7 != null) {
                  var6 = var7.getEntity((double)var3, (double)var4);
               }
            }

            ChartMouseEvent var9 = new ChartMouseEvent(this.getChart(), var1, var6);

            for(int var8 = var5.length - 1; var8 >= 0; --var8) {
               ((ChartMouseListener)var5[var8]).chartMouseClicked(var9);
            }

         }
      }
   }

   public void mouseMoved(MouseEvent var1) {
      Graphics2D var2 = (Graphics2D)this.getGraphics();
      if(this.horizontalAxisTrace) {
         this.drawHorizontalAxisTrace(var2, var1.getX());
      }

      if(this.verticalAxisTrace) {
         this.drawVerticalAxisTrace(var2, var1.getY());
      }

      var2.dispose();
      EventListener[] var3 = this.chartMouseListeners.getListeners(class$org$jfree$chart$ChartMouseListener == null?(class$org$jfree$chart$ChartMouseListener = class$("org.jfree.chart.ChartMouseListener")):class$org$jfree$chart$ChartMouseListener);
      if(var3.length != 0) {
         Insets var4 = this.getInsets();
         int var5 = (int)((double)(var1.getX() - var4.left) / this.scaleX);
         int var6 = (int)((double)(var1.getY() - var4.top) / this.scaleY);
         ChartEntity var7 = null;
         if(this.info != null) {
            EntityCollection var8 = this.info.getEntityCollection();
            if(var8 != null) {
               var7 = var8.getEntity((double)var5, (double)var6);
            }
         }

         if(this.chart != null) {
            ChartMouseEvent var10 = new ChartMouseEvent(this.getChart(), var1, var7);

            for(int var9 = var3.length - 1; var9 >= 0; --var9) {
               ((ChartMouseListener)var3[var9]).chartMouseMoved(var10);
            }
         }

      }
   }

   public void zoomInBoth(double var1, double var3) {
      this.zoomInDomain(var1, var3);
      this.zoomInRange(var1, var3);
   }

   public void zoomInDomain(double var1, double var3) {
      Plot var5 = this.chart.getPlot();
      if(var5 instanceof Zoomable) {
         Zoomable var6 = (Zoomable)var5;
         var6.zoomDomainAxes(this.zoomInFactor, this.info.getPlotInfo(), this.translateScreenToJava2D(new Point((int)var1, (int)var3)));
      }

   }

   public void zoomInRange(double var1, double var3) {
      Plot var5 = this.chart.getPlot();
      if(var5 instanceof Zoomable) {
         Zoomable var6 = (Zoomable)var5;
         var6.zoomRangeAxes(this.zoomInFactor, this.info.getPlotInfo(), this.translateScreenToJava2D(new Point((int)var1, (int)var3)));
      }

   }

   public void zoomOutBoth(double var1, double var3) {
      this.zoomOutDomain(var1, var3);
      this.zoomOutRange(var1, var3);
   }

   public void zoomOutDomain(double var1, double var3) {
      Plot var5 = this.chart.getPlot();
      if(var5 instanceof Zoomable) {
         Zoomable var6 = (Zoomable)var5;
         var6.zoomDomainAxes(this.zoomOutFactor, this.info.getPlotInfo(), this.translateScreenToJava2D(new Point((int)var1, (int)var3)));
      }

   }

   public void zoomOutRange(double var1, double var3) {
      Plot var5 = this.chart.getPlot();
      if(var5 instanceof Zoomable) {
         Zoomable var6 = (Zoomable)var5;
         var6.zoomRangeAxes(this.zoomOutFactor, this.info.getPlotInfo(), this.translateScreenToJava2D(new Point((int)var1, (int)var3)));
      }

   }

   public void zoom(Rectangle2D var1) {
      Point2D var2 = this.translateScreenToJava2D(new Point((int)Math.ceil(var1.getX()), (int)Math.ceil(var1.getY())));
      PlotRenderingInfo var3 = this.info.getPlotInfo();
      Rectangle2D var4 = this.getScreenDataArea((int)var1.getCenterX(), (int)var1.getCenterY());
      if(var1.getHeight() > 0.0D && var1.getWidth() > 0.0D) {
         double var5 = (var1.getMinX() - var4.getMinX()) / var4.getWidth();
         double var7 = (var1.getMaxX() - var4.getMinX()) / var4.getWidth();
         double var9 = (var4.getMaxY() - var1.getMaxY()) / var4.getHeight();
         double var11 = (var4.getMaxY() - var1.getMinY()) / var4.getHeight();
         Plot var13 = this.chart.getPlot();
         if(var13 instanceof Zoomable) {
            Zoomable var14 = (Zoomable)var13;
            if(var14.getOrientation() == PlotOrientation.HORIZONTAL) {
               var14.zoomDomainAxes(var9, var11, var3, var2);
               var14.zoomRangeAxes(var5, var7, var3, var2);
            } else {
               var14.zoomDomainAxes(var5, var7, var3, var2);
               var14.zoomRangeAxes(var9, var11, var3, var2);
            }
         }
      }

   }

   public void restoreAutoBounds() {
      this.restoreAutoDomainBounds();
      this.restoreAutoRangeBounds();
   }

   public void restoreAutoDomainBounds() {
      Plot var1 = this.chart.getPlot();
      if(var1 instanceof Zoomable) {
         Zoomable var2 = (Zoomable)var1;
         var2.zoomDomainAxes(0.0D, this.info.getPlotInfo(), this.zoomPoint);
      }

   }

   public void restoreAutoRangeBounds() {
      Plot var1 = this.chart.getPlot();
      if(var1 instanceof Zoomable) {
         Zoomable var2 = (Zoomable)var1;
         var2.zoomRangeAxes(0.0D, this.info.getPlotInfo(), this.zoomPoint);
      }

   }

   public Rectangle2D getScreenDataArea() {
      Rectangle2D var1 = this.info.getPlotInfo().getDataArea();
      Insets var2 = this.getInsets();
      double var3 = var1.getX() * this.scaleX + (double)var2.left;
      double var5 = var1.getY() * this.scaleY + (double)var2.top;
      double var7 = var1.getWidth() * this.scaleX;
      double var9 = var1.getHeight() * this.scaleY;
      return new java.awt.geom.Rectangle2D.Double(var3, var5, var7, var9);
   }

   public Rectangle2D getScreenDataArea(int var1, int var2) {
      PlotRenderingInfo var3 = this.info.getPlotInfo();
      Rectangle2D var4;
      if(var3.getSubplotCount() == 0) {
         var4 = this.getScreenDataArea();
      } else {
         Point2D var5 = this.translateScreenToJava2D(new Point(var1, var2));
         int var6 = var3.getSubplotIndex(var5);
         if(var6 == -1) {
            return null;
         }

         var4 = this.scale(var3.getSubplotInfo(var6).getDataArea());
      }

      return var4;
   }

   public int getInitialDelay() {
      return this.ownToolTipInitialDelay;
   }

   public int getReshowDelay() {
      return this.ownToolTipReshowDelay;
   }

   public int getDismissDelay() {
      return this.ownToolTipDismissDelay;
   }

   public void setInitialDelay(int var1) {
      this.ownToolTipInitialDelay = var1;
   }

   public void setReshowDelay(int var1) {
      this.ownToolTipReshowDelay = var1;
   }

   public void setDismissDelay(int var1) {
      this.ownToolTipDismissDelay = var1;
   }

   public double getZoomInFactor() {
      return this.zoomInFactor;
   }

   public void setZoomInFactor(double var1) {
      this.zoomInFactor = var1;
   }

   public double getZoomOutFactor() {
      return this.zoomOutFactor;
   }

   public void setZoomOutFactor(double var1) {
      this.zoomOutFactor = var1;
   }

   private void drawZoomRectangle(Graphics2D var1) {
      var1.setXORMode(Color.gray);
      if(this.zoomRectangle != null) {
         if(this.fillZoomRectangle) {
            var1.fill(this.zoomRectangle);
         } else {
            var1.draw(this.zoomRectangle);
         }
      }

      var1.setPaintMode();
   }

   private void drawHorizontalAxisTrace(Graphics2D var1, int var2) {
      Rectangle2D var3 = this.getScreenDataArea();
      var1.setXORMode(Color.orange);
      if((int)var3.getMinX() < var2 && var2 < (int)var3.getMaxX()) {
         if(this.verticalTraceLine != null) {
            var1.draw(this.verticalTraceLine);
            this.verticalTraceLine.setLine((double)var2, (double)((int)var3.getMinY()), (double)var2, (double)((int)var3.getMaxY()));
         } else {
            this.verticalTraceLine = new Float((float)var2, (float)((int)var3.getMinY()), (float)var2, (float)((int)var3.getMaxY()));
         }

         var1.draw(this.verticalTraceLine);
      }

      var1.setPaintMode();
   }

   private void drawVerticalAxisTrace(Graphics2D var1, int var2) {
      Rectangle2D var3 = this.getScreenDataArea();
      var1.setXORMode(Color.orange);
      if((int)var3.getMinY() < var2 && var2 < (int)var3.getMaxY()) {
         if(this.horizontalTraceLine != null) {
            var1.draw(this.horizontalTraceLine);
            this.horizontalTraceLine.setLine((double)((int)var3.getMinX()), (double)var2, (double)((int)var3.getMaxX()), (double)var2);
         } else {
            this.horizontalTraceLine = new Float((float)((int)var3.getMinX()), (float)var2, (float)((int)var3.getMaxX()), (float)var2);
         }

         var1.draw(this.horizontalTraceLine);
      }

      var1.setPaintMode();
   }

   public void doEditChartProperties() {
      ChartEditor var1 = ChartEditorManager.getChartEditor(this.chart);
      int var2 = JOptionPane.showConfirmDialog(this, var1, localizationResources.getString("Chart_Properties"), 2, -1);
      if(var2 == 0) {
         var1.updateChart(this.chart);
      }

   }

   public void doSaveAs() {
      JFileChooser var1 = new JFileChooser();
      ExtensionFileFilter var2 = new ExtensionFileFilter(localizationResources.getString("PNG_Image_Files"), ".png");
      var1.addChoosableFileFilter(var2);
      int var3 = var1.showSaveDialog(this);
      if(var3 == 0) {
         String var4 = var1.getSelectedFile().getPath();
         if(this.isEnforceFileExtensions() && !var4.endsWith(".png")) {
            var4 = var4 + ".png";
         }

         ChartUtilities.saveChartAsPNG(new File(var4), this.chart, this.getWidth(), this.getHeight());
      }

   }

   public void createChartPrintJob() {
      PrinterJob var1 = PrinterJob.getPrinterJob();
      PageFormat var2 = var1.defaultPage();
      PageFormat var3 = var1.pageDialog(var2);
      if(var3 != var2) {
         var1.setPrintable(this, var3);
         if(var1.printDialog()) {
            try {
               var1.print();
            } catch (PrinterException var5) {
               JOptionPane.showMessageDialog(this, var5);
            }
         }
      }

   }

   public int print(Graphics var1, PageFormat var2, int var3) {
      if(var3 != 0) {
         return 1;
      } else {
         Graphics2D var4 = (Graphics2D)var1;
         double var5 = var2.getImageableX();
         double var7 = var2.getImageableY();
         double var9 = var2.getImageableWidth();
         double var11 = var2.getImageableHeight();
         this.chart.draw(var4, new java.awt.geom.Rectangle2D.Double(var5, var7, var9, var11), this.anchor, (ChartRenderingInfo)null);
         return 0;
      }
   }

   public void addChartMouseListener(ChartMouseListener var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'listener\' argument.");
      } else {
         this.chartMouseListeners.add(class$org$jfree$chart$ChartMouseListener == null?(class$org$jfree$chart$ChartMouseListener = class$("org.jfree.chart.ChartMouseListener")):class$org$jfree$chart$ChartMouseListener, var1);
      }
   }

   public void removeChartMouseListener(ChartMouseListener var1) {
      this.chartMouseListeners.remove(class$org$jfree$chart$ChartMouseListener == null?(class$org$jfree$chart$ChartMouseListener = class$("org.jfree.chart.ChartMouseListener")):class$org$jfree$chart$ChartMouseListener, var1);
   }

   public EventListener[] getListeners(Class var1) {
      return var1 == (class$org$jfree$chart$ChartMouseListener == null?(class$org$jfree$chart$ChartMouseListener = class$("org.jfree.chart.ChartMouseListener")):class$org$jfree$chart$ChartMouseListener)?this.chartMouseListeners.getListeners(var1):super.getListeners(var1);
   }

   protected JPopupMenu createPopupMenu(boolean var1, boolean var2, boolean var3, boolean var4) {
      JPopupMenu var5 = new JPopupMenu("Chart:");
      boolean var6 = false;
      JMenuItem var7;
      if(var1) {
         var7 = new JMenuItem(localizationResources.getString("Properties..."));
         var7.setActionCommand("PROPERTIES");
         var7.addActionListener(this);
         var5.add(var7);
         var6 = true;
      }

      if(var2) {
         if(var6) {
            var5.addSeparator();
            var6 = false;
         }

         var7 = new JMenuItem(localizationResources.getString("Save_as..."));
         var7.setActionCommand("SAVE");
         var7.addActionListener(this);
         var5.add(var7);
         var6 = true;
      }

      if(var3) {
         if(var6) {
            var5.addSeparator();
            var6 = false;
         }

         var7 = new JMenuItem(localizationResources.getString("Print..."));
         var7.setActionCommand("PRINT");
         var7.addActionListener(this);
         var5.add(var7);
         var6 = true;
      }

      if(var4) {
         if(var6) {
            var5.addSeparator();
            var6 = false;
         }

         JMenu var10 = new JMenu(localizationResources.getString("Zoom_In"));
         this.zoomInBothMenuItem = new JMenuItem(localizationResources.getString("All_Axes"));
         this.zoomInBothMenuItem.setActionCommand("ZOOM_IN_BOTH");
         this.zoomInBothMenuItem.addActionListener(this);
         var10.add(this.zoomInBothMenuItem);
         var10.addSeparator();
         this.zoomInDomainMenuItem = new JMenuItem(localizationResources.getString("Domain_Axis"));
         this.zoomInDomainMenuItem.setActionCommand("ZOOM_IN_DOMAIN");
         this.zoomInDomainMenuItem.addActionListener(this);
         var10.add(this.zoomInDomainMenuItem);
         this.zoomInRangeMenuItem = new JMenuItem(localizationResources.getString("Range_Axis"));
         this.zoomInRangeMenuItem.setActionCommand("ZOOM_IN_RANGE");
         this.zoomInRangeMenuItem.addActionListener(this);
         var10.add(this.zoomInRangeMenuItem);
         var5.add(var10);
         JMenu var8 = new JMenu(localizationResources.getString("Zoom_Out"));
         this.zoomOutBothMenuItem = new JMenuItem(localizationResources.getString("All_Axes"));
         this.zoomOutBothMenuItem.setActionCommand("ZOOM_OUT_BOTH");
         this.zoomOutBothMenuItem.addActionListener(this);
         var8.add(this.zoomOutBothMenuItem);
         var8.addSeparator();
         this.zoomOutDomainMenuItem = new JMenuItem(localizationResources.getString("Domain_Axis"));
         this.zoomOutDomainMenuItem.setActionCommand("ZOOM_DOMAIN_BOTH");
         this.zoomOutDomainMenuItem.addActionListener(this);
         var8.add(this.zoomOutDomainMenuItem);
         this.zoomOutRangeMenuItem = new JMenuItem(localizationResources.getString("Range_Axis"));
         this.zoomOutRangeMenuItem.setActionCommand("ZOOM_RANGE_BOTH");
         this.zoomOutRangeMenuItem.addActionListener(this);
         var8.add(this.zoomOutRangeMenuItem);
         var5.add(var8);
         JMenu var9 = new JMenu(localizationResources.getString("Auto_Range"));
         this.zoomResetBothMenuItem = new JMenuItem(localizationResources.getString("All_Axes"));
         this.zoomResetBothMenuItem.setActionCommand("ZOOM_RESET_BOTH");
         this.zoomResetBothMenuItem.addActionListener(this);
         var9.add(this.zoomResetBothMenuItem);
         var9.addSeparator();
         this.zoomResetDomainMenuItem = new JMenuItem(localizationResources.getString("Domain_Axis"));
         this.zoomResetDomainMenuItem.setActionCommand("ZOOM_RESET_DOMAIN");
         this.zoomResetDomainMenuItem.addActionListener(this);
         var9.add(this.zoomResetDomainMenuItem);
         this.zoomResetRangeMenuItem = new JMenuItem(localizationResources.getString("Range_Axis"));
         this.zoomResetRangeMenuItem.setActionCommand("ZOOM_RESET_RANGE");
         this.zoomResetRangeMenuItem.addActionListener(this);
         var9.add(this.zoomResetRangeMenuItem);
         var5.addSeparator();
         var5.add(var9);
      }

      return var5;
   }

   protected void displayPopupMenu(int var1, int var2) {
      if(this.popup != null) {
         Plot var3 = this.chart.getPlot();
         boolean var4 = false;
         boolean var5 = false;
         if(var3 instanceof Zoomable) {
            Zoomable var6 = (Zoomable)var3;
            var4 = var6.isDomainZoomable();
            var5 = var6.isRangeZoomable();
         }

         if(this.zoomInDomainMenuItem != null) {
            this.zoomInDomainMenuItem.setEnabled(var4);
         }

         if(this.zoomOutDomainMenuItem != null) {
            this.zoomOutDomainMenuItem.setEnabled(var4);
         }

         if(this.zoomResetDomainMenuItem != null) {
            this.zoomResetDomainMenuItem.setEnabled(var4);
         }

         if(this.zoomInRangeMenuItem != null) {
            this.zoomInRangeMenuItem.setEnabled(var5);
         }

         if(this.zoomOutRangeMenuItem != null) {
            this.zoomOutRangeMenuItem.setEnabled(var5);
         }

         if(this.zoomResetRangeMenuItem != null) {
            this.zoomResetRangeMenuItem.setEnabled(var5);
         }

         if(this.zoomInBothMenuItem != null) {
            this.zoomInBothMenuItem.setEnabled(var4 && var5);
         }

         if(this.zoomOutBothMenuItem != null) {
            this.zoomOutBothMenuItem.setEnabled(var4 && var5);
         }

         if(this.zoomResetBothMenuItem != null) {
            this.zoomResetBothMenuItem.setEnabled(var4 && var5);
         }

         this.popup.show(this, var1, var2);
      }

   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }
}
