package polyderivate;
import java.math.BigInteger;
import java.util.regex.*;
import java.util.HashMap;

public class polyderivation {//�Զ���ʽ��
	private String polytoderi;
	private HashMap<BigInteger,BigInteger> terms= new HashMap<BigInteger,BigInteger>();
	public polyderivation(String str) {
		polytoderi = str;
	}
	private String optiregex="([\\+-]?[0-9]+)\\*x\\*\\*([\\+-]?[0-9]+)|([\\+-]?[0-9]+)\\*x|([\\+-]?[0-9]+)";
	private String zero="[\\+-]?[0-9]+";
	//ƥ���������ʽ
	public void isconst() {
		if(polytoderi.matches(zero)) {
			System.out.println(0);
			System.exit(0);
		}
	}
	public void fillmap() {//��ƥ���Ķ���ʽָ����ϵ������hashmap
		Pattern p=Pattern.compile(optiregex);
		Matcher m=p.matcher(polytoderi);
		while(m.find()) {
			if(m.group(1)!=null && m.group(2)!=null) {//����2*x**2����
				BigInteger coeff=new BigInteger(m.group(1));//ϵ��
				BigInteger expo=new BigInteger(m.group(2));//ָ��
				if(terms.containsKey(expo)) {//���ָ����ͬ��ϵ�����
					BigInteger newcoeff=terms.get(expo).add(coeff);
					terms.put(expo, newcoeff);}
				else
					terms.put(expo, coeff);//���ָ����ͬ����������
			}
			if(m.group(3)!=null) {//����2*x����
				BigInteger coeff=new BigInteger(m.group(3));//ϵ��
				BigInteger expo=new BigInteger("1");//ָ��Ϊ1
				if(terms.containsKey(expo)) {//�������ͬ������ϵ�����
					BigInteger newcoeff=terms.get(expo).add(coeff);
					terms.put(expo, newcoeff);}
				else
					terms.put(expo, coeff);//������������
			}
			
			

		}

		for(BigInteger k : terms.keySet()) {//��hashmap�е�ÿһ����
			BigInteger newcoeff=terms.get(k).multiply(k);//ϵ��=ϵ��xָ��
			terms.put(k, newcoeff);//�õ��󵼺������
			if(k.intValue()-1==0) {//���ָ��Ϊ1
				System.out.printf("%d",terms.get(k).intValue());//���󵼺�Ϊ����
			}
			else if(k.intValue()-1==1) {
				if(terms.get(k).intValue()>0)
					System.out.printf("+%d*x", terms.get(k).intValue());
				else 
					System.out.printf("%d*x", terms.get(k).intValue());
			}
	
			else
				System.out.printf("%d*x**%d", terms.get(k).intValue(),k.intValue()-1);//ָ����һ�����
		}
	}
	 
}
