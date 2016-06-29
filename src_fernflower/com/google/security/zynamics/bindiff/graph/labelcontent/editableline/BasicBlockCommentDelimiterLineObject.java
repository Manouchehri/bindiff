package com.google.security.zynamics.bindiff.graph.labelcontent.editableline;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.AbstractEditableLineObject;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;

public class BasicBlockCommentDelimiterLineObject extends AbstractEditableLineObject {
   private final RawBasicBlock rawBasicblock;

   public BasicBlockCommentDelimiterLineObject(RawBasicBlock var1, int var2, int var3) {
      super(var2, var3);
      Preconditions.checkNotNull(var1);
      this.rawBasicblock = var1;
   }

   public final Object getPersistentModel() {
      return this.rawBasicblock;
   }

   public boolean isCommentDelimiter() {
      return true;
   }

   public boolean update(String var1) {
      Preconditions.checkNotNull(var1);
      this.rawBasicblock.setComment(var1);
      return true;
   }

   public boolean updateComment(String var1, ECommentPlacement var2) {
      return false;
   }
}
