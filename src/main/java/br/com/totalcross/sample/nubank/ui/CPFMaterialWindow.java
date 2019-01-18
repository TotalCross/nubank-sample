package br.com.totalcross.sample.nubank.ui;

import totalcross.ui.Bar;
import totalcross.ui.Container;
import totalcross.ui.Control;
import totalcross.ui.Edit;
import totalcross.ui.Label;
import totalcross.ui.MainWindow;
import totalcross.ui.Presenter;
import totalcross.ui.SideMenuContainer;
import totalcross.ui.SlidingWindow;
import totalcross.ui.Spinner;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.PressListener;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.ui.icon.Icon;
import totalcross.ui.icon.MaterialIcons;

public class CPFMaterialWindow extends SlidingWindow {

	private Bar bar;
	private static int backcolor = 0;

	private SideMenuContainer findSideMenu(Container c) {
		if (c instanceof SideMenuContainer) {
			return (SideMenuContainer) c;
		}
		Control[] children = c.getChildren();
		for (Control control : children) {
			if (control instanceof SideMenuContainer) {
				return (SideMenuContainer) control;
			}
			if (control instanceof Container) {
				return findSideMenu((Container) control);
			}
		}
		return null;
	}

	public CPFMaterialWindow() {

		super(false, new Presenter() {
			@Override
			public Container getView() {
				return new Container() {
					@Override
					public void initUI() {
						backcolor = getBackColor();
						Label cpfLabel = new Label("Para acessar o app digite o \nseu CPF:");
						cpfLabel.setFont(Font.getFont("Lato Light", false, this.getFont().size + 6));

						add(cpfLabel, LEFT + 150, AFTER + 50, PREFERRED, Inicial.PREFERRED);

						Edit maskedEdit = new Edit("999.999.999-99");
						maskedEdit.caption = "";
						maskedEdit.setMode(Edit.NORMAL, true);
						maskedEdit.setValidChars(Edit.numbersSet);
						maskedEdit.transparentBackground = true;

						add(maskedEdit, SAME, AFTER + 50, PREFERRED, Inicial.PREFERRED);

					}
				};
			}
		});
		transparentBackground = true;

		Font medium = Font.getFont("Roboto Medium", false, 20);
		Icon i = new Icon(MaterialIcons._CLOSE);
		i.setForeColor(Color.BLACK);

		// cannot use empty constructor for Bar, otherwise we won't be able to use
		// setTitle later
		bar = new Bar("");
		bar.setBackColor(Color.WHITE);
		bar.setFont(medium != null ? medium : Font.getFont(bar.getFont().name, false, 20));
		bar.drawBorders = false;
		bar.backgroundStyle = Container.BACKGROUND_SOLID;

		// bar.setForeColor(Color.BLACK);
		SideMenuContainer smc = findSideMenu(MainWindow.getMainWindow());
		if (smc != null) {
			Control[] children2 = smc.getChildren();
			for (Control control2 : children2) {
				if (control2 instanceof Bar) {
					bar.setBackForeColors(control2.getBackColor(), control2.getForeColor());
				}
			}
		}

		bar.addButton(i, false);
		bar.addPressListener(new PressListener() {
			@Override
			public void controlPressed(ControlEvent e) {
				if (bar.getSelectedIndex() == 1) {
					CPFMaterialWindow.this.unpop();
				}
			}
		});
	}

	@Override
	public void initUI() {
		add(bar, LEFT, TOP + 200);
		if (!delayInitUI) {
			add(provider.getView(), LEFT, AFTER, FILL, FILL, bar);
		} else {
			new Thread(new Runnable() {
				@Override
				public void run() {
					Spinner s = new Spinner();
					add(s, CENTER, CENTER);
					s.start();
					add(provider.getView(), LEFT, AFTER, FILL, FILL, bar);
					remove(s);
					s.stop();
				}
			}).start();
		}
	}
}
