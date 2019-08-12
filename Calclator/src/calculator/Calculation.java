package calculator;

import java.util.LinkedList;

import javafx.stage.Stage;

public  class Calculation {
	String[] test = new String[10];
	Stage substage = new Stage();
//演算子に優先度をつける？
	public  void FormulaSplit(LinkedList<String> formula) {

		String element;
		for(int count = 0;count < formula.size();count++) {

			element = formula.get(count);

			if(element == "＋"|| element == "-" || element =="÷" || element == "×") {

				System.out.println("始め" + test);
	    		final int size = formula.size()-1;
	    		System.out.println("サイズ:" + size);
	    		int x = 0;
	    		int test = 1;
	    		int last = 1;
	    		while(x < count) {
	    			formula.set(x,formula.get(x)+ formula.get(last));
	    			formula.remove(last);
	    			System.out.println( count + "回目追加後" + test);
	    			x++;
	    		}

	    		System.out.println("終了" + test);
	    		return;
			}
		}



	}
	public void FormulaCalculation() {

	}
}
