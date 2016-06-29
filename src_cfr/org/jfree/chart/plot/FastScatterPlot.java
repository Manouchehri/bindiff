/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.axis.ValueTick;
import org.jfree.chart.event.AxisChangeListener;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.chart.plot.ValueAxisPlot;
import org.jfree.chart.plot.Zoomable;
import org.jfree.data.Range;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.ArrayUtilities;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;

public class FastScatterPlot
extends Plot
implements Serializable,
Cloneable,
ValueAxisPlot,
Zoomable {
    private static final long serialVersionUID = 7871545897358563521L;
    public static final Stroke DEFAULT_GRIDLINE_STROKE = new BasicStroke(0.5f, 0, 2, 0.0f, new float[]{2.0f, 2.0f}, 0.0f);
    public static final Paint DEFAULT_GRIDLINE_PAINT = Color.lightGray;
    private float[][] data;
    private Range xDataRange;
    private Range yDataRange;
    private ValueAxis domainAxis;
    private ValueAxis rangeAxis;
    private transient Paint paint;
    private boolean domainGridlinesVisible;
    private transient Stroke domainGridlineStroke;
    private transient Paint domainGridlinePaint;
    private boolean rangeGridlinesVisible;
    private transient Stroke rangeGridlineStroke;
    private transient Paint rangeGridlinePaint;
    protected static ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.chart.plot.LocalizationBundle");

    public FastScatterPlot() {
        this(null, new NumberAxis("X"), new NumberAxis("Y"));
    }

    public FastScatterPlot(float[][] arrf, ValueAxis valueAxis, ValueAxis valueAxis2) {
        if (valueAxis == null) {
            throw new IllegalArgumentException("Null 'domainAxis' argument.");
        }
        if (valueAxis2 == null) {
            throw new IllegalArgumentException("Null 'rangeAxis' argument.");
        }
        this.data = arrf;
        this.xDataRange = this.calculateXDataRange(arrf);
        this.yDataRange = this.calculateYDataRange(arrf);
        this.domainAxis = valueAxis;
        this.domainAxis.setPlot(this);
        this.domainAxis.addChangeListener(this);
        this.rangeAxis = valueAxis2;
        this.rangeAxis.setPlot(this);
        this.rangeAxis.addChangeListener(this);
        this.paint = Color.red;
        this.domainGridlinesVisible = true;
        this.domainGridlinePaint = DEFAULT_GRIDLINE_PAINT;
        this.domainGridlineStroke = DEFAULT_GRIDLINE_STROKE;
        this.rangeGridlinesVisible = true;
        this.rangeGridlinePaint = DEFAULT_GRIDLINE_PAINT;
        this.rangeGridlineStroke = DEFAULT_GRIDLINE_STROKE;
    }

    @Override
    public String getPlotType() {
        return localizationResources.getString("Fast_Scatter_Plot");
    }

    public float[][] getData() {
        return this.data;
    }

    public void setData(float[][] arrf) {
        this.data = arrf;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    @Override
    public PlotOrientation getOrientation() {
        return PlotOrientation.VERTICAL;
    }

    public ValueAxis getDomainAxis() {
        return this.domainAxis;
    }

    public void setDomainAxis(ValueAxis valueAxis) {
        if (valueAxis == null) {
            throw new IllegalArgumentException("Null 'axis' argument.");
        }
        this.domainAxis = valueAxis;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public ValueAxis getRangeAxis() {
        return this.rangeAxis;
    }

    public void setRangeAxis(ValueAxis valueAxis) {
        if (valueAxis == null) {
            throw new IllegalArgumentException("Null 'axis' argument.");
        }
        this.rangeAxis = valueAxis;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getPaint() {
        return this.paint;
    }

    public void setPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.paint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public boolean isDomainGridlinesVisible() {
        return this.domainGridlinesVisible;
    }

    public void setDomainGridlinesVisible(boolean bl2) {
        if (this.domainGridlinesVisible == bl2) return;
        this.domainGridlinesVisible = bl2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Stroke getDomainGridlineStroke() {
        return this.domainGridlineStroke;
    }

    public void setDomainGridlineStroke(Stroke stroke) {
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.domainGridlineStroke = stroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getDomainGridlinePaint() {
        return this.domainGridlinePaint;
    }

    public void setDomainGridlinePaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.domainGridlinePaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public boolean isRangeGridlinesVisible() {
        return this.rangeGridlinesVisible;
    }

    public void setRangeGridlinesVisible(boolean bl2) {
        if (this.rangeGridlinesVisible == bl2) return;
        this.rangeGridlinesVisible = bl2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Stroke getRangeGridlineStroke() {
        return this.rangeGridlineStroke;
    }

    public void setRangeGridlineStroke(Stroke stroke) {
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.rangeGridlineStroke = stroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getRangeGridlinePaint() {
        return this.rangeGridlinePaint;
    }

    public void setRangeGridlinePaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.rangeGridlinePaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    @Override
    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D, Point2D point2D, PlotState plotState, PlotRenderingInfo plotRenderingInfo) {
        if (plotRenderingInfo != null) {
            plotRenderingInfo.setPlotArea(rectangle2D);
        }
        RectangleInsets rectangleInsets = this.getInsets();
        rectangleInsets.trim(rectangle2D);
        AxisSpace axisSpace = new AxisSpace();
        axisSpace = this.domainAxis.reserveSpace(graphics2D, this, rectangle2D, RectangleEdge.BOTTOM, axisSpace);
        axisSpace = this.rangeAxis.reserveSpace(graphics2D, this, rectangle2D, RectangleEdge.LEFT, axisSpace);
        Rectangle2D rectangle2D2 = axisSpace.shrink(rectangle2D, null);
        if (plotRenderingInfo != null) {
            plotRenderingInfo.setDataArea(rectangle2D2);
        }
        this.drawBackground(graphics2D, rectangle2D2);
        AxisState axisState = this.domainAxis.draw(graphics2D, rectangle2D2.getMaxY(), rectangle2D, rectangle2D2, RectangleEdge.BOTTOM, plotRenderingInfo);
        AxisState axisState2 = this.rangeAxis.draw(graphics2D, rectangle2D2.getMinX(), rectangle2D, rectangle2D2, RectangleEdge.LEFT, plotRenderingInfo);
        this.drawDomainGridlines(graphics2D, rectangle2D2, axisState.getTicks());
        this.drawRangeGridlines(graphics2D, rectangle2D2, axisState2.getTicks());
        Shape shape = graphics2D.getClip();
        Composite composite = graphics2D.getComposite();
        graphics2D.clip(rectangle2D2);
        graphics2D.setComposite(AlphaComposite.getInstance(3, this.getForegroundAlpha()));
        this.render(graphics2D, rectangle2D2, plotRenderingInfo, null);
        graphics2D.setClip(shape);
        graphics2D.setComposite(composite);
        this.drawOutline(graphics2D, rectangle2D2);
    }

    public void render(Graphics2D graphics2D, Rectangle2D rectangle2D, PlotRenderingInfo plotRenderingInfo, CrosshairState crosshairState) {
        graphics2D.setPaint(this.paint);
        if (this.data == null) return;
        int n2 = 0;
        while (n2 < this.data[0].length) {
            float f2 = this.data[0][n2];
            float f3 = this.data[1][n2];
            int n3 = (int)this.domainAxis.valueToJava2D(f2, rectangle2D, RectangleEdge.BOTTOM);
            int n4 = (int)this.rangeAxis.valueToJava2D(f3, rectangle2D, RectangleEdge.LEFT);
            graphics2D.fillRect(n3, n4, 1, 1);
            ++n2;
        }
    }

    protected void drawDomainGridlines(Graphics2D graphics2D, Rectangle2D rectangle2D, List list) {
        if (!this.isDomainGridlinesVisible()) return;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ValueTick valueTick = (ValueTick)iterator.next();
            double d2 = this.domainAxis.valueToJava2D(valueTick.getValue(), rectangle2D, RectangleEdge.BOTTOM);
            Line2D.Double double_ = new Line2D.Double(d2, rectangle2D.getMinY(), d2, rectangle2D.getMaxY());
            graphics2D.setPaint(this.getDomainGridlinePaint());
            graphics2D.setStroke(this.getDomainGridlineStroke());
            graphics2D.draw(double_);
        }
    }

    protected void drawRangeGridlines(Graphics2D graphics2D, Rectangle2D rectangle2D, List list) {
        if (!this.isRangeGridlinesVisible()) return;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ValueTick valueTick = (ValueTick)iterator.next();
            double d2 = this.rangeAxis.valueToJava2D(valueTick.getValue(), rectangle2D, RectangleEdge.LEFT);
            Line2D.Double double_ = new Line2D.Double(rectangle2D.getMinX(), d2, rectangle2D.getMaxX(), d2);
            graphics2D.setPaint(this.getRangeGridlinePaint());
            graphics2D.setStroke(this.getRangeGridlineStroke());
            graphics2D.draw(double_);
        }
    }

    @Override
    public Range getDataRange(ValueAxis valueAxis) {
        Range range = null;
        if (valueAxis == this.domainAxis) {
            return this.xDataRange;
        }
        if (valueAxis != this.rangeAxis) return range;
        return this.yDataRange;
    }

    private Range calculateXDataRange(float[][] arrf) {
        Range range = null;
        if (arrf == null) return range;
        float f2 = Float.POSITIVE_INFINITY;
        float f3 = Float.NEGATIVE_INFINITY;
        int n2 = 0;
        do {
            if (n2 >= arrf[0].length) {
                if (f2 > f3) return range;
                return new Range(f2, f3);
            }
            float f4 = arrf[0][n2];
            if (f4 < f2) {
                f2 = f4;
            }
            if (f4 > f3) {
                f3 = f4;
            }
            ++n2;
        } while (true);
    }

    private Range calculateYDataRange(float[][] arrf) {
        Range range = null;
        if (arrf == null) return range;
        float f2 = Float.POSITIVE_INFINITY;
        float f3 = Float.NEGATIVE_INFINITY;
        int n2 = 0;
        do {
            if (n2 >= arrf[0].length) {
                if (f2 > f3) return range;
                return new Range(f2, f3);
            }
            float f4 = arrf[1][n2];
            if (f4 < f2) {
                f2 = f4;
            }
            if (f4 > f3) {
                f3 = f4;
            }
            ++n2;
        } while (true);
    }

    @Override
    public void zoomDomainAxes(double d2, PlotRenderingInfo plotRenderingInfo, Point2D point2D) {
        this.domainAxis.resizeRange(d2);
    }

    @Override
    public void zoomDomainAxes(double d2, double d3, PlotRenderingInfo plotRenderingInfo, Point2D point2D) {
        this.domainAxis.zoomRange(d2, d3);
    }

    @Override
    public void zoomRangeAxes(double d2, PlotRenderingInfo plotRenderingInfo, Point2D point2D) {
        this.rangeAxis.resizeRange(d2);
    }

    @Override
    public void zoomRangeAxes(double d2, double d3, PlotRenderingInfo plotRenderingInfo, Point2D point2D) {
        this.rangeAxis.zoomRange(d2, d3);
    }

    @Override
    public boolean isDomainZoomable() {
        return true;
    }

    @Override
    public boolean isRangeZoomable() {
        return true;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!super.equals(object)) {
            return false;
        }
        if (!(object instanceof FastScatterPlot)) {
            return false;
        }
        FastScatterPlot fastScatterPlot = (FastScatterPlot)object;
        if (!ArrayUtilities.equal(this.data, fastScatterPlot.data)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.domainAxis, fastScatterPlot.domainAxis)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.rangeAxis, fastScatterPlot.rangeAxis)) {
            return false;
        }
        if (!PaintUtilities.equal(this.paint, fastScatterPlot.paint)) {
            return false;
        }
        if (this.domainGridlinesVisible != fastScatterPlot.domainGridlinesVisible) {
            return false;
        }
        if (!PaintUtilities.equal(this.domainGridlinePaint, fastScatterPlot.domainGridlinePaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.domainGridlineStroke, fastScatterPlot.domainGridlineStroke)) {
            return false;
        }
        if (!this.rangeGridlinesVisible == fastScatterPlot.rangeGridlinesVisible) {
            return false;
        }
        if (!PaintUtilities.equal(this.rangeGridlinePaint, fastScatterPlot.rangeGridlinePaint)) {
            return false;
        }
        if (ObjectUtilities.equal(this.rangeGridlineStroke, fastScatterPlot.rangeGridlineStroke)) return true;
        return false;
    }

    @Override
    public Object clone() {
        FastScatterPlot fastScatterPlot = (FastScatterPlot)super.clone();
        if (this.data != null) {
            fastScatterPlot.data = ArrayUtilities.clone(this.data);
        }
        if (this.domainAxis != null) {
            fastScatterPlot.domainAxis = (ValueAxis)this.domainAxis.clone();
            fastScatterPlot.domainAxis.setPlot(fastScatterPlot);
            fastScatterPlot.domainAxis.addChangeListener(fastScatterPlot);
        }
        if (this.rangeAxis == null) return fastScatterPlot;
        fastScatterPlot.rangeAxis = (ValueAxis)this.rangeAxis.clone();
        fastScatterPlot.rangeAxis.setPlot(fastScatterPlot);
        fastScatterPlot.rangeAxis.addChangeListener(fastScatterPlot);
        return fastScatterPlot;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.paint, objectOutputStream);
        SerialUtilities.writeStroke(this.domainGridlineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.domainGridlinePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.rangeGridlineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.rangeGridlinePaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.paint = SerialUtilities.readPaint(objectInputStream);
        this.domainGridlineStroke = SerialUtilities.readStroke(objectInputStream);
        this.domainGridlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.rangeGridlineStroke = SerialUtilities.readStroke(objectInputStream);
        this.rangeGridlinePaint = SerialUtilities.readPaint(objectInputStream);
        if (this.domainAxis != null) {
            this.domainAxis.addChangeListener(this);
        }
        if (this.rangeAxis == null) return;
        this.rangeAxis.addChangeListener(this);
    }
}

