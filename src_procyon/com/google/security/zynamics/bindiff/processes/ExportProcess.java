package com.google.security.zynamics.bindiff.processes;

import com.google.security.zynamics.bindiff.exceptions.*;
import java.io.*;
import com.google.security.zynamics.zylib.io.*;
import com.google.security.zynamics.bindiff.config.*;
import com.google.security.zynamics.zylib.system.*;

public class ExportProcess
{
    private static File createIDAScript(final File file, final String s) {
        final String value = String.valueOf(file.getPath());
        final String value2 = String.valueOf(File.separator);
        final String value3 = String.valueOf("export.idc");
        final File file2 = new File(new StringBuilder(0 + String.valueOf(value).length() + String.valueOf(value2).length() + String.valueOf(value3).length()).append(value).append(value2).append(value3).toString());
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileOutputStream(file2));
            printWriter.println("#include <idc.idc>");
            printWriter.println("static main() {");
            printWriter.println("  Batch(0);");
            printWriter.println("  Wait();");
            final PrintWriter printWriter2 = printWriter;
            final String s2 = "  Exit(%s(\"%s\"));";
            final Object[] array = { "BinExport2Diff8", null };
            final int n = 1;
            final String value4 = String.valueOf(file.getPath());
            final String value5 = String.valueOf(File.separator);
            array[n] = new StringBuilder(0 + String.valueOf(value4).length() + String.valueOf(value5).length() + String.valueOf(s).length()).append(value4).append(value5).append(s).toString().replace("\\", "\\\\");
            printWriter2.println(String.format(s2, array));
            printWriter.println("}");
            if (printWriter.checkError()) {
                throw new BinExportException("Couldn't write IDA export script.");
            }
        }
        catch (FileNotFoundException ex) {
            throw new BinExportException(ex, "Couldn't create IDA export script file.");
        }
        finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
        return file2;
    }
    
    public static String getExportedFileName(final String s, final File file) {
        try {
            final String value = String.valueOf(FileUtils.ensureTrailingSlash(file.getPath()));
            final String value2 = String.valueOf(s);
            return (value2.length() != 0) ? value.concat(value2) : new String(value);
        }
        catch (Exception ex) {
            throw new BinExportException(ex, "Couldn't start exporting process. File name generation failed.");
        }
    }
    
    public static void startExportProcess(final File file, final File file2, final File file3, final String s) {
        final File idaScript = createIDAScript(file2, s);
        try {
            final String idaDirectory = BinDiffConfigFile.getInstance().getMainSettings().getIdaDirectory();
            final char separatorChar = File.separatorChar;
            final String value = String.valueOf(file.getName());
            IdaHelpers.createIdaProcess(new StringBuilder(1 + String.valueOf(idaDirectory).length() + String.valueOf(value).length()).append(idaDirectory).append(separatorChar).append(value).toString(), idaScript, file3.getAbsolutePath(), "");
        }
        catch (IdaException ex) {
            throw new BinExportException(ex);
        }
        finally {
            idaScript.delete();
        }
    }
}
