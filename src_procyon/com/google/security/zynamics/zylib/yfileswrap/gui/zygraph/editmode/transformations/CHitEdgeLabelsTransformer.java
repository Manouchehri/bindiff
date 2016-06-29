package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.*;
import java.awt.event.*;
import y.h.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;

public class CHitEdgeLabelsTransformer
{
    public static CStateChange changeEdgeLabel(final CStateFactory cStateFactory, final MouseEvent mouseEvent, final cW cw, final aA aa) {
        final aA m = cw.m();
        if (m == aa) {
            return new CStateChange(cStateFactory.createEdgeLabelHoverState(m, mouseEvent), true);
        }
        cStateFactory.createEdgeLabelExitState(aa, mouseEvent);
        return new CStateChange(cStateFactory.createEdgeLabelEnterState(m, mouseEvent), true);
    }
    
    public static IMouseStateChange enterEdgeLabel(final CStateFactory cStateFactory, final MouseEvent mouseEvent, final cW cw) {
        return new CStateChange(cStateFactory.createEdgeLabelEnterState(cw.m(), mouseEvent), true);
    }
}
