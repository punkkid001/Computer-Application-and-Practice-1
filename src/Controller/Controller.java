package Controller;
import Model.Animal;
import Model.User;
import View.*;

public class Controller
{
	public MainFrame m;
	protected User presentUser;
	
	//temporary value;
	private String userName;
	private int petNum;
	private String petName;
	
	public Controller()
	{
		m = new MainFrame(this);
		m.gotoStartPage();  //startPage 호출.
	}
	
	//start page
	public void goUserSetting()
	{
		System.out.println("스타트 버튼이 눌렸는걸 컨트롤러에서 알았습니다.");
		m.gotoUserSettingPage();
	}
	public void loadFile(){ }
	public void gameExit()
	{
		System.out.println("컨트롤러에서 알아차림 : 게임 종료.");
		System.exit(0);
	}
	
	//userSettingPage
	public void goPetSetting(String userName)
	{
		System.out.println("유저 이름 : " + userName + "을 받았습니다.");
		this.userName = userName;
		m.gotoPetSettingPage();
	}
	
	//petSettingPage
	public void goStartingPoint(int petNum, String petName)
	{
		System.out.println(petNum + ", " + petName + "데이터를 받음.");
		/*
		 * 유저와 pet초기화 하는 부분 필요.
		 * 
		 * 
		 */
		presentUser=new User(userName, petNum, petName);
		m.gotogameStartingPoint();
		this.viewLivingroomStatus();
		m.livingroomPage.createPetIcon(presentUser.getPet(0));
		presentUser.getPet(0).setPlace(m.livingroomPage);
		m.setVisible(true);
	}
	
	//map change 0:거실, 1:화장실, 2마당
	public void changeMap(Animal pet, int placeNum)
	{
		pet.getMyLocation().delectIcon(pet);
		if(placeNum == 0)
			pet.setPlace(m.livingroomPage);
		else if(placeNum == 1)
			pet.setPlace(m.bathroomPage);
		else 
			pet.setPlace(m.yardPage);
		pet.getMyLocation().createPetIcon(pet);
	}
	
	public void viewLivingroomStatus()
	{
		m.livingroomPage.simpleUserInfo.setText("Username : "+presentUser.getUsername()+" Gold : "+presentUser.getGold()+" Pet count : "+presentUser.getUserPetSize());	
	}
	public void viewBathroomStatus()
	{
		m.bathroomPage.simpleUserInfo.setText("Username : "+presentUser.getUsername()+" Gold : "+presentUser.getGold()+" Pet count : "+presentUser.getUserPetSize());
	}
	public void viewShopStatus()
	{
		m.shopPage.simpleUserInfo.setText("Username : "+presentUser.getUsername()+" Gold : "+presentUser.getGold()+" Pet count : "+presentUser.getUserPetSize());
	}
	public void viewYardStatus()
	{
		m.yardPage.simpleUserInfo.setText("Username : "+presentUser.getUsername()+" Gold : "+presentUser.getGold()+" Pet count : "+presentUser.getUserPetSize());
	}
	
	public String[] appendClosetItemList()
	{
		String[] list=presentUser.getClothItemNameList();
		return list;
	}
	
	public String[] appendFoodItemList()
	{
		String[] list=presentUser.getFoodItemList();
		return list;
	}
	
	public User getPresentUser()
	{
		return this.presentUser;
	}
}