/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CProgressPanel;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CUnlimitedProgressDialog$1;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CUnlimitedProgressDialog$InternalCommandThread;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CUnlimitedProgressDialog$InternalWindowListener;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IProgressDescription;
import com.google.security.zynamics.zylib.types.common.ICancelableCommand;
import com.google.security.zynamics.zylib.types.common.ICommand;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.concurrent.CountDownLatch;
import javax.swing.JDialog;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class CUnlimitedProgressDialog
extends JDialog
implements IProgressDescription {
    private static final long serialVersionUID = 1009536934858788904L;
    private final ICommand m_command;
    private final CUnlimitedProgressDialog$InternalWindowListener m_windowListener;
    private final CProgressPanel m_progressPanel;
    private Exception m_exception;
    private final boolean m_isCancelable;

    private CUnlimitedProgressDialog(Window window, String string, String string2, ICommand iCommand, boolean bl2) {
        super(window, string, Dialog.ModalityType.DOCUMENT_MODAL);
        this.m_windowListener = new CUnlimitedProgressDialog$InternalWindowListener(this, null);
        Preconditions.checkNotNull(iCommand, "Error: Comand can't be null.");
        this.m_isCancelable = bl2;
        this.addWindowListener(this.m_windowListener);
        this.setDefaultCloseOperation(0);
        this.m_command = iCommand;
        this.m_progressPanel = CUnlimitedProgressDialog.createProgressPanel(string2, bl2, this.m_windowListener);
        this.m_progressPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        this.m_progressPanel.start();
        this.setSubDescription("Please wait...");
        this.add(this.m_progressPanel);
        this.setSize(400, this.getPreferredSize().height);
        this.setMinimumSize(new Dimension(400, this.getPreferredSize().height));
        this.setMaximumSize(new Dimension(Math.max(400, this.getPreferredSize().width), this.getPreferredSize().height));
        this.pack();
        this.setSubDescription("Please wait...");
        if (window != null) {
            GuiHelper.centerChildToParent(window, this, true);
            return;
        }
        GuiHelper.centerOnScreen(this);
    }

    public CUnlimitedProgressDialog(Window window, String string, String string2, ICancelableCommand iCancelableCommand) {
        this(window, string, string2, iCancelableCommand, true);
    }

    public CUnlimitedProgressDialog(Window window, String string, String string2, ICommand iCommand) {
        this(window, string, string2, iCommand, false);
    }

    private static CProgressPanel createProgressPanel(String string, boolean bl2, CUnlimitedProgressDialog$InternalWindowListener cUnlimitedProgressDialog$InternalWindowListener) {
        if (!bl2) return new CProgressPanel(string, true, true, true, false);
        return new CProgressPanel(string, true, true, cUnlimitedProgressDialog$InternalWindowListener);
    }

    private void setException(Exception exception) {
        if (this.m_exception != null) return;
        this.m_exception = exception;
    }

    public Exception getException() {
        return this.m_exception;
    }

    @Override
    public synchronized void setDescription(String string) {
        this.m_progressPanel.setText(string);
    }

    @Override
    public synchronized void setSubDescription(String string) {
        this.m_progressPanel.setSubText(string);
    }

    @Override
    public void setVisible(boolean bl2) {
        if (bl2 && !this.isVisible()) {
            this.m_exception = null;
            CountDownLatch countDownLatch = new CountDownLatch(2);
            Thread thread = new Thread(new CUnlimitedProgressDialog$InternalCommandThread(this, countDownLatch));
            thread.start();
            super.setVisible(bl2);
            try {
                countDownLatch.await();
                return;
            }
            catch (InterruptedException var4_4) {
                throw new RuntimeException(var4_4);
            }
        }
        if (bl2) return;
        if (!this.isVisible()) return;
        super.setVisible(false);
    }

    public boolean wasCanceled() {
        if (!this.m_isCancelable) return false;
        if (!((ICancelableCommand)this.m_command).wasCanceled()) return false;
        return true;
    }

    static /* synthetic */ ICommand access$100(CUnlimitedProgressDialog cUnlimitedProgressDialog) {
        return cUnlimitedProgressDialog.m_command;
    }

    static /* synthetic */ void access$200(CUnlimitedProgressDialog cUnlimitedProgressDialog, Exception exception) {
        cUnlimitedProgressDialog.setException(exception);
    }

    static /* synthetic */ void access$301(CUnlimitedProgressDialog cUnlimitedProgressDialog) {
        cUnlimitedProgressDialog.dispose();
    }

    static /* synthetic */ void access$401(CUnlimitedProgressDialog cUnlimitedProgressDialog, boolean bl2) {
        cUnlimitedProgressDialog.setVisible(bl2);
    }

    static /* synthetic */ boolean access$600(CUnlimitedProgressDialog cUnlimitedProgressDialog) {
        return cUnlimitedProgressDialog.m_isCancelable;
    }
}

