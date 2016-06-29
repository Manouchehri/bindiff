/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions.CDefaultNodeClickedLeftAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeClickedLeftState;
import java.awt.event.MouseEvent;

public class CombinedNodeClickedLeftAction
implements IStateAction {
    public void execute(CNodeClickedLeftState cNodeClickedLeftState, MouseEvent mouseEvent) {
        new CDefaultNodeClickedLeftAction().execute(cNodeClickedLeftState, mouseEvent);
    }
}

