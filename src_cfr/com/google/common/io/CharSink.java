/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.CharStreams;
import com.google.common.io.Closer;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.Writer;

public abstract class CharSink {
    protected CharSink() {
    }

    public abstract Writer openStream();

    public Writer openBufferedStream() {
        BufferedWriter bufferedWriter;
        Writer writer = this.openStream();
        if (writer instanceof BufferedWriter) {
            bufferedWriter = (BufferedWriter)writer;
            return bufferedWriter;
        }
        bufferedWriter = new BufferedWriter(writer);
        return bufferedWriter;
    }

    public void write(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        Closer closer = Closer.create();
        try {
            Writer writer = (Writer)closer.register(this.openStream());
            writer.append(charSequence);
            writer.flush();
            return;
        }
        catch (Throwable var3_4) {
            throw closer.rethrow(var3_4);
        }
        finally {
            closer.close();
        }
    }

    public void writeLines(Iterable iterable) {
        this.writeLines(iterable, System.getProperty("line.separator"));
    }

    public void writeLines(Iterable iterable, String string) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(string);
        Closer closer = Closer.create();
        try {
            Writer writer = (Writer)closer.register(this.openBufferedStream());
            for (CharSequence charSequence : iterable) {
                writer.append(charSequence).append(string);
            }
            writer.flush();
            return;
        }
        catch (Throwable var4_5) {
            throw closer.rethrow(var4_5);
        }
        finally {
            closer.close();
        }
    }

    public long writeFrom(Readable readable) {
        Preconditions.checkNotNull(readable);
        Closer closer = Closer.create();
        try {
            Writer writer = (Writer)closer.register(this.openStream());
            long l2 = CharStreams.copy(readable, writer);
            writer.flush();
            long l3 = l2;
            return l3;
        }
        catch (Throwable var3_4) {
            throw closer.rethrow(var3_4);
        }
        finally {
            closer.close();
        }
    }
}

