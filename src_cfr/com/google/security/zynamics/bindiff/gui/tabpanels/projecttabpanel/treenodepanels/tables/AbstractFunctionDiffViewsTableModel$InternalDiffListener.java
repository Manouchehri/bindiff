/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractFunctionDiffViewsTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractFunctionDiffViewsTableModel$1;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.DiffListenerAdapter;
import java.io.File;
import java.util.Iterator;
import java.util.List;

class AbstractFunctionDiffViewsTableModel$InternalDiffListener
extends DiffListenerAdapter {
    final /* synthetic */ AbstractFunctionDiffViewsTableModel this$0;

    private AbstractFunctionDiffViewsTableModel$InternalDiffListener(AbstractFunctionDiffViewsTableModel abstractFunctionDiffViewsTableModel) {
        this.this$0 = abstractFunctionDiffViewsTableModel;
    }

    private Diff isExisting(String string) {
        Diff diff;
        Iterator iterator = this.this$0.functionDiffViewList.iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while (!(diff = (Diff)iterator.next()).getMatchesDatabase().getPath().equals(string));
        return diff;
    }

    @Override
    public void willOverwriteDiff(String string) {
        Diff diff = this.isExisting(string);
        if (diff == null) return;
        this.this$0.removeRow(diff);
    }

    /* synthetic */ AbstractFunctionDiffViewsTableModel$InternalDiffListener(AbstractFunctionDiffViewsTableModel abstractFunctionDiffViewsTableModel, AbstractFunctionDiffViewsTableModel$1 abstractFunctionDiffViewsTableModel$1) {
        this(abstractFunctionDiffViewsTableModel);
    }
}

