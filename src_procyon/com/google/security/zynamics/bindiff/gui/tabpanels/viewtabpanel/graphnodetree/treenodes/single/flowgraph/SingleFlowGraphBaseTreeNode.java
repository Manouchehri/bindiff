package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph;

import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import java.util.*;
import javax.swing.tree.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.*;
import com.google.security.zynamics.bindiff.graph.filter.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.utils.*;

public class SingleFlowGraphBaseTreeNode extends AbstractBaseTreeNode
{
    private static final Icon MATCHED_IDENTICAL_FUNCTION_ICON;
    private static final Icon MATCHED_INSTRUCTIONCHANGED_FUNCTION_ICON;
    private static final Icon MATCHED_STRUCTURALCHANGED_FUNCTION_ICON;
    private static final Icon PRIMARY_UNMATCHED_FUNCTION_ICON;
    private static final Icon SECONDRAY_UNMATCHED_FUNCNTION_ICON;
    private final IMatchesChangeListener matchesChangeListener;
    private final List basicBlockTreeNodes;
    private SingleDiffNode lastSelectedTreeNode;
    
    public SingleFlowGraphBaseTreeNode(final SingleFlowGraphRootTreeNode singleFlowGraphRootTreeNode) {
        super(singleFlowGraphRootTreeNode);
        this.matchesChangeListener = new SingleFlowGraphBaseTreeNode$InternalMatchesChangeListener(this, null);
        this.basicBlockTreeNodes = new ArrayList();
        this.createChildren();
        this.getDiff().getMatches().addListener(this.matchesChangeListener);
    }
    
    private void replaceBasicblockTreeNode(final IAddress address) {
        SingleDiffNode singleDiffNode = null;
        for (final SingleDiffNode singleDiffNode2 : this.getRootNode().getGraph().getNodes()) {
            if (address.equals(singleDiffNode2.getRawNode().getAddress())) {
                singleDiffNode = singleDiffNode2;
                break;
            }
        }
        if (singleDiffNode != null) {
            for (int i = 0; i < this.getChildCount(); ++i) {
                final SingleFlowGraphBasicBlockTreeNode singleFlowGraphBasicBlockTreeNode = (SingleFlowGraphBasicBlockTreeNode)this.getChildAt(i);
                if (address.equals(singleFlowGraphBasicBlockTreeNode.getBasicblock().getAddress())) {
                    final SingleFlowGraphBasicBlockTreeNode singleFlowGraphBasicBlockTreeNode2 = new SingleFlowGraphBasicBlockTreeNode(this.getRootNode(), singleDiffNode);
                    this.insert(singleFlowGraphBasicBlockTreeNode2, i);
                    this.basicBlockTreeNodes.set(this.basicBlockTreeNodes.indexOf(singleFlowGraphBasicBlockTreeNode), singleFlowGraphBasicBlockTreeNode2);
                    break;
                }
            }
            this.updateTreeNodes(true);
        }
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
        final ArrayList<SingleFlowGraphBasicBlockTreeNode> list = new ArrayList<SingleFlowGraphBasicBlockTreeNode>();
        if (searcher.getUseTemporaryResults() && !"".equals(searcher.getSearchString())) {
            for (int i = 0; i < this.getChildCount(); ++i) {
                list.add((SingleFlowGraphBasicBlockTreeNode)this.getChildAt(i));
            }
        }
        else {
            list.addAll((Collection<?>)this.basicBlockTreeNodes);
        }
        this.removeAllChildren();
        final ArrayList list2 = new ArrayList();
        if (b) {
            if (!"".equals(searcher.getSearchString())) {
                final List search = searcher.search(list);
                list.clear();
                final Iterator<ISearchableTreeNode> iterator = search.iterator();
                while (iterator.hasNext()) {
                    list.add((SingleFlowGraphBasicBlockTreeNode)iterator.next());
                }
            }
            else {
                searcher.search((List)null);
            }
        }
        final ArrayList<Object> list3 = new ArrayList<Object>();
        for (final SingleFlowGraphBasicBlockTreeNode singleFlowGraphBasicBlockTreeNode : list) {
            if (filter.filterRawBasicblock(singleFlowGraphBasicBlockTreeNode.getBasicblock())) {
                if (!b && !"".equals(searcher.getSearchString())) {
                    if (!searcher.isSearchHit(singleFlowGraphBasicBlockTreeNode.getSingleDiffNode())) {
                        continue;
                    }
                    list3.add(singleFlowGraphBasicBlockTreeNode);
                }
                else {
                    list3.add(singleFlowGraphBasicBlockTreeNode);
                }
            }
        }
        final Iterator<Comparator<? super Object>> iterator3 = (Iterator<Comparator<? super Object>>)this.getRootNode().getSorter().getSingleBasicblockTreeNodeComparatorList().iterator();
        while (iterator3.hasNext()) {
            Collections.sort(list3, iterator3.next());
        }
        final Iterator<SingleFlowGraphBasicBlockTreeNode> iterator4 = list3.iterator();
        while (iterator4.hasNext()) {
            this.add(iterator4.next());
        }
        this.getTree().getModel().nodeStructureChanged(this);
        this.getTree().updateUI();
    }
    
