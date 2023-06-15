package func;

import java.util.function.Function;

public interface IComposicion {

	Function<Function<Integer, Integer>, Function<Function<Integer, Integer>, Function<Integer, Integer>>> composicion();

	static Function<Function<Integer, Integer>, Function<Function<Integer, Integer>, Function<Integer, Integer>>> composicion2(){
		return fn -> (gn -> x -> gn.apply(fn.apply(x)));
	}


}
