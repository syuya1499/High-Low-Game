		public class Judge {
	public static String getResult(int card , int nextCard) {
		String result = null;
		if(card < nextCard) {
			result = "High";
		}else if(card > nextCard) {
			result = "Low";
		}else if(card == nextCard) {
			result = "drow";
		}
		return result;
	}
	public static String getResultText(String result , String select) {
		String resultText = "";
		if(select.equals(result)) {
			resultText = "おめでとう！正解だよ！！";
		}else if (result.equals("drow")) {
			resultText = "残念、今回はドローだね、、";
		}else {
			resultText = "間違いだ！ Game Over";
		}
		return resultText;
}
		}