package com.google.security.zynamics.zylib.plugins;

import java.io.*;

public class FileClassLoader extends MultiClassLoader
{
    private final String filePrefix;
    
    public FileClassLoader(final String filePrefix) {
        this.filePrefix = filePrefix;
    }
    
    @Override
    protected byte[] loadClassBytes(String formatClassName) {
        formatClassName = this.formatClassName(formatClassName);
        if (this.sourceMonitorOn) {
            final String s = ">> from file: ";
            final String value = String.valueOf(formatClassName);
            MultiClassLoader.print((value.length() != 0) ? s.concat(value) : new String(s));
        }
        final String value2 = String.valueOf(this.filePrefix);
        final String value3 = String.valueOf(formatClassName);
        final String s2 = (value3.length() != 0) ? value2.concat(value3) : new String(value2);
        try {
            final FileInputStream fileInputStream = new FileInputStream(s2);
            final byte[] array = new byte[fileInputStream.available()];
            fileInputStream.read(array);
            fileInputStream.close();
            return array;
        }
        catch (IOException ex) {
            System.out.println(new StringBuilder(22 + String.valueOf(s2).length()).append("### File '").append(s2).append("' not found.").toString());
            return null;
        }
    }
}
