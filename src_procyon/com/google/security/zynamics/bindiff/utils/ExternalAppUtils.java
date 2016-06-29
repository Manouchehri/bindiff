package com.google.security.zynamics.bindiff.utils;

import com.google.security.zynamics.zylib.io.*;
import com.google.security.zynamics.bindiff.resources.*;
import java.io.*;
import com.google.security.zynamics.zylib.system.*;
import com.google.security.zynamics.bindiff.config.*;

public class ExternalAppUtils
{
    public static String getCommandLineDiffer() {
        String s = BinDiffConfigFile.getInstance().getMainSettings().getDiffEnginePath();
        if (s == null || s.isEmpty()) {
            s = FileUtils.findLocalRootPath(ExternalAppUtils.class);
        }
        final String value = String.valueOf(FileUtils.ensureTrailingSlash(s));
        final String value2 = String.valueOf(Constants.BINDIFF_ENGINE_EXECUTABLE);
        return (value2.length() != 0) ? value.concat(value2) : new String(value);
    }
    
    public static File getIdaExe(final File file) {
        final String fileExtension = CFileUtils.getFileExtension(file.getPath());
        final GeneralSettingsConfigItem mainSettings = BinDiffConfigFile.getInstance().getMainSettings();
        if (fileExtension.equalsIgnoreCase("idb")) {
            final String idaDirectory = mainSettings.getIdaDirectory();
            final char separatorChar = File.separatorChar;
            final String value = String.valueOf(IdaHelpers.IDA32_EXECUTABLE);
            return new File(new StringBuilder(1 + String.valueOf(idaDirectory).length() + String.valueOf(value).length()).append(idaDirectory).append(separatorChar).append(value).toString());
        }
        if (fileExtension.equalsIgnoreCase("i64")) {
            final String idaDirectory2 = mainSettings.getIdaDirectory();
            final char separatorChar2 = File.separatorChar;
            final String value2 = String.valueOf(IdaHelpers.IDA64_EXECUTABLE);
            return new File(new StringBuilder(1 + String.valueOf(idaDirectory2).length() + String.valueOf(value2).length()).append(idaDirectory2).append(separatorChar2).append(value2).toString());
        }
        return null;
    }
}
