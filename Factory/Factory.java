/*
 * The idea of the factory design pattern is separate the object creation from the system 
 * that uses the object. The factory method is used to create the object.
 * 
 * This might be because object creation is dictated by a condition or a parameter.
 * 
 * To use a more advanced example, consider the Strategy design pattern in cipher algorithms.
 */

/*******************************************************************************/
/*                          STRATEGY -- IRRELEVANT                             */
/*******************************************************************************/
interface ICipher{
String cipher(String text);
}

class CaesarCipher implements ICipher{
    @Override
    public String cipher(String text){
        return "CaesarCipher: " + text;
    }
}

class VigenereCipher implements ICipher{
    @Override
    public String cipher(String text){
        return "VigenereCipher: " + text;
    }
}

class CipherContext{
    private ICipher cipher;

    public void setCipher(ICipher cipher){
        this.cipher = cipher;
    }

    public String cipher(String text){
        if(cipher == null){
            return "No cipher set";
        }
        return cipher.cipher(text);
    }
}

/*******************************************************************************/
/*                          FACTORY DESIGN PATTERN                             */
/*******************************************************************************/
class CipherFactory{
    public ICipher getCipher(String type){
        if(type.equals("Caesar")){
            return new CaesarCipher();
        }else if(type.equals("Vigenere")){
            return new VigenereCipher();
        }
        return null;
    }
}


public class Factory{
    public static void main(String[] args){
        CipherContext cipher = new CipherContext();

        cipher.setCipher(new CipherFactory().getCipher("Caesar"));
        System.out.println(cipher.cipher("Hello World"));

        cipher.setCipher(new CipherFactory().getCipher("Vigenere"));
        System.out.println(cipher.cipher("Hello World"));

        // You have isolated the selection of strategy in a factory class 

    }
}