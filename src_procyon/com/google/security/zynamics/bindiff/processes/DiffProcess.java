package com.google.security.zynamics.bindiff.processes;

import com.google.security.zynamics.bindiff.exceptions.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.log.*;
import java.io.*;

public class DiffProcess
{
    private static void handleExitCode(final int n) {
        if (n == 0) {
            return;
        }
        if (n == 1) {
            throw new DifferException("An error occued while diffing. Exit code 1.");
        }
        if (n == 2) {
            throw new DifferException("An error occured while diffing. Exit code 2.");
        }
        if (n == 3) {
            throw new DifferException("Machine ran out of memory. Exit code 3.");
        }
        throw new DifferException(String.format("Unknown error occured while diffing. Exit code %d.", n));
    }
    
    public static String getBinDiffFileName(final String s, final String s2) {
        try {
            final String removeFileExtension = CFileUtils.removeFileExtension(s);
            final String removeFileExtension2 = CFileUtils.removeFileExtension(s2.substring(s2.lastIndexOf(File.separator) + 1));
            final String value = String.valueOf("BinDiff");
            return new StringBuilder(5 + String.valueOf(removeFileExtension).length() + String.valueOf(removeFileExtension2).length() + String.valueOf(value).length()).append(removeFileExtension).append("_vs_").append(removeFileExtension2).append(".").append(value).toString();
        }
        catch (Exception ex) {
            throw new DifferException(ex, "Adding Diff to workspace.");
        }
    }
    
    public static void startDiffProcess(final String s, final String s2, final String s3, final File file) {
        final File file2 = new File(s);
        if (!file2.exists()) {
            throw new DifferException(new StringBuilder(29 + String.valueOf(s).length()).append("Can't find Diff engine at '").append(s).append("'.").toString());
        }
        if (!file2.canExecute()) {
            throw new DifferException(new StringBuilder(37 + String.valueOf(s).length()).append("Diff engine is not an executeable '").append(s).append("'.").toString());
        }
        final ProcessBuilder processBuilder = new ProcessBuilder(new String[] { s, "--primary", s2, "--secondary", s3, "--output_dir", file.getPath(), "--bin_format" });
        Logger.logInfo(Joiner.on(' ').join(processBuilder.command()), new Object[0]);
        int wait = -1;
        ProcessOutputStreamReader processOutputStreamReader = null;
        ProcessOutputStreamReader processOutputStreamReader2 = null;
        try {
            processBuilder.redirectErrorStream(true);
            final Process start = processBuilder.start();
            processOutputStreamReader = new ProcessOutputStreamReader("Diff Process - stdout", start.getInputStream());
            processOutputStreamReader2 = new ProcessOutputStreamReader("Diff Process - stderr", start.getErrorStream());
            processOutputStreamReader.start();
            processOutputStreamReader2.start();
            wait = start.waitFor();
            processOutputStreamReader.interruptThread();
            processOutputStreamReader2.interruptThread();
            handleExitCode(wait);
        }
        catch (DifferException ex) {
            throw ex;
        }
        catch (IOException ex2) {
            throw new DifferException(ex2, String.format("Couldn't start diffing process. Exit code %d.", wait));
        }
        catch (InterruptedException ex3) {
            throw new DifferException(ex3, String.format("Diffing process was interruped unexpectedly. Exit code %d.", wait));
        }
        catch (Exception ex4) {
            throw new DifferException(ex4, String.format("Diffing process failed. Exit code %d.", wait));
        }
        finally {
            if (processOutputStreamReader != null) {
                processOutputStreamReader.interruptThread();
            }
            if (processOutputStreamReader2 != null) {
                processOutputStreamReader2.interruptThread();
            }
        }
    }
}
