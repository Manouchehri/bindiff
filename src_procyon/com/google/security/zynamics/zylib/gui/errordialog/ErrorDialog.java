package com.google.security.zynamics.zylib.gui.errordialog;

import com.google.security.zynamics.zylib.gui.*;
import java.awt.*;
import javax.swing.border.*;
import com.google.security.zynamics.zylib.general.*;
import javax.swing.*;
import java.net.*;
import java.io.*;

public abstract class ErrorDialog extends JDialog
{
    private static final long serialVersionUID = -2246347447228688878L;
    private final String m_description;
    private final Throwable m_exception;
    private final String m_message;
    
    public ErrorDialog(final Window window, final String s, final String s2) {
        this(window, s, s2, null);
    }
    
    public ErrorDialog(final Window window, final String message, final String description, final Throwable exception) {
        super(window, ModalityType.APPLICATION_MODAL);
        this.m_message = message;
        this.m_description = description;
        this.m_exception = exception;
        new CDialogEscaper(this);
        this.setLayout(new BorderLayout());
        this.createGui();
        this.setMinimumSize(new Dimension(600, 400));
        this.setSize(600, 400);
    }
    
    private void createGui() {
        final JPanel panel = new JPanel(new BorderLayout());
        final JPanel panel2 = new JPanel(new BorderLayout());
        final JTextField textField = new JTextField();
        textField.setEditable(false);
        textField.setText(this.m_message);
        textField.setBackground(Color.WHITE);
        panel2.add(textField);
        panel2.setBorder(new TitledBorder("Error Message"));
        panel.add(panel2, "North");
        final JTabbedPane tabbedPane = new JTabbedPane();
        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setText(this.m_description);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        tabbedPane.addTab("Description", textArea);
        if (this.m_exception != null) {
            final JTextArea textArea2 = new JTextArea();
            textArea2.setEditable(false);
            textArea2.setText(StackTrace.toString(this.m_exception.getStackTrace()));
            tabbedPane.addTab("Stack Trace", new JScrollPane(textArea2));
        }
        this.add(panel, "North");
        this.add(tabbedPane);
        final JPanel panel3 = new JPanel(new BorderLayout());
        final JPanel panel4 = new JPanel();
        final JButton button = new JButton(new ErrorDialog$SendAction(this, null));
        button.setMinimumSize(new Dimension(180, button.getHeight()));
        final JButton button2 = new JButton(new ErrorDialog$ReportAction(this, null));
        panel4.add(button);
        panel4.add(button2);
        panel3.add(panel4, "West");
        final JPanel panel5 = new JPanel();
        final JButton defaultButton = new JButton(new ErrorDialog$CloseButtonListener(this, null));
        this.getRootPane().setDefaultButton(defaultButton);
        panel5.add(defaultButton);
        panel3.add(panel5, "East");
        this.add(panel3, "South");
    }
    
    protected ImageIcon createImageIcon(final String s, final String s2) {
        final URL resource = this.getClass().getResource(s);
        if (resource != null) {
            return new ImageIcon(resource, s2);
        }
        final PrintStream err = System.err;
        final String s3 = "Couldn't find file: ";
        final String value = String.valueOf(s);
        err.println((value.length() != 0) ? s3.concat(value) : new String(s3));
        return null;
    }
    
    protected abstract void report();
    
    protected abstract void send(final String p0, final String p1, final Throwable p2);
}
