
public class Category {
	private int catId;
	private String catName;

	public Category(int catId, String catName) {
		super();
		this.catId = catId;
		this.catName = catName;
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
