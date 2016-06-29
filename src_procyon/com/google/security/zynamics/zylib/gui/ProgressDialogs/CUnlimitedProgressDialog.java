package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import javax.swing.*;
import com.google.common.base.*;
import javax.swing.border.*;
import java.awt.*;
import com.google.security.zynamics.zylib.gui.*;
import com.google.security.zynamics.zylib.types.common.*;
import java.awt.event.*;
import java.util.concurrent.*;

public class CUnlimitedProgressDialog extends JDialog implements IProgressDescription
{
    private static final long serialVersionUID = 1009536934858788904L;
    private final ICommand m_command;
    private final CUnlimitedProgressDialog$InternalWindowListener m_windowListener;
    private final CProgressPanel m_progressPanel;
    private Exception m_exception;
    private final boolean m_isCancelable;
    
    private CUnlimitedProgressDialog(final Window window, final String s, final String s2, final ICommand command, final boolean isCancelable) {
        super(window, s, ModalityType.DOCUMENT_MODAL);
        this.m_windowListener = new CUnlimitedProgressDialog$InternalWindowListener(this, null);
        Preconditions.checkNotNull(command, (Object)"Error: Comand can't be null.");
        this.m_isCancelable = isCancelable;
        this.addWindowListener(this.m_windowListener);
        this.setDefaultCloseOperation(0);
        this.m_command = command;
        (this.m_progressPanel = createProgressPanel(s2, isCancelable, this.m_windowListener)).setBorder(new EmptyBorder(15, 15, 15, 15));
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
        }
        else {
            GuiHelper.centerOnScreen(this);
        }
    }
    
    public CUnlimitedProgressDialog(final Window window, final String s, final String s2, final ICancelableCommand cancelableCommand) {
        this(window, s, s2, cancelableCommand, true);
    }
    
    public CUnlimitedProgressDialog(final Window window, final String s, final String s2, final ICommand command) {
        this(window, s, s2, command, false);
    }
    
    private static CProgressPanel createProgressPanel(final String s, final boolean b, final CUnlimitedProgressDialog$InternalWindowListener cUnlimitedProgressDialog$InternalWindowListener) {
        if (b) {
            return new CProgressPanel(s, true, true, cUnlimitedProgressDialog$InternalWindowListener);
        }
        return new CProgressPanel(s, true, true, true, false);
    }
    
    private void setException(final Exception exception) {
        if (this.m_exception == null) {
            this.m_exception = exception;
        }
    }
    
    public Exception getException() {
        return this.m_exception;
    }
    
    @Override
    public synchronized void setDescription(final String text) {
        this.m_progressPanel.setText(text);
    }
    
    @Override
    public synchronized void setSubDescription(final String subText) {
        this.m_progressPanel.setSubText(subText);
    }
    
    @Override
    public void setVisible(final boolean visible) {
        if (visible && !this.isVisible()) {
            this.m_exception = null;
            final CountDownLatch countDownLatch = new CountDownLatch(2);
            new Thread(new CUnlimitedProgressDialog$InternalCommandThread(this, countDownLatch)).start();
            super.setVisible(visible);
            try {
                countDownLatch.await();
            }
            catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if (!visible && this.isVisible()) {
            super.setVisible(false);
        }
    }
    
    public boolean wasCanceled() {
        return this.m_isCancelable && ((ICancelableCommand)this.m_command).wasCanceled();
    }
}
