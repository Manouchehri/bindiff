/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.utils;

import com.google.security.zynamics.zylib.system.SystemHelpers;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class SystemUtils {
    public static void createUserDirectoy() {
        File file = new File(SystemHelpers.getApplicationDataDirectory("BinDiff"));
        if (file.exists()) return;
        file.mkdir();
    }

    public static File getBinDiffTempDirectory() {
        File file = new File(SystemHelpers.getTempDirectory("BinDiff"));
        if (file.exists()) return file;
        if (file.mkdirs()) return file;
        throw new IOException("Failed to create zynamics BinDiff's temporary directory.");
    }

    public static String getCurrentUserPersonalFolder() {
        JFileChooser jFileChooser = new JFileChooser();
        return jFileChooser.getFileSystemView().getDefaultDirectory().getPath();
    }
}

