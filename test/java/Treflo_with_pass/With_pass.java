package Treflo_with_pass;

public class With_pass extends baseclass {
	public static void main(String[] args) throws Exception {
		browserchrome();
		OpenUrl("https://app.treflo.com/get-started/signin");
		maximizewindow();
		POJO_Class m=new POJO_Class();
		Sendkeys(m.getMobil_Num(),m.read("C:\\Users\\Admin\\eclipse-workspace\\Treflo_ex_pass\\src\\test\\java\\Treflo_with_pass\\Book1.xlsx", "Sheet1", 4, 1));
		click(m.getLogin());
		System.out.println(" error page");
	}

	
}
