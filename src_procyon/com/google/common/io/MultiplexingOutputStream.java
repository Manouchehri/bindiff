package com.google.common.io;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;
import java.io.*;

@GoogleInternal
public final class MultiplexingOutputStream extends OutputStream
{
    private final List streams;
    
    public MultiplexingOutputStream(final OutputStream... array) {
        this(Arrays.asList(array));
    }
    
    public MultiplexingOutputStream(final Iterable iterable) {
        Preconditions.checkNotNull(iterable);
        this.streams = new ArrayList();
        final Iterator<OutputStream> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            this.streams.add(Preconditions.checkNotNull(iterator.next()));
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
    public void write(final byte[] array) {
        Preconditions.checkNotNull(array);
        this.runOnStreams(new MultiplexingOutputStream$3(this, array));
    }
    
    @Override
    public void write(final byte[] array, final int n, final int n2) {
        Preconditions.checkNotNull(array);
        this.runOnStreams(new MultiplexingOutputStream$4(this, array, n, n2));
    }
    
    @Override
    public void write(final int n) {
        this.runOnStreams(new MultiplexingOutputStream$5(this, n));
    }
    
    private void runOnStreams(final MultiplexingOutputStream$OutputStreamCaller multiplexingOutputStream$OutputStreamCaller) {
        final ArrayList<IOException> list = new ArrayList<IOException>(0);
        for (final OutputStream outputStream : this.streams) {
            try {
                multiplexingOutputStream$OutputStreamCaller.call(outputStream);
            }
            catch (IOException ex) {
                list.add(ex);
            }
        }
        if (!list.isEmpty()) {
            throw new MultiplexingOutputStream$MultiplexingIOException(list);
        }
    }
}
