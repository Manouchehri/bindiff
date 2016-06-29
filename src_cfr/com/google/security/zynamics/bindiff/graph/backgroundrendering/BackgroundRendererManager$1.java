/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.backgroundrendering;

import com.google.security.zynamics.bindiff.enums.EGraph;

class BackgroundRendererManager$1 {
    static final /* synthetic */ int[] $SwitchMap$com$google$security$zynamics$bindiff$enums$EGraph;

    static {
        $SwitchMap$com$google$security$zynamics$bindiff$enums$EGraph = new int[EGraph.values().length];
        try {
            BackgroundRendererManager$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EGraph[EGraph.PRIMARY_GRAPH.ordinal()] = 1;
        }
        catch (NoSuchFieldError var0) {
            // empty catch block
        }
        try {
            BackgroundRendererManager$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EGraph[EGraph.SECONDARY_GRAPH.ordinal()] = 2;
        }
        catch (NoSuchFieldError var0_1) {
            // empty catch block
        }
        try {
            BackgroundRendererManager$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EGraph[EGraph.COMBINED_GRAPH.ordinal()] = 3;
            return;
        }
        catch (NoSuchFieldError var0_2) {
            // empty catch block
        }
    }
}

