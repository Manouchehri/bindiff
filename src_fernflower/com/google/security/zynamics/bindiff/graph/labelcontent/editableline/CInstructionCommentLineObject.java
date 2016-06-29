package com.google.security.zynamics.bindiff.graph.labelcontent.editableline;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.AbstractEditableLineObject;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawInstruction;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;

public class CInstructionCommentLineObject extends AbstractEditableLineObject {
   private final RawInstruction rawInstruction;
   private final ECommentPlacement commentPlacement;

   public CInstructionCommentLineObject(RawInstruction var1, ECommentPlacement var2, int var3, int var4) {
      super(var3, var4);
      this.rawInstruction = (RawInstruction)Preconditions.checkNotNull(var1);
      this.commentPlacement = (ECommentPlacement)Preconditions.checkNotNull(var2);
   }

   public Object getPersistentModel() {
      return this.rawInstruction;
   }

   public boolean update(String var1) {
      Preconditions.checkNotNull(var1);
      this.rawInstruction.setComment(var1, this.commentPlacement);
      return true;
   }

   public boolean updateComment(String var1, ECommentPlacement var2) {
      return this.update(var1);
   }
}
