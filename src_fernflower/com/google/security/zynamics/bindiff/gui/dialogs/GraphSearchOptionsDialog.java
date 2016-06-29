package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.searchers.GraphSearcher;
import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.GraphSearchOptionsDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.GraphSearchOptionsDialog$InternalButtonListener;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Window;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class GraphSearchOptionsDialog extends BaseDialog {
   private final GraphSearchOptionsDialog$InternalButtonListener buttonListener = new GraphSearchOptionsDialog$InternalButtonListener(this, (GraphSearchOptionsDialog$1)null);
   private final JCheckBox regEx = new JCheckBox("Regular Expression");
   private final JCheckBox caseSensitive = new JCheckBox("Case Sensitive");
   private final JCheckBox visibleOnly = new JCheckBox("Visible Only");
   private final JCheckBox selectedOnly = new JCheckBox("Selected Only");
   private final JButton okButton = new JButton("Ok");
   private final JButton cancelButton = new JButton("Cancel");
   private final JButton setDefaultsButton = new JButton("Set Defaults");
   private final GraphSearcher searcher;
   private boolean originalRegEx;
   private boolean originalCaseSensitive;
   private boolean originalVisibleOnly;
   private boolean originalSelectedOnly;

   public GraphSearchOptionsDialog(Window var1, BinDiffGraph var2) {
      super(var1, "Search Options");
      Preconditions.checkNotNull(var2);
      this.setModal(true);
      this.setLayout(new BorderLayout());
      this.searcher = var2.getGraphSearcher();
      this.regEx.setSelected(this.searcher.isRegEx());
      this.caseSensitive.setSelected(this.searcher.isCaseSensitive());
      this.visibleOnly.setSelected(this.searcher.isVisibleOnly());
      this.selectedOnly.setSelected(this.searcher.isSelectedOnly());
      this.okButton.addActionListener(this.buttonListener);
      this.cancelButton.addActionListener(this.buttonListener);
      this.setDefaultsButton.addActionListener(this.buttonListener);
      this.init();
      this.pack();
      this.setMinimumSize(this.getSize());
      GuiHelper.centerChildToParent(var1, this, true);
   }

   private JPanel createButtonsPanel() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(new EmptyBorder(10, 5, 5, 5));
      JPanel var2 = new JPanel(new BorderLayout());
      var2.add(this.setDefaultsButton, "West");
      JPanel var3 = new JPanel(new GridLayout(1, 2, 5, 5));
      var3.add(this.okButton);
      var3.add(this.cancelButton);
      var1.add(var2, "West");
      var1.add(var3, "East");
      return var1;
   }

   private JPanel createOptionsPanel() {
      JPanel var1 = new JPanel(new GridLayout(1, 2, 5, 5));
      JPanel var2 = new JPanel(new GridLayout(2, 1));
      var2.setBorder(new TitledBorder(""));
      var2.add(this.regEx);
      var2.add(this.caseSensitive);
      JPanel var3 = new JPanel(new GridLayout(2, 1));
      var3.setBorder(new TitledBorder(""));
      var3.add(this.visibleOnly);
      var3.add(this.selectedOnly);
      var1.add(var2);
      var1.add(var3);
      return var1;
   }

   private void init() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(new TitledBorder(""));
      var1.add(this.createOptionsPanel(), "North");
      var1.add(this.createButtonsPanel(), "South");
      this.add(var1, "Center");
   }

   public void setVisible(boolean var1) {
      if(var1) {
         this.originalRegEx = this.regEx.isSelected();
         this.originalCaseSensitive = this.caseSensitive.isSelected();
         this.originalVisibleOnly = this.visibleOnly.isSelected();
         this.originalSelectedOnly = this.selectedOnly.isSelected();
      }

      super.setVisible(var1);
   }

   // $FF: synthetic method
   static JButton access$100(GraphSearchOptionsDialog var0) {
      return var0.setDefaultsButton;
   }

   // $FF: synthetic method
   static GraphSearcher access$200(GraphSearchOptionsDialog var0) {
      return var0.searcher;
   }

   // $FF: synthetic method
   static JCheckBox access$300(GraphSearchOptionsDialog var0) {
      return var0.regEx;
   }

   // $FF: synthetic method
   static JCheckBox access$400(GraphSearchOptionsDialog var0) {
      return var0.caseSensitive;
   }

   // $FF: synthetic method
   static JCheckBox access$500(GraphSearchOptionsDialog var0) {
      return var0.selectedOnly;
   }

   // $FF: synthetic method
   static JCheckBox access$600(GraphSearchOptionsDialog var0) {
      return var0.visibleOnly;
   }

   // $FF: synthetic method
   static JButton access$700(GraphSearchOptionsDialog var0) {
      return var0.okButton;
   }

   // $FF: synthetic method
   static JButton access$800(GraphSearchOptionsDialog var0) {
      return var0.cancelButton;
   }

   // $FF: synthetic method
   static boolean access$900(GraphSearchOptionsDialog var0) {
      return var0.originalRegEx;
   }

   // $FF: synthetic method
   static boolean access$1000(GraphSearchOptionsDialog var0) {
      return var0.originalCaseSensitive;
   }

   // $FF: synthetic method
   static boolean access$1100(GraphSearchOptionsDialog var0) {
      return var0.originalVisibleOnly;
   }

   // $FF: synthetic method
   static boolean access$1200(GraphSearchOptionsDialog var0) {
      return var0.originalSelectedOnly;
   }
}
