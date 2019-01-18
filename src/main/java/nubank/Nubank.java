package nubank;

import totalcross.io.IOException;
import totalcross.sys.Settings;
import totalcross.ui.MainWindow;
import totalcross.ui.image.ImageException;
import ui.Inicial;
import ui.SplashWindow;

public class Nubank extends MainWindow{
	public Nubank(){
		setUIStyle(Settings.Material);
		Settings.uiAdjustmentsBasedOnFontHeight = true;
	}
	
	public void initUI(){
		SplashWindow sp;
		Inicial inicial = new Inicial();
		try {
			sp = new SplashWindow();
			sp.popupNonBlocking();
			swap(inicial);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ImageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
