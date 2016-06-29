package com.google.security.zynamics.bindiff.gui.tabpanels.detachedviewstabpanel;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.bindiff.project.*;
import com.google.security.zynamics.bindiff.gui.window.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.common.base.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.project.helpers.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.utils.*;

public class FunctionDiffViewTabPanel extends ViewTabPanel
{
    private static final ImageIcon FUNCTIONDIFF_IDENTICAL_MATCHED_ICON;
    private static final ImageIcon FUNCTIONDIFF_INSTRUCTION_CHANGED_ONLY_ICON;
    private static final ImageIcon FUNCTIONDIFF_STRUTURAL_CHANGED_ICON;
    private static final ImageIcon SAVED_FUNCTIONDIFF_IDENTICAL_MATCHED_ICON;
    private static final ImageIcon SAVED_FUNCTIONDIFF_INSTRUCTION_CHANGED_ONLY_ICON;
    private static final ImageIcon SAVED_FUNCTIONDIFF_STRUTURAL_CHANGED_ICON;
    private final FunctionMatchData functionMatch;
    private final Workspace workspace;
    
    public FunctionDiffViewTabPanel(final MainWindow mainWindow, final TabPanelManager tabPanelManager, final Workspace workspace, final Diff diff, final FunctionMatchData functionMatchData, final ViewData viewData) {
        super(mainWindow, tabPanelManager, workspace, diff, viewData);
        this.functionMatch = (FunctionMatchData)Preconditions.checkNotNull(functionMatchData);
        this.workspace = (Workspace)Preconditions.checkNotNull(workspace);
    }
    
    private boolean isSavedView() {
        return this.workspace.isLoaded() && this.getDiff().getMatchesDatabase().getParentFile().getParentFile().getParent().equals(this.workspace.getWorkspaceDirPath());
    }
    
    @Override
    public Icon getIcon() {
        final CombinedGraph combinedGraph = this.getView().getGraphs().getCombinedGraph();
        if (!this.getView().isFlowgraphView()) {
            return null;
        }
        switch (FunctionDiffViewTabPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchType[MatchesGetter.getFlowgraphsMatchType(combinedGraph, this.functionMatch).ordinal()]) {
            case 1: {
                return this.isSavedView() ? FunctionDiffViewTabPanel.SAVED_FUNCTIONDIFF_IDENTICAL_MATCHED_ICON : FunctionDiffViewTabPanel.FUNCTIONDIFF_IDENTICAL_MATCHED_ICON;
            }
            case 2: {
                return this.isSavedView() ? FunctionDiffViewTabPanel.SAVED_FUNCTIONDIFF_INSTRUCTION_CHANGED_ONLY_ICON : FunctionDiffViewTabPanel.FUNCTIONDIFF_INSTRUCTION_CHANGED_ONLY_ICON;
            }
            case 3: {
                return this.isSavedView() ? FunctionDiffViewTabPanel.SAVED_FUNCTIONDIFF_STRUTURAL_CHANGED_ICON : FunctionDiffViewTabPanel.FUNCTIONDIFF_STRUTURAL_CHANGED_ICON;
            }
            default: {
                return null;
            }
        }
    }
    
    static {
        FUNCTIONDIFF_IDENTICAL_MATCHED_ICON = ImageUtils.getImageIcon("data/tabicons/functiondiff-flowgraphs-identical-matched-tab.png");
        FUNCTIONDIFF_INSTRUCTION_CHANGED_ONLY_ICON = ImageUtils.getImageIcon("data/tabicons/functiondiff-flowgraphs-changed-instructions-only-tab.png");
        FUNCTIONDIFF_STRUTURAL_CHANGED_ICON = ImageUtils.getImageIcon("data/tabicons/functiondiff-flowgraphs_structural-changed-tab.png");
        SAVED_FUNCTIONDIFF_IDENTICAL_MATCHED_ICON = ImageUtils.getImageIcon("data/tabicons/savedfunctiondiff-flowgraphs-identical-matched-tab.png");
        SAVED_FUNCTIONDIFF_INSTRUCTION_CHANGED_ONLY_ICON = ImageUtils.getImageIcon("data/tabicons/savedfunctiondiffflowgraphs-changed-instructions-only-tab.png");
        SAVED_FUNCTIONDIFF_STRUTURAL_CHANGED_ICON = ImageUtils.getImageIcon("data/tabicons/savedfunctiondiffflowgraphs_structural-changed-tab.png");
    }
}
