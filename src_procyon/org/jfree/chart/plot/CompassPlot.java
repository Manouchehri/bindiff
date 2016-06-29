package org.jfree.chart.plot;

import org.jfree.data.general.*;
import org.jfree.chart.event.*;
import org.jfree.chart.needle.*;
import java.awt.geom.*;
import java.awt.*;
import org.jfree.chart.*;
import org.jfree.util.*;
import java.util.*;
import org.jfree.io.*;
import java.io.*;

public class CompassPlot extends Plot implements Serializable, Cloneable
{
    private static final long serialVersionUID = 6924382802125527395L;
    public static final Font DEFAULT_LABEL_FONT;
    public static final int NO_LABELS = 0;
    public static final int VALUE_LABELS = 1;
    private int labelType;
    private Font labelFont;
    private boolean drawBorder;
    private transient Paint roseHighlightPaint;
    private transient Paint rosePaint;
    private transient Paint roseCenterPaint;
    private Font compassFont;
    private transient Ellipse2D circle1;
    private transient Ellipse2D circle2;
    private transient Area a1;
    private transient Area a2;
    private transient Rectangle2D rect1;
    private ValueDataset[] datasets;
    private MeterNeedle[] seriesNeedle;
    protected static ResourceBundle localizationResources;
    protected double revolutionDistance;
    
    public CompassPlot() {
        this(new DefaultValueDataset());
    }
    
    public CompassPlot(final ValueDataset valueDataset) {
        this.drawBorder = false;
        this.roseHighlightPaint = Color.black;
        this.rosePaint = Color.yellow;
        this.roseCenterPaint = Color.white;
        this.compassFont = new Font("Arial", 0, 10);
        this.datasets = new ValueDataset[1];
        this.seriesNeedle = new MeterNeedle[1];
        this.revolutionDistance = 360.0;
        if (valueDataset != null) {
            (this.datasets[0] = valueDataset).addChangeListener(this);
        }
        this.circle1 = new Ellipse2D.Double();
        this.circle2 = new Ellipse2D.Double();
        this.rect1 = new Rectangle2D.Double();
        this.setSeriesNeedle(0);
    }
    
    public int getLabelType() {
        return this.labelType;
    }
    
