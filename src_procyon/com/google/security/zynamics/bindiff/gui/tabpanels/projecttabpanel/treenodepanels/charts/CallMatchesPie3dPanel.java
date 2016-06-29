package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import javax.swing.*;
import org.jfree.data.general.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.resources.*;
import org.jfree.chart.labels.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import org.jfree.chart.*;

public class CallMatchesPie3dPanel extends JPanel
{
    public static final int MATCHED_FUNCTIONS = 0;
    public static final int PRIMRAY_UNMATCHED_CALLS = 1;
    public static final int SECONDARY_UNMATCHED_CALLS = 2;
    private static final String[] PLOTS;
    private int matchedCount;
    private int primaryUnmatchedCount;
    private int secondaryUnmatchedCount;
    private double matchedPercent;
    private double primaryUnmatchedPercent;
    private double secondaryUnmatchedPercent;
    private final Diff diff;
    private final Pie3dPanel piePanel;
    private final DefaultPieDataset dataset;
    private final CallMatchesPie3dPanel$InternalFlowgraphCachedCountsListener changeListener;
    
    public CallMatchesPie3dPanel(final Diff diff) {
        super(new BorderLayout());
        this.dataset = new DefaultPieDataset();
        this.changeListener = new CallMatchesPie3dPanel$InternalFlowgraphCachedCountsListener(this, null);
        Preconditions.checkNotNull(diff);
        this.diff = diff;
        (this.piePanel = new Pie3dPanel(this.getTitle(), this.dataset, new CallMatchesPie3dPanel$CustomLabelGenerator(this, null))).setSectionColor(CallMatchesPie3dPanel.PLOTS[0], Colors.PIE_MATCHED);
        this.piePanel.setSectionColor(CallMatchesPie3dPanel.PLOTS[1], Colors.PIE_PRIMARY_UNMATCHED);
        this.piePanel.setSectionColor(CallMatchesPie3dPanel.PLOTS[2], Colors.PIE_SECONDARY_UNMATCHED);
        this.piePanel.setTooltipGenerator(new CallMatchesPie3dPanel$CustomTooltipGenerator(this, null));
        this.add(this.piePanel, "Center");
        this.updateDataset();
        diff.getMetaData().addListener(this.changeListener);
    }
    
    private String getTitle() {
        if (Double.isNaN(this.matchedPercent)) {
            return "Calls";
        }
        return String.format("%s %.1f%s", "Calls", this.matchedPercent, "%");
    }
    
    private void updateDataset() {
        final MatchData matches = this.diff.getMatches();
        this.matchedCount = matches.getSizeOfMatchedCalls();
        this.primaryUnmatchedCount = matches.getSizeOfUnmatchedCalls(ESide.PRIMARY);
        this.secondaryUnmatchedCount = matches.getSizeOfUnmatchedCalls(ESide.SECONDARY);
        final int n = this.matchedCount + this.primaryUnmatchedCount + this.secondaryUnmatchedCount;
        this.matchedPercent = this.matchedCount / n * 100.0;
        this.primaryUnmatchedPercent = this.primaryUnmatchedCount / n * 100.0;
        this.secondaryUnmatchedPercent = this.secondaryUnmatchedCount / n * 100.0;
        this.dataset.setValue(CallMatchesPie3dPanel.PLOTS[0], this.matchedPercent);
        this.dataset.setValue(CallMatchesPie3dPanel.PLOTS[1], this.primaryUnmatchedPercent);
        this.dataset.setValue(CallMatchesPie3dPanel.PLOTS[2], this.secondaryUnmatchedPercent);
        this.piePanel.setTitle(this.getTitle());
        this.piePanel.fireChartChanged();
    }
    
    public void dispose() {
        this.diff.getMetaData().removeListener(this.changeListener);
    }
    
    public JFreeChart getChart() {
        return this.piePanel.getChart();
    }
    
    static {
        PLOTS = new String[] { "Matched Calls", "Primary unmatched Calls", "Secondary unmatched Calls" };
    }
}
