package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.*;
import java.awt.event.*;
import y.h.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;

public class CHitBendsTransformer
{
    public static CStateChange changeBend(final CStateFactory cStateFactory, final MouseEvent mouseEvent, final cW cw, final x x) {
        final x j = cw.j();
        if (j == x) {
            return new CStateChange(cStateFactory.createBendHoverState(j, mouseEvent), true);
        }
        cStateFactory.createBendExitState(x, mouseEvent);
        return new CStateChange(cStateFactory.createBendEnterState(j, mouseEvent), true);
    }
    
    public static IMouseStateChange enterBend(final CStateFactory cStateFactory, final MouseEvent mouseEvent, final cW cw) {
        return new CStateChange(cStateFactory.createBendEnterState(cw.j(), mouseEvent), true);
    }
}
