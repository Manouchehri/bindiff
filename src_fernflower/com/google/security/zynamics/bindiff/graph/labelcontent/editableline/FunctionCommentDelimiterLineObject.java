package com.google.security.zynamics.bindiff.graph.labelcontent.editableline;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.AbstractEditableLineObject;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;

public class FunctionCommentDelimiterLineObject extends AbstractEditableLineObject {
   private final RawFunction rawFunction;

   public FunctionCommentDelimiterLineObject(RawFunction var1, int var2, int var3) {
      super(var2, var3);
      Preconditions.checkNotNull(var1);
      this.rawFunction = var1;
   }

   public Object getPersistentModel() {
      return this.rawFunction;
   }

   public boolean isCommentDelimiter() {
      return true;
   }

   public boolean update(String var1) {
      Preconditions.checkNotNull(var1);
      this.rawFunction.setComment(var1);
      return true;
   }

   public boolean updateComment(String var1, ECommentPlacement var2) {
      return false;
   }
}
