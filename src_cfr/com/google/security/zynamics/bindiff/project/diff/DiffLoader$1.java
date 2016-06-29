/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.diff;

import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.DiffLoader;
import com.google.security.zynamics.bindiff.project.diff.IDiffListener;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import java.util.Iterator;

class DiffLoader$1
implements Runnable {
    final /* synthetic */ Diff val$diff;
    final /* synthetic */ DiffLoader this$0;

    DiffLoader$1(DiffLoader diffLoader, Diff diff) {
        this.this$0 = diffLoader;
        this.val$diff = diff;
    }

    @Override
    public void run() {
        Iterator iterator = this.val$diff.getListener().iterator();
        while (iterator.hasNext()) {
            IDiffListener iDiffListener = (IDiffListener)iterator.next();
            iDiffListener.loadedDiff(this.val$diff);
        }
    }
}

