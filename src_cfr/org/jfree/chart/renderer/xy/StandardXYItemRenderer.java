/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.xy;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.LegendItem;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.XYSeriesLabelGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.AbstractXYItemRenderer;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer$State;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.xy.XYDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.BooleanList;
import org.jfree.util.BooleanUtilities;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;
import org.jfree.util.ShapeUtilities;
import org.jfree.util.UnitType;

public class StandardXYItemRenderer
extends AbstractXYItemRenderer
implements Serializable,
Cloneable,
XYItemRenderer,
PublicCloneable {
    private static final long serialVersionUID = -3271351259436865995L;
    public static final int SHAPES = 1;
    public static final int LINES = 2;
    public static final int SHAPES_AND_LINES = 3;
    public static final int IMAGES = 4;
    public static final int DISCONTINUOUS = 8;
    public static final int DISCONTINUOUS_LINES = 10;
    private boolean baseShapesVisible;
    private boolean plotLines;
    private boolean plotImages;
    private boolean plotDiscontinuous;
    private UnitType gapThresholdType = UnitType.RELATIVE;
    private double gapThreshold = 1.0;
    private Boolean shapesFilled;
    private BooleanList seriesShapesFilled;
    private boolean baseShapesFilled;
    private boolean drawSeriesLineAsPath;
    private transient Shape legendLine;

    public StandardXYItemRenderer() {
        this(2, null);
    }

    public StandardXYItemRenderer(int n2) {
        this(n2, null);
    }

    public StandardXYItemRenderer(int n2, XYToolTipGenerator xYToolTipGenerator) {
        this(n2, xYToolTipGenerator, null);
    }

    public StandardXYItemRenderer(int n2, XYToolTipGenerator xYToolTipGenerator, XYURLGenerator xYURLGenerator) {
        this.setToolTipGenerator(xYToolTipGenerator);
        this.setURLGenerator(xYURLGenerator);
        if ((n2 & 1) != 0) {
            this.baseShapesVisible = true;
        }
        if ((n2 & 2) != 0) {
            this.plotLines = true;
        }
        if ((n2 & 4) != 0) {
            this.plotImages = true;
        }
        if ((n2 & 8) != 0) {
            this.plotDiscontinuous = true;
        }
        this.shapesFilled = null;
        this.seriesShapesFilled = new BooleanList();
        this.baseShapesFilled = true;
        this.legendLine = new Line2D.Double(-7.0, 0.0, 7.0, 0.0);
        this.drawSeriesLineAsPath = false;
    }

    public boolean getBaseShapesVisible() {
        return this.baseShapesVisible;
    }

    public void setBaseShapesVisible(boolean bl2) {
        if (this.baseShapesVisible == bl2) return;
        this.baseShapesVisible = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public boolean getItemShapeFilled(int n2, int n3) {
        if (this.shapesFilled != null) {
            return this.shapesFilled;
        }
        Boolean bl2 = this.seriesShapesFilled.getBoolean(n2);
        if (bl2 == null) return this.baseShapesFilled;
        return bl2;
    }

    public Boolean getShapesFilled() {
        return this.shapesFilled;
    }

    public void setShapesFilled(boolean bl2) {
        this.setShapesFilled(BooleanUtilities.valueOf(bl2));
    }

    public void setShapesFilled(Boolean bl2) {
        this.shapesFilled = bl2;
        this.fireChangeEvent();
    }

    public Boolean getSeriesShapesFilled(int n2) {
        return this.seriesShapesFilled.getBoolean(n2);
    }

    public void setSeriesShapesFilled(int n2, Boolean bl2) {
        this.seriesShapesFilled.setBoolean(n2, bl2);
        this.fireChangeEvent();
    }

    public boolean getBaseShapesFilled() {
        return this.baseShapesFilled;
    }

    public void setBaseShapesFilled(boolean bl2) {
        this.baseShapesFilled = bl2;
    }

    public boolean getPlotLines() {
        return this.plotLines;
    }

    public void setPlotLines(boolean bl2) {
        if (this.plotLines == bl2) return;
        this.plotLines = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public UnitType getGapThresholdType() {
        return this.gapThresholdType;
    }

    public void setGapThresholdType(UnitType unitType) {
        if (unitType == null) {
            throw new IllegalArgumentException("Null 'thresholdType' argument.");
        }
        this.gapThresholdType = unitType;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public double getGapThreshold() {
        return this.gapThreshold;
    }

    public void setGapThreshold(double d2) {
        this.gapThreshold = d2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public boolean getPlotImages() {
        return this.plotImages;
    }

    public void setPlotImages(boolean bl2) {
        if (this.plotImages == bl2) return;
        this.plotImages = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public boolean getPlotDiscontinuous() {
        return this.plotDiscontinuous;
    }

    public void setPlotDiscontinuous(boolean bl2) {
        if (this.plotDiscontinuous == bl2) return;
        this.plotDiscontinuous = bl2;
        this.fireChangeEvent();
    }

    public boolean getDrawSeriesLineAsPath() {
        return this.drawSeriesLineAsPath;
    }

    public void setDrawSeriesLineAsPath(boolean bl2) {
        this.drawSeriesLineAsPath = bl2;
    }

    public Shape getLegendLine() {
        return this.legendLine;
    }

    public void setLegendLine(Shape shape) {
        if (shape == null) {
            throw new IllegalArgumentException("Null 'line' argument.");
        }
        this.legendLine = shape;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public LegendItem getLegendItem(int n2, int n3) {
        String string;
        Paint paint;
        XYPlot xYPlot = this.getPlot();
        if (xYPlot == null) {
            return null;
        }
        LegendItem legendItem = null;
        XYDataset xYDataset = xYPlot.getDataset(n2);
        if (xYDataset == null) return legendItem;
        if (!this.getItemVisible(n3, 0)) return legendItem;
        String string2 = string = this.getLegendItemLabelGenerator().generateLabel(xYDataset, n3);
        String string3 = null;
        if (this.getLegendItemToolTipGenerator() != null) {
            string3 = this.getLegendItemToolTipGenerator().generateLabel(xYDataset, n3);
        }
        String string4 = null;
        if (this.getLegendItemURLGenerator() != null) {
            string4 = this.getLegendItemURLGenerator().generateLabel(xYDataset, n3);
        }
        Shape shape = this.getSeriesShape(n3);
        boolean bl2 = this.getItemShapeFilled(n3, 0);
        Paint paint2 = paint = this.getSeriesPaint(n3);
        Stroke stroke = this.getSeriesStroke(n3);
        return new LegendItem(string, string2, string3, string4, this.baseShapesVisible, shape, bl2, paint, !bl2, paint, stroke, this.plotLines, this.legendLine, stroke, paint2);
    }

    @Override
    public XYItemRendererState initialise(Graphics2D graphics2D, Rectangle2D rectangle2D, XYPlot xYPlot, XYDataset xYDataset, PlotRenderingInfo plotRenderingInfo) {
        StandardXYItemRenderer$State standardXYItemRenderer$State = new StandardXYItemRenderer$State(plotRenderingInfo);
        standardXYItemRenderer$State.seriesPath = new GeneralPath();
        StandardXYItemRenderer$State.access$002(standardXYItemRenderer$State, -1);
        return standardXYItemRenderer$State;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void drawItem(Graphics2D var1_1, XYItemRendererState var2_2, Rectangle2D var3_3, PlotRenderingInfo var4_4, XYPlot var5_5, ValueAxis var6_6, ValueAxis var7_7, XYDataset var8_8, int var9_9, int var10_10, CrosshairState var11_11, int var12_12) {
        var13_13 = this.getItemVisible(var9_9, var10_10);
        var14_14 = null;
        var15_15 = null;
        if (var4_4 != null) {
            var15_15 = var4_4.getOwner().getEntityCollection();
        }
        var16_16 = var5_5.getOrientation();
        var17_17 = this.getItemPaint(var9_9, var10_10);
        var18_18 = this.getItemStroke(var9_9, var10_10);
        var1_1.setPaint(var17_17);
        var1_1.setStroke(var18_18);
        var19_19 = var8_8.getXValue(var9_9, var10_10);
        var21_20 = var8_8.getYValue(var9_9, var10_10);
        if (Double.isNaN(var19_19) || Double.isNaN(var21_20)) {
            var13_13 = false;
        }
        var23_21 = var5_5.getDomainAxisEdge();
        var24_22 = var5_5.getRangeAxisEdge();
        var25_23 = var6_6.valueToJava2D(var19_19, var3_3, var23_21);
        var27_24 = var7_7.valueToJava2D(var21_20, var3_3, var24_22);
        if (!this.getPlotLines()) ** GOTO lbl72
        if (!this.drawSeriesLineAsPath) ** GOTO lbl44
        var29_25 = (StandardXYItemRenderer$State)var2_2;
        if (var29_25.getSeriesIndex() != var9_9) {
            var29_25.seriesPath.reset();
            StandardXYItemRenderer$State.access$102((StandardXYItemRenderer$State)var29_25, false);
            var29_25.setSeriesIndex(var9_9);
        }
        if (var13_13 && !Double.isNaN(var25_23) && !Double.isNaN(var27_24)) {
            var30_29 = (float)var25_23;
            var31_32 = (float)var27_24;
            if (var16_16 == PlotOrientation.HORIZONTAL) {
                var30_29 = (float)var27_24;
                var31_32 = (float)var25_23;
            }
            if (var29_25.isLastPointGood()) {
                var29_25.seriesPath.lineTo(var30_29, var31_32);
            } else {
                var29_25.seriesPath.moveTo(var30_29, var31_32);
            }
            var29_25.setLastPointGood(true);
        } else {
            var29_25.setLastPointGood(false);
        }
        if (var10_10 == var8_8.getItemCount(var9_9) - 1 && StandardXYItemRenderer$State.access$000((StandardXYItemRenderer$State)var29_25) == var9_9) {
            var1_1.setStroke(this.getSeriesStroke(var9_9));
            var1_1.setPaint(this.getSeriesPaint(var9_9));
            var1_1.draw(var29_25.seriesPath);
        }
        ** GOTO lbl72
lbl44: // 1 sources:
        if (var10_10 == 0 || !var13_13) ** GOTO lbl72
        var29_26 = var8_8.getXValue(var9_9, var10_10 - 1);
        var31_33 = var8_8.getYValue(var9_9, var10_10 - 1);
        if (Double.isNaN(var29_26) || Double.isNaN(var31_33)) ** GOTO lbl72
        var33_35 = true;
        if (!this.getPlotDiscontinuous()) ** GOTO lbl-1000
        var34_36 = var8_8.getItemCount(var9_9);
        var35_38 = var8_8.getXValue(var9_9, 0);
        var37_39 = var8_8.getXValue(var9_9, var34_36 - 1);
        if (this.gapThresholdType == UnitType.ABSOLUTE) {
            var33_35 = Math.abs(var19_19 - var29_26) <= this.gapThreshold;
        } else {
            v0 = var33_35 = Math.abs(var19_19 - var29_26) <= (var37_39 - var35_38) / (double)var34_36 * this.getGapThreshold();
        }
        if (var33_35) lbl-1000: // 2 sources:
        {
            var34_37 = var6_6.valueToJava2D(var29_26, var3_3, var23_21);
            var36_40 = var7_7.valueToJava2D(var31_33, var3_3, var24_22);
            if (Double.isNaN(var34_37) != false) return;
            if (Double.isNaN(var36_40) != false) return;
            if (Double.isNaN(var25_23) != false) return;
            if (Double.isNaN(var27_24)) {
                return;
            }
            if (var16_16 == PlotOrientation.HORIZONTAL) {
                var2_2.workingLine.setLine(var36_40, var34_37, var27_24, var25_23);
            } else if (var16_16 == PlotOrientation.VERTICAL) {
                var2_2.workingLine.setLine(var34_37, var36_40, var25_23, var27_24);
            }
            if (var2_2.workingLine.intersects(var3_3)) {
                var1_1.draw(var2_2.workingLine);
            }
        }
lbl72: // 9 sources:
        if (!var13_13) {
            return;
        }
        if (this.getBaseShapesVisible()) {
            var29_25 = this.getItemShape(var9_9, var10_10);
            if (var16_16 == PlotOrientation.HORIZONTAL) {
                var29_25 = ShapeUtilities.createTranslatedShape((Shape)var29_25, var27_24, var25_23);
            } else if (var16_16 == PlotOrientation.VERTICAL) {
                var29_25 = ShapeUtilities.createTranslatedShape((Shape)var29_25, var25_23, var27_24);
            }
            if (var29_25.intersects(var3_3)) {
                if (this.getItemShapeFilled(var9_9, var10_10)) {
                    var1_1.fill((Shape)var29_25);
                } else {
                    var1_1.draw((Shape)var29_25);
                }
            }
            var14_14 = var29_25;
        }
        if (this.getPlotImages() && (var29_25 = this.getImage(var5_5, var9_9, var10_10, var25_23, var27_24)) != null) {
            var30_30 = this.getImageHotspot(var5_5, var9_9, var10_10, var25_23, var27_24, (Image)var29_25);
            var1_1.drawImage((Image)var29_25, (int)(var25_23 - var30_30.getX()), (int)(var27_24 - var30_30.getY()), null);
            var14_14 = new Rectangle2D.Double(var25_23 - var30_30.getX(), var27_24 - var30_30.getY(), var29_25.getWidth(null), var29_25.getHeight(null));
        }
        if (this.isItemLabelVisible(var9_9, var10_10)) {
            var29_27 = var25_23;
            var31_34 = var27_24;
            if (var16_16 == PlotOrientation.HORIZONTAL) {
                var29_27 = var27_24;
                var31_34 = var25_23;
            }
            this.drawItemLabel(var1_1, var16_16, var8_8, var9_9, var10_10, var29_27, var31_34, var21_20 < 0.0);
        }
        var29_28 = var5_5.getDomainAxisIndex(var6_6);
        var30_31 = var5_5.getRangeAxisIndex(var7_7);
        this.updateCrosshairValues(var11_11, var19_19, var21_20, var29_28, var30_31, var25_23, var27_24, var16_16);
        if (var15_15 == null) return;
        this.addEntity(var15_15, (Shape)var14_14, var8_8, var9_9, var10_10, var25_23, var27_24);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof StandardXYItemRenderer)) {
            return false;
        }
        StandardXYItemRenderer standardXYItemRenderer = (StandardXYItemRenderer)object;
        if (this.baseShapesVisible != standardXYItemRenderer.baseShapesVisible) {
            return false;
        }
        if (this.plotLines != standardXYItemRenderer.plotLines) {
            return false;
        }
        if (this.plotImages != standardXYItemRenderer.plotImages) {
            return false;
        }
        if (this.plotDiscontinuous != standardXYItemRenderer.plotDiscontinuous) {
            return false;
        }
        if (this.gapThresholdType != standardXYItemRenderer.gapThresholdType) {
            return false;
        }
        if (this.gapThreshold != standardXYItemRenderer.gapThreshold) {
            return false;
        }
        if (!ObjectUtilities.equal(this.shapesFilled, standardXYItemRenderer.shapesFilled)) {
            return false;
        }
        if (!this.seriesShapesFilled.equals(standardXYItemRenderer.seriesShapesFilled)) {
            return false;
        }
        if (this.baseShapesFilled != standardXYItemRenderer.baseShapesFilled) {
            return false;
        }
        if (this.drawSeriesLineAsPath != standardXYItemRenderer.drawSeriesLineAsPath) {
            return false;
        }
        if (ShapeUtilities.equal(this.legendLine, standardXYItemRenderer.legendLine)) return super.equals(object);
        return false;
    }

    @Override
    public Object clone() {
        StandardXYItemRenderer standardXYItemRenderer = (StandardXYItemRenderer)super.clone();
        standardXYItemRenderer.seriesShapesFilled = (BooleanList)this.seriesShapesFilled.clone();
        standardXYItemRenderer.legendLine = ShapeUtilities.clone(this.legendLine);
        return standardXYItemRenderer;
    }

    protected Image getImage(Plot plot, int n2, int n3, double d2, double d3) {
        return null;
    }

    protected Point getImageHotspot(Plot plot, int n2, int n3, double d2, double d3, Image image) {
        int n4 = image.getHeight(null);
        int n5 = image.getWidth(null);
        return new Point(n5 / 2, n4 / 2);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.legendLine = SerialUtilities.readShape(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeShape(this.legendLine, objectOutputStream);
    }
}

