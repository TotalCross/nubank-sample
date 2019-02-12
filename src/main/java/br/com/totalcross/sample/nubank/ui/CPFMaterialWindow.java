package br.com.totalcross.sample.nubank.ui;

import java.sql.SQLException;

import totalcross.sql.Connection;
import totalcross.sql.DriverManager;
import totalcross.sql.Statement;
import totalcross.sys.Convert;
import totalcross.sys.Settings;
import totalcross.ui.Bar;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Control;
import totalcross.ui.Edit;
import totalcross.ui.Label;
import totalcross.ui.MainWindow;
import totalcross.ui.Presenter;
import totalcross.ui.SideMenuContainer;
import totalcross.ui.SlidingWindow;
import totalcross.ui.Spinner;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.PressListener;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.ui.icon.Icon;
import totalcross.ui.icon.MaterialIcons;
import totalcross.util.InvalidDateException;
import totalcross.util.UnitsConverter;

public class CPFMaterialWindow extends SlidingWindow {
	private static Connection dbcon;
	private Bar bar;
	private static Edit maskedEdit;
	private static Button btnOutlined;
	
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
						Label cpfLabel = new Label("Para acessar o app digite o \nseu CPF:");
						cpfLabel.setFont(Font.getFont("Lato Light", false, this.getFont().size + 6));

						add(cpfLabel, LEFT + UnitsConverter.toPixels(DP + 33), AFTER + UnitsConverter.toPixels(DP + 17), PREFERRED, Inicial.PREFERRED);

						maskedEdit = new Edit("999.999.999-99");
						btnOutlined = new Button("Continuar", Button.BORDER_OUTLINED);

						maskedEdit.caption = "";
						maskedEdit.setMode(Edit.NORMAL, true);
						maskedEdit.setValidChars(Edit.numbersSet);
						maskedEdit.transparentBackground = true;
						maskedEdit.addPressListener(new PressListener() {

							@Override
							public void controlPressed(ControlEvent event) {
								if (event.target == maskedEdit
										&& maskedEdit.getText().length() == "999.999.999-99".length()) {
									btnOutlined.setEnabled(true);
									btnOutlined.setForeColor(Color.BLUE);
									btnOutlined.repaintNow();
								} else {
									btnOutlined.setEnabled(false);
									btnOutlined.setForeColor(Color.getRGB(204, 204, 204));
									btnOutlined.repaintNow();
								}

							}
						});

						btnOutlined.setEnabled(false);

						btnOutlined.setBackForeColors(Color.getRGB(204, 204, 204), Color.WHITE);

						add(maskedEdit, SAME, AFTER + UnitsConverter.toPixels(DP + 17), PREFERRED, Inicial.PREFERRED);
						add(btnOutlined, LEFT, AFTER + UnitsConverter.toPixels(DP + 33), FILL, PREFERRED);
						btnOutlined.addPressListener((event) -> {
							try {
								doInsert();
							} catch (Exception ee) {
								MessageBox.showException(ee, true);
							}
						});
					}
				};
			}
		});
		transparentBackground = true;
		fadeOtherWindows = true;

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
		try {
			dbcon = DriverManager.getConnection("jdbc:sqlite:" + Convert.appendPath(Settings.appPath, "test.db"));
			Statement st = dbcon.createStatement();
			st.execute("create table if not exists person (cpf varchar)");
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	private static void doInsert() throws SQLException, InvalidDateException {
		if (maskedEdit.getTextWithoutMask() == ""){
			MessageBox mb = new MessageBox("Atenção!","Preencha o campo CPF");
			mb.setBackForeColors(Color.WHITE, Color.BLACK);
			mb.popup();

		}else {
			// simple example of how you can insert data into SQLite..
			String cpf = maskedEdit.getTextWithoutMask();

			Statement st = dbcon.createStatement();
			st.executeUpdate("insert into person values('" + cpf  + "')");
			st.close();
			MessageBox mb = new MessageBox("Atenção!","CPF:" + cpf + " foi cadastrado com sucesso!");
			mb.setBackForeColors(Color.WHITE, Color.BLACK);
			mb.popup();
		}
	}
}
