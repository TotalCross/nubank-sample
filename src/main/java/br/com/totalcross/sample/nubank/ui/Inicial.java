package br.com.totalcross.sample.nubank.ui;

import br.com.totalcross.sample.nubank.util.Colors;
import br.com.totalcross.sample.nubank.util.Fonts;
import br.com.totalcross.sample.nubank.util.Images;
import br.com.totalcross.sample.nubank.util.MaterialConstants;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.MainWindow;
import totalcross.ui.SlidingWindow;

public class Inicial extends Container {
	private Container back;
	private ImageControl girl, logon;

	public Inicial() {
	}

	public void initUI() {
		Images.loadImages(fmH);
		back = new Container();
		add(back, LEFT, TOP, FILL, FILL);

		girl = new ImageControl(Images.fundo3);
		girl.scaleToFit = true;
		girl.centerImage = true;
		girl.hwScale = true;
		girl.strechImage = true;
		back.add(girl, LEFT, TOP, FILL, FILL);

		logon = new ImageControl(Images.logo_nubank_branca);
		logon.scaleToFit = true;
		logon.transparentBackground = true;
		back.add(logon, LEFT + MaterialConstants.BORDER_SPACING, TOP + MaterialConstants.BORDER_SPACING,
				PARENTSIZE + 30, PARENTSIZE + 20);

		Container cont = new Container();
		cont.transparentBackground = true;
		back.add(cont, LEFT + MaterialConstants.BORDER_SPACING, BOTTOM, FILL - MaterialConstants.BORDER_SPACING,
				PARENTSIZE + 50);

		Label lbl = new Label("A forma mais \nsimples de lidar \ncom seus gastos.");
		lbl.setFont(Fonts.latoBoldPlus8);
		lbl.transparentBackground = true;
		lbl.setForeColor(Colors.WHITE);
		cont.add(lbl, LEFT, TOP + MaterialConstants.COMPONENT_SPACING);

		Button pedirc = new Button("Pedir Meu Convite");
		pedirc.setBackForeColors(Colors.WHITE, Colors.PURPLE_BUTTONS);
		cont.add(pedirc, LEFT, AFTER + MaterialConstants.COMPONENT_SPACING, FILL, PREFERRED);

		Button jac = new Button("Já Tenho Meu Convite", Button.BORDER_OUTLINED);
		jac.setForeColor(Colors.PURPLE_BUTTONS);
		cont.add(jac, LEFT, AFTER + MaterialConstants.COMPONENT_SPACING, FILL, PREFERRED);
		jac.addPressListener((e) -> {
			Menu menu = new Menu();
			MainWindow.getMainWindow().swap(menu);
		});

		Button login = new Button("Login", Button.BORDER_OUTLINED);
		login.setForeColor(Colors.PURPLE_BUTTONS);
		cont.add(login, LEFT, AFTER + MaterialConstants.COMPONENT_SPACING, FILL, PREFERRED);

		login.addPressListener((e) -> {
			SlidingWindow info = new CPFMaterialWindow();
			info.popup();
		});

	}
}
