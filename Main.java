import java.util.Random;

public class Main {

	public static void main(String[] args) {   
		int pontos []= new int [20000];
		Random random = new Random();
		pontos[0]=-1;
		for (int i = 1; i<pontos.length ; i++)
			pontos[i] = 1;
		
	    int matrizCusto[][] = new int [20000][20000];   
	    for (int i=0;i<matrizCusto.length;i++){
	    	for (int j=0;j<matrizCusto.length;j++){  
	    		if (i==j)
	    			matrizCusto[i][j] = 20001;
	    		else
	    			matrizCusto[i][j] = random.nextInt(19999)+1;
	    		
	    	}
	    }
	    
	    
	
	    
	    int comeco = 0;
	    int custoViagem = 0;
	    int caminhos = 0;
	    int proximoPonto=0; 
	    long inicio = System.currentTimeMillis();
	    while (caminhos<matrizCusto.length-1) {
	    	int escolhido = 101;
	    	for (int j = 0; j<matrizCusto.length; j++) {
	    		if (matrizCusto[comeco][j]< escolhido && pontos[j] != -1) {
	    			escolhido = matrizCusto[comeco][j];
	    			proximoPonto = j;
	    		}
	    	}
	    	//System.out.println("Ponto "+ comeco+ " Para o ponto "+ proximoPonto);
	    	//Apenas para conferir que não há repetição de ponto
	    	pontos[proximoPonto] = -1;
	    	comeco = proximoPonto;
	    	custoViagem += escolhido;
	    	caminhos++;
	    }

	    long fim = System.currentTimeMillis();
	    System.out.println("Tempo transcorrido: "+ (fim-inicio));
		System.out.println("O Custo da viagem por todos os pontos foi de "+ custoViagem);
	}

}
