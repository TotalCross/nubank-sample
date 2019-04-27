package br.com.totalcross.sample.nubank.ui;

import br.com.totalcross.sample.nubank.util.Colors;
import br.com.totalcross.sample.nubank.util.Fonts;
import br.com.totalcross.sample.nubank.util.Images;
import br.com.totalcross.sample.nubank.util.MaterialConstants;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;

public class FaturaContainer extends Container {
	private ImageControl cartao, cart, seta;
	private Label lbl1, lbl2, lbl3, lbl4, lblcinza;
	private Container cinza;

	public FaturaContainer() {
		this.setBackColor(Colors.MIDDLE_CONTAINER_BACKGROUND);
	}

	public void initUI() {
		Images.loadImages(fmH);

		cartao = new ImageControl(Images.ic_docs_front_purpleheart);
		cartao.scaleToFit = true;
		cartao.centerImage = true;
		add(cartao, LEFT + MaterialConstants.BORDER_SPACING, TOP + MaterialConstants.BORDER_SPACING, PARENTSIZE + 10,
				PARENTSIZE + 10);

		lbl1 = new Label("Fatura Atual:");
		lbl1.transparentBackground = true;
		lbl1.setFont(Fonts.latoMediumPlus1);
		lbl1.setForeColor(0x0092d1); // 0x00BFFF
		add(lbl1, LEFT + MaterialConstants.BORDER_SPACING, AFTER + MaterialConstants.COMPONENT_SPACING);

		lbl2 = new Label("R$ 2.148,98");
		lbl2.transparentBackground = true;
		lbl2.setFont(Fonts.latoBoldPlus8);
		lbl2.setForeColor(0x0092d1); // 0x00BFFF
		add(lbl2, LEFT + MaterialConstants.BORDER_SPACING, AFTER);

		lbl3 = new Label("Limite disponível:");
		lbl3.transparentBackground = true;
		lbl3.setFont(Fonts.latoMediumPlus1);
		lbl3.setForeColor(Colors.BLACK); // 0x00BFFF
		add(lbl3, LEFT + MaterialConstants.BORDER_SPACING, AFTER);

		lbl4 = new Label("R$ 228,52");
		lbl4.transparentBackground = true;
		lbl4.setFont(Fonts.latoMediumPlus1);
		lbl4.setForeColor(0XF4C430); // 0x00BFFF
		add(lbl4, AFTER + MaterialConstants.BORDER_SPACING, SAME);

		cinza = new Container();
		cinza.setBackColor(0xDCDCDC);
		add(cinza, LEFT, BOTTOM, FILL, PARENTSIZE + 25);

		cart = new ImageControl(Images.cart);
		cart.scaleToFit = true;
		cart.transparentBackground = true;
		cinza.add(cart, LEFT + MaterialConstants.BORDER_SPACING, CENTER, PARENTSIZE + 10, PARENTSIZE + 40);

		lblcinza = new Label("Compra mais recente em Supermercado \n" + "São Luiz no valor de R$31,84 ontem");
		lblcinza.setFont(Fonts.latoRegularMinus5);
		lblcinza.transparentBackground = true;
		cinza.add(lblcinza, AFTER + MaterialConstants.BORDER_SPACING, TOP, PARENTSIZE + 70, FILL);

		seta = new ImageControl(Images.slider_next);
		seta.scaleToFit = true;
		seta.transparentBackground = true;
		cinza.add(seta, RIGHT, CENTER, PARENTSIZE + 10, PARENTSIZE + 40);

	}
}
