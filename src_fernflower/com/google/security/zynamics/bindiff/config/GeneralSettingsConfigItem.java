package com.google.security.zynamics.bindiff.config;

import com.google.security.zynamics.common.config.AbstractConfigItem;
import com.google.security.zynamics.common.config.TypedPropertiesWrapper;

public class GeneralSettingsConfigItem extends AbstractConfigItem {
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

   public void load(TypedPropertiesWrapper var1) {
      this.configFileFormatVersion = var1.getInteger("ConfigFileFormatVersion", 1);
      this.diffEnginePath = var1.getString("DiffEnginePath", "");
      this.defaultWorkspace = var1.getString("DefaultWorkspace", "");
      this.idaDirectory = var1.getString("IDADirectory", "");
      this.workspaceDirectory = var1.getString("WorkspaceDirectory", "");
      this.lastWorkspaceDirectory1 = var1.getString("LastWorkspaceDirectory_1", "");
      this.lastWorkspaceDirectory2 = var1.getString("LastWorkspaceDirectory_2", "");
      this.lastWorkspaceDirectory3 = var1.getString("LastWorkspaceDirectory_3", "");
      this.lastWorkspaceDirectory4 = var1.getString("LastWorkspaceDirectory_4", "");
      this.socketPort = var1.getInteger("SocketPort", 2000);
      this.hideLicenseInfoDialog = var1.getBoolean("HideLicenseInfoDialog", false);
      this.hideLicenseInfoDialogWithExpiryWarning = var1.getBoolean("HideLicenseInfoDialogWithExpiryWarning", false);
      this.newDiffLastPrimaryDir = var1.getString("NewDiffLastPrimaryDir", "");
      this.newDiffLastSecondaryDir = var1.getString("NewDiffLastSecondaryDir", "");
      this.directoryDiffLastPrimaryDir = var1.getString("DirectoryDiffLastPrimaryDir", "");
      this.directoryDiffLastSecondaryDir = var1.getString("DirectoryDiffLastSecondaryDir", "");
      this.addExistingDiffLastDir = var1.getString("AddExistingDiffLastDir", "");
      this.consoleLogging = var1.getBoolean("ConsoleLogging", false);
      this.fileLogging = var1.getBoolean("FileLogging", false);
      this.logFileLocation = var1.getString("LogFileLocation", "");
      this.logVerbose = var1.getBoolean("LogVerbose", false);
      this.logInfo = var1.getBoolean("LogInfo", false);
      this.logWarning = var1.getBoolean("LogWarning", false);
      this.logSevere = var1.getBoolean("LogSevere", false);
      this.logException = var1.getBoolean("LogException", false);
      this.logStacktrace = var1.getBoolean("LogStacktrace", false);
      this.windowStateWasMaximized = var1.getBoolean("Window_State_Was_Maximized", false);
      this.windowXPos = var1.getInteger("Window_X_Pos", 0);
      this.windowYPos = var1.getInteger("Window_Y_Pos", 0);
      this.windowWidth = var1.getInteger("Window_Width", 800);
      this.windowHeight = var1.getInteger("Window_Height", 600);
      this.screenWidth = var1.getInteger("Screen_Width", 0);
      this.screenHeight = var1.getInteger("Screen_Height", 0);
      this.workspaceTreeDividerPosition = var1.getInteger("WorkspaceTreeDividerPosition", 200);
   }

