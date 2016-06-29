package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree;

import javax.swing.*;
import com.google.security.zynamics.zylib.gui.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.*;

class OutdegreeCriteriumPanel$InternalTextListener implements KeyListener
{
    final /* synthetic */ OutdegreeCriteriumPanel this$0;
    
    private OutdegreeCriteriumPanel$InternalTextListener(final OutdegreeCriteriumPanel this$0) {
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
