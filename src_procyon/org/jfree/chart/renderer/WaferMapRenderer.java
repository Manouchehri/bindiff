package org.jfree.chart.renderer;

import org.jfree.chart.plot.*;
import org.jfree.data.general.*;
import java.awt.geom.*;
import org.jfree.chart.*;
import java.awt.*;
import java.util.*;

public class WaferMapRenderer extends AbstractRenderer
{
    private Map paintIndex;
    private WaferMapPlot plot;
    private int paintLimit;
    private static final int DEFAULT_PAINT_LIMIT = 35;
    public static final int POSITION_INDEX = 0;
    public static final int VALUE_INDEX = 1;
    private int paintIndexMethod;
    
    public WaferMapRenderer() {
        this(null, null);
    }
    
    public WaferMapRenderer(final int n, final int n2) {
        this(new Integer(n), new Integer(n2));
    }
    
    public WaferMapRenderer(final Integer n, final Integer n2) {
        this.paintIndex = new HashMap();
        if (n == null) {
            this.paintLimit = 35;
        }
        else {
            this.paintLimit = n;
        }
        this.paintIndexMethod = 1;
        if (n2 != null && this.isMethodValid(n2)) {
            this.paintIndexMethod = n2;
        }
    }
    
    private boolean isMethodValid(final int n) {
        switch (n) {
            case 0: {
                return true;
            }
            case 1: {
                return true;
            }
            default: {
                return false;
            }
        }
    }
    
    public DrawingSupplier getDrawingSupplier() {
        DrawingSupplier drawingSupplier = null;
        final WaferMapPlot plot = this.getPlot();
        if (plot != null) {
            drawingSupplier = plot.getDrawingSupplier();
        }
        return drawingSupplier;
    }
    
    public WaferMapPlot getPlot() {
        return this.plot;
    }
    
    public void setPlot(final WaferMapPlot plot) {
        this.plot = plot;
        this.makePaintIndex();
    }
    
    public Paint getChipColor(final Number n) {
        return this.getSeriesPaint(this.getPaintIndex(n));
    }
    
    private int getPaintIndex(final Number n) {
        return this.paintIndex.get(n);
    }
    
    private void makePaintIndex() {
        if (this.plot == null) {
            return;
        }
        final WaferMapDataset dataset = this.plot.getDataset();
        final Number minValue = dataset.getMinValue();
        final Number maxValue = dataset.getMaxValue();
        final Set uniqueValues = dataset.getUniqueValues();
        if (uniqueValues.size() <= this.paintLimit) {
            int n = 0;
            final Iterator<Object> iterator = uniqueValues.iterator();
            while (iterator.hasNext()) {
                this.paintIndex.put(iterator.next(), new Integer(n++));
            }
        }
        else {
            switch (this.paintIndexMethod) {
                case 0: {
                    this.makePositionIndex(uniqueValues);
                    break;
                }
                case 1: {
                    this.makeValueIndex(maxValue, minValue, uniqueValues);
                    break;
                }
            }
        }
    }
    
    private void makePositionIndex(final Set set) {
        final int n = (int)Math.ceil(set.size() / this.paintLimit);
        int n2 = 0;
        int paintLimit = 0;
        final Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()) {
            this.paintIndex.put(iterator.next(), new Integer(paintLimit));
            if (++n2 % n == 0) {
                ++paintLimit;
            }
            if (paintLimit > this.paintLimit) {
                paintLimit = this.paintLimit;
            }
        }
    }
    
    private void makeValueIndex(final Number n, final Number n2, final Set set) {
        final double n3 = (n.doubleValue() - n2.doubleValue()) / this.paintLimit;
        int paintLimit = 0;
        double n4 = n2.doubleValue() + n3;
        for (final Number n5 : set) {
            while (n5.doubleValue() > n4) {
                n4 += n3;
                if (++paintLimit > this.paintLimit) {
                    paintLimit = this.paintLimit;
                }
            }
            this.paintIndex.put(n5, new Integer(paintLimit));
        }
    }
    
    public LegendItemCollection getLegendCollection() {
        final LegendItemCollection collection = new LegendItemCollection();
        if (this.paintIndex != null && this.paintIndex.size() > 0) {
            if (this.paintIndex.size() <= this.paintLimit) {
                for (final Map.Entry<Object, V> entry : this.paintIndex.entrySet()) {
                    final String string = entry.getKey().toString();
                    collection.add(new LegendItem(string, string, null, null, new Rectangle2D.Double(1.0, 1.0, 1.0, 1.0), this.getSeriesPaint(entry.getValue()), WaferMapRenderer.DEFAULT_STROKE, Color.black));
                }
            }
            else {
                final HashSet<Object> set = new HashSet<Object>();
                for (final Map.Entry<K, Object> entry2 : this.paintIndex.entrySet()) {
                    if (set.add(entry2.getValue())) {
                        final String string2 = this.getMinPaintValue(entry2.getValue()).toString() + " - " + this.getMaxPaintValue(entry2.getValue()).toString();
                        collection.add(new LegendItem(string2, string2, null, null, new Rectangle2D.Double(1.0, 1.0, 1.0, 1.0), this.getSeriesPaint(entry2.getValue()), WaferMapRenderer.DEFAULT_STROKE, Color.black));
                    }
                }
            }
        }
        return collection;
    }
    
    private Number getMinPaintValue(final Integer n) {
        double doubleValue = Double.POSITIVE_INFINITY;
        for (final Map.Entry<K, Integer> entry : this.paintIndex.entrySet()) {
            if (entry.getValue().equals(n) && ((Number)entry.getKey()).doubleValue() < doubleValue) {
                doubleValue = entry.getKey().doubleValue();
            }
        }
        return new Double(doubleValue);
    }
    
    private Number getMaxPaintValue(final Integer n) {
        double doubleValue = Double.NEGATIVE_INFINITY;
        for (final Map.Entry<K, Integer> entry : this.paintIndex.entrySet()) {
            if (entry.getValue().equals(n) && ((Number)entry.getKey()).doubleValue() > doubleValue) {
                doubleValue = entry.getKey().doubleValue();
            }
        }
        return new Double(doubleValue);
    }
}
