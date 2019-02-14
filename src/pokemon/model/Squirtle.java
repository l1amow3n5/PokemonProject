package pokemon.model;

public class Squirtle extends Pokemon implements Water
{
	public Squirtle()
	{
		super(07, "Squirtle");
	}
	public Squirtle (String name)
	{
		super(07, name);
	}
	public Squirtle (int number, String name)
	{
		super(number, name);
	}
		
	public void waterBlast()
	{
		
	}
	
	public void bigWave()
	{
		
	}
	
	public int jet() 
	{
		return 123;
	}
}
