package ule.edi.currency;


import org.junit.Test;

import ule.edi.currency.Euro.Denomination;
import ule.edi.queuewithrep.*;


public class EuroCurrencyTests {

	//	Calcula el valor en Euros de una bolsa
	
	private double totalValueInEuros(QueueWithRep<Denomination> b) {

		double result = 0.0;

		for (Denomination t : Euro.ALL_DENOMINATIONS) {
			result = result + (t.getValue() * b.count(t));
		}

		return result / 100.0;
	}
	
	@Test
	public void testQueueWithRepOfEuros() {
		
		//	Crea una bolsa con elementos del tipo adecuado
		QueueWithRep<Euro.Denomination> B = new ArrayQueueWithRepImpl<Euro.Denomination>();
		
		//	Añade contenido a la bolsa
		B.add(Euro.FIVE_HUNDRED_EUROS, 4);
		B.add(Euro.TWO_HUNDRED_EUROS, 1);
		B.add(Euro.TEN_EUROS, 1);
		B.add(Euro.FIFTY_CENTS, 1);
		
		//	Imprime el contenido de la bolsa; para todas las denominaciones legales...
		for (Euro.Denomination t : Euro.ALL_DENOMINATIONS) {
			//	Si la bolsa contiene esa denominación...
			if (B.contains(t)) {
				//	Mostrar cuántas veces
				System.out.println(t + " x " + B.count(t));
			}
		}
		
		//	Imprime el valor total
		System.out.println("Total: " + Euro.formatValue(totalValueInEuros(B)));
		
		//	Imprime mediante el iterador; para cada elemento en la bolsa que indique el iterador...
		for (Euro.Denomination x : B) {
			//	Mostrarlo
			System.out.println(x);
		}
	}
}
