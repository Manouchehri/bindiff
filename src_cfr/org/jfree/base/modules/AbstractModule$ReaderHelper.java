/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.base.modules;

import java.io.BufferedReader;

class AbstractModule$ReaderHelper {
    private String buffer;
    private final BufferedReader reader;

    public AbstractModule$ReaderHelper(BufferedReader bufferedReader) {
        this.reader = bufferedReader;
    }

    public boolean hasNext() {
        if (this.buffer == null) {
            this.buffer = this.readLine();
        }
        if (this.buffer == null) return false;
        return true;
    }

    public String next() {
        String string = this.buffer;
        this.buffer = null;
        return string;
    }

    public void pushBack(String string) {
        this.buffer = string;
    }

    protected String readLine() {
        String string = this.reader.readLine();
        while (string != null) {
            if (string.length() != 0) {
                if (!string.startsWith("#")) return string;
            }
            string = this.reader.readLine();
        }
        return string;
    }

    public void close() {
        this.reader.close();
    }
}

