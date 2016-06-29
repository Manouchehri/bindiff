/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.event;

import java.util.EventObject;
import org.jfree.chart.JFreeChart;

public class ChartProgressEvent
extends EventObject {
    public static final int DRAWING_STARTED = 1;
    public static final int DRAWING_FINISHED = 2;
    private int type;
    private int percent;
    private JFreeChart chart;

    public ChartProgressEvent(Object object, JFreeChart jFreeChart, int n2, int n3) {
        super(object);
        this.chart = jFreeChart;
        this.type = n2;
    }

    public JFreeChart getChart() {
        return this.chart;
    }

    public void setChart(JFreeChart jFreeChart) {
        this.chart = jFreeChart;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int n2) {
        this.type = n2;
    }

    public int getPercent() {
        return this.percent;
    }

    public void setPercent(int n2) {
        this.percent = n2;
    }
}

