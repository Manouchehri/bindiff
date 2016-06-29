package org.jfree.chart.plot;

import javax.swing.event.*;
import org.jfree.chart.*;
import java.awt.image.*;
import org.jfree.text.*;
import org.jfree.data.general.*;
import org.jfree.chart.event.*;
import org.jfree.ui.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;
import org.jfree.chart.axis.*;
import java.awt.*;
import java.awt.geom.*;

public abstract class Plot implements Serializable, Cloneable, LegendItemSource, AxisChangeListener, MarkerChangeListener, DatasetChangeListener, PublicCloneable
{
    private static final long serialVersionUID = -8831571430103671324L;
    public static final Number ZERO;
    public static final RectangleInsets DEFAULT_INSETS;
    public static final Stroke DEFAULT_OUTLINE_STROKE;
    public static final Paint DEFAULT_OUTLINE_PAINT;
    public static final float DEFAULT_FOREGROUND_ALPHA = 1.0f;
    public static final float DEFAULT_BACKGROUND_ALPHA = 1.0f;
    public static final Paint DEFAULT_BACKGROUND_PAINT;
    public static final int MINIMUM_WIDTH_TO_DRAW = 10;
    public static final int MINIMUM_HEIGHT_TO_DRAW = 10;
    public static final Shape DEFAULT_LEGEND_ITEM_BOX;
    public static final Shape DEFAULT_LEGEND_ITEM_CIRCLE;
    private Plot parent;
    private DatasetGroup datasetGroup;
    private String noDataMessage;
    private Font noDataMessageFont;
    private transient Paint noDataMessagePaint;
    private RectangleInsets insets;
    private transient Stroke outlineStroke;
    private transient Paint outlinePaint;
    private transient Paint backgroundPaint;
    private transient Image backgroundImage;
    private int backgroundImageAlignment;
    private float backgroundImageAlpha;
    private float foregroundAlpha;
    private float backgroundAlpha;
    private DrawingSupplier drawingSupplier;
    private transient EventListenerList listenerList;
    static Class class$org$jfree$chart$event$PlotChangeListener;
    
    protected Plot() {
        this.backgroundImageAlignment = 15;
        this.backgroundImageAlpha = 0.5f;
        this.parent = null;
        this.insets = Plot.DEFAULT_INSETS;
        this.backgroundPaint = Plot.DEFAULT_BACKGROUND_PAINT;
        this.backgroundAlpha = 1.0f;
        this.backgroundImage = null;
        this.outlineStroke = Plot.DEFAULT_OUTLINE_STROKE;
        this.outlinePaint = Plot.DEFAULT_OUTLINE_PAINT;
        this.foregroundAlpha = 1.0f;
        this.noDataMessage = null;
        this.noDataMessageFont = new Font("SansSerif", 0, 12);
        this.noDataMessagePaint = Color.black;
        this.drawingSupplier = new DefaultDrawingSupplier();
        this.listenerList = new EventListenerList();
    }
    
    public DatasetGroup getDatasetGroup() {
        return this.datasetGroup;
    }
    
    protected void setDatasetGroup(final DatasetGroup datasetGroup) {
        this.datasetGroup = datasetGroup;
    }
    
    public String getNoDataMessage() {
        return this.noDataMessage;
    }
    
