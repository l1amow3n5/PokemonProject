package pokemon.model;

public class Bulbasaur extends Pokemon implements Grass
{
	public Bulbasaur (int number, String name)
	{
		super(number, name);
	}
	
	public int cut()
	{
		return 123;
	}
	
	public void slash()
	{
		
	}
	
	public int whip()
	{
		return 123;
	}
}
