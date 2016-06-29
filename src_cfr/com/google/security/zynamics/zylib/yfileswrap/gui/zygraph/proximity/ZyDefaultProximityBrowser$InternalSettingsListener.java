/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.AbstractZyGraphSettings;
import com.google.security.zynamics.zylib.gui.zygraph.settings.IProximitySettings;
import com.google.security.zynamics.zylib.gui.zygraph.settings.IProximitySettingsListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser$1;

class ZyDefaultProximityBrowser$InternalSettingsListener
implements IProximitySettingsListener {
    final /* synthetic */ ZyDefaultProximityBrowser this$0;

    private ZyDefaultProximityBrowser$InternalSettingsListener(ZyDefaultProximityBrowser zyDefaultProximityBrowser) {
        this.this$0 = zyDefaultProximityBrowser;
    }

    @Override
    public void changedProximityBrowsing(boolean bl2) {
        ZyDefaultProximityBrowser.access$302(this.this$0, true);
        ZyDefaultProximityBrowser.access$400(this.this$0);
        ZyDefaultProximityBrowser.access$302(this.this$0, false);
        ZyDefaultProximityBrowser.access$500(this.this$0).updateViews();
    }

    @Override
    public void changedProximityBrowsingDepth(int n2, int n3) {
        if (!ZyDefaultProximityBrowser.access$500(this.this$0).getSettings().getProximitySettings().getProximityBrowsing()) return;
        ZyDefaultProximityBrowser.access$600(this.this$0);
    }

    @Override
    public void changedProximityBrowsingFrozen(boolean bl2) {
    }

    @Override
    public void changedProximityBrowsingPreview(boolean bl2) {
    }

    /* synthetic */ ZyDefaultProximityBrowser$InternalSettingsListener(ZyDefaultProximityBrowser zyDefaultProximityBrowser, ZyDefaultProximityBrowser$1 zyDefaultProximityBrowser$1) {
        this(zyDefaultProximityBrowser);
    }
}

