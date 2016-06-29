package org.jfree.ui.about;

import java.awt.Image;
import java.util.Iterator;
import java.util.List;
import org.jfree.base.BootableProjectInfo;
import org.jfree.ui.about.Contributor;

public class ProjectInfo extends BootableProjectInfo {
   private Image logo;
   private String licenceText;
   private List contributors;

   public ProjectInfo() {
   }

   public ProjectInfo(String var1, String var2, String var3, Image var4, String var5, String var6, String var7) {
      super(var1, var2, var3, var5, var6);
      this.logo = var4;
      this.licenceText = var7;
   }

   public Image getLogo() {
      return this.logo;
   }

   public void setLogo(Image var1) {
      this.logo = var1;
   }

   public String getLicenceText() {
      return this.licenceText;
   }

   public void setLicenceText(String var1) {
      this.licenceText = var1;
   }

   public List getContributors() {
      return this.contributors;
   }

   public void setContributors(List var1) {
      this.contributors = var1;
   }

   public String toString() {
      StringBuffer var1 = new StringBuffer();
      var1.append(this.getName());
      var1.append(" version ");
      var1.append(this.getVersion());
      var1.append(".\n");
      var1.append(this.getCopyright());
      var1.append(".\n");
      var1.append("\n");
      var1.append("For terms of use, see the licence below.\n");
      var1.append("\n");
      var1.append("FURTHER INFORMATION:");
      var1.append(this.getInfo());
      var1.append("\n");
      var1.append("CONTRIBUTORS:");
      if(this.contributors != null) {
         Iterator var2 = this.contributors.iterator();

         while(var2.hasNext()) {
            Contributor var3 = (Contributor)var2.next();
            var1.append(var3.getName());
            var1.append(" (");
            var1.append(var3.getEmail());
            var1.append(").");
         }
      } else {
         var1.append("None");
      }

      var1.append("\n");
      var1.append("OTHER LIBRARIES USED BY ");
      var1.append(this.getName());
      var1.append(":");
      org.jfree.base.Library[] var5 = this.getLibraries();
      if(var5.length != 0) {
         for(int var6 = 0; var6 < var5.length; ++var6) {
            org.jfree.base.Library var4 = var5[var6];
            var1.append(var4.getName());
            var1.append(" ");
            var1.append(var4.getVersion());
            var1.append(" (");
            var1.append(var4.getInfo());
            var1.append(").");
         }
      } else {
         var1.append("None");
      }

      var1.append("\n");
      var1.append(this.getName());
      var1.append(" LICENCE TERMS:");
      var1.append("\n");
      var1.append(this.getLicenceText());
      return var1.toString();
   }
}
