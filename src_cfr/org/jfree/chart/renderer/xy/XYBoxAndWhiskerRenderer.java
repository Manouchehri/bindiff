/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.xy;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.BoxAndWhiskerXYToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.Outlier;
import org.jfree.chart.renderer.OutlierList;
import org.jfree.chart.renderer.OutlierListCollection;
import org.jfree.chart.renderer.xy.AbstractXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.statistics.BoxAndWhiskerXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;

public class XYBoxAndWhiskerRenderer
extends AbstractXYItemRenderer
implements Serializable,
Cloneable,
XYItemRenderer,
PublicCloneable {
    private static final long serialVersionUID = -8020170108532232324L;
    private double boxWidth;
    private transient Paint boxPaint;
    private boolean fillBox;
    private transient Paint artifactPaint = Color.black;

    public XYBoxAndWhiskerRenderer() {
        this(-1.0);
    }

    public XYBoxAndWhiskerRenderer(double d2) {
        this.boxWidth = d2;
        this.boxPaint = Color.green;
        this.fillBox = true;
        this.setToolTipGenerator(new BoxAndWhiskerXYToolTipGenerator());
    }

    public double getBoxWidth() {
        return this.boxWidth;
    }

    public void setBoxWidth(double d2) {
        if (d2 == this.boxWidth) return;
        this.boxWidth = d2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public Paint getBoxPaint() {
        return this.boxPaint;
    }

    public void setBoxPaint(Paint paint) {
        this.boxPaint = paint;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public boolean getFillBox() {
        return this.fillBox;
    }

    public void setFillBox(boolean bl2) {
        this.fillBox = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public Paint getArtifactPaint() {
        return this.artifactPaint;
    }

    public void setArtifactPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'artifactPaint' argument.");
        }
        this.artifactPaint = paint;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public void drawItem(Graphics2D graphics2D, XYItemRendererState xYItemRendererState, Rectangle2D rectangle2D, PlotRenderingInfo plotRenderingInfo, XYPlot xYPlot, ValueAxis valueAxis, ValueAxis valueAxis2, XYDataset xYDataset, int n2, int n3, CrosshairState crosshairState, int n4) {
        PlotOrientation plotOrientation = xYPlot.getOrientation();
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            this.drawHorizontalItem(graphics2D, rectangle2D, plotRenderingInfo, xYPlot, valueAxis, valueAxis2, xYDataset, n2, n3, crosshairState, n4);
            return;
        }
        if (plotOrientation != PlotOrientation.VERTICAL) return;
        this.drawVerticalItem(graphics2D, rectangle2D, plotRenderingInfo, xYPlot, valueAxis, valueAxis2, xYDataset, n2, n3, crosshairState, n4);
    }

    public void drawHorizontalItem(Graphics2D graphics2D, Rectangle2D rectangle2D, PlotRenderingInfo plotRenderingInfo, XYPlot xYPlot, ValueAxis valueAxis, ValueAxis valueAxis2, XYDataset xYDataset, int n2, int n3, CrosshairState crosshairState, int n4) {
        Object object;
        Paint paint;
        double d2;
        EntityCollection entityCollection = null;
        if (plotRenderingInfo != null) {
            entityCollection = plotRenderingInfo.getOwner().getEntityCollection();
        }
        BoxAndWhiskerXYDataset boxAndWhiskerXYDataset = (BoxAndWhiskerXYDataset)xYDataset;
        Number number = boxAndWhiskerXYDataset.getX(n2, n3);
        Number number2 = boxAndWhiskerXYDataset.getMaxRegularValue(n2, n3);
        Number number3 = boxAndWhiskerXYDataset.getMinRegularValue(n2, n3);
        Number number4 = boxAndWhiskerXYDataset.getMedianValue(n2, n3);
        Number number5 = boxAndWhiskerXYDataset.getMeanValue(n2, n3);
        Number number6 = boxAndWhiskerXYDataset.getQ1Value(n2, n3);
        Number number7 = boxAndWhiskerXYDataset.getQ3Value(n2, n3);
        double d3 = valueAxis.valueToJava2D(number.doubleValue(), rectangle2D, xYPlot.getDomainAxisEdge());
        RectangleEdge rectangleEdge = xYPlot.getRangeAxisEdge();
        double d4 = valueAxis2.valueToJava2D(number2.doubleValue(), rectangle2D, rectangleEdge);
        double d5 = valueAxis2.valueToJava2D(number3.doubleValue(), rectangle2D, rectangleEdge);
        double d6 = valueAxis2.valueToJava2D(number4.doubleValue(), rectangle2D, rectangleEdge);
        double d7 = 0.0;
        if (number5 != null) {
            d7 = valueAxis2.valueToJava2D(number5.doubleValue(), rectangle2D, rectangleEdge);
        }
        double d8 = valueAxis2.valueToJava2D(number6.doubleValue(), rectangle2D, rectangleEdge);
        double d9 = valueAxis2.valueToJava2D(number7.doubleValue(), rectangle2D, rectangleEdge);
        double d10 = d2 = this.getBoxWidth();
        double d11 = rectangle2D.getHeight();
        double d12 = 0.1;
        double d13 = d11 * d12;
        if (d2 <= 0.0) {
            int n5 = boxAndWhiskerXYDataset.getItemCount(n2);
            d2 = d11 / (double)n5 * 4.5 / 7.0;
            d10 = d2 < 3.0 ? 3.0 : (d2 > d13 ? d13 : d2);
        }
        if ((paint = this.getBoxPaint()) != null) {
            graphics2D.setPaint(paint);
        }
        Stroke stroke = this.getItemStroke(n2, n3);
        graphics2D.setStroke(stroke);
        graphics2D.draw(new Line2D.Double(d4, d3, d9, d3));
        graphics2D.draw(new Line2D.Double(d4, d3 - d10 / 2.0, d4, d3 + d10 / 2.0));
        graphics2D.draw(new Line2D.Double(d5, d3, d8, d3));
        graphics2D.draw(new Line2D.Double(d5, d3 - d10 / 2.0, d5, d3 + d10 / 2.0));
        Rectangle2D.Double double_ = null;
        double_ = d8 < d9 ? new Rectangle2D.Double(d8, d3 - d10 / 2.0, d9 - d8, d10) : new Rectangle2D.Double(d9, d3 - d10 / 2.0, d8 - d9, d10);
        if (this.getBoxPaint() != null) {
            graphics2D.setPaint(this.getBoxPaint());
        }
        if (this.fillBox) {
            graphics2D.fill(double_);
        }
        graphics2D.draw(double_);
        graphics2D.setPaint(this.getArtifactPaint());
        graphics2D.draw(new Line2D.Double(d6, d3 - d10 / 2.0, d6, d3 + d10 / 2.0));
        if (number5 != null) {
            double d14 = d10 / 4.0;
            object = new Ellipse2D.Double(d7 - d14, d3 - d14, d14 * 2.0, d14 * 2.0);
            graphics2D.fill((Shape)object);
            graphics2D.draw((Shape)object);
        }
        if (entityCollection == null) return;
        String string = null;
        XYToolTipGenerator xYToolTipGenerator = this.getToolTipGenerator(n2, n3);
        if (xYToolTipGenerator != null) {
            string = xYToolTipGenerator.generateToolTip(xYDataset, n2, n3);
        }
        object = null;
        if (this.getURLGenerator() != null) {
            object = this.getURLGenerator().generateURL(xYDataset, n2, n3);
        }
        XYItemEntity xYItemEntity = new XYItemEntity(double_, xYDataset, n2, n3, string, (String)object);
        entityCollection.add(xYItemEntity);
    }

    public void drawVerticalItem(Graphics2D graphics2D, Rectangle2D rectangle2D, PlotRenderingInfo plotRenderingInfo, XYPlot xYPlot, ValueAxis valueAxis, ValueAxis valueAxis2, XYDataset xYDataset, int n2, int n3, CrosshairState crosshairState, int n4) {
        Object object2;
        Paint paint;
        Object object;
        double d2;
        List list;
        EntityCollection entityCollection = null;
        if (plotRenderingInfo != null) {
            entityCollection = plotRenderingInfo.getOwner().getEntityCollection();
        }
        BoxAndWhiskerXYDataset boxAndWhiskerXYDataset = (BoxAndWhiskerXYDataset)xYDataset;
        Number number = boxAndWhiskerXYDataset.getX(n2, n3);
        Number number2 = boxAndWhiskerXYDataset.getMaxRegularValue(n2, n3);
        Number number3 = boxAndWhiskerXYDataset.getMinRegularValue(n2, n3);
        Number number4 = boxAndWhiskerXYDataset.getMedianValue(n2, n3);
        Number number5 = boxAndWhiskerXYDataset.getMeanValue(n2, n3);
        Number number6 = boxAndWhiskerXYDataset.getQ1Value(n2, n3);
        Number number7 = boxAndWhiskerXYDataset.getQ3Value(n2, n3);
        List list2 = boxAndWhiskerXYDataset.getOutliers(n2, n3);
        double d3 = valueAxis.valueToJava2D(number.doubleValue(), rectangle2D, xYPlot.getDomainAxisEdge());
        RectangleEdge rectangleEdge = xYPlot.getRangeAxisEdge();
        double d4 = valueAxis2.valueToJava2D(number2.doubleValue(), rectangle2D, rectangleEdge);
        double d5 = valueAxis2.valueToJava2D(number3.doubleValue(), rectangle2D, rectangleEdge);
        double d6 = valueAxis2.valueToJava2D(number4.doubleValue(), rectangle2D, rectangleEdge);
        double d7 = 0.0;
        if (number5 != null) {
            d7 = valueAxis2.valueToJava2D(number5.doubleValue(), rectangle2D, rectangleEdge);
        }
        double d8 = valueAxis2.valueToJava2D(number6.doubleValue(), rectangle2D, rectangleEdge);
        double d9 = valueAxis2.valueToJava2D(number7.doubleValue(), rectangle2D, rectangleEdge);
        double d10 = d2 = this.getBoxWidth();
        double d11 = rectangle2D.getMaxX() - rectangle2D.getMinX();
        double d12 = 0.1;
        double d13 = d11 * d12;
        if (d2 <= 0.0) {
            int n5 = boxAndWhiskerXYDataset.getItemCount(n2);
            d2 = d11 / (double)n5 * 4.5 / 7.0;
            d10 = d2 < 3.0 ? 3.0 : (d2 > d13 ? d13 : d2);
        }
        if ((paint = this.getBoxPaint()) != null) {
            graphics2D.setPaint(paint);
        }
        Stroke stroke = this.getItemStroke(n2, n3);
        graphics2D.setStroke(stroke);
        graphics2D.draw(new Line2D.Double(d3, d4, d3, d9));
        graphics2D.draw(new Line2D.Double(d3 - d10 / 2.0, d4, d3 + d10 / 2.0, d4));
        graphics2D.draw(new Line2D.Double(d3, d5, d3, d8));
        graphics2D.draw(new Line2D.Double(d3 - d10 / 2.0, d5, d3 + d10 / 2.0, d5));
        Rectangle2D.Double double_ = null;
        double_ = d8 > d9 ? new Rectangle2D.Double(d3 - d10 / 2.0, d9, d10, d8 - d9) : new Rectangle2D.Double(d3 - d10 / 2.0, d8, d10, d9 - d8);
        if (this.fillBox) {
            graphics2D.fill(double_);
        }
        graphics2D.draw(double_);
        graphics2D.setPaint(this.getArtifactPaint());
        graphics2D.draw(new Line2D.Double(d3 - d10 / 2.0, d6, d3 + d10 / 2.0, d6));
        double d14 = 0.0;
        double d15 = d10 / 3.0;
        if (number5 != null) {
            d14 = d10 / 4.0;
            list = new Ellipse2D.Double(d3 - d14, d7 - d14, d14 * 2.0, d14 * 2.0);
            graphics2D.fill((Shape)((Object)list));
            graphics2D.draw((Shape)((Object)list));
        }
        list = new ArrayList();
        OutlierListCollection outlierListCollection = new OutlierListCollection();
        for (int i2 = 0; i2 < list2.size(); ++i2) {
            double d16;
            double d17 = ((Number)list2.get(i2)).doubleValue();
            if (d17 > boxAndWhiskerXYDataset.getMaxOutlier(n2, n3).doubleValue()) {
                outlierListCollection.setHighFarOut(true);
            } else if (d17 < boxAndWhiskerXYDataset.getMinOutlier(n2, n3).doubleValue()) {
                outlierListCollection.setLowFarOut(true);
            } else if (d17 > boxAndWhiskerXYDataset.getMaxRegularValue(n2, n3).doubleValue()) {
                d16 = valueAxis2.valueToJava2D(d17, rectangle2D, rectangleEdge);
                list.add(new Outlier(d3, d16, d15));
            } else if (d17 < boxAndWhiskerXYDataset.getMinRegularValue(n2, n3).doubleValue()) {
                d16 = valueAxis2.valueToJava2D(d17, rectangle2D, rectangleEdge);
                list.add(new Outlier(d3, d16, d15));
            }
            Collections.sort(list);
        }
        for (Outlier outlier : list) {
            outlierListCollection.add(outlier);
        }
        double d18 = valueAxis2.valueToJava2D(valueAxis2.getUpperBound(), rectangle2D, rectangleEdge) + d14;
        double d19 = valueAxis2.valueToJava2D(valueAxis2.getLowerBound(), rectangle2D, rectangleEdge) - d14;
        Object object3 = outlierListCollection.iterator();
        while (object3.hasNext()) {
            object = (OutlierList)object3.next();
            object2 = object.getAveragedOutlier();
            Point2D point2D = object2.getPoint();
            if (object.isMultiple()) {
                this.drawMultipleEllipse(point2D, d10, d15, graphics2D);
                continue;
            }
            this.drawEllipse(point2D, d15, graphics2D);
        }
        if (outlierListCollection.isHighFarOut()) {
            this.drawHighFarOut(d14, graphics2D, d3, d18);
        }
        if (outlierListCollection.isLowFarOut()) {
            this.drawLowFarOut(d14, graphics2D, d3, d19);
        }
        if (entityCollection == null) return;
        object3 = null;
        object = this.getToolTipGenerator(n2, n3);
        if (object != null) {
            object3 = object.generateToolTip(xYDataset, n2, n3);
        }
        object2 = null;
        if (this.getURLGenerator() != null) {
            object2 = this.getURLGenerator().generateURL(xYDataset, n2, n3);
        }
        XYItemEntity xYItemEntity = new XYItemEntity(double_, xYDataset, n2, n3, (String)object3, (String)object2);
        entityCollection.add(xYItemEntity);
    }

    protected void drawEllipse(Point2D point2D, double d2, Graphics2D graphics2D) {
        Ellipse2D.Double double_ = new Ellipse2D.Double(point2D.getX() + d2 / 2.0, point2D.getY(), d2, d2);
        graphics2D.draw(double_);
    }

    protected void drawMultipleEllipse(Point2D point2D, double d2, double d3, Graphics2D graphics2D) {
        Ellipse2D.Double double_ = new Ellipse2D.Double(point2D.getX() - d2 / 2.0 + d3, point2D.getY(), d3, d3);
        Ellipse2D.Double double_2 = new Ellipse2D.Double(point2D.getX() + d2 / 2.0, point2D.getY(), d3, d3);
        graphics2D.draw(double_);
        graphics2D.draw(double_2);
    }

    protected void drawHighFarOut(double d2, Graphics2D graphics2D, double d3, double d4) {
        double d5 = d2 * 2.0;
        graphics2D.draw(new Line2D.Double(d3 - d5, d4 + d5, d3 + d5, d4 + d5));
        graphics2D.draw(new Line2D.Double(d3 - d5, d4 + d5, d3, d4));
        graphics2D.draw(new Line2D.Double(d3 + d5, d4 + d5, d3, d4));
    }

    protected void drawLowFarOut(double d2, Graphics2D graphics2D, double d3, double d4) {
        double d5 = d2 * 2.0;
        graphics2D.draw(new Line2D.Double(d3 - d5, d4 - d5, d3 + d5, d4 - d5));
        graphics2D.draw(new Line2D.Double(d3 - d5, d4 - d5, d3, d4));
        graphics2D.draw(new Line2D.Double(d3 + d5, d4 - d5, d3, d4));
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof XYBoxAndWhiskerRenderer)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        XYBoxAndWhiskerRenderer xYBoxAndWhiskerRenderer = (XYBoxAndWhiskerRenderer)object;
        if (this.boxWidth != xYBoxAndWhiskerRenderer.getBoxWidth()) {
            return false;
        }
        if (!PaintUtilities.equal(this.boxPaint, xYBoxAndWhiskerRenderer.boxPaint)) {
            return false;
        }
        if (!PaintUtilities.equal(this.artifactPaint, xYBoxAndWhiskerRenderer.artifactPaint)) {
            return false;
        }
        if (this.fillBox == xYBoxAndWhiskerRenderer.fillBox) return true;
        return false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.boxPaint, objectOutputStream);
        SerialUtilities.writePaint(this.artifactPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.boxPaint = SerialUtilities.readPaint(objectInputStream);
        this.artifactPaint = SerialUtilities.readPaint(objectInputStream);
    }

    @Override
    public Object clone() {
        return super.clone();
    }
}

