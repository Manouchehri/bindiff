package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import java.awt.event.*;
import com.google.common.base.*;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;

public class CProgressPanel extends JPanel
{
    private static final long serialVersionUID = 8176524035621381995L;
    private final JLabel m_label;
    private final JProgressBar m_progressBar;
    private String m_description;
    private final ActionListener m_listener;
    private final ActionListener m_externalCancelButtonListener;
    private final Timer m_timer;
    private int m_seconds;
    private final boolean m_showSeconds;
    
    public CProgressPanel(final String s, final boolean b, final boolean b2) {
        this(s, b, true, b2);
    }
    
    public CProgressPanel(final String description, final boolean b, final boolean showSeconds, final ActionListener actionListener) {
        this.m_label = new JLabel();
        this.m_progressBar = new JProgressBar();
        this.m_listener = new CProgressPanel$InternalActionListener(this, null);
        this.m_timer = new Timer(1000, this.m_listener);
        this.m_seconds = 0;
        this.m_externalCancelButtonListener = (ActionListener)Preconditions.checkNotNull(actionListener, (Object)"Error: Cancel button listener can't be null.");
        this.m_description = description;
        this.createPanel(b, this.m_showSeconds = showSeconds, true, true);
    }
    
    public CProgressPanel(final String description, final boolean b, final boolean showSeconds, final boolean b2) {
        this.m_label = new JLabel();
        this.m_progressBar = new JProgressBar();
        this.m_listener = new CProgressPanel$InternalActionListener(this, null);
        this.m_timer = new Timer(1000, this.m_listener);
        this.m_seconds = 0;
        this.m_description = description;
        this.m_showSeconds = showSeconds;
        this.m_externalCancelButtonListener = null;
        this.createPanel(b, showSeconds, b2, false);
    }
    
    public CProgressPanel(final String description, final boolean b, final boolean showSeconds, final boolean b2, final boolean b3) {
        this.m_label = new JLabel();
        this.m_progressBar = new JProgressBar();
        this.m_listener = new CProgressPanel$InternalActionListener(this, null);
        this.m_timer = new Timer(1000, this.m_listener);
        this.m_seconds = 0;
        this.m_description = description;
        this.m_showSeconds = showSeconds;
        this.m_externalCancelButtonListener = null;
        this.createPanel(b, showSeconds, b3, b2);
    }
    
    private static String convertTextToHtml(final String s) {
        final String value = String.valueOf(s.replaceAll("\n", "<br>"));
        return new StringBuilder(13 + String.valueOf(value).length()).append("<html>").append(value).append("</html>").toString();
    }
    
    private void createPanel(final boolean indeterminate, final boolean b, final boolean b2, final boolean b3) {
        this.setLayout(new BorderLayout());
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder(""));
        if (this.m_description == null) {
            this.m_label.setVisible(false);
        }
        else {
            this.m_label.setText(convertTextToHtml(this.m_description));
        }
        panel.add(this.m_label, "North");
        this.m_progressBar.setIndeterminate(indeterminate);
        this.m_progressBar.setStringPainted(true);
        final JPanel panel2 = new JPanel(new BorderLayout());
        if (b3) {
            panel2.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.GRAY), new EmptyBorder(1, 1, 1, 1)));
        }
        if (b2) {
            final JPanel panel3 = new JPanel(new BorderLayout());
            final JButton button = new JButton(new CProgressPanel$CancelAction(this));
            button.setFocusable(false);
            final JPanel panel4 = new JPanel(new BorderLayout());
            panel4.setBorder(new EmptyBorder(0, 1, 0, 0));
            panel4.setMinimumSize(new Dimension(1, 0));
            panel3.add(panel4, "West");
            panel3.add(button, "East");
            panel2.add(panel3, "East");
        }
        panel2.add(this.m_progressBar, "Center");
        panel.add(panel2, "Center");
        if (indeterminate && b) {
            this.updateSecondsText();
            this.m_timer.setRepeats(true);
        }
        this.add(panel, "North");
    }
    
    private void updateSecondsText() {
        this.m_progressBar.setString(String.format("%d seconds", ++this.m_seconds));
    }
    
    protected void closeRequested() {
    }
    
    public String fitTextToLabel(String concat) {
        final FontMetrics fontMetrics = this.m_label.getFontMetrics(this.m_label.getFont());
        final double n = this.getWidth() - 50;
        boolean b = false;
        do {
            if (n > fontMetrics.stringWidth(concat)) {
                b = true;
            }
            else {
                if (concat.length() <= 4) {
                    break;
                }
                concat = String.valueOf(concat.substring(0, concat.length() - 4)).concat("...");
            }
        } while (!b && concat.length() > 4);
        return concat;
    }
    
    public void next() {
        this.m_progressBar.setValue(this.m_progressBar.getValue() + 1);
    }
    
    public void reset() {
        this.m_progressBar.setValue(0);
    }
    
    public void setMaximum(final int maximum) {
        this.m_progressBar.setMaximum(maximum);
    }
    
    public void setProgressText(final String string) {
        this.m_progressBar.setString(string);
    }
    
    public void setSubText(final String s) {
        final String value = String.valueOf(String.valueOf(this.fitTextToLabel(this.m_description)).concat("\n"));
        final String value2 = String.valueOf(this.fitTextToLabel(s));
        this.m_label.setText(convertTextToHtml((value2.length() != 0) ? value.concat(value2) : new String(value)));
        new CProgressPanel$1(this).invokeLater();
    }
    
    public void setText(final String description) {
        this.m_description = description;
        this.m_label.setText(this.fitTextToLabel(convertTextToHtml(description)));
        new CProgressPanel$2(this).invokeLater();
    }
    
    public void setValue(final int value) {
        this.m_progressBar.setValue(value);
    }
    
    public void start() {
        if (this.m_progressBar.isIndeterminate() && this.m_showSeconds) {
            this.m_seconds = 0;
            this.updateSecondsText();
            this.m_timer.start();
        }
    }
    
    public void stop() {
        if (this.m_progressBar.isIndeterminate() && this.m_showSeconds) {
            this.m_timer.stop();
        }
    }
}
