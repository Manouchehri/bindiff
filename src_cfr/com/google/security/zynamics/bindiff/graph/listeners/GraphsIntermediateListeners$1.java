/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.listeners;

import com.google.security.zynamics.bindiff.enums.EGraph;

class GraphsIntermediateListeners$1 {
    static final /* synthetic */ int[] $SwitchMap$com$google$security$zynamics$bindiff$enums$EGraph;

    static {
        $SwitchMap$com$google$security$zynamics$bindiff$enums$EGraph = new int[EGraph.values().length];
        try {
            GraphsIntermediateListeners$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EGraph[EGraph.PRIMARY_GRAPH.ordinal()] = 1;
        }
        catch (NoSuchFieldError var0) {
            // empty catch block
        }
        try {
            GraphsIntermediateListeners$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EGraph[EGraph.SECONDARY_GRAPH.ordinal()] = 2;
        }
        catch (NoSuchFieldError var0_1) {
            // empty catch block
        }
        try {
            GraphsIntermediateListeners$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EGraph[EGraph.COMBINED_GRAPH.ordinal()] = 3;
        }
        catch (NoSuchFieldError var0_2) {
            // empty catch block
        }
        try {
            GraphsIntermediateListeners$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EGraph[EGraph.SUPER_GRAPH.ordinal()] = 4;
            return;
        }
        catch (NoSuchFieldError var0_3) {
            // empty catch block
        }
    }
}

