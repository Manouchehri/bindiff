package com.google.security.zynamics.zylib.gui.zygraph;

import com.google.security.zynamics.zylib.gui.zygraph.settings.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.*;

class CGraphSettingsSynchronizer$InternalSettingsListener implements IDisplaySettingsListener
{
    final /* synthetic */ CGraphSettingsSynchronizer this$0;
    
    private CGraphSettingsSynchronizer$InternalSettingsListener(final CGraphSettingsSynchronizer this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void changedMagnifyingGlass(final boolean magnifyingMode) {
        this.this$0.m_editMode.setMagnifyingMode(magnifyingMode);
    }
}
