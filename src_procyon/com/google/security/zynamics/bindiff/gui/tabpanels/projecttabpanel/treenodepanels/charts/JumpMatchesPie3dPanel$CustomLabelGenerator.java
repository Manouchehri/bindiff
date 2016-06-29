package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import java.text.*;
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

class JumpMatchesPie3dPanel$CustomLabelGenerator implements PieSectionLabelGenerator
{
    final /* synthetic */ JumpMatchesPie3dPanel this$0;
    
    private JumpMatchesPie3dPanel$CustomLabelGenerator(final JumpMatchesPie3dPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public AttributedString generateAttributedSectionLabel(final PieDataset pieDataset, final Comparable comparable) {
        return null;
    }
    
    @Override
    public String generateSectionLabel(final PieDataset pieDataset, final Comparable comparable) {
        String s = null;
        if (pieDataset != null) {
            if (comparable.equals(JumpMatchesPie3dPanel.PLOTS[0])) {
                s = String.format("%d\n%.1f%s", this.this$0.matchedCount, this.this$0.matchedPercent, "%");
            }
            else if (comparable.equals(JumpMatchesPie3dPanel.PLOTS[1])) {
                s = String.format("%d\n%.1f%s", this.this$0.primaryUnmatchedCount, this.this$0.primaryUnmatchedPercent, "%");
            }
            else if (comparable.equals(JumpMatchesPie3dPanel.PLOTS[2])) {
                s = String.format("%d\n%.1f%s", this.this$0.secondaryUnmatchedCount, this.this$0.secondaryUnmatchedPercent, "%");
            }
        }
        return s;
    }
}
