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
	
	//�˵�
	private JList myboxList;
	private JList goodList;
	//��ť
	private JButton registerButton;
	private JButton addGoodButton;
	private JButton clothRecommendButton;
	private JButton travelRecommendButton;
	private JButton foodRemindButton;
	private JButton shoppingRecommendButton;
	private JButton okButton;
	//���
	private JPanel registerPanel;
	private JPanel userInformationPanel;
	private JPanel goodInformationPanel;
	private JPanel goodsPanel;
	//��ǩ
	private JLabel registerLabel;
	private JLabel userNameLabel;
	private JLabel myuserNameLabel;
	private JLabel userCodeLabel;
	private JLabel inputLabel;
	private JLabel ageLabel;
	private JLabel sexLabel;
	private JLabel heightLabel;
	private JLabel weightLabel;
	//�ı��������
	private JTextField userNameTextField;
	private JTextField nowuserNameTextField;
	private JTextField userCodeTextField;
	private JTextField inputTextField;
	private JTextField ageTextField;
	private JTextField sexTextField;
	private JTextField heightTextField;
	private JTextField weightTextField;
	//�ı���
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
		
		registerButton = new JButton("��¼");
		addGoodButton = new JButton("�����Ʒ");
		clothRecommendButton = new JButton("���մ����Ƽ�");
		travelRecommendButton = new JButton("���ճ����Ƽ�");
		foodRemindButton = new JButton("ʳƷ��������");
		shoppingRecommendButton = new JButton("���ｨ��");
		okButton = new JButton("ȷ��");
		
		registerLabel = new JLabel("��¼");
		userNameLabel = new JLabel("�û�����");
		myuserNameLabel = new JLabel("�û�����");
		userCodeLabel = new JLabel("���룺");
		inputLabel = new JLabel("�����");
		ageLabel = new JLabel("����");
		sexLabel = new JLabel("�Ա�");
		heightLabel = new JLabel("���");
		weightLabel = new JLabel("����");
		
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
		
		//��¼����
		registerPanel = new JPanel(new GridLayout(4,1));
		registerPanel.setBorder(
				BorderFactory.createTitledBorder("��¼"));
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
		
		//�û�����
		userInformationPanel = new JPanel(new GridLayout(5,1));
		userInformationPanel.setBorder(
				BorderFactory.createTitledBorder("�ҵ���Ϣ"));
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
		
		//�û�����
		JPanel userPanel = new JPanel(new GridLayout(2,1));
		userPanel.add(registerPanel);
		userPanel.add(userInformationPanel);
		
		
		//��Ʒ��Ϣ
		goodsPanel = new JPanel(new BorderLayout());
		goodsPanel.setBorder(BorderFactory.createTitledBorder("��Ʒչʾ"));
		goodsPanel.add (
			new JScrollPane(goodList,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER),BorderLayout.CENTER);
		goodsPanel.add(addGoodButton,BorderLayout.SOUTH);
		
		//�����б�
		JPanel boxListPanel = new JPanel();
		boxListPanel.setBorder(BorderFactory.createTitledBorder("�ҵ�����"));
		boxListPanel.add (
			new JScrollPane(myboxList,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
		
		//�ҵ�����
		JPanel myBoxListPanel = new JPanel(new BorderLayout());
		myBoxListPanel.add(boxListPanel,BorderLayout.WEST);
		myBoxListPanel.add(goodsPanel,BorderLayout.EAST);
		
		//��Ʒ������Ϣ
		goodInformationPanel = new JPanel();
		goodInformationPanel.setBorder(
				BorderFactory.createTitledBorder("��Ʒ����"));
		
		//�Ƽ���
		JPanel recommendPanel = new JPanel(new GridLayout(4,1));
		recommendPanel.add(clothRecommendButton);
		recommendPanel.add(travelRecommendButton);
		recommendPanel.add(foodRemindButton);
		recommendPanel.add(shoppingRecommendButton);
		
		
		//������Ϣ
		JPanel statusPanel = new JPanel(new BorderLayout());
		JPanel inputPanel = new JPanel(new GridLayout(1,2));
		inputPanel.add(inputLabel);
		inputPanel.add(inputTextField);
		statusPanel.add(inputPanel,BorderLayout.NORTH);
		statusPanel.add(statusTextArea,BorderLayout.CENTER);
		
		//����Ŀ�
		JPanel bottomPanel = new JPanel(new BorderLayout());
		bottomPanel.add(recommendPanel);
		bottomPanel.add(statusPanel);
		
		//���Ų���
		setLayout(new BorderLayout());
		add(userPanel, BorderLayout.WEST);
		add(myBoxListPanel, BorderLayout.CENTER);
		add(goodInformationPanel, BorderLayout.EAST);
		add(bottomPanel, BorderLayout.SOUTH);
		
		//�����¼�
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
				statusTextArea.setText(name + " �е���Ʒ�Ѿ���ʾ");
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


