package in360;

public class Ex6 {
	public static void main(String[] args) {
		System.out.println("1 € : ");
		int sum = 0;
		int n_2c = 0;
		int n_5c = 0;
		int n_10c = 0;
		

		while((n_2c != 50) && (n_5c != 20) && (n_10c != 10)){
			if(n_2c > 50) {
				n_2c = 0;
				
				if(n_5c >20) {
					n_5c=0;
					n_10c++;
				}
				else {
					n_5c++;
				}
			}
			else {
				n_2c++;
			}
			
			
			
			
			sum = n_2c * 2 + n_5c*5 + n_10c*10;
			if(sum == 100) {
				System.out.print("1€ = ");
				if(n_2c !=0) {
					System.out.print(n_2c + " X 2c");
				}
				if(n_5c != 0) {
					System.out.print(" + " + n_5c + " X 5c");
				}
				if(n_10c != 0) {
					System.out.print(" + " + n_10c + " X 10c");
				}
				
			}
		}
	}
}