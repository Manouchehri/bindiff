/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTree$1;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.tree.TreePath;

class JCriteriumTree$InternalMouseListener
extends MouseAdapter {
    final /* synthetic */ JCriteriumTree this$0;

    private JCriteriumTree$InternalMouseListener(JCriteriumTree jCriteriumTree) {
        this.this$0 = jCriteriumTree;
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        JCriteriumTree.access$102(this.this$0, this.this$0.getPathForLocation(mouseEvent.getX(), mouseEvent.getY()));
        if (!mouseEvent.isPopupTrigger()) return;
        JCriteriumTree.access$200(this.this$0, mouseEvent);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        JCriteriumTree.access$102(this.this$0, this.this$0.getPathForLocation(mouseEvent.getX(), mouseEvent.getY()));
        if (!mouseEvent.isPopupTrigger()) return;
        JCriteriumTree.access$200(this.this$0, mouseEvent);
    }

    /* synthetic */ JCriteriumTree$InternalMouseListener(JCriteriumTree jCriteriumTree, JCriteriumTree$1 jCriteriumTree$1) {
        this(jCriteriumTree);
    }
}

