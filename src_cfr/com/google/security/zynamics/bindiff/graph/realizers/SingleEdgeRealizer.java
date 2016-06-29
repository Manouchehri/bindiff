/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.realizers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IEdgeRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import y.h.x;
import y.h.y;

public class SingleEdgeRealizer
extends ZyEdgeRealizer {
    public static final Color BEND_SELECTION_COLOR = new Color(255, 200, 0);
    private final GraphSettings settings;

    public SingleEdgeRealizer(ZyLabelContent zyLabelContent, IEdgeRealizerUpdater iEdgeRealizerUpdater, GraphSettings graphSettings) {
        super(zyLabelContent, iEdgeRealizerUpdater);
        Preconditions.checkNotNull(graphSettings);
        this.settings = graphSettings;
        this.setSmoothedBends(true);
    }

    @Override
    public void paintBends(Graphics2D graphics2D) {
        if (!this.settings.getDrawBends()) return;
        y y2 = this.bends();
        while (y2.f()) {
            double d2 = y2.a().b();
            double d3 = y2.a().c();
            boolean bl2 = y2.a().d();
            Color color = graphics2D.getColor();
            Stroke stroke = graphics2D.getStroke();
            float f2 = bl2 ? 2.0f : 1.0f;
            int n2 = bl2 ? 7 : 5;
            float f3 = bl2 ? 3.0f : 2.0f;
            graphics2D.setStroke(new BasicStroke(f2));
            graphics2D.setColor(bl2 ? BEND_SELECTION_COLOR : Color.WHITE);
            graphics2D.fill(new Ellipse2D.Double(d2 - (double)f3, d3 - (double)f3, n2, n2));
            graphics2D.setColor(Color.BLACK);
            graphics2D.draw(new Ellipse2D.Double(d2 - (double)f3, d3 - (double)f3, n2, n2));
            graphics2D.setColor(color);
            graphics2D.setStroke(stroke);
            y2.g();
        }
    }
}

