package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.security.zynamics.bindiff.exceptions.*;
import com.google.security.zynamics.zylib.types.common.*;
import java.util.concurrent.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import y.c.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import java.util.*;
import y.f.a.*;
import com.google.security.zynamics.bindiff.graph.layout.*;
import y.f.c.*;
import com.google.security.zynamics.bindiff.graph.layout.util.*;
import y.f.c.a.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.layouters.*;
import y.f.*;
import com.google.security.zynamics.bindiff.graph.helpers.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.log.*;
import com.google.security.zynamics.bindiff.graph.settings.*;

class GraphLayoutCalculator$InternalLayoutThread extends Thread
{
    private final BinDiffGraph graph;
    private final c layouter;
    private O graphLayout;
    private GraphLayoutException exception;
    final /* synthetic */ GraphLayoutCalculator this$0;
    
    protected GraphLayoutCalculator$InternalLayoutThread(final GraphLayoutCalculator this$0, final BinDiffGraph graph, final c layouter) {
        this.this$0 = this$0;
        this.graphLayout = null;
        this.exception = null;
        this.graph = graph;
        this.layouter = layouter;
    }
    
    protected GraphLayoutException getException() {
        return this.exception;
    }
    
    protected O getGraphLayout() {
        return this.graphLayout;
    }
    
    @Override
    public void run() {
        try {
            if (this.graph instanceof CombinedGraph) {
                PortConstraints.configureConstraints((CombinedGraph)this.graph);
            }
            this.graphLayout = this.graph.calculateLayout(this.layouter);
        }
        catch (GraphLayoutException exception) {
            this.exception = exception;
        }
        finally {
            this.this$0.doneLatch.countDown();
        }
    }
}
