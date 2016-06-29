package com.google.common.io;

import java.io.*;

class BaseEncoding$1 extends ByteSink
{
    final /* synthetic */ CharSink val$encodedSink;
    final /* synthetic */ BaseEncoding this$0;
    
    BaseEncoding$1(final BaseEncoding this$0, final CharSink val$encodedSink) {
        this.this$0 = this$0;
        this.val$encodedSink = val$encodedSink;
    }
    
    @Override
    public OutputStream openStream() {
        return this.this$0.encodingStream(this.val$encodedSink.openStream());
    }
}
