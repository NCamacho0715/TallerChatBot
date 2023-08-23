package co.edu.unbosque.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

	public static void main(String[] args) {
		final int PORT = 62050;

		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			System.out.println("Servidor en espera de conexiones...");

			List<String> respuestas = new ArrayList<>();
			BufferedReader br = new BufferedReader(new FileReader("respuestas.txt"));
			String linea;
			while ((linea = br.readLine()) != null) {
				respuestas.add(linea);
			}
			br.close();

			while (true) {
				Socket clientSocket = serverSocket.accept();
				System.out.println("Cliente conectado: " + clientSocket);

				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

				String opcion = in.readLine();
				int opcionElegida = Integer.parseInt(opcion);
				String respuesta = respuestas.get(opcionElegida - 1);

				out.println(respuesta);

				in.close();
				out.close();
				clientSocket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
