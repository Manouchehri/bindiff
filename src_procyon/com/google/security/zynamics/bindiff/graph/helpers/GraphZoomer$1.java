package com.google.security.zynamics.bindiff.graph.helpers;

import y.h.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.*;
import java.awt.geom.*;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.graph.eventhandlers.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.graph.*;
import java.util.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;

final class GraphZoomer$1 implements Runnable
{
    final /* synthetic */ BinDiffGraph val$graph;
    final /* synthetic */ Collection val$nodes;
    
    GraphZoomer$1(final BinDiffGraph val$graph, final Collection val$nodes) {
        this.val$graph = val$graph;
        this.val$nodes = val$nodes;
    }
    
    @Override
    public void run() {
        zoomToNodes(this.val$graph, this.val$nodes);
    }
}
