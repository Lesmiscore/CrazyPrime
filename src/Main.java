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
		for(BigInteger bi=START;bi.min(START).equals(START);bi.add(BigInteger.ONE)){
			
		}
	}
	static{
		StringBuilder sb=new StringBuilder("f");
		for(int i=0;i<11;i++)sb.append(sb);
		START=new BigInteger(""+sb,16);
	}
	
	public static BigInteger sqrt(BigInteger value){
		//Thanked by http://www.suguru.jp/www.monjirou.net/semi/root/
		
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
				mutiplyTmp=new BigInteger(mutiplyTmp.toString()+inderminate[i-1]);
				substactTmp=new BigInteger(substactTmp.toString()+splitted[i-1]);
			}
			for(int j=1;j<10;j++){
				BigInteger nowValue=new BigInteger(substactTmp.toString()+j);
				if(!nowValue.multiply(BigInteger.valueOf(j)).max(substactTmp).equals(substactTmp)){
					inderminate[i]=j-1;
					break;
				}
			}
			if(inderminate[i]==-1){
				throw new RuntimeException("Implementation bug");
			}
			substactTmp=substactTmp.subtract(new BigInteger(substactTmp.toString()+inderminate[i]).multiply(BigInteger.valueOf(inderminate[i])));
		}
		StringBuilder sb=new StringBuilder();
		for(int v:inderminate){
			sb.append(v);
		}
		return new BigInteger(sb.toString());
	}
}
