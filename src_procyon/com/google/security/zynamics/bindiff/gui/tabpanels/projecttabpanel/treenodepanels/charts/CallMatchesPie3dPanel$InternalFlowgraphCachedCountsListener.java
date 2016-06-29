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

class CallMatchesPie3dPanel$InternalFlowgraphCachedCountsListener extends DiffChangeAdapter
{
    final /* synthetic */ CallMatchesPie3dPanel this$0;
    
    private CallMatchesPie3dPanel$InternalFlowgraphCachedCountsListener(final CallMatchesPie3dPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void callsCountChanged() {
        this.this$0.updateDataset();
    }
}
