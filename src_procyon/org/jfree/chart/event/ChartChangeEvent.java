package org.jfree.chart.event;

import java.util.*;
import org.jfree.chart.*;

public class ChartChangeEvent extends EventObject
{
    private ChartChangeEventType type;
    private JFreeChart chart;
    
    public ChartChangeEvent(final Object o) {
        this(o, null, ChartChangeEventType.GENERAL);
    }
    
    public ChartChangeEvent(final Object o, final JFreeChart freeChart) {
        this(o, freeChart, ChartChangeEventType.GENERAL);
    }
    
    public ChartChangeEvent(final Object o, final JFreeChart chart, final ChartChangeEventType type) {
        super(o);
        this.chart = chart;
        this.type = type;
    }
    
    public JFreeChart getChart() {
        return this.chart;
    }
    
    public void setChart(final JFreeChart chart) {
        this.chart = chart;
    }
    
    public ChartChangeEventType getType() {
        return this.type;
    }
    
    public void setType(final ChartChangeEventType type) {
        this.type = type;
    }
}
