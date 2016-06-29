package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.*;
import com.google.security.zynamics.zylib.gui.*;

public class CEndlessProgressDialog extends JDialog
{
    private boolean m_finished;
    private final IEndlessProgressModel m_progressModel;
    private final CEndlessProgressDialog$InternalListener m_internalListener;
    private final CProgressPanel m_progressPanel;
    
    public CEndlessProgressDialog(final Window window, final String s, final String s2, final IEndlessProgressModel progressModel) {
        super(window, s, ModalityType.DOCUMENT_MODAL);
        this.m_finished = false;
        this.m_internalListener = new CEndlessProgressDialog$InternalListener(this, null);
        this.m_progressModel = progressModel;
        this.setDefaultCloseOperation(0);
        this.addWindowListener(new CEndlessProgressDialog$InternalWindowListener(this, null));
        progressModel.addProgressListener(this.m_internalListener);
        (this.m_progressPanel = new CProgressPanel(s2, true, false)).start();
        this.m_progressPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        this.setSubDescription("Please wait...");
        this.getContentPane().add(this.m_progressPanel);
        this.pack();
        this.setSubDescription("Please wait...");
        if (window != null) {
            GuiHelper.centerChildToParent(window, this, true);
        }
        else {
            GuiHelper.centerOnScreen(this);
        }
    }
    
    public static CEndlessProgressDialog show(final Window window, final String s, final String s2, final CEndlessHelperThread cEndlessHelperThread) {
        final CEndlessProgressDialog cEndlessProgressDialog = new CEndlessProgressDialog(window, s, s2, cEndlessHelperThread);
        cEndlessHelperThread.start();
        cEndlessProgressDialog.setVisible(true);
        return cEndlessProgressDialog;
    }
    
    public void setDescription(final String text) {
        this.m_progressPanel.setText(text);
    }
    
    public void setSubDescription(final String subText) {
        this.m_progressPanel.setSubText(subText);
    }
    
    @Override
    public void setVisible(final boolean visible) {
        if (!this.m_finished) {
            try {
                super.setVisible(visible);
            }
            catch (Exception ex) {}
        }
    }
}
