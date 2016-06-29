/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel;

import com.google.security.zynamics.bindiff.enums.EDiffViewMode;
import com.google.security.zynamics.bindiff.enums.EGraphLayout;

class ViewTabPanelFunctions$1 {
    static final /* synthetic */ int[] $SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode;
    static final /* synthetic */ int[] $SwitchMap$com$google$security$zynamics$bindiff$enums$EGraphLayout;

    static {
        $SwitchMap$com$google$security$zynamics$bindiff$enums$EGraphLayout = new int[EGraphLayout.values().length];
        try {
            ViewTabPanelFunctions$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EGraphLayout[EGraphLayout.CIRCULAR.ordinal()] = 1;
        }
        catch (NoSuchFieldError var0) {
            // empty catch block
        }
        try {
            ViewTabPanelFunctions$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EGraphLayout[EGraphLayout.HIERARCHICAL.ordinal()] = 2;
        }
        catch (NoSuchFieldError var0_1) {
            // empty catch block
        }
        try {
            ViewTabPanelFunctions$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EGraphLayout[EGraphLayout.ORTHOGONAL.ordinal()] = 3;
        }
        catch (NoSuchFieldError var0_2) {
            // empty catch block
        }
        $SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode = new int[EDiffViewMode.values().length];
        try {
            ViewTabPanelFunctions$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode[EDiffViewMode.NORMAL_VIEW.ordinal()] = 1;
        }
        catch (NoSuchFieldError var0_3) {
            // empty catch block
        }
        try {
            ViewTabPanelFunctions$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode[EDiffViewMode.COMBINED_VIEW.ordinal()] = 2;
            return;
        }
        catch (NoSuchFieldError var0_4) {
            // empty catch block
        }
    }
}

