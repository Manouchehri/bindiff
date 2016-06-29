/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.io;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class StreamUtils {
    private StreamUtils() {
    }

    public static List readLinesFromReader(Reader reader) {
        BufferedReader bufferedReader = new BufferedReader(reader);
        try {
            ArrayList<String> arrayList = new ArrayList<String>();
            do {
                String string;
                if ((string = bufferedReader.readLine()) == null) {
                    ArrayList<String> arrayList2 = arrayList;
                    return arrayList2;
                }
                arrayList.add(string);
            } while (true);
        }
        finally {
            bufferedReader.close();
        }
    }
}

