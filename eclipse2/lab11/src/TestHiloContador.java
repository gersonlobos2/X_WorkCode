
public class TestHiloContador {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Contador cont=new Contador();
		Contador cont2=new Contador();
		cont2.setContador(1);
		
		//cont2.setContador(2);
		

		HiloContador hc1=new HiloContador("even",cont);
		HiloContador hc2=new HiloContador("odd",cont2);
		//HiloContador hc3=new HiloContador("sum");
		//HiloContador hc3=new HiloContador("HiloTres",cont);
		hc1.setPriority(1);
		hc2.setPriority(2);
		if(hc1.isAlive()==true)
		{
			try{
		hc1.wait();

			}catch(InterruptedException e){}
		}
		else
		{
		hc1.start();	
		
		}
		if(hc2.isAlive()==true)
		{
			try{
		hc2.wait();
			}catch(InterruptedException e){}
		}
		else
		{
			hc2.start();
		}
		//hc3.start();
		
	}

}
