package ui;

import totalcross.io.IOException;
import totalcross.ui.ImageControl;
import totalcross.ui.Window;
import totalcross.ui.anim.ControlAnimation;
import totalcross.ui.anim.FadeAnimation;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;

public class SplashWindow extends Window{
	
	public SplashWindow() throws IOException, ImageException{
				
	}	
	
	protected void onPopup(){
		ImageControl logo;
		try {
			logo = new ImageControl(new Image("images/fundo.png"));
			logo.scaleToFit = true;
			logo.centerImage = true;
			logo.hwScale = true;
			logo.strechImage = true;
			add(logo, LEFT, TOP, FILL, FILL);	
			
			 FadeAnimation.create(logo, true, null, 3000)
             .then(FadeAnimation.create(logo, false, this::onAnimationFinished, 3000)).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ImageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
    public void onAnimationFinished(ControlAnimation anim) {
        this.unpop();
    }
    
}
