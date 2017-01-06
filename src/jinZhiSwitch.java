import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
/**
 * 十进制-->对应负数  分别转化为十六进制，八、二进制
 * @author ljheee
 *
 */

public class jinZhiSwitch extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField input;
	private JLabel negitive,Hex,Hex2,Octal,Octal2,Binary,Binary2;
	
	public jinZhiSwitch(){
		super("进制转换");
		this.setBackground(Color.LIGHT_GRAY);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new GridLayout(4,3));
		input=new JTextField(12);  //用户输入十进制区
		negitive=new JLabel();//显示input的负数   
		
		 Hex=new JLabel();//to十六进制
		 Hex2=new JLabel();//to为负数的   十六进制
		
		 Octal=new JLabel();//to八进制
		 Octal2=new JLabel();//to为负数的   八进制
		
		 Binary=new JLabel();//to二进制
		 Binary2=new JLabel();//to负数的   二进制
		this.add(new JLabel("十进制:"));
		this.add(input);
		this.add(negitive);
		this.add(new JLabel("十六进制:"));
		this.add(Hex);
		this.add(Hex2);
		this.add(new JLabel("八进制:"));
		this.add(Octal);
		this.add(Octal2);
		this.add(new JLabel("二进制:"));
		this.add(Binary);
		this.add(Binary2);
	
		input.addCaretListener(new Switch());//注册文本事件监听器
		
       this.pack();
       this.setVisible(true);
       
	}
	
	class Switch implements CaretListener{          //内部类，文本编辑监听器
		public void caretUpdate(CaretEvent e) {
			int ss = 0;
			if(input.getText().equals(""))  JOptionPane.showMessageDialog(input, "输入为空，请输入");
			try {
				ss = Integer.parseInt(input.getText());
			}catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(input, "格式异常不能转化");
			}finally{}
	
			negitive.setText("-"+ss);  //显示负数
			int fushu=Integer.parseInt(negitive.getText());
			Hex.setText(Integer.toHexString(ss));  //将输入的数转化为十六进制字符串，并显示
			Hex2.setText(Integer.toHexString(fushu));
			
			Octal.setText(Integer.toOctalString(ss));//将输入的数转化为8进制字符串，并显示
			Octal2.setText(Integer.toOctalString(fushu));
			
			Binary.setText(Integer.toOctalString(ss));//将输入的数转化为2进制字符串，并显示
			Binary2.setText(Integer.toOctalString(fushu));
		}
		
	}
	
	public static void main(String[] args) { //main
		new jinZhiSwitch();
	}

}
