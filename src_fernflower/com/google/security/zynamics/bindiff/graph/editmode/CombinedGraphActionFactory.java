package com.google.security.zynamics.bindiff.graph.editmode;

import com.google.security.zynamics.bindiff.graph.editmode.actions.CombinedNodeClickedLeftAction;
import com.google.security.zynamics.bindiff.graph.editmode.actions.CombinedNodeClickedMiddleAction;
import com.google.security.zynamics.bindiff.graph.editmode.actions.CombinedNodeDraggedLeftAction;
import com.google.security.zynamics.bindiff.graph.editmode.actions.CombinedNodePressedLeftAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.CDefaultActionFactory;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;

public class CombinedGraphActionFactory extends CDefaultActionFactory {
   public IStateAction createNodeClickedLeftAction() {
      return new CombinedNodeClickedLeftAction();
   }

   public IStateAction createNodeClickedMiddleAction() {
      return new CombinedNodeClickedMiddleAction();
   }

   public IStateAction createNodeDraggedLeftAction() {
      return new CombinedNodeDraggedLeftAction();
   }

   public IStateAction createNodePressedLeftAction() {
      return new CombinedNodePressedLeftAction();
   }
}
