/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph;

import com.google.security.zynamics.zylib.gui.zygraph.CGraphSettingsSynchronizer;
import com.google.security.zynamics.zylib.gui.zygraph.CGraphSettingsSynchronizer$1;
import com.google.security.zynamics.zylib.gui.zygraph.settings.IDisplaySettingsListener;

class CGraphSettingsSynchronizer$InternalSettingsListener
implements IDisplaySettingsListener {
    final /* synthetic */ CGraphSettingsSynchronizer this$0;

    private CGraphSettingsSynchronizer$InternalSettingsListener(CGraphSettingsSynchronizer cGraphSettingsSynchronizer) {
        this.this$0 = cGraphSettingsSynchronizer;
    }

    @Override
    public void changedMagnifyingGlass(boolean bl2) {
        CGraphSettingsSynchronizer.access$100(this.this$0).setMagnifyingMode(bl2);
    }

    /* synthetic */ CGraphSettingsSynchronizer$InternalSettingsListener(CGraphSettingsSynchronizer cGraphSettingsSynchronizer, CGraphSettingsSynchronizer$1 cGraphSettingsSynchronizer$1) {
        this(cGraphSettingsSynchronizer);
    }
}

