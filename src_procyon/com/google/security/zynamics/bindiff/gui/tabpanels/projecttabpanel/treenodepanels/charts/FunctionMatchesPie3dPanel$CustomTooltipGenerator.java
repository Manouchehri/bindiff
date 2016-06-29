package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import javax.swing.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.enums.*;
import org.jfree.data.general.*;
import org.jfree.chart.labels.*;
import com.google.security.zynamics.bindiff.resources.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import org.jfree.chart.*;

class FunctionMatchesPie3dPanel$CustomTooltipGenerator implements PieToolTipGenerator
{
    final /* synthetic */ FunctionMatchesPie3dPanel this$0;
    
    private FunctionMatchesPie3dPanel$CustomTooltipGenerator(final FunctionMatchesPie3dPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public String generateToolTip(final PieDataset pieDataset, final Comparable comparable) {
        if (pieDataset == null) {
            return null;
        }
        if (comparable.equals("Matched Functions")) {
            return String.format("%s %d (%.1f%s)", "Matched Functions", this.this$0.matchedCount, this.this$0.matchedPercent, "%");
        }
        if (comparable.equals("Primary unmatched Functions")) {
            return String.format("%s %d (%.1f%s)", "Primary unmatched Functions", this.this$0.primaryUnmatchedCount, this.this$0.primaryUnmatchedPercent, "%");
        }
        if (comparable.equals("Secondary unmatched Functions")) {
            return String.format("%s %d (%.1f%s)", "Secondary unmatched Functions", this.this$0.secondaryUnmatchedCount, this.this$0.secondaryUnmatchedPercent, "%");
        }
        return null;
    }
}
