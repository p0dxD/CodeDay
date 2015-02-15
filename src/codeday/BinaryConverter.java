package codeday;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Timer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 * This program will convert any sentence to a binary representation of many
 * bits
 *
 * @author Joseph
 */
public class BinaryConverter {

    private static String musicPath = "file: ../../audio/";
    private static int number;
    private static int numberOnes = 0;
    private static int numberZeros = 0;
    private static ArrayList<Integer> binary = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter sentence to convert: ");
        breakSentence(input.nextLine());
        countOnes(binary);
        countZeros(binary);
        printbinaryValues();
        System.out.println("\nOnes: " + getCountOnes());
        System.out.println("Zeros: " + getCountZeros());
    }

    public static ArrayList<Integer> getBinaryValues() {

        return binary;
    }

    /**
     * Prints out the binary values obtained
     */
    public static void printbinaryValues() {
        for (int i = 0; i < binary.size(); i++) {
            System.out.print(binary.get(i));
        }
    }

    /**
     * This will get the initial sentence to break down
     *
     * @param sentence to break down
     */
    public static void breakSentence(String sentence) {
        StringTokenizer tk = new StringTokenizer(sentence);
        while (tk.hasMoreTokens() && tk.hasMoreElements()) {
            breakWord(tk.nextToken());
        }
        System.out.println("\nSentence: " + sentence);
    }

    /**
     * This will break the word into chars
     *
     * @param word to get the chars from
     */
    public static void breakWord(String word) {
        for (int i = 0; i < word.length(); i++) {
            wordCode(word.charAt(i));
        }
    }

    /**
     *
     * @param letter to get the int value for
     * @return the int value
     */
    private static void wordCode(char letter) {
        number = letter;
        printOutBinary(number);
    }

    /**
     * This prints out the binary representation of each word
     *
     * @param code the number to break down
     * @return the binary number
     */
    private static ArrayList<Integer> printOutBinary(int code) {
        ArrayList<Integer> temp = new ArrayList<>();
        while (code > 0) {
            binary.add(code % 2);
            code = code / 2;
        }
        if (code % 2 == 0) {
            binary.add(0);
        }
        //We flip it to the correct order
        for (int i = 1; i <= binary.size(); i++) {
            temp.add(binary.get(binary.size() - i));
        }
        binary = temp;
        return binary;

    }

    public static void countOnes(ArrayList<Integer> array) {
        for (int i = 0; i < array.size(); i++) {

            if (array.get(i).equals(1)) {
                numberOnes++;
            }
        }
    }

    public static void countZeros(ArrayList<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).equals(0)) {
                numberZeros++;
            }
        }
    }

    public static int getCountZeros() {
        return numberZeros;
    }

    public static int getCountOnes() {
        return numberOnes;
    }

    /**
     * This is the main method that will split the binary depending on size
     * breaking will be fixated on the following
     *
     * @param array
     */
    public static void split(ArrayList<Integer> array) {

        if (array.size() < 100 && !array.isEmpty()) {
            System.out.println("Small sentence");
            //System.out.println("First Two: "+breakTwoBits(array));
            //Media hitTwo;
            for (int i = 0; i < breakTwoBits(array).size(); i++) {

                switch (breakTwoBits(array).get(i)) {
                    case "00":
                        System.out.println("Inside 00");
                        Media hitTwo = new Media(new File("C:\\Users\\Joseph\\Documents\\"
                                + "NetBeansProjects\\CodeDay\\audio\\VoicePiano\\64Voice_1.wav").toURI().toString());
                        playSound(hitTwo);                        
                        
                        break;
                    case "01":
                        System.out.println("Inside 01");
                        Media hitTwo1 = new Media(new File("C:\\Users\\Joseph\\Documents\\"
                                + "NetBeansProjects\\CodeDay\\audio\\VoicePiano\\64Voice_2.wav").toURI().toString());
                        playSound(hitTwo1);
                        break;
                    case "10":
                        System.out.println("Inside 10");
                        Media hitTwo2 = new Media(new File("C:\\Users\\Joseph\\Documents\\"
                                + "NetBeansProjects\\CodeDay\\audio\\VoicePiano\\64Voice_3.wav").toURI().toString());
                        playSound(hitTwo2);
                        break;
                    case "11":
                        System.out.println("Inside 11");
                        Media hitTwo3 = new Media(new File("C:\\Users\\Joseph\\Documents\\"
                                + "NetBeansProjects\\CodeDay\\audio\\VoicePiano\\64Voice_4.wav").toURI().toString());
                        playSound(hitTwo3);
                        break;
                    default:
                        System.out.println("Something went wrong");
                        break;

                }
            }
//        } else if (array.size() > 20 && array.size() < 100) {
//            System.out.println("Mid sentence");
//            Media hitTwo;
//            for (int i = 0; i < breakThreeBits(array).size(); i++) {
//                try {
//                    Thread.sleep(1500*i/50);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(BinaryConverter.class.getName()).log(Level.SEVERE, null, ex);
//                }                
//                switch (breakThreeBits(array).get(i)) {
//                    case "000":
//                        System.out.println("Inside 000");
//                        hitTwo = new Media(new File("C:\\Users\\Joseph\\Documents\\"
//                                + "NetBeansProjects\\CodeDay\\audio\\VoicePiano\\64Voice_1.wav").toURI().toString());
//                        playSound(hitTwo);                        
//                        break;
//                    case "001":
//                        System.out.println("Inside 001");
//                        Media hitTwo2 = new Media(new File("C:\\Users\\Joseph\\Documents\\"
//                                + "NetBeansProjects\\CodeDay\\audio\\VoicePiano\\64Voice_2.wav").toURI().toString());
//                        playSound(hitTwo2);                        
//
//                        break;
//                    case "010":
//                        System.out.println("Inside 010");
//                        Media hitTwo3 = new Media(new File("C:\\Users\\Joseph\\Documents\\"
//                                + "NetBeansProjects\\CodeDay\\audio\\VoicePiano\\64Voice_3.wav").toURI().toString());
//                        playSound(hitTwo3);                        
//
//                        break;
//                    case "011":
//                        System.out.println("Inside 011");
//                        Media hitTwo4 = new Media(new File("C:\\Users\\Joseph\\Documents\\"
//                                + "NetBeansProjects\\CodeDay\\audio\\VoicePiano\\64Voice_4.wav").toURI().toString());
//                        playSound(hitTwo4);                        
//
//                        break;
//                    case "100":
//                        System.out.println("Inside 100");
//                        Media hitTwo5 = new Media(new File("C:\\Users\\Joseph\\Documents\\"
//                                + "NetBeansProjects\\CodeDay\\audio\\VoicePiano\\64Voice_5.wav").toURI().toString());
//                        playSound(hitTwo5);
//                        break;
//                    case "101":
//                        System.out.println("Inside 101");
//                        Media hitTwo6 = new Media(new File("C:\\Users\\Joseph\\Documents\\"
//                                + "NetBeansProjects\\CodeDay\\audio\\VoicePiano\\64Voice_6.wav").toURI().toString());
//                        playSound(hitTwo6);
//                        break;
//                    case "110":
//                        System.out.println("Inside 110");
//                        Media hitTwo7 = new Media(new File("C:\\Users\\Joseph\\Documents\\"
//                                + "NetBeansProjects\\CodeDay\\audio\\VoicePiano\\64Voice_7.wav").toURI().toString());
//                        playSound(hitTwo7);
//                        break;
//                    case "111":
//                        System.out.println("Inside 111");
//                        Media hitTwo8 = new Media(new File("C:\\Users\\Joseph\\Documents\\"
//                                + "NetBeansProjects\\CodeDay\\audio\\VoicePiano\\64Voice_8.wav").toURI().toString());
//                        playSound(hitTwo8);
//                        break;
//                    default:
//                        System.out.println("Something went wrong");
//                        break;
//
//                }
//            }
        } else if (array.size() > 100) {
            System.out.println("Decent sentence");
            //Media hitTwo;
            for (int i = 0; i < breakFourBits(array).size(); i++) {

                switch (breakFourBits(array).get(i)) {
                    case "0000":
                        System.out.println("Inside 0000");
                        Media hitTwo = new Media(new File("C:\\Users\\Joseph\\Documents\\NetBeansProjects\\CodeDay\\audio\\VoicePiano\\64Voice_1.wav").toURI().toString());
                        playSound(hitTwo);
                                MediaPlayer mediaPlayerTwo = new MediaPlayer(hitTwo);
                                mediaPlayerTwo.play();
                        break;
                    case "0001":
                        System.out.println("Inside 0001");
                        Media hitTwo1 = new Media(new File(("C:\\Users\\Joseph\\Documents\\NetBeansProjects\\CodeDay\\audio\\VoicePiano\\64Voice_2.wav")).toURI().toString());
                        playSound(hitTwo1);
                        break;
                    case "0010":
                        System.out.println("Inside 0010");
                        Media hitTwo2 = new Media(new File("C:\\Users\\Joseph\\Documents\\"
                                + "NetBeansProjects\\CodeDay\\audio\\VoicePiano\\64Voice_3.wav").toURI().toString());
                        playSound(hitTwo2);
                        break;
                    case "0011":
                        System.out.println("Inside 0011");
                        Media hitTwo3 = new Media(new File("C:\\Users\\Joseph\\Documents\\"
                                + "NetBeansProjects\\CodeDay\\audio\\VoicePiano\\64Voice_4.wav").toURI().toString());
                        playSound(hitTwo3);
                        break;
                    case "0100":
                        System.out.println("Inside 0100");
                        Media hitTwo4 = new Media(new File("C:\\Users\\Joseph\\Documents\\"
                                + "NetBeansProjects\\CodeDay\\audio\\VoicePiano\\64Voice_5.wav").toURI().toString());
                        playSound(hitTwo4);                        
                        break;
                    case "0101":
                        System.out.println("Inside 0101");
                        Media hitTwo5 = new Media(new File("C:\\Users\\Joseph\\Documents\\"
                                + "NetBeansProjects\\CodeDay\\audio\\VoicePiano\\64Voice_6.wav").toURI().toString());
                        playSound(hitTwo5);                        
                        break;
                    case "0110":
                        System.out.println("Inside 0110");
                        Media hitTwo6 = new Media(new File("C:\\Users\\Joseph\\Documents\\"
                                + "NetBeansProjects\\CodeDay\\audio\\VoicePiano\\64Voice_7.wav").toURI().toString());
                        playSound(hitTwo6);                        
                        break;
                    case "0111":
                        System.out.println("Inside 0111");
                        Media hitTwo7 = new Media(new File("C:\\Users\\Joseph\\Documents\\"
                                + "NetBeansProjects\\CodeDay\\audio\\VoicePiano\\64Voice_8.wav").toURI().toString());
                        playSound(hitTwo7);
                        break;
                    case "1000":
                        System.out.println("Inside 1000");
                        Media hitTwo8 = new Media(new File("C:\\Users\\Joseph\\Documents\\"
                                + "NetBeansProjects\\CodeDay\\audio\\VoicePiano\\64Voice_9.wav").toURI().toString());
                        playSound(hitTwo8);                        
                        break;
                    case "1001":
                        System.out.println("Inside 1001");
                        Media hitTwo9 = new Media(new File("C:\\Users\\Joseph\\Documents\\"
                                + "NetBeansProjects\\CodeDay\\audio\\VoicePiano\\64Voice_10.wav").toURI().toString());
                        playSound(hitTwo9);                        
                        break;
                    case "1010":
                        System.out.println("Inside 1010");
                        Media hitTwo10 = new Media(new File("C:\\Users\\Joseph\\Documents\\NetBeansProjects\\CodeDay"
                                + "\\audio\\APiano01\\AI-APiano01 1.wav").toURI().toString());
                        playSound(hitTwo10);                        
                        break;
                    case "1011":
                        System.out.println("Inside 1011");
                        Media hitTwo11 = new Media(new File("C:\\Users\\Joseph\\Documents\\NetBeansProjects\\CodeDay"
                                + "\\audio\\APiano01\\AI-APiano01 2.wav").toURI().toString());
                        playSound(hitTwo11);                        
                        break;
                    case "1101":
                        System.out.println("Inside 1101");
                        Media hitTwo12 = new Media(new File("C:\\Users\\Joseph\\Documents\\NetBeansProjects\\CodeDay"
                                + "\\audio\\APiano01\\AI-APiano01 3.wav").toURI().toString());
                        playSound(hitTwo12);                        
                        break;
                    case "1100":
                        System.out.println("Inside 1100");
                        Media hitTwo13 = new Media(new File("C:\\Users\\Joseph\\Documents\\NetBeansProjects\\CodeDay"
                                + "\\audio\\APiano01\\AI-APiano01 4.wav").toURI().toString());
                        playSound(hitTwo13);                        
                        break;
                    case "1110":
                        System.out.println("Inside 1110");
                        Media hitTwo14 = new Media(new File("C:\\Users\\Joseph\\Documents\\NetBeansProjects\\CodeDay"
                                + "\\audio\\APiano01\\AI-APiano01 5.wav").toURI().toString());
                        playSound(hitTwo14);                        
                        break;
                    case "1111":
                        System.out.println("Inside 1111");
                        Media hitTwo15 = new Media(new File("C:\\Users\\Joseph\\Documents\\NetBeansProjects\\CodeDay"
                                + "\\audio\\APiano01\\AI-APiano01 6.wav").toURI().toString());
                        playSound(hitTwo15);                        
                        break;
                    default:
                        System.out.println("Something went wrong");
                        break;

                }
            }
        } else {
            System.out.println("No input");
        }
    }

    /**
     * This method breaks the binary list into appropiate for usage
     *
     * @return
     */
    private static ArrayList<String> breakTwoBits(ArrayList<Integer> array) {
        ArrayList<String> list = new ArrayList<>();
        Iterator<Integer> it = array.iterator();
        while (it.hasNext()) {
            Integer element = it.next();
            Integer elementTwo = it.next();
            list.add(String.valueOf(element + "" + elementTwo));
        }
        //This will play for the first one

        return list;
    }

    private static ArrayList<String> breakFourBits(ArrayList<Integer> array) {
        ArrayList<String> list = new ArrayList<>();
        Iterator<Integer> it = array.iterator();
        while (it.hasNext()) {
            Integer element = it.next();
            Integer elementTwo = it.next();
            Integer elementThree = it.next();
            Integer elementFour = it.next();

            list.add(String.valueOf(element + "" + elementTwo + "" + elementThree + "" + elementFour));
        }
        //This will play for the first one

        return list;
    }

    private static ArrayList<String> breakThreeBits(ArrayList<Integer> array) {
        ArrayList<String> list = new ArrayList<>();
        Iterator<Integer> it = array.iterator();
        while (it.hasNext()) {
            Integer element = it.next();
            Integer elementTwo = it.next();
            Integer elementThree = it.next();
//            Integer elementFour = it.next();

            list.add(String.valueOf(element + "" + elementTwo + "" + elementThree));
        }
        //This will play for the first one

        return list;
    }

    public static void clearArray() {
        binary.clear();
    }
    /**
     * This will play the sound
     * @param hitTwo takes the media depending on track to play
     */
    private static void playSound(Media hitTwo) {
        System.out.println("Inside play");
        MediaPlayer mediaPlayerTwo = new MediaPlayer(hitTwo);
        new Timeline(new KeyFrame(
                Duration.millis(2500),
                ae -> {
                    Timer timer = new Timer();
                    for(int i =0; i < 1000000000; i+=1){
                    }
                    mediaPlayerTwo.rateProperty().setValue(3);
                    mediaPlayerTwo.play();
        System.out.println("Inside the play play");
                    
                }
        ))
                .play();

    }
    //private int breakFourBits(ArrayList<Integer> array){
    //}
}
