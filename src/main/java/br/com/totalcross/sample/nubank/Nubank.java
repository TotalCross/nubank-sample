package br.com.totalcross.sample.nubank;

import br.com.totalcross.sample.nubank.ui.Menu;
import totalcross.sys.Settings;
import totalcross.ui.MainWindow;

public class Nubank extends MainWindow{
	public Nubank(){
		setUIStyle(Settings.Material);
		Settings.uiAdjustmentsBasedOnFontHeight = true;
	}
	
	static {
		Settings.applicationId = "NUBK";
		Settings.appVersion = "1.0.1";
		Settings.iosCFBundleIdentifier = "com.totalcross.sample.nubank";
	}
	
	public void initUI(){
//		SplashWindow sp;
//		Inicial inicial = new Inicial();
		//			sp = new SplashWindow();
		//			sp.popupNonBlocking();
		//			swap(inicial);
					Menu menu = new Menu();
					swap(menu);
	}
}
