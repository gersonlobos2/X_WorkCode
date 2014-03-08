
public class HiloContador extends Thread {
	Contador contador;

	public HiloContador(String name, Contador contador) {
		super(name);
		this.contador = contador;
	}
	public void run(){
		try{
		for(int i=1;i<=6;i++)
		{
			int valorContador;
			synchronized (contador) {
				valorContador = contador.getContador();
				Thread.sleep(1);
				contador.setContador(2);
				
			}
			//System.out.print(getName()+"pone el contador a "+valorContador);
			//System.out.print(valorContador+",");
			System.out.println(getName()+" pone el contador a "+valorContador);
		}
		}catch(InterruptedException e){   }
		
	
	}
}
