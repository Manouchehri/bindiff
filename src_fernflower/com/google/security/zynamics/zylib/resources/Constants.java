package com.google.security.zynamics.zylib.resources;

import java.util.ResourceBundle;

public class Constants {
   public static final String OK;
   public static final String CANCEL;
   public static final String OK2;
   public static final String CANCEL2;
   public static final String MENU_FILE;
   public static final String MENU_CLOSE_ACTIVE_TAB;
   public static final String MENU_OPEN_NEW_TAB;
   public static final String MENU_LOAD_SCRIPT;
   public static final String MENU_SAVE_SCRIPT;
   public static final String MENU_SAVE_SCRIPT_AS;
   public static final String MENU_EXECUTE_SCRIPT;
   public static final String MENU_EXECUTE_AGAIN_SCRIPT;
   public static final String MESSAGE_RUNNING_SCRIPT;
   public static final String MENU_EDIT;
   public static final String MENU_EDIT_UNDO;
   public static final String MENU_EDIT_REDO;
   public static final String MENU_EDIT_CUT;
   public static final String MENU_EDIT_COPY;
   public static final String MENU_EDIT_PASTE;
   public static final String MENU_SCRIPTING_CONSOLE;
   public static final String COLOR_CHOOSER;
   public static final String RGB;
   public static final String RED;
   public static final String GREEN;
   public static final String BLUE;
   public static final String PREVIEW;
   public static final String HIDE_NEVER;
   public static final String HIDE_ALWAYS;
   public static final String THRESHOLD;
   public static final String ASK_FILE_OVERWRITE;

   static {
      ResourceBundle var0 = ResourceBundle.getBundle("com.google.security.zynamics.zylib.resources.Strings");
      OK = var0.getString("OK");
      CANCEL = var0.getString("CANCEL");
      OK2 = var0.getString("OK2");
      CANCEL2 = var0.getString("CANCEL2");
      PREVIEW = var0.getString("PREVIEW");
      MENU_FILE = var0.getString("MENU_FILE");
      MENU_CLOSE_ACTIVE_TAB = var0.getString("MENU_CLOSE_ACTIVE_TAB");
      MENU_OPEN_NEW_TAB = var0.getString("MENU_OPEN_NEW_TAB");
      MENU_LOAD_SCRIPT = var0.getString("MENU_LOAD_SCRIPT");
      MENU_SAVE_SCRIPT = var0.getString("MENU_SAVE_SCRIPT");
      MENU_SAVE_SCRIPT_AS = var0.getString("MENU_SAVE_SCRIPT_AS");
      MENU_EXECUTE_SCRIPT = var0.getString("MENU_EXECUTE_SCRIPT");
      MENU_EXECUTE_AGAIN_SCRIPT = var0.getString("MENU_EXECUTE_AGAIN_SCRIPT");
      MENU_EDIT = var0.getString("MENU_EDIT");
      MENU_EDIT_UNDO = var0.getString("MENU_EDIT_UNDO");
      MENU_EDIT_REDO = var0.getString("MENU_EDIT_REDO");
      MENU_EDIT_CUT = var0.getString("MENU_EDIT_CUT");
      MENU_EDIT_COPY = var0.getString("MENU_EDIT_COPY");
      MENU_EDIT_PASTE = var0.getString("MENU_EDIT_PASTE");
      MENU_SCRIPTING_CONSOLE = var0.getString("MENU_SCRIPTING_CONSOLE");
      MESSAGE_RUNNING_SCRIPT = var0.getString("MESSAGE_RUNNING_SCRIPT");
      COLOR_CHOOSER = var0.getString("COLOR_CHOOSER");
      RGB = var0.getString("RGB");
      RED = var0.getString("RED");
      GREEN = var0.getString("GREEN");
      BLUE = var0.getString("BLUE");
      HIDE_NEVER = var0.getString("HIDE_NEVER");
      HIDE_ALWAYS = var0.getString("HIDE_ALWAYS");
      THRESHOLD = var0.getString("THRESHOLD");
      ASK_FILE_OVERWRITE = var0.getString("ASK_FILE_OVERWRITE");
   }
}
