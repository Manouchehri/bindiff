/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ClipPath;
import org.jfree.chart.annotations.XYAnnotation;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.ColorBar;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.ContourEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.AxisChangeEvent;
import org.jfree.chart.event.AxisChangeListener;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.labels.ContourToolTipGenerator;
import org.jfree.chart.labels.StandardContourToolTipGenerator;
import org.jfree.chart.plot.ContourValuePlot;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.chart.plot.ValueAxisPlot;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.Range;
import org.jfree.data.contour.ContourDataset;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.ObjectUtilities;

public class ContourPlot
extends Plot
implements PropertyChangeListener,
Serializable,
Cloneable,
ContourValuePlot,
ValueAxisPlot {
    private static final long serialVersionUID = 7861072556590502247L;
    protected static final RectangleInsets DEFAULT_INSETS = new RectangleInsets(2.0, 2.0, 100.0, 10.0);
    private ValueAxis domainAxis;
    private ValueAxis rangeAxis;
    private ContourDataset dataset;
    private ColorBar colorBar = null;
    private RectangleEdge colorBarLocation;
    private boolean domainCrosshairVisible;
    private double domainCrosshairValue;
    private transient Stroke domainCrosshairStroke;
    private transient Paint domainCrosshairPaint;
    private boolean domainCrosshairLockedOnData = true;
    private boolean rangeCrosshairVisible;
    private double rangeCrosshairValue;
    private transient Stroke rangeCrosshairStroke;
    private transient Paint rangeCrosshairPaint;
    private boolean rangeCrosshairLockedOnData = true;
    private double dataAreaRatio = 0.0;
    private List domainMarkers;
    private List rangeMarkers;
    private List annotations;
    private ContourToolTipGenerator toolTipGenerator;
    private XYURLGenerator urlGenerator;
    private boolean renderAsPoints = false;
    private double ptSizePct = 0.05;
    private transient ClipPath clipPath = null;
    private transient Paint missingPaint = null;
    protected static ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.chart.plot.LocalizationBundle");

    public ContourPlot() {
        this(null, null, null, null);
    }

    public ContourPlot(ContourDataset contourDataset, ValueAxis valueAxis, ValueAxis valueAxis2, ColorBar colorBar) {
        this.dataset = contourDataset;
        if (contourDataset != null) {
            contourDataset.addChangeListener(this);
        }
        this.domainAxis = valueAxis;
        if (valueAxis != null) {
            valueAxis.setPlot(this);
            valueAxis.addChangeListener(this);
        }
        this.rangeAxis = valueAxis2;
        if (valueAxis2 != null) {
            valueAxis2.setPlot(this);
            valueAxis2.addChangeListener(this);
        }
        this.colorBar = colorBar;
        if (colorBar != null) {
            colorBar.getAxis().setPlot(this);
            colorBar.getAxis().addChangeListener(this);
            colorBar.configure(this);
        }
        this.colorBarLocation = RectangleEdge.LEFT;
        this.toolTipGenerator = new StandardContourToolTipGenerator();
    }

    public RectangleEdge getColorBarLocation() {
        return this.colorBarLocation;
    }

    public void setColorBarLocation(RectangleEdge rectangleEdge) {
        this.colorBarLocation = rectangleEdge;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public ContourDataset getDataset() {
        return this.dataset;
    }

    public void setDataset(ContourDataset contourDataset) {
        ContourDataset contourDataset2 = this.dataset;
        if (contourDataset2 != null) {
            contourDataset2.removeChangeListener(this);
        }
        this.dataset = contourDataset;
        if (contourDataset != null) {
            this.setDatasetGroup(contourDataset.getGroup());
            contourDataset.addChangeListener(this);
        }
        DatasetChangeEvent datasetChangeEvent = new DatasetChangeEvent(this, contourDataset);
        this.datasetChanged(datasetChangeEvent);
    }

    public ValueAxis getDomainAxis() {
        return this.domainAxis;
    }

    public void setDomainAxis(ValueAxis valueAxis) {
        if (!this.isCompatibleDomainAxis(valueAxis)) return;
        if (valueAxis != null) {
            valueAxis.setPlot(this);
            valueAxis.addChangeListener(this);
        }
        if (this.domainAxis != null) {
            this.domainAxis.removeChangeListener(this);
        }
        this.domainAxis = valueAxis;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public ValueAxis getRangeAxis() {
        return this.rangeAxis;
    }

    public void setRangeAxis(ValueAxis valueAxis) {
        if (valueAxis != null) {
            valueAxis.setPlot(this);
            valueAxis.addChangeListener(this);
        }
        if (this.rangeAxis != null) {
            this.rangeAxis.removeChangeListener(this);
        }
        this.rangeAxis = valueAxis;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public void setColorBarAxis(ColorBar colorBar) {
        this.colorBar = colorBar;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public double getDataAreaRatio() {
        return this.dataAreaRatio;
    }

    public void setDataAreaRatio(double d2) {
        this.dataAreaRatio = d2;
    }

    public void addDomainMarker(Marker marker) {
        if (this.domainMarkers == null) {
            this.domainMarkers = new ArrayList();
        }
        this.domainMarkers.add(marker);
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public void clearDomainMarkers() {
        if (this.domainMarkers == null) return;
        this.domainMarkers.clear();
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public void addRangeMarker(Marker marker) {
        if (this.rangeMarkers == null) {
            this.rangeMarkers = new ArrayList();
        }
        this.rangeMarkers.add(marker);
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public void clearRangeMarkers() {
        if (this.rangeMarkers == null) return;
        this.rangeMarkers.clear();
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public void addAnnotation(XYAnnotation xYAnnotation) {
        if (this.annotations == null) {
            this.annotations = new ArrayList();
        }
        this.annotations.add(xYAnnotation);
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public void clearAnnotations() {
        if (this.annotations == null) return;
        this.annotations.clear();
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public boolean isCompatibleDomainAxis(ValueAxis valueAxis) {
        return true;
    }

    @Override
    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D, Point2D point2D, PlotState plotState, PlotRenderingInfo plotRenderingInfo) {
        boolean bl2 = rectangle2D.getWidth() <= 10.0;
        if (rectangle2D.getHeight() > 10.0) return;
        boolean bl3 = true;
        boolean bl4 = bl3;
        if (bl2) return;
        if (bl4) {
            return;
        }
        if (plotRenderingInfo != null) {
            plotRenderingInfo.setPlotArea(rectangle2D);
        }
        RectangleInsets rectangleInsets = this.getInsets();
        rectangleInsets.trim(rectangle2D);
        AxisSpace axisSpace = new AxisSpace();
        axisSpace = this.domainAxis.reserveSpace(graphics2D, this, rectangle2D, RectangleEdge.BOTTOM, axisSpace);
        axisSpace = this.rangeAxis.reserveSpace(graphics2D, this, rectangle2D, RectangleEdge.LEFT, axisSpace);
        Rectangle2D rectangle2D2 = axisSpace.shrink(rectangle2D, null);
        AxisSpace axisSpace2 = new AxisSpace();
        axisSpace2 = this.colorBar.reserveSpace(graphics2D, this, rectangle2D, rectangle2D2, this.colorBarLocation, axisSpace2);
        Rectangle2D rectangle2D3 = axisSpace2.shrink(rectangle2D, null);
        Rectangle2D rectangle2D4 = axisSpace.shrink(rectangle2D3, null);
        Rectangle2D rectangle2D5 = axisSpace2.reserved(rectangle2D, this.colorBarLocation);
        if (this.getDataAreaRatio() != 0.0) {
            double d2 = this.getDataAreaRatio();
            Rectangle2D rectangle2D6 = (Rectangle2D)rectangle2D4.clone();
            double d3 = rectangle2D6.getHeight();
            double d4 = rectangle2D6.getWidth();
            if (d2 > 0.0) {
                if (d4 * d2 <= d3) {
                    d3 = d2 * d4;
                } else {
                    d4 = d3 / d2;
                }
            } else {
                d2 *= -1.0;
                double d5 = this.getDomainAxis().getRange().getLength();
                double d6 = this.getRangeAxis().getRange().getLength();
                double d7 = d6 / d5;
                d2 = d7 * d2;
                if (d4 * d2 <= d3) {
                    d3 = d2 * d4;
                } else {
                    d4 = d3 / d2;
                }
            }
            rectangle2D4.setRect(rectangle2D6.getX() + rectangle2D6.getWidth() / 2.0 - d4 / 2.0, rectangle2D6.getY(), d4, d3);
        }
        if (plotRenderingInfo != null) {
            plotRenderingInfo.setDataArea(rectangle2D4);
        }
        CrosshairState crosshairState = new CrosshairState();
        crosshairState.setCrosshairDistance(Double.POSITIVE_INFINITY);
        this.drawBackground(graphics2D, rectangle2D4);
        double d8 = rectangle2D4.getMaxY();
        if (this.domainAxis != null) {
            this.domainAxis.draw(graphics2D, d8, rectangle2D3, rectangle2D4, RectangleEdge.BOTTOM, plotRenderingInfo);
        }
        if (this.rangeAxis != null) {
            d8 = rectangle2D4.getMinX();
            this.rangeAxis.draw(graphics2D, d8, rectangle2D3, rectangle2D4, RectangleEdge.LEFT, plotRenderingInfo);
        }
        if (this.colorBar != null) {
            d8 = 0.0;
            d8 = this.colorBar.draw(graphics2D, d8, rectangle2D3, rectangle2D4, rectangle2D5, this.colorBarLocation);
        }
        Shape shape = graphics2D.getClip();
        Composite composite = graphics2D.getComposite();
        graphics2D.clip(rectangle2D4);
        graphics2D.setComposite(AlphaComposite.getInstance(3, this.getForegroundAlpha()));
        this.render(graphics2D, rectangle2D4, plotRenderingInfo, crosshairState);
        if (this.domainMarkers != null) {
            for (Marker marker : this.domainMarkers) {
                this.drawDomainMarker(graphics2D, this, this.getDomainAxis(), marker, rectangle2D4);
            }
        }
        if (this.rangeMarkers != null) {
            for (Marker marker : this.rangeMarkers) {
                this.drawRangeMarker(graphics2D, this, this.getRangeAxis(), marker, rectangle2D4);
            }
        }
        graphics2D.setClip(shape);
        graphics2D.setComposite(composite);
        this.drawOutline(graphics2D, rectangle2D4);
    }

    public void render(Graphics2D graphics2D, Rectangle2D rectangle2D, PlotRenderingInfo plotRenderingInfo, CrosshairState crosshairState) {
        ContourDataset contourDataset = this.getDataset();
        if (contourDataset == null) {
            if (this.clipPath == null) return;
            this.getClipPath().draw(graphics2D, rectangle2D, this.domainAxis, this.rangeAxis);
            return;
        }
        ColorBar colorBar = this.getColorBar();
        if (this.clipPath != null) {
            GeneralPath generalPath = this.getClipPath().draw(graphics2D, rectangle2D, this.domainAxis, this.rangeAxis);
            if (this.clipPath.isClip()) {
                graphics2D.clip(generalPath);
            }
        }
        if (this.renderAsPoints) {
            this.pointRenderer(graphics2D, rectangle2D, plotRenderingInfo, this, this.domainAxis, this.rangeAxis, colorBar, contourDataset, crosshairState);
        } else {
            this.contourRenderer(graphics2D, rectangle2D, plotRenderingInfo, this, this.domainAxis, this.rangeAxis, colorBar, contourDataset, crosshairState);
        }
        this.setDomainCrosshairValue(crosshairState.getCrosshairX(), false);
        if (this.isDomainCrosshairVisible()) {
            this.drawVerticalLine(graphics2D, rectangle2D, this.getDomainCrosshairValue(), this.getDomainCrosshairStroke(), this.getDomainCrosshairPaint());
        }
        this.setRangeCrosshairValue(crosshairState.getCrosshairY(), false);
        if (!this.isRangeCrosshairVisible()) return;
        this.drawHorizontalLine(graphics2D, rectangle2D, this.getRangeCrosshairValue(), this.getRangeCrosshairStroke(), this.getRangeCrosshairPaint());
    }

    /*
     * Unable to fully structure code
     */
    public void contourRenderer(Graphics2D var1_1, Rectangle2D var2_2, PlotRenderingInfo var3_3, ContourPlot var4_4, ValueAxis var5_5, ValueAxis var6_6, ColorBar var7_7, ContourDataset var8_8, CrosshairState var9_9) {
        var10_10 = null;
        var11_11 = null;
        if (var3_3 != null) {
            var11_11 = var3_3.getOwner().getEntityCollection();
        }
        var12_12 = null;
        var12_12 = new Rectangle2D.Double();
        var13_13 = var1_1.getRenderingHint(RenderingHints.KEY_ANTIALIASING);
        var1_1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        var14_14 = var8_8.getXValues();
        var15_15 = var8_8.getYValues();
        var16_16 = var8_8.getZValues();
        var17_17 = new double[var14_14.length];
        var18_18 = new double[var15_15.length];
        for (var19_19 = 0; var19_19 < var17_17.length; ++var19_19) {
            var17_17[var19_19] = var14_14[var19_19].doubleValue();
            var18_18[var19_19] = var15_15[var19_19].doubleValue();
        }
        var19_20 = var8_8.indexX();
        var20_21 = var8_8.getXIndices();
        var21_22 = ((NumberAxis)var6_6).isInverted();
        var22_23 = false;
        if (var5_5 instanceof NumberAxis) {
            var22_23 = ((NumberAxis)var5_5).isInverted();
        }
        var23_24 = 0.0;
        var25_25 = 0.0;
        var27_26 = 0.0;
        var29_27 = 0.0;
        var31_28 = 0.0;
        var33_29 = 0.0;
        var35_30 = 0.0;
        var37_31 = 0.0;
        var39_32 = 0.0;
        var41_33 = 0.0;
        var43_34 = 0.0;
        var45_35 = 0.0;
        var47_36 = var19_20[var19_20.length - 1];
        var48_37 = 0;
        do {
            if (var48_37 >= var17_17.length) {
                var1_1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, var13_13);
                return;
            }
            var49_38 = var19_20[var48_37];
            if (var20_21[var49_38] != var48_37) ** GOTO lbl69
            if (var49_38 == 0) {
                var25_25 = var23_24 = var5_5.valueToJava2D(var17_17[var48_37], var2_2, RectangleEdge.BOTTOM);
                var27_26 = var5_5.valueToJava2D(var17_17[var20_21[var49_38 + 1]], var2_2, RectangleEdge.BOTTOM);
                var29_27 = Math.abs(0.5 * (var23_24 - var25_25));
                var31_28 = Math.abs(0.5 * (var23_24 - var27_26));
            } else if (var49_38 == var47_36) {
                var23_24 = var5_5.valueToJava2D(var17_17[var48_37], var2_2, RectangleEdge.BOTTOM);
                var25_25 = var5_5.valueToJava2D(var17_17[var20_21[var49_38 - 1]], var2_2, RectangleEdge.BOTTOM);
                var27_26 = var23_24;
                var29_27 = Math.abs(0.5 * (var23_24 - var25_25));
                var31_28 = Math.abs(0.5 * (var23_24 - var27_26));
            } else {
                var23_24 = var5_5.valueToJava2D(var17_17[var48_37], var2_2, RectangleEdge.BOTTOM);
                var27_26 = var5_5.valueToJava2D(var17_17[var20_21[var49_38 + 1]], var2_2, RectangleEdge.BOTTOM);
                var29_27 = var31_28;
                var31_28 = Math.abs(0.5 * (var23_24 - var27_26));
            }
            var23_24 = var22_23 ? (var23_24 -= var31_28) : (var23_24 -= var29_27);
            var33_29 = var29_27 + var31_28;
            var37_31 = var35_30 = var6_6.valueToJava2D(var18_18[var48_37], var2_2, RectangleEdge.LEFT);
            if (var48_37 + 1 == var18_18.length) ** GOTO lbl107
            var39_32 = var6_6.valueToJava2D(var18_18[var48_37 + 1], var2_2, RectangleEdge.LEFT);
            var41_33 = Math.abs(0.5 * (var35_30 - var37_31));
            var43_34 = Math.abs(0.5 * (var35_30 - var39_32));
            ** GOTO lbl80
lbl69: // 1 sources:
            if (var49_38 < var20_21.length - 1 && var20_21[var49_38 + 1] - 1 == var48_37 || var48_37 == var17_17.length - 1) {
                var35_30 = var6_6.valueToJava2D(var18_18[var48_37], var2_2, RectangleEdge.LEFT);
                var37_31 = var6_6.valueToJava2D(var18_18[var48_37 - 1], var2_2, RectangleEdge.LEFT);
                var39_32 = var35_30;
                var41_33 = Math.abs(0.5 * (var35_30 - var37_31));
                var43_34 = Math.abs(0.5 * (var35_30 - var39_32));
            } else {
                var35_30 = var6_6.valueToJava2D(var18_18[var48_37], var2_2, RectangleEdge.LEFT);
                var39_32 = var6_6.valueToJava2D(var18_18[var48_37 + 1], var2_2, RectangleEdge.LEFT);
                var41_33 = var43_34;
                var43_34 = Math.abs(0.5 * (var35_30 - var39_32));
            }
lbl80: // 3 sources:
            var35_30 = var21_22 ? (var35_30 -= var41_33) : (var35_30 -= var43_34);
            var45_35 = var41_33 + var43_34;
            var12_12.setRect(var23_24, var35_30, var33_29, var45_35);
            if (var16_16[var48_37] != null) {
                var1_1.setPaint(var7_7.getPaint(var16_16[var48_37].doubleValue()));
                var1_1.fill(var12_12);
            } else if (this.missingPaint != null) {
                var1_1.setPaint(this.missingPaint);
                var1_1.fill(var12_12);
            }
            var10_10 = var12_12;
            if (var11_11 != null) {
                var50_39 = "";
                if (this.getToolTipGenerator() != null) {
                    var50_39 = this.toolTipGenerator.generateToolTip(var8_8, var48_37);
                }
                var51_40 = null;
                var52_41 = new ContourEntity((Rectangle2D.Double)var10_10.clone(), var50_39, var51_40);
                var52_41.setIndex(var48_37);
                var11_11.add(var52_41);
            }
            if (var4_4.isDomainCrosshairLockedOnData()) {
                if (var4_4.isRangeCrosshairLockedOnData()) {
                    var9_9.updateCrosshairPoint(var17_17[var48_37], var18_18[var48_37], var23_24, var35_30, PlotOrientation.VERTICAL);
                } else {
                    var9_9.updateCrosshairX(var23_24);
                }
            } else if (var4_4.isRangeCrosshairLockedOnData()) {
                var9_9.updateCrosshairY(var35_30);
            }
lbl107: // 6 sources:
            ++var48_37;
        } while (true);
    }

    public void pointRenderer(Graphics2D graphics2D, Rectangle2D rectangle2D, PlotRenderingInfo plotRenderingInfo, ContourPlot contourPlot, ValueAxis valueAxis, ValueAxis valueAxis2, ColorBar colorBar, ContourDataset contourDataset, CrosshairState crosshairState) {
        Ellipse2D.Double double_ = null;
        EntityCollection entityCollection = null;
        if (plotRenderingInfo != null) {
            entityCollection = plotRenderingInfo.getOwner().getEntityCollection();
        }
        Ellipse2D.Double double_2 = new Ellipse2D.Double();
        Object object = graphics2D.getRenderingHint(RenderingHints.KEY_ANTIALIASING);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        Number[] arrnumber = contourDataset.getXValues();
        Number[] arrnumber2 = contourDataset.getYValues();
        Number[] arrnumber3 = contourDataset.getZValues();
        double[] arrd = new double[arrnumber.length];
        double[] arrd2 = new double[arrnumber2.length];
        for (int i2 = 0; i2 < arrd.length; ++i2) {
            arrd[i2] = arrnumber[i2].doubleValue();
            arrd2[i2] = arrnumber2[i2].doubleValue();
        }
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        double d5 = 0.0;
        double d6 = rectangle2D.getWidth() * this.ptSizePct;
        int n2 = 0;
        do {
            if (n2 >= arrd.length) {
                graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, object);
                return;
            }
            d2 = valueAxis.valueToJava2D(arrd[n2], rectangle2D, RectangleEdge.BOTTOM) - 0.5 * d6;
            d4 = valueAxis2.valueToJava2D(arrd2[n2], rectangle2D, RectangleEdge.LEFT) - 0.5 * d6;
            d3 = d6;
            d5 = d6;
            double_2.setFrame(d2, d4, d3, d5);
            if (arrnumber3[n2] != null) {
                graphics2D.setPaint(colorBar.getPaint(arrnumber3[n2].doubleValue()));
                graphics2D.fill(double_2);
            } else if (this.missingPaint != null) {
                graphics2D.setPaint(this.missingPaint);
                graphics2D.fill(double_2);
            }
            double_ = double_2;
            if (entityCollection != null) {
                String string = null;
                if (this.getToolTipGenerator() != null) {
                    string = this.toolTipGenerator.generateToolTip(contourDataset, n2);
                }
                String string2 = null;
                ContourEntity contourEntity = new ContourEntity((RectangularShape)double_.clone(), string, string2);
                contourEntity.setIndex(n2);
                entityCollection.add(contourEntity);
            }
            if (contourPlot.isDomainCrosshairLockedOnData()) {
                if (contourPlot.isRangeCrosshairLockedOnData()) {
                    crosshairState.updateCrosshairPoint(arrd[n2], arrd2[n2], d2, d4, PlotOrientation.VERTICAL);
                } else {
                    crosshairState.updateCrosshairX(d2);
                }
            } else if (contourPlot.isRangeCrosshairLockedOnData()) {
                crosshairState.updateCrosshairY(d4);
            }
            ++n2;
        } while (true);
    }

    protected void drawVerticalLine(Graphics2D graphics2D, Rectangle2D rectangle2D, double d2, Stroke stroke, Paint paint) {
        double d3 = this.getDomainAxis().valueToJava2D(d2, rectangle2D, RectangleEdge.BOTTOM);
        Line2D.Double double_ = new Line2D.Double(d3, rectangle2D.getMinY(), d3, rectangle2D.getMaxY());
        graphics2D.setStroke(stroke);
        graphics2D.setPaint(paint);
        graphics2D.draw(double_);
    }

    protected void drawHorizontalLine(Graphics2D graphics2D, Rectangle2D rectangle2D, double d2, Stroke stroke, Paint paint) {
        double d3 = this.getRangeAxis().valueToJava2D(d2, rectangle2D, RectangleEdge.LEFT);
        Line2D.Double double_ = new Line2D.Double(rectangle2D.getMinX(), d3, rectangle2D.getMaxX(), d3);
        graphics2D.setStroke(stroke);
        graphics2D.setPaint(paint);
        graphics2D.draw(double_);
    }

    @Override
    public void handleClick(int n2, int n3, PlotRenderingInfo plotRenderingInfo) {
    }

    @Override
    public void zoom(double d2) {
        if (d2 > 0.0) {
            return;
        }
        this.getRangeAxis().setAutoRange(true);
        this.getDomainAxis().setAutoRange(true);
    }

    @Override
    public String getPlotType() {
        return localizationResources.getString("Contour_Plot");
    }

    @Override
    public Range getDataRange(ValueAxis valueAxis) {
        if (this.dataset == null) {
            return null;
        }
        Range range = null;
        if (valueAxis == this.getDomainAxis()) {
            return DatasetUtilities.findDomainBounds(this.dataset);
        }
        if (valueAxis != this.getRangeAxis()) return range;
        return DatasetUtilities.findRangeBounds(this.dataset);
    }

    @Override
    public Range getContourDataRange() {
        Range range = null;
        ContourDataset contourDataset = this.getDataset();
        if (contourDataset == null) return range;
        Range range2 = this.getDomainAxis().getRange();
        Range range3 = this.getRangeAxis().getRange();
        return this.visibleRange(contourDataset, range2, range3);
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        this.notifyListeners(new PlotChangeEvent(this));
    }

    @Override
    public void datasetChanged(DatasetChangeEvent datasetChangeEvent) {
        if (this.domainAxis != null) {
            this.domainAxis.configure();
        }
        if (this.rangeAxis != null) {
            this.rangeAxis.configure();
        }
        if (this.colorBar != null) {
            this.colorBar.configure(this);
        }
        super.datasetChanged(datasetChangeEvent);
    }

    public ColorBar getColorBar() {
        return this.colorBar;
    }

    public boolean isDomainCrosshairVisible() {
        return this.domainCrosshairVisible;
    }

    public void setDomainCrosshairVisible(boolean bl2) {
        if (this.domainCrosshairVisible == bl2) return;
        this.domainCrosshairVisible = bl2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public boolean isDomainCrosshairLockedOnData() {
        return this.domainCrosshairLockedOnData;
    }

    public void setDomainCrosshairLockedOnData(boolean bl2) {
        if (this.domainCrosshairLockedOnData == bl2) return;
        this.domainCrosshairLockedOnData = bl2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public double getDomainCrosshairValue() {
        return this.domainCrosshairValue;
    }

    public void setDomainCrosshairValue(double d2) {
        this.setDomainCrosshairValue(d2, true);
    }

    public void setDomainCrosshairValue(double d2, boolean bl2) {
        this.domainCrosshairValue = d2;
        if (!this.isDomainCrosshairVisible()) return;
        if (!bl2) return;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Stroke getDomainCrosshairStroke() {
        return this.domainCrosshairStroke;
    }

    public void setDomainCrosshairStroke(Stroke stroke) {
        this.domainCrosshairStroke = stroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getDomainCrosshairPaint() {
        return this.domainCrosshairPaint;
    }

    public void setDomainCrosshairPaint(Paint paint) {
        this.domainCrosshairPaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public boolean isRangeCrosshairVisible() {
        return this.rangeCrosshairVisible;
    }

    public void setRangeCrosshairVisible(boolean bl2) {
        if (this.rangeCrosshairVisible == bl2) return;
        this.rangeCrosshairVisible = bl2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public boolean isRangeCrosshairLockedOnData() {
        return this.rangeCrosshairLockedOnData;
    }

    public void setRangeCrosshairLockedOnData(boolean bl2) {
        if (this.rangeCrosshairLockedOnData == bl2) return;
        this.rangeCrosshairLockedOnData = bl2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public double getRangeCrosshairValue() {
        return this.rangeCrosshairValue;
    }

    public void setRangeCrosshairValue(double d2) {
        this.setRangeCrosshairValue(d2, true);
    }

    public void setRangeCrosshairValue(double d2, boolean bl2) {
        this.rangeCrosshairValue = d2;
        if (!this.isRangeCrosshairVisible()) return;
        if (!bl2) return;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Stroke getRangeCrosshairStroke() {
        return this.rangeCrosshairStroke;
    }

    public void setRangeCrosshairStroke(Stroke stroke) {
        this.rangeCrosshairStroke = stroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getRangeCrosshairPaint() {
        return this.rangeCrosshairPaint;
    }

    public void setRangeCrosshairPaint(Paint paint) {
        this.rangeCrosshairPaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public ContourToolTipGenerator getToolTipGenerator() {
        return this.toolTipGenerator;
    }

    public void setToolTipGenerator(ContourToolTipGenerator contourToolTipGenerator) {
        this.toolTipGenerator = contourToolTipGenerator;
    }

    public XYURLGenerator getURLGenerator() {
        return this.urlGenerator;
    }

    public void setURLGenerator(XYURLGenerator xYURLGenerator) {
        this.urlGenerator = xYURLGenerator;
    }

    public void drawDomainMarker(Graphics2D graphics2D, ContourPlot contourPlot, ValueAxis valueAxis, Marker marker, Rectangle2D rectangle2D) {
        if (!(marker instanceof ValueMarker)) return;
        ValueMarker valueMarker = (ValueMarker)marker;
        double d2 = valueMarker.getValue();
        Range range = valueAxis.getRange();
        if (!range.contains(d2)) {
            return;
        }
        double d3 = valueAxis.valueToJava2D(d2, rectangle2D, RectangleEdge.BOTTOM);
        Line2D.Double double_ = new Line2D.Double(d3, rectangle2D.getMinY(), d3, rectangle2D.getMaxY());
        Paint paint = marker.getOutlinePaint();
        Stroke stroke = marker.getOutlineStroke();
        graphics2D.setPaint(paint != null ? paint : Plot.DEFAULT_OUTLINE_PAINT);
        graphics2D.setStroke(stroke != null ? stroke : Plot.DEFAULT_OUTLINE_STROKE);
        graphics2D.draw(double_);
    }

    public void drawRangeMarker(Graphics2D graphics2D, ContourPlot contourPlot, ValueAxis valueAxis, Marker marker, Rectangle2D rectangle2D) {
        if (!(marker instanceof ValueMarker)) return;
        ValueMarker valueMarker = (ValueMarker)marker;
        double d2 = valueMarker.getValue();
        Range range = valueAxis.getRange();
        if (!range.contains(d2)) {
            return;
        }
        double d3 = valueAxis.valueToJava2D(d2, rectangle2D, RectangleEdge.LEFT);
        Line2D.Double double_ = new Line2D.Double(rectangle2D.getMinX(), d3, rectangle2D.getMaxX(), d3);
        Paint paint = marker.getOutlinePaint();
        Stroke stroke = marker.getOutlineStroke();
        graphics2D.setPaint(paint != null ? paint : Plot.DEFAULT_OUTLINE_PAINT);
        graphics2D.setStroke(stroke != null ? stroke : Plot.DEFAULT_OUTLINE_STROKE);
        graphics2D.draw(double_);
    }

    public ClipPath getClipPath() {
        return this.clipPath;
    }

    public void setClipPath(ClipPath clipPath) {
        this.clipPath = clipPath;
    }

    public double getPtSizePct() {
        return this.ptSizePct;
    }

    public boolean isRenderAsPoints() {
        return this.renderAsPoints;
    }

    public void setPtSizePct(double d2) {
        this.ptSizePct = d2;
    }

    public void setRenderAsPoints(boolean bl2) {
        this.renderAsPoints = bl2;
    }

    @Override
    public void axisChanged(AxisChangeEvent axisChangeEvent) {
        Object object = axisChangeEvent.getSource();
        if (object.equals(this.rangeAxis) || object.equals(this.domainAxis)) {
            ColorBar colorBar = this.colorBar;
            if (this.colorBar.getAxis().isAutoRange()) {
                colorBar.getAxis().configure();
            }
        }
        super.axisChanged(axisChangeEvent);
    }

    public Range visibleRange(ContourDataset contourDataset, Range range, Range range2) {
        Range range3 = null;
        return contourDataset.getZValueRange(range, range2);
    }

    public Paint getMissingPaint() {
        return this.missingPaint;
    }

    public void setMissingPaint(Paint paint) {
        this.missingPaint = paint;
    }

    public void zoomDomainAxes(double d2, double d3, double d4) {
    }

    public void zoomDomainAxes(double d2, double d3, double d4, double d5) {
    }

    public void zoomRangeAxes(double d2, double d3, double d4) {
    }

    public void zoomRangeAxes(double d2, double d3, double d4, double d5) {
    }

    public boolean isDomainZoomable() {
        return false;
    }

    public boolean isRangeZoomable() {
        return false;
    }

    @Override
    public Object clone() {
        ContourPlot contourPlot = (ContourPlot)super.clone();
        if (this.domainAxis != null) {
            contourPlot.domainAxis = (ValueAxis)this.domainAxis.clone();
            contourPlot.domainAxis.setPlot(contourPlot);
            contourPlot.domainAxis.addChangeListener(contourPlot);
        }
        if (this.rangeAxis != null) {
            contourPlot.rangeAxis = (ValueAxis)this.rangeAxis.clone();
            contourPlot.rangeAxis.setPlot(contourPlot);
            contourPlot.rangeAxis.addChangeListener(contourPlot);
        }
        if (contourPlot.dataset != null) {
            contourPlot.dataset.addChangeListener(contourPlot);
        }
        if (this.colorBar != null) {
            contourPlot.colorBar = (ColorBar)this.colorBar.clone();
        }
        contourPlot.domainMarkers = (List)ObjectUtilities.deepClone(this.domainMarkers);
        contourPlot.rangeMarkers = (List)ObjectUtilities.deepClone(this.rangeMarkers);
        contourPlot.annotations = (List)ObjectUtilities.deepClone(this.annotations);
        if (this.clipPath == null) return contourPlot;
        contourPlot.clipPath = (ClipPath)this.clipPath.clone();
        return contourPlot;
    }
}

