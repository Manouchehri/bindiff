package com.google.common.io;

import java.io.*;

class BaseEncoding$2 extends ByteSource
{
    final /* synthetic */ CharSource val$encodedSource;
    final /* synthetic */ BaseEncoding this$0;
    
    BaseEncoding$2(final BaseEncoding this$0, final CharSource val$encodedSource) {
        this.this$0 = this$0;
        this.val$encodedSource = val$encodedSource;
    }
    
    @Override
    public InputStream openStream() {
        return this.this$0.decodingStream(this.val$encodedSource.openStream());
    }
}
