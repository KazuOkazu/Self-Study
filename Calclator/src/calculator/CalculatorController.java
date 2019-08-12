package calculator;

import java.util.LinkedList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CalculatorController{

	Stage substage = new Stage();

/*---------------------------------------------------------------------------------------------------------------*/

	/************************************************
	 * 【Button～】電卓の数字のボタン				*
	 * 												*
	 * 【Addition】加算								*
	 * 												*
	 * 【Subtraction】減算							*
	 * 												*
	 * 【Multiplication】乗算						*
	 * 												*
	 * 【Division】除算								*
	 * 												*
	 * 【CalculationField】式を表示するフィールド	*
	 * 												*
	 * 【AllClear】オールクリアボタン				*
	 * 												*
	 * 【Calculation】計算ボタン					*
	 ***********************************************/

	@FXML
    	private Button Button0;
	@FXML
    	private Button Button1;
	@FXML
    	private Button Button2;
	@FXML
    	private Button Button3;
	@FXML
    	private Button Button4;
	@FXML
    	private Button Button5;
	@FXML
    	private Button Button6;
	@FXML
    	private Button Button7;
	@FXML
    	private Button Button8;
	@FXML
		private Button Button9;
	@FXML
    	private TextField CalculationField;
	@FXML
    	private Button AllClear;
	@FXML
    	private Button Calculation;
	@FXML
	    private Button Multiplication;
	@FXML
	    private Button Addition;
	@FXML
	    private Button Subtraction;
	@FXML
    	private Button Division;

/*---------------------------------------------------------------------------------------------------------------*/

	/************************************************
	 * 【operator】	 		演算子フラグ			*
	 * 												*
	 * 【calculated】		計算完了フラグ			*
	 *												*
	 * 【formula】	 		式リスト				*
	 * 												*
	 * 【OperatorBackup】	直前の式のバックアップ	*
	 * 												*
	 * 【calculation】		計算インスタンス		*
	 ***********************************************/

	boolean operator = false;
	boolean calculated = false;

	static LinkedList<String> formula = new LinkedList<String>();

	Calculation calculation = new Calculation();

	String OperatorBackup;

/*---------------------------------------------------------------------------------------------------------------*/
	/*ボタンの判定*/

	@FXML
    void ButtonOnClicked(ActionEvent click) {


		Button ButtonActionGetting = (Button)click.getSource();
		String ButtonAction = ButtonActionGetting.getId().toString();

		switch(ButtonAction) {

		/*～演算子ボタンの場合～*************
		 * ①直前に演算子が入っているか判定	*
		 * ②判定により処理を分岐			*
		 ***********************************/

		case "+":
		case "-":
		case "÷":
		case "×":

		/*～入っている場合～*********************************************
		 * ①式リストの演算子を入れ替え									*
		 * ②バックアップから直前の式を取得し、演算子を書き換えて表示	*
		 ***************************************************************/

		if(operator == true) {
			formula.removeLast();
			formula.add(ButtonAction);
			CalculationField.setText(OperatorBackup + ButtonAction);
		}

		/*～入っていない場合～*******************
		 * ①式リストに追加						*
		 * ②直前の式をバックアップ			 	*
		 * ③テキストフィールドに演算子を追加	*
		 * ④演算子フラグをtrueにする			*
		 * 										*
		 * ※バックアップは演算子が入ったとき	*
		 * のみとる								*
		 ***************************************/

		else {
			formula.add(ButtonAction);
			OperatorBackup = CalculationField.getText();
			CalculationField.setText(CalculationField.getText() + ButtonAction);
			operator = true;
		}
		break;

		/*～ACボタンの場合～*************
		 * ①式リストを初期化		   	*
		 * ②テキストフィールドを初期化	*
		 * ******************************/

		case "AllClear":
			formula.clear();
			CalculationField.setText("");
			break;

		/*～計算ボタンの場合～*/

		case  "Calculation":
			calculation.FormulaSplit(formula);

		/*～数字ボタンの場合～***************
		 * ①式リストに追加					*
		 * ②テキストフィールドに数字を追加	*
		 * ③演算子フラグをfalseにする		*
		 ***********************************/

		default:
			formula.add(ButtonAction);
			CalculationField.setText(CalculationField.getText() + ButtonAction);
			operator = false;
			System.out.println(formula.size());
			break;
		}



    }

    @FXML
    void SetFigure(ActionEvent event) {

    }

	}

