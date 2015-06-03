package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionHandler implements Runnable {

    private Socket connection;
    private BufferedReader in;
    private BufferedWriter out;

    public ConnectionHandler(Socket socket) {
        try {
            connection = socket;
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
        } catch (IOException ex) {
            Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (this) {
                    if (connection.isConnected()) {
                        System.out.println(in.readLine());
                        out.write("+---------------------------------------------------------------------------------------------------------------------+\r\n" +
"|                                                                                                                     |\r\n" +
"|               ,ggg,      gg      ,gg                                                                                |\r\n" +
"|              dP\"\"Y8a     88     ,8P        ,dPYb,                                                                   |\r\n" +
"|              Yb, `88     88     d8'        IP'`Yb                                                                   |\r\n" +
"|               `\"  88     88     88         I8  8I                                                                   |\r\n" +
"|                   88     88     88         I8  8'                                                                   |\r\n" +
"|                   88     88     88 ,ggg,   I8 dP    ,gggg,    ,ggggg,    ,ggg,,ggg,,ggg,    ,ggg,                   |\r\n" +
"|                   88     88     88i8\" \"8i  I8dP    dP\"  \"Yb  dP\"  \"Y8ggg,8\" \"8P\" \"8P\" \"8,  i8\" \"8i                  |\r\n" +
"|                   Y8    ,88,    8PI8, ,8I  I8P    i8'       i8'    ,8I  I8   8I   8I   8I  I8, ,8I                  |\r\n" +
"|                    Yb,,d8\"\"8b,,dP `YbadP' ,d8b,_ ,d8,_    _,d8,   ,d8' ,dP   8I   8I   Yb, `YbadP'                  |\r\n" +
"|                     \"88\"    \"88\" 888P\"Y8888P'\"Y88P\"\"Y8888PPP\"Y8888P\"   8P'   8I   8I   `Y8888P\"Y888                 |\r\n" +
"|                                                                                                                     |\r\n" +
"|                                                                                                                     |\r\n" +
"|                                                        _/_                                                          |\r\n" +
"|                                                        /  __                                                        |\r\n" +
"|                                                       (__(_)                                                        |\r\n" +
"|                                                                                                                     |\r\n" +
"|                                                                                                                     |\r\n" +
"|       ##### ##        ##### ##         ##### #             ##### ##            ##             #####   ##    ##      |\r\n" +
"|     ######  ###     ######  #### #   ######  #           ######  ###         #####          ######  ##### #####     |\r\n" +
"|    ##   #  # ##    ##   #  # ####   ##   #  #          ##    #  # ###       #  ###         ##   #  #  ##### #####   |\r\n" +
"|   #    #  #  ##   #    #  #   ##   #    #  #          #     #  #   ###         ###        #    #  #   # ##  # ##    |\r\n" +
"|       #  #   #        #  #             #  #                #  #     ###       #  ##           #  #    #     #       |\r\n" +
"|      ## ##  #        ## ##            ## ##               ## ##      ##       #  ##          ## ##    #     #       |\r\n" +
"|      ## ## #         ## ##            ## ##               ## ##      ##      #    ##         ## ##    #     #       |\r\n" +
"|      ## ###          ## ######        ## ##               ## ##      ##      #    ##         ## ##    #     #       |\r\n" +
"|      ## ## ###       ## #####         ## ##               ## ##      ##     #      ##        ## ##    #     #       |\r\n" +
"|      ## ##   ###     ## ##            ## ##               ## ##      ##     #########        ## ##    #     ##      |\r\n" +
"|      #  ##     ##    #  ##            #  ##               #  ##      ##    #        ##       #  ##    #     ##      |\r\n" +
"|         #      ##       #                #                   #       #     #        ##          #     #      ##     |\r\n" +
"|     ####     ###    ####         #   ####           #   #####       #     #####      ##     ####      #      ##     |\r\n" +
"|       ########        ###########      #############       #########     #   ####    ## #     #####           ##    |\r\n" +
"|                                                                                                                     |\r\n" +
"|    B E L D A M     E x t e r m i n a t i n g     L e g e n d a r y     D r a g o n s     A c r o s s     M U D s    |\r\n" +
"|                                                                                                                     |\r\n" +
"+---------------------------------------------------------------------------------------------------------------------+");
                        out.flush();
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
                out.close();
                connection.close();
            } catch (IOException ex) {
                Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
