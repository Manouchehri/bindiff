package com.google.security.zynamics.bindiff.utils;

import com.google.security.zynamics.zylib.system.*;
import java.io.*;
import javax.swing.*;

public class SystemUtils
{
    public static void createUserDirectoy() {
        final File file = new File(SystemHelpers.getApplicationDataDirectory("BinDiff"));
        if (!file.exists()) {
            file.mkdir();
        }
    }
    
    public static File getBinDiffTempDirectory() {
        final File file = new File(SystemHelpers.getTempDirectory("BinDiff"));
        if (!file.exists() && !file.mkdirs()) {
            throw new IOException("Failed to create zynamics BinDiff's temporary directory.");
        }
        return file;
    }
    
    public static String getCurrentUserPersonalFolder() {
        return new JFileChooser().getFileSystemView().getDefaultDirectory().getPath();
    }
}
