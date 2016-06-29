package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph;

import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import javax.swing.tree.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.*;
import com.google.security.zynamics.bindiff.graph.filter.*;
import java.util.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.helpers.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.utils.*;

public class CombinedFlowGraphBaseTreeNode extends AbstractBaseTreeNode
{
    private static final Icon MATCHED_IDENTICAL_FUNCTION_ICON;
    private static final Icon MATCHED_INSTRUCTIONCHANGED_FUNCTION_ICON;
    private static final Icon MATCHED_STRUCTURALCHANGED_FUNCTION_ICON;
    private static final Icon PRIMARY_UNMATCHED_FUNCTION_ICON;
    private static final Icon SECONDRAY_UNMATCHED_FUNCNTION_ICON;
    private final IMatchesChangeListener matchesChangeListener;
    private final List basicblockTreeNodes;
    private CombinedDiffNode lastSelectedTreeNode;
    
    public CombinedFlowGraphBaseTreeNode(final CombinedFlowGraphRootTreeNode combinedFlowGraphRootTreeNode) {
        super(combinedFlowGraphRootTreeNode);
        this.matchesChangeListener = new CombinedFlowGraphBaseTreeNode$InternalMatchesChangeListener(this, null);
        this.basicblockTreeNodes = new ArrayList();
        this.createChildren();
        this.getDiff().getMatches().addListener(this.matchesChangeListener);
    }
    
    @Override
    protected void delete() {
        this.getDiff().getMatches().removeListener(this.matchesChangeListener);
        super.delete();
    }
    
    @Override
    protected void updateTreeNodes(final boolean b) {
        final TreeNodeSearcher searcher = this.getSearcher();
        final GraphNodeMultiFilter filter = this.getFilter();
        final ArrayList<CombinedFlowGraphBasicBlockTreeNode> list = new ArrayList<CombinedFlowGraphBasicBlockTreeNode>();
        if (searcher.getUseTemporaryResults() && !"".equals(searcher.getSearchString())) {
            for (int i = 0; i < this.getChildCount(); ++i) {
                list.add((CombinedFlowGraphBasicBlockTreeNode)this.getChildAt(i));
            }
        }
        else {
            list.addAll((Collection<?>)this.basicblockTreeNodes);
        }
        this.removeAllChildren();
        final ArrayList list2 = new ArrayList();
        if (b) {
            if (!"".equals(searcher.getSearchString())) {
                final List search = searcher.search(list);
                list.clear();
                final Iterator<ISearchableTreeNode> iterator = search.iterator();
                while (iterator.hasNext()) {
                    list.add((CombinedFlowGraphBasicBlockTreeNode)iterator.next());
                }
            }
            else {
                searcher.search((List)null);
            }
        }
        final ArrayList<Object> list3 = new ArrayList<Object>();
        for (final CombinedFlowGraphBasicBlockTreeNode combinedFlowGraphBasicBlockTreeNode : list) {
            if (filter.filterRawCombinedBasicblock(combinedFlowGraphBasicBlockTreeNode.getCombinedBasicblock())) {
                if (!b && !"".equals(searcher.getSearchString())) {
                    if (!searcher.isSearchHit(combinedFlowGraphBasicBlockTreeNode.getCombinedDiffNode())) {
                        continue;
                    }
                    list3.add(combinedFlowGraphBasicBlockTreeNode);
                }
                else {
                    list3.add(combinedFlowGraphBasicBlockTreeNode);
                }
            }
        }
        final Iterator<Comparator<? super Object>> iterator3 = (Iterator<Comparator<? super Object>>)this.getRootNode().getSorter().getCombinedBasicblockTreeNodeComparatorList().iterator();
        while (iterator3.hasNext()) {
            Collections.sort(list3, iterator3.next());
        }
        final Iterator<CombinedFlowGraphBasicBlockTreeNode> iterator4 = list3.iterator();
        while (iterator4.hasNext()) {
            this.add(iterator4.next());
        }
        this.getTree().getModel().nodeStructureChanged(this);
        this.getTree().updateUI();
    }
    
    @Override
    public void createChildren() {
        final CombinedFlowGraphRootTreeNode rootNode = this.getRootNode();
        this.basicblockTreeNodes.clear();
        final Iterator iterator = rootNode.getGraph().getNodes().iterator();
        while (iterator.hasNext()) {
            this.basicblockTreeNodes.add(new CombinedFlowGraphBasicBlockTreeNode(rootNode, iterator.next()));
        }
        this.updateTreeNodes(false);
    }
    
