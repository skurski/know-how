package know.how.designpatterns.command;

public class BankCommander {
	public static Bank currentBank = new Bank();
	public static Client currentClient;
	
	static Command[] commands = {
	        new FindClientCommand(),
	        new GetAccountCommand(),
	        new WithdrawCommand(),
//	        new DepositCommand(), 
//	        new TransferCommand(),
//	        new AddClientCommand(),
	        new Command() { // Exit Command
	            public void execute() {
	            	printCommandInfo();
	                System.exit(0);
	            }

	            public void printCommandInfo() {
	                System.out.println("Exit");
	            }
	        }
	    };

	    
	public static void main(String args[]) {
        while (true) {
           for (int i=0;i<commands.length;i++) { // show menu
                 System.out.print(i+") ");
                 commands[i].printCommandInfo();
           }

           int command = (int)(commands.length * Math.random()); // initialize command randomly
//           String commandString = System.console().readLine();
//           int command = Integer.parseInt(commandString);        

           commands[command].execute();
        }
   }
}
