/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.CDefaultLabelEventHandler;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CEditNodeHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CBendPressedLeftState;
import java.awt.event.MouseEvent;

public class CDefaultBendPressedLeftAction
implements IStateAction {
    public void execute(CBendPressedLeftState cBendPressedLeftState, MouseEvent mouseEvent) {
        if (!cBendPressedLeftState.getGraph().getEditMode().getLabelEventHandler().isActive()) return;
        CEditNodeHelper.removeCaret(cBendPressedLeftState.getGraph());
    }
}

