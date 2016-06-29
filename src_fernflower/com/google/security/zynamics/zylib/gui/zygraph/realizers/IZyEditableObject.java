package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;

public interface IZyEditableObject {
   int getEnd();

   int getLength();

   Object getPersistentModel();

   int getStart();

   boolean isCommentDelimiter();

   boolean isPlaceholder();

   boolean update(String var1);

   boolean updateComment(String var1, ECommentPlacement var2);
}
