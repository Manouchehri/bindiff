package com.google.security.zynamics.bindiff.graph.backgroundrendering;

import com.google.security.zynamics.bindiff.enums.*;

class BackgroundRendererManager$1
{
    static {
        $SwitchMap$com$google$security$zynamics$bindiff$enums$EGraph = new int[EGraph.values().length];
        try {
            BackgroundRendererManager$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EGraph[EGraph.PRIMARY_GRAPH.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            BackgroundRendererManager$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EGraph[EGraph.SECONDARY_GRAPH.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            BackgroundRendererManager$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EGraph[EGraph.COMBINED_GRAPH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
    }
}
