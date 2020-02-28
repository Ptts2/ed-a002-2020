package ule.edi.currency;


import java.text.NumberFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 * Clase de ejemplo para trabajar con denominaciones (monedas y billetes) de Euro
 * y con bolsas de esos elementos
 * 
 * Ver {@link EuroCurrencyTests} para algunos ejemplos con JUnit.
 * 
 * @author profesor
 *
 */
public class Euro {

	//	Formato para cantidades monetarias en España
	
	private static final Locale LOCALE = new Locale("es", "ES");

	private static final NumberFormat CURRENCY_FORMAT = NumberFormat
			.getCurrencyInstance(LOCALE);

	
	/**
	 * Devuelve una cadena con el valor dado con formato monetario en Euros
	 * 
	 * @param euros
	 * @return
	 */
	public static String formatValue(double euros) {
		return Euro.CURRENCY_FORMAT.format(euros);
	}


	/**
	 * Representa una denominación de un valor dado en céntimos de Euro
	 *  
	 * @author profesor
	 *
	 */
	public static class Denomination {

		Denomination(long cents) {

			this.cents = cents;
		}

		public long getValue() {

			return cents;
		}

		//	No se puede modificar el valor, una vez creada la instancia
		//	pues no se proporciona un método setValue
		
		@Override
		public int hashCode() {
			return Objects.hash(cents);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			} else {
				if (obj instanceof Denomination) {
					return (((Denomination) obj).cents == cents);
				}
			}
			return false;
		}

		@Override
		public String toString() {
			//	Según el formato definido en la clase Euro
			return Euro.formatValue((double) cents / 100.0);
		}

		private long cents;
	}

	//	Se crean instancias para las denominaciones de moneda y billete de Euros, para
	//	que el cliente las utilice
	
	//	En el caso de bolsas de tipo Bag<Denomination>, se almacenan así las mismas instancias de
	//	<code>Denomination</code> en todas las bolsas (se ahorra memoria) y el cliente ya
	//	tiene acceso a las denominaciones como constantes en <code>Euro</code>
	
	/**
	 * Denominaciones de 1 céntimo, 5 céntimos, etc.
	 */
	public static final Denomination ONE_CENT = new Denomination(1);

	public static final Denomination FIVE_CENTS = new Denomination(5);

	public static final Denomination TWENTY_CENTS = new Denomination(20);

	public static final Denomination FIFTY_CENTS = new Denomination(50);

	public static final Denomination ONE_EURO = new Denomination(1 * 100);

	public static final Denomination TWO_EUROS = new Denomination(2 * 100);
	
	public static final Denomination FIVE_EUROS = new Denomination(5 * 100);

	public static final Denomination TEN_EUROS = new Denomination(10 * 100);

	public static final Denomination TWENTY_EUROS = new Denomination(20 * 100);

	public static final Denomination FIFTY_EUROS = new Denomination(50 * 100);

	public static final Denomination ONE_HUNDRED_EUROS = new Denomination(100 * 100);

	public static final Denomination TWO_HUNDRED_EUROS = new Denomination(200 * 100);

	public static final Denomination FIVE_HUNDRED_EUROS = new Denomination(500 * 100);

	//	Para hacer bucles <code>for</code> que inspeccionen todas las denominaciones
	
	/**
	 * Lista de todas las denominaciones de Euro legales
	 */
	public static final List<Denomination> ALL_DENOMINATIONS = new LinkedList<Denomination>(
			Arrays.asList(
					ONE_CENT, FIVE_CENTS, TWENTY_CENTS,
					FIFTY_CENTS, ONE_EURO, TWO_EUROS, FIVE_EUROS,
					TEN_EUROS, TWENTY_EUROS, FIFTY_EUROS,
					ONE_HUNDRED_EUROS, TWO_HUNDRED_EUROS, FIVE_HUNDRED_EUROS));	

}
