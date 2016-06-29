/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CProgressPanel;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CStandardHelperThread;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CStandardProgressDialog$1;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CStandardProgressDialog$InternalListener;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CStandardProgressDialog$InternalWindowListener;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IStandardProgressListener;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IStandardProgressModel;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Window;
import java.awt.event.WindowListener;
import javax.swing.JDialog;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class CStandardProgressDialog
extends JDialog {
    private static final long serialVersionUID = 7140381762236285546L;
    private boolean m_finished = false;
    private final IStandardProgressModel m_progressModel;
    private final CStandardProgressDialog$InternalListener m_internalListener;
    private final CProgressPanel m_progressPanel;

    public CStandardProgressDialog(Window window, String string, String string2, IStandardProgressModel iStandardProgressModel) {
        super(window, string, Dialog.ModalityType.DOCUMENT_MODAL);
        this.m_internalListener = new CStandardProgressDialog$InternalListener(this, null);
        this.m_progressModel = iStandardProgressModel;
        this.setDefaultCloseOperation(0);
        this.addWindowListener(new CStandardProgressDialog$InternalWindowListener(this, null));
        iStandardProgressModel.addProgressListener(this.m_internalListener);
        this.m_progressPanel = new CProgressPanel(string2, false, false);
        this.m_progressPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        this.add(this.m_progressPanel);
        this.pack();
        if (window != null) {
            GuiHelper.centerChildToParent(window, this, true);
            return;
        }
        GuiHelper.centerOnScreen(this);
    }

    public static void show(Window window, String string, String string2, CStandardHelperThread cStandardHelperThread) {
        CStandardProgressDialog cStandardProgressDialog = new CStandardProgressDialog(window, string, string2, cStandardHelperThread);
        cStandardHelperThread.start();
        cStandardProgressDialog.setVisible(true);
    }

    public void setDescription(String string) {
        this.m_progressPanel.setText(string);
    }

    public void setSubDescription(String string) {
        this.m_progressPanel.setSubText(string);
        if (this.getParent() != null) {
            GuiHelper.centerChildToParent(this.getParent(), this, true);
            return;
        }
        GuiHelper.centerOnScreen(this);
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

    static /* synthetic */ CProgressPanel access$200(CStandardProgressDialog cStandardProgressDialog) {
        return cStandardProgressDialog.m_progressPanel;
    }

    static /* synthetic */ boolean access$302(CStandardProgressDialog cStandardProgressDialog, boolean bl2) {
        cStandardProgressDialog.m_finished = bl2;
        return cStandardProgressDialog.m_finished;
    }

    static /* synthetic */ IStandardProgressModel access$400(CStandardProgressDialog cStandardProgressDialog) {
        return cStandardProgressDialog.m_progressModel;
    }
}

