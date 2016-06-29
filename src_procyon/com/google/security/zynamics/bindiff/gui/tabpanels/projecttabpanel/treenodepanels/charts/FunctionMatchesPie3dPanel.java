package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import javax.swing.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.enums.*;
import org.jfree.data.general.*;
import com.google.security.zynamics.bindiff.resources.*;
import org.jfree.chart.labels.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import org.jfree.chart.*;

public class FunctionMatchesPie3dPanel extends JPanel
{
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
    
    public FunctionMatchesPie3dPanel(final Diff diff) {
        super(new BorderLayout());
        Preconditions.checkNotNull(diff);
        final MatchData matches = diff.getMatches();
        this.matchedCount = matches.getSizeOfMatchedFunctions();
        this.primaryUnmatchedCount = matches.getSizeOfUnmatchedFunctions(ESide.PRIMARY);
        this.secondaryUnmatchedCount = matches.getSizeOfUnmatchedFunctions(ESide.SECONDARY);
        final int n = this.matchedCount + this.primaryUnmatchedCount + this.secondaryUnmatchedCount;
        this.matchedPercent = this.matchedCount / n * 100.0;
        this.primaryUnmatchedPercent = this.primaryUnmatchedCount / n * 100.0;
        this.secondaryUnmatchedPercent = this.secondaryUnmatchedCount / n * 100.0;
        final DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
        defaultPieDataset.setValue("Matched Functions", this.matchedPercent);
        defaultPieDataset.setValue("Primary unmatched Functions", this.primaryUnmatchedPercent);
        defaultPieDataset.setValue("Secondary unmatched Functions", this.secondaryUnmatchedPercent);
        (this.piePanel = new Pie3dPanel(this.getTitle(), defaultPieDataset, new FunctionMatchesPie3dPanel$CustomLabelGenerator(this, null))).setSectionColor("Matched Functions", Colors.PIE_MATCHED);
        this.piePanel.setSectionColor("Primary unmatched Functions", Colors.PIE_PRIMARY_UNMATCHED);
        this.piePanel.setSectionColor("Secondary unmatched Functions", Colors.PIE_SECONDARY_UNMATCHED);
        this.piePanel.setTooltipGenerator(new FunctionMatchesPie3dPanel$CustomTooltipGenerator(this, null));
        this.add(this.piePanel, "Center");
    }
    
    private String getTitle() {
        if (Double.isNaN(this.matchedPercent)) {
            return "Functions";
        }
        return String.format("%s %.1f%s", "Functions", this.matchedPercent, "%");
    }
    
    public FunctionMatchesPie3dPanel(final DiffMetaData diffMetaData) {
        super(new BorderLayout());
        Preconditions.checkNotNull(diffMetaData);
        this.matchedCount = diffMetaData.getSizeOfMatchedFunctions();
        this.primaryUnmatchedCount = diffMetaData.getSizeOfUnmatchedFunctions(ESide.PRIMARY);
        this.secondaryUnmatchedCount = diffMetaData.getSizeOfUnmatchedFunctions(ESide.SECONDARY);
        final int n = this.matchedCount + this.primaryUnmatchedCount + this.secondaryUnmatchedCount;
        this.matchedPercent = this.matchedCount / n * 100.0;
        this.primaryUnmatchedPercent = this.primaryUnmatchedCount / n * 100.0;
        this.secondaryUnmatchedPercent = this.secondaryUnmatchedCount / n * 100.0;
        final DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
        defaultPieDataset.setValue("Matched Functions", this.matchedPercent);
        defaultPieDataset.setValue("Primary unmatched Functions", this.primaryUnmatchedPercent);
        defaultPieDataset.setValue("Secondary unmatched Functions", this.secondaryUnmatchedPercent);
        (this.piePanel = new Pie3dPanel(String.format("%s %.1f%s", "Functions", this.matchedPercent, "%"), defaultPieDataset, new FunctionMatchesPie3dPanel$CustomLabelGenerator(this, null))).setSectionColor("Matched Functions", Colors.PIE_MATCHED);
        this.piePanel.setSectionColor("Primary unmatched Functions", Colors.PIE_PRIMARY_UNMATCHED);
        this.piePanel.setSectionColor("Secondary unmatched Functions", Colors.PIE_SECONDARY_UNMATCHED);
        this.piePanel.setTooltipGenerator(new FunctionMatchesPie3dPanel$CustomTooltipGenerator(this, null));
        this.add(this.piePanel, "Center");
    }
    
    public JFreeChart getChart() {
        return this.piePanel.getChart();
    }
}
