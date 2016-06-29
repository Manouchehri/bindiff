/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.general.undo;

import com.google.security.zynamics.zylib.general.undo.IUndoable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UndoStack
implements Iterable {
    private final List undoStack = new ArrayList();
    private int undoPosition = 0;

    public void add(IUndoable iUndoable) {
        int n2 = this.undoStack.size() - this.undoPosition;
        int n3 = 0;
        do {
            if (n3 >= n2) {
                this.undoStack.add(iUndoable);
                ++this.undoPosition;
                return;
            }
            this.undoStack.remove(this.undoPosition);
            ++n3;
        } while (true);
    }

    public boolean canRedo() {
        if (this.undoPosition >= this.undoStack.size()) return false;
        return true;
    }

    public boolean canUndo() {
        if (this.undoPosition <= 0) return false;
        return true;
    }

    public Iterator iterator() {
        return this.undoStack.iterator();
    }

    public void redo() {
        IUndoable iUndoable = (IUndoable)this.undoStack.get(this.undoPosition);
        iUndoable.revertToSnapshot();
        ++this.undoPosition;
    }

    public void undo() {
        IUndoable iUndoable = (IUndoable)this.undoStack.get(this.undoPosition - 1);
        iUndoable.undo();
        --this.undoPosition;
    }
}