   public void store(TypedPropertiesWrapper var1) {
      var1.getString("DiffEnginePath", this.diffEnginePath);
      var1.setString("DefaultWorkspace", this.defaultWorkspace);
      var1.setInteger("ConfigFileFormatVersion", this.configFileFormatVersion);
      var1.setString("IDADirectory", this.idaDirectory);
      var1.setString("WorkspaceDirectory", this.workspaceDirectory);
      var1.getString("LastWorkspaceDirectory_1", this.lastWorkspaceDirectory1);
      var1.getString("LastWorkspaceDirectory_2", this.lastWorkspaceDirectory2);
      var1.getString("LastWorkspaceDirectory_3", this.lastWorkspaceDirectory3);
      var1.getString("LastWorkspaceDirectory_4", this.lastWorkspaceDirectory4);
      var1.setInteger("SocketPort", this.socketPort);
      var1.setBoolean("HideLicenseInfoDialog", this.hideLicenseInfoDialog);
      var1.setBoolean("HideLicenseInfoDialogWithExpiryWarning", this.hideLicenseInfoDialogWithExpiryWarning);
      var1.setString("NewDiffLastPrimaryDir", this.newDiffLastPrimaryDir);
      var1.setString("NewDiffLastSecondaryDir", this.newDiffLastSecondaryDir);
      var1.setString("DirectoryDiffLastPrimaryDir", this.directoryDiffLastPrimaryDir);
      var1.setString("DirectoryDiffLastSecondaryDir", this.directoryDiffLastSecondaryDir);
      var1.setString("AddExistingDiffLastDir", this.addExistingDiffLastDir);
      var1.setBoolean("ConsoleLogging", this.consoleLogging);
      var1.setBoolean("FileLogging", this.fileLogging);
      var1.setString("LogFileLocation", this.logFileLocation);
      var1.setBoolean("LogVerbose", this.logVerbose);
      var1.setBoolean("LogInfo", this.logInfo);
      var1.setBoolean("LogWarning", this.logWarning);
      var1.setBoolean("LogSevere", this.logSevere);
      var1.setBoolean("LogException", this.logException);
      var1.setBoolean("LogStacktrace", this.logStacktrace);
      var1.setBoolean("Window_State_Was_Maximized", this.windowStateWasMaximized);
      var1.setInteger("Window_X_Pos", this.windowXPos);
      var1.setInteger("Window_Y_Pos", this.windowYPos);
      var1.setInteger("Window_Width", this.windowWidth);
      var1.setInteger("Window_Height", this.windowHeight);
      var1.setInteger("Screen_Width", this.screenWidth);
      var1.setInteger("Screen_Height", this.screenHeight);
      var1.setInteger("WorkspaceTreeDividerPosition", this.workspaceTreeDividerPosition);
   }

   public int getVersion() {
      return this.configFileFormatVersion;
   }

   public void setVersion(int var1) {
      this.configFileFormatVersion = var1;
   }

   public String getDefaultWorkspace() {
      return this.defaultWorkspace;
   }

   public void setDefaultWorkspace(String var1) {
      this.defaultWorkspace = var1;
   }

   public String getDiffEnginePath() {
      return this.diffEnginePath;
   }

   public void setDiffEnginePath(String var1) {
      this.diffEnginePath = var1;
   }

   public final String getIdaDirectory() {
      return this.idaDirectory;
   }

   public void setIdaDirectory(String var1) {
      this.idaDirectory = var1;
   }

   public final String getWorkspaceDirectory() {
      return this.workspaceDirectory;
   }

   public void setWorkspaceDirectory(String var1) {
      this.workspaceDirectory = var1;
   }

   public String getLastWorkspaceDirectory1() {
      return this.lastWorkspaceDirectory1;
   }

   public void setLastWorkspaceDirectory1(String var1) {
      this.lastWorkspaceDirectory1 = var1;
   }

   public String getLastWorkspaceDirectory2() {
      return this.lastWorkspaceDirectory2;
   }

   public void setLastWorkspaceDirectory2(String var1) {
      this.lastWorkspaceDirectory2 = var1;
   }

   public String getLastWorkspaceDirectory3() {
      return this.lastWorkspaceDirectory3;
   }

   public void setLastWorkspaceDirectory3(String var1) {
      this.lastWorkspaceDirectory3 = var1;
   }

   public String getLastWorkspaceDirectory4() {
      return this.lastWorkspaceDirectory4;
   }

   public void setLastWorkspaceDirectory4(String var1) {
      this.lastWorkspaceDirectory4 = var1;
   }

   public final int getSocketPort() {
      return this.socketPort;
   }

   public final void setSocketPort(int var1) {
      this.socketPort = var1;
   }

   public final boolean getHideLicenseInfoDialog() {
      return this.hideLicenseInfoDialog;
   }

   public final void setHideLicenseInfoDialog(boolean var1) {
      this.hideLicenseInfoDialog = var1;
   }

   public final boolean getHideLicenseInfoDialogWithExpiryWarning() {
      return this.hideLicenseInfoDialogWithExpiryWarning;
   }

