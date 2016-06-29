package com.google.security.zynamics.bindiff.config;

import com.google.security.zynamics.common.config.*;

public class GeneralSettingsConfigItem extends AbstractConfigItem
{
    private static final String CONFIG_FILE_FORMAT_VERSION = "ConfigFileFormatVersion";
    private static final int CONFIG_FILE_FORMAT_VERSION_DEFAULT = 1;
    private int configFileFormatVersion;
    private static final String DIFF_ENGINE_PATH = "DiffEnginePath";
    private static final String DIFF_ENGINE_PATH_DEFAULT = "";
    private String diffEnginePath;
    private static final String DEFAULT_WORKSPACE = "DefaultWorkspace";
    private static final String DEFAULT_WORKSPACE_DEFAULT = "";
    private String defaultWorkspace;
    private static final String IDA_DIRECTORY = "IDADirectory";
    private static final String IDA_DIRECTORY_DEFAULT = "";
    private String idaDirectory;
    private static final String WORKSPACE_DIRECTORY = "WorkspaceDirectory";
    private static final String WORKSPACE_DIRECTORY_DEFAULT = "";
    private String workspaceDirectory;
    private static final String LAST_WORKSPACE_DIRECTORY_1 = "LastWorkspaceDirectory_1";
    private static final String LAST_WORKSPACE_DIRECTORY_1_DEFAULT = "";
    private String lastWorkspaceDirectory1;
    private static final String LAST_WORKSPACE_DIRECTORY_2 = "LastWorkspaceDirectory_2";
    private static final String LAST_WORKSPACE_DIRECTORY_2_DEFAULT = "";
    private String lastWorkspaceDirectory2;
    private static final String LAST_WORKSPACE_DIRECTORY_3 = "LastWorkspaceDirectory_3";
    private static final String LAST_WORKSPACE_DIRECTORY_3_DEFAULT = "";
    private String lastWorkspaceDirectory3;
    private static final String LAST_WORKSPACE_DIRECTORY_4 = "LastWorkspaceDirectory_4";
    private static final String LAST_WORKSPACE_DIRECTORY_4_DEFAULT = "";
    private String lastWorkspaceDirectory4;
    private static final String SOCKET_PORT = "SocketPort";
    private static final int SOCKET_PORT_DEFAULT = 2000;
    private int socketPort;
    private static final String HIDE_LICENSE_INFO_DIALOG = "HideLicenseInfoDialog";
    private static final boolean HIDE_LICENSE_INFO_DIALOG_DEFAULT = false;
    private boolean hideLicenseInfoDialog;
    private static final String HIDE_LICENSE_INFO_DIALOG_WITH_EXPIREY_WARNING = "HideLicenseInfoDialogWithExpiryWarning";
    private static final boolean HIDE_LICENSE_INFO_DIALOG_WITH_EXPIREY_WARNING_DEFAULT = false;
    private boolean hideLicenseInfoDialogWithExpiryWarning;
    private static final String NEW_DIFF_LAST_PRIMARY_DIR = "NewDiffLastPrimaryDir";
    private static final String NEW_DIFF_LAST_PRIMARY_DIR_DEFAULT = "";
    private String newDiffLastPrimaryDir;
    private static final String NEW_DIFF_LAST_SECONDARY_DIR = "NewDiffLastSecondaryDir";
    private static final String NEW_DIFF_LAST_SECONDARY_DIR_DEFAULT = "";
    private String newDiffLastSecondaryDir;
    private static final String DIRECTORY_DIFF_LAST_PRIMARY_DIR = "DirectoryDiffLastPrimaryDir";
    private static final String DIRECTORY_DIFF_LAST_PRIMARY_DIR_DEFAULT = "";
    private String directoryDiffLastPrimaryDir;
    private static final String DIRECTORY_DIFF_LAST_SECONDARY_DIR = "DirectoryDiffLastSecondaryDir";
    private static final String DIRECTORY_DIFF_LAST_SECONDARY_DIR_DEFAULT = "";
    private String directoryDiffLastSecondaryDir;
    private static final String ADD_EXISTING_DIFF_LAST_DIR = "AddExistingDiffLastDir";
    private static final String ADD_EXISTING_DIFF_LAST_DIR_DEFAULT = "";
    private String addExistingDiffLastDir;
    private static final String CONSOLE_LOGGING = "ConsoleLogging";
    private static final boolean CONSOLE_LOGGING_DEFAULT = false;
    private boolean consoleLogging;
    private static final String FILE_LOGGING = "FileLogging";
    private static final boolean FILE_LOGGING_DEFAULT = false;
    private boolean fileLogging;
    private static final String LOG_FILE_LOCATION = "LogFileLocation";
    private static final String LOG_FILE_LOCATION_DEFAULT = "";
    private String logFileLocation;
    private static final String LOG_VERBOSE = "LogVerbose";
    private static final boolean LOG_VERBOSE_DEFAULT = false;
    private boolean logVerbose;
    private static final String LOG_INFO = "LogInfo";
    private static final boolean LOG_INFO_DEFAULT = false;
    private boolean logInfo;
    private static final String LOG_WARNING = "LogWarning";
    private static final boolean LOG_WARNING_DEFAULT = false;
    private boolean logWarning;
    private static final String LOG_SEVERE = "LogSevere";
    private static final boolean LOG_SEVERE_DEFAULT = false;
    private boolean logSevere;
    private static final String LOG_EXCEPTION = "LogException";
    private static final boolean LOG_EXCEPTION_DEFAULT = false;
    private boolean logException;
    private static final String LOG_STACKTRACE = "LogStacktrace";
    private static final boolean LOG_STACKTRACE_DEFAULT = false;
    private boolean logStacktrace;
    private static final String WINDOW_STATE_WAS_MAXIMIZED = "Window_State_Was_Maximized";
    private static final boolean WINDOW_STATE_WAS_MAXIMIZED_DEFAULT = false;
    private boolean windowStateWasMaximized;
    private static final String WINDOW_X_POS = "Window_X_Pos";
    private static final int WINDOW_X_POS_DEFAULT = 0;
    private int windowXPos;
    private static final String WINDOW_Y_POS = "Window_Y_Pos";
    private static final int WINDOW_Y_POS_DEFAULT = 0;
    private int windowYPos;
    private static final String WINDOW_WIDTH = "Window_Width";
    private static final int WINDOW_WIDTH_DEFAULT = 800;
    private int windowWidth;
    private static final String WINDOW_HEIGHT = "Window_Height";
    private static final int WINDOW_HEIGHT_DEFAULT = 600;
    private int windowHeight;
    private static final String SCREEN_WIDTH = "Screen_Width";
    private static final int SCREEN_WIDTH_DEFAULT = 0;
    private int screenWidth;
    private static final String SCREEN_HEIGHT = "Screen_Height";
    private static final int SCREEN_HEIGHT_DEFAULT = 0;
    private int screenHeight;
    private static final String WORKSPACE_TREE_DIVIDER_POSITION = "WorkspaceTreeDividerPosition";
    private static final int WORKSPACE_TREE_DIVIDER_POSITION_DEFAULT = 200;
    private int workspaceTreeDividerPosition;
    
