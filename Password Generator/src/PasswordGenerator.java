//this class works as backends and will generate  the password
import java.util.Random;
public class PasswordGenerator
{
        //character pools
    //these string will hold thr character /numbers/symbol/ that we are going  to randomly pic to generate our password
    public static final String LOWERCASE_CHARACTERS="abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CHARCATERS="ABCDERFGHIJKLMNOPQRSTUVWXYZ";

    public static final String numbers="0123456789";

    public static final String symbol="~!@#$%^&*()_+{}[]<>,./";

    //the random class allows us to generate a random password
    private final Random random;
    //constructor
    public PasswordGenerator()
{
    random=new Random();
}

    //length-length of the password to be generated (taken from user)
    //includeUppercase and etc,... consider if the password shuold include uppercase lowercase etc.. (taken from user)
    public String generatePassword(int length,boolean includeUppercase,boolean includeLowerCase,boolean includeNumbers,boolean includeSpecialSymbols)
    {
        //we will use StringBuilder over string for better efficiency
        StringBuilder passwordBuilder=new StringBuilder();
        //Store  vaild character(toggle states)

        String validCharcater="";
        if(includeUppercase)validCharcater+=UPPERCASE_CHARCATERS;
        if(includeLowerCase)validCharcater+=LOWERCASE_CHARACTERS;
        if(includeNumbers)validCharcater+=numbers;
        if(includeSpecialSymbols)validCharcater+=symbol;

        //build password
        for (int i = 0; i < length; i++) {
            //generate a random index
            int randomIndex= random.nextInt(validCharcater.length());

            //get the char based on the random index
            char randomChar=validCharcater.charAt(randomIndex);

            //store char into password builder
            passwordBuilder.append(randomChar);

            //do this until we have reached the length that the user has provided to us
        }
        //return the result
        return  passwordBuilder.toString();

    }


}
