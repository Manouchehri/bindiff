package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.types.common.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import java.util.*;

final class GraphHelpers$8 implements INodeCallback
{
    final /* synthetic */ StringBuilder val$selection;
    
    GraphHelpers$8(final StringBuilder val$selection) {
        this.val$selection = val$selection;
    }
    
    public IterationMode next(final ZyGraphNode zyGraphNode) {
        final Iterator iterator = zyGraphNode.getRealizer().getNodeContent().iterator();
        while (iterator.hasNext()) {
            this.val$selection.append(iterator.next().getText());
            this.val$selection.append("\n");
        }
        this.val$selection.append("\n");
        return IterationMode.CONTINUE;
    }
}
