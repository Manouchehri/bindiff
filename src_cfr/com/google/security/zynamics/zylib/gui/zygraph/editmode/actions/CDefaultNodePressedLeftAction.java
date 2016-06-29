/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.CDefaultLabelEventHandler;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CEditNodeHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodePressedLeftState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.awt.event.MouseEvent;
import y.c.q;

public class CDefaultNodePressedLeftAction
implements IStateAction {
    public void execute(CNodePressedLeftState cNodePressedLeftState, MouseEvent mouseEvent) {
        AbstractZyGraph abstractZyGraph = cNodePressedLeftState.getGraph();
        ZyGraphNode zyGraphNode = abstractZyGraph.getNode(cNodePressedLeftState.getNode());
        if (zyGraphNode == null) {
            CEditNodeHelper.removeCaret(abstractZyGraph);
            return;
        }
        ZyLabelContent zyLabelContent = zyGraphNode.getRealizer().getNodeContent();
        if (abstractZyGraph.getEditMode().getLabelEventHandler().isActiveLabel(zyLabelContent)) {
            CEditNodeHelper.setCaretStart(abstractZyGraph, cNodePressedLeftState.getNode(), mouseEvent);
            CEditNodeHelper.setCaretEnd(abstractZyGraph, cNodePressedLeftState.getNode(), mouseEvent);
            return;
        }
        CEditNodeHelper.removeCaret(abstractZyGraph);
    }
}

