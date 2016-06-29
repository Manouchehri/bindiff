/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.CallMatchesPie3dPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.CallMatchesPie3dPanel$CustomLabelGenerator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.CallMatchesPie3dPanel$CustomTooltipGenerator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.CallMatchesPie3dPanel$InternalFlowgraphCachedCountsListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.Pie3dPanel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.ICountsChangeListener;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.resources.Colors;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.LayoutManager;
import javax.swing.JPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.PieToolTipGenerator;
import org.jfree.data.general.DefaultPieDataset;

public class CallMatchesPie3dPanel
extends JPanel {
    public static final int MATCHED_FUNCTIONS = 0;
    public static final int PRIMRAY_UNMATCHED_CALLS = 1;
    public static final int SECONDARY_UNMATCHED_CALLS = 2;
    private static final String[] PLOTS = new String[]{"Matched Calls", "Primary unmatched Calls", "Secondary unmatched Calls"};
    private int matchedCount;
    private int primaryUnmatchedCount;
    private int secondaryUnmatchedCount;
    private double matchedPercent;
    private double primaryUnmatchedPercent;
    private double secondaryUnmatchedPercent;
    private final Diff diff;
    private final Pie3dPanel piePanel;
    private final DefaultPieDataset dataset = new DefaultPieDataset();
    private final CallMatchesPie3dPanel$InternalFlowgraphCachedCountsListener changeListener;

    public CallMatchesPie3dPanel(Diff diff) {
        super(new BorderLayout());
        this.changeListener = new CallMatchesPie3dPanel$InternalFlowgraphCachedCountsListener(this, null);
        Preconditions.checkNotNull(diff);
        this.diff = diff;
        this.piePanel = new Pie3dPanel(this.getTitle(), this.dataset, new CallMatchesPie3dPanel$CustomLabelGenerator(this, null));
        this.piePanel.setSectionColor(PLOTS[0], Colors.PIE_MATCHED);
        this.piePanel.setSectionColor(PLOTS[1], Colors.PIE_PRIMARY_UNMATCHED);
        this.piePanel.setSectionColor(PLOTS[2], Colors.PIE_SECONDARY_UNMATCHED);
        this.piePanel.setTooltipGenerator(new CallMatchesPie3dPanel$CustomTooltipGenerator(this, null));
        this.add((Component)this.piePanel, "Center");
        this.updateDataset();
        diff.getMetaData().addListener(this.changeListener);
    }

    private String getTitle() {
        if (!Double.isNaN(this.matchedPercent)) return String.format("%s %.1f%s", "Calls", this.matchedPercent, "%");
        return "Calls";
    }

    private void updateDataset() {
        MatchData matchData = this.diff.getMatches();
        this.matchedCount = matchData.getSizeOfMatchedCalls();
        this.primaryUnmatchedCount = matchData.getSizeOfUnmatchedCalls(ESide.PRIMARY);
        this.secondaryUnmatchedCount = matchData.getSizeOfUnmatchedCalls(ESide.SECONDARY);
        int n2 = this.matchedCount + this.primaryUnmatchedCount + this.secondaryUnmatchedCount;
        this.matchedPercent = (double)this.matchedCount / (double)n2 * 100.0;
        this.primaryUnmatchedPercent = (double)this.primaryUnmatchedCount / (double)n2 * 100.0;
        this.secondaryUnmatchedPercent = (double)this.secondaryUnmatchedCount / (double)n2 * 100.0;
        this.dataset.setValue((Comparable)((Object)PLOTS[0]), this.matchedPercent);
        this.dataset.setValue((Comparable)((Object)PLOTS[1]), this.primaryUnmatchedPercent);
        this.dataset.setValue((Comparable)((Object)PLOTS[2]), this.secondaryUnmatchedPercent);
        this.piePanel.setTitle(this.getTitle());
        this.piePanel.fireChartChanged();
    }

    public void dispose() {
        this.diff.getMetaData().removeListener(this.changeListener);
    }

    public JFreeChart getChart() {
        return this.piePanel.getChart();
    }

    static /* synthetic */ String[] access$300() {
        return PLOTS;
    }

    static /* synthetic */ int access$400(CallMatchesPie3dPanel callMatchesPie3dPanel) {
        return callMatchesPie3dPanel.matchedCount;
    }

    static /* synthetic */ double access$500(CallMatchesPie3dPanel callMatchesPie3dPanel) {
        return callMatchesPie3dPanel.matchedPercent;
    }

    static /* synthetic */ int access$600(CallMatchesPie3dPanel callMatchesPie3dPanel) {
        return callMatchesPie3dPanel.primaryUnmatchedCount;
    }

    static /* synthetic */ double access$700(CallMatchesPie3dPanel callMatchesPie3dPanel) {
        return callMatchesPie3dPanel.primaryUnmatchedPercent;
    }

    static /* synthetic */ int access$800(CallMatchesPie3dPanel callMatchesPie3dPanel) {
        return callMatchesPie3dPanel.secondaryUnmatchedCount;
    }

    static /* synthetic */ double access$900(CallMatchesPie3dPanel callMatchesPie3dPanel) {
        return callMatchesPie3dPanel.secondaryUnmatchedPercent;
    }

    static /* synthetic */ void access$1000(CallMatchesPie3dPanel callMatchesPie3dPanel) {
        callMatchesPie3dPanel.updateDataset();
    }
}

