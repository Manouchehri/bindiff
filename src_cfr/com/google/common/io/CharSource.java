/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource$CharSequenceCharSource;
import com.google.common.io.CharSource$ConcatenatedCharSource;
import com.google.common.io.CharSource$EmptyCharSource;
import com.google.common.io.CharStreams;
import com.google.common.io.Closer;
import com.google.common.io.LineProcessor;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.Nullable;

public abstract class CharSource {
    protected CharSource() {
    }

    public abstract Reader openStream();

    public BufferedReader openBufferedStream() {
        BufferedReader bufferedReader;
        Reader reader = this.openStream();
        if (reader instanceof BufferedReader) {
            bufferedReader = (BufferedReader)reader;
            return bufferedReader;
        }
        bufferedReader = new BufferedReader(reader);
        return bufferedReader;
    }

    @Beta
    public Optional lengthIfKnown() {
        return Optional.absent();
    }

    @Beta
    public long length() {
        Optional optional = this.lengthIfKnown();
        if (optional.isPresent()) {
            return (Long)optional.get();
        }
        Closer closer = Closer.create();
        try {
            Reader reader = (Reader)closer.register(this.openStream());
            long l2 = this.countBySkipping(reader);
            return l2;
        }
        catch (Throwable var3_4) {
            throw closer.rethrow(var3_4);
        }
        finally {
            closer.close();
        }
    }

    private long countBySkipping(Reader reader) {
        long l2;
        long l3 = 0;
        while ((l2 = reader.skip(Long.MAX_VALUE)) != 0) {
            l3 += l2;
        }
        return l3;
    }

    public long copyTo(Appendable appendable) {
        Preconditions.checkNotNull(appendable);
        Closer closer = Closer.create();
        try {
            Reader reader = (Reader)closer.register(this.openStream());
            long l2 = CharStreams.copy(reader, appendable);
            return l2;
        }
        catch (Throwable var3_4) {
            throw closer.rethrow(var3_4);
        }
        finally {
            closer.close();
        }
    }

    public long copyTo(CharSink charSink) {
        Preconditions.checkNotNull(charSink);
        Closer closer = Closer.create();
        try {
            Reader reader = (Reader)closer.register(this.openStream());
            Writer writer = (Writer)closer.register(charSink.openStream());
            long l2 = CharStreams.copy(reader, writer);
            return l2;
        }
        catch (Throwable var3_4) {
            throw closer.rethrow(var3_4);
        }
        finally {
            closer.close();
        }
    }

    public String read() {
        Closer closer = Closer.create();
        try {
            Reader reader = (Reader)closer.register(this.openStream());
            String string = CharStreams.toString(reader);
            return string;
        }
        catch (Throwable var2_3) {
            throw closer.rethrow(var2_3);
        }
        finally {
            closer.close();
        }
    }

    @Nullable
    public String readFirstLine() {
        Closer closer = Closer.create();
        try {
            BufferedReader bufferedReader = (BufferedReader)closer.register(this.openBufferedStream());
            String string = bufferedReader.readLine();
            return string;
        }
        catch (Throwable var2_3) {
            throw closer.rethrow(var2_3);
        }
        finally {
            closer.close();
        }
    }

    public ImmutableList readLines() {
        Closer closer = Closer.create();
        try {
            String string;
            BufferedReader bufferedReader = (BufferedReader)closer.register(this.openBufferedStream());
            ArrayList arrayList = Lists.newArrayList();
            while ((string = bufferedReader.readLine()) != null) {
                arrayList.add(string);
            }
            ImmutableList immutableList = ImmutableList.copyOf(arrayList);
            return immutableList;
        }
        catch (Throwable var2_3) {
            throw closer.rethrow(var2_3);
        }
        finally {
            closer.close();
        }
    }

    @Beta
    public Object readLines(LineProcessor lineProcessor) {
        Preconditions.checkNotNull(lineProcessor);
        Closer closer = Closer.create();
        try {
            Reader reader = (Reader)closer.register(this.openStream());
            Object object = CharStreams.readLines(reader, lineProcessor);
            return object;
        }
        catch (Throwable var3_4) {
            throw closer.rethrow(var3_4);
        }
        finally {
            closer.close();
        }
    }

    public boolean isEmpty() {
        Optional optional = this.lengthIfKnown();
        if (optional.isPresent() && (Long)optional.get() == 0) {
            return true;
        }
        Closer closer = Closer.create();
        try {
            Reader reader = (Reader)closer.register(this.openStream());
            boolean bl2 = reader.read() == -1;
            return bl2;
        }
        catch (Throwable var3_4) {
            throw closer.rethrow(var3_4);
        }
        finally {
            closer.close();
        }
    }

    public static CharSource concat(Iterable iterable) {
        return new CharSource$ConcatenatedCharSource(iterable);
    }

    public static CharSource concat(Iterator iterator) {
        return CharSource.concat(ImmutableList.copyOf(iterator));
    }

    public static /* varargs */ CharSource concat(CharSource ... arrcharSource) {
        return CharSource.concat(ImmutableList.copyOf(arrcharSource));
    }

    public static CharSource wrap(CharSequence charSequence) {
        return new CharSource$CharSequenceCharSource(charSequence);
    }

    public static CharSource empty() {
        return CharSource$EmptyCharSource.access$000();
    }
}

