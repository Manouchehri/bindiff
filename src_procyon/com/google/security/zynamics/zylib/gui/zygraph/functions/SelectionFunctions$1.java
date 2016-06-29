package com.google.security.zynamics.zylib.gui.zygraph.functions;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import java.util.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.types.common.*;

final class SelectionFunctions$1 implements INodeCallback
{
    final /* synthetic */ ArrayList val$toUnselect;
    final /* synthetic */ ArrayList val$toSelect;
    
    SelectionFunctions$1(final ArrayList val$toUnselect, final ArrayList val$toSelect) {
        this.val$toUnselect = val$toUnselect;
        this.val$toSelect = val$toSelect;
    }
    
    public IterationMode next(final ZyGraphNode zyGraphNode) {
        if (zyGraphNode.isSelected()) {
            this.val$toUnselect.add(zyGraphNode);
        }
        else {
            this.val$toSelect.add(zyGraphNode);
        }
        return IterationMode.CONTINUE;
    }
}
