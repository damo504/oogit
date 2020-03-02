package polyderivate;
import java.util.Scanner;
public class polyderi {

	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		String Polynomial=input.nextLine();
		polycheck poly_del_sp=new polycheck(Polynomial);
		String poly_to_deri=poly_del_sp.optimize(Polynomial);
		polyderivation polyderivate=new polyderivation(poly_to_deri);
		polyderivate.isconst();
		polyderivate.fillmap();
		
		

	}

}
