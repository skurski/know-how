package know.how.designpatterns.command;

public class GetAccountCommand implements Command {

	@Override
	public void execute() {
		System.out.println("Execute Get Account Command");
	}

	@Override
	public void printCommandInfo() {
		System.out.println("Get Account Command");
	}

}