    public void setLabelType(final int labelType) {
        if (labelType != 0 && labelType != 1) {
            throw new IllegalArgumentException("MeterPlot.setLabelType(int): unrecognised type.");
        }
        if (this.labelType != labelType) {
            this.labelType = labelType;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public Font getLabelFont() {
        return this.labelFont;
    }
    
    public void setLabelFont(final Font labelFont) {
        if (labelFont == null) {
            throw new IllegalArgumentException("Null 'font' not allowed.");
        }
        this.labelFont = labelFont;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getRosePaint() {
        return this.rosePaint;
    }
    
    public void setRosePaint(final Paint rosePaint) {
        if (rosePaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.rosePaint = rosePaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getRoseCenterPaint() {
        return this.roseCenterPaint;
    }
    
    public void setRoseCenterPaint(final Paint roseCenterPaint) {
        if (roseCenterPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.roseCenterPaint = roseCenterPaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getRoseHighlightPaint() {
        return this.roseHighlightPaint;
    }
    
    public void setRoseHighlightPaint(final Paint roseHighlightPaint) {
        if (roseHighlightPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.roseHighlightPaint = roseHighlightPaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public boolean getDrawBorder() {
        return this.drawBorder;
    }
    
    public void setDrawBorder(final boolean drawBorder) {
        this.drawBorder = drawBorder;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public void setSeriesPaint(final int n, final Paint fillPaint) {
        if (n >= 0 && n < this.seriesNeedle.length) {
            this.seriesNeedle[n].setFillPaint(fillPaint);
        }
    }
    
    public void setSeriesOutlinePaint(final int n, final Paint outlinePaint) {
        if (n >= 0 && n < this.seriesNeedle.length) {
            this.seriesNeedle[n].setOutlinePaint(outlinePaint);
        }
    }
    
    public void setSeriesOutlineStroke(final int n, final Stroke outlineStroke) {
        if (n >= 0 && n < this.seriesNeedle.length) {
            this.seriesNeedle[n].setOutlineStroke(outlineStroke);
        }
    }
    
    public void setSeriesNeedle(final int n) {
        this.setSeriesNeedle(0, n);
    }
    
    public void setSeriesNeedle(final int n, final int n2) {
        switch (n2) {
            case 0: {
                this.setSeriesNeedle(n, new ArrowNeedle(true));
                this.setSeriesPaint(n, Color.red);
                this.seriesNeedle[n].setHighlightPaint(Color.white);
                break;
            }
            case 1: {
                this.setSeriesNeedle(n, new LineNeedle());
                break;
            }
            case 2: {
                final LongNeedle longNeedle = new LongNeedle();
                longNeedle.setRotateY(0.5);
                this.setSeriesNeedle(n, longNeedle);
                break;
            }
            case 3: {
                this.setSeriesNeedle(n, new PinNeedle());
                break;
            }
            case 4: {
                this.setSeriesNeedle(n, new PlumNeedle());
                break;
            }
            case 5: {
                this.setSeriesNeedle(n, new PointerNeedle());
                break;
            }
            case 6: {
                this.setSeriesPaint(n, null);
                this.setSeriesOutlineStroke(n, new BasicStroke(3.0f));
                this.setSeriesNeedle(n, new ShipNeedle());
                break;
            }
            case 7: {
                this.setSeriesPaint(n, Color.blue);
                this.setSeriesNeedle(n, new WindNeedle());
                break;
            }
            case 8: {
                this.setSeriesNeedle(n, new ArrowNeedle(true));
                break;
            }
            case 9: {
                this.setSeriesNeedle(n, new MiddlePinNeedle());
                break;
            }
            default: {
                throw new IllegalArgumentException("Unrecognised type.");
            }
        }
    }
    
    public void setSeriesNeedle(final int n, final MeterNeedle meterNeedle) {
        if (meterNeedle != null && n < this.seriesNeedle.length) {
            this.seriesNeedle[n] = meterNeedle;
        }
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public ValueDataset[] getDatasets() {
        return this.datasets;
    }
    
    public void addDataset(final ValueDataset valueDataset) {
        this.addDataset(valueDataset, null);
    }
    
    public void addDataset(final ValueDataset valueDataset, final MeterNeedle meterNeedle) {
        if (valueDataset != null) {
            final int n = this.datasets.length + 1;
            final ValueDataset[] datasets = new ValueDataset[n];
            final MeterNeedle[] seriesNeedle = new MeterNeedle[n];
            for (int i = n - 2; i >= 0; --i) {
                datasets[i] = this.datasets[i];
                seriesNeedle[i] = this.seriesNeedle[i];
            }
            int j = this.datasets.length;
            datasets[j] = valueDataset;
            seriesNeedle[j] = ((meterNeedle != null) ? meterNeedle : seriesNeedle[j - 1]);
            final ValueDataset[] datasets2 = this.datasets;
            final MeterNeedle[] seriesNeedle2 = this.seriesNeedle;
            this.datasets = datasets;
            this.seriesNeedle = seriesNeedle;
            --j;
            while (j >= 0) {
                datasets2[j] = null;
                seriesNeedle2[j] = null;
                --j;
            }
            valueDataset.addChangeListener(this);
        }
    }
    
    public void draw(final Graphics2D graphics2D, final Rectangle2D plotArea, final Point2D point2D, final PlotState plotState, final PlotRenderingInfo plotRenderingInfo) {
        if (plotRenderingInfo != null) {
            plotRenderingInfo.setPlotArea(plotArea);
        }
        this.getInsets().trim(plotArea);
        if (this.drawBorder) {
            this.drawBackground(graphics2D, plotArea);
        }
        final int n = (int)(plotArea.getWidth() / 2.0);
        final int n2 = (int)(plotArea.getHeight() / 2.0);
        int n3;
        if (n2 < (n3 = n)) {
            n3 = n2;
        }
        --n3;
        final int n4 = 2 * n3;
        final int n5 = n + (int)plotArea.getMinX();
        final int n6 = n2 + (int)plotArea.getMinY();
        this.circle1.setFrame(n5 - n3, n6 - n3, n4, n4);
        this.circle2.setFrame(n5 - n3 + 15, n6 - n3 + 15, n4 - 30, n4 - 30);
        graphics2D.setPaint(this.rosePaint);
        this.a1 = new Area(this.circle1);
        this.a2 = new Area(this.circle2);
        this.a1.subtract(this.a2);
        graphics2D.fill(this.a1);
        graphics2D.setPaint(this.roseCenterPaint);
        final int n7 = n4 - 30;
        graphics2D.fillOval(n5 - n3 + 15, n6 - n3 + 15, n7, n7);
        graphics2D.setPaint(this.roseHighlightPaint);
        graphics2D.drawOval(n5 - n3, n6 - n3, n4, n4);
        final int n8 = n4 - 20;
        graphics2D.drawOval(n5 - n3 + 10, n6 - n3 + 10, n8, n8);
        final int n9 = n4 - 30;
        graphics2D.drawOval(n5 - n3 + 15, n6 - n3 + 15, n9, n9);
        final int n10 = n4 - 80;
        graphics2D.drawOval(n5 - n3 + 40, n6 - n3 + 40, n10, n10);
        final int n11 = n3 - 20;
        final int n12 = n3 - 32;
        for (int i = 0; i < 360; i += 15) {
            final double radians = Math.toRadians(i);
            graphics2D.drawLine(n5 - (int)(Math.sin(radians) * n12), n6 - (int)(Math.cos(radians) * n12), n5 - (int)(Math.sin(radians) * n11), n6 - (int)(Math.cos(radians) * n11));
        }
        graphics2D.setPaint(this.roseHighlightPaint);
        final int n13 = n3 - 26;
        final int n14 = 7;
        for (int j = 45; j < 360; j += 90) {
            final double radians2 = Math.toRadians(j);
            graphics2D.fillOval(n5 - (int)(Math.sin(radians2) * n13) - n14, n6 - (int)(Math.cos(radians2) * n13) - n14, 2 * n14, 2 * n14);
        }
        for (int k = 0; k < 360; k += 90) {
            final double radians3 = Math.toRadians(k);
            final int n15 = n5 - (int)(Math.sin(radians3) * n13);
            final int n16 = n6 - (int)(Math.cos(radians3) * n13);
            final Polygon polygon = new Polygon();
            polygon.addPoint(n15 - n14, n16);
            polygon.addPoint(n15, n16 + n14);
            polygon.addPoint(n15 + n14, n16);
            polygon.addPoint(n15, n16 - n14);
            graphics2D.fillPolygon(polygon);
        }
        final int n17 = n3 - 42;
        final Font compassFont = this.getCompassFont(n3);
        graphics2D.setFont(compassFont);
        graphics2D.drawString("N", n5 - 5, n6 - n17 + compassFont.getSize());
        graphics2D.drawString("S", n5 - 5, n6 + n17 - 5);
        graphics2D.drawString("W", n5 - n17 + 5, n6 + 5);
        graphics2D.drawString("E", n5 + n17 - compassFont.getSize(), n6 + 5);
        final int n18 = n3 / 2;
        final int n19 = n3 / 6;
        final Rectangle2D.Double double1 = new Rectangle2D.Double(n5 - n19, n6 - n18, 2 * n19, 2 * n18);
        final int length = this.seriesNeedle.length;
        for (int l = this.datasets.length - 1; l >= 0; --l) {
            final ValueDataset valueDataset = this.datasets[l];
            if (valueDataset != null && valueDataset.getValue() != null) {
                this.seriesNeedle[l % length].draw(graphics2D, double1, valueDataset.getValue().doubleValue() % this.revolutionDistance / this.revolutionDistance * 360.0);
            }
        }
        if (this.drawBorder) {
            this.drawOutline(graphics2D, plotArea);
        }
    }
    
    public String getPlotType() {
        return CompassPlot.localizationResources.getString("Compass_Plot");
    }
    
    public LegendItemCollection getLegendItems() {
        return null;
    }
    
    public void zoom(final double n) {
    }
    
    protected Font getCompassFont(final int n) {
        float n2 = n / 10.0f;
        if (n2 < 8.0f) {
            n2 = 8.0f;
        }
        return this.compassFont.deriveFont(n2);
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CompassPlot)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final CompassPlot compassPlot = (CompassPlot)o;
        return this.labelType == compassPlot.labelType && ObjectUtilities.equal(this.labelFont, compassPlot.labelFont) && this.drawBorder == compassPlot.drawBorder && PaintUtilities.equal(this.roseHighlightPaint, compassPlot.roseHighlightPaint) && PaintUtilities.equal(this.rosePaint, compassPlot.rosePaint) && PaintUtilities.equal(this.roseCenterPaint, compassPlot.roseCenterPaint) && ObjectUtilities.equal(this.compassFont, compassPlot.compassFont) && Arrays.equals(this.seriesNeedle, compassPlot.seriesNeedle) && this.getRevolutionDistance() == compassPlot.getRevolutionDistance();
    }
    
    public Object clone() {
        final CompassPlot compassPlot = (CompassPlot)super.clone();
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
        compassPlot.datasets = this.datasets.clone();
        compassPlot.seriesNeedle = this.seriesNeedle.clone();
        for (int i = 0; i < this.datasets.length; ++i) {
            if (compassPlot.datasets[i] != null) {
                compassPlot.datasets[i].addChangeListener(compassPlot);
            }
        }
        return compassPlot;
    }
    
    public void setRevolutionDistance(final double revolutionDistance) {
        if (revolutionDistance > 0.0) {
            this.revolutionDistance = revolutionDistance;
        }
    }
    
    public double getRevolutionDistance() {
        return this.revolutionDistance;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.rosePaint, objectOutputStream);
        SerialUtilities.writePaint(this.roseCenterPaint, objectOutputStream);
        SerialUtilities.writePaint(this.roseHighlightPaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.rosePaint = SerialUtilities.readPaint(objectInputStream);
        this.roseCenterPaint = SerialUtilities.readPaint(objectInputStream);
        this.roseHighlightPaint = SerialUtilities.readPaint(objectInputStream);
    }
    
    static {
        DEFAULT_LABEL_FONT = new Font("SansSerif", 1, 10);
        CompassPlot.localizationResources = ResourceBundle.getBundle("org.jfree.chart.plot.LocalizationBundle");
    }
}
