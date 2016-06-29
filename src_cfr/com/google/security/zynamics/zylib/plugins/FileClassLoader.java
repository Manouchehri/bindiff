/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.plugins;

import com.google.security.zynamics.zylib.plugins.MultiClassLoader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

public class FileClassLoader
extends MultiClassLoader {
    private final String filePrefix;

    public FileClassLoader(String string) {
        this.filePrefix = string;
    }

    @Override
    protected byte[] loadClassBytes(String string) {
        string = this.formatClassName(string);
        if (this.sourceMonitorOn) {
            String string2 = String.valueOf(string);
            FileClassLoader.print(string2.length() != 0 ? ">> from file: ".concat(string2) : new String(">> from file: "));
        }
        String string3 = String.valueOf(this.filePrefix);
        String string4 = String.valueOf(string);
        String string5 = string4.length() != 0 ? string3.concat(string4) : new String(string3);
        try {
            FileInputStream fileInputStream = new FileInputStream(string5);
            byte[] arrby = new byte[fileInputStream.available()];
            fileInputStream.read(arrby);
            fileInputStream.close();
            return arrby;
        }
        catch (IOException var4_4) {
            System.out.println(new StringBuilder(22 + String.valueOf(string5).length()).append("### File '").append(string5).append("' not found.").toString());
            return null;
        }
    }
}

