package Model;

import java.util.Random;

import javax.swing.ImageIcon;

import View.BathroomPage;
import View.LivingroomPage;
import View.PetLabel;
import View.Place;
import View.ShopPage;

/**
 * Created by Jiyoon on 2016. 5. 1..
 */
public abstract class Animal implements AnimalOperation_IF, Fight_IF, java.io.Serializable 
{
	private String name;
    private Place myLocation;
    //private String locationName;
    private Cloth myCloth;
    
    private int happiness;  //0~100
    private int fatigability;   //0~100 (1 activity(except for rid drappings) -> +10 / sleep -> -40)
    private int satiety;    //0~100 (feed -> +30 / play(-20), talk(-5), sleep(-10))
    private int drappings; //0~4 (activeCount=10 -> +1)
    
    private int exp;    //0~100 (1 activity -> +5)
    private int level;  //1~5
    
    
    private int power;  //0~300
    private int stemina;    //0~1000 for battle
    private int defense;    //0~300
    
    private int activeCount;
    private int m_x=250;
    private int m_y=250;
    private String[] speechList;
    transient private ImageIcon myImage;
    transient private ImageIcon faceImage[];  //제너럴 써야할듯?
    private PetLabel myView;
    
    private User myUser;
    private int index;
    private int price;

    public Animal()
    {
    	this.faceImage = new ImageIcon[5];
    	// 기본 메시지
    	this.speechList = new String[]{
    			"Level up!", 						//0		levelUp 
    			"충분히 깨끗해",				 			//1		ridDrappings-false
    			"고마워! 깨끗해졌어!!!",				 	//2		ridDrappings-true
        		"똥 치워줘@@@", 						//3		letProtest-ridDappings
        		"즐거운 놀이시간~!", 						//4		play
        		"너랑 안놀거야",		 					//5		letProtest-play	
        		"맛있어", 								//6		feed
        		"입맛 없어", 							//7		letProtest-feed
        		"zZZ...", 							//8		sleep
        		"나 그냥 잘거야", 						//9		force sleep
        		"어때, 잘어울려?", 						//10	dress
        		"null", 							//11	special_1
        		"null", 							//12	special_2
        		"null", 							//13	special_3
        		"null", 							//14	special_4
        		"null",		 						//15	special_5
        		"null",								//16	special_6
        		"Happy",							//17	happy
        		"Hungry",							//18	hungry
        		"Tired"								//19	tired
        };

        //setting start stat
        this.fatigability=30;  //피로도
        this.satiety=30;	//배고픔
        this.happiness=30;	//행복도
        this.drappings=0;

        this.power=20;
        this.stemina=50;
        this.defense=10;

        this.level=1;
        this.exp=0;
        this.activeCount=0;
        this.myCloth=null;
    }
    public Animal(User myUser, int index) {
    	this();
    	this.myUser = myUser;
    	this.index = index;
    }
    
    public Animal(Animal p)
    {	
    	this();
    	this.setName(p.getName());
    	this.setPlace(p.getMyLocation());
    	this.setMyCloth(p.getMyCloth());
        this.setLevel(p.getLevel());

        this.setHappiness(p.getHappiness());
        this.setFatigability(p.getFatigability());
        this.setSatiety(p.getSatiety());
        this.setDrappings(p.getDrappings());
        
        this.exp = 0;
        this.setLevel(p.getLevel());
        
    	this.setStemina(p.getStemina());
        this.setPower(p.getPower());
    	this.setDefense(p.getDefense());

    	this.setActiveCount(p.getActiveCount());
    	this.setXY(p.getX(), p.getY());
    }
    
