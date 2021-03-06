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

class BasicBlockMatchesPie3dPanel$CustomTooltipGenerator implements PieToolTipGenerator
{
    final /* synthetic */ BasicBlockMatchesPie3dPanel this$0;
    
    private BasicBlockMatchesPie3dPanel$CustomTooltipGenerator(final BasicBlockMatchesPie3dPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public String generateToolTip(final PieDataset pieDataset, final Comparable comparable) {
        if (pieDataset != null) {
            if (comparable.equals(BasicBlockMatchesPie3dPanel.PLOTS[0])) {
                return String.format("%s %d (%.1f%s)", BasicBlockMatchesPie3dPanel.PLOTS[0], this.this$0.matchedCount, this.this$0.matchedPercent, "%");
            }
            if (comparable.equals(BasicBlockMatchesPie3dPanel.PLOTS[1])) {
                return String.format("%s %d (%.1f%s)", BasicBlockMatchesPie3dPanel.PLOTS[1], this.this$0.primaryUnmatchedCount, this.this$0.primaryUnmatchedPercent, "%");
            }
            if (comparable.equals(BasicBlockMatchesPie3dPanel.PLOTS[2])) {
                return String.format("%s %d (%.1f%s)", BasicBlockMatchesPie3dPanel.PLOTS[2], this.this$0.secondaryUnmatchedCount, this.this$0.secondaryUnmatchedPercent, "%");
            }
        }
        return null;
    }
}
