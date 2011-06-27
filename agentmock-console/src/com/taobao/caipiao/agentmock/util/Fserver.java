package com.taobao.caipiao.agentmock.util;

import java.io.*;
import java.net.*;
import java.util.Enumeration;



import java.io.*;
import java.net.*;
import java.util.*;

public class Fserver extends Thread{
	private int _port;
	public static String initDir = "c:/ftp/";
	public static String ftpMockMsg="<xml>AgentMockFtpServer!</xml>";
	
	public Fserver(int port){
		_port = port;
	}
	
	public void run() {
		
		// loadUsersInfo();
		int counter = 1;
		int i = 0;
		try {

			// 监听command号端口
			ServerSocket s = new ServerSocket(this._port);
			s.setReuseAddress(true);
			for (;;) {
				// 接受客户端请求
				Socket incoming = s.accept();
				//BufferedReader in = new BufferedReader(new InputStreamReader(
				//		incoming.getInputStream()));
				PrintWriter peer = new PrintWriter(incoming.getOutputStream(),
						true);
				peer.println("220 Service ready for new user" + counter);

				// 创建服务线程
				SFtpHandler h = new SFtpHandler(incoming, i);
				//users.add(h);
				counter++;
				i++;
				//h.run();
				h.start();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	} // FThreadServer() end

	public static void main(String[] args) {
		if (args.length != 0) {
			initDir = args[0];
		} else {
			initDir = "c:/ftp/";
		}
		Fserver ftpServer = new Fserver(21);
		ftpServer.start();
	} // main end

}

class SFtpHandler extends Thread{
	Socket csocket;
	Socket dsocket;
	ServerSocket ssocket;
	int id;
	String cmd = "";
	String param = "";
	String user;
	String remoteHost = "";
	int remotePort = 0;
	String dir = Fserver.initDir;
	String rootdir = "./";
	int state = 0;
	String reply;
	PrintWriter out;
	int type = 0;
	String requestfile = "";
	boolean isrest = false;
	boolean ispasv = false;
	String serverIp="127.0.0.1";
	
	int parseInput(String s) {
		int p = 0;
		int i = -1;
		p = s.indexOf(" ");
		if (p == -1)
			cmd = s;
		else
			cmd = s.substring(0, p);

		if (p >= s.length() || p == -1)
			param = "";
		else
			param = s.substring(p + 1, s.length());
		cmd = cmd.toUpperCase();

		if (cmd.equals("USER"))
			i = 1;
		else if (cmd.equals("PASS"))
			i = 2;
		else if (cmd.equals("ACCT"))
			i = 3;
		else if (cmd.equals("CDUP"))
			i = 4;
		else if (cmd.equals("SMNT"))
			i = 5;
		else if (cmd.equals("CWD"))
			i = 6;
		else if (cmd.equals("QUIT"))
			i = 7;
		else if (cmd.equals("REIN"))
			i = 8;
		else if (cmd.equals("PORT"))
			i = 9;
		else if (cmd.equals("PASV"))
			i = 10;
		else if (cmd.equals("TYPE"))
			i = 11;
		else if (cmd.equals("STRU"))
			i = 12;
		else if (cmd.equals("MODE"))
			i = 13;
		else if (cmd.equals("RETR"))
			i = 14;
		else if (cmd.equals("STOR"))
			i = 15;
		else if (cmd.equals("STOU"))
			i = 16;
		else if (cmd.equals("APPE"))
			i = 17;
		else if (cmd.equals("ALLO"))
			i = 18;
		else if (cmd.equals("REST"))
			i = 19;
		else if (cmd.equals("RNFR"))
			i = 20;
		else if (cmd.equals("RNTO"))
			i = 21;
		else if (cmd.equals("ABOR"))
			i = 22;
		else if (cmd.equals("DELE"))
			i = 23;
		else if (cmd.equals("RMD"))
			i = 24;
		else if (cmd.equals("XMKD"))
			i = 25;
		else if (cmd.equals("MKD"))
			i = 25;
		else if (cmd.equals("PWD"))
			i = 26;
		else if (cmd.equals("LIST"))
			i = 27;
		else if (cmd.equals("NLST"))
			i = 28;
		else if (cmd.equals("SITE"))
			i = 29;
		else if (cmd.equals("SYST"))
			i = 30;
		else if (cmd.equals("HELP"))
			i = 31;
		else if (cmd.equals("NOOP"))
			i = 32;
		else if (cmd.equals("XPWD"))
			i = 33;
		return i;
	}// parseInput() end

	int validatePath(String s) {
		File f = new File(s);
		if (f.exists() && !f.isDirectory()) {
			String s1 = s.toLowerCase();
			String s2 = rootdir.toLowerCase();
			if (s1.startsWith(s2))
				return 1;
			else
				return 0;
		}
		f = new File(addTail(dir) + s);
		if (f.exists() && !f.isDirectory()) {
			String s1 = (addTail(dir) + s).toLowerCase();
			String s2 = rootdir.toLowerCase();
			if (s1.startsWith(s2))
				return 2;
			else
				return 0;
		}
		return 0;
	}// validatePath() end

	boolean checkPASS(String s) {
		rootdir = Fserver.initDir;
		dir = Fserver.initDir;
		return true;
	}// checkPASS() end

	boolean commandUSER() {
		if (cmd.equals("USER")) {
			reply = "331 User name okay, need password";
			user = param;
			state = FtpState.FS_WAIT_PASS;
			return false;
		} else {
			reply = "501 Syntax error in parameters or arguments";
			return true;
		}

	}// commandUser() end

	boolean commandPASS() {
		if (cmd.equals("PASS")) {
			if (checkPASS(param)) {
				reply = "230 User logged in, proceed";
				state = FtpState.FS_LOGIN;
				System.out.println("Message: user " + user + " Form "
						+ remoteHost + "Login");
				System.out.print("->");
				return false;
			} else {
				reply = "530 Not logged in";
				return true;
			}
		} else {
			reply = "501 Syntax error in parameters or arguments";
			return true;
		}

	}// commandPass() end

	void errCMD() {
		reply = "500 Syntax error, command unrecognized";
	}

	boolean commandPASV() {
		ispasv = true;
		String ip = null;
		Enumeration<NetworkInterface> netInterfaces = null;
		try {
			netInterfaces = NetworkInterface.getNetworkInterfaces();
			while (netInterfaces.hasMoreElements()) {
				NetworkInterface ni = netInterfaces.nextElement();
				//System.out.println("DisplayName:" + ni.getDisplayName());
				//System.out.println("Name:" + ni.getName());
				Enumeration<InetAddress> ips = ni.getInetAddresses();
				while (ips.hasMoreElements()) {
					ip = (String)ips.nextElement().getHostAddress(); 
					if(!ip.equals("127.0.0.1")){
						serverIp = ip;
						//System.out.println("ip address: "+serverIp);
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String parts[] = serverIp.split("\\.");
		try {
			ssocket = new ServerSocket(0);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int port = ssocket.getLocalPort();
		int highPart = port >> 8;
		int lowPart = port & 0xFF;
		
		StringBuilder sb = new StringBuilder();
		sb.append("227 Entering Passive Mode (").append(parts[0]).append(",")
		.append(parts[1]).append(",").append(parts[2]).append(",").append(parts[3]).append(",")
		.append(highPart).append(",").append(lowPart).append(")");
		reply = sb.toString();
		return false;
	}
	
	boolean commandCDUP() {
		dir = Fserver.initDir;
		File f = new File(dir);
		if (f.getParent() != null && (!dir.equals(rootdir))) {
			dir = f.getParent();
			reply = "200 Command okay";
		} else {
			reply = "550 Current directory has no parent";
		}

		return false;
	}// commandCDUP() end

	boolean commandCWD() {
		File f = new File(param);
		String s = "";
		String s1 = "";
		if (dir.endsWith("/"))
			s = dir;
		else
			s = dir + "/";
		File f1 = new File(s + param);

		if (f.isDirectory() && f.exists()) {
			if (param.equals("..") || param.equals("..\\")) {
				if (dir.compareToIgnoreCase(rootdir) == 0) {
					reply = "550 The directory does not exists";
					// return false;
				} else {
					s1 = new File(dir).getParent();
					if (s1 != null) {
						dir = s1;
						reply = "250 Requested file action okay, directory change to "
								+ dir;
					} else
						reply = "550 The directory does not exists";
				}
			} else if (param.equals(".") || param.equals(".\\")) {
			} else {
				dir = param;
				reply = "250 Requested file action okay, directory change to "
						+ dir;
			}
		} else if (f1.isDirectory() && f1.exists()) {
			dir = s + param;
			reply = "250 Requested file action okay, directory change to "
					+ dir;
		} else
			reply = "501 Syntax error in parameters or arguments";

		return false;
	} // commandCDW() end

	boolean commandQUIT() {
		reply = "221 Service closing control connection";
		return true;
	}// commandQuit() end

	boolean commandPORT() {
		ispasv = false;
		int p1 = 0;
		int p2 = 0;
		int[] a = new int[6];
		int i = 0;
		try {
			while ((p2 = param.indexOf(",", p1)) != -1) {
				a[i] = Integer.parseInt(param.substring(p1, p2));
				p2 = p2 + 1;
				p1 = p2;
				i++;
			}
			a[i] = Integer.parseInt(param.substring(p1, param.length()));
		} catch (NumberFormatException e) {
			reply = "501 Syntax error in parameters or arguments";
			return false;
		}

		remoteHost = a[0] + "." + a[1] + "." + a[2] + "." + a[3];
		remotePort = a[4] * 256 + a[5];
		reply = "200 Command okay";
		return false;
	}// commandPort() end

	boolean commandLIST() {
		try {
			dsocket = new Socket(remoteHost, remotePort, InetAddress
					.getLocalHost(), 20);
			PrintWriter dout = new PrintWriter(dsocket.getOutputStream(), true);
			if (param.equals("") || param.equals("LIST")) {
				out.println("150 Opening ASCII mode data connection for /bin/ls. ");
				File f = new File(dir);
				String[] dirStructure = f.list();
				String fileType;
				for (int i = 0; i < dirStructure.length; i++) {
					if (dirStructure[i].indexOf(".") != -1) {
						fileType = "- ";
					} else {
						fileType = "d ";
					}
					dout.println(fileType + dirStructure[i]);
				}
			}
			dout.close();
			dsocket.close();
			reply = "226 Transfer complete !";
		} catch (Exception e) {
			e.printStackTrace();
			reply = "451 Requested action aborted: local error in processing";
			return false;
		}

		return false;
	}// commandLIST() end

	boolean commandTYPE() {
		if (param.equalsIgnoreCase("a")) {
			type = FtpState.FTYPE_ASCII;
			reply = "200 Command okay Change to ASCII mode";
		} else if (param.equalsIgnoreCase("i")) {
			type = FtpState.FTYPE_IMAGE;
			reply = "200 Command okay Change to BINARY mode";
		} else
			reply = "504 Command not implemented for that parameter";

		return false;
	}// commandTYPE() end

	boolean commandRETR() {
		// requestfile = param;
		// File f = new File(requestfile);
		// if (!f.exists()) {
		// f = new File(addTail(dir) + requestfile);
		// if (!f.exists()) {
		// reply = "550 File not found";
		// return false;
		// }
		// requestfile = addTail(dir) + requestfile;
		// }

		if (isrest) {
			
		} else {
			if (type == FtpState.FTYPE_IMAGE) {
				try {
					out.println("150 Opening Binary mode data connection for "
							+ requestfile);
					if(ispasv){
						FileSenderThread fst = new FileSenderThread(ssocket,Fserver.ftpMockMsg);
						fst.start();
						synchronized (fst){
							try{
								fst.wait();
							}catch(InterruptedException e){}
						}
					}else{
						dsocket = new Socket(remoteHost, remotePort, InetAddress
								.getLocalHost(), 20);
						// BufferedInputStream fin = new BufferedInputStream(
						// new FileInputStream(requestfile));
						BufferedInputStream finStr = new BufferedInputStream(
								new ByteArrayInputStream(Fserver.ftpMockMsg.getBytes()));
						
						PrintStream dout = null;
						dout = new PrintStream(dsocket.getOutputStream(),true);
						
						byte[] buf = new byte[1024];
						int l = 0;
						while ((l = finStr.read(buf, 0, 1024)) != -1) {
							dout.write(buf, 0, l);
						}
						finStr.close();
						dout.close();
						dsocket.close();
					}
					
					reply = "226 Transfer complete !";

				} catch (Exception e) {
					e.printStackTrace();
					reply = "451 Requested action aborted: local error in processing";
					return false;
				}

			} else if (type == FtpState.FTYPE_ASCII) {
				try {
					out.println("150 Opening ASCII mode data connection for "
							+ requestfile);
					dsocket = new Socket(remoteHost, remotePort, InetAddress
							.getLocalHost(), 20);
					BufferedReader fin = new BufferedReader(new FileReader(
							requestfile));
					PrintWriter dout = new PrintWriter(dsocket
							.getOutputStream(), true);
					String s;
					while ((s = fin.readLine()) != null) {
						dout.println(s);
					}
					fin.close();
					dout.close();
					dsocket.close();
					reply = "226 Transfer complete !";
				} catch (Exception e) {
					e.printStackTrace();
					reply = "451 Requested action aborted: local error in processing";
					return false;
				}
			}
		}
		return false;

	}// commandRETR() end

	boolean commandSTOR() {
		if (param.equals("")) {
			reply = "501 Syntax error in parameters or arguments";
			return false;
		}
		requestfile = addTail(dir) + param;
		if (type == FtpState.FTYPE_IMAGE) {
			try {
				out.println("150 Opening Binary mode data connection for "
						+ requestfile);
				dsocket = new Socket(remoteHost, remotePort, InetAddress
						.getLocalHost(), 20);
				BufferedOutputStream fout = new BufferedOutputStream(
						new FileOutputStream(requestfile));
				BufferedInputStream din = new BufferedInputStream(dsocket
						.getInputStream());
				byte[] buf = new byte[1024];
				int l = 0;
				while ((l = din.read(buf, 0, 1024)) != -1) {
					fout.write(buf, 0, l);
				}// while()
				din.close();
				fout.close();
				dsocket.close();
				reply = "226 Transfer complete !";
			} catch (Exception e) {
				e.printStackTrace();
				reply = "451 Requested action aborted: local error in processing";
				return false;
			}
		}
		if (type == FtpState.FTYPE_ASCII) {
			try {
				out.println("150 Opening ASCII mode data connection for "
						+ requestfile);
				dsocket = new Socket(remoteHost, remotePort, InetAddress
						.getLocalHost(), 20);
				PrintWriter fout = new PrintWriter(new FileOutputStream(
						requestfile));
				BufferedReader din = new BufferedReader(new InputStreamReader(
						dsocket.getInputStream()));
				String line;
				while ((line = din.readLine()) != null) {
					fout.println(line);
				}
				din.close();
				fout.close();
				dsocket.close();
				reply = " 226 Transfer complete !";
			} catch (Exception e) {
				e.printStackTrace();
				reply = "451 Requested action aborted: local error in processing";
				return false;
			}
		}
		return false;
	}// commandSTOR() end

	boolean commandPWD() {
		reply = "257 " + dir + " is current directory.";
		return false;
	}// commandPWD() end

	boolean commandNOOP() {
		reply = "200 OK.";
		return false;
	}// commandNOOP() end

	boolean commandABOR() {
		try {
			dsocket.close();
		} catch (Exception e) {
			e.printStackTrace();
			reply = "451 Requested action aborted: local error in processing";
			return false;
		}
		reply = "421 Service not available, closing control connection";
		return false;
	}// commandABOR() end

	boolean commandDELE() {
		int i = validatePath(param);
		if (i == 0) {
			reply = "550 Request action not taken";
			return false;
		}
		if (i == 1) {
			File f = new File(param);
			f.delete();
		}
		if (i == 2) {
			File f = new File(addTail(dir) + param);
			f.delete();
		}

		reply = "250 Request file action ok,complete";
		return false;

	}// commandDELE() end

	boolean commandMKD() {
		String s1 = param.toLowerCase();
		String s2 = rootdir.toLowerCase();
		if (s1.startsWith(s2)) {
			File f = new File(param);
			if (f.exists()) {
				reply = "550 Request action not taken";
				return false;
			} else {
				f.mkdirs();
				reply = "250 Request file action ok,complete";
			}
		} else {
			File f = new File(addTail(dir) + param);
			if (f.exists()) {
				reply = "550 Request action not taken";
				return false;
			} else {
				f.mkdirs();
				reply = "250 Request file action ok,complete";
			}
		}

		return false;
	}// commandMKD() end

	String addTail(String s) {
		if (!s.endsWith("/"))
			s = s + "/";
		return s;
	}

	public SFtpHandler(Socket s, int i) {
		csocket = s;
		id = i;
		remoteHost = s.getInetAddress().getHostAddress();
		remotePort = s.getPort();
	}

	public void run() {
		String str = "";
		int parseResult = -1;

		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					csocket.getInputStream()));
			out = new PrintWriter(csocket.getOutputStream(), true);
			state = FtpState.FS_WAIT_LOGIN;
			boolean finished = false;
			while (!finished) {
				str = in.readLine();
				if (str == null)
					finished = true;
				else {
					parseResult = parseInput(str);
					System.out.println("Command:" + cmd + " Parameter:" + param);
					System.out.print("->");
					switch (state) {
					case FtpState.FS_WAIT_LOGIN:
						finished = commandUSER();
						break;
					case FtpState.FS_WAIT_PASS:
						finished = commandPASS();
						break;
					case FtpState.FS_LOGIN: {
						switch (parseResult) {
						case -1:
							errCMD();
							break;
						case 4:
							finished = commandCDUP();
							break;
						case 6:
							finished = commandCWD();
							break;
						case 7:
							finished = commandQUIT();
							break;
						case 9:
							finished = commandPORT();
							break;
						case 27:
							finished = commandLIST();
							break;
						case 11:
							finished = commandTYPE();
							break;
						case 14:
							finished = commandRETR();
							break;
						case 15:
							finished = commandSTOR();
							break;
						case 26:
						case 33:
							finished = commandPWD();
							break;
						case 32:
							finished = commandNOOP();
							break;
						case 22:
							finished = commandABOR();
							break;
						case 23:
							finished = commandDELE();
							break;
						case 25:
							finished = commandMKD();
							break;
						case 10:
							finished = commandPASV();
							break;

						}// switch(parseResult) end
					}// case FtpState.FS_LOGIN: end
						break;

					}// switch(state) end
				} // else
				out.println(reply);
			} // while
			csocket.close();
		} // try
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class FileSenderThread extends Thread{
	private Socket _cs;
	ServerSocket _ss;
	String _msg;
	
	public FileSenderThread(ServerSocket ss, String msg){
		_ss = ss;
		_msg = msg;
	}
	public void run(){
		//Simply send the String content to the client!
		synchronized (this){
			try {
				_cs = _ss.accept();
				BufferedInputStream finStr = new BufferedInputStream(
						new ByteArrayInputStream(_msg.getBytes()));
				
				PrintStream dout = null;
				dout = new PrintStream(_cs.getOutputStream(),true);
				
				byte[] buf = new byte[1024];
				int l = 0;
				while ((l = finStr.read(buf, 0, 1024)) != -1) {
					dout.write(buf, 0, l);
				}
				finStr.close();
				dout.close();
				_cs.close();
				//Wake up!
				notify();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					_ss.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}

class FtpState {
	final static int FS_WAIT_LOGIN = 0;
	final static int FS_WAIT_PASS = 1;
	final static int FS_LOGIN = 2;
	final static int FTYPE_ASCII = 0;
	final static int FTYPE_IMAGE = 1;
	final static int FMODE_STREAM = 0;
	final static int FMODE_COMPRESSED = 1;
	final static int FSTRU_FILE = 0;
	final static int FSTRU_PAGE = 1;
}

class UserInfo {
	String user;
	String password;
	String workDir;
}

