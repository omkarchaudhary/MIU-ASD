package command;

public interface Command {
    void execute();
    void unExecute(Command command);
}
