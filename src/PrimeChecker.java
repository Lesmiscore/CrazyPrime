
import java.util.*;
import java.math.BigInteger;

public class PrimeChecker   
{
	static private List<BigInteger> knownPrimes=new ArrayList(Arrays.asList(BigInteger.valueOf(2),BigInteger.valueOf(3),BigInteger.valueOf(5)));
	public static boolean isPrime(BigInteger bi){
		if(knownPrimes.contains(bi)){
			return true;
		}
		BigInteger square=BigIntSqRoot.bigIntSqRootFloor(bi);
		expandTemp(square);
		for(BigInteger i:knownPrimes){
			if(bi.mod(i).equals(BigInteger.ZERO)){
				return false;
			}
		}
		knownPrimes.add(bi);
		return true;
	}
	private static void expandTemp(BigInteger bi){
		if(Collections.max(knownPrimes).min(bi).equals(bi)){
			return;
		}
		expandTemp(bi,false);
	}
	private static void expandTemp(BigInteger bi,boolean force){
		BigInteger max=Collections.max(knownPrimes);
		BigInteger possible=max.pow(2);
		if(bi.min(possible).equals(possible)&!force){
			expandTemp(possible,true);
		}
		for(BigInteger i=BigIntSqRoot.bigIntSqRootCeil(bi);bi.max(i).equals(i);i=i.add(BigInteger.ONE)){
			for(BigInteger j:knownPrimes){
				if(i.mod(j).equals(BigInteger.ZERO)){
					break;
				}
			}
			knownPrimes.add(i);
		}
	}
}
