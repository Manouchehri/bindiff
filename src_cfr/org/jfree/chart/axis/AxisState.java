/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.util.ArrayList;
import java.util.List;
import org.jfree.ui.RectangleEdge;

public class AxisState {
    private double cursor;
    private List ticks;
    private double max;

    public AxisState() {
        this(0.0);
    }

    public AxisState(double d2) {
        this.cursor = d2;
        this.ticks = new ArrayList();
    }

    public double getCursor() {
        return this.cursor;
    }

    public void setCursor(double d2) {
        this.cursor = d2;
    }

    public void moveCursor(double d2, RectangleEdge rectangleEdge) {
        if (rectangleEdge == RectangleEdge.TOP) {
            this.cursorUp(d2);
            return;
        }
        if (rectangleEdge == RectangleEdge.BOTTOM) {
            this.cursorDown(d2);
            return;
        }
        if (rectangleEdge == RectangleEdge.LEFT) {
            this.cursorLeft(d2);
            return;
        }
        if (rectangleEdge != RectangleEdge.RIGHT) return;
        this.cursorRight(d2);
    }

    public void cursorUp(double d2) {
        this.cursor -= d2;
    }

    public void cursorDown(double d2) {
        this.cursor += d2;
    }

    public void cursorLeft(double d2) {
        this.cursor -= d2;
    }

    public void cursorRight(double d2) {
        this.cursor += d2;
    }

    public List getTicks() {
        return this.ticks;
    }

    public void setTicks(List list) {
        this.ticks = list;
    }

    public double getMax() {
        return this.max;
    }

    public void setMax(double d2) {
        this.max = d2;
    }
}

