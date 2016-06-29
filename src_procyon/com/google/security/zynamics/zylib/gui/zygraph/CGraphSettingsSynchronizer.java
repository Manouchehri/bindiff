package com.google.security.zynamics.zylib.gui.zygraph;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.gui.zygraph.settings.*;

public class CGraphSettingsSynchronizer
{
    private final AbstractZyGraphSettings m_settings;
    private final ZyEditMode m_editMode;
    private final CGraphSettingsSynchronizer$InternalSettingsListener m_settingsListener;
    
    public CGraphSettingsSynchronizer(final ZyEditMode editMode, final AbstractZyGraphSettings settings) {
        this.m_settingsListener = new CGraphSettingsSynchronizer$InternalSettingsListener(this, null);
        this.m_editMode = editMode;
        this.m_settings = settings;
        this.m_settings.getDisplaySettings().addListener(this.m_settingsListener);
    }
    
    public void dispose() {
        this.m_settings.getDisplaySettings().removeListener(this.m_settingsListener);
    }
}
