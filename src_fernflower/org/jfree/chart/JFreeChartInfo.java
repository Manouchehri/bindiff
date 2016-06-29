package org.jfree.chart;

import java.awt.Image;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;
import org.jfree.JCommon;
import org.jfree.ui.about.Contributor;
import org.jfree.ui.about.Licences;
import org.jfree.ui.about.ProjectInfo;

class JFreeChartInfo extends ProjectInfo {
   public JFreeChartInfo() {
      String var1 = "org.jfree.chart.resources.JFreeChartResources";
      ResourceBundle var2 = ResourceBundle.getBundle(var1);
      this.setName(var2.getString("project.name"));
      this.setVersion(var2.getString("project.version"));
      this.setInfo(var2.getString("project.info"));
      this.setCopyright(var2.getString("project.copyright"));
      this.setLogo((Image)null);
      this.setLicenceName("LGPL");
      this.setLicenceText(Licences.getInstance().getLGPL());
      this.setContributors(Arrays.asList(new Contributor[]{new Contributor("Eric Alexander", "-"), new Contributor("Richard Atkinson", "richard_c_atkinson@ntlworld.com"), new Contributor("David Basten", "-"), new Contributor("David Berry", "-"), new Contributor("Anthony Boulestreau", "-"), new Contributor("Jeremy Bowman", "-"), new Contributor("Nicolas Brodu", "-"), new Contributor("David Browning", "-"), new Contributor("Soren Caspersen", "-"), new Contributor("Chuanhao Chiu", "-"), new Contributor("Brian Cole", "-"), new Contributor("Pascal Collet", "-"), new Contributor("Martin Cordova", "-"), new Contributor("Paolo Cova", "-"), new Contributor("Mike Duffy", "-"), new Contributor("Don Elliott", "-"), new Contributor("Jonathan Gabbai", "-"), new Contributor("David Gilbert", "david.gilbert@object-refinery.com"), new Contributor("Serge V. Grachov", "-"), new Contributor("Daniel Gredler", "-"), new Contributor("Hans-Jurgen Greiner", "-"), new Contributor("Joao Guilherme Del Valle", "-"), new Contributor("Aiman Han", "-"), new Contributor("Cameron Hayne", "-"), new Contributor("Jon Iles", "-"), new Contributor("Wolfgang Irler", "-"), new Contributor("Sergei Ivanov", "-"), new Contributor("Adriaan Joubert", "-"), new Contributor("Darren Jung", "-"), new Contributor("Xun Kang", "-"), new Contributor("Bill Kelemen", "-"), new Contributor("Norbert Kiesel", "-"), new Contributor("Gideon Krause", "-"), new Contributor("Pierre-Marie Le Biot", "-"), new Contributor("Arnaud Lelievre", "-"), new Contributor("Wolfgang Lenhard", "-"), new Contributor("David Li", "-"), new Contributor("Yan Liu", "-"), new Contributor("Tin Luu", "-"), new Contributor("Craig MacFarlane", "-"), new Contributor("Achilleus Mantzios", "-"), new Contributor("Thomas Meier", "-"), new Contributor("Jim Moore", "-"), new Contributor("Jonathan Nash", "-"), new Contributor("Barak Naveh", "-"), new Contributor("David M. O\'Donnell", "-"), new Contributor("Krzysztof Paz", "-"), new Contributor("Tomer Peretz", "-"), new Contributor("Andrzej Porebski", "-"), new Contributor("Xavier Poinsard", "-"), new Contributor("Viktor Rajewski", "-"), new Contributor("Eduardo Ramalho", "-"), new Contributor("Michael Rauch", "-"), new Contributor("Cameron Riley", "-"), new Contributor("Klaus Rheinwald", "-"), new Contributor("Dan Rivett", "d.rivett@ukonline.co.uk"), new Contributor("Scott Sams", "-"), new Contributor("Michel Santos", "-"), new Contributor("Thierry Saura", "-"), new Contributor("Andreas Schneider", "-"), new Contributor("Jean-Luc SCHWAB", "-"), new Contributor("Bryan Scott", "-"), new Contributor("Tobias Selb", "-"), new Contributor("Mofeed Shahin", "-"), new Contributor("Pady Srinivasan", "-"), new Contributor("Greg Steckman", "-"), new Contributor("Roger Studner", "-"), new Contributor("Irv Thomae", "-"), new Contributor("Eric Thomas", "-"), new Contributor("Rich Unger", "-"), new Contributor("Daniel van Enckevort", "-"), new Contributor("Laurence Vanhelsuwe", "-"), new Contributor("Sylvain Vieujot", "-"), new Contributor("Mark Watson", "www.markwatson.com"), new Contributor("Alex Weber", "-"), new Contributor("Matthew Wright", "-"), new Contributor("Benoit Xhenseval", "-"), new Contributor("Christian W. Zuckschwerdt", "Christian.Zuckschwerdt@Informatik.Uni-Oldenburg.de"), new Contributor("Hari", "-"), new Contributor("Sam (oldman)", "-")}));
      this.addLibrary(JCommon.INFO);
   }

   public Image getLogo() {
      Image var1 = super.getLogo();
      if(var1 == null) {
         URL var2 = this.getClass().getClassLoader().getResource("org/jfree/chart/gorilla.jpg");
         if(var2 != null) {
            ImageIcon var3 = new ImageIcon(var2);
            var1 = var3.getImage();
            this.setLogo(var1);
         }
      }

      return var1;
   }
}
