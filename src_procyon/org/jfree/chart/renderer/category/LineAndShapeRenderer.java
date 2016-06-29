package org.jfree.chart.renderer.category;

import java.io.*;
import org.jfree.chart.event.*;
import org.jfree.chart.*;
import org.jfree.data.category.*;
import java.awt.*;
import java.awt.geom.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.entity.*;
import org.jfree.util.*;

public class LineAndShapeRenderer extends AbstractCategoryItemRenderer implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = -197749519869226398L;
    private Boolean linesVisible;
    private BooleanList seriesLinesVisible;
    private boolean baseLinesVisible;
    private Boolean shapesVisible;
    private BooleanList seriesShapesVisible;
    private boolean baseShapesVisible;
    private Boolean shapesFilled;
    private BooleanList seriesShapesFilled;
    private boolean baseShapesFilled;
    private boolean useFillPaint;
    private boolean drawOutlines;
    private boolean useOutlinePaint;
    
    public LineAndShapeRenderer() {
        this(true, true);
    }
    
    public LineAndShapeRenderer(final boolean baseLinesVisible, final boolean baseShapesVisible) {
        this.linesVisible = null;
        this.seriesLinesVisible = new BooleanList();
        this.baseLinesVisible = baseLinesVisible;
        this.shapesVisible = null;
        this.seriesShapesVisible = new BooleanList();
        this.baseShapesVisible = baseShapesVisible;
        this.shapesFilled = null;
        this.seriesShapesFilled = new BooleanList();
        this.baseShapesFilled = true;
        this.useFillPaint = false;
        this.drawOutlines = true;
        this.useOutlinePaint = false;
    }
    
    public boolean getItemLineVisible(final int n, final int n2) {
        Boolean b = this.linesVisible;
        if (b == null) {
            b = this.getSeriesLinesVisible(n);
        }
        if (b != null) {
            return b;
        }
        return this.baseLinesVisible;
    }
    
    public Boolean getLinesVisible() {
        return this.linesVisible;
    }
    
    public void setLinesVisible(final Boolean linesVisible) {
        this.linesVisible = linesVisible;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public void setLinesVisible(final boolean b) {
        this.setLinesVisible(BooleanUtilities.valueOf(b));
    }
    
    public Boolean getSeriesLinesVisible(final int n) {
        return this.seriesLinesVisible.getBoolean(n);
    }
    
    public void setSeriesLinesVisible(final int n, final Boolean b) {
        this.seriesLinesVisible.setBoolean(n, b);
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public void setSeriesLinesVisible(final int n, final boolean b) {
        this.setSeriesLinesVisible(n, BooleanUtilities.valueOf(b));
    }
    
    public boolean getBaseLinesVisible() {
        return this.baseLinesVisible;
    }
    
    public void setBaseLinesVisible(final boolean baseLinesVisible) {
        this.baseLinesVisible = baseLinesVisible;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public boolean getItemShapeVisible(final int n, final int n2) {
        Boolean b = this.shapesVisible;
        if (b == null) {
            b = this.getSeriesShapesVisible(n);
        }
        if (b != null) {
            return b;
        }
        return this.baseShapesVisible;
    }
    
    public Boolean getShapesVisible() {
        return this.shapesVisible;
    }
    
    public void setShapesVisible(final Boolean shapesVisible) {
        this.shapesVisible = shapesVisible;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public void setShapesVisible(final boolean b) {
        this.setShapesVisible(BooleanUtilities.valueOf(b));
    }
    
    public Boolean getSeriesShapesVisible(final int n) {
        return this.seriesShapesVisible.getBoolean(n);
    }
    
    public void setSeriesShapesVisible(final int n, final boolean b) {
        this.setSeriesShapesVisible(n, BooleanUtilities.valueOf(b));
    }
    
    public void setSeriesShapesVisible(final int n, final Boolean b) {
        this.seriesShapesVisible.setBoolean(n, b);
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public boolean getBaseShapesVisible() {
        return this.baseShapesVisible;
    }
    
    public void setBaseShapesVisible(final boolean baseShapesVisible) {
        this.baseShapesVisible = baseShapesVisible;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public boolean getDrawOutlines() {
        return this.drawOutlines;
    }
    
    public void setDrawOutlines(final boolean drawOutlines) {
        this.drawOutlines = drawOutlines;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public boolean getUseOutlinePaint() {
        return this.useOutlinePaint;
    }
    
    public void setUseOutlinePaint(final boolean useOutlinePaint) {
        this.useOutlinePaint = useOutlinePaint;
    }
    
    public boolean getItemShapeFilled(final int n, final int n2) {
        return this.getSeriesShapesFilled(n);
    }
    
    public boolean getSeriesShapesFilled(final int n) {
        if (this.shapesFilled != null) {
            return this.shapesFilled;
        }
        final Boolean boolean1 = this.seriesShapesFilled.getBoolean(n);
        if (boolean1 != null) {
            return boolean1;
        }
        return this.baseShapesFilled;
    }
    
    public Boolean getShapesFilled() {
        return this.shapesFilled;
    }
    
    public void setShapesFilled(final boolean b) {
        if (b) {
            this.setShapesFilled(Boolean.TRUE);
        }
        else {
            this.setShapesFilled(Boolean.FALSE);
        }
    }
    
    public void setShapesFilled(final Boolean shapesFilled) {
        this.shapesFilled = shapesFilled;
    }
    
    public void setSeriesShapesFilled(final int n, final Boolean b) {
        this.seriesShapesFilled.setBoolean(n, b);
    }
    
    public void setSeriesShapesFilled(final int n, final boolean b) {
        this.seriesShapesFilled.setBoolean(n, BooleanUtilities.valueOf(b));
    }
    
    public boolean getBaseShapesFilled() {
        return this.baseShapesFilled;
    }
    
    public void setBaseShapesFilled(final boolean baseShapesFilled) {
        this.baseShapesFilled = baseShapesFilled;
    }
    
    public boolean getUseFillPaint() {
        return this.useFillPaint;
    }
    
    public void setUseFillPaint(final boolean useFillPaint) {
        this.useFillPaint = useFillPaint;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public LegendItem getLegendItem(final int n, final int n2) {
        final CategoryPlot plot = this.getPlot();
        if (plot == null) {
            return null;
        }
        if (this.isSeriesVisible(n2) && this.isSeriesVisibleInLegend(n2)) {
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
            final Shape seriesShape = this.getSeriesShape(n2);
            final Paint seriesPaint = this.getSeriesPaint(n2);
            return new LegendItem(generateLabel, generateLabel, generateLabel2, generateLabel3, this.getItemShapeVisible(n2, 0), seriesShape, this.getItemShapeFilled(n2, 0), this.useFillPaint ? this.getItemFillPaint(n2, 0) : seriesPaint, this.drawOutlines, this.useOutlinePaint ? this.getItemOutlinePaint(n2, 0) : seriesPaint, this.getSeriesOutlineStroke(n2), this.getItemLineVisible(n2, 0), new Line2D.Double(-7.0, 0.0, 7.0, 0.0), this.getItemStroke(n2, 0), this.getItemPaint(n2, 0));
        }
        return null;
    }
    
    public int getPassCount() {
        return 2;
    }
    
    public void drawItem(final Graphics2D graphics2D, final CategoryItemRendererState categoryItemRendererState, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final CategoryAxis categoryAxis, final ValueAxis valueAxis, final CategoryDataset categoryDataset, final int n, final int n2, final int n3) {
        if (!this.getItemVisible(n, n2)) {
            return;
        }
        if (!this.getItemLineVisible(n, n2) && !this.getItemShapeVisible(n, n2)) {
            return;
        }
        final Number value = categoryDataset.getValue(n, n2);
        if (value == null) {
            return;
        }
        final PlotOrientation orientation = categoryPlot.getOrientation();
        final double categoryMiddle = categoryAxis.getCategoryMiddle(n2, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
        final double doubleValue = value.doubleValue();
        final double valueToJava2D = valueAxis.valueToJava2D(doubleValue, rectangle2D, categoryPlot.getRangeAxisEdge());
        if (n3 == 0 && this.getItemLineVisible(n, n2) && n2 != 0) {
            final Number value2 = categoryDataset.getValue(n, n2 - 1);
            if (value2 != null) {
                final double doubleValue2 = value2.doubleValue();
                final double categoryMiddle2 = categoryAxis.getCategoryMiddle(n2 - 1, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
                final double valueToJava2D2 = valueAxis.valueToJava2D(doubleValue2, rectangle2D, categoryPlot.getRangeAxisEdge());
                Shape shape = null;
                if (orientation == PlotOrientation.HORIZONTAL) {
                    shape = new Line2D.Double(valueToJava2D2, categoryMiddle2, valueToJava2D, categoryMiddle);
                }
                else if (orientation == PlotOrientation.VERTICAL) {
                    shape = new Line2D.Double(categoryMiddle2, valueToJava2D2, categoryMiddle, valueToJava2D);
                }
                graphics2D.setPaint(this.getItemPaint(n, n2));
                graphics2D.setStroke(this.getItemStroke(n, n2));
                graphics2D.draw(shape);
            }
        }
        if (n3 == 1) {
            Shape shape2 = this.getItemShape(n, n2);
            if (orientation == PlotOrientation.HORIZONTAL) {
                shape2 = ShapeUtilities.createTranslatedShape(shape2, valueToJava2D, categoryMiddle);
            }
            else if (orientation == PlotOrientation.VERTICAL) {
                shape2 = ShapeUtilities.createTranslatedShape(shape2, categoryMiddle, valueToJava2D);
            }
            if (this.getItemShapeVisible(n, n2)) {
                if (this.getItemShapeFilled(n, n2)) {
                    if (this.useFillPaint) {
                        graphics2D.setPaint(this.getItemFillPaint(n, n2));
                    }
                    else {
                        graphics2D.setPaint(this.getItemPaint(n, n2));
                    }
                    graphics2D.fill(shape2);
                }
                if (this.drawOutlines) {
                    if (this.useOutlinePaint) {
                        graphics2D.setPaint(this.getItemOutlinePaint(n, n2));
                    }
                    else {
                        graphics2D.setPaint(this.getItemPaint(n, n2));
                    }
                    graphics2D.setStroke(this.getItemOutlineStroke(n, n2));
                    graphics2D.draw(shape2);
                }
            }
            if (this.isItemLabelVisible(n, n2)) {
                if (orientation == PlotOrientation.HORIZONTAL) {
                    this.drawItemLabel(graphics2D, orientation, categoryDataset, n, n2, valueToJava2D, categoryMiddle, doubleValue < 0.0);
                }
                else if (orientation == PlotOrientation.VERTICAL) {
                    this.drawItemLabel(graphics2D, orientation, categoryDataset, n, n2, categoryMiddle, valueToJava2D, doubleValue < 0.0);
                }
            }
            final EntityCollection entityCollection = categoryItemRendererState.getEntityCollection();
            if (entityCollection != null) {
                this.addItemEntity(entityCollection, categoryDataset, n, n2, shape2);
            }
        }
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof LineAndShapeRenderer)) {
            return false;
        }
        final LineAndShapeRenderer lineAndShapeRenderer = (LineAndShapeRenderer)o;
        return this.baseLinesVisible == lineAndShapeRenderer.baseLinesVisible && ObjectUtilities.equal(this.seriesLinesVisible, lineAndShapeRenderer.seriesLinesVisible) && ObjectUtilities.equal(this.linesVisible, lineAndShapeRenderer.linesVisible) && this.baseShapesVisible == lineAndShapeRenderer.baseShapesVisible && ObjectUtilities.equal(this.seriesShapesVisible, lineAndShapeRenderer.seriesShapesVisible) && ObjectUtilities.equal(this.shapesVisible, lineAndShapeRenderer.shapesVisible) && ObjectUtilities.equal(this.shapesFilled, lineAndShapeRenderer.shapesFilled) && ObjectUtilities.equal(this.seriesShapesFilled, lineAndShapeRenderer.seriesShapesFilled) && this.baseShapesFilled == lineAndShapeRenderer.baseShapesFilled && this.useOutlinePaint == lineAndShapeRenderer.useOutlinePaint && super.equals(o);
    }
    
    public Object clone() {
        final LineAndShapeRenderer lineAndShapeRenderer = (LineAndShapeRenderer)super.clone();
        lineAndShapeRenderer.seriesLinesVisible = (BooleanList)this.seriesLinesVisible.clone();
        lineAndShapeRenderer.seriesShapesVisible = (BooleanList)this.seriesLinesVisible.clone();
        lineAndShapeRenderer.seriesShapesFilled = (BooleanList)this.seriesShapesFilled.clone();
        return lineAndShapeRenderer;
    }
}
