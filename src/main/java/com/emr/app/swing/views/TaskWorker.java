package com.emr.app.swing.views;

import java.util.List;

import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class TaskWorker extends SwingWorker<Integer, Integer> {

	private JProgressBar progressBar;
	private Runnable runnable;

	private TaskWorker(JProgressBar progressBar, Runnable runnable) {
		this.progressBar = progressBar;
		this.runnable = runnable;
	}

	@Override
	public Integer doInBackground() throws Exception {
		this.publish(50);
		this.runnable.run();
		this.publish(100);
		return 100;
	}

	@Override
	protected void process(List<Integer> chunks) {
		int progress = chunks.get(chunks.size() - 1);
		progressBar.setValue(chunks.get(chunks.size() - 1));
		if (progress == 100) {
			progressBar.setValue(0);
		}
	}

	public static void invoke(JProgressBar progressBar, Runnable runnable) {
		TaskWorker worker = new TaskWorker(progressBar, runnable);
		worker.execute();
	}

}
