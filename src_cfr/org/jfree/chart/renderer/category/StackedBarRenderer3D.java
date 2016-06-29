/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.category;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.data.DataUtilities;
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.BooleanUtilities;
import org.jfree.util.PublicCloneable;

public class StackedBarRenderer3D
extends BarRenderer3D
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = -5832945916493247123L;
    private boolean renderAsPercentages;

    public StackedBarRenderer3D() {
        this(false);
    }

    public StackedBarRenderer3D(double d2, double d3) {
        super(d2, d3);
    }

    public StackedBarRenderer3D(boolean bl2) {
        this.renderAsPercentages = bl2;
    }

    public StackedBarRenderer3D(double d2, double d3, boolean bl2) {
        super(d2, d3);
        this.renderAsPercentages = bl2;
    }

    public boolean getRenderAsPercentages() {
        return this.renderAsPercentages;
    }

    public void setRenderAsPercentages(boolean bl2) {
        this.renderAsPercentages = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public Range findRangeBounds(CategoryDataset categoryDataset) {
        if (!this.renderAsPercentages) return DatasetUtilities.findStackedRangeBounds(categoryDataset);
        return new Range(0.0, 1.0);
    }

    @Override
    protected void calculateBarWidth(CategoryPlot categoryPlot, Rectangle2D rectangle2D, int n2, CategoryItemRendererState categoryItemRendererState) {
        CategoryAxis categoryAxis = this.getDomainAxis(categoryPlot, n2);
        CategoryDataset categoryDataset = categoryPlot.getDataset(n2);
        if (categoryDataset == null) return;
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        double d2 = 0.0;
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            d2 = rectangle2D.getHeight();
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            d2 = rectangle2D.getWidth();
        }
        double d3 = d2 * this.getMaximumBarWidth();
        int n3 = categoryDataset.getColumnCount();
        double d4 = 0.0;
        if (n3 > 1) {
            d4 = categoryAxis.getCategoryMargin();
        }
        double d5 = d2 * (1.0 - categoryAxis.getLowerMargin() - categoryAxis.getUpperMargin() - d4);
        if (n3 > 0) {
            categoryItemRendererState.setBarWidth(Math.min(d5 / (double)n3, d3));
            return;
        }
        categoryItemRendererState.setBarWidth(Math.min(d5, d3));
    }

    protected static List createStackedValueList(CategoryDataset categoryDataset, Comparable comparable, double d2, boolean bl2) {
        ArrayList<Object[]> arrayList = new ArrayList<Object[]>();
        double d3 = d2;
        double d4 = d2;
        double d5 = 0.0;
        if (bl2) {
            d5 = DataUtilities.calculateColumnTotal(categoryDataset, categoryDataset.getColumnIndex(comparable));
        }
        int n2 = -1;
        int n3 = categoryDataset.getRowCount();
        int n4 = 0;
        while (n4 < n3) {
            Number number = categoryDataset.getValue(categoryDataset.getRowKey(n4), comparable);
            if (number != null) {
                double d6 = number.doubleValue();
                if (bl2) {
                    d6 /= d5;
                }
                if (d6 >= 0.0) {
                    if (n2 < 0) {
                        arrayList.add(new Object[]{null, new Double(d2)});
                        n2 = 0;
                    }
                    arrayList.add(new Object[]{new Integer(n4), new Double(d3 += d6)});
                } else if (d6 < 0.0) {
                    if (n2 < 0) {
                        arrayList.add(new Object[]{null, new Double(d2)});
                        n2 = 0;
                    }
                    arrayList.add(0, new Object[]{new Integer(- n4), new Double(d4 += d6)});
                    ++n2;
                }
            }
            ++n4;
        }
        return arrayList;
    }

    @Override
    public void drawItem(Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, CategoryDataset categoryDataset, int n2, int n3, int n4) {
        if (n2 < categoryDataset.getRowCount() - 1) {
            return;
        }
        Comparable comparable = categoryDataset.getColumnKey(n3);
        List list = StackedBarRenderer3D.createStackedValueList(categoryDataset, categoryDataset.getColumnKey(n3), this.getBase(), this.renderAsPercentages);
        Rectangle2D.Double double_ = new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY() + this.getYOffset(), rectangle2D.getWidth() - this.getXOffset(), rectangle2D.getHeight() - this.getYOffset());
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            this.drawStackHorizontal(list, comparable, graphics2D, categoryItemRendererState, double_, categoryPlot, categoryAxis, valueAxis, categoryDataset);
            return;
        }
        this.drawStackVertical(list, comparable, graphics2D, categoryItemRendererState, double_, categoryPlot, categoryAxis, valueAxis, categoryDataset);
    }

    protected void drawStackHorizontal(List list, Comparable comparable, Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, CategoryDataset categoryDataset) {
        int n2;
        Object object;
        int n3;
        int n4 = categoryDataset.getColumnIndex(comparable);
        double d2 = categoryAxis.getCategoryMiddle(n4, categoryDataset.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge()) - categoryItemRendererState.getBarWidth() / 2.0;
        double d3 = categoryItemRendererState.getBarWidth();
        ArrayList<Object[]> arrayList = new ArrayList<Object[]>();
        boolean bl2 = valueAxis.isInverted();
        int n5 = list.size() - 1;
        for (n3 = 0; n3 < n5; ++n3) {
            int n6 = bl2 ? n5 - n3 - 1 : n3;
            Object[] arrobject = (Object[])list.get(n6);
            object = (Object[])list.get(n6 + 1);
            n2 = 0;
            if (object[0] == null) {
                n2 = - ((Integer)arrobject[0]).intValue();
            } else {
                n2 = (Integer)object[0];
                if (n2 < 0) {
                    n2 = - ((Integer)arrobject[0]).intValue();
                }
            }
            double d4 = (Double)arrobject[1];
            double d5 = valueAxis.valueToJava2D(d4, rectangle2D, categoryPlot.getRangeAxisEdge());
            double d6 = (Double)object[1];
            double d7 = valueAxis.valueToJava2D(d6, rectangle2D, categoryPlot.getRangeAxisEdge());
            Shape[] arrshape = this.createHorizontalBlock(d2, d3, d5, d7, bl2);
            Paint paint = this.getItemPaint(n2, n4);
            Paint paint2 = this.getItemOutlinePaint(n2, n4);
            graphics2D.setStroke(this.getItemOutlineStroke(n2, n4));
            for (int i2 = 0; i2 < 6; ++i2) {
                graphics2D.setPaint(paint);
                graphics2D.fill(arrshape[i2]);
                graphics2D.setPaint(paint2);
                graphics2D.draw(arrshape[i2]);
            }
            Object[] arrobject2 = new Object[3];
            arrobject2[0] = new Integer(n2);
            arrobject2[1] = arrshape[5].getBounds2D();
            arrobject2[2] = BooleanUtilities.valueOf(d4 < this.getBase());
            arrayList.add(arrobject2);
            EntityCollection entityCollection = categoryItemRendererState.getEntityCollection();
            if (entityCollection == null) continue;
            this.addItemEntity(entityCollection, categoryDataset, n2, n4, arrshape[5]);
        }
        n3 = 0;
        while (n3 < arrayList.size()) {
            Object[] arrobject = (Object[])arrayList.get(n3);
            int n7 = (Integer)arrobject[0];
            object = (Rectangle2D)arrobject[1];
            n2 = ((Boolean)arrobject[2]).booleanValue();
            CategoryItemLabelGenerator categoryItemLabelGenerator = this.getItemLabelGenerator(n7, n4);
            if (categoryItemLabelGenerator != null && this.isItemLabelVisible(n7, n4)) {
                this.drawItemLabel(graphics2D, categoryDataset, n7, n4, categoryPlot, categoryItemLabelGenerator, (Rectangle2D)object, (boolean)n2);
            }
            ++n3;
        }
    }

    private Shape[] createHorizontalBlock(double d2, double d3, double d4, double d5, boolean bl2) {
        Shape[] arrshape = new Shape[6];
        Point2D.Double double_ = new Point2D.Double(d4, d2);
        Point2D.Double double_2 = new Point2D.Double(d4, d2 + d3);
        Point2D.Double double_3 = new Point2D.Double(double_2.getX() + this.getXOffset(), double_2.getY() - this.getYOffset());
        Point2D.Double double_4 = new Point2D.Double(double_.getX() + this.getXOffset(), double_.getY() - this.getYOffset());
        Point2D.Double double_5 = new Point2D.Double(d5, d2);
        Point2D.Double double_6 = new Point2D.Double(d5, d2 + d3);
        Point2D.Double double_7 = new Point2D.Double(double_6.getX() + this.getXOffset(), double_6.getY() - this.getYOffset());
        Point2D.Double double_8 = new Point2D.Double(double_5.getX() + this.getXOffset(), double_5.getY() - this.getYOffset());
        GeneralPath generalPath = new GeneralPath();
        generalPath.moveTo((float)double_6.getX(), (float)double_6.getY());
        generalPath.lineTo((float)double_2.getX(), (float)double_2.getY());
        generalPath.lineTo((float)double_3.getX(), (float)double_3.getY());
        generalPath.lineTo((float)double_7.getX(), (float)double_7.getY());
        generalPath.closePath();
        GeneralPath generalPath2 = new GeneralPath();
        generalPath2.moveTo((float)double_5.getX(), (float)double_5.getY());
        generalPath2.lineTo((float)double_.getX(), (float)double_.getY());
        generalPath2.lineTo((float)double_4.getX(), (float)double_4.getY());
        generalPath2.lineTo((float)double_8.getX(), (float)double_8.getY());
        generalPath2.closePath();
        GeneralPath generalPath3 = new GeneralPath();
        generalPath3.moveTo((float)double_7.getX(), (float)double_7.getY());
        generalPath3.lineTo((float)double_3.getX(), (float)double_3.getY());
        generalPath3.lineTo((float)double_4.getX(), (float)double_4.getY());
        generalPath3.lineTo((float)double_8.getX(), (float)double_8.getY());
        generalPath3.closePath();
        GeneralPath generalPath4 = new GeneralPath();
        generalPath4.moveTo((float)double_5.getX(), (float)double_5.getY());
        generalPath4.lineTo((float)double_6.getX(), (float)double_6.getY());
        generalPath4.lineTo((float)double_2.getX(), (float)double_2.getY());
        generalPath4.lineTo((float)double_.getX(), (float)double_.getY());
        generalPath4.closePath();
        GeneralPath generalPath5 = new GeneralPath();
        generalPath5.moveTo((float)double_5.getX(), (float)double_5.getY());
        generalPath5.lineTo((float)double_6.getX(), (float)double_6.getY());
        generalPath5.lineTo((float)double_7.getX(), (float)double_7.getY());
        generalPath5.lineTo((float)double_8.getX(), (float)double_8.getY());
        generalPath5.closePath();
        GeneralPath generalPath6 = new GeneralPath();
        generalPath6.moveTo((float)double_.getX(), (float)double_.getY());
        generalPath6.lineTo((float)double_2.getX(), (float)double_2.getY());
        generalPath6.lineTo((float)double_3.getX(), (float)double_3.getY());
        generalPath6.lineTo((float)double_4.getX(), (float)double_4.getY());
        generalPath6.closePath();
        arrshape[0] = generalPath;
        arrshape[1] = generalPath3;
        if (bl2) {
            arrshape[2] = generalPath6;
            arrshape[3] = generalPath5;
        } else {
            arrshape[2] = generalPath5;
            arrshape[3] = generalPath6;
        }
        arrshape[4] = generalPath2;
        arrshape[5] = generalPath4;
        return arrshape;
    }

    protected void drawStackVertical(List list, Comparable comparable, Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, CategoryDataset categoryDataset) {
        int n2;
        Object object;
        int n3;
        int n4 = categoryDataset.getColumnIndex(comparable);
        double d2 = categoryAxis.getCategoryMiddle(n4, categoryDataset.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge()) - categoryItemRendererState.getBarWidth() / 2.0;
        double d3 = categoryItemRendererState.getBarWidth();
        ArrayList<Object[]> arrayList = new ArrayList<Object[]>();
        boolean bl2 = valueAxis.isInverted();
        int n5 = list.size() - 1;
        for (n3 = 0; n3 < n5; ++n3) {
            int n6 = bl2 ? n5 - n3 - 1 : n3;
            Object[] arrobject = (Object[])list.get(n6);
            object = (Object[])list.get(n6 + 1);
            n2 = 0;
            if (object[0] == null) {
                n2 = - ((Integer)arrobject[0]).intValue();
            } else {
                n2 = (Integer)object[0];
                if (n2 < 0) {
                    n2 = - ((Integer)arrobject[0]).intValue();
                }
            }
            double d4 = (Double)arrobject[1];
            double d5 = valueAxis.valueToJava2D(d4, rectangle2D, categoryPlot.getRangeAxisEdge());
            double d6 = (Double)object[1];
            double d7 = valueAxis.valueToJava2D(d6, rectangle2D, categoryPlot.getRangeAxisEdge());
            Shape[] arrshape = this.createVerticalBlock(d2, d3, d5, d7, bl2);
            Paint paint = this.getItemPaint(n2, n4);
            Paint paint2 = this.getItemOutlinePaint(n2, n4);
            graphics2D.setStroke(this.getItemOutlineStroke(n2, n4));
            for (int i2 = 0; i2 < 6; ++i2) {
                graphics2D.setPaint(paint);
                graphics2D.fill(arrshape[i2]);
                graphics2D.setPaint(paint2);
                graphics2D.draw(arrshape[i2]);
            }
            Object[] arrobject2 = new Object[3];
            arrobject2[0] = new Integer(n2);
            arrobject2[1] = arrshape[5].getBounds2D();
            arrobject2[2] = BooleanUtilities.valueOf(d4 < this.getBase());
            arrayList.add(arrobject2);
            EntityCollection entityCollection = categoryItemRendererState.getEntityCollection();
            if (entityCollection == null) continue;
            this.addItemEntity(entityCollection, categoryDataset, n2, n4, arrshape[5]);
        }
        n3 = 0;
        while (n3 < arrayList.size()) {
            Object[] arrobject = (Object[])arrayList.get(n3);
            int n7 = (Integer)arrobject[0];
            object = (Rectangle2D)arrobject[1];
            n2 = ((Boolean)arrobject[2]).booleanValue();
            CategoryItemLabelGenerator categoryItemLabelGenerator = this.getItemLabelGenerator(n7, n4);
            if (categoryItemLabelGenerator != null && this.isItemLabelVisible(n7, n4)) {
                this.drawItemLabel(graphics2D, categoryDataset, n7, n4, categoryPlot, categoryItemLabelGenerator, (Rectangle2D)object, (boolean)n2);
            }
            ++n3;
        }
    }

    private Shape[] createVerticalBlock(double d2, double d3, double d4, double d5, boolean bl2) {
        Shape[] arrshape = new Shape[6];
        Point2D.Double double_ = new Point2D.Double(d2, d4);
        Point2D.Double double_2 = new Point2D.Double(d2 + d3, d4);
        Point2D.Double double_3 = new Point2D.Double(double_2.getX() + this.getXOffset(), double_2.getY() - this.getYOffset());
        Point2D.Double double_4 = new Point2D.Double(double_.getX() + this.getXOffset(), double_.getY() - this.getYOffset());
        Point2D.Double double_5 = new Point2D.Double(d2, d5);
        Point2D.Double double_6 = new Point2D.Double(d2 + d3, d5);
        Point2D.Double double_7 = new Point2D.Double(double_6.getX() + this.getXOffset(), double_6.getY() - this.getYOffset());
        Point2D.Double double_8 = new Point2D.Double(double_5.getX() + this.getXOffset(), double_5.getY() - this.getYOffset());
        GeneralPath generalPath = new GeneralPath();
        generalPath.moveTo((float)double_6.getX(), (float)double_6.getY());
        generalPath.lineTo((float)double_2.getX(), (float)double_2.getY());
        generalPath.lineTo((float)double_3.getX(), (float)double_3.getY());
        generalPath.lineTo((float)double_7.getX(), (float)double_7.getY());
        generalPath.closePath();
        GeneralPath generalPath2 = new GeneralPath();
        generalPath2.moveTo((float)double_5.getX(), (float)double_5.getY());
        generalPath2.lineTo((float)double_.getX(), (float)double_.getY());
        generalPath2.lineTo((float)double_4.getX(), (float)double_4.getY());
        generalPath2.lineTo((float)double_8.getX(), (float)double_8.getY());
        generalPath2.closePath();
        GeneralPath generalPath3 = new GeneralPath();
        generalPath3.moveTo((float)double_7.getX(), (float)double_7.getY());
        generalPath3.lineTo((float)double_3.getX(), (float)double_3.getY());
        generalPath3.lineTo((float)double_4.getX(), (float)double_4.getY());
        generalPath3.lineTo((float)double_8.getX(), (float)double_8.getY());
        generalPath3.closePath();
        GeneralPath generalPath4 = new GeneralPath();
        generalPath4.moveTo((float)double_5.getX(), (float)double_5.getY());
        generalPath4.lineTo((float)double_6.getX(), (float)double_6.getY());
        generalPath4.lineTo((float)double_2.getX(), (float)double_2.getY());
        generalPath4.lineTo((float)double_.getX(), (float)double_.getY());
        generalPath4.closePath();
        GeneralPath generalPath5 = new GeneralPath();
        generalPath5.moveTo((float)double_5.getX(), (float)double_5.getY());
        generalPath5.lineTo((float)double_6.getX(), (float)double_6.getY());
        generalPath5.lineTo((float)double_7.getX(), (float)double_7.getY());
        generalPath5.lineTo((float)double_8.getX(), (float)double_8.getY());
        generalPath5.closePath();
        GeneralPath generalPath6 = new GeneralPath();
        generalPath6.moveTo((float)double_.getX(), (float)double_.getY());
        generalPath6.lineTo((float)double_2.getX(), (float)double_2.getY());
        generalPath6.lineTo((float)double_3.getX(), (float)double_3.getY());
        generalPath6.lineTo((float)double_4.getX(), (float)double_4.getY());
        generalPath6.closePath();
        arrshape[0] = generalPath6;
        arrshape[1] = generalPath3;
        arrshape[2] = generalPath2;
        arrshape[3] = generalPath;
        arrshape[4] = generalPath5;
        arrshape[5] = generalPath4;
        if (!bl2) return arrshape;
        arrshape[0] = generalPath5;
        arrshape[4] = generalPath6;
        return arrshape;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof StackedBarRenderer3D)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        StackedBarRenderer3D stackedBarRenderer3D = (StackedBarRenderer3D)object;
        if (this.renderAsPercentages == stackedBarRenderer3D.getRenderAsPercentages()) return true;
        return false;
    }
}

