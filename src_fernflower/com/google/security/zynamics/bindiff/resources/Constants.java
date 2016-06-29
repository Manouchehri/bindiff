package com.google.security.zynamics.bindiff.resources;

import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.zylib.system.SystemHelpers;
import java.io.File;

public final class Constants {
   public static final boolean SHOW_SUPERGRAPH = false;
   public static final String COMPANY_NAME = "zynamics";
   public static final String PRODUCT_NAME = "BinDiff";
   public static final String PRODUCT_VERSION = "4.2.0";
   public static final String PRODUCT_NAME_VERSION = "BinDiff 4.2";
   public static final String DEFAULT_WINDOW_TITLE = "BinDiff";
   public static final String LOG_FILE_NAME = "bindiff_ui.log";
   public static final String LOG_DIRECTORYNAME = "logs";
   public static final String APP_ICON_PATH_16x16 = "data/appicons/bindiff-16x16-rgba.png";
   public static final String APP_ICON_PATH_32x32 = "data/appicons/bindiff-32x32-rgba.png";
   public static final String APP_ICON_PATH_48x48 = "data/appicons/bindiff-48x48-rgba.png";
   public static final String DEFAULT_BACKGROUND_IMAGE_PATH = "data/appimages/bindiff-background-image.png";
   public static final String ABOUT_BINDIFF_IMAGE_PATH = "data/appimages/bindiff-about-image.png";
   public static final String SPLASHSCREEN_IMAGE_PATH = "data/splashscreen/splashscreen.png";
   public static final String MANUAL_FILE;
   public static final String COPYRIGHT_TEXT = "\nCopyright ©2004-2011 zynamics GmbH\nCopyright ©2011-2015 Google Inc.\n";
   public static final String ZYNAMICS_HOME_URL = "http://www.zynamics.com";
   public static final String ZYNAMICS_BINDIFF_PRODUCT_SITE_URL = "http://www.zynamics.com/bindiff.html";
   public static final String ZYNAMICS_SUPPORT_MAIL_URL = "mailto:zynamics-support@google.com";
   public static final String BUG_REPORT_URL = "http://bugs.zynamics.com/BinDiff";
   public static final String LICENSE_FILENAME = "zynamics BinDiff License Key.txt";
   public static final int SUPPORT_EXPIRY_REMINDER_THRESHOLD_IN_DAYS = 45;
   public static final String BINDIFF_WORKSPACEFILE_EXTENSION = "BinDiffWorkspace";
   public static final String BINDIFF_MATCHES_DB_EXTENSION = "BinDiff";
   public static final String BINDIFF_BINEXPORT_EXTENSION = "BinExport";
   public static final String IDB32_EXTENSION = "idb";
   public static final String IDB64_EXTENSION = "i64";
   public static final String BINDIFF_ENGINE_EXECUTABLE;
   public static final String IDA_EXPORTER_PLUGIN_NAME = "zynamics_binexport_8";
   public static final String IDA_EXPORTER_IDC_COMMAND = "BinExport2Diff8";
   public static final String IDA_EXPORT_SCRIPT_NAME = "export.idc";
   public static final int CALLGRAPH_BINARY_FORMAT_VERSION = 3;
   public static final int WORKSPACE_DATABASE_FORMAT_VERSION = 1;
   public static final String CONFIG_FILENAME = "config.xml";
   public static final int CONFIG_FILEVERSION = 1;
   private static final int SOCKET_SERVER_PORT = 2000;

   public static int getSocketPort() {
      Integer var0 = Integer.valueOf(BinDiffConfigFile.getInstance().getMainSettings().getSocketPort());
      return var0 != null && var0.intValue() >= 0 && var0.intValue() <= 65536?var0.intValue():2000;
   }

   static {
      MANUAL_FILE = "../doc/index.html".replace('/', File.separatorChar);
      if(SystemHelpers.isRunningWindows()) {
         BINDIFF_ENGINE_EXECUTABLE = SystemHelpers.is64BitArchitecture()?"differ64.exe":"differ.exe";
      } else {
         BINDIFF_ENGINE_EXECUTABLE = "differ";
      }

   }
}
