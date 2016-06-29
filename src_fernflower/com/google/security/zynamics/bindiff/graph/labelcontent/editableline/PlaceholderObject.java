package com.google.security.zynamics.bindiff.graph.labelcontent.editableline;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EPlaceholderType;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.AbstractEditableLineObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;

public class PlaceholderObject extends AbstractEditableLineObject {
   private final EPlaceholderType placeholderType;

   public PlaceholderObject(EPlaceholderType var1) {
      super(0, 0);
      Preconditions.checkNotNull(var1);
      this.placeholderType = var1;
   }

   public Object getPersistentModel() {
      return null;
   }

   public EPlaceholderType getPlaceholderType() {
      return this.placeholderType;
   }

   public boolean isPlaceholder() {
      return true;
   }

   public boolean update(String var1) {
      return false;
   }

   public boolean updateComment(String var1, ECommentPlacement var2) {
      return false;
   }
}
