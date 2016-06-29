/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.text;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.text.TextCriteriumPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.text.TextCriteriumPanel$1;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class TextCriteriumPanel$InternalTextListener
implements KeyListener {
    final /* synthetic */ TextCriteriumPanel this$0;

    private TextCriteriumPanel$InternalTextListener(TextCriteriumPanel textCriteriumPanel) {
        this.this$0 = textCriteriumPanel;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        TextCriteriumPanel.access$100(this.this$0).update();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        TextCriteriumPanel.access$100(this.this$0).update();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        TextCriteriumPanel.access$100(this.this$0).update();
    }

    /* synthetic */ TextCriteriumPanel$InternalTextListener(TextCriteriumPanel textCriteriumPanel, TextCriteriumPanel$1 textCriteriumPanel$1) {
        this(textCriteriumPanel);
    }
}

