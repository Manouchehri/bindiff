/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.JumpMatchesPie3dPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.JumpMatchesPie3dPanel$CustomLabelGenerator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.JumpMatchesPie3dPanel$CustomTooltipGenerator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.JumpMatchesPie3dPanel$InternalFlowgraphCachedCountsListener;
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

public class JumpMatchesPie3dPanel
extends JPanel {
    private static final int MATCHED_JUMPS = 0;
    private static final int PRIMRAY_UNMATCHED_JUMPS = 1;
    private static final int SECONDARY_UNMATCHED_JUMPS = 2;
    private static final String[] PLOTS = new String[]{"Matched Jumps", "Primary unmatched Jumps", "Secondary unmatched Jumps"};
    private int matchedCount = 0;
    private int primaryUnmatchedCount = 0;
    private int secondaryUnmatchedCount = 0;
    private double matchedPercent = 0.0;
    private double primaryUnmatchedPercent = 0.0;
    private double secondaryUnmatchedPercent = 0.0;
    private final boolean includeUnmatchedFunctions;
    private final Diff diff;
    private final Pie3dPanel piePanel;
    private final DefaultPieDataset dataset = new DefaultPieDataset();
    private final JumpMatchesPie3dPanel$InternalFlowgraphCachedCountsListener changeListener;

    public JumpMatchesPie3dPanel(Diff diff, boolean bl2) {
        super(new BorderLayout());
        this.changeListener = new JumpMatchesPie3dPanel$InternalFlowgraphCachedCountsListener(this, null);
        this.diff = (Diff)Preconditions.checkNotNull(diff);
        this.includeUnmatchedFunctions = bl2;
        this.piePanel = new Pie3dPanel(this.getTitle(), this.dataset, new JumpMatchesPie3dPanel$CustomLabelGenerator(this, null));
        this.piePanel.setSectionColor(PLOTS[0], Colors.PIE_MATCHED);
        this.piePanel.setSectionColor(PLOTS[1], Colors.PIE_PRIMARY_UNMATCHED);
        this.piePanel.setSectionColor(PLOTS[2], Colors.PIE_SECONDARY_UNMATCHED);
        this.piePanel.setTooltipGenerator(new JumpMatchesPie3dPanel$CustomTooltipGenerator(this, null));
        this.add((Component)this.piePanel, "Center");
        if (!bl2) return;
        diff.getMetaData().addListener(this.changeListener);
        this.updateDataset();
    }

    private String getTitle() {
        if (!Double.isNaN(this.matchedPercent)) return String.format("%s %.1f%s", "Jumps", this.matchedPercent, "%");
        return "Jumps";
    }

    private void updateDataset() {
        if (!this.includeUnmatchedFunctions) return;
        MatchData matchData = this.diff.getMatches();
        this.matchedCount = matchData.getSizeOfMatchedJumps();
        this.primaryUnmatchedCount = matchData.getSizeOfUnmatchedJumps(ESide.PRIMARY);
        this.secondaryUnmatchedCount = matchData.getSizeOfUnmatchedJumps(ESide.SECONDARY);
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
        if (!this.includeUnmatchedFunctions) return;
        this.diff.getMetaData().removeListener(this.changeListener);
    }

    public JFreeChart getChart() {
        return this.piePanel.getChart();
    }

    public void updateDataset(int n2, int n3, int n4) {
        if (this.includeUnmatchedFunctions) return;
        this.matchedCount = n2;
        this.primaryUnmatchedCount = n3;
        this.secondaryUnmatchedCount = n4;
        int n5 = this.matchedCount + this.primaryUnmatchedCount + this.secondaryUnmatchedCount;
        this.matchedPercent = (double)this.matchedCount / (double)n5 * 100.0;
        this.primaryUnmatchedPercent = (double)this.primaryUnmatchedCount / (double)n5 * 100.0;
        this.secondaryUnmatchedPercent = (double)this.secondaryUnmatchedCount / (double)n5 * 100.0;
        this.dataset.setValue((Comparable)((Object)PLOTS[0]), this.matchedPercent);
        this.dataset.setValue((Comparable)((Object)PLOTS[1]), this.primaryUnmatchedPercent);
        this.dataset.setValue((Comparable)((Object)PLOTS[2]), this.secondaryUnmatchedPercent);
        this.piePanel.setTitle(this.getTitle());
        this.piePanel.fireChartChanged();
    }

    static /* synthetic */ String[] access$300() {
        return PLOTS;
    }

    static /* synthetic */ int access$400(JumpMatchesPie3dPanel jumpMatchesPie3dPanel) {
        return jumpMatchesPie3dPanel.matchedCount;
    }

    static /* synthetic */ double access$500(JumpMatchesPie3dPanel jumpMatchesPie3dPanel) {
        return jumpMatchesPie3dPanel.matchedPercent;
    }

    static /* synthetic */ int access$600(JumpMatchesPie3dPanel jumpMatchesPie3dPanel) {
        return jumpMatchesPie3dPanel.primaryUnmatchedCount;
    }

    static /* synthetic */ double access$700(JumpMatchesPie3dPanel jumpMatchesPie3dPanel) {
        return jumpMatchesPie3dPanel.primaryUnmatchedPercent;
    }

    static /* synthetic */ int access$800(JumpMatchesPie3dPanel jumpMatchesPie3dPanel) {
        return jumpMatchesPie3dPanel.secondaryUnmatchedCount;
    }

    static /* synthetic */ double access$900(JumpMatchesPie3dPanel jumpMatchesPie3dPanel) {
        return jumpMatchesPie3dPanel.secondaryUnmatchedPercent;
    }

    static /* synthetic */ void access$1000(JumpMatchesPie3dPanel jumpMatchesPie3dPanel) {
        jumpMatchesPie3dPanel.updateDataset();
    }
}

