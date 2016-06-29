package com.google.security.zynamics.zylib.gui.zygraph.edges;

import com.google.security.zynamics.zylib.gui.zygraph.edges.CBend;
import com.google.security.zynamics.zylib.gui.zygraph.edges.CViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.edges.EdgeType;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdgeListener;
import java.awt.Color;

public abstract class ViewEdgeListenerAdapter implements IViewEdgeListener {
   public void addedBend(IViewEdge var1, CBend var2) {
   }

   public void changedColor(CViewEdge var1, Color var2) {
   }

   public void changedSelection(IViewEdge var1, boolean var2) {
   }

   public void changedSourceX(CViewEdge var1, double var2) {
   }

   public void changedSourceY(CViewEdge var1, double var2) {
   }

   public void changedTargetX(CViewEdge var1, double var2) {
   }

   public void changedTargetY(CViewEdge var1, double var2) {
   }

   public void changedType(CViewEdge var1, EdgeType var2) {
   }

   public void changedVisibility(IViewEdge var1, boolean var2) {
   }

   public void clearedBends(IViewEdge var1) {
   }

   public void insertedBend(IViewEdge var1, int var2, CBend var3) {
   }

   public void removedBend(CViewEdge var1, int var2, CBend var3) {
   }
}