    public GeneralSettingsConfigItem() {
        this.configFileFormatVersion = 1;
        this.diffEnginePath = "";
        this.defaultWorkspace = "";
        this.idaDirectory = "";
        this.workspaceDirectory = "";
        this.lastWorkspaceDirectory1 = "";
        this.lastWorkspaceDirectory2 = "";
        this.lastWorkspaceDirectory3 = "";
        this.lastWorkspaceDirectory4 = "";
        this.socketPort = 2000;
        this.hideLicenseInfoDialog = false;
        this.hideLicenseInfoDialogWithExpiryWarning = false;
        this.newDiffLastPrimaryDir = "";
        this.newDiffLastSecondaryDir = "";
        this.directoryDiffLastPrimaryDir = "";
        this.directoryDiffLastSecondaryDir = "";
        this.addExistingDiffLastDir = "";
        this.consoleLogging = false;
        this.fileLogging = false;
        this.logFileLocation = "";
        this.logVerbose = false;
        this.logInfo = false;
        this.logWarning = false;
        this.logSevere = false;
        this.logException = false;
        this.logStacktrace = false;
        this.windowStateWasMaximized = false;
        this.windowXPos = 0;
        this.windowYPos = 0;
        this.windowWidth = 800;
        this.windowHeight = 600;
        this.screenWidth = 0;
        this.screenHeight = 0;
        this.workspaceTreeDividerPosition = 200;
    }
    
