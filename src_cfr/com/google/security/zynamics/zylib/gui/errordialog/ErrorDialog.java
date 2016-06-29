/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.errordialog;

import com.google.security.zynamics.zylib.general.StackTrace;
import com.google.security.zynamics.zylib.gui.CDialogEscaper;
import com.google.security.zynamics.zylib.gui.errordialog.ErrorDialog$1;
import com.google.security.zynamics.zylib.gui.errordialog.ErrorDialog$CloseButtonListener;
import com.google.security.zynamics.zylib.gui.errordialog.ErrorDialog$ReportAction;
import com.google.security.zynamics.zylib.gui.errordialog.ErrorDialog$SendAction;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Window;
import java.io.PrintStream;
import java.net.URL;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public abstract class ErrorDialog
extends JDialog {
    private static final long serialVersionUID = -2246347447228688878L;
    private final String m_description;
    private final Throwable m_exception;
    private final String m_message;

    public ErrorDialog(Window window, String string, String string2) {
        this(window, string, string2, null);
    }

    public ErrorDialog(Window window, String string, String string2, Throwable throwable) {
        super(window, Dialog.ModalityType.APPLICATION_MODAL);
        this.m_message = string;
        this.m_description = string2;
        this.m_exception = throwable;
        new CDialogEscaper(this);
        this.setLayout(new BorderLayout());
        this.createGui();
        this.setMinimumSize(new Dimension(600, 400));
        this.setSize(600, 400);
    }

    private void createGui() {
        Container container;
        JPanel jPanel = new JPanel(new BorderLayout());
        JPanel jPanel2 = new JPanel(new BorderLayout());
        JTextField jTextField = new JTextField();
        jTextField.setEditable(false);
        jTextField.setText(this.m_message);
        jTextField.setBackground(Color.WHITE);
        jPanel2.add(jTextField);
        jPanel2.setBorder(new TitledBorder("Error Message"));
        jPanel.add((Component)jPanel2, "North");
        JTabbedPane jTabbedPane = new JTabbedPane();
        JTextArea jTextArea = new JTextArea();
        jTextArea.setEditable(false);
        jTextArea.setText(this.m_description);
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);
        jTabbedPane.addTab("Description", jTextArea);
        if (this.m_exception != null) {
            container = new JTextArea();
            container.setEditable(false);
            container.setText(StackTrace.toString(this.m_exception.getStackTrace()));
            jTabbedPane.addTab("Stack Trace", new JScrollPane(container));
        }
        this.add((Component)jPanel, "North");
        this.add(jTabbedPane);
        container = new JPanel(new BorderLayout());
        JPanel jPanel3 = new JPanel();
        JButton jButton = new JButton(new ErrorDialog$SendAction(this, null));
        jButton.setMinimumSize(new Dimension(180, jButton.getHeight()));
        JButton jButton2 = new JButton(new ErrorDialog$ReportAction(this, null));
        jPanel3.add(jButton);
        jPanel3.add(jButton2);
        container.add((Component)jPanel3, "West");
        JPanel jPanel4 = new JPanel();
        JButton jButton3 = new JButton(new ErrorDialog$CloseButtonListener(this, null));
        this.getRootPane().setDefaultButton(jButton3);
        jPanel4.add(jButton3);
        container.add((Component)jPanel4, "East");
        this.add((Component)container, "South");
    }

    protected ImageIcon createImageIcon(String string, String string2) {
        URL uRL = this.getClass().getResource(string);
        if (uRL != null) {
            return new ImageIcon(uRL, string2);
        }
        String string3 = String.valueOf(string);
        System.err.println(string3.length() != 0 ? "Couldn't find file: ".concat(string3) : new String("Couldn't find file: "));
        return null;
    }

    protected abstract void report();

    protected abstract void send(String var1, String var2, Throwable var3);

    static /* synthetic */ String access$300(ErrorDialog errorDialog) {
        return errorDialog.m_description;
    }

    static /* synthetic */ String access$400(ErrorDialog errorDialog) {
        return errorDialog.m_message;
    }

    static /* synthetic */ Throwable access$500(ErrorDialog errorDialog) {
        return errorDialog.m_exception;
    }
}

