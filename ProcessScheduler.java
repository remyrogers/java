/*
 * Remy Rogers
 */
public class ProcessScheduler {
	private LLQueue<Process> processes;
	private Process currProcess;
	public ProcessScheduler()
	{
		processes = new LLQueue<>();
		currProcess = null;
	}
	public Process getCurrentProcess()
	{
		return currProcess;
	}
	public void addProcess(Process aProcess)
	{
		if (currProcess == null)
		{
			currProcess = aProcess;
		}
		else
		{
			processes.enqueue(aProcess);
		}
	}
	public void runNextProcess()
	{
		if (processes.peek() != null)
		{
			currProcess = processes.dequeue();
		}
	}
	public void cancelCurrentProcess()
	{
		if(currProcess != null)
		{
			currProcess = processes.dequeue();
		}
	}
	public void printProcessQueue()
	{
		processes.print();
	}
}
