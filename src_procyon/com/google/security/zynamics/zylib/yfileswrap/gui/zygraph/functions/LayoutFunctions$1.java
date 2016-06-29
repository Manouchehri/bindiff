package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.functions;

import com.google.security.zynamics.zylib.gui.*;
import y.h.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import y.f.*;

final class LayoutFunctions$1 extends SwingInvoker
{
    final /* synthetic */ dj val$layoutMorpher;
    final /* synthetic */ AbstractZyGraph val$graph;
    final /* synthetic */ O val$morpherLayout;
    
    LayoutFunctions$1(final dj val$layoutMorpher, final AbstractZyGraph val$graph, final O val$morpherLayout) {
        this.val$layoutMorpher = val$layoutMorpher;
        this.val$graph = val$graph;
        this.val$morpherLayout = val$morpherLayout;
    }
    
    @Override
    protected void operation() {
        this.val$layoutMorpher.execute(this.val$graph.getView(), this.val$morpherLayout);
    }
}
