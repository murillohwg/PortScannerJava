import java.net.Socket;

public class PortScanner {
    public static void main(String[] args) {
        
        if (args.length != 1) {
            System.out.println("Uso: java PortScanner <host>");
            return;
        }

        String host = args[0]; 

      
        int portaInicial = 1;
        int portaFinal = 1024;

        System.out.println("🔎 Iniciando varredura em " + host + " de " + portaInicial + " até " + portaFinal + "...\n");

        for (int porta = portaInicial; porta <= portaFinal; porta++) {
            try {
                Socket socket = new Socket(host, porta);
                System.out.println("✅ Porta " + porta + " está ABERTA");
                socket.close();
            } catch (Exception e) {
                System.out.println("❌ Porta " + porta + " está FECHADA");
            }
        }

        System.out.println("\n✅ Varredura concluída!");
    }
}
