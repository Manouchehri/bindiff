/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.io.AppendableWriter;
import com.google.common.io.CharStreams$1;
import com.google.common.io.CharStreams$NullWriter;
import com.google.common.io.LineProcessor;
import com.google.common.io.LineReader;
import java.io.EOFException;
import java.io.Reader;
import java.io.Writer;
import java.nio.Buffer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

@Beta
public final class CharStreams {
    private static final int BUF_SIZE = 2048;

    private CharStreams() {
    }

    public static long copy(Readable readable, Appendable appendable) {
        Preconditions.checkNotNull(readable);
        Preconditions.checkNotNull(appendable);
        CharBuffer charBuffer = CharBuffer.allocate(2048);
        long l2 = 0;
        while (readable.read(charBuffer) != -1) {
            charBuffer.flip();
            appendable.append(charBuffer);
            l2 += (long)charBuffer.remaining();
            charBuffer.clear();
        }
        return l2;
    }

    public static String toString(Readable readable) {
        return CharStreams.toStringBuilder(readable).toString();
    }

    private static StringBuilder toStringBuilder(Readable readable) {
        StringBuilder stringBuilder = new StringBuilder();
        CharStreams.copy(readable, stringBuilder);
        return stringBuilder;
    }

    public static List readLines(Readable readable) {
        String string;
        ArrayList<String> arrayList = new ArrayList<String>();
        LineReader lineReader = new LineReader(readable);
        while ((string = lineReader.readLine()) != null) {
            arrayList.add(string);
        }
        return arrayList;
    }

    public static Object readLines(Readable readable, LineProcessor lineProcessor) {
        String string;
        Preconditions.checkNotNull(readable);
        Preconditions.checkNotNull(lineProcessor);
        LineReader lineReader = new LineReader(readable);
        do {
            if ((string = lineReader.readLine()) == null) return lineProcessor.getResult();
        } while (lineProcessor.processLine(string));
        return lineProcessor.getResult();
    }

    public static void skipFully(Reader reader, long l2) {
        Preconditions.checkNotNull(reader);
        while (l2 > 0) {
            long l3 = reader.skip(l2);
            if (l3 == 0) {
                throw new EOFException();
            }
            l2 -= l3;
        }
    }

    public static Writer nullWriter() {
        return CharStreams$NullWriter.access$000();
    }

    public static Writer asWriter(Appendable appendable) {
        if (!(appendable instanceof Writer)) return new AppendableWriter(appendable);
        return (Writer)appendable;
    }

    static Reader asReader(Readable readable) {
        Preconditions.checkNotNull(readable);
        if (!(readable instanceof Reader)) return new CharStreams$1(readable);
        return (Reader)readable;
    }
}

