/*
 * Decompiled with CFR 0_115.
 */
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

    public ResourceBundleSupport(Locale locale, String string) {
        this(locale, ResourceBundle.getBundle(string, locale), string);
    }

    protected ResourceBundleSupport(Locale locale, ResourceBundle resourceBundle, String string) {
        if (locale == null) {
            throw new NullPointerException("Locale must not be null");
        }
        if (resourceBundle == null) {
            throw new NullPointerException("Resources must not be null");
        }
        if (string == null) {
            throw new NullPointerException("BaseName must not be null");
        }
        this.locale = locale;
        this.resources = resourceBundle;
        this.resourceBase = string;
        this.cache = new TreeMap();
        this.lookupPath = new TreeSet();
    }

    public ResourceBundleSupport(Locale locale, ResourceBundle resourceBundle) {
        this(locale, resourceBundle, resourceBundle.toString());
    }

    public ResourceBundleSupport(String string) {
        this(Locale.getDefault(), ResourceBundle.getBundle(string), string);
    }

    protected ResourceBundleSupport(ResourceBundle resourceBundle, String string) {
        this(Locale.getDefault(), resourceBundle, string);
    }

    public ResourceBundleSupport(ResourceBundle resourceBundle) {
        this(Locale.getDefault(), resourceBundle, resourceBundle.toString());
    }

    protected final String getResourceBase() {
        return this.resourceBase;
    }

    public synchronized String getString(String string) {
        String string2 = (String)this.cache.get(string);
        if (string2 != null) {
            return string2;
        }
        this.lookupPath.clear();
        return this.internalGetString(string);
    }

    protected String internalGetString(String string) {
        if (this.lookupPath.contains(string)) {
            throw new MissingResourceException("InfiniteLoop in resource lookup", this.getResourceBase(), this.lookupPath.toString());
        }
        String string2 = this.resources.getString(string);
        if (string2.startsWith("@@")) {
            int n2 = string2.indexOf(64, 2);
            if (n2 == -1) {
                throw new MissingResourceException("Invalid format for global lookup key.", this.getResourceBase(), string);
            }
            try {
                ResourceBundle resourceBundle = ResourceBundle.getBundle(string2.substring(2, n2));
                return resourceBundle.getString(string2.substring(n2 + 1));
            }
            catch (Exception var4_6) {
                Log.error("Error during global lookup", var4_6);
                throw new MissingResourceException("Error during global lookup", this.getResourceBase(), string);
            }
        }
        if (string2.startsWith("@")) {
            String string3 = string2.substring(1);
            this.lookupPath.add(string);
            String string4 = this.internalGetString(string3);
            this.cache.put(string, string4);
            return string4;
        }
        this.cache.put(string, string2);
        return string2;
    }

    public Icon getIcon(String string, boolean bl2) {
        String string2 = this.getString(string);
        return this.createIcon(string2, true, bl2);
    }

    public Icon getIcon(String string) {
        String string2 = this.getString(string);
        return this.createIcon(string2, false, false);
    }

    public Integer getMnemonic(String string) {
        String string2 = this.getString(string);
        return this.createMnemonic(string2);
    }

    public Integer getOptionalMnemonic(String string) {
        String string2 = this.getString(string);
        if (string2 == null) return null;
        if (string2.length() <= 0) return null;
        return this.createMnemonic(string2);
    }

    public KeyStroke getKeyStroke(String string) {
        return this.getKeyStroke(string, this.getMenuKeyMask());
    }

    public KeyStroke getOptionalKeyStroke(String string) {
        return this.getOptionalKeyStroke(string, this.getMenuKeyMask());
    }

    public KeyStroke getKeyStroke(String string, int n2) {
        String string2 = this.getString(string);
        return KeyStroke.getKeyStroke(this.createMnemonic(string2), n2);
    }

    public KeyStroke getOptionalKeyStroke(String string, int n2) {
        String string2 = this.getString(string);
        if (string2 == null) return null;
        if (string2.length() <= 0) return null;
        return KeyStroke.getKeyStroke(this.createMnemonic(string2), n2);
    }

    public JMenu createMenu(String string) {
        JMenu jMenu = new JMenu();
        jMenu.setText(this.getString(new StringBuffer().append(string).append(".name").toString()));
        jMenu.setMnemonic(this.getMnemonic(new StringBuffer().append(string).append(".mnemonic").toString()));
        return jMenu;
    }

    public URL getResourceURL(String string) {
        String string2 = this.getString(string);
        Class class_ = class$org$jfree$util$ResourceBundleSupport == null ? (ResourceBundleSupport.class$org$jfree$util$ResourceBundleSupport = ResourceBundleSupport.class$("org.jfree.util.ResourceBundleSupport")) : class$org$jfree$util$ResourceBundleSupport;
        URL uRL = ObjectUtilities.getResource(string2, class_);
        if (uRL != null) return uRL;
        Log.warn(new StringBuffer().append("Unable to find file in the class path: ").append(string2).append("; key=").append(string).toString());
        return uRL;
    }

    private ImageIcon createIcon(String string, boolean bl2, boolean bl3) {
        Class class_ = class$org$jfree$util$ResourceBundleSupport == null ? (ResourceBundleSupport.class$org$jfree$util$ResourceBundleSupport = ResourceBundleSupport.class$("org.jfree.util.ResourceBundleSupport")) : class$org$jfree$util$ResourceBundleSupport;
        URL uRL = ObjectUtilities.getResource(string, class_);
        if (uRL == null) {
            Log.warn(new StringBuffer().append("Unable to find file in the class path: ").append(string).toString());
            return new ImageIcon(this.createTransparentImage(1, 1));
        }
        Image image = Toolkit.getDefaultToolkit().createImage(uRL);
        if (image == null) {
            Log.warn(new StringBuffer().append("Unable to instantiate the image: ").append(string).toString());
            return new ImageIcon(this.createTransparentImage(1, 1));
        }
        if (!bl2) return new ImageIcon(image);
        if (!bl3) return new ImageIcon(image.getScaledInstance(16, 16, 4));
        return new ImageIcon(image.getScaledInstance(24, 24, 4));
    }

    private Integer createMnemonic(String string) {
        if (string == null) {
            throw new NullPointerException("Key is null.");
        }
        if (string.length() == 0) {
            throw new IllegalArgumentException("Key is empty.");
        }
        int n2 = string.charAt(0);
        if (!string.startsWith("VK_")) return new Integer(n2);
        try {
            Class class_ = class$java$awt$event$KeyEvent == null ? (ResourceBundleSupport.class$java$awt$event$KeyEvent = ResourceBundleSupport.class$("java.awt.event.KeyEvent")) : class$java$awt$event$KeyEvent;
            Field field = class_.getField(string);
            Integer n3 = (Integer)field.get(null);
            n2 = n3;
            return new Integer(n2);
        }
        catch (Exception var3_4) {
            // empty catch block
        }
        return new Integer(n2);
    }

    private int getMenuKeyMask() {
        try {
            return Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        }
        catch (UnsupportedOperationException var1_1) {
            return 2;
        }
    }

    private BufferedImage createTransparentImage(int n2, int n3) {
        BufferedImage bufferedImage = new BufferedImage(n2, n3, 2);
        int[] arrn = bufferedImage.getRGB(0, 0, n2, n3, null, 0, n2);
        Arrays.fill(arrn, 0);
        bufferedImage.setRGB(0, 0, n2, n3, arrn, 0, n2);
        return bufferedImage;
    }

    public Icon createTransparentIcon(int n2, int n3) {
        return new ImageIcon(this.createTransparentImage(n2, n3));
    }

    public String formatMessage(String string, Object object) {
        return this.formatMessage(string, new Object[]{object});
    }

    public String formatMessage(String string, Object object, Object object2) {
        return this.formatMessage(string, new Object[]{object, object2});
    }

    public String formatMessage(String string, Object[] arrobject) {
        MessageFormat messageFormat = new MessageFormat(this.getString(string));
        messageFormat.setLocale(this.getLocale());
        return messageFormat.format(arrobject);
    }

    public Locale getLocale() {
        return this.locale;
    }

    static Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }
}

