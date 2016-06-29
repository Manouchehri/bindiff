/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.category;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.chart.renderer.category.IntervalBarRenderer;
import org.jfree.chart.urls.CategoryURLGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.gantt.GanttCategoryDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PaintUtilities;

public class GanttRenderer
extends IntervalBarRenderer
implements Serializable {
    private static final long serialVersionUID = -4010349116350119512L;
    private transient Paint completePaint;
    private transient Paint incompletePaint;
    private double startPercent;
    private double endPercent;

    public GanttRenderer() {
        this.setIncludeBaseInRange(false);
        this.completePaint = Color.green;
        this.incompletePaint = Color.red;
        this.startPercent = 0.35;
        this.endPercent = 0.65;
    }

    public Paint getCompletePaint() {
        return this.completePaint;
    }

    public void setCompletePaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.completePaint = paint;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public Paint getIncompletePaint() {
        return this.incompletePaint;
    }

    public void setIncompletePaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.incompletePaint = paint;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public double getStartPercent() {
        return this.startPercent;
    }

    public void setStartPercent(double d2) {
        this.startPercent = d2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public double getEndPercent() {
        return this.endPercent;
    }

    public void setEndPercent(double d2) {
        this.endPercent = d2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public void drawItem(Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, CategoryDataset categoryDataset, int n2, int n3, int n4) {
        if (categoryDataset instanceof GanttCategoryDataset) {
            GanttCategoryDataset ganttCategoryDataset = (GanttCategoryDataset)categoryDataset;
            this.drawTasks(graphics2D, categoryItemRendererState, rectangle2D, categoryPlot, categoryAxis, valueAxis, ganttCategoryDataset, n2, n3);
            return;
        }
        super.drawItem(graphics2D, categoryItemRendererState, rectangle2D, categoryPlot, categoryAxis, valueAxis, categoryDataset, n2, n3, n4);
    }

    protected void drawTasks(Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, GanttCategoryDataset ganttCategoryDataset, int n2, int n3) {
        int n4 = ganttCategoryDataset.getSubIntervalCount(n2, n3);
        if (n4 == 0) {
            this.drawTask(graphics2D, categoryItemRendererState, rectangle2D, categoryPlot, categoryAxis, valueAxis, ganttCategoryDataset, n2, n3);
        }
        int n5 = 0;
        while (n5 < n4) {
            EntityCollection entityCollection;
            double d2;
            RectangleEdge rectangleEdge = categoryPlot.getRangeAxisEdge();
            Number number = ganttCategoryDataset.getStartValue(n2, n3, n5);
            if (number == null) {
                return;
            }
            double d3 = valueAxis.valueToJava2D(number.doubleValue(), rectangle2D, rectangleEdge);
            Number number2 = ganttCategoryDataset.getEndValue(n2, n3, n5);
            if (number2 == null) {
                return;
            }
            double d4 = valueAxis.valueToJava2D(number2.doubleValue(), rectangle2D, rectangleEdge);
            if (d4 < d3) {
                d2 = d4;
                d4 = d3;
                d3 = d2;
            }
            d2 = this.calculateBarW0(categoryPlot, categoryPlot.getOrientation(), rectangle2D, categoryAxis, categoryItemRendererState, n2, n3);
            double d5 = Math.abs(d4 - d3);
            double d6 = categoryItemRendererState.getBarWidth();
            Rectangle2D.Double double_ = null;
            if (categoryPlot.getOrientation() == PlotOrientation.HORIZONTAL) {
                double_ = new Rectangle2D.Double(d3, d2, d5, d6);
            } else if (categoryPlot.getOrientation() == PlotOrientation.VERTICAL) {
                double_ = new Rectangle2D.Double(d2, d3, d6, d5);
            }
            Rectangle2D.Double double_2 = null;
            Rectangle2D.Double double_3 = null;
            Number number3 = ganttCategoryDataset.getPercentComplete(n2, n3, n5);
            double d7 = this.getStartPercent();
            double d8 = this.getEndPercent();
            if (number3 != null) {
                double d9 = number3.doubleValue();
                if (categoryPlot.getOrientation() == PlotOrientation.HORIZONTAL) {
                    double_2 = new Rectangle2D.Double(d3, d2 + d7 * d6, d5 * d9, d6 * (d8 - d7));
                    double_3 = new Rectangle2D.Double(d3 + d5 * d9, d2 + d7 * d6, d5 * (1.0 - d9), d6 * (d8 - d7));
                } else if (categoryPlot.getOrientation() == PlotOrientation.VERTICAL) {
                    double_2 = new Rectangle2D.Double(d2 + d7 * d6, d3 + d5 * (1.0 - d9), d6 * (d8 - d7), d5 * d9);
                    double_3 = new Rectangle2D.Double(d2 + d7 * d6, d3, d6 * (d8 - d7), d5 * (1.0 - d9));
                }
            }
            Paint paint = this.getItemPaint(n2, n3);
            graphics2D.setPaint(paint);
            graphics2D.fill(double_);
            if (double_2 != null) {
                graphics2D.setPaint(this.getCompletePaint());
                graphics2D.fill(double_2);
            }
            if (double_3 != null) {
                graphics2D.setPaint(this.getIncompletePaint());
                graphics2D.fill(double_3);
            }
            if (this.isDrawBarOutline() && categoryItemRendererState.getBarWidth() > 3.0) {
                graphics2D.setStroke(this.getItemStroke(n2, n3));
                graphics2D.setPaint(this.getItemOutlinePaint(n2, n3));
                graphics2D.draw(double_);
            }
            if (categoryItemRendererState.getInfo() != null && (entityCollection = categoryItemRendererState.getEntityCollection()) != null) {
                String string = null;
                if (this.getToolTipGenerator(n2, n3) != null) {
                    string = this.getToolTipGenerator(n2, n3).generateToolTip(ganttCategoryDataset, n2, n3);
                }
                String string2 = null;
                if (this.getItemURLGenerator(n2, n3) != null) {
                    string2 = this.getItemURLGenerator(n2, n3).generateURL(ganttCategoryDataset, n2, n3);
                }
                CategoryItemEntity categoryItemEntity = new CategoryItemEntity(double_, string, string2, ganttCategoryDataset, n2, ganttCategoryDataset.getColumnKey(n3), n3);
                entityCollection.add(categoryItemEntity);
            }
            ++n5;
        }
    }

    protected void drawTask(Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, GanttCategoryDataset ganttCategoryDataset, int n2, int n3) {
        double d2;
        Object object;
        Object object2;
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        RectangleEdge rectangleEdge = categoryPlot.getRangeAxisEdge();
        Number number = ganttCategoryDataset.getEndValue(n2, n3);
        if (number == null) {
            return;
        }
        double d3 = valueAxis.valueToJava2D(number.doubleValue(), rectangle2D, rectangleEdge);
        Number number2 = ganttCategoryDataset.getStartValue(n2, n3);
        if (number2 == null) {
            return;
        }
        double d4 = valueAxis.valueToJava2D(number2.doubleValue(), rectangle2D, rectangleEdge);
        if (d4 < d3) {
            d2 = d4;
            d4 = d3;
            d3 = d2;
            Number number3 = number2;
            number2 = number;
            number = number3;
        }
        d2 = this.calculateBarW0(categoryPlot, plotOrientation, rectangle2D, categoryAxis, categoryItemRendererState, n2, n3);
        double d5 = categoryItemRendererState.getBarWidth();
        double d6 = Math.abs(d4 - d3);
        Rectangle2D.Double double_ = null;
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            double_ = new Rectangle2D.Double(d3, d2, d6, d5);
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            double_ = new Rectangle2D.Double(d2, d4, d5, d6);
        }
        Rectangle2D.Double double_2 = null;
        Rectangle2D.Double double_3 = null;
        Number number4 = ganttCategoryDataset.getPercentComplete(n2, n3);
        double d7 = this.getStartPercent();
        double d8 = this.getEndPercent();
        if (number4 != null) {
            double d9 = number4.doubleValue();
            if (categoryPlot.getOrientation() == PlotOrientation.HORIZONTAL) {
                double_2 = new Rectangle2D.Double(d3, d2 + d7 * d5, d6 * d9, d5 * (d8 - d7));
                double_3 = new Rectangle2D.Double(d3 + d6 * d9, d2 + d7 * d5, d6 * (1.0 - d9), d5 * (d8 - d7));
            } else if (categoryPlot.getOrientation() == PlotOrientation.VERTICAL) {
                double_2 = new Rectangle2D.Double(d2 + d7 * d5, d4 + d6 * (1.0 - d9), d5 * (d8 - d7), d6 * d9);
                double_3 = new Rectangle2D.Double(d2 + d7 * d5, d4, d5 * (d8 - d7), d6 * (1.0 - d9));
            }
        }
        Paint paint = this.getItemPaint(n2, n3);
        graphics2D.setPaint(paint);
        graphics2D.fill(double_);
        if (double_2 != null) {
            graphics2D.setPaint(this.getCompletePaint());
            graphics2D.fill(double_2);
        }
        if (double_3 != null) {
            graphics2D.setPaint(this.getIncompletePaint());
            graphics2D.fill(double_3);
        }
        if (this.isDrawBarOutline() && categoryItemRendererState.getBarWidth() > 3.0) {
            object = this.getItemOutlineStroke(n2, n3);
            object2 = this.getItemOutlinePaint(n2, n3);
            if (object != null && object2 != null) {
                graphics2D.setStroke((Stroke)object);
                graphics2D.setPaint((Paint)object2);
                graphics2D.draw(double_);
            }
        }
        if ((object = this.getItemLabelGenerator(n2, n3)) != null && this.isItemLabelVisible(n2, n3)) {
            this.drawItemLabel(graphics2D, ganttCategoryDataset, n2, n3, categoryPlot, (CategoryItemLabelGenerator)object, double_, false);
        }
        if (categoryItemRendererState.getInfo() == null) return;
        object2 = categoryItemRendererState.getEntityCollection();
        if (object2 == null) return;
        String string = null;
        CategoryToolTipGenerator categoryToolTipGenerator = this.getToolTipGenerator(n2, n3);
        if (categoryToolTipGenerator != null) {
            string = categoryToolTipGenerator.generateToolTip(ganttCategoryDataset, n2, n3);
        }
        String string2 = null;
        if (this.getItemURLGenerator(n2, n3) != null) {
            string2 = this.getItemURLGenerator(n2, n3).generateURL(ganttCategoryDataset, n2, n3);
        }
        CategoryItemEntity categoryItemEntity = new CategoryItemEntity(double_, string, string2, ganttCategoryDataset, n2, ganttCategoryDataset.getColumnKey(n3), n3);
        object2.add(categoryItemEntity);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof GanttRenderer)) {
            return false;
        }
        GanttRenderer ganttRenderer = (GanttRenderer)object;
        if (!PaintUtilities.equal(this.completePaint, ganttRenderer.completePaint)) {
            return false;
        }
        if (!PaintUtilities.equal(this.incompletePaint, ganttRenderer.incompletePaint)) {
            return false;
        }
        if (this.startPercent != ganttRenderer.startPercent) {
            return false;
        }
        if (this.endPercent == ganttRenderer.endPercent) return super.equals(object);
        return false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.completePaint, objectOutputStream);
        SerialUtilities.writePaint(this.incompletePaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.completePaint = SerialUtilities.readPaint(objectInputStream);
        this.incompletePaint = SerialUtilities.readPaint(objectInputStream);
    }
}

