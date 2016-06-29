package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.EMatchType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.ISearchableTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.ISortableTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.CombinedCallGraphFunctionTreeNode$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.CombinedCallGraphRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.helper.MouseTreeNodeSelectionHandlerCombinedFunction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus.CallGraphPopupMenu;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedFunction;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JPopupMenu;

public class CombinedCallGraphFunctionTreeNode extends AbstractTreeNode implements ISearchableTreeNode, ISortableTreeNode {
   private static final Icon PRIMARY_UNMATCHED_FUNCTION = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-functions.png");
   private static final Icon PRIMARY_UNMATCHED_FUNCTION_SELECTED = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-functions-selected.png");
   private static final Icon PRIMARY_UNMATCHED_FUNCTION_INVISIBLE = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-functions-invisible.png");
   private static final Icon SECONDARY_UNMATCHED_FUNCTION = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-functions.png");
   private static final Icon SECONDARY_UNMATCHED_FUNCTION_SELECTED = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-functions-selected.png");
   private static final Icon SECONDARY_UNMATCHED_FUNCTION_INVISIBLE = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-functions-invisible.png");
   private static final Icon MATCHED_IDENTICAL_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/matched-functions.png");
   private static final Icon MATCHED_IDENTICAL_FUNCTION_SELECTED_ICON = ImageUtils.getImageIcon("data/treeicons/matched-functions-selected.png");
   private static final Icon MATCHED_IDENTICAL_FUNCTION_INVISIBLE_ICON = ImageUtils.getImageIcon("data/treeicons/matched-functions-invisible.png");
   private static final Icon MATCHED_STRUCTURALCHANGED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/structural-changed-function.png");
   private static final Icon MATCHED_STRUCTURALCHANGED_FUNCTION_SELECTED_ICON = ImageUtils.getImageIcon("data/treeicons/structural-changed-function-selected.png");
   private static final Icon MATCHED_STRUCTURALCHANGED_FUNCTION_INVISIBLE_ICON = ImageUtils.getImageIcon("data/treeicons/structural-changed-function-invisible.png");
   private static final Icon MATCHED_INSTRUCTIONCHANGED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/instructions-changed-function.png");
   private static final Icon MATCHED_INSTRUCTIONCHANGED_FUNCTION_SELECTED_ICON = ImageUtils.getImageIcon("data/treeicons/instructions-changed-function-selected.png");
   private static final Icon MATCHED_INSTRUCTIONCHANGED_FUNCTION_INVISIBLE_ICON = ImageUtils.getImageIcon("data/treeicons/instructions-changed-function-invisible.png");
   private CombinedDiffNode combinedDiffNode;

   public CombinedCallGraphFunctionTreeNode(CombinedCallGraphRootTreeNode var1, CombinedDiffNode var2) {
      super(var1);
      Preconditions.checkNotNull(var2);
      this.combinedDiffNode = var2;
      this.createChildren();
   }

   protected void delete() {
      super.delete();
      this.combinedDiffNode = null;
   }

   public void createChildren() {
   }

   public IAddress getAddress() {
      return null;
   }

   public IAddress getAddress(ESide var1) {
      return this.getCombinedFunction().getAddress(var1);
   }

   public CombinedDiffNode getCombinedDiffNode() {
      return this.combinedDiffNode;
   }

   public RawCombinedFunction getCombinedFunction() {
      return (RawCombinedFunction)this.combinedDiffNode.getRawNode();
   }

   public String getFunctionName() {
      return null;
   }

   public EFunctionType getFunctionType() {
      return this.getCombinedFunction().getFunctionType();
   }

   public ZyGraphNode getGraphNode() {
      return this.combinedDiffNode;
   }

   public ZyGraphNode getGraphNode(ESide var1) {
      return var1 == ESide.PRIMARY?this.combinedDiffNode.getPrimaryDiffNode():this.combinedDiffNode.getSecondaryDiffNode();
   }

