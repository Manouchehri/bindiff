package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.SaveAsViewDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.SaveAsViewDialog$InternalButtonListener;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class SaveAsViewDialog extends BaseDialog {
   private final SaveAsViewDialog$InternalButtonListener buttonListener = new SaveAsViewDialog$InternalButtonListener(this, (SaveAsViewDialog$1)null);
   private final JTextField nameTextField = new JTextField();
   private final JTextArea commentTextField = new JTextArea();
   private final JButton okButton = new JButton("Ok");
   private final JButton cancelButton = new JButton("Cancel");
   private boolean pressedOkButton = false;

   public SaveAsViewDialog(Window var1, String var2) {
      super(var1, "Save View As");
      this.setModal(true);
      this.setLayout(new BorderLayout());
      this.nameTextField.setText(var2.toString());
      this.okButton.addActionListener(this.buttonListener);
      this.cancelButton.addActionListener(this.buttonListener);
      this.init();
      GuiHelper.centerChildToParent(var1, this, true);
   }

   private void init() {
      this.nameTextField.setPreferredSize(new Dimension(this.nameTextField.getPreferredSize().width, 25));
      this.commentTextField.setLineWrap(true);
      JScrollPane var1 = new JScrollPane(this.commentTextField);
      JPanel var2 = new JPanel(new BorderLayout());
      JPanel var3 = new JPanel(new BorderLayout());
      var3.setBorder(new TitledBorder("View Name"));
      var3.add(this.nameTextField, "North");
      JPanel var4 = new JPanel(new BorderLayout());
      var4.setBorder(new TitledBorder("View Comment"));
      var4.add(var1, "Center");
      JPanel var5 = new JPanel(new BorderLayout());
      var5.setBorder(new EmptyBorder(10, 5, 5, 5));
      JPanel var6 = new JPanel(new GridLayout(1, 2, 5, 5));
      var6.add(this.okButton);
      var6.add(this.cancelButton);
      var5.add(var6, "East");
      var2.add(var3, "North");
      var2.add(var4, "Center");
      var2.add(var5, "South");
      this.add(var2, "Center");
      this.pack();
      this.setPreferredSize(new Dimension(400, 250));
      this.setSize(new Dimension(400, 250));
      this.setMinimumSize(this.getSize());
   }

   public void dispose() {
      this.okButton.removeActionListener(this.buttonListener);
      this.cancelButton.removeActionListener(this.buttonListener);
      super.dispose();
   }

   public boolean getOkButtonPressed() {
      return this.pressedOkButton;
   }

   public String getViewComment() {
      return this.commentTextField.getText();
   }

   public String getViewName() {
      return this.nameTextField.getText();
   }

   // $FF: synthetic method
   static JButton access$100(SaveAsViewDialog var0) {
      return var0.okButton;
   }

   // $FF: synthetic method
   static boolean access$202(SaveAsViewDialog var0, boolean var1) {
      return var0.pressedOkButton = var1;
   }
}
