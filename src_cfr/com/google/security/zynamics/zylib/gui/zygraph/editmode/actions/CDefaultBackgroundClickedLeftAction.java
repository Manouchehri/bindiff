/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.states.CBackgroundClickedLeftState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import java.awt.event.MouseEvent;
import java.util.Collection;

public class CDefaultBackgroundClickedLeftAction
implements IStateAction {
    protected void unselectAll(AbstractZyGraph abstractZyGraph) {
        abstractZyGraph.selectNodes(abstractZyGraph.getNodes(), false);
    }

    public void execute(CBackgroundClickedLeftState cBackgroundClickedLeftState, MouseEvent mouseEvent) {
        this.unselectAll(cBackgroundClickedLeftState.getGraph());
    }
}

