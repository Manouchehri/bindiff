package org.jfree.chart.renderer.category;

import java.io.*;
import org.jfree.chart.event.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.axis.*;
import org.jfree.data.category.*;
import org.jfree.data.*;
import org.jfree.data.general.*;
import org.jfree.chart.*;
import java.awt.*;
import org.jfree.ui.*;
import org.jfree.chart.entity.*;
import org.jfree.text.*;
import java.awt.geom.*;
import org.jfree.chart.labels.*;
import org.jfree.util.*;

public class BarRenderer extends AbstractCategoryItemRenderer implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = 6000649414965887481L;
    public static final double DEFAULT_ITEM_MARGIN = 0.2;
    public static final double BAR_OUTLINE_WIDTH_THRESHOLD = 3.0;
    private double itemMargin;
    private boolean drawBarOutline;
    private double maximumBarWidth;
    private double minimumBarLength;
    private GradientPaintTransformer gradientPaintTransformer;
    private ItemLabelPosition positiveItemLabelPositionFallback;
    private ItemLabelPosition negativeItemLabelPositionFallback;
    private double upperClip;
    private double lowerClip;
    private double base;
    private boolean includeBaseInRange;
    
    public BarRenderer() {
        this.base = 0.0;
        this.includeBaseInRange = true;
        this.itemMargin = 0.2;
        this.drawBarOutline = true;
        this.maximumBarWidth = 1.0;
        this.positiveItemLabelPositionFallback = null;
        this.negativeItemLabelPositionFallback = null;
        this.gradientPaintTransformer = new StandardGradientPaintTransformer();
        this.minimumBarLength = 0.0;
    }
    
    public double getBase() {
        return this.base;
    }
    
    public void setBase(final double base) {
        this.base = base;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public double getItemMargin() {
        return this.itemMargin;
    }
    
    public void setItemMargin(final double itemMargin) {
        this.itemMargin = itemMargin;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public boolean isDrawBarOutline() {
        return this.drawBarOutline;
    }
    
    public void setDrawBarOutline(final boolean drawBarOutline) {
        this.drawBarOutline = drawBarOutline;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public double getMaximumBarWidth() {
        return this.maximumBarWidth;
    }
    
    public void setMaximumBarWidth(final double maximumBarWidth) {
        this.maximumBarWidth = maximumBarWidth;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public double getMinimumBarLength() {
        return this.minimumBarLength;
    }
    
    public void setMinimumBarLength(final double minimumBarLength) {
        this.minimumBarLength = minimumBarLength;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public GradientPaintTransformer getGradientPaintTransformer() {
        return this.gradientPaintTransformer;
    }
    
    public void setGradientPaintTransformer(final GradientPaintTransformer gradientPaintTransformer) {
        this.gradientPaintTransformer = gradientPaintTransformer;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public ItemLabelPosition getPositiveItemLabelPositionFallback() {
        return this.positiveItemLabelPositionFallback;
    }
    
    public void setPositiveItemLabelPositionFallback(final ItemLabelPosition positiveItemLabelPositionFallback) {
        this.positiveItemLabelPositionFallback = positiveItemLabelPositionFallback;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public ItemLabelPosition getNegativeItemLabelPositionFallback() {
        return this.negativeItemLabelPositionFallback;
    }
    
    public void setNegativeItemLabelPositionFallback(final ItemLabelPosition negativeItemLabelPositionFallback) {
        this.negativeItemLabelPositionFallback = negativeItemLabelPositionFallback;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public boolean getIncludeBaseInRange() {
        return this.includeBaseInRange;
    }
    
    public void setIncludeBaseInRange(final boolean includeBaseInRange) {
        if (this.includeBaseInRange != includeBaseInRange) {
            this.includeBaseInRange = includeBaseInRange;
            this.notifyListeners(new RendererChangeEvent(this));
        }
    }
    
    public double getLowerClip() {
        return this.lowerClip;
    }
    
    public double getUpperClip() {
        return this.upperClip;
    }
    
    public CategoryItemRendererState initialise(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final int n, final PlotRenderingInfo plotRenderingInfo) {
        final CategoryItemRendererState initialise = super.initialise(graphics2D, rectangle2D, categoryPlot, n, plotRenderingInfo);
        final ValueAxis rangeAxisForDataset = categoryPlot.getRangeAxisForDataset(n);
        this.lowerClip = rangeAxisForDataset.getRange().getLowerBound();
        this.upperClip = rangeAxisForDataset.getRange().getUpperBound();
        this.calculateBarWidth(categoryPlot, rectangle2D, n, initialise);
        return initialise;
    }
    
    protected void calculateBarWidth(final CategoryPlot categoryPlot, final Rectangle2D rectangle2D, final int n, final CategoryItemRendererState categoryItemRendererState) {
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
            final double n3 = n2 * this.getMaximumBarWidth();
            double categoryMargin = 0.0;
            double itemMargin = 0.0;
            if (columnCount > 1) {
                categoryMargin = domainAxis.getCategoryMargin();
            }
            if (rowCount > 1) {
                itemMargin = this.getItemMargin();
            }
            final double n4 = n2 * (1.0 - domainAxis.getLowerMargin() - domainAxis.getUpperMargin() - categoryMargin - itemMargin);
            if (rowCount * columnCount > 0) {
                categoryItemRendererState.setBarWidth(Math.min(n4 / (rowCount * columnCount), n3));
            }
            else {
                categoryItemRendererState.setBarWidth(Math.min(n4, n3));
            }
        }
    }
    
    protected double calculateBarW0(final CategoryPlot categoryPlot, final PlotOrientation plotOrientation, final Rectangle2D rectangle2D, final CategoryAxis categoryAxis, final CategoryItemRendererState categoryItemRendererState, final int n, final int n2) {
        double n3;
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            n3 = rectangle2D.getHeight();
        }
        else {
            n3 = rectangle2D.getWidth();
        }
        final double categoryStart = categoryAxis.getCategoryStart(n2, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
        final int rowCount = this.getRowCount();
        final int columnCount = this.getColumnCount();
        double n5;
        if (rowCount > 1) {
            final double n4 = n3 * this.getItemMargin() / (columnCount * (rowCount - 1));
            final double calculateSeriesWidth = this.calculateSeriesWidth(n3, categoryAxis, columnCount, rowCount);
            n5 = categoryStart + n * (calculateSeriesWidth + n4) + calculateSeriesWidth / 2.0 - categoryItemRendererState.getBarWidth() / 2.0;
        }
        else {
            n5 = categoryAxis.getCategoryMiddle(n2, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge()) - categoryItemRendererState.getBarWidth() / 2.0;
        }
        return n5;
    }
    
    protected double[] calculateBarL0L1(final double n) {
        final double lowerClip = this.getLowerClip();
        final double upperClip = this.getUpperClip();
        final double min = Math.min(this.base, n);
        final double max = Math.max(this.base, n);
        if (max < lowerClip) {
            return null;
        }
        if (min > upperClip) {
            return null;
        }
        return new double[] { Math.max(min, lowerClip), Math.min(max, upperClip) };
    }
    
    public Range findRangeBounds(final CategoryDataset categoryDataset) {
        Range range = DatasetUtilities.findRangeBounds(categoryDataset);
        if (range != null && this.includeBaseInRange) {
            range = Range.expandToInclude(range, this.base);
        }
        return range;
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
        final LegendItem legendItem = new LegendItem(generateLabel, generateLabel, generateLabel2, generateLabel3, true, new Rectangle2D.Double(-4.0, -4.0, 8.0, 8.0), true, this.getSeriesPaint(n2), this.isDrawBarOutline(), this.getSeriesOutlinePaint(n2), this.getSeriesOutlineStroke(n2), false, new Line2D.Float(), new BasicStroke(1.0f), Color.black);
        if (this.gradientPaintTransformer != null) {
            legendItem.setFillPaintTransformer(this.gradientPaintTransformer);
        }
        return legendItem;
    }
    
    public void drawItem(final Graphics2D graphics2D, final CategoryItemRendererState categoryItemRendererState, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final CategoryAxis categoryAxis, final ValueAxis valueAxis, final CategoryDataset categoryDataset, final int n, final int n2, final int n3) {
        final Number value = categoryDataset.getValue(n, n2);
        if (value == null) {
            return;
        }
        final double doubleValue = value.doubleValue();
        final PlotOrientation orientation = categoryPlot.getOrientation();
        final double calculateBarW0 = this.calculateBarW0(categoryPlot, orientation, rectangle2D, categoryAxis, categoryItemRendererState, n, n2);
        final double[] calculateBarL0L1 = this.calculateBarL0L1(doubleValue);
        if (calculateBarL0L1 == null) {
            return;
        }
        final RectangleEdge rangeAxisEdge = categoryPlot.getRangeAxisEdge();
        final double valueToJava2D = valueAxis.valueToJava2D(calculateBarL0L1[0], rectangle2D, rangeAxisEdge);
        final double valueToJava2D2 = valueAxis.valueToJava2D(calculateBarL0L1[1], rectangle2D, rangeAxisEdge);
        final double min = Math.min(valueToJava2D, valueToJava2D2);
        final double max = Math.max(Math.abs(valueToJava2D2 - valueToJava2D), this.getMinimumBarLength());
        Rectangle2D.Double double1;
        if (orientation == PlotOrientation.HORIZONTAL) {
            double1 = new Rectangle2D.Double(min, calculateBarW0, max, categoryItemRendererState.getBarWidth());
        }
        else {
            double1 = new Rectangle2D.Double(calculateBarW0, min, categoryItemRendererState.getBarWidth(), max);
        }
        Paint paint = this.getItemPaint(n, n2);
        final GradientPaintTransformer gradientPaintTransformer = this.getGradientPaintTransformer();
        if (gradientPaintTransformer != null && paint instanceof GradientPaint) {
            paint = gradientPaintTransformer.transform((GradientPaint)paint, double1);
        }
        graphics2D.setPaint(paint);
        graphics2D.fill(double1);
        if (this.isDrawBarOutline() && categoryItemRendererState.getBarWidth() > 3.0) {
            final Stroke itemOutlineStroke = this.getItemOutlineStroke(n, n2);
            final Paint itemOutlinePaint = this.getItemOutlinePaint(n, n2);
            if (itemOutlineStroke != null && itemOutlinePaint != null) {
                graphics2D.setStroke(itemOutlineStroke);
                graphics2D.setPaint(itemOutlinePaint);
                graphics2D.draw(double1);
            }
        }
        final CategoryItemLabelGenerator itemLabelGenerator = this.getItemLabelGenerator(n, n2);
        if (itemLabelGenerator != null && this.isItemLabelVisible(n, n2)) {
            this.drawItemLabel(graphics2D, categoryDataset, n, n2, categoryPlot, itemLabelGenerator, double1, doubleValue < 0.0);
        }
        final EntityCollection entityCollection = categoryItemRendererState.getEntityCollection();
        if (entityCollection != null) {
            this.addItemEntity(entityCollection, categoryDataset, n, n2, double1);
        }
    }
    
    protected double calculateSeriesWidth(final double n, final CategoryAxis categoryAxis, final int n2, final int n3) {
        double n4 = 1.0 - this.getItemMargin() - categoryAxis.getLowerMargin() - categoryAxis.getUpperMargin();
        if (n2 > 1) {
            n4 -= categoryAxis.getCategoryMargin();
        }
        return n * n4 / (n2 * n3);
    }
    
    protected void drawItemLabel(final Graphics2D graphics2D, final CategoryDataset categoryDataset, final int n, final int n2, final CategoryPlot categoryPlot, final CategoryItemLabelGenerator categoryItemLabelGenerator, final Rectangle2D rectangle2D, final boolean b) {
        final String generateLabel = categoryItemLabelGenerator.generateLabel(categoryDataset, n, n2);
        if (generateLabel == null) {
            return;
        }
        graphics2D.setFont(this.getItemLabelFont(n, n2));
        graphics2D.setPaint(this.getItemLabelPaint(n, n2));
        ItemLabelPosition itemLabelPosition;
        if (!b) {
            itemLabelPosition = this.getPositiveItemLabelPosition(n, n2);
        }
        else {
            itemLabelPosition = this.getNegativeItemLabelPosition(n, n2);
        }
        Point2D point2D = this.calculateLabelAnchorPoint(itemLabelPosition.getItemLabelAnchor(), rectangle2D, categoryPlot.getOrientation());
        if (this.isInternalAnchor(itemLabelPosition.getItemLabelAnchor())) {
            final Shape calculateRotatedStringBounds = TextUtilities.calculateRotatedStringBounds(generateLabel, graphics2D, (float)point2D.getX(), (float)point2D.getY(), itemLabelPosition.getTextAnchor(), itemLabelPosition.getAngle(), itemLabelPosition.getRotationAnchor());
            if (calculateRotatedStringBounds != null && !rectangle2D.contains(calculateRotatedStringBounds.getBounds2D())) {
                if (!b) {
                    itemLabelPosition = this.getPositiveItemLabelPositionFallback();
                }
                else {
                    itemLabelPosition = this.getNegativeItemLabelPositionFallback();
                }
                if (itemLabelPosition != null) {
                    point2D = this.calculateLabelAnchorPoint(itemLabelPosition.getItemLabelAnchor(), rectangle2D, categoryPlot.getOrientation());
                }
            }
        }
        if (itemLabelPosition != null) {
            TextUtilities.drawRotatedString(generateLabel, graphics2D, (float)point2D.getX(), (float)point2D.getY(), itemLabelPosition.getTextAnchor(), itemLabelPosition.getAngle(), itemLabelPosition.getRotationAnchor());
        }
    }
    
    private Point2D calculateLabelAnchorPoint(final ItemLabelAnchor itemLabelAnchor, final Rectangle2D rectangle2D, final PlotOrientation plotOrientation) {
        Point2D point2D = null;
        final double itemLabelAnchorOffset = this.getItemLabelAnchorOffset();
        final double n = rectangle2D.getX() - itemLabelAnchorOffset;
        final double x = rectangle2D.getX();
        final double n2 = rectangle2D.getX() + itemLabelAnchorOffset;
        final double centerX = rectangle2D.getCenterX();
        final double n3 = rectangle2D.getMaxX() - itemLabelAnchorOffset;
        final double maxX = rectangle2D.getMaxX();
        final double n4 = rectangle2D.getMaxX() + itemLabelAnchorOffset;
        final double n5 = rectangle2D.getMaxY() + itemLabelAnchorOffset;
        final double maxY = rectangle2D.getMaxY();
        final double n6 = rectangle2D.getMaxY() - itemLabelAnchorOffset;
        final double centerY = rectangle2D.getCenterY();
        final double n7 = rectangle2D.getMinY() + itemLabelAnchorOffset;
        final double minY = rectangle2D.getMinY();
        final double n8 = rectangle2D.getMinY() - itemLabelAnchorOffset;
        if (itemLabelAnchor == ItemLabelAnchor.CENTER) {
            point2D = new Point2D.Double(centerX, centerY);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE1) {
            point2D = new Point2D.Double(n3, n7);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE2) {
            point2D = new Point2D.Double(n3, n7);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE3) {
            point2D = new Point2D.Double(n3, centerY);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE4) {
            point2D = new Point2D.Double(n3, n6);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE5) {
            point2D = new Point2D.Double(n3, n6);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE6) {
            point2D = new Point2D.Double(centerX, n6);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE7) {
            point2D = new Point2D.Double(n2, n6);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE8) {
            point2D = new Point2D.Double(n2, n6);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE9) {
            point2D = new Point2D.Double(n2, centerY);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE10) {
            point2D = new Point2D.Double(n2, n7);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE11) {
            point2D = new Point2D.Double(n2, n7);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.INSIDE12) {
            point2D = new Point2D.Double(centerX, n7);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE1) {
            point2D = new Point2D.Double(maxX, n8);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE2) {
            point2D = new Point2D.Double(n4, minY);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE3) {
            point2D = new Point2D.Double(n4, centerY);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE4) {
            point2D = new Point2D.Double(n4, maxY);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE5) {
            point2D = new Point2D.Double(maxX, n5);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE6) {
            point2D = new Point2D.Double(centerX, n5);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE7) {
            point2D = new Point2D.Double(x, n5);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE8) {
            point2D = new Point2D.Double(n, maxY);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE9) {
            point2D = new Point2D.Double(n, centerY);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE10) {
            point2D = new Point2D.Double(n, minY);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE11) {
            point2D = new Point2D.Double(x, n8);
        }
        else if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE12) {
            point2D = new Point2D.Double(centerX, n8);
        }
        return point2D;
    }
    
    private boolean isInternalAnchor(final ItemLabelAnchor itemLabelAnchor) {
        return itemLabelAnchor == ItemLabelAnchor.CENTER || itemLabelAnchor == ItemLabelAnchor.INSIDE1 || itemLabelAnchor == ItemLabelAnchor.INSIDE2 || itemLabelAnchor == ItemLabelAnchor.INSIDE3 || itemLabelAnchor == ItemLabelAnchor.INSIDE4 || itemLabelAnchor == ItemLabelAnchor.INSIDE5 || itemLabelAnchor == ItemLabelAnchor.INSIDE6 || itemLabelAnchor == ItemLabelAnchor.INSIDE7 || itemLabelAnchor == ItemLabelAnchor.INSIDE8 || itemLabelAnchor == ItemLabelAnchor.INSIDE9 || itemLabelAnchor == ItemLabelAnchor.INSIDE10 || itemLabelAnchor == ItemLabelAnchor.INSIDE11 || itemLabelAnchor == ItemLabelAnchor.INSIDE12;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BarRenderer)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final BarRenderer barRenderer = (BarRenderer)o;
        return this.base == barRenderer.base && this.itemMargin == barRenderer.itemMargin && this.drawBarOutline == barRenderer.drawBarOutline && this.maximumBarWidth == barRenderer.maximumBarWidth && this.minimumBarLength == barRenderer.minimumBarLength && ObjectUtilities.equal(this.gradientPaintTransformer, barRenderer.gradientPaintTransformer) && ObjectUtilities.equal(this.positiveItemLabelPositionFallback, barRenderer.positiveItemLabelPositionFallback) && ObjectUtilities.equal(this.negativeItemLabelPositionFallback, barRenderer.negativeItemLabelPositionFallback);
    }
}
