package com.google.security.zynamics.bindiff.graph.realizers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import com.google.common.base.*;
import java.awt.geom.*;
import java.awt.*;
import y.h.*;

public class CombinedEdgeRealizer extends ZyEdgeRealizer
{
    private final GraphSettings settings;
    
    public CombinedEdgeRealizer(final ZyLabelContent zyLabelContent, final IEdgeRealizerUpdater edgeRealizerUpdater, final GraphSettings graphSettings) {
        super(zyLabelContent, edgeRealizerUpdater);
        this.settings = (GraphSettings)Preconditions.checkNotNull(graphSettings);
    }
    
    @Override
    public void paintBends(final Graphics2D graphics2D) {
        if (this.settings.getDrawBends()) {
            final y bends = this.bends();
            while (bends.f()) {
                final double b = bends.a().b();
                final double c = bends.a().c();
                final boolean d = bends.a().d();
                final Color color = graphics2D.getColor();
                final Stroke stroke = graphics2D.getStroke();
                final float n = d ? 2.0f : 1.0f;
                final int n2 = d ? 7 : 5;
                final float n3 = d ? 3.0f : 2.0f;
                graphics2D.setStroke(new BasicStroke(n));
                graphics2D.setColor(d ? SingleEdgeRealizer.BEND_SELECTION_COLOR : Color.WHITE);
                graphics2D.fill(new Ellipse2D.Double(b - n3, c - n3, n2, n2));
                graphics2D.setColor(Color.BLACK);
                graphics2D.draw(new Ellipse2D.Double(b - n3, c - n3, n2, n2));
                graphics2D.setColor(color);
                graphics2D.setStroke(stroke);
                bends.g();
            }
        }
    }
}
