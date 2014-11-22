package factory;

public class FactoryDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShoesFactory sf = new LeatherShoesFactory();
		makeShoes(sf);
		
		System.out.println();
		
		ShoesFactory sf2 = new SportShoesFactory();
		makeShoes(sf2);		

	}
	
	public static void makeShoes(ShoesFactory f) {
		System.out.println(f.makeShoesBody());
		System.out.println(f.makeShoesBottom());	
		System.out.println(f.makeShoesStrap());	
	}
}




class ShoesBody {
	
}

class ShoesBottom{
	
}

class ShoesStrap{
	
}

class SportShoesBody extends ShoesBody{
	
}

class SportShoesStrap extends ShoesStrap{
	
}

class SportShoesBottom extends ShoesBottom{
	
}

class LeatherShoesBody extends ShoesBody{
	
}

class LeatherShoesStrap extends ShoesStrap{
	
}

class LeatherShoesBottom extends ShoesBottom{
	
}



interface ShoesFactory {
	public ShoesBody makeShoesBody();
	public ShoesBottom makeShoesBottom();
	public ShoesStrap makeShoesStrap();
	
}

class SportShoesFactory implements ShoesFactory {

	@Override
	public ShoesBody makeShoesBody() {
		// TODO Auto-generated method stub
		return new SportShoesBody();
	}

	@Override
	public ShoesBottom makeShoesBottom() {
		// TODO Auto-generated method stub
		return new SportShoesBottom();
	}

	@Override
	public ShoesStrap makeShoesStrap() {
		// TODO Auto-generated method stub
		return new SportShoesStrap();
	}
	
}

class LeatherShoesFactory implements ShoesFactory {

	@Override
	public ShoesBody makeShoesBody() {
		// TODO Auto-generated method stub
		return new LeatherShoesBody();
	}

	@Override
	public ShoesBottom makeShoesBottom() {
		// TODO Auto-generated method stub
		return new LeatherShoesBottom();
	}

	@Override
	public ShoesStrap makeShoesStrap() {
		// TODO Auto-generated method stub
		return new LeatherShoesStrap();
	}	
}

