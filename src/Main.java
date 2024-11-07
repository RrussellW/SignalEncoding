import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
        System.out.println("│ Exercise 9: Digital Signal Encoding Techniques Visualizer │");
        System.out.println("└───────────────────────────────────────────────────────────┘");


        String input = "";
        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String YELLOW = "\u001B[33m";

        while(true) {
            System.out.println();
            System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓" );
            System.out.println("│ Enter digital signal (e.g. 10100) │");
            System.out.println("│ Type "+ YELLOW + "Done "+ RESET+ "to finish               │" );
            System.out.println("└───────────────────────────────────┘" );
            input = scan.next();

            if(input.equals("Done")) {
                System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
                System.out.println("│ Brought to you by: https://github.com/RrussellW           │");
                System.out.println("└───────────────────────────────────────────────────────────┘");
                return;
            }

            if (!(input.matches("[01]+"))) {
                System.out.println("Input should " + RED + "only be" + RESET + " ones zeroes.");
            } else {
                System.out.println(YELLOW + "▓▓▓▓▓▓▓▓▓▓▓" + RESET);
                System.out.println(YELLOW + "│ " + RESET + "NRZ - L" + YELLOW + " │" + RESET);
                System.out.println(YELLOW + "└─────────┘" + RESET);
                printInput(input);
                Digit[] nrzL = createLink(input);               //create Linked         (NRZL)
                artNRZL(nrzL, input);                            //create ASCII art      (NRZL)
                printInputBottom(input);

                System.out.println(YELLOW + "▓▓▓▓▓▓▓▓▓▓▓" + RESET);
                System.out.println(YELLOW + "│ " + RESET + "NRZ - I" + YELLOW + " │" + RESET);
                System.out.println(YELLOW + "└─────────┘" + RESET);
                printInput(input);
                String inputNRZI = convertNRZI(nrzL, input);    //convert new input     (NRZI)
                Digit[] nrzI = createLink(inputNRZI);           //create new Linked     (NRZI)
                artNRZL(nrzI, inputNRZI);                        //create ASCII art      (NRZI)
                printInputBottom(input);


                System.out.println(YELLOW + "▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓" + RESET);
                System.out.println(YELLOW + "│ " + RESET + "Bipolar - AMI" + YELLOW + " │" + RESET);
                System.out.println(YELLOW + "└───────────────┘" + RESET);
                printInput(input);
                String inputAMI = convertAMI(nrzL, input);    //convert new input     (AMI)
                Digit[] bAMI = createLink(inputAMI);           //create new Linked     (AMI)
                artNRZL(bAMI, inputAMI);                        //create ASCII art      (AMI)
                printInputBottom(input);


                System.out.println(YELLOW + "▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓" + RESET);
                System.out.println(YELLOW + "│ " + RESET + "Pseudoternary" + YELLOW + " │" + RESET);
                System.out.println(YELLOW + "└───────────────┘" + RESET);
                printInput(input);
                String inputPseudo = convertPseudo(nrzL, input);    //convert new input     (Pseudo)
                Digit[] pTern = createLink(inputPseudo);           //create new Linked     (Pseudo)
                artNRZL(pTern, inputPseudo);                        //create ASCII art      (Pseudo)
                printInputBottom(input);

                System.out.println(YELLOW + "▓▓▓▓▓▓▓▓▓▓▓▓▓▓" + RESET);
                System.out.println(YELLOW + "│ " + RESET + "Manchester" + YELLOW + " │" + RESET);
                System.out.println(YELLOW + "└────────────┘" + RESET);
                printInput(input);
                artMC(nrzL, input);                            //create ASCII art      (Manchester)
                printInputBottom(input);

                System.out.println(YELLOW + "▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓" + RESET);
                System.out.println(YELLOW + "│ " + RESET + "Differential Manchester" + YELLOW + " │" + RESET);
                System.out.println(YELLOW + "└─────────────────────────┘" + RESET);
                printInput(input);
                String diffInput = convertDiff(nrzL, input);
                Digit[] diff = createLink(diffInput);             //create Linked         (Differential)
                artMC(diff, diffInput);                            //create ASCII art      (Differential)
                printInputBottom(input);

                System.out.println();
                System.out.println("When encountering bugs, errors, crashes and freezes, goodluck");
            }
        }
    }

    public static void printInput(String input) {
        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String YELLOW = "\u001B[33m";

        for(int i = 0; i < input.length(); i++) {
            System.out.print(YELLOW +"▓▓▓▓▓▓▓" + RESET);
        }
        System.out.println();
        for(int i = 0; i < input.length(); i++) {
            System.out.print(YELLOW +"│   " + RED + input.charAt(i) + YELLOW + "  " + RESET);
        }
        System.out.println();
        for(int i = 0; i < input.length(); i++) {
            System.out.print(YELLOW +"┼──────" + RESET);
        }
        System.out.println();
    }

    public static void printInputBottom(String input) {
        String RESET = "\u001B[0m";
        String YELLOW = "\u001B[33m";
        for(int i = 0; i < input.length(); i++) {
            if(i==0) {
                if(i+1 == input.length()){
                    System.out.print(YELLOW +"└─────┘" + RESET);
                } else {
                    System.out.print(YELLOW +"└──────" + RESET);
                }
            } else {
                System.out.print(YELLOW +"┴──────" + RESET);
            }
        }
        System.out.println();
    }

    public static Digit[] createLink(String n) {
        Digit[] line = new Digit[n.length()];
        for(int i = 0; i < n.length(); i++){
                char start;
                char current = n.charAt(i);
                char end;

                if(i==0){
                    start = 's';
                } else {
                    start = n.charAt(i-1);
                }
                if(i+1==(n.length())){
                    end = 'e';
                } else {
                    end = n.charAt(i+1);
                }

                line[i] = new Digit(current, start, end);
        }
        return line;
    }

    public static void artNRZL(Digit[] input,String n){

        String RESET = "\u001B[0m";
        String YELLOW = "\u001B[33m";

        String top00 = YELLOW + "│" + RESET + "      ";
        String top01 = "╔══════";
        String top10 = "╗      ";
        String top11 = "═══════";

        String bot00 = "═══════";
        String bot01 = "╝      ";
        String bot10 = "╚══════";
        String bot11 = YELLOW + "│" + RESET + "      ";

        String mid20 = "╗      ";
        String bot20 = "╚══════";
        String mid02 = "╔══════";
        String bot02 = "╝      ";
        String top12 = "╗      ";
        String mid12 = "╚══════";

        String bodyEC = "║      ";
        String bodyCC = YELLOW + "│" + RESET + "      ";

        String[][] art = new String[6][n.length()];


        for(int i = 0; i < n.length(); i++) {

            if(n.charAt(i) == '1'){
                if(input[i].before == '1'){   //before 1 curr 1
                    art[0][i] = top11;
                    art[1][i] = bodyCC;
                    art[2][i] = bot11;
                } else if(input[i].before == '0' || input[i].before == 's'){//before 0 curr 1
                    art[0][i] = top01;
                    art[1][i] = bodyEC;
                    art[2][i] = bot01;
                } else {                    //before 2 curr 1
                    art[0][i] = top01;
                    art[1][i] = bot01;
                    art[2][i] = bodyCC;
                }

            } else if (n.charAt(i) == '0'){
                if(input[i].before == '1'){   //before 1 curr 0
                    art[0][i] = top10;
                    art[1][i] = bodyEC;
                    art[2][i] = bot10;
                } else if (input[i].before == '0' || input[i].before == 's'){//before 0 curr 0
                    art[0][i] = top00;
                    art[1][i] = bodyCC;
                    art[2][i] = bot00;
                } else {                     //before 2 curr 0
                    art[0][i] = top00;
                    art[1][i] = mid20;
                    art[2][i] = bot20;
                }
            } else {
                if(input[i].before == '1'){  //before 1 curr 2
                    art[0][i] = top12;
                    art[1][i] = mid12;
                    art[2][i] = bodyCC;
                } else if(input[i].before == '0' || input[i].before == 's'){//before 0 curr 2
                    art[0][i] = bodyCC;
                    art[1][i] = mid02;
                    art[2][i] = bot02;
                } else {                    //before 2 curr 2
                    art[0][i] = bodyCC;
                    art[1][i] = bot00;
                    art[2][i] = bodyCC;
                }

            }
        }

        for(int j = 0; j < 3; j++) {
            for(int k = 0; k < n.length(); k++) {
                System.out.print(art[j][k]);
            }
            System.out.println();
        }

    }


    public static String convertNRZI(Digit[] input,String n) {
        String conversion;
        int flag;

        if(n.charAt(0)=='1'){
            conversion = "1";
            flag = 1;
        } else {
            conversion = "0";
            flag = 0;
        }

        if(n.length() > 1) {
            for (int i = 1; i < n.length(); i++) {
                if (input[i].digit == '1') {
                    if(flag == 1){
                        flag = 0;
                        conversion = conversion + "0";
                    } else {
                        flag = 1;
                        conversion = conversion + "1";
                    }
                } else {
                    conversion = conversion + flag;
                }
            }
        }

        return conversion;
    }

    public static String convertAMI(Digit[] input,String n) {
        String conversion;
        int flag;

        if(n.charAt(0)=='1'){
            conversion = "1";
            flag = 1;
        } else {
            conversion = "2";
            flag = 0;
        }

        if(n.length() > 1) {
            for (int i = 1; i < n.length(); i++) {
                if (input[i].digit == '1') {
                    if(flag == 1){
                        flag = 0;
                        conversion = conversion + "0";
                    } else {
                        flag = 1;
                        conversion = conversion + "1";
                    }
                } else {
                    conversion = conversion + "2";
                }
            }
        }

        return conversion;
    }

    public static String convertPseudo(Digit[] input,String n) {
        String conversion;
        int flag;

        if(n.charAt(0)=='0'){
            conversion = "1";
            flag = 1;
        } else {
            conversion = "2";
            flag = 0;
        }

        if(n.length() > 1) {
            for (int i = 1; i < n.length(); i++) {
                if (input[i].digit == '0') {
                    if(flag == 1){
                        flag = 0;
                        conversion = conversion + "0";
                    } else {
                        flag = 1;
                        conversion = conversion + "1";
                    }
                } else {
                    conversion = conversion + "2";
                }
            }
        }

        return conversion;
    }

    public static void artMC(Digit[] input,String n){

        String RESET = "\u001B[0m";
        String YELLOW = "\u001B[33m";

        String top01 = "═══╗   ";
        String mid01 = YELLOW + "│" + RESET + "  ║   ";
        String bot01 = YELLOW + "│" + RESET + "  ╚═══";

        String top00 = "╔══╗   ";
        String mid00 = "║  ║   ";
        String bot00 = "╝  ╚═══";

        String top11 = "╗  ╔═══";
        String mid11 = "║  ║   ";
        String bot11 = "╚══╝   ";

        String top10 = YELLOW + "│" + RESET + "  ╔═══";
        String mid10 = YELLOW + "│" + RESET + "  ║   ";
        String bot10 = "═══╝   ";

        String[][] art = new String[6][n.length()];


        for(int i = 0; i < n.length(); i++) {

            if(n.charAt(i) == '1'){
                if(input[i].before == '1'){   //curr 1 after 1
                    art[0][i] = top11;
                    art[1][i] = mid11;
                    art[2][i] = bot11;
                } else if(input[i].before == '0' || input[i].before == 's'){//curr 1 after 0
                    art[0][i] = top10;
                    art[1][i] = mid10;
                    art[2][i] = bot10;
                }

            } else if (n.charAt(i) == '0'){
                if(input[i].before == '1'  || input[i].before == 's'){   //curr 0 after 1
                    art[0][i] = top01;
                    art[1][i] = mid01;
                    art[2][i] = bot01;
                } else if (input[i].before == '0'){//curr 0 after 0
                    art[0][i] = top00;
                    art[1][i] = mid00;
                    art[2][i] = bot00;
                }
            }
        }

        for(int j = 0; j < 3; j++) {
            for(int k = 0; k < n.length(); k++) {
                System.out.print(art[j][k]);
            }
            System.out.println();
        }

    }

    public static String convertDiff(Digit[] input,String n) {
        String conversion = "";
        int flag;

        if(n.charAt(0)=='0'){
            conversion = "1";
            flag = 1;
        } else {
            conversion = "0";
            flag = 0;
        }

        if(n.length() > 1) {
            for (int i = 1; i < n.length(); i++) {
                if(flag == 1) {
                    flag = 0;
                } else {
                    flag = 1;
                }
                if (input[i].digit == '0') {
                    if(flag == 1){
                        flag = 0;
                        conversion = conversion + "0";
                    } else {
                        flag = 1;
                        conversion = conversion + "1";
                    }
                } else {
                    conversion = conversion + flag;
                }
            }
        }

        return conversion;
    }
}