package com.google.security.zynamics.zylib.gui.license;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.*;
import java.net.*;
import com.google.security.zynamics.zylib.io.*;
import java.io.*;
import java.util.*;

final class UpdateCheckHelper$1 extends CEndlessHelperThread
{
    final /* synthetic */ List val$lines;
    final /* synthetic */ URL val$checkUrl;
    
    UpdateCheckHelper$1(final List val$lines, final URL val$checkUrl) {
        this.val$lines = val$lines;
        this.val$checkUrl = val$checkUrl;
    }
    
    @Override
    protected void runExpensiveCommand() {
        final long time = new Date().getTime();
        this.val$lines.addAll(StreamUtils.readLinesFromReader(new InputStreamReader(this.val$checkUrl.openStream())));
        final long n = new Date().getTime() - time;
        if (n < 400L) {
            Thread.sleep(400L - n);
        }
    }
}
