package org.jfree.chart.renderer.category;

import javax.swing.*;
import org.jfree.chart.event.*;
import org.jfree.chart.axis.*;
import org.jfree.data.category.*;
import org.jfree.chart.plot.*;
import java.awt.*;
import org.jfree.chart.entity.*;
import org.jfree.chart.labels.*;
import java.awt.geom.*;
import org.jfree.io.*;
import java.io.*;

public class MinMaxCategoryRenderer extends AbstractCategoryItemRenderer
{
    private static final long serialVersionUID = 2935615937671064911L;
    private boolean plotLines;
    private transient Paint groupPaint;
    private transient Stroke groupStroke;
    private transient Icon minIcon;
    private transient Icon maxIcon;
    private transient Icon objectIcon;
    private int lastCategory;
    private double min;
    private double max;
    
    public MinMaxCategoryRenderer() {
        this.plotLines = false;
        this.groupPaint = Color.black;
        this.groupStroke = new BasicStroke(1.0f);
        this.minIcon = this.getIcon(new Arc2D.Double(-4.0, -4.0, 8.0, 8.0, 0.0, 360.0, 0), null, Color.black);
        this.maxIcon = this.getIcon(new Arc2D.Double(-4.0, -4.0, 8.0, 8.0, 0.0, 360.0, 0), null, Color.black);
        this.objectIcon = this.getIcon(new Line2D.Double(-4.0, 0.0, 4.0, 0.0), false, true);
        this.lastCategory = -1;
    }
    
    public boolean isDrawLines() {
        return this.plotLines;
    }
    
    public void setDrawLines(final boolean plotLines) {
        if (this.plotLines != plotLines) {
            this.plotLines = plotLines;
            this.notifyListeners(new RendererChangeEvent(this));
        }
    }
    
    public Paint getGroupPaint() {
        return this.groupPaint;
    }
    
