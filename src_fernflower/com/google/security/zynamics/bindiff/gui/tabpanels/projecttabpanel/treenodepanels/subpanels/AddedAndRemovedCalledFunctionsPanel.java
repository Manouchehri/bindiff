package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.security.zynamics.bindiff.enums.ECallDirection;
import com.google.security.zynamics.bindiff.enums.EExistence;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.edges.SingleViewEdge;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.AddedAndRemovedCalledFunctionsPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.AddedAndRemovedCalledFunctionsPanel$InternalMatchedFunctionViewsTableListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.ExtendedMatchedFunctionViewsTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.ExtendedMatchedFunctionViewsTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.MatchedFunctionViewsTable;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Triple;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class AddedAndRemovedCalledFunctionsPanel extends JPanel {
   private static String INCOMING_CALLS_BORDER_TEXT = "+%d / -%d Added and removed Parent Functions calling the selected Functions";
   private static String OUTGOING_CALLS_BORDER_TEXT = "+%d / -%d Added and removed Child Functions called from the selected Functions";
   private final TitledBorder incomingBorder;
   private final TitledBorder outgoingBorder;
   private final ExtendedMatchedFunctionViewsTable incomingFunctionsCalledTable;
   private final ExtendedMatchedFunctionViewsTable outgoingFunctionsCalledTable;
   private final Diff diff;
   private final MatchedFunctionViewsTable matchedfunctionViewsTable;
   private final AddedAndRemovedCalledFunctionsPanel$InternalMatchedFunctionViewsTableListener matchedFunctionViewsSelectionListener;

   public AddedAndRemovedCalledFunctionsPanel(Diff var1, WorkspaceTabPanelFunctions var2, MatchedFunctionViewsTable var3) {
      super(new BorderLayout());
      this.incomingBorder = new TitledBorder(String.format(INCOMING_CALLS_BORDER_TEXT, new Object[]{Integer.valueOf(0), Integer.valueOf(0)}));
      this.outgoingBorder = new TitledBorder(String.format(OUTGOING_CALLS_BORDER_TEXT, new Object[]{Integer.valueOf(0), Integer.valueOf(0)}));
      this.matchedFunctionViewsSelectionListener = new AddedAndRemovedCalledFunctionsPanel$InternalMatchedFunctionViewsTableListener(this, (AddedAndRemovedCalledFunctionsPanel$1)null);
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      Preconditions.checkNotNull(var3);
      this.diff = var1;
      this.matchedfunctionViewsTable = var3;
      this.incomingFunctionsCalledTable = new ExtendedMatchedFunctionViewsTable(new ExtendedMatchedFunctionViewsTableModel(var1), var2);
      this.outgoingFunctionsCalledTable = new ExtendedMatchedFunctionViewsTable(new ExtendedMatchedFunctionViewsTableModel(var1), var2);
      this.matchedfunctionViewsTable.addListener(this.matchedFunctionViewsSelectionListener);
      this.add(this.createFunctionsCalledPanel(), "Center");
   }

   private JPanel createFunctionsCalledPanel() {
      JPanel var1 = new JPanel(new BorderLayout());
      JSplitPane var2 = new JSplitPane(0, true);
      var2.setBorder(new EmptyBorder(0, 0, 0, 0));
      var2.setRightComponent(this.createOutgoingFunctionsCalledTable());
      var2.setLeftComponent(this.createIncomingFunctionsCalledPanel());
      var2.setOneTouchExpandable(true);
      var2.setResizeWeight(0.5D);
      var2.setDividerLocation(0.5D);
      var1.add(var2, "Center");
      return var1;
   }

   private JPanel createIncomingFunctionsCalledPanel() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(this.incomingBorder);
      var1.add(this.createTablePanel(this.incomingFunctionsCalledTable), "Center");
      return var1;
   }

   private JPanel createOutgoingFunctionsCalledTable() {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBorder(this.outgoingBorder);
      var1.add(this.createTablePanel(this.outgoingFunctionsCalledTable), "Center");
      return var1;
   }

   private JPanel createTablePanel(AbstractTable var1) {
      JPanel var2 = new JPanel(new BorderLayout());
      JScrollPane var3 = new JScrollPane(var1);
      var2.add(var3, "Center");
      return var2;
   }

   private Multiset getFunctions(RawFunction var1, ECallDirection var2) {
      HashMultiset var3 = HashMultiset.create();
      List var4 = var2 == ECallDirection.INCOMING?var1.getIncomingEdges():var1.getOutgoingEdges();
      Iterator var5 = var4.iterator();

      while(var5.hasNext()) {
         SingleViewEdge var6 = (SingleViewEdge)var5.next();
         var3.add(var2 == ECallDirection.INCOMING?(RawFunction)var6.getSource():(RawFunction)var6.getTarget());
      }

      return var3;
   }

   private void getSecondaryFunctionCallChanges(IAddress var1, IAddress var2, ECallDirection var3, List var4) {
      RawFunction var5 = this.diff.getCallgraph(ESide.PRIMARY).getFunction(var1);
      RawFunction var6 = this.diff.getCallgraph(ESide.SECONDARY).getFunction(var2);
      Multiset var7 = this.getFunctions(var5, var3);
      Multiset var8 = this.getFunctions(var6, var3);
      ArrayList var9 = new ArrayList();
      ArrayList var10 = new ArrayList();
      Iterator var11 = var8.iterator();

      RawFunction var12;
      RawFunction var13;
      while(var11.hasNext()) {
         var12 = (RawFunction)var11.next();
         var13 = var12.getMatchedFunction();
         if(var13 != null && var7.remove(var13)) {
            var9.add(var13);
            var10.add(var12);
         }
      }

      var8.removeAll(var10);
      var11 = var8.iterator();

      while(var11.hasNext()) {
         var12 = (RawFunction)var11.next();
         var4.add(Triple.make(var12.getMatchedFunction(), var12, EExistence.ADDED));
      }

      var7.addAll(var9);
      var8.addAll(var10);
      ArrayList var15 = new ArrayList();
      Iterator var16 = var7.iterator();

      while(var16.hasNext()) {
         var13 = (RawFunction)var16.next();
         RawFunction var14 = var13.getMatchedFunction();
         if(var14 != null && var8.remove(var14)) {
            var15.add(var13);
         }
      }

      var7.removeAll(var15);
      var16 = var7.iterator();

      while(var16.hasNext()) {
         var13 = (RawFunction)var16.next();
         var4.add(Triple.make(var13, var13.getMatchedFunction(), EExistence.REMOVED));
      }

   }

   private void updateBorders(int var1, int var2, int var3, int var4) {
      this.incomingBorder.setTitle(String.format(INCOMING_CALLS_BORDER_TEXT, new Object[]{Integer.valueOf(var1), Integer.valueOf(var2)}));
      this.outgoingBorder.setTitle(String.format(OUTGOING_CALLS_BORDER_TEXT, new Object[]{Integer.valueOf(var3), Integer.valueOf(var4)}));
      this.updateUI();
   }

   public void dispose() {
      this.matchedfunctionViewsTable.removeListener(this.matchedFunctionViewsSelectionListener);
   }

   // $FF: synthetic method
   static void access$100(AddedAndRemovedCalledFunctionsPanel var0, IAddress var1, IAddress var2, ECallDirection var3, List var4) {
      var0.getSecondaryFunctionCallChanges(var1, var2, var3, var4);
   }

   // $FF: synthetic method
   static ExtendedMatchedFunctionViewsTable access$200(AddedAndRemovedCalledFunctionsPanel var0) {
      return var0.outgoingFunctionsCalledTable;
   }

   // $FF: synthetic method
   static ExtendedMatchedFunctionViewsTable access$300(AddedAndRemovedCalledFunctionsPanel var0) {
      return var0.incomingFunctionsCalledTable;
   }

   // $FF: synthetic method
   static void access$400(AddedAndRemovedCalledFunctionsPanel var0, int var1, int var2, int var3, int var4) {
      var0.updateBorders(var1, var2, var3, var4);
   }
}
