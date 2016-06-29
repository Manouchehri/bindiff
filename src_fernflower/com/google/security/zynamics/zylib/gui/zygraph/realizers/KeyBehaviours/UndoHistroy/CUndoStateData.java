package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;

public class CUndoStateData {
   private final ZyLabelContent m_labelContent;
   private final Object m_persistentModel;
   private final IZyEditableObject m_editableObject;
   private final String m_text;
   private final boolean m_isAboveLineComment;
   private final boolean m_isBehindLineComment;
   private final boolean m_isLabelComment;
   private final int m_caretStartX;
   private final int m_caretMousePressedX;
   private final int m_caretMousePressedY;
   private final int m_caretEndX;
   private final int m_caretMouseReleasedX;
   private final int m_caretMouseReleasedY;

   public CUndoStateData(ZyLabelContent var1, Object var2, IZyEditableObject var3, String var4, boolean var5, boolean var6, boolean var7, int var8, int var9, int var10, int var11, int var12, int var13) {
      Preconditions.checkNotNull(var1, "Error: Label content can\'t be null.");
      Preconditions.checkNotNull(var2, "Error: Persistent model can\'t be null.");
      Preconditions.checkNotNull(var3, "Error: Editable object cant be null.");
      Preconditions.checkNotNull(var4, "Error: Text can\'t be null.");
      this.m_labelContent = var1;
      this.m_persistentModel = var2;
      this.m_editableObject = var3;
      this.m_text = var4;
      this.m_isAboveLineComment = var5;
      this.m_isBehindLineComment = var6;
      this.m_isLabelComment = var7;
      this.m_caretStartX = var8;
      this.m_caretMousePressedX = var9;
      this.m_caretMousePressedY = var10;
      this.m_caretEndX = var11;
      this.m_caretMouseReleasedX = var12;
      this.m_caretMouseReleasedY = var13;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof CUndoStateData)) {
         return false;
      } else {
         CUndoStateData var2 = (CUndoStateData)var1;
         return this.m_isAboveLineComment == var2.m_isAboveLineComment && this.m_isBehindLineComment == var2.m_isBehindLineComment && this.m_isLabelComment == var2.m_isLabelComment && this.m_persistentModel == var2.m_persistentModel && this.m_text.equals(var2.m_text);
      }
   }

   public int hashCode() {
      byte var1 = 0;
      int var2 = 64 + this.m_text.hashCode();
      var2 *= this.m_persistentModel.hashCode();
      int var3 = var1 + (this.m_isAboveLineComment?1:2);
      var3 += this.m_isBehindLineComment?4:8;
      var3 += this.m_isBehindLineComment?16:32;
      var3 += var2;
      return var3;
   }

   public void restore() {
      if(this.m_isAboveLineComment) {
         this.m_editableObject.updateComment(this.m_text, ECommentPlacement.ABOVE_LINE);
      } else if(this.m_isBehindLineComment) {
         this.m_editableObject.updateComment(this.m_text, ECommentPlacement.BEHIND_LINE);
      } else {
         if(!this.m_isLabelComment) {
            throw new RuntimeException("Not implemented yet.");
         }

         this.m_editableObject.update(this.m_text);
      }

      this.m_labelContent.getLineEditor().recreateLabelLines(this.m_labelContent, this.m_persistentModel);
      this.m_labelContent.getCaret().setCaret(this.m_caretStartX, this.m_caretMousePressedX, this.m_caretMousePressedY, this.m_caretEndX, this.m_caretMouseReleasedX, this.m_caretMouseReleasedY);
   }
}
