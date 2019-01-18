package br.com.totalcross.sample.nubank.ui;

import totalcross.io.IOException;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;

public class Inicial extends Container {
	private Container back;
	private ImageControl girl, logon;

	public Inicial() {
	}

	public void initUI() {
		try {
			back = new Container();
			add(back, LEFT, TOP, FILL, FILL);

			girl = new ImageControl(new Image("images/fundo3.png"));
			girl.scaleToFit = true;
			girl.centerImage = true;
			girl.hwScale = true;
			girl.strechImage = true;
			back.add(girl, LEFT, TOP, FILL, FILL);

			logon = new ImageControl(new Image("images/logo-nubank-branca.png"));
			logon.scaleToFit = true;
			logon.transparentBackground = true;
			back.add(logon, LEFT + 150, TOP + 80, PARENTSIZE + 30, PARENTSIZE + 20);

			Container cont = new Container();
			cont.transparentBackground = true;
			back.add(cont, LEFT + 150, BOTTOM, FILL - 150, PARENTSIZE + 50);

			Label lbl = new Label("A forma mais \nsimples de lidar \ncom seus gastos.");
			lbl.setFont(Font.getFont("Lato Bold", false, this.getFont().size + 6));
			lbl.transparentBackground = true;
			lbl.setForeColor(Color.WHITE);
			cont.add(lbl, LEFT, TOP + 15);

			Button pedirc = new Button("Pedir Meu Convite");
			pedirc.setBackForeColors(Color.WHITE, Color.getRGB(108, 37, 117));
			cont.add(pedirc, LEFT, AFTER + 60, FILL, PREFERRED);

			Button jac = new Button("Já Tenho Meu Convite", Button.BORDER_OUTLINED);
			jac.setForeColor(Color.getRGB(108, 37, 117));
			cont.add(jac, LEFT, AFTER + 20, FILL, PREFERRED);

			Button login = new Button("Login", Button.BORDER_OUTLINED);
			login.setForeColor(Color.getRGB(108, 37, 117));
			cont.add(login, LEFT, AFTER + 20, FILL, PREFERRED);

		} catch (IOException | ImageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