    @Override
    public void load(final TypedPropertiesWrapper typedPropertiesWrapper) {
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
    public void store(final TypedPropertiesWrapper typedPropertiesWrapper) {
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
    
    public void setVersion(final int configFileFormatVersion) {
        this.configFileFormatVersion = configFileFormatVersion;
    }
    
    public String getDefaultWorkspace() {
        return this.defaultWorkspace;
    }
    
    public void setDefaultWorkspace(final String defaultWorkspace) {
        this.defaultWorkspace = defaultWorkspace;
    }
    
    public String getDiffEnginePath() {
        return this.diffEnginePath;
    }
    
    public void setDiffEnginePath(final String diffEnginePath) {
        this.diffEnginePath = diffEnginePath;
    }
    
    public final String getIdaDirectory() {
        return this.idaDirectory;
    }
    
    public void setIdaDirectory(final String idaDirectory) {
        this.idaDirectory = idaDirectory;
    }
    
    public final String getWorkspaceDirectory() {
        return this.workspaceDirectory;
    }
    
    public void setWorkspaceDirectory(final String workspaceDirectory) {
        this.workspaceDirectory = workspaceDirectory;
    }
    
    public String getLastWorkspaceDirectory1() {
        return this.lastWorkspaceDirectory1;
    }
    
    public void setLastWorkspaceDirectory1(final String lastWorkspaceDirectory1) {
        this.lastWorkspaceDirectory1 = lastWorkspaceDirectory1;
    }
    
    public String getLastWorkspaceDirectory2() {
        return this.lastWorkspaceDirectory2;
    }
    
    public void setLastWorkspaceDirectory2(final String lastWorkspaceDirectory2) {
        this.lastWorkspaceDirectory2 = lastWorkspaceDirectory2;
    }
    
    public String getLastWorkspaceDirectory3() {
        return this.lastWorkspaceDirectory3;
    }
    
    public void setLastWorkspaceDirectory3(final String lastWorkspaceDirectory3) {
        this.lastWorkspaceDirectory3 = lastWorkspaceDirectory3;
    }
    
    public String getLastWorkspaceDirectory4() {
        return this.lastWorkspaceDirectory4;
    }
    
    public void setLastWorkspaceDirectory4(final String lastWorkspaceDirectory4) {
        this.lastWorkspaceDirectory4 = lastWorkspaceDirectory4;
    }
    
    public final int getSocketPort() {
        return this.socketPort;
    }
    
    public final void setSocketPort(final int socketPort) {
        this.socketPort = socketPort;
    }
    
    public final boolean getHideLicenseInfoDialog() {
        return this.hideLicenseInfoDialog;
    }
    
    public final void setHideLicenseInfoDialog(final boolean hideLicenseInfoDialog) {
        this.hideLicenseInfoDialog = hideLicenseInfoDialog;
    }
    
    public final boolean getHideLicenseInfoDialogWithExpiryWarning() {
        return this.hideLicenseInfoDialogWithExpiryWarning;
    }
    
    public final void setHideLicenseInfoDialogWithExpiryWarning(final boolean hideLicenseInfoDialogWithExpiryWarning) {
        this.hideLicenseInfoDialogWithExpiryWarning = hideLicenseInfoDialogWithExpiryWarning;
    }
    
    public final String getNewDiffLastPrimaryDir() {
        return this.newDiffLastPrimaryDir;
    }
    
    public final void setNewDiffLastPrimaryDir(final String newDiffLastPrimaryDir) {
        this.newDiffLastPrimaryDir = newDiffLastPrimaryDir;
    }
    
    public final String getNewDiffLastSecondaryDir() {
        return this.newDiffLastSecondaryDir;
    }
    
    public final void setNewDiffLastSecondaryDir(final String newDiffLastSecondaryDir) {
        this.newDiffLastSecondaryDir = newDiffLastSecondaryDir;
    }
    
    public final String getDirectoryDiffLastPrimaryDir() {
        return this.directoryDiffLastPrimaryDir;
    }
    
    public final void setDirectoryDiffLastPrimaryDir(final String directoryDiffLastPrimaryDir) {
        this.directoryDiffLastPrimaryDir = directoryDiffLastPrimaryDir;
    }
    
    public final String getDirectoryDiffLastSecondaryDir() {
        return this.directoryDiffLastSecondaryDir;
    }
    
    public final void setDirectoryDiffLastSecondaryDir(final String directoryDiffLastSecondaryDir) {
        this.directoryDiffLastSecondaryDir = directoryDiffLastSecondaryDir;
    }
    
    public final String getAddExistingDiffLastDir() {
        return this.addExistingDiffLastDir;
    }
    
    public final void setAddExistingDiffLastDir(final String addExistingDiffLastDir) {
        this.addExistingDiffLastDir = addExistingDiffLastDir;
    }
    
    public final boolean getConsoleLogging() {
        return this.consoleLogging;
    }
    
    public final void setConsoleLogging(final boolean consoleLogging) {
        this.consoleLogging = consoleLogging;
    }
    
    public final boolean getFileLogging() {
        return this.fileLogging;
    }
    
    public final void setFileLogging(final boolean fileLogging) {
        this.fileLogging = fileLogging;
    }
    
    public final String getLogFileLocation() {
        return this.logFileLocation;
    }
    
    public final void setLogFileLocation(final String logFileLocation) {
        this.logFileLocation = logFileLocation;
    }
    
    public final boolean getLogVerbose() {
        return this.logVerbose;
    }
    
    public final void setLogVerbose(final boolean logVerbose) {
        this.logVerbose = logVerbose;
    }
    
    public final boolean getLogInfo() {
        return this.logInfo;
    }
    
    public final void setLogInfo(final boolean logInfo) {
        this.logInfo = logInfo;
    }
    
    public final boolean getLogWarning() {
        return this.logWarning;
    }
    
    public final void setLogWarning(final boolean logWarning) {
        this.logWarning = logWarning;
    }
    
    public final boolean getLogSevere() {
        return this.logSevere;
    }
    
    public final void setLogSevere(final boolean logSevere) {
        this.logSevere = logSevere;
    }
    
    public final boolean getLogException() {
        return this.logException;
    }
    
    public final void setLogException(final boolean logException) {
        this.logException = logException;
    }
    
    public final boolean getLogStacktrace() {
        return this.logStacktrace;
    }
    
    public final void setLogStacktrace(final boolean logStacktrace) {
        this.logStacktrace = logStacktrace;
    }
    
    public final boolean getWindowStateWasMaximized() {
        return this.windowStateWasMaximized;
    }
    
    public final void setWindowStateWasMaximized(final boolean windowStateWasMaximized) {
        this.windowStateWasMaximized = windowStateWasMaximized;
    }
    
    public final int getWindowXPos() {
        return this.windowXPos;
    }
    
    public final void setWindowXPos(final int windowXPos) {
        this.windowXPos = windowXPos;
    }
    
    public final int getWindowYPos() {
        return this.windowYPos;
    }
    
    public final void setWindowYPos(final int windowYPos) {
        this.windowYPos = windowYPos;
    }
    
    public final int getWindowWidth() {
        return this.windowWidth;
    }
    
    public final void setWindowWidth(final int windowWidth) {
        this.windowWidth = windowWidth;
    }
    
    public final int getWindowHeight() {
        return this.windowHeight;
    }
    
    public final void setWindowHeight(final int windowHeight) {
        this.windowHeight = windowHeight;
    }
    
    public final int getScreenWidth() {
        return this.screenWidth;
    }
    
    public final void setScreenWidth(final int screenWidth) {
        this.screenWidth = screenWidth;
    }
    
    public final int getScreenHeight() {
        return this.screenHeight;
    }
    
    public final void setScreenHeight(final int screenHeight) {
        this.screenHeight = screenHeight;
    }
    
    public final int getWorkspaceTreeDividerPosition() {
        return this.workspaceTreeDividerPosition;
    }
    
    public final void setWorkspaceTreeDividerPosition(final int workspaceTreeDividerPosition) {
        this.workspaceTreeDividerPosition = workspaceTreeDividerPosition;
    }
}
