package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.text;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

class TextCriteriumPanel$InternalTextListener implements KeyListener
{
    final /* synthetic */ TextCriteriumPanel this$0;
    
    private TextCriteriumPanel$InternalTextListener(final TextCriteriumPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void keyPressed(final KeyEvent keyEvent) {
        this.this$0.criterium.update();
    }
    
    @Override
    public void keyReleased(final KeyEvent keyEvent) {
        this.this$0.criterium.update();
    }
    
    @Override
    public void keyTyped(final KeyEvent keyEvent) {
        this.this$0.criterium.update();
    }
}
