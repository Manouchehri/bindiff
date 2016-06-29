/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.detachedviewstabpanel;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EMatchType;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.detachedviewstabpanel.FunctionDiffViewTabPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.helpers.MatchesGetter;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class FunctionDiffViewTabPanel
extends ViewTabPanel {
    private static final ImageIcon FUNCTIONDIFF_IDENTICAL_MATCHED_ICON = ImageUtils.getImageIcon("data/tabicons/functiondiff-flowgraphs-identical-matched-tab.png");
    private static final ImageIcon FUNCTIONDIFF_INSTRUCTION_CHANGED_ONLY_ICON = ImageUtils.getImageIcon("data/tabicons/functiondiff-flowgraphs-changed-instructions-only-tab.png");
    private static final ImageIcon FUNCTIONDIFF_STRUTURAL_CHANGED_ICON = ImageUtils.getImageIcon("data/tabicons/functiondiff-flowgraphs_structural-changed-tab.png");
    private static final ImageIcon SAVED_FUNCTIONDIFF_IDENTICAL_MATCHED_ICON = ImageUtils.getImageIcon("data/tabicons/savedfunctiondiff-flowgraphs-identical-matched-tab.png");
    private static final ImageIcon SAVED_FUNCTIONDIFF_INSTRUCTION_CHANGED_ONLY_ICON = ImageUtils.getImageIcon("data/tabicons/savedfunctiondiffflowgraphs-changed-instructions-only-tab.png");
    private static final ImageIcon SAVED_FUNCTIONDIFF_STRUTURAL_CHANGED_ICON = ImageUtils.getImageIcon("data/tabicons/savedfunctiondiffflowgraphs_structural-changed-tab.png");
    private final FunctionMatchData functionMatch;
    private final Workspace workspace;

    public FunctionDiffViewTabPanel(MainWindow mainWindow, TabPanelManager tabPanelManager, Workspace workspace, Diff diff, FunctionMatchData functionMatchData, ViewData viewData) {
        super(mainWindow, tabPanelManager, workspace, diff, viewData);
        this.functionMatch = (FunctionMatchData)Preconditions.checkNotNull(functionMatchData);
        this.workspace = (Workspace)Preconditions.checkNotNull(workspace);
    }

    private boolean isSavedView() {
        if (!this.workspace.isLoaded()) return false;
        String string = this.getDiff().getMatchesDatabase().getParentFile().getParentFile().getParent();
        String string2 = this.workspace.getWorkspaceDirPath();
        return string.equals(string2);
    }

    @Override
    public Icon getIcon() {
        CombinedGraph combinedGraph = this.getView().getGraphs().getCombinedGraph();
        if (!this.getView().isFlowgraphView()) return null;
        EMatchType eMatchType = MatchesGetter.getFlowgraphsMatchType(combinedGraph, this.functionMatch);
        switch (FunctionDiffViewTabPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchType[eMatchType.ordinal()]) {
            case 1: {
                ImageIcon imageIcon;
                if (this.isSavedView()) {
                    imageIcon = SAVED_FUNCTIONDIFF_IDENTICAL_MATCHED_ICON;
                    return imageIcon;
                }
                imageIcon = FUNCTIONDIFF_IDENTICAL_MATCHED_ICON;
                return imageIcon;
            }
            case 2: {
                ImageIcon imageIcon;
                if (this.isSavedView()) {
                    imageIcon = SAVED_FUNCTIONDIFF_INSTRUCTION_CHANGED_ONLY_ICON;
                    return imageIcon;
                }
                imageIcon = FUNCTIONDIFF_INSTRUCTION_CHANGED_ONLY_ICON;
                return imageIcon;
            }
            case 3: {
                ImageIcon imageIcon;
                if (this.isSavedView()) {
                    imageIcon = SAVED_FUNCTIONDIFF_STRUTURAL_CHANGED_ICON;
                    return imageIcon;
                }
                imageIcon = FUNCTIONDIFF_STRUTURAL_CHANGED_ICON;
                return imageIcon;
            }
        }
        return null;
    }
}

