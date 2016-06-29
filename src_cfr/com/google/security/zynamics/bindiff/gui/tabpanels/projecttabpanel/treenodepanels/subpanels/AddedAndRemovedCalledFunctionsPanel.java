/*
 * Decompiled with CFR 0_115.
 */
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
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.ExtendedMatchedFunctionViewsTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.ExtendedMatchedFunctionViewsTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.IMatchedFunctionsViewsTableListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.MatchedFunctionViewsTable;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Triple;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class AddedAndRemovedCalledFunctionsPanel
extends JPanel {
    private static String INCOMING_CALLS_BORDER_TEXT = "+%d / -%d Added and removed Parent Functions calling the selected Functions";
    private static String OUTGOING_CALLS_BORDER_TEXT = "+%d / -%d Added and removed Child Functions called from the selected Functions";
    private final TitledBorder incomingBorder = new TitledBorder(String.format(INCOMING_CALLS_BORDER_TEXT, 0, 0));
    private final TitledBorder outgoingBorder = new TitledBorder(String.format(OUTGOING_CALLS_BORDER_TEXT, 0, 0));
    private final ExtendedMatchedFunctionViewsTable incomingFunctionsCalledTable;
    private final ExtendedMatchedFunctionViewsTable outgoingFunctionsCalledTable;
    private final Diff diff;
    private final MatchedFunctionViewsTable matchedfunctionViewsTable;
    private final AddedAndRemovedCalledFunctionsPanel$InternalMatchedFunctionViewsTableListener matchedFunctionViewsSelectionListener;

    public AddedAndRemovedCalledFunctionsPanel(Diff diff, WorkspaceTabPanelFunctions workspaceTabPanelFunctions, MatchedFunctionViewsTable matchedFunctionViewsTable) {
        super(new BorderLayout());
        this.matchedFunctionViewsSelectionListener = new AddedAndRemovedCalledFunctionsPanel$InternalMatchedFunctionViewsTableListener(this, null);
        Preconditions.checkNotNull(diff);
        Preconditions.checkNotNull(workspaceTabPanelFunctions);
        Preconditions.checkNotNull(matchedFunctionViewsTable);
        this.diff = diff;
        this.matchedfunctionViewsTable = matchedFunctionViewsTable;
        this.incomingFunctionsCalledTable = new ExtendedMatchedFunctionViewsTable(new ExtendedMatchedFunctionViewsTableModel(diff), workspaceTabPanelFunctions);
        this.outgoingFunctionsCalledTable = new ExtendedMatchedFunctionViewsTable(new ExtendedMatchedFunctionViewsTableModel(diff), workspaceTabPanelFunctions);
        this.matchedfunctionViewsTable.addListener(this.matchedFunctionViewsSelectionListener);
        this.add((Component)this.createFunctionsCalledPanel(), "Center");
    }

    private JPanel createFunctionsCalledPanel() {
        JPanel jPanel = new JPanel(new BorderLayout());
        JSplitPane jSplitPane = new JSplitPane(0, true);
        jSplitPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        jSplitPane.setRightComponent(this.createOutgoingFunctionsCalledTable());
        jSplitPane.setLeftComponent(this.createIncomingFunctionsCalledPanel());
        jSplitPane.setOneTouchExpandable(true);
        jSplitPane.setResizeWeight(0.5);
        jSplitPane.setDividerLocation(0.5);
        jPanel.add((Component)jSplitPane, "Center");
        return jPanel;
    }

    private JPanel createIncomingFunctionsCalledPanel() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(this.incomingBorder);
        jPanel.add((Component)this.createTablePanel(this.incomingFunctionsCalledTable), "Center");
        return jPanel;
    }

    private JPanel createOutgoingFunctionsCalledTable() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(this.outgoingBorder);
        jPanel.add((Component)this.createTablePanel(this.outgoingFunctionsCalledTable), "Center");
        return jPanel;
    }

    private JPanel createTablePanel(AbstractTable abstractTable) {
        JPanel jPanel = new JPanel(new BorderLayout());
        JScrollPane jScrollPane = new JScrollPane(abstractTable);
        jPanel.add((Component)jScrollPane, "Center");
        return jPanel;
    }

    private Multiset getFunctions(RawFunction rawFunction, ECallDirection eCallDirection) {
        HashMultiset hashMultiset = HashMultiset.create();
        List list = eCallDirection == ECallDirection.INCOMING ? rawFunction.getIncomingEdges() : rawFunction.getOutgoingEdges();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            SingleViewEdge singleViewEdge = (SingleViewEdge)iterator.next();
            hashMultiset.add(eCallDirection == ECallDirection.INCOMING ? (RawFunction)singleViewEdge.getSource() : (RawFunction)singleViewEdge.getTarget());
        }
        return hashMultiset;
    }

    private void getSecondaryFunctionCallChanges(IAddress iAddress, IAddress iAddress2, ECallDirection eCallDirection, List list) {
        Object object22;
        RawFunction rawFunction4;
        RawFunction rawFunction2 = this.diff.getCallgraph(ESide.PRIMARY).getFunction(iAddress);
        RawFunction rawFunction3 = this.diff.getCallgraph(ESide.SECONDARY).getFunction(iAddress2);
        Multiset multiset = this.getFunctions(rawFunction2, eCallDirection);
        Multiset multiset2 = this.getFunctions(rawFunction3, eCallDirection);
        ArrayList<RawFunction> arrayList = new ArrayList<RawFunction>();
        ArrayList<RawFunction> arrayList2 = new ArrayList<RawFunction>();
        for (Object object22 : multiset2) {
            rawFunction4 = object22.getMatchedFunction();
            if (rawFunction4 == null || !multiset.remove(rawFunction4)) continue;
            arrayList.add(rawFunction4);
            arrayList2.add((RawFunction)object22);
        }
        multiset2.removeAll(arrayList2);
        for (Object object22 : multiset2) {
            list.add(Triple.make(object22.getMatchedFunction(), object22, (Object)EExistence.ADDED));
        }
        multiset.addAll(arrayList);
        multiset2.addAll(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        for (RawFunction rawFunction4 : multiset) {
            RawFunction rawFunction5 = rawFunction4.getMatchedFunction();
            if (rawFunction5 == null || !multiset2.remove(rawFunction5)) continue;
            arrayList3.add(rawFunction4);
        }
        multiset.removeAll(arrayList3);
        object22 = multiset.iterator();
        while (object22.hasNext()) {
            rawFunction4 = (RawFunction)object22.next();
            list.add(Triple.make(rawFunction4, rawFunction4.getMatchedFunction(), (Object)EExistence.REMOVED));
        }
    }

    private void updateBorders(int n2, int n3, int n4, int n5) {
        this.incomingBorder.setTitle(String.format(INCOMING_CALLS_BORDER_TEXT, n2, n3));
        this.outgoingBorder.setTitle(String.format(OUTGOING_CALLS_BORDER_TEXT, n4, n5));
        this.updateUI();
    }

    public void dispose() {
        this.matchedfunctionViewsTable.removeListener(this.matchedFunctionViewsSelectionListener);
    }

    static /* synthetic */ void access$100(AddedAndRemovedCalledFunctionsPanel addedAndRemovedCalledFunctionsPanel, IAddress iAddress, IAddress iAddress2, ECallDirection eCallDirection, List list) {
        addedAndRemovedCalledFunctionsPanel.getSecondaryFunctionCallChanges(iAddress, iAddress2, eCallDirection, list);
    }

    static /* synthetic */ ExtendedMatchedFunctionViewsTable access$200(AddedAndRemovedCalledFunctionsPanel addedAndRemovedCalledFunctionsPanel) {
        return addedAndRemovedCalledFunctionsPanel.outgoingFunctionsCalledTable;
    }

    static /* synthetic */ ExtendedMatchedFunctionViewsTable access$300(AddedAndRemovedCalledFunctionsPanel addedAndRemovedCalledFunctionsPanel) {
        return addedAndRemovedCalledFunctionsPanel.incomingFunctionsCalledTable;
    }

    static /* synthetic */ void access$400(AddedAndRemovedCalledFunctionsPanel addedAndRemovedCalledFunctionsPanel, int n2, int n3, int n4, int n5) {
        addedAndRemovedCalledFunctionsPanel.updateBorders(n2, n3, n4, n5);
    }
}

