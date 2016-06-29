package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.*;
import com.google.security.zynamics.zylib.gui.*;

public class CStandardProgressDialog extends JDialog
{
    private static final long serialVersionUID = 7140381762236285546L;
    private boolean m_finished;
    private final IStandardProgressModel m_progressModel;
    private final CStandardProgressDialog$InternalListener m_internalListener;
    private final CProgressPanel m_progressPanel;
    
    public CStandardProgressDialog(final Window window, final String s, final String s2, final IStandardProgressModel progressModel) {
        super(window, s, ModalityType.DOCUMENT_MODAL);
        this.m_finished = false;
        this.m_internalListener = new CStandardProgressDialog$InternalListener(this, null);
        this.m_progressModel = progressModel;
        this.setDefaultCloseOperation(0);
        this.addWindowListener(new CStandardProgressDialog$InternalWindowListener(this, null));
        progressModel.addProgressListener(this.m_internalListener);
        (this.m_progressPanel = new CProgressPanel(s2, false, false)).setBorder(new EmptyBorder(15, 15, 15, 15));
        this.add(this.m_progressPanel);
        this.pack();
        if (window != null) {
            GuiHelper.centerChildToParent(window, this, true);
        }
        else {
            GuiHelper.centerOnScreen(this);
        }
    }
    
    public static void show(final Window window, final String s, final String s2, final CStandardHelperThread cStandardHelperThread) {
        final CStandardProgressDialog cStandardProgressDialog = new CStandardProgressDialog(window, s, s2, cStandardHelperThread);
        cStandardHelperThread.start();
        cStandardProgressDialog.setVisible(true);
    }
    
    public void setDescription(final String text) {
        this.m_progressPanel.setText(text);
    }
    
    public void setSubDescription(final String subText) {
        this.m_progressPanel.setSubText(subText);
        if (this.getParent() != null) {
            GuiHelper.centerChildToParent(this.getParent(), this, true);
        }
        else {
            GuiHelper.centerOnScreen(this);
        }
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
