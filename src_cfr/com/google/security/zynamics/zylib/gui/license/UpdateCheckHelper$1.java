/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.license;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessHelperThread;
import com.google.security.zynamics.zylib.io.StreamUtils;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collection;
import java.util.Date;
import java.util.List;

final class UpdateCheckHelper$1
extends CEndlessHelperThread {
    final /* synthetic */ List val$lines;
    final /* synthetic */ URL val$checkUrl;

    UpdateCheckHelper$1(List list, URL uRL) {
        this.val$lines = list;
        this.val$checkUrl = uRL;
    }

    @Override
    protected void runExpensiveCommand() {
        long l2 = new Date().getTime();
        this.val$lines.addAll(StreamUtils.readLinesFromReader(new InputStreamReader(this.val$checkUrl.openStream())));
        long l3 = new Date().getTime() - l2;
        if (l3 >= 400) return;
        Thread.sleep(400 - l3);
    }
}

