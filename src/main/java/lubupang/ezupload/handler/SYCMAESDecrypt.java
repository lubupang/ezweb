package lubupang.ezupload.handler;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class SYCMAESDecrypt {
    public String iv;
    public String key;
    public SYCMAESDecrypt(String iv, String key){
        this.iv=iv;
        this.key=key;
    }
    public String AESEncrypt(String str){
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes("UTF-8"));
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

            byte[] encrypted = cipher.doFinal(str.getBytes());

            StringBuilder sb = new StringBuilder(2*encrypted.length);
            for(byte b : encrypted){
                sb.append(String.format("%02x", b&0xff));
            }

            return sb.toString();
        } catch (Exception ex) {

            ex.printStackTrace();
            return null;
        }



    }
    public String AESDecrypt(String str){


        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes("UTF-8"));
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);



            byte[] encrypted = new byte[str.length() / 2];
            for(int i = 0; i < str.length() / 2; i++) {
                String subStr = str.substring(i * 2, i * 2 + 2);
                encrypted[i] = (byte) Integer.parseInt(subStr, 16);
            }


            byte[] value = cipher.doFinal(encrypted);
            return new String(value, StandardCharsets.UTF_8);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
