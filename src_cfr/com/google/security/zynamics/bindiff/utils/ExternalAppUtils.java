/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.utils;

import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.GeneralSettingsConfigItem;
import com.google.security.zynamics.bindiff.resources.Constants;
import com.google.security.zynamics.bindiff.utils.CFileUtils;
import com.google.security.zynamics.zylib.io.FileUtils;
import com.google.security.zynamics.zylib.system.IdaHelpers;
import java.io.File;

public class ExternalAppUtils {
    public static String getCommandLineDiffer() {
        String string;
        String string2 = BinDiffConfigFile.getInstance().getMainSettings().getDiffEnginePath();
        if (string2 == null || string2.isEmpty()) {
            string2 = FileUtils.findLocalRootPath(ExternalAppUtils.class);
        }
        String string3 = String.valueOf(FileUtils.ensureTrailingSlash(string2));
        String string4 = String.valueOf(Constants.BINDIFF_ENGINE_EXECUTABLE);
        if (string4.length() != 0) {
            string = string3.concat(string4);
            return string;
        }
        string = new String(string3);
        return string;
    }

    public static File getIdaExe(File file) {
        String string = CFileUtils.getFileExtension(file.getPath());
        GeneralSettingsConfigItem generalSettingsConfigItem = BinDiffConfigFile.getInstance().getMainSettings();
        if (string.equalsIgnoreCase("idb")) {
            String string2 = generalSettingsConfigItem.getIdaDirectory();
            char c2 = File.separatorChar;
            String string3 = String.valueOf(IdaHelpers.IDA32_EXECUTABLE);
            return new File(new StringBuilder(1 + String.valueOf(string2).length() + String.valueOf(string3).length()).append(string2).append(c2).append(string3).toString());
        }
        if (!string.equalsIgnoreCase("i64")) return null;
        String string4 = generalSettingsConfigItem.getIdaDirectory();
        char c3 = File.separatorChar;
        String string5 = String.valueOf(IdaHelpers.IDA64_EXECUTABLE);
        return new File(new StringBuilder(1 + String.valueOf(string4).length() + String.valueOf(string5).length()).append(string4).append(c3).append(string5).toString());
    }
}

