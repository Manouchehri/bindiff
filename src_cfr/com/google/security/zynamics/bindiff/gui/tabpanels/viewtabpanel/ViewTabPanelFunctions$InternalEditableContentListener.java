/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions$1;
import com.google.security.zynamics.zylib.gui.zygraph.ILabelEditableContentListener;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;

class ViewTabPanelFunctions$InternalEditableContentListener
implements ILabelEditableContentListener {
    final /* synthetic */ ViewTabPanelFunctions this$0;

    private ViewTabPanelFunctions$InternalEditableContentListener(ViewTabPanelFunctions viewTabPanelFunctions) {
        this.this$0 = viewTabPanelFunctions;
    }

    @Override
    public void editableContentChanged(ZyLabelContent zyLabelContent) {
        ViewTabPanelFunctions.access$100(this.this$0, true);
    }

    /* synthetic */ ViewTabPanelFunctions$InternalEditableContentListener(ViewTabPanelFunctions viewTabPanelFunctions, ViewTabPanelFunctions$1 viewTabPanelFunctions$1) {
        this(viewTabPanelFunctions);
    }
}

