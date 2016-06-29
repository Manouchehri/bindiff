package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings;

public enum ESettingsDialogType
{
    INITIAL_CALLGRAPH_SETTING("INITIAL_CALLGRAPH_SETTING", 0), 
    INITIAL_FLOWGRAPH_SETTINGS("INITIAL_FLOWGRAPH_SETTINGS", 1), 
    NON_INITIAL("NON_INITIAL", 2);
    
    private ESettingsDialogType(final String s, final int n) {
    }
}
