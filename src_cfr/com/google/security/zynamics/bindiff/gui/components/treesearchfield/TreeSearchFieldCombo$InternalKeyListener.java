/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.components.treesearchfield;

import com.google.security.zynamics.bindiff.gui.components.treesearchfield.ITreeSearchFieldListener;
import com.google.security.zynamics.bindiff.gui.components.treesearchfield.TreeSearchFieldCombo;
import com.google.security.zynamics.bindiff.gui.components.treesearchfield.TreeSearchFieldCombo$1;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;

class TreeSearchFieldCombo$InternalKeyListener
implements KeyListener {
    final /* synthetic */ TreeSearchFieldCombo this$0;

    private TreeSearchFieldCombo$InternalKeyListener(TreeSearchFieldCombo treeSearchFieldCombo) {
        this.this$0 = treeSearchFieldCombo;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        if (keyEvent.getKeyChar() != '\n') return;
        if (TreeSearchFieldCombo.access$200(this.this$0).equals(TreeSearchFieldCombo.access$100(this.this$0))) return;
        if (!TreeSearchFieldCombo.access$200(this.this$0).equals("")) {
            this.this$0.add(TreeSearchFieldCombo.access$200(this.this$0));
        }
        Iterator iterator = TreeSearchFieldCombo.access$300(this.this$0).iterator();
        do {
            if (!iterator.hasNext()) {
                TreeSearchFieldCombo.access$102(this.this$0, TreeSearchFieldCombo.access$200(this.this$0));
                return;
            }
            ITreeSearchFieldListener iTreeSearchFieldListener = (ITreeSearchFieldListener)iterator.next();
            iTreeSearchFieldListener.searchChanged(TreeSearchFieldCombo.access$200(this.this$0));
        } while (true);
    }

    /* synthetic */ TreeSearchFieldCombo$InternalKeyListener(TreeSearchFieldCombo treeSearchFieldCombo, TreeSearchFieldCombo$1 treeSearchFieldCombo$1) {
        this(treeSearchFieldCombo);
    }
}

