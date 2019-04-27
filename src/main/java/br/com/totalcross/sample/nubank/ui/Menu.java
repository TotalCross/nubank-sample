package br.com.totalcross.sample.nubank.ui;

import br.com.totalcross.sample.nubank.util.Colors;
import br.com.totalcross.sample.nubank.util.Fonts;
import br.com.totalcross.sample.nubank.util.Images;
import br.com.totalcross.sample.nubank.util.MaterialConstants;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.ScrollContainer;
import totalcross.ui.TabbedContainer;
import totalcross.ui.event.DragEvent;
import totalcross.ui.event.PenEvent;
import totalcross.ui.event.PenListener;
import totalcross.ui.image.Image;
import totalcross.util.UnitsConverter;

public class Menu extends ScrollContainer {
	private String[] tits = { "", "" };
	private ImageControl background;
	private ImageControl logo;
	private Label nome;
	private Card cd1, cd2, cd3, cd4, cd5, cd6;

	public void initUI() {
		Images.loadImages(fmH);
		background = new ImageControl(Images.ic_adaptive_launcher_shell_background_retang);
		background.scaleToFit = true;
		background.centerImage = true;
		background.hwScale = true;
		background.strechImage = true;
		add(background, LEFT, TOP, FILL, FILL);

		logo = new ImageControl(Images.logo_nubank);
		logo.scaleToFit = true;
		logo.transparentBackground = true;
		add(logo, CENTER - (3 * MaterialConstants.COMPONENT_SPACING), TOP + MaterialConstants.BORDER_SPACING,
				PARENTSIZE + 20, PARENTSIZE + 10);

		nome = new Label("Pedro");
		nome.setFont(Fonts.latoBoldPlus2);
		nome.transparentBackground = true;
		nome.setForeColor(Colors.WHITE);
		add(nome, AFTER + MaterialConstants.COMPONENT_SPACING, CENTER_OF, logo);

		// Container do centro
		// Container do centro
		Container center = new Container();
		add(center, LEFT + MaterialConstants.BORDER_SPACING, AFTER + (2 * MaterialConstants.COMPONENT_SPACING),
				FILL - MaterialConstants.BORDER_SPACING, PARENTSIZE + 48);

		TabbedContainer tc = new TabbedContainer(tits);
		center.add(tc, LEFT, CENTER, FILL, PARENTSIZE);

		tc.setContainer(0, new FaturaContainer());
		tc.setContainer(1, new PontosContainer());
		tc.setActiveTab(0);
		tc.transparentBackground = true;

		ImageControl b1 = new ImageControl(Images.circulo_cinza);
		b1.transparentBackground = true;
		b1.centerImage = true;
		b1.scaleToFit = true;

		add(b1, CENTER - MaterialConstants.BORDER_SPACING, AFTER + MaterialConstants.BORDER_SPACING, PARENTSIZE + 2,
				PARENTSIZE + 2);

		ImageControl b2 = new ImageControl(Images.circulo_branco);
		b2.transparentBackground = true;
		b2.centerImage = true;
		b2.scaleToFit = true;
		b1.addPenListener(new PenListener() {
			public void penUp(PenEvent arg0) {
				tc.setActiveTab(0);
				b1.setImage(Images.circulo_cinza);
				b2.setImage(Images.circulo_branco);
			}

			public void penDragStart(DragEvent arg0) {
			}

			public void penDragEnd(DragEvent arg0) {
			}

			public void penDrag(DragEvent arg0) {
			}

			public void penDown(PenEvent arg0) {
			}
		});

		b2.addPenListener(new PenListener() {
			public void penUp(PenEvent arg0) {
				tc.setActiveTab(1);
				b2.setImage(Images.circulo_cinza);
				b1.setImage(Images.circulo_branco);
			}

			public void penDragStart(DragEvent arg0) {
			}

			public void penDragEnd(DragEvent arg0) {
			}

			public void penDrag(DragEvent arg0) {
			}

			public void penDown(PenEvent arg0) {
			}
		});
		add(b2, AFTER + MaterialConstants.BORDER_SPACING, SAME, PARENTSIZE + 2, PARENTSIZE + 2);

		// ScrollContainer
		ScrollContainer sc = new ScrollContainer(true, false);
		sc.transparentBackground = true;
		// sc.disableFlick();
		sc.sbH.setVisible(false);
		add(sc, LEFT + MaterialConstants.BORDER_SPACING, BOTTOM - MaterialConstants.BORDER_SPACING,
				FILL - MaterialConstants.BORDER_SPACING, PARENTSIZE + 20);

		Image add = Images.icone_adicionar;
		Image cobrar = Images.icone_dinheiro_cobrar;
		Image depositar = Images.icone_dinheiro_down;

		cd1 = new Card(add, "Indicar \namigos");
		sc.add(cd1, LEFT, TOP, PARENTSIZE + 38, FILL - MaterialConstants.COMPONENT_SPACING);

		cd2 = new Card(cobrar, "Cobrar");
		sc.add(cd2, AFTER + MaterialConstants.COMPONENT_SPACING, TOP, PARENTSIZE + 38,
				FILL - MaterialConstants.COMPONENT_SPACING);

		cd3 = new Card(depositar, "Depositar");
		sc.add(cd3, AFTER + MaterialConstants.COMPONENT_SPACING, TOP, PARENTSIZE + 38,
				FILL - MaterialConstants.COMPONENT_SPACING);

		cd4 = new Card(depositar, "Transferir");
		sc.add(cd4, AFTER + MaterialConstants.COMPONENT_SPACING, TOP, PARENTSIZE + 38,
				FILL - MaterialConstants.COMPONENT_SPACING);

		cd5 = new Card(depositar, "Outra \nopção");
		sc.add(cd5, AFTER + MaterialConstants.COMPONENT_SPACING, TOP, PARENTSIZE + 38,
				FILL - MaterialConstants.COMPONENT_SPACING);

		cd6 = new Card(depositar, "Outra \nopção");
		sc.add(cd6, AFTER + MaterialConstants.COMPONENT_SPACING, TOP, PARENTSIZE + 38,
				FILL - MaterialConstants.COMPONENT_SPACING);

	}
}
