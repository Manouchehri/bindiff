/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.processes;

import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.GeneralSettingsConfigItem;
import com.google.security.zynamics.bindiff.exceptions.BinExportException;
import com.google.security.zynamics.zylib.io.FileUtils;
import com.google.security.zynamics.zylib.system.IdaException;
import com.google.security.zynamics.zylib.system.IdaHelpers;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class ExportProcess {
    private static File createIDAScript(File file, String string) {
        Object object = String.valueOf(file.getPath());
        String string2 = String.valueOf(File.separator);
        String string3 = String.valueOf("export.idc");
        File file2 = new File(new StringBuilder(0 + String.valueOf(object).length() + String.valueOf(string2).length() + String.valueOf(string3).length()).append((String)object).append(string2).append(string3).toString());
        object = null;
        try {
            object = new PrintWriter(new FileOutputStream(file2));
            object.println("#include <idc.idc>");
            object.println("static main() {");
            object.println("  Batch(0);");
            object.println("  Wait();");
            Object[] arrobject = new Object[2];
            arrobject[0] = "BinExport2Diff8";
            string2 = String.valueOf(file.getPath());
            string3 = String.valueOf(File.separator);
            arrobject[1] = new StringBuilder(0 + String.valueOf(string2).length() + String.valueOf(string3).length() + String.valueOf(string).length()).append(string2).append(string3).append(string).toString().replace("\\", "\\\\");
            object.println(String.format("  Exit(%s(\"%s\"));", arrobject));
            object.println("}");
            if (!object.checkError()) return file2;
            throw new BinExportException("Couldn't write IDA export script.");
        }
        catch (FileNotFoundException var4_4) {
            throw new BinExportException(var4_4, "Couldn't create IDA export script file.");
        }
        finally {
            if (object != null) {
                object.close();
            }
        }
    }

    public static String getExportedFileName(String string, File file) {
        try {
            String string2 = String.valueOf(FileUtils.ensureTrailingSlash(file.getPath()));
            String string3 = String.valueOf(string);
            return string3.length() != 0 ? string2.concat(string3) : new String(string2);
        }
        catch (Exception var2_3) {
            throw new BinExportException(var2_3, "Couldn't start exporting process. File name generation failed.");
        }
    }

    public static void startExportProcess(File file, File file2, File file3, String string) {
        File file4 = ExportProcess.createIDAScript(file2, string);
        try {
            String string2 = BinDiffConfigFile.getInstance().getMainSettings().getIdaDirectory();
            char c2 = File.separatorChar;
            String string3 = String.valueOf(file.getName());
            IdaHelpers.createIdaProcess(new StringBuilder(1 + String.valueOf(string2).length() + String.valueOf(string3).length()).append(string2).append(c2).append(string3).toString(), file4, file3.getAbsolutePath(), "");
            return;
        }
        catch (IdaException var5_6) {
            throw new BinExportException(var5_6);
        }
        finally {
            file4.delete();
        }
    }
}

