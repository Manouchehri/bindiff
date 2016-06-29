package com.google.common.collect;

import java.util.*;

final class MultimapBuilder$2 extends MultimapBuilder$MultimapBuilderWithKeys
{
    final /* synthetic */ int val$expectedKeys;
    
    MultimapBuilder$2(final int val$expectedKeys) {
        this.val$expectedKeys = val$expectedKeys;
    }
    
    @Override
    Map createMap() {
        return Maps.newLinkedHashMapWithExpectedSize(this.val$expectedKeys);
    }
}
