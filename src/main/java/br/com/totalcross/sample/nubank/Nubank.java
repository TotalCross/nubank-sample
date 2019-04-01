package br.com.totalcross.sample.nubank;

import br.com.totalcross.sample.nubank.ui.Inicial;
import br.com.totalcross.sample.nubank.ui.SplashWindow;
import br.com.totalcross.sample.nubank.util.Fonts;
import totalcross.io.IOException;
import totalcross.sys.Settings;
import totalcross.ui.MainWindow;
import totalcross.ui.font.Font;
import totalcross.ui.image.ImageException;

public class Nubank extends MainWindow {
	public Nubank() {
		setUIStyle(Settings.Material);
		Settings.uiAdjustmentsBasedOnFontHeight = true;
		setDefaultFont(Font.getFont(Fonts.FONT_DEFAULT_SIZE));
	}

	static {
		Settings.applicationId = "NUBK";
		Settings.appVersion = "1.0.1";
		Settings.iosCFBundleIdentifier = "com.totalcross.sample.nubank";
	}

	public void initUI() {
		SplashWindow sp;
		Inicial inicial = new Inicial();
		try {
			sp = new SplashWindow();
			sp.popupNonBlocking();
			swap(inicial);
		} catch (IOException | ImageException e) {
			e.printStackTrace();
		}
	}
}
