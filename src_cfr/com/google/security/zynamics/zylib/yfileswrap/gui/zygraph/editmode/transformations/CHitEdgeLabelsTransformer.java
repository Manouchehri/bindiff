/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.CStateChange;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import java.awt.event.MouseEvent;
import y.h.aA;
import y.h.cW;

public class CHitEdgeLabelsTransformer {
    public static CStateChange changeEdgeLabel(CStateFactory cStateFactory, MouseEvent mouseEvent, cW cW2, aA aA2) {
        aA aA3 = cW2.m();
        if (aA3 == aA2) {
            return new CStateChange(cStateFactory.createEdgeLabelHoverState(aA3, mouseEvent), true);
        }
        cStateFactory.createEdgeLabelExitState(aA2, mouseEvent);
        return new CStateChange(cStateFactory.createEdgeLabelEnterState(aA3, mouseEvent), true);
    }

    public static IMouseStateChange enterEdgeLabel(CStateFactory cStateFactory, MouseEvent mouseEvent, cW cW2) {
        aA aA2 = cW2.m();
        return new CStateChange(cStateFactory.createEdgeLabelEnterState(aA2, mouseEvent), true);
    }
}

