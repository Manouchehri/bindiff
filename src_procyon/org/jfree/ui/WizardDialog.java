package org.jfree.ui;

import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class WizardDialog extends JDialog implements ActionListener
{
    private Object result;
    private int step;
    private WizardPanel currentPanel;
    private List panels;
    private JButton previousButton;
    private JButton nextButton;
    private JButton finishButton;
    private JButton helpButton;
    
    public WizardDialog(final JDialog dialog, final boolean b, final String s, final WizardPanel currentPanel) {
        super(dialog, s + " : step 1", b);
        this.result = null;
        this.currentPanel = currentPanel;
        this.step = 0;
        (this.panels = new ArrayList()).add(currentPanel);
        this.setContentPane(this.createContent());
    }
    
    public WizardDialog(final JFrame frame, final boolean b, final String s, final WizardPanel currentPanel) {
        super(frame, s + " : step 1", b);
        this.result = null;
        this.currentPanel = currentPanel;
        this.step = 0;
        (this.panels = new ArrayList()).add(currentPanel);
        this.setContentPane(this.createContent());
    }
    
    public Object getResult() {
        return this.result;
    }
    
    public int getStepCount() {
        return 0;
    }
    
    public boolean canDoPreviousPanel() {
        return this.step > 0;
    }
    
    public boolean canDoNextPanel() {
        return this.currentPanel.hasNextPanel();
    }
    
    public boolean canFinish() {
        return this.currentPanel.canFinish();
    }
    
    public WizardPanel getWizardPanel(final int n) {
        if (n < this.panels.size()) {
            return this.panels.get(n);
        }
        return null;
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        final String actionCommand = actionEvent.getActionCommand();
        if (actionCommand.equals("nextButton")) {
            this.next();
        }
        else if (actionCommand.equals("previousButton")) {
            this.previous();
        }
        else if (actionCommand.equals("finishButton")) {
            this.finish();
        }
    }
    
    public void previous() {
        if (this.step > 0) {
            final WizardPanel wizardPanel = this.getWizardPanel(this.step - 1);
            wizardPanel.returnFromLaterStep();
            final Container contentPane = this.getContentPane();
            contentPane.remove(this.currentPanel);
            contentPane.add(wizardPanel);
            --this.step;
            this.currentPanel = wizardPanel;
            this.setTitle("Step " + (this.step + 1));
            this.enableButtons();
            this.pack();
        }
    }
    
    public void next() {
        WizardPanel currentPanel = this.getWizardPanel(this.step + 1);
        if (currentPanel != null) {
            if (!this.currentPanel.canRedisplayNextPanel()) {
                currentPanel = this.currentPanel.getNextPanel();
            }
        }
        else {
            currentPanel = this.currentPanel.getNextPanel();
        }
        ++this.step;
        if (this.step < this.panels.size()) {
            this.panels.set(this.step, currentPanel);
        }
        else {
            this.panels.add(currentPanel);
        }
        final Container contentPane = this.getContentPane();
        contentPane.remove(this.currentPanel);
        contentPane.add(currentPanel);
        this.currentPanel = currentPanel;
        this.setTitle("Step " + (this.step + 1));
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
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        panel.add(this.panels.get(0));
        final L1R3ButtonPanel l1R3ButtonPanel = new L1R3ButtonPanel("Help", "Previous", "Next", "Finish");
        (this.helpButton = l1R3ButtonPanel.getLeftButton()).setEnabled(false);
        (this.previousButton = l1R3ButtonPanel.getRightButton1()).setActionCommand("previousButton");
        this.previousButton.addActionListener(this);
        this.previousButton.setEnabled(false);
        (this.nextButton = l1R3ButtonPanel.getRightButton2()).setActionCommand("nextButton");
        this.nextButton.addActionListener(this);
        this.nextButton.setEnabled(true);
        (this.finishButton = l1R3ButtonPanel.getRightButton3()).setActionCommand("finishButton");
        this.finishButton.addActionListener(this);
        this.finishButton.setEnabled(false);
        l1R3ButtonPanel.setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));
        panel.add(l1R3ButtonPanel, "South");
        return panel;
    }
}
