/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoHistory;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoStateData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import java.util.HashMap;
import java.util.Map;

public class CUndoManager {
    private final Map m_undoHistories = new HashMap();
    private ZyLabelContent m_labelContent = null;

    private CUndoHistory getUndoHistory() {
        if (this.m_labelContent == null) {
            return null;
        }
        CUndoHistory cUndoHistory = (CUndoHistory)this.m_undoHistories.get(this.m_labelContent);
        if (cUndoHistory != null) return cUndoHistory;
        cUndoHistory = new CUndoHistory();
        this.m_undoHistories.put(this.m_labelContent, cUndoHistory);
        return cUndoHistory;
    }

    public void addUndoState(ZyLabelContent zyLabelContent, Object object, IZyEditableObject iZyEditableObject, String string, boolean bl2, boolean bl3, boolean bl4, int n2, int n3, int n4, int n5, int n6, int n7) {
        if (object == null) {
            return;
        }
        CUndoHistory cUndoHistory = this.getUndoHistory();
        if (cUndoHistory == null) return;
        CUndoStateData cUndoStateData = new CUndoStateData(zyLabelContent, object, iZyEditableObject, string, bl2, bl3, bl4, n2, n3, n4, n5, n6, n7);
        cUndoHistory.addState(cUndoStateData);
    }

    public void redo() {
        CUndoHistory cUndoHistory = this.getUndoHistory();
        if (cUndoHistory == null) return;
        cUndoHistory.redo();
    }

    public void setLabelContent(ZyLabelContent zyLabelContent) {
        this.m_labelContent = zyLabelContent;
    }

    public void undo() {
        CUndoHistory cUndoHistory = this.getUndoHistory();
        if (cUndoHistory == null) return;
        cUndoHistory.undo();
    }
}

