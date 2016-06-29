package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import java.text.*;
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

class FunctionMatchesPie3dPanel$CustomLabelGenerator implements PieSectionLabelGenerator
{
    final /* synthetic */ FunctionMatchesPie3dPanel this$0;
    
    private FunctionMatchesPie3dPanel$CustomLabelGenerator(final FunctionMatchesPie3dPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public AttributedString generateAttributedSectionLabel(final PieDataset pieDataset, final Comparable comparable) {
        return null;
    }
    
    @Override
    public String generateSectionLabel(final PieDataset pieDataset, final Comparable comparable) {
        if (pieDataset == null) {
            return null;
        }
        if (comparable.equals("Matched Functions")) {
            return String.format("%d\n%.1f%s", this.this$0.matchedCount, this.this$0.matchedPercent, "%");
        }
        if (comparable.equals("Primary unmatched Functions")) {
            return String.format("%d\n%.1f%s", this.this$0.primaryUnmatchedCount, this.this$0.primaryUnmatchedPercent, "%");
        }
        if (comparable.equals("Secondary unmatched Functions")) {
            return String.format("%d\n%.1f%s", this.this$0.secondaryUnmatchedCount, this.this$0.secondaryUnmatchedPercent, "%");
        }
        return null;
    }
}
