package br.com.totalcross.sample.nubank.ui;

import totalcross.io.IOException;
import totalcross.ui.ImageControl;
import totalcross.ui.Window;
import totalcross.ui.anim.ControlAnimation;
import totalcross.ui.anim.FadeAnimation;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;

public class SplashWindow extends Window {

	public SplashWindow() throws IOException, ImageException {

	}

	protected void onPopup() {
		ImageControl logo, back;
		try {
			back = new ImageControl(new Image("images/ic_adaptive_launcher_shell_background.png"));
			back.scaleToFit = true;
			back.centerImage = true;
			back.hwScale = true;
			back.strechImage = true;
			add(back, LEFT, TOP, FILL, FILL);

			// setBackColor(Color.getRGB(136, 47, 146));
			logo = new ImageControl(new Image("images/nubank_logo.png"));
			logo.scaleToFit = true;
			logo.centerImage = true;
			logo.transparentBackground = true;
			// logo.hwScale = true;
			// logo.strechImage = true;
			add(logo, CENTER, CENTER, PARENTSIZE + 50, PARENTSIZE + 50);

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
