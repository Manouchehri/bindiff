package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

class Tables$TransformedTable$2 implements Function
{
    final /* synthetic */ Tables$TransformedTable this$0;
    
    Tables$TransformedTable$2(final Tables$TransformedTable this$0) {
        this.this$0 = this$0;
    }
    
    public Map apply(final Map map) {
        return Maps.transformValues(map, this.this$0.function);
    }
}