   public Icon getIcon() {
      RawFunction var1 = (RawFunction)this.combinedDiffNode.getPrimaryRawNode();
      if(var1 == null) {
         var1 = (RawFunction)this.combinedDiffNode.getPrimaryRawNode();
      }

      switch(CombinedCallGraphFunctionTreeNode$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState[this.combinedDiffNode.getRawNode().getMatchState().ordinal()]) {
      case 1:
         if(var1.isIdenticalMatch()) {
            if(this.isSelected()) {
               return MATCHED_IDENTICAL_FUNCTION_SELECTED_ICON;
            } else {
               if(!this.isVisible()) {
                  return MATCHED_IDENTICAL_FUNCTION_INVISIBLE_ICON;
               }

               return MATCHED_IDENTICAL_FUNCTION_ICON;
            }
         } else if(var1.isChangedInstructionsOnlyMatch()) {
            if(this.isSelected()) {
               return MATCHED_INSTRUCTIONCHANGED_FUNCTION_SELECTED_ICON;
            } else {
               if(!this.isVisible()) {
                  return MATCHED_INSTRUCTIONCHANGED_FUNCTION_INVISIBLE_ICON;
               }

               return MATCHED_INSTRUCTIONCHANGED_FUNCTION_ICON;
            }
         } else if(var1.isChangedStructuralMatch()) {
            if(this.isSelected()) {
               return MATCHED_STRUCTURALCHANGED_FUNCTION_SELECTED_ICON;
            } else {
               if(!this.isVisible()) {
                  return MATCHED_STRUCTURALCHANGED_FUNCTION_INVISIBLE_ICON;
               }

               return MATCHED_STRUCTURALCHANGED_FUNCTION_ICON;
            }
         }
      default:
         throw new IllegalStateException("Unknown match type.");
      case 2:
         if(this.combinedDiffNode != null) {
            if(this.combinedDiffNode.isSelected()) {
               return PRIMARY_UNMATCHED_FUNCTION_SELECTED;
            }

            if(!this.combinedDiffNode.isVisible()) {
               return PRIMARY_UNMATCHED_FUNCTION_INVISIBLE;
            }
         }

         return PRIMARY_UNMATCHED_FUNCTION;
      case 3:
         if(this.combinedDiffNode != null) {
            if(this.combinedDiffNode.isSelected()) {
               return SECONDARY_UNMATCHED_FUNCTION_SELECTED;
            }

            if(!this.combinedDiffNode.isVisible()) {
               return SECONDARY_UNMATCHED_FUNCTION_INVISIBLE;
            }
         }

         return SECONDARY_UNMATCHED_FUNCTION;
      }
   }

   public EMatchState getMatchState() {
      return this.getCombinedFunction().getMatchState();
   }

   public EMatchType getMatchType() {
      RawFunction var1 = (RawFunction)this.combinedDiffNode.getPrimaryRawNode();
      return var1 == null?EMatchType.UNUMATCHED:(var1.isIdenticalMatch()?EMatchType.IDENTICAL:(var1.isIdenticalMatch()?EMatchType.INSTRUCTIONS_CHANGED:EMatchType.STRUCTURAL_CHANGED));
   }

   public JPopupMenu getPopupMenu() {
      return new CallGraphPopupMenu(this.getRootNode().getController(), this.getGraph(), this.combinedDiffNode);
   }

   public CombinedCallGraphRootTreeNode getRootNode() {
      return (CombinedCallGraphRootTreeNode)this.getAbstractRootNode();
   }

   public void handleMouseEvent(MouseEvent var1) {
      if(var1.getButton() == 1 && var1.getClickCount() == 1) {
         MouseTreeNodeSelectionHandlerCombinedFunction.handleMouseSelectionEvent(var1, this);
      } else {
         super.handleMouseEvent(var1);
      }
   }

   public boolean isSelected() {
      return this.combinedDiffNode.isSelected();
   }

   public boolean isVisible() {
      return this.combinedDiffNode.isVisible();
   }

   public String toString() {
      String var1 = "";
      EMatchState var2 = this.combinedDiffNode.getRawNode().getMatchState();
      if(var2 == EMatchState.MATCHED) {
         var1 = String.format("%s ↔ %s", new Object[]{this.combinedDiffNode.getPrimaryRawNode().getAddress().toHexString(), this.combinedDiffNode.getSecondaryRawNode().getAddress().toHexString()});
      } else if(var2 == EMatchState.PRIMARY_UNMATCHED) {
         var1 = String.format("%s ↔ %s", new Object[]{this.combinedDiffNode.getPrimaryRawNode().getAddress().toHexString(), "missing"});
      } else if(var2 == EMatchState.SECONDRAY_UNMATCHED) {
         var1 = String.format("%s ↔ %s", new Object[]{"missing", this.combinedDiffNode.getSecondaryRawNode().getAddress().toHexString()});
      }

      return var1;
   }
}
