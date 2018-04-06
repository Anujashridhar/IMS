package in.cdac.ims.campus.entity;

import java.util.ArrayList;
import java.util.List;

import in.cdac.db.campus.entity.ImageDetails;

public class ImageForm {

	List<ImageDetails> imageList=new ArrayList<ImageDetails>();

	public List<ImageDetails> getImageList() {
		return imageList;
	}

	public void setImageList(List<ImageDetails> imageList) {
		this.imageList = imageList;
	}

	@Override
	public String toString() {
		return "ImageForm [imageList=" + imageList + "]";
	}
}
