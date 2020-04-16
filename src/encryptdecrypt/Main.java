package encryptdecrypt;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String vHI = "", vSTR = "", vMD = "enc", vOut = "", vMOut = "", vAlg = "shift";
        int vSHFT = 0;
        File filein = null, fileout = null;
        boolean vErr = false;

        vHI = "Available flags:\n -key - encryption step (enc/dec) (default <enc>),\n" +
                " -data - input \"<String>\", could be changed by -in flag,\n" +
                " [-in] - input file path/name with String,\n" +
                " [-out] - output file with result, otherwise console out\n" +
                " -alg - algorithm to use (shift/unicode) (default <shift>).";

        for (int i = 0; i < args.length; i += 2) {
            if ("-mode".equals(args[i])) {
                vMD = args[i + 1];
            } else if ("-key".equals(args[i])) {
                vSHFT = Integer.parseInt(args[i + 1]);
            } else if ("-data".equals(args[i])) {
                vSTR = args[i + 1];
            } else if ("-in".equals(args[i])) {
                filein = vSTR.isEmpty() ? new File(args[i + 1]) : null;
            } else if ("-out".equals(args[i])) {
                fileout = new File(args[i + 1]);
            } else if ("-alg".equals(args[i])) { //shift unicode
                vAlg = args[i + 1];
            } else {
                System.out.println("Error! Unknown flag: " + args[i]);
                vErr = true;
            }
        }

        if(vErr || args.length == 0) {
            if (args.length == 0) {
                vHI = "No arguments were passed.\n" + vHI;
            }
            System.out.println(vHI);
            System.exit(1);
        }

        if (filein != null) {
            vSTR = ReadFromFile(filein);
        }

        vMOut = new Checker().maker(vMD, vAlg, vSTR, vSHFT).getResult();
        vOut = vSTR.replaceAll("[a-z]{1}", "#");

        if (fileout == null) {
            //System.out.println(vSTR);
            System.out.println(vMOut);
            //System.out.println(vOut);
        } else {
            WriteToFile(fileout, vMOut);
        }
    }

    private static String ReadFromFile(File filein) throws IOException {
        String vS = "";
        try(BufferedReader vin = new BufferedReader(new FileReader(filein))) {
            vS = vin.readLine();
        } catch (IOException e) {
            System.out.printf("Error: %s", e.getMessage());
        }
        return vS;
    }

    private static void WriteToFile(File fileout, String vS) throws IOException {
        try(PrintWriter printWriter = new PrintWriter(fileout)) {
            printWriter.println(vS);
        } catch (IOException e) {
            System.out.printf("Error: %s", e.getMessage());
        }
    }
}
