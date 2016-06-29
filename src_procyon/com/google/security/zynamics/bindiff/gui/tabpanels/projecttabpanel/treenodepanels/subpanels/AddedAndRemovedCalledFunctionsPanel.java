package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.common.base.*;
import java.awt.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.common.collect.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.zylib.disassembly.*;
import java.util.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.general.*;

public class AddedAndRemovedCalledFunctionsPanel extends JPanel
{
    private static String INCOMING_CALLS_BORDER_TEXT;
    private static String OUTGOING_CALLS_BORDER_TEXT;
    private final TitledBorder incomingBorder;
    private final TitledBorder outgoingBorder;
    private final ExtendedMatchedFunctionViewsTable incomingFunctionsCalledTable;
    private final ExtendedMatchedFunctionViewsTable outgoingFunctionsCalledTable;
    private final Diff diff;
    private final MatchedFunctionViewsTable matchedfunctionViewsTable;
    private final AddedAndRemovedCalledFunctionsPanel$InternalMatchedFunctionViewsTableListener matchedFunctionViewsSelectionListener;
    
    public AddedAndRemovedCalledFunctionsPanel(final Diff diff, final WorkspaceTabPanelFunctions workspaceTabPanelFunctions, final MatchedFunctionViewsTable matchedfunctionViewsTable) {
        super(new BorderLayout());
        this.incomingBorder = new TitledBorder(String.format(AddedAndRemovedCalledFunctionsPanel.INCOMING_CALLS_BORDER_TEXT, 0, 0));
        this.outgoingBorder = new TitledBorder(String.format(AddedAndRemovedCalledFunctionsPanel.OUTGOING_CALLS_BORDER_TEXT, 0, 0));
        this.matchedFunctionViewsSelectionListener = new AddedAndRemovedCalledFunctionsPanel$InternalMatchedFunctionViewsTableListener(this, null);
        Preconditions.checkNotNull(diff);
        Preconditions.checkNotNull(workspaceTabPanelFunctions);
        Preconditions.checkNotNull(matchedfunctionViewsTable);
        this.diff = diff;
        this.matchedfunctionViewsTable = matchedfunctionViewsTable;
        this.incomingFunctionsCalledTable = new ExtendedMatchedFunctionViewsTable(new ExtendedMatchedFunctionViewsTableModel(diff), workspaceTabPanelFunctions);
        this.outgoingFunctionsCalledTable = new ExtendedMatchedFunctionViewsTable(new ExtendedMatchedFunctionViewsTableModel(diff), workspaceTabPanelFunctions);
        this.matchedfunctionViewsTable.addListener(this.matchedFunctionViewsSelectionListener);
        this.add(this.createFunctionsCalledPanel(), "Center");
    }
    
    private JPanel createFunctionsCalledPanel() {
        final JPanel panel = new JPanel(new BorderLayout());
        final JSplitPane splitPane = new JSplitPane(0, true);
        splitPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        splitPane.setRightComponent(this.createOutgoingFunctionsCalledTable());
        splitPane.setLeftComponent(this.createIncomingFunctionsCalledPanel());
        splitPane.setOneTouchExpandable(true);
        splitPane.setResizeWeight(0.5);
        splitPane.setDividerLocation(0.5);
        panel.add(splitPane, "Center");
        return panel;
    }
    
    private JPanel createIncomingFunctionsCalledPanel() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(this.incomingBorder);
        panel.add(this.createTablePanel(this.incomingFunctionsCalledTable), "Center");
        return panel;
    }
    
    private JPanel createOutgoingFunctionsCalledTable() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(this.outgoingBorder);
        panel.add(this.createTablePanel(this.outgoingFunctionsCalledTable), "Center");
        return panel;
    }
    
    private JPanel createTablePanel(final AbstractTable abstractTable) {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(abstractTable), "Center");
        return panel;
    }
    
    private Multiset getFunctions(final RawFunction rawFunction, final ECallDirection eCallDirection) {
        final HashMultiset create = HashMultiset.create();
        for (final SingleViewEdge singleViewEdge : (eCallDirection == ECallDirection.INCOMING) ? rawFunction.getIncomingEdges() : rawFunction.getOutgoingEdges()) {
            create.add((eCallDirection == ECallDirection.INCOMING) ? singleViewEdge.getSource() : ((RawFunction)singleViewEdge.getTarget()));
        }
        return create;
    }
    
    private void getSecondaryFunctionCallChanges(final IAddress address, final IAddress address2, final ECallDirection eCallDirection, final List list) {
        final RawFunction function = this.diff.getCallgraph(ESide.PRIMARY).getFunction(address);
        final RawFunction function2 = this.diff.getCallgraph(ESide.SECONDARY).getFunction(address2);
        final Multiset functions = this.getFunctions(function, eCallDirection);
        final Multiset functions2 = this.getFunctions(function2, eCallDirection);
        final ArrayList<RawFunction> list2 = new ArrayList<RawFunction>();
        final ArrayList<RawFunction> list3 = new ArrayList<RawFunction>();
        for (final RawFunction rawFunction : functions2) {
            final RawFunction matchedFunction = rawFunction.getMatchedFunction();
            if (matchedFunction != null && functions.remove(matchedFunction)) {
                list2.add(matchedFunction);
                list3.add(rawFunction);
            }
        }
        functions2.removeAll(list3);
        for (final RawFunction rawFunction2 : functions2) {
            list.add(Triple.make(rawFunction2.getMatchedFunction(), rawFunction2, EExistence.ADDED));
        }
        functions.addAll(list2);
        functions2.addAll(list3);
        final ArrayList<RawFunction> list4 = new ArrayList<RawFunction>();
        for (final RawFunction rawFunction3 : functions) {
            final RawFunction matchedFunction2 = rawFunction3.getMatchedFunction();
            if (matchedFunction2 != null && functions2.remove(matchedFunction2)) {
                list4.add(rawFunction3);
            }
        }
        functions.removeAll(list4);
        for (final RawFunction rawFunction4 : functions) {
            list.add(Triple.make(rawFunction4, rawFunction4.getMatchedFunction(), EExistence.REMOVED));
        }
    }
    
    private void updateBorders(final int n, final int n2, final int n3, final int n4) {
        this.incomingBorder.setTitle(String.format(AddedAndRemovedCalledFunctionsPanel.INCOMING_CALLS_BORDER_TEXT, n, n2));
        this.outgoingBorder.setTitle(String.format(AddedAndRemovedCalledFunctionsPanel.OUTGOING_CALLS_BORDER_TEXT, n3, n4));
        this.updateUI();
    }
    
    public void dispose() {
        this.matchedfunctionViewsTable.removeListener(this.matchedFunctionViewsSelectionListener);
    }
    
    static {
        AddedAndRemovedCalledFunctionsPanel.INCOMING_CALLS_BORDER_TEXT = "+%d / -%d Added and removed Parent Functions calling the selected Functions";
        AddedAndRemovedCalledFunctionsPanel.OUTGOING_CALLS_BORDER_TEXT = "+%d / -%d Added and removed Child Functions called from the selected Functions";
    }
}
