/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.event;

import java.util.EventObject;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.event.ChartChangeEventType;

public class ChartChangeEvent
extends EventObject {
    private ChartChangeEventType type;
    private JFreeChart chart;

    public ChartChangeEvent(Object object) {
        this(object, null, ChartChangeEventType.GENERAL);
    }

    public ChartChangeEvent(Object object, JFreeChart jFreeChart) {
        this(object, jFreeChart, ChartChangeEventType.GENERAL);
    }

    public ChartChangeEvent(Object object, JFreeChart jFreeChart, ChartChangeEventType chartChangeEventType) {
        super(object);
        this.chart = jFreeChart;
        this.type = chartChangeEventType;
    }

    public JFreeChart getChart() {
        return this.chart;
    }

    public void setChart(JFreeChart jFreeChart) {
        this.chart = jFreeChart;
    }

    public ChartChangeEventType getType() {
        return this.type;
    }

    public void setType(ChartChangeEventType chartChangeEventType) {
        this.type = chartChangeEventType;
    }
}

