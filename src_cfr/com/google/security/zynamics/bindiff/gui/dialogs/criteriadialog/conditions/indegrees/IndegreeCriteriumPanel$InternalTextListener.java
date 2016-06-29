/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees.IndegreeCriteriumPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees.IndegreeCriteriumPanel$1;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class IndegreeCriteriumPanel$InternalTextListener
implements KeyListener {
    final /* synthetic */ IndegreeCriteriumPanel this$0;

    private IndegreeCriteriumPanel$InternalTextListener(IndegreeCriteriumPanel indegreeCriteriumPanel) {
        this.this$0 = indegreeCriteriumPanel;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        IndegreeCriteriumPanel.access$200(this.this$0).update();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        IndegreeCriteriumPanel.access$200(this.this$0).update();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        IndegreeCriteriumPanel.access$200(this.this$0).update();
    }

    /* synthetic */ IndegreeCriteriumPanel$InternalTextListener(IndegreeCriteriumPanel indegreeCriteriumPanel, IndegreeCriteriumPanel$1 indegreeCriteriumPanel$1) {
        this(indegreeCriteriumPanel);
    }
}

