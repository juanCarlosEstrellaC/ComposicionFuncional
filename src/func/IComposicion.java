package func;

import java.util.function.Function;

public interface IComposicion {

	Function<Function<Integer, Integer>, Function<Function<Integer, Integer>, Function<Integer, Integer>>> composicion();

	static Function<Function<Integer, Integer>, Function<Function<Integer, Integer>, Function<Integer, Integer>>> composicion2() {
		return fn -> (gn -> x -> gn.apply(fn.apply(x)));
	}

	static Function<Integer, Integer> composicion3(Function<Integer, Integer> f, Function<Integer, Integer> g) {
		return x -> f.apply(g.apply(x));
	}

	// ************* EN CLASE: USO LA COMPOSICIÓN SIN PARÁMETROS EN EL MÉTODO, QUE ME DEVUELVE EL TRD DE 5Fs ******************
	static <T> Function<Function<T, T>, Function<Function<T, T>, Function<T, T>>> composicion4() {
		return fn -> (gn -> x -> gn.apply(fn.apply(x)));
	}
	
	static <T, U, V> Function<Function<T, U>, Function<Function<U, V>, Function<T, V>>> composicion5() {
		return fn -> (gn -> x -> gn.apply(fn.apply(x)));
	}
	
	// 
}
