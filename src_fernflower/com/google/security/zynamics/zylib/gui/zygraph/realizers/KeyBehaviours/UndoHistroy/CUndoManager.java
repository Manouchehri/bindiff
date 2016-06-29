package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoHistory;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoStateData;
import java.util.HashMap;
import java.util.Map;

public class CUndoManager {
   private final Map m_undoHistories = new HashMap();
   private ZyLabelContent m_labelContent = null;

   private CUndoHistory getUndoHistory() {
      if(this.m_labelContent == null) {
         return null;
      } else {
         CUndoHistory var1 = (CUndoHistory)this.m_undoHistories.get(this.m_labelContent);
         if(var1 == null) {
            var1 = new CUndoHistory();
            this.m_undoHistories.put(this.m_labelContent, var1);
         }

         return var1;
      }
   }

   public void addUndoState(ZyLabelContent var1, Object var2, IZyEditableObject var3, String var4, boolean var5, boolean var6, boolean var7, int var8, int var9, int var10, int var11, int var12, int var13) {
      if(var2 != null) {
         CUndoHistory var14 = this.getUndoHistory();
         if(var14 != null) {
            CUndoStateData var15 = new CUndoStateData(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13);
            var14.addState(var15);
         }

      }
   }

   public void redo() {
      CUndoHistory var1 = this.getUndoHistory();
      if(var1 != null) {
         var1.redo();
      }

   }

   public void setLabelContent(ZyLabelContent var1) {
      this.m_labelContent = var1;
   }

   public void undo() {
      CUndoHistory var1 = this.getUndoHistory();
      if(var1 != null) {
         var1.undo();
      }

   }
}
