/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.base.Joiner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MultiplexingOutputStream$MultiplexingIOException
extends IOException {
    private final List exceptions;

    public MultiplexingOutputStream$MultiplexingIOException(List list) {
        super(MultiplexingOutputStream$MultiplexingIOException.getComponentMessages(list));
        this.exceptions = Collections.unmodifiableList(list);
    }

    public List getCauses() {
        return this.exceptions;
    }

    private static String getComponentMessages(List list) {
        Joiner joiner = Joiner.on("\n");
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Component messages:\n");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            IOException iOException = (IOException)iterator.next();
            String string = String.valueOf(iOException.getMessage());
            arrayList.add(string.length() != 0 ? "\t".concat(string) : new String("\t"));
        }
        return joiner.join(arrayList);
    }
}

