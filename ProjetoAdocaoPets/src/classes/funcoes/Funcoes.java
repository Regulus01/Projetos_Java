package classes.funcoes;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Funcoes {
	public static String dataAtual() {
		Calendar hoje = new GregorianCalendar();		
		String dataCadastro = String.format("%d/%d/%d",
			hoje.get(Calendar.DAY_OF_MONTH), hoje.get(Calendar.MONTH)+1, 
			hoje.get(Calendar.YEAR));
		return dataCadastro;
		}
	
	
}
