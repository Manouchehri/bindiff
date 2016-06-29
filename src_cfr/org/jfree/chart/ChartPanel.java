/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.EventListener;
import java.util.ResourceBundle;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.ToolTipManager;
import javax.swing.event.EventListenerList;
import javax.swing.filechooser.FileFilter;
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

public class ChartPanel
extends JPanel
implements ActionListener,
MouseListener,
MouseMotionListener,
Printable,
Serializable,
ChartChangeListener,
ChartProgressListener {
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
    private PlotOrientation orientation = PlotOrientation.VERTICAL;
    private boolean domainZoomable = false;
    private boolean rangeZoomable = false;
    private Point zoomPoint = null;
    private transient Rectangle2D zoomRectangle = null;
    private boolean fillZoomRectangle = false;
    private int zoomTriggerDistance;
    private boolean horizontalAxisTrace = false;
    private boolean verticalAxisTrace = false;
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
    private double zoomInFactor = 0.5;
    private double zoomOutFactor = 2.0;
    protected static ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.chart.LocalizationBundle");
    static Class class$org$jfree$chart$ChartMouseListener;

    public ChartPanel(JFreeChart jFreeChart) {
        this(jFreeChart, 680, 420, 300, 200, 800, 600, false, true, true, true, true, true);
    }

    public ChartPanel(JFreeChart jFreeChart, boolean bl2) {
        this(jFreeChart, 680, 420, 300, 200, 800, 600, bl2, true, true, true, true, true);
    }

    public ChartPanel(JFreeChart jFreeChart, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this(jFreeChart, 680, 420, 300, 200, 800, 600, false, bl2, bl3, bl4, bl5, bl6);
    }

    public ChartPanel(JFreeChart jFreeChart, int n2, int n3, int n4, int n5, int n6, int n7, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7) {
        this.setChart(jFreeChart);
        this.chartMouseListeners = new EventListenerList();
        this.info = new ChartRenderingInfo();
        this.setPreferredSize(new Dimension(n2, n3));
        this.useBuffer = bl2;
        this.refreshBuffer = false;
        this.minimumDrawWidth = n4;
        this.minimumDrawHeight = n5;
        this.maximumDrawWidth = n6;
        this.maximumDrawHeight = n7;
        this.zoomTriggerDistance = 10;
        this.popup = null;
        if (bl3 || bl4 || bl5 || bl6) {
            this.popup = this.createPopupMenu(bl3, bl4, bl5, bl6);
        }
        this.enableEvents(16);
        this.enableEvents(32);
        this.setDisplayToolTips(bl7);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.enforceFileExtensions = true;
        ToolTipManager toolTipManager = ToolTipManager.sharedInstance();
        this.ownToolTipInitialDelay = toolTipManager.getInitialDelay();
        this.ownToolTipDismissDelay = toolTipManager.getDismissDelay();
        this.ownToolTipReshowDelay = toolTipManager.getReshowDelay();
    }

    public JFreeChart getChart() {
        return this.chart;
    }

    public void setChart(JFreeChart jFreeChart) {
        if (this.chart != null) {
            this.chart.removeChangeListener(this);
            this.chart.removeProgressListener(this);
        }
        this.chart = jFreeChart;
        if (jFreeChart != null) {
            this.chart.addChangeListener(this);
            this.chart.addProgressListener(this);
            Plot plot = jFreeChart.getPlot();
            this.domainZoomable = false;
            this.rangeZoomable = false;
            if (plot instanceof Zoomable) {
                Zoomable zoomable = (Zoomable)((Object)plot);
                this.domainZoomable = zoomable.isDomainZoomable();
                this.rangeZoomable = zoomable.isRangeZoomable();
                this.orientation = zoomable.getOrientation();
            }
        } else {
            this.domainZoomable = false;
            this.rangeZoomable = false;
        }
        if (this.useBuffer) {
            this.refreshBuffer = true;
        }
        this.repaint();
    }

    public int getMinimumDrawWidth() {
        return this.minimumDrawWidth;
    }

    public void setMinimumDrawWidth(int n2) {
        this.minimumDrawWidth = n2;
    }

    public int getMaximumDrawWidth() {
        return this.maximumDrawWidth;
    }

    public void setMaximumDrawWidth(int n2) {
        this.maximumDrawWidth = n2;
    }

    public int getMinimumDrawHeight() {
        return this.minimumDrawHeight;
    }

    public void setMinimumDrawHeight(int n2) {
        this.minimumDrawHeight = n2;
    }

    public int getMaximumDrawHeight() {
        return this.maximumDrawHeight;
    }

    public void setMaximumDrawHeight(int n2) {
        this.maximumDrawHeight = n2;
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

    protected void setAnchor(Point2D point2D) {
        this.anchor = point2D;
    }

    public JPopupMenu getPopupMenu() {
        return this.popup;
    }

    public void setPopupMenu(JPopupMenu jPopupMenu) {
        this.popup = jPopupMenu;
    }

    public ChartRenderingInfo getChartRenderingInfo() {
        return this.info;
    }

    public void setMouseZoomable(boolean bl2) {
        this.setMouseZoomable(bl2, true);
    }

    public void setMouseZoomable(boolean bl2, boolean bl3) {
        this.setDomainZoomable(bl2);
        this.setRangeZoomable(bl2);
        this.setFillZoomRectangle(bl3);
    }

    public boolean isDomainZoomable() {
        return this.domainZoomable;
    }

    public void setDomainZoomable(boolean bl2) {
        if (!bl2) {
            this.domainZoomable = false;
            return;
        }
        Plot plot = this.chart.getPlot();
        if (!(plot instanceof Zoomable)) return;
        Zoomable zoomable = (Zoomable)((Object)plot);
        this.domainZoomable = bl2 && zoomable.isDomainZoomable();
    }

    public boolean isRangeZoomable() {
        return this.rangeZoomable;
    }

    public void setRangeZoomable(boolean bl2) {
        if (!bl2) {
            this.rangeZoomable = false;
            return;
        }
        Plot plot = this.chart.getPlot();
        if (!(plot instanceof Zoomable)) return;
        Zoomable zoomable = (Zoomable)((Object)plot);
        this.rangeZoomable = bl2 && zoomable.isRangeZoomable();
    }

    public boolean getFillZoomRectangle() {
        return this.fillZoomRectangle;
    }

    public void setFillZoomRectangle(boolean bl2) {
        this.fillZoomRectangle = bl2;
    }

    public int getZoomTriggerDistance() {
        return this.zoomTriggerDistance;
    }

    public void setZoomTriggerDistance(int n2) {
        this.zoomTriggerDistance = n2;
    }

    public boolean getHorizontalAxisTrace() {
        return this.horizontalAxisTrace;
    }

    public void setHorizontalAxisTrace(boolean bl2) {
        this.horizontalAxisTrace = bl2;
    }

    protected Line2D getHorizontalTraceLine() {
        return this.horizontalTraceLine;
    }

    protected void setHorizontalTraceLine(Line2D line2D) {
        this.horizontalTraceLine = line2D;
    }

    public boolean getVerticalAxisTrace() {
        return this.verticalAxisTrace;
    }

    public void setVerticalAxisTrace(boolean bl2) {
        this.verticalAxisTrace = bl2;
    }

    protected Line2D getVerticalTraceLine() {
        return this.verticalTraceLine;
    }

    protected void setVerticalTraceLine(Line2D line2D) {
        this.verticalTraceLine = line2D;
    }

    public boolean isEnforceFileExtensions() {
        return this.enforceFileExtensions;
    }

    public void setEnforceFileExtensions(boolean bl2) {
        this.enforceFileExtensions = bl2;
    }

    public void setDisplayToolTips(boolean bl2) {
        if (bl2) {
            ToolTipManager.sharedInstance().registerComponent(this);
            return;
        }
        ToolTipManager.sharedInstance().unregisterComponent(this);
    }

    @Override
    public String getToolTipText(MouseEvent mouseEvent) {
        String string = null;
        if (this.info == null) return string;
        EntityCollection entityCollection = this.info.getEntityCollection();
        if (entityCollection == null) return string;
        Insets insets = this.getInsets();
        ChartEntity chartEntity = entityCollection.getEntity((int)((double)(mouseEvent.getX() - insets.left) / this.scaleX), (int)((double)(mouseEvent.getY() - insets.top) / this.scaleY));
        if (chartEntity == null) return string;
        return chartEntity.getToolTipText();
    }

    public Point translateJava2DToScreen(Point2D point2D) {
        Insets insets = this.getInsets();
        int n2 = (int)(point2D.getX() * this.scaleX + (double)insets.left);
        int n3 = (int)(point2D.getY() * this.scaleY + (double)insets.top);
        return new Point(n2, n3);
    }

    public Point2D translateScreenToJava2D(Point point) {
        Insets insets = this.getInsets();
        double d2 = (point.getX() - (double)insets.left) / this.scaleX;
        double d3 = (point.getY() - (double)insets.top) / this.scaleY;
        return new Point2D.Double(d2, d3);
    }

    public Rectangle2D scale(Rectangle2D rectangle2D) {
        Insets insets = this.getInsets();
        double d2 = rectangle2D.getX() * this.getScaleX() + (double)insets.left;
        double d3 = rectangle2D.getY() * this.getScaleY() + (double)insets.top;
        double d4 = rectangle2D.getWidth() * this.getScaleX();
        double d5 = rectangle2D.getHeight() * this.getScaleY();
        return new Rectangle2D.Double(d2, d3, d4, d5);
    }

    public ChartEntity getEntityForPoint(int n2, int n3) {
        ChartEntity chartEntity = null;
        if (this.info == null) return chartEntity;
        Insets insets = this.getInsets();
        double d2 = (double)(n2 - insets.left) / this.scaleX;
        double d3 = (double)(n3 - insets.top) / this.scaleY;
        EntityCollection entityCollection = this.info.getEntityCollection();
        if (entityCollection == null) return null;
        ChartEntity chartEntity2 = entityCollection.getEntity(d2, d3);
        return chartEntity2;
    }

    public boolean getRefreshBuffer() {
        return this.refreshBuffer;
    }

    public void setRefreshBuffer(boolean bl2) {
        this.refreshBuffer = bl2;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if (this.chart == null) {
            return;
        }
        Graphics2D graphics2D = (Graphics2D)graphics.create();
        Dimension dimension = this.getSize();
        Insets insets = this.getInsets();
        Rectangle2D.Double double_ = new Rectangle2D.Double(insets.left, insets.top, dimension.getWidth() - (double)insets.left - (double)insets.right, dimension.getHeight() - (double)insets.top - (double)insets.bottom);
        boolean bl2 = false;
        double d2 = double_.getWidth();
        double d3 = double_.getHeight();
        this.scaleX = 1.0;
        this.scaleY = 1.0;
        if (d2 < (double)this.minimumDrawWidth) {
            this.scaleX = d2 / (double)this.minimumDrawWidth;
            d2 = this.minimumDrawWidth;
            bl2 = true;
        } else if (d2 > (double)this.maximumDrawWidth) {
            this.scaleX = d2 / (double)this.maximumDrawWidth;
            d2 = this.maximumDrawWidth;
            bl2 = true;
        }
        if (d3 < (double)this.minimumDrawHeight) {
            this.scaleY = d3 / (double)this.minimumDrawHeight;
            d3 = this.minimumDrawHeight;
            bl2 = true;
        } else if (d3 > (double)this.maximumDrawHeight) {
            this.scaleY = d3 / (double)this.maximumDrawHeight;
            d3 = this.maximumDrawHeight;
            bl2 = true;
        }
        Rectangle2D.Double double_2 = new Rectangle2D.Double(0.0, 0.0, d2, d3);
        if (this.useBuffer) {
            if (this.chartBuffer == null || (double)this.chartBufferWidth != double_.getWidth() || (double)this.chartBufferHeight != double_.getHeight()) {
                this.chartBufferWidth = (int)double_.getWidth();
                this.chartBufferHeight = (int)double_.getHeight();
                this.chartBuffer = this.createImage(this.chartBufferWidth, this.chartBufferHeight);
                this.refreshBuffer = true;
            }
            if (this.refreshBuffer) {
                Rectangle2D.Double double_3 = new Rectangle2D.Double(0.0, 0.0, this.chartBufferWidth, this.chartBufferHeight);
                Graphics2D graphics2D2 = (Graphics2D)this.chartBuffer.getGraphics();
                if (bl2) {
                    AffineTransform affineTransform = graphics2D2.getTransform();
                    AffineTransform affineTransform2 = AffineTransform.getScaleInstance(this.scaleX, this.scaleY);
                    graphics2D2.transform(affineTransform2);
                    this.chart.draw(graphics2D2, double_2, this.anchor, this.info);
                    graphics2D2.setTransform(affineTransform);
                } else {
                    this.chart.draw(graphics2D2, double_3, this.anchor, this.info);
                }
                this.refreshBuffer = false;
            }
            graphics2D.drawImage(this.chartBuffer, insets.left, insets.right, this);
        } else {
            AffineTransform affineTransform = graphics2D.getTransform();
            graphics2D.translate(insets.left, insets.top);
            if (bl2) {
                AffineTransform affineTransform3 = AffineTransform.getScaleInstance(this.scaleX, this.scaleY);
                graphics2D.transform(affineTransform3);
            }
            this.chart.draw(graphics2D, double_2, this.anchor, this.info);
            graphics2D.setTransform(affineTransform);
        }
        this.drawZoomRectangle(graphics2D);
        graphics2D.dispose();
        this.anchor = null;
        this.verticalTraceLine = null;
        this.horizontalTraceLine = null;
    }

    @Override
    public void chartChanged(ChartChangeEvent chartChangeEvent) {
        this.refreshBuffer = true;
        Plot plot = this.chart.getPlot();
        if (plot instanceof Zoomable) {
            Zoomable zoomable = (Zoomable)((Object)plot);
            this.orientation = zoomable.getOrientation();
        }
        this.repaint();
    }

    @Override
    public void chartProgress(ChartProgressEvent chartProgressEvent) {
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("PROPERTIES")) {
            this.doEditChartProperties();
            return;
        }
        if (string.equals("SAVE")) {
            try {
                this.doSaveAs();
                return;
            }
            catch (IOException var3_3) {
                var3_3.printStackTrace();
                return;
            }
        }
        if (string.equals("PRINT")) {
            this.createChartPrintJob();
            return;
        }
        if (string.equals("ZOOM_IN_BOTH")) {
            this.zoomInBoth(this.zoomPoint.getX(), this.zoomPoint.getY());
            return;
        }
        if (string.equals("ZOOM_IN_DOMAIN")) {
            this.zoomInDomain(this.zoomPoint.getX(), this.zoomPoint.getY());
            return;
        }
        if (string.equals("ZOOM_IN_RANGE")) {
            this.zoomInRange(this.zoomPoint.getX(), this.zoomPoint.getY());
            return;
        }
        if (string.equals("ZOOM_OUT_BOTH")) {
            this.zoomOutBoth(this.zoomPoint.getX(), this.zoomPoint.getY());
            return;
        }
        if (string.equals("ZOOM_DOMAIN_BOTH")) {
            this.zoomOutDomain(this.zoomPoint.getX(), this.zoomPoint.getY());
            return;
        }
        if (string.equals("ZOOM_RANGE_BOTH")) {
            this.zoomOutRange(this.zoomPoint.getX(), this.zoomPoint.getY());
            return;
        }
        if (string.equals("ZOOM_RESET_BOTH")) {
            this.restoreAutoBounds();
            return;
        }
        if (string.equals("ZOOM_RESET_DOMAIN")) {
            this.restoreAutoDomainBounds();
            return;
        }
        if (!string.equals("ZOOM_RESET_RANGE")) return;
        this.restoreAutoRangeBounds();
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        if (this.ownToolTipDelaysActive) return;
        ToolTipManager toolTipManager = ToolTipManager.sharedInstance();
        this.originalToolTipInitialDelay = toolTipManager.getInitialDelay();
        toolTipManager.setInitialDelay(this.ownToolTipInitialDelay);
        this.originalToolTipReshowDelay = toolTipManager.getReshowDelay();
        toolTipManager.setReshowDelay(this.ownToolTipReshowDelay);
        this.originalToolTipDismissDelay = toolTipManager.getDismissDelay();
        toolTipManager.setDismissDelay(this.ownToolTipDismissDelay);
        this.ownToolTipDelaysActive = true;
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        if (!this.ownToolTipDelaysActive) return;
        ToolTipManager toolTipManager = ToolTipManager.sharedInstance();
        toolTipManager.setInitialDelay(this.originalToolTipInitialDelay);
        toolTipManager.setReshowDelay(this.originalToolTipReshowDelay);
        toolTipManager.setDismissDelay(this.originalToolTipDismissDelay);
        this.ownToolTipDelaysActive = false;
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if (this.zoomRectangle != null) return;
        Rectangle2D rectangle2D = this.getScreenDataArea(mouseEvent.getX(), mouseEvent.getY());
        this.zoomPoint = rectangle2D != null ? this.getPointInRectangle(mouseEvent.getX(), mouseEvent.getY(), rectangle2D) : null;
        if (!mouseEvent.isPopupTrigger()) return;
        if (this.popup == null) return;
        this.displayPopupMenu(mouseEvent.getX(), mouseEvent.getY());
    }

    private Point getPointInRectangle(int n2, int n3, Rectangle2D rectangle2D) {
        n2 = (int)Math.max(Math.ceil(rectangle2D.getMinX()), Math.min((double)n2, Math.floor(rectangle2D.getMaxX())));
        n3 = (int)Math.max(Math.ceil(rectangle2D.getMinY()), Math.min((double)n3, Math.floor(rectangle2D.getMaxY())));
        return new Point(n2, n3);
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        if (this.popup != null && this.popup.isShowing()) {
            return;
        }
        if (this.zoomPoint == null) {
            return;
        }
        Graphics2D graphics2D = (Graphics2D)this.getGraphics();
        this.drawZoomRectangle(graphics2D);
        boolean bl2 = false;
        boolean bl3 = false;
        if (this.orientation == PlotOrientation.HORIZONTAL) {
            bl2 = this.rangeZoomable;
            bl3 = this.domainZoomable;
        } else {
            bl2 = this.domainZoomable;
            bl3 = this.rangeZoomable;
        }
        Rectangle2D rectangle2D = this.getScreenDataArea((int)this.zoomPoint.getX(), (int)this.zoomPoint.getY());
        if (bl2 && bl3) {
            double d2 = Math.min((double)mouseEvent.getX(), rectangle2D.getMaxX());
            double d3 = Math.min((double)mouseEvent.getY(), rectangle2D.getMaxY());
            this.zoomRectangle = new Rectangle2D.Double(this.zoomPoint.getX(), this.zoomPoint.getY(), d2 - this.zoomPoint.getX(), d3 - this.zoomPoint.getY());
        } else if (bl2) {
            double d4 = Math.min((double)mouseEvent.getX(), rectangle2D.getMaxX());
            this.zoomRectangle = new Rectangle2D.Double(this.zoomPoint.getX(), rectangle2D.getMinY(), d4 - this.zoomPoint.getX(), rectangle2D.getHeight());
        } else if (bl3) {
            double d5 = Math.min((double)mouseEvent.getY(), rectangle2D.getMaxY());
            this.zoomRectangle = new Rectangle2D.Double(rectangle2D.getMinX(), this.zoomPoint.getY(), rectangle2D.getWidth(), d5 - this.zoomPoint.getY());
        }
        this.drawZoomRectangle(graphics2D);
        graphics2D.dispose();
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        boolean bl2;
        if (this.zoomRectangle == null) {
            if (!mouseEvent.isPopupTrigger()) return;
            if (this.popup == null) return;
            this.displayPopupMenu(mouseEvent.getX(), mouseEvent.getY());
            return;
        }
        boolean bl3 = false;
        boolean bl4 = false;
        if (this.orientation == PlotOrientation.HORIZONTAL) {
            bl3 = this.rangeZoomable;
            bl4 = this.domainZoomable;
        } else {
            bl3 = this.domainZoomable;
            bl4 = this.rangeZoomable;
        }
        boolean bl5 = bl3 && Math.abs((double)mouseEvent.getX() - this.zoomPoint.getX()) >= (double)this.zoomTriggerDistance;
        boolean bl6 = bl2 = bl4 && Math.abs((double)mouseEvent.getY() - this.zoomPoint.getY()) >= (double)this.zoomTriggerDistance;
        if (!bl5 && !bl2) {
            Graphics2D graphics2D = (Graphics2D)this.getGraphics();
            this.drawZoomRectangle(graphics2D);
            graphics2D.dispose();
            this.zoomPoint = null;
            this.zoomRectangle = null;
            return;
        }
        if (bl3 && (double)mouseEvent.getX() < this.zoomPoint.getX() || bl4 && (double)mouseEvent.getY() < this.zoomPoint.getY()) {
            this.restoreAutoBounds();
        } else {
            double d2;
            double d3;
            double d4;
            double d5;
            Rectangle2D rectangle2D = this.getScreenDataArea((int)this.zoomPoint.getX(), (int)this.zoomPoint.getY());
            if (!bl4) {
                d5 = this.zoomPoint.getX();
                d4 = rectangle2D.getMinY();
                d3 = Math.min(this.zoomRectangle.getWidth(), rectangle2D.getMaxX() - this.zoomPoint.getX());
                d2 = rectangle2D.getHeight();
            } else if (!bl3) {
                d5 = rectangle2D.getMinX();
                d4 = this.zoomPoint.getY();
                d3 = rectangle2D.getWidth();
                d2 = Math.min(this.zoomRectangle.getHeight(), rectangle2D.getMaxY() - this.zoomPoint.getY());
            } else {
                d5 = this.zoomPoint.getX();
                d4 = this.zoomPoint.getY();
                d3 = Math.min(this.zoomRectangle.getWidth(), rectangle2D.getMaxX() - this.zoomPoint.getX());
                d2 = Math.min(this.zoomRectangle.getHeight(), rectangle2D.getMaxY() - this.zoomPoint.getY());
            }
            Rectangle2D.Double double_ = new Rectangle2D.Double(d5, d4, d3, d2);
            this.zoom(double_);
        }
        this.zoomPoint = null;
        this.zoomRectangle = null;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        Object object;
        Insets insets = this.getInsets();
        int n2 = (int)((double)(mouseEvent.getX() - insets.left) / this.scaleX);
        int n3 = (int)((double)(mouseEvent.getY() - insets.top) / this.scaleY);
        this.anchor = new Point2D.Double(n2, n3);
        if (this.chart == null) {
            return;
        }
        this.chart.setNotify(true);
        Class class_ = class$org$jfree$chart$ChartMouseListener == null ? (ChartPanel.class$org$jfree$chart$ChartMouseListener = ChartPanel.class$("org.jfree.chart.ChartMouseListener")) : class$org$jfree$chart$ChartMouseListener;
        EventListener[] arreventListener = this.chartMouseListeners.getListeners(class_);
        if (arreventListener.length == 0) {
            return;
        }
        ChartEntity chartEntity = null;
        if (this.info != null && (object = this.info.getEntityCollection()) != null) {
            chartEntity = object.getEntity(n2, n3);
        }
        object = new ChartMouseEvent(this.getChart(), mouseEvent, chartEntity);
        int n4 = arreventListener.length - 1;
        while (n4 >= 0) {
            ((ChartMouseListener)arreventListener[n4]).chartMouseClicked((ChartMouseEvent)object);
            --n4;
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        Object object;
        Graphics2D graphics2D = (Graphics2D)this.getGraphics();
        if (this.horizontalAxisTrace) {
            this.drawHorizontalAxisTrace(graphics2D, mouseEvent.getX());
        }
        if (this.verticalAxisTrace) {
            this.drawVerticalAxisTrace(graphics2D, mouseEvent.getY());
        }
        graphics2D.dispose();
        Class class_ = class$org$jfree$chart$ChartMouseListener == null ? (ChartPanel.class$org$jfree$chart$ChartMouseListener = ChartPanel.class$("org.jfree.chart.ChartMouseListener")) : class$org$jfree$chart$ChartMouseListener;
        EventListener[] arreventListener = this.chartMouseListeners.getListeners(class_);
        if (arreventListener.length == 0) {
            return;
        }
        Insets insets = this.getInsets();
        int n2 = (int)((double)(mouseEvent.getX() - insets.left) / this.scaleX);
        int n3 = (int)((double)(mouseEvent.getY() - insets.top) / this.scaleY);
        ChartEntity chartEntity = null;
        if (this.info != null && (object = this.info.getEntityCollection()) != null) {
            chartEntity = object.getEntity(n2, n3);
        }
        if (this.chart == null) return;
        object = new ChartMouseEvent(this.getChart(), mouseEvent, chartEntity);
        int n4 = arreventListener.length - 1;
        while (n4 >= 0) {
            ((ChartMouseListener)arreventListener[n4]).chartMouseMoved((ChartMouseEvent)object);
            --n4;
        }
    }

    public void zoomInBoth(double d2, double d3) {
        this.zoomInDomain(d2, d3);
        this.zoomInRange(d2, d3);
    }

    public void zoomInDomain(double d2, double d3) {
        Plot plot = this.chart.getPlot();
        if (!(plot instanceof Zoomable)) return;
        Zoomable zoomable = (Zoomable)((Object)plot);
        zoomable.zoomDomainAxes(this.zoomInFactor, this.info.getPlotInfo(), this.translateScreenToJava2D(new Point((int)d2, (int)d3)));
    }

    public void zoomInRange(double d2, double d3) {
        Plot plot = this.chart.getPlot();
        if (!(plot instanceof Zoomable)) return;
        Zoomable zoomable = (Zoomable)((Object)plot);
        zoomable.zoomRangeAxes(this.zoomInFactor, this.info.getPlotInfo(), this.translateScreenToJava2D(new Point((int)d2, (int)d3)));
    }

    public void zoomOutBoth(double d2, double d3) {
        this.zoomOutDomain(d2, d3);
        this.zoomOutRange(d2, d3);
    }

    public void zoomOutDomain(double d2, double d3) {
        Plot plot = this.chart.getPlot();
        if (!(plot instanceof Zoomable)) return;
        Zoomable zoomable = (Zoomable)((Object)plot);
        zoomable.zoomDomainAxes(this.zoomOutFactor, this.info.getPlotInfo(), this.translateScreenToJava2D(new Point((int)d2, (int)d3)));
    }

    public void zoomOutRange(double d2, double d3) {
        Plot plot = this.chart.getPlot();
        if (!(plot instanceof Zoomable)) return;
        Zoomable zoomable = (Zoomable)((Object)plot);
        zoomable.zoomRangeAxes(this.zoomOutFactor, this.info.getPlotInfo(), this.translateScreenToJava2D(new Point((int)d2, (int)d3)));
    }

    public void zoom(Rectangle2D rectangle2D) {
        Point2D point2D = this.translateScreenToJava2D(new Point((int)Math.ceil(rectangle2D.getX()), (int)Math.ceil(rectangle2D.getY())));
        PlotRenderingInfo plotRenderingInfo = this.info.getPlotInfo();
        Rectangle2D rectangle2D2 = this.getScreenDataArea((int)rectangle2D.getCenterX(), (int)rectangle2D.getCenterY());
        if (rectangle2D.getHeight() <= 0.0) return;
        if (rectangle2D.getWidth() <= 0.0) return;
        double d2 = (rectangle2D.getMinX() - rectangle2D2.getMinX()) / rectangle2D2.getWidth();
        double d3 = (rectangle2D.getMaxX() - rectangle2D2.getMinX()) / rectangle2D2.getWidth();
        double d4 = (rectangle2D2.getMaxY() - rectangle2D.getMaxY()) / rectangle2D2.getHeight();
        double d5 = (rectangle2D2.getMaxY() - rectangle2D.getMinY()) / rectangle2D2.getHeight();
        Plot plot = this.chart.getPlot();
        if (!(plot instanceof Zoomable)) return;
        Zoomable zoomable = (Zoomable)((Object)plot);
        if (zoomable.getOrientation() == PlotOrientation.HORIZONTAL) {
            zoomable.zoomDomainAxes(d4, d5, plotRenderingInfo, point2D);
            zoomable.zoomRangeAxes(d2, d3, plotRenderingInfo, point2D);
            return;
        }
        zoomable.zoomDomainAxes(d2, d3, plotRenderingInfo, point2D);
        zoomable.zoomRangeAxes(d4, d5, plotRenderingInfo, point2D);
    }

    public void restoreAutoBounds() {
        this.restoreAutoDomainBounds();
        this.restoreAutoRangeBounds();
    }

    public void restoreAutoDomainBounds() {
        Plot plot = this.chart.getPlot();
        if (!(plot instanceof Zoomable)) return;
        Zoomable zoomable = (Zoomable)((Object)plot);
        zoomable.zoomDomainAxes(0.0, this.info.getPlotInfo(), this.zoomPoint);
    }

    public void restoreAutoRangeBounds() {
        Plot plot = this.chart.getPlot();
        if (!(plot instanceof Zoomable)) return;
        Zoomable zoomable = (Zoomable)((Object)plot);
        zoomable.zoomRangeAxes(0.0, this.info.getPlotInfo(), this.zoomPoint);
    }

    public Rectangle2D getScreenDataArea() {
        Rectangle2D rectangle2D = this.info.getPlotInfo().getDataArea();
        Insets insets = this.getInsets();
        double d2 = rectangle2D.getX() * this.scaleX + (double)insets.left;
        double d3 = rectangle2D.getY() * this.scaleY + (double)insets.top;
        double d4 = rectangle2D.getWidth() * this.scaleX;
        double d5 = rectangle2D.getHeight() * this.scaleY;
        return new Rectangle2D.Double(d2, d3, d4, d5);
    }

    public Rectangle2D getScreenDataArea(int n2, int n3) {
        PlotRenderingInfo plotRenderingInfo = this.info.getPlotInfo();
        if (plotRenderingInfo.getSubplotCount() == 0) {
            return this.getScreenDataArea();
        }
        Point2D point2D = this.translateScreenToJava2D(new Point(n2, n3));
        int n4 = plotRenderingInfo.getSubplotIndex(point2D);
        if (n4 != -1) return this.scale(plotRenderingInfo.getSubplotInfo(n4).getDataArea());
        return null;
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

    public void setInitialDelay(int n2) {
        this.ownToolTipInitialDelay = n2;
    }

    public void setReshowDelay(int n2) {
        this.ownToolTipReshowDelay = n2;
    }

    public void setDismissDelay(int n2) {
        this.ownToolTipDismissDelay = n2;
    }

    public double getZoomInFactor() {
        return this.zoomInFactor;
    }

    public void setZoomInFactor(double d2) {
        this.zoomInFactor = d2;
    }

    public double getZoomOutFactor() {
        return this.zoomOutFactor;
    }

    public void setZoomOutFactor(double d2) {
        this.zoomOutFactor = d2;
    }

    private void drawZoomRectangle(Graphics2D graphics2D) {
        graphics2D.setXORMode(Color.gray);
        if (this.zoomRectangle != null) {
            if (this.fillZoomRectangle) {
                graphics2D.fill(this.zoomRectangle);
            } else {
                graphics2D.draw(this.zoomRectangle);
            }
        }
        graphics2D.setPaintMode();
    }

    private void drawHorizontalAxisTrace(Graphics2D graphics2D, int n2) {
        Rectangle2D rectangle2D = this.getScreenDataArea();
        graphics2D.setXORMode(Color.orange);
        if ((int)rectangle2D.getMinX() < n2 && n2 < (int)rectangle2D.getMaxX()) {
            if (this.verticalTraceLine != null) {
                graphics2D.draw(this.verticalTraceLine);
                this.verticalTraceLine.setLine(n2, (int)rectangle2D.getMinY(), n2, (int)rectangle2D.getMaxY());
            } else {
                this.verticalTraceLine = new Line2D.Float(n2, (int)rectangle2D.getMinY(), n2, (int)rectangle2D.getMaxY());
            }
            graphics2D.draw(this.verticalTraceLine);
        }
        graphics2D.setPaintMode();
    }

    private void drawVerticalAxisTrace(Graphics2D graphics2D, int n2) {
        Rectangle2D rectangle2D = this.getScreenDataArea();
        graphics2D.setXORMode(Color.orange);
        if ((int)rectangle2D.getMinY() < n2 && n2 < (int)rectangle2D.getMaxY()) {
            if (this.horizontalTraceLine != null) {
                graphics2D.draw(this.horizontalTraceLine);
                this.horizontalTraceLine.setLine((int)rectangle2D.getMinX(), n2, (int)rectangle2D.getMaxX(), n2);
            } else {
                this.horizontalTraceLine = new Line2D.Float((int)rectangle2D.getMinX(), n2, (int)rectangle2D.getMaxX(), n2);
            }
            graphics2D.draw(this.horizontalTraceLine);
        }
        graphics2D.setPaintMode();
    }

    public void doEditChartProperties() {
        ChartEditor chartEditor = ChartEditorManager.getChartEditor(this.chart);
        int n2 = JOptionPane.showConfirmDialog(this, chartEditor, localizationResources.getString("Chart_Properties"), 2, -1);
        if (n2 != 0) return;
        chartEditor.updateChart(this.chart);
    }

    public void doSaveAs() {
        JFileChooser jFileChooser = new JFileChooser();
        ExtensionFileFilter extensionFileFilter = new ExtensionFileFilter(localizationResources.getString("PNG_Image_Files"), ".png");
        jFileChooser.addChoosableFileFilter(extensionFileFilter);
        int n2 = jFileChooser.showSaveDialog(this);
        if (n2 != 0) return;
        String string = jFileChooser.getSelectedFile().getPath();
        if (this.isEnforceFileExtensions() && !string.endsWith(".png")) {
            string = new StringBuffer().append(string).append(".png").toString();
        }
        ChartUtilities.saveChartAsPNG(new File(string), this.chart, this.getWidth(), this.getHeight());
    }

    public void createChartPrintJob() {
        PageFormat pageFormat;
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        PageFormat pageFormat2 = printerJob.pageDialog(pageFormat = printerJob.defaultPage());
        if (pageFormat2 == pageFormat) return;
        printerJob.setPrintable(this, pageFormat2);
        if (!printerJob.printDialog()) return;
        try {
            printerJob.print();
            return;
        }
        catch (PrinterException var4_4) {
            JOptionPane.showMessageDialog(this, var4_4);
        }
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int n2) {
        if (n2 != 0) {
            return 1;
        }
        Graphics2D graphics2D = (Graphics2D)graphics;
        double d2 = pageFormat.getImageableX();
        double d3 = pageFormat.getImageableY();
        double d4 = pageFormat.getImageableWidth();
        double d5 = pageFormat.getImageableHeight();
        this.chart.draw(graphics2D, new Rectangle2D.Double(d2, d3, d4, d5), this.anchor, null);
        return 0;
    }

    public void addChartMouseListener(ChartMouseListener chartMouseListener) {
        if (chartMouseListener == null) {
            throw new IllegalArgumentException("Null 'listener' argument.");
        }
        Class class_ = class$org$jfree$chart$ChartMouseListener == null ? (ChartPanel.class$org$jfree$chart$ChartMouseListener = ChartPanel.class$("org.jfree.chart.ChartMouseListener")) : class$org$jfree$chart$ChartMouseListener;
        this.chartMouseListeners.add(class_, chartMouseListener);
    }

    public void removeChartMouseListener(ChartMouseListener chartMouseListener) {
        Class class_ = class$org$jfree$chart$ChartMouseListener == null ? (ChartPanel.class$org$jfree$chart$ChartMouseListener = ChartPanel.class$("org.jfree.chart.ChartMouseListener")) : class$org$jfree$chart$ChartMouseListener;
        this.chartMouseListeners.remove(class_, chartMouseListener);
    }

    public EventListener[] getListeners(Class class_) {
        Class class_2 = class$org$jfree$chart$ChartMouseListener == null ? (ChartPanel.class$org$jfree$chart$ChartMouseListener = ChartPanel.class$("org.jfree.chart.ChartMouseListener")) : class$org$jfree$chart$ChartMouseListener;
        if (class_ != class_2) return super.getListeners(class_);
        return this.chartMouseListeners.getListeners(class_);
    }

    protected JPopupMenu createPopupMenu(boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        JMenuItem jMenuItem;
        JPopupMenu jPopupMenu = new JPopupMenu("Chart:");
        boolean bl6 = false;
        if (bl2) {
            jMenuItem = new JMenuItem(localizationResources.getString("Properties..."));
            jMenuItem.setActionCommand("PROPERTIES");
            jMenuItem.addActionListener(this);
            jPopupMenu.add(jMenuItem);
            bl6 = true;
        }
        if (bl3) {
            if (bl6) {
                jPopupMenu.addSeparator();
                bl6 = false;
            }
            jMenuItem = new JMenuItem(localizationResources.getString("Save_as..."));
            jMenuItem.setActionCommand("SAVE");
            jMenuItem.addActionListener(this);
            jPopupMenu.add(jMenuItem);
            bl6 = true;
        }
        if (bl4) {
            if (bl6) {
                jPopupMenu.addSeparator();
                bl6 = false;
            }
            jMenuItem = new JMenuItem(localizationResources.getString("Print..."));
            jMenuItem.setActionCommand("PRINT");
            jMenuItem.addActionListener(this);
            jPopupMenu.add(jMenuItem);
            bl6 = true;
        }
        if (!bl5) return jPopupMenu;
        if (bl6) {
            jPopupMenu.addSeparator();
            bl6 = false;
        }
        jMenuItem = new JMenu(localizationResources.getString("Zoom_In"));
        this.zoomInBothMenuItem = new JMenuItem(localizationResources.getString("All_Axes"));
        this.zoomInBothMenuItem.setActionCommand("ZOOM_IN_BOTH");
        this.zoomInBothMenuItem.addActionListener(this);
        jMenuItem.add(this.zoomInBothMenuItem);
        jMenuItem.addSeparator();
        this.zoomInDomainMenuItem = new JMenuItem(localizationResources.getString("Domain_Axis"));
        this.zoomInDomainMenuItem.setActionCommand("ZOOM_IN_DOMAIN");
        this.zoomInDomainMenuItem.addActionListener(this);
        jMenuItem.add(this.zoomInDomainMenuItem);
        this.zoomInRangeMenuItem = new JMenuItem(localizationResources.getString("Range_Axis"));
        this.zoomInRangeMenuItem.setActionCommand("ZOOM_IN_RANGE");
        this.zoomInRangeMenuItem.addActionListener(this);
        jMenuItem.add(this.zoomInRangeMenuItem);
        jPopupMenu.add(jMenuItem);
        JMenu jMenu = new JMenu(localizationResources.getString("Zoom_Out"));
        this.zoomOutBothMenuItem = new JMenuItem(localizationResources.getString("All_Axes"));
        this.zoomOutBothMenuItem.setActionCommand("ZOOM_OUT_BOTH");
        this.zoomOutBothMenuItem.addActionListener(this);
        jMenu.add(this.zoomOutBothMenuItem);
        jMenu.addSeparator();
        this.zoomOutDomainMenuItem = new JMenuItem(localizationResources.getString("Domain_Axis"));
        this.zoomOutDomainMenuItem.setActionCommand("ZOOM_DOMAIN_BOTH");
        this.zoomOutDomainMenuItem.addActionListener(this);
        jMenu.add(this.zoomOutDomainMenuItem);
        this.zoomOutRangeMenuItem = new JMenuItem(localizationResources.getString("Range_Axis"));
        this.zoomOutRangeMenuItem.setActionCommand("ZOOM_RANGE_BOTH");
        this.zoomOutRangeMenuItem.addActionListener(this);
        jMenu.add(this.zoomOutRangeMenuItem);
        jPopupMenu.add(jMenu);
        JMenu jMenu2 = new JMenu(localizationResources.getString("Auto_Range"));
        this.zoomResetBothMenuItem = new JMenuItem(localizationResources.getString("All_Axes"));
        this.zoomResetBothMenuItem.setActionCommand("ZOOM_RESET_BOTH");
        this.zoomResetBothMenuItem.addActionListener(this);
        jMenu2.add(this.zoomResetBothMenuItem);
        jMenu2.addSeparator();
        this.zoomResetDomainMenuItem = new JMenuItem(localizationResources.getString("Domain_Axis"));
        this.zoomResetDomainMenuItem.setActionCommand("ZOOM_RESET_DOMAIN");
        this.zoomResetDomainMenuItem.addActionListener(this);
        jMenu2.add(this.zoomResetDomainMenuItem);
        this.zoomResetRangeMenuItem = new JMenuItem(localizationResources.getString("Range_Axis"));
        this.zoomResetRangeMenuItem.setActionCommand("ZOOM_RESET_RANGE");
        this.zoomResetRangeMenuItem.addActionListener(this);
        jMenu2.add(this.zoomResetRangeMenuItem);
        jPopupMenu.addSeparator();
        jPopupMenu.add(jMenu2);
        return jPopupMenu;
    }

    protected void displayPopupMenu(int n2, int n3) {
        if (this.popup == null) return;
        Plot plot = this.chart.getPlot();
        boolean bl2 = false;
        boolean bl3 = false;
        if (plot instanceof Zoomable) {
            Zoomable zoomable = (Zoomable)((Object)plot);
            bl2 = zoomable.isDomainZoomable();
            bl3 = zoomable.isRangeZoomable();
        }
        if (this.zoomInDomainMenuItem != null) {
            this.zoomInDomainMenuItem.setEnabled(bl2);
        }
        if (this.zoomOutDomainMenuItem != null) {
            this.zoomOutDomainMenuItem.setEnabled(bl2);
        }
        if (this.zoomResetDomainMenuItem != null) {
            this.zoomResetDomainMenuItem.setEnabled(bl2);
        }
        if (this.zoomInRangeMenuItem != null) {
            this.zoomInRangeMenuItem.setEnabled(bl3);
        }
        if (this.zoomOutRangeMenuItem != null) {
            this.zoomOutRangeMenuItem.setEnabled(bl3);
        }
        if (this.zoomResetRangeMenuItem != null) {
            this.zoomResetRangeMenuItem.setEnabled(bl3);
        }
        if (this.zoomInBothMenuItem != null) {
            this.zoomInBothMenuItem.setEnabled(bl2 && bl3);
        }
        if (this.zoomOutBothMenuItem != null) {
            this.zoomOutBothMenuItem.setEnabled(bl2 && bl3);
        }
        if (this.zoomResetBothMenuItem != null) {
            this.zoomResetBothMenuItem.setEnabled(bl2 && bl3);
        }
        this.popup.show(this, n2, n3);
    }

    static Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }
}

