/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel;

import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.eventhandlers.GraphLayoutEventHandler;
import com.google.security.zynamics.bindiff.graph.helpers.GraphViewFitter;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.viewpanel.CNormalViewPanel;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessHelperThread;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditMode;
import java.awt.Dimension;
import y.h.ch;

public class ViewTabPanelInitializer {
    private static void configureScrollPanes(GraphsContainer graphsContainer) {
        boolean bl2 = graphsContainer.getSettings().getShowScrollbars();
        int n2 = 31;
        int n3 = 21;
        if (bl2) {
            n2 = 32;
            n3 = 22;
        }
        graphsContainer.getPrimaryGraph().getEditMode().setAdjustScrollBarPolicy(bl2);
        graphsContainer.getSecondaryGraph().getEditMode().setAdjustScrollBarPolicy(bl2);
        graphsContainer.getCombinedGraph().getEditMode().setAdjustScrollBarPolicy(bl2);
        graphsContainer.getPrimaryGraph().getView().setHorizontalScrollBarPolicy(n2);
        graphsContainer.getSecondaryGraph().getView().setHorizontalScrollBarPolicy(n2);
        graphsContainer.getCombinedGraph().getView().setHorizontalScrollBarPolicy(n2);
        graphsContainer.getPrimaryGraph().getView().setVerticalScrollBarPolicy(n3);
        graphsContainer.getSecondaryGraph().getView().setVerticalScrollBarPolicy(n3);
        graphsContainer.getCombinedGraph().getView().setVerticalScrollBarPolicy(n3);
    }

    private static void setDoubleBufferedGraphViews(GraphsContainer graphsContainer) {
        graphsContainer.getPrimaryGraph().getView().setDoubleBuffered(true);
        graphsContainer.getSecondaryGraph().getView().setDoubleBuffered(true);
        graphsContainer.getCombinedGraph().getView().setDoubleBuffered(true);
    }

    public static void centerCombinedGraph(GraphsContainer graphsContainer, ViewTabPanel viewTabPanel) {
        ch ch2 = graphsContainer.getCombinedGraph().getView();
        CNormalViewPanel cNormalViewPanel = viewTabPanel.getNormalViewPanel();
        int n2 = cNormalViewPanel.getSize().width;
        int n3 = cNormalViewPanel.getSize().height;
        long l2 = Math.round((double)n2 * (1.0 - GraphPanel.COMBINED_MAIN_DIVIDER_WIDTH));
        long l3 = Math.round(n3);
        ch2.setSize((int)l2, (int)l3);
        ch2.setPreferredSize(new Dimension((int)l2, (int)l3));
        ch2.fitWorldRect();
        ch2.fitContent();
        ch2.setZoom(graphsContainer.getCombinedGraph().getView().getZoom() * 0.95);
    }

    public static void centerSingleGraphs(SuperGraph superGraph) {
        GraphViewFitter.adoptSuperViewCanvasProperties(superGraph);
        GraphViewFitter.fitSingleViewToSuperViewContent(superGraph);
    }

    public static void initialize(GraphsContainer graphsContainer, CEndlessHelperThread cEndlessHelperThread) {
        cEndlessHelperThread.setDescription("Configure View...");
        ViewTabPanelInitializer.configureScrollPanes(graphsContainer);
        ViewTabPanelInitializer.setDoubleBufferedGraphViews(graphsContainer);
        cEndlessHelperThread.setDescription("Layouting graphs...");
        GraphLayoutEventHandler.handleInitialLayoutEvent(graphsContainer.getCombinedGraph());
    }
}

