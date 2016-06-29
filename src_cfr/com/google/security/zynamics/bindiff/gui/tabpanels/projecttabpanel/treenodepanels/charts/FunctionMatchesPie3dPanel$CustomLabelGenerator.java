/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.FunctionMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.FunctionMatchesPie3dPanel$1;
import java.text.AttributedString;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.data.general.PieDataset;

class FunctionMatchesPie3dPanel$CustomLabelGenerator
implements PieSectionLabelGenerator {
    final /* synthetic */ FunctionMatchesPie3dPanel this$0;

    private FunctionMatchesPie3dPanel$CustomLabelGenerator(FunctionMatchesPie3dPanel functionMatchesPie3dPanel) {
        this.this$0 = functionMatchesPie3dPanel;
    }

    @Override
    public AttributedString generateAttributedSectionLabel(PieDataset pieDataset, Comparable comparable) {
        return null;
    }

    @Override
    public String generateSectionLabel(PieDataset pieDataset, Comparable comparable) {
        if (pieDataset == null) {
            return null;
        }
        if (comparable.equals("Matched Functions")) {
            return String.format("%d\n%.1f%s", FunctionMatchesPie3dPanel.access$200(this.this$0), FunctionMatchesPie3dPanel.access$300(this.this$0), "%");
        }
        if (comparable.equals("Primary unmatched Functions")) {
            return String.format("%d\n%.1f%s", FunctionMatchesPie3dPanel.access$400(this.this$0), FunctionMatchesPie3dPanel.access$500(this.this$0), "%");
        }
        if (!comparable.equals("Secondary unmatched Functions")) return null;
        return String.format("%d\n%.1f%s", FunctionMatchesPie3dPanel.access$600(this.this$0), FunctionMatchesPie3dPanel.access$700(this.this$0), "%");
    }

    /* synthetic */ FunctionMatchesPie3dPanel$CustomLabelGenerator(FunctionMatchesPie3dPanel functionMatchesPie3dPanel, FunctionMatchesPie3dPanel$1 functionMatchesPie3dPanel$1) {
        this(functionMatchesPie3dPanel);
    }
}

