/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.category;

import java.awt.geom.Line2D;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.category.CategoryItemRendererState;

public class CategoryStepRenderer$State
extends CategoryItemRendererState {
    public Line2D line = new Line2D.Double();

    public CategoryStepRenderer$State(PlotRenderingInfo plotRenderingInfo) {
        super(plotRenderingInfo);
    }
}

