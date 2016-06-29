package com.google.security.zynamics.zylib.gui.zygraph.editmode;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateActionFactory;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.actions.CDefaultBackgroundClickedLeftAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.actions.CDefaultBackgroundClickedRightAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.actions.CDefaultBackgroundDraggedLeftAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.actions.CDefaultBackgroundDraggedRightAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.actions.CDefaultBackgroundPressedLeftAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.actions.CDefaultBackgroundPressedRightAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.actions.CDefaultBendClickedLeftAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.actions.CDefaultBendEnterAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.actions.CDefaultBendExitAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.actions.CDefaultBendHoverAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.actions.CDefaultBendPressedLeftAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.actions.CDefaultEdgeClickedLeftAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.actions.CDefaultEdgeClickedRightAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.actions.CDefaultEdgeHoverAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.actions.CDefaultEdgeLabelHoverAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.actions.CDefaultEdgePressedLeftAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.actions.CDefaultEdgePressedRightAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.actions.CDefaultNodeClickedMiddleAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.actions.CDefaultNodeEditAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.actions.CDefaultNodeEditEnterAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.actions.CDefaultNodeEditExitAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.actions.CDefaultNodeHoverAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.actions.CDefaultNodePressedLeftAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.actions.CDefaultNodePressedMiddleAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.actions.CDefaultNodePressedRightAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions.CDefaultEdgeEnterAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions.CDefaultEdgeExitAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions.CDefaultEdgeLabelEnterAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions.CDefaultEdgeLabelExitAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions.CDefaultNodeClickedLeftAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions.CDefaultNodeClickedRightAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions.CDefaultNodeDraggedLeftAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions.CDefaultNodeEnterAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions.CDefaultNodeExitAction;

public class CDefaultActionFactory implements IStateActionFactory {
   public IStateAction createBackgroundClickedLeftAction() {
      return new CDefaultBackgroundClickedLeftAction();
   }

   public IStateAction createBackgroundClickedRightAction() {
      return new CDefaultBackgroundClickedRightAction();
   }

   public IStateAction createBackgroundDraggedLeftAction() {
      return new CDefaultBackgroundDraggedLeftAction();
   }

   public IStateAction createBackgroundDraggedRightAction() {
      return new CDefaultBackgroundDraggedRightAction();
   }

   public IStateAction createBackgroundPressedLeftAction() {
      return new CDefaultBackgroundPressedLeftAction();
   }

   public IStateAction createBackgroundPressedRightAction() {
      return new CDefaultBackgroundPressedRightAction();
   }

   public IStateAction createBendClickedLeftAction() {
      return new CDefaultBendClickedLeftAction();
   }

   public IStateAction createBendEnterAction() {
      return new CDefaultBendEnterAction();
   }

   public IStateAction createBendExitAction() {
      return new CDefaultBendExitAction();
   }

   public IStateAction createBendHoverAction() {
      return new CDefaultBendHoverAction();
   }

   public IStateAction createBendPressedLeftAction() {
      return new CDefaultBendPressedLeftAction();
   }

   public IStateAction createEdgeClickedLeftAction() {
      return new CDefaultEdgeClickedLeftAction();
   }

   public IStateAction createEdgeClickedRightAction() {
      return new CDefaultEdgeClickedRightAction();
   }

   public IStateAction createEdgeEnterAction() {
      return new CDefaultEdgeEnterAction();
   }

   public IStateAction createEdgeExitAction() {
      return new CDefaultEdgeExitAction();
   }

   public IStateAction createEdgeHoverAction() {
      return new CDefaultEdgeHoverAction();
   }

   public IStateAction createEdgeLabelEnterAction() {
      return new CDefaultEdgeLabelEnterAction();
   }

   public IStateAction createEdgeLabelExitAction() {
      return new CDefaultEdgeLabelExitAction();
   }

   public IStateAction createEdgeLabelHoverAction() {
      return new CDefaultEdgeLabelHoverAction();
   }

   public IStateAction createEdgePressedLeftAction() {
      return new CDefaultEdgePressedLeftAction();
   }

   public IStateAction createEdgePressedRightAction() {
      return new CDefaultEdgePressedRightAction();
   }

   public IStateAction createNodeClickedLeftAction() {
      return new CDefaultNodeClickedLeftAction();
   }

   public IStateAction createNodeClickedMiddleAction() {
      return new CDefaultNodeClickedMiddleAction();
   }

   public IStateAction createNodeClickedRightAction() {
      return new CDefaultNodeClickedRightAction();
   }

   public IStateAction createNodeDraggedLeftAction() {
      return new CDefaultNodeDraggedLeftAction();
   }

   public IStateAction createNodeEditAction() {
      return new CDefaultNodeEditAction();
   }

   public IStateAction createNodeEditEnterAction() {
      return new CDefaultNodeEditEnterAction();
   }

   public IStateAction createNodeEditExitAction() {
      return new CDefaultNodeEditExitAction();
   }

   public IStateAction createNodeEnterAction() {
      return new CDefaultNodeEnterAction();
   }

   public IStateAction createNodeExitAction() {
      return new CDefaultNodeExitAction();
   }

   public IStateAction createNodeHoverAction() {
      return new CDefaultNodeHoverAction();
   }

   public IStateAction createNodePressedLeftAction() {
      return new CDefaultNodePressedLeftAction();
   }

   public IStateAction createNodePressedMiddleAction() {
      return new CDefaultNodePressedMiddleAction();
   }

   public IStateAction createNodePressedRightAction() {
      return new CDefaultNodePressedRightAction();
   }
}
