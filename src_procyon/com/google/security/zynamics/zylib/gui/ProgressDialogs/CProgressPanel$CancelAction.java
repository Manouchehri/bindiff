package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.resources.*;
import java.awt.event.*;
import com.google.common.base.*;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;

class CProgressPanel$CancelAction extends AbstractAction
{
    private static final long serialVersionUID = 3809222494243730570L;
    final /* synthetic */ CProgressPanel this$0;
    
    public CProgressPanel$CancelAction(final CProgressPanel this$0) {
        this.this$0 = this$0;
        super("", new ImageIcon(Constants.class.getResource("cancel.png")));
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (this.this$0.m_externalCancelButtonListener != null) {
            this.this$0.m_externalCancelButtonListener.actionPerformed(actionEvent);
        }
        this.this$0.closeRequested();
    }
}
