package util;

import totalcross.io.IOException;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;

public class Images {
	public static Image BACKGROUND_INICIAL;
    public static Image BACKGROUND_LOGO;
    public static Image BACKGROUND;
    public static Image LOGO;
    public static Image NU_LOGO;
    public static Image NU_LOGO_ROUNDED;
    public static Image CARD;
    public static Image ADD_PERSON;
    
    public static void loadImages() {
    	try {
			BACKGROUND_INICIAL = new Image("images/fundo3.png");
			LOGO = new Image("images/logo-nubank-branca.png");
			BACKGROUND = new Image("images/ic_adaptive_launcher_shell_background.png");
			NU_LOGO_ROUNDED = new Image("images/ic_adaptive_launcher_shell_round.png");
			NU_LOGO = new Image("images/logo-nubank.png");
			CARD = new Image("images/ic_docs_front_purpleheart.png");
			ADD_PERSON = new Image("images/addperson.png");
		} catch (IOException | ImageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
