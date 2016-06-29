package com.google.security.zynamics.bindiff.project.rawflowgraph;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;

public class RawInstructionComment {
   private final ECommentPlacement commentPlacement;
   private String text;
   private boolean modified = false;

   public RawInstructionComment(String var1, ECommentPlacement var2) {
      this.text = (String)Preconditions.checkNotNull(var1);
      this.commentPlacement = var2;
   }

   public String getText() {
      return this.text;
   }

   public boolean isModified() {
      return this.modified;
   }

   public ECommentPlacement getPlacement() {
      return this.commentPlacement;
   }

   public boolean isChangedComment() {
      return this.modified;
   }

   public void setText(String var1) {
      this.text = var1;
      this.modified = true;
   }
}
