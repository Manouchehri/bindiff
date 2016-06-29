package com.google.common.collect;

import java.util.*;

final class MultimapBuilder$4 extends MultimapBuilder$MultimapBuilderWithKeys
{
    final /* synthetic */ Class val$keyClass;
    
    MultimapBuilder$4(final Class val$keyClass) {
        this.val$keyClass = val$keyClass;
    }
    
    @Override
    Map createMap() {
        return new EnumMap(this.val$keyClass);
    }
}
