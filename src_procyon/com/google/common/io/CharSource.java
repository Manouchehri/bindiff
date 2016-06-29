package com.google.common.io;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.io.*;
import javax.annotation.*;
import com.google.common.collect.*;
import java.util.*;

public abstract class CharSource
{
    public abstract Reader openStream();
    
    public BufferedReader openBufferedStream() {
        final Reader openStream = this.openStream();
        return (BufferedReader)((openStream instanceof BufferedReader) ? openStream : new BufferedReader(openStream));
    }
    
    @Beta
    public Optional lengthIfKnown() {
        return Optional.absent();
    }
    
    @Beta
    public long length() {
        final Optional lengthIfKnown = this.lengthIfKnown();
        if (lengthIfKnown.isPresent()) {
            return (long)lengthIfKnown.get();
        }
        final Closer create = Closer.create();
        try {
            return this.countBySkipping((Reader)create.register(this.openStream()));
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    private long countBySkipping(final Reader reader) {
        long n = 0L;
        long skip;
        while ((skip = reader.skip(Long.MAX_VALUE)) != 0L) {
            n += skip;
        }
        return n;
    }
    
    public long copyTo(final Appendable appendable) {
        Preconditions.checkNotNull(appendable);
        final Closer create = Closer.create();
        try {
            return CharStreams.copy((Readable)create.register(this.openStream()), appendable);
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    public long copyTo(final CharSink charSink) {
        Preconditions.checkNotNull(charSink);
        final Closer create = Closer.create();
        try {
            return CharStreams.copy((Readable)create.register(this.openStream()), (Appendable)create.register(charSink.openStream()));
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    public String read() {
        final Closer create = Closer.create();
        try {
            return CharStreams.toString((Readable)create.register(this.openStream()));
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    @Nullable
    public String readFirstLine() {
        final Closer create = Closer.create();
        try {
            return ((BufferedReader)create.register(this.openBufferedStream())).readLine();
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    public ImmutableList readLines() {
        final Closer create = Closer.create();
        try {
            final BufferedReader bufferedReader = (BufferedReader)create.register(this.openBufferedStream());
            final ArrayList arrayList = Lists.newArrayList();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                arrayList.add(line);
            }
            return ImmutableList.copyOf(arrayList);
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    @Beta
    public Object readLines(final LineProcessor lineProcessor) {
        Preconditions.checkNotNull(lineProcessor);
        final Closer create = Closer.create();
        try {
            return CharStreams.readLines((Readable)create.register(this.openStream()), lineProcessor);
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    public boolean isEmpty() {
        final Optional lengthIfKnown = this.lengthIfKnown();
        if (lengthIfKnown.isPresent() && (long)lengthIfKnown.get() == 0L) {
            return true;
        }
        final Closer create = Closer.create();
        try {
            return ((Reader)create.register(this.openStream())).read() == -1;
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    public static CharSource concat(final Iterable iterable) {
        return new CharSource$ConcatenatedCharSource(iterable);
    }
    
    public static CharSource concat(final Iterator iterator) {
        return concat(ImmutableList.copyOf(iterator));
    }
    
    public static CharSource concat(final CharSource... array) {
        return concat(ImmutableList.copyOf(array));
    }
    
    public static CharSource wrap(final CharSequence charSequence) {
        return new CharSource$CharSequenceCharSource(charSequence);
    }
    
    public static CharSource empty() {
        return CharSource$EmptyCharSource.INSTANCE;
    }
}
