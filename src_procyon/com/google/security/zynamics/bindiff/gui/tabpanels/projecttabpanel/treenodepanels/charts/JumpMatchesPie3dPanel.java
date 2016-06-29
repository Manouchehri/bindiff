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

public class JumpMatchesPie3dPanel extends JPanel
{
    private static final int MATCHED_JUMPS = 0;
    private static final int PRIMRAY_UNMATCHED_JUMPS = 1;
    private static final int SECONDARY_UNMATCHED_JUMPS = 2;
    private static final String[] PLOTS;
    private int matchedCount;
    private int primaryUnmatchedCount;
    private int secondaryUnmatchedCount;
    private double matchedPercent;
    private double primaryUnmatchedPercent;
    private double secondaryUnmatchedPercent;
    private final boolean includeUnmatchedFunctions;
    private final Diff diff;
    private final Pie3dPanel piePanel;
    private final DefaultPieDataset dataset;
    private final JumpMatchesPie3dPanel$InternalFlowgraphCachedCountsListener changeListener;
    
    public JumpMatchesPie3dPanel(final Diff diff, final boolean includeUnmatchedFunctions) {
        super(new BorderLayout());
        this.matchedCount = 0;
        this.primaryUnmatchedCount = 0;
        this.secondaryUnmatchedCount = 0;
        this.matchedPercent = 0.0;
        this.primaryUnmatchedPercent = 0.0;
        this.secondaryUnmatchedPercent = 0.0;
        this.dataset = new DefaultPieDataset();
        this.changeListener = new JumpMatchesPie3dPanel$InternalFlowgraphCachedCountsListener(this, null);
        this.diff = (Diff)Preconditions.checkNotNull(diff);
        this.includeUnmatchedFunctions = includeUnmatchedFunctions;
        (this.piePanel = new Pie3dPanel(this.getTitle(), this.dataset, new JumpMatchesPie3dPanel$CustomLabelGenerator(this, null))).setSectionColor(JumpMatchesPie3dPanel.PLOTS[0], Colors.PIE_MATCHED);
        this.piePanel.setSectionColor(JumpMatchesPie3dPanel.PLOTS[1], Colors.PIE_PRIMARY_UNMATCHED);
        this.piePanel.setSectionColor(JumpMatchesPie3dPanel.PLOTS[2], Colors.PIE_SECONDARY_UNMATCHED);
        this.piePanel.setTooltipGenerator(new JumpMatchesPie3dPanel$CustomTooltipGenerator(this, null));
        this.add(this.piePanel, "Center");
        if (includeUnmatchedFunctions) {
            diff.getMetaData().addListener(this.changeListener);
            this.updateDataset();
        }
    }
    
    private String getTitle() {
        if (Double.isNaN(this.matchedPercent)) {
            return "Jumps";
        }
        return String.format("%s %.1f%s", "Jumps", this.matchedPercent, "%");
    }
    
    private void updateDataset() {
        if (this.includeUnmatchedFunctions) {
            final MatchData matches = this.diff.getMatches();
            this.matchedCount = matches.getSizeOfMatchedJumps();
            this.primaryUnmatchedCount = matches.getSizeOfUnmatchedJumps(ESide.PRIMARY);
            this.secondaryUnmatchedCount = matches.getSizeOfUnmatchedJumps(ESide.SECONDARY);
            final int n = this.matchedCount + this.primaryUnmatchedCount + this.secondaryUnmatchedCount;
            this.matchedPercent = this.matchedCount / n * 100.0;
            this.primaryUnmatchedPercent = this.primaryUnmatchedCount / n * 100.0;
            this.secondaryUnmatchedPercent = this.secondaryUnmatchedCount / n * 100.0;
            this.dataset.setValue(JumpMatchesPie3dPanel.PLOTS[0], this.matchedPercent);
            this.dataset.setValue(JumpMatchesPie3dPanel.PLOTS[1], this.primaryUnmatchedPercent);
            this.dataset.setValue(JumpMatchesPie3dPanel.PLOTS[2], this.secondaryUnmatchedPercent);
            this.piePanel.setTitle(this.getTitle());
            this.piePanel.fireChartChanged();
        }
    }
    
    public void dispose() {
        if (this.includeUnmatchedFunctions) {
            this.diff.getMetaData().removeListener(this.changeListener);
        }
    }
    
    public JFreeChart getChart() {
        return this.piePanel.getChart();
    }
    
    public void updateDataset(final int matchedCount, final int primaryUnmatchedCount, final int secondaryUnmatchedCount) {
        if (!this.includeUnmatchedFunctions) {
            this.matchedCount = matchedCount;
            this.primaryUnmatchedCount = primaryUnmatchedCount;
            this.secondaryUnmatchedCount = secondaryUnmatchedCount;
            final int n = this.matchedCount + this.primaryUnmatchedCount + this.secondaryUnmatchedCount;
            this.matchedPercent = this.matchedCount / n * 100.0;
            this.primaryUnmatchedPercent = this.primaryUnmatchedCount / n * 100.0;
            this.secondaryUnmatchedPercent = this.secondaryUnmatchedCount / n * 100.0;
            this.dataset.setValue(JumpMatchesPie3dPanel.PLOTS[0], this.matchedPercent);
            this.dataset.setValue(JumpMatchesPie3dPanel.PLOTS[1], this.primaryUnmatchedPercent);
            this.dataset.setValue(JumpMatchesPie3dPanel.PLOTS[2], this.secondaryUnmatchedPercent);
            this.piePanel.setTitle(this.getTitle());
            this.piePanel.fireChartChanged();
        }
    }
    
    static {
        PLOTS = new String[] { "Matched Jumps", "Primary unmatched Jumps", "Secondary unmatched Jumps" };
    }
}
