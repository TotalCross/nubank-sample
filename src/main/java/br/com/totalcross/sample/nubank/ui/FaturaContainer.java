package br.com.totalcross.sample.nubank.ui;

import br.com.totalcross.sample.nubank.util.Colors;
import br.com.totalcross.sample.nubank.util.NubankImages;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.font.Font;
import totalcross.util.UnitsConverter;

public class FaturaContainer extends Container {
	private ImageControl cartao, cart, seta;
	private Label lbl1, lbl2, lbl3, lbl4, lblcinza;
	private Container cinza;

	public FaturaContainer() {
		this.setBackColor(Colors.MIDDLE_CONTAINER_BACKGROUND);
	}

	public void initUI() {
		NubankImages.loadImages(fmH);

		cartao = new ImageControl(NubankImages.ic_docs_front_purpleheart);
		cartao.scaleToFit = true;
		cartao.centerImage = true;
		add(cartao, LEFT + 50, TOP + 50, PARENTSIZE + 10, PARENTSIZE + 10);

		lbl1 = new Label("Fatura Atual:");
		lbl1.transparentBackground = true;
		lbl1.setFont(Font.getFont("Lato Medium", false, this.getFont().size -5));
		lbl1.setForeColor(0x0092d1); // 0x00BFFF
		add(lbl1, LEFT + UnitsConverter.toPixels(DP + 17), AFTER + UnitsConverter.toPixels(DP + 25));

		lbl2 = new Label("R$ 2.148,98");
		lbl2.transparentBackground = true;
		lbl2.setFont(Font.getFont("Lato Bold", false, this.getFont().size -5));
		lbl2.setForeColor(0x0092d1); // 0x00BFFF
		add(lbl2, LEFT + UnitsConverter.toPixels(DP + 17), AFTER);

		lbl3 = new Label("Limite disponível:");
		lbl3.transparentBackground = true;
		lbl3.setFont(Font.getFont("Lato Medium", false, this.getFont().size -10));
		lbl3.setForeColor(Colors.BLACK); // 0x00BFFF
		add(lbl3, LEFT + UnitsConverter.toPixels(DP + 17), AFTER);

		lbl4 = new Label("R$ 228,52");
		lbl4.transparentBackground = true;
		lbl4.setFont(Font.getFont("Lato Medium", false, this.getFont().size -10));
		lbl4.setForeColor(0XF4C430); // 0x00BFFF
		add(lbl4, AFTER + UnitsConverter.toPixels(DP + 17), SAME);

		cinza = new Container();
		cinza.setBackColor(0xDCDCDC);
		add(cinza, LEFT, BOTTOM, FILL, PARENTSIZE + 25);

		cart = new ImageControl(NubankImages.cart);
		cart.scaleToFit = true;
		cart.transparentBackground = true;
		cinza.add(cart, LEFT + UnitsConverter.toPixels(DP + 17), CENTER, PARENTSIZE + 10, PARENTSIZE + 40);

		lblcinza = new Label("Compra mais recente em Supermercado \n" + "São Luiz no valor de R$31,84 ontem");
		lblcinza.setFont(Font.getFont("Lato Regular", false, this.getFont().size - 5));
		lblcinza.transparentBackground = true;
		cinza.add(lblcinza, AFTER + UnitsConverter.toPixels(DP + 17), TOP, PARENTSIZE + 70, FILL);

		seta = new ImageControl(NubankImages.slider_next);
		seta.scaleToFit = true;
		seta.transparentBackground = true;
		cinza.add(seta, RIGHT, CENTER, PARENTSIZE + 10, PARENTSIZE + 40);

		
	}
}
