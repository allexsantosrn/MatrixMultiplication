package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManipulaArquivo {

	// L� o arquivo atrav�s do caminho informado e retorna uma matriz.
	public int[][] lerAquivo(String arquivo) {

		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {

			String[] dimMatrix = br.readLine().split(" ");

			int linhaMatriz = Integer.parseInt(dimMatrix[0]);
			int colunaMatriz = Integer.parseInt(dimMatrix[1]);

			int matriz[][] = new int[linhaMatriz][colunaMatriz];

			for (int linhaAtual = 0; linhaAtual < linhaMatriz; linhaAtual++) {

				String[] vect = br.readLine().split(" ");

				for (int colunaAtual = 0; colunaAtual < colunaMatriz; colunaAtual++) {

					matriz[linhaAtual][colunaAtual] = Integer.parseInt(vect[colunaAtual]);

				}

			}

			return matriz;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	// Recebe a matriz com o resultado da multiplica��o e a exporta para um arquivo
	// .txt.
	public void salvarArquivo(int C[][], int tamMatriz) {

		String tamanho = String.valueOf(tamMatriz);
		String conteudo = new String(tamanho + " " + tamanho + "\n");

		String path = new String("./resultados/C" + tamanho + "x" + tamanho + ".txt");

		for (int linhaAtual = 0; linhaAtual < tamMatriz; linhaAtual++) {

			for (int colunaAtual = 0; colunaAtual < tamMatriz; colunaAtual++) {
				conteudo += String.valueOf(C[linhaAtual][colunaAtual]) + " ";
			}
			conteudo += "\n";
		}

		FileWriter writer = null;

		try {
			writer = new FileWriter(path);
			writer.write(conteudo);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Cria o arquivo .txt com o tempo de execu��o.
	public void salvarTempo(long tempo, int tamMatriz) {

		String tamanho = String.valueOf(tamMatriz);
		String time = String.valueOf(tempo);
		
		String conteudo="";

		String path = new String("tempos/C" + tamanho + "x" + tamanho + ".txt");

		File file = new File(path);

		// Verifica se o arquivo existe para recuperar os tempos anteriores.
		if (file.exists()) {

			String vect[] = lerTempos(path);

			//time += " ";

			for (int i = 0; i < vect.length; i++) {
				conteudo += vect[i] + " ";
			}

		}
		
		conteudo += time;

		FileWriter writer = null;

		try {
			writer = new FileWriter(path);
			writer.write(conteudo);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String[] lerTempos(String arquivo) {

		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {

			String[] vect = br.readLine().split(" ");

			return vect;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
