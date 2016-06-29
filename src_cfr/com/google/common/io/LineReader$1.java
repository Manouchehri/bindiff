/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.io.LineBuffer;
import com.google.common.io.LineReader;

class LineReader$1
extends LineBuffer {
    final /* synthetic */ LineReader this$0;

    LineReader$1(LineReader lineReader) {
        this.this$0 = lineReader;
    }

    @Override
    protected void handleLine(String string, String string2) {
        LineReader.access$000(this.this$0).add(string);
    }
}

