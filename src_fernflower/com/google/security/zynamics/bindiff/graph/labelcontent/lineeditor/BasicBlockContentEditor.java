package com.google.security.zynamics.bindiff.graph.labelcontent.lineeditor;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EPlaceholderType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.builders.ViewCodeNodeBuilder;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.BasicBlockLineObject;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.PlaceholderObject;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.project.helpers.GraphGetter;
import com.google.security.zynamics.bindiff.project.helpers.MatchesGetter;
import com.google.security.zynamics.bindiff.project.matches.BasicBlockMatchData;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawInstruction;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyLineEditor;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.strings.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BasicBlockContentEditor implements IZyLineEditor {
   private static int NODELABEL_PADDING = 10;
   private final GraphsContainer graphContainer;
   private final FunctionMatchData functionMatch;
   private final ESide side;

   public BasicBlockContentEditor(FunctionMatchData var1, GraphsContainer var2, ESide var3) {
      this.functionMatch = var1;
      this.graphContainer = (GraphsContainer)Preconditions.checkNotNull(var2);
      this.side = (ESide)Preconditions.checkNotNull(var3);
   }

   private int preCountLabelCommentLines(RawBasicBlock var1, ESide var2) {
      int var3 = 0;
      if(var2 == var1.getSide()) {
         if(!var1.getComment().isEmpty()) {
            var3 = StringHelper.count(var1.getComment(), '\n') + 1;
         }
      } else {
         SingleDiffNode var4 = null;
         if(var2 == ESide.PRIMARY) {
            var4 = GraphGetter.getPrimaryDiffNode(this.graphContainer.getSecondaryGraph(), var1);
         } else {
            var4 = GraphGetter.getSecondaryDiffNode(this.graphContainer.getPrimaryGraph(), var1);
         }

         if(var4 != null) {
            RawBasicBlock var5 = (RawBasicBlock)var4.getRawNode();
            if(!var5.getComment().isEmpty()) {
               var3 = StringHelper.count(var5.getComment(), '\n') + 1;
            }
         }
      }

      return var3;
   }

   private void recreateInstruction(ZyLabelContent var1, RawInstruction var2, int var3, int var4, int var5) {
      RawBasicBlock var6 = ((BasicBlockLineObject)var1.getModel()).getRawBasicblock();
      int var7 = var6.getMaxOperandLength();
      int var8 = var1.getLastLineIndexOfModelAt(var3);

      for(int var9 = var3; var9 <= var8; ++var9) {
         var1.removeLine(var3);
      }

      boolean var14 = false;
      if(this.functionMatch != null && var2 != null) {
         var14 = MatchesGetter.isMatchedInstruction(this.functionMatch, var6, var2);
      }

      List var10 = ViewCodeNodeBuilder.buildInstruction(var2, var7, !var14, this.side, var4, var5);
      int var11 = var3;
      Iterator var12 = var10.iterator();

      while(var12.hasNext()) {
         ZyLineContent var13 = (ZyLineContent)var12.next();
         var1.insertLine(var13, var11++);
      }

   }

   private void recreateInstructionSynchronized(ZyLabelContent var1, RawInstruction var2, int var3) {
      RawBasicBlock var4 = ((BasicBlockLineObject)var1.getModel()).getRawBasicblock();
      ESide var5 = var4.getSide();
      RawInstruction var6 = null;
      RawInstruction var7 = null;
      RawBasicBlock var8;
      BasicBlockMatchData var9;
      IAddress var10;
      if(var4.getSide() == ESide.PRIMARY) {
         var6 = var2;
         var7 = null;
         var8 = GraphGetter.getSecondaryRawBasicblock(this.graphContainer, var4);
         var9 = MatchesGetter.getBasicblockMatch(this.functionMatch, var4);
         if(var9 != null) {
            var10 = var9.getSecondaryInstructionAddr(var2.getAddress());
            var7 = var8.getInstruction(var10);
         }
      } else {
         var6 = null;
         var7 = var2;
         var8 = GraphGetter.getPrimaryRawBasicblock(this.graphContainer, var4);
         var9 = MatchesGetter.getBasicblockMatch(this.functionMatch, var4);
         if(var9 != null) {
            var10 = var9.getPrimaryInstructionAddr(var2.getAddress());
            var6 = var8.getInstruction(var10);
         }
      }

      int var18 = ViewCodeNodeBuilder.precalcMaxCommentLineCount(var6, var7, ECommentPlacement.ABOVE_LINE);
      int var19 = ViewCodeNodeBuilder.precalcMaxCommentLineCount(var6, var7, ECommentPlacement.BEHIND_LINE);
      var1.setRightPadding(NODELABEL_PADDING);
      this.recreateInstruction(var1, var2, var3, var18, var19);
      var10 = null;
      SingleDiffNode var16;
      if(var5 == ESide.PRIMARY) {
         var16 = GraphGetter.getSecondaryDiffNode(this.graphContainer.getPrimaryGraph(), var4);
      } else {
         var16 = GraphGetter.getPrimaryDiffNode(this.graphContainer.getSecondaryGraph(), var4);
      }

      if(var16 != null) {
         ZyLabelContent var11 = var16.getRealizer().getNodeContent();
         var11.setRightPadding(NODELABEL_PADDING);
         this.recreateInstruction(var11, var5 == ESide.PRIMARY?var7:var6, var3, var18, var19);
         double var12 = var1.getBounds().getWidth();
         double var14 = var11.getBounds().getWidth();
         if(var12 > var14) {
            var11.setRightPadding((int)Math.round(var12 - var14) + 10);
         } else {
            var1.setRightPadding((int)Math.round(var14 - var12) + 10);
         }

         var16.getRealizer().regenerate();
      }

      SingleDiffNode var17 = GraphGetter.getDiffNode(this.graphContainer, var4);
      var17.getRealizer().regenerate();
      this.graphContainer.getSuperGraph().refreshSuperNodeSize(this.graphContainer.getPrimaryGraph(), this.graphContainer.getSecondaryGraph(), var17.getSuperDiffNode());
      this.graphContainer.updateViews();
   }

   private void recreateLabelComment(ZyLabelContent var1, RawBasicBlock var2, int var3) {
      ArrayList var4 = new ArrayList();
      int var5 = var1.getLineCount();
      var4.addAll(ViewCodeNodeBuilder.buildBasicblockComment(var2, var3));
      int var6 = var5;

      while(true) {
         --var6;
         if(var6 <= 0) {
            break;
         }

         ZyLineContent var7 = var1.getLineContent(var6);
         IZyEditableObject var8 = var7.getLineObject();
         if(var8.isPlaceholder()) {
            if(((PlaceholderObject)var8).getPlaceholderType() != EPlaceholderType.BASICBLOCK_COMMENT) {
               break;
            }

            var1.removeLine(var6);
         } else {
            if(!(var8.getPersistentModel() instanceof RawBasicBlock)) {
               break;
            }

            var1.removeLine(var6);
         }
      }

      Iterator var9 = var4.iterator();

      while(var9.hasNext()) {
         ZyLineContent var10 = (ZyLineContent)var9.next();
         var1.addLineContent(var10);
      }

   }

   private void recreateLabelCommentSynchronized(ZyLabelContent var1, RawBasicBlock var2) {
      ESide var3 = var2.getSide();
      int var4 = this.preCountLabelCommentLines(var2, var3);
      int var5 = this.preCountLabelCommentLines(var2, var3 == ESide.PRIMARY?ESide.SECONDARY:ESide.PRIMARY);
      int var6 = Math.max(var4, var5);
      var1.setRightPadding(NODELABEL_PADDING);
      this.recreateLabelComment(var1, var2, var6);
      SingleDiffNode var7 = null;
      RawBasicBlock var8 = null;
      if(var3 == ESide.PRIMARY) {
         var7 = GraphGetter.getSecondaryDiffNode(this.graphContainer.getPrimaryGraph(), var2);
         var8 = GraphGetter.getSecondaryRawBasicblock(this.graphContainer, var2);
      } else {
         var7 = GraphGetter.getPrimaryDiffNode(this.graphContainer.getSecondaryGraph(), var2);
         var8 = GraphGetter.getPrimaryRawBasicblock(this.graphContainer, var2);
      }

      if(var8 != null) {
         ZyLabelContent var9 = var7.getRealizer().getNodeContent();
         var9.setRightPadding(NODELABEL_PADDING);
         this.recreateLabelComment(var9, var8, var6);
         double var10 = var1.getBounds().getWidth();
         double var12 = var9.getBounds().getWidth();
         if(var10 > var12) {
            var9.setRightPadding((int)Math.round(var10 - var12) + NODELABEL_PADDING);
         } else {
            var1.setRightPadding((int)Math.round(var12 - var10) + NODELABEL_PADDING);
         }

         var7.getRealizer().regenerate();
      }

      SingleDiffNode var14 = GraphGetter.getDiffNode(this.graphContainer, var2);
      var14.getRealizer().regenerate();
      this.graphContainer.getSuperGraph().refreshSuperNodeSize(this.graphContainer.getPrimaryGraph(), this.graphContainer.getSecondaryGraph(), var14.getSuperDiffNode());
      this.graphContainer.updateViews();
   }

   private boolean validateLineCountEquality(ZyLabelContent var1, RawBasicBlock var2) {
      ESide var3 = var2.getSide();
      SingleDiffNode var4;
      RawBasicBlock var5;
      if(var3 == ESide.PRIMARY) {
         var4 = GraphGetter.getSecondaryDiffNode(this.graphContainer.getPrimaryGraph(), var2);
         var5 = GraphGetter.getSecondaryRawBasicblock(this.graphContainer, var2);
      } else {
         var4 = GraphGetter.getPrimaryDiffNode(this.graphContainer.getSecondaryGraph(), var2);
         var5 = GraphGetter.getPrimaryRawBasicblock(this.graphContainer, var2);
      }

      if(var5 != null) {
         ZyLabelContent var6 = var4.getRealizer().getNodeContent();
         return var1.getLineCount() == var6.getLineCount();
      } else {
         return true;
      }
   }

   public void recreateLabelLines(ZyLabelContent var1, Object var2) {
      int var3 = 0;

      for(Iterator var4 = var1.getContent().iterator(); var4.hasNext(); ++var3) {
         ZyLineContent var5 = (ZyLineContent)var4.next();
         IZyEditableObject var6 = var5.getLineObject();
         if(var6 != null && var6.getPersistentModel() == var2) {
            if(var2 instanceof RawBasicBlock) {
               this.recreateLabelCommentSynchronized(var1, (RawBasicBlock)var2);
               return;
            }

            if(var2 instanceof RawInstruction) {
               var3 = var1.getFirstLineIndexOfModelAt(var3);
               this.recreateInstructionSynchronized(var1, (RawInstruction)var2, var3);
               if(!this.validateLineCountEquality(var1, ((BasicBlockLineObject)var1.getModel()).getRawBasicblock())) {
                  throw new RuntimeException("Pimary and secondary basicblock label content line count are not equal.");
               }
            }
         }
      }

      if(var2 instanceof RawBasicBlock) {
         this.recreateLabelCommentSynchronized(var1, (RawBasicBlock)var2);
         if(!this.validateLineCountEquality(var1, ((BasicBlockLineObject)var1.getModel()).getRawBasicblock())) {
            throw new RuntimeException("Pimary and secondary basicblock label content line count are not equal.");
         }
      }

   }

   public void refreshSize(ZyLabelContent var1, Object var2) {
      RawBasicBlock var3 = null;
      if(var2 instanceof RawBasicBlock) {
         var3 = (RawBasicBlock)var2;
      } else {
         if(!(var2 instanceof RawInstruction)) {
            return;
         }

         var3 = ((BasicBlockLineObject)var1.getModel()).getRawBasicblock();
      }

      SingleDiffNode var4 = GraphGetter.getDiffNode(this.graphContainer, var3);
      this.graphContainer.getSuperGraph().refreshSuperNodeSize(this.graphContainer.getPrimaryGraph(), this.graphContainer.getPrimaryGraph(), var4.getSuperDiffNode());
   }
}
