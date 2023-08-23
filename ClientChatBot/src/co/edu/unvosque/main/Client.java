package co.edu.unvosque.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String SERVER_ADDRESS = "127.0.0.1";
		final int SERVER_PORT = 62850;

		try {
			Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				System.out.println("Elige una opción (1-20), o 21 para salir:");
				System.out.println("1. ¿Cual es mi nombre?");
				System.out.println("2. ¿Cuantos años tengo?");
				System.out.println("3. ¿Que me gusta jugar?");
				System.out.println("4. ¿Cual es mi jugador favorito?");
				System.out.println("5. ¿Cual es mi bebida favorita?");
				System.out.println("6. ¿Que comida rapida es mi favorita?");
				System.out.println("7. ¿Cual es mi deporte favorito?");
				System.out.println("8. ¿Cual es mi fruta favorita?");
				System.out.println("9. ¿Cual es mi animal favorito?");
				System.out.println("10. ¿Prefiero frio o calor?");
				System.out.println("11. ¿Android o IOs?");
				System.out.println("12. ¿Cuanto peso?");
				System.out.println("13. ¿Cuanto mido?");
				System.out.println("14. ¿AMD o Intel?");
				System.out.println("15. ¿Azul o verde?");
				System.out.println("16. ¿Helado de vainilla o chocolate?");
				System.out.println("17. ¿Valorant o fifa?");
				System.out.println("18. ¿Helio o Diego?");
				System.out.println("19. ¿Tablet o celular?");
				System.out.println("20. ¿Portatil o computador de escritorio?");
				int opcion = Integer.parseInt(br.readLine());
				out.println(opcion);

				if (opcion == 21) {
					System.out.println("Server cerrado");
					in.close();
					out.close();
					socket.close();
					break;
				}

				String respuesta = in.readLine();
				System.out.println("Respuesta del servidor: " + respuesta);
			}
			
			out.println("DISCONNECT");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
