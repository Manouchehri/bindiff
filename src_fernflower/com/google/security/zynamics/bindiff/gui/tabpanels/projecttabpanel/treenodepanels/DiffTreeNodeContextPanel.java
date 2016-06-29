package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.database.MatchesDatabase;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.AbstractTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.DiffTreeNodeContextPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.DiffTreeNodeContextPanel$InternalDescriptionFocusListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.DiffTreeNodeContextPanel$InternalKeyListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.DiffTreeNodeContextPanel$InternalTimerListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.FunctionMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.SimilarityBarChart2dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarCellData;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarLabel;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import com.google.security.zynamics.zylib.gui.CPathLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class DiffTreeNodeContextPanel extends AbstractTreeNodeContextPanel {
   private static final int TEXTFIELDHEIGHT = 25;
   private static final int TEXTFIELDLABELWIDTH = 100;
   private final DiffTreeNodeContextPanel$InternalDescriptionFocusListener focusListener = new DiffTreeNodeContextPanel$InternalDescriptionFocusListener(this, (DiffTreeNodeContextPanel$1)null);
   private final DiffTreeNodeContextPanel$InternalKeyListener keyListener = new DiffTreeNodeContextPanel$InternalKeyListener(this, (DiffTreeNodeContextPanel$1)null);
   private final DiffTreeNodeContextPanel$InternalTimerListener timerListener = new DiffTreeNodeContextPanel$InternalTimerListener(this, (DiffTreeNodeContextPanel$1)null);
   private final CPathLabel diffPath;
   private final JTextField creationDate;
   private final JTextField primaryIDBName;
   private final JTextField primaryImageName;
   private final JTextField primaryImageHash;
   private final JTextField primaryArchitectureName;
   private final JTextField secondaryIDBName;
   private final JTextField secondaryImageName;
   private final JTextField secondaryImageHash;
   private final JTextField secondaryArchitectureName;
   private final JTextArea description;
   private final PercentageTwoBarLabel primaryFunctions;
   private final PercentageTwoBarLabel secondaryFunctions;
   private final Timer timer;
   private final Diff diff;
   private final TitledBorder descriptionBorder;
   private final WorkspaceTabPanelFunctions controller;

   public DiffTreeNodeContextPanel(Diff var1, WorkspaceTabPanelFunctions var2) {
      this.timer = new Timer(3500, this.timerListener);
      this.descriptionBorder = new TitledBorder("Description");
      this.diff = (Diff)Preconditions.checkNotNull(var1);
      this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(var2);
      DiffMetaData var3 = var1.getMetaData();
      this.creationDate = new JTextField(var3.getDateString());
      this.primaryIDBName = new JTextField(String.format("%s (%sBit)", new Object[]{var3.getIdbName(ESide.PRIMARY), var3.getAddressSpace(ESide.PRIMARY) == 0?"?":Integer.valueOf(var3.getAddressSpace(ESide.PRIMARY))}));
      this.primaryImageName = new JTextField(var3.getImageName(ESide.PRIMARY));
      this.primaryImageHash = new JTextField(var3.getImageHash(ESide.PRIMARY));
      this.primaryArchitectureName = new JTextField(var3.getArchitectureName(ESide.PRIMARY));
      this.secondaryIDBName = new JTextField(String.format("%s (%sBit)", new Object[]{var3.getIdbName(ESide.SECONDARY), var3.getAddressSpace(ESide.SECONDARY) == 0?"?":Integer.valueOf(var3.getAddressSpace(ESide.SECONDARY))}));
      this.secondaryImageName = new JTextField(var3.getImageName(ESide.SECONDARY));
      this.secondaryImageHash = new JTextField(var3.getImageHash(ESide.SECONDARY));
      this.secondaryArchitectureName = new JTextField(var3.getArchitectureName(ESide.SECONDARY));
      int var4 = var3.getSizeOfMatchedFunctions();
      PercentageTwoBarCellData var5 = new PercentageTwoBarCellData(var4, var3.getSizeOfUnmatchedFunctions(ESide.PRIMARY));
      PercentageTwoBarCellData var6 = new PercentageTwoBarCellData(var4, var3.getSizeOfUnmatchedFunctions(ESide.SECONDARY));
      this.primaryFunctions = new PercentageTwoBarLabel(var5, Colors.MATCHED_LABEL_BAR, Colors.UNMATCHED_PRIMARY_LABEL_BAR, 25);
      this.secondaryFunctions = new PercentageTwoBarLabel(var6, Colors.MATCHED_LABEL_BAR, Colors.UNMATCHED_SECONDARY_LABEL_BAR, 25);
      this.diffPath = new CPathLabel(var1.getMatchesDatabase().getPath());
      this.description = new JTextArea(var3.getDiffDescription());
      this.description.addFocusListener(this.focusListener);
      this.description.addKeyListener(this.keyListener);
      this.initComponents();
      this.loadDescription();
   }

   private JPanel createDescriptionPanel() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(this.descriptionBorder);
      var1.add(new JScrollPane(this.description), "Center");
      return var1;
   }

   private JPanel createDiffInfoPanel() {
      JPanel var1 = new JPanel(new GridLayout(1, 2, 2, 2));
      JPanel var2 = new JPanel(new BorderLayout());
      JPanel var3 = new JPanel(new BorderLayout());
      JPanel var4 = new JPanel(new GridLayout(5, 1, 2, 2));
      JPanel var5 = new JPanel(new GridLayout(5, 1, 2, 2));
      var2.setBorder(new TitledBorder("Primary Image"));
      var3.setBorder(new TitledBorder("Secondary Image"));
      var4.setBorder(new LineBorder(Color.GRAY));
      var5.setBorder(new LineBorder(Color.GRAY));
      var4.setBackground(Color.WHITE);
      var5.setBackground(Color.WHITE);
      var4.add(GuiUtils.createHorizontalNamedLabelPanel("IDB Name", 100, (JTextField)this.primaryIDBName, 25));
      var4.add(GuiUtils.createHorizontalNamedLabelPanel("Image Name", 100, (JTextField)this.primaryImageName, 25));
      var4.add(GuiUtils.createHorizontalNamedLabelPanel("Hash", 100, (JTextField)this.primaryImageHash, 25));
      var4.add(GuiUtils.createHorizontalNamedLabelPanel("Architecture", 100, (JTextField)this.primaryArchitectureName, 25));
      var4.add(GuiUtils.createHorizontalNamedLabelPanel("Functions", 100, (JLabel)this.primaryFunctions, 25));
      var5.add(GuiUtils.createHorizontalNamedLabelPanel("IDB Name", 100, (JTextField)this.secondaryIDBName, 25));
      var5.add(GuiUtils.createHorizontalNamedLabelPanel("Image Name", 100, (JTextField)this.secondaryImageName, 25));
      var5.add(GuiUtils.createHorizontalNamedLabelPanel("Hash", 100, (JTextField)this.secondaryImageHash, 25));
      var5.add(GuiUtils.createHorizontalNamedLabelPanel("Architecture", 100, (JTextField)this.secondaryArchitectureName, 25));
      var5.add(GuiUtils.createHorizontalNamedLabelPanel("Functions", 100, (JLabel)this.secondaryFunctions, 25));
      var2.add(var4, "Center");
      var3.add(var5, "Center");
      var1.add(var2);
      var1.add(var3);
      return var1;
   }

   private JPanel createOverviewPanel() {
      DiffMetaData var1 = this.diff.getMetaData();
      JPanel var2 = new JPanel(new BorderLayout(0, 0));
      var2.setBorder(new CompoundBorder(new TitledBorder("Overview"), new LineBorder(Color.GRAY)));
      JPanel var3 = new JPanel(new GridLayout(1, 1, 0, 0));
      var2.add(var3, "Center");
      var3.add(new FunctionMatchesPie3dPanel(var1));
      var3.add(new SimilarityBarChart2dPanel(var1));
      JPanel var4 = new JPanel(new GridLayout(2, 1, 2, 2));
      var4.setBorder(BorderFactory.createLineBorder(Color.GRAY));
      var4.setBackground(Color.WHITE);
      var4.add(GuiUtils.createHorizontalNamedLabelPanel("Diff Path", 100, (JLabel)this.diffPath, 25));
      var4.add(GuiUtils.createHorizontalNamedLabelPanel("File Date", 100, (JTextField)this.creationDate, 25));
      JPanel var5 = new JPanel(new BorderLayout());
      var5.setBorder(new TitledBorder("Diff Info"));
      var5.add(var4, "Center");
      JPanel var6 = new JPanel(new BorderLayout());
      var6.add(var2, "Center");
      var6.add(var5, "South");
      return var6;
   }

   private void initComponents() {
      this.diffPath.setPreferredSize(new Dimension(this.diffPath.getPreferredSize().width, 25));
      JPanel var1 = new JPanel(new BorderLayout());
      var1.add(this.createOverviewPanel(), "Center");
      var1.add(this.createDiffInfoPanel(), "South");
      this.add(var1, "North");
      this.add(this.createDescriptionPanel(), "Center");
   }

   private void loadDescription() {
      MatchesDatabase var1 = null;

      try {
         var1 = new MatchesDatabase(this.diff.getMatchesDatabase());
         this.description.setText(var1.loadDiffDescription());
      } catch (SQLException var3) {
         Logger.logException(var3, "Load diff description failed.");
      }

   }

   private void saveDescription() {
      if(this.controller.saveDescription(this.diff, this.description.getText())) {
         this.descriptionBorder.setTitleColor(Colors.JUMP_CONDITIONAL_FALSE);
         this.descriptionBorder.setTitle("Saved description");
         this.updateUI();
         this.timer.start();
      }

   }

   public void dispose() {
      this.description.removeFocusListener(this.focusListener);
      this.description.removeKeyListener(this.keyListener);
   }

   public List getTables() {
      return null;
   }

   // $FF: synthetic method
   static void access$300(DiffTreeNodeContextPanel var0) {
      var0.saveDescription();
   }

   // $FF: synthetic method
   static TitledBorder access$400(DiffTreeNodeContextPanel var0) {
      return var0.descriptionBorder;
   }

   // $FF: synthetic method
   static Timer access$500(DiffTreeNodeContextPanel var0) {
      return var0.timer;
   }
}
