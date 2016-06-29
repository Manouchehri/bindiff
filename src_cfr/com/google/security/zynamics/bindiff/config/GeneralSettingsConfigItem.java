/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.config;

import com.google.security.zynamics.common.config.AbstractConfigItem;
import com.google.security.zynamics.common.config.TypedPropertiesWrapper;

public class GeneralSettingsConfigItem
extends AbstractConfigItem {
    private static final String CONFIG_FILE_FORMAT_VERSION = "ConfigFileFormatVersion";
    private static final int CONFIG_FILE_FORMAT_VERSION_DEFAULT = 1;
    private int configFileFormatVersion = 1;
    private static final String DIFF_ENGINE_PATH = "DiffEnginePath";
    private static final String DIFF_ENGINE_PATH_DEFAULT = "";
    private String diffEnginePath = "";
    private static final String DEFAULT_WORKSPACE = "DefaultWorkspace";
    private static final String DEFAULT_WORKSPACE_DEFAULT = "";
    private String defaultWorkspace = "";
    private static final String IDA_DIRECTORY = "IDADirectory";
    private static final String IDA_DIRECTORY_DEFAULT = "";
    private String idaDirectory = "";
    private static final String WORKSPACE_DIRECTORY = "WorkspaceDirectory";
    private static final String WORKSPACE_DIRECTORY_DEFAULT = "";
    private String workspaceDirectory = "";
    private static final String LAST_WORKSPACE_DIRECTORY_1 = "LastWorkspaceDirectory_1";
    private static final String LAST_WORKSPACE_DIRECTORY_1_DEFAULT = "";
    private String lastWorkspaceDirectory1 = "";
    private static final String LAST_WORKSPACE_DIRECTORY_2 = "LastWorkspaceDirectory_2";
    private static final String LAST_WORKSPACE_DIRECTORY_2_DEFAULT = "";
    private String lastWorkspaceDirectory2 = "";
    private static final String LAST_WORKSPACE_DIRECTORY_3 = "LastWorkspaceDirectory_3";
    private static final String LAST_WORKSPACE_DIRECTORY_3_DEFAULT = "";
    private String lastWorkspaceDirectory3 = "";
    private static final String LAST_WORKSPACE_DIRECTORY_4 = "LastWorkspaceDirectory_4";
    private static final String LAST_WORKSPACE_DIRECTORY_4_DEFAULT = "";
    private String lastWorkspaceDirectory4 = "";
    private static final String SOCKET_PORT = "SocketPort";
    private static final int SOCKET_PORT_DEFAULT = 2000;
    private int socketPort = 2000;
    private static final String HIDE_LICENSE_INFO_DIALOG = "HideLicenseInfoDialog";
    private static final boolean HIDE_LICENSE_INFO_DIALOG_DEFAULT = false;
    private boolean hideLicenseInfoDialog = false;
    private static final String HIDE_LICENSE_INFO_DIALOG_WITH_EXPIREY_WARNING = "HideLicenseInfoDialogWithExpiryWarning";
    private static final boolean HIDE_LICENSE_INFO_DIALOG_WITH_EXPIREY_WARNING_DEFAULT = false;
    private boolean hideLicenseInfoDialogWithExpiryWarning = false;
    private static final String NEW_DIFF_LAST_PRIMARY_DIR = "NewDiffLastPrimaryDir";
    private static final String NEW_DIFF_LAST_PRIMARY_DIR_DEFAULT = "";
    private String newDiffLastPrimaryDir = "";
    private static final String NEW_DIFF_LAST_SECONDARY_DIR = "NewDiffLastSecondaryDir";
    private static final String NEW_DIFF_LAST_SECONDARY_DIR_DEFAULT = "";
    private String newDiffLastSecondaryDir = "";
    private static final String DIRECTORY_DIFF_LAST_PRIMARY_DIR = "DirectoryDiffLastPrimaryDir";
    private static final String DIRECTORY_DIFF_LAST_PRIMARY_DIR_DEFAULT = "";
    private String directoryDiffLastPrimaryDir = "";
    private static final String DIRECTORY_DIFF_LAST_SECONDARY_DIR = "DirectoryDiffLastSecondaryDir";
    private static final String DIRECTORY_DIFF_LAST_SECONDARY_DIR_DEFAULT = "";
    private String directoryDiffLastSecondaryDir = "";
    private static final String ADD_EXISTING_DIFF_LAST_DIR = "AddExistingDiffLastDir";
    private static final String ADD_EXISTING_DIFF_LAST_DIR_DEFAULT = "";
    private String addExistingDiffLastDir = "";
    private static final String CONSOLE_LOGGING = "ConsoleLogging";
    private static final boolean CONSOLE_LOGGING_DEFAULT = false;
    private boolean consoleLogging = false;
    private static final String FILE_LOGGING = "FileLogging";
    private static final boolean FILE_LOGGING_DEFAULT = false;
    private boolean fileLogging = false;
    private static final String LOG_FILE_LOCATION = "LogFileLocation";
    private static final String LOG_FILE_LOCATION_DEFAULT = "";
    private String logFileLocation = "";
    private static final String LOG_VERBOSE = "LogVerbose";
    private static final boolean LOG_VERBOSE_DEFAULT = false;
    private boolean logVerbose = false;
    private static final String LOG_INFO = "LogInfo";
    private static final boolean LOG_INFO_DEFAULT = false;
    private boolean logInfo = false;
    private static final String LOG_WARNING = "LogWarning";
    private static final boolean LOG_WARNING_DEFAULT = false;
    private boolean logWarning = false;
    private static final String LOG_SEVERE = "LogSevere";
    private static final boolean LOG_SEVERE_DEFAULT = false;
    private boolean logSevere = false;
    private static final String LOG_EXCEPTION = "LogException";
    private static final boolean LOG_EXCEPTION_DEFAULT = false;
    private boolean logException = false;
    private static final String LOG_STACKTRACE = "LogStacktrace";
    private static final boolean LOG_STACKTRACE_DEFAULT = false;
    private boolean logStacktrace = false;
    private static final String WINDOW_STATE_WAS_MAXIMIZED = "Window_State_Was_Maximized";
    private static final boolean WINDOW_STATE_WAS_MAXIMIZED_DEFAULT = false;
    private boolean windowStateWasMaximized = false;
    private static final String WINDOW_X_POS = "Window_X_Pos";
    private static final int WINDOW_X_POS_DEFAULT = 0;
    private int windowXPos = 0;
    private static final String WINDOW_Y_POS = "Window_Y_Pos";
    private static final int WINDOW_Y_POS_DEFAULT = 0;
    private int windowYPos = 0;
    private static final String WINDOW_WIDTH = "Window_Width";
    private static final int WINDOW_WIDTH_DEFAULT = 800;
    private int windowWidth = 800;
    private static final String WINDOW_HEIGHT = "Window_Height";
    private static final int WINDOW_HEIGHT_DEFAULT = 600;
    private int windowHeight = 600;
    private static final String SCREEN_WIDTH = "Screen_Width";
    private static final int SCREEN_WIDTH_DEFAULT = 0;
    private int screenWidth = 0;
    private static final String SCREEN_HEIGHT = "Screen_Height";
    private static final int SCREEN_HEIGHT_DEFAULT = 0;
    private int screenHeight = 0;
    private static final String WORKSPACE_TREE_DIVIDER_POSITION = "WorkspaceTreeDividerPosition";
    private static final int WORKSPACE_TREE_DIVIDER_POSITION_DEFAULT = 200;
    private int workspaceTreeDividerPosition = 200;

    @Override
    public void load(TypedPropertiesWrapper typedPropertiesWrapper) {
        this.configFileFormatVersion = typedPropertiesWrapper.getInteger("ConfigFileFormatVersion", 1);
        this.diffEnginePath = typedPropertiesWrapper.getString("DiffEnginePath", "");
        this.defaultWorkspace = typedPropertiesWrapper.getString("DefaultWorkspace", "");
        this.idaDirectory = typedPropertiesWrapper.getString("IDADirectory", "");
        this.workspaceDirectory = typedPropertiesWrapper.getString("WorkspaceDirectory", "");
        this.lastWorkspaceDirectory1 = typedPropertiesWrapper.getString("LastWorkspaceDirectory_1", "");
        this.lastWorkspaceDirectory2 = typedPropertiesWrapper.getString("LastWorkspaceDirectory_2", "");
        this.lastWorkspaceDirectory3 = typedPropertiesWrapper.getString("LastWorkspaceDirectory_3", "");
        this.lastWorkspaceDirectory4 = typedPropertiesWrapper.getString("LastWorkspaceDirectory_4", "");
        this.socketPort = typedPropertiesWrapper.getInteger("SocketPort", 2000);
        this.hideLicenseInfoDialog = typedPropertiesWrapper.getBoolean("HideLicenseInfoDialog", false);
        this.hideLicenseInfoDialogWithExpiryWarning = typedPropertiesWrapper.getBoolean("HideLicenseInfoDialogWithExpiryWarning", false);
        this.newDiffLastPrimaryDir = typedPropertiesWrapper.getString("NewDiffLastPrimaryDir", "");
        this.newDiffLastSecondaryDir = typedPropertiesWrapper.getString("NewDiffLastSecondaryDir", "");
        this.directoryDiffLastPrimaryDir = typedPropertiesWrapper.getString("DirectoryDiffLastPrimaryDir", "");
        this.directoryDiffLastSecondaryDir = typedPropertiesWrapper.getString("DirectoryDiffLastSecondaryDir", "");
        this.addExistingDiffLastDir = typedPropertiesWrapper.getString("AddExistingDiffLastDir", "");
        this.consoleLogging = typedPropertiesWrapper.getBoolean("ConsoleLogging", false);
        this.fileLogging = typedPropertiesWrapper.getBoolean("FileLogging", false);
        this.logFileLocation = typedPropertiesWrapper.getString("LogFileLocation", "");
        this.logVerbose = typedPropertiesWrapper.getBoolean("LogVerbose", false);
        this.logInfo = typedPropertiesWrapper.getBoolean("LogInfo", false);
        this.logWarning = typedPropertiesWrapper.getBoolean("LogWarning", false);
        this.logSevere = typedPropertiesWrapper.getBoolean("LogSevere", false);
        this.logException = typedPropertiesWrapper.getBoolean("LogException", false);
        this.logStacktrace = typedPropertiesWrapper.getBoolean("LogStacktrace", false);
        this.windowStateWasMaximized = typedPropertiesWrapper.getBoolean("Window_State_Was_Maximized", false);
        this.windowXPos = typedPropertiesWrapper.getInteger("Window_X_Pos", 0);
        this.windowYPos = typedPropertiesWrapper.getInteger("Window_Y_Pos", 0);
        this.windowWidth = typedPropertiesWrapper.getInteger("Window_Width", 800);
        this.windowHeight = typedPropertiesWrapper.getInteger("Window_Height", 600);
        this.screenWidth = typedPropertiesWrapper.getInteger("Screen_Width", 0);
        this.screenHeight = typedPropertiesWrapper.getInteger("Screen_Height", 0);
        this.workspaceTreeDividerPosition = typedPropertiesWrapper.getInteger("WorkspaceTreeDividerPosition", 200);
    }

    @Override
    public void store(TypedPropertiesWrapper typedPropertiesWrapper) {
        typedPropertiesWrapper.getString("DiffEnginePath", this.diffEnginePath);
        typedPropertiesWrapper.setString("DefaultWorkspace", this.defaultWorkspace);
        typedPropertiesWrapper.setInteger("ConfigFileFormatVersion", this.configFileFormatVersion);
        typedPropertiesWrapper.setString("IDADirectory", this.idaDirectory);
        typedPropertiesWrapper.setString("WorkspaceDirectory", this.workspaceDirectory);
        typedPropertiesWrapper.getString("LastWorkspaceDirectory_1", this.lastWorkspaceDirectory1);
        typedPropertiesWrapper.getString("LastWorkspaceDirectory_2", this.lastWorkspaceDirectory2);
        typedPropertiesWrapper.getString("LastWorkspaceDirectory_3", this.lastWorkspaceDirectory3);
        typedPropertiesWrapper.getString("LastWorkspaceDirectory_4", this.lastWorkspaceDirectory4);
        typedPropertiesWrapper.setInteger("SocketPort", this.socketPort);
        typedPropertiesWrapper.setBoolean("HideLicenseInfoDialog", this.hideLicenseInfoDialog);
        typedPropertiesWrapper.setBoolean("HideLicenseInfoDialogWithExpiryWarning", this.hideLicenseInfoDialogWithExpiryWarning);
        typedPropertiesWrapper.setString("NewDiffLastPrimaryDir", this.newDiffLastPrimaryDir);
        typedPropertiesWrapper.setString("NewDiffLastSecondaryDir", this.newDiffLastSecondaryDir);
        typedPropertiesWrapper.setString("DirectoryDiffLastPrimaryDir", this.directoryDiffLastPrimaryDir);
        typedPropertiesWrapper.setString("DirectoryDiffLastSecondaryDir", this.directoryDiffLastSecondaryDir);
        typedPropertiesWrapper.setString("AddExistingDiffLastDir", this.addExistingDiffLastDir);
        typedPropertiesWrapper.setBoolean("ConsoleLogging", this.consoleLogging);
        typedPropertiesWrapper.setBoolean("FileLogging", this.fileLogging);
        typedPropertiesWrapper.setString("LogFileLocation", this.logFileLocation);
        typedPropertiesWrapper.setBoolean("LogVerbose", this.logVerbose);
        typedPropertiesWrapper.setBoolean("LogInfo", this.logInfo);
        typedPropertiesWrapper.setBoolean("LogWarning", this.logWarning);
        typedPropertiesWrapper.setBoolean("LogSevere", this.logSevere);
        typedPropertiesWrapper.setBoolean("LogException", this.logException);
        typedPropertiesWrapper.setBoolean("LogStacktrace", this.logStacktrace);
        typedPropertiesWrapper.setBoolean("Window_State_Was_Maximized", this.windowStateWasMaximized);
        typedPropertiesWrapper.setInteger("Window_X_Pos", this.windowXPos);
        typedPropertiesWrapper.setInteger("Window_Y_Pos", this.windowYPos);
        typedPropertiesWrapper.setInteger("Window_Width", this.windowWidth);
        typedPropertiesWrapper.setInteger("Window_Height", this.windowHeight);
        typedPropertiesWrapper.setInteger("Screen_Width", this.screenWidth);
        typedPropertiesWrapper.setInteger("Screen_Height", this.screenHeight);
        typedPropertiesWrapper.setInteger("WorkspaceTreeDividerPosition", this.workspaceTreeDividerPosition);
    }

    public int getVersion() {
        return this.configFileFormatVersion;
    }

    public void setVersion(int n2) {
        this.configFileFormatVersion = n2;
    }

    public String getDefaultWorkspace() {
        return this.defaultWorkspace;
    }

    public void setDefaultWorkspace(String string) {
        this.defaultWorkspace = string;
    }

    public String getDiffEnginePath() {
        return this.diffEnginePath;
    }

    public void setDiffEnginePath(String string) {
        this.diffEnginePath = string;
    }

    public final String getIdaDirectory() {
        return this.idaDirectory;
    }

    public void setIdaDirectory(String string) {
        this.idaDirectory = string;
    }

    public final String getWorkspaceDirectory() {
        return this.workspaceDirectory;
    }

    public void setWorkspaceDirectory(String string) {
        this.workspaceDirectory = string;
    }

    public String getLastWorkspaceDirectory1() {
        return this.lastWorkspaceDirectory1;
    }

    public void setLastWorkspaceDirectory1(String string) {
        this.lastWorkspaceDirectory1 = string;
    }

    public String getLastWorkspaceDirectory2() {
        return this.lastWorkspaceDirectory2;
    }

    public void setLastWorkspaceDirectory2(String string) {
        this.lastWorkspaceDirectory2 = string;
    }

    public String getLastWorkspaceDirectory3() {
        return this.lastWorkspaceDirectory3;
    }

    public void setLastWorkspaceDirectory3(String string) {
        this.lastWorkspaceDirectory3 = string;
    }

    public String getLastWorkspaceDirectory4() {
        return this.lastWorkspaceDirectory4;
    }

    public void setLastWorkspaceDirectory4(String string) {
        this.lastWorkspaceDirectory4 = string;
    }

    public final int getSocketPort() {
        return this.socketPort;
    }

    public final void setSocketPort(int n2) {
        this.socketPort = n2;
    }

    public final boolean getHideLicenseInfoDialog() {
        return this.hideLicenseInfoDialog;
    }

    public final void setHideLicenseInfoDialog(boolean bl2) {
        this.hideLicenseInfoDialog = bl2;
    }

    public final boolean getHideLicenseInfoDialogWithExpiryWarning() {
        return this.hideLicenseInfoDialogWithExpiryWarning;
    }

    public final void setHideLicenseInfoDialogWithExpiryWarning(boolean bl2) {
        this.hideLicenseInfoDialogWithExpiryWarning = bl2;
    }

    public final String getNewDiffLastPrimaryDir() {
        return this.newDiffLastPrimaryDir;
    }

    public final void setNewDiffLastPrimaryDir(String string) {
        this.newDiffLastPrimaryDir = string;
    }

    public final String getNewDiffLastSecondaryDir() {
        return this.newDiffLastSecondaryDir;
    }

    public final void setNewDiffLastSecondaryDir(String string) {
        this.newDiffLastSecondaryDir = string;
    }

    public final String getDirectoryDiffLastPrimaryDir() {
        return this.directoryDiffLastPrimaryDir;
    }

    public final void setDirectoryDiffLastPrimaryDir(String string) {
        this.directoryDiffLastPrimaryDir = string;
    }

    public final String getDirectoryDiffLastSecondaryDir() {
        return this.directoryDiffLastSecondaryDir;
    }

    public final void setDirectoryDiffLastSecondaryDir(String string) {
        this.directoryDiffLastSecondaryDir = string;
    }

    public final String getAddExistingDiffLastDir() {
        return this.addExistingDiffLastDir;
    }

    public final void setAddExistingDiffLastDir(String string) {
        this.addExistingDiffLastDir = string;
    }

    public final boolean getConsoleLogging() {
        return this.consoleLogging;
    }

    public final void setConsoleLogging(boolean bl2) {
        this.consoleLogging = bl2;
    }

    public final boolean getFileLogging() {
        return this.fileLogging;
    }

    public final void setFileLogging(boolean bl2) {
        this.fileLogging = bl2;
    }

    public final String getLogFileLocation() {
        return this.logFileLocation;
    }

    public final void setLogFileLocation(String string) {
        this.logFileLocation = string;
    }

    public final boolean getLogVerbose() {
        return this.logVerbose;
    }

    public final void setLogVerbose(boolean bl2) {
        this.logVerbose = bl2;
    }

    public final boolean getLogInfo() {
        return this.logInfo;
    }

    public final void setLogInfo(boolean bl2) {
        this.logInfo = bl2;
    }

    public final boolean getLogWarning() {
        return this.logWarning;
    }

    public final void setLogWarning(boolean bl2) {
        this.logWarning = bl2;
    }

    public final boolean getLogSevere() {
        return this.logSevere;
    }

    public final void setLogSevere(boolean bl2) {
        this.logSevere = bl2;
    }

    public final boolean getLogException() {
        return this.logException;
    }

    public final void setLogException(boolean bl2) {
        this.logException = bl2;
    }

    public final boolean getLogStacktrace() {
        return this.logStacktrace;
    }

    public final void setLogStacktrace(boolean bl2) {
        this.logStacktrace = bl2;
    }

    public final boolean getWindowStateWasMaximized() {
        return this.windowStateWasMaximized;
    }

    public final void setWindowStateWasMaximized(boolean bl2) {
        this.windowStateWasMaximized = bl2;
    }

    public final int getWindowXPos() {
        return this.windowXPos;
    }

    public final void setWindowXPos(int n2) {
        this.windowXPos = n2;
    }

    public final int getWindowYPos() {
        return this.windowYPos;
    }

    public final void setWindowYPos(int n2) {
        this.windowYPos = n2;
    }

    public final int getWindowWidth() {
        return this.windowWidth;
    }

    public final void setWindowWidth(int n2) {
        this.windowWidth = n2;
    }

    public final int getWindowHeight() {
        return this.windowHeight;
    }

    public final void setWindowHeight(int n2) {
        this.windowHeight = n2;
    }

    public final int getScreenWidth() {
        return this.screenWidth;
    }

    public final void setScreenWidth(int n2) {
        this.screenWidth = n2;
    }

    public final int getScreenHeight() {
        return this.screenHeight;
    }

    public final void setScreenHeight(int n2) {
        this.screenHeight = n2;
    }

    public final int getWorkspaceTreeDividerPosition() {
        return this.workspaceTreeDividerPosition;
    }

    public final void setWorkspaceTreeDividerPosition(int n2) {
        this.workspaceTreeDividerPosition = n2;
    }
}

