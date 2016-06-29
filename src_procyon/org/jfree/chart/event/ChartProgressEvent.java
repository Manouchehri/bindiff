package org.jfree.chart.event;

import java.util.*;
import org.jfree.chart.*;

public class ChartProgressEvent extends EventObject
{
    public static final int DRAWING_STARTED = 1;
    public static final int DRAWING_FINISHED = 2;
    private int type;
    private int percent;
    private JFreeChart chart;
    
    public ChartProgressEvent(final Object o, final JFreeChart chart, final int type, final int n) {
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
    
    public int getType() {
        return this.type;
    }
    
    public void setType(final int type) {
        this.type = type;
    }
    
    public int getPercent() {
        return this.percent;
    }
    
    public void setPercent(final int percent) {
        this.percent = percent;
    }
}
