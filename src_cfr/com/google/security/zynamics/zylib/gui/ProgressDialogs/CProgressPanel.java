/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CProgressPanel$1;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CProgressPanel$2;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CProgressPanel$CancelAction;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CProgressPanel$InternalActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class CProgressPanel
extends JPanel {
    private static final long serialVersionUID = 8176524035621381995L;
    private final JLabel m_label = new JLabel();
    private final JProgressBar m_progressBar = new JProgressBar();
    private String m_description;
    private final ActionListener m_listener;
    private final ActionListener m_externalCancelButtonListener;
    private final Timer m_timer;
    private int m_seconds;
    private final boolean m_showSeconds;

    public CProgressPanel(String string, boolean bl2, boolean bl3) {
        this(string, bl2, true, bl3);
    }

    public CProgressPanel(String string, boolean bl2, boolean bl3, ActionListener actionListener) {
        this.m_listener = new CProgressPanel$InternalActionListener(this, null);
        this.m_timer = new Timer(1000, this.m_listener);
        this.m_seconds = 0;
        this.m_externalCancelButtonListener = (ActionListener)Preconditions.checkNotNull(actionListener, "Error: Cancel button listener can't be null.");
        this.m_description = string;
        this.m_showSeconds = bl3;
        this.createPanel(bl2, bl3, true, true);
    }

    public CProgressPanel(String string, boolean bl2, boolean bl3, boolean bl4) {
        this.m_listener = new CProgressPanel$InternalActionListener(this, null);
        this.m_timer = new Timer(1000, this.m_listener);
        this.m_seconds = 0;
        this.m_description = string;
        this.m_showSeconds = bl3;
        this.m_externalCancelButtonListener = null;
        this.createPanel(bl2, bl3, bl4, false);
    }

    public CProgressPanel(String string, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        this.m_listener = new CProgressPanel$InternalActionListener(this, null);
        this.m_timer = new Timer(1000, this.m_listener);
        this.m_seconds = 0;
        this.m_description = string;
        this.m_showSeconds = bl3;
        this.m_externalCancelButtonListener = null;
        this.createPanel(bl2, bl3, bl5, bl4);
    }

    private static String convertTextToHtml(String string) {
        String string2 = String.valueOf(string.replaceAll("\n", "<br>"));
        return new StringBuilder(13 + String.valueOf(string2).length()).append("<html>").append(string2).append("</html>").toString();
    }

    private void createPanel(boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        this.setLayout(new BorderLayout());
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new TitledBorder(""));
        if (this.m_description == null) {
            this.m_label.setVisible(false);
        } else {
            this.m_label.setText(CProgressPanel.convertTextToHtml(this.m_description));
        }
        jPanel.add((Component)this.m_label, "North");
        this.m_progressBar.setIndeterminate(bl2);
        this.m_progressBar.setStringPainted(true);
        JPanel jPanel2 = new JPanel(new BorderLayout());
        if (bl5) {
            jPanel2.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.GRAY), new EmptyBorder(1, 1, 1, 1)));
        }
        if (bl4) {
            JPanel jPanel3 = new JPanel(new BorderLayout());
            JButton jButton = new JButton(new CProgressPanel$CancelAction(this));
            jButton.setFocusable(false);
            JPanel jPanel4 = new JPanel(new BorderLayout());
            jPanel4.setBorder(new EmptyBorder(0, 1, 0, 0));
            jPanel4.setMinimumSize(new Dimension(1, 0));
            jPanel3.add((Component)jPanel4, "West");
            jPanel3.add((Component)jButton, "East");
            jPanel2.add((Component)jPanel3, "East");
        }
        jPanel2.add((Component)this.m_progressBar, "Center");
        jPanel.add((Component)jPanel2, "Center");
        if (bl2 && bl3) {
            this.updateSecondsText();
            this.m_timer.setRepeats(true);
        }
        this.add((Component)jPanel, "North");
    }

    private void updateSecondsText() {
        Object[] arrobject = new Object[]{++this.m_seconds};
        this.m_progressBar.setString(String.format("%d seconds", arrobject));
    }

    protected void closeRequested() {
    }

    public String fitTextToLabel(String string) {
        FontMetrics fontMetrics = this.m_label.getFontMetrics(this.m_label.getFont());
        double d2 = this.getWidth() - 50;
        boolean bl2 = false;
        do {
            double d3;
            if (d2 > (d3 = (double)fontMetrics.stringWidth(string))) {
                return string;
            }
            if (string.length() <= 4) return string;
            string = String.valueOf(string.substring(0, string.length() - 4)).concat("...");
            if (bl2) return string;
        } while (string.length() > 4);
        return string;
    }

    public void next() {
        this.m_progressBar.setValue(this.m_progressBar.getValue() + 1);
    }

    public void reset() {
        this.m_progressBar.setValue(0);
    }

    public void setMaximum(int n2) {
        this.m_progressBar.setMaximum(n2);
    }

    public void setProgressText(String string) {
        this.m_progressBar.setString(string);
    }

    public void setSubText(String string) {
        String string2 = String.valueOf(this.fitTextToLabel(this.m_description)).concat("\n");
        String string3 = String.valueOf(string2);
        String string4 = String.valueOf(this.fitTextToLabel(string));
        string2 = string4.length() != 0 ? string3.concat(string4) : new String(string3);
        this.m_label.setText(CProgressPanel.convertTextToHtml(string2));
        new CProgressPanel$1(this).invokeLater();
    }

    public void setText(String string) {
        this.m_description = string;
        String string2 = CProgressPanel.convertTextToHtml(string);
        string2 = this.fitTextToLabel(string2);
        this.m_label.setText(string2);
        new CProgressPanel$2(this).invokeLater();
    }

    public void setValue(int n2) {
        this.m_progressBar.setValue(n2);
    }

    public void start() {
        if (!this.m_progressBar.isIndeterminate()) return;
        if (!this.m_showSeconds) return;
        this.m_seconds = 0;
        this.updateSecondsText();
        this.m_timer.start();
    }

    public void stop() {
        if (!this.m_progressBar.isIndeterminate()) return;
        if (!this.m_showSeconds) return;
        this.m_timer.stop();
    }

    static /* synthetic */ JLabel access$100(CProgressPanel cProgressPanel) {
        return cProgressPanel.m_label;
    }

    static /* synthetic */ ActionListener access$200(CProgressPanel cProgressPanel) {
        return cProgressPanel.m_externalCancelButtonListener;
    }

    static /* synthetic */ void access$300(CProgressPanel cProgressPanel) {
        cProgressPanel.updateSecondsText();
    }
}