    public void setGroupPaint(final Paint groupPaint) {
        if (groupPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.groupPaint = groupPaint;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public Stroke getGroupStroke() {
        return this.groupStroke;
    }
    
    public void setGroupStroke(final Stroke groupStroke) {
        this.groupStroke = groupStroke;
    }
    
    public Icon getObjectIcon() {
        return this.objectIcon;
    }
    
    public void setObjectIcon(final Icon objectIcon) {
        if (objectIcon == null) {
            throw new IllegalArgumentException("Null 'icon' argument.");
        }
        this.objectIcon = objectIcon;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public Icon getMaxIcon() {
        return this.maxIcon;
    }
    
    public void setMaxIcon(final Icon maxIcon) {
        if (maxIcon == null) {
            throw new IllegalArgumentException("Null 'icon' argument.");
        }
        this.maxIcon = maxIcon;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public Icon getMinIcon() {
        return this.minIcon;
    }
    
    public void setMinIcon(final Icon minIcon) {
        if (minIcon == null) {
            throw new IllegalArgumentException("Null 'icon' argument.");
        }
        this.minIcon = minIcon;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public void drawItem(final Graphics2D graphics2D, final CategoryItemRendererState categoryItemRendererState, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final CategoryAxis categoryAxis, final ValueAxis valueAxis, final CategoryDataset categoryDataset, final int n, final int lastCategory, final int n2) {
        final Number value = categoryDataset.getValue(n, lastCategory);
        if (value != null) {
            final double categoryMiddle = categoryAxis.getCategoryMiddle(lastCategory, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
            final double valueToJava2D = valueAxis.valueToJava2D(value.doubleValue(), rectangle2D, categoryPlot.getRangeAxisEdge());
            graphics2D.setPaint(this.getItemPaint(n, lastCategory));
            graphics2D.setStroke(this.getItemStroke(n, lastCategory));
            final Rectangle2D.Double double1 = new Rectangle2D.Double(categoryMiddle - 4.0, valueToJava2D - 4.0, 8.0, 8.0);
            final PlotOrientation orientation = categoryPlot.getOrientation();
            if (orientation == PlotOrientation.VERTICAL) {
                this.objectIcon.paintIcon(null, graphics2D, (int)categoryMiddle, (int)valueToJava2D);
            }
            else {
                this.objectIcon.paintIcon(null, graphics2D, (int)valueToJava2D, (int)categoryMiddle);
            }
            if (this.lastCategory == lastCategory) {
                if (this.min > value.doubleValue()) {
                    this.min = value.doubleValue();
                }
                if (this.max < value.doubleValue()) {
                    this.max = value.doubleValue();
                }
                if (categoryDataset.getRowCount() - 1 == n) {
                    graphics2D.setPaint(this.groupPaint);
                    graphics2D.setStroke(this.groupStroke);
                    final double valueToJava2D2 = valueAxis.valueToJava2D(this.min, rectangle2D, categoryPlot.getRangeAxisEdge());
                    final double valueToJava2D3 = valueAxis.valueToJava2D(this.max, rectangle2D, categoryPlot.getRangeAxisEdge());
                    if (orientation == PlotOrientation.VERTICAL) {
                        graphics2D.draw(new Line2D.Double(categoryMiddle, valueToJava2D2, categoryMiddle, valueToJava2D3));
                        this.minIcon.paintIcon(null, graphics2D, (int)categoryMiddle, (int)valueToJava2D2);
                        this.maxIcon.paintIcon(null, graphics2D, (int)categoryMiddle, (int)valueToJava2D3);
                    }
                    else {
                        graphics2D.draw(new Line2D.Double(valueToJava2D2, categoryMiddle, valueToJava2D3, categoryMiddle));
                        this.minIcon.paintIcon(null, graphics2D, (int)valueToJava2D2, (int)categoryMiddle);
                        this.maxIcon.paintIcon(null, graphics2D, (int)valueToJava2D3, (int)categoryMiddle);
                    }
                }
            }
            else {
                this.lastCategory = lastCategory;
                this.min = value.doubleValue();
                this.max = value.doubleValue();
            }
            if (this.plotLines && lastCategory != 0) {
                final Number value2 = categoryDataset.getValue(n, lastCategory - 1);
                if (value2 != null) {
                    final double doubleValue = value2.doubleValue();
                    final double categoryMiddle2 = categoryAxis.getCategoryMiddle(lastCategory - 1, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
                    final double valueToJava2D4 = valueAxis.valueToJava2D(doubleValue, rectangle2D, categoryPlot.getRangeAxisEdge());
                    graphics2D.setPaint(this.getItemPaint(n, lastCategory));
                    graphics2D.setStroke(this.getItemStroke(n, lastCategory));
                    Line2D.Double double2;
                    if (orientation == PlotOrientation.VERTICAL) {
                        double2 = new Line2D.Double(categoryMiddle2, valueToJava2D4, categoryMiddle, valueToJava2D);
                    }
                    else {
                        double2 = new Line2D.Double(valueToJava2D4, categoryMiddle2, valueToJava2D, categoryMiddle);
                    }
                    graphics2D.draw(double2);
                }
            }
            if (categoryItemRendererState.getInfo() != null) {
                final EntityCollection entityCollection = categoryItemRendererState.getEntityCollection();
                if (entityCollection != null && double1 != null) {
                    String generateToolTip = null;
                    final CategoryToolTipGenerator toolTipGenerator = this.getToolTipGenerator(n, lastCategory);
                    if (toolTipGenerator != null) {
                        generateToolTip = toolTipGenerator.generateToolTip(categoryDataset, n, lastCategory);
                    }
                    entityCollection.add(new CategoryItemEntity(double1, generateToolTip, null, categoryDataset, n, categoryDataset.getColumnKey(lastCategory), lastCategory));
                }
            }
        }
    }
    
    private Icon getIcon(final Shape shape, final Paint paint, final Paint paint2) {
        return new MinMaxCategoryRenderer$1(this, new GeneralPath(shape), paint, paint2, shape.getBounds().width, shape.getBounds().height);
    }
    
    private Icon getIcon(final Shape shape, final boolean b, final boolean b2) {
        return new MinMaxCategoryRenderer$2(this, new GeneralPath(shape), b, b2, shape.getBounds().width, shape.getBounds().height);
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeStroke(this.groupStroke, objectOutputStream);
        SerialUtilities.writePaint(this.groupPaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.groupStroke = SerialUtilities.readStroke(objectInputStream);
        this.groupPaint = SerialUtilities.readPaint(objectInputStream);
        this.minIcon = this.getIcon(new Arc2D.Double(-4.0, -4.0, 8.0, 8.0, 0.0, 360.0, 0), null, Color.black);
        this.maxIcon = this.getIcon(new Arc2D.Double(-4.0, -4.0, 8.0, 8.0, 0.0, 360.0, 0), null, Color.black);
        this.objectIcon = this.getIcon(new Line2D.Double(-4.0, 0.0, 4.0, 0.0), false, true);
    }
}
