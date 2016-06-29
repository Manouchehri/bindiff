/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.CategoryAnchor;
import org.jfree.chart.axis.CategoryLabelPosition;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.CategoryLabelWidthType;
import org.jfree.chart.axis.CategoryTick;
import org.jfree.chart.entity.CategoryLabelEntity;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.AxisChangeEvent;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.io.SerialUtilities;
import org.jfree.text.G2TextMeasurer;
import org.jfree.text.TextBlock;
import org.jfree.text.TextBlockAnchor;
import org.jfree.text.TextUtilities;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.Size2D;
import org.jfree.ui.TextAnchor;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;
import org.jfree.util.ShapeUtilities;

public class CategoryAxis
extends Axis
implements Serializable,
Cloneable {
    private static final long serialVersionUID = 5886554608114265863L;
    public static final double DEFAULT_AXIS_MARGIN = 0.05;
    public static final double DEFAULT_CATEGORY_MARGIN = 0.2;
    private double lowerMargin = 0.05;
    private double upperMargin = 0.05;
    private double categoryMargin = 0.2;
    private int maximumCategoryLabelLines = 1;
    private float maximumCategoryLabelWidthRatio = 0.0f;
    private int categoryLabelPositionOffset;
    private CategoryLabelPositions categoryLabelPositions;
    private Map tickLabelFontMap;
    private transient Map tickLabelPaintMap;
    private Map categoryLabelToolTips;

    public CategoryAxis() {
        this(null);
    }

    public CategoryAxis(String string) {
        super(string);
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

    public void setLowerMargin(double d2) {
        this.lowerMargin = d2;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public double getUpperMargin() {
        return this.upperMargin;
    }

    public void setUpperMargin(double d2) {
        this.upperMargin = d2;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public double getCategoryMargin() {
        return this.categoryMargin;
    }

    public void setCategoryMargin(double d2) {
        this.categoryMargin = d2;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public int getMaximumCategoryLabelLines() {
        return this.maximumCategoryLabelLines;
    }

    public void setMaximumCategoryLabelLines(int n2) {
        this.maximumCategoryLabelLines = n2;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public float getMaximumCategoryLabelWidthRatio() {
        return this.maximumCategoryLabelWidthRatio;
    }

    public void setMaximumCategoryLabelWidthRatio(float f2) {
        this.maximumCategoryLabelWidthRatio = f2;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public int getCategoryLabelPositionOffset() {
        return this.categoryLabelPositionOffset;
    }

    public void setCategoryLabelPositionOffset(int n2) {
        this.categoryLabelPositionOffset = n2;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public CategoryLabelPositions getCategoryLabelPositions() {
        return this.categoryLabelPositions;
    }

    public void setCategoryLabelPositions(CategoryLabelPositions categoryLabelPositions) {
        if (categoryLabelPositions == null) {
            throw new IllegalArgumentException("Null 'positions' argument.");
        }
        this.categoryLabelPositions = categoryLabelPositions;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public Font getTickLabelFont(Comparable comparable) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'category' argument.");
        }
        Font font = (Font)this.tickLabelFontMap.get(comparable);
        if (font != null) return font;
        return this.getTickLabelFont();
    }

    public void setTickLabelFont(Comparable comparable, Font font) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'category' argument.");
        }
        if (font == null) {
            this.tickLabelFontMap.remove(comparable);
        } else {
            this.tickLabelFontMap.put(comparable, font);
        }
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public Paint getTickLabelPaint(Comparable comparable) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'category' argument.");
        }
        Paint paint = (Paint)this.tickLabelPaintMap.get(comparable);
        if (paint != null) return paint;
        return this.getTickLabelPaint();
    }

    public void setTickLabelPaint(Comparable comparable, Paint paint) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'category' argument.");
        }
        if (paint == null) {
            this.tickLabelPaintMap.remove(comparable);
        } else {
            this.tickLabelPaintMap.put(comparable, paint);
        }
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public void addCategoryLabelToolTip(Comparable comparable, String string) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'category' argument.");
        }
        this.categoryLabelToolTips.put(comparable, string);
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public String getCategoryLabelToolTip(Comparable comparable) {
        if (comparable != null) return (String)this.categoryLabelToolTips.get(comparable);
        throw new IllegalArgumentException("Null 'category' argument.");
    }

    public void removeCategoryLabelToolTip(Comparable comparable) {
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

    public double getCategoryJava2DCoordinate(CategoryAnchor categoryAnchor, int n2, int n3, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        double d2 = 0.0;
        if (categoryAnchor == CategoryAnchor.START) {
            return this.getCategoryStart(n2, n3, rectangle2D, rectangleEdge);
        }
        if (categoryAnchor == CategoryAnchor.MIDDLE) {
            return this.getCategoryMiddle(n2, n3, rectangle2D, rectangleEdge);
        }
        if (categoryAnchor != CategoryAnchor.END) return d2;
        return this.getCategoryEnd(n2, n3, rectangle2D, rectangleEdge);
    }

    public double getCategoryStart(int n2, int n3, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        double d2 = 0.0;
        if (rectangleEdge == RectangleEdge.TOP || rectangleEdge == RectangleEdge.BOTTOM) {
            d2 = rectangle2D.getX() + rectangle2D.getWidth() * this.getLowerMargin();
        } else if (rectangleEdge == RectangleEdge.LEFT || rectangleEdge == RectangleEdge.RIGHT) {
            d2 = rectangle2D.getMinY() + rectangle2D.getHeight() * this.getLowerMargin();
        }
        double d3 = this.calculateCategorySize(n3, rectangle2D, rectangleEdge);
        double d4 = this.calculateCategoryGapSize(n3, rectangle2D, rectangleEdge);
        return d2 += (double)n2 * (d3 + d4);
    }

    public double getCategoryMiddle(int n2, int n3, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        return this.getCategoryStart(n2, n3, rectangle2D, rectangleEdge) + this.calculateCategorySize(n3, rectangle2D, rectangleEdge) / 2.0;
    }

    public double getCategoryEnd(int n2, int n3, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        return this.getCategoryStart(n2, n3, rectangle2D, rectangleEdge) + this.calculateCategorySize(n3, rectangle2D, rectangleEdge);
    }

    protected double calculateCategorySize(int n2, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        double d2 = 0.0;
        double d3 = 0.0;
        if (rectangleEdge == RectangleEdge.TOP || rectangleEdge == RectangleEdge.BOTTOM) {
            d3 = rectangle2D.getWidth();
        } else if (rectangleEdge == RectangleEdge.LEFT || rectangleEdge == RectangleEdge.RIGHT) {
            d3 = rectangle2D.getHeight();
        }
        if (n2 <= 1) return d3 * (1.0 - this.getLowerMargin() - this.getUpperMargin());
        d2 = d3 * (1.0 - this.getLowerMargin() - this.getUpperMargin() - this.getCategoryMargin());
        return d2 /= (double)n2;
    }

    protected double calculateCategoryGapSize(int n2, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        double d2 = 0.0;
        double d3 = 0.0;
        if (rectangleEdge == RectangleEdge.TOP || rectangleEdge == RectangleEdge.BOTTOM) {
            d3 = rectangle2D.getWidth();
        } else if (rectangleEdge == RectangleEdge.LEFT || rectangleEdge == RectangleEdge.RIGHT) {
            d3 = rectangle2D.getHeight();
        }
        if (n2 <= 1) return d2;
        return d3 * this.getCategoryMargin() / (double)(n2 - 1);
    }

    @Override
    public AxisSpace reserveSpace(Graphics2D graphics2D, Plot plot, Rectangle2D rectangle2D, RectangleEdge rectangleEdge, AxisSpace axisSpace) {
        Object object;
        if (axisSpace == null) {
            axisSpace = new AxisSpace();
        }
        if (!this.isVisible()) {
            return axisSpace;
        }
        double d2 = 0.0;
        double d3 = 0.0;
        if (this.isTickLabelsVisible()) {
            graphics2D.setFont(this.getTickLabelFont());
            object = new AxisState();
            this.refreshTicks(graphics2D, (AxisState)object, rectangle2D, rectangleEdge);
            if (rectangleEdge == RectangleEdge.TOP) {
                d2 = object.getMax();
            } else if (rectangleEdge == RectangleEdge.BOTTOM) {
                d2 = object.getMax();
            } else if (rectangleEdge == RectangleEdge.LEFT) {
                d3 = object.getMax();
            } else if (rectangleEdge == RectangleEdge.RIGHT) {
                d3 = object.getMax();
            }
        }
        object = this.getLabelEnclosure(graphics2D, rectangleEdge);
        double d4 = 0.0;
        double d5 = 0.0;
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            d4 = object.getHeight();
            axisSpace.add(d4 + d2 + (double)this.categoryLabelPositionOffset, rectangleEdge);
            return axisSpace;
        }
        if (!RectangleEdge.isLeftOrRight(rectangleEdge)) return axisSpace;
        d5 = object.getWidth();
        axisSpace.add(d5 + d3 + (double)this.categoryLabelPositionOffset, rectangleEdge);
        return axisSpace;
    }

    @Override
    public void configure() {
    }

    @Override
    public AxisState draw(Graphics2D graphics2D, double d2, Rectangle2D rectangle2D, Rectangle2D rectangle2D2, RectangleEdge rectangleEdge, PlotRenderingInfo plotRenderingInfo) {
        if (!this.isVisible()) {
            return new AxisState(d2);
        }
        if (this.isAxisLineVisible()) {
            this.drawAxisLine(graphics2D, d2, rectangle2D2, rectangleEdge);
        }
        AxisState axisState = new AxisState(d2);
        axisState = this.drawCategoryLabels(graphics2D, rectangle2D, rectangle2D2, rectangleEdge, axisState, plotRenderingInfo);
        return this.drawLabel(this.getLabel(), graphics2D, rectangle2D, rectangle2D2, rectangleEdge, axisState);
    }

    protected AxisState drawCategoryLabels(Graphics2D graphics2D, Rectangle2D rectangle2D, RectangleEdge rectangleEdge, AxisState axisState, PlotRenderingInfo plotRenderingInfo) {
        return this.drawCategoryLabels(graphics2D, rectangle2D, rectangle2D, rectangleEdge, axisState, plotRenderingInfo);
    }

    protected AxisState drawCategoryLabels(Graphics2D graphics2D, Rectangle2D rectangle2D, Rectangle2D rectangle2D2, RectangleEdge rectangleEdge, AxisState axisState, PlotRenderingInfo plotRenderingInfo) {
        if (axisState == null) {
            throw new IllegalArgumentException("Null 'state' argument.");
        }
        if (!this.isTickLabelsVisible()) return axisState;
        List list = this.refreshTicks(graphics2D, axisState, rectangle2D, rectangleEdge);
        axisState.setTicks(list);
        int n2 = 0;
        for (CategoryTick categoryTick : list) {
            EntityCollection entityCollection;
            graphics2D.setFont(this.getTickLabelFont(categoryTick.getCategory()));
            graphics2D.setPaint(this.getTickLabelPaint(categoryTick.getCategory()));
            CategoryLabelPosition categoryLabelPosition = this.categoryLabelPositions.getLabelPosition(rectangleEdge);
            double d2 = 0.0;
            double d3 = 0.0;
            double d4 = 0.0;
            double d5 = 0.0;
            if (rectangleEdge == RectangleEdge.TOP) {
                d2 = this.getCategoryStart(n2, list.size(), rectangle2D2, rectangleEdge);
                d3 = this.getCategoryEnd(n2, list.size(), rectangle2D2, rectangleEdge);
                d5 = axisState.getCursor() - (double)this.categoryLabelPositionOffset;
                d4 = d5 - axisState.getMax();
            } else if (rectangleEdge == RectangleEdge.BOTTOM) {
                d2 = this.getCategoryStart(n2, list.size(), rectangle2D2, rectangleEdge);
                d3 = this.getCategoryEnd(n2, list.size(), rectangle2D2, rectangleEdge);
                d4 = axisState.getCursor() + (double)this.categoryLabelPositionOffset;
                d5 = d4 + axisState.getMax();
            } else if (rectangleEdge == RectangleEdge.LEFT) {
                d4 = this.getCategoryStart(n2, list.size(), rectangle2D2, rectangleEdge);
                d5 = this.getCategoryEnd(n2, list.size(), rectangle2D2, rectangleEdge);
                d3 = axisState.getCursor() - (double)this.categoryLabelPositionOffset;
                d2 = d3 - axisState.getMax();
            } else if (rectangleEdge == RectangleEdge.RIGHT) {
                d4 = this.getCategoryStart(n2, list.size(), rectangle2D2, rectangleEdge);
                d5 = this.getCategoryEnd(n2, list.size(), rectangle2D2, rectangleEdge);
                d2 = axisState.getCursor() + (double)this.categoryLabelPositionOffset;
                d3 = d2 - axisState.getMax();
            }
            Rectangle2D.Double double_ = new Rectangle2D.Double(d2, d4, d3 - d2, d5 - d4);
            Point2D point2D = RectangleAnchor.coordinates(double_, categoryLabelPosition.getCategoryAnchor());
            TextBlock textBlock = categoryTick.getLabel();
            textBlock.draw(graphics2D, (float)point2D.getX(), (float)point2D.getY(), categoryLabelPosition.getLabelAnchor(), (float)point2D.getX(), (float)point2D.getY(), categoryLabelPosition.getAngle());
            Shape shape = textBlock.calculateBounds(graphics2D, (float)point2D.getX(), (float)point2D.getY(), categoryLabelPosition.getLabelAnchor(), (float)point2D.getX(), (float)point2D.getY(), categoryLabelPosition.getAngle());
            if (plotRenderingInfo != null && plotRenderingInfo.getOwner() != null && (entityCollection = plotRenderingInfo.getOwner().getEntityCollection()) != null) {
                String string = this.getCategoryLabelToolTip(categoryTick.getCategory());
                entityCollection.add(new CategoryLabelEntity(categoryTick.getCategory(), shape, string, null));
            }
            ++n2;
        }
        if (rectangleEdge.equals(RectangleEdge.TOP)) {
            double d6 = axisState.getMax() + (double)this.categoryLabelPositionOffset;
            axisState.cursorUp(d6);
            return axisState;
        }
        if (rectangleEdge.equals(RectangleEdge.BOTTOM)) {
            double d7 = axisState.getMax() + (double)this.categoryLabelPositionOffset;
            axisState.cursorDown(d7);
            return axisState;
        }
        if (rectangleEdge == RectangleEdge.LEFT) {
            double d8 = axisState.getMax() + (double)this.categoryLabelPositionOffset;
            axisState.cursorLeft(d8);
            return axisState;
        }
        if (rectangleEdge != RectangleEdge.RIGHT) return axisState;
        double d9 = axisState.getMax() + (double)this.categoryLabelPositionOffset;
        axisState.cursorRight(d9);
        return axisState;
    }

    @Override
    public List refreshTicks(Graphics2D graphics2D, AxisState axisState, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        ArrayList<CategoryTick> arrayList = new ArrayList<CategoryTick>();
        if (rectangle2D.getHeight() <= 0.0) return arrayList;
        if (rectangle2D.getWidth() < 0.0) {
            return arrayList;
        }
        CategoryPlot categoryPlot = (CategoryPlot)this.getPlot();
        List list = categoryPlot.getCategoriesForAxis(this);
        double d2 = 0.0;
        if (list != null) {
            CategoryLabelPosition categoryLabelPosition = this.categoryLabelPositions.getLabelPosition(rectangleEdge);
            float f2 = this.maximumCategoryLabelWidthRatio;
            if ((double)f2 <= 0.0) {
                f2 = categoryLabelPosition.getWidthRatio();
            }
            float f3 = 0.0f;
            f3 = categoryLabelPosition.getWidthType() == CategoryLabelWidthType.CATEGORY ? (float)this.calculateCategorySize(list.size(), rectangle2D, rectangleEdge) : (RectangleEdge.isLeftOrRight(rectangleEdge) ? (float)rectangle2D.getWidth() : (float)rectangle2D.getHeight());
            int n2 = 0;
            for (Comparable comparable : list) {
                TextBlock textBlock = this.createLabel(comparable, f3 * f2, rectangleEdge, graphics2D);
                if (rectangleEdge == RectangleEdge.TOP || rectangleEdge == RectangleEdge.BOTTOM) {
                    d2 = Math.max(d2, this.calculateTextBlockHeight(textBlock, categoryLabelPosition, graphics2D));
                } else if (rectangleEdge == RectangleEdge.LEFT || rectangleEdge == RectangleEdge.RIGHT) {
                    d2 = Math.max(d2, this.calculateTextBlockWidth(textBlock, categoryLabelPosition, graphics2D));
                }
                CategoryTick categoryTick = new CategoryTick(comparable, textBlock, categoryLabelPosition.getLabelAnchor(), categoryLabelPosition.getRotationAnchor(), categoryLabelPosition.getAngle());
                arrayList.add(categoryTick);
                ++n2;
            }
        }
        axisState.setMax(d2);
        return arrayList;
    }

    protected TextBlock createLabel(Comparable comparable, float f2, RectangleEdge rectangleEdge, Graphics2D graphics2D) {
        return TextUtilities.createTextBlock(comparable.toString(), this.getTickLabelFont(comparable), this.getTickLabelPaint(comparable), f2, this.maximumCategoryLabelLines, new G2TextMeasurer(graphics2D));
    }

    protected double calculateTextBlockWidth(TextBlock textBlock, CategoryLabelPosition categoryLabelPosition, Graphics2D graphics2D) {
        RectangleInsets rectangleInsets = this.getTickLabelInsets();
        Size2D size2D = textBlock.calculateDimensions(graphics2D);
        Rectangle2D.Double double_ = new Rectangle2D.Double(0.0, 0.0, size2D.getWidth(), size2D.getHeight());
        Shape shape = ShapeUtilities.rotateShape(double_, categoryLabelPosition.getAngle(), 0.0f, 0.0f);
        return shape.getBounds2D().getWidth() + rectangleInsets.getTop() + rectangleInsets.getBottom();
    }

    protected double calculateTextBlockHeight(TextBlock textBlock, CategoryLabelPosition categoryLabelPosition, Graphics2D graphics2D) {
        RectangleInsets rectangleInsets = this.getTickLabelInsets();
        Size2D size2D = textBlock.calculateDimensions(graphics2D);
        Rectangle2D.Double double_ = new Rectangle2D.Double(0.0, 0.0, size2D.getWidth(), size2D.getHeight());
        Shape shape = ShapeUtilities.rotateShape(double_, categoryLabelPosition.getAngle(), 0.0f, 0.0f);
        return shape.getBounds2D().getHeight() + rectangleInsets.getTop() + rectangleInsets.getBottom();
    }

    @Override
    public Object clone() {
        CategoryAxis categoryAxis = (CategoryAxis)super.clone();
        categoryAxis.tickLabelFontMap = new HashMap(this.tickLabelFontMap);
        categoryAxis.tickLabelPaintMap = new HashMap(this.tickLabelPaintMap);
        categoryAxis.categoryLabelToolTips = new HashMap(this.categoryLabelToolTips);
        return categoryAxis;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof CategoryAxis)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        CategoryAxis categoryAxis = (CategoryAxis)object;
        if (categoryAxis.lowerMargin != this.lowerMargin) {
            return false;
        }
        if (categoryAxis.upperMargin != this.upperMargin) {
            return false;
        }
        if (categoryAxis.categoryMargin != this.categoryMargin) {
            return false;
        }
        if (categoryAxis.maximumCategoryLabelWidthRatio != this.maximumCategoryLabelWidthRatio) {
            return false;
        }
        if (categoryAxis.categoryLabelPositionOffset != this.categoryLabelPositionOffset) {
            return false;
        }
        if (!ObjectUtilities.equal(categoryAxis.categoryLabelPositions, this.categoryLabelPositions)) {
            return false;
        }
        if (!ObjectUtilities.equal(categoryAxis.categoryLabelToolTips, this.categoryLabelToolTips)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.tickLabelFontMap, categoryAxis.tickLabelFontMap)) {
            return false;
        }
        if (this.equalPaintMaps(this.tickLabelPaintMap, categoryAxis.tickLabelPaintMap)) return true;
        return false;
    }

    public int hashCode() {
        if (this.getLabel() == null) return 0;
        return this.getLabel().hashCode();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        this.writePaintMap(this.tickLabelPaintMap, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.tickLabelPaintMap = this.readPaintMap(objectInputStream);
    }

    private Map readPaintMap(ObjectInputStream objectInputStream) {
        boolean bl2 = objectInputStream.readBoolean();
        if (bl2) {
            return null;
        }
        HashMap<Comparable, Paint> hashMap = new HashMap<Comparable, Paint>();
        int n2 = objectInputStream.readInt();
        int n3 = 0;
        while (n3 < n2) {
            Comparable comparable = (Comparable)objectInputStream.readObject();
            Paint paint = SerialUtilities.readPaint(objectInputStream);
            hashMap.put(comparable, paint);
            ++n3;
        }
        return hashMap;
    }

    private void writePaintMap(Map map, ObjectOutputStream objectOutputStream) {
        if (map == null) {
            objectOutputStream.writeBoolean(true);
            return;
        }
        objectOutputStream.writeBoolean(false);
        Set set = map.keySet();
        int n2 = set.size();
        objectOutputStream.writeInt(n2);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Comparable comparable = (Comparable)iterator.next();
            objectOutputStream.writeObject(comparable);
            SerialUtilities.writePaint((Paint)map.get(comparable), objectOutputStream);
        }
    }

    private boolean equalPaintMaps(Map map, Map map2) {
        Paint paint;
        Comparable comparable;
        Paint paint2;
        if (map.size() != map2.size()) {
            return false;
        }
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        do {
            if (!iterator.hasNext()) return true;
        } while (PaintUtilities.equal(paint2 = (Paint)map.get(comparable = (Comparable)iterator.next()), paint = (Paint)map2.get(comparable)));
        return false;
    }
}

