import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Die Klasse definiert einen TCP-Server, der in einer Endlosschleife
 * mehrere Verbindungen akzeptiert und alle Zeichen, die er darüber
 * empfängt, gleich wieder zurückschickt.
 */
class TCPMultiServer
{
    static void echo(final int port) throws IOException
    {
        try (final ServerSocket server = new ServerSocket()) {
            server.bind(new InetSocketAddress(port));
            while (true) {
                final Socket acceptedSocket = server.accept();
                new Thread(() -> {
                    try (final Socket socket = acceptedSocket) {
                        final InputStream in = socket.getInputStream();
                        final OutputStream out = socket.getOutputStream();
                        int c;
                        while ((c = in.read()) != -1) {
                            System.out.write((byte) c);
                            out.write((byte) c);
                        }
                    }
                    catch (final IOException e) {
                        System.err.println(e.getMessage());
                    }
                }).start();
            }
        }
    }
}
