package ru.nemesh;

//import ru.nemesh.exception.NullnumException;
//import ru.nemesh.exception.ProbelException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

@WebServlet("/hello")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Scanner scanner = new Scanner(System.in);
        String input;
        String keyapi = "5ba4a553d3605f0f89a02b2e0cc0182300c8bab8";
        String result;
        boolean flag = true;

        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        //printWriter.write("Введите ИНН");
        printWriter.write("Enter INN");
        printWriter.close();

        JButton button = new JButton("Найти");
        ActionListener actionListener = new ToActionListener();
        button.addActionListener(actionListener);

        while (flag == true) {



            input = scanner.nextLine();

            try {
                input = Check.getProbel(input);

            } catch (ProbelException e) {
                System.out.println(e.getMessage());
                continue;
            }

            String[] mas = input.split("");  //  делим массив строку на части по символам для проверки количсетва введеных чисел (10) и наличия всех чисел, без симоволов
            try {
                input = Check.getHownum(input);
            } catch (NullnumException e) {
                System.out.println(e.getMessage());
                continue;
            }
            result = Senda.checkOrg(input, keyapi);
            String[] mas2 = result.split(",");
            System.out.println("Информация по организации:" + mas2);
        }
    }
}
