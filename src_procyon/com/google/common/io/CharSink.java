package com.google.common.io;

import com.google.common.base.*;
import java.io.*;
import java.util.*;

public abstract class CharSink
{
    public abstract Writer openStream();
    
    public Writer openBufferedStream() {
        final Writer openStream = this.openStream();
        return (openStream instanceof BufferedWriter) ? openStream : new BufferedWriter(openStream);
    }
    
    public void write(final CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        final Closer create = Closer.create();
        try {
            final Writer writer = (Writer)create.register(this.openStream());
            writer.append(charSequence);
            writer.flush();
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    public void writeLines(final Iterable iterable) {
        this.writeLines(iterable, System.getProperty("line.separator"));
    }
    
    public void writeLines(final Iterable iterable, final String s) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(s);
        final Closer create = Closer.create();
        try {
            final Writer writer = (Writer)create.register(this.openBufferedStream());
            final Iterator<CharSequence> iterator = iterable.iterator();
            while (iterator.hasNext()) {
                writer.append((CharSequence)iterator.next()).append((CharSequence)s);
            }
            writer.flush();
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    public long writeFrom(final Readable readable) {
        Preconditions.checkNotNull(readable);
        final Closer create = Closer.create();
        try {
            final Writer writer = (Writer)create.register(this.openStream());
            final long copy = CharStreams.copy(readable, writer);
            writer.flush();
            return copy;
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
}
