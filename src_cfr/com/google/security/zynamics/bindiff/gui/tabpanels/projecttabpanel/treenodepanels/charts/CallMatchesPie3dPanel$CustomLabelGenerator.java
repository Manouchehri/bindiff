/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.CallMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.CallMatchesPie3dPanel$1;
import java.text.AttributedString;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.data.general.PieDataset;

class CallMatchesPie3dPanel$CustomLabelGenerator
implements PieSectionLabelGenerator {
    final /* synthetic */ CallMatchesPie3dPanel this$0;

    private CallMatchesPie3dPanel$CustomLabelGenerator(CallMatchesPie3dPanel callMatchesPie3dPanel) {
        this.this$0 = callMatchesPie3dPanel;
    }

    @Override
    public AttributedString generateAttributedSectionLabel(PieDataset pieDataset, Comparable comparable) {
        return null;
    }

    @Override
    public String generateSectionLabel(PieDataset pieDataset, Comparable comparable) {
        String string = null;
        if (pieDataset == null) return string;
        if (comparable.equals(CallMatchesPie3dPanel.access$300()[0])) {
            return String.format("%d\n%.1f%s", CallMatchesPie3dPanel.access$400(this.this$0), CallMatchesPie3dPanel.access$500(this.this$0), "%");
        }
        if (comparable.equals(CallMatchesPie3dPanel.access$300()[1])) {
            return String.format("%d\n%.1f%s", CallMatchesPie3dPanel.access$600(this.this$0), CallMatchesPie3dPanel.access$700(this.this$0), "%");
        }
        if (!comparable.equals(CallMatchesPie3dPanel.access$300()[2])) return string;
        return String.format("%d\n%.1f%s", CallMatchesPie3dPanel.access$800(this.this$0), CallMatchesPie3dPanel.access$900(this.this$0), "%");
    }

    /* synthetic */ CallMatchesPie3dPanel$CustomLabelGenerator(CallMatchesPie3dPanel callMatchesPie3dPanel, CallMatchesPie3dPanel$1 callMatchesPie3dPanel$1) {
        this(callMatchesPie3dPanel);
    }
}

