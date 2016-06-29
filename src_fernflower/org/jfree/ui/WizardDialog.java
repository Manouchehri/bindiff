package org.jfree.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.ui.L1R3ButtonPanel;
import org.jfree.ui.WizardPanel;

public class WizardDialog extends JDialog implements ActionListener {
   private Object result = null;
   private int step;
   private WizardPanel currentPanel;
   private List panels;
   private JButton previousButton;
   private JButton nextButton;
   private JButton finishButton;
   private JButton helpButton;

   public WizardDialog(JDialog var1, boolean var2, String var3, WizardPanel var4) {
      super(var1, var3 + " : step 1", var2);
      this.currentPanel = var4;
      this.step = 0;
      this.panels = new ArrayList();
      this.panels.add(var4);
      this.setContentPane(this.createContent());
   }

   public WizardDialog(JFrame var1, boolean var2, String var3, WizardPanel var4) {
      super(var1, var3 + " : step 1", var2);
      this.currentPanel = var4;
      this.step = 0;
      this.panels = new ArrayList();
      this.panels.add(var4);
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

   public WizardPanel getWizardPanel(int var1) {
      return var1 < this.panels.size()?(WizardPanel)this.panels.get(var1):null;
   }

   public void actionPerformed(ActionEvent var1) {
      String var2 = var1.getActionCommand();
      if(var2.equals("nextButton")) {
         this.next();
      } else if(var2.equals("previousButton")) {
         this.previous();
      } else if(var2.equals("finishButton")) {
         this.finish();
      }

   }

   public void previous() {
      if(this.step > 0) {
         WizardPanel var1 = this.getWizardPanel(this.step - 1);
         var1.returnFromLaterStep();
         Container var2 = this.getContentPane();
         var2.remove(this.currentPanel);
         var2.add(var1);
         --this.step;
         this.currentPanel = var1;
         this.setTitle("Step " + (this.step + 1));
         this.enableButtons();
         this.pack();
      }

   }

   public void next() {
      WizardPanel var1 = this.getWizardPanel(this.step + 1);
      if(var1 != null) {
         if(!this.currentPanel.canRedisplayNextPanel()) {
            var1 = this.currentPanel.getNextPanel();
         }
      } else {
         var1 = this.currentPanel.getNextPanel();
      }

      ++this.step;
      if(this.step < this.panels.size()) {
         this.panels.set(this.step, var1);
      } else {
         this.panels.add(var1);
      }

      Container var2 = this.getContentPane();
      var2.remove(this.currentPanel);
      var2.add(var1);
      this.currentPanel = var1;
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
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
      var1.add((JPanel)this.panels.get(0));
      L1R3ButtonPanel var2 = new L1R3ButtonPanel("Help", "Previous", "Next", "Finish");
      this.helpButton = var2.getLeftButton();
      this.helpButton.setEnabled(false);
      this.previousButton = var2.getRightButton1();
      this.previousButton.setActionCommand("previousButton");
      this.previousButton.addActionListener(this);
      this.previousButton.setEnabled(false);
      this.nextButton = var2.getRightButton2();
      this.nextButton.setActionCommand("nextButton");
      this.nextButton.addActionListener(this);
      this.nextButton.setEnabled(true);
      this.finishButton = var2.getRightButton3();
      this.finishButton.setActionCommand("finishButton");
      this.finishButton.addActionListener(this);
      this.finishButton.setEnabled(false);
      var2.setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));
      var1.add(var2, "South");
      return var1;
   }
}
