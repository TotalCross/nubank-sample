package br.com.totalcross.sample.nubank.ui;

import br.com.totalcross.sample.nubank.util.Colors;
import totalcross.io.IOException;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.ScrollContainer;
import totalcross.ui.TabbedContainer;
import totalcross.ui.font.Font;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;

public class Menu extends ScrollContainer{
	private ImageControl background;
	private ImageControl logo, cartao;
	private Label nome;
	private Card cd1, cd2, cd3, cd4, cd5, cd6;
	private Container cont;
	
	public void initUI(){
		try {
			background = new ImageControl(new Image("images/ic_adaptive_launcher_shell_background.png"));
			background.scaleToFit = true;
			background.centerImage = true;
			background.hwScale = true;
			background.strechImage = true;
			add(background, LEFT, TOP, FILL, FILL);
			
			logo = new ImageControl(new Image("images/logo-nubank.png"));
			logo.scaleToFit = true;
			logo.transparentBackground = true;
			add(logo, CENTER-112, TOP + 80, PARENTSIZE + 18, PARENTSIZE + 18);
			
			nome = new Label("Pedro");
			nome.setFont(Font.getFont("Lato Bold", false, this.getFont().size + 2));
			nome.transparentBackground = true;
			nome.setForeColor(Colors.WHITE);
			add(nome, AFTER+10, TOP + 100);
			
			//Container do centro
			cont = new Container();
			cont.setBackColor(0xF8F8FF);
			add(cont, LEFT+100, CENTER-160, FILL-100, PARENTSIZE+48);
			
			cartao = new ImageControl(new Image("images/ic_docs_front_purpleheart.png"));
			cartao.scaleToFit = true;
			cartao.centerImage = true;
			cont.add(cartao, LEFT+50, TOP+50, PARENTSIZE+10, PARENTSIZE+10);
			
			Label lbl1 = new Label("Fatura Atual:");
			lbl1.transparentBackground = true;
			lbl1.setFont(Font.getFont("Lato Medium", false, this.getFont().size + 1));
			lbl1.setForeColor(0x0092d1);  //0x00BFFF
			cont.add(lbl1, LEFT+50, AFTER+150);
			
			Label lbl2 = new Label("R$ 2.148,98");
			lbl2.transparentBackground = true;
			lbl2.setFont(Font.getFont("Lato Bold", false, this.getFont().size + 7));
			lbl2.setForeColor(0x0092d1);  //0x00BFFF
			cont.add(lbl2, LEFT+50, AFTER);
			
			Label lbl3 = new Label("Limite disponível:");
			lbl3.transparentBackground = true;
			lbl3.setFont(Font.getFont("Lato Medium", false, this.getFont().size + 1));
			lbl3.setForeColor(Colors.BLACK);  //0x00BFFF
			cont.add(lbl3, LEFT+50, AFTER);
			
			Label lbl4 = new Label("R$ 228,52");
			lbl4.transparentBackground = true;
			lbl4.setFont(Font.getFont("Lato Medium", false, this.getFont().size + 1));
			lbl4.setForeColor(0XF4C430);  //0x00BFFF
			cont.add(lbl4, RIGHT-180, CENTER+25);
			
			Container cinza = new Container();
			cinza.setBackColor(0xDCDCDC);
			cont.add(cinza, LEFT, BOTTOM, FILL, PARENTSIZE+25);
			
			ImageControl cart = new ImageControl(new Image("images/cart.png"));
			cart.scaleToFit = true;
			cart.transparentBackground = true;
			cinza.add(cart, LEFT+50, CENTER, PARENTSIZE+36, PARENTSIZE+40);
			
			Label lblcinza = new Label("Compra mais recente em Supermercado \n"
					+ "São Luiz no valor de R$31,84 ontem");
			lblcinza.setFont(Font.getFont("Lato Regular", false, this.getFont().size -5));
			lblcinza.transparentBackground = true;
			cinza.add(lblcinza, LEFT+330, TOP+75, PARENTSIZE+73, PARENTSIZE+65);
			
			ImageControl seta = new ImageControl(new Image("images/slider-next.png"));
			seta.scaleToFit = true;
			seta.transparentBackground = true;
			cinza.add(seta, AFTER, CENTER, PARENTSIZE+40, PARENTSIZE+30, lblcinza);
			
			//ScrollContainer
			ScrollContainer sc = new ScrollContainer(true, false);
			sc.transparentBackground = true;
			add(sc, LEFT+100, BOTTOM-100, FILL-100, PARENTSIZE+20);
			
			
			Image img = new Image("images/addperson.png");
			cd1 = new Card(img, "Indicar \namigos");
			sc.add(cd1, LEFT, TOP, PARENTSIZE+38, FILL-25);
			
			Image img2 = new Image("images/addperson.png");
			cd2 = new Card(img2, "Cobrar");
			sc.add(cd2, AFTER+25, TOP, PARENTSIZE+38, FILL-25);
			
			Image img3 = new Image("images/addperson.png");
			cd3 = new Card(img3, "Depositar");
			sc.add(cd3, AFTER+25, TOP, PARENTSIZE+38, FILL-25);
		
			Image img4 = new Image("images/addperson.png");
			cd4 = new Card(img4, "Transferir");
			sc.add(cd4, AFTER+25, TOP, PARENTSIZE+38, FILL-25);
			
			Image img5 = new Image("images/addperson.png");
			cd5 = new Card(img5, "Outra \nopção");
			sc.add(cd5, AFTER+25, TOP, PARENTSIZE+38, FILL-25);
			
			Image img6 = new Image("images/addperson.png");
			cd6 = new Card(img6, "Outra \nopção");
			sc.add(cd6, AFTER+25, TOP, PARENTSIZE+38, FILL-25);
		} catch (IOException | ImageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
