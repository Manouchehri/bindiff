/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedInputStream$RefillCallback;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

class CodedInputStream$SkippedDataSink
implements CodedInputStream$RefillCallback {
    private int lastPos;
    private ByteArrayOutputStream byteArrayStream;
    final /* synthetic */ CodedInputStream this$0;

    private CodedInputStream$SkippedDataSink(CodedInputStream codedInputStream) {
        this.this$0 = codedInputStream;
        this.lastPos = CodedInputStream.access$000(this.this$0);
    }

    @Override
    public void onRefill() {
        if (this.byteArrayStream == null) {
            this.byteArrayStream = new ByteArrayOutputStream();
        }
        this.byteArrayStream.write(CodedInputStream.access$100(this.this$0), this.lastPos, CodedInputStream.access$000(this.this$0) - this.lastPos);
        this.lastPos = 0;
    }

    ByteBuffer getSkippedData() {
        if (this.byteArrayStream == null) {
            return ByteBuffer.wrap(CodedInputStream.access$100(this.this$0), this.lastPos, CodedInputStream.access$000(this.this$0) - this.lastPos);
        }
        this.byteArrayStream.write(CodedInputStream.access$100(this.this$0), this.lastPos, CodedInputStream.access$000(this.this$0));
        return ByteBuffer.wrap(this.byteArrayStream.toByteArray());
    }
}

