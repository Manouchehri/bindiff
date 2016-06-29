package com.google.security.zynamics.zylib.general.undo;

import java.util.*;

public class UndoStack implements Iterable
{
    private final List undoStack;
    private int undoPosition;
    
    public UndoStack() {
        this.undoStack = new ArrayList();
        this.undoPosition = 0;
    }
    
    public void add(final IUndoable undoable) {
        for (int n = this.undoStack.size() - this.undoPosition, i = 0; i < n; ++i) {
            this.undoStack.remove(this.undoPosition);
        }
        this.undoStack.add(undoable);
        ++this.undoPosition;
    }
    
    public boolean canRedo() {
        return this.undoPosition < this.undoStack.size();
    }
    
    public boolean canUndo() {
        return this.undoPosition > 0;
    }
    
    @Override
    public Iterator iterator() {
        return this.undoStack.iterator();
    }
    
    public void redo() {
        this.undoStack.get(this.undoPosition).revertToSnapshot();
        ++this.undoPosition;
    }
    
    public void undo() {
        this.undoStack.get(this.undoPosition - 1).undo();
        --this.undoPosition;
    }
}
