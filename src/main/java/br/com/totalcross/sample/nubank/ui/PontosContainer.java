package br.com.totalcross.sample.nubank.ui;

import br.com.totalcross.sample.nubank.util.Colors;
import br.com.totalcross.sample.nubank.util.Fonts;
import br.com.totalcross.sample.nubank.util.Images;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.font.Font;

public class PontosContainer extends Container {
	private ImageControl gift, seta;
	private Label lbl2, lbl3, lbl4, lblcinza;
	private Container cinza;

	public PontosContainer() {
		this.setBackColor(Colors.MIDDLE_CONTAINER_BACKGROUND);
	}

	public void initUI() {
		Images.loadImages(fmH);

		gift = new ImageControl(Images.presente_icone);
		gift.scaleToFit = true;
		gift.centerImage = true;
		add(gift, LEFT + 50, TOP + 50, PARENTSIZE + 10, PARENTSIZE + 10);

		lbl2 = new Label("8.652 pts");
		lbl2.transparentBackground = true;
		lbl2.setFont(Fonts.latoBoldPlus8);
		lbl2.setForeColor(Colors.PURPLE_TEXT); // 0x00BFFF
		add(lbl2, LEFT + 50, AFTER + 125);

		lbl3 = new Label("Você acumulou");
		lbl3.transparentBackground = true;
		lbl3.setFont(Fonts.latoMediumPlus1);
		lbl3.setForeColor(Colors.BLACK); // 0x00BFFF
		add(lbl3, LEFT + 50, AFTER);

		lbl4 = new Label("4.335 pontos");
		lbl4.transparentBackground = true;
		lbl4.setFont(Fonts.latoMediumPlus1);
		lbl4.setForeColor(Colors.PURPLE_TEXT); // 0x00BFFF
		add(lbl4, AFTER + 20, SAME);

		lbl3 = new Label("nos ultimos 30 dias");
		lbl3.transparentBackground = true;
		lbl3.setFont(Fonts.latoMediumPlus1);
		lbl3.setForeColor(Colors.BLACK); // 0x00BFFF
		add(lbl3, LEFT + 50, AFTER);

		cinza = new Container();
		cinza.setBackColor(0xDCDCDC);
		add(cinza, LEFT, BOTTOM, FILL, PARENTSIZE + 25);

		lblcinza = new Label("Você ainda não tem compras para pagar \n" + "com pontos");
		lblcinza.setFont(Fonts.latoRegularMinus5);
		lblcinza.transparentBackground = true;
		cinza.add(lblcinza, LEFT + 50, TOP, PARENTSIZE + 73, FILL);

		seta = new ImageControl(Images.slider_next);
		seta.scaleToFit = true;
		seta.transparentBackground = true;
		cinza.add(seta, RIGHT, CENTER, PARENTSIZE + 10, PARENTSIZE + 40);

	}
}
