package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;

public class ZyNodeContentHelpers
{
    public static Object getObject(final ZyGraphNode zyGraphNode, final double n, final double n2) {
        final ZyLineContent$ObjectWrapper objectWrapper = getObjectWrapper(zyGraphNode, n, n2);
        return (objectWrapper == null) ? null : objectWrapper.getObject();
    }
    
    public static ZyLineContent$ObjectWrapper getObjectWrapper(final ZyGraphNode zyGraphNode, final double n, final double n2) {
        final IZyNodeRealizer realizer = zyGraphNode.getRealizer();
        final ZyLabelContent nodeContent = realizer.getNodeContent();
        final double n3 = realizer.getWidth() / nodeContent.getBounds().getWidth();
        final int positionToRow = zyGraphNode.positionToRow(n2 - zyGraphNode.getY());
        if (positionToRow == -1) {
            return null;
        }
        final ZyLineContent lineContent = nodeContent.getLineContent(positionToRow);
        return lineContent.getObjectWrapper((int)(((n - zyGraphNode.getX()) / n3 - nodeContent.getPaddingLeft()) / lineContent.getCharWidth()));
    }
}
