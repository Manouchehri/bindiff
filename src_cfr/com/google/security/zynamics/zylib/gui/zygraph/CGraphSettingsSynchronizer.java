/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph;

import com.google.security.zynamics.zylib.gui.zygraph.AbstractZyGraphSettings;
import com.google.security.zynamics.zylib.gui.zygraph.CGraphSettingsSynchronizer$1;
import com.google.security.zynamics.zylib.gui.zygraph.CGraphSettingsSynchronizer$InternalSettingsListener;
import com.google.security.zynamics.zylib.gui.zygraph.settings.IDisplaySettings;
import com.google.security.zynamics.zylib.gui.zygraph.settings.IDisplaySettingsListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditMode;

public class CGraphSettingsSynchronizer {
    private final AbstractZyGraphSettings m_settings;
    private final ZyEditMode m_editMode;
    private final CGraphSettingsSynchronizer$InternalSettingsListener m_settingsListener;

    public CGraphSettingsSynchronizer(ZyEditMode zyEditMode, AbstractZyGraphSettings abstractZyGraphSettings) {
        this.m_settingsListener = new CGraphSettingsSynchronizer$InternalSettingsListener(this, null);
        this.m_editMode = zyEditMode;
        this.m_settings = abstractZyGraphSettings;
        this.m_settings.getDisplaySettings().addListener(this.m_settingsListener);
    }

    public void dispose() {
        this.m_settings.getDisplaySettings().removeListener(this.m_settingsListener);
    }

    static /* synthetic */ ZyEditMode access$100(CGraphSettingsSynchronizer cGraphSettingsSynchronizer) {
        return cGraphSettingsSynchronizer.m_editMode;
    }
}

