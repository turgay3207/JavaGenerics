package enumTypes;

import static enumTypes.PasswordStrengthConstant.*;
import static enumTypes.PasswordStrengthConstant.HIGH;

public class Runner {
    public static void main(String[] args) {


        useConstant("LOW");
        useConstant("MEDIUM");
        useConstant("HIGH");
        useConstant("BASIC");

        //--------ENUM__________

        useEnum(PasswordStrengthEnum.HIGH);
        useEnum(PasswordStrengthEnum.LOW);
        useEnum(PasswordStrengthEnum.MEDIUM);

        //Sadece sınırlıdegerler olan enumları kullanmaya zorluyor...



    }
    public static void useConstant(String strength){

        switch (strength){
            case LOW:
                System.out.println("Password gucunuz dusuktur!!!");
                break;
            case MEDIUM:
                System.out.println("Password gucunuz orta seviyededir!!!!");
                break;
            case HIGH:
                System.out.println("Password gucunuz YUKSEK seviyededir!!!!!");
                break;
            default:
                System.out.println("Herhangi bir zorluk derecesi secmediniz!!! & Zorluk derecesini buyuk harfle giriniz");
                break;
        }
    }
    public static void useEnum(PasswordStrengthEnum strength){
        switch (strength){

            case LOW:
                System.out.println("Password gucunuz dusuktur!!!");
                System.out.println("Seviye "+strength.getLevel());
                break;
            case MEDIUM:
                System.out.println("Password gucunuz orta seviyededir!!!!");
                break;
            case HIGH:
                System.out.println("Password gucunuz YUKSEK seviyededir!!!!!");
                break;
        }
    }
}
