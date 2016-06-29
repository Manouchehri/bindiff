/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.log;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.log.LogFormatter;
import com.google.security.zynamics.bindiff.utils.CFileUtils;
import com.google.security.zynamics.zylib.io.FileUtils;
import com.google.security.zynamics.zylib.system.SystemHelpers;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;

public class Logger {
    private static java.util.logging.Logger logger = java.util.logging.Logger.getLogger("BinDiff");
    private static FileHandler fileHandler = null;
    private static LogFormatter formatter = null;
    private static boolean logInfo = false;
    private static boolean logVerbose = false;
    private static boolean logWarning = false;
    private static boolean logSevere = false;
    private static boolean logException = false;
    private static boolean enableFileLogger = false;
    private static boolean enableConsoleLogger = false;

    private static void logExceptionIntern(Level level, Throwable throwable, String string) {
        String string2;
        StringWriter stringWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringWriter));
        String string3 = String.valueOf(level.toString());
        if (string == null || string.isEmpty()) {
            string2 = "";
        } else {
            String string4 = String.valueOf(string);
            string2 = string4.length() != 0 ? " ".concat(string4) : new String(" ");
        }
        String string5 = string2;
        logger.log(level, new StringBuilder(12 + String.valueOf(string3).length() + String.valueOf(string5).length()).append(string3).append(": EXCEPTION:").append(string5).toString(), throwable);
        logger.log(level, stringWriter.getBuffer().toString());
    }

    private static boolean logIf(boolean bl2) {
        if (!bl2) return false;
        if (enableFileLogger) return true;
        if (!enableConsoleLogger) return false;
        return true;
    }

    private static /* varargs */ void logIf(boolean bl2, Level level, String string, Object ... arrobject) {
        if (!bl2) {
            return;
        }
        String string2 = String.valueOf(level.toString());
        String string3 = String.valueOf(String.format(string, arrobject));
        logger.log(level, new StringBuilder(2 + String.valueOf(string2).length() + String.valueOf(string3).length()).append(string2).append(": ").append(string3).toString());
    }

    public static void addFileLogger(FileHandler fileHandler) {
        if (Logger.fileHandler != null) {
            logger.removeHandler(fileHandler);
        }
        Logger.fileHandler = fileHandler;
        Logger.fileHandler.setFormatter(formatter);
    }

    public static void enableConsoleLogger(boolean bl2) {
        logger.setUseParentHandlers(bl2);
        enableConsoleLogger = bl2;
    }

    public static void enableFileLogger(boolean bl2) {
        Preconditions.checkArgument(fileHandler != null, "File handler cannot be null. Add a valid file handler first.");
        if (!bl2) {
            logger.removeHandler(fileHandler);
        } else {
            logger.addHandler(fileHandler);
        }
        enableFileLogger = bl2;
    }

    public static boolean getConsoleLogging() {
        return enableConsoleLogger;
    }

    public static String getDefaultLoggingDirectoryPath() {
        String string = String.valueOf(SystemHelpers.getApplicationDataDirectory("BinDiff"));
        String string2 = String.valueOf("logs");
        File file = new File(string2.length() != 0 ? string.concat(string2) : new String(string));
        if (file.exists()) return file.getPath();
        file.mkdirs();
        return file.getPath();
    }

    public static boolean getFileLogging() {
        return enableFileLogger;
    }

    public static boolean getLogExceptions() {
        return logException;
    }

    public static String getLoggingFilePath(String string) {
        String string2;
        String string3 = null;
        string3 = string == null || string.isEmpty() ? Logger.getDefaultLoggingDirectoryPath() : string;
        File file = new File(string3);
        if (!file.exists()) {
            file.mkdirs();
        }
        string3 = CFileUtils.forceFileSeparators(string3);
        String string4 = String.valueOf(FileUtils.ensureTrailingSlash(string3));
        String string5 = String.valueOf("bindiff_ui.log");
        if (string5.length() != 0) {
            string2 = string4.concat(string5);
            return string2;
        }
        string2 = new String(string4);
        return string2;
    }

    public static boolean getLogInfo() {
        return logInfo;
    }

    public static boolean getLogSevere() {
        return logSevere;
    }

    public static boolean getLogVerbose() {
        return logVerbose;
    }

    public static boolean getLogWarning() {
        return logWarning;
    }

    public static void logException(Level level, Throwable throwable, String string) {
        if (!Logger.logIf(logException)) return;
        Logger.logExceptionIntern(level, throwable, string);
    }

    public static void logException(Throwable throwable) {
        Logger.logException(throwable, null);
    }

    public static void logException(Throwable throwable, String string) {
        Logger.logException(Level.SEVERE, throwable, string);
    }

    public static /* varargs */ void logInfo(String string, Object ... arrobject) {
        Logger.logIf(Logger.logIf(logInfo), Level.INFO, string, arrobject);
    }

    public static /* varargs */ void logSevere(String string, Object ... arrobject) {
        Logger.logIf(Logger.logIf(logSevere), Level.SEVERE, string, arrobject);
    }

    public static /* varargs */ void logVerbose(String string, Object ... arrobject) {
        Logger.logIf(Logger.logIf(logVerbose), Level.INFO, string, arrobject);
    }

    public static void logWarning(Exception exception, String string) {
        if (!Logger.logIf(logWarning)) return;
        Logger.logExceptionIntern(Level.WARNING, exception, string);
    }

    public static /* varargs */ void logWarning(String string, Object ... arrobject) {
        Logger.logIf(Logger.logIf(logWarning), Level.WARNING, string, arrobject);
    }

    public static void removeFileHandler() {
        if (fileHandler != null) {
            logger.removeHandler(fileHandler);
        }
        enableFileLogger = false;
    }

    public static void setLogExceptions(boolean bl2) {
        logException = bl2;
    }

    public static void setLogInfos(boolean bl2) {
        logInfo = bl2;
    }

    public static void setLogSevere(boolean bl2) {
        logSevere = bl2;
    }

    public static void setLogVerboseInfos(boolean bl2) {
        logVerbose = bl2;
    }

    public static void setLogWarnings(boolean bl2) {
        logWarning = bl2;
    }

    public static void setVeryVerboseLogging(boolean bl2) {
        LogFormatter.setVerboseLogging(bl2);
    }

    static {
        formatter = new LogFormatter();
        logger.setLevel(Level.INFO);
        logger.setUseParentHandlers(false);
        Handler[] arrhandler = logger.getParent().getHandlers();
        int n2 = arrhandler.length;
        int n3 = 0;
        while (n3 < n2) {
            Handler handler = arrhandler[n3];
            handler.setFormatter(formatter);
            ++n3;
        }
    }
}

