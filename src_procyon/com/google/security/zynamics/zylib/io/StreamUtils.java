package com.google.security.zynamics.zylib.io;

import java.io.*;
import java.util.*;

public class StreamUtils
{
    public static List readLinesFromReader(final Reader reader) {
        final BufferedReader bufferedReader = new BufferedReader(reader);
        try {
            final ArrayList<String> list = new ArrayList<String>();
            while (true) {
                final String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                list.add(line);
            }
            return list;
        }
        finally {
            bufferedReader.close();
        }
    }
}
