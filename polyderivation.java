package polyderivate;
import java.math.BigInteger;
import java.util.regex.*;
import java.util.HashMap;

public class polyderivation {//对多项式求导
	private String polytoderi;
	private HashMap<BigInteger,BigInteger> terms= new HashMap<BigInteger,BigInteger>();
	public polyderivation(String str) {
		polytoderi = str;
	}
	private String optiregex="([\\+-]?[0-9]+)\\*x\\*\\*([\\+-]?[0-9]+)|([\\+-]?[0-9]+)\\*x|([\\+-]?[0-9]+)";
	private String zero="[\\+-]?[0-9]+";
	//匹配正则多项式
	public void isconst() {
		if(polytoderi.matches(zero)) {
			System.out.println(0);
			System.exit(0);
		}
	}
	public void fillmap() {//将匹配后的多项式指数和系数填入hashmap
		Pattern p=Pattern.compile(optiregex);
		Matcher m=p.matcher(polytoderi);
		while(m.find()) {
			if(m.group(1)!=null && m.group(2)!=null) {//形如2*x**2的项
				BigInteger coeff=new BigInteger(m.group(1));//系数
				BigInteger expo=new BigInteger(m.group(2));//指数
				if(terms.containsKey(expo)) {//如果指数相同则系数相加
					BigInteger newcoeff=terms.get(expo).add(coeff);
					terms.put(expo, newcoeff);}
				else
					terms.put(expo, coeff);//如果指数不同则填入新项
			}
			if(m.group(3)!=null) {//形如2*x的项
				BigInteger coeff=new BigInteger(m.group(3));//系数
				BigInteger expo=new BigInteger("1");//指数为1
				if(terms.containsKey(expo)) {//如果有相同的项则系数相加
					BigInteger newcoeff=terms.get(expo).add(coeff);
					terms.put(expo, newcoeff);}
				else
					terms.put(expo, coeff);//否则填入新项
			}
			
			

		}

		for(BigInteger k : terms.keySet()) {//对hashmap中的每一项求导
			BigInteger newcoeff=terms.get(k).multiply(k);//系数=系数x指数
			terms.put(k, newcoeff);//得到求导后的新项
			if(k.intValue()-1==0) {//如果指数为1
				System.out.printf("%d",terms.get(k).intValue());//则求导后为常数
			}
			else if(k.intValue()-1==1) {
				if(terms.get(k).intValue()>0)
					System.out.printf("+%d*x", terms.get(k).intValue());
				else 
					System.out.printf("%d*x", terms.get(k).intValue());
			}
	
			else
				System.out.printf("%d*x**%d", terms.get(k).intValue(),k.intValue()-1);//指数减一输出项
		}
	}
	 
}
