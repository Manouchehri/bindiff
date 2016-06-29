package com.google.common.collect;

import java.util.*;

final class MultimapBuilder$3 extends MultimapBuilder$MultimapBuilderWithKeys
{
    final /* synthetic */ Comparator val$comparator;
    
    MultimapBuilder$3(final Comparator val$comparator) {
        this.val$comparator = val$comparator;
    }
    
    @Override
    Map createMap() {
        return new TreeMap(this.val$comparator);
    }
}
