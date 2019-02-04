package pokemon.view;

import javax.swing.*;
import pokemon.controller.PokedexController;
import java.awt.event.*;
import java.awt.*;

public class PokedexPanel extends JPanel
{
	private PokedexController app; 
	private SpringLayout appLayout;
	
	private JTextField PikachuText;
	private JTextField CharizardText; 
	private JTextField BulbasaurText; 
	private JTextField SquirtleText; 
	private JTextField JigglypuffText;
	
	private JLabel PikachuLabel;
	private JLabel CharizardLabel;
	private JLabel BulbasaurLabel;
	private JLabel SquirtleLabel;
	private JLabel JigglypuffLabel;
	
	public PokedexPanel(PokedexController app)
	{
		super();
		
		this.app = app;
		PikachuText = new JTextField("Pik");
		CharizardText = new JTextField("Char");
		BulbasaurText = new JTextField("Bulb");
		SquirtleText = new JTextField("Squi");
		JigglypuffText = new JTextField("Jiggy");
		
		PikachuLabel = new JLabel("Pikachu");
		CharizardLabel = new JLabel("Charizard");
		BulbasaurLabel = new JLabel("Bulbasaur");
		SquirtleLabel = new JLabel("Squirtle");
		JigglypuffLabel = new JLabel("Jigglypuff");
		
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(800, 600));
		this.setBackground(Color.RED);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}
}
