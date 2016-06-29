package com.google.security.zynamics.bindiff.log;

import java.util.logging.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.system.*;
import java.io.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.zylib.io.*;

public class Logger
{
    private static java.util.logging.Logger logger;
    private static FileHandler fileHandler;
    private static LogFormatter formatter;
    private static boolean logInfo;
    private static boolean logVerbose;
    private static boolean logWarning;
    private static boolean logSevere;
    private static boolean logException;
    private static boolean enableFileLogger;
    private static boolean enableConsoleLogger;
    
    private static void logExceptionIntern(final Level level, final Throwable t, final String s) {
        final StringWriter stringWriter = new StringWriter();
        t.printStackTrace(new PrintWriter(stringWriter));
        final java.util.logging.Logger logger = Logger.logger;
        final String value = String.valueOf(level.toString());
        String s2;
        if (s == null || s.isEmpty()) {
            s2 = "";
        }
        else {
            final String s3 = " ";
            final String value2 = String.valueOf(s);
            s2 = ((value2.length() != 0) ? s3.concat(value2) : new String(s3));
        }
        final String s4 = s2;
        logger.log(level, new StringBuilder(12 + String.valueOf(value).length() + String.valueOf(s4).length()).append(value).append(": EXCEPTION:").append(s4).toString(), t);
        Logger.logger.log(level, stringWriter.getBuffer().toString());
    }
    
    private static boolean logIf(final boolean b) {
        return b && (Logger.enableFileLogger || Logger.enableConsoleLogger);
    }
    
    private static void logIf(final boolean b, final Level level, final String s, final Object... array) {
        if (!b) {
            return;
        }
        final java.util.logging.Logger logger = Logger.logger;
        final String value = String.valueOf(level.toString());
        final String value2 = String.valueOf(String.format(s, array));
        logger.log(level, new StringBuilder(2 + String.valueOf(value).length() + String.valueOf(value2).length()).append(value).append(": ").append(value2).toString());
    }
    
    public static void addFileLogger(final FileHandler fileHandler) {
        if (Logger.fileHandler != null) {
            Logger.logger.removeHandler(fileHandler);
        }
        (Logger.fileHandler = fileHandler).setFormatter(Logger.formatter);
    }
    
    public static void enableConsoleLogger(final boolean b) {
        Logger.logger.setUseParentHandlers(b);
        Logger.enableConsoleLogger = b;
    }
    
    public static void enableFileLogger(final boolean enableFileLogger) {
        Preconditions.checkArgument(Logger.fileHandler != null, (Object)"File handler cannot be null. Add a valid file handler first.");
        if (!enableFileLogger) {
            Logger.logger.removeHandler(Logger.fileHandler);
        }
        else {
            Logger.logger.addHandler(Logger.fileHandler);
        }
        Logger.enableFileLogger = enableFileLogger;
    }
    
    public static boolean getConsoleLogging() {
        return Logger.enableConsoleLogger;
    }
    
    public static String getDefaultLoggingDirectoryPath() {
        final String value = String.valueOf(SystemHelpers.getApplicationDataDirectory("BinDiff"));
        final String value2 = String.valueOf("logs");
        final File file = new File((value2.length() != 0) ? value.concat(value2) : new String(value));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }
    
    public static boolean getFileLogging() {
        return Logger.enableFileLogger;
    }
    
    public static boolean getLogExceptions() {
        return Logger.logException;
    }
    
    public static String getLoggingFilePath(final String s) {
        String defaultLoggingDirectoryPath;
        if (s == null || s.isEmpty()) {
            defaultLoggingDirectoryPath = getDefaultLoggingDirectoryPath();
        }
        else {
            defaultLoggingDirectoryPath = s;
        }
        final File file = new File(defaultLoggingDirectoryPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        final String value = String.valueOf(FileUtils.ensureTrailingSlash(CFileUtils.forceFileSeparators(defaultLoggingDirectoryPath)));
        final String value2 = String.valueOf("bindiff_ui.log");
        return (value2.length() != 0) ? value.concat(value2) : new String(value);
    }
    
    public static boolean getLogInfo() {
        return Logger.logInfo;
    }
    
    public static boolean getLogSevere() {
        return Logger.logSevere;
    }
    
    public static boolean getLogVerbose() {
        return Logger.logVerbose;
    }
    
    public static boolean getLogWarning() {
        return Logger.logWarning;
    }
    
    public static void logException(final Level level, final Throwable t, final String s) {
        if (logIf(Logger.logException)) {
            logExceptionIntern(level, t, s);
        }
    }
    
    public static void logException(final Throwable t) {
        logException(t, null);
    }
    
    public static void logException(final Throwable t, final String s) {
        logException(Level.SEVERE, t, s);
    }
    
    public static void logInfo(final String s, final Object... array) {
        logIf(logIf(Logger.logInfo), Level.INFO, s, array);
    }
    
    public static void logSevere(final String s, final Object... array) {
        logIf(logIf(Logger.logSevere), Level.SEVERE, s, array);
    }
    
    public static void logVerbose(final String s, final Object... array) {
        logIf(logIf(Logger.logVerbose), Level.INFO, s, array);
    }
    
    public static void logWarning(final Exception ex, final String s) {
        if (logIf(Logger.logWarning)) {
            logExceptionIntern(Level.WARNING, ex, s);
        }
    }
    
    public static void logWarning(final String s, final Object... array) {
        logIf(logIf(Logger.logWarning), Level.WARNING, s, array);
    }
    
    public static void removeFileHandler() {
        if (Logger.fileHandler != null) {
            Logger.logger.removeHandler(Logger.fileHandler);
        }
        Logger.enableFileLogger = false;
    }
    
    public static void setLogExceptions(final boolean logException) {
        Logger.logException = logException;
    }
    
    public static void setLogInfos(final boolean logInfo) {
        Logger.logInfo = logInfo;
    }
    
    public static void setLogSevere(final boolean logSevere) {
        Logger.logSevere = logSevere;
    }
    
    public static void setLogVerboseInfos(final boolean logVerbose) {
        Logger.logVerbose = logVerbose;
    }
    
    public static void setLogWarnings(final boolean logWarning) {
        Logger.logWarning = logWarning;
    }
    
    public static void setVeryVerboseLogging(final boolean verboseLogging) {
        LogFormatter.setVerboseLogging(verboseLogging);
    }
    
    static {
        Logger.logger = java.util.logging.Logger.getLogger("BinDiff");
        Logger.fileHandler = null;
        Logger.formatter = null;
        Logger.logInfo = false;
        Logger.logVerbose = false;
        Logger.logWarning = false;
        Logger.logSevere = false;
        Logger.logException = false;
        Logger.enableFileLogger = false;
        Logger.enableConsoleLogger = false;
        Logger.formatter = new LogFormatter();
        Logger.logger.setLevel(Level.INFO);
        Logger.logger.setUseParentHandlers(false);
        final Handler[] handlers = Logger.logger.getParent().getHandlers();
        for (int length = handlers.length, i = 0; i < length; ++i) {
            handlers[i].setFormatter(Logger.formatter);
        }
    }
}
