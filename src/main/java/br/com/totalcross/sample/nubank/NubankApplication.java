package br.com.totalcross.sample.nubank;

import totalcross.TotalCrossApplication;

public class NubankApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TotalCrossApplication.run(Nubank.class, "/scr", "1125x2304", "/scale", "0.33", "/fontsize", "14", "/r","<your key here>");
		//TotalCrossApplication.run(Nubank.class,"/scr","360x640","/r","<your key here>");

	}

}
