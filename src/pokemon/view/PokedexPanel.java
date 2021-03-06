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
		
		this.pokemonIcon = new ImageIcon(getClass().getResource("/pokemon/view/images/Pokeball.jpeg"));
		this.appLayout = new SpringLayout();
		changeButton = new JButton("Click here to change the pokevalues");	
		saveButton = new JButton("save the pokedex");
				
		pokedexDropdown = new JComboBox<String>();
				
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
		this.setBackground(Color.CYAN);
		
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
		appLayout.putConstraint(SpringLayout.WEST, imageLabel, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, changeButton, 10, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, imageLabel, 101, SpringLayout.SOUTH, changeButton);
		appLayout.putConstraint(SpringLayout.WEST, changeButton, 0, SpringLayout.WEST, imageLabel);
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 412, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, pokedexDropdown, 6, SpringLayout.SOUTH, changeButton);
		appLayout.putConstraint(SpringLayout.WEST, pokedexDropdown, 20, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, nameField, -5, SpringLayout.NORTH, nameLabel);
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 36, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, nameLabel, 97, SpringLayout.EAST, changeButton);
		appLayout.putConstraint(SpringLayout.SOUTH, pokedexDropdown, -505, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, pokedexDropdown, -10, SpringLayout.EAST, changeButton);
		appLayout.putConstraint(SpringLayout.NORTH, healthField, -5, SpringLayout.NORTH, healthLabel);
		appLayout.putConstraint(SpringLayout.WEST, healthLabel, 71, SpringLayout.EAST, imageLabel);
		appLayout.putConstraint(SpringLayout.NORTH, numberLabel, 94, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, numberField, -5, SpringLayout.NORTH, numberLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, nameLabel, -42, SpringLayout.NORTH, numberLabel);
		appLayout.putConstraint(SpringLayout.WEST, numberLabel, 0, SpringLayout.WEST, nameLabel);
		appLayout.putConstraint(SpringLayout.NORTH, evolveLabel, 35, SpringLayout.SOUTH, numberLabel);
		appLayout.putConstraint(SpringLayout.NORTH, evolveField, -5, SpringLayout.NORTH, evolveLabel);
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, 43, SpringLayout.SOUTH, evolveLabel);
		appLayout.putConstraint(SpringLayout.WEST, evolveLabel, 0, SpringLayout.WEST, nameLabel);
		appLayout.putConstraint(SpringLayout.NORTH, enhanceField, -5, SpringLayout.NORTH, enhanceLabel);
		appLayout.putConstraint(SpringLayout.WEST, enhanceField, 73, SpringLayout.EAST, enhanceLabel);
		appLayout.putConstraint(SpringLayout.EAST, enhanceField, 219, SpringLayout.EAST, enhanceLabel);
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 148, SpringLayout.SOUTH, enhanceLabel);
		appLayout.putConstraint(SpringLayout.WEST, enhanceLabel, 0, SpringLayout.WEST, healthLabel);
		appLayout.putConstraint(SpringLayout.NORTH, attackLabel, 44, SpringLayout.SOUTH, healthLabel);
		appLayout.putConstraint(SpringLayout.NORTH, attackField, -5, SpringLayout.NORTH, attackLabel);
		appLayout.putConstraint(SpringLayout.NORTH, enhanceLabel, 33, SpringLayout.SOUTH, attackLabel);
		appLayout.putConstraint(SpringLayout.WEST, attackLabel, 0, SpringLayout.WEST, nameLabel);
		appLayout.putConstraint(SpringLayout.WEST, nameField, 0, SpringLayout.WEST, numberField);
		appLayout.putConstraint(SpringLayout.EAST, nameField, 0, SpringLayout.EAST, numberField);
		appLayout.putConstraint(SpringLayout.WEST, numberField, 0, SpringLayout.WEST, evolveField);
		appLayout.putConstraint(SpringLayout.EAST, numberField, 0, SpringLayout.EAST, evolveField);
		appLayout.putConstraint(SpringLayout.WEST, evolveField, 0, SpringLayout.WEST, attackField);
		appLayout.putConstraint(SpringLayout.EAST, evolveField, 0, SpringLayout.EAST, attackField);
		appLayout.putConstraint(SpringLayout.WEST, attackField, 0, SpringLayout.WEST, enhanceField);
		appLayout.putConstraint(SpringLayout.EAST, attackField, 0, SpringLayout.EAST, enhanceField);
		appLayout.putConstraint(SpringLayout.WEST, healthField, 0, SpringLayout.WEST, attackField);
		appLayout.putConstraint(SpringLayout.EAST, healthField, 0, SpringLayout.EAST, attackField);

	}
	
	private void sendDataToController()
	{
		int index = pokedexDropdown.getSelectedIndex();
		
		if(app.isInt(attackField.getText()) && app.isDouble(enhanceField.getText()) && app.isInt(healthField.getText()))
		{
			String [] data = new String[5];
			data[0] = attackField.getText();
			data[1] = enhanceField.getText();
			data[2] = healthField.getText();
			data[3] = nameField.getText();
			data[4] = evolveField.getText();
			
			app.updatePokemon(index, data);
		}
	}
	
	private void changeImageDisplay(String name)
	{
		String path = "/pokemon/view/images/";
		String defaultName = "Pokeball";
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
	
	private void updateFields(int index)
	{
		String [] data = app.getPokeData(index);
		
		attackField.setText(data[0]);
		enhanceField.setText(data[1]);;
		healthField.setText(data[2]);
		nameField.setText(data[3]);
		evolveField.setText(data[4]);
		numberField.setText(data[5]);
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
				updateFields(pokedexDropdown.getSelectedIndex());
			}
		});
	}
}
