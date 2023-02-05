import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{
        System.out.println("Введите ИНН");
        Scanner scanner = new Scanner(System.in);
        String input;
        String keyapi = "5ba4a553d3605f0f89a02b2e0cc0182300c8bab8";
        String result;

        /**
         * уверен что этот блок нужен?
         * очень похоже на gui интерфейс
         * а у тебя тут все через командную строку
         * соответственно и класс ToActionListener не нужен
         */
        JButton button = new JButton("Найти");
        ActionListener actionListener = new ToActionListener();
        button.addActionListener(actionListener);

        input = scanner.nextLine();

//        try {
//        input = String.valueOf(Check.getNum(input));
////        } catch (NumException e) {
////            System.out.println(e.getMessage());
//        }

        try {
            input = Check.getProbel(input);

        } catch (ProbelException e) {
            System.out.println(e.getMessage());
            //   continue;
        }

        String[] mas = input.split("");  //  делим массив строку на части по символам для проверки количсетва введеных чисел (10) и наличия всех чисел, без симоволов
        try {
            input = Check.getHownum(input);
        } catch (NullnumException e) {
            System.out.println(e.getMessage());
            //  continue;    
        }
        result = Senda.checkOrg(input,keyapi);
        System.out.println("Информация по организации:" + result);
    }
}