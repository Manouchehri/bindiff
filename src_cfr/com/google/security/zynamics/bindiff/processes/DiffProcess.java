/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.processes;

import com.google.common.base.Joiner;
import com.google.security.zynamics.bindiff.exceptions.DifferException;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.processes.ProcessOutputStreamReader;
import com.google.security.zynamics.bindiff.utils.CFileUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DiffProcess {
    private static void handleExitCode(int n2) {
        if (n2 == 0) return;
        if (n2 == 1) {
            throw new DifferException("An error occued while diffing. Exit code 1.");
        }
        if (n2 == 2) {
            throw new DifferException("An error occured while diffing. Exit code 2.");
        }
        if (n2 != 3) throw new DifferException(String.format("Unknown error occured while diffing. Exit code %d.", n2));
        throw new DifferException("Machine ran out of memory. Exit code 3.");
    }

    public static String getBinDiffFileName(String string, String string2) {
        try {
            String string3 = CFileUtils.removeFileExtension(string);
            String string4 = string2.substring(string2.lastIndexOf(File.separator) + 1);
            String string5 = string4 = CFileUtils.removeFileExtension(string4);
            String string6 = String.valueOf("BinDiff");
            return new StringBuilder(5 + String.valueOf(string3).length() + String.valueOf(string5).length() + String.valueOf(string6).length()).append(string3).append("_vs_").append(string5).append(".").append(string6).toString();
        }
        catch (Exception var2_3) {
            throw new DifferException(var2_3, "Adding Diff to workspace.");
        }
    }

    public static void startDiffProcess(String string, String string2, String string3, File file) {
        File file2 = new File(string);
        if (!file2.exists()) {
            throw new DifferException(new StringBuilder(29 + String.valueOf(string).length()).append("Can't find Diff engine at '").append(string).append("'.").toString());
        }
        if (!file2.canExecute()) {
            throw new DifferException(new StringBuilder(37 + String.valueOf(string).length()).append("Diff engine is not an executeable '").append(string).append("'.").toString());
        }
        ProcessBuilder processBuilder = new ProcessBuilder(string, "--primary", string2, "--secondary", string3, "--output_dir", file.getPath(), "--bin_format");
        Logger.logInfo(Joiner.on(' ').join(processBuilder.command()), new Object[0]);
        int n2 = -1;
        Process process = null;
        ProcessOutputStreamReader processOutputStreamReader = null;
        ProcessOutputStreamReader processOutputStreamReader2 = null;
        try {
            processBuilder.redirectErrorStream(true);
            process = processBuilder.start();
            processOutputStreamReader = new ProcessOutputStreamReader("Diff Process - stdout", process.getInputStream());
            processOutputStreamReader2 = new ProcessOutputStreamReader("Diff Process - stderr", process.getErrorStream());
            processOutputStreamReader.start();
            processOutputStreamReader2.start();
            n2 = process.waitFor();
            processOutputStreamReader.interruptThread();
            processOutputStreamReader2.interruptThread();
            DiffProcess.handleExitCode(n2);
            return;
        }
        catch (DifferException var10_10) {
            throw var10_10;
        }
        catch (IOException var10_11) {
            throw new DifferException(var10_11, String.format("Couldn't start diffing process. Exit code %d.", n2));
        }
        catch (InterruptedException var10_12) {
            throw new DifferException(var10_12, String.format("Diffing process was interruped unexpectedly. Exit code %d.", n2));
        }
        catch (Exception var10_13) {
            throw new DifferException(var10_13, String.format("Diffing process failed. Exit code %d.", n2));
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

