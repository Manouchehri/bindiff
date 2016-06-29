package org.jfree.chart.renderer.category;

import org.jfree.chart.event.*;
import org.jfree.chart.*;
import org.jfree.data.category.*;
import java.awt.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.axis.*;
import org.jfree.data.statistics.*;
import org.jfree.ui.*;
import org.jfree.chart.entity.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.renderer.*;
import java.util.*;
import java.awt.geom.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class BoxAndWhiskerRenderer extends AbstractCategoryItemRenderer implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = 632027470694481177L;
    private transient Paint artifactPaint;
    private boolean fillBox;
    private double itemMargin;
    
    public BoxAndWhiskerRenderer() {
        this.artifactPaint = Color.black;
        this.fillBox = true;
        this.itemMargin = 0.2;
    }
    
    public Paint getArtifactPaint() {
        return this.artifactPaint;
    }
    
    public void setArtifactPaint(final Paint artifactPaint) {
        if (artifactPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.artifactPaint = artifactPaint;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public boolean getFillBox() {
        return this.fillBox;
    }
    
    public void setFillBox(final boolean fillBox) {
        this.fillBox = fillBox;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public double getItemMargin() {
        return this.itemMargin;
    }
    
    public void setItemMargin(final double itemMargin) {
        this.itemMargin = itemMargin;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public LegendItem getLegendItem(final int n, final int n2) {
        final CategoryPlot plot = this.getPlot();
        if (plot == null) {
            return null;
        }
        final CategoryDataset dataset = plot.getDataset(n);
        final String generateLabel = this.getLegendItemLabelGenerator().generateLabel(dataset, n2);
        String generateLabel2 = null;
        if (this.getLegendItemToolTipGenerator() != null) {
            generateLabel2 = this.getLegendItemToolTipGenerator().generateLabel(dataset, n2);
        }
        String generateLabel3 = null;
        if (this.getLegendItemURLGenerator() != null) {
            generateLabel3 = this.getLegendItemURLGenerator().generateLabel(dataset, n2);
        }
        return new LegendItem(generateLabel, generateLabel, generateLabel2, generateLabel3, new Rectangle2D.Double(-4.0, -4.0, 8.0, 8.0), this.getSeriesPaint(n2), this.getSeriesOutlineStroke(n2), this.getSeriesOutlinePaint(n2));
    }
    
    public CategoryItemRendererState initialise(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final int n, final PlotRenderingInfo plotRenderingInfo) {
        final CategoryItemRendererState initialise = super.initialise(graphics2D, rectangle2D, categoryPlot, n, plotRenderingInfo);
        final CategoryAxis domainAxis = this.getDomainAxis(categoryPlot, n);
        final CategoryDataset dataset = categoryPlot.getDataset(n);
        if (dataset != null) {
            final int columnCount = dataset.getColumnCount();
            final int rowCount = dataset.getRowCount();
            double n2 = 0.0;
            final PlotOrientation orientation = categoryPlot.getOrientation();
            if (orientation == PlotOrientation.HORIZONTAL) {
                n2 = rectangle2D.getHeight();
            }
            else if (orientation == PlotOrientation.VERTICAL) {
                n2 = rectangle2D.getWidth();
            }
            double categoryMargin = 0.0;
            double itemMargin = 0.0;
            if (columnCount > 1) {
                categoryMargin = domainAxis.getCategoryMargin();
            }
            if (rowCount > 1) {
                itemMargin = this.getItemMargin();
            }
            final double barWidth = n2 * (1.0 - domainAxis.getLowerMargin() - domainAxis.getUpperMargin() - categoryMargin - itemMargin);
            if (rowCount * columnCount > 0) {
                initialise.setBarWidth(barWidth / (dataset.getColumnCount() * dataset.getRowCount()));
            }
            else {
                initialise.setBarWidth(barWidth);
            }
        }
        return initialise;
    }
    
    public void drawItem(final Graphics2D graphics2D, final CategoryItemRendererState categoryItemRendererState, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final CategoryAxis categoryAxis, final ValueAxis valueAxis, final CategoryDataset categoryDataset, final int n, final int n2, final int n3) {
        if (!(categoryDataset instanceof BoxAndWhiskerCategoryDataset)) {
            throw new IllegalArgumentException("BoxAndWhiskerRenderer.drawItem() : the data should be of type BoxAndWhiskerCategoryDataset only.");
        }
        final PlotOrientation orientation = categoryPlot.getOrientation();
        if (orientation == PlotOrientation.HORIZONTAL) {
            this.drawHorizontalItem(graphics2D, categoryItemRendererState, rectangle2D, categoryPlot, categoryAxis, valueAxis, categoryDataset, n, n2);
        }
        else if (orientation == PlotOrientation.VERTICAL) {
            this.drawVerticalItem(graphics2D, categoryItemRendererState, rectangle2D, categoryPlot, categoryAxis, valueAxis, categoryDataset, n, n2);
        }
    }
    
    public void drawHorizontalItem(final Graphics2D graphics2D, final CategoryItemRendererState categoryItemRendererState, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final CategoryAxis categoryAxis, final ValueAxis valueAxis, final CategoryDataset categoryDataset, final int n, final int n2) {
        final BoxAndWhiskerCategoryDataset boxAndWhiskerCategoryDataset = (BoxAndWhiskerCategoryDataset)categoryDataset;
        final double categoryEnd = categoryAxis.getCategoryEnd(n2, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
        final double categoryStart = categoryAxis.getCategoryStart(n2, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
        final double abs = Math.abs(categoryEnd - categoryStart);
        final double n3 = categoryStart;
        final int rowCount = this.getRowCount();
        final int columnCount = this.getColumnCount();
        double n5;
        if (rowCount > 1) {
            final double n4 = rectangle2D.getWidth() * this.getItemMargin() / (columnCount * (rowCount - 1));
            n5 = n3 + (abs - (categoryItemRendererState.getBarWidth() * rowCount + n4 * (rowCount - 1))) / 2.0 + n * (categoryItemRendererState.getBarWidth() + n4);
        }
        else {
            n5 = n3 + (abs - categoryItemRendererState.getBarWidth()) / 2.0;
        }
        final Paint itemPaint = this.getItemPaint(n, n2);
        if (itemPaint != null) {
            graphics2D.setPaint(itemPaint);
        }
        graphics2D.setStroke(this.getItemStroke(n, n2));
        final RectangleEdge rangeAxisEdge = categoryPlot.getRangeAxisEdge();
        final Number q1Value = boxAndWhiskerCategoryDataset.getQ1Value(n, n2);
        final Number q3Value = boxAndWhiskerCategoryDataset.getQ3Value(n, n2);
        final Number maxRegularValue = boxAndWhiskerCategoryDataset.getMaxRegularValue(n, n2);
        final Number minRegularValue = boxAndWhiskerCategoryDataset.getMinRegularValue(n, n2);
        Shape shape = null;
        if (q1Value != null && q3Value != null && maxRegularValue != null && minRegularValue != null) {
            final double valueToJava2D = valueAxis.valueToJava2D(q1Value.doubleValue(), rectangle2D, rangeAxisEdge);
            final double valueToJava2D2 = valueAxis.valueToJava2D(q3Value.doubleValue(), rectangle2D, rangeAxisEdge);
            final double valueToJava2D3 = valueAxis.valueToJava2D(maxRegularValue.doubleValue(), rectangle2D, rangeAxisEdge);
            final double valueToJava2D4 = valueAxis.valueToJava2D(minRegularValue.doubleValue(), rectangle2D, rangeAxisEdge);
            final double n6 = n5 + categoryItemRendererState.getBarWidth() / 2.0;
            graphics2D.draw(new Line2D.Double(valueToJava2D3, n6, valueToJava2D2, n6));
            graphics2D.draw(new Line2D.Double(valueToJava2D3, n5, valueToJava2D3, n5 + categoryItemRendererState.getBarWidth()));
            graphics2D.draw(new Line2D.Double(valueToJava2D4, n6, valueToJava2D, n6));
            graphics2D.draw(new Line2D.Double(valueToJava2D4, n5, valueToJava2D4, n5 + categoryItemRendererState.getBarWidth()));
            shape = new Rectangle2D.Double(Math.min(valueToJava2D, valueToJava2D2), n5, Math.abs(valueToJava2D - valueToJava2D2), categoryItemRendererState.getBarWidth());
            if (this.fillBox) {
                graphics2D.fill(shape);
            }
            graphics2D.draw(shape);
        }
        graphics2D.setPaint(this.artifactPaint);
        final Number meanValue = boxAndWhiskerCategoryDataset.getMeanValue(n, n2);
        if (meanValue != null) {
            final double valueToJava2D5 = valueAxis.valueToJava2D(meanValue.doubleValue(), rectangle2D, rangeAxisEdge);
            final double n7 = categoryItemRendererState.getBarWidth() / 4.0;
            final Ellipse2D.Double double1 = new Ellipse2D.Double(valueToJava2D5 - n7, n5 + n7, n7 * 2.0, n7 * 2.0);
            graphics2D.fill(double1);
            graphics2D.draw(double1);
        }
        final Number medianValue = boxAndWhiskerCategoryDataset.getMedianValue(n, n2);
        if (medianValue != null) {
            final double valueToJava2D6 = valueAxis.valueToJava2D(medianValue.doubleValue(), rectangle2D, rangeAxisEdge);
            graphics2D.draw(new Line2D.Double(valueToJava2D6, n5, valueToJava2D6, n5 + categoryItemRendererState.getBarWidth()));
        }
        if (categoryItemRendererState.getInfo() != null && shape != null) {
            final EntityCollection entityCollection = categoryItemRendererState.getEntityCollection();
            if (entityCollection != null) {
                String generateToolTip = null;
                final CategoryToolTipGenerator toolTipGenerator = this.getToolTipGenerator(n, n2);
                if (toolTipGenerator != null) {
                    generateToolTip = toolTipGenerator.generateToolTip(categoryDataset, n, n2);
                }
                String generateURL = null;
                if (this.getItemURLGenerator(n, n2) != null) {
                    generateURL = this.getItemURLGenerator(n, n2).generateURL(categoryDataset, n, n2);
                }
                entityCollection.add(new CategoryItemEntity(shape, generateToolTip, generateURL, categoryDataset, n, categoryDataset.getColumnKey(n2), n2));
            }
        }
    }
    
    public void drawVerticalItem(final Graphics2D graphics2D, final CategoryItemRendererState categoryItemRendererState, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final CategoryAxis categoryAxis, final ValueAxis valueAxis, final CategoryDataset categoryDataset, final int n, final int n2) {
        final BoxAndWhiskerCategoryDataset boxAndWhiskerCategoryDataset = (BoxAndWhiskerCategoryDataset)categoryDataset;
        final double categoryEnd = categoryAxis.getCategoryEnd(n2, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
        final double categoryStart = categoryAxis.getCategoryStart(n2, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
        final double n3 = categoryEnd - categoryStart;
        final double n4 = categoryStart;
        final int rowCount = this.getRowCount();
        final int columnCount = this.getColumnCount();
        double n6;
        if (rowCount > 1) {
            final double n5 = rectangle2D.getWidth() * this.getItemMargin() / (columnCount * (rowCount - 1));
            n6 = n4 + (n3 - (categoryItemRendererState.getBarWidth() * rowCount + n5 * (rowCount - 1))) / 2.0 + n * (categoryItemRendererState.getBarWidth() + n5);
        }
        else {
            n6 = n4 + (n3 - categoryItemRendererState.getBarWidth()) / 2.0;
        }
        final Paint itemPaint = this.getItemPaint(n, n2);
        if (itemPaint != null) {
            graphics2D.setPaint(itemPaint);
        }
        graphics2D.setStroke(this.getItemStroke(n, n2));
        double n7 = 0.0;
        final RectangleEdge rangeAxisEdge = categoryPlot.getRangeAxisEdge();
        final Number q1Value = boxAndWhiskerCategoryDataset.getQ1Value(n, n2);
        final Number q3Value = boxAndWhiskerCategoryDataset.getQ3Value(n, n2);
        final Number maxRegularValue = boxAndWhiskerCategoryDataset.getMaxRegularValue(n, n2);
        final Number minRegularValue = boxAndWhiskerCategoryDataset.getMinRegularValue(n, n2);
        Shape shape = null;
        if (q1Value != null && q3Value != null && maxRegularValue != null && minRegularValue != null) {
            final double valueToJava2D = valueAxis.valueToJava2D(q1Value.doubleValue(), rectangle2D, rangeAxisEdge);
            final double valueToJava2D2 = valueAxis.valueToJava2D(q3Value.doubleValue(), rectangle2D, rangeAxisEdge);
            final double valueToJava2D3 = valueAxis.valueToJava2D(maxRegularValue.doubleValue(), rectangle2D, rangeAxisEdge);
            final double valueToJava2D4 = valueAxis.valueToJava2D(minRegularValue.doubleValue(), rectangle2D, rangeAxisEdge);
            final double n8 = n6 + categoryItemRendererState.getBarWidth() / 2.0;
            graphics2D.draw(new Line2D.Double(n8, valueToJava2D3, n8, valueToJava2D2));
            graphics2D.draw(new Line2D.Double(n6, valueToJava2D3, n6 + categoryItemRendererState.getBarWidth(), valueToJava2D3));
            graphics2D.draw(new Line2D.Double(n8, valueToJava2D4, n8, valueToJava2D));
            graphics2D.draw(new Line2D.Double(n6, valueToJava2D4, n6 + categoryItemRendererState.getBarWidth(), valueToJava2D4));
            shape = new Rectangle2D.Double(n6, Math.min(valueToJava2D, valueToJava2D2), categoryItemRendererState.getBarWidth(), Math.abs(valueToJava2D - valueToJava2D2));
            if (this.fillBox) {
                graphics2D.fill(shape);
            }
            graphics2D.draw(shape);
        }
        graphics2D.setPaint(this.artifactPaint);
        final Number meanValue = boxAndWhiskerCategoryDataset.getMeanValue(n, n2);
        if (meanValue != null) {
            final double valueToJava2D5 = valueAxis.valueToJava2D(meanValue.doubleValue(), rectangle2D, rangeAxisEdge);
            n7 = categoryItemRendererState.getBarWidth() / 4.0;
            final Ellipse2D.Double double1 = new Ellipse2D.Double(n6 + n7, valueToJava2D5 - n7, n7 * 2.0, n7 * 2.0);
            graphics2D.fill(double1);
            graphics2D.draw(double1);
        }
        final Number medianValue = boxAndWhiskerCategoryDataset.getMedianValue(n, n2);
        if (medianValue != null) {
            final double valueToJava2D6 = valueAxis.valueToJava2D(medianValue.doubleValue(), rectangle2D, rangeAxisEdge);
            graphics2D.draw(new Line2D.Double(n6, valueToJava2D6, n6 + categoryItemRendererState.getBarWidth(), valueToJava2D6));
        }
        final double n9 = valueAxis.valueToJava2D(valueAxis.getUpperBound(), rectangle2D, rangeAxisEdge) + n7;
        final double n10 = valueAxis.valueToJava2D(valueAxis.getLowerBound(), rectangle2D, rangeAxisEdge) - n7;
        graphics2D.setPaint(itemPaint);
        final double n11 = categoryItemRendererState.getBarWidth() / 3.0;
        final ArrayList<Comparable> list = new ArrayList<Comparable>();
        final OutlierListCollection collection = new OutlierListCollection();
        final List outliers = boxAndWhiskerCategoryDataset.getOutliers(n, n2);
        if (outliers != null) {
            for (int i = 0; i < outliers.size(); ++i) {
                final double doubleValue = outliers.get(i).doubleValue();
                final Number minOutlier = boxAndWhiskerCategoryDataset.getMinOutlier(n, n2);
                final Number maxOutlier = boxAndWhiskerCategoryDataset.getMaxOutlier(n, n2);
                final Number minRegularValue2 = boxAndWhiskerCategoryDataset.getMinRegularValue(n, n2);
                final Number maxRegularValue2 = boxAndWhiskerCategoryDataset.getMaxRegularValue(n, n2);
                if (doubleValue > maxOutlier.doubleValue()) {
                    collection.setHighFarOut(true);
                }
                else if (doubleValue < minOutlier.doubleValue()) {
                    collection.setLowFarOut(true);
                }
                else if (doubleValue > maxRegularValue2.doubleValue()) {
                    list.add(new Outlier(n6 + categoryItemRendererState.getBarWidth() / 2.0, valueAxis.valueToJava2D(doubleValue, rectangle2D, rangeAxisEdge), n11));
                }
                else if (doubleValue < minRegularValue2.doubleValue()) {
                    list.add(new Outlier(n6 + categoryItemRendererState.getBarWidth() / 2.0, valueAxis.valueToJava2D(doubleValue, rectangle2D, rangeAxisEdge), n11));
                }
                Collections.sort(list);
            }
            final Iterator<Outlier> iterator = list.iterator();
            while (iterator.hasNext()) {
                collection.add(iterator.next());
            }
            for (final OutlierList list2 : collection) {
                final Point2D point = list2.getAveragedOutlier().getPoint();
                if (list2.isMultiple()) {
                    this.drawMultipleEllipse(point, categoryItemRendererState.getBarWidth(), n11, graphics2D);
                }
                else {
                    this.drawEllipse(point, n11, graphics2D);
                }
            }
            if (collection.isHighFarOut()) {
                this.drawHighFarOut(n7 / 2.0, graphics2D, n6 + categoryItemRendererState.getBarWidth() / 2.0, n9);
            }
            if (collection.isLowFarOut()) {
                this.drawLowFarOut(n7 / 2.0, graphics2D, n6 + categoryItemRendererState.getBarWidth() / 2.0, n10);
            }
        }
        if (categoryItemRendererState.getInfo() != null && shape != null) {
            final EntityCollection entityCollection = categoryItemRendererState.getEntityCollection();
            if (entityCollection != null) {
                String generateToolTip = null;
                final CategoryToolTipGenerator toolTipGenerator = this.getToolTipGenerator(n, n2);
                if (toolTipGenerator != null) {
                    generateToolTip = toolTipGenerator.generateToolTip(categoryDataset, n, n2);
                }
                String generateURL = null;
                if (this.getItemURLGenerator(n, n2) != null) {
                    generateURL = this.getItemURLGenerator(n, n2).generateURL(categoryDataset, n, n2);
                }
                entityCollection.add(new CategoryItemEntity(shape, generateToolTip, generateURL, categoryDataset, n, categoryDataset.getColumnKey(n2), n2));
            }
        }
    }
    
    private void drawEllipse(final Point2D point2D, final double n, final Graphics2D graphics2D) {
        graphics2D.draw(new Ellipse2D.Double(point2D.getX() + n / 2.0, point2D.getY(), n, n));
    }
    
    private void drawMultipleEllipse(final Point2D point2D, final double n, final double n2, final Graphics2D graphics2D) {
        final Ellipse2D.Double double1 = new Ellipse2D.Double(point2D.getX() - n / 2.0 + n2, point2D.getY(), n2, n2);
        final Ellipse2D.Double double2 = new Ellipse2D.Double(point2D.getX() + n / 2.0, point2D.getY(), n2, n2);
        graphics2D.draw(double1);
        graphics2D.draw(double2);
    }
    
    private void drawHighFarOut(final double n, final Graphics2D graphics2D, final double n2, final double n3) {
        final double n4 = n * 2.0;
        graphics2D.draw(new Line2D.Double(n2 - n4, n3 + n4, n2 + n4, n3 + n4));
        graphics2D.draw(new Line2D.Double(n2 - n4, n3 + n4, n2, n3));
        graphics2D.draw(new Line2D.Double(n2 + n4, n3 + n4, n2, n3));
    }
    
    private void drawLowFarOut(final double n, final Graphics2D graphics2D, final double n2, final double n3) {
        final double n4 = n * 2.0;
        graphics2D.draw(new Line2D.Double(n2 - n4, n3 - n4, n2 + n4, n3 - n4));
        graphics2D.draw(new Line2D.Double(n2 - n4, n3 - n4, n2, n3));
        graphics2D.draw(new Line2D.Double(n2 + n4, n3 - n4, n2, n3));
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BoxAndWhiskerRenderer)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final BoxAndWhiskerRenderer boxAndWhiskerRenderer = (BoxAndWhiskerRenderer)o;
        return PaintUtilities.equal(this.artifactPaint, boxAndWhiskerRenderer.artifactPaint) && this.fillBox == boxAndWhiskerRenderer.fillBox && this.itemMargin == boxAndWhiskerRenderer.itemMargin;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.artifactPaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.artifactPaint = SerialUtilities.readPaint(objectInputStream);
    }
}
