package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes;

import com.google.security.zynamics.bindiff.project.diff.*;
import javax.swing.tree.*;

class DiffNode$InternalDiffModelListener extends DiffListenerAdapter
{
    final /* synthetic */ DiffNode this$0;
    
    private DiffNode$InternalDiffModelListener(final DiffNode this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void loadedDiff(final Diff diff) {
        if (!diff.isFunctionDiff()) {
            this.this$0.createChildren();
            this.this$0.getTree().expandPath(new TreePath(this.this$0.getPath()));
        }
    }
    
    @Override
    public void removedDiff(final Diff diff) {
        if (!diff.isFunctionDiff()) {
            this.this$0.removeFromParent();
            this.this$0.delete();
            this.this$0.getTree().setSelectionPath(new TreePath(this.this$0.getRoot().getPath()));
            this.this$0.getTree().updateTree();
        }
    }
    
    @Override
    public void unloadedDiff(final Diff diff) {
        if (!diff.isFunctionDiff()) {
            this.this$0.deleteChildren();
            this.this$0.getTree().setSelectionPath(new TreePath(this.this$0.getPath()));
            this.this$0.getTree().updateTree();
        }
    }
}
