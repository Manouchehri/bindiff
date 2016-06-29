/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.category;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.Icon;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.category.AbstractCategoryItemRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.chart.renderer.category.MinMaxCategoryRenderer$1;
import org.jfree.chart.renderer.category.MinMaxCategoryRenderer$2;
import org.jfree.data.category.CategoryDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;

public class MinMaxCategoryRenderer
extends AbstractCategoryItemRenderer {
    private static final long serialVersionUID = 2935615937671064911L;
    private boolean plotLines = false;
    private transient Paint groupPaint = Color.black;
    private transient Stroke groupStroke = new BasicStroke(1.0f);
    private transient Icon minIcon;
    private transient Icon maxIcon;
    private transient Icon objectIcon;
    private int lastCategory;
    private double min;
    private double max;

    public MinMaxCategoryRenderer() {
        this.minIcon = this.getIcon((Shape)new Arc2D.Double(-4.0, -4.0, 8.0, 8.0, 0.0, 360.0, 0), null, Color.black);
        this.maxIcon = this.getIcon((Shape)new Arc2D.Double(-4.0, -4.0, 8.0, 8.0, 0.0, 360.0, 0), null, Color.black);
        this.objectIcon = this.getIcon((Shape)new Line2D.Double(-4.0, 0.0, 4.0, 0.0), false, true);
        this.lastCategory = -1;
    }

    public boolean isDrawLines() {
        return this.plotLines;
    }

    public void setDrawLines(boolean bl2) {
        if (this.plotLines == bl2) return;
        this.plotLines = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public Paint getGroupPaint() {
        return this.groupPaint;
    }

    public void setGroupPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.groupPaint = paint;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public Stroke getGroupStroke() {
        return this.groupStroke;
    }

    public void setGroupStroke(Stroke stroke) {
        this.groupStroke = stroke;
    }

    public Icon getObjectIcon() {
        return this.objectIcon;
    }

    public void setObjectIcon(Icon icon) {
        if (icon == null) {
            throw new IllegalArgumentException("Null 'icon' argument.");
        }
        this.objectIcon = icon;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public Icon getMaxIcon() {
        return this.maxIcon;
    }

    public void setMaxIcon(Icon icon) {
        if (icon == null) {
            throw new IllegalArgumentException("Null 'icon' argument.");
        }
        this.maxIcon = icon;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public Icon getMinIcon() {
        return this.minIcon;
    }

    public void setMinIcon(Icon icon) {
        if (icon == null) {
            throw new IllegalArgumentException("Null 'icon' argument.");
        }
        this.minIcon = icon;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public void drawItem(Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, CategoryDataset categoryDataset, int n2, int n3, int n4) {
        Number number;
        Number number2 = categoryDataset.getValue(n2, n3);
        if (number2 == null) return;
        double d2 = categoryAxis.getCategoryMiddle(n3, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
        double d3 = valueAxis.valueToJava2D(number2.doubleValue(), rectangle2D, categoryPlot.getRangeAxisEdge());
        graphics2D.setPaint(this.getItemPaint(n2, n3));
        graphics2D.setStroke(this.getItemStroke(n2, n3));
        Rectangle2D.Double double_ = null;
        double_ = new Rectangle2D.Double(d2 - 4.0, d3 - 4.0, 8.0, 8.0);
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        if (plotOrientation == PlotOrientation.VERTICAL) {
            this.objectIcon.paintIcon(null, graphics2D, (int)d2, (int)d3);
        } else {
            this.objectIcon.paintIcon(null, graphics2D, (int)d3, (int)d2);
        }
        if (this.lastCategory == n3) {
            if (this.min > number2.doubleValue()) {
                this.min = number2.doubleValue();
            }
            if (this.max < number2.doubleValue()) {
                this.max = number2.doubleValue();
            }
            if (categoryDataset.getRowCount() - 1 == n2) {
                graphics2D.setPaint(this.groupPaint);
                graphics2D.setStroke(this.groupStroke);
                double d4 = valueAxis.valueToJava2D(this.min, rectangle2D, categoryPlot.getRangeAxisEdge());
                double d5 = valueAxis.valueToJava2D(this.max, rectangle2D, categoryPlot.getRangeAxisEdge());
                if (plotOrientation == PlotOrientation.VERTICAL) {
                    graphics2D.draw(new Line2D.Double(d2, d4, d2, d5));
                    this.minIcon.paintIcon(null, graphics2D, (int)d2, (int)d4);
                    this.maxIcon.paintIcon(null, graphics2D, (int)d2, (int)d5);
                } else {
                    graphics2D.draw(new Line2D.Double(d4, d2, d5, d2));
                    this.minIcon.paintIcon(null, graphics2D, (int)d4, (int)d2);
                    this.maxIcon.paintIcon(null, graphics2D, (int)d5, (int)d2);
                }
            }
        } else {
            this.lastCategory = n3;
            this.min = number2.doubleValue();
            this.max = number2.doubleValue();
        }
        if (this.plotLines && n3 != 0 && (number = categoryDataset.getValue(n2, n3 - 1)) != null) {
            double d6 = number.doubleValue();
            double d7 = categoryAxis.getCategoryMiddle(n3 - 1, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
            double d8 = valueAxis.valueToJava2D(d6, rectangle2D, categoryPlot.getRangeAxisEdge());
            graphics2D.setPaint(this.getItemPaint(n2, n3));
            graphics2D.setStroke(this.getItemStroke(n2, n3));
            Line2D.Double double_2 = plotOrientation == PlotOrientation.VERTICAL ? new Line2D.Double(d7, d8, d2, d3) : new Line2D.Double(d8, d7, d3, d2);
            graphics2D.draw(double_2);
        }
        if (categoryItemRendererState.getInfo() == null) return;
        EntityCollection entityCollection = categoryItemRendererState.getEntityCollection();
        if (entityCollection == null) return;
        if (double_ == null) return;
        String string = null;
        CategoryToolTipGenerator categoryToolTipGenerator = this.getToolTipGenerator(n2, n3);
        if (categoryToolTipGenerator != null) {
            string = categoryToolTipGenerator.generateToolTip(categoryDataset, n2, n3);
        }
        CategoryItemEntity categoryItemEntity = new CategoryItemEntity(double_, string, null, categoryDataset, n2, categoryDataset.getColumnKey(n3), n3);
        entityCollection.add(categoryItemEntity);
    }

    private Icon getIcon(Shape shape, Paint paint, Paint paint2) {
        int n2 = shape.getBounds().width;
        int n3 = shape.getBounds().height;
        GeneralPath generalPath = new GeneralPath(shape);
        return new MinMaxCategoryRenderer$1(this, generalPath, paint, paint2, n2, n3);
    }

    private Icon getIcon(Shape shape, boolean bl2, boolean bl3) {
        int n2 = shape.getBounds().width;
        int n3 = shape.getBounds().height;
        GeneralPath generalPath = new GeneralPath(shape);
        return new MinMaxCategoryRenderer$2(this, generalPath, bl2, bl3, n2, n3);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeStroke(this.groupStroke, objectOutputStream);
        SerialUtilities.writePaint(this.groupPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.groupStroke = SerialUtilities.readStroke(objectInputStream);
        this.groupPaint = SerialUtilities.readPaint(objectInputStream);
        this.minIcon = this.getIcon((Shape)new Arc2D.Double(-4.0, -4.0, 8.0, 8.0, 0.0, 360.0, 0), null, Color.black);
        this.maxIcon = this.getIcon((Shape)new Arc2D.Double(-4.0, -4.0, 8.0, 8.0, 0.0, 360.0, 0), null, Color.black);
        this.objectIcon = this.getIcon((Shape)new Line2D.Double(-4.0, 0.0, 4.0, 0.0), false, true);
    }
}

