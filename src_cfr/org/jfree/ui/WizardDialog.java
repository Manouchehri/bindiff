/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import org.jfree.ui.L1R3ButtonPanel;
import org.jfree.ui.WizardPanel;

public class WizardDialog
extends JDialog
implements ActionListener {
    private Object result = null;
    private int step;
    private WizardPanel currentPanel;
    private List panels;
    private JButton previousButton;
    private JButton nextButton;
    private JButton finishButton;
    private JButton helpButton;

    public WizardDialog(JDialog jDialog, boolean bl2, String string, WizardPanel wizardPanel) {
        super(jDialog, new StringBuffer().append(string).append(" : step 1").toString(), bl2);
        this.currentPanel = wizardPanel;
        this.step = 0;
        this.panels = new ArrayList();
        this.panels.add(wizardPanel);
        this.setContentPane(this.createContent());
    }

    public WizardDialog(JFrame jFrame, boolean bl2, String string, WizardPanel wizardPanel) {
        super(jFrame, new StringBuffer().append(string).append(" : step 1").toString(), bl2);
        this.currentPanel = wizardPanel;
        this.step = 0;
        this.panels = new ArrayList();
        this.panels.add(wizardPanel);
        this.setContentPane(this.createContent());
    }

    public Object getResult() {
        return this.result;
    }

    public int getStepCount() {
        return 0;
    }

    public boolean canDoPreviousPanel() {
        if (this.step <= 0) return false;
        return true;
    }

    public boolean canDoNextPanel() {
        return this.currentPanel.hasNextPanel();
    }

    public boolean canFinish() {
        return this.currentPanel.canFinish();
    }

    public WizardPanel getWizardPanel(int n2) {
        if (n2 >= this.panels.size()) return null;
        return (WizardPanel)this.panels.get(n2);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("nextButton")) {
            this.next();
            return;
        }
        if (string.equals("previousButton")) {
            this.previous();
            return;
        }
        if (!string.equals("finishButton")) return;
        this.finish();
    }

    public void previous() {
        if (this.step <= 0) return;
        WizardPanel wizardPanel = this.getWizardPanel(this.step - 1);
        wizardPanel.returnFromLaterStep();
        Container container = this.getContentPane();
        container.remove(this.currentPanel);
        container.add(wizardPanel);
        --this.step;
        this.currentPanel = wizardPanel;
        this.setTitle(new StringBuffer().append("Step ").append(this.step + 1).toString());
        this.enableButtons();
        this.pack();
    }

    public void next() {
        WizardPanel wizardPanel = this.getWizardPanel(this.step + 1);
        if (wizardPanel != null) {
            if (!this.currentPanel.canRedisplayNextPanel()) {
                wizardPanel = this.currentPanel.getNextPanel();
            }
        } else {
            wizardPanel = this.currentPanel.getNextPanel();
        }
        ++this.step;
        if (this.step < this.panels.size()) {
            this.panels.set(this.step, wizardPanel);
        } else {
            this.panels.add(wizardPanel);
        }
        Container container = this.getContentPane();
        container.remove(this.currentPanel);
        container.add(wizardPanel);
        this.currentPanel = wizardPanel;
        this.setTitle(new StringBuffer().append("Step ").append(this.step + 1).toString());
        this.enableButtons();
        this.pack();
    }

    public void finish() {
        this.result = this.currentPanel.getResult();
        this.setVisible(false);
    }

    private void enableButtons() {
        this.previousButton.setEnabled(this.step > 0);
        this.nextButton.setEnabled(this.canDoNextPanel());
        this.finishButton.setEnabled(this.canFinish());
        this.helpButton.setEnabled(false);
    }

    public boolean isCancelled() {
        return false;
    }

    public JPanel createContent() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        jPanel.add((JPanel)this.panels.get(0));
        L1R3ButtonPanel l1R3ButtonPanel = new L1R3ButtonPanel("Help", "Previous", "Next", "Finish");
        this.helpButton = l1R3ButtonPanel.getLeftButton();
        this.helpButton.setEnabled(false);
        this.previousButton = l1R3ButtonPanel.getRightButton1();
        this.previousButton.setActionCommand("previousButton");
        this.previousButton.addActionListener(this);
        this.previousButton.setEnabled(false);
        this.nextButton = l1R3ButtonPanel.getRightButton2();
        this.nextButton.setActionCommand("nextButton");
        this.nextButton.addActionListener(this);
        this.nextButton.setEnabled(true);
        this.finishButton = l1R3ButtonPanel.getRightButton3();
        this.finishButton.setActionCommand("finishButton");
        this.finishButton.addActionListener(this);
        this.finishButton.setEnabled(false);
        l1R3ButtonPanel.setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));
        jPanel.add((Component)l1R3ButtonPanel, "South");
        return jPanel;
    }
}

