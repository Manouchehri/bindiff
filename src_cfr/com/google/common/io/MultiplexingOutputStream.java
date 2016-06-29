/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.io.MultiplexingOutputStream$1;
import com.google.common.io.MultiplexingOutputStream$2;
import com.google.common.io.MultiplexingOutputStream$3;
import com.google.common.io.MultiplexingOutputStream$4;
import com.google.common.io.MultiplexingOutputStream$5;
import com.google.common.io.MultiplexingOutputStream$MultiplexingIOException;
import com.google.common.io.MultiplexingOutputStream$OutputStreamCaller;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@GoogleInternal
public final class MultiplexingOutputStream
extends OutputStream {
    private final List streams;

    public /* varargs */ MultiplexingOutputStream(OutputStream ... arroutputStream) {
        this(Arrays.asList(arroutputStream));
    }

    public MultiplexingOutputStream(Iterable iterable) {
        Preconditions.checkNotNull(iterable);
        this.streams = new ArrayList();
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            OutputStream outputStream = (OutputStream)iterator.next();
            this.streams.add(Preconditions.checkNotNull(outputStream));
        }
    }

    @Override
    public void close() {
        this.runOnStreams(new MultiplexingOutputStream$1(this));
    }

    @Override
    public void flush() {
        this.runOnStreams(new MultiplexingOutputStream$2(this));
    }

    @Override
    public void write(byte[] arrby) {
        Preconditions.checkNotNull(arrby);
        this.runOnStreams(new MultiplexingOutputStream$3(this, arrby));
    }

    @Override
    public void write(byte[] arrby, int n2, int n3) {
        Preconditions.checkNotNull(arrby);
        this.runOnStreams(new MultiplexingOutputStream$4(this, arrby, n2, n3));
    }

    @Override
    public void write(int n2) {
        this.runOnStreams(new MultiplexingOutputStream$5(this, n2));
    }

    private void runOnStreams(MultiplexingOutputStream$OutputStreamCaller multiplexingOutputStream$OutputStreamCaller) {
        ArrayList<IOException> arrayList = new ArrayList<IOException>(0);
        Iterator iterator = this.streams.iterator();
        do {
            if (!iterator.hasNext()) {
                if (arrayList.isEmpty()) return;
                throw new MultiplexingOutputStream$MultiplexingIOException(arrayList);
            }
            OutputStream outputStream = (OutputStream)iterator.next();
            try {
                multiplexingOutputStream$OutputStreamCaller.call(outputStream);
            }
            catch (IOException var5_5) {
                arrayList.add(var5_5);
                continue;
            }
            break;
        } while (true);
    }
}

