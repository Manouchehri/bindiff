/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import java.awt.Paint;
import org.jfree.chart.renderer.category.BarRenderer3D;

public class ChartBarRenderer
extends BarRenderer3D {
    private final Paint[] colors;

    public ChartBarRenderer(Paint[] arrpaint) {
        this.colors = arrpaint;
    }

    @Override
    public Paint getItemPaint(int n2, int n3) {
        return this.colors[n3 % this.colors.length];
    }
}

