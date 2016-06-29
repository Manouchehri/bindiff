package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.ViewSearchOptionsDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.ViewSearchOptionsDialog$InternalCancelButtonListener;
import com.google.security.zynamics.bindiff.gui.dialogs.ViewSearchOptionsDialog$InternalOkButtonListener;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class ViewSearchOptionsDialog extends BaseDialog {
   private static final ImageIcon APP_ICON = ImageUtils.getImageIcon("data/appicons/bindiff-16x16-rgba.png");
   private final ViewSearchOptionsDialog$InternalOkButtonListener okButtonListener = new ViewSearchOptionsDialog$InternalOkButtonListener(this, (ViewSearchOptionsDialog$1)null);
   private final ViewSearchOptionsDialog$InternalCancelButtonListener cancelButtonListener = new ViewSearchOptionsDialog$InternalCancelButtonListener(this, (ViewSearchOptionsDialog$1)null);
   private final JButton okButton = new JButton("Ok");
   private final JButton cancelButton = new JButton("Cancel");
   private final JCheckBox regExBox;
   private final JCheckBox caseSensitiveBox;
   private final JCheckBox primarySideBox;
   private final JCheckBox secondarySideBox;
   private final JCheckBox tempViewTables;
   private boolean okButtonPressed = false;

   public ViewSearchOptionsDialog(Window var1, String var2, boolean var3, boolean var4, boolean var5, boolean var6, boolean var7) {
      super(var1, var2);
      this.setIconImage(APP_ICON.getImage());
      this.okButton.addActionListener(this.okButtonListener);
      this.cancelButton.addActionListener(this.cancelButtonListener);
      this.regExBox = new JCheckBox("Regular Expression", var3);
      this.caseSensitiveBox = new JCheckBox("Case sensitive", var4);
      this.primarySideBox = new JCheckBox("Primary Side", var5);
      this.secondarySideBox = new JCheckBox("Secondary Side", var6);
      this.tempViewTables = new JCheckBox("Only search in last temporary search result table", var7);
      this.init();
      GuiHelper.centerChildToParent(var1, this, true);
   }

   private void init() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(new EmptyBorder(5, 5, 5, 5));
      JPanel var2 = new JPanel(new GridLayout(2, 1));
      var2.setBorder(new TitledBorder(""));
      var2.add(this.regExBox);
      var2.add(this.caseSensitiveBox);
      JPanel var3 = new JPanel(new GridLayout(2, 1));
      var3.setBorder(new TitledBorder(""));
      var3.add(this.primarySideBox);
      var3.add(this.secondarySideBox);
      JPanel var4 = new JPanel(new GridLayout(1, 2, 5, 5));
      var4.add(var2);
      var4.add(var3);
      JPanel var5 = new JPanel(new BorderLayout());
      var5.add(var4, "Center");
      JPanel var6 = new JPanel(new BorderLayout());
      var6.setBorder(new EmptyBorder(5, 0, 0, 0));
      var6.add(this.tempViewTables, "Center");
      var5.add(var6, "South");
      JPanel var7 = new JPanel(new BorderLayout());
      var7.setBorder(new EmptyBorder(10, 0, 0, 0));
      JPanel var8 = new JPanel(new GridLayout(1, 2, 5, 5));
      var8.add(this.okButton);
      var8.add(this.cancelButton);
      var7.add(var8, "East");
      var1.add(var5, "Center");
      var1.add(var7, "South");
      this.add(var1, "Center");
      this.pack();
      this.setMinimumSize(new Dimension(this.getPreferredSize().width, this.getPreferredSize().height));
      this.setResizable(false);
   }

   public void disableSideCheckboxes() {
      this.primarySideBox.setEnabled(false);
      this.secondarySideBox.setEnabled(false);
   }

   public void dispose() {
      this.okButton.removeActionListener(this.okButtonListener);
      this.cancelButton.removeActionListener(this.cancelButtonListener);
      super.dispose();
   }

   public boolean getCaseSensitiveSelected() {
      return this.caseSensitiveBox.isSelected();
   }

   public boolean getOkButtonPressed() {
      return this.okButtonPressed;
   }

   public boolean getPrimarySideSearch() {
      return this.primarySideBox.isSelected();
   }

   public boolean getRegExSelected() {
      return this.regExBox.isSelected();
   }

   public boolean getSecondarySideSearch() {
      return this.secondarySideBox.isSelected();
   }

   public boolean getTemporaryTableUse() {
      return this.tempViewTables.isSelected();
   }

   // $FF: synthetic method
   static boolean access$202(ViewSearchOptionsDialog var0, boolean var1) {
      return var0.okButtonPressed = var1;
   }
}