    public void setMyUser(User p) {
    	this.myUser = p;
    }
    public User getMyUser() {
    	return this.myUser;
    }
    public void setLabel(PetLabel p) {
    	this.myView = p;
    }
    public PetLabel getLabel() {
    	return this.myView;
    }
    public void setActiveCount(int activeCount) {
		this.activeCount = activeCount;
	}
    public void setHappiness(int happiness) {
		this.happiness = happiness;
	}
    public void setMyCloth(Cloth myCloth) {
		this.myCloth = myCloth;
	}
    public void setDrappings(int drappings) {
		this.drappings = drappings;
	}
    public void setSatiety(int satiety) {
		this.satiety = satiety;
	}
	public void setFatigability(int fatigability) {
		this.fatigability = fatigability;
	}
	public int getHappiness() {
		// TODO Auto-generated method stub
		return this.happiness;
	}
	public Cloth getMyCloth() {
		// TODO Auto-generated method stub
		return this.myCloth;
	}
	public void setMyImageIcon(ImageIcon p) {
		this.myImage = p;
	}
	public ImageIcon getMyImageIcon() {
		return this.myImage;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	public int getIndex() {
		return this.index;
	}
	//set x,y
    public void setXY(int x, int y) {
    	this.m_x = x;
    	this.m_y = y;
    }
    public int getX() { return this.m_x; }
    public int getY() { return this.m_y; }
    
    //set place
    public void setPlace(Place p) {
    	this.myLocation = p;
    }
    //get method
    public int getPower()
    {
        return this.power;
    }
    public int getStemina()
    {
        return this.stemina;
    }
    public String getMessage(int index) {
    	return this.speechList[index];
    }
    public int getDefense() {return this.defense;}
    public int getExp(){return this.exp;}
    public int getLevel(){return this.level;}
    public int getSatiety(){return this.satiety;}
    public int getFatigability(){return this.fatigability;}
    public int getDrappings(){return this.drappings;}
    public int getHappy(){return this.happiness;}
    public String getName(){return this.name;}
    public int getActiveCount(){return this.activeCount;}
    public String[] getSpeechList(){return this.speechList;}
    public Place getMyLocation(){return this.myLocation;}
    public int getPrice(){return this.price;}
    //public String getLocationName(){return this.locationName;}

    //set method
    public void setName(String name){this.name=name;}
    public void setLevel(int level){this.level=level;}  //new
    public void setExp(int exp){this.exp=exp;}   //new
    public void setPower(int power) {this.power=power;}
    public void setDefense(int defense){this.defense=defense;}
    public void setStemina(int stemina) {this.stemina=stemina;}
    public void setSpeechList(String speech, int index){this.speechList[index]=speech;}
    public void setPrice(int price){this.price=price;}


    @Override
    public String ridDrappings()
    {
        if(this.drappings!=0)
        {
            this.drappings = 0;
            this.myView.ridDrapping();
            System.out.println("Message : "+speechList[2]);
            return speechList[2];
        }
        else {
            System.out.println("Message : "+speechList[1]);
            return speechList[1];
        }
    }
    
    public void makeDrappings()
    {
        if(this.activeCount==2)  //debug   original -> 10;
        {
            this.activeCount = 0;
            this.drappings += 1;
            if(this.drappings > 5)
            	this.drappings = 5;
            else {
            	System.out.println("똥을 싸다" + this.myView.getClass());
            	this.myView.makeDrapping();
            }
            if(this.drappings==5)	//new
            	this.happiness-=40;
            System.out.println(this.name+" Message : make drapping....");
        //   this.getMyLocation().setVisible(true);
            this.getMyLocation().repaint();
        }
        
    }
    @Override
    public String feed()
    {
        if(letProtest()) {
            System.out.println("Can't play with pet. Check your message.");
            return speechList[7];
        } else
        {
            this.fatigability+=10;
            this.satiety-=20; //배고픔
            this.exp+=5;
            this.happiness+=10;
            this.statCheck();
            System.out.println(this.name+" Message : "+speechList[6]);
            this.checkEvent();
            return speechList[6] + "\n피로 +10, 만족+30, 행복+10, 경험+5";
        }
		
    }

    public void statCheck() {
    	if(this.fatigability < 0)
    		this.fatigability = 0;
    	else if(this.fatigability > 100)
    		this.fatigability = 0;
    	
    	if(this.satiety < 0)
    		this.satiety = 0;
    	else if(this.satiety > 100)
    		this.satiety = 100;
    	
    	if(this.happiness < 0)
    		this.happiness = 0;
    	else if(this.happiness > 100)
    		this.happiness = 100;
    	
    }
    
    @Override
    public String play()
    {
        if(letProtest()) {
            System.out.println(speechList[3]);
            return speechList[3];
    	}
        else
        {
            this.fatigability+=10;
            this.satiety-=30;
            this.exp+=5;
            this.happiness+=10;
            this.statCheck();
            System.out.println(this.name+" Message : "+speechList[4]);
            this.checkEvent();
            return speechList[4];
        }
    }

    public String talk(int num){ //1인사하기, 2다정하게, 3훈계하기
    	Random random = new Random();
    	int p = random.nextInt(10) % 2;
    	int indexNum = 0;
    	if(num == 1) {
    		switch(p) {
    		case 0:
    			indexNum = 11;
    			break;
    		case 1:
    			indexNum = 12;
    			break;
    		}
    	} else if(num == 2) {
    		switch(p) {
    		case 0:
    			indexNum = 13;
    			break;
    		case 1:
    			indexNum = 14;
    			break;
    		}
    	} else if(num == 3) {
    		switch(p) {
    		case 0:
    			indexNum = 15;
    			break;
    		case 1:
    			indexNum = 16;
    			break;
    		}
    	}
    	return this.speechList[indexNum];
    }

    public String sleep()
    {
        this.fatigability-=40;
        this.satiety-=10;
        this.exp+=5;
        this.statCheck();
        this.checkEvent();
        
        return speechList[8];
    }

    public void sleep(boolean isTired)
    {
        long sleepSecond=10000;  //10s

        this.fatigability-=40;
        this.satiety-=10;
        this.exp+=5;
        this.statCheck();
        this.checkEvent();

        System.out.println("Message : "+speechList[9]);
        try
        {
            Thread.sleep(sleepSecond);
        }
        catch(InterruptedException e)
        {

        }
    }

    public void dress(Cloth cloth)
    {
    	this.myCloth=cloth;
    	this.power+=cloth.getPower();
    	this.stemina+=cloth.getStemina();
    	this.defense+=cloth.getDefense();
    }

    public void undress()
    {
    	this.power-=myCloth.getPower();
    	this.stemina-=myCloth.getStemina();
    	this.defense-=myCloth.getDefense();
        this.myCloth=null;
    }

    public void levelUp()
    {
        this.exp=0;
        this.level+=1;
    }
      
    public boolean checkExp()
    {
        if(this.exp>=20&&this.level<5) {
            this.levelUp();
            return true;
        }
        else
        	return false;
    }

    public boolean letProtest()
    {
        if(this.drappings > 4)
        {
            System.out.println(this.name+" Message : "+speechList[3]);
            return true;
        }

        else
            return false;
    }
    // 1: 평상시, 2: 행복, 3: 피곤, 4: 배고픔, 5: 잠.
    public void checkEvent()
    {
        int max=0;

        this.activeCount++;
        this.makeDrappings();
        if(this.fatigability>=100) {
        	//this.getLabel().setIcon(icon);
        	this.sleep(true);
        }
        if(this.checkExp()==true){
        	this.myView.makeMessageBox(speechList[0]);
        }
        else if(this.fatigability>=80){
        	System.out.println("Message : "+speechList[19]);
        	this.myView.makeMessageBox(speechList[19]);
        }
        else if(this.satiety>=80){
            System.out.println("Message : "+speechList[18]);
            this.myView.makeMessageBox(speechList[18]);
        }
        else if(this.happiness>=80){
            System.out.println("Message : "+speechList[17]);
            this.myView.makeMessageBox(speechList[17]);
        }       
    }
    
    public void useItem(Food i)
    {
    	this.fatigability+=i.getFatigability();
    	this.happiness+=i.getHappiness();
    	this.satiety+=i.getSatiety();
    	
    	//this.myUser.useItem(i);
    }
    
    public void useItem(Potion i)
    {
    	if(this instanceof AdultCat || this instanceof AdultMonkey)
    	{
    		this.getLabel().transform_label();
    		//밑으로 전부다 null ex
    		this.getMyUser().getController().m.livingroomPage.getbtnPotion().setVisible(false);
    		this.getMyUser().getController().m.livingroomPage.getfoodItemInfo().repaint();
    		this.getMyUser().setPotion(null);
    	}
    	else
    	{
    		
    	}
    }

    //change
    public int snap(Animal target)
    {
        int damage=this.power;
        target.setStemina(target.getStemina()-damage);
        return damage;
    }
    public int tackle(Animal target)
    {
        int damage=this.power;
        target.setStemina(target.getStemina()-damage);
        return damage;
    }
    public void defence(int damage)
    {
        this.setStemina(this.getStemina()+damage);
    }

    public boolean escape()
    {
        System.out.println("Game Exit..");
        return true;
    }

    public void showDoing(){}

    public void move(int x, int y)
    {
        this.m_x=x;
        this.m_y=y;
    }
/*
    public void goLivingroom(){this.myLocation=new LivingroomPage(); this.locationName=myLocation.getName();}
    public void goBathroom(){this.myLocation=new BathroomPage(); this.locationName=myLocation.getName();}
    public void goYard(){this.myLocation=new BathroomPage(); this.locationName=myLocation.getName();}
    public void goShop(){this.myLocation=new ShopPage(); this.locationName=myLocation.getName();}
    */
    
    //new
    public String[] getPetStatList()	//delete 'int index' parameter
    {
    	String[] list=new String[8];
    	list[0]="행복도 : "+Integer.toString(this.happiness);
    	list[1]="피로도 : "+Integer.toString(this.fatigability);
    	list[2]="배고픔 : "+Integer.toString(this.satiety);
    	list[3]="Level : "+Integer.toString(this.level);
    	list[4]="Exp : "+Integer.toString(this.exp);
    	list[5]="Stemina : "+Integer.toString(this.stemina);
    	list[6]="Power : "+Integer.toString(this.power);
    	list[7]="Defense : "+Integer.toString(this.defense);
    	
    	return list;
    }
    
    public abstract void grow(User presentUser, int index);
    public void degrade(User presentUser, int index){
    }
    public void transform(User presentUser, int index) {
    	
    }
}
