package org.jfree.chart.axis;

import org.jfree.chart.event.*;
import java.awt.geom.*;
import java.awt.*;
import org.jfree.chart.entity.*;
import org.jfree.chart.plot.*;
import org.jfree.text.*;
import org.jfree.ui.*;
import java.io.*;
import org.jfree.io.*;
import java.util.*;
import org.jfree.util.*;

public class CategoryAxis extends Axis implements Serializable, Cloneable
{
    private static final long serialVersionUID = 5886554608114265863L;
    public static final double DEFAULT_AXIS_MARGIN = 0.05;
    public static final double DEFAULT_CATEGORY_MARGIN = 0.2;
    private double lowerMargin;
    private double upperMargin;
    private double categoryMargin;
    private int maximumCategoryLabelLines;
    private float maximumCategoryLabelWidthRatio;
    private int categoryLabelPositionOffset;
    private CategoryLabelPositions categoryLabelPositions;
    private Map tickLabelFontMap;
    private transient Map tickLabelPaintMap;
    private Map categoryLabelToolTips;
    
    public CategoryAxis() {
        this(null);
    }
    
    public CategoryAxis(final String s) {
        super(s);
        this.lowerMargin = 0.05;
        this.upperMargin = 0.05;
        this.categoryMargin = 0.2;
        this.maximumCategoryLabelLines = 1;
        this.maximumCategoryLabelWidthRatio = 0.0f;
        this.setTickMarksVisible(false);
        this.categoryLabelPositionOffset = 4;
        this.categoryLabelPositions = CategoryLabelPositions.STANDARD;
        this.tickLabelFontMap = new HashMap();
        this.tickLabelPaintMap = new HashMap();
        this.categoryLabelToolTips = new HashMap();
    }
    
    public double getLowerMargin() {
        return this.lowerMargin;
    }
    
