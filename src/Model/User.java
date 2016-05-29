package Model;

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
    private int index=0;    //new
    private int foodIndex=-1;   //new
    private int clothIndex=-1;  //new
    
    public User(String userName, int petChoice, String petName)   //蹂��솕
    {
        this.myPetList=new Animal[5];
        this.myFoodList=new Food[8];
        this.myClothList=new Cloth[8];
        this.gold=500;

        this.name=userName;

        if(petChoice == 1)
            myPetList[index]=new BabyCat(petName);
        else if(petChoice == 2)
            myPetList[index]=new BabyMonkey(petName);
    }

    public void setAnimal(Animal p){this.myPetList[++this.index]=p;}    //change
    public void setAnimal(int index, Animal p){this.myPetList[index]=p;this.index++;}    //new
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
    
    public boolean buyItem(String name)
    {
    	ShopPage item=new ShopPage();
    	
    	if(name==item.foodList[0].getName())
    	{
    		if(this.gold>=item.foodList[0].getPrice())
    		{
    			gold-=item.foodList[0].getPrice();
    			return true;
    		}
    	}
    	else if(name==item.foodList[1].getName())
    	{
    		if(this.gold>=item.foodList[1].getPrice())
    		{
    			gold-=item.foodList[1].getPrice();
    			return true;
    		}
    	}
    	else if(name==item.foodList[2].getName())
    	{
    		if(this.gold>=item.foodList[2].getPrice())
    		{
    			gold-=item.foodList[2].getPrice();
    			return true;
    		}
    	}
    	
    	if(name==item.clothList[0].getName())
    	{
    		if(this.gold>=item.clothList[0].getPrice())
    		{
    			gold-=item.clothList[0].getPrice();
    			return true;
    		}
    	}
    	else if(name==item.clothList[1].getName())
    	{
    		if(this.gold>=item.clothList[1].getPrice())
    		{
    			gold-=item.clothList[1].getPrice();
    			return true;
    		}
    	}
    	else if(name==item.clothList[2].getName())
    	{
    		if(this.gold>=item.clothList[2].getPrice())
    		{
    			gold-=item.clothList[2].getPrice();
    			return true;
    		}
    	}
    	
    	if(name==item.animalList[0].getName())
    	{
    		if(this.gold>=item.animalList[0].getPrice())
    		{
    			gold-=item.animalList[0].getPrice();
    			return true;
    		}
    	}
    	else if(name==item.animalList[1].getName())
    	{
    		if(this.gold>=item.animalList[1].getPrice())
    		{
    			gold-=item.animalList[1].getPrice();
    			return true;
    		}
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
