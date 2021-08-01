
public class Category {
	private String catName;
	private int catId;
	public Category(String catName, int catId) {
		super();
		this.catName = catName;
		this.catId = catId;
	}
	
	public String getCatName() {
		return catName;
	}
	
	public void setCatName(String catName) {
		this.catName = catName;
	}
	
	public int getCatId() {
		return catId;
	}
	
	public void setCatId(int catId) {
		this.catId = catId;
	}
	
	@Override
	public String toString() {
		return "CCACategory [name=" + catName + ", id=" + catId + "]";
	}
	
}
