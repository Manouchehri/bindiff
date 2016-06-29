package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.EMatchType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.ISearchableTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.ISortableTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.helper.MouseTreeNodeSelectionHandlerSingleBasicBlock;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph.SingleFlowGraphBasicBlockTreeNode$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph.SingleFlowGraphRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus.FlowGraphPopupMenu;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.BasicBlockMatchData;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JPopupMenu;

public class SingleFlowGraphBasicBlockTreeNode extends AbstractTreeNode implements ISearchableTreeNode, ISortableTreeNode {
   private static final Icon MATCHED_BASICBLOCK = ImageUtils.getImageIcon("data/treeicons/matched-basicblock.png");
   private static final Icon CHANGED_BASICBLOCK = ImageUtils.getImageIcon("data/treeicons/changed-basicblock.png");
   private static final Icon PRIMARY_UNMATCHED_BASICBLOCK = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-basicblock.png");
   private static final Icon SECONDARY_UNMATCHED_BASICBLOCK = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-basicblock.png");
   private static final Icon MATCHED_BASICBLOCK_SELECTED = ImageUtils.getImageIcon("data/treeicons/matched-selected-basicblock.png");
   private static final Icon CHANGED_BASICBLOCK_SELECTED = ImageUtils.getImageIcon("data/treeicons/changed-selected-basicblock.png");
   private static final Icon PRIMARY_UNMATCHED_BASICBLOCK_SELECTED = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-selected-basicblock.png");
   private static final Icon SECONDARY_UNMATCHED_BASICBLOCK_SELECTED = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-selected-basicblock.png");
   private static final Icon MATCHED_BASICBLOCK_INVISIBLE = ImageUtils.getImageIcon("data/treeicons/matched-invisible-basicblock.png");
   private static final Icon CHANGED_BASICBLOCK_INVISIBLE = ImageUtils.getImageIcon("data/treeicons/changed-invisible-basicblock.png");
   private static final Icon PRIMARY_UNMATCHED_BASICBLOCK_INVISIBLE = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-invisible-basicblock.png");
   private static final Icon SECONDARY_UNMATCHED_BASICBLOCK_INVISIBLE = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-invisible-basicblock.png");
   private final SingleDiffNode singleDiffNode;
   private final RawBasicBlock rawBasicblock;

   public SingleFlowGraphBasicBlockTreeNode(SingleFlowGraphRootTreeNode var1, SingleDiffNode var2) {
      super(var1);
      this.singleDiffNode = (SingleDiffNode)Preconditions.checkNotNull(var2);
      this.rawBasicblock = (RawBasicBlock)this.singleDiffNode.getRawNode();
      this.createChildren();
   }

   private boolean isChangedBasicblock() {
      Diff var1 = this.getDiff();
      EMatchState var2 = this.getMatchState();
      if(var2 != EMatchState.PRIMARY_UNMATCHED && var2 != EMatchState.SECONDRAY_UNMATCHED) {
         MatchData var3 = var1.getMatches();
         IAddress var4;
         IAddress var5;
         FunctionMatchData var6;
         IAddress var7;
         IAddress var8;
         RawBasicBlock var9;
         BasicBlockMatchData var10;
         int var11;
         if(this.rawBasicblock.getSide() == ESide.PRIMARY) {
            var4 = this.rawBasicblock.getFunctionAddr();
            var5 = var3.getSecondaryFunctionAddr(var4);
            if(var5 != null) {
               var6 = var3.getFunctionMatch(var4, ESide.PRIMARY);
               if(var6 != null) {
                  var7 = this.rawBasicblock.getAddress();
                  var8 = var6.getSecondaryBasicblockAddr(var7);
                  if(var6.isBasicblockMatch(var7, var8)) {
                     var9 = ((FlowGraphViewData)this.getView()).getRawGraph(ESide.SECONDARY).getBasicblock(var8);
                     var10 = var6.getBasicblockMatch(var7, ESide.PRIMARY);
                     if(var10 != null) {
                        var11 = var10.getSizeOfMatchedInstructions();
                        return this.rawBasicblock.getInstructions().size() > var11 || var9.getInstructions().size() > var11;
                     }
                  }
               }
            }
         } else {
            var4 = this.rawBasicblock.getFunctionAddr();
            var5 = var3.getPrimaryFunctionAddr(var4);
            if(var5 != null) {
               var6 = var3.getFunctionMatch(var5, ESide.PRIMARY);
               if(var6 != null) {
                  var7 = this.rawBasicblock.getAddress();
                  var8 = var6.getPrimaryBasicblockAddr(var7);
                  if(var6.isBasicblockMatch(var8, var7)) {
                     var9 = ((FlowGraphViewData)this.getView()).getRawGraph(ESide.PRIMARY).getBasicblock(var8);
                     var10 = var6.getBasicblockMatch(var8, ESide.PRIMARY);
                     if(var10 != null) {
                        var11 = var10.getSizeOfMatchedInstructions();
                        return this.rawBasicblock.getInstructions().size() > var11 || var9.getInstructions().size() > var11;
                     }
                  }
               }
            }
         }

         return false;
      } else {
         return false;
      }
   }

