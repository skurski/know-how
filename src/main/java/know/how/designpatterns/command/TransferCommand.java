package know.how.designpatterns.command;

public class TransferCommand implements Command {

	@Override
	public void execute() {
		System.out.println("Execute Transfer Command");
	}

	@Override
	public void printCommandInfo() {
		System.out.println("Transfer Command");	
	}

}
