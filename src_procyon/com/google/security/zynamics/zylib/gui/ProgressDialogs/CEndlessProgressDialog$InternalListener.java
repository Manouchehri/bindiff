package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.*;
import com.google.security.zynamics.zylib.gui.*;

class CEndlessProgressDialog$InternalListener implements IEndlessProgressListener
{
    final /* synthetic */ CEndlessProgressDialog this$0;
    
    private CEndlessProgressDialog$InternalListener(final CEndlessProgressDialog this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void changedDescription(final String subDescription) {
        this.this$0.setSubDescription(subDescription);
    }
    
    @Override
    public void changedGeneralDescription(final String description) {
        this.this$0.setDescription(description);
    }
    
    @Override
    public void finished() {
        this.this$0.m_finished = true;
        this.this$0.m_progressModel.removeProgressListener(this);
        this.this$0.dispose();
    }
}
