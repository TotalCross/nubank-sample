package br.com.totalcross.sample.nubank.util;

import totalcross.io.IOException;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;

public class NubankImages {
	private NubankImages() {}
	public static Image addperson, cart, cartao, circulo_branco, circulo_cinza, dollar, fundo, 
	fundo2, fundo3, ic_adaptive_launcher_shell_background_retang, ic_adaptive_launcher_shell_background_circ,
	ic_docs_front_purpleheart, icone_adicionar, icone_dinheiro_cobrar, icone_dinheiro_down,
	icone_dinheiro_up, logo_nubank, logo_nubank_branca, nubank_logo_retang, nubank_logo_circ,
	presente_icone, slider_next, logo_branco;
	public static void loadImages(int fmH) {
	      try {
	    	logo_branco= new Image("images/nubank-branco.png");
			addperson = new Image("images/addperson.png");
			cart = new Image("images/cart.png");
			cartao = new Image("images/cartao.png");
			circulo_branco = new Image("images/circulo-branco.png");
			circulo_cinza = new Image("images/circulo-cinza-.png");
			dollar = new Image("images/dollar.png");
			fundo = new Image("images/fundo.png");
			fundo2 = new Image("images/fundo2.png");
			fundo3 = new Image("images/fundo3.png");
			ic_adaptive_launcher_shell_background_retang = new Image("images/ic_adaptive_launcher_shell_background.png");
			ic_adaptive_launcher_shell_background_circ = new Image("images/ic_adaptive_launcher_shell_round.png");
			ic_docs_front_purpleheart = new Image("images/ic_docs_front_purpleheart.png");
			icone_adicionar = new Image("images/icone_adicionar-.png");
			icone_dinheiro_cobrar = new Image("images/icone-dinheiro-cobrar.png");
			icone_dinheiro_down = new Image("images/icone-dinheiro-down.png");
			icone_dinheiro_up = new Image("images/icone-dinheiro-up-.png");
			logo_nubank = new Image("images/logo-nubank.png");
			logo_nubank_branca = new Image("images/logo-nubank-branca.png");
			nubank_logo_retang = new Image("images/nubank_logo.jpg");
			nubank_logo_circ = new Image("images/nubank_logo.png");
			presente_icone = new Image("images/presente-icone.png");
			slider_next = new Image("images/slider-next.png");
		} catch (ImageException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