    public void setNoDataMessage(final String noDataMessage) {
        this.noDataMessage = noDataMessage;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Font getNoDataMessageFont() {
        return this.noDataMessageFont;
    }
    
    public void setNoDataMessageFont(final Font noDataMessageFont) {
        if (noDataMessageFont == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        this.noDataMessageFont = noDataMessageFont;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getNoDataMessagePaint() {
        return this.noDataMessagePaint;
    }
    
    public void setNoDataMessagePaint(final Paint noDataMessagePaint) {
        if (noDataMessagePaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.noDataMessagePaint = noDataMessagePaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public abstract String getPlotType();
    
    public Plot getParent() {
        return this.parent;
    }
    
    public void setParent(final Plot parent) {
        this.parent = parent;
    }
    
    public Plot getRootPlot() {
        final Plot parent = this.getParent();
        if (parent == null) {
            return this;
        }
        return parent.getRootPlot();
    }
    
    public boolean isSubplot() {
        return this.getParent() != null;
    }
    
    public RectangleInsets getInsets() {
        return this.insets;
    }
    
    public void setInsets(final RectangleInsets rectangleInsets) {
        this.setInsets(rectangleInsets, true);
    }
    
    public void setInsets(final RectangleInsets insets, final boolean b) {
        if (insets == null) {
            throw new IllegalArgumentException("Null 'insets' argument.");
        }
        if (!this.insets.equals(insets)) {
            this.insets = insets;
            if (b) {
                this.notifyListeners(new PlotChangeEvent(this));
            }
        }
    }
    
    public Paint getBackgroundPaint() {
        return this.backgroundPaint;
    }
    
    public void setBackgroundPaint(final Paint backgroundPaint) {
        if (backgroundPaint == null) {
            if (this.backgroundPaint != null) {
                this.backgroundPaint = null;
                this.notifyListeners(new PlotChangeEvent(this));
            }
        }
        else {
            if (this.backgroundPaint != null && this.backgroundPaint.equals(backgroundPaint)) {
                return;
            }
            this.backgroundPaint = backgroundPaint;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public float getBackgroundAlpha() {
        return this.backgroundAlpha;
    }
    
    public void setBackgroundAlpha(final float backgroundAlpha) {
        if (this.backgroundAlpha != backgroundAlpha) {
            this.backgroundAlpha = backgroundAlpha;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public DrawingSupplier getDrawingSupplier() {
        final Plot parent = this.getParent();
        DrawingSupplier drawingSupplier;
        if (parent != null) {
            drawingSupplier = parent.getDrawingSupplier();
        }
        else {
            drawingSupplier = this.drawingSupplier;
        }
        return drawingSupplier;
    }
    
    public void setDrawingSupplier(final DrawingSupplier drawingSupplier) {
        this.drawingSupplier = drawingSupplier;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Image getBackgroundImage() {
        return this.backgroundImage;
    }
    
    public void setBackgroundImage(final Image backgroundImage) {
        this.backgroundImage = backgroundImage;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public int getBackgroundImageAlignment() {
        return this.backgroundImageAlignment;
    }
    
    public void setBackgroundImageAlignment(final int backgroundImageAlignment) {
        if (this.backgroundImageAlignment != backgroundImageAlignment) {
            this.backgroundImageAlignment = backgroundImageAlignment;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public float getBackgroundImageAlpha() {
        return this.backgroundImageAlpha;
    }
    
    public void setBackgroundImageAlpha(final float backgroundImageAlpha) {
        if (backgroundImageAlpha < 0.0f || backgroundImageAlpha > 1.0f) {
            throw new IllegalArgumentException("The 'alpha' value must be in the range 0.0f to 1.0f.");
        }
        if (this.backgroundImageAlpha != backgroundImageAlpha) {
            this.backgroundImageAlpha = backgroundImageAlpha;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public Stroke getOutlineStroke() {
        return this.outlineStroke;
    }
    
    public void setOutlineStroke(final Stroke outlineStroke) {
        if (outlineStroke == null) {
            if (this.outlineStroke != null) {
                this.outlineStroke = null;
                this.notifyListeners(new PlotChangeEvent(this));
            }
        }
        else {
            if (this.outlineStroke != null && this.outlineStroke.equals(outlineStroke)) {
                return;
            }
            this.outlineStroke = outlineStroke;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public Paint getOutlinePaint() {
        return this.outlinePaint;
    }
    
    public void setOutlinePaint(final Paint outlinePaint) {
        if (outlinePaint == null) {
            if (this.outlinePaint != null) {
                this.outlinePaint = null;
                this.notifyListeners(new PlotChangeEvent(this));
            }
        }
        else {
            if (this.outlinePaint != null && this.outlinePaint.equals(outlinePaint)) {
                return;
            }
            this.outlinePaint = outlinePaint;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public float getForegroundAlpha() {
        return this.foregroundAlpha;
    }
    
    public void setForegroundAlpha(final float foregroundAlpha) {
        if (this.foregroundAlpha != foregroundAlpha) {
            this.foregroundAlpha = foregroundAlpha;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public LegendItemCollection getLegendItems() {
        return null;
    }
    
    public void addChangeListener(final PlotChangeListener plotChangeListener) {
        this.listenerList.add((Plot.class$org$jfree$chart$event$PlotChangeListener == null) ? (Plot.class$org$jfree$chart$event$PlotChangeListener = class$("org.jfree.chart.event.PlotChangeListener")) : Plot.class$org$jfree$chart$event$PlotChangeListener, plotChangeListener);
    }
    
    public void removeChangeListener(final PlotChangeListener plotChangeListener) {
        this.listenerList.remove((Plot.class$org$jfree$chart$event$PlotChangeListener == null) ? (Plot.class$org$jfree$chart$event$PlotChangeListener = class$("org.jfree.chart.event.PlotChangeListener")) : Plot.class$org$jfree$chart$event$PlotChangeListener, plotChangeListener);
    }
    
    public void notifyListeners(final PlotChangeEvent plotChangeEvent) {
        final Object[] listenerList = this.listenerList.getListenerList();
        for (int i = listenerList.length - 2; i >= 0; i -= 2) {
            if (listenerList[i] == ((Plot.class$org$jfree$chart$event$PlotChangeListener == null) ? (Plot.class$org$jfree$chart$event$PlotChangeListener = class$("org.jfree.chart.event.PlotChangeListener")) : Plot.class$org$jfree$chart$event$PlotChangeListener)) {
                ((PlotChangeListener)listenerList[i + 1]).plotChanged(plotChangeEvent);
            }
        }
    }
    
    public abstract void draw(final Graphics2D p0, final Rectangle2D p1, final Point2D p2, final PlotState p3, final PlotRenderingInfo p4);
    
    public void drawBackground(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        this.fillBackground(graphics2D, rectangle2D);
        this.drawBackgroundImage(graphics2D, rectangle2D);
    }
    
    protected void fillBackground(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        if (this.backgroundPaint != null) {
            final Composite composite = graphics2D.getComposite();
            graphics2D.setComposite(AlphaComposite.getInstance(3, this.backgroundAlpha));
            graphics2D.setPaint(this.backgroundPaint);
            graphics2D.fill(rectangle2D);
            graphics2D.setComposite(composite);
        }
    }
    
    protected void drawBackgroundImage(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        if (this.backgroundImage != null) {
            final Composite composite = graphics2D.getComposite();
            graphics2D.setComposite(AlphaComposite.getInstance(3, this.backgroundImageAlpha));
            final Rectangle2D.Double double1 = new Rectangle2D.Double(0.0, 0.0, this.backgroundImage.getWidth(null), this.backgroundImage.getHeight(null));
            Align.align(double1, rectangle2D, this.backgroundImageAlignment);
            graphics2D.drawImage(this.backgroundImage, (int)double1.getX(), (int)double1.getY(), (int)double1.getWidth() + 1, (int)double1.getHeight() + 1, null);
            graphics2D.setComposite(composite);
        }
    }
    
    public void drawOutline(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        if (this.outlineStroke != null && this.outlinePaint != null) {
            graphics2D.setStroke(this.outlineStroke);
            graphics2D.setPaint(this.outlinePaint);
            graphics2D.draw(rectangle2D);
        }
    }
    
    protected void drawNoDataMessage(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        final Shape clip = graphics2D.getClip();
        graphics2D.clip(rectangle2D);
        if (this.noDataMessage != null) {
            graphics2D.setFont(this.noDataMessageFont);
            graphics2D.setPaint(this.noDataMessagePaint);
            TextUtilities.createTextBlock(this.noDataMessage, this.noDataMessageFont, this.noDataMessagePaint, 0.9f * (float)rectangle2D.getWidth(), new G2TextMeasurer(graphics2D)).draw(graphics2D, (float)rectangle2D.getCenterX(), (float)rectangle2D.getCenterY(), TextBlockAnchor.CENTER);
        }
        graphics2D.setClip(clip);
    }
    
    public void handleClick(final int n, final int n2, final PlotRenderingInfo plotRenderingInfo) {
    }
    
    public void zoom(final double n) {
    }
    
    public void axisChanged(final AxisChangeEvent axisChangeEvent) {
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public void datasetChanged(final DatasetChangeEvent datasetChangeEvent) {
        final PlotChangeEvent plotChangeEvent = new PlotChangeEvent(this);
        plotChangeEvent.setType(ChartChangeEventType.DATASET_UPDATED);
        this.notifyListeners(plotChangeEvent);
    }
    
    public void markerChanged(final MarkerChangeEvent markerChangeEvent) {
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    protected double getRectX(final double n, final double n2, final double n3, final RectangleEdge rectangleEdge) {
        double n4 = n;
        if (rectangleEdge == RectangleEdge.LEFT) {
            n4 += n2;
        }
        else if (rectangleEdge == RectangleEdge.RIGHT) {
            n4 += n3;
        }
        return n4;
    }
    
    protected double getRectY(final double n, final double n2, final double n3, final RectangleEdge rectangleEdge) {
        double n4 = n;
        if (rectangleEdge == RectangleEdge.TOP) {
            n4 += n2;
        }
        else if (rectangleEdge == RectangleEdge.BOTTOM) {
            n4 += n3;
        }
        return n4;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Plot)) {
            return false;
        }
        final Plot plot = (Plot)o;
        return ObjectUtilities.equal(this.noDataMessage, plot.noDataMessage) && ObjectUtilities.equal(this.noDataMessageFont, plot.noDataMessageFont) && PaintUtilities.equal(this.noDataMessagePaint, plot.noDataMessagePaint) && ObjectUtilities.equal(this.insets, plot.insets) && ObjectUtilities.equal(this.outlineStroke, plot.outlineStroke) && PaintUtilities.equal(this.outlinePaint, plot.outlinePaint) && PaintUtilities.equal(this.backgroundPaint, plot.backgroundPaint) && ObjectUtilities.equal(this.backgroundImage, plot.backgroundImage) && this.backgroundImageAlignment == plot.backgroundImageAlignment && this.backgroundImageAlpha == plot.backgroundImageAlpha && this.foregroundAlpha == plot.foregroundAlpha && this.backgroundAlpha == plot.backgroundAlpha && this.drawingSupplier.equals(plot.drawingSupplier);
    }
    
    public Object clone() {
        final Plot plot = (Plot)super.clone();
        if (this.datasetGroup != null) {
            plot.datasetGroup = (DatasetGroup)ObjectUtilities.clone(this.datasetGroup);
        }
        plot.drawingSupplier = (DrawingSupplier)ObjectUtilities.clone(this.drawingSupplier);
        plot.listenerList = new EventListenerList();
        return plot;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.noDataMessagePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.outlineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.outlinePaint, objectOutputStream);
        SerialUtilities.writePaint(this.backgroundPaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.noDataMessagePaint = SerialUtilities.readPaint(objectInputStream);
        this.outlineStroke = SerialUtilities.readStroke(objectInputStream);
        this.outlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.backgroundPaint = SerialUtilities.readPaint(objectInputStream);
        this.listenerList = new EventListenerList();
    }
    
    public static RectangleEdge resolveDomainAxisLocation(final AxisLocation axisLocation, final PlotOrientation plotOrientation) {
        if (axisLocation == null) {
            throw new IllegalArgumentException("Null 'location' argument.");
        }
        if (plotOrientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        RectangleEdge rectangleEdge = null;
        if (axisLocation == AxisLocation.TOP_OR_RIGHT) {
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                rectangleEdge = RectangleEdge.RIGHT;
            }
            else if (plotOrientation == PlotOrientation.VERTICAL) {
                rectangleEdge = RectangleEdge.TOP;
            }
        }
        else if (axisLocation == AxisLocation.TOP_OR_LEFT) {
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                rectangleEdge = RectangleEdge.LEFT;
            }
            else if (plotOrientation == PlotOrientation.VERTICAL) {
                rectangleEdge = RectangleEdge.TOP;
            }
        }
        else if (axisLocation == AxisLocation.BOTTOM_OR_RIGHT) {
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                rectangleEdge = RectangleEdge.RIGHT;
            }
            else if (plotOrientation == PlotOrientation.VERTICAL) {
                rectangleEdge = RectangleEdge.BOTTOM;
            }
        }
        else if (axisLocation == AxisLocation.BOTTOM_OR_LEFT) {
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                rectangleEdge = RectangleEdge.LEFT;
            }
            else if (plotOrientation == PlotOrientation.VERTICAL) {
                rectangleEdge = RectangleEdge.BOTTOM;
            }
        }
        if (rectangleEdge == null) {
            throw new IllegalStateException("resolveDomainAxisLocation()");
        }
        return rectangleEdge;
    }
    
    public static RectangleEdge resolveRangeAxisLocation(final AxisLocation axisLocation, final PlotOrientation plotOrientation) {
        if (axisLocation == null) {
            throw new IllegalArgumentException("Null 'location' argument.");
        }
        if (plotOrientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        RectangleEdge rectangleEdge = null;
        if (axisLocation == AxisLocation.TOP_OR_RIGHT) {
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                rectangleEdge = RectangleEdge.TOP;
            }
            else if (plotOrientation == PlotOrientation.VERTICAL) {
                rectangleEdge = RectangleEdge.RIGHT;
            }
        }
        else if (axisLocation == AxisLocation.TOP_OR_LEFT) {
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                rectangleEdge = RectangleEdge.TOP;
            }
            else if (plotOrientation == PlotOrientation.VERTICAL) {
                rectangleEdge = RectangleEdge.LEFT;
            }
        }
        else if (axisLocation == AxisLocation.BOTTOM_OR_RIGHT) {
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                rectangleEdge = RectangleEdge.BOTTOM;
            }
            else if (plotOrientation == PlotOrientation.VERTICAL) {
                rectangleEdge = RectangleEdge.RIGHT;
            }
        }
        else if (axisLocation == AxisLocation.BOTTOM_OR_LEFT) {
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                rectangleEdge = RectangleEdge.BOTTOM;
            }
            else if (plotOrientation == PlotOrientation.VERTICAL) {
                rectangleEdge = RectangleEdge.LEFT;
            }
        }
        if (rectangleEdge == null) {
            throw new IllegalStateException("resolveRangeAxisLocation()");
        }
        return rectangleEdge;
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
        ZERO = new Integer(0);
        DEFAULT_INSETS = new RectangleInsets(4.0, 8.0, 4.0, 8.0);
        DEFAULT_OUTLINE_STROKE = new BasicStroke(0.5f);
        DEFAULT_OUTLINE_PAINT = Color.gray;
        DEFAULT_BACKGROUND_PAINT = Color.white;
        DEFAULT_LEGEND_ITEM_BOX = new Rectangle2D.Double(-4.0, -4.0, 8.0, 8.0);
        DEFAULT_LEGEND_ITEM_CIRCLE = new Ellipse2D.Double(-4.0, -4.0, 8.0, 8.0);
    }
}
