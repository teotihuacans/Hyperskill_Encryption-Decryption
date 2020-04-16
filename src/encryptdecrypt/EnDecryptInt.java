package encryptdecrypt;

public interface EnDecryptInt {
    String getResult();
}

abstract class AbstractEnDecrypt implements EnDecryptInt {
    String vSTR;
    int vSHFT;
    String vEnDe = "";

    public AbstractEnDecrypt(String vSTR, int vSHFT) {
        this.vSTR = vSTR;
        this.vSHFT = vSHFT;
    }
}

class EncryptUnicode extends AbstractEnDecrypt {
    public EncryptUnicode (String vSTR, int vSHFT) {
        super(vSTR, vSHFT);
    }

    @Override
    public String getResult() {
        for (int i = 0; i < vSTR.length(); i++) {
            vEnDe += Character.toString((char)(((Math.abs(' ' - vSTR.charAt(i)) + vSHFT) % 96) + ' '));
        }
        return vEnDe;
    }
}

class DecryptUnicode extends AbstractEnDecrypt {
    public DecryptUnicode (String vSTR, int vSHFT) {
        super(vSTR, vSHFT);
    }

    @Override
    public String getResult() {
        for (int i = 0; i < vSTR.length(); i++) {
            vEnDe += Character.toString((char) (((Math.abs(' ' - vSTR.charAt(i)) - vSHFT + 96) % 96) + ' '));
        }
        return vEnDe;
    }
}



class EncryptShift extends AbstractEnDecrypt {
    public EncryptShift (String vSTR, int vSHFT) {
        super(vSTR, vSHFT);
    }

    @Override
    public String getResult() {
        for (int i = 0; i < vSTR.length(); i++) {
            if (vSTR.charAt(i) >= 'a' && vSTR.charAt(i) <= 'z') {
                vEnDe += Character.toString((char)(((Math.abs('a' - vSTR.charAt(i)) + vSHFT) % 26) + 'a'));
            } else if (vSTR.charAt(i) >= 'A' && vSTR.charAt(i) <= 'Z') {
                vEnDe += Character.toString((char)(((Math.abs('A' - vSTR.charAt(i)) + vSHFT) % 26) + 'A'));
            } else {
                vEnDe += vSTR.charAt(i);
            }
        }
        return vEnDe;
    }
}

class DecryptShift extends AbstractEnDecrypt {
    public DecryptShift (String vSTR, int vSHFT) {
        super(vSTR, vSHFT);
    }

    @Override
    public String getResult() {
        for (int i = 0; i < vSTR.length(); i++) {
            if (vSTR.charAt(i) >= 'a' && vSTR.charAt(i) <= 'z') {
                vEnDe += Character.toString((char)(((Math.abs('a' - vSTR.charAt(i)) - vSHFT + 26) % 26) + 'a'));
            } else if (vSTR.charAt(i) >= 'A' && vSTR.charAt(i) <= 'Z') {
                vEnDe += Character.toString((char)(((Math.abs('A' - vSTR.charAt(i)) - vSHFT + 26) % 26) + 'A'));
            } else {
                vEnDe += vSTR.charAt(i);
            }
        }
        return vEnDe;
    }
}