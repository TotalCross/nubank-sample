package br.com.totalcross.sample.nubank.ui;


import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.MainWindow;
import totalcross.ui.SlidingWindow;
import totalcross.ui.font.Font;
import util.Colors;
import util.Images;

public class Inicial extends Container {
	private Container back;
	private ImageControl girl, logon;

	public Inicial() {
	}

	public void initUI() {
		back = new Container();
		add(back, LEFT, TOP, FILL, FILL);

		girl = new ImageControl(Images.BACKGROUND_INICIAL);
		girl.scaleToFit = true;
		girl.centerImage = true;
		girl.hwScale = true;
		girl.strechImage = true;
		back.add(girl, LEFT, TOP, FILL, FILL);

		logon = new ImageControl(Images.LOGO);
		logon.scaleToFit = true;
		logon.transparentBackground = true;
		back.add(logon, LEFT + 150, TOP + 80, PARENTSIZE + 30, PARENTSIZE + 20);

		Container cont = new Container();
		cont.transparentBackground = true;
		back.add(cont, LEFT + 150, BOTTOM, FILL - 150, PARENTSIZE + 50);

		Label lbl = new Label("A forma mais \nsimples de lidar \ncom seus gastos.");
		lbl.setFont(Font.getFont("Lato Bold", false, this.getFont().size + 6));
		lbl.transparentBackground = true;
		lbl.setForeColor(Colors.WHITE);
		cont.add(lbl, LEFT, TOP + 15);

		Button pedirc = new Button("Pedir Meu Convite");
		pedirc.setBackForeColors(Colors.WHITE, Colors.PURPLE_BUTTONS);
		cont.add(pedirc, LEFT, AFTER + 60, FILL, PREFERRED);

		Button jac = new Button("Já Tenho Meu Convite", Button.BORDER_OUTLINED);
		jac.setForeColor(Colors.PURPLE_BUTTONS);
		cont.add(jac, LEFT, AFTER + 20, FILL, PREFERRED);
		jac.addPressListener((e)->{
			Menu menu = new Menu();
			MainWindow.getMainWindow().swap(menu);
		});

		Button login = new Button("Login", Button.BORDER_OUTLINED);
		login.setForeColor(Colors.PURPLE_BUTTONS);
		cont.add(login, LEFT, AFTER + 20, FILL, PREFERRED);

		//Icon i = new Icon(MaterialIcons._CLOSE);

		login.addPressListener((e) -> {
			SlidingWindow info = new CPFMaterialWindow();
			// info.setBarFont(Font.getFont("Lato Light", false, this.getFont().size));
			info.popup();
		});

	}
}
