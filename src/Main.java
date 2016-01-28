import java.util.*;
import java.math.*;

public class Main
{
	static final BigInteger START;
	public static void main(String[] args)
	{
		System.out.println(sqrt(BigInteger.valueOf(76405081)));
		
		//System.out.println(START);
		//BigInteger squ=sqrt(START);
		//System.out.println(squ);
		//for(BigInteger bi=START;bi.min(START).equals(START);bi.add(BigInteger.ONE)){
			
		//}
	}
	static{
		StringBuilder sb=new StringBuilder("f");
		for(int i=0;i<11;i++)sb.append(sb);
		START=new BigInteger(""+sb,16);
	}
	
	public static BigInteger sqrt(BigInteger value){
		//Thanked by http://www.suguru.jp/www.monjirou.net/semi/root/
		
		final BigInteger INT_MAX_VALUE=BigInteger.valueOf(Integer.MAX_VALUE);
		
		String strVal=value.toString();
		String[] splitted=new String[(strVal.length()+((strVal.length()%2)==0?0:1))/2];
		if(strVal.length()%2==0){
			for(int i=0;i<strVal.length();i+=2){
				splitted[i/2]=new String(new char[]{strVal.charAt(i),strVal.charAt(i+1)});
			}
		}else{
			splitted[0]=new String(new char[]{strVal.charAt(0)});
			for(int i=1;i<strVal.length();i+=2){
				splitted[((i-1)/2)+1]=new String(new char[]{strVal.charAt(i),strVal.charAt(i+1)});
			}
		}
		
		int[] inderminate=new int[splitted.length];
		Arrays.fill(inderminate,-1);
		BigInteger mutiplyTmp=new BigInteger(splitted[0]);
		BigInteger substactTmp=mutiplyTmp;
		for(int i=0;i<splitted.length;i++){
			if(0!=i){
				mutiplyTmp=mutiplyTmp.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(inderminate[i-1]));
				substactTmp=new BigInteger(substactTmp.toString()+splitted[i]);
			}
			BigInteger multipliedE=null;
			for(int j=1;j<11;j++){
				BigInteger nowValue=new BigInteger(substactTmp.toString()+j);
				BigInteger multiplied=nowValue.multiply(BigInteger.valueOf(j));
				System.err.println("nv ["+i+"]  =="+nowValue);
				System.err.println("nv ["+i+"]*"+j+"=="+nowValue.multiply(BigInteger.valueOf(j)));
				if(!multiplied.subtract(substactTmp).max(BigInteger.ZERO).equals(BigInteger.ZERO)){
					inderminate[i]=j-1;
					multipliedE=multiplied;
				}
			}
			if(inderminate[i]==-1){
				throw new RuntimeException("Implementation bug");
			}
			System.err.println("mule=="+multipliedE);
			System.err.println("sbst=="+substactTmp);
			substactTmp=substactTmp.subtract(multipliedE);
		}
		StringBuilder sb=new StringBuilder();
		for(int v:inderminate){
			sb.append(v);
		}
		return new BigInteger(sb.toString());
	}
}
