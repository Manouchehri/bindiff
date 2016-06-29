package org.jfree.chart.plot;

import org.jfree.data.*;
import org.jfree.chart.event.*;
import org.jfree.ui.*;
import org.jfree.chart.axis.*;
import java.awt.geom.*;
import java.util.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;
import java.awt.*;

public class FastScatterPlot extends Plot implements Serializable, Cloneable, ValueAxisPlot, Zoomable
{
    private static final long serialVersionUID = 7871545897358563521L;
    public static final Stroke DEFAULT_GRIDLINE_STROKE;
    public static final Paint DEFAULT_GRIDLINE_PAINT;
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
    protected static ResourceBundle localizationResources;
    
    public FastScatterPlot() {
        this(null, new NumberAxis("X"), new NumberAxis("Y"));
    }
    
    public FastScatterPlot(final float[][] data, final ValueAxis domainAxis, final ValueAxis rangeAxis) {
        if (domainAxis == null) {
            throw new IllegalArgumentException("Null 'domainAxis' argument.");
        }
        if (rangeAxis == null) {
            throw new IllegalArgumentException("Null 'rangeAxis' argument.");
        }
        this.data = data;
        this.xDataRange = this.calculateXDataRange(data);
        this.yDataRange = this.calculateYDataRange(data);
        (this.domainAxis = domainAxis).setPlot(this);
        this.domainAxis.addChangeListener(this);
        (this.rangeAxis = rangeAxis).setPlot(this);
        this.rangeAxis.addChangeListener(this);
        this.paint = Color.red;
        this.domainGridlinesVisible = true;
        this.domainGridlinePaint = FastScatterPlot.DEFAULT_GRIDLINE_PAINT;
        this.domainGridlineStroke = FastScatterPlot.DEFAULT_GRIDLINE_STROKE;
        this.rangeGridlinesVisible = true;
        this.rangeGridlinePaint = FastScatterPlot.DEFAULT_GRIDLINE_PAINT;
        this.rangeGridlineStroke = FastScatterPlot.DEFAULT_GRIDLINE_STROKE;
    }
    
    public String getPlotType() {
        return FastScatterPlot.localizationResources.getString("Fast_Scatter_Plot");
    }
    
    public float[][] getData() {
        return this.data;
    }
    
