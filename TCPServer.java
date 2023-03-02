/* 
 *  Sebastian Rodriguez
 *  Assignment 2 - TCPServer
 *  CSC 4220
 */

import java.io.*;
import java.net.*;

class TCPServer {
    public static void main(String argv[]) throws Exception {
        String clientSentence;
        String reversedString; 
        ServerSocket welcomeSocket = new ServerSocket(6789);

        while(true) {
            StringBuilder sb = new StringBuilder();
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader
            (new InputStreamReader(connectionSocket.getInputStream()));

            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            clientSentence = inFromClient.readLine();
            sb.append(clientSentence);
            sb.reverse();
            reversedString = sb.toString();
            outToClient.writeBytes(reversedString + "\n");
        }
    }
}
