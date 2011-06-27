package com.taobao.caipiao.agentmock.core.commu.bjfc.util;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;


public class Bjfczlip {

	/**
	 * 把内容使用Zlib压缩,并Base64编码
	 * 
	 * @param content
	 *            内容
	 * @return
	 */
	public static byte[] encode(byte[] input) {
		byte[] output = new byte[input.length * 2];
		Deflater compresser = new Deflater();
		try{
			compresser.setInput(input);
			compresser.finish();
			int compressedDataLength = compresser.deflate(output);
			byte[] contentByte = new byte[compressedDataLength];
			System.arraycopy(output, 0, contentByte, 0, compressedDataLength);
			return contentByte;
		}finally{
			compresser.end();
		}
	}

	/**
	 * Base64解码，Zlib解压缩
	 * 
	 * @param content
	 *            内容
	 * @return
	 */
	public static String decode(byte[] encodeByte) {
		String outputString = "";
		try {
			boolean flag = true;
			int resultLength = 0;
			byte[] result = null;
			int i = 1;

			while (flag) {
				Inflater decompresser = new Inflater();
				try{
					result = new byte[encodeByte.length * 20 * i];
					decompresser.setInput(encodeByte, 0, encodeByte.length);
					resultLength = decompresser.inflate(result);
					if (decompresser.getRemaining() == 0) {
						flag = false;
					}
				}finally{
					decompresser.end();
				}
				i++;
			}

			outputString = new String(result, 0, resultLength,"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outputString;
	}

	static byte int2bytes(int num)
	{
	       byte[] b=new byte[4];
	       int mask=0xff;
	       for(int i=0;i<4;i++){
	            b[i]=(byte)(num>>>(24-i*8));
	       }
	      return b[3];
	}
	
	public static void main(String argv[]) throws IOException, Exception {
		String inputStr = "";  		
		//inputStr = "<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\"?><body><lType>2</lType><periodNum>2010234</periodNum></body>";
		inputStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<body><lType>2</lType><periodNum>2010234</periodNum></body>";
		//inputStr = "<?xml version=\"1.0\" encoding=\"utf-8\"?><body><records><record><ltype>8</ltype><periodnum>523185</periodnum><orderno></orderno><chipincontent></chipincontent><printresult>7</printresult><ordermoney></ordermoney></record></records></body>";
		
        System.out.println("输入字符串:\t" + inputStr + "长度:\t" + inputStr.length());        
                
        byte[] input = inputStr.getBytes("UTF-8");
        System.out.println("输入字节长度:\t" + input.length);        
 
        byte[] data = Bjfczlip.encode(input);  
        System.out.println("压缩后字节长度:\t" + data.length);        
               
        
        String desKey = "1234567890ABCDEF";        
        String packStr = BjfcUtil.packBodyByte(data, desKey);
        System.out.println("pack(compressed string):\t" + packStr);
  
        
        String bodyStr = "UHEfjZ0v6jK61EeFqWI9EUQfq4umqMKwSGYrp4EABHpITb9vzOyytjhiKdZRaxTTSdnBgtC29TQalEMF+eZ8SpSKeeuDOVOkZST6NPXxh3A6kQ+m9A6u8Fev/nSmja04";	
        byte[] unpackByte =BjfcUtil.unpackBodyToXMLByte(bodyStr, "1234567890ABCDEF");
        for(int i = 0; i< unpackByte.length; i++)        	
			System.out.print((unpackByte[i] > 0 ? unpackByte[i] : unpackByte[i] + 256) + " ");
		System.out.println("\nunpackBytes length : " + unpackByte.length);
		String deResult = Bjfczlip.decode(unpackByte);
        System.out.println("deResult: "+deResult);
        
	}
}
