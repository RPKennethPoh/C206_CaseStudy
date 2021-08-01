import java.util.ArrayList;

public class C206_CaseStudy {
	ArrayList<Category> categoryArrList;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//Add category
	private boolean addCategory(int catId, String catName) {
		boolean added = false;
		
		Category category = new Category(catId, catName);
		
		int oldArrListSize = categoryArrList.size();
		categoryArrList.add(category);
		
		int newArrListSize = categoryArrList.size();
		
		if (newArrListSize == (oldArrListSize + 1)) {
			added = true;
		}
		
		return added;
	}

}