    @Override
    public Icon getIcon() {
        final FlowGraphViewData view = this.getRootNode().getView();
        final RawFlowGraph rawGraph = view.getRawGraph(ESide.PRIMARY);
        final RawFlowGraph rawGraph2 = view.getRawGraph(ESide.SECONDARY);
        final RawFunction function = GraphGetter.getFunction(this.getDiff(), rawGraph);
        if (GraphGetter.getFunction(this.getDiff(), rawGraph2) == null) {
            return CombinedFlowGraphBaseTreeNode.PRIMARY_UNMATCHED_FUNCTION_ICON;
        }
        if (function == null) {
            return CombinedFlowGraphBaseTreeNode.SECONDRAY_UNMATCHED_FUNCNTION_ICON;
        }
        if (function.isChangedInstructionsOnlyMatch()) {
            return CombinedFlowGraphBaseTreeNode.MATCHED_INSTRUCTIONCHANGED_FUNCTION_ICON;
        }
        if (function.isChangedStructuralMatch()) {
            return CombinedFlowGraphBaseTreeNode.MATCHED_STRUCTURALCHANGED_FUNCTION_ICON;
        }
        return CombinedFlowGraphBaseTreeNode.MATCHED_IDENTICAL_FUNCTION_ICON;
    }
    
    public CombinedDiffNode getLastSelectedGraphNode() {
        return this.lastSelectedTreeNode;
    }
    
    @Override
    public JPopupMenu getPopupMenu() {
        final JPopupMenu popupMenu = new JPopupMenu();
        final JMenuItem menuItem = new JMenuItem(new CombinedFlowGraphBaseTreeNode$1(this, "Copy Primary Function Address"));
        final JMenuItem menuItem2 = new JMenuItem(new CombinedFlowGraphBaseTreeNode$2(this, "Copy Primary Function Name"));
        final JMenuItem menuItem3 = new JMenuItem(new CombinedFlowGraphBaseTreeNode$3(this, "Copy Secondary Function Address"));
        final JMenuItem menuItem4 = new JMenuItem(new CombinedFlowGraphBaseTreeNode$4(this, "Copy Secondary Function Name"));
        popupMenu.add(menuItem);
        popupMenu.add(menuItem2);
        popupMenu.add(menuItem3);
        popupMenu.add(menuItem4);
        return popupMenu;
    }
    
    @Override
    public CombinedFlowGraphRootTreeNode getRootNode() {
        return (CombinedFlowGraphRootTreeNode)this.getAbstractRootNode();
    }
    
    @Override
    public String getTooltipText() {
        return null;
    }
    
    @Override
    public void handleMouseEvent(final MouseEvent mouseEvent) {
        if (mouseEvent.isPopupTrigger()) {
            this.getPopupMenu().show(this.getTree(), mouseEvent.getX(), mouseEvent.getY());
        }
    }
    
    @Override
    public boolean isSelected() {
        return false;
    }
    
    @Override
    public boolean isVisible() {
        return true;
    }
    
    public void setLastSelectedGraphNode(final CombinedDiffNode lastSelectedTreeNode) {
        this.lastSelectedTreeNode = lastSelectedTreeNode;
    }
    
    @Override
    public String toString() {
        final FlowGraphViewData view = this.getRootNode().getView();
        final RawFlowGraph rawGraph = view.getRawGraph(ESide.PRIMARY);
        final RawFlowGraph rawGraph2 = view.getRawGraph(ESide.SECONDARY);
        String name = "missing";
        String name2 = "missing";
        if (rawGraph != null) {
            name = rawGraph.getName();
        }
        if (rawGraph2 != null) {
            name2 = rawGraph2.getName();
        }
        return String.format("%s \u2194 %s (%d / %d)", name, name2, this.getChildCount(), this.basicblockTreeNodes.size());
    }
    
    static {
        MATCHED_IDENTICAL_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/matched-functions.png");
        MATCHED_INSTRUCTIONCHANGED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/instructions-changed-function.png");
        MATCHED_STRUCTURALCHANGED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/structural-changed-function.png");
        PRIMARY_UNMATCHED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-functions.png");
        SECONDRAY_UNMATCHED_FUNCNTION_ICON = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-functions.png");
    }
}
