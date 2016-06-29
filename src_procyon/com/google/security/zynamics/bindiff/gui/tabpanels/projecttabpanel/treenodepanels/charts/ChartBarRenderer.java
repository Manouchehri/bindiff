package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import org.jfree.chart.renderer.category.*;
import java.awt.*;

public class ChartBarRenderer extends BarRenderer3D
{
    private final Paint[] colors;
    
    public ChartBarRenderer(final Paint[] colors) {
        this.colors = colors;
    }
    
    @Override
    public Paint getItemPaint(final int n, final int n2) {
        return this.colors[n2 % this.colors.length];
    }
}
