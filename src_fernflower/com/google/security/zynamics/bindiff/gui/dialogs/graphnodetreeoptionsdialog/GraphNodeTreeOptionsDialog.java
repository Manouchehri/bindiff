package com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESortByCriterium;
import com.google.security.zynamics.bindiff.enums.ESortOrder;
import com.google.security.zynamics.bindiff.graph.filter.enums.EMatchStateFilter;
import com.google.security.zynamics.bindiff.graph.filter.enums.ESelectionFilter;
import com.google.security.zynamics.bindiff.graph.filter.enums.ESideFilter;
import com.google.security.zynamics.bindiff.graph.filter.enums.EVisibilityFilter;
import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.GraphNodeTreeOptionsDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.GraphNodeTreeOptionsDialog$InternalButtonListener;
import com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabpanels.FilteringTabPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabpanels.SearchingTabPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabpanels.SortingTabPanel;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class GraphNodeTreeOptionsDialog extends BaseDialog {
   private final GraphNodeTreeOptionsDialog$InternalButtonListener buttonListener = new GraphNodeTreeOptionsDialog$InternalButtonListener(this, (GraphNodeTreeOptionsDialog$1)null);
   final JTabbedPane tab = new JTabbedPane();
   private final SearchingTabPanel searchingPanel;
   private final FilteringTabPanel filteringPanel;
   private final SortingTabPanel sortingPanel;
   private final JButton okButton = new JButton("Ok");
   private final JButton cancelButton = new JButton("Cancel");
   private final JButton setDefaultsButton = new JButton("Set Defaults");
   private boolean ok = false;

   public GraphNodeTreeOptionsDialog(Window var1, String var2, boolean var3, boolean var4) {
      super(var1, var2);
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      this.setTitle(var2);
      this.setModal(true);
      this.setLayout(new BorderLayout());
      ArrayList var5 = new ArrayList();
      var5.add(ImageUtils.getImageIcon("data/appicons/bindiff-16x16-rgba.png").getImage());
      var5.add(ImageUtils.getImageIcon("data/appicons/bindiff-32x32-rgba.png").getImage());
      var5.add(ImageUtils.getImageIcon("data/appicons/bindiff-48x48-rgba.png").getImage());
      this.setIconImages(var5);
      this.searchingPanel = new SearchingTabPanel(var4);
      this.filteringPanel = new FilteringTabPanel(var4, var3);
      this.sortingPanel = new SortingTabPanel(var4, var3);
      this.init();
      this.okButton.addActionListener(this.buttonListener);
      this.cancelButton.addActionListener(this.buttonListener);
      this.setDefaultsButton.addActionListener(this.buttonListener);
   }

   private JPanel createButtonPanel() {
      JPanel var1 = new JPanel(new GridLayout(1, 2));
      var1.setBorder(new EmptyBorder(10, 5, 5, 5));
      JPanel var2 = new JPanel(new BorderLayout());
      var2.add(this.setDefaultsButton, "West");
      JPanel var3 = new JPanel(new BorderLayout());
      JPanel var4 = new JPanel(new GridLayout(1, 2, 5, 5));
      var4.add(this.okButton);
      var4.add(this.cancelButton);
      var3.add(var4, "East");
      var1.add(var2);
      var1.add(var3);
      return var1;
   }

   public void dispose() {
      this.okButton.removeActionListener(this.buttonListener);
      this.cancelButton.removeActionListener(this.buttonListener);
      this.setDefaultsButton.removeActionListener(this.buttonListener);
      super.dispose();
   }

   public boolean getCaseSensitive() {
      return this.searchingPanel.getCaseSensitive();
   }

   public IAddress getEndAddress() {
      return this.filteringPanel.getEndAddress();
   }

   public boolean getHighlightGraphNodes() {
      return this.searchingPanel.getHighlightGraphNodes();
   }

   public EMatchStateFilter getMatchStateFilter() {
      return this.filteringPanel.getMatchStateFilter();
   }

   public boolean getOkPressed() {
      return this.ok;
   }

   public boolean getPrimarySide() {
      return this.searchingPanel.getPrimarySide();
   }

   public boolean getRegEx() {
      return this.searchingPanel.getRegEx();
   }

   public boolean getSecondarySide() {
      return this.searchingPanel.getSecondarySide();
   }

   public ESelectionFilter getSelectionFilter() {
      return this.filteringPanel.getSelectionFilter();
   }

   public ESideFilter getSideFilter() {
      return this.filteringPanel.getSideFilter();
   }

   public ESortByCriterium getSortByCriterium(int var1) {
      return this.sortingPanel.getSortByCriterium(var1);
   }

   public ESortOrder getSortOrder(int var1) {
      return this.sortingPanel.getSortOrder(var1);
   }

   public IAddress getStartAddress() {
      return this.filteringPanel.getStartAddress();
   }

   public boolean getUseTemporaryResult() {
      return this.searchingPanel.getUseTemporaryResult();
   }

   public EVisibilityFilter getVisibilityFilter() {
      return this.filteringPanel.getVisibilityFilter();
   }

   private void init() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(new EmptyBorder(1, 1, 1, 1));
      this.tab.add(this.searchingPanel);
      this.tab.add(this.filteringPanel);
      this.tab.add(this.sortingPanel);
      this.tab.setTitleAt(0, "Search");
      this.tab.setTitleAt(1, "Filter");
      this.tab.setTitleAt(2, "Sort");
      JPanel var2 = this.createButtonPanel();
      var1.add(this.tab, "Center");
      var1.add(var2, "South");
      this.add(var1, "Center");
      this.pack();
      this.setPreferredSize(new Dimension(this.getPreferredSize().width, this.getPreferredSize().height + 8));
      this.setMinimumSize(this.getPreferredSize());
   }

   public void setDefaults(int var1) {
      switch(var1) {
      case 0:
         this.searchingPanel.setDefaults();
         break;
      case 1:
         this.filteringPanel.setDefaults();
         break;
      case 2:
         this.sortingPanel.setDefaults();
      }

   }

   public void setVisible(boolean var1) {
      if(var1) {
         this.searchingPanel.storeInitialSettings();
         this.filteringPanel.storeInitialSettings();
         this.sortingPanel.storeInitialSettings();
      }

      super.setVisible(var1);
   }

   // $FF: synthetic method
   static JButton access$100(GraphNodeTreeOptionsDialog var0) {
      return var0.okButton;
   }

   // $FF: synthetic method
   static boolean access$202(GraphNodeTreeOptionsDialog var0, boolean var1) {
      return var0.ok = var1;
   }

   // $FF: synthetic method
   static JButton access$300(GraphNodeTreeOptionsDialog var0) {
      return var0.cancelButton;
   }

   // $FF: synthetic method
   static SearchingTabPanel access$400(GraphNodeTreeOptionsDialog var0) {
      return var0.searchingPanel;
   }

   // $FF: synthetic method
   static FilteringTabPanel access$500(GraphNodeTreeOptionsDialog var0) {
      return var0.filteringPanel;
   }

   // $FF: synthetic method
   static SortingTabPanel access$600(GraphNodeTreeOptionsDialog var0) {
      return var0.sortingPanel;
   }

   // $FF: synthetic method
   static JButton access$700(GraphNodeTreeOptionsDialog var0) {
      return var0.setDefaultsButton;
   }
}
