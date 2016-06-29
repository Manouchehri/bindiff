package com.google.security.zynamics.bindiff.graph.labelcontent.editableline;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;

public abstract class AbstractEditableLineObject implements IZyEditableObject {
   protected final int start;
   protected final int length;

   protected AbstractEditableLineObject(int var1, int var2) {
      this.start = var1;
      this.length = var2;
   }

   public int getEnd() {
      return this.start + this.length;
   }

   public int getLength() {
      return this.length;
   }

   public int getStart() {
      return this.start;
   }

   public boolean isCommentDelimiter() {
      return false;
   }

   public boolean isPlaceholder() {
      return false;
   }
}
