package com.google.security.zynamics.zylib.disassembly;

import com.google.security.zynamics.zylib.disassembly.GraphType;
import com.google.security.zynamics.zylib.disassembly.IViewListener;
import com.google.security.zynamics.zylib.disassembly.ViewType;
import com.google.security.zynamics.zylib.types.graphs.IDirectedGraph;

public interface IView {
   void addListener(IViewListener var1);

   boolean close();

   int getEdgeCount();

   IDirectedGraph getGraph();

   GraphType getGraphType();

   String getName();

   int getNodeCount();

   ViewType getType();

   boolean isLoaded();

   void removeListener(IViewListener var1);
}
