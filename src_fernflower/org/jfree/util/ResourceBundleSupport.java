package org.jfree.util;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.lang.reflect.Field;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.KeyStroke;
import org.jfree.util.Log;
import org.jfree.util.ObjectUtilities;

public class ResourceBundleSupport {
   private ResourceBundle resources;
   private TreeMap cache;
   private TreeSet lookupPath;
   private String resourceBase;
   private Locale locale;
   static Class class$org$jfree$util$ResourceBundleSupport;
   static Class class$java$awt$event$KeyEvent;

   public ResourceBundleSupport(Locale var1, String var2) {
      this(var1, ResourceBundle.getBundle(var2, var1), var2);
   }

   protected ResourceBundleSupport(Locale var1, ResourceBundle var2, String var3) {
      if(var1 == null) {
         throw new NullPointerException("Locale must not be null");
      } else if(var2 == null) {
         throw new NullPointerException("Resources must not be null");
      } else if(var3 == null) {
         throw new NullPointerException("BaseName must not be null");
      } else {
         this.locale = var1;
         this.resources = var2;
         this.resourceBase = var3;
         this.cache = new TreeMap();
         this.lookupPath = new TreeSet();
      }
   }

   public ResourceBundleSupport(Locale var1, ResourceBundle var2) {
      this(var1, var2, var2.toString());
   }

   public ResourceBundleSupport(String var1) {
      this(Locale.getDefault(), ResourceBundle.getBundle(var1), var1);
   }

   protected ResourceBundleSupport(ResourceBundle var1, String var2) {
      this(Locale.getDefault(), var1, var2);
   }

   public ResourceBundleSupport(ResourceBundle var1) {
      this(Locale.getDefault(), var1, var1.toString());
   }

   protected final String getResourceBase() {
      return this.resourceBase;
   }

   public synchronized String getString(String var1) {
      String var2 = (String)this.cache.get(var1);
      if(var2 != null) {
         return var2;
      } else {
         this.lookupPath.clear();
         return this.internalGetString(var1);
      }
   }

   protected String internalGetString(String var1) {
      if(this.lookupPath.contains(var1)) {
         throw new MissingResourceException("InfiniteLoop in resource lookup", this.getResourceBase(), this.lookupPath.toString());
      } else {
         String var2 = this.resources.getString(var1);
         if(var2.startsWith("@@")) {
            int var6 = var2.indexOf(64, 2);
            if(var6 == -1) {
               throw new MissingResourceException("Invalid format for global lookup key.", this.getResourceBase(), var1);
            } else {
               try {
                  ResourceBundle var7 = ResourceBundle.getBundle(var2.substring(2, var6));
                  return var7.getString(var2.substring(var6 + 1));
               } catch (Exception var5) {
                  Log.error("Error during global lookup", var5);
                  throw new MissingResourceException("Error during global lookup", this.getResourceBase(), var1);
               }
            }
         } else if(var2.startsWith("@")) {
            String var3 = var2.substring(1);
            this.lookupPath.add(var1);
            String var4 = this.internalGetString(var3);
            this.cache.put(var1, var4);
            return var4;
         } else {
            this.cache.put(var1, var2);
            return var2;
         }
      }
   }

   public Icon getIcon(String var1, boolean var2) {
      String var3 = this.getString(var1);
      return this.createIcon(var3, true, var2);
   }

   public Icon getIcon(String var1) {
      String var2 = this.getString(var1);
      return this.createIcon(var2, false, false);
   }

   public Integer getMnemonic(String var1) {
      String var2 = this.getString(var1);
      return this.createMnemonic(var2);
   }

   public Integer getOptionalMnemonic(String var1) {
      String var2 = this.getString(var1);
      return var2 != null && var2.length() > 0?this.createMnemonic(var2):null;
   }

   public KeyStroke getKeyStroke(String var1) {
      return this.getKeyStroke(var1, this.getMenuKeyMask());
   }

   public KeyStroke getOptionalKeyStroke(String var1) {
      return this.getOptionalKeyStroke(var1, this.getMenuKeyMask());
   }

