package br.com.totalcross.sample.nubank.ui;

import br.com.totalcross.sample.nubank.util.Colors;
import br.com.totalcross.sample.nubank.util.Fonts;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.image.Image;

public class Card extends Container {
	private Image img;
	private Label lbl;
	private String txt;
	private ImageControl ic;

	public Card(Image img, String txt) {
		this.img = img;
		this.txt = txt;
	}

	public void initUI() {
		this.setBackColor(Colors.SCROLL);
		this.setBorderStyle(BORDER_ROUNDED);
		this.borderColor = (Colors.SCROLL);

		ic = new ImageControl(img);
		ic.transparentBackground = true;
		ic.centerImage = true;
		ic.scaleToFit = true;
		add(ic, LEFT + 50, TOP + 50, PARENTSIZE + 28, PARENTSIZE + 28);

		lbl = new Label(txt);
		lbl.transparentBackground = true;
		lbl.setFont(Fonts.latoMediumMinus2);
		lbl.setForeColor(Colors.WHITE);
		add(lbl, LEFT + 50, BOTTOM - 50);
	}
}
