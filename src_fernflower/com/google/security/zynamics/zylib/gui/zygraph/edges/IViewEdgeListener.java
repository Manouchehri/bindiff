package com.google.security.zynamics.zylib.gui.zygraph.edges;

import com.google.security.zynamics.zylib.gui.zygraph.edges.CBend;
import com.google.security.zynamics.zylib.gui.zygraph.edges.CViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.edges.EdgeType;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import java.awt.Color;

public interface IViewEdgeListener {
   void addedBend(IViewEdge var1, CBend var2);

   void changedColor(CViewEdge var1, Color var2);

   void changedSelection(IViewEdge var1, boolean var2);

   void changedSourceX(CViewEdge var1, double var2);

   void changedSourceY(CViewEdge var1, double var2);

   void changedTargetX(CViewEdge var1, double var2);

   void changedTargetY(CViewEdge var1, double var2);

   void changedType(CViewEdge var1, EdgeType var2);

   void changedVisibility(IViewEdge var1, boolean var2);

   void clearedBends(IViewEdge var1);

   void insertedBend(IViewEdge var1, int var2, CBend var3);

   void removedBend(CViewEdge var1, int var2, CBend var3);
}
