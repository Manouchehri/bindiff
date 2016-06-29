package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy;

import java.util.*;

public class CUndoHistory
{
    private final List m_undoStates;
    private int m_statePointer;
    
    public CUndoHistory() {
        this.m_undoStates = new ArrayList();
        this.m_statePointer = 0;
    }
    
    public void addState(final CUndoStateData cUndoStateData) {
        if (this.m_statePointer < this.m_undoStates.size() - 1) {
            final int n = (this.m_statePointer > 0) ? -1 : 0;
            final ArrayList<CUndoStateData> list = new ArrayList<CUndoStateData>();
            for (int i = this.m_statePointer - n; i < this.m_undoStates.size(); ++i) {
                list.add((CUndoStateData)this.m_undoStates.get(i));
            }
            final Iterator<Object> iterator = list.iterator();
            while (iterator.hasNext()) {
                this.m_undoStates.remove(iterator.next());
            }
        }
        if (!this.m_undoStates.isEmpty() && this.m_undoStates.get(this.m_undoStates.size() - 1).equals(cUndoStateData)) {
            this.m_undoStates.remove(this.m_undoStates.size() - 1);
        }
        this.m_undoStates.add(cUndoStateData);
        this.m_statePointer = this.m_undoStates.size() - 1;
    }
    
    public boolean isEmpty() {
        return this.m_undoStates.isEmpty();
    }
    
    public void redo() {
        if (this.m_statePointer < this.m_undoStates.size() - 1) {
            ++this.m_statePointer;
            this.m_undoStates.get(this.m_statePointer).restore();
        }
    }
    
    public void undo() {
        if (!this.m_undoStates.isEmpty() && this.m_statePointer > 0) {
            --this.m_statePointer;
            this.m_undoStates.get(this.m_statePointer).restore();
        }
    }
}
