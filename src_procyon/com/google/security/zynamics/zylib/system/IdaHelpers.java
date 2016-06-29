package com.google.security.zynamics.zylib.system;

import java.io.*;

public final class IdaHelpers
{
    public static final String IDA32_EXECUTABLE;
    public static final String IDA64_EXECUTABLE;
    
    public static Process createIdaProcess(final String s, final File file, final String s2, final String s3) {
        final String sArgument = getSArgument(file.getAbsolutePath(), SystemHelpers.isRunningWindows());
        final String[] array = { s, "-A", null, null, null };
        final int n = 2;
        final String s4 = "-OExporterModule:";
        final String value = String.valueOf(s3);
        array[n] = ((value.length() != 0) ? s4.concat(value) : new String(s4));
        array[3] = sArgument;
        array[4] = s2;
        final ProcessBuilder processBuilder = new ProcessBuilder(array);
        try {
            processBuilder.redirectErrorStream(true);
            final Process start = processBuilder.start();
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream()));
            try {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
            }
            catch (IOException ex2) {
                bufferedReader.close();
            }
            bufferedReader.close();
            return start;
        }
        catch (Exception ex) {
            final String value2 = String.valueOf(ex);
            throw new IdaException(new StringBuilder(51 + String.valueOf(value2).length()).append("Failed attempting to launch the importer with IDA: ").append(value2).toString(), ex);
        }
    }
    
    public static String getSArgument(final String s, final boolean b) {
        return b ? new StringBuilder(6 + String.valueOf(s).length()).append("-S\\\"").append(s).append("\\\"").toString() : new StringBuilder(4 + String.valueOf(s).length()).append("-S\"").append(s).append("\"").toString();
    }
    
    static {
        if (SystemHelpers.isRunningWindows()) {
            IDA32_EXECUTABLE = "idaq.exe";
            IDA64_EXECUTABLE = "idaq64.exe";
        }
        else {
            IDA32_EXECUTABLE = "idaq";
            IDA64_EXECUTABLE = "idaq64";
        }
    }
}
