package org.jfree.chart;

import javax.swing.event.*;
import org.jfree.chart.entity.*;
import java.awt.geom.*;
import java.awt.image.*;
import org.jfree.chart.event.*;
import java.awt.event.*;
import java.util.*;
import org.jfree.chart.plot.*;
import java.awt.*;
import org.jfree.chart.editor.*;
import org.jfree.ui.*;
import javax.swing.filechooser.*;
import java.io.*;
import java.awt.print.*;
import javax.swing.*;

public class ChartPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener, Printable, Serializable, ChartChangeListener, ChartProgressListener
{
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
    protected static ResourceBundle localizationResources;
    static Class class$org$jfree$chart$ChartMouseListener;
    
    public ChartPanel(final JFreeChart freeChart) {
        this(freeChart, 680, 420, 300, 200, 800, 600, false, true, true, true, true, true);
    }
    
    public ChartPanel(final JFreeChart freeChart, final boolean b) {
        this(freeChart, 680, 420, 300, 200, 800, 600, b, true, true, true, true, true);
    }
    
    public ChartPanel(final JFreeChart freeChart, final boolean b, final boolean b2, final boolean b3, final boolean b4, final boolean b5) {
        this(freeChart, 680, 420, 300, 200, 800, 600, false, b, b2, b3, b4, b5);
    }
    
    public ChartPanel(final JFreeChart chart, final int n, final int n2, final int minimumDrawWidth, final int minimumDrawHeight, final int maximumDrawWidth, final int maximumDrawHeight, final boolean useBuffer, final boolean b, final boolean b2, final boolean b3, final boolean b4, final boolean displayToolTips) {
        this.orientation = PlotOrientation.VERTICAL;
        this.domainZoomable = false;
        this.rangeZoomable = false;
        this.zoomPoint = null;
        this.zoomRectangle = null;
        this.fillZoomRectangle = false;
        this.horizontalAxisTrace = false;
        this.verticalAxisTrace = false;
        this.zoomInFactor = 0.5;
        this.zoomOutFactor = 2.0;
        this.setChart(chart);
        this.chartMouseListeners = new EventListenerList();
        this.info = new ChartRenderingInfo();
        this.setPreferredSize(new Dimension(n, n2));
        this.useBuffer = useBuffer;
        this.refreshBuffer = false;
        this.minimumDrawWidth = minimumDrawWidth;
        this.minimumDrawHeight = minimumDrawHeight;
        this.maximumDrawWidth = maximumDrawWidth;
        this.maximumDrawHeight = maximumDrawHeight;
        this.zoomTriggerDistance = 10;
        this.popup = null;
        if (b || b2 || b3 || b4) {
            this.popup = this.createPopupMenu(b, b2, b3, b4);
        }
        this.enableEvents(16L);
        this.enableEvents(32L);
        this.setDisplayToolTips(displayToolTips);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.enforceFileExtensions = true;
        final ToolTipManager sharedInstance = ToolTipManager.sharedInstance();
        this.ownToolTipInitialDelay = sharedInstance.getInitialDelay();
        this.ownToolTipDismissDelay = sharedInstance.getDismissDelay();
        this.ownToolTipReshowDelay = sharedInstance.getReshowDelay();
    }
    
    public JFreeChart getChart() {
        return this.chart;
    }
    
