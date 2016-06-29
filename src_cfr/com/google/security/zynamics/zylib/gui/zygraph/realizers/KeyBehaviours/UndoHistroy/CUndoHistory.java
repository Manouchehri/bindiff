/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoStateData;
import java.util.ArrayList;
import java.util.List;

public class CUndoHistory {
    private final List m_undoStates = new ArrayList();
    private int m_statePointer = 0;

    public void addState(CUndoStateData cUndoStateData) {
        CUndoStateData cUndoStateData2;
        if (this.m_statePointer < this.m_undoStates.size() - 1) {
            int n2 = this.m_statePointer > 0 ? -1 : 0;
            ArrayList arrayList = new ArrayList();
            for (int i2 = this.m_statePointer - n2; i2 < this.m_undoStates.size(); ++i2) {
                arrayList.add(this.m_undoStates.get(i2));
            }
            for (CUndoStateData cUndoStateData3 : arrayList) {
                this.m_undoStates.remove(cUndoStateData3);
            }
        }
        if (!this.m_undoStates.isEmpty() && (cUndoStateData2 = (CUndoStateData)this.m_undoStates.get(this.m_undoStates.size() - 1)).equals(cUndoStateData)) {
            this.m_undoStates.remove(this.m_undoStates.size() - 1);
        }
        this.m_undoStates.add(cUndoStateData);
        this.m_statePointer = this.m_undoStates.size() - 1;
    }

    public boolean isEmpty() {
        return this.m_undoStates.isEmpty();
    }

    public void redo() {
        if (this.m_statePointer >= this.m_undoStates.size() - 1) return;
        ++this.m_statePointer;
        ((CUndoStateData)this.m_undoStates.get(this.m_statePointer)).restore();
    }

    public void undo() {
        if (this.m_undoStates.isEmpty()) return;
        if (this.m_statePointer <= 0) return;
        --this.m_statePointer;
        ((CUndoStateData)this.m_undoStates.get(this.m_statePointer)).restore();
    }
}

