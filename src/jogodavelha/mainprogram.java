package jogodavelha;

import java.util.Scanner;

public class mainprogram {
	public static void print(char[] data) {
		int i = 0;
		for(char c : data) {
			if(i == 0) {
				System.out.print(c);
			}
			if(i == 1) {
				System.out.print(" | " + c + " | ");
			}
			if(i == 2) {
				System.out.print(c + "\r");
			}
			
			i++;
			if(i == 3) i = 0;
			}
		System.out.println();
	}
	public static void gravarEscolha(Integer posicao, boolean isXturn, char[]data) {
		posicao--;
			if(isXturn) {
				data[posicao] = 'X';			
			} else {
				data[posicao] = 'O';	
			}
	}
	public static boolean validarEscolha(Integer posicao, char[]data) {
		posicao--;
		if(data[posicao] != 'X' && data[posicao] != 'O' ) return true;
		System.out.println("Posição já preenchida!");
		return false;
	}
	public static boolean validarGanhador(char[] data) {
		for(int i = 0; i < data.length; i++) {
			//checa se há 3 seguidos diagonalmente
			if(i == 4) {
				if(data[i] == data[i-4] && data[i] == data[i+4]
						||
					data[i] == data[i-2] && data[i] == data[i+2]) {
					return true;
				}
			}
			//checa se há 3 seguidos verticalmente
			if(i < 3) {
				if(data[i] == data[i+3] && data[i] == data[i+6]) {
					return true;
				}
			}
			//checa se há 3 seguidos horizontalmente
			if(i % 3 == 0 || i == 0) {
				if(data[i] == data[i+1] && data[i] == data[i+2]) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		char[] data = {'1','2','3','4','5','6','7','8','9'};
		boolean isXturn = true;
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		boolean isThereWinner = false;
		
		while(isThereWinner == false) {
			System.out.println("Escolha sua posição!");
			print(data);
			
			Integer posicao = scanner.nextInt();
			if(validarEscolha(posicao,data)){
				gravarEscolha(posicao, isXturn, data);
				isXturn = !isXturn;
			}
			
			isThereWinner = validarGanhador(data);
			if(isThereWinner) {
				Character ganhador = null;
				if(!isXturn) {
					ganhador = 'X';
				} else ganhador = 'O';
				print(data);
				System.out.println("Vencedor Jogador : " + ganhador + " !");
			}
		}
		
	}
}
