package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class ManageGoodsGUI extends JPanel{
	static private PrintWriter  stdErr = new  PrintWriter(System.err, true);
	
	static private int WIDTH = 600;

	/* Window height in pixels */
	static private int HEIGHT = 530;

	/* Size of the catalog list cell in pixels */
	static private int BOXLIST_CELL_SIZE = 50;

	/* Visible rows in catalog list */
	static private int BOXLIST_LIST_ROWS = 14;

	/* Size of the order list cell in pixels */
	static private int GOODLIST_CELL_SIZE = 100;

	/* Visible rows in order list */
	static private int GOODLIST_LIST_ROWS = 6;

	/* Size quantity text field */
	static private int USERNAME__TEXTFIELD_SIZE = 10;

	/* Size total text field */
	static private int USERCODE__TEXTFIELD_SIZE = 10;

	static private int INPUT__TEXTFIELD_SIZE = 40;
	/* Rows in status text area rows */
	static private int STATUS_ROWS = 10;

	/* Rows in status text area cols */
	static private int STATUS_COLS = 40;
	
	//菜单
	private JList myboxList;
	private JList goodList;
	//按钮
	private JButton registerButton;
	private JButton addGoodButton;
	private JButton clothRecommendButton;
	private JButton travelRecommendButton;
	private JButton foodRemindButton;
	private JButton shoppingRecommendButton;
	private JButton okButton;
	//面板
	private JPanel registerPanel;
	private JPanel userInformationPanel;
	private JPanel goodInformationPanel;
	private JPanel goodsPanel;
	//标签
	private JLabel registerLabel;
	private JLabel userNameLabel;
	private JLabel myuserNameLabel;
	private JLabel userCodeLabel;
	private JLabel inputLabel;
	private JLabel ageLabel;
	private JLabel sexLabel;
	private JLabel heightLabel;
	private JLabel weightLabel;
	//文本框，输入框
	private JTextField userNameTextField;
	private JTextField nowuserNameTextField;
	private JTextField userCodeTextField;
	private JTextField inputTextField;
	private JTextField ageTextField;
	private JTextField sexTextField;
	private JTextField heightTextField;
	private JTextField weightTextField;
	//文本区
	private JTextArea statusTextArea;
	
	private JFileChooser  fileChooser;

	private Catalog  catalog;
	private ClothRecommend clothRecommend;
	private TravelRecommend travelRecommend;
	private FoodRemind foodRemind;
	private ShoppingRecommend shoppingRecommend;
	private User user;
	private BoxList boxList;
	
	public void displayGUI() {
		JFrame frame = new JFrame("Manage Good");

		frame.setContentPane(new ManageGoodsGUI(boxList,user));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(true);
		frame.setVisible(true);
	}
	
	public ManageGoodsGUI(BoxList newboxList,User newuser) {
		
		myboxList = new JList();
		goodList = new JList();
		myboxList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		myboxList.setVisibleRowCount(BOXLIST_LIST_ROWS);
		myboxList.setFixedCellWidth(BOXLIST_CELL_SIZE);
		
		goodList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		goodList.setVisibleRowCount(GOODLIST_LIST_ROWS);
		goodList.setFixedCellWidth(GOODLIST_CELL_SIZE);
		
		registerButton = new JButton("登录");
		addGoodButton = new JButton("添加物品");
		clothRecommendButton = new JButton("今日穿搭推荐");
		travelRecommendButton = new JButton("今日出行推荐");
		foodRemindButton = new JButton("食品过期提醒");
		shoppingRecommendButton = new JButton("购物建议");
		okButton = new JButton("确定");
		
		registerLabel = new JLabel("登录");
		userNameLabel = new JLabel("用户名：");
		myuserNameLabel = new JLabel("用户名：");
		userCodeLabel = new JLabel("密码：");
		inputLabel = new JLabel("输入框：");
		ageLabel = new JLabel("年龄");
		sexLabel = new JLabel("性别");
		heightLabel = new JLabel("身高");
		weightLabel = new JLabel("体重");
		
		userNameTextField = new JTextField("", USERNAME__TEXTFIELD_SIZE);
		userCodeTextField = new JTextField("", USERCODE__TEXTFIELD_SIZE);
		inputTextField = new JTextField("", INPUT__TEXTFIELD_SIZE);
		ageTextField = new JTextField("", USERNAME__TEXTFIELD_SIZE);
		sexTextField = new JTextField("", USERNAME__TEXTFIELD_SIZE);
		heightTextField = new JTextField("", USERNAME__TEXTFIELD_SIZE);
		weightTextField = new JTextField("", USERNAME__TEXTFIELD_SIZE);
		nowuserNameTextField = new JTextField("", USERNAME__TEXTFIELD_SIZE);
		
		statusTextArea = new JTextArea(STATUS_ROWS, STATUS_COLS);
		statusTextArea.setEditable(false);
		
		//登录界面
		registerPanel = new JPanel(new GridLayout(4,1));
		registerPanel.setBorder(
				BorderFactory.createTitledBorder("登录"));
		JPanel userNamePanel = new JPanel(new GridLayout(1,2));
		userNamePanel.add(userNameLabel);
		userNamePanel.add(userNameTextField);
		JPanel userCodePanel = new JPanel(new GridLayout(1,2));
		userCodePanel.add(userCodeLabel);
		userCodePanel.add(userCodeTextField);
		registerPanel.add(registerLabel);
		registerPanel.add(userNamePanel);
		registerPanel.add(userCodePanel);
		registerPanel.add(registerButton);
		
		//用户界面
		userInformationPanel = new JPanel(new GridLayout(5,1));
		userInformationPanel.setBorder(
				BorderFactory.createTitledBorder("我的信息"));
		JPanel nowuserNamePanel = new JPanel(new GridLayout(1,2));
		JPanel useragePanel = new JPanel(new GridLayout(1,2));
		JPanel usersexPanel = new JPanel(new GridLayout(1,2));
		JPanel userheightPanel = new JPanel(new GridLayout(1,2));
		JPanel userweightPanel = new JPanel(new GridLayout(1,2));
		nowuserNamePanel.add(myuserNameLabel);
		nowuserNamePanel.add(nowuserNameTextField);
		useragePanel.add(ageLabel);
		useragePanel.add(ageTextField);
		usersexPanel.add(sexLabel);
		usersexPanel.add(sexTextField);
		userheightPanel.add(heightLabel);
		userheightPanel.add(heightTextField);
		userweightPanel.add(weightLabel);
		userweightPanel.add(weightTextField);
		userInformationPanel.add(nowuserNamePanel);
		userInformationPanel.add(useragePanel);
		userInformationPanel.add(usersexPanel);
		userInformationPanel.add(userweightPanel);
		userInformationPanel.add(userheightPanel);
		
		//用户界面
		JPanel userPanel = new JPanel(new GridLayout(2,1));
		userPanel.add(registerPanel);
		userPanel.add(userInformationPanel);
		
		
		//物品信息
		goodsPanel = new JPanel(new BorderLayout());
		goodsPanel.setBorder(BorderFactory.createTitledBorder("物品展示"));
		goodsPanel.add (
			new JScrollPane(goodList,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER),BorderLayout.CENTER);
		goodsPanel.add(addGoodButton,BorderLayout.SOUTH);
		
		//箱子列表
		JPanel boxListPanel = new JPanel();
		boxListPanel.setBorder(BorderFactory.createTitledBorder("我的箱子"));
		boxListPanel.add (
			new JScrollPane(myboxList,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
		
		//我的箱子
		JPanel myBoxListPanel = new JPanel(new BorderLayout());
		myBoxListPanel.add(boxListPanel,BorderLayout.WEST);
		myBoxListPanel.add(goodsPanel,BorderLayout.EAST);
		
		//物品详情信息
		goodInformationPanel = new JPanel();
		goodInformationPanel.setBorder(
				BorderFactory.createTitledBorder("物品详情"));
		
		//推荐类
		JPanel recommendPanel = new JPanel(new GridLayout(4,1));
		recommendPanel.add(clothRecommendButton);
		recommendPanel.add(travelRecommendButton);
		recommendPanel.add(foodRemindButton);
		recommendPanel.add(shoppingRecommendButton);
		
		
		//输入信息
		JPanel statusPanel = new JPanel(new BorderLayout());
		JPanel inputPanel = new JPanel(new GridLayout(1,2));
		inputPanel.add(inputLabel);
		inputPanel.add(inputTextField);
		statusPanel.add(inputPanel,BorderLayout.NORTH);
		statusPanel.add(statusTextArea,BorderLayout.CENTER);
		
		//下面的块
		JPanel bottomPanel = new JPanel(new BorderLayout());
		bottomPanel.add(recommendPanel);
		bottomPanel.add(statusPanel);
		
		//安排布局
		setLayout(new BorderLayout());
		add(userPanel, BorderLayout.WEST);
		add(myBoxListPanel, BorderLayout.CENTER);
		add(goodInformationPanel, BorderLayout.EAST);
		add(bottomPanel, BorderLayout.SOUTH);
		
		//监听事件
		//myboxList.addListSelectionListener(new DisplayBoxListener());
		goodList.addListSelectionListener(new DisplayGoodListener());
		addGoodButton.addActionListener(new AddGoodListener());
		//registerButton.addActionListener(new RegisterListener());
		//clothRecommendButton.addActionListener(new ClothRecommendListener());
		//travelRecommendButton.addActionListener(new TravelRecommendListener());
		//foodRemindButton.addActionListener(new GoodRemindListener());
		//shoppingRecommendButton.addActionListener(new ShoppingRecommendListener());
		//okButton.addActionListener(new OkListener());
		
		boxList = newboxList;
		myboxList.setListData(boxList.getNames());
		user = newuser;
	}
	
	class DisplayGoodListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent event) {
			
			if (! myboxList.getValueIsAdjusting()) {
				String name = (String) myboxList.getSelectedValue();
				Box box = boxList.getBox(name);
				
				goodList.setListData(box.getGoods());
				statusTextArea.setText(name + " 中的物品已经显示");
			}
		}
	}
	
	/*
	class RegisterListener() implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
		}
	}*/
	
	class AddGoodListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
		}
	}
	
}


