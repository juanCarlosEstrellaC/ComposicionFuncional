package func;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class Main {

	public static void main(String[] args) {

		// ----------------------------- MODELIZACION DE FUNCIONES DE R^n -> R ----------------------------------
//		// R -> R : F<I,I> f1
//		Function<Integer, Integer> f1 = x -> x + 1;
//		Integer a = f1.apply(3);
//		System.out.println(a);
//
//		// R^2 -> R: F<I,F<I,I>> f2
//		Function<Integer, Function<Integer, Integer>> f2 = x -> y -> x + y;
//		Integer b = f2.apply(3).apply(2);
//		System.out.println(b);
//
//		// R^3 -> R: F<I,F<I,F<I,I>>> f3
//		Function<Integer, Function<Integer, Function<Integer, Integer>>> f3 = x -> y -> z -> x + y + z;
//		Integer c = f3.apply(3).apply(2).apply(4);
//		System.out.println(c);
//
		// --------------------------  MODELIZACION DE COMPOSICIÓN DE FUNCIONES gof = g(f(x)) ---------------------

		Function<Integer, Integer> f = x -> 3 * x;
		Function<Integer, Integer> g = x -> x * x;
		
		// 1. Usando la interface funcional Function:
			/* Así sería como normalmente he usado:
			 
			 	 F< I , I> sumarUno
		 		 F< Dominio, Rango> sumarUno
		 		 
				 Function<Integer, Integer> sumarUno = x -> x+1;
				 var v = sumarUno.apply(5);
				 System.out.println(v);
			
				Pero, en esta ocasión, el Function es de esta manera:
			    	
			    	F< F<I,I> , F<F<I,I>,F<I,I>>> compo
		 		    F< Dominio,       Rango     > compo
			 */
		
			Function<Function<Integer, Integer>, Function<Function<Integer, Integer>, Function<Integer, Integer>>> compo = fn -> (gn -> x -> gn.apply(fn.apply(x)));
			Integer d = compo.apply(f).apply(g).apply(2);
			System.out.println(d);


		
		// 2. USANDO INTERFACES:
			IComposicion iComposicion = () -> fn -> (gn -> x -> gn.apply(fn.apply(x)));
			var funcionCompuesta = iComposicion.composicion();
			var fog = funcionCompuesta.apply(f).apply(g).apply(2);
			System.out.println("fog = f(g(x)) = "+fog);
			
			var funcionCompuesta2 = IComposicion.composicion2();
			var fog2 = funcionCompuesta2.apply(f).apply(g).apply(2);
			System.out.println("fog2 = f(g(x)) = "+fog2);
			
			var funcionCompuesta3 = IComposicion.composicion3(g, f);
			var fog3 = funcionCompuesta3.apply(2);
			System.out.println("fog3 = f(g(x)) = "+fog3);
			
			
			// ******************************* EN CLASE ********************************************
			var funcionCompuesta4 = IComposicion.<Integer>composicion4();
			var fog4 = funcionCompuesta4.apply(f).apply(g).apply(2);
			System.out.println("fog4 = f(g(x)) = "+fog4);
			
			var funcionCompuesta5 = IComposicion.<Integer, Integer, Integer>composicion5();
			var fog5 = funcionCompuesta5.apply(f).apply(g).apply(2);
			System.out.println("fog5 = f(g(x)) = "+fog5);
			
			
			// ********************************  DEBER *******************************************
			String txt = "hola mundo java hola abc";
			
			Function<String, String[]> funcion1 = cadena -> cadena.split(" ");
	
			Function<String[], List<Par>> funcion2 = arregloStrings -> {
				List<Par> listaPares = new ArrayList<>();
				for (String palabra : arregloStrings) {
					int contador = 0;
					for (String palabra2 : arregloStrings) {
						if (palabra.equals(palabra2)) {
							contador++;
						}
					}
					Par par = new Par(palabra, contador);
					listaPares.add(par);
				}
				return listaPares;
			};
			
			// Sin usar la funcion de composición:
			List<Par> listaPares = funcion2.apply(funcion1.apply(txt));
			for (Par par : listaPares) {
				System.out.println(par);
			}
	
			// Usando la función de composición:
			List<Par> listaPares2 = IComposicion.<String, String[], List<Par>>composicion5().apply(funcion1).apply(funcion2).apply(txt);
			for (Par par : listaPares2) {
				System.out.println(par);
			}
		}

}
