/**
 * @author Vrinda
 * Class for image attribute
 */
public class Image {
	private String imgName;
	private String imgUrl;
	
	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getImgName() {
		return imgName;
	}

	public Image(String imgName, String imgUrl) {
		super();
		this.imgName = imgName;
		this.imgUrl = imgUrl;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
}
