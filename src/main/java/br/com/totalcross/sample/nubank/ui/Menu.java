package br.com.totalcross.sample.nubank.ui;

import br.com.totalcross.sample.nubank.util.Colors;
import br.com.totalcross.sample.nubank.util.NubankImages;

import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.ScrollContainer;
import totalcross.ui.TabbedContainer;
import totalcross.ui.event.DragEvent;
import totalcross.ui.event.PenEvent;
import totalcross.ui.event.PenListener;
import totalcross.ui.font.Font;
import totalcross.ui.image.Image;

public class Menu extends ScrollContainer {
	private String[] tits = { "", "" };
	private ImageControl background;
	private ImageControl logo;
	private Label nome;
	private Card cd1, cd2, cd3, cd4, cd5, cd6;

	public void initUI() {
		NubankImages.loadImages(fmH);
		background = new ImageControl(NubankImages.ic_adaptive_launcher_shell_background_retang);
		background.scaleToFit = true;
		background.centerImage = true;
		background.hwScale = true;
		background.strechImage = true;
		add(background, LEFT, TOP, FILL, FILL);

		logo = new ImageControl(NubankImages.logo_nubank);
		logo.scaleToFit = true;
		logo.transparentBackground = true;
		add(logo, CENTER - 112, TOP + 80, PARENTSIZE + 18, PARENTSIZE + 18);

		nome = new Label("Pedro");
		nome.setFont(Font.getFont("Lato Bold", false, this.getFont().size + 2));
		nome.transparentBackground = true;
		nome.setForeColor(Colors.WHITE);
		add(nome, AFTER + 10, TOP + 100);

		// Container do centro
		// Container do centro
		Container center = new Container();
		add(center, LEFT + 100, CENTER - 180, FILL - 100, PARENTSIZE + 48);

		TabbedContainer tc = new TabbedContainer(tits);
		center.add(tc, LEFT, CENTER, FILL, PARENTSIZE);

		tc.setContainer(0, new FaturaContainer());
		tc.setContainer(1, new PontosContainer());
		tc.setActiveTab(0);
		tc.transparentBackground = true;

		ImageControl b1 = new ImageControl(NubankImages.circulo_cinza);
		b1.transparentBackground = true;
		b1.centerImage = true;
		b1.scaleToFit = true;

		add(b1, CENTER - 20, AFTER + 10, PARENTSIZE + 2, PARENTSIZE + 2);

		ImageControl b2 = new ImageControl(NubankImages.circulo_branco);
		b2.transparentBackground = true;
		b2.centerImage = true;
		b2.scaleToFit = true;
		b1.addPenListener(new PenListener() {

			public void penUp(PenEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("teste1");
				tc.setActiveTab(0);
				b1.setImage(NubankImages.circulo_cinza);
				b2.setImage(NubankImages.circulo_branco);
			}

			public void penDragStart(DragEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void penDragEnd(DragEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void penDrag(DragEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void penDown(PenEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		b2.addPenListener(new PenListener() {

			public void penUp(PenEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("teste2");
				tc.setActiveTab(1);
				b2.setImage(NubankImages.circulo_cinza);
				b1.setImage(NubankImages.circulo_branco);
			}

			public void penDragStart(DragEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void penDragEnd(DragEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void penDrag(DragEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void penDown(PenEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		add(b2, AFTER + 15, SAME, PARENTSIZE + 2, PARENTSIZE + 2);

		// ScrollContainer
		ScrollContainer sc = new ScrollContainer(true, false);
		sc.transparentBackground = true;
		add(sc, LEFT + 100, BOTTOM - 100, FILL - 100, PARENTSIZE + 20);

		Image add = NubankImages.icone_adicionar;
		Image cobrar = NubankImages.icone_dinheiro_cobrar;
		Image depositar = NubankImages.icone_dinheiro_down;

		cd1 = new Card(add, "Indicar \namigos");
		sc.add(cd1, LEFT, TOP, PARENTSIZE + 38, FILL - 25);

		cd2 = new Card(cobrar, "Cobrar");
		sc.add(cd2, AFTER + 25, TOP, PARENTSIZE + 38, FILL - 25);

		cd3 = new Card(depositar, "Depositar");
		sc.add(cd3, AFTER + 25, TOP, PARENTSIZE + 38, FILL - 25);

		cd4 = new Card(depositar, "Transferir");
		sc.add(cd4, AFTER + 25, TOP, PARENTSIZE + 38, FILL - 25);

		cd5 = new Card(depositar, "Outra \nopção");
		sc.add(cd5, AFTER + 25, TOP, PARENTSIZE + 38, FILL - 25);

		cd6 = new Card(depositar, "Outra \nopção");
		sc.add(cd6, AFTER + 25, TOP, PARENTSIZE + 38, FILL - 25);

	}

}
