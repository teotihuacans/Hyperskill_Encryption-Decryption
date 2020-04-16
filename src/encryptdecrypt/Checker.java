package encryptdecrypt;

public class Checker {
    public static EnDecryptInt maker(String vMD, String vAlg, String vSTR, int vSHFT) {
        switch (vAlg) {
            case "unicode":
                return "enc".equals(vMD) ? new EncryptUnicode(vSTR, vSHFT) : new DecryptUnicode(vSTR, vSHFT);
            case "shift":
                return "enc".equals(vMD) ? new EncryptShift(vSTR, vSHFT) : new DecryptShift(vSTR, vSHFT);
            default:
                return null;
        }
    }
}