package com.google.common.io;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.nio.*;
import java.util.*;
import java.io.*;

@Beta
public final class CharStreams
{
    private static final int BUF_SIZE = 2048;
    
    public static long copy(final Readable readable, final Appendable appendable) {
        Preconditions.checkNotNull(readable);
        Preconditions.checkNotNull(appendable);
        final CharBuffer allocate = CharBuffer.allocate(2048);
        long n = 0L;
        while (readable.read(allocate) != -1) {
            allocate.flip();
            appendable.append(allocate);
            n += allocate.remaining();
            allocate.clear();
        }
        return n;
    }
    
    public static String toString(final Readable readable) {
        return toStringBuilder(readable).toString();
    }
    
    private static StringBuilder toStringBuilder(final Readable readable) {
        final StringBuilder sb = new StringBuilder();
        copy(readable, sb);
        return sb;
    }
    
    public static List readLines(final Readable readable) {
        final ArrayList<String> list = new ArrayList<String>();
        String line;
        while ((line = new LineReader(readable).readLine()) != null) {
            list.add(line);
        }
        return list;
    }
    
    public static Object readLines(final Readable readable, final LineProcessor lineProcessor) {
        Preconditions.checkNotNull(readable);
        Preconditions.checkNotNull(lineProcessor);
        String line;
        while ((line = new LineReader(readable).readLine()) != null && lineProcessor.processLine(line)) {}
        return lineProcessor.getResult();
    }
    
    public static void skipFully(final Reader reader, long n) {
        Preconditions.checkNotNull(reader);
        while (n > 0L) {
            final long skip = reader.skip(n);
            if (skip == 0L) {
                throw new EOFException();
            }
            n -= skip;
        }
    }
    
    public static Writer nullWriter() {
        return CharStreams$NullWriter.INSTANCE;
    }
    
    public static Writer asWriter(final Appendable appendable) {
        if (appendable instanceof Writer) {
            return (Writer)appendable;
        }
        return new AppendableWriter(appendable);
    }
    
    static Reader asReader(final Readable readable) {
        Preconditions.checkNotNull(readable);
        if (readable instanceof Reader) {
            return (Reader)readable;
        }
        return new CharStreams$1(readable);
    }
}
