package br.com.totalcross.sample.nubank.ui;

import java.sql.SQLException;

import br.com.totalcross.sample.nubank.dao.CPFDAO;
import br.com.totalcross.sample.nubank.util.Colors;
import br.com.totalcross.sample.nubank.util.Fonts;
import br.com.totalcross.sample.nubank.util.MaterialConstants;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Edit;
import totalcross.ui.Label;
import totalcross.ui.MaterialWindow;
import totalcross.ui.Presenter;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.PressListener;
import totalcross.util.InvalidDateException;

public class CPFMaterialWindow extends MaterialWindow {

	private static Edit maskedEdit;
	private static Button btnOutlined;

	public CPFMaterialWindow() {
		super(false, new Presenter() {
			@Override
			public Container getView() {
				return new Container() {
					@Override
					public void initUI() {
						Label cpfLabel = new Label("Para acessar o app digite o \nseu CPF:");
						cpfLabel.setFont(Fonts.latoLightPlus6);

						add(cpfLabel, LEFT + MaterialConstants.BORDER_SPACING,
								AFTER + MaterialConstants.COMPONENT_SPACING, PREFERRED, Inicial.PREFERRED);

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
									btnOutlined.setForeColor(Colors.BLUE);
									btnOutlined.repaintNow();
								} else {
									btnOutlined.setEnabled(false);
									btnOutlined.setForeColor(Colors.GRAY);
									btnOutlined.repaintNow();
								}

							}
						});

						btnOutlined.setEnabled(false);
						btnOutlined.setBackForeColors(Colors.GRAY, Colors.WHITE);

						add(maskedEdit, SAME, AFTER + MaterialConstants.COMPONENT_SPACING,
								FILL - MaterialConstants.BORDER_SPACING, PREFERRED);
						add(btnOutlined, LEFT, AFTER + MaterialConstants.COMPONENT_SPACING, FILL, PREFERRED);
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

		this.setBackColor(Colors.PURPLE);
		this.setSlackSpace(100);
	}

	private static void doInsert() throws SQLException, InvalidDateException {
		if (maskedEdit.getTextWithoutMask() == "") {
			MessageBox mb = new MessageBox("Atenção!", "Preencha o campo CPF");
			mb.setBackForeColors(Colors.WHITE, Colors.BLACK);
			mb.popup();

		} else {

			// simple example of how you can insert data into SQLite..
			String cpf = maskedEdit.getTextWithoutMask();
			new CPFDAO().insertCPF(cpf);

			MessageBox mb = new MessageBox("Atenção!", "CPF:" + cpf + " foi cadastrado com sucesso!");
			mb.setBackForeColors(Colors.WHITE, Colors.BLACK);
			mb.popup();
		}
	}
}
