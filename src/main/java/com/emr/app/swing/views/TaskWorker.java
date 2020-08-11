package com.emr.app.swing.views;

import java.util.List;

import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class TaskWorker extends SwingWorker<Integer, Integer> {

	private JProgressBar progressBar;
	private Executable executable;
	private Callback callback;

	private TaskWorker(JProgressBar progressBar, Executable executable, Callback callback) {
		this.progressBar = progressBar;
		this.executable = executable;
		this.callback = callback;
	}

	@Override
	protected Integer doInBackground() throws Exception {
		this.publish(50);
		try {
			Object response = this.executable.execute();
			if (callback != null) {
				callback.onSucess(response);
			}
		} catch (Exception e) {
			if (callback != null) {
				callback.onFailure();
			} else {
				throw e;
			}
		}
		this.publish(100);
		return 100;
	}

	@Override
	protected void process(List<Integer> chunks) {
		progressBar.setValue(chunks.get(chunks.size() - 1));
	}

	@Override
	protected void done() {
		progressBar.setValue(0);
	}

	public static void invoke(JProgressBar progressBar, Executable executable, Callback callback) {
		TaskWorker worker = new TaskWorker(progressBar, executable, callback);
		worker.execute();
	}

}

@FunctionalInterface
interface Executable {
	public Object execute() throws Exception;
}

interface Callback {

	public void onSucess(Object response);

	public void onFailure();
}
