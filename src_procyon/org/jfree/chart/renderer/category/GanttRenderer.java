package org.jfree.chart.renderer.category;

import org.jfree.chart.event.*;
import java.awt.geom.*;
import org.jfree.chart.axis.*;
import org.jfree.data.category.*;
import org.jfree.data.gantt.*;
import org.jfree.chart.plot.*;
import org.jfree.ui.*;
import org.jfree.chart.entity.*;
import java.awt.*;
import org.jfree.chart.labels.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class GanttRenderer extends IntervalBarRenderer implements Serializable
{
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
    
    public void setCompletePaint(final Paint completePaint) {
        if (completePaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.completePaint = completePaint;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public Paint getIncompletePaint() {
        return this.incompletePaint;
    }
    
    public void setIncompletePaint(final Paint incompletePaint) {
        if (incompletePaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.incompletePaint = incompletePaint;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public double getStartPercent() {
        return this.startPercent;
    }
    
    public void setStartPercent(final double startPercent) {
        this.startPercent = startPercent;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public double getEndPercent() {
        return this.endPercent;
    }
    
    public void setEndPercent(final double endPercent) {
        this.endPercent = endPercent;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public void drawItem(final Graphics2D graphics2D, final CategoryItemRendererState categoryItemRendererState, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final CategoryAxis categoryAxis, final ValueAxis valueAxis, final CategoryDataset categoryDataset, final int n, final int n2, final int n3) {
        if (categoryDataset instanceof GanttCategoryDataset) {
            this.drawTasks(graphics2D, categoryItemRendererState, rectangle2D, categoryPlot, categoryAxis, valueAxis, (GanttCategoryDataset)categoryDataset, n, n2);
        }
        else {
            super.drawItem(graphics2D, categoryItemRendererState, rectangle2D, categoryPlot, categoryAxis, valueAxis, categoryDataset, n, n2, n3);
        }
    }
    
    protected void drawTasks(final Graphics2D graphics2D, final CategoryItemRendererState categoryItemRendererState, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final CategoryAxis categoryAxis, final ValueAxis valueAxis, final GanttCategoryDataset ganttCategoryDataset, final int n, final int n2) {
        final int subIntervalCount = ganttCategoryDataset.getSubIntervalCount(n, n2);
        if (subIntervalCount == 0) {
            this.drawTask(graphics2D, categoryItemRendererState, rectangle2D, categoryPlot, categoryAxis, valueAxis, ganttCategoryDataset, n, n2);
        }
        for (int i = 0; i < subIntervalCount; ++i) {
            final RectangleEdge rangeAxisEdge = categoryPlot.getRangeAxisEdge();
            final Number startValue = ganttCategoryDataset.getStartValue(n, n2, i);
            if (startValue == null) {
                return;
            }
            double valueToJava2D = valueAxis.valueToJava2D(startValue.doubleValue(), rectangle2D, rangeAxisEdge);
            final Number endValue = ganttCategoryDataset.getEndValue(n, n2, i);
            if (endValue == null) {
                return;
            }
            double valueToJava2D2 = valueAxis.valueToJava2D(endValue.doubleValue(), rectangle2D, rangeAxisEdge);
            if (valueToJava2D2 < valueToJava2D) {
                final double n3 = valueToJava2D2;
                valueToJava2D2 = valueToJava2D;
                valueToJava2D = n3;
            }
            final double calculateBarW0 = this.calculateBarW0(categoryPlot, categoryPlot.getOrientation(), rectangle2D, categoryAxis, categoryItemRendererState, n, n2);
            final double abs = Math.abs(valueToJava2D2 - valueToJava2D);
            final double barWidth = categoryItemRendererState.getBarWidth();
            Shape shape = null;
            if (categoryPlot.getOrientation() == PlotOrientation.HORIZONTAL) {
                shape = new Rectangle2D.Double(valueToJava2D, calculateBarW0, abs, barWidth);
            }
            else if (categoryPlot.getOrientation() == PlotOrientation.VERTICAL) {
                shape = new Rectangle2D.Double(calculateBarW0, valueToJava2D, barWidth, abs);
            }
            Shape shape2 = null;
            Shape shape3 = null;
            final Number percentComplete = ganttCategoryDataset.getPercentComplete(n, n2, i);
            final double startPercent = this.getStartPercent();
            final double endPercent = this.getEndPercent();
            if (percentComplete != null) {
                final double doubleValue = percentComplete.doubleValue();
                if (categoryPlot.getOrientation() == PlotOrientation.HORIZONTAL) {
                    shape2 = new Rectangle2D.Double(valueToJava2D, calculateBarW0 + startPercent * barWidth, abs * doubleValue, barWidth * (endPercent - startPercent));
                    shape3 = new Rectangle2D.Double(valueToJava2D + abs * doubleValue, calculateBarW0 + startPercent * barWidth, abs * (1.0 - doubleValue), barWidth * (endPercent - startPercent));
                }
                else if (categoryPlot.getOrientation() == PlotOrientation.VERTICAL) {
                    shape2 = new Rectangle2D.Double(calculateBarW0 + startPercent * barWidth, valueToJava2D + abs * (1.0 - doubleValue), barWidth * (endPercent - startPercent), abs * doubleValue);
                    shape3 = new Rectangle2D.Double(calculateBarW0 + startPercent * barWidth, valueToJava2D, barWidth * (endPercent - startPercent), abs * (1.0 - doubleValue));
                }
            }
            graphics2D.setPaint(this.getItemPaint(n, n2));
            graphics2D.fill(shape);
            if (shape2 != null) {
                graphics2D.setPaint(this.getCompletePaint());
                graphics2D.fill(shape2);
            }
            if (shape3 != null) {
                graphics2D.setPaint(this.getIncompletePaint());
                graphics2D.fill(shape3);
            }
            if (this.isDrawBarOutline() && categoryItemRendererState.getBarWidth() > 3.0) {
                graphics2D.setStroke(this.getItemStroke(n, n2));
                graphics2D.setPaint(this.getItemOutlinePaint(n, n2));
                graphics2D.draw(shape);
            }
            if (categoryItemRendererState.getInfo() != null) {
                final EntityCollection entityCollection = categoryItemRendererState.getEntityCollection();
                if (entityCollection != null) {
                    String generateToolTip = null;
                    if (this.getToolTipGenerator(n, n2) != null) {
                        generateToolTip = this.getToolTipGenerator(n, n2).generateToolTip(ganttCategoryDataset, n, n2);
                    }
                    String generateURL = null;
                    if (this.getItemURLGenerator(n, n2) != null) {
                        generateURL = this.getItemURLGenerator(n, n2).generateURL(ganttCategoryDataset, n, n2);
                    }
                    entityCollection.add(new CategoryItemEntity(shape, generateToolTip, generateURL, ganttCategoryDataset, n, ganttCategoryDataset.getColumnKey(n2), n2));
                }
            }
        }
    }
    
    protected void drawTask(final Graphics2D graphics2D, final CategoryItemRendererState categoryItemRendererState, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final CategoryAxis categoryAxis, final ValueAxis valueAxis, final GanttCategoryDataset ganttCategoryDataset, final int n, final int n2) {
        final PlotOrientation orientation = categoryPlot.getOrientation();
        final RectangleEdge rangeAxisEdge = categoryPlot.getRangeAxisEdge();
        final Number endValue = ganttCategoryDataset.getEndValue(n, n2);
        if (endValue == null) {
            return;
        }
        double valueToJava2D = valueAxis.valueToJava2D(endValue.doubleValue(), rectangle2D, rangeAxisEdge);
        final Number startValue = ganttCategoryDataset.getStartValue(n, n2);
        if (startValue == null) {
            return;
        }
        double valueToJava2D2 = valueAxis.valueToJava2D(startValue.doubleValue(), rectangle2D, rangeAxisEdge);
        if (valueToJava2D2 < valueToJava2D) {
            final double n3 = valueToJava2D2;
            valueToJava2D2 = valueToJava2D;
            valueToJava2D = n3;
        }
        final double calculateBarW0 = this.calculateBarW0(categoryPlot, orientation, rectangle2D, categoryAxis, categoryItemRendererState, n, n2);
        final double barWidth = categoryItemRendererState.getBarWidth();
        final double abs = Math.abs(valueToJava2D2 - valueToJava2D);
        Rectangle2D rectangle2D2 = null;
        if (orientation == PlotOrientation.HORIZONTAL) {
            rectangle2D2 = new Rectangle2D.Double(valueToJava2D, calculateBarW0, abs, barWidth);
        }
        else if (orientation == PlotOrientation.VERTICAL) {
            rectangle2D2 = new Rectangle2D.Double(calculateBarW0, valueToJava2D2, barWidth, abs);
        }
        Shape shape = null;
        Shape shape2 = null;
        final Number percentComplete = ganttCategoryDataset.getPercentComplete(n, n2);
        final double startPercent = this.getStartPercent();
        final double endPercent = this.getEndPercent();
        if (percentComplete != null) {
            final double doubleValue = percentComplete.doubleValue();
            if (categoryPlot.getOrientation() == PlotOrientation.HORIZONTAL) {
                shape = new Rectangle2D.Double(valueToJava2D, calculateBarW0 + startPercent * barWidth, abs * doubleValue, barWidth * (endPercent - startPercent));
                shape2 = new Rectangle2D.Double(valueToJava2D + abs * doubleValue, calculateBarW0 + startPercent * barWidth, abs * (1.0 - doubleValue), barWidth * (endPercent - startPercent));
            }
            else if (categoryPlot.getOrientation() == PlotOrientation.VERTICAL) {
                shape = new Rectangle2D.Double(calculateBarW0 + startPercent * barWidth, valueToJava2D2 + abs * (1.0 - doubleValue), barWidth * (endPercent - startPercent), abs * doubleValue);
                shape2 = new Rectangle2D.Double(calculateBarW0 + startPercent * barWidth, valueToJava2D2, barWidth * (endPercent - startPercent), abs * (1.0 - doubleValue));
            }
        }
        graphics2D.setPaint(this.getItemPaint(n, n2));
        graphics2D.fill(rectangle2D2);
        if (shape != null) {
            graphics2D.setPaint(this.getCompletePaint());
            graphics2D.fill(shape);
        }
        if (shape2 != null) {
            graphics2D.setPaint(this.getIncompletePaint());
            graphics2D.fill(shape2);
        }
        if (this.isDrawBarOutline() && categoryItemRendererState.getBarWidth() > 3.0) {
            final Stroke itemOutlineStroke = this.getItemOutlineStroke(n, n2);
            final Paint itemOutlinePaint = this.getItemOutlinePaint(n, n2);
            if (itemOutlineStroke != null && itemOutlinePaint != null) {
                graphics2D.setStroke(itemOutlineStroke);
                graphics2D.setPaint(itemOutlinePaint);
                graphics2D.draw(rectangle2D2);
            }
        }
        final CategoryItemLabelGenerator itemLabelGenerator = this.getItemLabelGenerator(n, n2);
        if (itemLabelGenerator != null && this.isItemLabelVisible(n, n2)) {
            this.drawItemLabel(graphics2D, ganttCategoryDataset, n, n2, categoryPlot, itemLabelGenerator, rectangle2D2, false);
        }
        if (categoryItemRendererState.getInfo() != null) {
            final EntityCollection entityCollection = categoryItemRendererState.getEntityCollection();
            if (entityCollection != null) {
                String generateToolTip = null;
                final CategoryToolTipGenerator toolTipGenerator = this.getToolTipGenerator(n, n2);
                if (toolTipGenerator != null) {
                    generateToolTip = toolTipGenerator.generateToolTip(ganttCategoryDataset, n, n2);
                }
                String generateURL = null;
                if (this.getItemURLGenerator(n, n2) != null) {
                    generateURL = this.getItemURLGenerator(n, n2).generateURL(ganttCategoryDataset, n, n2);
                }
                entityCollection.add(new CategoryItemEntity(rectangle2D2, generateToolTip, generateURL, ganttCategoryDataset, n, ganttCategoryDataset.getColumnKey(n2), n2));
            }
        }
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof GanttRenderer)) {
            return false;
        }
        final GanttRenderer ganttRenderer = (GanttRenderer)o;
        return PaintUtilities.equal(this.completePaint, ganttRenderer.completePaint) && PaintUtilities.equal(this.incompletePaint, ganttRenderer.incompletePaint) && this.startPercent == ganttRenderer.startPercent && this.endPercent == ganttRenderer.endPercent && super.equals(o);
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.completePaint, objectOutputStream);
        SerialUtilities.writePaint(this.incompletePaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.completePaint = SerialUtilities.readPaint(objectInputStream);
        this.incompletePaint = SerialUtilities.readPaint(objectInputStream);
    }
}
