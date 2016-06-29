package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees;

import javax.swing.*;
import com.google.security.zynamics.zylib.gui.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.*;

class IndegreeCriteriumPanel$InternalTextListener implements KeyListener
{
    final /* synthetic */ IndegreeCriteriumPanel this$0;
    
    private IndegreeCriteriumPanel$InternalTextListener(final IndegreeCriteriumPanel this$0) {
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
