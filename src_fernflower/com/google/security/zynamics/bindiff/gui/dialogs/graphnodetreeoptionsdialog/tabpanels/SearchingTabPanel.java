package com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabpanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class SearchingTabPanel extends JPanel {
   private final JCheckBox regExCheckBox = new JCheckBox("Regular Expression");
   private final JCheckBox caseSensitiveCheckBox = new JCheckBox("Case Sensitive");
   private final JCheckBox primarySideCheckBox = new JCheckBox("Primary Side");
   private final JCheckBox secondarySideCheckBox = new JCheckBox("Secondary Side");
   private final JCheckBox useTempResultsCheckBox = new JCheckBox("Search in last temporary Results");
   private final JCheckBox hightlightGraphNodesCheckBox = new JCheckBox("Highlight Graph Nodes");
   private boolean initialRegEx;
   private boolean initialCaseSensitive;
   private boolean initialPrimarySide;
   private boolean initialSecondarySide;
   private boolean initialHighlightGraphNode;
   private boolean initialUseTempResults;

   public SearchingTabPanel(boolean var1) {
      super(new BorderLayout());
      this.add(this.createPanel(var1), "Center");
      this.setDefaults();
   }

   private JPanel createPanel(boolean var1) {
      JPanel var2 = new JPanel(new BorderLayout());
      var2.setBorder(new LineBorder(Color.GRAY));
      JPanel var3 = new JPanel(new BorderLayout());
      JPanel var4 = new JPanel(new GridLayout(var1?4:2, 1));
      var4.setBorder(new TitledBorder("Search Options"));
      var4.add(this.regExCheckBox);
      var4.add(this.caseSensitiveCheckBox);
      if(var1) {
         var4.add(this.primarySideCheckBox);
         var4.add(this.secondarySideCheckBox);
      }

      JPanel var5 = new JPanel(new BorderLayout());
      JPanel var6 = new JPanel(new GridLayout(2, 1));
      var6.setBorder(new TitledBorder("Result options"));
      var6.add(this.useTempResultsCheckBox);
      var6.add(this.hightlightGraphNodesCheckBox);
      var3.add(var4, "North");
      var5.add(var6, "North");
      var2.add(var3, "North");
      var2.add(var5, "Center");
      return var2;
   }

   public boolean getCaseSensitive() {
      return this.caseSensitiveCheckBox.isSelected();
   }

   public boolean getHighlightGraphNodes() {
      return this.hightlightGraphNodesCheckBox.isSelected();
   }

   public boolean getPrimarySide() {
      return this.primarySideCheckBox.isSelected();
   }

   public boolean getRegEx() {
      return this.regExCheckBox.isSelected();
   }

   public boolean getSecondarySide() {
      return this.secondarySideCheckBox.isSelected();
   }

   public boolean getUseTemporaryResult() {
      return this.useTempResultsCheckBox.isSelected();
   }

   public void restoreInitialSettings() {
      this.regExCheckBox.setSelected(this.initialRegEx);
      this.caseSensitiveCheckBox.setSelected(this.initialCaseSensitive);
      this.primarySideCheckBox.setSelected(this.initialPrimarySide);
      this.secondarySideCheckBox.setSelected(this.initialSecondarySide);
      this.hightlightGraphNodesCheckBox.setSelected(this.initialHighlightGraphNode);
      this.useTempResultsCheckBox.setSelected(this.initialUseTempResults);
   }

   public void setDefaults() {
      this.regExCheckBox.setSelected(false);
      this.caseSensitiveCheckBox.setSelected(false);
      this.primarySideCheckBox.setSelected(true);
      this.secondarySideCheckBox.setSelected(true);
      this.hightlightGraphNodesCheckBox.setSelected(true);
      this.useTempResultsCheckBox.setSelected(false);
   }

   public void storeInitialSettings() {
      this.initialRegEx = this.getRegEx();
      this.initialCaseSensitive = this.getCaseSensitive();
      this.initialPrimarySide = this.getPrimarySide();
      this.initialSecondarySide = this.getSecondarySide();
      this.initialHighlightGraphNode = this.getHighlightGraphNodes();
      this.initialUseTempResults = this.getUseTemporaryResult();
   }
}
