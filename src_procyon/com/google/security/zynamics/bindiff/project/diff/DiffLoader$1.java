package com.google.security.zynamics.bindiff.project.diff;

import java.util.*;

class DiffLoader$1 implements Runnable
{
    final /* synthetic */ Diff val$diff;
    final /* synthetic */ DiffLoader this$0;
    
    DiffLoader$1(final DiffLoader this$0, final Diff val$diff) {
        this.this$0 = this$0;
        this.val$diff = val$diff;
    }
    
    @Override
    public void run() {
        final Iterator iterator = this.val$diff.getListener().iterator();
        while (iterator.hasNext()) {
            iterator.next().loadedDiff(this.val$diff);
        }
    }
}
