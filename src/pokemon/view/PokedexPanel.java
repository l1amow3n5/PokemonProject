package pokemon.view;

import javax.swing.*;
import pokemon.controller.PokedexController;
import java.awt.event.*;
import java.awt.*;

public class PokedexPanel extends JPanel
{
	private PokedexController app; 
	private SpringLayout appLayout;
	
	private JComboBox<String> pokedexDropdown;
	
	private JButton changeButton;
	
	private JTextField numberField;
	private JTextField nameField; 
	private JTextField evolveField; 
	private JTextField attackField; 
	private JTextField enhanceField;
	private JTextField healthField;
	
	private JLabel numberLabel;
	private JLabel nameLabel;
	private JLabel healthLabel;
	private JLabel imageLabel;
	private JLabel evolveLabel;
	private JLabel enhanceLabel;
	private JLabel attackLabel;
	
	private ImageIcon pokemonIcon;
	
	public PokedexPanel(PokedexController app)
	{
		super();
		
		this.app = app;
		
		this.pokemonIcon = new ImageIcon(getClass().getResource("/pokemon/view/images/bulbasaur.jpeg"));
		
		numberField = new JTextField("00");
		nameField = new JTextField("Name");
		evolveField = new JTextField("false");
		attackField = new JTextField("0");
		enhanceField = new JTextField("0");
		healthField = new JTextField("0");
		
		imageLabel = new JLabel("Pokemon goes here", pokemonIcon, JLabel.CENTER);
		nameLabel = new JLabel("What is your pokemons name");
		healthLabel = new JLabel("How much health does your pokemon have");
		numberLabel = new JLabel("What number is your pokemon");
		evolveLabel = new JLabel("Does your pokemon evolve");
		enhanceLabel = new JLabel("Can you enhance your pokemon");
		attackLabel = new JLabel("My attack is");
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(800, 600));
		this.setBackground(Color.WHITE);
		
		this.add(numberField);
		this.add(nameField);
		this.add(evolveField);
		this.add(attackField);
		this.add(enhanceField);
		this.add(healthField);
		
		this.add(changeButton);
		this.add(pokedexDropdown);
		
		this.add(imageLabel);
		this.add(nameLabel);
		this.add(healthLabel);
		this.add(numberLabel);
		this.add(evolveLabel);
		this.add(enhanceLabel);
		this.add(attackLabel);
		
		imageLabel.setVerticalTextPosition(JLabel.BOTTOM);
		imageLabel.setHorizontalTextPosition(JLabel.CENTER);
	}
	
	private void setupLayout()
	{
		
	}

	private void sendDataToController()
	{
		int index = pokedexDropdown.getSelectedIndex();
		
		if(app.isInt(attackField.getText()) && app.isDouble(enhanceField.getText()) && app.isInt(healthField.getText()))
		{
			String [] data = new String[5];
			
			app.updatePokemon(index, data);
		}
	}
	
	private void changeImageDisplay(String name)
	{
		String path = "/pokemon/view/images/";
		String defaultName = "arc";
		String extension = ".jpeg";
		
		try 
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + name.toLowerCase() + extension));
		}
		catch (NullPointerException missingFile)
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		imageLabel.setIcon(pokemonIcon);
		repaint();
	}
	
	private void setupListeners()
	{
		changeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				sendDataToController();
			}
		});
		pokedexDropdown.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent selection)
			{
				String name = pokedexDropdown.getSelectedItem().toString();
				changeImageDisplay(name);
			}
		});
	}
}
