package com.google.protobuf;

import java.nio.*;
import java.io.*;
import java.util.*;

class CodedInputStream$SkippedDataSink implements CodedInputStream$RefillCallback
{
    private int lastPos;
    private ByteArrayOutputStream byteArrayStream;
    final /* synthetic */ CodedInputStream this$0;
    
    private CodedInputStream$SkippedDataSink(final CodedInputStream this$0) {
        this.this$0 = this$0;
        this.lastPos = this.this$0.bufferPos;
    }
    
    public void onRefill() {
        if (this.byteArrayStream == null) {
            this.byteArrayStream = new ByteArrayOutputStream();
        }
        this.byteArrayStream.write(this.this$0.buffer, this.lastPos, this.this$0.bufferPos - this.lastPos);
        this.lastPos = 0;
    }
    
    ByteBuffer getSkippedData() {
        if (this.byteArrayStream == null) {
            return ByteBuffer.wrap(this.this$0.buffer, this.lastPos, this.this$0.bufferPos - this.lastPos);
        }
        this.byteArrayStream.write(this.this$0.buffer, this.lastPos, this.this$0.bufferPos);
        return ByteBuffer.wrap(this.byteArrayStream.toByteArray());
    }
}
