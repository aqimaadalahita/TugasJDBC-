import java.util.Scanner;

public class Transaksi implements Login {
    String username = "aqima@gmail.com";
    String password = "semogaberkah";
    String captcha = "B8MwS2v";
    String inputUsername;
    String inputCaptcha;
    String inputPassword;

    //method login
    public void login(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("SELAMAT DATANG DI SUPER MARKET");
        System.out.println("======================================");
        System.out.println("LOG IN");

        System.out.print("Username : ");
        inputUsername = scanner.next();

        System.out.print("Password : ");
        inputPassword = scanner.next();

        while (!inputUsername.equals(username)) {
            System.out.println("LOGIN GAGAL\n");
            System.out.print("Username : ");
            inputUsername = scanner.next();

            System.out.print("Password : ");
            inputPassword = scanner.next();  
        }

        while(!inputPassword.equals(password)){
            System.out.println("LOGIN GAGAL\n");
            System.out.print("Username : ");
            inputUsername = scanner.next();

            System.out.print("Password : ");
            inputPassword = scanner.next();  
        }
        
        System.out.println("LOGIN BERHASIL\n");

        System.out.println("Kode captcha : " + captcha);
        System.out.print("Entry captcha : ");
        inputCaptcha = scanner.next();

        while(!inputCaptcha.equalsIgnoreCase(captcha)){
            System.out.println("GAGAL\n");
            System.out.print("Entry captcha : ");
            inputCaptcha = scanner.next();

            scanner.close();
        }

        System.out.println("BERHASIL");
        System.out.println("--------------------------------------\n\n");

    }
}

