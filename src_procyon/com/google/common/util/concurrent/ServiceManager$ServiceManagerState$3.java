package com.google.common.util.concurrent;

import com.google.common.base.*;
import java.util.*;

class ServiceManager$ServiceManagerState$3 implements Function
{
    final /* synthetic */ ServiceManager$ServiceManagerState this$0;
    
    ServiceManager$ServiceManagerState$3(final ServiceManager$ServiceManagerState this$0) {
        this.this$0 = this$0;
    }
    
    public Long apply(final Map.Entry entry) {
        return entry.getValue();
    }
}
