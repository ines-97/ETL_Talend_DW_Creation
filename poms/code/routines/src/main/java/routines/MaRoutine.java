package routines;

import routines.system.RandomUtils;
import java.text.SimpleDateFormat;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.regex.*;
/*
 * user specification: the function's comment should contain keys as follows: 1. write about the function's comment.but
 * it must be before the "{talendTypes}" key.
 * 
 * 2. {talendTypes} 's value must be talend Type, it is required . its value should be one of: String, char | Character,
 * long | Long, int | Integer, boolean | Boolean, byte | Byte, Date, double | Double, float | Float, Object, short |
 * Short
 * 
 * 3. {Category} define a category for the Function. it is required. its value is user-defined .
 * 
 * 4. {param} 's format is: {param} <type>[(<default value or closed list values>)] <name>[ : <comment>]
 * 
 * <type> 's value should be one of: string, int, list, double, object, boolean, long, char, date. <name>'s value is the
 * Function's parameter name. the {param} is optional. so if you the Function without the parameters. the {param} don't
 * added. you can have many parameters for the Function.
 * 
 * 5. {example} gives a example for the Function. it is optional.
 */
public class MaRoutine {

    /**
     * helloExample: not return value, only print "hello" + message.
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} User Defined
     * 
     * {param} string("world") input: The string need to be printed.
     * 
     * {example} helloExemple("world") # hello world !.
     */
    public static void helloExample(String message) {
        if (message == null) {
            message = "World"; //$NON-NLS-1$
        }
        System.out.println("Hello " + message + " !"); //$NON-NLS-1$ //$NON-NLS-2$
    }
    /**
     * {talendTypes} String
     * 
     * {Category} TalendDataGenerator
     * 
     * {example} getListPoste() # i-data.
     */
    public static String getListPoste() {
        String[] list = { "Ingénieur BI", "RH", "Comptable"}; 
        Integer random = 0 + ((Long) Math.round(RandomUtils.random() * (list.length - 1 - 0))).intValue();
        return list[random];
    }
    
    /**
     * Vérifier la validité du format d'une date
     * {param} {String date, String formatDate} 
     */
    public static boolean isValidDate (String date, String formatDate) {
    	SimpleDateFormat df = new SimpleDateFormat(formatDate);
    	df.setLenient(false);
    	try {
    		df.parse(date);
    	}catch (ParseException ex) {
    		return false;
    	}
    	return true;
    }

    /**
     * Vérifier la validité du format d'un mail
     * {param} {String email} 
     * 
     */
    public static boolean isEmailAdress (String email) {
    	 Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
         Matcher m = p.matcher(email.toUpperCase());
         return m.matches();
    }
    
    /**
     * Convertir une chaine de caractère en BigDecimal
     * {param} {String value}
     * 
     */
    public static BigDecimal parseBigDecimal (String value) {
    	if (value!=null && value.length()>0){
    		if (Mathematical.NUM(value.replace(",","").replace(".","").replace(" ",""))==1){
    		       return new BigDecimal(value.replace(",",".").replace(" ",""));
    			}
		}
		return null;
    }
}


