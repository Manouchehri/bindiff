package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy;

import java.util.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;

public class CUndoManager
{
    private final Map m_undoHistories;
    private ZyLabelContent m_labelContent;
    
    public CUndoManager() {
        this.m_undoHistories = new HashMap();
        this.m_labelContent = null;
    }
    
    private CUndoHistory getUndoHistory() {
        if (this.m_labelContent == null) {
            return null;
        }
        CUndoHistory cUndoHistory = this.m_undoHistories.get(this.m_labelContent);
        if (cUndoHistory == null) {
            cUndoHistory = new CUndoHistory();
            this.m_undoHistories.put(this.m_labelContent, cUndoHistory);
        }
        return cUndoHistory;
    }
    
    public void addUndoState(final ZyLabelContent zyLabelContent, final Object o, final IZyEditableObject zyEditableObject, final String s, final boolean b, final boolean b2, final boolean b3, final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        if (o == null) {
            return;
        }
        final CUndoHistory undoHistory = this.getUndoHistory();
        if (undoHistory != null) {
            undoHistory.addState(new CUndoStateData(zyLabelContent, o, zyEditableObject, s, b, b2, b3, n, n2, n3, n4, n5, n6));
        }
    }
    
    public void redo() {
        final CUndoHistory undoHistory = this.getUndoHistory();
        if (undoHistory != null) {
            undoHistory.redo();
        }
    }
    
    public void setLabelContent(final ZyLabelContent labelContent) {
        this.m_labelContent = labelContent;
    }
    
    public void undo() {
        final CUndoHistory undoHistory = this.getUndoHistory();
        if (undoHistory != null) {
            undoHistory.undo();
        }
    }
}
