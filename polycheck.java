package polyderivate;
import java.util.Scanner;
import java.util.regex.*;

public class polycheck {
	private String polyinput;
	private String space="[ \\t]*";//空白字符
	private String b1="\\+\\+|--";
	private String b2="\\+-|-\\+";//第一项前有符号
	private String polyregex="^([ \\t]*[\\+-]?[ \\t]*[\\+-]?[0-9]+[ \\t]*\\*[ \\t]*x[ \\t]*(\\*\\*[ \\t]*[\\+-]?[0-9]+)?|[ \\t]*[\\+-]?[ \\t]*x[ \\t]*(\\*\\*[ \\t]*[\\+-]?[0-9]+)?|[ \\t]*[\\+-]?[0-9]+)+$";
	//多项式正则表达式
	public polycheck(String input) {
		polyinput=input;//输入多项式字符串
}
	public String optimize(String str) {//将多项式与正则表达式匹配
		Pattern p=Pattern.compile(polyregex);
		Matcher m=p.matcher(polyinput);
		if(m.find())//匹配成功
		{
			polyinput=polyinput.replaceAll(space, "");
			polyinput=polyinput.replaceAll(b1, "");
			polyinput=polyinput.replaceAll(b2, "-");
			polyinput=polyinput.replaceAll("\\+x", "\\+1\\*x");
			polyinput=polyinput.replaceAll("-x", "-1\\*x");
		}//对多项式进行去除空白符、消除连续的符号、给单个x补1的操作
			
		else
		{
			System.out.println("WRONG FORMAT!");
			System.exit(0);
		}//匹配不成功则退出程序
		return polyinput;	
			
		
	}

	}



