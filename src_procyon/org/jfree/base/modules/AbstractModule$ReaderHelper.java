package org.jfree.base.modules;

import java.io.*;

class AbstractModule$ReaderHelper
{
    private String buffer;
    private final BufferedReader reader;
    
    public AbstractModule$ReaderHelper(final BufferedReader reader) {
        this.reader = reader;
    }
    
    public boolean hasNext() {
        if (this.buffer == null) {
            this.buffer = this.readLine();
        }
        return this.buffer != null;
    }
    
    public String next() {
        final String buffer = this.buffer;
        this.buffer = null;
        return buffer;
    }
    
    public void pushBack(final String buffer) {
        this.buffer = buffer;
    }
    
    protected String readLine() {
        String s;
        for (s = this.reader.readLine(); s != null && (s.length() == 0 || s.startsWith("#")); s = this.reader.readLine()) {}
        return s;
    }
    
    public void close() {
        this.reader.close();
    }
}
