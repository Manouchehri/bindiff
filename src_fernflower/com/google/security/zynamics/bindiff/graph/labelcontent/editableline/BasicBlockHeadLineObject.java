package com.google.security.zynamics.bindiff.graph.labelcontent.editableline;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.AbstractEditableLineObject;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;

public class BasicBlockHeadLineObject extends AbstractEditableLineObject {
   private final RawBasicBlock rawBasicblock;

   public BasicBlockHeadLineObject(RawBasicBlock var1) {
      super(0, 0);
      Preconditions.checkNotNull(var1);
      this.rawBasicblock = var1;
   }

   public final Object getPersistentModel() {
      return this.rawBasicblock;
   }

   public boolean update(String var1) {
      return false;
   }

   public boolean updateComment(String var1, ECommentPlacement var2) {
      return false;
   }
}
