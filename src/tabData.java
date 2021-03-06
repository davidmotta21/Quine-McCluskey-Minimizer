/* Structure for holding data related to the tabular method
 * of QM minimizing
 */

public class tabData 
{
	//Variables
	public static int inputs;
	public static int decValue;
	public static int binValue[];
	public static int groupID;
	
	//tabData Constructor
	public tabData()
	{
		inputs = 0;
		decValue = 0;
		groupID = 0;
		binValue = new int[0];
	}
	
	public tabData(int numIn, int dec)
	{
		inputs = numIn;
		decValue = dec;
		
		//Call binary conversion method to calculate binValue and store it
		binValue = new int[numIn];
		binConv();
		
		groupID = setGroupID();
	}
	
	//tabData methods
	private static void binConv()
	{
		int temp = decValue;
		int count = inputs;
		
		while(temp > 0)
		{
			binValue[count-1] = temp % 2;
			temp = temp / 2;
			count--;
		}
		for(int i = 0; i < inputs; i++)
		{
			System.out.print(binValue[i]);
		}
	}
	
	private static int setGroupID()
	{
		int count = 0;
		for(int i = 0; i < inputs; i++)
		{
			if(binValue[i] == 1)
			{
				count++;
			}
		}
		System.out.println("Group ID set to: " + count);
		return count;
	}
	
	
}