package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.project.diff.*;
import java.util.*;

class AbstractFunctionDiffViewsTableModel$InternalDiffListener extends DiffListenerAdapter
{
    final /* synthetic */ AbstractFunctionDiffViewsTableModel this$0;
    
    private AbstractFunctionDiffViewsTableModel$InternalDiffListener(final AbstractFunctionDiffViewsTableModel this$0) {
        this.this$0 = this$0;
    }
    
    private Diff isExisting(final String s) {
        for (final Diff diff : this.this$0.functionDiffViewList) {
            if (diff.getMatchesDatabase().getPath().equals(s)) {
                return diff;
            }
        }
        return null;
    }
    
    @Override
    public void willOverwriteDiff(final String s) {
        final Diff existing = this.isExisting(s);
        if (existing != null) {
            this.this$0.removeRow(existing);
        }
    }
}