   public void createChildren() {
   }

   public IAddress getAddress() {
      return this.rawBasicblock.getAddress();
   }

   public IAddress getAddress(ESide var1) {
      return this.rawBasicblock.getSide() == var1?this.rawBasicblock.getAddress():null;
   }

   public RawBasicBlock getBasicblock() {
      return this.rawBasicblock;
   }

   public String getFunctionName() {
      return this.rawBasicblock.getFunctionName();
   }

   public EFunctionType getFunctionType() {
      return null;
   }

   public ZyGraphNode getGraphNode() {
      return this.singleDiffNode;
   }

   public ZyGraphNode getGraphNode(ESide var1) {
      return this.singleDiffNode.getSide() != var1?null:this.singleDiffNode;
   }

   public Icon getIcon() {
      switch(SingleFlowGraphBasicBlockTreeNode$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState[this.getMatchState().ordinal()]) {
      case 1:
         if(!this.isChangedBasicblock()) {
            if(this.isSelected()) {
               return MATCHED_BASICBLOCK_SELECTED;
            } else {
               if(!this.isVisible()) {
                  return MATCHED_BASICBLOCK_INVISIBLE;
               }

               return MATCHED_BASICBLOCK;
            }
         } else if(this.isSelected()) {
            return CHANGED_BASICBLOCK_SELECTED;
         } else {
            if(!this.isVisible()) {
               return CHANGED_BASICBLOCK_INVISIBLE;
            }

            return CHANGED_BASICBLOCK;
         }
      case 2:
         if(this.isSelected()) {
            return PRIMARY_UNMATCHED_BASICBLOCK_SELECTED;
         } else {
            if(!this.isVisible()) {
               return PRIMARY_UNMATCHED_BASICBLOCK_INVISIBLE;
            }

            return PRIMARY_UNMATCHED_BASICBLOCK;
         }
      case 3:
         if(this.isSelected()) {
            return SECONDARY_UNMATCHED_BASICBLOCK_SELECTED;
         } else {
            if(!this.isVisible()) {
               return SECONDARY_UNMATCHED_BASICBLOCK_INVISIBLE;
            }

            return SECONDARY_UNMATCHED_BASICBLOCK;
         }
      default:
         throw new IllegalStateException("Unknown match type.");
      }
   }

   public EMatchState getMatchState() {
      return this.rawBasicblock.getMatchState();
   }

   public EMatchType getMatchType() {
      return this.getMatchState() == EMatchState.MATCHED?(this.isChangedBasicblock()?EMatchType.INSTRUCTIONS_CHANGED:EMatchType.IDENTICAL):EMatchType.UNUMATCHED;
   }

   public JPopupMenu getPopupMenu() {
      return new FlowGraphPopupMenu(this.getRootNode().getController(), this.getGraph(), this.singleDiffNode);
   }

   public SingleFlowGraphRootTreeNode getRootNode() {
      return (SingleFlowGraphRootTreeNode)this.getAbstractRootNode();
   }

   public SingleDiffNode getSingleDiffNode() {
      return this.singleDiffNode;
   }

   public String getTooltipText() {
      return null;
   }

   public void handleMouseEvent(MouseEvent var1) {
      if(var1.getButton() == 1 && var1.getClickCount() == 1) {
         MouseTreeNodeSelectionHandlerSingleBasicBlock.handleMouseSelectionEvent(var1, this);
      }

      super.handleMouseEvent(var1);
   }

   public boolean isSelected() {
      return this.rawBasicblock.isSelected();
   }

   public boolean isVisible() {
      return this.rawBasicblock.isVisible();
   }

   public String toString() {
      return this.rawBasicblock.getAddress().toHexString();
   }
}
