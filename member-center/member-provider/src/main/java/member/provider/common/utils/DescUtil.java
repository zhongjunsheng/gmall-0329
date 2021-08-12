package member.provider.common.utils;

import com.sun.crypto.provider.SunJCE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.Security;

/**
 * @author Administrator
 * @date 2019/10/17
 * @since 1.0.0
 */
public class DescUtil {
    private static final Logger log = LoggerFactory.getLogger(DescUtil.class);

    private static final String ALGORITHM = "DES";
    private static final int KEY_LENGTH = 8;

    static {
        Security.addProvider(new SunJCE());
    }

    /**
     * 获取加解密的钥
     *
     * @param privateKeyStr
     *
     * @return Key
     */
    private static Key getKey(String privateKeyStr) {
        byte[] arrBTmp = privateKeyStr.getBytes();
        byte[] arrB = new byte[8];
        for (int i = 0; i < privateKeyStr.getBytes().length && i < arrB.length; i++) {
            arrB[i] = arrBTmp[i];
        }
        return new SecretKeySpec(arrB, ALGORITHM);
    }

    /**
     * 字节数组加密，指定KEY
     *
     * @param data
     *            数据
     * @param privateKey
     *            私钥
     *
     * @return 加密后的数组
     *
     * @throws IllegalBlockSizeException
     *             异常
     * @throws BadPaddingException
     *             异常
     */
    public static byte[] encrypt(byte[] data, String privateKey) throws IllegalBlockSizeException, BadPaddingException {
        if (privateKey == null || privateKey.length() < KEY_LENGTH) {
            throw new IllegalArgumentException("privateKeyStr is not null && length < 8");
        }
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, getKey(privateKey));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return cipher.doFinal(data);
    }

    /**
     * 字节数组解密-指定KEY
     *
     * @param data
     *            数据
     * @param privateKey
     *            秘钥
     *
     * @return 解密后的数组
     *
     * @throws IllegalBlockSizeException
     *             异常
     * @throws BadPaddingException
     *             异常
     */
    public static byte[] decrypt(byte[] data, String privateKey) throws IllegalBlockSizeException, BadPaddingException {
        if (privateKey == null || privateKey.length() > KEY_LENGTH) {
            throw new IllegalArgumentException("privateKey is not null && length < 8");
        }
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, getKey(privateKey));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cipher.doFinal(data);
    }

    /**
     * 字符串加密-指定KEY
     *
     * @param data
     *            数据
     * @param privateKey
     *            秘钥
     *
     * @return 加密后的数据
     *
     * @throws IllegalBlockSizeException
     *             异常
     * @throws BadPaddingException
     *             异常
     */
    public static String encrypt(String data, String privateKey) throws IllegalBlockSizeException, BadPaddingException {
        return byteArr2HexStr(encrypt(data.getBytes(), privateKey));
    }

    /**
     * 字符串解密-指定KEY
     *
     * @param data
     *            数据
     * @param privateKey
     *            秘钥
     *
     * @return 解密后的数据
     *
     * @throws IllegalBlockSizeException
     *             异常
     * @throws BadPaddingException
     *             异常
     */
    public static String decrypt(String data, String privateKey) throws IllegalBlockSizeException, BadPaddingException {
        return new String(decrypt(hexStr2ByteArr(data), privateKey));
    }

    /**
     * Byte 数组-改16进制
     *
     * @param arrB
     *            byte 数组
     *
     * @return 16进制字符串
     */
    private static String byteArr2HexStr(byte[] arrB) {
        int iLen = arrB.length;
        StringBuilder sb = new StringBuilder(iLen * 2);
        for (int i = 0; i < iLen; i++) {
            int intTmp = arrB[i];
            while (intTmp < 0) {
                intTmp = intTmp + 256;
            }
            if (intTmp < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(intTmp, 16));
        }
        return sb.toString();
    }

    /**
     * 将16进制的字符串-转为Byte数组
     *
     * @param strIn
     *            16进制的字符串
     *
     * @return Byte数组
     */
    private static byte[] hexStr2ByteArr(String strIn) {
        byte[] arrB = strIn.getBytes();
        int iLen = arrB.length;
        byte[] arrOut = new byte[iLen / 2];
        for (int i = 0; i < iLen; i = i + 2) {
            String strTmp = new String(arrB, i, 2);
            arrOut[i / 2] = (byte)Integer.parseInt(strTmp, 16);
        }
        return arrOut;
    }

    public static void main(String[] args) {
        try {
            String allen = encrypt("allen", "12345678");
            String decrypt = decrypt(allen, "12345678");
            System.out.println(decrypt);
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }


    }
}