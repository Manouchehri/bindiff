/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.FunctionMatchesPie3dPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.FunctionMatchesPie3dPanel$CustomLabelGenerator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.FunctionMatchesPie3dPanel$CustomTooltipGenerator;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.Pie3dPanel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
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

public class FunctionMatchesPie3dPanel
extends JPanel {
    private static final String MATCHED_FUNCTIONS = "Matched Functions";
    private static final String PRIMRAY_UNMATCHED_FUNCTIONS = "Primary unmatched Functions";
    private static final String SECONDARY_UNMATCHED_FUNCTIONS = "Secondary unmatched Functions";
    private final Pie3dPanel piePanel;
    private final int matchedCount;
    private final int primaryUnmatchedCount;
    private final int secondaryUnmatchedCount;
    private final double matchedPercent;
    private final double primaryUnmatchedPercent;
    private final double secondaryUnmatchedPercent;

    public FunctionMatchesPie3dPanel(Diff diff) {
        super(new BorderLayout());
        Preconditions.checkNotNull(diff);
        MatchData matchData = diff.getMatches();
        this.matchedCount = matchData.getSizeOfMatchedFunctions();
        this.primaryUnmatchedCount = matchData.getSizeOfUnmatchedFunctions(ESide.PRIMARY);
        this.secondaryUnmatchedCount = matchData.getSizeOfUnmatchedFunctions(ESide.SECONDARY);
        int n2 = this.matchedCount + this.primaryUnmatchedCount + this.secondaryUnmatchedCount;
        this.matchedPercent = (double)this.matchedCount / (double)n2 * 100.0;
        this.primaryUnmatchedPercent = (double)this.primaryUnmatchedCount / (double)n2 * 100.0;
        this.secondaryUnmatchedPercent = (double)this.secondaryUnmatchedCount / (double)n2 * 100.0;
        DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
        defaultPieDataset.setValue((Comparable)((Object)"Matched Functions"), this.matchedPercent);
        defaultPieDataset.setValue((Comparable)((Object)"Primary unmatched Functions"), this.primaryUnmatchedPercent);
        defaultPieDataset.setValue((Comparable)((Object)"Secondary unmatched Functions"), this.secondaryUnmatchedPercent);
        this.piePanel = new Pie3dPanel(this.getTitle(), defaultPieDataset, new FunctionMatchesPie3dPanel$CustomLabelGenerator(this, null));
        this.piePanel.setSectionColor("Matched Functions", Colors.PIE_MATCHED);
        this.piePanel.setSectionColor("Primary unmatched Functions", Colors.PIE_PRIMARY_UNMATCHED);
        this.piePanel.setSectionColor("Secondary unmatched Functions", Colors.PIE_SECONDARY_UNMATCHED);
        this.piePanel.setTooltipGenerator(new FunctionMatchesPie3dPanel$CustomTooltipGenerator(this, null));
        this.add((Component)this.piePanel, "Center");
    }

    private String getTitle() {
        if (!Double.isNaN(this.matchedPercent)) return String.format("%s %.1f%s", "Functions", this.matchedPercent, "%");
        return "Functions";
    }

    public FunctionMatchesPie3dPanel(DiffMetaData diffMetaData) {
        super(new BorderLayout());
        Preconditions.checkNotNull(diffMetaData);
        this.matchedCount = diffMetaData.getSizeOfMatchedFunctions();
        this.primaryUnmatchedCount = diffMetaData.getSizeOfUnmatchedFunctions(ESide.PRIMARY);
        this.secondaryUnmatchedCount = diffMetaData.getSizeOfUnmatchedFunctions(ESide.SECONDARY);
        int n2 = this.matchedCount + this.primaryUnmatchedCount + this.secondaryUnmatchedCount;
        this.matchedPercent = (double)this.matchedCount / (double)n2 * 100.0;
        this.primaryUnmatchedPercent = (double)this.primaryUnmatchedCount / (double)n2 * 100.0;
        this.secondaryUnmatchedPercent = (double)this.secondaryUnmatchedCount / (double)n2 * 100.0;
        DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
        defaultPieDataset.setValue((Comparable)((Object)"Matched Functions"), this.matchedPercent);
        defaultPieDataset.setValue((Comparable)((Object)"Primary unmatched Functions"), this.primaryUnmatchedPercent);
        defaultPieDataset.setValue((Comparable)((Object)"Secondary unmatched Functions"), this.secondaryUnmatchedPercent);
        this.piePanel = new Pie3dPanel(String.format("%s %.1f%s", "Functions", this.matchedPercent, "%"), defaultPieDataset, new FunctionMatchesPie3dPanel$CustomLabelGenerator(this, null));
        this.piePanel.setSectionColor("Matched Functions", Colors.PIE_MATCHED);
        this.piePanel.setSectionColor("Primary unmatched Functions", Colors.PIE_PRIMARY_UNMATCHED);
        this.piePanel.setSectionColor("Secondary unmatched Functions", Colors.PIE_SECONDARY_UNMATCHED);
        this.piePanel.setTooltipGenerator(new FunctionMatchesPie3dPanel$CustomTooltipGenerator(this, null));
        this.add((Component)this.piePanel, "Center");
    }

    public JFreeChart getChart() {
        return this.piePanel.getChart();
    }

    static /* synthetic */ int access$200(FunctionMatchesPie3dPanel functionMatchesPie3dPanel) {
        return functionMatchesPie3dPanel.matchedCount;
    }

    static /* synthetic */ double access$300(FunctionMatchesPie3dPanel functionMatchesPie3dPanel) {
        return functionMatchesPie3dPanel.matchedPercent;
    }

    static /* synthetic */ int access$400(FunctionMatchesPie3dPanel functionMatchesPie3dPanel) {
        return functionMatchesPie3dPanel.primaryUnmatchedCount;
    }

    static /* synthetic */ double access$500(FunctionMatchesPie3dPanel functionMatchesPie3dPanel) {
        return functionMatchesPie3dPanel.primaryUnmatchedPercent;
    }

    static /* synthetic */ int access$600(FunctionMatchesPie3dPanel functionMatchesPie3dPanel) {
        return functionMatchesPie3dPanel.secondaryUnmatchedCount;
    }

    static /* synthetic */ double access$700(FunctionMatchesPie3dPanel functionMatchesPie3dPanel) {
        return functionMatchesPie3dPanel.secondaryUnmatchedPercent;
    }
}

