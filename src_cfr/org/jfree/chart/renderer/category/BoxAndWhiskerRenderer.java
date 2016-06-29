/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.category;

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
import org.jfree.chart.LegendItem;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.CategorySeriesLabelGenerator;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.Outlier;
import org.jfree.chart.renderer.OutlierList;
import org.jfree.chart.renderer.OutlierListCollection;
import org.jfree.chart.renderer.category.AbstractCategoryItemRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.chart.urls.CategoryURLGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;

public class BoxAndWhiskerRenderer
extends AbstractCategoryItemRenderer
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = 632027470694481177L;
    private transient Paint artifactPaint = Color.black;
    private boolean fillBox = true;
    private double itemMargin = 0.2;

    public Paint getArtifactPaint() {
        return this.artifactPaint;
    }

    public void setArtifactPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.artifactPaint = paint;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public boolean getFillBox() {
        return this.fillBox;
    }

    public void setFillBox(boolean bl2) {
        this.fillBox = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public double getItemMargin() {
        return this.itemMargin;
    }

    public void setItemMargin(double d2) {
        this.itemMargin = d2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public LegendItem getLegendItem(int n2, int n3) {
        String string;
        CategoryPlot categoryPlot = this.getPlot();
        if (categoryPlot == null) {
            return null;
        }
        CategoryDataset categoryDataset = categoryPlot.getDataset(n2);
        String string2 = string = this.getLegendItemLabelGenerator().generateLabel(categoryDataset, n3);
        String string3 = null;
        if (this.getLegendItemToolTipGenerator() != null) {
            string3 = this.getLegendItemToolTipGenerator().generateLabel(categoryDataset, n3);
        }
        String string4 = null;
        if (this.getLegendItemURLGenerator() != null) {
            string4 = this.getLegendItemURLGenerator().generateLabel(categoryDataset, n3);
        }
        Rectangle2D.Double double_ = new Rectangle2D.Double(-4.0, -4.0, 8.0, 8.0);
        Paint paint = this.getSeriesPaint(n3);
        Paint paint2 = this.getSeriesOutlinePaint(n3);
        Stroke stroke = this.getSeriesOutlineStroke(n3);
        return new LegendItem(string, string2, string3, string4, (Shape)double_, paint, stroke, paint2);
    }

    @Override
    public CategoryItemRendererState initialise(Graphics2D graphics2D, Rectangle2D rectangle2D, CategoryPlot categoryPlot, int n2, PlotRenderingInfo plotRenderingInfo) {
        CategoryItemRendererState categoryItemRendererState = super.initialise(graphics2D, rectangle2D, categoryPlot, n2, plotRenderingInfo);
        CategoryAxis categoryAxis = this.getDomainAxis(categoryPlot, n2);
        CategoryDataset categoryDataset = categoryPlot.getDataset(n2);
        if (categoryDataset == null) return categoryItemRendererState;
        int n3 = categoryDataset.getColumnCount();
        int n4 = categoryDataset.getRowCount();
        double d2 = 0.0;
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            d2 = rectangle2D.getHeight();
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            d2 = rectangle2D.getWidth();
        }
        double d3 = 0.0;
        double d4 = 0.0;
        if (n3 > 1) {
            d3 = categoryAxis.getCategoryMargin();
        }
        if (n4 > 1) {
            d4 = this.getItemMargin();
        }
        double d5 = d2 * (1.0 - categoryAxis.getLowerMargin() - categoryAxis.getUpperMargin() - d3 - d4);
        if (n4 * n3 > 0) {
            categoryItemRendererState.setBarWidth(d5 / (double)(categoryDataset.getColumnCount() * categoryDataset.getRowCount()));
            return categoryItemRendererState;
        }
        categoryItemRendererState.setBarWidth(d5);
        return categoryItemRendererState;
    }

    @Override
    public void drawItem(Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, CategoryDataset categoryDataset, int n2, int n3, int n4) {
        if (!(categoryDataset instanceof BoxAndWhiskerCategoryDataset)) {
            throw new IllegalArgumentException("BoxAndWhiskerRenderer.drawItem() : the data should be of type BoxAndWhiskerCategoryDataset only.");
        }
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            this.drawHorizontalItem(graphics2D, categoryItemRendererState, rectangle2D, categoryPlot, categoryAxis, valueAxis, categoryDataset, n2, n3);
            return;
        }
        if (plotOrientation != PlotOrientation.VERTICAL) return;
        this.drawVerticalItem(graphics2D, categoryItemRendererState, rectangle2D, categoryPlot, categoryAxis, valueAxis, categoryDataset, n2, n3);
    }

    public void drawHorizontalItem(Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, CategoryDataset categoryDataset, int n2, int n3) {
        double d2;
        double d3;
        Object object;
        Number number;
        double d4;
        BoxAndWhiskerCategoryDataset boxAndWhiskerCategoryDataset = (BoxAndWhiskerCategoryDataset)categoryDataset;
        double d5 = categoryAxis.getCategoryEnd(n3, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
        double d6 = categoryAxis.getCategoryStart(n3, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
        double d7 = Math.abs(d5 - d6);
        double d8 = d6;
        int n4 = this.getRowCount();
        int n5 = this.getColumnCount();
        if (n4 > 1) {
            d2 = rectangle2D.getWidth() * this.getItemMargin() / (double)(n5 * (n4 - 1));
            double d9 = categoryItemRendererState.getBarWidth() * (double)n4 + d2 * (double)(n4 - 1);
            double d10 = (d7 - d9) / 2.0;
            d8 = d8 + d10 + (double)n2 * (categoryItemRendererState.getBarWidth() + d2);
        } else {
            d2 = (d7 - categoryItemRendererState.getBarWidth()) / 2.0;
            d8 += d2;
        }
        Paint paint = this.getItemPaint(n2, n3);
        if (paint != null) {
            graphics2D.setPaint(paint);
        }
        Stroke stroke = this.getItemStroke(n2, n3);
        graphics2D.setStroke(stroke);
        RectangleEdge rectangleEdge = categoryPlot.getRangeAxisEdge();
        Number number2 = boxAndWhiskerCategoryDataset.getQ1Value(n2, n3);
        Number number3 = boxAndWhiskerCategoryDataset.getQ3Value(n2, n3);
        Number number4 = boxAndWhiskerCategoryDataset.getMaxRegularValue(n2, n3);
        Number number5 = boxAndWhiskerCategoryDataset.getMinRegularValue(n2, n3);
        Rectangle2D.Double double_ = null;
        if (number2 != null && number3 != null && number4 != null && number5 != null) {
            d4 = valueAxis.valueToJava2D(number2.doubleValue(), rectangle2D, rectangleEdge);
            double d11 = valueAxis.valueToJava2D(number3.doubleValue(), rectangle2D, rectangleEdge);
            d3 = valueAxis.valueToJava2D(number4.doubleValue(), rectangle2D, rectangleEdge);
            double d12 = valueAxis.valueToJava2D(number5.doubleValue(), rectangle2D, rectangleEdge);
            double d13 = d8 + categoryItemRendererState.getBarWidth() / 2.0;
            graphics2D.draw(new Line2D.Double(d3, d13, d11, d13));
            graphics2D.draw(new Line2D.Double(d3, d8, d3, d8 + categoryItemRendererState.getBarWidth()));
            graphics2D.draw(new Line2D.Double(d12, d13, d4, d13));
            graphics2D.draw(new Line2D.Double(d12, d8, d12, d8 + categoryItemRendererState.getBarWidth()));
            double_ = new Rectangle2D.Double(Math.min(d4, d11), d8, Math.abs(d4 - d11), categoryItemRendererState.getBarWidth());
            if (this.fillBox) {
                graphics2D.fill(double_);
            }
            graphics2D.draw(double_);
        }
        graphics2D.setPaint(this.artifactPaint);
        d4 = 0.0;
        Number number6 = boxAndWhiskerCategoryDataset.getMeanValue(n2, n3);
        if (number6 != null) {
            double d14 = valueAxis.valueToJava2D(number6.doubleValue(), rectangle2D, rectangleEdge);
            d4 = categoryItemRendererState.getBarWidth() / 4.0;
            object = new Ellipse2D.Double(d14 - d4, d8 + d4, d4 * 2.0, d4 * 2.0);
            graphics2D.fill((Shape)object);
            graphics2D.draw((Shape)object);
        }
        if ((number = boxAndWhiskerCategoryDataset.getMedianValue(n2, n3)) != null) {
            d3 = valueAxis.valueToJava2D(number.doubleValue(), rectangle2D, rectangleEdge);
            graphics2D.draw(new Line2D.Double(d3, d8, d3, d8 + categoryItemRendererState.getBarWidth()));
        }
        if (categoryItemRendererState.getInfo() == null) return;
        if (double_ == null) return;
        EntityCollection entityCollection = categoryItemRendererState.getEntityCollection();
        if (entityCollection == null) return;
        object = null;
        CategoryToolTipGenerator categoryToolTipGenerator = this.getToolTipGenerator(n2, n3);
        if (categoryToolTipGenerator != null) {
            object = categoryToolTipGenerator.generateToolTip(categoryDataset, n2, n3);
        }
        String string = null;
        if (this.getItemURLGenerator(n2, n3) != null) {
            string = this.getItemURLGenerator(n2, n3).generateURL(categoryDataset, n2, n3);
        }
        CategoryItemEntity categoryItemEntity = new CategoryItemEntity(double_, (String)object, string, categoryDataset, n2, categoryDataset.getColumnKey(n3), n3);
        entityCollection.add(categoryItemEntity);
    }

    public void drawVerticalItem(Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, CategoryDataset categoryDataset, int n2, int n3) {
        double d6;
        double d5;
        Object object2;
        Object object;
        Serializable serializable22;
        double d3;
        double d4;
        Object object3;
        double d2;
        BoxAndWhiskerCategoryDataset boxAndWhiskerCategoryDataset = (BoxAndWhiskerCategoryDataset)categoryDataset;
        double d7 = categoryAxis.getCategoryEnd(n3, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
        double d8 = categoryAxis.getCategoryStart(n3, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
        double d9 = d7 - d8;
        double d10 = d8;
        int n4 = this.getRowCount();
        int n5 = this.getColumnCount();
        if (n4 > 1) {
            d2 = rectangle2D.getWidth() * this.getItemMargin() / (double)(n5 * (n4 - 1));
            d6 = categoryItemRendererState.getBarWidth() * (double)n4 + d2 * (double)(n4 - 1);
            double d11 = (d9 - d6) / 2.0;
            d10 = d10 + d11 + (double)n2 * (categoryItemRendererState.getBarWidth() + d2);
        } else {
            d2 = (d9 - categoryItemRendererState.getBarWidth()) / 2.0;
            d10 += d2;
        }
        d2 = 0.0;
        Paint paint = this.getItemPaint(n2, n3);
        if (paint != null) {
            graphics2D.setPaint(paint);
        }
        Stroke stroke = this.getItemStroke(n2, n3);
        graphics2D.setStroke(stroke);
        double d12 = 0.0;
        RectangleEdge rectangleEdge = categoryPlot.getRangeAxisEdge();
        Number number2 = boxAndWhiskerCategoryDataset.getQ1Value(n2, n3);
        Number number3 = boxAndWhiskerCategoryDataset.getQ3Value(n2, n3);
        Number number4 = boxAndWhiskerCategoryDataset.getMaxRegularValue(n2, n3);
        Number number5 = boxAndWhiskerCategoryDataset.getMinRegularValue(n2, n3);
        Rectangle2D.Double double_ = null;
        if (number2 != null && number3 != null && number4 != null && number5 != null) {
            double d13 = valueAxis.valueToJava2D(number2.doubleValue(), rectangle2D, rectangleEdge);
            d5 = valueAxis.valueToJava2D(number3.doubleValue(), rectangle2D, rectangleEdge);
            d4 = valueAxis.valueToJava2D(number4.doubleValue(), rectangle2D, rectangleEdge);
            d3 = valueAxis.valueToJava2D(number5.doubleValue(), rectangle2D, rectangleEdge);
            double d14 = d10 + categoryItemRendererState.getBarWidth() / 2.0;
            graphics2D.draw(new Line2D.Double(d14, d4, d14, d5));
            graphics2D.draw(new Line2D.Double(d10, d4, d10 + categoryItemRendererState.getBarWidth(), d4));
            graphics2D.draw(new Line2D.Double(d14, d3, d14, d13));
            graphics2D.draw(new Line2D.Double(d10, d3, d10 + categoryItemRendererState.getBarWidth(), d3));
            double_ = new Rectangle2D.Double(d10, Math.min(d13, d5), categoryItemRendererState.getBarWidth(), Math.abs(d13 - d5));
            if (this.fillBox) {
                graphics2D.fill(double_);
            }
            graphics2D.draw(double_);
        }
        graphics2D.setPaint(this.artifactPaint);
        Number number6 = boxAndWhiskerCategoryDataset.getMeanValue(n2, n3);
        if (number6 != null) {
            d2 = valueAxis.valueToJava2D(number6.doubleValue(), rectangle2D, rectangleEdge);
            d12 = categoryItemRendererState.getBarWidth() / 4.0;
            Serializable serializable22 = new Ellipse2D.Double(d10 + d12, d2 - d12, d12 * 2.0, d12 * 2.0);
            graphics2D.fill((Shape)((Object)serializable22));
            graphics2D.draw((Shape)((Object)serializable22));
        }
        if ((serializable22 = boxAndWhiskerCategoryDataset.getMedianValue(n2, n3)) != null) {
            d5 = valueAxis.valueToJava2D(serializable22.doubleValue(), rectangle2D, rectangleEdge);
            graphics2D.draw(new Line2D.Double(d10, d5, d10 + categoryItemRendererState.getBarWidth(), d5));
        }
        d5 = valueAxis.valueToJava2D(valueAxis.getUpperBound(), rectangle2D, rectangleEdge) + d12;
        d4 = valueAxis.valueToJava2D(valueAxis.getLowerBound(), rectangle2D, rectangleEdge) - d12;
        graphics2D.setPaint(paint);
        d3 = categoryItemRendererState.getBarWidth() / 3.0;
        ArrayList<Outlier> arrayList = new ArrayList<Outlier>();
        OutlierListCollection outlierListCollection = new OutlierListCollection();
        List list = boxAndWhiskerCategoryDataset.getOutliers(n2, n3);
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); ++i2) {
                double d15 = ((Number)list.get(i2)).doubleValue();
                object2 = boxAndWhiskerCategoryDataset.getMinOutlier(n2, n3);
                Number number = boxAndWhiskerCategoryDataset.getMaxOutlier(n2, n3);
                Number number7 = boxAndWhiskerCategoryDataset.getMinRegularValue(n2, n3);
                Number number8 = boxAndWhiskerCategoryDataset.getMaxRegularValue(n2, n3);
                if (d15 > number.doubleValue()) {
                    outlierListCollection.setHighFarOut(true);
                } else if (d15 < object2.doubleValue()) {
                    outlierListCollection.setLowFarOut(true);
                } else if (d15 > number8.doubleValue()) {
                    d6 = valueAxis.valueToJava2D(d15, rectangle2D, rectangleEdge);
                    arrayList.add(new Outlier(d10 + categoryItemRendererState.getBarWidth() / 2.0, d6, d3));
                } else if (d15 < number7.doubleValue()) {
                    d6 = valueAxis.valueToJava2D(d15, rectangle2D, rectangleEdge);
                    arrayList.add(new Outlier(d10 + categoryItemRendererState.getBarWidth() / 2.0, d6, d3));
                }
                Collections.sort(arrayList);
            }
            for (Outlier outlier : arrayList) {
                outlierListCollection.add(outlier);
            }
            object = outlierListCollection.iterator();
            while (object.hasNext()) {
                OutlierList outlierList = (OutlierList)object.next();
                object3 = outlierList.getAveragedOutlier();
                object2 = object3.getPoint();
                if (outlierList.isMultiple()) {
                    this.drawMultipleEllipse((Point2D)object2, categoryItemRendererState.getBarWidth(), d3, graphics2D);
                    continue;
                }
                this.drawEllipse((Point2D)object2, d3, graphics2D);
            }
            if (outlierListCollection.isHighFarOut()) {
                this.drawHighFarOut(d12 / 2.0, graphics2D, d10 + categoryItemRendererState.getBarWidth() / 2.0, d5);
            }
            if (outlierListCollection.isLowFarOut()) {
                this.drawLowFarOut(d12 / 2.0, graphics2D, d10 + categoryItemRendererState.getBarWidth() / 2.0, d4);
            }
        }
        if (categoryItemRendererState.getInfo() == null) return;
        if (double_ == null) return;
        object = categoryItemRendererState.getEntityCollection();
        if (object == null) return;
        String string = null;
        object3 = this.getToolTipGenerator(n2, n3);
        if (object3 != null) {
            string = object3.generateToolTip(categoryDataset, n2, n3);
        }
        object2 = null;
        if (this.getItemURLGenerator(n2, n3) != null) {
            object2 = this.getItemURLGenerator(n2, n3).generateURL(categoryDataset, n2, n3);
        }
        CategoryItemEntity categoryItemEntity = new CategoryItemEntity(double_, string, (String)object2, categoryDataset, n2, categoryDataset.getColumnKey(n3), n3);
        object.add(categoryItemEntity);
    }

    private void drawEllipse(Point2D point2D, double d2, Graphics2D graphics2D) {
        Ellipse2D.Double double_ = new Ellipse2D.Double(point2D.getX() + d2 / 2.0, point2D.getY(), d2, d2);
        graphics2D.draw(double_);
    }

    private void drawMultipleEllipse(Point2D point2D, double d2, double d3, Graphics2D graphics2D) {
        Ellipse2D.Double double_ = new Ellipse2D.Double(point2D.getX() - d2 / 2.0 + d3, point2D.getY(), d3, d3);
        Ellipse2D.Double double_2 = new Ellipse2D.Double(point2D.getX() + d2 / 2.0, point2D.getY(), d3, d3);
        graphics2D.draw(double_);
        graphics2D.draw(double_2);
    }

    private void drawHighFarOut(double d2, Graphics2D graphics2D, double d3, double d4) {
        double d5 = d2 * 2.0;
        graphics2D.draw(new Line2D.Double(d3 - d5, d4 + d5, d3 + d5, d4 + d5));
        graphics2D.draw(new Line2D.Double(d3 - d5, d4 + d5, d3, d4));
        graphics2D.draw(new Line2D.Double(d3 + d5, d4 + d5, d3, d4));
    }

    private void drawLowFarOut(double d2, Graphics2D graphics2D, double d3, double d4) {
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
        if (!(object instanceof BoxAndWhiskerRenderer)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        BoxAndWhiskerRenderer boxAndWhiskerRenderer = (BoxAndWhiskerRenderer)object;
        if (!PaintUtilities.equal(this.artifactPaint, boxAndWhiskerRenderer.artifactPaint)) {
            return false;
        }
        if (this.fillBox != boxAndWhiskerRenderer.fillBox) {
            return false;
        }
        if (this.itemMargin == boxAndWhiskerRenderer.itemMargin) return true;
        return false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.artifactPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.artifactPaint = SerialUtilities.readPaint(objectInputStream);
    }
}

