/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent$ObjectWrapper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.awt.geom.Rectangle2D;

public class ZyNodeContentHelpers {
    public static Object getObject(ZyGraphNode zyGraphNode, double d2, double d3) {
        ZyLineContent$ObjectWrapper zyLineContent$ObjectWrapper = ZyNodeContentHelpers.getObjectWrapper(zyGraphNode, d2, d3);
        if (zyLineContent$ObjectWrapper == null) {
            return null;
        }
        Object object = zyLineContent$ObjectWrapper.getObject();
        return object;
    }

    public static ZyLineContent$ObjectWrapper getObjectWrapper(ZyGraphNode zyGraphNode, double d2, double d3) {
        IZyNodeRealizer iZyNodeRealizer = zyGraphNode.getRealizer();
        ZyLabelContent zyLabelContent = iZyNodeRealizer.getNodeContent();
        Rectangle2D rectangle2D = zyLabelContent.getBounds();
        double d4 = iZyNodeRealizer.getWidth() / rectangle2D.getWidth();
        double d5 = d3 - zyGraphNode.getY();
        int n2 = zyGraphNode.positionToRow(d5);
        if (n2 == -1) {
            return null;
        }
        ZyLineContent zyLineContent = zyLabelContent.getLineContent(n2);
        double d6 = ((d2 - zyGraphNode.getX()) / d4 - (double)zyLabelContent.getPaddingLeft()) / zyLineContent.getCharWidth();
        return zyLineContent.getObjectWrapper((int)d6);
    }
}

