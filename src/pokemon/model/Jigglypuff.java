package pokemon.model;

public class Jigglypuff extends Pokemon implements Fairy
{
	public Jigglypuff()
	{
		super(39, "Jigglypuff");
	}
	public Jigglypuff(String name)
	{
		super(39, name);
	}
	public Jigglypuff (int number, String name)
	{
		super(number, name);
	}
	
	public String taunt()
	{
		return "hello";
	}
	
	public void tackle()
	{
		
	}
	
	public String tickle()
	{
		return "hello";
	}
}
