/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.CDefaultLabelEventHandler;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CEditNodeHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CEdgePressedLeftState;
import java.awt.event.MouseEvent;

public class CDefaultEdgePressedLeftAction
implements IStateAction {
    public void execute(CEdgePressedLeftState cEdgePressedLeftState, MouseEvent mouseEvent) {
        if (!cEdgePressedLeftState.getGraph().getEditMode().getLabelEventHandler().isActive()) return;
        CEditNodeHelper.removeCaret(cEdgePressedLeftState.getGraph());
    }
}

