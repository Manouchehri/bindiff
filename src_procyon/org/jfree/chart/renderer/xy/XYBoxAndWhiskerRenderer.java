package org.jfree.chart.renderer.xy;

import org.jfree.chart.labels.*;
import org.jfree.chart.event.*;
import org.jfree.chart.axis.*;
import org.jfree.data.xy.*;
import org.jfree.chart.plot.*;
import org.jfree.data.statistics.*;
import java.awt.*;
import org.jfree.chart.entity.*;
import org.jfree.ui.*;
import org.jfree.chart.renderer.*;
import java.util.*;
import java.awt.geom.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class XYBoxAndWhiskerRenderer extends AbstractXYItemRenderer implements Serializable, Cloneable, XYItemRenderer, PublicCloneable
{
    private static final long serialVersionUID = -8020170108532232324L;
    private double boxWidth;
    private transient Paint boxPaint;
    private boolean fillBox;
    private transient Paint artifactPaint;
    
    public XYBoxAndWhiskerRenderer() {
        this(-1.0);
    }
    
    public XYBoxAndWhiskerRenderer(final double boxWidth) {
        this.artifactPaint = Color.black;
        this.boxWidth = boxWidth;
        this.boxPaint = Color.green;
        this.fillBox = true;
        this.setToolTipGenerator(new BoxAndWhiskerXYToolTipGenerator());
    }
    
    public double getBoxWidth() {
        return this.boxWidth;
    }
    
    public void setBoxWidth(final double boxWidth) {
        if (boxWidth != this.boxWidth) {
            this.boxWidth = boxWidth;
            this.notifyListeners(new RendererChangeEvent(this));
        }
    }
    
    public Paint getBoxPaint() {
        return this.boxPaint;
    }
    
    public void setBoxPaint(final Paint boxPaint) {
        this.boxPaint = boxPaint;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public boolean getFillBox() {
        return this.fillBox;
    }
    
    public void setFillBox(final boolean fillBox) {
        this.fillBox = fillBox;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public Paint getArtifactPaint() {
        return this.artifactPaint;
    }
    
    public void setArtifactPaint(final Paint artifactPaint) {
        if (artifactPaint == null) {
            throw new IllegalArgumentException("Null 'artifactPaint' argument.");
        }
        this.artifactPaint = artifactPaint;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public void drawItem(final Graphics2D graphics2D, final XYItemRendererState xyItemRendererState, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo, final XYPlot xyPlot, final ValueAxis valueAxis, final ValueAxis valueAxis2, final XYDataset xyDataset, final int n, final int n2, final CrosshairState crosshairState, final int n3) {
        final PlotOrientation orientation = xyPlot.getOrientation();
        if (orientation == PlotOrientation.HORIZONTAL) {
            this.drawHorizontalItem(graphics2D, rectangle2D, plotRenderingInfo, xyPlot, valueAxis, valueAxis2, xyDataset, n, n2, crosshairState, n3);
        }
        else if (orientation == PlotOrientation.VERTICAL) {
            this.drawVerticalItem(graphics2D, rectangle2D, plotRenderingInfo, xyPlot, valueAxis, valueAxis2, xyDataset, n, n2, crosshairState, n3);
        }
    }
    
    public void drawHorizontalItem(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo, final XYPlot xyPlot, final ValueAxis valueAxis, final ValueAxis valueAxis2, final XYDataset xyDataset, final int n, final int n2, final CrosshairState crosshairState, final int n3) {
        EntityCollection entityCollection = null;
        if (plotRenderingInfo != null) {
            entityCollection = plotRenderingInfo.getOwner().getEntityCollection();
        }
        final BoxAndWhiskerXYDataset boxAndWhiskerXYDataset = (BoxAndWhiskerXYDataset)xyDataset;
        final Number x = boxAndWhiskerXYDataset.getX(n, n2);
        final Number maxRegularValue = boxAndWhiskerXYDataset.getMaxRegularValue(n, n2);
        final Number minRegularValue = boxAndWhiskerXYDataset.getMinRegularValue(n, n2);
        final Number medianValue = boxAndWhiskerXYDataset.getMedianValue(n, n2);
        final Number meanValue = boxAndWhiskerXYDataset.getMeanValue(n, n2);
        final Number q1Value = boxAndWhiskerXYDataset.getQ1Value(n, n2);
        final Number q3Value = boxAndWhiskerXYDataset.getQ3Value(n, n2);
        final double valueToJava2D = valueAxis.valueToJava2D(x.doubleValue(), rectangle2D, xyPlot.getDomainAxisEdge());
        final RectangleEdge rangeAxisEdge = xyPlot.getRangeAxisEdge();
        final double valueToJava2D2 = valueAxis2.valueToJava2D(maxRegularValue.doubleValue(), rectangle2D, rangeAxisEdge);
        final double valueToJava2D3 = valueAxis2.valueToJava2D(minRegularValue.doubleValue(), rectangle2D, rangeAxisEdge);
        final double valueToJava2D4 = valueAxis2.valueToJava2D(medianValue.doubleValue(), rectangle2D, rangeAxisEdge);
        double valueToJava2D5 = 0.0;
        if (meanValue != null) {
            valueToJava2D5 = valueAxis2.valueToJava2D(meanValue.doubleValue(), rectangle2D, rangeAxisEdge);
        }
        final double valueToJava2D6 = valueAxis2.valueToJava2D(q1Value.doubleValue(), rectangle2D, rangeAxisEdge);
        final double valueToJava2D7 = valueAxis2.valueToJava2D(q3Value.doubleValue(), rectangle2D, rangeAxisEdge);
        double boxWidth;
        final double n4 = boxWidth = this.getBoxWidth();
        final double height = rectangle2D.getHeight();
        final double n5 = height * 0.1;
        if (n4 <= 0.0) {
            final double n6 = height / boxAndWhiskerXYDataset.getItemCount(n) * 4.5 / 7.0;
            if (n6 < 3.0) {
                boxWidth = 3.0;
            }
            else if (n6 > n5) {
                boxWidth = n5;
            }
            else {
                boxWidth = n6;
            }
        }
        final Paint boxPaint = this.getBoxPaint();
        if (boxPaint != null) {
            graphics2D.setPaint(boxPaint);
        }
        graphics2D.setStroke(this.getItemStroke(n, n2));
        graphics2D.draw(new Line2D.Double(valueToJava2D2, valueToJava2D, valueToJava2D7, valueToJava2D));
        graphics2D.draw(new Line2D.Double(valueToJava2D2, valueToJava2D - boxWidth / 2.0, valueToJava2D2, valueToJava2D + boxWidth / 2.0));
        graphics2D.draw(new Line2D.Double(valueToJava2D3, valueToJava2D, valueToJava2D6, valueToJava2D));
        graphics2D.draw(new Line2D.Double(valueToJava2D3, valueToJava2D - boxWidth / 2.0, valueToJava2D3, valueToJava2D + boxWidth / 2.0));
        Rectangle2D.Double double1;
        if (valueToJava2D6 < valueToJava2D7) {
            double1 = new Rectangle2D.Double(valueToJava2D6, valueToJava2D - boxWidth / 2.0, valueToJava2D7 - valueToJava2D6, boxWidth);
        }
        else {
            double1 = new Rectangle2D.Double(valueToJava2D7, valueToJava2D - boxWidth / 2.0, valueToJava2D6 - valueToJava2D7, boxWidth);
        }
        if (this.getBoxPaint() != null) {
            graphics2D.setPaint(this.getBoxPaint());
        }
        if (this.fillBox) {
            graphics2D.fill(double1);
        }
        graphics2D.draw(double1);
        graphics2D.setPaint(this.getArtifactPaint());
        graphics2D.draw(new Line2D.Double(valueToJava2D4, valueToJava2D - boxWidth / 2.0, valueToJava2D4, valueToJava2D + boxWidth / 2.0));
        if (meanValue != null) {
            final double n7 = boxWidth / 4.0;
            final Ellipse2D.Double double2 = new Ellipse2D.Double(valueToJava2D5 - n7, valueToJava2D - n7, n7 * 2.0, n7 * 2.0);
            graphics2D.fill(double2);
            graphics2D.draw(double2);
        }
        if (entityCollection != null) {
            String generateToolTip = null;
            final XYToolTipGenerator toolTipGenerator = this.getToolTipGenerator(n, n2);
            if (toolTipGenerator != null) {
                generateToolTip = toolTipGenerator.generateToolTip(xyDataset, n, n2);
            }
            String generateURL = null;
            if (this.getURLGenerator() != null) {
                generateURL = this.getURLGenerator().generateURL(xyDataset, n, n2);
            }
            entityCollection.add(new XYItemEntity(double1, xyDataset, n, n2, generateToolTip, generateURL));
        }
    }
    
    public void drawVerticalItem(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo, final XYPlot xyPlot, final ValueAxis valueAxis, final ValueAxis valueAxis2, final XYDataset xyDataset, final int n, final int n2, final CrosshairState crosshairState, final int n3) {
        EntityCollection entityCollection = null;
        if (plotRenderingInfo != null) {
            entityCollection = plotRenderingInfo.getOwner().getEntityCollection();
        }
        final BoxAndWhiskerXYDataset boxAndWhiskerXYDataset = (BoxAndWhiskerXYDataset)xyDataset;
        final Number x = boxAndWhiskerXYDataset.getX(n, n2);
        final Number maxRegularValue = boxAndWhiskerXYDataset.getMaxRegularValue(n, n2);
        final Number minRegularValue = boxAndWhiskerXYDataset.getMinRegularValue(n, n2);
        final Number medianValue = boxAndWhiskerXYDataset.getMedianValue(n, n2);
        final Number meanValue = boxAndWhiskerXYDataset.getMeanValue(n, n2);
        final Number q1Value = boxAndWhiskerXYDataset.getQ1Value(n, n2);
        final Number q3Value = boxAndWhiskerXYDataset.getQ3Value(n, n2);
        final List outliers = boxAndWhiskerXYDataset.getOutliers(n, n2);
        final double valueToJava2D = valueAxis.valueToJava2D(x.doubleValue(), rectangle2D, xyPlot.getDomainAxisEdge());
        final RectangleEdge rangeAxisEdge = xyPlot.getRangeAxisEdge();
        final double valueToJava2D2 = valueAxis2.valueToJava2D(maxRegularValue.doubleValue(), rectangle2D, rangeAxisEdge);
        final double valueToJava2D3 = valueAxis2.valueToJava2D(minRegularValue.doubleValue(), rectangle2D, rangeAxisEdge);
        final double valueToJava2D4 = valueAxis2.valueToJava2D(medianValue.doubleValue(), rectangle2D, rangeAxisEdge);
        double valueToJava2D5 = 0.0;
        if (meanValue != null) {
            valueToJava2D5 = valueAxis2.valueToJava2D(meanValue.doubleValue(), rectangle2D, rangeAxisEdge);
        }
        final double valueToJava2D6 = valueAxis2.valueToJava2D(q1Value.doubleValue(), rectangle2D, rangeAxisEdge);
        final double valueToJava2D7 = valueAxis2.valueToJava2D(q3Value.doubleValue(), rectangle2D, rangeAxisEdge);
        double boxWidth;
        final double n4 = boxWidth = this.getBoxWidth();
        final double n5 = rectangle2D.getMaxX() - rectangle2D.getMinX();
        final double n6 = n5 * 0.1;
        if (n4 <= 0.0) {
            final double n7 = n5 / boxAndWhiskerXYDataset.getItemCount(n) * 4.5 / 7.0;
            if (n7 < 3.0) {
                boxWidth = 3.0;
            }
            else if (n7 > n6) {
                boxWidth = n6;
            }
            else {
                boxWidth = n7;
            }
        }
        final Paint boxPaint = this.getBoxPaint();
        if (boxPaint != null) {
            graphics2D.setPaint(boxPaint);
        }
        graphics2D.setStroke(this.getItemStroke(n, n2));
        graphics2D.draw(new Line2D.Double(valueToJava2D, valueToJava2D2, valueToJava2D, valueToJava2D7));
        graphics2D.draw(new Line2D.Double(valueToJava2D - boxWidth / 2.0, valueToJava2D2, valueToJava2D + boxWidth / 2.0, valueToJava2D2));
        graphics2D.draw(new Line2D.Double(valueToJava2D, valueToJava2D3, valueToJava2D, valueToJava2D6));
        graphics2D.draw(new Line2D.Double(valueToJava2D - boxWidth / 2.0, valueToJava2D3, valueToJava2D + boxWidth / 2.0, valueToJava2D3));
        Rectangle2D.Double double1;
        if (valueToJava2D6 > valueToJava2D7) {
            double1 = new Rectangle2D.Double(valueToJava2D - boxWidth / 2.0, valueToJava2D7, boxWidth, valueToJava2D6 - valueToJava2D7);
        }
        else {
            double1 = new Rectangle2D.Double(valueToJava2D - boxWidth / 2.0, valueToJava2D6, boxWidth, valueToJava2D7 - valueToJava2D6);
        }
        if (this.fillBox) {
            graphics2D.fill(double1);
        }
        graphics2D.draw(double1);
        graphics2D.setPaint(this.getArtifactPaint());
        graphics2D.draw(new Line2D.Double(valueToJava2D - boxWidth / 2.0, valueToJava2D4, valueToJava2D + boxWidth / 2.0, valueToJava2D4));
        double n8 = 0.0;
        final double n9 = boxWidth / 3.0;
        if (meanValue != null) {
            n8 = boxWidth / 4.0;
            final Ellipse2D.Double double2 = new Ellipse2D.Double(valueToJava2D - n8, valueToJava2D5 - n8, n8 * 2.0, n8 * 2.0);
            graphics2D.fill(double2);
            graphics2D.draw(double2);
        }
        final ArrayList<Comparable> list = new ArrayList<Comparable>();
        final OutlierListCollection collection = new OutlierListCollection();
        for (int i = 0; i < outliers.size(); ++i) {
            final double doubleValue = outliers.get(i).doubleValue();
            if (doubleValue > boxAndWhiskerXYDataset.getMaxOutlier(n, n2).doubleValue()) {
                collection.setHighFarOut(true);
            }
            else if (doubleValue < boxAndWhiskerXYDataset.getMinOutlier(n, n2).doubleValue()) {
                collection.setLowFarOut(true);
            }
            else if (doubleValue > boxAndWhiskerXYDataset.getMaxRegularValue(n, n2).doubleValue()) {
                list.add(new Outlier(valueToJava2D, valueAxis2.valueToJava2D(doubleValue, rectangle2D, rangeAxisEdge), n9));
            }
            else if (doubleValue < boxAndWhiskerXYDataset.getMinRegularValue(n, n2).doubleValue()) {
                list.add(new Outlier(valueToJava2D, valueAxis2.valueToJava2D(doubleValue, rectangle2D, rangeAxisEdge), n9));
            }
            Collections.sort(list);
        }
        final Iterator<Outlier> iterator = list.iterator();
        while (iterator.hasNext()) {
            collection.add(iterator.next());
        }
        final double n10 = valueAxis2.valueToJava2D(valueAxis2.getUpperBound(), rectangle2D, rangeAxisEdge) + n8;
        final double n11 = valueAxis2.valueToJava2D(valueAxis2.getLowerBound(), rectangle2D, rangeAxisEdge) - n8;
        for (final OutlierList list2 : collection) {
            final Point2D point = list2.getAveragedOutlier().getPoint();
            if (list2.isMultiple()) {
                this.drawMultipleEllipse(point, boxWidth, n9, graphics2D);
            }
            else {
                this.drawEllipse(point, n9, graphics2D);
            }
        }
        if (collection.isHighFarOut()) {
            this.drawHighFarOut(n8, graphics2D, valueToJava2D, n10);
        }
        if (collection.isLowFarOut()) {
            this.drawLowFarOut(n8, graphics2D, valueToJava2D, n11);
        }
        if (entityCollection != null) {
            String generateToolTip = null;
            final XYToolTipGenerator toolTipGenerator = this.getToolTipGenerator(n, n2);
            if (toolTipGenerator != null) {
                generateToolTip = toolTipGenerator.generateToolTip(xyDataset, n, n2);
            }
            String generateURL = null;
            if (this.getURLGenerator() != null) {
                generateURL = this.getURLGenerator().generateURL(xyDataset, n, n2);
            }
            entityCollection.add(new XYItemEntity(double1, xyDataset, n, n2, generateToolTip, generateURL));
        }
    }
    
    protected void drawEllipse(final Point2D point2D, final double n, final Graphics2D graphics2D) {
        graphics2D.draw(new Ellipse2D.Double(point2D.getX() + n / 2.0, point2D.getY(), n, n));
    }
    
    protected void drawMultipleEllipse(final Point2D point2D, final double n, final double n2, final Graphics2D graphics2D) {
        final Ellipse2D.Double double1 = new Ellipse2D.Double(point2D.getX() - n / 2.0 + n2, point2D.getY(), n2, n2);
        final Ellipse2D.Double double2 = new Ellipse2D.Double(point2D.getX() + n / 2.0, point2D.getY(), n2, n2);
        graphics2D.draw(double1);
        graphics2D.draw(double2);
    }
    
    protected void drawHighFarOut(final double n, final Graphics2D graphics2D, final double n2, final double n3) {
        final double n4 = n * 2.0;
        graphics2D.draw(new Line2D.Double(n2 - n4, n3 + n4, n2 + n4, n3 + n4));
        graphics2D.draw(new Line2D.Double(n2 - n4, n3 + n4, n2, n3));
        graphics2D.draw(new Line2D.Double(n2 + n4, n3 + n4, n2, n3));
    }
    
    protected void drawLowFarOut(final double n, final Graphics2D graphics2D, final double n2, final double n3) {
        final double n4 = n * 2.0;
        graphics2D.draw(new Line2D.Double(n2 - n4, n3 - n4, n2 + n4, n3 - n4));
        graphics2D.draw(new Line2D.Double(n2 - n4, n3 - n4, n2, n3));
        graphics2D.draw(new Line2D.Double(n2 + n4, n3 - n4, n2, n3));
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof XYBoxAndWhiskerRenderer)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final XYBoxAndWhiskerRenderer xyBoxAndWhiskerRenderer = (XYBoxAndWhiskerRenderer)o;
        return this.boxWidth == xyBoxAndWhiskerRenderer.getBoxWidth() && PaintUtilities.equal(this.boxPaint, xyBoxAndWhiskerRenderer.boxPaint) && PaintUtilities.equal(this.artifactPaint, xyBoxAndWhiskerRenderer.artifactPaint) && this.fillBox == xyBoxAndWhiskerRenderer.fillBox;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.boxPaint, objectOutputStream);
        SerialUtilities.writePaint(this.artifactPaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.boxPaint = SerialUtilities.readPaint(objectInputStream);
        this.artifactPaint = SerialUtilities.readPaint(objectInputStream);
    }
    
    public Object clone() {
        return super.clone();
    }
}
