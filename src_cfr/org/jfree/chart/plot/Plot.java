/*
 * Decompiled with CFR 0_115.
 */
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
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.EventListener;
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

public abstract class Plot
implements Serializable,
Cloneable,
LegendItemSource,
AxisChangeListener,
MarkerChangeListener,
DatasetChangeListener,
PublicCloneable {
    private static final long serialVersionUID = -8831571430103671324L;
    public static final Number ZERO = new Integer(0);
    public static final RectangleInsets DEFAULT_INSETS = new RectangleInsets(4.0, 8.0, 4.0, 8.0);
    public static final Stroke DEFAULT_OUTLINE_STROKE = new BasicStroke(0.5f);
    public static final Paint DEFAULT_OUTLINE_PAINT = Color.gray;
    public static final float DEFAULT_FOREGROUND_ALPHA = 1.0f;
    public static final float DEFAULT_BACKGROUND_ALPHA = 1.0f;
    public static final Paint DEFAULT_BACKGROUND_PAINT = Color.white;
    public static final int MINIMUM_WIDTH_TO_DRAW = 10;
    public static final int MINIMUM_HEIGHT_TO_DRAW = 10;
    public static final Shape DEFAULT_LEGEND_ITEM_BOX = new Rectangle2D.Double(-4.0, -4.0, 8.0, 8.0);
    public static final Shape DEFAULT_LEGEND_ITEM_CIRCLE = new Ellipse2D.Double(-4.0, -4.0, 8.0, 8.0);
    private Plot parent = null;
    private DatasetGroup datasetGroup;
    private String noDataMessage = null;
    private Font noDataMessageFont = new Font("SansSerif", 0, 12);
    private transient Paint noDataMessagePaint = Color.black;
    private RectangleInsets insets = DEFAULT_INSETS;
    private transient Stroke outlineStroke = DEFAULT_OUTLINE_STROKE;
    private transient Paint outlinePaint = DEFAULT_OUTLINE_PAINT;
    private transient Paint backgroundPaint = DEFAULT_BACKGROUND_PAINT;
    private transient Image backgroundImage = null;
    private int backgroundImageAlignment = 15;
    private float backgroundImageAlpha = 0.5f;
    private float foregroundAlpha = 1.0f;
    private float backgroundAlpha = 1.0f;
    private DrawingSupplier drawingSupplier = new DefaultDrawingSupplier();
    private transient EventListenerList listenerList = new EventListenerList();
    static Class class$org$jfree$chart$event$PlotChangeListener;

    protected Plot() {
    }

    public DatasetGroup getDatasetGroup() {
        return this.datasetGroup;
    }

    protected void setDatasetGroup(DatasetGroup datasetGroup) {
        this.datasetGroup = datasetGroup;
    }

    public String getNoDataMessage() {
        return this.noDataMessage;
    }

    public void setNoDataMessage(String string) {
        this.noDataMessage = string;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Font getNoDataMessageFont() {
        return this.noDataMessageFont;
    }

    public void setNoDataMessageFont(Font font) {
        if (font == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        this.noDataMessageFont = font;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getNoDataMessagePaint() {
        return this.noDataMessagePaint;
    }

    public void setNoDataMessagePaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.noDataMessagePaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public abstract String getPlotType();

    public Plot getParent() {
        return this.parent;
    }

    public void setParent(Plot plot) {
        this.parent = plot;
    }

    public Plot getRootPlot() {
        Plot plot = this.getParent();
        if (plot != null) return plot.getRootPlot();
        return this;
    }

    public boolean isSubplot() {
        if (this.getParent() == null) return false;
        return true;
    }

    public RectangleInsets getInsets() {
        return this.insets;
    }

    public void setInsets(RectangleInsets rectangleInsets) {
        this.setInsets(rectangleInsets, true);
    }

    public void setInsets(RectangleInsets rectangleInsets, boolean bl2) {
        if (rectangleInsets == null) {
            throw new IllegalArgumentException("Null 'insets' argument.");
        }
        if (this.insets.equals(rectangleInsets)) return;
        this.insets = rectangleInsets;
        if (!bl2) return;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getBackgroundPaint() {
        return this.backgroundPaint;
    }

    public void setBackgroundPaint(Paint paint) {
        if (paint == null) {
            if (this.backgroundPaint == null) return;
            this.backgroundPaint = null;
            this.notifyListeners(new PlotChangeEvent(this));
            return;
        }
        if (this.backgroundPaint != null && this.backgroundPaint.equals(paint)) {
            return;
        }
        this.backgroundPaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public float getBackgroundAlpha() {
        return this.backgroundAlpha;
    }

    public void setBackgroundAlpha(float f2) {
        if (this.backgroundAlpha == f2) return;
        this.backgroundAlpha = f2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public DrawingSupplier getDrawingSupplier() {
        DrawingSupplier drawingSupplier = null;
        Plot plot = this.getParent();
        if (plot == null) return this.drawingSupplier;
        return plot.getDrawingSupplier();
    }

    public void setDrawingSupplier(DrawingSupplier drawingSupplier) {
        this.drawingSupplier = drawingSupplier;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Image getBackgroundImage() {
        return this.backgroundImage;
    }

    public void setBackgroundImage(Image image) {
        this.backgroundImage = image;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public int getBackgroundImageAlignment() {
        return this.backgroundImageAlignment;
    }

    public void setBackgroundImageAlignment(int n2) {
        if (this.backgroundImageAlignment == n2) return;
        this.backgroundImageAlignment = n2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public float getBackgroundImageAlpha() {
        return this.backgroundImageAlpha;
    }

    public void setBackgroundImageAlpha(float f2) {
        if (f2 < 0.0f) throw new IllegalArgumentException("The 'alpha' value must be in the range 0.0f to 1.0f.");
        if (f2 > 1.0f) {
            throw new IllegalArgumentException("The 'alpha' value must be in the range 0.0f to 1.0f.");
        }
        if (this.backgroundImageAlpha == f2) return;
        this.backgroundImageAlpha = f2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Stroke getOutlineStroke() {
        return this.outlineStroke;
    }

    public void setOutlineStroke(Stroke stroke) {
        if (stroke == null) {
            if (this.outlineStroke == null) return;
            this.outlineStroke = null;
            this.notifyListeners(new PlotChangeEvent(this));
            return;
        }
        if (this.outlineStroke != null && this.outlineStroke.equals(stroke)) {
            return;
        }
        this.outlineStroke = stroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getOutlinePaint() {
        return this.outlinePaint;
    }

    public void setOutlinePaint(Paint paint) {
        if (paint == null) {
            if (this.outlinePaint == null) return;
            this.outlinePaint = null;
            this.notifyListeners(new PlotChangeEvent(this));
            return;
        }
        if (this.outlinePaint != null && this.outlinePaint.equals(paint)) {
            return;
        }
        this.outlinePaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public float getForegroundAlpha() {
        return this.foregroundAlpha;
    }

    public void setForegroundAlpha(float f2) {
        if (this.foregroundAlpha == f2) return;
        this.foregroundAlpha = f2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    @Override
    public LegendItemCollection getLegendItems() {
        return null;
    }

    public void addChangeListener(PlotChangeListener plotChangeListener) {
        Class class_ = class$org$jfree$chart$event$PlotChangeListener == null ? (Plot.class$org$jfree$chart$event$PlotChangeListener = Plot.class$("org.jfree.chart.event.PlotChangeListener")) : class$org$jfree$chart$event$PlotChangeListener;
        this.listenerList.add(class_, plotChangeListener);
    }

    public void removeChangeListener(PlotChangeListener plotChangeListener) {
        Class class_ = class$org$jfree$chart$event$PlotChangeListener == null ? (Plot.class$org$jfree$chart$event$PlotChangeListener = Plot.class$("org.jfree.chart.event.PlotChangeListener")) : class$org$jfree$chart$event$PlotChangeListener;
        this.listenerList.remove(class_, plotChangeListener);
    }

    public void notifyListeners(PlotChangeEvent plotChangeEvent) {
        Object[] arrobject = this.listenerList.getListenerList();
        int n2 = arrobject.length - 2;
        while (n2 >= 0) {
            if (arrobject[n2] == (class$org$jfree$chart$event$PlotChangeListener == null ? Plot.class$("org.jfree.chart.event.PlotChangeListener") : class$org$jfree$chart$event$PlotChangeListener)) {
                ((PlotChangeListener)arrobject[n2 + 1]).plotChanged(plotChangeEvent);
            }
            n2 -= 2;
        }
    }

    public abstract void draw(Graphics2D var1, Rectangle2D var2, Point2D var3, PlotState var4, PlotRenderingInfo var5);

    public void drawBackground(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        this.fillBackground(graphics2D, rectangle2D);
        this.drawBackgroundImage(graphics2D, rectangle2D);
    }

    protected void fillBackground(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        if (this.backgroundPaint == null) return;
        Composite composite = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.getInstance(3, this.backgroundAlpha));
        graphics2D.setPaint(this.backgroundPaint);
        graphics2D.fill(rectangle2D);
        graphics2D.setComposite(composite);
    }

    protected void drawBackgroundImage(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        if (this.backgroundImage == null) return;
        Composite composite = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.getInstance(3, this.backgroundImageAlpha));
        Rectangle2D.Double double_ = new Rectangle2D.Double(0.0, 0.0, this.backgroundImage.getWidth(null), this.backgroundImage.getHeight(null));
        Align.align(double_, rectangle2D, this.backgroundImageAlignment);
        graphics2D.drawImage(this.backgroundImage, (int)double_.getX(), (int)double_.getY(), (int)double_.getWidth() + 1, (int)double_.getHeight() + 1, null);
        graphics2D.setComposite(composite);
    }

    public void drawOutline(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        if (this.outlineStroke == null) return;
        if (this.outlinePaint == null) return;
        graphics2D.setStroke(this.outlineStroke);
        graphics2D.setPaint(this.outlinePaint);
        graphics2D.draw(rectangle2D);
    }

    protected void drawNoDataMessage(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        Shape shape = graphics2D.getClip();
        graphics2D.clip(rectangle2D);
        String string = this.noDataMessage;
        if (string != null) {
            graphics2D.setFont(this.noDataMessageFont);
            graphics2D.setPaint(this.noDataMessagePaint);
            TextBlock textBlock = TextUtilities.createTextBlock(this.noDataMessage, this.noDataMessageFont, this.noDataMessagePaint, 0.9f * (float)rectangle2D.getWidth(), new G2TextMeasurer(graphics2D));
            textBlock.draw(graphics2D, (float)rectangle2D.getCenterX(), (float)rectangle2D.getCenterY(), TextBlockAnchor.CENTER);
        }
        graphics2D.setClip(shape);
    }

    public void handleClick(int n2, int n3, PlotRenderingInfo plotRenderingInfo) {
    }

    public void zoom(double d2) {
    }

    @Override
    public void axisChanged(AxisChangeEvent axisChangeEvent) {
        this.notifyListeners(new PlotChangeEvent(this));
    }

    @Override
    public void datasetChanged(DatasetChangeEvent datasetChangeEvent) {
        PlotChangeEvent plotChangeEvent = new PlotChangeEvent(this);
        plotChangeEvent.setType(ChartChangeEventType.DATASET_UPDATED);
        this.notifyListeners(plotChangeEvent);
    }

    @Override
    public void markerChanged(MarkerChangeEvent markerChangeEvent) {
        this.notifyListeners(new PlotChangeEvent(this));
    }

    protected double getRectX(double d2, double d3, double d4, RectangleEdge rectangleEdge) {
        double d5 = d2;
        if (rectangleEdge == RectangleEdge.LEFT) {
            return d5 += d3;
        }
        if (rectangleEdge != RectangleEdge.RIGHT) return d5;
        d5 += d4;
        return d5;
    }

    protected double getRectY(double d2, double d3, double d4, RectangleEdge rectangleEdge) {
        double d5 = d2;
        if (rectangleEdge == RectangleEdge.TOP) {
            return d5 += d3;
        }
        if (rectangleEdge != RectangleEdge.BOTTOM) return d5;
        d5 += d4;
        return d5;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Plot)) {
            return false;
        }
        Plot plot = (Plot)object;
        if (!ObjectUtilities.equal(this.noDataMessage, plot.noDataMessage)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.noDataMessageFont, plot.noDataMessageFont)) {
            return false;
        }
        if (!PaintUtilities.equal(this.noDataMessagePaint, plot.noDataMessagePaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.insets, plot.insets)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.outlineStroke, plot.outlineStroke)) {
            return false;
        }
        if (!PaintUtilities.equal(this.outlinePaint, plot.outlinePaint)) {
            return false;
        }
        if (!PaintUtilities.equal(this.backgroundPaint, plot.backgroundPaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.backgroundImage, plot.backgroundImage)) {
            return false;
        }
        if (this.backgroundImageAlignment != plot.backgroundImageAlignment) {
            return false;
        }
        if (this.backgroundImageAlpha != plot.backgroundImageAlpha) {
            return false;
        }
        if (this.foregroundAlpha != plot.foregroundAlpha) {
            return false;
        }
        if (this.backgroundAlpha != plot.backgroundAlpha) {
            return false;
        }
        if (this.drawingSupplier.equals(plot.drawingSupplier)) return true;
        return false;
    }

    @Override
    public Object clone() {
        Plot plot = (Plot)super.clone();
        if (this.datasetGroup != null) {
            plot.datasetGroup = (DatasetGroup)ObjectUtilities.clone(this.datasetGroup);
        }
        plot.drawingSupplier = (DrawingSupplier)ObjectUtilities.clone(this.drawingSupplier);
        plot.listenerList = new EventListenerList();
        return plot;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.noDataMessagePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.outlineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.outlinePaint, objectOutputStream);
        SerialUtilities.writePaint(this.backgroundPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.noDataMessagePaint = SerialUtilities.readPaint(objectInputStream);
        this.outlineStroke = SerialUtilities.readStroke(objectInputStream);
        this.outlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.backgroundPaint = SerialUtilities.readPaint(objectInputStream);
        this.listenerList = new EventListenerList();
    }

    public static RectangleEdge resolveDomainAxisLocation(AxisLocation axisLocation, PlotOrientation plotOrientation) {
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
            } else if (plotOrientation == PlotOrientation.VERTICAL) {
                rectangleEdge = RectangleEdge.TOP;
            }
        } else if (axisLocation == AxisLocation.TOP_OR_LEFT) {
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                rectangleEdge = RectangleEdge.LEFT;
            } else if (plotOrientation == PlotOrientation.VERTICAL) {
                rectangleEdge = RectangleEdge.TOP;
            }
        } else if (axisLocation == AxisLocation.BOTTOM_OR_RIGHT) {
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                rectangleEdge = RectangleEdge.RIGHT;
            } else if (plotOrientation == PlotOrientation.VERTICAL) {
                rectangleEdge = RectangleEdge.BOTTOM;
            }
        } else if (axisLocation == AxisLocation.BOTTOM_OR_LEFT) {
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                rectangleEdge = RectangleEdge.LEFT;
            } else if (plotOrientation == PlotOrientation.VERTICAL) {
                rectangleEdge = RectangleEdge.BOTTOM;
            }
        }
        if (rectangleEdge != null) return rectangleEdge;
        throw new IllegalStateException("resolveDomainAxisLocation()");
    }

    public static RectangleEdge resolveRangeAxisLocation(AxisLocation axisLocation, PlotOrientation plotOrientation) {
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
            } else if (plotOrientation == PlotOrientation.VERTICAL) {
                rectangleEdge = RectangleEdge.RIGHT;
            }
        } else if (axisLocation == AxisLocation.TOP_OR_LEFT) {
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                rectangleEdge = RectangleEdge.TOP;
            } else if (plotOrientation == PlotOrientation.VERTICAL) {
                rectangleEdge = RectangleEdge.LEFT;
            }
        } else if (axisLocation == AxisLocation.BOTTOM_OR_RIGHT) {
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                rectangleEdge = RectangleEdge.BOTTOM;
            } else if (plotOrientation == PlotOrientation.VERTICAL) {
                rectangleEdge = RectangleEdge.RIGHT;
            }
        } else if (axisLocation == AxisLocation.BOTTOM_OR_LEFT) {
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                rectangleEdge = RectangleEdge.BOTTOM;
            } else if (plotOrientation == PlotOrientation.VERTICAL) {
                rectangleEdge = RectangleEdge.LEFT;
            }
        }
        if (rectangleEdge != null) return rectangleEdge;
        throw new IllegalStateException("resolveRangeAxisLocation()");
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

