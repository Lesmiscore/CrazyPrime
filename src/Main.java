import java.util.*;
import java.math.*;

public class Main
{
	static final BigInteger START;
	public static void main(String[] args)
	{
		System.out.println(sqrt(BigInteger.valueOf(76405081)));
		
		System.out.println(START);
		BigInteger squ=sqrt(START);
		System.out.println(squ);
		
		System.out.println(PrimeChecker.isPrime(START));
	}
	static{
		StringBuilder sb=new StringBuilder("f");
		for(int i=0;i<15;i++)sb.append(sb);
		START=new BigInteger(""+sb,16);
	}
	
	public static BigInteger sqrt(BigInteger value){
		return BigIntSqRoot.bigIntSqRootFloor(value);
	}
}
