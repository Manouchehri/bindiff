package com.google.security.zynamics.zylib.general.undo;

import com.google.security.zynamics.zylib.general.undo.IUndoable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UndoStack implements Iterable {
   private final List undoStack = new ArrayList();
   private int undoPosition = 0;

   public void add(IUndoable var1) {
      int var2 = this.undoStack.size() - this.undoPosition;

      for(int var3 = 0; var3 < var2; ++var3) {
         this.undoStack.remove(this.undoPosition);
      }

      this.undoStack.add(var1);
      ++this.undoPosition;
   }

   public boolean canRedo() {
      return this.undoPosition < this.undoStack.size();
   }

   public boolean canUndo() {
      return this.undoPosition > 0;
   }

   public Iterator iterator() {
      return this.undoStack.iterator();
   }

   public void redo() {
      IUndoable var1 = (IUndoable)this.undoStack.get(this.undoPosition);
      var1.revertToSnapshot();
      ++this.undoPosition;
   }

   public void undo() {
      IUndoable var1 = (IUndoable)this.undoStack.get(this.undoPosition - 1);
      var1.undo();
      --this.undoPosition;
   }
}
