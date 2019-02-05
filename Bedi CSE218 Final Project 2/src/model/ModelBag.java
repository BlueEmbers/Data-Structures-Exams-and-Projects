package model;

public class ModelBag {

	private UserBag userBag;
	private CollegeBag collegeBag;
	
	public ModelBag(UserBag userBag, CollegeBag collegeBag) {
		super();
		this.userBag = userBag;
		this.collegeBag = collegeBag;
	}

	public UserBag getUserBag() {
		return userBag;
	}

	public void setUserBag(UserBag userBag) {
		this.userBag = userBag;
	}

	public CollegeBag getCollegeBag() {
		return collegeBag;
	}

	public void setCollegeBag(CollegeBag collegeBag) {
		this.collegeBag = collegeBag;
	}
	
}
