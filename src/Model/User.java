package Model;

import Controller.Controller;
import View.ShopPage;

/**
 * Created by Jiyoon on 2016. 5. 17..
 */
public class User
{
    private String name;
    private int gold;
    private Animal[] myPetList;
    private Cloth[] myClothList;
    private Food[] myFoodList;
    private Potion myPotion;
    private int index=0;    //new
    private int foodIndex=-1;   //new
    private int clothIndex=-1;  //new
    private int petIndex=-1;	//new
    private Controller c;
    
    public User(String userName, int petChoice, String petName, Controller c)   
    {
    	this.c = c;
        this.myPetList=new Animal[5];
        this.myFoodList=new Food[8];
        this.myClothList=new Cloth[8];
        this.gold=500;

        this.name=userName;

        if(petChoice == 1)
            myPetList[0]=new BabyCat(petName, 0);
        else if(petChoice == 2)
            myPetList[0]=new BabyMonkey(petName, 0);
    }

    
    public Controller getController() {
    	return c;
    }
	public void setAnimal(Animal p){
    	this.myPetList[++this.index]=p;
    	}    //change
    public void setAnimal(int index, Animal p){
    	this.myPetList[index]=p;
    }    //new
    public void setGold(int gold){this.gold=gold;}
    public void setFoodList(int listNum, Food food){this.myFoodList[listNum]=food; this.foodIndex++;}
    public void setClothList(int listNum, Cloth cloth){this.myClothList[listNum]=cloth; this.clothIndex++;}

    public Animal[] getPetList(){return this.myPetList;}
    public Food[] getFoodList(){return this.myFoodList;}    //new
    public Food getFood(int index){return this.myFoodList[index];}  //new
    public Cloth[] getClothList(){return this.myClothList;} //new
    public Cloth getCloth(int index){return this.myClothList[index];}   //new
    public int getGold(){return this.gold;} //new
    public Animal getPet(int index){return this.myPetList[index];}  //new
    public String getUsername(){return this.name;}  //new
    public int getUserPetSize(){return this.index+1;}   //new
    public int getFoodIndex(){return  this.foodIndex;}//new
    public int getClothIndex(){return this.clothIndex;} //new
    public int getIndex(){return this.index;}   //new
    
    public boolean buyItem(Food i)
    {
    	if(this.gold>=i.getPrice())
    	{
    		myFoodList[++foodIndex]=i;
    		System.out.println(i.getName()+" buy...");
    		this.gold-=i.getPrice();
    		return true;
    	}
		return false;
    }
    public boolean buyItem(Cloth i)
    {
    	if(this.gold>=i.getPrice())
    	{
    		myClothList[++clothIndex]=i;
    		System.out.println(i.getName()+" buy...");
    		this.gold-=i.getPrice();
    		return true;
    	}
		return false;
    }
    public boolean buyItem(Animal i)	//Need TO CHANGE
    {
    	if(this.gold>=i.getPrice())
    	{
    		petIndex++;
    		if(i instanceof BabyCat)
    			myPetList[petIndex]=new BabyCat("name1", petIndex);
    		else
    			myPetList[petIndex]=new BabyMonkey("name2", petIndex);
    			
    		c.m.livingroomPage.createPetIcon(myPetList[petIndex]);
    		myPetList[petIndex].setPlace(c.m.livingroomPage);
    		c.m.setVisible(true);
    		System.out.println(i.getName()+" buy...");
    		this.gold-=i.getPrice();
    		System.out.println("구매 완료");
    		return true;
    	}
		return false;
    }
    
    public boolean buyItem(Potion i)
    {
    	if(this.gold>=i.getPrice())
    	{
    		myPotion=i;
    		System.out.println(i.getName()+" buy...");
    		this.gold-=i.getPrice();
    		return true;
    	}
    	return false;
    }
    
    public String[] getClothItemNameList()
    {
    	if(clothIndex!=-1)
    	{
    		String list[]=new String[clothIndex+1];
    		for(int i=0;i<clothIndex+1;i++)
    		list[i]=myClothList[i].getName();
    		
    		return list;
    	}
    	else
    		return null;
    }
    
    public String[] getFoodItemList()
    {
    	if(this.foodIndex!=-1)
    	{
    		String list[]=new String[foodIndex+1];
    		for(int i=0;i<foodIndex+1;i++)
    			list[i]=myFoodList[i].getName();
    		return list;
    	}
    	else
    		return null;
    }
}
