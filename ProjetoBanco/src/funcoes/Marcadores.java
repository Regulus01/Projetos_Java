package funcoes;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Marcadores {
	public void dataCadastro(String dataCadastro) {
		Calendar hoje = new GregorianCalendar();			
		dataCadastro = String.format("%d/%d/%d",
			hoje.get(Calendar.DAY_OF_MONTH), hoje.get(Calendar.MONTH)+1, 
			hoje.get(Calendar.YEAR));
		}
}