    @Override
    public void createChildren() {
        this.basicBlockTreeNodes.clear();
        final SingleFlowGraphRootTreeNode rootNode = this.getRootNode();
        final Iterator<SingleDiffNode> iterator = this.getRootNode().getGraph().getNodes().iterator();
        while (iterator.hasNext()) {
            this.basicBlockTreeNodes.add(new SingleFlowGraphBasicBlockTreeNode(rootNode, iterator.next()));
        }
        this.updateTreeNodes(false);
    }
    
    @Override
    public Icon getIcon() {
        final FlowGraphViewData view = this.getRootNode().getView();
        final ESide side = this.getRootNode().getSide();
        final RawFunction function = this.getDiff().getCallgraph(side).getFunction(view.getRawGraph(side).getAddress());
        final EMatchState matchState = function.getMatchState();
        if (matchState == EMatchState.MATCHED) {
            final IAddress matchedFunctionAddress = function.getMatchedFunctionAddress();
            RawFunction function2;
            if (function.getSide() == ESide.PRIMARY) {
                function2 = function;
            }
            else {
                function2 = this.getDiff().getFunction(matchedFunctionAddress, ESide.PRIMARY);
            }
            if (function2.isIdenticalMatch()) {
                return SingleFlowGraphBaseTreeNode.MATCHED_IDENTICAL_FUNCTION_ICON;
            }
            if (function2.isChangedInstructionsOnlyMatch()) {
                return SingleFlowGraphBaseTreeNode.MATCHED_INSTRUCTIONCHANGED_FUNCTION_ICON;
            }
            if (function2.isChangedStructuralMatch()) {
                return SingleFlowGraphBaseTreeNode.MATCHED_STRUCTURALCHANGED_FUNCTION_ICON;
            }
        }
        else if (matchState == EMatchState.PRIMARY_UNMATCHED) {
            return SingleFlowGraphBaseTreeNode.PRIMARY_UNMATCHED_FUNCTION_ICON;
        }
        return SingleFlowGraphBaseTreeNode.SECONDRAY_UNMATCHED_FUNCNTION_ICON;
    }
    
    public SingleDiffNode getLastSelectedGraphNode() {
        return this.lastSelectedTreeNode;
    }
    
    @Override
    public JPopupMenu getPopupMenu() {
        final JPopupMenu popupMenu = new JPopupMenu();
        final ESide side = this.getRootNode().getSide();
        final JMenuItem menuItem = new JMenuItem(new SingleFlowGraphBaseTreeNode$1(this, "Copy Function Address", side));
        final JMenuItem menuItem2 = new JMenuItem(new SingleFlowGraphBaseTreeNode$2(this, "Copy Function Name", side));
        popupMenu.add(menuItem);
        popupMenu.add(menuItem2);
        return popupMenu;
    }
    
    @Override
    public SingleFlowGraphRootTreeNode getRootNode() {
        return (SingleFlowGraphRootTreeNode)this.getAbstractRootNode();
    }
    
    @Override
    public String getTooltipText() {
        return null;
    }
    
    @Override
    public boolean isSelected() {
        return false;
    }
    
    @Override
    public boolean isVisible() {
        return true;
    }
    
    public void setLastSelectedGraphNode(final SingleDiffNode lastSelectedTreeNode) {
        this.lastSelectedTreeNode = lastSelectedTreeNode;
    }
    
    @Override
    public String toString() {
        return String.format("%s (%d / %d)", this.getRootNode().getView().getRawGraph(this.getRootNode().getSide()).getName(), this.getChildCount(), this.basicBlockTreeNodes.size());
    }
    
    static {
        MATCHED_IDENTICAL_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/matched-functions.png");
        MATCHED_INSTRUCTIONCHANGED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/instructions-changed-function.png");
        MATCHED_STRUCTURALCHANGED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/structural-changed-function.png");
        PRIMARY_UNMATCHED_FUNCTION_ICON = ImageUtils.getImageIcon("data/treeicons/primary-unmatched-functions.png");
        SECONDRAY_UNMATCHED_FUNCNTION_ICON = ImageUtils.getImageIcon("data/treeicons/secondary-unmatched-functions.png");
    }
}
