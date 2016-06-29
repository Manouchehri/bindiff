package com.google.security.zynamics.bindiff.graph.labelcontent.editableline;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.AbstractEditableLineObject;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawInstruction;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;

public class InstructionObject extends AbstractEditableLineObject {
   private final RawInstruction rawInstruction;

   public InstructionObject(RawInstruction var1, int var2, int var3) {
      super(var2, var3);
      Preconditions.checkNotNull(var1);
      this.rawInstruction = var1;
   }

   public RawInstruction getPersistentModel() {
      return this.rawInstruction;
   }

   public boolean update(String var1) {
      return false;
   }

   public boolean updateComment(String var1, ECommentPlacement var2) {
      Preconditions.checkNotNull(var1);
      this.rawInstruction.setComment(var1, var2);
      return true;
   }
}