   public KeyStroke getKeyStroke(String var1, int var2) {
      String var3 = this.getString(var1);
      return KeyStroke.getKeyStroke(this.createMnemonic(var3).intValue(), var2);
   }

   public KeyStroke getOptionalKeyStroke(String var1, int var2) {
      String var3 = this.getString(var1);
      return var3 != null && var3.length() > 0?KeyStroke.getKeyStroke(this.createMnemonic(var3).intValue(), var2):null;
   }

   public JMenu createMenu(String var1) {
      JMenu var2 = new JMenu();
      var2.setText(this.getString(var1 + ".name"));
      var2.setMnemonic(this.getMnemonic(var1 + ".mnemonic").intValue());
      return var2;
   }

   public URL getResourceURL(String var1) {
      String var2 = this.getString(var1);
      URL var3 = ObjectUtilities.getResource(var2, class$org$jfree$util$ResourceBundleSupport == null?(class$org$jfree$util$ResourceBundleSupport = class$("org.jfree.util.ResourceBundleSupport")):class$org$jfree$util$ResourceBundleSupport);
      if(var3 == null) {
         Log.warn("Unable to find file in the class path: " + var2 + "; key=" + var1);
      }

      return var3;
   }

   private ImageIcon createIcon(String var1, boolean var2, boolean var3) {
      URL var4 = ObjectUtilities.getResource(var1, class$org$jfree$util$ResourceBundleSupport == null?(class$org$jfree$util$ResourceBundleSupport = class$("org.jfree.util.ResourceBundleSupport")):class$org$jfree$util$ResourceBundleSupport);
      if(var4 == null) {
         Log.warn("Unable to find file in the class path: " + var1);
         return new ImageIcon(this.createTransparentImage(1, 1));
      } else {
         Image var5 = Toolkit.getDefaultToolkit().createImage(var4);
         if(var5 == null) {
            Log.warn("Unable to instantiate the image: " + var1);
            return new ImageIcon(this.createTransparentImage(1, 1));
         } else {
            return var2?(var3?new ImageIcon(var5.getScaledInstance(24, 24, 4)):new ImageIcon(var5.getScaledInstance(16, 16, 4))):new ImageIcon(var5);
         }
      }
   }

   private Integer createMnemonic(String var1) {
      if(var1 == null) {
         throw new NullPointerException("Key is null.");
      } else if(var1.length() == 0) {
         throw new IllegalArgumentException("Key is empty.");
      } else {
         int var2 = var1.charAt(0);
         if(var1.startsWith("VK_")) {
            try {
               Field var3 = (class$java$awt$event$KeyEvent == null?(class$java$awt$event$KeyEvent = class$("java.awt.event.KeyEvent")):class$java$awt$event$KeyEvent).getField(var1);
               Integer var4 = (Integer)var3.get((Object)null);
               var2 = var4.intValue();
            } catch (Exception var5) {
               ;
            }
         }

         return new Integer(var2);
      }
   }

   private int getMenuKeyMask() {
      try {
         return Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
      } catch (UnsupportedOperationException var2) {
         return 2;
      }
   }

   private BufferedImage createTransparentImage(int var1, int var2) {
      BufferedImage var3 = new BufferedImage(var1, var2, 2);
      int[] var4 = var3.getRGB(0, 0, var1, var2, (int[])null, 0, var1);
      Arrays.fill(var4, 0);
      var3.setRGB(0, 0, var1, var2, var4, 0, var1);
      return var3;
   }

   public Icon createTransparentIcon(int var1, int var2) {
      return new ImageIcon(this.createTransparentImage(var1, var2));
   }

   public String formatMessage(String var1, Object var2) {
      return this.formatMessage(var1, new Object[]{var2});
   }

   public String formatMessage(String var1, Object var2, Object var3) {
      return this.formatMessage(var1, new Object[]{var2, var3});
   }

   public String formatMessage(String var1, Object[] var2) {
      MessageFormat var3 = new MessageFormat(this.getString(var1));
      var3.setLocale(this.getLocale());
      return var3.format(var2);
   }

   public Locale getLocale() {
      return this.locale;
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }
}
