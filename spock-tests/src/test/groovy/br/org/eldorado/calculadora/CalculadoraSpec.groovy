package br.org.eldorado.calculadora

import spock.lang.Specification
import spock.lang.Unroll
import br.org.eldorado.calculadora.Calculadora

class CalculadoraSpec extends Specification {
	
	@Unroll
	def "Testando calculadora com valores a = #valorA e b = #valorB"() {
		given: "uma calculadora"
		Calculadora calc = new Calculadora();

		expect: "realiza os calculos"
		calc.soma(valorA,valorB)==soma
		calc.subtrai(valorA,valorB)==subtrai
		calc.multiplica(valorA,valorB)==multiplica
		calc.divide(valorA,valorB)==divide
		calc.elevadoAo(valorA,valorB)==elevadoAo

		where: "soma, subtrai, multiplica e eleva ao exponencial"
		valorA                    |valorB                     || soma                      | subtrai | multiplica | divide  | elevadoAo
		6                         | 2                         || 8                         | 4       | 12         | 3       | 36
		2+3                       | 5-2                       || new Integer(8).intValue() | 2       | 15         | 1.667   | 125
		[1,2,3].get(1)            | 3                         || 5                         |-1       | 6          | 0.667   | 8
		new Integer(5).intValue() | new String("cat").size()  || BigDecimal.valueOf(8)     | 2       | 15         | 1.667   | 125
		Integer.valueOf("9")  	  | BigDecimal.ZERO.intValue()|| 9                         | 9       | 0          | null    | 1
	}

}
