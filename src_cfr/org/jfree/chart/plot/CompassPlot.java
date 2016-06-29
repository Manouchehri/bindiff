/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.ResourceBundle;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.needle.ArrowNeedle;
import org.jfree.chart.needle.LineNeedle;
import org.jfree.chart.needle.LongNeedle;
import org.jfree.chart.needle.MeterNeedle;
import org.jfree.chart.needle.MiddlePinNeedle;
import org.jfree.chart.needle.PinNeedle;
import org.jfree.chart.needle.PlumNeedle;
import org.jfree.chart.needle.PointerNeedle;
import org.jfree.chart.needle.ShipNeedle;
import org.jfree.chart.needle.WindNeedle;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.general.ValueDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;

public class CompassPlot
extends Plot
implements Serializable,
Cloneable {
    private static final long serialVersionUID = 6924382802125527395L;
    public static final Font DEFAULT_LABEL_FONT = new Font("SansSerif", 1, 10);
    public static final int NO_LABELS = 0;
    public static final int VALUE_LABELS = 1;
    private int labelType;
    private Font labelFont;
    private boolean drawBorder = false;
    private transient Paint roseHighlightPaint = Color.black;
    private transient Paint rosePaint = Color.yellow;
    private transient Paint roseCenterPaint = Color.white;
    private Font compassFont = new Font("Arial", 0, 10);
    private transient Ellipse2D circle1;
    private transient Ellipse2D circle2;
    private transient Area a1;
    private transient Area a2;
    private transient Rectangle2D rect1;
    private ValueDataset[] datasets = new ValueDataset[1];
    private MeterNeedle[] seriesNeedle = new MeterNeedle[1];
    protected static ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.chart.plot.LocalizationBundle");
    protected double revolutionDistance = 360.0;

    public CompassPlot() {
        this(new DefaultValueDataset());
    }

    public CompassPlot(ValueDataset valueDataset) {
        if (valueDataset != null) {
            this.datasets[0] = valueDataset;
            valueDataset.addChangeListener(this);
        }
        this.circle1 = new Ellipse2D.Double();
        this.circle2 = new Ellipse2D.Double();
        this.rect1 = new Rectangle2D.Double();
        this.setSeriesNeedle(0);
    }

    public int getLabelType() {
        return this.labelType;
    }

    public void setLabelType(int n2) {
        if (n2 != 0 && n2 != 1) {
            throw new IllegalArgumentException("MeterPlot.setLabelType(int): unrecognised type.");
        }
        if (this.labelType == n2) return;
        this.labelType = n2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Font getLabelFont() {
        return this.labelFont;
    }

    public void setLabelFont(Font font) {
        if (font == null) {
            throw new IllegalArgumentException("Null 'font' not allowed.");
        }
        this.labelFont = font;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getRosePaint() {
        return this.rosePaint;
    }

    public void setRosePaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.rosePaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getRoseCenterPaint() {
        return this.roseCenterPaint;
    }

    public void setRoseCenterPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.roseCenterPaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getRoseHighlightPaint() {
        return this.roseHighlightPaint;
    }

    public void setRoseHighlightPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.roseHighlightPaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public boolean getDrawBorder() {
        return this.drawBorder;
    }

    public void setDrawBorder(boolean bl2) {
        this.drawBorder = bl2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public void setSeriesPaint(int n2, Paint paint) {
        if (n2 < 0) return;
        if (n2 >= this.seriesNeedle.length) return;
        this.seriesNeedle[n2].setFillPaint(paint);
    }

    public void setSeriesOutlinePaint(int n2, Paint paint) {
        if (n2 < 0) return;
        if (n2 >= this.seriesNeedle.length) return;
        this.seriesNeedle[n2].setOutlinePaint(paint);
    }

    public void setSeriesOutlineStroke(int n2, Stroke stroke) {
        if (n2 < 0) return;
        if (n2 >= this.seriesNeedle.length) return;
        this.seriesNeedle[n2].setOutlineStroke(stroke);
    }

    public void setSeriesNeedle(int n2) {
        this.setSeriesNeedle(0, n2);
    }

    public void setSeriesNeedle(int n2, int n3) {
        switch (n3) {
            case 0: {
                this.setSeriesNeedle(n2, new ArrowNeedle(true));
                this.setSeriesPaint(n2, Color.red);
                this.seriesNeedle[n2].setHighlightPaint(Color.white);
                return;
            }
            case 1: {
                this.setSeriesNeedle(n2, new LineNeedle());
                return;
            }
            case 2: {
                LongNeedle longNeedle = new LongNeedle();
                longNeedle.setRotateY(0.5);
                this.setSeriesNeedle(n2, longNeedle);
                return;
            }
            case 3: {
                this.setSeriesNeedle(n2, new PinNeedle());
                return;
            }
            case 4: {
                this.setSeriesNeedle(n2, new PlumNeedle());
                return;
            }
            case 5: {
                this.setSeriesNeedle(n2, new PointerNeedle());
                return;
            }
            case 6: {
                this.setSeriesPaint(n2, null);
                this.setSeriesOutlineStroke(n2, new BasicStroke(3.0f));
                this.setSeriesNeedle(n2, new ShipNeedle());
                return;
            }
            case 7: {
                this.setSeriesPaint(n2, Color.blue);
                this.setSeriesNeedle(n2, new WindNeedle());
                return;
            }
            case 8: {
                this.setSeriesNeedle(n2, new ArrowNeedle(true));
                return;
            }
            case 9: {
                this.setSeriesNeedle(n2, new MiddlePinNeedle());
                return;
            }
        }
        throw new IllegalArgumentException("Unrecognised type.");
    }

    public void setSeriesNeedle(int n2, MeterNeedle meterNeedle) {
        if (meterNeedle != null && n2 < this.seriesNeedle.length) {
            this.seriesNeedle[n2] = meterNeedle;
        }
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public ValueDataset[] getDatasets() {
        return this.datasets;
    }

    public void addDataset(ValueDataset valueDataset) {
        this.addDataset(valueDataset, null);
    }

    public void addDataset(ValueDataset valueDataset, MeterNeedle meterNeedle) {
        if (valueDataset == null) return;
        int n2 = this.datasets.length + 1;
        ValueDataset[] arrvalueDataset = new ValueDataset[n2];
        MeterNeedle[] arrmeterNeedle = new MeterNeedle[n2];
        n2 -= 2;
        while (n2 >= 0) {
            arrvalueDataset[n2] = this.datasets[n2];
            arrmeterNeedle[n2] = this.seriesNeedle[n2];
            --n2;
        }
        n2 = this.datasets.length;
        arrvalueDataset[n2] = valueDataset;
        arrmeterNeedle[n2] = meterNeedle != null ? meterNeedle : arrmeterNeedle[n2 - 1];
        ValueDataset[] arrvalueDataset2 = this.datasets;
        MeterNeedle[] arrmeterNeedle2 = this.seriesNeedle;
        this.datasets = arrvalueDataset;
        this.seriesNeedle = arrmeterNeedle;
        --n2;
        do {
            if (n2 < 0) {
                valueDataset.addChangeListener(this);
                return;
            }
            arrvalueDataset2[n2] = null;
            arrmeterNeedle2[n2] = null;
            --n2;
        } while (true);
    }

    @Override
    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D, Point2D point2D, PlotState plotState, PlotRenderingInfo plotRenderingInfo) {
        int n2;
        double d2;
        int n3;
        int n4 = 0;
        int n5 = 0;
        if (plotRenderingInfo != null) {
            plotRenderingInfo.setPlotArea(rectangle2D);
        }
        RectangleInsets rectangleInsets = this.getInsets();
        rectangleInsets.trim(rectangle2D);
        if (this.drawBorder) {
            this.drawBackground(graphics2D, rectangle2D);
        }
        int n6 = (int)(rectangle2D.getWidth() / 2.0);
        int n7 = (int)(rectangle2D.getHeight() / 2.0);
        int n8 = n6;
        if (n7 < n6) {
            n8 = n7;
        }
        int n9 = 2 * --n8;
        this.circle1.setFrame((n6 += (int)rectangle2D.getMinX()) - n8, (n7 += (int)rectangle2D.getMinY()) - n8, n9, n9);
        this.circle2.setFrame(n6 - n8 + 15, n7 - n8 + 15, n9 - 30, n9 - 30);
        graphics2D.setPaint(this.rosePaint);
        this.a1 = new Area(this.circle1);
        this.a2 = new Area(this.circle2);
        this.a1.subtract(this.a2);
        graphics2D.fill(this.a1);
        graphics2D.setPaint(this.roseCenterPaint);
        int n10 = n9 - 30;
        graphics2D.fillOval(n6 - n8 + 15, n7 - n8 + 15, n10, n10);
        graphics2D.setPaint(this.roseHighlightPaint);
        graphics2D.drawOval(n6 - n8, n7 - n8, n9, n9);
        n10 = n9 - 20;
        graphics2D.drawOval(n6 - n8 + 10, n7 - n8 + 10, n10, n10);
        n10 = n9 - 30;
        graphics2D.drawOval(n6 - n8 + 15, n7 - n8 + 15, n10, n10);
        n10 = n9 - 80;
        graphics2D.drawOval(n6 - n8 + 40, n7 - n8 + 40, n10, n10);
        n4 = n8 - 20;
        n5 = n8 - 32;
        for (n3 = 0; n3 < 360; n3 += 15) {
            d2 = Math.toRadians(n3);
            n10 = n6 - (int)(Math.sin(d2) * (double)n5);
            int n11 = n6 - (int)(Math.sin(d2) * (double)n4);
            n2 = n7 - (int)(Math.cos(d2) * (double)n5);
            int n12 = n7 - (int)(Math.cos(d2) * (double)n4);
            graphics2D.drawLine(n10, n2, n11, n12);
        }
        graphics2D.setPaint(this.roseHighlightPaint);
        n5 = n8 - 26;
        n4 = 7;
        for (n3 = 45; n3 < 360; n3 += 90) {
            d2 = Math.toRadians(n3);
            n10 = n6 - (int)(Math.sin(d2) * (double)n5);
            n2 = n7 - (int)(Math.cos(d2) * (double)n5);
            graphics2D.fillOval(n10 - n4, n2 - n4, 2 * n4, 2 * n4);
        }
        for (n3 = 0; n3 < 360; n3 += 90) {
            d2 = Math.toRadians(n3);
            n10 = n6 - (int)(Math.sin(d2) * (double)n5);
            n2 = n7 - (int)(Math.cos(d2) * (double)n5);
            Polygon polygon = new Polygon();
            polygon.addPoint(n10 - n4, n2);
            polygon.addPoint(n10, n2 + n4);
            polygon.addPoint(n10 + n4, n2);
            polygon.addPoint(n10, n2 - n4);
            graphics2D.fillPolygon(polygon);
        }
        n5 = n8 - 42;
        Font font = this.getCompassFont(n8);
        graphics2D.setFont(font);
        graphics2D.drawString("N", n6 - 5, n7 - n5 + font.getSize());
        graphics2D.drawString("S", n6 - 5, n7 + n5 - 5);
        graphics2D.drawString("W", n6 - n5 + 5, n7 + 5);
        graphics2D.drawString("E", n6 + n5 - font.getSize(), n7 + 5);
        n2 = n8 / 2;
        n10 = n8 / 6;
        Rectangle2D.Double double_ = new Rectangle2D.Double(n6 - n10, n7 - n2, 2 * n10, 2 * n2);
        int n11 = this.seriesNeedle.length;
        int n12 = 0;
        double d3 = 0.0;
        int n13 = this.datasets.length - 1;
        do {
            if (n13 < 0) {
                if (!this.drawBorder) return;
                this.drawOutline(graphics2D, rectangle2D);
                return;
            }
            ValueDataset valueDataset = this.datasets[n13];
            if (valueDataset != null && valueDataset.getValue() != null) {
                d3 = valueDataset.getValue().doubleValue() % this.revolutionDistance;
                d3 = d3 / this.revolutionDistance * 360.0;
                n12 = n13 % n11;
                this.seriesNeedle[n12].draw(graphics2D, double_, d3);
            }
            --n13;
        } while (true);
    }

    @Override
    public String getPlotType() {
        return localizationResources.getString("Compass_Plot");
    }

    @Override
    public LegendItemCollection getLegendItems() {
        return null;
    }

    @Override
    public void zoom(double d2) {
    }

    protected Font getCompassFont(int n2) {
        float f2 = (float)n2 / 10.0f;
        if (f2 >= 8.0f) return this.compassFont.deriveFont(f2);
        f2 = 8.0f;
        return this.compassFont.deriveFont(f2);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof CompassPlot)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        CompassPlot compassPlot = (CompassPlot)object;
        if (this.labelType != compassPlot.labelType) {
            return false;
        }
        if (!ObjectUtilities.equal(this.labelFont, compassPlot.labelFont)) {
            return false;
        }
        if (this.drawBorder != compassPlot.drawBorder) {
            return false;
        }
        if (!PaintUtilities.equal(this.roseHighlightPaint, compassPlot.roseHighlightPaint)) {
            return false;
        }
        if (!PaintUtilities.equal(this.rosePaint, compassPlot.rosePaint)) {
            return false;
        }
        if (!PaintUtilities.equal(this.roseCenterPaint, compassPlot.roseCenterPaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.compassFont, compassPlot.compassFont)) {
            return false;
        }
        if (!Arrays.equals(this.seriesNeedle, compassPlot.seriesNeedle)) {
            return false;
        }
        if (this.getRevolutionDistance() == compassPlot.getRevolutionDistance()) return true;
        return false;
    }

    @Override
    public Object clone() {
        CompassPlot compassPlot = (CompassPlot)super.clone();
        if (this.circle1 != null) {
            compassPlot.circle1 = (Ellipse2D)this.circle1.clone();
        }
        if (this.circle2 != null) {
            compassPlot.circle2 = (Ellipse2D)this.circle2.clone();
        }
        if (this.a1 != null) {
            compassPlot.a1 = (Area)this.a1.clone();
        }
        if (this.a2 != null) {
            compassPlot.a2 = (Area)this.a2.clone();
        }
        if (this.rect1 != null) {
            compassPlot.rect1 = (Rectangle2D)this.rect1.clone();
        }
        compassPlot.datasets = (ValueDataset[])this.datasets.clone();
        compassPlot.seriesNeedle = (MeterNeedle[])this.seriesNeedle.clone();
        int n2 = 0;
        while (n2 < this.datasets.length) {
            if (compassPlot.datasets[n2] != null) {
                compassPlot.datasets[n2].addChangeListener(compassPlot);
            }
            ++n2;
        }
        return compassPlot;
    }

    public void setRevolutionDistance(double d2) {
        if (d2 <= 0.0) return;
        this.revolutionDistance = d2;
    }

    public double getRevolutionDistance() {
        return this.revolutionDistance;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.rosePaint, objectOutputStream);
        SerialUtilities.writePaint(this.roseCenterPaint, objectOutputStream);
        SerialUtilities.writePaint(this.roseHighlightPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.rosePaint = SerialUtilities.readPaint(objectInputStream);
        this.roseCenterPaint = SerialUtilities.readPaint(objectInputStream);
        this.roseHighlightPaint = SerialUtilities.readPaint(objectInputStream);
    }
}

