package com.google.common.collect;

import java.util.*;
import com.google.common.base.*;

class MultimapBuilder$MultimapBuilderWithKeys$5 extends MultimapBuilder$SortedSetMultimapBuilder
{
    final /* synthetic */ Comparator val$comparator;
    final /* synthetic */ MultimapBuilder$MultimapBuilderWithKeys this$0;
    
    MultimapBuilder$MultimapBuilderWithKeys$5(final MultimapBuilder$MultimapBuilderWithKeys this$0, final Comparator val$comparator) {
        this.this$0 = this$0;
        this.val$comparator = val$comparator;
    }
    
    @Override
    public SortedSetMultimap build() {
        return Multimaps.newSortedSetMultimap(this.this$0.createMap(), new MultimapBuilder$TreeSetSupplier(this.val$comparator));
    }
}
