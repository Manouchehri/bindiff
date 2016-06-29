package org.jfree.chart;

import java.util.*;
import java.io.*;
import java.awt.event.*;
import org.jfree.chart.entity.*;

public class ChartMouseEvent extends EventObject implements Serializable
{
    private static final long serialVersionUID = -682393837314562149L;
    private JFreeChart chart;
    private MouseEvent trigger;
    private ChartEntity entity;
    
    public ChartMouseEvent(final JFreeChart chart, final MouseEvent trigger, final ChartEntity entity) {
        super(chart);
        this.chart = chart;
        this.trigger = trigger;
        this.entity = entity;
    }
    
    public JFreeChart getChart() {
        return this.chart;
    }
    
    public MouseEvent getTrigger() {
        return this.trigger;
    }
    
    public ChartEntity getEntity() {
        return this.entity;
    }
}
