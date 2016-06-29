/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessHelperThread;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessProgressDialog$1;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessProgressDialog$InternalListener;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessProgressDialog$InternalWindowListener;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CProgressPanel;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IEndlessProgressListener;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IEndlessProgressModel;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Window;
import java.awt.event.WindowListener;
import javax.swing.JDialog;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class CEndlessProgressDialog
extends JDialog {
    private boolean m_finished = false;
    private final IEndlessProgressModel m_progressModel;
    private final CEndlessProgressDialog$InternalListener m_internalListener;
    private final CProgressPanel m_progressPanel;

    public CEndlessProgressDialog(Window window, String string, String string2, IEndlessProgressModel iEndlessProgressModel) {
        super(window, string, Dialog.ModalityType.DOCUMENT_MODAL);
        this.m_internalListener = new CEndlessProgressDialog$InternalListener(this, null);
        this.m_progressModel = iEndlessProgressModel;
        this.setDefaultCloseOperation(0);
        this.addWindowListener(new CEndlessProgressDialog$InternalWindowListener(this, null));
        iEndlessProgressModel.addProgressListener(this.m_internalListener);
        this.m_progressPanel = new CProgressPanel(string2, true, false);
        this.m_progressPanel.start();
        this.m_progressPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        this.setSubDescription("Please wait...");
        this.getContentPane().add(this.m_progressPanel);
        this.pack();
        this.setSubDescription("Please wait...");
        if (window != null) {
            GuiHelper.centerChildToParent(window, this, true);
            return;
        }
        GuiHelper.centerOnScreen(this);
    }

    public static CEndlessProgressDialog show(Window window, String string, String string2, CEndlessHelperThread cEndlessHelperThread) {
        CEndlessProgressDialog cEndlessProgressDialog = new CEndlessProgressDialog(window, string, string2, cEndlessHelperThread);
        cEndlessHelperThread.start();
        cEndlessProgressDialog.setVisible(true);
        return cEndlessProgressDialog;
    }

    public void setDescription(String string) {
        this.m_progressPanel.setText(string);
    }

    public void setSubDescription(String string) {
        this.m_progressPanel.setSubText(string);
    }

    @Override
    public void setVisible(boolean bl2) {
        if (this.m_finished) return;
        try {
            super.setVisible(bl2);
            return;
        }
        catch (Exception var2_2) {
            // empty catch block
        }
    }

    static /* synthetic */ boolean access$202(CEndlessProgressDialog cEndlessProgressDialog, boolean bl2) {
        cEndlessProgressDialog.m_finished = bl2;
        return cEndlessProgressDialog.m_finished;
    }

    static /* synthetic */ IEndlessProgressModel access$300(CEndlessProgressDialog cEndlessProgressDialog) {
        return cEndlessProgressDialog.m_progressModel;
    }

    static /* synthetic */ CProgressPanel access$400(CEndlessProgressDialog cEndlessProgressDialog) {
        return cEndlessProgressDialog.m_progressPanel;
    }
}

