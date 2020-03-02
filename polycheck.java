package polyderivate;
import java.util.Scanner;
import java.util.regex.*;

public class polycheck {
	private String polyinput;
	private String space="[ \\t]*";//�հ��ַ�
	private String b1="\\+\\+|--";
	private String b2="\\+-|-\\+";//��һ��ǰ�з���
	private String polyregex="^([ \\t]*[\\+-]?[ \\t]*[\\+-]?[0-9]+[ \\t]*\\*[ \\t]*x[ \\t]*(\\*\\*[ \\t]*[\\+-]?[0-9]+)?|[ \\t]*[\\+-]?[ \\t]*x[ \\t]*(\\*\\*[ \\t]*[\\+-]?[0-9]+)?|[ \\t]*[\\+-]?[0-9]+)+$";
	//����ʽ������ʽ
	public polycheck(String input) {
		polyinput=input;//�������ʽ�ַ���
}
	public String optimize(String str) {//������ʽ��������ʽƥ��
		Pattern p=Pattern.compile(polyregex);
		Matcher m=p.matcher(polyinput);
		if(m.find())//ƥ��ɹ�
		{
			polyinput=polyinput.replaceAll(space, "");
			polyinput=polyinput.replaceAll(b1, "");
			polyinput=polyinput.replaceAll(b2, "-");
			polyinput=polyinput.replaceAll("\\+x", "\\+1\\*x");
			polyinput=polyinput.replaceAll("-x", "-1\\*x");
		}//�Զ���ʽ����ȥ���հ׷������������ķ��š�������x��1�Ĳ���
			
		else
		{
			System.out.println("WRONG FORMAT!");
			System.exit(0);
		}//ƥ�䲻�ɹ����˳�����
		return polyinput;	
			
		
	}

	}



