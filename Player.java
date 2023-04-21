package ultittt;

import java.util.Scanner;
public class Player {
	
	private ComputerPlayer computer = new ComputerPlayer();
	private String name;
	private String mark;
	
	
	
	Scanner input = new Scanner(System.in);
	
	Player()
	{
		this.name = null;
		this.mark = "";
	}
	
	public void setVal(String name, String mark)
	{
		this.name = name;
		this.mark = mark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}
	
	public int makeMove(boolean human)
	{
		if(human)
		{
			return input.nextInt();
		}
		else
		{
			return computer.makeMove();
		}
	}
	
	public int chooseBoard(boolean human)
	{
		if(human)
		{
			return input.nextInt();
		}
		else
		{
			return computer.makeMove();
		}
	}
	
}
