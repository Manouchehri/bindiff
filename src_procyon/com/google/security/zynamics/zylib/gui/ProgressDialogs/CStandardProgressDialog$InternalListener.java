package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.*;
import com.google.security.zynamics.zylib.gui.*;

class CStandardProgressDialog$InternalListener implements IStandardProgressListener
{
    final /* synthetic */ CStandardProgressDialog this$0;
    
    private CStandardProgressDialog$InternalListener(final CStandardProgressDialog this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void changedDescription(final String subDescription) {
        this.this$0.setSubDescription(subDescription);
    }
    
    @Override
    public void changedMaximum(final int maximum) {
        this.this$0.m_progressPanel.setMaximum(maximum);
    }
    
    @Override
    public void finished() {
        this.this$0.m_finished = true;
        this.this$0.m_progressModel.removeProgressListener(this);
        this.this$0.dispose();
    }
    
    @Override
    public void next() {
        this.this$0.m_progressPanel.next();
    }
    
    @Override
    public void reset() {
        this.this$0.m_progressPanel.reset();
    }
}
