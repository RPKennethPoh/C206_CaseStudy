import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<CCA> ccaList = new ArrayList<CCA>();

	}
	
	//Add CCA
	public static CCA addCCA() {
		System.out.println(viewAllCategories());
		int catId = Helper.readInt("Enter CCA's category ID > ");
		String title = Helper.readString("Enter CCA's title > ");
		String desc = Helper.readString("Enter CCA's description > ");
		int size = Helper.readInt("Enter CCA's cohort size > ");
		String day = Helper.readString("Enter CCA's day > ");
		String time = Helper.readString("Enter CCA's timing (start to end, in 24 hours) > ");
		String venue = Helper.readString("Enter CCA's venue > ");
		String instructor = Helper.readString("Enter CCA's instructor in-charge > ");
		CCA cca = new CCA(catId, )
	}

}
