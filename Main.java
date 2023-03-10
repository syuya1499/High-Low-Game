import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

 class Main extends JFrame implements ActionListener{
	//表示されるカードを定義
	 int card = Card.getCard();
	 int nextCard = Card.getNextCard();
	 
	 ImageIcon gameIcon;
	 JPanel mainPanel;
	 JPanel gamePanel;
	 JButton highButton;
	 JButton lowButton;
	 JLabel gameHeaderLabel;
	 JLabel gameHeaderLabel2;
	 JLabel gameLeftCenterLabel;
	 JLabel gameRightCenterLabel;
	 CardLayout layout;
	 //カードの配列
	 String[] cards = {"1","2","3","4","5","6","7","8","9","10","11","12","13"};
	
	 public static void main(String args[]) {
		 Main frame = new Main("High&Low");
		    frame.setVisible(true);
		    
	}
	 Main(String title){
		setTitle(title);
		setBounds(100, 100, 950, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  //スタート画面（ルール説明画面）を作成
    //スタートパネル
	    JPanel startPanel = new JPanel();
	    startPanel.setLayout(new BorderLayout());
	    //ゲーム画面へのボタン作成
	    JButton gameButton = Button.ArialButton("ゲーム画面へ", 20, 50);
	    gameButton.addActionListener(this);
	    gameButton.setActionCommand("game");
	    //ヘッダーのラベルの作成
	    JLabel startHeaderLabel = Label.MSLabel("~2択の世界へようこそ~" , 30 , 50 , 100);
	    //ルール説明の追加
	    JPanel textPanel = new JPanel();
	    JTextField text1 = TextField.makeText("ルール" , Color.YELLOW);
	    JTextField text2 = TextField.makeText("画面に表示されているカードを確認しよう！" );
	    JTextField text3 = TextField.makeText("次に引くカードが確認したカードより数字が大きいと思えばHigh、低いと思えばLowを選択してねっ" );
	    JTextField text4 = TextField.makeText("間違えればGame Over!!" );
	    JTextField text5 = TextField.makeText("さっそくチャレンジしてみよう！" );

	    //トランプの画像の貼り付け（ルール説明の下）
	    ImageIcon leftIcon = new ImageIcon("leftTranp.png");
	    ImageIcon rightIcon = new ImageIcon("rightTranp.png");
	    JLabel leftLabel = new JLabel(leftIcon);
	    JLabel rightLabel = new JLabel(rightIcon);
	    leftLabel.setPreferredSize(new Dimension(200,120));
	    rightLabel.setPreferredSize(new Dimension(200,120));
	    //パネルにルール文と画像を追加
	    textPanel.add(text1);
	    textPanel.add(text2);
	    textPanel.add(text3);
	    textPanel.add(text4);
	    textPanel.add(text5);
	    textPanel.add(leftLabel);
	    textPanel.add(rightLabel);
	    //パネルにボタン・ラベル・テキスト・画像を追加
	    startPanel.add(gameButton , BorderLayout.SOUTH);
	    startPanel.add(startHeaderLabel , BorderLayout.NORTH);
	    startPanel.add(textPanel , BorderLayout.CENTER);

  //ゲーム画面を作成
    //ゲームパネル（全体）
	    gamePanel = new JPanel();
	    //ヘッダー部分
	    JPanel gameHeaderPanel = new JPanel();
	    JPanel buttonPanel = new JPanel();
	    gameHeaderLabel2 = Label.ArialLabel("" , Color.BLACK);
	    gameHeaderLabel = Label.ArialLabel("" , Color.MAGENTA);
	    //それぞれのパネルのレイアウトを設定
	    gamePanel.setLayout(new BorderLayout());
	    gameHeaderPanel.setLayout(new GridLayout ());
	    buttonPanel.setLayout(new GridLayout());
	    //スタートボタンの作成とパネルに追加
	    JButton startButton = Button.ArialButton("スタート画面へ戻る", 20, 50);
	    startButton.addActionListener(this);
	    startButton.setActionCommand("start");
	    gameHeaderPanel.add(startButton);
	    //ヘッダー部分にラベルを追加
	    gameHeaderPanel.add(gameHeaderLabel);
	    gameHeaderPanel.add(gameHeaderLabel2);
	    //HighとLowのボタンの作成
	    highButton = Button.MSButton("High", 300, 80, 24);
	    highButton.addActionListener(this);
	    highButton.setActionCommand("High");
	    lowButton = Button.MSButton("Low" , 300 , 80 , 24);
	    lowButton.addActionListener(this);
	    lowButton.setActionCommand("Low");
	    //パネルにそれぞれのボタンを追加
	    buttonPanel.add(highButton);
	    buttonPanel.add(lowButton);
	    //センターパネルの作成
	    JPanel gameCenterPanel = new JPanel();
	    gameCenterPanel.setLayout(new BorderLayout());
	    //センターラベルの作成
	    gameLeftCenterLabel = new JLabel();
	    gameRightCenterLabel = new JLabel();
	    gameLeftCenterLabel.setPreferredSize(new Dimension(500,500));
	    gameRightCenterLabel.setPreferredSize(new Dimension(500,500));
	    gameLeftCenterLabel.setHorizontalAlignment(JLabel.CENTER);
	    gameRightCenterLabel.setHorizontalAlignment(JLabel.CENTER);
	    //センターパネルに画像の入ったラベルを追加
	    gameCenterPanel.add(gameRightCenterLabel , BorderLayout.EAST);
	    gameCenterPanel.add(gameLeftCenterLabel , BorderLayout.WEST);
	    //ゲームパネル（全体）にそれぞれ追加
	    gamePanel.add(buttonPanel , BorderLayout.SOUTH);
	    gamePanel.add(gameCenterPanel , BorderLayout.CENTER);
	    gamePanel.add(gameHeaderPanel , BorderLayout.NORTH);

	    mainPanel = new JPanel();
	    layout = new CardLayout();
	    mainPanel.setLayout(layout);
	    mainPanel.add(startPanel , "start");
	    mainPanel.add(gamePanel, "game");
	    getContentPane().add(mainPanel , BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
	   //ゲーム画面に移動した際にleftTranpを表示
	    if(card == 1) {
	    	gameIcon = new ImageIcon("one.png");
	    }else if(card == 2) {
	    	gameIcon = new ImageIcon("two.png");
	    }else if(card == 3) {
	    	gameIcon = new ImageIcon("three.png");
	    }else if(card == 4) {
	    	gameIcon = new ImageIcon("four.png");
	    }else if(card == 5) {
	    	gameIcon = new ImageIcon("five.png");
	    }else if(card == 6) {
	    	gameIcon = new ImageIcon("six.png");
	    }else if(card == 7) {
	    	gameIcon = new ImageIcon("seven.png");
	    }else if(card == 8) {
	    	gameIcon = new ImageIcon("eight.png");
	    }else if(card == 9) {
	    	gameIcon = new ImageIcon("nine.png");
	    }else if(card == 10) {
	    	gameIcon = new ImageIcon("ten.png");
	    }else if(card == 11) {
	    	gameIcon = new ImageIcon("eleven.png");
	    }else if(card == 12) {
	    	gameIcon = new ImageIcon("twelve.png");
	    }else if(card == 13) {
	    	gameIcon = new ImageIcon("thirteen.png");
	    }
	    //gameIcon（leftTranp）をラベルい追加
	    gameLeftCenterLabel.setIcon(gameIcon);
		//4個の各ボタンが押された時の処理内容
		if(cmd.equals("start")) {
			layout.show(mainPanel, cmd);
		}else if(cmd.equals("game")) {
			layout.show(mainPanel, cmd);
		}else if(cmd.equals("High") || cmd.equals("Low")) {
			if(nextCard == 1) {
		    	gameIcon = new ImageIcon("one.png");
		    }else if(nextCard == 2) {
		    	gameIcon = new ImageIcon("two.png");
		    }else if(nextCard == 3) {
		    	gameIcon = new ImageIcon("three.png");
		    }else if(nextCard == 4) {
		    	gameIcon = new ImageIcon("four.png");
		    }else if(nextCard == 5) {
		    	gameIcon = new ImageIcon("five.png");
		    }else if(nextCard == 6) {
		    	gameIcon = new ImageIcon("six.png");
		    }else if(nextCard == 7) {
		    	gameIcon = new ImageIcon("seven.png");
		    }else if(nextCard == 8) {
		    	gameIcon = new ImageIcon("eight.png");
		    }else if(nextCard == 9) {
		    	gameIcon = new ImageIcon("nine.png");
		    }else if(nextCard == 10) {
		    	gameIcon = new ImageIcon("ten.png");
		    }else if(nextCard == 11) {
		    	gameIcon = new ImageIcon("eleven.png");
		    }else if(nextCard == 12) {
		    	gameIcon = new ImageIcon("twelve.png");
		    }else if(nextCard == 13) {
		    	gameIcon = new ImageIcon("thirteen.png");
		    }
		    gameRightCenterLabel.setIcon(gameIcon);
		    String textLabel = "引いたカードは" + String.valueOf(nextCard) + "だよ";
		    gameHeaderLabel2.setText(textLabel);
		    highButton.setEnabled(false);
		    lowButton.setEnabled(false);
		}
		//選択したボタンを区別させる
		String select = null;
		if(cmd.equals("High")) {
			select = "High";
		}else if(cmd.equals("Low")) {
			select = "Low";
		}
		//現在のカードと次のカードと比べて実際の答えがHighかLowかをresultに追加している。
		String result = Judge.getResult(card , nextCard);
		//実際に選んだ選択と答えがあってるか比べて、ラベルに追加している。
		String resultText = Judge.getResultText(result, select);
		gameHeaderLabel.setText(resultText);
	}
 }
 
