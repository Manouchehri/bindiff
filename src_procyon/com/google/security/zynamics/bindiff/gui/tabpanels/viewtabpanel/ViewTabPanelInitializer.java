package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.*;
import java.awt.*;
import y.h.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.viewpanel.*;
import com.google.security.zynamics.bindiff.graph.helpers.*;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.*;
import com.google.security.zynamics.bindiff.graph.eventhandlers.*;
import com.google.security.zynamics.bindiff.graph.*;

public class ViewTabPanelInitializer
{
    private static void configureScrollPanes(final GraphsContainer graphsContainer) {
        final boolean showScrollbars = graphsContainer.getSettings().getShowScrollbars();
        int horizontalScrollBarPolicy = 31;
        int verticalScrollBarPolicy = 21;
        if (showScrollbars) {
            horizontalScrollBarPolicy = 32;
            verticalScrollBarPolicy = 22;
        }
        graphsContainer.getPrimaryGraph().getEditMode().setAdjustScrollBarPolicy(showScrollbars);
        graphsContainer.getSecondaryGraph().getEditMode().setAdjustScrollBarPolicy(showScrollbars);
        graphsContainer.getCombinedGraph().getEditMode().setAdjustScrollBarPolicy(showScrollbars);
        graphsContainer.getPrimaryGraph().getView().setHorizontalScrollBarPolicy(horizontalScrollBarPolicy);
        graphsContainer.getSecondaryGraph().getView().setHorizontalScrollBarPolicy(horizontalScrollBarPolicy);
        graphsContainer.getCombinedGraph().getView().setHorizontalScrollBarPolicy(horizontalScrollBarPolicy);
        graphsContainer.getPrimaryGraph().getView().setVerticalScrollBarPolicy(verticalScrollBarPolicy);
        graphsContainer.getSecondaryGraph().getView().setVerticalScrollBarPolicy(verticalScrollBarPolicy);
        graphsContainer.getCombinedGraph().getView().setVerticalScrollBarPolicy(verticalScrollBarPolicy);
    }
    
    private static void setDoubleBufferedGraphViews(final GraphsContainer graphsContainer) {
        graphsContainer.getPrimaryGraph().getView().setDoubleBuffered(true);
        graphsContainer.getSecondaryGraph().getView().setDoubleBuffered(true);
        graphsContainer.getCombinedGraph().getView().setDoubleBuffered(true);
    }
    
    public static void centerCombinedGraph(final GraphsContainer graphsContainer, final ViewTabPanel viewTabPanel) {
        final ch view = graphsContainer.getCombinedGraph().getView();
        final CNormalViewPanel normalViewPanel = viewTabPanel.getNormalViewPanel();
        final int width = normalViewPanel.getSize().width;
        final int height = normalViewPanel.getSize().height;
        final long round = Math.round(width * (1.0 - GraphPanel.COMBINED_MAIN_DIVIDER_WIDTH));
        final long n = Math.round(height);
        view.setSize((int)round, (int)n);
        view.setPreferredSize(new Dimension((int)round, (int)n));
        view.fitWorldRect();
        view.fitContent();
        view.setZoom(graphsContainer.getCombinedGraph().getView().getZoom() * 0.95);
    }
    
    public static void centerSingleGraphs(final SuperGraph superGraph) {
        GraphViewFitter.adoptSuperViewCanvasProperties(superGraph);
        GraphViewFitter.fitSingleViewToSuperViewContent(superGraph);
    }
    
    public static void initialize(final GraphsContainer doubleBufferedGraphViews, final CEndlessHelperThread cEndlessHelperThread) {
        cEndlessHelperThread.setDescription("Configure View...");
        configureScrollPanes(doubleBufferedGraphViews);
        setDoubleBufferedGraphViews(doubleBufferedGraphViews);
        cEndlessHelperThread.setDescription("Layouting graphs...");
        GraphLayoutEventHandler.handleInitialLayoutEvent(doubleBufferedGraphViews.getCombinedGraph());
    }
}
