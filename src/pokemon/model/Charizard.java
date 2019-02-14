package pokemon.model;

public class Charizard extends Pokemon implements Fire
{
	public Charizard()
	{
		super(06, "Charizard");
	}
	public Charizard (String name)
	{
		super(06, name);
	}
	public Charizard (int number, String name)
	{
		super(number, name);
	}
	
	public void burn()
	{
		
	}
	
	public void fireball() 
	{
		
	}
	
	public int torch() 
	{
		return 213;
	}
	
}
