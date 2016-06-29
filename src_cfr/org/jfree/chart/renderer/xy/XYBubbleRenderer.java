/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.xy;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.LegendItem;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.chart.labels.XYSeriesLabelGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.AbstractXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PublicCloneable;

public class XYBubbleRenderer
extends AbstractXYItemRenderer
implements Serializable,
Cloneable,
XYItemRenderer,
PublicCloneable {
    public static final long serialVersionUID = -5221991598674249125L;
    public static final int SCALE_ON_BOTH_AXES = 0;
    public static final int SCALE_ON_DOMAIN_AXIS = 1;
    public static final int SCALE_ON_RANGE_AXIS = 2;
    private int scaleType;

    public XYBubbleRenderer() {
        this(0);
    }

    public XYBubbleRenderer(int n2) {
        if (n2 < 0) throw new IllegalArgumentException("Invalid 'scaleType'.");
        if (n2 > 2) {
            throw new IllegalArgumentException("Invalid 'scaleType'.");
        }
        this.scaleType = n2;
    }

    public int getScaleType() {
        return this.scaleType;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void drawItem(Graphics2D var1_1, XYItemRendererState var2_2, Rectangle2D var3_3, PlotRenderingInfo var4_4, XYPlot var5_5, ValueAxis var6_6, ValueAxis var7_7, XYDataset var8_8, int var9_9, int var10_10, CrosshairState var11_11, int var12_12) {
        var13_13 = var5_5.getOrientation();
        var14_14 = var8_8.getXValue(var9_9, var10_10);
        var16_15 = var8_8.getYValue(var9_9, var10_10);
        var18_16 = Double.NaN;
        if (var8_8 instanceof XYZDataset) {
            var20_17 = (XYZDataset)var8_8;
            var18_16 = var20_17.getZValue(var9_9, var10_10);
        }
        if (Double.isNaN(var18_16) != false) return;
        var20_17 = var5_5.getDomainAxisEdge();
        var21_18 = var5_5.getRangeAxisEdge();
        var22_19 = var6_6.valueToJava2D(var14_14, var3_3, (RectangleEdge)var20_17);
        var24_20 = var7_7.valueToJava2D(var16_15, var3_3, var21_18);
        var26_21 = 0.0;
        var28_22 = 0.0;
        switch (this.getScaleType()) {
            case 1: {
                var30_23 = var6_6.valueToJava2D(0.0, var3_3, (RectangleEdge)var20_17);
                var28_22 = var26_21 = var6_6.valueToJava2D(var18_16, var3_3, (RectangleEdge)var20_17) - var30_23;
                ** break;
            }
            case 2: {
                var30_24 = var7_7.valueToJava2D(0.0, var3_3, var21_18);
                var26_21 = var28_22 = var30_24 - var7_7.valueToJava2D(var18_16, var3_3, var21_18);
                ** break;
            }
        }
        var32_25 = var6_6.valueToJava2D(0.0, var3_3, (RectangleEdge)var20_17);
        var34_27 = var7_7.valueToJava2D(0.0, var3_3, var21_18);
        var26_21 = var6_6.valueToJava2D(var18_16, var3_3, (RectangleEdge)var20_17) - var32_25;
        var28_22 = var34_27 - var7_7.valueToJava2D(var18_16, var3_3, var21_18);
lbl28: // 3 sources:
        var26_21 = Math.abs(var26_21);
        var28_22 = Math.abs(var28_22);
        var32_26 = null;
        if (var13_13 == PlotOrientation.VERTICAL) {
            var32_26 = new Ellipse2D.Double(var22_19 - var26_21 / 2.0, var24_20 - var28_22 / 2.0, var26_21, var28_22);
        } else if (var13_13 == PlotOrientation.HORIZONTAL) {
            var32_26 = new Ellipse2D.Double(var24_20 - var28_22 / 2.0, var22_19 - var26_21 / 2.0, var28_22, var26_21);
        }
        var1_1.setPaint(this.getItemPaint(var9_9, var10_10));
        var1_1.fill(var32_26);
        var1_1.setStroke(this.getItemOutlineStroke(var9_9, var10_10));
        var1_1.setPaint(this.getItemOutlinePaint(var9_9, var10_10));
        var1_1.draw(var32_26);
        if (this.isItemLabelVisible(var9_9, var10_10)) {
            if (var13_13 == PlotOrientation.VERTICAL) {
                this.drawItemLabel(var1_1, var13_13, var8_8, var9_9, var10_10, var22_19, var24_20, false);
            } else if (var13_13 == PlotOrientation.HORIZONTAL) {
                this.drawItemLabel(var1_1, var13_13, var8_8, var9_9, var10_10, var24_20, var22_19, false);
            }
        }
        var33_30 = null;
        if (var4_4 != null && (var33_30 = var4_4.getOwner().getEntityCollection()) != null) {
            var34_28 = null;
            var35_31 = this.getToolTipGenerator(var9_9, var10_10);
            if (var35_31 != null) {
                var34_28 = var35_31.generateToolTip(var8_8, var9_9, var10_10);
            }
            var36_33 = null;
            if (this.getURLGenerator() != null) {
                var36_33 = this.getURLGenerator().generateURL(var8_8, var9_9, var10_10);
            }
            var37_34 = new XYItemEntity(var32_26, var8_8, var9_9, var10_10, var34_28, var36_33);
            var33_30.add(var37_34);
        }
        var34_29 = var5_5.getDomainAxisIndex(var6_6);
        var35_32 = var5_5.getRangeAxisIndex(var7_7);
        this.updateCrosshairValues(var11_11, var14_14, var16_15, var34_29, var35_32, var22_19, var24_20, var13_13);
    }

    @Override
    public LegendItem getLegendItem(int n2, int n3) {
        String string;
        LegendItem legendItem = null;
        XYPlot xYPlot = this.getPlot();
        if (xYPlot == null) return legendItem;
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
        Ellipse2D.Double double_ = new Ellipse2D.Double(-4.0, -4.0, 8.0, 8.0);
        Paint paint = this.getSeriesPaint(n3);
        Paint paint2 = this.getSeriesOutlinePaint(n3);
        Stroke stroke = this.getSeriesOutlineStroke(n3);
        return new LegendItem(string, string2, string3, string4, (Shape)double_, paint, stroke, paint2);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof XYBubbleRenderer)) {
            return false;
        }
        XYBubbleRenderer xYBubbleRenderer = (XYBubbleRenderer)object;
        if (this.scaleType == xYBubbleRenderer.scaleType) return super.equals(object);
        return false;
    }

    @Override
    public Object clone() {
        return super.clone();
    }
}

