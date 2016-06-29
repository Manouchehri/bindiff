package com.google.common.io;

import java.io.*;
import com.google.common.base.*;
import java.util.*;

public class MultiplexingOutputStream$MultiplexingIOException extends IOException
{
    private final List exceptions;
    
    public MultiplexingOutputStream$MultiplexingIOException(final List list) {
        super(getComponentMessages(list));
        this.exceptions = Collections.unmodifiableList((List<?>)list);
    }
    
    public List getCauses() {
        return this.exceptions;
    }
    
    private static String getComponentMessages(final List list) {
        final Joiner on = Joiner.on("\n");
        final ArrayList<String> list2 = new ArrayList<String>();
        list2.add("Component messages:\n");
        for (final IOException ex : list) {
            final ArrayList<String> list3 = list2;
            final String s = "\t";
            final String value = String.valueOf(ex.getMessage());
            list3.add((value.length() != 0) ? s.concat(value) : new String(s));
        }
        return on.join(list2);
    }
}
