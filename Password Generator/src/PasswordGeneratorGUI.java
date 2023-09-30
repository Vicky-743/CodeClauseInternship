import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//render the GUI Components(Frontend)
//this class will inherit from the JFrame class

public class PasswordGeneratorGUI extends JFrame {
    private PasswordGenerator passwordGenerator;
    public PasswordGeneratorGUI()
    {
        // render frame and add a title
        super("Password Generator");

        //set the size of GUI
        setSize(540,570);

        //prevent GUI from being able to resized
        setResizable(false);

        //we will set the layout to be null to prove control over the position and size of our component in our app
        setLayout(null);
        //terminate the program when the GUI is closed (ends the process )
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ////center the GUI to the screen
        setLocationRelativeTo(null);

        //init password generator
        passwordGenerator =new PasswordGenerator();

        //render GUI components
        addGuiComponents();
    }
    private void addGuiComponents()
    {
        //create title text
        JLabel titleLabel=new JLabel("Password Generator");

        //increase the font size and make it bold
        titleLabel.setFont(new Font("Dialog",Font.BOLD,32));

        //center the text to the screen
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //set x,y cordinates and width/height values
        titleLabel.setBounds(0,10,540,39);

        //add to GUI
        add(titleLabel);

        //create  result Text area
        JTextArea passwordOutput=new JTextArea();

        //prevent the editing the text area
        passwordOutput.setEditable(false);

        passwordOutput.setFont(new Font("Dialog",Font.BOLD,32));

        //add scrolability in the case of output becomes too big

        JScrollPane passwordOutputPane=new JScrollPane(passwordOutput);
        passwordOutputPane.setBounds(25,97,479,70);

        //create a black color border arounds the text area
        passwordOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        add(passwordOutputPane);

        //create a password length label
        JLabel passwordLengthLabel=new JLabel("Password Length");
        passwordLengthLabel.setFont(new Font("Dialog",Font.PLAIN,32));

        passwordLengthLabel.setBounds(25,215,272,39);
        add(passwordLengthLabel);

        //create pasword leght input
        JTextArea passwordLength=new JTextArea("");
        passwordLength.setFont(new Font("Dialog",Font.PLAIN,32));
        passwordLength.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        passwordLength.setBounds(310,215,192,39);
        add(passwordLength);


        //create a toggle button
        //uppercase letter toggle
        JToggleButton uppercaseToggle=new JToggleButton("Uppercase");
        uppercaseToggle.setFont(new Font("Dialog",Font.PLAIN,26));
        uppercaseToggle.setBounds(25,302,225,56);
        add(uppercaseToggle);

        //Lowecase letter Toggle
        JToggleButton lowercaseToggle=new JToggleButton("Lowercase");
        lowercaseToggle.setFont(new Font("Dialog",Font.PLAIN,26));
        lowercaseToggle.setBounds(282,302,225,56);
        add(lowercaseToggle);

        //numbers Toggle
        JToggleButton numbersToogle=new JToggleButton("Numbers");
        numbersToogle.setFont(new Font("Dialog",Font.PLAIN,26));
        numbersToogle.setBounds(25,373,225,56);
        add(numbersToogle);

        //symbols toggle
        JToggleButton symbolToggle=new JToggleButton("Symbol");
       symbolToggle.setFont(new Font("Dialog",Font.PLAIN,26));
        symbolToggle.setBounds(282,373,225,56);
        add(symbolToggle);

        //create generator button
        JButton genrateButton=new JButton("Generate");
        genrateButton.setFont(new Font("Dialog",Font.PLAIN,32));
        genrateButton.setBounds(155,477,222,41);
        genrateButton.addActionListener(new ActionListener() {
        public void actionPerformed (ActionEvent e)
        {
            //validation :generate a password only whein length >0 and one of the toggle button is pressed
            if(passwordLength.getText().length()<=8)
            {
                boolean anyToggleSelected=lowercaseToggle.isSelected() ||
                uppercaseToggle.isSelected()|| numbersToogle.isSelected()||
                symbolToggle.isSelected();

                //generate password
                //converts the text to an intger value
                int passwordLen=Integer.parseInt(passwordLength.getText());
                if(anyToggleSelected)
                {
                    String generatedPassword=passwordGenerator.generatePassword(passwordLen,uppercaseToggle.isSelected(),
                            lowercaseToggle.isSelected(),
                            numbersToogle.isSelected(),
                            symbolToggle.isSelected());
                    //display password back to the user
                    passwordOutput.setText(generatedPassword);
                }
            }
        }
    });

        add(genrateButton);


    }

}
