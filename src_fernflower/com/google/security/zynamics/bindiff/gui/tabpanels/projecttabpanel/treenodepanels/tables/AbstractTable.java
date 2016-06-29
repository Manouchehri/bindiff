package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractFunctionDiffViewsTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable$InternalMouseListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable$InternalSelectionListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.ExtendedMatchedFunctionViewsTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsContainerTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsContainerTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.IViewsTableListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.MatchedFunctionViewsTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.UnmatchedFunctionViewsTable;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.tables.CTableSorter;
import java.awt.event.MouseEvent;
import java.util.Comparator;
import java.util.Iterator;
import javax.swing.JPopupMenu;
import javax.swing.JTable;

public abstract class AbstractTable extends JTable {
   private final AbstractTableModel model;
   private final WorkspaceTabPanelFunctions controller;
   private final CTableSorter tableSorter;
   private final ListenerProvider listeners = new ListenerProvider();
   private final AbstractTable$InternalMouseListener mouseListener = new AbstractTable$InternalMouseListener(this, (AbstractTable$1)null);
   private final AbstractTable$InternalSelectionListener selectionListener = new AbstractTable$InternalSelectionListener(this, (AbstractTable$1)null);

   public AbstractTable(AbstractTableModel var1, WorkspaceTabPanelFunctions var2) {
      this.model = (AbstractTableModel)Preconditions.checkNotNull(var1);
      this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(var2);
      this.tableSorter = new CTableSorter(var1);
      this.setModel(this.tableSorter);
      this.tableSorter.setTableHeader(this.getTableHeader());
      Iterator var3 = var1.getSorters().iterator();

      while(var3.hasNext()) {
         Pair var4 = (Pair)var3.next();
         this.tableSorter.setColumnComparator(((Integer)var4.first()).intValue(), (Comparator)var4.second());
      }

      this.getModel().getTableHeader().setToolTipText("Press CTRL to add secondary sort.");
      this.addMouseListener(this.mouseListener);
      this.getSelectionModel().addListSelectionListener(this.selectionListener);
   }

   public static Diff getRowDiff(AbstractTable var0, int var1) {
      int var2 = var0.getModel().modelIndex(var1);
      if(var0.getTableModel() instanceof FunctionDiffViewsContainerTableModel) {
         FunctionDiffViewsContainerTableModel var4 = (FunctionDiffViewsContainerTableModel)var0.getTableModel();
         return var4.getDiffAt(var2);
      } else if(var0.getTableModel() instanceof FunctionDiffViewsTableModel) {
         FunctionDiffViewsTableModel var3 = (FunctionDiffViewsTableModel)var0.getTableModel();
         return var3.getDiffAt(var2);
      } else {
         return var0.getDiff();
      }
   }

   public static Pair getViewAddressPair(AbstractTable var0, int var1) {
      Object var2 = null;
      Object var3 = null;
      if(var0 instanceof MatchedFunctionViewsTable) {
         var2 = new CAddress(var0.getValueAt(var1, 3).toString(), 16);
         var3 = new CAddress(var0.getValueAt(var1, 6).toString(), 16);
      } else if(var0 instanceof ExtendedMatchedFunctionViewsTable) {
         String var4 = var0.getValueAt(var1, 3).toString();
         if(!var4.isEmpty()) {
            var2 = new CAddress(var4, 16);
         }

         String var5 = var0.getValueAt(var1, 6).toString();
         if(!var5.isEmpty()) {
            var3 = new CAddress(var5, 16);
         }
      } else if(!(var0 instanceof FunctionDiffViewsContainerTable) && !(var0 instanceof FunctionDiffViewsTable)) {
         if(var0 instanceof UnmatchedFunctionViewsTable) {
            CAddress var8 = new CAddress(var0.getValueAt(var1, 0).toString(), 16);
            if(((UnmatchedFunctionViewsTable)var0).getSide() == ESide.PRIMARY) {
               var2 = var8;
            } else {
               var3 = var8;
            }
         }
      } else {
         Diff var7 = var0.getDiff();
         if(var7 == null) {
            AbstractFunctionDiffViewsTableModel var9 = (AbstractFunctionDiffViewsTableModel)var0.getTableModel();
            int var6 = var0.getModel().modelIndex(var1);
            var7 = var9.getDiffAt(var6);
         }

         if(!var7.isLoaded()) {
            return null;
         }

         var2 = ((RawFunction)var7.getCallgraph(ESide.PRIMARY).getNodes().get(0)).getAddress();
         var3 = ((RawFunction)var7.getCallgraph(ESide.SECONDARY).getNodes().get(0)).getAddress();
      }

      return Pair.make(var2, var3);
   }

   private void displayPopupMenu(MouseEvent var1) {
      int var2 = this.getSelectionIndex(var1);
      if(var2 != -1) {
         int var3 = this.rowAtPoint(var1.getPoint());
         int var4 = this.columnAtPoint(var1.getPoint());
         JPopupMenu var5 = this.getPopupMenu(var3, var4);
         if(var5 != null) {
            var5.show(this, var1.getX(), var1.getY());
         }

      }
   }

   private int getSelectionIndex(MouseEvent var1) {
      return this.tableSorter.modelIndex(this.rowAtPoint(var1.getPoint()));
   }

   protected abstract JPopupMenu getPopupMenu(int var1, int var2);

   protected int[] getSortSelectedRows() {
      int[] var1 = this.getSelectedRows();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         var1[var2] = this.tableSorter.modelIndex(var1[var2]);
      }

      return var1;
   }

   protected abstract void handleDoubleClick(int var1);

   public void addListener(IViewsTableListener var1) {
      this.listeners.addListener(var1);
   }

   public void dispose() {
      this.removeMouseListener(this.mouseListener);
      this.getSelectionModel().removeListSelectionListener(this.selectionListener);
      this.model.dispose();
   }

   public WorkspaceTabPanelFunctions getController() {
      return this.controller;
   }

   public Diff getDiff() {
      return this.model.getDiff();
   }

   public CTableSorter getModel() {
      return this.tableSorter;
   }

   public AbstractTableModel getTableModel() {
      return this.model;
   }

   public String getToolTipForRow(Diff var1, int var2) {
      return null;
   }

   public boolean hasSelection() {
      return this.getSelectedRowCount() > 0;
   }

   public void removeListener(IViewsTableListener var1) {
      this.listeners.removeListener(var1);
   }

   public void sortColumn(int var1, int var2) {
      this.tableSorter.setSortingStatus(var1, var2);
   }

   // $FF: synthetic method
   static int access$200(AbstractTable var0, MouseEvent var1) {
      return var0.getSelectionIndex(var1);
   }

   // $FF: synthetic method
   static void access$300(AbstractTable var0, MouseEvent var1) {
      var0.displayPopupMenu(var1);
   }

   // $FF: synthetic method
   static ListenerProvider access$400(AbstractTable var0) {
      return var0.listeners;
   }
}