    public void setChart(final JFreeChart chart) {
        if (this.chart != null) {
            this.chart.removeChangeListener(this);
            this.chart.removeProgressListener(this);
        }
        if ((this.chart = chart) != null) {
            this.chart.addChangeListener(this);
            this.chart.addProgressListener(this);
            final Plot plot = chart.getPlot();
            this.domainZoomable = false;
            this.rangeZoomable = false;
            if (plot instanceof Zoomable) {
                final Zoomable zoomable = (Zoomable)plot;
                this.domainZoomable = zoomable.isDomainZoomable();
                this.rangeZoomable = zoomable.isRangeZoomable();
                this.orientation = zoomable.getOrientation();
            }
        }
        else {
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
    
    public void setMinimumDrawWidth(final int minimumDrawWidth) {
        this.minimumDrawWidth = minimumDrawWidth;
    }
    
    public int getMaximumDrawWidth() {
        return this.maximumDrawWidth;
    }
    
    public void setMaximumDrawWidth(final int maximumDrawWidth) {
        this.maximumDrawWidth = maximumDrawWidth;
    }
    
    public int getMinimumDrawHeight() {
        return this.minimumDrawHeight;
    }
    
    public void setMinimumDrawHeight(final int minimumDrawHeight) {
        this.minimumDrawHeight = minimumDrawHeight;
    }
    
    public int getMaximumDrawHeight() {
        return this.maximumDrawHeight;
    }
    
    public void setMaximumDrawHeight(final int maximumDrawHeight) {
        this.maximumDrawHeight = maximumDrawHeight;
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
    
    protected void setAnchor(final Point2D anchor) {
        this.anchor = anchor;
    }
    
    public JPopupMenu getPopupMenu() {
        return this.popup;
    }
    
    public void setPopupMenu(final JPopupMenu popup) {
        this.popup = popup;
    }
    
    public ChartRenderingInfo getChartRenderingInfo() {
        return this.info;
    }
    
    public void setMouseZoomable(final boolean b) {
        this.setMouseZoomable(b, true);
    }
    
    public void setMouseZoomable(final boolean b, final boolean fillZoomRectangle) {
        this.setDomainZoomable(b);
        this.setRangeZoomable(b);
        this.setFillZoomRectangle(fillZoomRectangle);
    }
    
    public boolean isDomainZoomable() {
        return this.domainZoomable;
    }
    
    public void setDomainZoomable(final boolean b) {
        if (b) {
            final Plot plot = this.chart.getPlot();
            if (plot instanceof Zoomable) {
                final Zoomable zoomable = (Zoomable)plot;
                this.domainZoomable = (b && zoomable.isDomainZoomable());
            }
        }
        else {
            this.domainZoomable = false;
        }
    }
    
    public boolean isRangeZoomable() {
        return this.rangeZoomable;
    }
    
    public void setRangeZoomable(final boolean b) {
        if (b) {
            final Plot plot = this.chart.getPlot();
            if (plot instanceof Zoomable) {
                final Zoomable zoomable = (Zoomable)plot;
                this.rangeZoomable = (b && zoomable.isRangeZoomable());
            }
        }
        else {
            this.rangeZoomable = false;
        }
    }
    
    public boolean getFillZoomRectangle() {
        return this.fillZoomRectangle;
    }
    
    public void setFillZoomRectangle(final boolean fillZoomRectangle) {
        this.fillZoomRectangle = fillZoomRectangle;
    }
    
    public int getZoomTriggerDistance() {
        return this.zoomTriggerDistance;
    }
    
    public void setZoomTriggerDistance(final int zoomTriggerDistance) {
        this.zoomTriggerDistance = zoomTriggerDistance;
    }
    
    public boolean getHorizontalAxisTrace() {
        return this.horizontalAxisTrace;
    }
    
    public void setHorizontalAxisTrace(final boolean horizontalAxisTrace) {
        this.horizontalAxisTrace = horizontalAxisTrace;
    }
    
    protected Line2D getHorizontalTraceLine() {
        return this.horizontalTraceLine;
    }
    
    protected void setHorizontalTraceLine(final Line2D horizontalTraceLine) {
        this.horizontalTraceLine = horizontalTraceLine;
    }
    
    public boolean getVerticalAxisTrace() {
        return this.verticalAxisTrace;
    }
    
    public void setVerticalAxisTrace(final boolean verticalAxisTrace) {
        this.verticalAxisTrace = verticalAxisTrace;
    }
    
    protected Line2D getVerticalTraceLine() {
        return this.verticalTraceLine;
    }
    
    protected void setVerticalTraceLine(final Line2D verticalTraceLine) {
        this.verticalTraceLine = verticalTraceLine;
    }
    
    public boolean isEnforceFileExtensions() {
        return this.enforceFileExtensions;
    }
    
    public void setEnforceFileExtensions(final boolean enforceFileExtensions) {
        this.enforceFileExtensions = enforceFileExtensions;
    }
    
    public void setDisplayToolTips(final boolean b) {
        if (b) {
            ToolTipManager.sharedInstance().registerComponent(this);
        }
        else {
            ToolTipManager.sharedInstance().unregisterComponent(this);
        }
    }
    
    public String getToolTipText(final MouseEvent mouseEvent) {
        String toolTipText = null;
        if (this.info != null) {
            final EntityCollection entityCollection = this.info.getEntityCollection();
            if (entityCollection != null) {
                final Insets insets = this.getInsets();
                final ChartEntity entity = entityCollection.getEntity((int)((mouseEvent.getX() - insets.left) / this.scaleX), (int)((mouseEvent.getY() - insets.top) / this.scaleY));
                if (entity != null) {
                    toolTipText = entity.getToolTipText();
                }
            }
        }
        return toolTipText;
    }
    
    public Point translateJava2DToScreen(final Point2D point2D) {
        final Insets insets = this.getInsets();
        return new Point((int)(point2D.getX() * this.scaleX + insets.left), (int)(point2D.getY() * this.scaleY + insets.top));
    }
    
    public Point2D translateScreenToJava2D(final Point point) {
        final Insets insets = this.getInsets();
        return new Point2D.Double((point.getX() - insets.left) / this.scaleX, (point.getY() - insets.top) / this.scaleY);
    }
    
    public Rectangle2D scale(final Rectangle2D rectangle2D) {
        final Insets insets = this.getInsets();
        return new Rectangle2D.Double(rectangle2D.getX() * this.getScaleX() + insets.left, rectangle2D.getY() * this.getScaleY() + insets.top, rectangle2D.getWidth() * this.getScaleX(), rectangle2D.getHeight() * this.getScaleY());
    }
    
    public ChartEntity getEntityForPoint(final int n, final int n2) {
        ChartEntity chartEntity = null;
        if (this.info != null) {
            final Insets insets = this.getInsets();
            final double n3 = (n - insets.left) / this.scaleX;
            final double n4 = (n2 - insets.top) / this.scaleY;
            final EntityCollection entityCollection = this.info.getEntityCollection();
            chartEntity = ((entityCollection != null) ? entityCollection.getEntity(n3, n4) : null);
        }
        return chartEntity;
    }
    
    public boolean getRefreshBuffer() {
        return this.refreshBuffer;
    }
    
    public void setRefreshBuffer(final boolean refreshBuffer) {
        this.refreshBuffer = refreshBuffer;
    }
    
    public void paintComponent(final Graphics graphics) {
        super.paintComponent(graphics);
        if (this.chart == null) {
            return;
        }
        final Graphics2D graphics2D = (Graphics2D)graphics.create();
        final Dimension size = this.getSize();
        final Insets insets = this.getInsets();
        final Rectangle2D.Double double1 = new Rectangle2D.Double(insets.left, insets.top, size.getWidth() - insets.left - insets.right, size.getHeight() - insets.top - insets.bottom);
        boolean b = false;
        double width = double1.getWidth();
        double height = double1.getHeight();
        this.scaleX = 1.0;
        this.scaleY = 1.0;
        if (width < this.minimumDrawWidth) {
            this.scaleX = width / this.minimumDrawWidth;
            width = this.minimumDrawWidth;
            b = true;
        }
        else if (width > this.maximumDrawWidth) {
            this.scaleX = width / this.maximumDrawWidth;
            width = this.maximumDrawWidth;
            b = true;
        }
        if (height < this.minimumDrawHeight) {
            this.scaleY = height / this.minimumDrawHeight;
            height = this.minimumDrawHeight;
            b = true;
        }
        else if (height > this.maximumDrawHeight) {
            this.scaleY = height / this.maximumDrawHeight;
            height = this.maximumDrawHeight;
            b = true;
        }
        final Rectangle2D.Double double2 = new Rectangle2D.Double(0.0, 0.0, width, height);
        if (this.useBuffer) {
            if (this.chartBuffer == null || this.chartBufferWidth != double1.getWidth() || this.chartBufferHeight != double1.getHeight()) {
                this.chartBufferWidth = (int)double1.getWidth();
                this.chartBufferHeight = (int)double1.getHeight();
                this.chartBuffer = this.createImage(this.chartBufferWidth, this.chartBufferHeight);
                this.refreshBuffer = true;
            }
            if (this.refreshBuffer) {
                final Rectangle2D.Double double3 = new Rectangle2D.Double(0.0, 0.0, this.chartBufferWidth, this.chartBufferHeight);
                final Graphics2D graphics2D2 = (Graphics2D)this.chartBuffer.getGraphics();
                if (b) {
                    final AffineTransform transform = graphics2D2.getTransform();
                    graphics2D2.transform(AffineTransform.getScaleInstance(this.scaleX, this.scaleY));
                    this.chart.draw(graphics2D2, double2, this.anchor, this.info);
                    graphics2D2.setTransform(transform);
                }
                else {
                    this.chart.draw(graphics2D2, double3, this.anchor, this.info);
                }
                this.refreshBuffer = false;
            }
            graphics2D.drawImage(this.chartBuffer, insets.left, insets.right, this);
        }
        else {
            final AffineTransform transform2 = graphics2D.getTransform();
            graphics2D.translate(insets.left, insets.top);
            if (b) {
                graphics2D.transform(AffineTransform.getScaleInstance(this.scaleX, this.scaleY));
            }
            this.chart.draw(graphics2D, double2, this.anchor, this.info);
            graphics2D.setTransform(transform2);
        }
        this.drawZoomRectangle(graphics2D);
        graphics2D.dispose();
        this.anchor = null;
        this.verticalTraceLine = null;
        this.horizontalTraceLine = null;
    }
    
    public void chartChanged(final ChartChangeEvent chartChangeEvent) {
        this.refreshBuffer = true;
        final Plot plot = this.chart.getPlot();
        if (plot instanceof Zoomable) {
            this.orientation = ((Zoomable)plot).getOrientation();
        }
        this.repaint();
    }
    
    public void chartProgress(final ChartProgressEvent chartProgressEvent) {
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        final String actionCommand = actionEvent.getActionCommand();
        if (actionCommand.equals("PROPERTIES")) {
            this.doEditChartProperties();
        }
        else if (actionCommand.equals("SAVE")) {
            try {
                this.doSaveAs();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if (actionCommand.equals("PRINT")) {
            this.createChartPrintJob();
        }
        else if (actionCommand.equals("ZOOM_IN_BOTH")) {
            this.zoomInBoth(this.zoomPoint.getX(), this.zoomPoint.getY());
        }
        else if (actionCommand.equals("ZOOM_IN_DOMAIN")) {
            this.zoomInDomain(this.zoomPoint.getX(), this.zoomPoint.getY());
        }
        else if (actionCommand.equals("ZOOM_IN_RANGE")) {
            this.zoomInRange(this.zoomPoint.getX(), this.zoomPoint.getY());
        }
        else if (actionCommand.equals("ZOOM_OUT_BOTH")) {
            this.zoomOutBoth(this.zoomPoint.getX(), this.zoomPoint.getY());
        }
        else if (actionCommand.equals("ZOOM_DOMAIN_BOTH")) {
            this.zoomOutDomain(this.zoomPoint.getX(), this.zoomPoint.getY());
        }
        else if (actionCommand.equals("ZOOM_RANGE_BOTH")) {
            this.zoomOutRange(this.zoomPoint.getX(), this.zoomPoint.getY());
        }
        else if (actionCommand.equals("ZOOM_RESET_BOTH")) {
            this.restoreAutoBounds();
        }
        else if (actionCommand.equals("ZOOM_RESET_DOMAIN")) {
            this.restoreAutoDomainBounds();
        }
        else if (actionCommand.equals("ZOOM_RESET_RANGE")) {
            this.restoreAutoRangeBounds();
        }
    }
    
    public void mouseEntered(final MouseEvent mouseEvent) {
        if (!this.ownToolTipDelaysActive) {
            final ToolTipManager sharedInstance = ToolTipManager.sharedInstance();
            this.originalToolTipInitialDelay = sharedInstance.getInitialDelay();
            sharedInstance.setInitialDelay(this.ownToolTipInitialDelay);
            this.originalToolTipReshowDelay = sharedInstance.getReshowDelay();
            sharedInstance.setReshowDelay(this.ownToolTipReshowDelay);
            this.originalToolTipDismissDelay = sharedInstance.getDismissDelay();
            sharedInstance.setDismissDelay(this.ownToolTipDismissDelay);
            this.ownToolTipDelaysActive = true;
        }
    }
    
    public void mouseExited(final MouseEvent mouseEvent) {
        if (this.ownToolTipDelaysActive) {
            final ToolTipManager sharedInstance = ToolTipManager.sharedInstance();
            sharedInstance.setInitialDelay(this.originalToolTipInitialDelay);
            sharedInstance.setReshowDelay(this.originalToolTipReshowDelay);
            sharedInstance.setDismissDelay(this.originalToolTipDismissDelay);
            this.ownToolTipDelaysActive = false;
        }
    }
    
    public void mousePressed(final MouseEvent mouseEvent) {
        if (this.zoomRectangle == null) {
            final Rectangle2D screenDataArea = this.getScreenDataArea(mouseEvent.getX(), mouseEvent.getY());
            if (screenDataArea != null) {
                this.zoomPoint = this.getPointInRectangle(mouseEvent.getX(), mouseEvent.getY(), screenDataArea);
            }
            else {
                this.zoomPoint = null;
            }
            if (mouseEvent.isPopupTrigger() && this.popup != null) {
                this.displayPopupMenu(mouseEvent.getX(), mouseEvent.getY());
            }
        }
    }
    
    private Point getPointInRectangle(int n, int n2, final Rectangle2D rectangle2D) {
        n = (int)Math.max(Math.ceil(rectangle2D.getMinX()), Math.min(n, Math.floor(rectangle2D.getMaxX())));
        n2 = (int)Math.max(Math.ceil(rectangle2D.getMinY()), Math.min(n2, Math.floor(rectangle2D.getMaxY())));
        return new Point(n, n2);
    }
    
    public void mouseDragged(final MouseEvent mouseEvent) {
        if (this.popup != null && this.popup.isShowing()) {
            return;
        }
        if (this.zoomPoint == null) {
            return;
        }
        final Graphics2D graphics2D = (Graphics2D)this.getGraphics();
        this.drawZoomRectangle(graphics2D);
        boolean b;
        boolean b2;
        if (this.orientation == PlotOrientation.HORIZONTAL) {
            b = this.rangeZoomable;
            b2 = this.domainZoomable;
        }
        else {
            b = this.domainZoomable;
            b2 = this.rangeZoomable;
        }
        final Rectangle2D screenDataArea = this.getScreenDataArea((int)this.zoomPoint.getX(), (int)this.zoomPoint.getY());
        if (b && b2) {
            this.zoomRectangle = new Rectangle2D.Double(this.zoomPoint.getX(), this.zoomPoint.getY(), Math.min(mouseEvent.getX(), screenDataArea.getMaxX()) - this.zoomPoint.getX(), Math.min(mouseEvent.getY(), screenDataArea.getMaxY()) - this.zoomPoint.getY());
        }
        else if (b) {
            this.zoomRectangle = new Rectangle2D.Double(this.zoomPoint.getX(), screenDataArea.getMinY(), Math.min(mouseEvent.getX(), screenDataArea.getMaxX()) - this.zoomPoint.getX(), screenDataArea.getHeight());
        }
        else if (b2) {
            this.zoomRectangle = new Rectangle2D.Double(screenDataArea.getMinX(), this.zoomPoint.getY(), screenDataArea.getWidth(), Math.min(mouseEvent.getY(), screenDataArea.getMaxY()) - this.zoomPoint.getY());
        }
        this.drawZoomRectangle(graphics2D);
        graphics2D.dispose();
    }
    
    public void mouseReleased(final MouseEvent mouseEvent) {
        if (this.zoomRectangle != null) {
            boolean b;
            boolean b2;
            if (this.orientation == PlotOrientation.HORIZONTAL) {
                b = this.rangeZoomable;
                b2 = this.domainZoomable;
            }
            else {
                b = this.domainZoomable;
                b2 = this.rangeZoomable;
            }
            final boolean b3 = b && Math.abs(mouseEvent.getX() - this.zoomPoint.getX()) >= this.zoomTriggerDistance;
            final boolean b4 = b2 && Math.abs(mouseEvent.getY() - this.zoomPoint.getY()) >= this.zoomTriggerDistance;
            if (b3 || b4) {
                if ((b && mouseEvent.getX() < this.zoomPoint.getX()) || (b2 && mouseEvent.getY() < this.zoomPoint.getY())) {
                    this.restoreAutoBounds();
                }
                else {
                    final Rectangle2D screenDataArea = this.getScreenDataArea((int)this.zoomPoint.getX(), (int)this.zoomPoint.getY());
                    double n;
                    double n2;
                    double n3;
                    double n4;
                    if (!b2) {
                        n = this.zoomPoint.getX();
                        n2 = screenDataArea.getMinY();
                        n3 = Math.min(this.zoomRectangle.getWidth(), screenDataArea.getMaxX() - this.zoomPoint.getX());
                        n4 = screenDataArea.getHeight();
                    }
                    else if (!b) {
                        n = screenDataArea.getMinX();
                        n2 = this.zoomPoint.getY();
                        n3 = screenDataArea.getWidth();
                        n4 = Math.min(this.zoomRectangle.getHeight(), screenDataArea.getMaxY() - this.zoomPoint.getY());
                    }
                    else {
                        n = this.zoomPoint.getX();
                        n2 = this.zoomPoint.getY();
                        n3 = Math.min(this.zoomRectangle.getWidth(), screenDataArea.getMaxX() - this.zoomPoint.getX());
                        n4 = Math.min(this.zoomRectangle.getHeight(), screenDataArea.getMaxY() - this.zoomPoint.getY());
                    }
                    this.zoom(new Rectangle2D.Double(n, n2, n3, n4));
                }
                this.zoomPoint = null;
                this.zoomRectangle = null;
            }
            else {
                final Graphics2D graphics2D = (Graphics2D)this.getGraphics();
                this.drawZoomRectangle(graphics2D);
                graphics2D.dispose();
                this.zoomPoint = null;
                this.zoomRectangle = null;
            }
        }
        else if (mouseEvent.isPopupTrigger() && this.popup != null) {
            this.displayPopupMenu(mouseEvent.getX(), mouseEvent.getY());
        }
    }
    
    public void mouseClicked(final MouseEvent mouseEvent) {
        final Insets insets = this.getInsets();
        final int n = (int)((mouseEvent.getX() - insets.left) / this.scaleX);
        final int n2 = (int)((mouseEvent.getY() - insets.top) / this.scaleY);
        this.anchor = new Point2D.Double(n, n2);
        if (this.chart == null) {
            return;
        }
        this.chart.setNotify(true);
        final EventListener[] listeners = this.chartMouseListeners.getListeners((Class<EventListener>)((ChartPanel.class$org$jfree$chart$ChartMouseListener == null) ? (ChartPanel.class$org$jfree$chart$ChartMouseListener = class$("org.jfree.chart.ChartMouseListener")) : ChartPanel.class$org$jfree$chart$ChartMouseListener));
        if (listeners.length == 0) {
            return;
        }
        ChartEntity entity = null;
        if (this.info != null) {
            final EntityCollection entityCollection = this.info.getEntityCollection();
            if (entityCollection != null) {
                entity = entityCollection.getEntity(n, n2);
            }
        }
        final ChartMouseEvent chartMouseEvent = new ChartMouseEvent(this.getChart(), mouseEvent, entity);
        for (int i = listeners.length - 1; i >= 0; --i) {
            ((ChartMouseListener)listeners[i]).chartMouseClicked(chartMouseEvent);
        }
    }
    
    public void mouseMoved(final MouseEvent mouseEvent) {
        final Graphics2D graphics2D = (Graphics2D)this.getGraphics();
        if (this.horizontalAxisTrace) {
            this.drawHorizontalAxisTrace(graphics2D, mouseEvent.getX());
        }
        if (this.verticalAxisTrace) {
            this.drawVerticalAxisTrace(graphics2D, mouseEvent.getY());
        }
        graphics2D.dispose();
        final EventListener[] listeners = this.chartMouseListeners.getListeners((Class<EventListener>)((ChartPanel.class$org$jfree$chart$ChartMouseListener == null) ? (ChartPanel.class$org$jfree$chart$ChartMouseListener = class$("org.jfree.chart.ChartMouseListener")) : ChartPanel.class$org$jfree$chart$ChartMouseListener));
        if (listeners.length == 0) {
            return;
        }
        final Insets insets = this.getInsets();
        final int n = (int)((mouseEvent.getX() - insets.left) / this.scaleX);
        final int n2 = (int)((mouseEvent.getY() - insets.top) / this.scaleY);
        ChartEntity entity = null;
        if (this.info != null) {
            final EntityCollection entityCollection = this.info.getEntityCollection();
            if (entityCollection != null) {
                entity = entityCollection.getEntity(n, n2);
            }
        }
        if (this.chart != null) {
            final ChartMouseEvent chartMouseEvent = new ChartMouseEvent(this.getChart(), mouseEvent, entity);
            for (int i = listeners.length - 1; i >= 0; --i) {
                ((ChartMouseListener)listeners[i]).chartMouseMoved(chartMouseEvent);
            }
        }
    }
    
    public void zoomInBoth(final double n, final double n2) {
        this.zoomInDomain(n, n2);
        this.zoomInRange(n, n2);
    }
    
    public void zoomInDomain(final double n, final double n2) {
        final Plot plot = this.chart.getPlot();
        if (plot instanceof Zoomable) {
            ((Zoomable)plot).zoomDomainAxes(this.zoomInFactor, this.info.getPlotInfo(), this.translateScreenToJava2D(new Point((int)n, (int)n2)));
        }
    }
    
    public void zoomInRange(final double n, final double n2) {
        final Plot plot = this.chart.getPlot();
        if (plot instanceof Zoomable) {
            ((Zoomable)plot).zoomRangeAxes(this.zoomInFactor, this.info.getPlotInfo(), this.translateScreenToJava2D(new Point((int)n, (int)n2)));
        }
    }
    
    public void zoomOutBoth(final double n, final double n2) {
        this.zoomOutDomain(n, n2);
        this.zoomOutRange(n, n2);
    }
    
    public void zoomOutDomain(final double n, final double n2) {
        final Plot plot = this.chart.getPlot();
        if (plot instanceof Zoomable) {
            ((Zoomable)plot).zoomDomainAxes(this.zoomOutFactor, this.info.getPlotInfo(), this.translateScreenToJava2D(new Point((int)n, (int)n2)));
        }
    }
    
    public void zoomOutRange(final double n, final double n2) {
        final Plot plot = this.chart.getPlot();
        if (plot instanceof Zoomable) {
            ((Zoomable)plot).zoomRangeAxes(this.zoomOutFactor, this.info.getPlotInfo(), this.translateScreenToJava2D(new Point((int)n, (int)n2)));
        }
    }
    
    public void zoom(final Rectangle2D rectangle2D) {
        final Point2D translateScreenToJava2D = this.translateScreenToJava2D(new Point((int)Math.ceil(rectangle2D.getX()), (int)Math.ceil(rectangle2D.getY())));
        final PlotRenderingInfo plotInfo = this.info.getPlotInfo();
        final Rectangle2D screenDataArea = this.getScreenDataArea((int)rectangle2D.getCenterX(), (int)rectangle2D.getCenterY());
        if (rectangle2D.getHeight() > 0.0 && rectangle2D.getWidth() > 0.0) {
            final double n = (rectangle2D.getMinX() - screenDataArea.getMinX()) / screenDataArea.getWidth();
            final double n2 = (rectangle2D.getMaxX() - screenDataArea.getMinX()) / screenDataArea.getWidth();
            final double n3 = (screenDataArea.getMaxY() - rectangle2D.getMaxY()) / screenDataArea.getHeight();
            final double n4 = (screenDataArea.getMaxY() - rectangle2D.getMinY()) / screenDataArea.getHeight();
            final Plot plot = this.chart.getPlot();
            if (plot instanceof Zoomable) {
                final Zoomable zoomable = (Zoomable)plot;
                if (zoomable.getOrientation() == PlotOrientation.HORIZONTAL) {
                    zoomable.zoomDomainAxes(n3, n4, plotInfo, translateScreenToJava2D);
                    zoomable.zoomRangeAxes(n, n2, plotInfo, translateScreenToJava2D);
                }
                else {
                    zoomable.zoomDomainAxes(n, n2, plotInfo, translateScreenToJava2D);
                    zoomable.zoomRangeAxes(n3, n4, plotInfo, translateScreenToJava2D);
                }
            }
        }
    }
    
    public void restoreAutoBounds() {
        this.restoreAutoDomainBounds();
        this.restoreAutoRangeBounds();
    }
    
    public void restoreAutoDomainBounds() {
        final Plot plot = this.chart.getPlot();
        if (plot instanceof Zoomable) {
            ((Zoomable)plot).zoomDomainAxes(0.0, this.info.getPlotInfo(), this.zoomPoint);
        }
    }
    
    public void restoreAutoRangeBounds() {
        final Plot plot = this.chart.getPlot();
        if (plot instanceof Zoomable) {
            ((Zoomable)plot).zoomRangeAxes(0.0, this.info.getPlotInfo(), this.zoomPoint);
        }
    }
    
    public Rectangle2D getScreenDataArea() {
        final Rectangle2D dataArea = this.info.getPlotInfo().getDataArea();
        final Insets insets = this.getInsets();
        return new Rectangle2D.Double(dataArea.getX() * this.scaleX + insets.left, dataArea.getY() * this.scaleY + insets.top, dataArea.getWidth() * this.scaleX, dataArea.getHeight() * this.scaleY);
    }
    
    public Rectangle2D getScreenDataArea(final int n, final int n2) {
        final PlotRenderingInfo plotInfo = this.info.getPlotInfo();
        Rectangle2D rectangle2D;
        if (plotInfo.getSubplotCount() == 0) {
            rectangle2D = this.getScreenDataArea();
        }
        else {
            final int subplotIndex = plotInfo.getSubplotIndex(this.translateScreenToJava2D(new Point(n, n2)));
            if (subplotIndex == -1) {
                return null;
            }
            rectangle2D = this.scale(plotInfo.getSubplotInfo(subplotIndex).getDataArea());
        }
        return rectangle2D;
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
    
    public void setInitialDelay(final int ownToolTipInitialDelay) {
        this.ownToolTipInitialDelay = ownToolTipInitialDelay;
    }
    
    public void setReshowDelay(final int ownToolTipReshowDelay) {
        this.ownToolTipReshowDelay = ownToolTipReshowDelay;
    }
    
    public void setDismissDelay(final int ownToolTipDismissDelay) {
        this.ownToolTipDismissDelay = ownToolTipDismissDelay;
    }
    
    public double getZoomInFactor() {
        return this.zoomInFactor;
    }
    
    public void setZoomInFactor(final double zoomInFactor) {
        this.zoomInFactor = zoomInFactor;
    }
    
    public double getZoomOutFactor() {
        return this.zoomOutFactor;
    }
    
    public void setZoomOutFactor(final double zoomOutFactor) {
        this.zoomOutFactor = zoomOutFactor;
    }
    
    private void drawZoomRectangle(final Graphics2D graphics2D) {
        graphics2D.setXORMode(Color.gray);
        if (this.zoomRectangle != null) {
            if (this.fillZoomRectangle) {
                graphics2D.fill(this.zoomRectangle);
            }
            else {
                graphics2D.draw(this.zoomRectangle);
            }
        }
        graphics2D.setPaintMode();
    }
    
    private void drawHorizontalAxisTrace(final Graphics2D graphics2D, final int n) {
        final Rectangle2D screenDataArea = this.getScreenDataArea();
        graphics2D.setXORMode(Color.orange);
        if ((int)screenDataArea.getMinX() < n && n < (int)screenDataArea.getMaxX()) {
            if (this.verticalTraceLine != null) {
                graphics2D.draw(this.verticalTraceLine);
                this.verticalTraceLine.setLine(n, (int)screenDataArea.getMinY(), n, (int)screenDataArea.getMaxY());
            }
            else {
                this.verticalTraceLine = new Line2D.Float(n, (int)screenDataArea.getMinY(), n, (int)screenDataArea.getMaxY());
            }
            graphics2D.draw(this.verticalTraceLine);
        }
        graphics2D.setPaintMode();
    }
    
    private void drawVerticalAxisTrace(final Graphics2D graphics2D, final int n) {
        final Rectangle2D screenDataArea = this.getScreenDataArea();
        graphics2D.setXORMode(Color.orange);
        if ((int)screenDataArea.getMinY() < n && n < (int)screenDataArea.getMaxY()) {
            if (this.horizontalTraceLine != null) {
                graphics2D.draw(this.horizontalTraceLine);
                this.horizontalTraceLine.setLine((int)screenDataArea.getMinX(), n, (int)screenDataArea.getMaxX(), n);
            }
            else {
                this.horizontalTraceLine = new Line2D.Float((int)screenDataArea.getMinX(), n, (int)screenDataArea.getMaxX(), n);
            }
            graphics2D.draw(this.horizontalTraceLine);
        }
        graphics2D.setPaintMode();
    }
    
    public void doEditChartProperties() {
        final ChartEditor chartEditor = ChartEditorManager.getChartEditor(this.chart);
        if (JOptionPane.showConfirmDialog(this, chartEditor, ChartPanel.localizationResources.getString("Chart_Properties"), 2, -1) == 0) {
            chartEditor.updateChart(this.chart);
        }
    }
    
    public void doSaveAs() {
        final JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new ExtensionFileFilter(ChartPanel.localizationResources.getString("PNG_Image_Files"), ".png"));
        if (fileChooser.showSaveDialog(this) == 0) {
            String s = fileChooser.getSelectedFile().getPath();
            if (this.isEnforceFileExtensions() && !s.endsWith(".png")) {
                s += ".png";
            }
            ChartUtilities.saveChartAsPNG(new File(s), this.chart, this.getWidth(), this.getHeight());
        }
    }
    
    public void createChartPrintJob() {
        final PrinterJob printerJob = PrinterJob.getPrinterJob();
        final PageFormat defaultPage = printerJob.defaultPage();
        final PageFormat pageDialog = printerJob.pageDialog(defaultPage);
        if (pageDialog != defaultPage) {
            printerJob.setPrintable(this, pageDialog);
            if (printerJob.printDialog()) {
                try {
                    printerJob.print();
                }
                catch (PrinterException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                }
            }
        }
    }
    
    public int print(final Graphics graphics, final PageFormat pageFormat, final int n) {
        if (n != 0) {
            return 1;
        }
        this.chart.draw((Graphics2D)graphics, new Rectangle2D.Double(pageFormat.getImageableX(), pageFormat.getImageableY(), pageFormat.getImageableWidth(), pageFormat.getImageableHeight()), this.anchor, null);
        return 0;
    }
    
    public void addChartMouseListener(final ChartMouseListener chartMouseListener) {
        if (chartMouseListener == null) {
            throw new IllegalArgumentException("Null 'listener' argument.");
        }
        this.chartMouseListeners.add((ChartPanel.class$org$jfree$chart$ChartMouseListener == null) ? (ChartPanel.class$org$jfree$chart$ChartMouseListener = class$("org.jfree.chart.ChartMouseListener")) : ChartPanel.class$org$jfree$chart$ChartMouseListener, chartMouseListener);
    }
    
    public void removeChartMouseListener(final ChartMouseListener chartMouseListener) {
        this.chartMouseListeners.remove((ChartPanel.class$org$jfree$chart$ChartMouseListener == null) ? (ChartPanel.class$org$jfree$chart$ChartMouseListener = class$("org.jfree.chart.ChartMouseListener")) : ChartPanel.class$org$jfree$chart$ChartMouseListener, chartMouseListener);
    }
    
    public EventListener[] getListeners(final Class clazz) {
        if (clazz == ((ChartPanel.class$org$jfree$chart$ChartMouseListener == null) ? (ChartPanel.class$org$jfree$chart$ChartMouseListener = class$("org.jfree.chart.ChartMouseListener")) : ChartPanel.class$org$jfree$chart$ChartMouseListener)) {
            return this.chartMouseListeners.getListeners((Class<EventListener>)clazz);
        }
        return super.getListeners((Class<T>)clazz);
    }
    
    protected JPopupMenu createPopupMenu(final boolean b, final boolean b2, final boolean b3, final boolean b4) {
        final JPopupMenu popupMenu = new JPopupMenu("Chart:");
        int n = 0;
        if (b) {
            final JMenuItem menuItem = new JMenuItem(ChartPanel.localizationResources.getString("Properties..."));
            menuItem.setActionCommand("PROPERTIES");
            menuItem.addActionListener(this);
            popupMenu.add(menuItem);
            n = 1;
        }
        if (b2) {
            if (n != 0) {
                popupMenu.addSeparator();
            }
            final JMenuItem menuItem2 = new JMenuItem(ChartPanel.localizationResources.getString("Save_as..."));
            menuItem2.setActionCommand("SAVE");
            menuItem2.addActionListener(this);
            popupMenu.add(menuItem2);
            n = 1;
        }
        if (b3) {
            if (n != 0) {
                popupMenu.addSeparator();
            }
            final JMenuItem menuItem3 = new JMenuItem(ChartPanel.localizationResources.getString("Print..."));
            menuItem3.setActionCommand("PRINT");
            menuItem3.addActionListener(this);
            popupMenu.add(menuItem3);
            n = 1;
        }
        if (b4) {
            if (n != 0) {
                popupMenu.addSeparator();
            }
            final JMenu menu = new JMenu(ChartPanel.localizationResources.getString("Zoom_In"));
            (this.zoomInBothMenuItem = new JMenuItem(ChartPanel.localizationResources.getString("All_Axes"))).setActionCommand("ZOOM_IN_BOTH");
            this.zoomInBothMenuItem.addActionListener(this);
            menu.add(this.zoomInBothMenuItem);
            menu.addSeparator();
            (this.zoomInDomainMenuItem = new JMenuItem(ChartPanel.localizationResources.getString("Domain_Axis"))).setActionCommand("ZOOM_IN_DOMAIN");
            this.zoomInDomainMenuItem.addActionListener(this);
            menu.add(this.zoomInDomainMenuItem);
            (this.zoomInRangeMenuItem = new JMenuItem(ChartPanel.localizationResources.getString("Range_Axis"))).setActionCommand("ZOOM_IN_RANGE");
            this.zoomInRangeMenuItem.addActionListener(this);
            menu.add(this.zoomInRangeMenuItem);
            popupMenu.add(menu);
            final JMenu menu2 = new JMenu(ChartPanel.localizationResources.getString("Zoom_Out"));
            (this.zoomOutBothMenuItem = new JMenuItem(ChartPanel.localizationResources.getString("All_Axes"))).setActionCommand("ZOOM_OUT_BOTH");
            this.zoomOutBothMenuItem.addActionListener(this);
            menu2.add(this.zoomOutBothMenuItem);
            menu2.addSeparator();
            (this.zoomOutDomainMenuItem = new JMenuItem(ChartPanel.localizationResources.getString("Domain_Axis"))).setActionCommand("ZOOM_DOMAIN_BOTH");
            this.zoomOutDomainMenuItem.addActionListener(this);
            menu2.add(this.zoomOutDomainMenuItem);
            (this.zoomOutRangeMenuItem = new JMenuItem(ChartPanel.localizationResources.getString("Range_Axis"))).setActionCommand("ZOOM_RANGE_BOTH");
            this.zoomOutRangeMenuItem.addActionListener(this);
            menu2.add(this.zoomOutRangeMenuItem);
            popupMenu.add(menu2);
            final JMenu menu3 = new JMenu(ChartPanel.localizationResources.getString("Auto_Range"));
            (this.zoomResetBothMenuItem = new JMenuItem(ChartPanel.localizationResources.getString("All_Axes"))).setActionCommand("ZOOM_RESET_BOTH");
            this.zoomResetBothMenuItem.addActionListener(this);
            menu3.add(this.zoomResetBothMenuItem);
            menu3.addSeparator();
            (this.zoomResetDomainMenuItem = new JMenuItem(ChartPanel.localizationResources.getString("Domain_Axis"))).setActionCommand("ZOOM_RESET_DOMAIN");
            this.zoomResetDomainMenuItem.addActionListener(this);
            menu3.add(this.zoomResetDomainMenuItem);
            (this.zoomResetRangeMenuItem = new JMenuItem(ChartPanel.localizationResources.getString("Range_Axis"))).setActionCommand("ZOOM_RESET_RANGE");
            this.zoomResetRangeMenuItem.addActionListener(this);
            menu3.add(this.zoomResetRangeMenuItem);
            popupMenu.addSeparator();
            popupMenu.add(menu3);
        }
        return popupMenu;
    }
    
    protected void displayPopupMenu(final int n, final int n2) {
        if (this.popup != null) {
            final Plot plot = this.chart.getPlot();
            boolean domainZoomable = false;
            boolean rangeZoomable = false;
            if (plot instanceof Zoomable) {
                final Zoomable zoomable = (Zoomable)plot;
                domainZoomable = zoomable.isDomainZoomable();
                rangeZoomable = zoomable.isRangeZoomable();
            }
            if (this.zoomInDomainMenuItem != null) {
                this.zoomInDomainMenuItem.setEnabled(domainZoomable);
            }
            if (this.zoomOutDomainMenuItem != null) {
                this.zoomOutDomainMenuItem.setEnabled(domainZoomable);
            }
            if (this.zoomResetDomainMenuItem != null) {
                this.zoomResetDomainMenuItem.setEnabled(domainZoomable);
            }
            if (this.zoomInRangeMenuItem != null) {
                this.zoomInRangeMenuItem.setEnabled(rangeZoomable);
            }
            if (this.zoomOutRangeMenuItem != null) {
                this.zoomOutRangeMenuItem.setEnabled(rangeZoomable);
            }
            if (this.zoomResetRangeMenuItem != null) {
                this.zoomResetRangeMenuItem.setEnabled(rangeZoomable);
            }
            if (this.zoomInBothMenuItem != null) {
                this.zoomInBothMenuItem.setEnabled(domainZoomable && rangeZoomable);
            }
            if (this.zoomOutBothMenuItem != null) {
                this.zoomOutBothMenuItem.setEnabled(domainZoomable && rangeZoomable);
            }
            if (this.zoomResetBothMenuItem != null) {
                this.zoomResetBothMenuItem.setEnabled(domainZoomable && rangeZoomable);
            }
            this.popup.show(this, n, n2);
        }
    }
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    static {
        ChartPanel.localizationResources = ResourceBundle.getBundle("org.jfree.chart.LocalizationBundle");
    }
}
