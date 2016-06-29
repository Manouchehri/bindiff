/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree.OutdegreeCriteriumPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree.OutdegreeCriteriumPanel$1;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class OutdegreeCriteriumPanel$InternalTextListener
implements KeyListener {
    final /* synthetic */ OutdegreeCriteriumPanel this$0;

    private OutdegreeCriteriumPanel$InternalTextListener(OutdegreeCriteriumPanel outdegreeCriteriumPanel) {
        this.this$0 = outdegreeCriteriumPanel;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        OutdegreeCriteriumPanel.access$200(this.this$0).update();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        OutdegreeCriteriumPanel.access$200(this.this$0).update();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        OutdegreeCriteriumPanel.access$200(this.this$0).update();
    }

    /* synthetic */ OutdegreeCriteriumPanel$InternalTextListener(OutdegreeCriteriumPanel outdegreeCriteriumPanel, OutdegreeCriteriumPanel$1 outdegreeCriteriumPanel$1) {
        this(outdegreeCriteriumPanel);
    }
}

