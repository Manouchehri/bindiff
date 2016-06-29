package com.google.common.collect;

import java.util.*;

final class MultimapBuilder$1 extends MultimapBuilder$MultimapBuilderWithKeys
{
    final /* synthetic */ int val$expectedKeys;
    
    MultimapBuilder$1(final int val$expectedKeys) {
        this.val$expectedKeys = val$expectedKeys;
    }
    
    @Override
    Map createMap() {
        return Maps.newHashMapWithExpectedSize(this.val$expectedKeys);
    }
}
