package pokemon.model;

public class Pikachu extends Pokemon implements Electric
{
	public Pikachu (int number, String name)
	{
		super(number, name);
	}
	
	public void stun()
	{
		System.out.println("He is unable to move");
	}
	
	public int shock()
	{
		return 123445; 
	}
	
	public void storm()
	{
		
	}
}