    public void setLowerMargin(final double lowerMargin) {
        this.lowerMargin = lowerMargin;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public double getUpperMargin() {
        return this.upperMargin;
    }
    
    public void setUpperMargin(final double upperMargin) {
        this.upperMargin = upperMargin;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public double getCategoryMargin() {
        return this.categoryMargin;
    }
    
    public void setCategoryMargin(final double categoryMargin) {
        this.categoryMargin = categoryMargin;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public int getMaximumCategoryLabelLines() {
        return this.maximumCategoryLabelLines;
    }
    
    public void setMaximumCategoryLabelLines(final int maximumCategoryLabelLines) {
        this.maximumCategoryLabelLines = maximumCategoryLabelLines;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public float getMaximumCategoryLabelWidthRatio() {
        return this.maximumCategoryLabelWidthRatio;
    }
    
    public void setMaximumCategoryLabelWidthRatio(final float maximumCategoryLabelWidthRatio) {
        this.maximumCategoryLabelWidthRatio = maximumCategoryLabelWidthRatio;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public int getCategoryLabelPositionOffset() {
        return this.categoryLabelPositionOffset;
    }
    
    public void setCategoryLabelPositionOffset(final int categoryLabelPositionOffset) {
        this.categoryLabelPositionOffset = categoryLabelPositionOffset;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public CategoryLabelPositions getCategoryLabelPositions() {
        return this.categoryLabelPositions;
    }
    
    public void setCategoryLabelPositions(final CategoryLabelPositions categoryLabelPositions) {
        if (categoryLabelPositions == null) {
            throw new IllegalArgumentException("Null 'positions' argument.");
        }
        this.categoryLabelPositions = categoryLabelPositions;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public Font getTickLabelFont(final Comparable comparable) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'category' argument.");
        }
        Font tickLabelFont = this.tickLabelFontMap.get(comparable);
        if (tickLabelFont == null) {
            tickLabelFont = this.getTickLabelFont();
        }
        return tickLabelFont;
    }
    
    public void setTickLabelFont(final Comparable comparable, final Font font) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'category' argument.");
        }
        if (font == null) {
            this.tickLabelFontMap.remove(comparable);
        }
        else {
            this.tickLabelFontMap.put(comparable, font);
        }
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public Paint getTickLabelPaint(final Comparable comparable) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'category' argument.");
        }
        Paint tickLabelPaint = this.tickLabelPaintMap.get(comparable);
        if (tickLabelPaint == null) {
            tickLabelPaint = this.getTickLabelPaint();
        }
        return tickLabelPaint;
    }
    
    public void setTickLabelPaint(final Comparable comparable, final Paint paint) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'category' argument.");
        }
        if (paint == null) {
            this.tickLabelPaintMap.remove(comparable);
        }
        else {
            this.tickLabelPaintMap.put(comparable, paint);
        }
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public void addCategoryLabelToolTip(final Comparable comparable, final String s) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'category' argument.");
        }
        this.categoryLabelToolTips.put(comparable, s);
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public String getCategoryLabelToolTip(final Comparable comparable) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'category' argument.");
        }
        return this.categoryLabelToolTips.get(comparable);
    }
    
    public void removeCategoryLabelToolTip(final Comparable comparable) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'category' argument.");
        }
        this.categoryLabelToolTips.remove(comparable);
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public void clearCategoryLabelToolTips() {
        this.categoryLabelToolTips.clear();
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public double getCategoryJava2DCoordinate(final CategoryAnchor categoryAnchor, final int n, final int n2, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        double n3 = 0.0;
        if (categoryAnchor == CategoryAnchor.START) {
            n3 = this.getCategoryStart(n, n2, rectangle2D, rectangleEdge);
        }
        else if (categoryAnchor == CategoryAnchor.MIDDLE) {
            n3 = this.getCategoryMiddle(n, n2, rectangle2D, rectangleEdge);
        }
        else if (categoryAnchor == CategoryAnchor.END) {
            n3 = this.getCategoryEnd(n, n2, rectangle2D, rectangleEdge);
        }
        return n3;
    }
    
    public double getCategoryStart(final int n, final int n2, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        double n3 = 0.0;
        if (rectangleEdge == RectangleEdge.TOP || rectangleEdge == RectangleEdge.BOTTOM) {
            n3 = rectangle2D.getX() + rectangle2D.getWidth() * this.getLowerMargin();
        }
        else if (rectangleEdge == RectangleEdge.LEFT || rectangleEdge == RectangleEdge.RIGHT) {
            n3 = rectangle2D.getMinY() + rectangle2D.getHeight() * this.getLowerMargin();
        }
        return n3 + n * (this.calculateCategorySize(n2, rectangle2D, rectangleEdge) + this.calculateCategoryGapSize(n2, rectangle2D, rectangleEdge));
    }
    
    public double getCategoryMiddle(final int n, final int n2, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        return this.getCategoryStart(n, n2, rectangle2D, rectangleEdge) + this.calculateCategorySize(n2, rectangle2D, rectangleEdge) / 2.0;
    }
    
    public double getCategoryEnd(final int n, final int n2, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        return this.getCategoryStart(n, n2, rectangle2D, rectangleEdge) + this.calculateCategorySize(n2, rectangle2D, rectangleEdge);
    }
    
    protected double calculateCategorySize(final int n, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        double n2 = 0.0;
        if (rectangleEdge == RectangleEdge.TOP || rectangleEdge == RectangleEdge.BOTTOM) {
            n2 = rectangle2D.getWidth();
        }
        else if (rectangleEdge == RectangleEdge.LEFT || rectangleEdge == RectangleEdge.RIGHT) {
            n2 = rectangle2D.getHeight();
        }
        double n3;
        if (n > 1) {
            n3 = n2 * (1.0 - this.getLowerMargin() - this.getUpperMargin() - this.getCategoryMargin()) / n;
        }
        else {
            n3 = n2 * (1.0 - this.getLowerMargin() - this.getUpperMargin());
        }
        return n3;
    }
    
    protected double calculateCategoryGapSize(final int n, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        double n2 = 0.0;
        double n3 = 0.0;
        if (rectangleEdge == RectangleEdge.TOP || rectangleEdge == RectangleEdge.BOTTOM) {
            n3 = rectangle2D.getWidth();
        }
        else if (rectangleEdge == RectangleEdge.LEFT || rectangleEdge == RectangleEdge.RIGHT) {
            n3 = rectangle2D.getHeight();
        }
        if (n > 1) {
            n2 = n3 * this.getCategoryMargin() / (n - 1);
        }
        return n2;
    }
    
    public AxisSpace reserveSpace(final Graphics2D graphics2D, final Plot plot, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge, AxisSpace axisSpace) {
        if (axisSpace == null) {
            axisSpace = new AxisSpace();
        }
        if (!this.isVisible()) {
            return axisSpace;
        }
        double n = 0.0;
        double n2 = 0.0;
        if (this.isTickLabelsVisible()) {
            graphics2D.setFont(this.getTickLabelFont());
            final AxisState axisState = new AxisState();
            this.refreshTicks(graphics2D, axisState, rectangle2D, rectangleEdge);
            if (rectangleEdge == RectangleEdge.TOP) {
                n = axisState.getMax();
            }
            else if (rectangleEdge == RectangleEdge.BOTTOM) {
                n = axisState.getMax();
            }
            else if (rectangleEdge == RectangleEdge.LEFT) {
                n2 = axisState.getMax();
            }
            else if (rectangleEdge == RectangleEdge.RIGHT) {
                n2 = axisState.getMax();
            }
        }
        final Rectangle2D labelEnclosure = this.getLabelEnclosure(graphics2D, rectangleEdge);
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            axisSpace.add(labelEnclosure.getHeight() + n + this.categoryLabelPositionOffset, rectangleEdge);
        }
        else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            axisSpace.add(labelEnclosure.getWidth() + n2 + this.categoryLabelPositionOffset, rectangleEdge);
        }
        return axisSpace;
    }
    
    public void configure() {
    }
    
    public AxisState draw(final Graphics2D graphics2D, final double n, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final RectangleEdge rectangleEdge, final PlotRenderingInfo plotRenderingInfo) {
        if (!this.isVisible()) {
            return new AxisState(n);
        }
        if (this.isAxisLineVisible()) {
            this.drawAxisLine(graphics2D, n, rectangle2D2, rectangleEdge);
        }
        return this.drawLabel(this.getLabel(), graphics2D, rectangle2D, rectangle2D2, rectangleEdge, this.drawCategoryLabels(graphics2D, rectangle2D, rectangle2D2, rectangleEdge, new AxisState(n), plotRenderingInfo));
    }
    
    protected AxisState drawCategoryLabels(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge, final AxisState axisState, final PlotRenderingInfo plotRenderingInfo) {
        return this.drawCategoryLabels(graphics2D, rectangle2D, rectangle2D, rectangleEdge, axisState, plotRenderingInfo);
    }
    
    protected AxisState drawCategoryLabels(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final RectangleEdge rectangleEdge, final AxisState axisState, final PlotRenderingInfo plotRenderingInfo) {
        if (axisState == null) {
            throw new IllegalArgumentException("Null 'state' argument.");
        }
        if (this.isTickLabelsVisible()) {
            final List refreshTicks = this.refreshTicks(graphics2D, axisState, rectangle2D, rectangleEdge);
            axisState.setTicks(refreshTicks);
            int n = 0;
            for (final CategoryTick categoryTick : refreshTicks) {
                graphics2D.setFont(this.getTickLabelFont(categoryTick.getCategory()));
                graphics2D.setPaint(this.getTickLabelPaint(categoryTick.getCategory()));
                final CategoryLabelPosition labelPosition = this.categoryLabelPositions.getLabelPosition(rectangleEdge);
                double n2 = 0.0;
                double n3 = 0.0;
                double n4 = 0.0;
                double n5 = 0.0;
                if (rectangleEdge == RectangleEdge.TOP) {
                    n2 = this.getCategoryStart(n, refreshTicks.size(), rectangle2D2, rectangleEdge);
                    n3 = this.getCategoryEnd(n, refreshTicks.size(), rectangle2D2, rectangleEdge);
                    n5 = axisState.getCursor() - this.categoryLabelPositionOffset;
                    n4 = n5 - axisState.getMax();
                }
                else if (rectangleEdge == RectangleEdge.BOTTOM) {
                    n2 = this.getCategoryStart(n, refreshTicks.size(), rectangle2D2, rectangleEdge);
                    n3 = this.getCategoryEnd(n, refreshTicks.size(), rectangle2D2, rectangleEdge);
                    n4 = axisState.getCursor() + this.categoryLabelPositionOffset;
                    n5 = n4 + axisState.getMax();
                }
                else if (rectangleEdge == RectangleEdge.LEFT) {
                    n4 = this.getCategoryStart(n, refreshTicks.size(), rectangle2D2, rectangleEdge);
                    n5 = this.getCategoryEnd(n, refreshTicks.size(), rectangle2D2, rectangleEdge);
                    n3 = axisState.getCursor() - this.categoryLabelPositionOffset;
                    n2 = n3 - axisState.getMax();
                }
                else if (rectangleEdge == RectangleEdge.RIGHT) {
                    n4 = this.getCategoryStart(n, refreshTicks.size(), rectangle2D2, rectangleEdge);
                    n5 = this.getCategoryEnd(n, refreshTicks.size(), rectangle2D2, rectangleEdge);
                    n2 = axisState.getCursor() + this.categoryLabelPositionOffset;
                    n3 = n2 - axisState.getMax();
                }
                final Point2D coordinates = RectangleAnchor.coordinates(new Rectangle2D.Double(n2, n4, n3 - n2, n5 - n4), labelPosition.getCategoryAnchor());
                final TextBlock label = categoryTick.getLabel();
                label.draw(graphics2D, (float)coordinates.getX(), (float)coordinates.getY(), labelPosition.getLabelAnchor(), (float)coordinates.getX(), (float)coordinates.getY(), labelPosition.getAngle());
                final Shape calculateBounds = label.calculateBounds(graphics2D, (float)coordinates.getX(), (float)coordinates.getY(), labelPosition.getLabelAnchor(), (float)coordinates.getX(), (float)coordinates.getY(), labelPosition.getAngle());
                if (plotRenderingInfo != null && plotRenderingInfo.getOwner() != null) {
                    final EntityCollection entityCollection = plotRenderingInfo.getOwner().getEntityCollection();
                    if (entityCollection != null) {
                        entityCollection.add(new CategoryLabelEntity(categoryTick.getCategory(), calculateBounds, this.getCategoryLabelToolTip(categoryTick.getCategory()), null));
                    }
                }
                ++n;
            }
            if (rectangleEdge.equals(RectangleEdge.TOP)) {
                axisState.cursorUp(axisState.getMax() + this.categoryLabelPositionOffset);
            }
            else if (rectangleEdge.equals(RectangleEdge.BOTTOM)) {
                axisState.cursorDown(axisState.getMax() + this.categoryLabelPositionOffset);
            }
            else if (rectangleEdge == RectangleEdge.LEFT) {
                axisState.cursorLeft(axisState.getMax() + this.categoryLabelPositionOffset);
            }
            else if (rectangleEdge == RectangleEdge.RIGHT) {
                axisState.cursorRight(axisState.getMax() + this.categoryLabelPositionOffset);
            }
        }
        return axisState;
    }
    
    public List refreshTicks(final Graphics2D graphics2D, final AxisState axisState, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        final ArrayList<CategoryTick> list = new ArrayList<CategoryTick>();
        if (rectangle2D.getHeight() <= 0.0 || rectangle2D.getWidth() < 0.0) {
            return list;
        }
        final List categoriesForAxis = ((CategoryPlot)this.getPlot()).getCategoriesForAxis(this);
        double max = 0.0;
        if (categoriesForAxis != null) {
            final CategoryLabelPosition labelPosition = this.categoryLabelPositions.getLabelPosition(rectangleEdge);
            float n = this.maximumCategoryLabelWidthRatio;
            if (n <= 0.0) {
                n = labelPosition.getWidthRatio();
            }
            float n2;
            if (labelPosition.getWidthType() == CategoryLabelWidthType.CATEGORY) {
                n2 = (float)this.calculateCategorySize(categoriesForAxis.size(), rectangle2D, rectangleEdge);
            }
            else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
                n2 = (float)rectangle2D.getWidth();
            }
            else {
                n2 = (float)rectangle2D.getHeight();
            }
            int n3 = 0;
            for (final Comparable comparable : categoriesForAxis) {
                final TextBlock label = this.createLabel(comparable, n2 * n, rectangleEdge, graphics2D);
                if (rectangleEdge == RectangleEdge.TOP || rectangleEdge == RectangleEdge.BOTTOM) {
                    max = Math.max(max, this.calculateTextBlockHeight(label, labelPosition, graphics2D));
                }
                else if (rectangleEdge == RectangleEdge.LEFT || rectangleEdge == RectangleEdge.RIGHT) {
                    max = Math.max(max, this.calculateTextBlockWidth(label, labelPosition, graphics2D));
                }
                list.add(new CategoryTick(comparable, label, labelPosition.getLabelAnchor(), labelPosition.getRotationAnchor(), labelPosition.getAngle()));
                ++n3;
            }
        }
        axisState.setMax(max);
        return list;
    }
    
    protected TextBlock createLabel(final Comparable comparable, final float n, final RectangleEdge rectangleEdge, final Graphics2D graphics2D) {
        return TextUtilities.createTextBlock(comparable.toString(), this.getTickLabelFont(comparable), this.getTickLabelPaint(comparable), n, this.maximumCategoryLabelLines, new G2TextMeasurer(graphics2D));
    }
    
    protected double calculateTextBlockWidth(final TextBlock textBlock, final CategoryLabelPosition categoryLabelPosition, final Graphics2D graphics2D) {
        final RectangleInsets tickLabelInsets = this.getTickLabelInsets();
        final Size2D calculateDimensions = textBlock.calculateDimensions(graphics2D);
        return ShapeUtilities.rotateShape(new Rectangle2D.Double(0.0, 0.0, calculateDimensions.getWidth(), calculateDimensions.getHeight()), categoryLabelPosition.getAngle(), 0.0f, 0.0f).getBounds2D().getWidth() + tickLabelInsets.getTop() + tickLabelInsets.getBottom();
    }
    
    protected double calculateTextBlockHeight(final TextBlock textBlock, final CategoryLabelPosition categoryLabelPosition, final Graphics2D graphics2D) {
        final RectangleInsets tickLabelInsets = this.getTickLabelInsets();
        final Size2D calculateDimensions = textBlock.calculateDimensions(graphics2D);
        return ShapeUtilities.rotateShape(new Rectangle2D.Double(0.0, 0.0, calculateDimensions.getWidth(), calculateDimensions.getHeight()), categoryLabelPosition.getAngle(), 0.0f, 0.0f).getBounds2D().getHeight() + tickLabelInsets.getTop() + tickLabelInsets.getBottom();
    }
    
    public Object clone() {
        final CategoryAxis categoryAxis = (CategoryAxis)super.clone();
        categoryAxis.tickLabelFontMap = new HashMap(this.tickLabelFontMap);
        categoryAxis.tickLabelPaintMap = new HashMap(this.tickLabelPaintMap);
        categoryAxis.categoryLabelToolTips = new HashMap(this.categoryLabelToolTips);
        return categoryAxis;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CategoryAxis)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final CategoryAxis categoryAxis = (CategoryAxis)o;
        return categoryAxis.lowerMargin == this.lowerMargin && categoryAxis.upperMargin == this.upperMargin && categoryAxis.categoryMargin == this.categoryMargin && categoryAxis.maximumCategoryLabelWidthRatio == this.maximumCategoryLabelWidthRatio && categoryAxis.categoryLabelPositionOffset == this.categoryLabelPositionOffset && ObjectUtilities.equal(categoryAxis.categoryLabelPositions, this.categoryLabelPositions) && ObjectUtilities.equal(categoryAxis.categoryLabelToolTips, this.categoryLabelToolTips) && ObjectUtilities.equal(this.tickLabelFontMap, categoryAxis.tickLabelFontMap) && this.equalPaintMaps(this.tickLabelPaintMap, categoryAxis.tickLabelPaintMap);
    }
    
    public int hashCode() {
        if (this.getLabel() != null) {
            return this.getLabel().hashCode();
        }
        return 0;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        this.writePaintMap(this.tickLabelPaintMap, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.tickLabelPaintMap = this.readPaintMap(objectInputStream);
    }
    
    private Map readPaintMap(final ObjectInputStream objectInputStream) {
        if (objectInputStream.readBoolean()) {
            return null;
        }
        final HashMap<Comparable, Paint> hashMap = new HashMap<Comparable, Paint>();
        for (int int1 = objectInputStream.readInt(), i = 0; i < int1; ++i) {
            hashMap.put((Comparable)objectInputStream.readObject(), SerialUtilities.readPaint(objectInputStream));
        }
        return hashMap;
    }
    
    private void writePaintMap(final Map map, final ObjectOutputStream objectOutputStream) {
        if (map == null) {
            objectOutputStream.writeBoolean(true);
        }
        else {
            objectOutputStream.writeBoolean(false);
            final Set<Comparable> keySet = (Set<Comparable>)map.keySet();
            objectOutputStream.writeInt(keySet.size());
            for (final Comparable comparable : keySet) {
                objectOutputStream.writeObject(comparable);
                SerialUtilities.writePaint(map.get(comparable), objectOutputStream);
            }
        }
    }
    
    private boolean equalPaintMaps(final Map map, final Map map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (final Comparable comparable : map.keySet()) {
            if (!PaintUtilities.equal(map.get(comparable), map2.get(comparable))) {
                return false;
            }
        }
        return true;
    }
}
