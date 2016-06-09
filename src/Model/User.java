package Model;

import Controller.Controller;
import View.ShopPage;

/**
 * Created by Jiyoon on 2016. 5. 17..
 */
public class User implements java.io.Serializable 
{
    private String name;
    private int gold;
    private Animal[] myPetList;
    private Cloth[] myClothList;
    private Food[] myFoodList;
    private Potion myPotion=null;
    private int foodIndex=-1;   //new
    private int clothIndex=-1;  //new
    private int petIndex=0;	//new
    private Controller c;
    
    public User(String userName, int petChoice, String petName, Controller c)   
    {
    	this.c = c;
        this.myPetList=new Animal[5];
        this.myFoodList=new Food[8];
        this.myClothList=new Cloth[8];
        this.gold=500;

        this.name=userName;
        //System.out.println("this pet : "+petName);

        if(petChoice == 1)
            myPetList[0]=new BabyCat(petName, 0);
        else if(petChoice == 2)
            myPetList[0]=new BabyMonkey(petName, 0);
        //System.out.println("name : "+this.getPet(0).getName());
    }
    
    public Controller getController() {
    	return c;
    }
	public void setAnimal(Animal p){
    	this.myPetList[++this.petIndex]=p;
    	}    //change
    public void setAnimal(int index, Animal p){
    	this.myPetList[index]=p;
    }    //new
    public void setName(String name){this.name=name;}
    public void setGold(int gold){this.gold=gold;}
    public void setPetList(Animal[] list){this.myPetList=list;}
    public void setFoodList(Food[] list){this.myFoodList=list;}
    public void setClothList(Cloth[] list){this.myClothList=list;}
    public void setFoodList(int listNum, Food food){this.myFoodList[listNum]=food; this.foodIndex++;}
    public void setClothList(int listNum, Cloth cloth){this.myClothList[listNum]=cloth; this.clothIndex++;}
    public void setPotion(Potion potion){this.myPotion=potion;}
    public void setPetIndex(int index){this.petIndex=index;}
    public void setFoodIndex(int index){this.foodIndex=index;}
    public void setClothIndex(int index){this.clothIndex=index;}
    public void setController(Controller c){this.c=c;}

    public Animal[] getPetList(){return this.myPetList;}
    public Food[] getFoodList(){return this.myFoodList;}    //new
    public Food getFood(int index){return this.myFoodList[index];}  //new
    public Cloth[] getClothList(){return this.myClothList;} //new
    public Cloth getCloth(int index){return this.myClothList[index];}   //new
    public int getGold(){return this.gold;} //new
    public Animal getPet(int index){return this.myPetList[index];}  //new
    public String getUsername(){return this.name;}  //new
    public int getUserPetSize(){return this.petIndex+1;}   //new
    public int getFoodIndex(){return  this.foodIndex;}//new
    public int getClothIndex(){return this.clothIndex;} //new
    public int getIndex(){return this.petIndex;}   //new
    public String getName(){return this.name;}
    public Potion getPotion(){return this.myPotion;}
    
    public void useItem(Food i)
    {
    	for(int j=0;j<myFoodList.length;j++)
    		if(myFoodList[j]==i)
    		{
    			myFoodList[j]=null;
    			foodIndex--;
    			break;
    		}
    	for(int j=0;j<foodIndex+1;j++)
    	{
    		if(myFoodList[j]==null)
    		{
    			myFoodList[j]=myFoodList[j+1];
    			myFoodList[j+1]=null;
    		}
    	}
    }
    
    public void useItem()
    {
    	this.myPotion=null;
    }
    
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
    	System.out.println(i.getPrice()+"원 입니다.");
    	if(this.gold>=i.getPrice())
    	{
    		
    		System.out.println("현재 인덱스" + petIndex++);
    		if(i instanceof BabyCat)
    			myPetList[petIndex]=new BabyCat(i.getName(), petIndex);
    		else if(i instanceof BabyMonkey)
    			myPetList[petIndex]=new BabyMonkey(i.getName(), petIndex);
    			
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
    
    public void sellItem(Cloth i)
    {
    	this.gold+=i.getPrice();
    	for(int j=0;j<myClothList.length;j++)
    		if(myClothList[j]==i)
    		{
    			myClothList[j]=null;
    			clothIndex--;
    			break;
    		}
    	for(int j=0;j<clothIndex+1;j++)
    	{
    		if(myClothList[j]==null)
    		{
    			myClothList[j]=myClothList[j+1];
    			myClothList[j+1]=null;
    		}
    	}
    	System.out.println("sell..");
    }
    
    public void sellItem(Food i)
    {
    	this.gold+=i.getPrice();
    	for(int j=0;j<myFoodList.length;j++)
    		if(myFoodList[j]==i)
    		{
    			myFoodList[j]=null;
    			foodIndex--;
    			break;
    		}
    	for(int j=0;j<foodIndex+1;j++)
    	{
    		if(myFoodList[j]==null)
    		{
    			myFoodList[j]=myFoodList[j+1];
    			myFoodList[j+1]=null;
    		}
    	}
    	System.out.println("sell..");
    }
    
    public void sellItem(Potion i)
    {
    	this.gold+=i.getPrice();
    	myPotion=null;
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
