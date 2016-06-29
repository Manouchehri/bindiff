package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import javax.swing.*;
import org.jfree.data.general.*;
import com.google.common.base.*;
import org.jfree.chart.labels.*;
import com.google.security.zynamics.bindiff.resources.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import org.jfree.chart.*;

class InstructionMatchesPie3dPanel$CustomTooltipGenerator implements PieToolTipGenerator
{
    final /* synthetic */ InstructionMatchesPie3dPanel this$0;
    
    private InstructionMatchesPie3dPanel$CustomTooltipGenerator(final InstructionMatchesPie3dPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public String generateToolTip(final PieDataset pieDataset, final Comparable comparable) {
        String s = null;
        if (pieDataset != null) {
            if (comparable.equals(InstructionMatchesPie3dPanel.PLOTS[0])) {
                s = String.format("%s %d (%.1f%s)", InstructionMatchesPie3dPanel.PLOTS[0], this.this$0.matchedCount, this.this$0.matchedPercent, "%");
            }
            else if (comparable.equals(InstructionMatchesPie3dPanel.PLOTS[1])) {
                s = String.format("%s %d (%.1f%s)", InstructionMatchesPie3dPanel.PLOTS[1], this.this$0.primaryUnmatchedCount, this.this$0.primaryUnmatchedPercent, "%");
            }
            else if (comparable.equals(InstructionMatchesPie3dPanel.PLOTS[2])) {
                s = String.format("%s %d (%.1f%s)", InstructionMatchesPie3dPanel.PLOTS[2], this.this$0.secondaryUnmatchedCount, this.this$0.secondaryUnmatchedPercent, "%");
            }
        }
        return s;
    }
}
