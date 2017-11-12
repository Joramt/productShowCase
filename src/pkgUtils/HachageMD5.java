package pkgUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HachageMD5 {
	
	public static final String DEFAULT_ENCODING="UTF-8"; 
	static BASE64Encoder enc=new BASE64Encoder();
	static BASE64Decoder dec=new BASE64Decoder();

	public static String encryptString(String toEncrypt){
		 try {
	         return new String(enc.encode( toEncrypt.getBytes( DEFAULT_ENCODING )));      
	      }
	      catch ( UnsupportedEncodingException e ) {
	         return null;
	      }
	}
	
	public static String decryptString(String toDecrypt){

        try {
           return new String(dec.decodeBuffer( toDecrypt ),DEFAULT_ENCODING);
        }
        catch ( IOException e ) {
          return null;
        }

     }//base64decode
	
	public  static String crypter(String password){
	    	
	        MessageDigest md;
	        StringBuffer sb=null;
			try {
				md = MessageDigest.getInstance("MD5");
			
	        md.update(password.getBytes());
	        
	        byte byteData[] = md.digest();
	 
	        //convert the byte to hex format method 1
	         sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	     
	        System.out.println("Digest(in hex format):: " + sb.toString());
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
				 return password=sb.toString();
	    }
	
	public static void main(String arg[]) {
		String a = HachageMD5.crypter("omar");
		System.out.println(a);
	}
	
	}
	

