package pokemon.model;

public class Bulbasaur extends Pokemon implements Grass
{
	public Bulbasaur()
	{
		super(01, "Bulbasaur");
	}
	public Bulbasaur(String name)
	{
		super(01, name);
	}
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
