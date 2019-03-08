/**

	Copyright:
	==========
	
	Splinter - The RAT (Remote Administrator Tool)
	Developed By Solomon Sonya, Nick Kulesza, and Dan Gunter
	Copyright 2013 Solomon Sonya
	
	This copyright applies to the entire Splinter Project and all relating source code

	This program is free software: you are free to  redistribute 
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.       

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
	
	By executing this program, you assume full responsibility 
	and will hold zero responsibility, liability, damages, etc to the
	development team over this program or any variations of this program.
	This program is not meant to be harmful or used in a malicious manner.
	
	Notes:
	===========
	This program is 100% open source and still a very BETA version. 
	I don't know of any significant bugs.... but I'm sure they may exist ;-)
	If you find one, congratulations, please forward the data back to us 
	and we'll do our best to put a fix/workaround if applicable (and time permitting...)
	Finally, feature imprevements/updates, etc, please let us know what you would
	like to see, and we'll do my best to have it incorporated into the newer 
	versions of Splinter or new projects to come.  We're here to help.
	
	Thanks again, 
	
	Solomon
	
	Contact: 
	========
	Twitter	--> @splinter_therat, @carpenter1010
	Email	--> splinterbotnet@gmail.com
	GitHub	--> https://github.com/splinterbotnet
**/



package Implant.Payloads;

import Implant.Driver;
import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JPanel_RenderedScreen extends JPanel
{
  public static final String strMyClassName = "JPanel_RenderedScreen";
  JLabel jlblImage = new JLabel("");

  JScrollPane jscrlpne_MyImage = null;

  ImageIcon myImageIcon = null;

  Image img = null;

  public JPanel_RenderedScreen(File fleToRender)
  {
    try
    {
      setLayout(new BorderLayout());
      this.jscrlpne_MyImage = new JScrollPane(this.jlblImage);
      add("Center", this.jscrlpne_MyImage);

      setImage(fleToRender);

      validate();
    }
    catch (Exception e)
    {
      this.jlblImage.setText("IMAGE COULD NOT BE DISPLAYED!");

      Driver.eop("Constructor", "JPanel_RenderedScreen", e, "", false);
    }

    validate();
  }

  public boolean setImage(File fleImageToSet)
  {
    try
    {
      if ((fleImageToSet == null) || (!fleImageToSet.exists()) || (!fleImageToSet.isFile()))
      {
        this.jlblImage.setText("IMAGE COULD NOT BE DISPLAYED!");
        validate();
        return false;
      }

      System.gc();

      this.img = ImageIO.read(fleImageToSet);
      this.myImageIcon = new ImageIcon(this.img);
      this.jlblImage.setIcon(this.myImageIcon);

      validate();

      return true;
    }
    catch (NullPointerException localNullPointerException)
    {
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
    }
    catch (Exception e)
    {
      Driver.sop("Unable to render image!!!  - " + fleImageToSet);
    }

    return false;
  }
}