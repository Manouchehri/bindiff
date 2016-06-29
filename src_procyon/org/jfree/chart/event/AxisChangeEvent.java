package org.jfree.chart.event;

import org.jfree.chart.axis.*;

public class AxisChangeEvent extends ChartChangeEvent
{
    private Axis axis;
    
    public AxisChangeEvent(final Axis axis) {
        super(axis);
        this.axis = axis;
    }
    
    public Axis getAxis() {
        return this.axis;
    }
}
