package org.jfree.chart.renderer.category;

import java.io.*;
import org.jfree.chart.event.*;
import org.jfree.data.category.*;
import org.jfree.data.general.*;
import org.jfree.chart.plot.*;
import java.util.*;
import org.jfree.data.*;
import org.jfree.chart.axis.*;
import org.jfree.util.*;
import java.awt.*;
import org.jfree.chart.entity.*;
import org.jfree.chart.labels.*;
import java.awt.geom.*;

public class StackedBarRenderer3D extends BarRenderer3D implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = -5832945916493247123L;
    private boolean renderAsPercentages;
    
    public StackedBarRenderer3D() {
        this(false);
    }
    
    public StackedBarRenderer3D(final double n, final double n2) {
        super(n, n2);
    }
    
    public StackedBarRenderer3D(final boolean renderAsPercentages) {
        this.renderAsPercentages = renderAsPercentages;
    }
    
    public StackedBarRenderer3D(final double n, final double n2, final boolean renderAsPercentages) {
        super(n, n2);
        this.renderAsPercentages = renderAsPercentages;
    }
    
    public boolean getRenderAsPercentages() {
        return this.renderAsPercentages;
    }
    
    public void setRenderAsPercentages(final boolean renderAsPercentages) {
        this.renderAsPercentages = renderAsPercentages;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public Range findRangeBounds(final CategoryDataset categoryDataset) {
        if (this.renderAsPercentages) {
            return new Range(0.0, 1.0);
        }
        return DatasetUtilities.findStackedRangeBounds(categoryDataset);
    }
    
    protected void calculateBarWidth(final CategoryPlot categoryPlot, final Rectangle2D rectangle2D, final int n, final CategoryItemRendererState categoryItemRendererState) {
        final CategoryAxis domainAxis = this.getDomainAxis(categoryPlot, n);
        final CategoryDataset dataset = categoryPlot.getDataset(n);
        if (dataset != null) {
            final PlotOrientation orientation = categoryPlot.getOrientation();
            double n2 = 0.0;
            if (orientation == PlotOrientation.HORIZONTAL) {
                n2 = rectangle2D.getHeight();
            }
            else if (orientation == PlotOrientation.VERTICAL) {
                n2 = rectangle2D.getWidth();
            }
            final double n3 = n2 * this.getMaximumBarWidth();
            final int columnCount = dataset.getColumnCount();
            double categoryMargin = 0.0;
            if (columnCount > 1) {
                categoryMargin = domainAxis.getCategoryMargin();
            }
            final double n4 = n2 * (1.0 - domainAxis.getLowerMargin() - domainAxis.getUpperMargin() - categoryMargin);
            if (columnCount > 0) {
                categoryItemRendererState.setBarWidth(Math.min(n4 / columnCount, n3));
            }
            else {
                categoryItemRendererState.setBarWidth(Math.min(n4, n3));
            }
        }
    }
    
    protected static List createStackedValueList(final CategoryDataset categoryDataset, final Comparable comparable, final double n, final boolean b) {
        final ArrayList<Object[]> list = new ArrayList<Object[]>();
        double n2 = n;
        double n3 = n;
        double calculateColumnTotal = 0.0;
        if (b) {
            calculateColumnTotal = DataUtilities.calculateColumnTotal(categoryDataset, categoryDataset.getColumnIndex(comparable));
        }
        int n4 = -1;
        for (int rowCount = categoryDataset.getRowCount(), i = 0; i < rowCount; ++i) {
            final Number value = categoryDataset.getValue(categoryDataset.getRowKey(i), comparable);
            if (value != null) {
                double doubleValue = value.doubleValue();
                if (b) {
                    doubleValue /= calculateColumnTotal;
                }
                if (doubleValue >= 0.0) {
                    if (n4 < 0) {
                        list.add(new Object[] { null, new Double(n) });
                        n4 = 0;
                    }
                    n2 += doubleValue;
                    list.add(new Object[] { new Integer(i), new Double(n2) });
                }
                else if (doubleValue < 0.0) {
                    if (n4 < 0) {
                        list.add(new Object[] { null, new Double(n) });
                        n4 = 0;
                    }
                    n3 += doubleValue;
                    list.add(0, new Object[] { new Integer(-i), new Double(n3) });
                    ++n4;
                }
            }
        }
        return list;
    }
    
    public void drawItem(final Graphics2D graphics2D, final CategoryItemRendererState categoryItemRendererState, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final CategoryAxis categoryAxis, final ValueAxis valueAxis, final CategoryDataset categoryDataset, final int n, final int n2, final int n3) {
        if (n < categoryDataset.getRowCount() - 1) {
            return;
        }
        final Comparable columnKey = categoryDataset.getColumnKey(n2);
        final List stackedValueList = createStackedValueList(categoryDataset, categoryDataset.getColumnKey(n2), this.getBase(), this.renderAsPercentages);
        final Rectangle2D.Double double1 = new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY() + this.getYOffset(), rectangle2D.getWidth() - this.getXOffset(), rectangle2D.getHeight() - this.getYOffset());
        if (categoryPlot.getOrientation() == PlotOrientation.HORIZONTAL) {
            this.drawStackHorizontal(stackedValueList, columnKey, graphics2D, categoryItemRendererState, double1, categoryPlot, categoryAxis, valueAxis, categoryDataset);
        }
        else {
            this.drawStackVertical(stackedValueList, columnKey, graphics2D, categoryItemRendererState, double1, categoryPlot, categoryAxis, valueAxis, categoryDataset);
        }
    }
    
    protected void drawStackHorizontal(final List list, final Comparable comparable, final Graphics2D graphics2D, final CategoryItemRendererState categoryItemRendererState, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final CategoryAxis categoryAxis, final ValueAxis valueAxis, final CategoryDataset categoryDataset) {
        final int columnIndex = categoryDataset.getColumnIndex(comparable);
        final double n = categoryAxis.getCategoryMiddle(columnIndex, categoryDataset.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge()) - categoryItemRendererState.getBarWidth() / 2.0;
        final double barWidth = categoryItemRendererState.getBarWidth();
        final ArrayList list2 = new ArrayList<Object>();
        final boolean inverted = valueAxis.isInverted();
        for (int n2 = list.size() - 1, i = 0; i < n2; ++i) {
            final int n3 = inverted ? (n2 - i - 1) : i;
            final Object[] array = list.get(n3);
            final Object[] array2 = list.get(n3 + 1);
            int intValue;
            if (array2[0] == null) {
                intValue = -(int)array[0];
            }
            else {
                intValue = (int)array2[0];
                if (intValue < 0) {
                    intValue = -(int)array[0];
                }
            }
            final double doubleValue = (double)array[1];
            final Shape[] horizontalBlock = this.createHorizontalBlock(n, barWidth, valueAxis.valueToJava2D(doubleValue, rectangle2D, categoryPlot.getRangeAxisEdge()), valueAxis.valueToJava2D((double)array2[1], rectangle2D, categoryPlot.getRangeAxisEdge()), inverted);
            final Paint itemPaint = this.getItemPaint(intValue, columnIndex);
            final Paint itemOutlinePaint = this.getItemOutlinePaint(intValue, columnIndex);
            graphics2D.setStroke(this.getItemOutlineStroke(intValue, columnIndex));
            for (int j = 0; j < 6; ++j) {
                graphics2D.setPaint(itemPaint);
                graphics2D.fill(horizontalBlock[j]);
                graphics2D.setPaint(itemOutlinePaint);
                graphics2D.draw(horizontalBlock[j]);
            }
            list2.add(new Object[] { new Integer(intValue), horizontalBlock[5].getBounds2D(), BooleanUtilities.valueOf(doubleValue < this.getBase()) });
            final EntityCollection entityCollection = categoryItemRendererState.getEntityCollection();
            if (entityCollection != null) {
                this.addItemEntity(entityCollection, categoryDataset, intValue, columnIndex, horizontalBlock[5]);
            }
        }
        for (int k = 0; k < list2.size(); ++k) {
            final Object[] array3 = list2.get(k);
            final int intValue2 = (int)array3[0];
            final Rectangle2D rectangle2D2 = (Rectangle2D)array3[1];
            final boolean booleanValue = (boolean)array3[2];
            final CategoryItemLabelGenerator itemLabelGenerator = this.getItemLabelGenerator(intValue2, columnIndex);
            if (itemLabelGenerator != null && this.isItemLabelVisible(intValue2, columnIndex)) {
                this.drawItemLabel(graphics2D, categoryDataset, intValue2, columnIndex, categoryPlot, itemLabelGenerator, rectangle2D2, booleanValue);
            }
        }
    }
    
    private Shape[] createHorizontalBlock(final double n, final double n2, final double n3, final double n4, final boolean b) {
        final Shape[] array = new Shape[6];
        final Point2D.Double double1 = new Point2D.Double(n3, n);
        final Point2D.Double double2 = new Point2D.Double(n3, n + n2);
        final Point2D.Double double3 = new Point2D.Double(double2.getX() + this.getXOffset(), double2.getY() - this.getYOffset());
        final Point2D.Double double4 = new Point2D.Double(double1.getX() + this.getXOffset(), double1.getY() - this.getYOffset());
        final Point2D.Double double5 = new Point2D.Double(n4, n);
        final Point2D.Double double6 = new Point2D.Double(n4, n + n2);
        final Point2D.Double double7 = new Point2D.Double(double6.getX() + this.getXOffset(), double6.getY() - this.getYOffset());
        final Point2D.Double double8 = new Point2D.Double(double5.getX() + this.getXOffset(), double5.getY() - this.getYOffset());
        final GeneralPath generalPath = new GeneralPath();
        generalPath.moveTo((float)double6.getX(), (float)double6.getY());
        generalPath.lineTo((float)double2.getX(), (float)double2.getY());
        generalPath.lineTo((float)double3.getX(), (float)double3.getY());
        generalPath.lineTo((float)double7.getX(), (float)double7.getY());
        generalPath.closePath();
        final GeneralPath generalPath2 = new GeneralPath();
        generalPath2.moveTo((float)double5.getX(), (float)double5.getY());
        generalPath2.lineTo((float)double1.getX(), (float)double1.getY());
        generalPath2.lineTo((float)double4.getX(), (float)double4.getY());
        generalPath2.lineTo((float)double8.getX(), (float)double8.getY());
        generalPath2.closePath();
        final GeneralPath generalPath3 = new GeneralPath();
        generalPath3.moveTo((float)double7.getX(), (float)double7.getY());
        generalPath3.lineTo((float)double3.getX(), (float)double3.getY());
        generalPath3.lineTo((float)double4.getX(), (float)double4.getY());
        generalPath3.lineTo((float)double8.getX(), (float)double8.getY());
        generalPath3.closePath();
        final GeneralPath generalPath4 = new GeneralPath();
        generalPath4.moveTo((float)double5.getX(), (float)double5.getY());
        generalPath4.lineTo((float)double6.getX(), (float)double6.getY());
        generalPath4.lineTo((float)double2.getX(), (float)double2.getY());
        generalPath4.lineTo((float)double1.getX(), (float)double1.getY());
        generalPath4.closePath();
        final GeneralPath generalPath5 = new GeneralPath();
        generalPath5.moveTo((float)double5.getX(), (float)double5.getY());
        generalPath5.lineTo((float)double6.getX(), (float)double6.getY());
        generalPath5.lineTo((float)double7.getX(), (float)double7.getY());
        generalPath5.lineTo((float)double8.getX(), (float)double8.getY());
        generalPath5.closePath();
        final GeneralPath generalPath6 = new GeneralPath();
        generalPath6.moveTo((float)double1.getX(), (float)double1.getY());
        generalPath6.lineTo((float)double2.getX(), (float)double2.getY());
        generalPath6.lineTo((float)double3.getX(), (float)double3.getY());
        generalPath6.lineTo((float)double4.getX(), (float)double4.getY());
        generalPath6.closePath();
        array[0] = generalPath;
        array[1] = generalPath3;
        if (b) {
            array[2] = generalPath6;
            array[3] = generalPath5;
        }
        else {
            array[2] = generalPath5;
            array[3] = generalPath6;
        }
        array[4] = generalPath2;
        array[5] = generalPath4;
        return array;
    }
    
    protected void drawStackVertical(final List list, final Comparable comparable, final Graphics2D graphics2D, final CategoryItemRendererState categoryItemRendererState, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final CategoryAxis categoryAxis, final ValueAxis valueAxis, final CategoryDataset categoryDataset) {
        final int columnIndex = categoryDataset.getColumnIndex(comparable);
        final double n = categoryAxis.getCategoryMiddle(columnIndex, categoryDataset.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge()) - categoryItemRendererState.getBarWidth() / 2.0;
        final double barWidth = categoryItemRendererState.getBarWidth();
        final ArrayList list2 = new ArrayList<Object>();
        final boolean inverted = valueAxis.isInverted();
        for (int n2 = list.size() - 1, i = 0; i < n2; ++i) {
            final int n3 = inverted ? (n2 - i - 1) : i;
            final Object[] array = list.get(n3);
            final Object[] array2 = list.get(n3 + 1);
            int intValue;
            if (array2[0] == null) {
                intValue = -(int)array[0];
            }
            else {
                intValue = (int)array2[0];
                if (intValue < 0) {
                    intValue = -(int)array[0];
                }
            }
            final double doubleValue = (double)array[1];
            final Shape[] verticalBlock = this.createVerticalBlock(n, barWidth, valueAxis.valueToJava2D(doubleValue, rectangle2D, categoryPlot.getRangeAxisEdge()), valueAxis.valueToJava2D((double)array2[1], rectangle2D, categoryPlot.getRangeAxisEdge()), inverted);
            final Paint itemPaint = this.getItemPaint(intValue, columnIndex);
            final Paint itemOutlinePaint = this.getItemOutlinePaint(intValue, columnIndex);
            graphics2D.setStroke(this.getItemOutlineStroke(intValue, columnIndex));
            for (int j = 0; j < 6; ++j) {
                graphics2D.setPaint(itemPaint);
                graphics2D.fill(verticalBlock[j]);
                graphics2D.setPaint(itemOutlinePaint);
                graphics2D.draw(verticalBlock[j]);
            }
            list2.add(new Object[] { new Integer(intValue), verticalBlock[5].getBounds2D(), BooleanUtilities.valueOf(doubleValue < this.getBase()) });
            final EntityCollection entityCollection = categoryItemRendererState.getEntityCollection();
            if (entityCollection != null) {
                this.addItemEntity(entityCollection, categoryDataset, intValue, columnIndex, verticalBlock[5]);
            }
        }
        for (int k = 0; k < list2.size(); ++k) {
            final Object[] array3 = list2.get(k);
            final int intValue2 = (int)array3[0];
            final Rectangle2D rectangle2D2 = (Rectangle2D)array3[1];
            final boolean booleanValue = (boolean)array3[2];
            final CategoryItemLabelGenerator itemLabelGenerator = this.getItemLabelGenerator(intValue2, columnIndex);
            if (itemLabelGenerator != null && this.isItemLabelVisible(intValue2, columnIndex)) {
                this.drawItemLabel(graphics2D, categoryDataset, intValue2, columnIndex, categoryPlot, itemLabelGenerator, rectangle2D2, booleanValue);
            }
        }
    }
    
    private Shape[] createVerticalBlock(final double n, final double n2, final double n3, final double n4, final boolean b) {
        final Shape[] array = new Shape[6];
        final Point2D.Double double1 = new Point2D.Double(n, n3);
        final Point2D.Double double2 = new Point2D.Double(n + n2, n3);
        final Point2D.Double double3 = new Point2D.Double(double2.getX() + this.getXOffset(), double2.getY() - this.getYOffset());
        final Point2D.Double double4 = new Point2D.Double(double1.getX() + this.getXOffset(), double1.getY() - this.getYOffset());
        final Point2D.Double double5 = new Point2D.Double(n, n4);
        final Point2D.Double double6 = new Point2D.Double(n + n2, n4);
        final Point2D.Double double7 = new Point2D.Double(double6.getX() + this.getXOffset(), double6.getY() - this.getYOffset());
        final Point2D.Double double8 = new Point2D.Double(double5.getX() + this.getXOffset(), double5.getY() - this.getYOffset());
        final GeneralPath generalPath = new GeneralPath();
        generalPath.moveTo((float)double6.getX(), (float)double6.getY());
        generalPath.lineTo((float)double2.getX(), (float)double2.getY());
        generalPath.lineTo((float)double3.getX(), (float)double3.getY());
        generalPath.lineTo((float)double7.getX(), (float)double7.getY());
        generalPath.closePath();
        final GeneralPath generalPath2 = new GeneralPath();
        generalPath2.moveTo((float)double5.getX(), (float)double5.getY());
        generalPath2.lineTo((float)double1.getX(), (float)double1.getY());
        generalPath2.lineTo((float)double4.getX(), (float)double4.getY());
        generalPath2.lineTo((float)double8.getX(), (float)double8.getY());
        generalPath2.closePath();
        final GeneralPath generalPath3 = new GeneralPath();
        generalPath3.moveTo((float)double7.getX(), (float)double7.getY());
        generalPath3.lineTo((float)double3.getX(), (float)double3.getY());
        generalPath3.lineTo((float)double4.getX(), (float)double4.getY());
        generalPath3.lineTo((float)double8.getX(), (float)double8.getY());
        generalPath3.closePath();
        final GeneralPath generalPath4 = new GeneralPath();
        generalPath4.moveTo((float)double5.getX(), (float)double5.getY());
        generalPath4.lineTo((float)double6.getX(), (float)double6.getY());
        generalPath4.lineTo((float)double2.getX(), (float)double2.getY());
        generalPath4.lineTo((float)double1.getX(), (float)double1.getY());
        generalPath4.closePath();
        final GeneralPath generalPath5 = new GeneralPath();
        generalPath5.moveTo((float)double5.getX(), (float)double5.getY());
        generalPath5.lineTo((float)double6.getX(), (float)double6.getY());
        generalPath5.lineTo((float)double7.getX(), (float)double7.getY());
        generalPath5.lineTo((float)double8.getX(), (float)double8.getY());
        generalPath5.closePath();
        final GeneralPath generalPath6 = new GeneralPath();
        generalPath6.moveTo((float)double1.getX(), (float)double1.getY());
        generalPath6.lineTo((float)double2.getX(), (float)double2.getY());
        generalPath6.lineTo((float)double3.getX(), (float)double3.getY());
        generalPath6.lineTo((float)double4.getX(), (float)double4.getY());
        generalPath6.closePath();
        array[0] = generalPath6;
        array[1] = generalPath3;
        array[2] = generalPath2;
        array[3] = generalPath;
        array[4] = generalPath5;
        array[5] = generalPath4;
        if (b) {
            array[0] = generalPath5;
            array[4] = generalPath6;
        }
        return array;
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof StackedBarRenderer3D && super.equals(o) && this.renderAsPercentages == ((StackedBarRenderer3D)o).getRenderAsPercentages());
    }
}
