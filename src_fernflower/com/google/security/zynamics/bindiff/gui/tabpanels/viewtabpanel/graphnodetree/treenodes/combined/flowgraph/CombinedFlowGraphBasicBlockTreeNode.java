package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.EMatchType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.ISearchableTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.ISortableTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphBasicBlockTreeNode$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.helper.MouseTreeNodeSelectionHandlerCombinedBasicBlock;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus.FlowGraphPopupMenu;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.BasicBlockMatchData;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JPopupMenu;

public class CombinedFlowGraphBasicBlockTreeNode extends AbstractTreeNode implements ISearchableTreeNode, ISortableTreeNode {
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
   private final CombinedDiffNode combinedDiffNode;
   private final RawCombinedBasicBlock combinedBasicblock;

   public CombinedFlowGraphBasicBlockTreeNode(CombinedFlowGraphRootTreeNode var1, CombinedDiffNode var2) {
      super(var1);
      Preconditions.checkNotNull(var2);
      this.combinedDiffNode = var2;
      this.combinedBasicblock = (RawCombinedBasicBlock)var2.getRawNode();
      this.createChildren();
   }

   private boolean isChangedBasicblock() {
      Diff var1 = this.getDiff();
      EMatchState var2 = this.getMatchState();
      if(var2 != EMatchState.PRIMARY_UNMATCHED && var2 != EMatchState.SECONDRAY_UNMATCHED) {
         MatchData var3 = var1.getMatches();
         IAddress var4 = this.combinedBasicblock.getPrimaryFunctionAddress();
         FunctionMatchData var5 = var3.getFunctionMatch(var4, ESide.PRIMARY);
         if(var5 != null) {
            RawBasicBlock var6 = this.combinedBasicblock.getRawNode(ESide.PRIMARY);
            RawBasicBlock var7 = this.combinedBasicblock.getRawNode(ESide.SECONDARY);
            IAddress var8 = this.combinedBasicblock.getAddress(ESide.PRIMARY);
            IAddress var9 = this.combinedBasicblock.getAddress(ESide.SECONDARY);
            if(var5.isBasicblockMatch(var8, var9)) {
               BasicBlockMatchData var10 = var5.getBasicblockMatch(var8, ESide.PRIMARY);
               if(var10 != null) {
                  int var11 = var10.getSizeOfMatchedInstructions();
                  return var6.getInstructions().size() > var11 || var7.getInstructions().size() > var11;
               }
            }
         }

         return false;
      } else {
         return false;
      }
   }

   public IAddress getAddress() {
      return null;
   }

   public IAddress getAddress(ESide var1) {
      return this.combinedBasicblock.getAddress(var1);
   }

   public RawCombinedBasicBlock getCombinedBasicblock() {
      return this.combinedBasicblock;
   }

   public CombinedDiffNode getCombinedDiffNode() {
      return this.combinedDiffNode;
   }

   public String getFunctionName() {
      return null;
   }

   public EFunctionType getFunctionType() {
      return null;
   }

   public ZyGraphNode getGraphNode() {
      return this.combinedDiffNode;
   }

   public ZyGraphNode getGraphNode(ESide var1) {
      return var1 == ESide.PRIMARY?this.combinedDiffNode.getPrimaryDiffNode():this.combinedDiffNode.getSecondaryDiffNode();
   }

   public Icon getIcon() {
      switch(CombinedFlowGraphBasicBlockTreeNode$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState[this.getMatchState().ordinal()]) {
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
      return this.combinedBasicblock.getMatchState();
   }

   public EMatchType getMatchType() {
      return this.getMatchState() != EMatchState.MATCHED?EMatchType.UNUMATCHED:(this.isChangedBasicblock()?EMatchType.INSTRUCTIONS_CHANGED:EMatchType.IDENTICAL);
   }

   public JPopupMenu getPopupMenu() {
      return new FlowGraphPopupMenu(this.getRootNode().getController(), this.getGraph(), this.combinedDiffNode);
   }

   public CombinedFlowGraphRootTreeNode getRootNode() {
      return (CombinedFlowGraphRootTreeNode)this.getAbstractRootNode();
   }

   public void handleMouseEvent(MouseEvent var1) {
      if(var1.getButton() == 1 && var1.getClickCount() == 1) {
         MouseTreeNodeSelectionHandlerCombinedBasicBlock.handleMouseSelectionEvent(var1, this);
      }

      super.handleMouseEvent(var1);
   }

   public boolean isSelected() {
      return this.combinedBasicblock.isSelected();
   }

   public boolean isVisible() {
      return this.combinedBasicblock.isVisible();
   }

   public String toString() {
      RawBasicBlock var1 = this.combinedBasicblock.getRawNode(ESide.PRIMARY);
      RawBasicBlock var2 = this.combinedBasicblock.getRawNode(ESide.SECONDARY);
      return String.format("%s ↔ %s", new Object[]{var1 == null?"missing":var1.getAddress().toHexString(), var2 == null?"missing":var2.getAddress().toHexString()});
   }
}
