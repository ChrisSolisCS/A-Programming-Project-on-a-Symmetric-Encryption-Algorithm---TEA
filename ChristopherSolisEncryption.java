// Code by Christopher Solis
// This Java program implements TEA Encryption that includes only one
// pair of rounds: rounds 1 and 2
/*
Testing Cases:

DeltaOne 0x11111111
DeltaTwo 0x22222222

KZero  0x90001C55
KOne  0x1234ABCD
KTwo  0xFEDCBA98
KThree  0xE2468AC0

LZero  0xA0000009
RZero  0x8000006B

LOne  0x8000006B
ROne  0xB72599B2

LTwo  0xB72599B2
RTwo  0xCF8E5A4C
 */

import java.util.Scanner; // scanner for reading user input

public class ChristopherSolisEncryption {
        public static void main(String[] args) {

        int DeltaOne = 0x11111111; // Constant
        int DeltaTwo = 0x22222222; // Constant

        int K[]; // array declared
        K = new int[4];

        //K[0]
        int i = 0;
        Scanner values = new Scanner(System.in); // scanner object
        System.out.println("Please input K[i] in Hex String (without '0x':) ");
        String userInput = values.nextLine(); // user input saved
        int hexNum = Integer.parseUnsignedInt(userInput, 16);

        K[i] = hexNum;
        i++;

        //K[1]
        System.out.println("Please input K[i] in Hex String (without '0x':) ");
        userInput = values.nextLine(); // user input saved
        hexNum = Integer.parseUnsignedInt(userInput, 16);
        K[i] = hexNum;
        i++;

        //K[2]
        System.out.println("Please input K[i] in Hex String (without '0x':) ");
        userInput = values.nextLine(); // user input saved
        hexNum = Integer.parseUnsignedInt(userInput, 16);
        K[i] = hexNum;
        i++;

        //K[3]
        System.out.println("Please input K[i] in Hex String (without '0x':) ");
        userInput = values.nextLine(); // user input saved
        hexNum = Integer.parseUnsignedInt(userInput, 16);
        K[i] = hexNum;

        int L[]; // array declared
        int R[]; // array declared
        L = new int[3];
        R = new int[3];

        //L[0]
        System.out.println("Please input L[0] in Hex String (without '0x'): ");
        userInput = values.nextLine(); //user input saved
        hexNum = Integer.parseUnsignedInt(userInput, 16);
        L[0] = hexNum;

        //R[0]
        System.out.println("Please input R[0] in Hex String (without '0x'): ");
        userInput = values.nextLine(); //user input saved
        hexNum = Integer.parseUnsignedInt(userInput, 16);
        R[0] = hexNum;

        L[1] = 0x00000000;
        L[2] = 0x00000000;
        R[1] = 0x00000000;
        R[2] = 0x00000000;

        //Encryption Algorithm

        //L[1]
        L[1] = R[0];

        //R[1]
        R[1] = L[0] + ((R[0] + DeltaOne) ^ ((R[0] << 4) + K[0]) ^ ((R[0] >>> 5) + K[1]));

        //L[2]
        L[2] = R[1];

        //R[2]
        R[2] = L[1] + ((R[1] + DeltaTwo) ^ ((R[1] << 4) + K[2]) ^ ((R[1] >>> 5) + K[3]));

        //Outputs

        //[0]
        System.out.println("L[0] = " + String.format("%08X", L[0]));
        System.out.println("R[0] = " + String.format("%08X", R[0]));

        //[1]
        System.out.println("L[1] = " + String.format("%08X", L[1]));
        System.out.println("R[1] = " + String.format("%08X", R[1]));

        //[2]
        System.out.println("L[2] = " + String.format("%08X", L[2]));
        System.out.println("R[2] = " + String.format("%08X", R[2]));
        }
}