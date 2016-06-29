/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.CStateChange;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import java.awt.event.MouseEvent;
import y.h.cW;
import y.h.x;

public class CHitBendsTransformer {
    public static CStateChange changeBend(CStateFactory cStateFactory, MouseEvent mouseEvent, cW cW2, x x2) {
        x x3 = cW2.j();
        if (x3 == x2) {
            return new CStateChange(cStateFactory.createBendHoverState(x3, mouseEvent), true);
        }
        cStateFactory.createBendExitState(x2, mouseEvent);
        return new CStateChange(cStateFactory.createBendEnterState(x3, mouseEvent), true);
    }

    public static IMouseStateChange enterBend(CStateFactory cStateFactory, MouseEvent mouseEvent, cW cW2) {
        x x2 = cW2.j();
        return new CStateChange(cStateFactory.createBendEnterState(x2, mouseEvent), true);
    }
}

