public class PhoneBook
{
	private static final int MAX_SIZE = 10;
	private Person [] entries;
	private int count;

	public PhoneBook()
	{
		this.entries = new Person[MAX_SIZE];
		this.count = 0;
	}

	public void insert(String name, String phoneNumber)
	{

		
			if(count<MAX_SIZE)
			{
				entries[count] = new Person(name, phoneNumber);
				count++;
			
			}	
	
		else
			{
				System.out.println("Phone book is full.");
			}
	}

	public String searchByName(String targetName)
	{
		for (int i=0; i<count; i++)
		{
			if(entries[i].getName().equals(targetName))
			{
				return entries[i].getPhone();
			}

		}

		return "Not found.";
	}

	public String searchByPhone(String targetPhone)
	{
		for (int i=0; i<count; i++)
		{
			if(entries[i].getPhone().equals(targetPhone))
			{
				return entries[i].getName();
			}

		}

		return "Not found";
	}

	private int search(String targetName)
	{
		for(int i=0; i<count; i++)
		{
			if(entries[i].getName().equals(targetName))
			{
				return i;
			}
		}

		return -1;
	}

	public void deleteEntry(String targetName)
	{
		int index = search(targetName);

		if(index != -1)
		{
			for(int i=index; i<count-1; i++)
			{
				entries[i] = entries[i+1];
			}
			entries[count-1] = null;
			count--;
		}
	}

	public String toString()
	{
		String desc = "";
		for(int i=0;i<count;i++)
		{
			desc += "\n" +entries[i].toString();
		}
		return desc;
	}
}