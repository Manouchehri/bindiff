package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.EMatchType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.ISearchableTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.ISortableTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.helper.MouseTreeNodeSelectionHandlerSingleFunction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph.SingleCallGraphFunctionTreeNode$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph.SingleCallGraphRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus.CallGraphPopupMenu;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JPopupMenu;

public class SingleCallGraphFunctionTreeNode extends AbstractTreeNode implements ISearchableTreeNode, ISortableTreeNode {
   private static final Icon PRIMARY_UNMATCHED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-functions.png");
   private static final Icon PRIMARY_UNMATCHED_FUNCTION_SELECTED_ICON = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-functions-selected.png");
   private static final Icon PRIMARY_UNMATCHED_FUNCTION_INVISIBLE_ICON = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-functions-invisible.png");
   private static final Icon SECONDARY_UNMATCHED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-functions.png");
   private static final Icon SECONDARY_UNMATCHED_FUNCTION_SELECTED_ICON = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-functions-selected.png");
   private static final Icon SECONDARY_UNMATCHED_FUNCTION_INVISIBLE_ICON = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-functions-invisible.png");
   private static final Icon MATCHED_IDENTICAL_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/matched-functions.png");
   private static final Icon MATCHED_IDENTICAL_FUNCTION_SELECTED_ICON = ImageUtils.getImageIcon("data/treeicons/matched-functions-selected.png");
   private static final Icon MATCHED_IDENTICAL_FUNCTION_INVISIBLE_ICON = ImageUtils.getImageIcon("data/treeicons/matched-functions-invisible.png");
   private static final Icon MATCHED_STRUCTURALCHANGED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/structural-changed-function.png");
   private static final Icon MATCHED_STRUCTURALCHANGED_FUNCTION_SELECTED_ICON = ImageUtils.getImageIcon("data/treeicons/structural-changed-function-selected.png");
   private static final Icon MATCHED_STRUCTURALCHANGED_FUNCTION_INVISIBLE_ICON = ImageUtils.getImageIcon("data/treeicons/structural-changed-function-invisible.png");
   private static final Icon MATCHED_INSTRUCTIONCHANGED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/instructions-changed-function.png");
   private static final Icon MATCHED_INSTRUCTIONCHANGED_FUNCTION_SELECTED_ICON = ImageUtils.getImageIcon("data/treeicons/instructions-changed-function-selected.png");
   private static final Icon MATCHED_INSTRUCTIONCHANGED_FUNCTION_INVISIBLE_ICON = ImageUtils.getImageIcon("data/treeicons/instructions-changed-function-invisible.png");
   private SingleDiffNode singleDiffNode;

   public SingleCallGraphFunctionTreeNode(SingleCallGraphRootTreeNode var1, SingleDiffNode var2) {
      super(var1);
      this.singleDiffNode = (SingleDiffNode)Preconditions.checkNotNull(var2);
      this.createChildren();
   }

   public SingleCallGraphFunctionTreeNode(SingleCallGraphRootTreeNode var1, SingleDiffNode var2, boolean var3) {
      super(var1);
      this.singleDiffNode = (SingleDiffNode)Preconditions.checkNotNull(var2);
      if(!var3) {
         this.createChildren();
      }

   }

   protected void delete() {
      super.delete();
      this.singleDiffNode = null;
   }

   public void createChildren() {
   }

   public IAddress getAddress() {
      return this.getFunction().getAddress();
   }

   public IAddress getAddress(ESide var1) {
      return this.getFunction().getSide() != var1?null:this.getAddress();
   }

   public RawFunction getFunction() {
      return (RawFunction)this.singleDiffNode.getRawNode();
   }

   public String getFunctionName() {
      return this.getFunction().getName();
   }

   public EFunctionType getFunctionType() {
      return this.getFunction().getFunctionType();
   }

   public ZyGraphNode getGraphNode() {
      return this.singleDiffNode;
   }

   public ZyGraphNode getGraphNode(ESide var1) {
      return this.singleDiffNode.getSide() != var1?null:this.singleDiffNode;
   }

   public Icon getIcon() {
      RawFunction var1 = this.getFunction();
      switch(SingleCallGraphFunctionTreeNode$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState[var1.getMatchState().ordinal()]) {
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
         if(this.isSelected()) {
            return PRIMARY_UNMATCHED_FUNCTION_SELECTED_ICON;
         } else {
            if(!this.isVisible()) {
               return PRIMARY_UNMATCHED_FUNCTION_INVISIBLE_ICON;
            }

            return PRIMARY_UNMATCHED_FUNCTION_ICON;
         }
      case 3:
         return this.isSelected()?SECONDARY_UNMATCHED_FUNCTION_SELECTED_ICON:(!this.isVisible()?SECONDARY_UNMATCHED_FUNCTION_INVISIBLE_ICON:SECONDARY_UNMATCHED_FUNCTION_ICON);
      }
   }

   public EMatchState getMatchState() {
      return this.getFunction().getMatchState();
   }

   public EMatchType getMatchType() {
      RawFunction var1 = (RawFunction)this.singleDiffNode.getRawNode();
      return var1 == null?EMatchType.UNUMATCHED:(var1.isIdenticalMatch()?EMatchType.IDENTICAL:(var1.isChangedInstructionsOnlyMatch()?EMatchType.INSTRUCTIONS_CHANGED:EMatchType.STRUCTURAL_CHANGED));
   }

   public JPopupMenu getPopupMenu() {
      return new CallGraphPopupMenu(this.getRootNode().getController(), this.getGraph(), this.singleDiffNode);
   }

   public SingleCallGraphRootTreeNode getRootNode() {
      return (SingleCallGraphRootTreeNode)this.getAbstractRootNode();
   }

   public SingleDiffNode getSingleDiffNode() {
      return this.singleDiffNode;
   }

   public String getTooltipText() {
      return null;
   }

   public void handleMouseEvent(MouseEvent var1) {
      if(var1.getButton() == 1 && var1.getClickCount() == 1) {
         MouseTreeNodeSelectionHandlerSingleFunction.handleMouseSelectionEvent(var1, this);
      }

      super.handleMouseEvent(var1);
   }

   public boolean isSelected() {
      return this.getFunction().isSelected();
   }

   public boolean isVisible() {
      return this.getFunction().isVisible();
   }

   public String toString() {
      return String.format("%s %s", new Object[]{this.getFunction().getAddress().toHexString(), this.getFunction().getName()});
   }
}
