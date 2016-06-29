/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.system;

import com.google.security.zynamics.zylib.system.IdaException;
import com.google.security.zynamics.zylib.system.SystemHelpers;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;

public final class IdaHelpers {
    public static final String IDA32_EXECUTABLE;
    public static final String IDA64_EXECUTABLE;

    public static Process createIdaProcess(String string, File file, String string2, String string3) {
        String string4 = file.getAbsolutePath();
        String string5 = IdaHelpers.getSArgument(string4, SystemHelpers.isRunningWindows());
        String[] arrstring = new String[5];
        arrstring[0] = string;
        arrstring[1] = "-A";
        String string6 = String.valueOf(string3);
        arrstring[2] = string6.length() != 0 ? "-OExporterModule:".concat(string6) : new String("-OExporterModule:");
        arrstring[3] = string5;
        arrstring[4] = string2;
        ProcessBuilder processBuilder = new ProcessBuilder(arrstring);
        try {
            Process process = null;
            processBuilder.redirectErrorStream(true);
            process = processBuilder.start();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            try {
                String string7;
                while ((string7 = bufferedReader.readLine()) != null) {
                    System.out.println(string7);
                }
            }
            catch (IOException var10_12) {
                bufferedReader.close();
            }
            bufferedReader.close();
            return process;
        }
        catch (Exception var7_8) {
            String string8 = String.valueOf(var7_8);
            throw new IdaException(new StringBuilder(51 + String.valueOf(string8).length()).append("Failed attempting to launch the importer with IDA: ").append(string8).toString(), var7_8);
        }
    }

    public static String getSArgument(String string, boolean bl2) {
        String string2;
        if (bl2) {
            string2 = new StringBuilder(6 + String.valueOf(string).length()).append("-S\\\"").append(string).append("\\\"").toString();
            return string2;
        }
        string2 = new StringBuilder(4 + String.valueOf(string).length()).append("-S\"").append(string).append("\"").toString();
        return string2;
    }

    static {
        if (SystemHelpers.isRunningWindows()) {
            IDA32_EXECUTABLE = "idaq.exe";
            IDA64_EXECUTABLE = "idaq64.exe";
            return;
        }
        IDA32_EXECUTABLE = "idaq";
        IDA64_EXECUTABLE = "idaq64";
    }
}

