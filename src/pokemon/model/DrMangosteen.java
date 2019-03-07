package pokemon.model;

public class DrMangosteen extends Pokemon implements Grass
{
	public DrMangosteen()
	{
		super(808, "DrMangosteen");
	}
	public DrMangosteen(String name)
	{
		super(808, name);
	}
	public DrMangosteen (int number, String name)
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
	public int mangoBurst()
	{
		return 999 * 12345670;
	}
}
