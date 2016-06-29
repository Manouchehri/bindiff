/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer;

import java.awt.Color;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.plot.DrawingSupplier;
import org.jfree.chart.plot.WaferMapPlot;
import org.jfree.chart.renderer.AbstractRenderer;
import org.jfree.data.general.WaferMapDataset;

public class WaferMapRenderer
extends AbstractRenderer {
    private Map paintIndex = new HashMap();
    private WaferMapPlot plot;
    private int paintLimit;
    private static final int DEFAULT_PAINT_LIMIT = 35;
    public static final int POSITION_INDEX = 0;
    public static final int VALUE_INDEX = 1;
    private int paintIndexMethod;

    public WaferMapRenderer() {
        this(null, null);
    }

    public WaferMapRenderer(int n2, int n3) {
        this(new Integer(n2), new Integer(n3));
    }

    public WaferMapRenderer(Integer n2, Integer n3) {
        this.paintLimit = n2 == null ? 35 : n2;
        this.paintIndexMethod = 1;
        if (n3 == null) return;
        if (!this.isMethodValid(n3)) return;
        this.paintIndexMethod = n3;
    }

    private boolean isMethodValid(int n2) {
        switch (n2) {
            case 0: {
                return true;
            }
            case 1: {
                return true;
            }
        }
        return false;
    }

    @Override
    public DrawingSupplier getDrawingSupplier() {
        DrawingSupplier drawingSupplier = null;
        WaferMapPlot waferMapPlot = this.getPlot();
        if (waferMapPlot == null) return drawingSupplier;
        return waferMapPlot.getDrawingSupplier();
    }

    public WaferMapPlot getPlot() {
        return this.plot;
    }

    public void setPlot(WaferMapPlot waferMapPlot) {
        this.plot = waferMapPlot;
        this.makePaintIndex();
    }

    public Paint getChipColor(Number number) {
        return this.getSeriesPaint(this.getPaintIndex(number));
    }

    private int getPaintIndex(Number number) {
        return (Integer)this.paintIndex.get(number);
    }

    /*
     * Unable to fully structure code
     */
    private void makePaintIndex() {
        if (this.plot == null) {
            return;
        }
        var1_1 = this.plot.getDataset();
        var2_2 = var1_1.getMinValue();
        var3_3 = var1_1.getMaxValue();
        var4_4 = var1_1.getUniqueValues();
        if (var4_4.size() <= this.paintLimit) {
            var5_5 = 0;
            var6_6 = var4_4.iterator();
            while (var6_6.hasNext() != false) {
                this.paintIndex.put(var6_6.next(), new Integer(var5_5++));
            }
            return;
        }
        switch (this.paintIndexMethod) {
            case 0: {
                this.makePositionIndex(var4_4);
                return;
            }
            case 1: {
                this.makeValueIndex(var3_3, var2_2, var4_4);
                ** break;
            }
        }
lbl21: // 2 sources:
    }

    private void makePositionIndex(Set set) {
        int n2 = (int)Math.ceil((double)set.size() / (double)this.paintLimit);
        int n3 = 0;
        int n4 = 0;
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            this.paintIndex.put(iterator.next(), new Integer(n4));
            if (++n3 % n2 == 0) {
                ++n4;
            }
            if (n4 <= this.paintLimit) continue;
            n4 = this.paintLimit;
        }
    }

    private void makeValueIndex(Number number, Number number2, Set set) {
        double d2 = number.doubleValue() - number2.doubleValue();
        double d3 = d2 / (double)this.paintLimit;
        int n2 = 0;
        double d4 = number2.doubleValue() + d3;
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Number number3 = (Number)iterator.next();
            while (number3.doubleValue() > d4) {
                d4 += d3;
                if (++n2 <= this.paintLimit) continue;
                n2 = this.paintLimit;
            }
            this.paintIndex.put(number3, new Integer(n2));
        }
    }

    public LegendItemCollection getLegendCollection() {
        LegendItemCollection legendItemCollection = new LegendItemCollection();
        if (this.paintIndex == null) return legendItemCollection;
        if (this.paintIndex.size() <= 0) return legendItemCollection;
        if (this.paintIndex.size() <= this.paintLimit) {
            Iterator iterator = this.paintIndex.entrySet().iterator();
            while (iterator.hasNext()) {
                String string;
                Map.Entry entry = iterator.next();
                String string2 = string = entry.getKey().toString();
                Rectangle2D.Double double_ = new Rectangle2D.Double(1.0, 1.0, 1.0, 1.0);
                Paint paint = this.getSeriesPaint((Integer)entry.getValue());
                Color color = Color.black;
                Stroke stroke = DEFAULT_STROKE;
                legendItemCollection.add(new LegendItem(string, string2, null, null, (Shape)double_, paint, stroke, (Paint)color));
            }
            return legendItemCollection;
        }
        HashSet hashSet = new HashSet();
        Iterator iterator = this.paintIndex.entrySet().iterator();
        while (iterator.hasNext()) {
            String string;
            Map.Entry entry = iterator.next();
            if (!hashSet.add(entry.getValue())) continue;
            String string3 = string = new StringBuffer().append(this.getMinPaintValue((Integer)entry.getValue()).toString()).append(" - ").append(this.getMaxPaintValue((Integer)entry.getValue()).toString()).toString();
            Rectangle2D.Double double_ = new Rectangle2D.Double(1.0, 1.0, 1.0, 1.0);
            Paint paint = this.getSeriesPaint((Integer)entry.getValue());
            Color color = Color.black;
            Stroke stroke = DEFAULT_STROKE;
            legendItemCollection.add(new LegendItem(string, string3, null, null, (Shape)double_, paint, stroke, (Paint)color));
        }
        return legendItemCollection;
    }

    private Number getMinPaintValue(Integer n2) {
        double d2 = Double.POSITIVE_INFINITY;
        Iterator iterator = this.paintIndex.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            if (!((Integer)entry.getValue()).equals(n2) || ((Number)entry.getKey()).doubleValue() >= d2) continue;
            d2 = ((Number)entry.getKey()).doubleValue();
        }
        return new Double(d2);
    }

    private Number getMaxPaintValue(Integer n2) {
        double d2 = Double.NEGATIVE_INFINITY;
        Iterator iterator = this.paintIndex.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            if (!((Integer)entry.getValue()).equals(n2) || ((Number)entry.getKey()).doubleValue() <= d2) continue;
            d2 = ((Number)entry.getKey()).doubleValue();
        }
        return new Double(d2);
    }
}

