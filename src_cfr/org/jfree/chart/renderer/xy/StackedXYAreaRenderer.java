/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.xy;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Stack;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StackedXYAreaRenderer$StackedXYAreaRendererState;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.Range;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;
import org.jfree.util.ShapeUtilities;

public class StackedXYAreaRenderer
extends XYAreaRenderer
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = 5217394318178570889L;
    private transient Paint shapePaint = null;
    private transient Stroke shapeStroke = null;

    public StackedXYAreaRenderer() {
        this(4);
    }

    public StackedXYAreaRenderer(int n2) {
        this(n2, null, null);
    }

    public StackedXYAreaRenderer(int n2, XYToolTipGenerator xYToolTipGenerator, XYURLGenerator xYURLGenerator) {
        super(n2, xYToolTipGenerator, xYURLGenerator);
    }

    public Paint getShapePaint() {
        return this.shapePaint;
    }

    public void setShapePaint(Paint paint) {
        this.shapePaint = paint;
        this.fireChangeEvent();
    }

    public Stroke getShapeStroke() {
        return this.shapeStroke;
    }

    public void setShapeStroke(Stroke stroke) {
        this.shapeStroke = stroke;
        this.fireChangeEvent();
    }

    @Override
    public XYItemRendererState initialise(Graphics2D graphics2D, Rectangle2D rectangle2D, XYPlot xYPlot, XYDataset xYDataset, PlotRenderingInfo plotRenderingInfo) {
        return new StackedXYAreaRenderer$StackedXYAreaRendererState(plotRenderingInfo);
    }

    @Override
    public int getPassCount() {
        return 2;
    }

    @Override
    public Range findRangeBounds(XYDataset xYDataset) {
        if (xYDataset == null) return null;
        return DatasetUtilities.findStackedRangeBounds((TableXYDataset)xYDataset);
    }

    @Override
    public void drawItem(Graphics2D graphics2D, XYItemRendererState xYItemRendererState, Rectangle2D rectangle2D, PlotRenderingInfo plotRenderingInfo, XYPlot xYPlot, ValueAxis valueAxis, ValueAxis valueAxis2, XYDataset xYDataset, int n2, int n3, CrosshairState crosshairState, int n4) {
        PlotOrientation plotOrientation = xYPlot.getOrientation();
        StackedXYAreaRenderer$StackedXYAreaRendererState stackedXYAreaRenderer$StackedXYAreaRendererState = (StackedXYAreaRenderer$StackedXYAreaRendererState)xYItemRendererState;
        TableXYDataset tableXYDataset = (TableXYDataset)xYDataset;
        int n5 = tableXYDataset.getItemCount();
        double d2 = xYDataset.getXValue(n2, n3);
        double d3 = xYDataset.getYValue(n2, n3);
        boolean bl2 = false;
        if (Double.isNaN(d3)) {
            d3 = 0.0;
            bl2 = true;
        }
        double d4 = this.getPreviousHeight(tableXYDataset, n2, n3);
        double d5 = valueAxis.valueToJava2D(d2, rectangle2D, xYPlot.getDomainAxisEdge());
        double d6 = valueAxis2.valueToJava2D(d3 + d4, rectangle2D, xYPlot.getRangeAxisEdge());
        Paint paint = this.getItemPaint(n2, n3);
        Stroke stroke = this.getItemStroke(n2, n3);
        if (n4 == 0) {
            if (n3 == 0) {
                stackedXYAreaRenderer$StackedXYAreaRendererState.setSeriesArea(new Polygon());
                stackedXYAreaRenderer$StackedXYAreaRendererState.setLastSeriesPoints(stackedXYAreaRenderer$StackedXYAreaRendererState.getCurrentSeriesPoints());
                stackedXYAreaRenderer$StackedXYAreaRendererState.setCurrentSeriesPoints(new Stack());
                double d7 = valueAxis2.valueToJava2D(d4, rectangle2D, xYPlot.getRangeAxisEdge());
                if (plotOrientation == PlotOrientation.VERTICAL) {
                    stackedXYAreaRenderer$StackedXYAreaRendererState.getSeriesArea().addPoint((int)d5, (int)d7);
                } else if (plotOrientation == PlotOrientation.HORIZONTAL) {
                    stackedXYAreaRenderer$StackedXYAreaRendererState.getSeriesArea().addPoint((int)d7, (int)d5);
                }
            }
            if (plotOrientation == PlotOrientation.VERTICAL) {
                Point point = new Point((int)d5, (int)d6);
                stackedXYAreaRenderer$StackedXYAreaRendererState.getSeriesArea().addPoint((int)point.getX(), (int)point.getY());
                stackedXYAreaRenderer$StackedXYAreaRendererState.getCurrentSeriesPoints().push(point);
            } else if (plotOrientation == PlotOrientation.HORIZONTAL) {
                stackedXYAreaRenderer$StackedXYAreaRendererState.getSeriesArea().addPoint((int)d6, (int)d5);
            }
            if (this.getPlotLines() && n3 > 0) {
                double d8 = xYDataset.getXValue(n2, n3 - 1);
                double d9 = xYDataset.getYValue(n2, n3 - 1);
                double d10 = this.getPreviousHeight(tableXYDataset, n2, n3 - 1);
                double d11 = valueAxis.valueToJava2D(d8, rectangle2D, xYPlot.getDomainAxisEdge());
                double d12 = valueAxis2.valueToJava2D(d9 + d10, rectangle2D, xYPlot.getRangeAxisEdge());
                if (plotOrientation == PlotOrientation.VERTICAL) {
                    stackedXYAreaRenderer$StackedXYAreaRendererState.getLine().setLine(d11, d12, d5, d6);
                } else if (plotOrientation == PlotOrientation.HORIZONTAL) {
                    stackedXYAreaRenderer$StackedXYAreaRendererState.getLine().setLine(d12, d11, d6, d5);
                }
                graphics2D.draw(stackedXYAreaRenderer$StackedXYAreaRendererState.getLine());
            }
            if (this.getPlotArea() && n3 > 0 && n3 == n5 - 1) {
                double d13 = valueAxis2.valueToJava2D(d4, rectangle2D, xYPlot.getRangeAxisEdge());
                if (plotOrientation == PlotOrientation.VERTICAL) {
                    stackedXYAreaRenderer$StackedXYAreaRendererState.getSeriesArea().addPoint((int)d5, (int)d13);
                } else if (plotOrientation == PlotOrientation.HORIZONTAL) {
                    stackedXYAreaRenderer$StackedXYAreaRendererState.getSeriesArea().addPoint((int)d13, (int)d5);
                }
                if (n2 != 0) {
                    Stack stack = stackedXYAreaRenderer$StackedXYAreaRendererState.getLastSeriesPoints();
                    while (!stack.empty()) {
                        Point point = (Point)stack.pop();
                        stackedXYAreaRenderer$StackedXYAreaRendererState.getSeriesArea().addPoint((int)point.getX(), (int)point.getY());
                    }
                }
                graphics2D.setPaint(paint);
                graphics2D.setStroke(stroke);
                graphics2D.fill(stackedXYAreaRenderer$StackedXYAreaRendererState.getSeriesArea());
                if (this.isOutline()) {
                    graphics2D.setStroke(this.getSeriesOutlineStroke(n2));
                    graphics2D.setPaint(this.getSeriesOutlinePaint(n2));
                    graphics2D.draw(stackedXYAreaRenderer$StackedXYAreaRendererState.getSeriesArea());
                }
            }
            int n6 = xYPlot.getDomainAxisIndex(valueAxis);
            int n7 = xYPlot.getRangeAxisIndex(valueAxis2);
            this.updateCrosshairValues(crosshairState, d2, d4 + d3, n6, n7, d5, d6, plotOrientation);
            return;
        }
        if (n4 != 1) return;
        Shape shape = null;
        if (this.getPlotShapes()) {
            shape = this.getItemShape(n2, n3);
            if (xYPlot.getOrientation() == PlotOrientation.VERTICAL) {
                shape = ShapeUtilities.createTranslatedShape(shape, d5, d6);
            } else if (xYPlot.getOrientation() == PlotOrientation.HORIZONTAL) {
                shape = ShapeUtilities.createTranslatedShape(shape, d6, d5);
            }
            if (!bl2) {
                if (this.getShapePaint() != null) {
                    graphics2D.setPaint(this.getShapePaint());
                } else {
                    graphics2D.setPaint(paint);
                }
                if (this.getShapeStroke() != null) {
                    graphics2D.setStroke(this.getShapeStroke());
                } else {
                    graphics2D.setStroke(stroke);
                }
                graphics2D.draw(shape);
            }
        } else if (xYPlot.getOrientation() == PlotOrientation.VERTICAL) {
            shape = new Rectangle2D.Double(d5 - 3.0, d6 - 3.0, 6.0, 6.0);
        } else if (xYPlot.getOrientation() == PlotOrientation.HORIZONTAL) {
            shape = new Rectangle2D.Double(d6 - 3.0, d5 - 3.0, 6.0, 6.0);
        }
        if (xYItemRendererState.getInfo() == null) return;
        EntityCollection entityCollection = xYItemRendererState.getEntityCollection();
        if (entityCollection == null) return;
        if (shape == null) return;
        if (bl2) return;
        String string = null;
        XYToolTipGenerator xYToolTipGenerator = this.getToolTipGenerator(n2, n3);
        if (xYToolTipGenerator != null) {
            string = xYToolTipGenerator.generateToolTip(xYDataset, n2, n3);
        }
        String string2 = null;
        if (this.getURLGenerator() != null) {
            string2 = this.getURLGenerator().generateURL(xYDataset, n2, n3);
        }
        XYItemEntity xYItemEntity = new XYItemEntity(shape, xYDataset, n2, n3, string, string2);
        entityCollection.add(xYItemEntity);
    }

    protected double getPreviousHeight(TableXYDataset tableXYDataset, int n2, int n3) {
        double d2 = 0.0;
        int n4 = 0;
        while (n4 < n2) {
            double d3 = tableXYDataset.getYValue(n4, n3);
            if (!Double.isNaN(d3)) {
                d2 += d3;
            }
            ++n4;
        }
        return d2;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof StackedXYAreaRenderer)) return false;
        if (!super.equals(object)) {
            return false;
        }
        StackedXYAreaRenderer stackedXYAreaRenderer = (StackedXYAreaRenderer)object;
        if (!PaintUtilities.equal(this.shapePaint, stackedXYAreaRenderer.shapePaint)) {
            return false;
        }
        if (ObjectUtilities.equal(this.shapeStroke, stackedXYAreaRenderer.shapeStroke)) return true;
        return false;
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.shapePaint = SerialUtilities.readPaint(objectInputStream);
        this.shapeStroke = SerialUtilities.readStroke(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.shapePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.shapeStroke, objectOutputStream);
    }
}

