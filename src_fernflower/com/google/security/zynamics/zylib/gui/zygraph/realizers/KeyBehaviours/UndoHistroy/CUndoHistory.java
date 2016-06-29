package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoStateData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CUndoHistory {
   private final List m_undoStates = new ArrayList();
   private int m_statePointer = 0;

   public void addState(CUndoStateData var1) {
      if(this.m_statePointer < this.m_undoStates.size() - 1) {
         int var2 = this.m_statePointer > 0?-1:0;
         ArrayList var3 = new ArrayList();

         for(int var4 = this.m_statePointer - var2; var4 < this.m_undoStates.size(); ++var4) {
            var3.add(this.m_undoStates.get(var4));
         }

         Iterator var7 = var3.iterator();

         while(var7.hasNext()) {
            CUndoStateData var5 = (CUndoStateData)var7.next();
            this.m_undoStates.remove(var5);
         }
      }

      if(!this.m_undoStates.isEmpty()) {
         CUndoStateData var6 = (CUndoStateData)this.m_undoStates.get(this.m_undoStates.size() - 1);
         if(var6.equals(var1)) {
            this.m_undoStates.remove(this.m_undoStates.size() - 1);
         }
      }

      this.m_undoStates.add(var1);
      this.m_statePointer = this.m_undoStates.size() - 1;
   }

   public boolean isEmpty() {
      return this.m_undoStates.isEmpty();
   }

   public void redo() {
      if(this.m_statePointer < this.m_undoStates.size() - 1) {
         ++this.m_statePointer;
         ((CUndoStateData)this.m_undoStates.get(this.m_statePointer)).restore();
      }

   }

   public void undo() {
      if(!this.m_undoStates.isEmpty() && this.m_statePointer > 0) {
         --this.m_statePointer;
         ((CUndoStateData)this.m_undoStates.get(this.m_statePointer)).restore();
      }

   }
}