   public final void setHideLicenseInfoDialogWithExpiryWarning(boolean var1) {
      this.hideLicenseInfoDialogWithExpiryWarning = var1;
   }

   public final String getNewDiffLastPrimaryDir() {
      return this.newDiffLastPrimaryDir;
   }

   public final void setNewDiffLastPrimaryDir(String var1) {
      this.newDiffLastPrimaryDir = var1;
   }

   public final String getNewDiffLastSecondaryDir() {
      return this.newDiffLastSecondaryDir;
   }

   public final void setNewDiffLastSecondaryDir(String var1) {
      this.newDiffLastSecondaryDir = var1;
   }

   public final String getDirectoryDiffLastPrimaryDir() {
      return this.directoryDiffLastPrimaryDir;
   }

   public final void setDirectoryDiffLastPrimaryDir(String var1) {
      this.directoryDiffLastPrimaryDir = var1;
   }

   public final String getDirectoryDiffLastSecondaryDir() {
      return this.directoryDiffLastSecondaryDir;
   }

   public final void setDirectoryDiffLastSecondaryDir(String var1) {
      this.directoryDiffLastSecondaryDir = var1;
   }

   public final String getAddExistingDiffLastDir() {
      return this.addExistingDiffLastDir;
   }

   public final void setAddExistingDiffLastDir(String var1) {
      this.addExistingDiffLastDir = var1;
   }

   public final boolean getConsoleLogging() {
      return this.consoleLogging;
   }

   public final void setConsoleLogging(boolean var1) {
      this.consoleLogging = var1;
   }

   public final boolean getFileLogging() {
      return this.fileLogging;
   }

   public final void setFileLogging(boolean var1) {
      this.fileLogging = var1;
   }

   public final String getLogFileLocation() {
      return this.logFileLocation;
   }

   public final void setLogFileLocation(String var1) {
      this.logFileLocation = var1;
   }

   public final boolean getLogVerbose() {
      return this.logVerbose;
   }

   public final void setLogVerbose(boolean var1) {
      this.logVerbose = var1;
   }

   public final boolean getLogInfo() {
      return this.logInfo;
   }

   public final void setLogInfo(boolean var1) {
      this.logInfo = var1;
   }

   public final boolean getLogWarning() {
      return this.logWarning;
   }

   public final void setLogWarning(boolean var1) {
      this.logWarning = var1;
   }

   public final boolean getLogSevere() {
      return this.logSevere;
   }

   public final void setLogSevere(boolean var1) {
      this.logSevere = var1;
   }

   public final boolean getLogException() {
      return this.logException;
   }

   public final void setLogException(boolean var1) {
      this.logException = var1;
   }

   public final boolean getLogStacktrace() {
      return this.logStacktrace;
   }

   public final void setLogStacktrace(boolean var1) {
      this.logStacktrace = var1;
   }

   public final boolean getWindowStateWasMaximized() {
      return this.windowStateWasMaximized;
   }

   public final void setWindowStateWasMaximized(boolean var1) {
      this.windowStateWasMaximized = var1;
   }

   public final int getWindowXPos() {
      return this.windowXPos;
   }

   public final void setWindowXPos(int var1) {
      this.windowXPos = var1;
   }

   public final int getWindowYPos() {
      return this.windowYPos;
   }

   public final void setWindowYPos(int var1) {
      this.windowYPos = var1;
   }

   public final int getWindowWidth() {
      return this.windowWidth;
   }

   public final void setWindowWidth(int var1) {
      this.windowWidth = var1;
   }

   public final int getWindowHeight() {
      return this.windowHeight;
   }

   public final void setWindowHeight(int var1) {
      this.windowHeight = var1;
   }

   public final int getScreenWidth() {
      return this.screenWidth;
   }

   public final void setScreenWidth(int var1) {
      this.screenWidth = var1;
   }

   public final int getScreenHeight() {
      return this.screenHeight;
   }

   public final void setScreenHeight(int var1) {
      this.screenHeight = var1;
   }

   public final int getWorkspaceTreeDividerPosition() {
      return this.workspaceTreeDividerPosition;
   }

   public final void setWorkspaceTreeDividerPosition(int var1) {
      this.workspaceTreeDividerPosition = var1;
   }
}
