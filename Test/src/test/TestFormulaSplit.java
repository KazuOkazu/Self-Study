package test;

import java.util.LinkedList;

public class TestFormulaSplit {
		public static void main(String args[]) {
			/*サンプル式*/
			LinkedList<String> test = new LinkedList<>();
			test.add("1");
			test.add("2");
			test.add("3");
			test.add("+");
			test.add("4");
			test.add("5");
			test.add("6");
			test.add("6");
			test.add("×");
			test.add("6");
			test.add("7");
			test.add("9");

			int x = 0;
			int last = 1;
			String element = null;
			System.out.println("サンプル式" + test);

			/*～式の分割～***************************************
			 * 条件:末尾がリストの最後を取得するまで続ける		*
			 *													*
			 * 1.数字を結合するために次のリストをelementに取得	*
			 * 2.!演算子を取得した場合!							*
			 * 			演算子の次の数字へいくためにxを追加		*
			 * 			同じく末尾もずらす						*
			 *													*
			 * 3.!数字の場合!									*
			 * 			リストを隣と結合し、置き換える			*
			 * 			結合した元の部分を削除					*
			 ***************************************************/
			test:while(last != test.size()) {

				element = test.get(last);

				if(element == "+"|| element == "-" || element =="÷" || element == "×") {
					x+=2;
		    		last+=2;
		    		continue test;
	    		}

				test.set(x,test.get(x)+ test.get(last));
				test.remove(last);

			}
			System.out.println("終了" + test);
			}
		}