    public void setData(final float[][] data) {
        this.data = data;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public PlotOrientation getOrientation() {
        return PlotOrientation.VERTICAL;
    }
    
    public ValueAxis getDomainAxis() {
        return this.domainAxis;
    }
    
    public void setDomainAxis(final ValueAxis domainAxis) {
        if (domainAxis == null) {
            throw new IllegalArgumentException("Null 'axis' argument.");
        }
        this.domainAxis = domainAxis;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public ValueAxis getRangeAxis() {
        return this.rangeAxis;
    }
    
    public void setRangeAxis(final ValueAxis rangeAxis) {
        if (rangeAxis == null) {
            throw new IllegalArgumentException("Null 'axis' argument.");
        }
        this.rangeAxis = rangeAxis;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getPaint() {
        return this.paint;
    }
    
    public void setPaint(final Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.paint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public boolean isDomainGridlinesVisible() {
        return this.domainGridlinesVisible;
    }
    
    public void setDomainGridlinesVisible(final boolean domainGridlinesVisible) {
        if (this.domainGridlinesVisible != domainGridlinesVisible) {
            this.domainGridlinesVisible = domainGridlinesVisible;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public Stroke getDomainGridlineStroke() {
        return this.domainGridlineStroke;
    }
    
    public void setDomainGridlineStroke(final Stroke domainGridlineStroke) {
        if (domainGridlineStroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.domainGridlineStroke = domainGridlineStroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getDomainGridlinePaint() {
        return this.domainGridlinePaint;
    }
    
    public void setDomainGridlinePaint(final Paint domainGridlinePaint) {
        if (domainGridlinePaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.domainGridlinePaint = domainGridlinePaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public boolean isRangeGridlinesVisible() {
        return this.rangeGridlinesVisible;
    }
    
    public void setRangeGridlinesVisible(final boolean rangeGridlinesVisible) {
        if (this.rangeGridlinesVisible != rangeGridlinesVisible) {
            this.rangeGridlinesVisible = rangeGridlinesVisible;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public Stroke getRangeGridlineStroke() {
        return this.rangeGridlineStroke;
    }
    
    public void setRangeGridlineStroke(final Stroke rangeGridlineStroke) {
        if (rangeGridlineStroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.rangeGridlineStroke = rangeGridlineStroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getRangeGridlinePaint() {
        return this.rangeGridlinePaint;
    }
    
    public void setRangeGridlinePaint(final Paint rangeGridlinePaint) {
        if (rangeGridlinePaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.rangeGridlinePaint = rangeGridlinePaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public void draw(final Graphics2D graphics2D, final Rectangle2D plotArea, final Point2D point2D, final PlotState plotState, final PlotRenderingInfo plotRenderingInfo) {
        if (plotRenderingInfo != null) {
            plotRenderingInfo.setPlotArea(plotArea);
        }
        this.getInsets().trim(plotArea);
        final Rectangle2D shrink = this.rangeAxis.reserveSpace(graphics2D, this, plotArea, RectangleEdge.LEFT, this.domainAxis.reserveSpace(graphics2D, this, plotArea, RectangleEdge.BOTTOM, new AxisSpace())).shrink(plotArea, null);
        if (plotRenderingInfo != null) {
            plotRenderingInfo.setDataArea(shrink);
        }
        this.drawBackground(graphics2D, shrink);
        final AxisState draw = this.domainAxis.draw(graphics2D, shrink.getMaxY(), plotArea, shrink, RectangleEdge.BOTTOM, plotRenderingInfo);
        final AxisState draw2 = this.rangeAxis.draw(graphics2D, shrink.getMinX(), plotArea, shrink, RectangleEdge.LEFT, plotRenderingInfo);
        this.drawDomainGridlines(graphics2D, shrink, draw.getTicks());
        this.drawRangeGridlines(graphics2D, shrink, draw2.getTicks());
        final Shape clip = graphics2D.getClip();
        final Composite composite = graphics2D.getComposite();
        graphics2D.clip(shrink);
        graphics2D.setComposite(AlphaComposite.getInstance(3, this.getForegroundAlpha()));
        this.render(graphics2D, shrink, plotRenderingInfo, null);
        graphics2D.setClip(clip);
        graphics2D.setComposite(composite);
        this.drawOutline(graphics2D, shrink);
    }
    
    public void render(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo, final CrosshairState crosshairState) {
        graphics2D.setPaint(this.paint);
        if (this.data != null) {
            for (int i = 0; i < this.data[0].length; ++i) {
                graphics2D.fillRect((int)this.domainAxis.valueToJava2D(this.data[0][i], rectangle2D, RectangleEdge.BOTTOM), (int)this.rangeAxis.valueToJava2D(this.data[1][i], rectangle2D, RectangleEdge.LEFT), 1, 1);
            }
        }
    }
    
    protected void drawDomainGridlines(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final List list) {
        if (this.isDomainGridlinesVisible()) {
            final Iterator<ValueTick> iterator = list.iterator();
            while (iterator.hasNext()) {
                final double valueToJava2D = this.domainAxis.valueToJava2D(iterator.next().getValue(), rectangle2D, RectangleEdge.BOTTOM);
                final Line2D.Double double1 = new Line2D.Double(valueToJava2D, rectangle2D.getMinY(), valueToJava2D, rectangle2D.getMaxY());
                graphics2D.setPaint(this.getDomainGridlinePaint());
                graphics2D.setStroke(this.getDomainGridlineStroke());
                graphics2D.draw(double1);
            }
        }
    }
    
    protected void drawRangeGridlines(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final List list) {
        if (this.isRangeGridlinesVisible()) {
            final Iterator<ValueTick> iterator = list.iterator();
            while (iterator.hasNext()) {
                final double valueToJava2D = this.rangeAxis.valueToJava2D(iterator.next().getValue(), rectangle2D, RectangleEdge.LEFT);
                final Line2D.Double double1 = new Line2D.Double(rectangle2D.getMinX(), valueToJava2D, rectangle2D.getMaxX(), valueToJava2D);
                graphics2D.setPaint(this.getRangeGridlinePaint());
                graphics2D.setStroke(this.getRangeGridlineStroke());
                graphics2D.draw(double1);
            }
        }
    }
    
    public Range getDataRange(final ValueAxis valueAxis) {
        Range range = null;
        if (valueAxis == this.domainAxis) {
            range = this.xDataRange;
        }
        else if (valueAxis == this.rangeAxis) {
            range = this.yDataRange;
        }
        return range;
    }
    
    private Range calculateXDataRange(final float[][] array) {
        Range range = null;
        if (array != null) {
            float n = Float.POSITIVE_INFINITY;
            float n2 = Float.NEGATIVE_INFINITY;
            for (int i = 0; i < array[0].length; ++i) {
                final float n3 = array[0][i];
                if (n3 < n) {
                    n = n3;
                }
                if (n3 > n2) {
                    n2 = n3;
                }
            }
            if (n <= n2) {
                range = new Range(n, n2);
            }
        }
        return range;
    }
    
    private Range calculateYDataRange(final float[][] array) {
        Range range = null;
        if (array != null) {
            float n = Float.POSITIVE_INFINITY;
            float n2 = Float.NEGATIVE_INFINITY;
            for (int i = 0; i < array[0].length; ++i) {
                final float n3 = array[1][i];
                if (n3 < n) {
                    n = n3;
                }
                if (n3 > n2) {
                    n2 = n3;
                }
            }
            if (n <= n2) {
                range = new Range(n, n2);
            }
        }
        return range;
    }
    
    public void zoomDomainAxes(final double n, final PlotRenderingInfo plotRenderingInfo, final Point2D point2D) {
        this.domainAxis.resizeRange(n);
    }
    
    public void zoomDomainAxes(final double n, final double n2, final PlotRenderingInfo plotRenderingInfo, final Point2D point2D) {
        this.domainAxis.zoomRange(n, n2);
    }
    
    public void zoomRangeAxes(final double n, final PlotRenderingInfo plotRenderingInfo, final Point2D point2D) {
        this.rangeAxis.resizeRange(n);
    }
    
    public void zoomRangeAxes(final double n, final double n2, final PlotRenderingInfo plotRenderingInfo, final Point2D point2D) {
        this.rangeAxis.zoomRange(n, n2);
    }
    
    public boolean isDomainZoomable() {
        return true;
    }
    
    public boolean isRangeZoomable() {
        return true;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!super.equals(o)) {
            return false;
        }
        if (!(o instanceof FastScatterPlot)) {
            return false;
        }
        final FastScatterPlot fastScatterPlot = (FastScatterPlot)o;
        return ArrayUtilities.equal(this.data, fastScatterPlot.data) && ObjectUtilities.equal(this.domainAxis, fastScatterPlot.domainAxis) && ObjectUtilities.equal(this.rangeAxis, fastScatterPlot.rangeAxis) && PaintUtilities.equal(this.paint, fastScatterPlot.paint) && this.domainGridlinesVisible == fastScatterPlot.domainGridlinesVisible && PaintUtilities.equal(this.domainGridlinePaint, fastScatterPlot.domainGridlinePaint) && ObjectUtilities.equal(this.domainGridlineStroke, fastScatterPlot.domainGridlineStroke) && !this.rangeGridlinesVisible != fastScatterPlot.rangeGridlinesVisible && PaintUtilities.equal(this.rangeGridlinePaint, fastScatterPlot.rangeGridlinePaint) && ObjectUtilities.equal(this.rangeGridlineStroke, fastScatterPlot.rangeGridlineStroke);
    }
    
    public Object clone() {
        final FastScatterPlot fastScatterPlot = (FastScatterPlot)super.clone();
        if (this.data != null) {
            fastScatterPlot.data = ArrayUtilities.clone(this.data);
        }
        if (this.domainAxis != null) {
            (fastScatterPlot.domainAxis = (ValueAxis)this.domainAxis.clone()).setPlot(fastScatterPlot);
            fastScatterPlot.domainAxis.addChangeListener(fastScatterPlot);
        }
        if (this.rangeAxis != null) {
            (fastScatterPlot.rangeAxis = (ValueAxis)this.rangeAxis.clone()).setPlot(fastScatterPlot);
            fastScatterPlot.rangeAxis.addChangeListener(fastScatterPlot);
        }
        return fastScatterPlot;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.paint, objectOutputStream);
        SerialUtilities.writeStroke(this.domainGridlineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.domainGridlinePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.rangeGridlineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.rangeGridlinePaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.paint = SerialUtilities.readPaint(objectInputStream);
        this.domainGridlineStroke = SerialUtilities.readStroke(objectInputStream);
        this.domainGridlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.rangeGridlineStroke = SerialUtilities.readStroke(objectInputStream);
        this.rangeGridlinePaint = SerialUtilities.readPaint(objectInputStream);
        if (this.domainAxis != null) {
            this.domainAxis.addChangeListener(this);
        }
        if (this.rangeAxis != null) {
            this.rangeAxis.addChangeListener(this);
        }
    }
    
    static {
        DEFAULT_GRIDLINE_STROKE = new BasicStroke(0.5f, 0, 2, 0.0f, new float[] { 2.0f, 2.0f }, 0.0f);
        DEFAULT_GRIDLINE_PAINT = Color.lightGray;
        FastScatterPlot.localizationResources = ResourceBundle.getBundle("org.jfree.chart.plot.LocalizationBundle");
    }
}
