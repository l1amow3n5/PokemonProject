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
	private JButton saveButton;
	
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
		this.appLayout = new SpringLayout();
		changeButton = new JButton("Click here to change the pokevalues");
		saveButton = new JButton("save the pokedex");
		
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
		enhanceLabel = new JLabel("Your pokemon enhance level is: ");		
		attackLabel = new JLabel("My attack is");
		
		
		setupDropdown();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupDropdown()
	{
		DefaultComboBoxModel<String> temp = new DefaultComboBoxModel<String>(app.buildPokedexText());
		pokedexDropdown.setModel(temp);
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
		this.add(saveButton);
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
		appLayout.putConstraint(SpringLayout.NORTH, evolveField, 263, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, evolveField, -296, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, attackField, -250, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, attackField, -380, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, enhanceField, 339, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, enhanceField, -144, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, healthField, 118, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, healthField, 195, SpringLayout.EAST, imageLabel);
		appLayout.putConstraint(SpringLayout.WEST, imageLabel, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, imageLabel, -121, SpringLayout.NORTH, evolveLabel);
		appLayout.putConstraint(SpringLayout.WEST, enhanceLabel, 91, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, enhanceLabel, -10, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, attackLabel, 0, SpringLayout.NORTH, enhanceLabel);
		appLayout.putConstraint(SpringLayout.EAST, attackLabel, -211, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, numberLabel, 42, SpringLayout.SOUTH, nameLabel);
		appLayout.putConstraint(SpringLayout.NORTH, numberField, -5, SpringLayout.NORTH, numberLabel);
		appLayout.putConstraint(SpringLayout.WEST, numberLabel, 0, SpringLayout.WEST, nameLabel);
		appLayout.putConstraint(SpringLayout.NORTH, evolveLabel, 42, SpringLayout.SOUTH, enhanceField);
		appLayout.putConstraint(SpringLayout.EAST, evolveLabel, -455, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.EAST, nameField, -84, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, numberField, 0, SpringLayout.WEST, nameField);
		appLayout.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, healthLabel);
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, 5, SpringLayout.NORTH, enhanceField);
		appLayout.putConstraint(SpringLayout.EAST, healthLabel, -57, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, nameField, -5, SpringLayout.NORTH, nameLabel);
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 36, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, nameLabel, -211, SpringLayout.NORTH, evolveField);
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
		String defaultName = "bulbasaur";
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
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				app.savePokedex();
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
